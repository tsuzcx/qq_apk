import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.qphone.base.util.QLog;

public class aspi
  implements ValueAnimator.AnimatorUpdateListener
{
  public aspi(EmotionKeywordLayout paramEmotionKeywordLayout) {}
  
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
 * Qualified Name:     aspi
 * JD-Core Version:    0.7.0.1
 */