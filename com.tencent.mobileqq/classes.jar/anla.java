import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;

public class anla
  implements CompoundButton.OnCheckedChangeListener
{
  public anla(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      anlx.a().c();
      return;
    }
    anlx.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anla
 * JD-Core Version:    0.7.0.1
 */