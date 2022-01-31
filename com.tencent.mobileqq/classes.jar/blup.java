import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class blup
  implements blun
{
  private File a;
  
  public void a()
  {
    if ((this.a == null) || (!this.a.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VoiceBgmRecognizer", 2, "recognize: invoked. info: mTargetAudioFile = " + this.a);
      }
      return;
    }
    blur localblur = (blur)blqr.a().c(10);
    localblur.a(this.a);
    try
    {
      blud.a(this.a.getAbsolutePath(), this.a.getAbsolutePath() + "_8kHz", localblur);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      QLog.d("VoiceBgmRecognizer", 1, String.format("e = %s", new Object[] { localFFmpegCommandAlreadyRunningException }));
    }
  }
  
  public void a(File paramFile)
  {
    this.a = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blup
 * JD-Core Version:    0.7.0.1
 */