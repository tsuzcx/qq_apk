package com.huawei.hms.support.api.push.service;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.push.c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper.PackageStates;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

public class HmsMsgService$a
  extends Handler
{
  public Context a;
  
  public HmsMsgService$a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Bundle localBundle = paramMessage.getData();
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((Objects.equals(this.a.getApplicationContext().getPackageManager().getNameForUid(paramMessage.sendingUid), HMSPackageManager.getInstance(this.a).getHMSPackageName())) && (localBundle != null)) {
        if (HMSPackageManager.getInstance(this.a).getHMSPackageStates() != PackageManagerHelper.PackageStates.ENABLED)
        {
          HMSLog.i("HmsMsgService", "service not start by hms");
        }
        else
        {
          HMSLog.i("HmsMsgService", "chose push type");
          if (Objects.equals(c.b(localBundle, "push_action"), "com.huawei.push.msg.NOTIFY_MSG"))
          {
            if (ResourceLoaderUtil.getmContext() == null) {
              ResourceLoaderUtil.setmContext(this.a.getApplicationContext());
            }
            HMSLog.i("HmsMsgService", "invokeSelfShow");
            HmsMsgService.a(this.a, localBundle);
          }
          else if (Objects.equals(c.b(localBundle, "push_action"), "com.huawei.push.msg.PASSBY_MSG"))
          {
            HMSLog.i("HmsMsgService", "sendBroadcastToHms");
            HmsMsgService.b(this.a, localBundle);
          }
        }
      }
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.push.service.HmsMsgService.a
 * JD-Core Version:    0.7.0.1
 */