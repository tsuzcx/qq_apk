import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable.AnimationListener;

public class aobp
  implements Animator.AnimatorListener
{
  public aobp(InfoStickerDrawable paramInfoStickerDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (InfoStickerDrawable.a(this.a) != null) {
      InfoStickerDrawable.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aobp
 * JD-Core Version:    0.7.0.1
 */