import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.capture.view.StoryToastView;

public class bmbu
  extends AnimatorListenerAdapter
{
  public bmbu(StoryToastView paramStoryToastView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbu
 * JD-Core Version:    0.7.0.1
 */