package com.tencent.mobileqq.app;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;

class FrameHelperActivity$9$2
  implements Runnable
{
  FrameHelperActivity$9$2(FrameHelperActivity.9 param9, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    if (this.a == null)
    {
      this.c.a.ac.setVisibility(8);
    }
    else
    {
      if (this.c.a.w() == FrameControllerUtil.a) {
        this.c.a.ac.setVisibility(8);
      } else {
        this.c.a.ac.setVisibility(0);
      }
      this.c.a.ac.setImageDrawable(this.a);
    }
    this.c.a.ac.setContentDescription(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.9.2
 * JD-Core Version:    0.7.0.1
 */