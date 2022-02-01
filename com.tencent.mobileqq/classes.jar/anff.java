import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

class anff
  implements ISPlayerVideoView.IVideoViewCallBack
{
  anff(anfe paramanfe) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onSurfaceChanged]");
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onSurfaceCreated]");
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onSurfaceDestroy]");
    anfe.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anff
 * JD-Core Version:    0.7.0.1
 */