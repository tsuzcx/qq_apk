import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import dov.com.tencent.mobileqq.richmedia.capture.view.GuideVideoView;

public class aovh
  implements Runnable
{
  public aovh(GuideVideoView paramGuideVideoView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onVideoPrepared");
    }
    this.a.a = true;
    if (this.a.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "has triggered start, now start");
      }
      GuideVideoView.a(this.a).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aovh
 * JD-Core Version:    0.7.0.1
 */