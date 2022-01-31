import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public final class arzs
  extends Handler
{
  public arzs(QQPlayerService paramQQPlayerService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      QQPlayerService.a(this.a, (Intent)paramMessage.obj);
    }
    for (;;)
    {
      return;
      try
      {
        BaseApplicationImpl.getContext().unregisterReceiver(QQPlayerService.a(this.a));
        paramMessage = (arzr)paramMessage.obj;
        if (paramMessage == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QQPlayerService", 2, "release player");
        }
        if (paramMessage.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          paramMessage.jdField_a_of_type_AndroidMediaMediaPlayer.release();
          if (QQPlayerService.a() == paramMessage.jdField_a_of_type_AndroidMediaMediaPlayer) {
            QQPlayerService.a(null);
          }
        }
        if (paramMessage.jdField_a_of_type_AndroidOsLooper != null) {
          paramMessage.jdField_a_of_type_AndroidOsLooper.quit();
        }
        if (QQPlayerService.d() != paramMessage.jdField_a_of_type_ComTencentMobileqqMusicSongInfo) {
          continue;
        }
        QQPlayerService.a(null);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onDestroy unregisterReceiver exception ");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     arzs
 * JD-Core Version:    0.7.0.1
 */