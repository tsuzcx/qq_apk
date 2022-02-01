import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;

class bfcr
  implements Animator.AnimatorListener
{
  bfcr(bfcn parambfcn) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bfcn.a(this.a).setPadding(bhgr.a(bfcn.a(this.a).getContext(), 8.0F), -bfcn.a(this.a), 0, 0);
    bfcn.a(this.a).setVisibility(8);
    bfcn.a(this.a, false);
    bfcn.b(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bfcn.a(this.a).setPadding(bhgr.a(bfcn.a(this.a).getContext(), 8.0F), -bfcn.a(this.a), 0, 0);
    bfcn.a(this.a).setVisibility(8);
    bfcn.a(this.a, false);
    bfcn.b(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bfcn.a(this.a).setPadding(bhgr.a(bfcn.a(this.a).getContext(), 8.0F), 0, 0, 0);
    bfcn.a(this.a, true);
    bfcn.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfcr
 * JD-Core Version:    0.7.0.1
 */