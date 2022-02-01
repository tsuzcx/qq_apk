package com.tencent.biz.qqcircle.immersive.personal.part;

import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;

class QFSPersonalTitleBarPart$4
  implements Runnable
{
  QFSPersonalTitleBarPart$4(QFSPersonalTitleBarPart paramQFSPersonalTitleBarPart, PopupWindow paramPopupWindow) {}
  
  public void run()
  {
    try
    {
      if (this.a.isShowing())
      {
        this.a.dismiss();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QFSPersonalTitleBarPart", 2, "tryShowingInviteGuideBubble error! ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.4
 * JD-Core Version:    0.7.0.1
 */