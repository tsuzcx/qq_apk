package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.f.f;
import com.heytap.msp.push.callback.IDataMessageCallBackService;

public class c
{
  public static void a(Context paramContext, Intent paramIntent, IDataMessageCallBackService paramIDataMessageCallBackService)
  {
    if (paramContext == null)
    {
      com.heytap.mcssdk.f.c.b("context is null , please check param of parseIntent()");
      return;
    }
    if (paramIntent == null)
    {
      com.heytap.mcssdk.f.c.b("intent is null , please check param of parseIntent()");
      return;
    }
    if (paramIDataMessageCallBackService == null)
    {
      com.heytap.mcssdk.f.c.b("callback is null , please check param of parseIntent()");
      return;
    }
    f.a(new c.1(paramContext, paramIntent, paramIDataMessageCallBackService));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.c
 * JD-Core Version:    0.7.0.1
 */