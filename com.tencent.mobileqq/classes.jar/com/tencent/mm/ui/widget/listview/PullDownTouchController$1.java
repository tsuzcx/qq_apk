package com.tencent.mm.ui.widget.listview;

import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import com.tencent.mm.ui.f;

class PullDownTouchController$1
  extends Handler
{
  PullDownTouchController$1(PullDownTouchController paramPullDownTouchController) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (paramMessage.what != 0) {
        return;
      }
      f.b(PullDownTouchController.a(), "MSG_STORY_LONG_PRESS_CHECK", new Object[0]);
      if (PullDownTouchController.a(this.a) != null) {
        PullDownTouchController.a(this.a).onLongClick();
      }
      this.a.setLongPressed(true);
      PullDownTouchController.b(this.a).vibrate(10L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownTouchController.1
 * JD-Core Version:    0.7.0.1
 */