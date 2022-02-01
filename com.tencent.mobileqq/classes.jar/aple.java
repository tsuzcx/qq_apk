import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.ar.ScanningData;

public class aple
  extends ScanningData
{
  private long jdField_a_of_type_Long;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_b_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_c_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_c_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_d_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_d_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_e_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_e_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_f_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_f_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_g_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_g_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_h_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_h_of_type_AndroidAnimationObjectAnimator;
  
  public aple(Context paramContext)
  {
    super(paramContext);
    l();
    a();
  }
  
  private void l()
  {
    this.jdField_b_of_type_Boolean = true;
    this.i = (bhtq.a(1.5F) * this.jdField_c_of_type_Float);
    this.jdField_e_of_type_Int = -1;
  }
  
  public void a()
  {
    d();
    e();
    f();
    g();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = true;
    l();
    b(paramBoolean);
    h();
    i();
    if (!this.jdField_e_of_type_Boolean)
    {
      j();
      k();
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_c_of_type_Boolean)
    {
      this.i = bhtq.a(5.0F);
      return;
    }
    this.i = bhtq.a(1.5F);
  }
  
  @TargetApi(11)
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_e_of_type_Boolean)) {}
    for (this.jdField_a_of_type_Long = 3666L;; this.jdField_a_of_type_Long = 0L)
    {
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.setStartDelay(this.jdField_a_of_type_Long);
      }
      if (this.jdField_b_of_type_AndroidAnimationAnimatorSet != null) {
        this.jdField_b_of_type_AndroidAnimationAnimatorSet.setStartDelay(this.jdField_a_of_type_Long);
      }
      if (this.jdField_c_of_type_AndroidAnimationAnimatorSet != null) {
        this.jdField_c_of_type_AndroidAnimationAnimatorSet.setStartDelay(this.jdField_a_of_type_Long);
      }
      if (this.jdField_d_of_type_AndroidAnimationAnimatorSet != null) {
        this.jdField_d_of_type_AndroidAnimationAnimatorSet.setStartDelay(this.jdField_a_of_type_Long);
      }
      if (this.jdField_e_of_type_AndroidAnimationAnimatorSet != null) {
        this.jdField_e_of_type_AndroidAnimationAnimatorSet.setStartDelay(this.jdField_a_of_type_Long + 320L);
      }
      if (this.jdField_f_of_type_AndroidAnimationAnimatorSet != null) {
        this.jdField_f_of_type_AndroidAnimationAnimatorSet.setStartDelay(this.jdField_a_of_type_Long + 320L);
      }
      if (this.jdField_g_of_type_AndroidAnimationAnimatorSet != null) {
        this.jdField_g_of_type_AndroidAnimationAnimatorSet.setStartDelay(this.jdField_a_of_type_Long + 800L);
      }
      if (this.jdField_h_of_type_AndroidAnimationAnimatorSet != null) {
        this.jdField_h_of_type_AndroidAnimationAnimatorSet.setStartDelay(this.jdField_a_of_type_Long + 800L);
      }
      return;
    }
  }
  
  @TargetApi(11)
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
    }
    if ((this.jdField_b_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_b_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.end();
    }
    if ((this.jdField_c_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_c_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_c_of_type_AndroidAnimationAnimatorSet.end();
    }
    if ((this.jdField_d_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_d_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_d_of_type_AndroidAnimationAnimatorSet.end();
    }
    if ((this.jdField_e_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_e_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_e_of_type_AndroidAnimationAnimatorSet.end();
    }
    if ((this.jdField_f_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_f_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_f_of_type_AndroidAnimationAnimatorSet.end();
    }
    if ((this.jdField_g_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_g_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_g_of_type_AndroidAnimationAnimatorSet.end();
    }
    if ((this.jdField_h_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_h_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_h_of_type_AndroidAnimationAnimatorSet.end();
    }
  }
  
  @TargetApi(11)
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCAlpha", new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(600L);
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(this.jdField_a_of_type_AndroidAnimationObjectAnimator);
    }
    if (this.jdField_b_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 0.0F, -360.0F });
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.setDuration(18000L);
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    }
    if (this.jdField_b_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.play(this.jdField_b_of_type_AndroidAnimationObjectAnimator);
    }
  }
  
  @TargetApi(11)
  public void e()
  {
    if (this.jdField_c_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_c_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "iBCAlpha", new float[] { 0.0F, 1.0F });
      this.jdField_c_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_c_of_type_AndroidAnimationObjectAnimator.setDuration(600L);
    }
    if (this.jdField_c_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_c_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_c_of_type_AndroidAnimationAnimatorSet.play(this.jdField_c_of_type_AndroidAnimationObjectAnimator);
    }
    if (this.jdField_d_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_d_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { 0.0F, 360.0F });
      this.jdField_d_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_d_of_type_AndroidAnimationObjectAnimator.setDuration(18000L);
      this.jdField_d_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    }
    if (this.jdField_d_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_d_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_d_of_type_AndroidAnimationAnimatorSet.play(this.jdField_d_of_type_AndroidAnimationObjectAnimator);
    }
  }
  
  @TargetApi(11)
  public void f()
  {
    if (this.jdField_e_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_e_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "fNCHAlpha", new float[] { 0.0F, 1.0F });
      this.jdField_e_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_e_of_type_AndroidAnimationObjectAnimator.setDuration(400L);
    }
    if (this.jdField_e_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_e_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_e_of_type_AndroidAnimationAnimatorSet.play(this.jdField_e_of_type_AndroidAnimationObjectAnimator);
    }
    if (this.jdField_f_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_f_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "fLAlpha", new float[] { 0.0F, 1.0F });
      this.jdField_f_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_f_of_type_AndroidAnimationObjectAnimator.setDuration(200L);
    }
    if (this.jdField_f_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_f_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_f_of_type_AndroidAnimationAnimatorSet.play(this.jdField_f_of_type_AndroidAnimationObjectAnimator);
    }
  }
  
  @TargetApi(11)
  public void g()
  {
    if (this.jdField_g_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_g_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "fCPositionY", new float[] { -bhtq.a(25.0F), 0.0F });
      this.jdField_g_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_g_of_type_AndroidAnimationObjectAnimator.setDuration(280L);
    }
    if (this.jdField_g_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_g_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_g_of_type_AndroidAnimationAnimatorSet.play(this.jdField_g_of_type_AndroidAnimationObjectAnimator);
    }
    if (this.jdField_h_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_h_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "fCAlpha", new float[] { 0.0F, 1.0F });
      this.jdField_h_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_h_of_type_AndroidAnimationObjectAnimator.setDuration(280L);
    }
    if (this.jdField_h_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_h_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_h_of_type_AndroidAnimationAnimatorSet.play(this.jdField_h_of_type_AndroidAnimationObjectAnimator);
    }
  }
  
  @TargetApi(11)
  public void h()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    }
    if (this.jdField_b_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void i()
  {
    if (this.jdField_c_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_c_of_type_AndroidAnimationAnimatorSet.start();
    }
    if (this.jdField_d_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_d_of_type_AndroidAnimationAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void j()
  {
    if (this.jdField_e_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_e_of_type_AndroidAnimationAnimatorSet.start();
    }
    if (this.jdField_f_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_f_of_type_AndroidAnimationAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void k()
  {
    if (this.jdField_g_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_g_of_type_AndroidAnimationAnimatorSet.start();
    }
    if (this.jdField_h_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_h_of_type_AndroidAnimationAnimatorSet.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aple
 * JD-Core Version:    0.7.0.1
 */