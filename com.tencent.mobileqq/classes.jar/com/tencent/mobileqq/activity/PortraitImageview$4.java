package com.tencent.mobileqq.activity;

class PortraitImageview$4
  implements Runnable
{
  float a;
  float b;
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.c, (float)(l - this.d));
    float f2 = this.this$0.b(f1, 0.0F, this.e, this.c);
    float f3 = this.this$0.b(f1, 0.0F, this.f, this.c);
    this.this$0.a(f2 - this.a, f3 - this.b);
    PortraitImageview localPortraitImageview = this.this$0;
    localPortraitImageview.setImageMatrix(localPortraitImageview.getImageViewMatrix());
    this.a = f2;
    this.b = f3;
    if (f1 < this.c) {
      this.this$0.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview.4
 * JD-Core Version:    0.7.0.1
 */