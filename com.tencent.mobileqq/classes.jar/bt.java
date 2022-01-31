import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout.LayoutParams;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XEditTextEx;
import mqq.app.MobileQQ;

public class bt
  implements Animator.AnimatorListener
{
  public bt(LiteActivity paramLiteActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LiteActivity.a(this.a).setPadding(0, 0, 0, 0);
    ((FrameLayout.LayoutParams)this.a.a.getLayoutParams()).setMargins(0, 0, 0, 0);
    this.a.a.setPadding(aepi.a(24.0F, this.a.app.getApplication().getResources()), aepi.a(10.0F, this.a.app.getApplication().getResources()), aepi.a(24.0F, this.a.app.getApplication().getResources()), 0);
    LiteActivity.a(this.a).getLayoutParams().height = -1;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bt
 * JD-Core Version:    0.7.0.1
 */