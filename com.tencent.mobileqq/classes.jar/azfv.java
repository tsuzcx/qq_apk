import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.5.1;

public class azfv
  implements Animation.AnimationListener
{
  public azfv(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.b == null) {
      return;
    }
    this.a.b.post(new TroopAvatarWallPreviewActivity.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azfv
 * JD-Core Version:    0.7.0.1
 */