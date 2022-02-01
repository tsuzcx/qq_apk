import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avgf
  implements CompoundButton.OnCheckedChangeListener
{
  public avgf(TempMsgSettingFragment paramTempMsgSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((axae)this.a.a.getManager(303)).a((short)-23309, paramBoolean, true);
    bdll.b(this.a.a, "dc00898", "", "", "0X8009976", "0X8009976", 5, 5, "", "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgf
 * JD-Core Version:    0.7.0.1
 */