package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.qphone.base.util.QLog;

class ListenPanel$2
  implements Runnable
{
  ListenPanel$2(ListenPanel paramListenPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel playAnimRunable:,isEnabled= " + this.this$0.isEnabled());
    }
    if (this.this$0.isEnabled()) {
      ListenPanel.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel.2
 * JD-Core Version:    0.7.0.1
 */