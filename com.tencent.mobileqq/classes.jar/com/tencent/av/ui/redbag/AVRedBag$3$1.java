package com.tencent.av.ui.redbag;

import com.tencent.qphone.base.util.QLog;
import moq;
import mot;
import moy;

public class AVRedBag$3$1
  implements Runnable
{
  public AVRedBag$3$1(mot parammot) {}
  
  public void run()
  {
    moy localmoy = this.a.a.a();
    if (localmoy == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.a.i, 1, "onAVActivityResume, AVRedBagMgr为空");
      }
    }
    do
    {
      return;
      if (localmoy.a()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("AVRedBag", 1, "onAVActivityResume, 不是GameMode");
    return;
    localmoy.c("onAVActivityResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag.3.1
 * JD-Core Version:    0.7.0.1
 */