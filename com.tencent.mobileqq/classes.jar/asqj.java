import android.widget.ImageView;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;

class asqj
  implements ValueAnimator.AnimatorUpdateListener
{
  asqj(asqh paramasqh) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    if (this.a.a.getVisibility() == 0) {
      this.a.a.setAlpha(f);
    }
    HotVideoMongoliaRelativeLayout localHotVideoMongoliaRelativeLayout = this.a.a();
    if (localHotVideoMongoliaRelativeLayout != null) {
      localHotVideoMongoliaRelativeLayout.a(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqj
 * JD-Core Version:    0.7.0.1
 */