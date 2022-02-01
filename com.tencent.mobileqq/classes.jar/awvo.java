import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;

class awvo
  extends AnimatorListenerAdapter
{
  awvo(awur paramawur) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c = false;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366987).setVisibility(8);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366964).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366986).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366992).setVisibility(8);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.c = true;
    int i = this.a.jdField_b_of_type_Int;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366985).setBackgroundResource(2130845316);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366985).getBackground().setColorFilter(new LightingColorFilter(-16777216, i));
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131366984).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvo
 * JD-Core Version:    0.7.0.1
 */