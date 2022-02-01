package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.push.i;
import com.huawei.hms.push.t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class PushMsgReceiver
  extends BroadcastReceiver
{
  public static void a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.hasExtra("selfshow_info"))
    {
      if (!t.a(paramContext))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getPackageName());
        localStringBuilder.append(" disable display notification.");
        HMSLog.i("PushMsgReceiver", localStringBuilder.toString());
      }
      i.a(paramContext, paramIntent);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null)
    {
      if (paramContext == null) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("push receive broadcast message, Intent:");
      ((StringBuilder)localObject).append(paramIntent.getAction());
      ((StringBuilder)localObject).append(" pkgName:");
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      HMSLog.i("PushMsgReceiver", ((StringBuilder)localObject).toString());
    }
    try
    {
      paramIntent.getStringExtra("TestIntent");
      localObject = paramIntent.getAction();
      if (ResourceLoaderUtil.getmContext() == null) {
        ResourceLoaderUtil.setmContext(paramContext.getApplicationContext());
      }
      if ((!"com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(localObject)) && ((!"com.huawei.intent.action.PUSH".equals(localObject)) || (HwBuildEx.VERSION.EMUI_SDK_INT >= 10)))
      {
        paramContext = new StringBuilder();
        paramContext.append("message can't be recognised:");
        paramContext.append(paramIntent.toUri(0));
        HMSLog.i("PushMsgReceiver", paramContext.toString());
        return;
      }
      a(paramContext, paramIntent);
      return;
    }
    catch (Exception paramContext)
    {
      label153:
      break label153;
    }
    HMSLog.e("PushMsgReceiver", "intent has some error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushMsgReceiver
 * JD-Core Version:    0.7.0.1
 */