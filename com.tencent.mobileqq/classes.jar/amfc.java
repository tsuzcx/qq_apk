import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.icebreaking.AIOIceBreakShow;
import com.tencent.widget.AbsListView.LayoutParams;

public class amfc
  implements ValueAnimator.AnimatorUpdateListener
{
  public amfc(AIOIceBreakShow paramAIOIceBreakShow) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (AIOIceBreakShow.a(this.a) == null) {
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("height")).intValue();
    AIOIceBreakShow.a(this.a).setAlpha(i / 100.0F);
    paramValueAnimator = AIOIceBreakShow.a(this.a).a();
    ((AbsListView.LayoutParams)paramValueAnimator.getLayoutParams()).height = j;
    paramValueAnimator.requestLayout();
    AIOIceBreakShow.a(this.a).scrollTo(0, j - AIOIceBreakShow.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfc
 * JD-Core Version:    0.7.0.1
 */