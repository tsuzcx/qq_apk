import android.annotation.TargetApi;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auaf
  implements SeekBar.OnSeekBarChangeListener
{
  auaf(auaa paramauaa) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (auaa.a(this.a) != null))
    {
      auaa.a(this.a, auaa.b(this.a, paramInt));
      this.a.jdField_a_of_type_Aubg.b(auaa.a(this.a));
      if (QLog.isDevelopLevel()) {
        QLog.d("#@#@", 1, "onProgressChanged userPos[" + auaa.a(this.a) + "]");
      }
      this.a.jdField_a_of_type_Aubg.d(false);
    }
  }
  
  @TargetApi(16)
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((auaa.a(this.a) == null) || (!auaa.a(this.a).isPlaying()))
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    auaa.d(this.a);
    auaa.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.jdField_a_of_type_Boolean = auaa.a(this.a).isPlaying();
    auaa.a(this.a).pause();
    this.a.jdField_a_of_type_Aubg.a(null);
    auaa.a(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (auaa.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      auaa.a(this.a, auaa.b(this.a, paramSeekBar.getProgress()));
      if (QLog.isDevelopLevel()) {
        QLog.d("##########", 1, "mMediaPlayer sekTo [" + auaa.a(this.a) + "]");
      }
      auaa.a(this.a).seekTo(auaa.a(this.a));
      if (this.a.jdField_a_of_type_Boolean)
      {
        auaa.a(this.a).post(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_Aubg.d(true);
        auaa.a(this.a).play();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auaf
 * JD-Core Version:    0.7.0.1
 */