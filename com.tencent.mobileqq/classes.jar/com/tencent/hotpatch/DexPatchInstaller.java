package com.tencent.hotpatch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.qfix.Relax;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class DexPatchInstaller
{
  public static int a = 0;
  public static String b = "";
  
  private static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return paramInt + 10000;
            }
            return 801;
          }
          return 805;
        }
        return 803;
      }
      return 807;
    }
    return 800;
  }
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private static int a(Context paramContext, PatchConfig paramPatchConfig)
  {
    try
    {
      File localFile1 = new File(PatchCommonUtil.getPatchPath(paramPatchConfig.e()));
      File localFile2 = paramContext.getDir("dex", 0);
      String str = PatchCommonUtil.getPatchDirPath(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPatchConfig.d());
      localStringBuilder.append("");
      int i = Relax.apply(paramContext, localFile1, localFile2, new File(str, localStringBuilder.toString()), false);
      paramContext = new StringBuilder();
      paramContext.append("apply result: ");
      paramContext.append(i);
      QLog.d("PatchLogTag", 1, paramContext.toString());
      i = a(i);
      return i;
    }
    catch (Throwable paramContext)
    {
      QLog.d("PatchLogTag", 1, paramContext, new Object[0]);
    }
    return 802;
  }
  
  private static String a()
  {
    String str = "";
    Object localObject = str;
    try
    {
      if (Build.VERSION.SDK_INT <= 28) {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = str;
          if (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {}
        }
        else
        {
          if (Build.VERSION.SDK_INT < 23) {
            return "";
          }
          localObject = (TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone");
          if (Build.VERSION.SDK_INT < 26) {
            return PhoneInfoMonitor.getDeviceId((TelephonyManager)localObject);
          }
          localObject = PhoneInfoMonitor.getImei((TelephonyManager)localObject);
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    PatchConfig localPatchConfig = PatchConfigManager.b(paramContext, "dex");
    if ((a == 0) && (b(paramContext, localPatchConfig)))
    {
      String str = a();
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("66666")))
      {
        QLog.w("PatchLogTag", 1, "running on a game assist vbox, skip patching");
        return;
      }
      int i;
      if ((localPatchConfig.b()) && (!SoLoadUtil.a()))
      {
        i = a(paramContext, localPatchConfig);
        if (i == 807)
        {
          QLog.d("PatchLogTag", 1, "inject failed");
          a = 0;
          b = "";
        }
        else if (i != 800)
        {
          a = 0;
          b = "";
        }
        else
        {
          a = 500;
        }
      }
      else
      {
        i = 0;
      }
      c(paramContext, localPatchConfig);
      PatchReporter.reportPatchEvent(paramContext, "", "actPatchInstall", a, localPatchConfig.e(), i);
      paramContext = new StringBuilder();
      paramContext.append("DexPatchInstaller installDexPatch total cost time=");
      paramContext.append(System.currentTimeMillis() - l);
      paramContext.append(" ms.");
      QLog.d("PatchLogTag", 1, paramContext.toString());
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("DexPatchInstaller installDexPatch Not inject patch, status=");
    paramContext.append(a);
    QLog.d("PatchLogTag", 1, paramContext.toString());
  }
  
  private static boolean b(Context paramContext, PatchConfig paramPatchConfig)
  {
    if (paramPatchConfig == null)
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch config is null");
      return false;
    }
    if (!paramPatchConfig.a(paramContext, BaseApplicationImpl.processName)) {
      return false;
    }
    String str = paramPatchConfig.e();
    File localFile = new File(PatchCommonUtil.getPatchPath(str));
    if (!localFile.exists())
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch file not exist");
      return false;
    }
    if (localFile.length() != paramPatchConfig.g())
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch file length not match");
      return false;
    }
    if (!PatchSharedPreUtil.getPatchVerifyStatus(paramContext, str))
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus verify failed");
      return false;
    }
    if (PatchSharedPreUtil.getCountFailInstallPatch(paramContext, BaseApplicationImpl.processName, str) >= 3)
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus install patch failed max count");
      return false;
    }
    if (PatchSharedPreUtil.getCountFailStartupPatch(paramContext, BaseApplicationImpl.processName, str) > 5)
    {
      a = 503;
      PatchReporter.reportPatchEvent(paramContext, "", "actPatchInstall", 503, str);
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus start failed max count as install patch");
      return false;
    }
    QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus return true");
    return true;
  }
  
  private static void c(Context paramContext, PatchConfig paramPatchConfig)
  {
    paramContext = new DexPatchInstaller.1(paramPatchConfig, paramContext);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramContext, 5, null, true);
      return;
    }
    paramContext.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hotpatch.DexPatchInstaller
 * JD-Core Version:    0.7.0.1
 */