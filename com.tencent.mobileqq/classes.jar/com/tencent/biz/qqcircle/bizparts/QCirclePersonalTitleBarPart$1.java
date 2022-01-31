package com.tencent.biz.qqcircle.bizparts;

import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;
import tss;

public class QCirclePersonalTitleBarPart$1
  implements Runnable
{
  public QCirclePersonalTitleBarPart$1(tss paramtss, PopupWindow paramPopupWindow) {}
  
  public void run()
  {
    try
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCirclePersonalTitleBar", 2, "tryShowingInviteGuideBubble error! ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.1
 * JD-Core Version:    0.7.0.1
 */