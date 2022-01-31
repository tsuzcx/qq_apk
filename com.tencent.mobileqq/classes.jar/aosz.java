import android.media.MediaPlayer;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import mqq.os.MqqHandler;

public class aosz
  implements Runnable
{
  public aosz(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void run()
  {
    Message localMessage;
    if ((this.a.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) && (this.a.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.a.jdField_a_of_type_AndroidViewSurfaceView != null))
    {
      localMessage = Message.obtain();
      localMessage.arg1 = this.a.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "此时时间为+" + localMessage.arg1);
      }
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localMessage.arg1);
      if (this.a.jdField_a_of_type_MqqOsMqqHandler != null) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    this.a.jdField_a_of_type_MqqOsMqqHandler.post(this.a.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aosz
 * JD-Core Version:    0.7.0.1
 */