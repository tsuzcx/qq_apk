import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

public class bjdh
  implements MediaPlayer.OnPreparedListener
{
  public bjdh(ShortVideoPreviewActivity paramShortVideoPreviewActivity, int paramInt) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared: mDuration=" + this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_b_of_type_Long);
    }
    paramMediaPlayer = this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    if ((paramMediaPlayer == null) || (!paramMediaPlayer.getSurface().isValid()))
    {
      apcb.a(2131625742);
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.f();
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.c) && (this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(paramMediaPlayer);
      this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
      if (this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_Int > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreviewActivity", 2, "此时的时长为" + ShortVideoUtils.a(this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_Int));
        }
        this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.d.setText(ShortVideoUtils.a(this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_Int));
        this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjdh
 * JD-Core Version:    0.7.0.1
 */