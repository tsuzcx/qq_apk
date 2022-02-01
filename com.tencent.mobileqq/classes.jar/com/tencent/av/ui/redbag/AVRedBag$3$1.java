package com.tencent.av.ui.redbag;

import com.tencent.qphone.base.util.QLog;
import mpt;
import mpw;
import mqb;

public class AVRedBag$3$1
  implements Runnable
{
  public AVRedBag$3$1(mpw parammpw) {}
  
  public void run()
  {
    mqb localmqb = this.a.a.a();
    if (localmqb == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.a.i, 1, "onAVActivityResume, AVRedBagMgr为空");
      }
    }
    do
    {
      return;
      if (localmqb.a()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("AVRedBag", 1, "onAVActivityResume, 不是GameMode");
    return;
    localmqb.c("onAVActivityResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag.3.1
 * JD-Core Version:    0.7.0.1
 */