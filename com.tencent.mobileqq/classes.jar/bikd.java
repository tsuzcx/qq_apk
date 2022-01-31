import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;

class bikd
  implements Animator.AnimatorListener
{
  bikd(bikc parambikc) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
    }
    if (bikc.a(this.a) != null)
    {
      bikc.a(this.a).setAlpha(1.0F);
      bikc.a(this.a).setVisibility(4);
      bikc.a(this.a).b().a(Boolean.valueOf(false));
    }
    bikc.b(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bikd
 * JD-Core Version:    0.7.0.1
 */