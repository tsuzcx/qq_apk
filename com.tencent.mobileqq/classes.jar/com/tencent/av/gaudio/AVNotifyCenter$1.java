package com.tencent.av.gaudio;

import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.mobileqq.app.QQAppInterface;

class AVNotifyCenter$1
  implements Runnable
{
  AVNotifyCenter$1(AVNotifyCenter paramAVNotifyCenter) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      AVNotifyCenter.a(this.this$0, new PhoneStatusMonitor(this.this$0.a.getApp(), null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.1
 * JD-Core Version:    0.7.0.1
 */