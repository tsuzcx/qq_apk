package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.push.m;
import com.huawei.hms.push.x;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class PushMsgReceiver
  extends BroadcastReceiver
{
  private static void a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.hasExtra("selfshow_info"))
    {
      if (!x.a(paramContext)) {
        HMSLog.i("PushMsgReceiver", paramContext.getPackageName() + " disable display notification.");
      }
      m.a(paramContext, paramIntent);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      return;
    }
    HMSLog.i("PushMsgReceiver", "push receive broadcast message, Intent:" + paramIntent.getAction() + " pkgName:" + paramContext.getPackageName());
    try
    {
      paramIntent.getStringExtra("TestIntent");
      String str = paramIntent.getAction();
      if (ResourceLoaderUtil.getmContext() == null) {
        ResourceLoaderUtil.setmContext(paramContext.getApplicationContext());
      }
      if (("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(str)) || (("com.huawei.intent.action.PUSH".equals(str)) && (HwBuildEx.VERSION.EMUI_SDK_INT < 10)))
      {
        a(paramContext, paramIntent);
        return;
      }
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushMsgReceiver", "intent has some error");
      return;
    }
    HMSLog.i("PushMsgReceiver", "message can't be recognised:" + paramIntent.toUri(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushMsgReceiver
 * JD-Core Version:    0.7.0.1
 */