package com.tencent.biz.subscribe.animation;

import android.graphics.drawable.AnimationDrawable;
import mqq.util.WeakReference;
import zry;

class PopViewAnimationDrawableHelper$LoopingRunnable
  implements Runnable
{
  private WeakReference<PopViewAnimationDrawableHelper> a;
  
  public PopViewAnimationDrawableHelper$LoopingRunnable(PopViewAnimationDrawableHelper paramPopViewAnimationDrawableHelper)
  {
    this.a = new WeakReference(paramPopViewAnimationDrawableHelper);
  }
  
  public void run()
  {
    Object localObject = (PopViewAnimationDrawableHelper)this.a.get();
    zry localzry;
    if (localObject != null)
    {
      localzry = PopViewAnimationDrawableHelper.a((PopViewAnimationDrawableHelper)localObject);
      if (localzry != null)
      {
        if (PopViewAnimationDrawableHelper.a((PopViewAnimationDrawableHelper)localObject) <= 0) {
          break label38;
        }
        localzry.a();
      }
    }
    return;
    label38:
    localObject = PopViewAnimationDrawableHelper.a((PopViewAnimationDrawableHelper)localObject);
    if ((localObject != null) && (((AnimationDrawable)localObject).getFrame(((AnimationDrawable)localObject).getNumberOfFrames() - 1) != ((AnimationDrawable)localObject).getCurrent()))
    {
      localzry.b();
      return;
    }
    localzry.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.LoopingRunnable
 * JD-Core Version:    0.7.0.1
 */