import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class birw
  implements Animation.AnimationListener
{
  birw(biru parambiru, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    biru.a(this.jdField_a_of_type_Biru).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birw
 * JD-Core Version:    0.7.0.1
 */