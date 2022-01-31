import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class awcp
  implements CompoundButton.OnCheckedChangeListener
{
  public awcp(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((bbev.d(this.a.getActivity())) && (SignTextEditFragment.a(this.a) != null))
    {
      if (AppSetting.d) {
        this.a.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(ajyc.a(2131707917));
      }
      SignTextEditFragment.a(this.a).a(paramBoolean);
      axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97B", "0X800A97B", 0, 0, "0", "0", "", "");
      return;
    }
    paramCompoundButton = this.a.getActivity();
    int i;
    label108:
    CheckBox localCheckBox;
    if (SignTextEditFragment.a(this.a) != null)
    {
      i = 2131694670;
      bcpw.a(paramCompoundButton, i, 1).a();
      paramCompoundButton = this.a;
      localCheckBox = this.a.jdField_a_of_type_AndroidWidgetCheckBox;
      if (paramBoolean) {
        break label154;
      }
    }
    label154:
    for (paramBoolean = true;; paramBoolean = false)
    {
      SignTextEditFragment.a(paramCompoundButton, localCheckBox, paramBoolean);
      break;
      i = 2131719375;
      break label108;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awcp
 * JD-Core Version:    0.7.0.1
 */