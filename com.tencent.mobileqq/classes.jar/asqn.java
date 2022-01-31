import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;

class asqn
  extends AnimatorListenerAdapter
{
  asqn(aspq paramaspq) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c = false;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131300926).setVisibility(8);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131300900).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131300925).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131300931).setVisibility(8);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.c = true;
    int i = this.a.jdField_b_of_type_Int;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131300924).setBackgroundResource(2130844504);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131300924).getBackground().setColorFilter(new LightingColorFilter(-16777216, i));
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131300923).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asqn
 * JD-Core Version:    0.7.0.1
 */