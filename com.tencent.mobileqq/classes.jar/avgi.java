import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.16;

public class avgi
  implements Animation.AnimationListener
{
  public avgi(QQGameFeedWebFragment.16 param16) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QQGameFeedWebFragment.a(this.a.this$0).setVisibility(8);
    QQGameFeedWebFragment.a(this.a.this$0, QQGameFeedWebFragment.a(this.a.this$0), true);
    paramAnimation = new RotateAnimation(0.0F, -45.0F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setRepeatMode(2);
    paramAnimation.setRepeatCount(1);
    paramAnimation.setDuration(80L);
    QQGameFeedWebFragment.a(this.a.this$0).startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgi
 * JD-Core Version:    0.7.0.1
 */