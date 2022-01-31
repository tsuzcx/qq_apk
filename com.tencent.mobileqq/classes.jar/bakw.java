import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

public class bakw
  implements ImageAssetDelegate
{
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (BaseApplicationImpl.sImageCache != null) {
      return (Bitmap)BaseApplicationImpl.sImageCache.get(paramLottieImageAsset.getKey());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakw
 * JD-Core Version:    0.7.0.1
 */