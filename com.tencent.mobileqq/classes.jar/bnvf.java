import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class bnvf
  implements ValueAnimator.AnimatorUpdateListener
{
  public bnvf(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(AEEditorAILoadingView.a(1000.0F, paramValueAnimator.getAnimatedFraction(), 0.0F, 1.0F) * 75.0F - 75.0F);
    AEEditorAILoadingView.b(this.a).setPadding(0, i, 0, 0);
    AEEditorAILoadingView.c(this.a).setPadding(0, i, 0, 0);
    paramValueAnimator = (ViewGroup.MarginLayoutParams)AEEditorAILoadingView.b(this.a).getLayoutParams();
    paramValueAnimator.topMargin = (i + AEEditorAILoadingView.b(this.a));
    AEEditorAILoadingView.b(this.a).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvf
 * JD-Core Version:    0.7.0.1
 */