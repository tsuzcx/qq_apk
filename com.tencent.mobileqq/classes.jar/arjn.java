import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.qphone.base.util.QLog;

public class arjn
  implements ValueAnimator.AnimatorUpdateListener
{
  public arjn(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue("alpha")).floatValue();
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setAlpha(f);
    f = ((Float)paramValueAnimator.getAnimatedValue("translate")).floatValue();
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setTranslationY(f);
    f = paramValueAnimator.getAnimatedFraction();
    if ((!this.a.c) && (f >= 0.8857143F))
    {
      this.a.c = true;
      this.a.jdField_a_of_type_Befq.sendEmptyMessage(4);
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "send MSG_START_3D_ROTATE");
      }
    }
    if (f >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arjn
 * JD-Core Version:    0.7.0.1
 */