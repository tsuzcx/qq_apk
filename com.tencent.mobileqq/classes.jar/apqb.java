import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.6.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class apqb
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  apqb(appt paramappt) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    long l1 = 0L;
    this.a.jdField_a_of_type_Aprb.i(false);
    long l2 = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 4, "Video Total Time:" + l2);
    }
    paramTVK_IMediaPlayer = this.a;
    if (l2 < 0L) {}
    for (;;)
    {
      appt.a(paramTVK_IMediaPlayer, l1);
      this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.6.1(this));
      return;
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apqb
 * JD-Core Version:    0.7.0.1
 */