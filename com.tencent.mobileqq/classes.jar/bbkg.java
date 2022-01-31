import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bbkg
  extends AnimatorListenerAdapter
{
  bbkg(bbke parambbke, boolean paramBoolean, View paramView, int paramInt) {}
  
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
      i = xod.d(this.jdField_a_of_type_Bbke.jdField_a_of_type_AndroidContentContext) - paramAnimator[1];
      if (i >= this.jdField_a_of_type_Int) {}
    }
    for (int i = this.jdField_a_of_type_Int - i;; i = 0)
    {
      if (this.jdField_a_of_type_Bbke.jdField_a_of_type_Bbki != null)
      {
        paramAnimator = this.jdField_a_of_type_Bbke.jdField_a_of_type_Bbki;
        if (!this.jdField_a_of_type_Boolean) {
          bool = true;
        }
        paramAnimator.a(bool, i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkg
 * JD-Core Version:    0.7.0.1
 */