package com.tencent.av.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QavMuteButtonForeGroundDrawable;

class QavPanel$3
  implements View.OnTouchListener
{
  QavPanel$3(QavPanel paramQavPanel) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.J.isEnabled())
    {
      if (this.a.U == null) {
        return false;
      }
      int i = this.a.getCurrentSpeakerMode();
      paramView = this.a.U.b().k();
      int j = paramMotionEvent.getAction();
      if (j != 0)
      {
        if ((j != 1) && (j != 3)) {
          return false;
        }
        QavPanel.c(this.a).setAlpha(255);
        QavPanel.e(this.a).removeMessages(256);
        QavPanel.e(this.a).removeMessages(261);
        if (i == 3)
        {
          QavPanel.a(this.a, true);
          if (QavPanel.a(this.a))
          {
            paramView.a("MotionEventACTION_UP", true);
            paramView.c("MotionEventACTION_UP", 1);
            this.a.a("MotionEventUP", 3, 1, true);
          }
          else
          {
            this.a.U.b().a("MotionEventACTION_UP", QavPanel.b(this.a).d(), false, true, 1);
            this.a.a("MotionEventACTION_UP", 3, 1, false);
            QavPanel.b(this.a).a(false, true);
          }
        }
        QavPanel.b(this.a).c();
        return false;
      }
      if ((i == 0) || (i == 1) || (i == 2))
      {
        if (i == 2) {
          if (QavPanel.a(this.a))
          {
            paramView.a("MotionEventDown", true);
            paramView.c("MotionEventDown", 1);
            this.a.a("MotionEventDown", 2, 1, true);
          }
          else
          {
            if (this.a.U.b().H()) {
              this.a.U.b().c("MotionEventDown", 1);
            } else {
              this.a.U.b().a("MotionEventDown", QavPanel.b(this.a).d(), false, true, 1);
            }
            this.a.a("MotionEventDown", 2, 1, false);
            QavPanel.b(this.a).a(false, false);
          }
        }
        QavPanel.c(this.a).setAlpha(127);
      }
      if (QavPanel.d(this.a))
      {
        QavPanel.a(this.a, false);
        QavPanel.e(this.a).removeMessages(256);
        QavPanel.e(this.a).sendEmptyMessageDelayed(256, 200L);
        QavPanel.e(this.a).removeMessages(261);
      }
      if (QavPanel.b(this.a) != null) {
        QavPanel.b(this.a).c();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.3
 * JD-Core Version:    0.7.0.1
 */