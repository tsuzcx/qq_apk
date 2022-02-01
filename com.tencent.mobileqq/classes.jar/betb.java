import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

public class betb
  implements ISPlayerVideoView.IVideoViewCallBack
{
  public betb(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceDestory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betb
 * JD-Core Version:    0.7.0.1
 */