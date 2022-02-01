package com.tencent.mobileqq.activity.aio.anim.friendship.impl.base;

import android.support.annotation.IntRange;

public abstract interface IDirector
{
  @IntRange(from=0L, to=3L)
  public abstract int a();
  
  public abstract void a();
  
  public abstract void a(IDirector.OnDirectorPrepared paramOnDirectorPrepared);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.IDirector
 * JD-Core Version:    0.7.0.1
 */