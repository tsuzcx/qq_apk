package com.tencent.biz.qqcircle.flutter.animation;

final class PushCountImageRenderer$1
  implements Runnable
{
  PushCountImageRenderer$1(PushCountImageRenderer.LoadCountBitmapsListener paramLoadCountBitmapsListener, String[] paramArrayOfString) {}
  
  public void run()
  {
    this.a.a();
    PushCountImageRenderer.a(this.b);
    if (PushCountImageRenderer.c() != null)
    {
      this.a.b();
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.PushCountImageRenderer.1
 * JD-Core Version:    0.7.0.1
 */