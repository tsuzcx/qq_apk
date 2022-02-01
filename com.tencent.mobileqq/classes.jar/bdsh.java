import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class bdsh
  implements View.OnAttachStateChangeListener
{
  bdsh(bdsf parambdsf, ObjectAnimator paramObjectAnimator) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsh
 * JD-Core Version:    0.7.0.1
 */