import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ListView;
import com.tencent.mobileqq.util.DisplayUtil;

class besh
  implements ValueAnimator.AnimatorUpdateListener
{
  besh(bese parambese) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    bese.a(this.a).setPadding(DisplayUtil.dip2px(bese.a(this.a).getContext(), 8.0F), i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besh
 * JD-Core Version:    0.7.0.1
 */