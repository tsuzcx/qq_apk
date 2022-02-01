import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class ayti
  extends ReportDialog
  implements Animator.AnimatorListener
{
  protected float a;
  protected AnimatorSet a;
  protected View a;
  private int[] a;
  protected float b;
  protected View b;
  
  public ayti(@NonNull Context paramContext)
  {
    super(paramContext, 2131755228);
    this.jdField_a_of_type_Float = 0.5F;
    this.jdField_b_of_type_Float = 0.5F;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    setCanceledOnTouchOutside(true);
    setCancelable(true);
    paramContext = getWindow();
    if (paramContext != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        paramContext.addFlags(67108864);
      }
      ImmersiveUtils.a(paramContext, true);
    }
  }
  
  public void a(TextView paramTextView, QQAppInterface paramQQAppInterface)
  {
    a(paramTextView, paramQQAppInterface, 2131165612, 2131167171);
  }
  
  public void a(TextView paramTextView, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)) {}
    for (;;)
    {
      paramTextView.setTextColor(paramTextView.getResources().getColor(paramInt1));
      return;
      paramInt1 = paramInt2;
    }
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length != 2)) {
      return;
    }
    this.jdField_a_of_type_Float = paramArrayOfFloat[0];
    this.jdField_b_of_type_Float = paramArrayOfFloat[1];
  }
  
  protected abstract void a(int[] paramArrayOfInt);
  
  public boolean b(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return false;
    }
    a(this.jdField_a_of_type_ArrayOfInt);
    View localView = this.jdField_b_of_type_AndroidViewView;
    float f = this.jdField_a_of_type_Float;
    localView.setPivotX(this.jdField_a_of_type_ArrayOfInt[0] * f);
    this.jdField_b_of_type_AndroidViewView.setPivotY(this.jdField_b_of_type_Float * this.jdField_a_of_type_ArrayOfInt[1]);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    c(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(this);
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    return true;
  }
  
  protected void c(boolean paramBoolean)
  {
    float f4 = 1.0F;
    float f1;
    float f2;
    label16:
    float f3;
    if (paramBoolean)
    {
      f1 = 0.3F;
      if (!paramBoolean) {
        break label147;
      }
      f2 = 1.0F;
      if (!paramBoolean) {
        break label152;
      }
      f3 = 0.5F;
      label24:
      if (!paramBoolean) {
        break label158;
      }
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleX", new float[] { f1, f2 });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleY", new float[] { f1, f2 });
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { f3, f4 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
      return;
      f1 = 1.0F;
      break;
      label147:
      f2 = 0.0F;
      break label16;
      label152:
      f3 = 1.0F;
      break label24;
      label158:
      f4 = 0.0F;
    }
  }
  
  protected void d() {}
  
  public void dismiss()
  {
    d();
    if (!b(false))
    {
      super.dismiss();
      e();
    }
  }
  
  protected void e() {}
  
  public void m()
  {
    d();
    super.dismiss();
    e();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.dismiss();
    e();
    paramAnimator.removeListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.dismiss();
    e();
    paramAnimator.removeListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayti
 * JD-Core Version:    0.7.0.1
 */