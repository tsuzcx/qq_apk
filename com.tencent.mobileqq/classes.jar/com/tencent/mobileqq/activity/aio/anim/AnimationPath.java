package com.tencent.mobileqq.activity.aio.anim;

public abstract interface AnimationPath
{
  public static final AnimationPath.Values a = new AnimationPath.Values();
  
  public abstract int a(long paramLong, AnimationPath.Values paramValues);
  
  public abstract int a(AnimationPath.Values paramValues, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract AnimationPath a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AnimationPath
 * JD-Core Version:    0.7.0.1
 */