package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import mqq.app.AppRuntime;

public abstract class PreloadManagerAbs
{
  public AppRuntime a;
  
  public PreloadManagerAbs(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (paramString.equalsIgnoreCase("WiFi")) {
        return 1;
      }
      if (paramString.equalsIgnoreCase("4G")) {
        return 4;
      }
      if (paramString.equalsIgnoreCase("3G")) {
        return 3;
      }
    } while (!paramString.equalsIgnoreCase("2G"));
    return 2;
  }
  
  public static String a()
  {
    String str = c();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return b();
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    return b(paramAppRuntime) + paramString;
  }
  
  public static String a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      String str = c();
      paramAppRuntime = b();
      if (paramBoolean) {}
      while (!TextUtils.isEmpty(paramAppRuntime))
      {
        return new File(paramAppRuntime, paramString).getAbsolutePath();
        if (!TextUtils.isEmpty(str)) {
          paramAppRuntime = str;
        }
      }
    }
    return null;
  }
  
  public static String b()
  {
    return d() + ".preloaduni" + "/";
  }
  
  public static String b(AppRuntime paramAppRuntime)
  {
    return d() + paramAppRuntime.getAccount() + "/" + ".preloaduni" + "/";
  }
  
  public static String c()
  {
    String str = e();
    if (!TextUtils.isEmpty(str)) {
      return str + ".preloaduni" + "/";
    }
    return null;
  }
  
  protected static String d()
  {
    return BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/QWallet/";
  }
  
  protected static String e()
  {
    String str = null;
    if (FileUtils.a()) {
      str = Environment.getExternalStorageDirectory().getPath() + "/tencent/QWallet/";
    }
    return str;
  }
  
  public abstract void a(String paramString1, String paramString2, long paramLong, PreloadManager.OnGetPathListener paramOnGetPathListener, boolean paramBoolean);
  
  public void a(String paramString1, String paramString2, PreloadManager.OnGetPathListener paramOnGetPathListener, boolean paramBoolean)
  {
    a(paramString1, paramString2, 9223372036854775807L, paramOnGetPathListener, paramBoolean);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = NetworkUtil.a(this.a.getApplication());
    int k = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label57;
      }
      if (a(paramString[i]) == j) {
        break;
      }
      i += 1;
    }
    label57:
    return false;
  }
  
  public String b(String paramString)
  {
    return null;
  }
  
  public String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = d(paramString);
      if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
      {
        ResUtil.a(paramString, NetConnInfoCenter.getServerTimeMillis());
        return str;
      }
    }
    return null;
  }
  
  public void c(String paramString, PreloadManager.OnGetPathListener paramOnGetPathListener)
  {
    a(paramString, "", 0L, paramOnGetPathListener, false);
  }
  
  public String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = MD5.toMD5(paramString);
    return a() + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerAbs
 * JD-Core Version:    0.7.0.1
 */