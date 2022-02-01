import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;

class bgzb
  implements Animation.AnimationListener
{
  bgzb(bgyz parambgyz, ImageView paramImageView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Bgyz.a.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgzb
 * JD-Core Version:    0.7.0.1
 */