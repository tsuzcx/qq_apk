import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;

public class atgu
  implements Animation.AnimationListener
{
  public atgu(Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((Face2FaceFriendBubbleView.a(this.a) == 2) || (Face2FaceFriendBubbleView.a(this.a) == 3) || (Face2FaceFriendBubbleView.a(this.a) == 4))
    {
      Face2FaceFriendBubbleView.a(this.a).startAnimation(Face2FaceFriendBubbleView.a(this.a));
      return;
    }
    Face2FaceFriendBubbleView.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgu
 * JD-Core Version:    0.7.0.1
 */