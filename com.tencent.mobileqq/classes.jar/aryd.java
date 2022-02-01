import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.widget.XPanelContainer;

class aryd
  implements ValueAnimator.AnimatorUpdateListener
{
  aryd(aryb paramaryb, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    XPanelContainer.jdField_a_of_type_Int = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (aryb.a(this.jdField_a_of_type_Aryb).getParent() != null) {
      aryb.a(this.jdField_a_of_type_Aryb).getParent().requestLayout();
    }
    if ((this.jdField_a_of_type_Int == aryb.a(this.jdField_a_of_type_Aryb)) && (XPanelContainer.jdField_a_of_type_Int == aryb.a(this.jdField_a_of_type_Aryb))) {
      this.jdField_a_of_type_Aryb.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryd
 * JD-Core Version:    0.7.0.1
 */