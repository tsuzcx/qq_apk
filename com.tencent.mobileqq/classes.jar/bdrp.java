import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.6;

public class bdrp
  extends AnimatorListenerAdapter
{
  public bdrp(TroopBarPublishActivity.6 param6) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a) {
      this.a.this$0.p();
    }
    this.a.this$0.b.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrp
 * JD-Core Version:    0.7.0.1
 */