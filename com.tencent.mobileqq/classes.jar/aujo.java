import android.annotation.TargetApi;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aujo
  implements SeekBar.OnSeekBarChangeListener
{
  aujo(aujj paramaujj) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (aujj.a(this.a) != null))
    {
      aujj.a(this.a, aujj.b(this.a, paramInt));
      this.a.jdField_a_of_type_Aukp.b(aujj.a(this.a));
      if (QLog.isDevelopLevel()) {
        QLog.d("#@#@", 1, "onProgressChanged userPos[" + aujj.a(this.a) + "]");
      }
      this.a.jdField_a_of_type_Aukp.d(false);
    }
  }
  
  @TargetApi(16)
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((aujj.a(this.a) == null) || (!aujj.a(this.a).isPlaying()))
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    aujj.d(this.a);
    aujj.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.jdField_a_of_type_Boolean = aujj.a(this.a).isPlaying();
    aujj.a(this.a).pause();
    this.a.jdField_a_of_type_Aukp.a(null);
    aujj.a(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (aujj.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      aujj.a(this.a, aujj.b(this.a, paramSeekBar.getProgress()));
      if (QLog.isDevelopLevel()) {
        QLog.d("##########", 1, "mMediaPlayer sekTo [" + aujj.a(this.a) + "]");
      }
      aujj.a(this.a).seekTo(aujj.a(this.a));
      if (this.a.jdField_a_of_type_Boolean)
      {
        aujj.a(this.a).post(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_Aukp.d(true);
        aujj.a(this.a).play();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujo
 * JD-Core Version:    0.7.0.1
 */