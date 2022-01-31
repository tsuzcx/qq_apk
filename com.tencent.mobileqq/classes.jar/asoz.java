import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;

public class asoz
  implements ValueAnimator.AnimatorUpdateListener
{
  public asoz(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramValueAnimator.leftMargin = (this.jdField_a_of_type_Int + Math.round((this.b - this.jdField_a_of_type_Int) * f1));
    paramValueAnimator.topMargin = (this.c + Math.round((this.d - this.c) * f1));
    paramValueAnimator.width = (this.e + Math.round((this.f - this.e) * f1));
    int i = this.g;
    int j = MultiAIOFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment).getHeight() - MultiAIOFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment).getPaddingTop() - MultiAIOFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment).getPaddingBottom();
    if (j > 0) {
      i = j;
    }
    for (;;)
    {
      j = this.h;
      paramValueAnimator.height = (Math.round((i - this.h) * f1) + j);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramValueAnimator);
      this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asoz
 * JD-Core Version:    0.7.0.1
 */