import android.view.SurfaceHolder;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;

public class azbd
  implements IVideoViewBase.IVideoViewCallBack
{
  public azbd(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceDestory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azbd
 * JD-Core Version:    0.7.0.1
 */