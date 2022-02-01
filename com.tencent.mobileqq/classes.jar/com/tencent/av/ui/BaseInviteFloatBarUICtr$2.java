package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class BaseInviteFloatBarUICtr$2
  implements Runnable
{
  BaseInviteFloatBarUICtr$2(BaseInviteFloatBarUICtr paramBaseInviteFloatBarUICtr) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      String str = this.this$0.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeout~ mPeerUin:");
      localStringBuilder.append(this.this$0.c);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.BaseInviteFloatBarUICtr.2
 * JD-Core Version:    0.7.0.1
 */