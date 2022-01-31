import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.ScrollerRunnable.4;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bcqx
  implements Animator.AnimatorListener
{
  public bcqx(ScrollerRunnable.4 param4) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a.getParent() != null)
    {
      this.a.a.clearAnimation();
      if (QLog.isColorLevel()) {
        QLog.i("ScrollerRunnable", 2, "onAnimationEnd-->clearAnimation");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ScrollerRunnable", 2, "onAnimationEnd:" + hashCode() + "," + this.a.a.hashCode() + "," + this.a.a.getParent());
    }
    if ((azng.a(this.a.this$0.k)) && (this.a.this$0.a != null)) {
      this.a.this$0.a.obtainMessage(50).sendToTarget();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScrollerRunnable", 2, "onAnimationStart:" + hashCode() + "," + this.a.a.hashCode() + "," + this.a.a.getParent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcqx
 * JD-Core Version:    0.7.0.1
 */