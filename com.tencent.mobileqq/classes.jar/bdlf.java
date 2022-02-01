import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;
import com.tencent.mobileqq.util.DisplayUtil;

class bdlf
  implements Animator.AnimatorListener
{
  bdlf(bdlb parambdlb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bdlb.a(this.a).setPadding(DisplayUtil.dip2px(bdlb.a(this.a).getContext(), 8.0F), -bdlb.a(this.a), 0, 0);
    bdlb.a(this.a).setVisibility(8);
    bdlb.a(this.a, false);
    bdlb.b(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bdlb.a(this.a).setPadding(DisplayUtil.dip2px(bdlb.a(this.a).getContext(), 8.0F), -bdlb.a(this.a), 0, 0);
    bdlb.a(this.a).setVisibility(8);
    bdlb.a(this.a, false);
    bdlb.b(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bdlb.a(this.a).setPadding(DisplayUtil.dip2px(bdlb.a(this.a).getContext(), 8.0F), 0, 0, 0);
    bdlb.a(this.a, true);
    bdlb.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdlf
 * JD-Core Version:    0.7.0.1
 */