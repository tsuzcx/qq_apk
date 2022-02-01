import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.RelativeLayout;

class azdq
  extends AnimatorListenerAdapter
{
  azdq(azdh paramazdh, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    azdh.a(this.jdField_a_of_type_Azdh).removeView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdq
 * JD-Core Version:    0.7.0.1
 */