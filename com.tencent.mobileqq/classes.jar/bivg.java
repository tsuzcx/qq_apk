import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v4.view.PagerAdapter;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;

public class bivg
{
  public float a;
  private int jdField_a_of_type_Int = 200;
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  
  public bivg(BounceViewPager paramBounceViewPager)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = paramBounceViewPager;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager, "Pull", new float[] { this.jdField_a_of_type_Float, 0.0F });
    this.jdField_a_of_type_AndroidAnimationAnimator.setInterpolator(new DecelerateInterpolator());
    float f = Math.abs(-this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidAnimationAnimator.setDuration((f * this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new bivh(this));
    this.jdField_a_of_type_AndroidAnimationAnimator.start();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Float < 0.0F)) {}
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getAdapter().getCount() - 1 == this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem()) {}
      for (int i = 1; (i == 0) || (this.jdField_a_of_type_Float <= 0.0F); i = 0) {
        return false;
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new bivi(this));
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bivg
 * JD-Core Version:    0.7.0.1
 */