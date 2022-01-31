import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;

public class apxl
  implements ValueAnimator.AnimatorUpdateListener
{
  public apxl(HorizontalListViewEx paramHorizontalListViewEx, View paramView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.jdField_a_of_type_Int = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.jdField_a_of_type_Int += this.jdField_a_of_type_AndroidViewView.getLeft() - this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.jdField_a_of_type_Int == this.jdField_a_of_type_AndroidViewView.getLeft()) {
      HorizontalListViewEx.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxl
 * JD-Core Version:    0.7.0.1
 */