import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneAudioRecordPlugin.SimpleAACRecorder;

public class ammb
  implements MediaRecorder.OnErrorListener
{
  public ammb(QzoneAudioRecordPlugin.SimpleAACRecorder paramSimpleAACRecorder) {}
  
  public void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    paramMediaRecorder = "(code = " + paramInt1 + ", extra = " + paramInt2 + ")";
    QzoneAudioRecordPlugin.SimpleAACRecorder.a(this.a, paramInt1, paramMediaRecorder);
    QLog.w("QzoneVoiceRecordPlugin.SimpleRecorder", 1, "MediaRecorder error " + paramMediaRecorder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammb
 * JD-Core Version:    0.7.0.1
 */