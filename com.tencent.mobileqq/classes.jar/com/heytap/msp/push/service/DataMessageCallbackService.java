package com.heytap.msp.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.mcssdk.c;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.DataMessage;

public class DataMessageCallbackService
  extends Service
  implements IDataMessageCallBackService
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    c.a(getApplicationContext(), paramIntent, this);
    return 2;
  }
  
  public void processMessage(Context paramContext, DataMessage paramDataMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.msp.push.service.DataMessageCallbackService
 * JD-Core Version:    0.7.0.1
 */