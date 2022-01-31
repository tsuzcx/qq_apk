import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.ContainerViewListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.Iterator;
import java.util.List;

public class anyf
  implements Animator.AnimatorListener
{
  public anyf(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c.setVisibility(0);
    QIMProviderContainerView.a(this.a, true);
    if (QIMProviderContainerView.a(this.a) != null)
    {
      paramAnimator = QIMProviderContainerView.a(this.a).iterator();
      while (paramAnimator.hasNext()) {
        ((ProviderContainerView.ContainerViewListener)paramAnimator.next()).a(null, 0);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "panelOpened : " + QIMProviderContainerView.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anyf
 * JD-Core Version:    0.7.0.1
 */