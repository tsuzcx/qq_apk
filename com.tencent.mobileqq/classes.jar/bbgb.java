import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;

public class bbgb
  implements Animation.AnimationListener
{
  public bbgb(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.b = false;
    paramAnimation.setAnimationListener(null);
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgb
 * JD-Core Version:    0.7.0.1
 */