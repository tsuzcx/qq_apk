import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.troop.widget.TroopGameCardView;

public class bgpt
  implements ValueAnimator.AnimatorUpdateListener
{
  public bgpt(TroopGameCardView paramTroopGameCardView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue("startColor")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("endColor")).intValue();
    TroopGameCardView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopGameCardView, this.jdField_a_of_type_AndroidViewView, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpt
 * JD-Core Version:    0.7.0.1
 */