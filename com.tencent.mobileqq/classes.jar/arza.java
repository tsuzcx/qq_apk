import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arza
  implements CompoundButton.OnCheckedChangeListener
{
  public arza(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      arzx.a().c();
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      arzx.a().d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arza
 * JD-Core Version:    0.7.0.1
 */