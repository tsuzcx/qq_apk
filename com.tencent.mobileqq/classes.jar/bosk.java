import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bosk
  implements Animation.AnimationListener
{
  bosk(bosi parambosi, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bosi.a(this.jdField_a_of_type_Bosi).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosk
 * JD-Core Version:    0.7.0.1
 */