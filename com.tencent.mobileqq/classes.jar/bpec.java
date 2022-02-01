import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class bpec
  implements ValueAnimator.AnimatorUpdateListener
{
  public bpec(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpec
 * JD-Core Version:    0.7.0.1
 */