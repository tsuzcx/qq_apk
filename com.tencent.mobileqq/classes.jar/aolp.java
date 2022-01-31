import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;

public class aolp
  extends AnimatorListenerAdapter
{
  public aolp(MatchingView paramMatchingView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (MatchingView.a(this.a)) {
      MatchingView.a(this.a).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aolp
 * JD-Core Version:    0.7.0.1
 */