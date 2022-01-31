import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.CaptureComboMusic;
import dov.com.qq.im.capture.music.MusicDownloadListener;

public class anug
  extends MusicDownloadListener
{
  public anug(CaptureComboMusic paramCaptureComboMusic) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String arg1, int paramInt)
  {
    synchronized (this.a)
    {
      this.a.a.c = paramInt;
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicDownloadListener", 2, "notifyDownloadFinish key: " + paramString + ", success " + paramBoolean);
    }
    paramString = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.a.a.c = 100;
        this.a.b();
        return;
      }
      finally {}
      this.a.a.c = -1;
      this.a.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anug
 * JD-Core Version:    0.7.0.1
 */