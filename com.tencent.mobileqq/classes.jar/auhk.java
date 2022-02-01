import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auhk
  implements CompoundButton.OnCheckedChangeListener
{
  public auhk(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    atlb.a().e(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhk
 * JD-Core Version:    0.7.0.1
 */