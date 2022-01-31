import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;

public class anxi
  implements ValueAnimator.AnimatorUpdateListener
{
  public anxi(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.w = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxi
 * JD-Core Version:    0.7.0.1
 */