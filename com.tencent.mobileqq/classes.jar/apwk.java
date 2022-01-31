import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.qphone.base.util.QLog;

public class apwk
  implements ValueAnimator.AnimatorUpdateListener
{
  public apwk(EmotionKeywordLayout paramEmotionKeywordLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "show:offset=" + f);
    }
    if (EmotionKeywordLayout.a(this.a) != null) {
      EmotionKeywordLayout.a(this.a).setTranslationY(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwk
 * JD-Core Version:    0.7.0.1
 */