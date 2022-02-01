package com.tencent.av.ui.redbag;

import com.tencent.qphone.base.util.QLog;
import mow;
import moz;
import mpe;

public class AVRedBag$3$1
  implements Runnable
{
  public AVRedBag$3$1(moz parammoz) {}
  
  public void run()
  {
    mpe localmpe = this.a.a.a();
    if (localmpe == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.a.i, 1, "onAVActivityResume, AVRedBagMgr为空");
      }
    }
    do
    {
      return;
      if (localmpe.a()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("AVRedBag", 1, "onAVActivityResume, 不是GameMode");
    return;
    localmpe.c("onAVActivityResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag.3.1
 * JD-Core Version:    0.7.0.1
 */