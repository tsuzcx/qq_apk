import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;

class bfcp
  implements Animator.AnimatorListener
{
  bfcp(bfcn parambfcn) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bfcn.a(this.a).setPadding(bhgr.a(bfcn.a(this.a).getContext(), 8.0F), -bfcn.a(this.a), 0, 0);
    bfcn.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bfcn.a(this.a).setPadding(bhgr.a(bfcn.a(this.a).getContext(), 8.0F), 0, 0, 0);
    bfcn.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bfcn.a(this.a).setPadding(bhgr.a(bfcn.a(this.a).getContext(), 8.0F), -bfcn.a(this.a), 0, 0);
    bfcn.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfcp
 * JD-Core Version:    0.7.0.1
 */