package com.tencent.biz.qqcircle.publish.common;

public abstract class Singleton<T, P>
{
  private volatile T a;
  
  protected abstract T a(P paramP);
  
  public void a()
  {
    this.a = null;
  }
  
  public final T b(P paramP)
  {
    if (this.a == null) {
      try
      {
        if (this.a == null) {
          this.a = a(paramP);
        }
      }
      finally {}
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.common.Singleton
 * JD-Core Version:    0.7.0.1
 */