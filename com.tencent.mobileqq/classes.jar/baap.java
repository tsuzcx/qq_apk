import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader;

public class baap
  implements ImageAssetDelegate
{
  public baap(ProfileColorScreenComponent.ColorScreenLoader paramColorScreenLoader) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    return (Bitmap)BaseApplicationImpl.sImageCache.get(paramLottieImageAsset.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baap
 * JD-Core Version:    0.7.0.1
 */