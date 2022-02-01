package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;

public class a
  extends c
{
  public BaseMode a(Context paramContext, int paramInt, Intent paramIntent)
  {
    if (4105 == paramInt) {
      return a(paramIntent);
    }
    return null;
  }
  
  protected BaseMode a(Intent paramIntent)
  {
    try
    {
      localObject = new com.heytap.mcssdk.c.a();
      ((com.heytap.mcssdk.c.a)localObject).a(Integer.parseInt(com.heytap.mcssdk.f.a.b(paramIntent.getStringExtra("command"))));
      ((com.heytap.mcssdk.c.a)localObject).b(Integer.parseInt(com.heytap.mcssdk.f.a.b(paramIntent.getStringExtra("code"))));
      ((com.heytap.mcssdk.c.a)localObject).c(com.heytap.mcssdk.f.a.b(paramIntent.getStringExtra("content")));
      ((com.heytap.mcssdk.c.a)localObject).a(com.heytap.mcssdk.f.a.b(paramIntent.getStringExtra("appKey")));
      ((com.heytap.mcssdk.c.a)localObject).b(com.heytap.mcssdk.f.a.b(paramIntent.getStringExtra("appSecret")));
      ((com.heytap.mcssdk.c.a)localObject).d(com.heytap.mcssdk.f.a.b(paramIntent.getStringExtra("appPackage")));
      paramIntent = new StringBuilder();
      paramIntent.append("OnHandleIntent-message:");
      paramIntent.append(((com.heytap.mcssdk.c.a)localObject).toString());
      com.heytap.mcssdk.f.c.a(paramIntent.toString());
      return localObject;
    }
    catch (Exception paramIntent)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnHandleIntent--");
      ((StringBuilder)localObject).append(paramIntent.getMessage());
      com.heytap.mcssdk.f.c.a(((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.d.a
 * JD-Core Version:    0.7.0.1
 */