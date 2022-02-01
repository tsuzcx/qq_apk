import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;

public class atgt
  implements Animation.AnimationListener
{
  public atgt(Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Face2FaceFriendBubbleView.a(this.a).setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (Face2FaceFriendBubbleView.a(this.a) == 1)
    {
      Face2FaceFriendBubbleView.a(this.a).setVisibility(8);
      Face2FaceFriendBubbleView.a(this.a).setVisibility(8);
    }
    for (;;)
    {
      Face2FaceFriendBubbleView.a(this.a).setVisibility(4);
      return;
      if (Face2FaceFriendBubbleView.a(this.a) == 2)
      {
        Face2FaceFriendBubbleView.a(this.a).setImageResource(2130840090);
        Face2FaceFriendBubbleView.a(this.a).setVisibility(0);
        Face2FaceFriendBubbleView.a(this.a).setVisibility(8);
      }
      else if (Face2FaceFriendBubbleView.a(this.a) == 3)
      {
        Face2FaceFriendBubbleView.a(this.a).setImageResource(2130840091);
        Face2FaceFriendBubbleView.a(this.a).setVisibility(0);
        Face2FaceFriendBubbleView.a(this.a).setVisibility(8);
      }
      else if (Face2FaceFriendBubbleView.a(this.a) == 4)
      {
        Face2FaceFriendBubbleView.a(this.a).setImageResource(2130840092);
        Face2FaceFriendBubbleView.a(this.a).setVisibility(0);
        Face2FaceFriendBubbleView.a(this.a).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgt
 * JD-Core Version:    0.7.0.1
 */