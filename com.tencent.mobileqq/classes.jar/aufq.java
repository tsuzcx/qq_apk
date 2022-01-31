import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.RelativeLayout;

class aufq
  extends AnimatorListenerAdapter
{
  aufq(aufh paramaufh, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aufh.a(this.jdField_a_of_type_Aufh).removeView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufq
 * JD-Core Version:    0.7.0.1
 */