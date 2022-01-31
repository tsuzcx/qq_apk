import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable;
import java.util.ArrayList;

public class aobo
  implements ValueAnimator.AnimatorUpdateListener
{
  public aobo(InfoStickerDrawable paramInfoStickerDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (ArrayList)paramValueAnimator.getAnimatedValue();
    this.a.a = paramValueAnimator;
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aobo
 * JD-Core Version:    0.7.0.1
 */