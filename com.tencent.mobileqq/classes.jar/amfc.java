import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;

class amfc
  implements ValueAnimator.AnimatorUpdateListener
{
  amfc(amfb paramamfb, ItemTouchHelper paramItemTouchHelper) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Amfb.a(paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amfc
 * JD-Core Version:    0.7.0.1
 */