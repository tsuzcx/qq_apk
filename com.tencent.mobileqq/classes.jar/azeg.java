import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class azeg
  implements OnCompositionLoadedListener
{
  azeg(azef paramazef, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setImageAssetDelegate(new azeh(this));
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    azef.a(this.jdField_a_of_type_Azef).setImageDrawable(localLottieDrawable);
    azef.a(this.jdField_a_of_type_Azef, localLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azeg
 * JD-Core Version:    0.7.0.1
 */