package com.tencent.av.ui.redbag;

import com.tencent.qphone.base.util.QLog;

class AVRedBag$3$1
  implements Runnable
{
  AVRedBag$3$1(AVRedBag.3 param3) {}
  
  public void run()
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a.a();
    if (localAVRedBagMgr == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.a.i, 1, "onAVActivityResume, AVRedBagMgr为空");
      }
    }
    do
    {
      return;
      if (localAVRedBagMgr.a()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("AVRedBag", 1, "onAVActivityResume, 不是GameMode");
    return;
    localAVRedBagMgr.c("onAVActivityResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag.3.1
 * JD-Core Version:    0.7.0.1
 */