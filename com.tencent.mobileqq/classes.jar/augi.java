import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class augi
  implements OnCompositionLoadedListener
{
  augi(augh paramaugh, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setImageAssetDelegate(new augj(this));
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    augh.a(this.jdField_a_of_type_Augh).setImageDrawable(localLottieDrawable);
    augh.a(this.jdField_a_of_type_Augh, localLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     augi
 * JD-Core Version:    0.7.0.1
 */