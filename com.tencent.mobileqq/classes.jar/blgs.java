import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView;

public class blgs
  implements ValueAnimator.AnimatorUpdateListener
{
  public blgs(AEEditorApplyAllLoadingView paramAEEditorApplyAllLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AEEditorApplyAllLoadingView.a(this.a).setPadding(0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue(), 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgs
 * JD-Core Version:    0.7.0.1
 */