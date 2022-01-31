package com.tencent.mobileqq.activity.aio.anim;

public class PathDemo
  implements AnimationPath
{
  double jdField_a_of_type_Double;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public int a(long paramLong, AnimationPath.Values paramValues)
  {
    paramValues.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int + this.jdField_a_of_type_Float * (float)paramLong));
    paramValues.jdField_b_of_type_Int = ((int)(this.jdField_b_of_type_Int + 0.8D * paramLong));
    paramValues.f = ((float)((Math.sin((float)paramLong / 500.0F) + 1.0D) / 2.0D));
    float f1 = (float)paramLong / 2.0F;
    paramValues.jdField_b_of_type_Float = ((float)(f1 * Math.sin(this.jdField_a_of_type_Double)));
    paramValues.c = ((float)(f1 * Math.cos(this.jdField_a_of_type_Double)));
    if ((paramValues.jdField_a_of_type_Int < -this.c) || (paramValues.jdField_b_of_type_Int < -this.d) || (paramValues.jdField_a_of_type_Int > this.e + this.c) || (paramValues.jdField_b_of_type_Int > this.f + this.d)) {
      return -1;
    }
    return 16;
  }
  
  public int a(AnimationPath.Values paramValues, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = (paramInt3 / 2);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = ((float)(Math.random() - 0.5D));
    this.c = (paramInt1 / 2);
    this.d = (paramInt2 / 2);
    this.e = paramInt3;
    this.f = paramInt4;
    paramValues.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramValues.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Double = (Math.random() * 2.0D * 3.141592653589793D);
    return 1;
  }
  
  public PathDemo a()
  {
    return new PathDemo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.PathDemo
 * JD-Core Version:    0.7.0.1
 */