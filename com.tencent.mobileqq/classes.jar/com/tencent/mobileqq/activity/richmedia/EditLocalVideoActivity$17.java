package com.tencent.mobileqq.activity.richmedia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;

class EditLocalVideoActivity$17
  implements View.OnTouchListener
{
  EditLocalVideoActivity$17(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (EditLocalVideoActivity.q(this.a).isPlaying())
      {
        if (EditLocalVideoActivity.t(this.a))
        {
          EditLocalVideoActivity.d(this.a, false);
          EditLocalVideoActivity.q(this.a).pause();
          EditLocalVideoActivity.r(this.a).setVisibility(0);
          return true;
        }
      }
      else if (EditLocalVideoActivity.t(this.a))
      {
        EditLocalVideoActivity.q(this.a).start();
        EditLocalVideoActivity.d(this.a, true);
        EditLocalVideoActivity.r(this.a).setVisibility(4);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.17
 * JD-Core Version:    0.7.0.1
 */