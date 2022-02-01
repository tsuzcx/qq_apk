package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.abtest.QavUIABTestUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

class AVActivity$1$1
  implements Runnable
{
  AVActivity$1$1(AVActivity.1 param1) {}
  
  public void run()
  {
    VideoAppInterface localVideoAppInterface = this.a.a.H;
    if (localVideoAppInterface == null) {
      return;
    }
    if ((this.a.a.I != null) && (this.a.a.I.k() != null)) {
      this.a.a.I.k().a(localVideoAppInterface.h(this.a.a.j));
    }
    QavUIABTestUtils.a(localVideoAppInterface.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.1.1
 * JD-Core Version:    0.7.0.1
 */