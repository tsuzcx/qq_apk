import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;

public class awpe
  implements ValueAnimator.AnimatorUpdateListener
{
  public awpe(MusicPanelView paramMusicPanelView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    MusicPanelView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpe
 * JD-Core Version:    0.7.0.1
 */