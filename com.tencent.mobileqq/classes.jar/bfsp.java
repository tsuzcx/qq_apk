import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;

public class bfsp
  implements Animation.AnimationListener
{
  public bfsp(ReciteFragment paramReciteFragment, Button paramButton) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsp
 * JD-Core Version:    0.7.0.1
 */