import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout.LayoutParams;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteActivity.52.1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XEditTextEx;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class br
  implements Animator.AnimatorListener
{
  public br(LiteActivity paramLiteActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LiteActivity.a(this.a).setPadding(0, aepi.a(8.0F, this.a.app.getApplication().getResources()), 0, 0);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
    ((FrameLayout.LayoutParams)this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(aepi.a(14.0F, this.a.app.getApplication().getResources()), 0, 0, 0);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130849281);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(aepi.a(11.0F, this.a.app.getApplication().getResources()), aepi.a(6.0F, this.a.app.getApplication().getResources()), aepi.a(11.0F, this.a.app.getApplication().getResources()), aepi.a(6.0F, this.a.app.getApplication().getResources()));
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestLayout();
    this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new LiteActivity.52.1(this), 100L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     br
 * JD-Core Version:    0.7.0.1
 */