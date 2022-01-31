package com.tencent.mobileqq.activity;

class PortraitImageview$3
  implements Runnable
{
  PortraitImageview$3(PortraitImageview paramPortraitImageview, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.jdField_a_of_type_Float, (float)(l - this.jdField_a_of_type_Long));
    float f2 = this.b;
    float f3 = this.c;
    this.this$0.a(f2 + f3 * f1, this.d, this.e);
    if (f1 < this.jdField_a_of_type_Float) {
      this.this$0.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview.3
 * JD-Core Version:    0.7.0.1
 */