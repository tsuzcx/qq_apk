import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class bhmo
  implements MediaPlayer.OnCompletionListener
{
  bhmo(bhmn parambhmn, AudioManager paramAudioManager) {}
  
  public void onCompletion(MediaPlayer arg1)
  {
    synchronized (this.jdField_a_of_type_Bhmn.jdField_a_of_type_JavaLangObject)
    {
      ???.release();
      this.jdField_a_of_type_Bhmn.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_a_of_type_Bhmn.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bhmn.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_Bhmn.c.setImageDrawable(this.jdField_a_of_type_Bhmn.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847094));
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_Bhmn.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    synchronized (this.jdField_a_of_type_Bhmn.jdField_a_of_type_Bhmu)
    {
      this.jdField_a_of_type_Bhmn.jdField_a_of_type_Bhmu.jdField_a_of_type_Int = 6;
      return;
      ??? = finally;
      throw ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmo
 * JD-Core Version:    0.7.0.1
 */