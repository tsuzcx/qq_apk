import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class bpee
  implements ValueAnimator.AnimatorUpdateListener
{
  public bpee(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AEEditorAILoadingView.c(this.a).setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpee
 * JD-Core Version:    0.7.0.1
 */