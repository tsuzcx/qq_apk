package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.qphone.base.util.QLog;

class ListenPanel$2
  implements Runnable
{
  ListenPanel$2(ListenPanel paramListenPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel playAnimRunable:,isEnabled= ");
      localStringBuilder.append(this.this$0.isEnabled());
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (this.this$0.isEnabled()) {
      ListenPanel.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel.2
 * JD-Core Version:    0.7.0.1
 */