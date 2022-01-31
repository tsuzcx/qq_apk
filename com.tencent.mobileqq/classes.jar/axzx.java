import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ListView;

class axzx
  implements ValueAnimator.AnimatorUpdateListener
{
  axzx(axzw paramaxzw) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    axzw.a(this.a).setPadding(azvv.a(axzw.a(this.a).getContext(), 8.0F), i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axzx
 * JD-Core Version:    0.7.0.1
 */