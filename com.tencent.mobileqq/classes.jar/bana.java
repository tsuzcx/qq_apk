import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bana
  implements CompoundButton.OnCheckedChangeListener
{
  public bana(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((NetworkUtil.isNetSupport(this.a.getActivity())) && (SignTextEditFragment.a(this.a) != null))
    {
      if (AppSetting.c) {
        this.a.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(amtj.a(2131707030));
      }
      SignTextEditFragment.a(this.a).a(paramBoolean);
      bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97B", "0X800A97B", 0, 0, "0", "0", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    Object localObject = this.a.getActivity();
    int i;
    label117:
    CheckBox localCheckBox;
    if (SignTextEditFragment.a(this.a) != null)
    {
      i = 2131694105;
      QQToast.a((Context)localObject, i, 1).a();
      localObject = this.a;
      localCheckBox = this.a.jdField_a_of_type_AndroidWidgetCheckBox;
      if (paramBoolean) {
        break label168;
      }
    }
    label168:
    for (boolean bool = true;; bool = false)
    {
      SignTextEditFragment.a((SignTextEditFragment)localObject, localCheckBox, bool);
      break;
      i = 2131718207;
      break label117;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bana
 * JD-Core Version:    0.7.0.1
 */