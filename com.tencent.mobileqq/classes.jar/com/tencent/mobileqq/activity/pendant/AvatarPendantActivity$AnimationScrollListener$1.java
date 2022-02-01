package com.tencent.mobileqq.activity.pendant;

import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;

class AvatarPendantActivity$AnimationScrollListener$1
  implements Runnable
{
  AvatarPendantActivity$AnimationScrollListener$1(AvatarPendantActivity.AnimationScrollListener paramAnimationScrollListener) {}
  
  public void run()
  {
    if (this.a.b.W == 0)
    {
      URLDrawable.resume();
      this.a.b.B.B = false;
      this.a.b.B.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.AnimationScrollListener.1
 * JD-Core Version:    0.7.0.1
 */