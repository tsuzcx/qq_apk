import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class blbn
  implements Animation.AnimationListener
{
  blbn(blbl paramblbl, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    blbl.a(this.jdField_a_of_type_Blbl).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbn
 * JD-Core Version:    0.7.0.1
 */