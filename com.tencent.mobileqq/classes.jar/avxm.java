import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class avxm
  implements OnCompositionLoadedListener
{
  avxm(avxl paramavxl, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setImageAssetDelegate(new avxn(this));
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    avxl.a(this.jdField_a_of_type_Avxl).setImageDrawable(localLottieDrawable);
    avxl.a(this.jdField_a_of_type_Avxl, localLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avxm
 * JD-Core Version:    0.7.0.1
 */