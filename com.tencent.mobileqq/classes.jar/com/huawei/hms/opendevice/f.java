package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class f
  implements Runnable
{
  public Context a;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void run()
  {
    try
    {
      i = ErrorEnum.SUCCESS.getInternalCode();
      localObject1 = null;
      try
      {
        String str = HmsInstanceId.getInstance(this.a).getToken(Util.getAppId(this.a), null);
        localObject1 = str;
        HMSLog.i("AutoInit", "Push init succeed");
        localObject1 = str;
        bool = TextUtils.isEmpty(str);
        localObject1 = str;
        if (bool) {
          return;
        }
      }
      catch (ApiException localApiException)
      {
        i = localApiException.getStatusCode();
        HMSLog.e("AutoInit", "Push init failed");
      }
    }
    catch (Exception localException)
    {
      int i;
      Object localObject1;
      boolean bool;
      Object localObject2;
      label215:
      HMSLog.e("AutoInit", "Push init failed", localException);
    }
    try
    {
      localObject2 = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
      if (((ApplicationInfo)localObject2).metaData != null)
      {
        localObject2 = ((ApplicationInfo)localObject2).metaData;
        if (((Bundle)localObject2).getString("com.huawei.hms.client.service.name:push") != null)
        {
          localObject2 = new Intent("com.huawei.push.action.MESSAGING_EVENT");
          ((Intent)localObject2).setPackage(this.a.getPackageName());
          Bundle localBundle = new Bundle();
          localBundle.putString("message_type", "new_token");
          localBundle.putString("device_token", localObject1);
          localBundle.putInt("error", i);
          bool = new h().a(this.a, localBundle, (Intent)localObject2);
          if (bool) {
            break label232;
          }
          HMSLog.e("AutoInit", "start service failed");
          return;
        }
      }
      HMSLog.i("AutoInit", "push kit sdk not exists");
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label215;
    }
    HMSLog.i("AutoInit", "push kit sdk not exists");
    return;
    label232:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.opendevice.f
 * JD-Core Version:    0.7.0.1
 */