import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;

public class aqiw
  extends AnimatorListenerAdapter
{
  public aqiw(MatchingView paramMatchingView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (MatchingView.a(this.a)) {
      MatchingView.a(this.a).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqiw
 * JD-Core Version:    0.7.0.1
 */