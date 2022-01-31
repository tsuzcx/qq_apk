import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;

class avic
  extends AnimatorListenerAdapter
{
  avic(avhf paramavhf) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c = false;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366649).setVisibility(8);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366623).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366648).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366658).setVisibility(8);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.c = true;
    int i = this.a.jdField_b_of_type_Int;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366647).setBackgroundResource(2130845024);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366647).getBackground().setColorFilter(new LightingColorFilter(-16777216, i));
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366646).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avic
 * JD-Core Version:    0.7.0.1
 */