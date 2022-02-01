import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.widget.Gallery;

public class bfhl
  implements Animation.AnimationListener
{
  public bfhl(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setVisibility(4);
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhl
 * JD-Core Version:    0.7.0.1
 */