import android.annotation.TargetApi;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asvy
  implements SeekBar.OnSeekBarChangeListener
{
  asvy(asvt paramasvt) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (asvt.a(this.a) != null))
    {
      asvt.a(this.a, asvt.b(this.a, paramInt));
      this.a.jdField_a_of_type_Aswz.b(asvt.a(this.a));
      if (QLog.isDevelopLevel()) {
        QLog.d("#@#@", 1, "onProgressChanged userPos[" + asvt.a(this.a) + "]");
      }
      this.a.jdField_a_of_type_Aswz.d(false);
    }
  }
  
  @TargetApi(16)
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((asvt.a(this.a) == null) || (!asvt.a(this.a).isPlaying()))
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    asvt.d(this.a);
    asvt.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.jdField_a_of_type_Boolean = asvt.a(this.a).isPlaying();
    asvt.a(this.a).pause();
    this.a.jdField_a_of_type_Aswz.a(null);
    asvt.a(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (asvt.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      asvt.a(this.a, asvt.b(this.a, paramSeekBar.getProgress()));
      if (QLog.isDevelopLevel()) {
        QLog.d("##########", 1, "mMediaPlayer sekTo [" + asvt.a(this.a) + "]");
      }
      asvt.a(this.a).seekTo(asvt.a(this.a));
      if (this.a.jdField_a_of_type_Boolean)
      {
        asvt.a(this.a).post(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_Aswz.d(true);
        asvt.a(this.a).play();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvy
 * JD-Core Version:    0.7.0.1
 */