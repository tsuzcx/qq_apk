package androidx.dynamicanimation.animation;

public final class FlingAnimation
  extends DynamicAnimation<FlingAnimation>
{
  private final FlingAnimation.DragForce a;
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= this.c) || (paramFloat1 <= this.d) || (this.jdField_a_of_type_AndroidxDynamicanimationAnimationFlingAnimation$DragForce.a(paramFloat1, paramFloat2));
  }
  
  boolean b(long paramLong)
  {
    DynamicAnimation.MassState localMassState = this.jdField_a_of_type_AndroidxDynamicanimationAnimationFlingAnimation$DragForce.a(this.b, this.jdField_a_of_type_Float, paramLong);
    this.b = localMassState.jdField_a_of_type_Float;
    this.jdField_a_of_type_Float = localMassState.b;
    if (this.b < this.d) {
      this.b = this.d;
    }
    do
    {
      return true;
      if (this.b > this.c)
      {
        this.b = this.c;
        return true;
      }
    } while (a(this.b, this.jdField_a_of_type_Float));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.FlingAnimation
 * JD-Core Version:    0.7.0.1
 */