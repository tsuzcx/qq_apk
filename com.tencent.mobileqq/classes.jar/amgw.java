import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class amgw
{
  private float jdField_a_of_type_Float;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private float b;
  
  public amgw(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView.setPivotX(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidViewView.setPivotY(this.b);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 1.0F, 0.0F });
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(500L);
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(amki paramamki, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      Animator localAnimator = wfb.a(this.jdField_a_of_type_AndroidViewView, (int)this.jdField_a_of_type_Float + paramInt, (int)this.b, this.jdField_a_of_type_AndroidViewView.getHeight() / 2, 1.0F);
      localAnimator.addListener(new amgx(this, paramamki, paramBoolean));
      localAnimator.setDuration(300L);
      localAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgw
 * JD-Core Version:    0.7.0.1
 */