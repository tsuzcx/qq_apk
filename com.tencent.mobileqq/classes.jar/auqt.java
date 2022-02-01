import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auqt
  implements CompoundButton.OnCheckedChangeListener
{
  public auqt(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    atul.a().c(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqt
 * JD-Core Version:    0.7.0.1
 */