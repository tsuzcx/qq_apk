package com.tencent.av.ui.redbag;

import com.tencent.qphone.base.util.QLog;
import mdv;
import mdy;
import med;

public class AVRedBag$3$1
  implements Runnable
{
  public AVRedBag$3$1(mdy parammdy) {}
  
  public void run()
  {
    med localmed = this.a.a.a();
    if (localmed == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.a.i, 1, "onAVActivityResume, AVRedBagMgr为空");
      }
    }
    do
    {
      return;
      if (localmed.a()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("AVRedBag", 1, "onAVActivityResume, 不是GameMode");
    return;
    localmed.c("onAVActivityResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag.3.1
 * JD-Core Version:    0.7.0.1
 */