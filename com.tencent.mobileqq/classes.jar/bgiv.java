import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bgiv
  implements Animation.AnimationListener
{
  bgiv(bgit parambgit, Dialog paramDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgiv
 * JD-Core Version:    0.7.0.1
 */