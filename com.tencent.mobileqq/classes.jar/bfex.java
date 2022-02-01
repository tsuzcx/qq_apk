import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;

class bfex
  extends AnimatorListenerAdapter
{
  bfex(bfev parambfev, boolean paramBoolean, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      paramAnimator = new int[2];
      this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramAnimator);
      i = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_Bfev.jdField_a_of_type_AndroidContentContext) - paramAnimator[1];
      if (i >= this.jdField_a_of_type_Int) {}
    }
    for (int i = this.jdField_a_of_type_Int - i;; i = 0)
    {
      if (this.jdField_a_of_type_Bfev.jdField_a_of_type_Bfez != null)
      {
        paramAnimator = this.jdField_a_of_type_Bfev.jdField_a_of_type_Bfez;
        if (!this.jdField_a_of_type_Boolean) {
          bool = true;
        }
        paramAnimator.a(bool, i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfex
 * JD-Core Version:    0.7.0.1
 */