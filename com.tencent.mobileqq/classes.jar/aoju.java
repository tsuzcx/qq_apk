import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

public class aoju
  implements Runnable
{
  public aoju(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    if (this.a.b())
    {
      if (this.a.b <= 0L) {
        this.a.h();
      }
      ShortVideoPlayActivity.a(this.a, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      if (ShortVideoPlayActivity.a(this.a) != 0L)
      {
        ShortVideoPlayActivity.a(this.a, (int)(ShortVideoPlayActivity.a(this.a) * 10000L / this.a.b + 0.5D));
        if (!ShortVideoPlayActivity.a(this.a))
        {
          this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(ShortVideoPlayActivity.a(this.a));
          this.a.b(ShortVideoPlayActivity.a(this.a));
        }
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.a.g != 0L))
    {
      if (!this.a.jdField_f_of_type_Boolean) {
        break label352;
      }
      ShortVideoPlayActivity.b(this.a, (int)(this.a.jdField_f_of_type_Long * 10000L / this.a.g));
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetSeekBar.getSecondaryProgress() != ShortVideoPlayActivity.b(this.a)) {
        this.a.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(ShortVideoPlayActivity.b(this.a));
      }
      if ((this.a.c()) && (ShortVideoPlayActivity.c(this.a) > 0) && (ShortVideoPlayActivity.a(this.a) != null) && (ShortVideoPlayActivity.a(this.a).getVisibility() == 0))
      {
        String str = ShortVideoUtils.a(this.a.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.c(this.a) * 1024);
        ShortVideoPlayActivity.a(this.a).setText(str + "/s");
      }
      if (!this.a.isFinishing()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "check progress, while finishing");
      }
      return;
      label352:
      ShortVideoPlayActivity.b(this.a, 10000);
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoju
 * JD-Core Version:    0.7.0.1
 */