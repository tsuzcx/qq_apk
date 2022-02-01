package com.tencent.mobileqq.app;

import android.app.Application;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

public class DataMigrationService
  extends Service
{
  private Handler a = new DataMigrationService.1(this);
  
  private void a(Intent paramIntent, int paramInt)
  {
    String str1 = paramIntent.getStringExtra("com.tencent.mobileqq.extra.PACKAGE_NAME");
    String str2 = paramIntent.getStringExtra("com.tencent.mobileqq.extra.ACTIVITY_NAME");
    String str3 = paramIntent.getStringExtra("com.tencent.mobileqq.extra.SERVICE_NAME");
    int i = paramIntent.getIntExtra("com.tencent.mobileqq.extra_TASK_ID", 0);
    boolean bool = paramIntent.getBooleanExtra("com.tencent.mobileqq.extra.CHECK_WHITELIST", true);
    if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)))
    {
      QLog.e("DataMigrationService", 2, "handleActionMigrationData| no valid component...");
      stopSelf(paramInt);
      return;
    }
    if ((bool) && (TextUtils.isEmpty(getApplication().getSharedPreferences("data_migration_tim", 0).getString("data_migration_tim_uins", ""))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataMigrationService", 2, "handleActionMigrationData| not in whitelist");
      }
      stopSelf(paramInt);
      return;
    }
    if (("com.tencent.tim".equals(str1)) && (PackageUtil.b(this, "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0")))
    {
      a("com.tencent.tim", str2, str3, i, paramInt);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DataMigrationService", 2, new Object[] { str1, " verify success: ", Boolean.valueOf(bool) });
    }
    if (!bool) {
      stopSelf(paramInt);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt1, Intent paramIntent, int paramInt2)
  {
    String str2 = "com.tencent.mobileqq.fileprovider";
    if (QLog.isColorLevel()) {
      QLog.d("DataMigrationService", 2, "sendAction");
    }
    Object localObject1 = MsfSdkUtils.getLoginedAccountList();
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    String str1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    int i;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str1 = ((SimpleAccount)((Iterator)localObject1).next()).getUin();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(".db");
        localObject2 = getDatabasePath(((StringBuilder)localObject2).toString());
        if (QLog.isDevelopLevel()) {
          QLog.d("DataMigrationService", 4, new Object[] { "db path=", ((File)localObject2).getPath(), ", exist=", Boolean.valueOf(((File)localObject2).exists()) });
        }
        if (((File)localObject2).exists())
        {
          localArrayList1.add(str1);
          localArrayList2.add(localObject2);
        }
      }
      if (localArrayList1.isEmpty())
      {
        stopSelf(paramInt2);
        return;
      }
      localObject2 = getApplication().getSharedPreferences("data_migration_tim", 0);
      boolean bool1 = ((SharedPreferences)localObject2).getBoolean("data_migration_tim_uninstall_flag", false);
      localObject1 = ((SharedPreferences)localObject2).getString("data_migration_tim_title", "");
      localObject3 = ((SharedPreferences)localObject2).getString("data_migration_tim_content", "");
      boolean bool2 = ((SharedPreferences)localObject2).getBoolean("data_migration_tim_uninstall_notify", false);
      localObject4 = ((SharedPreferences)localObject2).getString("data_migration_tim_uninstall_title", "");
      str1 = "DataMigrationService";
      localObject5 = ((SharedPreferences)localObject2).getString("data_migration_tim_uninstall_content", "");
      i = localArrayList1.size();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("com.tencent.mobileqq.extra_TASK_ID", paramInt1);
      ((Intent)localObject2).putExtra("com.tencent.mobileqq.UNINSTALL_FLAG", bool1);
      ((Intent)localObject2).putExtra("com.tencent.mobileqq.MIGRATION_TITLE", (String)localObject1);
      ((Intent)localObject2).putExtra("com.tencent.mobileqq.MIGRATION_CONTENT", (String)localObject3);
      ((Intent)localObject2).putExtra("com.tencent.mobileqq.UNINSTALL_FLAG", bool2);
      ((Intent)localObject2).putExtra("com.tencent.mobileqq.UNINSTALL_TITLE", (String)localObject4);
      ((Intent)localObject2).putExtra("com.tencent.mobileqq.UNINSTALL_CONTENT", (String)localObject5);
      ((Intent)localObject2).putExtra("com.tencent.mobileqq.FILE_NUMBER", i);
      if (paramIntent != null) {
        ((Intent)localObject2).putExtras(paramIntent);
      }
      localObject1 = new StringBuilder();
      paramIntent = localArrayList1.iterator();
      while (paramIntent.hasNext()) {
        ((StringBuilder)localObject1).append((String)paramIntent.next());
      }
      paramIntent = new String(SecurityUtile.getKey());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(MD5.toMD5(((StringBuilder)localObject1).toString()));
      ((StringBuilder)localObject3).append("datamigration");
      ((StringBuilder)localObject3).append(paramInt1);
      localObject1 = MD5.toMD5(((StringBuilder)localObject3).toString());
      localObject3 = ((String)localObject1).substring(0, 16);
      localObject4 = ((String)localObject1).substring(((String)localObject1).length() - 16, ((String)localObject1).length());
      localObject1 = str1;
    }
    label1158:
    label1225:
    for (;;)
    {
      try
      {
        localObject4 = new IvParameterSpec(((String)localObject4).getBytes());
        localObject1 = str1;
        localObject3 = new SecretKeySpec(((String)localObject3).getBytes(), "AES");
        localObject1 = str1;
        localObject5 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localObject1 = str1;
        ((Cipher)localObject5).init(1, (Key)localObject3, (AlgorithmParameterSpec)localObject4);
        localObject1 = str1;
        ((Intent)localObject2).putExtra("com.tencent.mobileqq.CODE_KEY", Base64.encodeToString(((Cipher)localObject5).doFinal(paramIntent.getBytes()), 2));
        localObject1 = str1;
        localObject3 = new ArrayList();
        int j = 0;
        paramIntent = str1;
        paramInt1 = i;
        str1 = str2;
        i = j;
        Object localObject6;
        Object localObject7;
        if (i < paramInt1)
        {
          localObject1 = paramIntent;
          str2 = (String)localArrayList1.get(i);
          localObject1 = paramIntent;
          localObject4 = (File)localArrayList2.get(i);
          localObject1 = paramIntent;
          localObject5 = ((File)localObject4).getParent();
          localObject1 = paramIntent;
          localObject6 = new StringBuilder();
          localObject1 = paramIntent;
          ((StringBuilder)localObject6).append(((File)localObject4).getName());
          localObject1 = paramIntent;
          ((StringBuilder)localObject6).append("-journal");
          localObject1 = paramIntent;
          localObject6 = new File((String)localObject5, ((StringBuilder)localObject6).toString());
          localObject1 = paramIntent;
          localObject7 = new StringBuilder();
          localObject1 = paramIntent;
          ((StringBuilder)localObject7).append("slowtable_");
          localObject1 = paramIntent;
          ((StringBuilder)localObject7).append(str2);
          localObject1 = paramIntent;
          ((StringBuilder)localObject7).append(".db");
          localObject1 = paramIntent;
          localObject7 = new File((String)localObject5, ((StringBuilder)localObject7).toString());
          localObject1 = paramIntent;
          localObject5 = FileProvider.getUriForFile(this, str1, (File)localObject4);
          localObject1 = paramIntent;
          localObject6 = FileProvider.getUriForFile(this, str1, (File)localObject6);
          localObject1 = paramIntent;
          localObject7 = FileProvider.getUriForFile(this, str1, (File)localObject7);
          localObject1 = paramIntent;
          grantUriPermission(paramString1, (Uri)localObject5, 1);
          localObject1 = paramIntent;
          grantUriPermission(paramString1, (Uri)localObject6, 1);
          localObject1 = paramIntent;
          grantUriPermission(paramString1, (Uri)localObject7, 1);
          localObject1 = paramIntent;
          if (!QLog.isDevelopLevel()) {
            break label1225;
          }
        }
        try
        {
          QLog.d(paramIntent, 4, new Object[] { "db uri: ", localObject5, ", journal: ", localObject6 });
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("com.tencent.mobileqq.UIN", str2);
          ((Bundle)localObject1).putInt("com.tencent.mobileqq.CURRENT_NUMBER", i);
          ((Bundle)localObject1).putLong("com.tencent.mobileqq.FILE_LENGTH", ((File)localObject4).length());
          ((Bundle)localObject1).putParcelable("com.tencent.mobileqq.URI", (Parcelable)localObject5);
          ((Bundle)localObject1).putParcelable("com.tencent.mobileqq.JOURNAL_URI", (Parcelable)localObject6);
          ((Bundle)localObject1).putParcelable("com.tencent.mobileqq.SLOW_URI", (Parcelable)localObject7);
          ((ArrayList)localObject3).add(localObject1);
          i += 1;
        }
        catch (Exception paramString1)
        {
          paramString2 = paramIntent;
          paramString1 = paramString1;
          break label1158;
        }
        ((Intent)localObject2).putParcelableArrayListExtra("com.tencent.mobileqq.DATA_BOX", (ArrayList)localObject3);
        if (!TextUtils.isEmpty(paramString2))
        {
          ((Intent)localObject2).setComponent(new ComponentName(paramString1, paramString2));
          ((Intent)localObject2).addFlags(268435456);
          startActivity((Intent)localObject2);
        }
        else
        {
          ((Intent)localObject2).setComponent(new ComponentName(paramString1, paramString3));
          startService((Intent)localObject2);
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = (String)localObject1;
      }
      paramString1.printStackTrace();
      paramString3 = new StringBuilder();
      paramString3.append("Encrypt or start activity fail: ");
      paramString3.append(paramString1.getMessage());
      QLog.e(paramString2, 2, paramString3.toString());
      stopSelf(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DataMigrationService", 2, "no login account available");
      }
      stopSelf(paramInt2);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && (!TextUtils.isEmpty(localAppRuntime.getAccount())))
    {
      WtloginHelper localWtloginHelper = new WtloginHelper(this);
      localWtloginHelper.SetTimeOut(20);
      localWtloginHelper.SetMsfTransportFlag(1);
      localWtloginHelper.SetListener(new DataMigrationService.2(this, paramString1, paramString2, paramString3, paramInt1, paramInt2, localWtloginHelper));
      byte[] arrayOfByte = util.getPkgSigFromApkName(this, "com.tencent.tim");
      int i = localWtloginHelper.GetA1WithA1(localAppRuntime.getAccount(), 16L, 16L, "com.tencent.tim".getBytes(), 1L, 16L, 16L, "8.7.0".getBytes(), arrayOfByte, new WUserSigInfo(), new WFastLoginInfo());
      if (QLog.isColorLevel()) {
        QLog.d("DataMigrationService", 2, new Object[] { "sendActionAfterGetTicket| retCode=", Integer.valueOf(i), ", account=", localAppRuntime.getAccount() });
      }
      if (i != -1001) {
        a(paramString1, paramString2, paramString3, paramInt1, null, paramInt2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| app null or no account");
    }
    a(paramString1, paramString2, paramString3, paramInt1, null, paramInt2);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Message localMessage = this.a.obtainMessage();
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramIntent;
    this.a.sendMessage(localMessage);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataMigrationService
 * JD-Core Version:    0.7.0.1
 */