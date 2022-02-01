import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ListView;

class bfco
  implements ValueAnimator.AnimatorUpdateListener
{
  bfco(bfcn parambfcn) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    bfcn.a(this.a).setPadding(bhgr.a(bfcn.a(this.a).getContext(), 8.0F), i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfco
 * JD-Core Version:    0.7.0.1
 */