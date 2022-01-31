import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.Vas.ColorFont.FounderColorLayout;
import com.etrump.mixlayout.ETTextView;

public class b
  implements ValueAnimator.AnimatorUpdateListener
{
  public b(FounderColorLayout paramFounderColorLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= this.a.jdField_a_of_type_ArrayOfInt[0])
    {
      FounderColorLayout.a(this.a).cancel();
      this.a.jdField_a_of_type_Int = 0;
      FounderColorLayout.a(this.a, 0L);
      FounderColorLayout.a(this.a).mShouldDisplayAnimation = false;
      FounderColorLayout.a(this.a).h = false;
      FounderColorLayout.a(this.a).invalidate();
    }
    while (i <= this.a.jdField_a_of_type_Int) {
      return;
    }
    this.a.jdField_a_of_type_Int = i;
    FounderColorLayout.a(this.a).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     b
 * JD-Core Version:    0.7.0.1
 */