package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.DataMessage;

class b$1
  implements Runnable
{
  b$1(b paramb, IDataMessageCallBackService paramIDataMessageCallBackService, Context paramContext, DataMessage paramDataMessage) {}
  
  public void run()
  {
    this.a.processMessage(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.e.b.1
 * JD-Core Version:    0.7.0.1
 */