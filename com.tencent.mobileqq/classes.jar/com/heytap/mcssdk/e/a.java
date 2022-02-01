package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.mcssdk.d;
import com.heytap.mcssdk.f.f;
import com.heytap.mcssdk.f.g;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;

public class a
  implements c
{
  private void a(com.heytap.mcssdk.c.a parama, d paramd)
  {
    if (parama == null) {
      parama = "message is null , please check param of parseCommandMessage(2)";
    }
    for (;;)
    {
      com.heytap.mcssdk.f.c.b(parama);
      return;
      if (paramd == null)
      {
        parama = "pushService is null , please check param of parseCommandMessage(2)";
      }
      else
      {
        if (paramd.h() != null) {
          break;
        }
        parama = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
      }
    }
    int i = parama.a();
    if (i != 12289)
    {
      if (i != 12290)
      {
        if (i != 12298)
        {
          if (i != 12306)
          {
            if (i != 12309) {
              return;
            }
            paramd.h().onGetNotificationStatus(parama.c(), g.a(parama.b()));
            return;
          }
          paramd.h().onGetPushStatus(parama.c(), g.a(parama.b()));
          return;
        }
        paramd.h().onSetPushTime(parama.c(), parama.b());
        return;
      }
      paramd.h().onUnRegister(parama.c());
      return;
    }
    if (parama.c() == 0) {
      paramd.a(parama.b());
    }
    paramd.h().onRegister(parama.c(), parama.b());
  }
  
  public void a(Context paramContext, BaseMode paramBaseMode, IDataMessageCallBackService paramIDataMessageCallBackService)
  {
    if (paramBaseMode == null) {
      return;
    }
    if (paramBaseMode.getType() == 4105)
    {
      paramContext = (com.heytap.mcssdk.c.a)paramBaseMode;
      paramBaseMode = new StringBuilder();
      paramBaseMode.append("mcssdk-CallBackResultProcessor:");
      paramBaseMode.append(paramContext.toString());
      com.heytap.mcssdk.f.c.a(paramBaseMode.toString());
      f.b(new a.1(this, paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.e.a
 * JD-Core Version:    0.7.0.1
 */