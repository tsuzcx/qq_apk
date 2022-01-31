package com.tencent.mobileqq.activity;

class PortraitImageview$4
  implements Runnable
{
  float jdField_a_of_type_Float;
  float b;
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.c, (float)(l - this.jdField_a_of_type_Long));
    float f2 = this.this$0.a(f1, 0.0F, this.d, this.c);
    float f3 = this.this$0.a(f1, 0.0F, this.e, this.c);
    this.this$0.a(f2 - this.jdField_a_of_type_Float, f3 - this.b);
    this.this$0.setImageMatrix(this.this$0.a());
    this.jdField_a_of_type_Float = f2;
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