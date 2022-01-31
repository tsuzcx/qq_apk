package com.tencent.mezs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mdm.m;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mqpsdk.INetTransportProvider;
import com.tencent.mqpsdk.MQPSecServiceManager;
import com.tencent.mqpsdk.secsrv.MQPSigCheckService;
import com.tencent.mqpsdk.secsrv.MQPSigCheckService.ISigCheckResultListener;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import rif;

public class a
  implements MQPSigCheckService.ISigCheckResultListener
{
  private static boolean jdField_a_of_type_Boolean = true;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean b;
  private boolean c;
  
  public a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label254:
    do
    {
      long l1;
      long l2;
      int j;
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = null;
            localObject2 = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
            localObject3 = ((SharedPreferences)localObject2).edit();
            localObject4 = ((SharedPreferences)localObject2).getString("SecMd5Entry", null);
            i = ((SharedPreferences)localObject2).getInt("SecResEntry", -1);
            l1 = ((SharedPreferences)localObject2).getLong("SecStampEntry", -1L);
            l2 = System.currentTimeMillis();
            j = ((SharedPreferences)localObject2).getInt("SecCacheTime", 604800);
            if (this.c) {
              break label545;
            }
            if (jdField_a_of_type_Boolean) {
              break;
            }
          } while (l2 <= (0x12 ^ l1) + j * 1000);
          jdField_a_of_type_Boolean = true;
          localObject2 = m.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationInfo().sourceDir);
        } while ((localObject2 == null) || (((String)localObject2).length() == 0));
        jdField_a_of_type_Boolean = false;
      } while ((localObject4 != null) && (((String)localObject4).equalsIgnoreCase((String)localObject2)) && (l1 != -1L) && (l2 <= (0x12 ^ l1) + j * 1000) && (i != -1) && ((i ^ 0x12) == 1));
      localObject1 = localObject2;
      if (l2 > (0x12 ^ l1) + j * 1000)
      {
        ((SharedPreferences.Editor)localObject3).remove("SecResEntry");
        ((SharedPreferences.Editor)localObject3).remove("SecStampEntry");
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localObject2 = SecUtil.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationInfo().sourceDir);
    } while ((localObject2 == null) || (((String)localObject2).length() == 0));
    ((SharedPreferences.Editor)localObject3).putString("SecMd5Entry", (String)localObject2);
    ((SharedPreferences.Editor)localObject3).commit();
    String str1 = SecUtil.getSignatureHash(SecUtil.getSign(BaseApplication.getContext()));
    String str2 = SecUtil.getPackageVersion(BaseApplication.getContext());
    if (!SecUtil.check0DayRepack(BaseApplication.getContext())) {}
    for (int i = 0;; i = 1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SigChk", 2, (String)localObject2);
        }
        try
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("uin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
          ((JSONObject)localObject4).put("client_type", 0);
          ((JSONObject)localObject4).put("is_repack", i);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getPackageName();
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = "MobileQQ";
          }
          ((JSONObject)localObject4).put("package_name", localObject1);
          ((JSONObject)localObject4).put("package_version", str2);
          ((JSONObject)localObject4).put("package_md5", localObject2);
          ((JSONObject)localObject4).put("package_signature", str1);
          localObject1 = (MSFNetTransportProvider)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(63);
          localObject1 = new MQPSecServiceManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), (INetTransportProvider)localObject1);
          if (localObject1 == null) {
            break;
          }
          localObject1 = (MQPSigCheckService)((MQPSecServiceManager)localObject1).a("sig_check");
          if (localObject1 == null) {
            break;
          }
          ((MQPSigCheckService)localObject1).a(this);
          ((MQPSigCheckService)localObject1).a(((JSONObject)localObject4).toString());
          return;
        }
        catch (Exception localException)
        {
          label545:
          localException.printStackTrace();
        }
      }
      ((SharedPreferences.Editor)localObject3).remove("SecResEntry");
      ((SharedPreferences.Editor)localObject3).remove("SecStampEntry");
      break label254;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("SecResEntry", -1);
    if ((i == -1) || ((i ^ 0x12) != paramInt1))
    {
      localEditor.putInt("SecResEntry", paramInt1 ^ 0x12);
      localEditor.putLong("SecStampEntry", System.currentTimeMillis() ^ 0x12);
      localEditor.putInt("SecCacheTime", paramInt2);
      localEditor.commit();
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Object localObject5 = null;
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = paramJSONObject.getString("dialog_title");
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          String str1;
          Object localObject3;
          Object localObject2;
          try
          {
            str2 = paramJSONObject.getString("dialog_content");
          }
          catch (Exception localException2)
          {
            Object localObject1;
            Object localObject4;
            Bundle localBundle;
            str1 = null;
            String str2 = null;
            paramJSONObject = null;
            localObject3 = localObject2;
            localObject2 = localException2;
            continue;
          }
          try
          {
            str1 = paramJSONObject.getString("dialog_left_button");
          }
          catch (Exception localException3)
          {
            str1 = null;
            paramJSONObject = null;
            localObject3 = localObject2;
            localObject2 = localException3;
            continue;
          }
          try
          {
            localObject3 = paramJSONObject.getString("dialog_right_button");
          }
          catch (Exception localException4)
          {
            paramJSONObject = null;
            localObject3 = localObject2;
            localObject2 = localException4;
            continue;
          }
          try
          {
            paramJSONObject = paramJSONObject.getString("url");
            localObject5 = paramJSONObject;
            localObject4 = localObject1;
            paramJSONObject = (JSONObject)localObject3;
            localObject1 = localObject5;
            if ((TextUtils.isEmpty(localObject4)) || (TextUtils.isEmpty(str2))) {
              break;
            }
            localObject3 = BaseActivity.sTopActivity;
            localObject5 = new Intent((Context)localObject3, NotificationActivity.class);
            ((Intent)localObject5).putExtra("type", 9);
            localBundle = new Bundle();
            localBundle.putString("dlg_title", localObject4);
            localBundle.putString("dlg_content", str2);
            localBundle.putString("dlg_lbutton", str1);
            localBundle.putString("dlg_rbutton", paramJSONObject);
            localBundle.putString("dlg_url", (String)localObject1);
            ((Intent)localObject5).putExtras(localBundle);
            ((Intent)localObject5).setFlags(872415232);
            ((Context)localObject3).startActivity((Intent)localObject5);
            return;
          }
          catch (Exception localException5)
          {
            paramJSONObject = (JSONObject)localObject3;
            localObject3 = localObject2;
            localObject2 = localException5;
          }
        }
        localException1 = localException1;
        str1 = null;
        str2 = null;
        localObject3 = null;
        paramJSONObject = null;
      }
      localException1.printStackTrace();
      localObject2 = localObject5;
      localObject4 = localObject3;
    }
  }
  
  public void a(String paramString)
  {
    int j = -1;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      localJSONObject = new JSONObject(paramString);
      i = localJSONObject.getInt("sig_check_result");
      paramString = localObject2;
    }
    catch (Exception localException2)
    {
      JSONObject localJSONObject;
      int k;
      label101:
      i = -1;
      paramString = (String)localObject1;
      localObject1 = localException2;
    }
    try
    {
      localObject1 = localJSONObject.getJSONObject("dialog_config");
      paramString = (String)localObject1;
      k = localJSONObject.getInt("cache_time");
      j = k;
      paramString = (String)localObject1;
      switch (i)
      {
      default: 
        return;
      }
    }
    catch (Exception localException1)
    {
      label125:
      break label125;
    }
    if (i == 0) {}
    for (int i = 1;; i = 0)
    {
      a(i, j);
      return;
      ((Exception)localObject1).printStackTrace();
      break;
      a(paramString);
      break label101;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.c = paramBoolean;
    if (this.c) {
      new rif(this).start();
    }
    for (;;)
    {
      this.b = false;
      return;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mezs.a
 * JD-Core Version:    0.7.0.1
 */