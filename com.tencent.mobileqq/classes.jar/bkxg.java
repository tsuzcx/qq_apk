import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bkxg
  implements Animation.AnimationListener
{
  bkxg(bkxe parambkxe, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bkxe.a(this.jdField_a_of_type_Bkxe).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxg
 * JD-Core Version:    0.7.0.1
 */