package com.tencent.ilinkservice;

import android.os.Message;
import java.util.TimerTask;

class IlinkService$1
  extends TimerTask
{
  IlinkService$1(IlinkService paramIlinkService) {}
  
  public void run()
  {
    Message localMessage = IlinkService.access$700(this.a).obtainMessage();
    localMessage.what = 1;
    localMessage.arg1 = IlinkService.access$808(this.a);
    IlinkService.access$700(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IlinkService.1
 * JD-Core Version:    0.7.0.1
 */