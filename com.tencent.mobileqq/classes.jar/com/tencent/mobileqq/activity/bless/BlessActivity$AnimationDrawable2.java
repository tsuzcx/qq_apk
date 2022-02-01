package com.tencent.mobileqq.activity.bless;

import android.graphics.drawable.AnimationDrawable;

public class BlessActivity$AnimationDrawable2
  extends AnimationDrawable
{
  private boolean a = false;
  private BlessActivity.IAnimationFinishListener b;
  
  public BlessActivity$AnimationDrawable2(BlessActivity paramBlessActivity) {}
  
  public void a()
  {
    stop();
    this.a = false;
  }
  
  public void a(BlessActivity.IAnimationFinishListener paramIAnimationFinishListener)
  {
    this.b = paramIAnimationFinishListener;
  }
  
  public boolean selectDrawable(int paramInt)
  {
    boolean bool = super.selectDrawable(paramInt);
    if ((paramInt != 0) && (paramInt == getNumberOfFrames() - 1) && (!this.a))
    {
      this.a = true;
      BlessActivity.IAnimationFinishListener localIAnimationFinishListener = this.b;
      if (localIAnimationFinishListener != null) {
        localIAnimationFinishListener.a();
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity.AnimationDrawable2
 * JD-Core Version:    0.7.0.1
 */