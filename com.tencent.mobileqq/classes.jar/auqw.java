import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auqw
  implements CompoundButton.OnCheckedChangeListener
{
  public auqw(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    atul.a().f(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqw
 * JD-Core Version:    0.7.0.1
 */