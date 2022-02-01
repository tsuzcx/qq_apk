import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class bocp
  implements ValueAnimator.AnimatorUpdateListener
{
  public bocp(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((AEEditorAILoadingView.a(this.a) >= 2) && (AEEditorAILoadingView.a(this.a)))
    {
      AEEditorAILoadingView.a(this.a, false);
      AEEditorAILoadingView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocp
 * JD-Core Version:    0.7.0.1
 */