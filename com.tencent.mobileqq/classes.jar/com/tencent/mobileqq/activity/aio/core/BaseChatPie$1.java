package com.tencent.mobileqq.activity.aio.core;

import com.tencent.qphone.base.util.QLog;

class BaseChatPie$1
  implements Runnable
{
  BaseChatPie$1(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      str = this.this$0.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mRunOnShow 800 hasDestory=");
      localStringBuilder.append(this.this$0.B);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((!this.this$0.r) && (!this.this$0.B))
    {
      this.this$0.g(3);
      return;
    }
    String str = this.this$0.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShowFirst return|3 hasDestory:");
    localStringBuilder.append(this.this$0.B);
    QLog.i(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.1
 * JD-Core Version:    0.7.0.1
 */