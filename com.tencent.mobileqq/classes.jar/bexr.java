import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.4.1;

public class bexr
  implements Animation.AnimationListener
{
  public bexr(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.a.jdField_b_of_type_AndroidViewView.post(new TroopAvatarWallPreviewActivity.4.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexr
 * JD-Core Version:    0.7.0.1
 */