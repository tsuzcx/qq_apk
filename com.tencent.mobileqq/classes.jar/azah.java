import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ListView;

class azah
  implements ValueAnimator.AnimatorUpdateListener
{
  azah(azag paramazag) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    azag.a(this.a).setPadding(baxn.a(azag.a(this.a).getContext(), 8.0F), i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azah
 * JD-Core Version:    0.7.0.1
 */