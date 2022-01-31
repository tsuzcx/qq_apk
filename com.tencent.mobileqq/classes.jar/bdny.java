import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class bdny
  implements MediaPlayer.OnCompletionListener
{
  bdny(bdnx parambdnx, AudioManager paramAudioManager) {}
  
  public void onCompletion(MediaPlayer arg1)
  {
    synchronized (this.jdField_a_of_type_Bdnx.jdField_a_of_type_JavaLangObject)
    {
      ???.release();
      this.jdField_a_of_type_Bdnx.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_a_of_type_Bdnx.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bdnx.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_Bdnx.c.setImageDrawable(this.jdField_a_of_type_Bdnx.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130846557));
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_Bdnx.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    synchronized (this.jdField_a_of_type_Bdnx.jdField_a_of_type_Bdoe)
    {
      this.jdField_a_of_type_Bdnx.jdField_a_of_type_Bdoe.jdField_a_of_type_Int = 6;
      return;
      ??? = finally;
      throw ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdny
 * JD-Core Version:    0.7.0.1
 */