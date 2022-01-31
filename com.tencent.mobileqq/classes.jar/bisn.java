import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bisn
  implements Animation.AnimationListener
{
  bisn(bisl parambisl, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bisl.a(this.jdField_a_of_type_Bisl).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bisn
 * JD-Core Version:    0.7.0.1
 */