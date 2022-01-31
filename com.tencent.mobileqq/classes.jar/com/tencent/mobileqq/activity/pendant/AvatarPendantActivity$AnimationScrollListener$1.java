package com.tencent.mobileqq.activity.pendant;

import agii;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;

public class AvatarPendantActivity$AnimationScrollListener$1
  implements Runnable
{
  public AvatarPendantActivity$AnimationScrollListener$1(agii paramagii) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.AnimationScrollListener.1
 * JD-Core Version:    0.7.0.1
 */