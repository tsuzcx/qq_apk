import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class blgq
  implements ValueAnimator.AnimatorUpdateListener
{
  public blgq(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AEEditorAILoadingView.a(this.a).setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgq
 * JD-Core Version:    0.7.0.1
 */