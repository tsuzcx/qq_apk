import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.qqmini.sdk.utils.DisplayUtil;

public class bgpe
{
  public static Animation a(Context paramContext, int paramInt1, int paramInt2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(paramInt1, paramInt2, 0.0F, 0.0F);
    localTranslateAnimation.setDuration((Math.abs(paramInt2 - paramInt1) * 1.0F / DisplayUtil.getScreenWidth(paramContext) * 3000.0F));
    localTranslateAnimation.setInterpolator(new bgpj());
    localTranslateAnimation.setFillAfter(true);
    return localTranslateAnimation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgpe
 * JD-Core Version:    0.7.0.1
 */