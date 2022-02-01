package com.tencent.mobileqq.activity.pendant;

import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;

class AvatarPendantActivity$AnimationScrollListener$1
  implements Runnable
{
  AvatarPendantActivity$AnimationScrollListener$1(AvatarPendantActivity.AnimationScrollListener paramAnimationScrollListener) {}
  
  public void run()
  {
    if (this.a.b.u == 0)
    {
      URLDrawable.resume();
      this.a.b.a.a = false;
      this.a.b.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.AnimationScrollListener.1
 * JD-Core Version:    0.7.0.1
 */