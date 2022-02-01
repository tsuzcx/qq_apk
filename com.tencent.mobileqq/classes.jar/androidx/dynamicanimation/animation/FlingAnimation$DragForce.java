package androidx.dynamicanimation.animation;

final class FlingAnimation$DragForce
  implements Force
{
  private float jdField_a_of_type_Float = -4.2F;
  private final DynamicAnimation.MassState jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState = new DynamicAnimation.MassState();
  private float b;
  
  DynamicAnimation.MassState a(float paramFloat1, float paramFloat2, long paramLong)
  {
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState.b = ((float)(paramFloat2 * Math.exp((float)paramLong / 1000.0F * this.jdField_a_of_type_Float)));
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState.jdField_a_of_type_Float = ((float)(paramFloat1 - paramFloat2 / this.jdField_a_of_type_Float + paramFloat2 / this.jdField_a_of_type_Float * Math.exp(this.jdField_a_of_type_Float * (float)paramLong / 1000.0F)));
    if (a(this.jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState.b)) {
      this.jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState.b = 0.0F;
    }
    return this.jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$MassState;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) < this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.FlingAnimation.DragForce
 * JD-Core Version:    0.7.0.1
 */