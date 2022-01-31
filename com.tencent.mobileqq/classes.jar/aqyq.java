import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;

public class aqyq
  implements ValueAnimator.AnimatorUpdateListener
{
  public aqyq(MusicPanelView paramMusicPanelView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    MusicPanelView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqyq
 * JD-Core Version:    0.7.0.1
 */