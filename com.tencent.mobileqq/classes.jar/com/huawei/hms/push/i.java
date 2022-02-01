package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;

public class i
{
  public static void a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null)) {}
    try
    {
      Object localObject = paramIntent.getAction();
      boolean bool = "com.huawei.intent.action.PUSH".equals(localObject);
      if (!bool)
      {
        bool = "com.huawei.push.msg.NOTIFY_MSG".equals(localObject);
        if (!bool)
        {
          bool = "com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(localObject);
          if (!bool) {
            break label129;
          }
        }
      }
      localObject = paramIntent.getByteArrayExtra("selfshow_info");
      byte[] arrayOfByte = paramIntent.getByteArrayExtra("selfshow_token");
      if ((localObject != null) && (arrayOfByte != null) && (localObject.length != 0) && (arrayOfByte.length != 0))
      {
        a(paramContext, paramIntent, (byte[])localObject, arrayOfByte);
        return;
      }
      HMSLog.i("PushSelfShowLog", "self show info or token is null.");
      return;
    }
    catch (RuntimeException paramContext)
    {
      HMSLog.e("PushSelfShowLog", "onReceive RuntimeException.", paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      break label112;
    }
    HMSLog.d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
    return;
    label112:
    HMSLog.d("PushSelfShowLog", "onReceive Exception.");
  }
  
  public static void a(Context paramContext, Intent paramIntent, k paramk)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive a selfshow message, the cmd type is ");
    localStringBuilder.append(paramk.i());
    HMSLog.i("PushSelfShowLog", localStringBuilder.toString());
    if (!j.b(paramk.i())) {
      return;
    }
    long l = q.a(paramk.c());
    if (l == 0L)
    {
      new p(paramContext, paramk).start();
      return;
    }
    HMSLog.d("PushSelfShowLog", "waiting...");
    paramIntent.setPackage(paramContext.getPackageName());
    q.a(paramContext, paramIntent, l);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, k paramk, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive a selfshow user handle message eventId = ");
    localStringBuilder.append(paramString);
    HMSLog.d("PushSelfShowLog", localStringBuilder.toString());
    if (!"-1".equals(paramString)) {
      q.a(paramContext, paramIntent);
    } else {
      q.a(paramContext, paramInt);
    }
    if ("1".equals(paramString))
    {
      new j(paramContext, paramk).c();
      PluginUtil.onNotificationClicked(paramContext, paramk.p(), paramk.b());
      return;
    }
    if ("2".equals(paramString))
    {
      e.a(paramContext, paramk.p(), paramk.b(), "2");
      return;
    }
    HMSLog.d("PushSelfShowLog", "other event");
  }
  
  public static void a(Context paramContext, Intent paramIntent, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    String str = paramIntent.getStringExtra("selfshow_event_id");
    int i = paramIntent.getIntExtra("selfshow_notify_id", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get notifyId:");
    localStringBuilder.append(i);
    HMSLog.i("PushSelfShowLog", localStringBuilder.toString());
    paramArrayOfByte1 = new k(paramArrayOfByte1, paramArrayOfByte2);
    if (!paramArrayOfByte1.z())
    {
      HMSLog.d("PushSelfShowLog", "parseMessage failed");
      return;
    }
    paramArrayOfByte2 = new StringBuilder();
    paramArrayOfByte2.append("onReceive the msg id = ");
    paramArrayOfByte2.append(paramArrayOfByte1.p());
    paramArrayOfByte2.append(",and cmd is ");
    paramArrayOfByte2.append(paramArrayOfByte1.i());
    paramArrayOfByte2.append(",and the eventId is ");
    paramArrayOfByte2.append(str);
    HMSLog.i("PushSelfShowLog", paramArrayOfByte2.toString());
    if (str == null)
    {
      a(paramContext, paramIntent, paramArrayOfByte1);
      return;
    }
    a(paramContext, paramIntent, str, paramArrayOfByte1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.i
 * JD-Core Version:    0.7.0.1
 */