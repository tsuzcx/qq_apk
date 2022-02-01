import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;

public class bego
  implements Animation.AnimationListener
{
  public bego(AudioRecordFragment paramAudioRecordFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    this.a.jdField_b_of_type_AndroidViewView.setBackgroundColor(2130706432);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bego
 * JD-Core Version:    0.7.0.1
 */