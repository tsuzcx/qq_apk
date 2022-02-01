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
import anta;
import antb;
import bhfn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
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
  private Handler a = new anta(this);
  
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
    if (("com.tencent.tim".equals(str1)) && (bhfn.b(this, "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0"))) {
      a("com.tencent.tim", str2, str3, i, paramInt);
    }
    for (bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataMigrationService", 2, new Object[] { str1, " verify success: ", Boolean.valueOf(bool) });
      }
      if (bool) {
        break;
      }
      stopSelf(paramInt);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt1, Intent paramIntent, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataMigrationService", 2, "sendAction");
    }
    Object localObject1 = MsfSdkUtils.getLoginedAccountList();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataMigrationService", 2, "no login account available");
      }
      stopSelf(paramInt2);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((SimpleAccount)((Iterator)localObject1).next()).getUin();
      localObject3 = getDatabasePath((String)localObject2 + ".db");
      if (QLog.isDevelopLevel()) {
        QLog.d("DataMigrationService", 4, new Object[] { "db path=", ((File)localObject3).getPath(), ", exist=", Boolean.valueOf(((File)localObject3).exists()) });
      }
      if (((File)localObject3).exists())
      {
        localArrayList1.add(localObject2);
        localArrayList2.add(localObject3);
      }
    }
    if (localArrayList1.isEmpty())
    {
      stopSelf(paramInt2);
      return;
    }
    localObject1 = getApplication().getSharedPreferences("data_migration_tim", 0);
    boolean bool1 = ((SharedPreferences)localObject1).getBoolean("data_migration_tim_uninstall_flag", false);
    Object localObject2 = ((SharedPreferences)localObject1).getString("data_migration_tim_title", "");
    Object localObject3 = ((SharedPreferences)localObject1).getString("data_migration_tim_content", "");
    boolean bool2 = ((SharedPreferences)localObject1).getBoolean("data_migration_tim_uninstall_notify", false);
    Object localObject4 = ((SharedPreferences)localObject1).getString("data_migration_tim_uninstall_title", "");
    Object localObject5 = ((SharedPreferences)localObject1).getString("data_migration_tim_uninstall_content", "");
    int i = localArrayList1.size();
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("com.tencent.mobileqq.extra_TASK_ID", paramInt1);
    ((Intent)localObject1).putExtra("com.tencent.mobileqq.UNINSTALL_FLAG", bool1);
    ((Intent)localObject1).putExtra("com.tencent.mobileqq.MIGRATION_TITLE", (String)localObject2);
    ((Intent)localObject1).putExtra("com.tencent.mobileqq.MIGRATION_CONTENT", (String)localObject3);
    ((Intent)localObject1).putExtra("com.tencent.mobileqq.UNINSTALL_FLAG", bool2);
    ((Intent)localObject1).putExtra("com.tencent.mobileqq.UNINSTALL_TITLE", (String)localObject4);
    ((Intent)localObject1).putExtra("com.tencent.mobileqq.UNINSTALL_CONTENT", (String)localObject5);
    ((Intent)localObject1).putExtra("com.tencent.mobileqq.FILE_NUMBER", i);
    if (paramIntent != null) {
      ((Intent)localObject1).putExtras(paramIntent);
    }
    localObject2 = new StringBuilder();
    paramIntent = localArrayList1.iterator();
    while (paramIntent.hasNext()) {
      ((StringBuilder)localObject2).append((String)paramIntent.next());
    }
    paramIntent = new String(SecurityUtile.getKey());
    localObject3 = MD5.toMD5(MD5.toMD5(((StringBuilder)localObject2).toString()) + "datamigration" + paramInt1);
    localObject2 = ((String)localObject3).substring(0, 16);
    localObject3 = ((String)localObject3).substring(((String)localObject3).length() - 16, ((String)localObject3).length());
    for (;;)
    {
      try
      {
        localObject3 = new IvParameterSpec(((String)localObject3).getBytes());
        localObject2 = new SecretKeySpec(((String)localObject2).getBytes(), "AES");
        localObject4 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher)localObject4).init(1, (Key)localObject2, (AlgorithmParameterSpec)localObject3);
        ((Intent)localObject1).putExtra("com.tencent.mobileqq.CODE_KEY", Base64.encodeToString(((Cipher)localObject4).doFinal(paramIntent.getBytes()), 2));
        paramIntent = new ArrayList();
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          localObject2 = (String)localArrayList1.get(paramInt1);
          localObject3 = (File)localArrayList2.get(paramInt1);
          localObject4 = ((File)localObject3).getParent();
          localObject5 = new File((String)localObject4, ((File)localObject3).getName() + "-journal");
          Object localObject6 = new File((String)localObject4, "slowtable_" + (String)localObject2 + ".db");
          localObject4 = FileProvider.getUriForFile(this, "com.tencent.mobileqq.fileprovider", (File)localObject3);
          localObject5 = FileProvider.getUriForFile(this, "com.tencent.mobileqq.fileprovider", (File)localObject5);
          localObject6 = FileProvider.getUriForFile(this, "com.tencent.mobileqq.fileprovider", (File)localObject6);
          grantUriPermission(paramString1, (Uri)localObject4, 1);
          grantUriPermission(paramString1, (Uri)localObject5, 1);
          grantUriPermission(paramString1, (Uri)localObject6, 1);
          if (QLog.isDevelopLevel()) {
            QLog.d("DataMigrationService", 4, new Object[] { "db uri: ", localObject4, ", journal: ", localObject5 });
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("com.tencent.mobileqq.UIN", (String)localObject2);
          localBundle.putInt("com.tencent.mobileqq.CURRENT_NUMBER", paramInt1);
          localBundle.putLong("com.tencent.mobileqq.FILE_LENGTH", ((File)localObject3).length());
          localBundle.putParcelable("com.tencent.mobileqq.URI", (Parcelable)localObject4);
          localBundle.putParcelable("com.tencent.mobileqq.JOURNAL_URI", (Parcelable)localObject5);
          localBundle.putParcelable("com.tencent.mobileqq.SLOW_URI", (Parcelable)localObject6);
          paramIntent.add(localBundle);
          paramInt1 += 1;
          continue;
        }
        ((Intent)localObject1).putParcelableArrayListExtra("com.tencent.mobileqq.DATA_BOX", paramIntent);
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        ((Intent)localObject1).setComponent(new ComponentName(paramString1, paramString2));
        ((Intent)localObject1).addFlags(268435456);
        startActivity((Intent)localObject1);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.e("DataMigrationService", 2, "Encrypt or start activity fail: " + paramString1.getMessage());
        continue;
      }
      stopSelf(paramInt2);
      return;
      ((Intent)localObject1).setComponent(new ComponentName(paramString1, paramString3));
      startService((Intent)localObject1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (TextUtils.isEmpty(localAppRuntime.getAccount())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| app null or no account");
      }
      a(paramString1, paramString2, paramString3, paramInt1, null, paramInt2);
    }
    int i;
    do
    {
      return;
      WtloginHelper localWtloginHelper = new WtloginHelper(this);
      localWtloginHelper.SetTimeOut(20);
      localWtloginHelper.SetMsfTransportFlag(1);
      localWtloginHelper.SetListener(new antb(this, paramString1, paramString2, paramString3, paramInt1, paramInt2, localWtloginHelper));
      byte[] arrayOfByte = util.getPkgSigFromApkName(this, "com.tencent.tim");
      i = localWtloginHelper.GetA1WithA1(localAppRuntime.getAccount(), 16L, 16L, "com.tencent.tim".getBytes(), 1L, 16L, 16L, "8.4.10".getBytes(), arrayOfByte, new WUserSigInfo(), new WFastLoginInfo());
      if (QLog.isColorLevel()) {
        QLog.d("DataMigrationService", 2, new Object[] { "sendActionAfterGetTicket| retCode=", Integer.valueOf(i), ", account=", localAppRuntime.getAccount() });
      }
    } while (i == -1001);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataMigrationService
 * JD-Core Version:    0.7.0.1
 */