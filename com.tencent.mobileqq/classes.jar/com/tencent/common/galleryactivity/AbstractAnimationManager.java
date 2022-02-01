package com.tencent.common.galleryactivity;

import java.util.ArrayList;

public abstract class AbstractAnimationManager
  implements AnimationLister
{
  protected ArrayList<AnimationLister> a = new ArrayList();
  protected boolean b;
  protected long c = 350L;
  public boolean d = true;
  public boolean e;
  
  public void a(AnimationLister paramAnimationLister)
  {
    if (!this.a.contains(paramAnimationLister)) {
      this.a.add(paramAnimationLister);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public void d()
  {
    this.c = 350L;
  }
  
  public long e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractAnimationManager
 * JD-Core Version:    0.7.0.1
 */