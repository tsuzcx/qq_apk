import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

public class aqfi
  implements Animation.AnimationListener
{
  public aqfi(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfi
 * JD-Core Version:    0.7.0.1
 */