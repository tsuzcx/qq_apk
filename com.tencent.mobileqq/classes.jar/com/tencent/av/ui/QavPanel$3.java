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
    if ((!this.a.h.isEnabled()) || (this.a.a == null)) {}
    int i;
    do
    {
      return false;
      i = this.a.a();
      paramView = this.a.a.a().a();
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return false;
      case 0: 
        if ((i == 0) || (i == 1) || (i == 2))
        {
          if (i == 2)
          {
            if (!QavPanel.a(this.a)) {
              break label235;
            }
            paramView.a("MotionEventDown", true);
            paramView.b("MotionEventDown", 1);
            this.a.a("MotionEventDown", 2, 1, true);
          }
          QavPanel.a(this.a).setAlpha(127);
        }
        if (QavPanel.b(this.a))
        {
          QavPanel.a(this.a, false);
          QavPanel.a(this.a).removeMessages(256);
          QavPanel.a(this.a).sendEmptyMessageDelayed(256, 200L);
          QavPanel.a(this.a).removeMessages(261);
        }
        break;
      }
    } while (QavPanel.a(this.a) == null);
    QavPanel.a(this.a).a();
    return false;
    label235:
    if (this.a.a.a().h()) {
      this.a.a.a().c("MotionEventDown", 1);
    }
    for (;;)
    {
      this.a.a("MotionEventDown", 2, 1, false);
      QavPanel.a(this.a).a(false, false);
      break;
      this.a.a.a().a("MotionEventDown", QavPanel.a(this.a).a(), false, true, 1);
    }
    QavPanel.a(this.a).setAlpha(255);
    QavPanel.a(this.a).removeMessages(256);
    QavPanel.a(this.a).removeMessages(261);
    if (i == 3)
    {
      QavPanel.a(this.a, true);
      if (QavPanel.a(this.a))
      {
        paramView.a("MotionEventACTION_UP", true);
        paramView.b("MotionEventACTION_UP", 1);
        this.a.a("MotionEventUP", 3, 1, true);
      }
    }
    for (;;)
    {
      QavPanel.a(this.a).a();
      return false;
      this.a.a.a().a("MotionEventACTION_UP", QavPanel.a(this.a).a(), false, true, 1);
      this.a.a("MotionEventACTION_UP", 3, 1, false);
      QavPanel.a(this.a).a(false, true);
      continue;
      if (i != 1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.3
 * JD-Core Version:    0.7.0.1
 */