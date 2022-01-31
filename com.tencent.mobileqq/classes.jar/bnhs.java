import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr.DragViewIcon;

public class bnhs
  extends AnimatorListenerAdapter
{
  public bnhs(DragAnimationMgr paramDragAnimationMgr) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    int i = DragAnimationMgr.a(this.a).a();
    DragAnimationMgr.a(this.a, DragAnimationMgr.a(this.a), i);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = DragAnimationMgr.a(this.a).a();
    DragAnimationMgr.a(this.a, DragAnimationMgr.a(this.a), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhs
 * JD-Core Version:    0.7.0.1
 */