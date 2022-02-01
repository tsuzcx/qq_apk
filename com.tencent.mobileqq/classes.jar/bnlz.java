import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bnlz
  implements Animation.AnimationListener
{
  bnlz(bnlx parambnlx, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bnlx.a(this.jdField_a_of_type_Bnlx).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlz
 * JD-Core Version:    0.7.0.1
 */