package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.qphone.base.util.QLog;

class MultiForwardChatPie$4
  implements Runnable
{
  MultiForwardChatPie$4(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      str = this.this$0.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mRunOnShow 800 hasDestory=");
      localStringBuilder.append(this.this$0.aY);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((!this.this$0.aD) && (!this.this$0.aY))
    {
      MultiForwardChatPie.j(this.this$0);
      return;
    }
    String str = this.this$0.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShowFirst return|3 hasDestory:");
    localStringBuilder.append(this.this$0.aY);
    QLog.i(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.4
 * JD-Core Version:    0.7.0.1
 */