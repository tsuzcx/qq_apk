import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auyh
  implements CompoundButton.OnCheckedChangeListener
{
  public auyh(TempMsgSettingFragment paramTempMsgSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((awtq)this.a.a.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a((short)-23308, paramBoolean, true);
    bdla.b(this.a.a, "dc00898", "", "", "0X8009976", "0X8009976", 1, 1, "", "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyh
 * JD-Core Version:    0.7.0.1
 */