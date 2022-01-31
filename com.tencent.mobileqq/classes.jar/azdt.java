import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;

public class azdt
  implements Animation.AnimationListener
{
  public azdt(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.b = false;
    paramAnimation.setAnimationListener(null);
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azdt
 * JD-Core Version:    0.7.0.1
 */