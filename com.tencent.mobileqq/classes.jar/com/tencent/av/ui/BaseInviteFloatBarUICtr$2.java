package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import mbw;

public class BaseInviteFloatBarUICtr$2
  implements Runnable
{
  public BaseInviteFloatBarUICtr$2(mbw parammbw) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "timeout~ mPeerUin:" + this.this$0.c);
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.BaseInviteFloatBarUICtr.2
 * JD-Core Version:    0.7.0.1
 */