package com.tencent.image;

public abstract interface AnimationCallback
{
  public abstract void invalidateSelf();
  
  public abstract void scheduleSelf(Runnable paramRunnable, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.AnimationCallback
 * JD-Core Version:    0.7.0.1
 */