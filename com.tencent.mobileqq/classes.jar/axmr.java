import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;

public class axmr
  implements ImageAssetDelegate
{
  public axmr(QEffectLottieImageView paramQEffectLottieImageView) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (BaseApplicationImpl.sImageCache != null) {
      return (Bitmap)BaseApplicationImpl.sImageCache.get(paramLottieImageAsset.getKey());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axmr
 * JD-Core Version:    0.7.0.1
 */