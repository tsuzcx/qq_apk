package com.tencent.mobileqq.activity;

class PortraitImageview$3
  implements Runnable
{
  PortraitImageview$3(PortraitImageview paramPortraitImageview, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.a, (float)(l - this.b));
    float f2 = this.c;
    float f3 = this.d;
    this.this$0.a(f2 + f3 * f1, this.e, this.f);
    if (f1 < this.a) {
      this.this$0.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview.3
 * JD-Core Version:    0.7.0.1
 */