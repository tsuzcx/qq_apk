package androidx.dynamicanimation.animation;

public final class SpringAnimation
  extends DynamicAnimation<SpringAnimation>
{
  private SpringForce a;
  private boolean c;
  private float e = 3.4028235E+38F;
  
  public <K> SpringAnimation(K paramK, FloatPropertyCompat<K> paramFloatPropertyCompat, float paramFloat)
  {
    super(paramK, paramFloatPropertyCompat);
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce = new SpringForce(paramFloat);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce == null) {
      throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }
    double d = this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.a();
    if (d > this.jdField_c_of_type_Float) {
      throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    }
    if (d < this.d) {
      throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    }
  }
  
  public SpringForce a()
  {
    return this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce;
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.a(a());
    super.a();
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.a(paramFloat1, paramFloat2);
  }
  
  boolean b(long paramLong)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.e != 3.4028235E+38F)
      {
        this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.c(this.e);
        this.e = 3.4028235E+38F;
      }
      this.b = this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.a();
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_c_of_type_Boolean = false;
      return true;
    }
    DynamicAnimation.MassState localMassState;
    if (this.e != 3.4028235E+38F)
    {
      double d = this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.a();
      localMassState = this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.a(this.b, this.jdField_a_of_type_Float, paramLong / 2L);
      this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.c(this.e);
      this.e = 3.4028235E+38F;
      localMassState = this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.a(localMassState.jdField_a_of_type_Float, localMassState.b, paramLong / 2L);
      this.b = localMassState.jdField_a_of_type_Float;
    }
    for (this.jdField_a_of_type_Float = localMassState.b;; this.jdField_a_of_type_Float = localMassState.b)
    {
      this.b = Math.max(this.b, this.d);
      this.b = Math.min(this.b, this.jdField_c_of_type_Float);
      if (!a(this.b, this.jdField_a_of_type_Float)) {
        break;
      }
      this.b = this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.a();
      this.jdField_a_of_type_Float = 0.0F;
      return true;
      localMassState = this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.a(this.b, this.jdField_a_of_type_Float, paramLong);
      this.b = localMassState.jdField_a_of_type_Float;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.SpringAnimation
 * JD-Core Version:    0.7.0.1
 */