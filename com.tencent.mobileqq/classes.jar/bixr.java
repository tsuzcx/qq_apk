import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView;
import dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment;

public class bixr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bixr(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      AEVideoShelfPreviewFragment.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      AEVideoShelfPreviewFragment.a(this.a).updateVideoSize(AEVideoShelfPreviewFragment.a(this.a).getVideoWidth(), AEVideoShelfPreviewFragment.a(this.a).getVideoHeight());
      return;
      AEVideoShelfPreviewFragment.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bixr
 * JD-Core Version:    0.7.0.1
 */