import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class bdxw
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public bdxw(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "Completion video000");
    }
    paramTVK_IMediaPlayer.seekTo(0);
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "Completion video");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxw
 * JD-Core Version:    0.7.0.1
 */