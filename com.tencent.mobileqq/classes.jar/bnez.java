import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import mqq.os.MqqHandler;

public class bnez
  extends MqqHandler
{
  public bnez(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QQToast.a(this.a, 2131720097, 0).a();
          return;
          String str = this.a.getString(2131720098);
          paramMessage = (String)paramMessage.obj;
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2, str + paramMessage, 0).a();
          bdda.a(this.a, paramMessage);
          return;
          paramMessage = bdcd.a(this.a.jdField_a_of_type_AndroidContentContext, 232, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720130), this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720129), 2131720112, 2131719197, new bnfa(this), new bnfb(this));
          ShortVideoPlayActivity.a(this.a, paramMessage);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "...mobile/none => wifi...");
          }
        } while (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
        this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "...wifi/none => mobile...");
        }
        if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
          this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(2);
        }
        if ((this.a.b != 1) && (this.a.b != 2)) {
          break;
        }
      } while (!this.a.b());
      this.a.j();
      this.a.r();
      return;
    } while (this.a.b != 0);
    ShortVideoPlayActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnez
 * JD-Core Version:    0.7.0.1
 */