import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.6;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.6.1.1;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

public class aquq
  implements OnCompositionLoadedListener
{
  public aquq(ColorNoteSmallScreenRelativeLayout.6 param6) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      QLog.e("ColorNoteSmallScreenRelativeLayout", 1, "getLottieDrawable onCompositionLoaded failed");
      return;
    }
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.setImagesAssetsFolder(this.a.b);
    ColorNoteSmallScreenRelativeLayout.a(this.a.this$0, localLottieDrawable);
    ThreadManagerV2.getUIHandlerV2().post(new ColorNoteSmallScreenRelativeLayout.6.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aquq
 * JD-Core Version:    0.7.0.1
 */