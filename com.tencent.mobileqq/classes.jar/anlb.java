import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;

public class anlb
  implements CompoundButton.OnCheckedChangeListener
{
  public anlb(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramBoolean) {
      anlx.a().a();
    }
    anlx.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anlb
 * JD-Core Version:    0.7.0.1
 */