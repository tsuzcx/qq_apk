import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class bqam
  implements SeekBar.OnSeekBarChangeListener
{
  public bqam(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onProgressChanged: progress = " + paramInt + ",fromUser=" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramSeekBar = this.a;
      paramSeekBar.g += 1;
      ShortVideoPlayActivity.b(this.a, true);
    }
    this.a.b(paramInt * this.a.b / 10000L);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    ShortVideoPlayActivity.b(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onStartTrackingTouch: progress = " + i);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.l();
    ShortVideoPlayActivity localShortVideoPlayActivity = this.a;
    localShortVideoPlayActivity.h += 1;
    int i = this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    int j = (int)(i * this.a.b / 10000L);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onStopTrackingTouch: seekProgress = " + i + ", mCacheProgress= " + ShortVideoPlayActivity.b(this.a) + ", timestamp = " + j);
    }
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.a.jdField_a_of_type_Int == 2) {
        this.a.a();
      }
      this.a.a(j);
    }
    ShortVideoPlayActivity.b(this.a, false);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqam
 * JD-Core Version:    0.7.0.1
 */