package com.tencent.biz.subscribe.animation;

import android.graphics.drawable.AnimationDrawable;
import mqq.util.WeakReference;

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
    if (localObject != null)
    {
      PopViewAnimationDrawableHelper.OnInnerFrameAnimationListener localOnInnerFrameAnimationListener = PopViewAnimationDrawableHelper.a((PopViewAnimationDrawableHelper)localObject);
      if (localOnInnerFrameAnimationListener != null)
      {
        if (PopViewAnimationDrawableHelper.a((PopViewAnimationDrawableHelper)localObject) > 0)
        {
          localOnInnerFrameAnimationListener.a();
          return;
        }
        localObject = PopViewAnimationDrawableHelper.a((PopViewAnimationDrawableHelper)localObject);
        if ((localObject != null) && (((AnimationDrawable)localObject).getFrame(((AnimationDrawable)localObject).getNumberOfFrames() - 1) != ((AnimationDrawable)localObject).getCurrent()))
        {
          localOnInnerFrameAnimationListener.b();
          return;
        }
        localOnInnerFrameAnimationListener.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.LoopingRunnable
 * JD-Core Version:    0.7.0.1
 */