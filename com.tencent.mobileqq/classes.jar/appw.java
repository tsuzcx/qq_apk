import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class appw
  implements AudioManager.OnAudioFocusChangeListener
{
  appw(appt paramappt) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt == -2) {
      if ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
        appt.a(this.a);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) || (this.a.jdField_a_of_type_AndroidAppActivity == null) || (!(this.a.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) || (!((FileBrowserActivity)this.a.jdField_a_of_type_AndroidAppActivity).isResume()));
      appt.b(this.a);
      return;
    } while ((paramInt != -1) || (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (!this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()));
    appt.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appw
 * JD-Core Version:    0.7.0.1
 */