import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import dov.com.qq.im.capture.view.StoryToastView;

public class bmbt
  extends AnimatorListenerAdapter
{
  public bmbt(StoryToastView paramStoryToastView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    StoryToastView.a(this.a).sendEmptyMessageDelayed(1, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbt
 * JD-Core Version:    0.7.0.1
 */