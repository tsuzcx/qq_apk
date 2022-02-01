import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView;

public class bpeq
  implements ValueAnimator.AnimatorUpdateListener
{
  public bpeq(AEEditorApplyAllLoadingView paramAEEditorApplyAllLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpeq
 * JD-Core Version:    0.7.0.1
 */