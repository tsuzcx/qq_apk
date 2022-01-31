import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.qphone.base.util.QLog;

public class aoaf
  implements ValueAnimator.AnimatorUpdateListener
{
  public aoaf(EmotionKeywordLayout paramEmotionKeywordLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "hide:offset=" + f);
    }
    if (EmotionKeywordLayout.a(this.a) != null) {
      EmotionKeywordLayout.a(this.a).setTranslationY(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoaf
 * JD-Core Version:    0.7.0.1
 */