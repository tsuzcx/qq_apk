import android.annotation.TargetApi;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atrt
  implements SeekBar.OnSeekBarChangeListener
{
  atrt(atro paramatro) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (atro.a(this.a) != null))
    {
      atro.a(this.a, atro.b(this.a, paramInt));
      this.a.jdField_a_of_type_Atsu.b(atro.a(this.a));
      if (QLog.isDevelopLevel()) {
        QLog.d("#@#@", 1, "onProgressChanged userPos[" + atro.a(this.a) + "]");
      }
      this.a.jdField_a_of_type_Atsu.d(false);
    }
  }
  
  @TargetApi(16)
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((atro.a(this.a) == null) || (!atro.a(this.a).isPlaying()))
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    atro.d(this.a);
    atro.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.jdField_a_of_type_Boolean = atro.a(this.a).isPlaying();
    atro.a(this.a).pause();
    this.a.jdField_a_of_type_Atsu.a(null);
    atro.a(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (atro.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      atro.a(this.a, atro.b(this.a, paramSeekBar.getProgress()));
      if (QLog.isDevelopLevel()) {
        QLog.d("##########", 1, "mMediaPlayer sekTo [" + atro.a(this.a) + "]");
      }
      atro.a(this.a).seekTo(atro.a(this.a));
      if (this.a.jdField_a_of_type_Boolean)
      {
        this.a.jdField_a_of_type_Atsu.d(true);
        atro.a(this.a).play();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrt
 * JD-Core Version:    0.7.0.1
 */