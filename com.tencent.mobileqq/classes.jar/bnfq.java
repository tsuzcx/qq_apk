import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import mqq.os.MqqHandler;

public class bnfq
  implements SeekBar.OnSeekBarChangeListener
{
  public bnfq(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    if (this.a.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    }
    this.a.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onStartTrackingTouch: progress = " + i);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onStopTrackingTouch: 当前位置为 = " + i);
    }
    if (this.a.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (this.a.e == 2) {
        this.a.d();
      }
      this.a.c.setImageResource(2130845635);
      this.a.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.a.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(i);
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.b(1);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131694485);
      this.a.b.setEnabled(false);
      this.a.b.setTextColor(-2130706433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfq
 * JD-Core Version:    0.7.0.1
 */