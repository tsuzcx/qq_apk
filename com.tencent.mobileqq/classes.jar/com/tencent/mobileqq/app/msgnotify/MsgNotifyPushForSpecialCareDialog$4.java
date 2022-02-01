package com.tencent.mobileqq.app.msgnotify;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class MsgNotifyPushForSpecialCareDialog$4
  implements View.OnTouchListener
{
  MsgNotifyPushForSpecialCareDialog$4(MsgNotifyPushForSpecialCareDialog paramMsgNotifyPushForSpecialCareDialog, ImageView paramImageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 0))
    {
      int i;
      if (paramMotionEvent.getAction() == 1) {
        i = 255;
      } else {
        i = 127;
      }
      if (Build.VERSION.SDK_INT >= 16) {
        this.a.setImageAlpha(i);
      } else {
        this.a.setAlpha(i);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog.4
 * JD-Core Version:    0.7.0.1
 */