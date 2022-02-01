package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class g
  implements Runnable
{
  private Context a;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void run()
  {
    try
    {
      String str = HmsInstanceId.getInstance(this.a).getToken(Util.getAppId(this.a), "HCM");
      if (!TextUtils.isEmpty(str))
      {
        HMSLog.i("AutoInit", "Push init succeed");
        try
        {
          Object localObject = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
          if ((((ApplicationInfo)localObject).metaData != null) && (((ApplicationInfo)localObject).metaData.getString("com.huawei.hms.client.service.name:push") != null))
          {
            localObject = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            ((Intent)localObject).setPackage(this.a.getPackageName());
            Bundle localBundle = new Bundle();
            localBundle.putString("message_type", "new_token");
            localBundle.putString("device_token", str);
            if (!new h().a(this.a, localBundle, (Intent)localObject)) {
              HMSLog.e("AutoInit", "start service failed");
            }
          }
          else
          {
            HMSLog.i("AutoInit", "push kit sdk not exists");
            return;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          HMSLog.i("AutoInit", "push kit sdk not exists");
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      HMSLog.e("AutoInit", "Push init failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.g
 * JD-Core Version:    0.7.0.1
 */