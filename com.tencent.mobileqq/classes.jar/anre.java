import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

class anre
  implements ImageAssetDelegate
{
  anre(anrd paramanrd) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (this.a.a.a() == null) {
      return null;
    }
    return (Bitmap)this.a.a.a().get(paramLottieImageAsset.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anre
 * JD-Core Version:    0.7.0.1
 */