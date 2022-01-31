import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;

class biku
  implements Animator.AnimatorListener
{
  biku(bikt parambikt) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
    }
    if (bikt.a(this.a) != null)
    {
      bikt.a(this.a).setAlpha(1.0F);
      bikt.a(this.a).setVisibility(4);
      bikt.a(this.a).b().a(Boolean.valueOf(false));
    }
    bikt.b(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biku
 * JD-Core Version:    0.7.0.1
 */