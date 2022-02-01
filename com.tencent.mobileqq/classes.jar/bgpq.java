import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.TroopGameCardView;

public class bgpq
  implements ValueAnimator.AnimatorUpdateListener
{
  public bgpq(TroopGameCardView paramTroopGameCardView, TextView paramTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpq
 * JD-Core Version:    0.7.0.1
 */