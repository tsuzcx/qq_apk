package com.tencent.mobileqq.activity.aio;

import android.view.View;
import com.tencent.image.URLDrawable;

final class AIOUtils$4
  implements Runnable
{
  AIOUtils$4(URLDrawable paramURLDrawable, View paramView) {}
  
  public void run()
  {
    if ((this.val$d.getStatus() == 0) || (this.val$d.getStatus() == 4)) {
      this.val$v.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOUtils.4
 * JD-Core Version:    0.7.0.1
 */