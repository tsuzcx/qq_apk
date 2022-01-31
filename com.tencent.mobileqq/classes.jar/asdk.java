import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;

public class asdk
  implements CompoundButton.OnCheckedChangeListener
{
  public asdk(TempMsgSettingFragment paramTempMsgSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((atvu)this.a.a.getManager(303)).a((short)-23171, paramBoolean, true);
    azmj.b(this.a.a, "dc00898", "", "", "0X8009976", "0X8009976", 5, 5, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdk
 * JD-Core Version:    0.7.0.1
 */