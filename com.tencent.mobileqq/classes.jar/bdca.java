import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.engine.QEffectData;

public class bdca
  implements OnCompositionLoadedListener
{
  public bdca(QEffectLottieImageView paramQEffectLottieImageView) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if ((QLog.isColorLevel()) || (paramLottieComposition == null)) {
      QLog.e("QEffectLottieImageView", 1, "onCompositionLoaded: composition= " + paramLottieComposition);
    }
    if (paramLottieComposition == null) {
      return;
    }
    if (QEffectLottieImageView.a(this.a))
    {
      QLog.e("QEffectLottieImageView", 1, "onCompositionLoaded: mIsStop " + QEffectLottieImageView.a(this.a));
      return;
    }
    this.a.cancelAnimation();
    this.a.setComposition(paramLottieComposition);
    this.a.setProgress(0.0F);
    this.a.setRepeatCount(QEffectLottieImageView.a(this.a).repeat);
    this.a.setVisibility(0);
    this.a.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdca
 * JD-Core Version:    0.7.0.1
 */