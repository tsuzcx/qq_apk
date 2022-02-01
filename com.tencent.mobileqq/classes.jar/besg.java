import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;
import com.tencent.mobileqq.util.DisplayUtil;

class besg
  implements Animator.AnimatorListener
{
  besg(bese parambese) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bese.a(this.a).setPadding(DisplayUtil.dip2px(bese.a(this.a).getContext(), 8.0F), -bese.a(this.a), 0, 0);
    bese.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bese.a(this.a).setPadding(DisplayUtil.dip2px(bese.a(this.a).getContext(), 8.0F), 0, 0, 0);
    bese.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bese.a(this.a).setPadding(DisplayUtil.dip2px(bese.a(this.a).getContext(), 8.0F), -bese.a(this.a), 0, 0);
    bese.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besg
 * JD-Core Version:    0.7.0.1
 */