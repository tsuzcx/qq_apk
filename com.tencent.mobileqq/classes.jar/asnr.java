import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.widget.XPanelContainer;

class asnr
  implements ValueAnimator.AnimatorUpdateListener
{
  asnr(asnp paramasnp, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    XPanelContainer.jdField_a_of_type_Int = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (asnp.a(this.jdField_a_of_type_Asnp).getParent() != null) {
      asnp.a(this.jdField_a_of_type_Asnp).getParent().requestLayout();
    }
    if ((this.jdField_a_of_type_Int == asnp.a(this.jdField_a_of_type_Asnp)) && (XPanelContainer.jdField_a_of_type_Int == asnp.a(this.jdField_a_of_type_Asnp))) {
      this.jdField_a_of_type_Asnp.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnr
 * JD-Core Version:    0.7.0.1
 */