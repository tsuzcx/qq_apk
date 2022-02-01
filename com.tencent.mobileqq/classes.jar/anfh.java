import android.view.SurfaceHolder;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;

class anfh
  implements IVideoViewBase.IVideoViewCallBack
{
  anfh(anfg paramanfg) {}
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    anfg.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfh
 * JD-Core Version:    0.7.0.1
 */