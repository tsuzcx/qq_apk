import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneAudioRecordPlugin.SimpleAACRecorder;

public class ancf
  implements MediaRecorder.OnInfoListener
{
  public ancf(QzoneAudioRecordPlugin.SimpleAACRecorder paramSimpleAACRecorder) {}
  
  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      QLog.i("QzoneVoiceRecordPlugin.SimpleRecorder", 4, "start|onInfo|what=" + paramInt1 + ",extra=" + paramInt2);
      return;
    case 801: 
      QLog.i("QzoneVoiceRecordPlugin.SimpleRecorder", 4, "start|onInfo|max file size reached.extra=" + paramInt2);
      this.a.a();
      return;
    }
    QLog.i("QzoneVoiceRecordPlugin.SimpleRecorder", 4, "start|onInfo|max duration reached.extra=" + paramInt2);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancf
 * JD-Core Version:    0.7.0.1
 */