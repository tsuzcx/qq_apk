import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar;
import mqq.app.AppRuntime;

public class bjer
  implements SeekBar.OnSeekBarChangeListener
{
  public bjer(BeautyBar paramBeautyBar) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    BeautyBar.a(this.a, paramInt);
    if (paramBoolean) {
      BeautyBar.a(this.a, BeautyBar.a(this.a), false);
    }
    if (BeautyBar.a(this.a) != BeautyBar.b(this.a))
    {
      if (BeautyBar.a(this.a) != null) {
        BeautyBar.a(this.a).b(BeautyBar.a(this.a));
      }
      BeautyBar.b(this.a, BeautyBar.a(this.a));
    }
    if (paramBoolean) {
      BeautyBar.a(this.a).setContentDescription(ajjy.a(2131635288) + BeautyBar.a(this.a) + "%");
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    BeautyBar.a(this.a).removeMessages(1011);
    if (BeautyBar.a(this.a) != null) {
      BeautyBar.a(this.a).setVisibility(0);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (BeautyBar.b(this.a) >= 0)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0);
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localSharedPreferences.edit().putFloat("beauty_radius" + str, BeautyBar.b(this.a));
      localSharedPreferences.edit().putFloat("beauty_whitenmag" + str, BeautyBar.b(this.a));
      localSharedPreferences.edit().putInt("beauty_level" + str, paramSeekBar.getProgress());
      localSharedPreferences.edit().commit();
      if (QLog.isColorLevel()) {
        QLog.d("beauty", 2, "onStopTrackingTouch mBeautyValue" + BeautyBar.b(this.a) + " mBeautyProcess=" + paramSeekBar.getProgress());
      }
      BeautyBar.a(this.a).removeMessages(1011);
      BeautyBar.a(this.a).sendEmptyMessageDelayed(1011, BeautyBar.a);
      if (BeautyBar.a(this.a) != null) {
        BeautyBar.a(this.a).setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjer
 * JD-Core Version:    0.7.0.1
 */