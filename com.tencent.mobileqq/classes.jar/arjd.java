import android.annotation.TargetApi;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class arjd
  implements SeekBar.OnSeekBarChangeListener
{
  arjd(aris paramaris) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      aris.a(this.a, aris.b(this.a, paramInt));
      this.a.jdField_a_of_type_Arke.b(aris.a(this.a));
      if (QLog.isDevelopLevel()) {
        QLog.d("#@#@", 1, "onProgressChanged userPos[" + aris.a(this.a) + "]");
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
    aris.c(this.a);
    aris.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
    this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    this.a.jdField_a_of_type_Arke.a(null);
    aris.a(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("##########", 1, "mMediaPlayer sekTo [" + aris.a(this.a) + "]");
    }
    this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(aris.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjd
 * JD-Core Version:    0.7.0.1
 */