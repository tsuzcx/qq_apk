import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView;

public class bnvu
  implements ValueAnimator.AnimatorUpdateListener
{
  public bnvu(AEEditorApplyAllLoadingView paramAEEditorApplyAllLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvu
 * JD-Core Version:    0.7.0.1
 */