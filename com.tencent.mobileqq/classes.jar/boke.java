import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.arch.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;

class boke
  implements Animator.AnimatorListener
{
  boke(bojy parambojy) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
    }
    if (bojy.a(this.a) != null)
    {
      bojy.a(this.a).setAlpha(1.0F);
      bojy.a(this.a).setVisibility(4);
      bojy.a(this.a).b().postValue(Boolean.valueOf(false));
    }
    bojy.d(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boke
 * JD-Core Version:    0.7.0.1
 */