import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.6;

public class azgu
  extends AnimatorListenerAdapter
{
  public azgu(TroopBarPublishActivity.6 param6) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a) {
      this.a.this$0.s();
    }
    this.a.this$0.b.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azgu
 * JD-Core Version:    0.7.0.1
 */