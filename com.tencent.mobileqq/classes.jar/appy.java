import android.annotation.TargetApi;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class appy
  implements SeekBar.OnSeekBarChangeListener
{
  appy(appt paramappt) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      appt.a(this.a, appt.b(this.a, paramInt));
      this.a.jdField_a_of_type_Aprb.b(appt.a(this.a));
      if (QLog.isDevelopLevel()) {
        QLog.d("#@#@", 1, "onProgressChanged userPos[" + appt.a(this.a) + "]");
      }
    }
  }
  
  @TargetApi(16)
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (!this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    appt.c(this.a);
    appt.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
    this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    this.a.jdField_a_of_type_Aprb.a(null);
    appt.a(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("##########", 1, "mMediaPlayer sekTo [" + appt.a(this.a) + "]");
    }
    this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(appt.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appy
 * JD-Core Version:    0.7.0.1
 */