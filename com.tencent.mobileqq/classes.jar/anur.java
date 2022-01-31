import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.music.QQMusicPlayerScene;
import java.util.TimerTask;

public class anur
  extends TimerTask
{
  private anur(QQMusicPlayerScene paramQQMusicPlayerScene) {}
  
  public void run()
  {
    this.a.a.sendEmptyMessage(1);
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlayerScene", 2, "MyMusicTimerTask MSG_MUSIC_REPLAY");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anur
 * JD-Core Version:    0.7.0.1
 */