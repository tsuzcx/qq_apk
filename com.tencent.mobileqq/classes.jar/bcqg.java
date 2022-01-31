import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;

class bcqg
  implements Animation.AnimationListener
{
  bcqg(bcqe parambcqe, ImageView paramImageView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Bcqe.a.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqg
 * JD-Core Version:    0.7.0.1
 */