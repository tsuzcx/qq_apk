import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.RelativeLayout;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class bnjd
  implements ValueAnimator.AnimatorUpdateListener
{
  public bnjd(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((this.a.a.getVisibility() == 0) && (Math.abs(this.a.a.getAlpha() - f) >= 0.02F)) {
        this.a.a.setAlpha(f);
      }
      if ((this.a.c.getVisibility() == 0) && (Math.abs(this.a.a.getAlpha() - f) >= 0.02F)) {
        this.a.c.setAlpha(Float.valueOf(f).floatValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjd
 * JD-Core Version:    0.7.0.1
 */