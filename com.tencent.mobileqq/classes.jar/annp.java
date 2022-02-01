import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.apollo.view.CmShowAESurfaceView;
import com.tencent.qphone.base.util.QLog;

public class annp
  extends AnimatorListenerAdapter
{
  public annp(CmShowAESurfaceView paramCmShowAESurfaceView) {}
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    QLog.i("CmShowAESurfaceView", 1, "onAnimationEnd.");
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    QLog.i("CmShowAESurfaceView", 1, "onAnimationStart.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annp
 * JD-Core Version:    0.7.0.1
 */