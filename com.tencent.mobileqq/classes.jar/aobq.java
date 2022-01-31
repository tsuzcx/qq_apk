import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.SecondDemoView;
import java.util.ArrayList;

public class aobq
  implements ValueAnimator.AnimatorUpdateListener
{
  public aobq(SecondDemoView paramSecondDemoView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (ArrayList)paramValueAnimator.getAnimatedValue();
    this.a.a = paramValueAnimator;
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aobq
 * JD-Core Version:    0.7.0.1
 */