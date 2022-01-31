package com.tencent.av.ui.redbag;

import com.tencent.qphone.base.util.QLog;
import mrl;
import mro;
import mrt;

public class AVRedBag$3$1
  implements Runnable
{
  public AVRedBag$3$1(mro parammro) {}
  
  public void run()
  {
    mrt localmrt = this.a.a.a();
    if (localmrt == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.a.i, 1, "onAVActivityResume, AVRedBagMgr为空");
      }
    }
    do
    {
      return;
      if (localmrt.a()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("AVRedBag", 1, "onAVActivityResume, 不是GameMode");
    return;
    localmrt.c("onAVActivityResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag.3.1
 * JD-Core Version:    0.7.0.1
 */