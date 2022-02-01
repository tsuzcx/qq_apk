package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;

public final class SpringForce
  implements Force
{
  double jdField_a_of_type_Double = Math.sqrt(1500.0D);
  private final DynamicAnimation.MassState jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState = new DynamicAnimation.MassState();
  private boolean jdField_a_of_type_Boolean = false;
  double b = 0.5D;
  private double c;
  private double d;
  private double e;
  private double f;
  private double g;
  private double h = 1.7976931348623157E+308D;
  
  public SpringForce() {}
  
  public SpringForce(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.h == 1.7976931348623157E+308D) {
      throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
    if (this.b > 1.0D)
    {
      this.e = (-this.b * this.jdField_a_of_type_Double + this.jdField_a_of_type_Double * Math.sqrt(this.b * this.b - 1.0D));
      this.f = (-this.b * this.jdField_a_of_type_Double - this.jdField_a_of_type_Double * Math.sqrt(this.b * this.b - 1.0D));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      if ((this.b >= 0.0D) && (this.b < 1.0D)) {
        this.g = (this.jdField_a_of_type_Double * Math.sqrt(1.0D - this.b * this.b));
      }
    }
  }
  
  public float a()
  {
    return (float)this.h;
  }
  
  DynamicAnimation.MassState a(double paramDouble1, double paramDouble2, long paramLong)
  {
    a();
    double d1 = paramLong / 1000.0D;
    paramDouble1 -= this.h;
    double d2;
    double d3;
    double d4;
    double d5;
    if (this.b > 1.0D)
    {
      d2 = paramDouble1 - (this.f * paramDouble1 - paramDouble2) / (this.f - this.e);
      paramDouble1 = (this.f * paramDouble1 - paramDouble2) / (this.f - this.e);
      paramDouble2 = Math.pow(2.718281828459045D, this.f * d1) * d2 + Math.pow(2.718281828459045D, this.e * d1) * paramDouble1;
      d3 = this.f;
      d4 = Math.pow(2.718281828459045D, this.f * d1);
      d5 = this.e;
      paramDouble1 = Math.pow(2.718281828459045D, d1 * this.e) * (paramDouble1 * d5) + d2 * d3 * d4;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState.a = ((float)(paramDouble2 + this.h));
      this.jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState.b = ((float)paramDouble1);
      return this.jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState;
      if (this.b == 1.0D)
      {
        d2 = paramDouble2 + this.jdField_a_of_type_Double * paramDouble1;
        paramDouble2 = (d2 * d1 + paramDouble1) * Math.pow(2.718281828459045D, -this.jdField_a_of_type_Double * d1);
        d3 = Math.pow(2.718281828459045D, -this.jdField_a_of_type_Double * d1);
        d4 = -this.jdField_a_of_type_Double;
        paramDouble1 = Math.pow(2.718281828459045D, d1 * -this.jdField_a_of_type_Double) * d2 + (paramDouble1 + d2 * d1) * d3 * d4;
      }
      else
      {
        d2 = 1.0D / this.g;
        d2 = (this.b * this.jdField_a_of_type_Double * paramDouble1 + paramDouble2) * d2;
        paramDouble2 = Math.pow(2.718281828459045D, -this.b * this.jdField_a_of_type_Double * d1) * (Math.cos(this.g * d1) * paramDouble1 + Math.sin(this.g * d1) * d2);
        d3 = -this.jdField_a_of_type_Double;
        d4 = this.b;
        d5 = Math.pow(2.718281828459045D, -this.b * this.jdField_a_of_type_Double * d1);
        double d6 = -this.g;
        double d7 = Math.sin(this.g * d1);
        double d8 = this.g;
        paramDouble1 = (Math.cos(d1 * this.g) * (d2 * d8) + paramDouble1 * d6 * d7) * d5 + d3 * paramDouble2 * d4;
      }
    }
  }
  
  public SpringForce a(@FloatRange(from=0.0D, fromInclusive=false) float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }
    this.jdField_a_of_type_Double = Math.sqrt(paramFloat);
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  void a(double paramDouble)
  {
    this.c = Math.abs(paramDouble);
    this.d = (this.c * 62.5D);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return (Math.abs(paramFloat2) < this.d) && (Math.abs(paramFloat1 - a()) < this.c);
  }
  
  public SpringForce b(@FloatRange(from=0.0D) float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Damping ratio must be non-negative");
    }
    this.b = paramFloat;
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public SpringForce c(float paramFloat)
  {
    this.h = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.SpringForce
 * JD-Core Version:    0.7.0.1
 */