import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class azlx
  extends AnimatorListenerAdapter
{
  azlx(azlv paramazlv, boolean paramBoolean, View paramView, int paramInt) {}
  
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
      i = vzl.d(this.jdField_a_of_type_Azlv.jdField_a_of_type_AndroidContentContext) - paramAnimator[1];
      if (i >= this.jdField_a_of_type_Int) {}
    }
    for (int i = this.jdField_a_of_type_Int - i;; i = 0)
    {
      if (this.jdField_a_of_type_Azlv.jdField_a_of_type_Azlz != null)
      {
        paramAnimator = this.jdField_a_of_type_Azlv.jdField_a_of_type_Azlz;
        if (!this.jdField_a_of_type_Boolean) {
          bool = true;
        }
        paramAnimator.a(bool, i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlx
 * JD-Core Version:    0.7.0.1
 */