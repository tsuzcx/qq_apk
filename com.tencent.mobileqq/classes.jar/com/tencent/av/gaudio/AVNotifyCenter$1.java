package com.tencent.av.gaudio;

import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.mobileqq.app.QQAppInterface;

class AVNotifyCenter$1
  implements Runnable
{
  AVNotifyCenter$1(AVNotifyCenter paramAVNotifyCenter) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      AVNotifyCenter localAVNotifyCenter = this.this$0;
      AVNotifyCenter.a(localAVNotifyCenter, new PhoneStatusMonitor(localAVNotifyCenter.a.getApp(), new AVNotifyCenter.1.1(this)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.1
 * JD-Core Version:    0.7.0.1
 */