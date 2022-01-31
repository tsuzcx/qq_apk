import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

class apqr
  implements ValueAnimator.AnimatorUpdateListener
{
  apqr(apqq paramapqq, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == this.jdField_a_of_type_Int) {
      AbstractGifImage.resumeAll();
    }
    com.tencent.widget.XPanelContainer.jdField_a_of_type_Int = i;
    if (apqq.a(this.jdField_a_of_type_Apqq).getParent() != null) {
      apqq.a(this.jdField_a_of_type_Apqq).getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqr
 * JD-Core Version:    0.7.0.1
 */