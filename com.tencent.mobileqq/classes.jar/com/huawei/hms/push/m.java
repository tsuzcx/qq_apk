package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

public class m
{
  public static void a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    try
    {
      HMSLog.d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
      return;
    }
    catch (RuntimeException paramContext)
    {
      Object localObject;
      byte[] arrayOfByte;
      HMSLog.e("PushSelfShowLog", "onReceive RuntimeException.", paramContext);
      return;
      String str = paramIntent.getStringExtra("selfshow_event_id");
      int i = paramIntent.getIntExtra("selfshow_notify_id", 0);
      HMSLog.i("PushSelfShowLog", "get notifyId:" + i);
      a(paramContext, paramIntent, (byte[])localObject, arrayOfByte, str, i);
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.d("PushSelfShowLog", "onReceive Exception.");
    }
    localObject = paramIntent.getAction();
    if (("com.huawei.intent.action.PUSH".equals(localObject)) || ("com.huawei.push.msg.NOTIFY_MSG".equals(localObject)) || ("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(localObject)))
    {
      localObject = paramIntent.getByteArrayExtra("selfshow_info");
      arrayOfByte = paramIntent.getByteArrayExtra("selfshow_token");
      if ((localObject.length == 0) || (arrayOfByte.length == 0))
      {
        HMSLog.i("PushSelfShowLog", "self show info or token is null.");
        return;
      }
    }
  }
  
  private static void a(Context paramContext, Intent paramIntent, o paramo)
  {
    HMSLog.i("PushSelfShowLog", "receive a selfshow message ,the type is" + paramo.j());
    if (!n.a(paramo.j())) {
      return;
    }
    long l = u.a(paramo.h());
    if (l == 0L)
    {
      new t(paramContext, paramo).start();
      return;
    }
    HMSLog.d("PushSelfShowLog", "waiting ……");
    paramIntent.setPackage(paramContext.getPackageName());
    u.a(paramContext, paramIntent, l);
  }
  
  private static void a(Context paramContext, Intent paramIntent, String paramString, o paramo, int paramInt)
  {
    HMSLog.d("PushSelfShowLog", "receive a selfshow userhandle message");
    if (!"-1".equals(paramString)) {
      u.b(paramContext, paramIntent);
    }
    while ("1".equals(paramString))
    {
      new n(paramContext, paramo).a();
      k.a(paramContext, "1", String.valueOf(paramInt), paramo);
      return;
      u.a(paramContext, paramInt);
    }
    if ("2".equals(paramString))
    {
      k.a(paramContext, "2", String.valueOf(paramInt), paramo);
      return;
    }
    HMSLog.d("PushSelfShowLog", "other event");
  }
  
  private static void a(Context paramContext, Intent paramIntent, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, int paramInt)
  {
    paramArrayOfByte1 = new o(paramArrayOfByte1, paramArrayOfByte2);
    if (!paramArrayOfByte1.b())
    {
      HMSLog.d("PushSelfShowLog", "parseMessage failed");
      return;
    }
    HMSLog.i("PushSelfShowLog", " onReceive the msg id = " + paramArrayOfByte1.a() + ",and cmd is" + paramArrayOfByte1.j() + ",and the eventId is " + paramString);
    if (paramString == null)
    {
      a(paramContext, paramIntent, paramArrayOfByte1);
      return;
    }
    a(paramContext, paramIntent, paramString, paramArrayOfByte1, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.m
 * JD-Core Version:    0.7.0.1
 */