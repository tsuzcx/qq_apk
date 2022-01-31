import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;

class bkpj
  implements Animator.AnimatorListener
{
  bkpj(bkpi parambkpi) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
    }
    if (bkpi.a(this.a) != null)
    {
      bkpi.a(this.a).setAlpha(1.0F);
      bkpi.a(this.a).setVisibility(4);
      bkpi.a(this.a).b().a(Boolean.valueOf(false));
    }
    bkpi.c(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpj
 * JD-Core Version:    0.7.0.1
 */