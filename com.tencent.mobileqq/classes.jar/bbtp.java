import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bbtp
  implements CompoundButton.OnCheckedChangeListener
{
  public bbtp(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((NetworkUtil.isNetSupport(this.a.getActivity())) && (SignTextEditFragment.a(this.a) != null))
    {
      if (AppSetting.c) {
        this.a.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(anvx.a(2131707377));
      }
      SignTextEditFragment.a(this.a).a(paramBoolean);
      bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97B", "0X800A97B", 0, 0, "0", "0", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    Object localObject = this.a.getActivity();
    int i;
    label117:
    CheckBox localCheckBox;
    if (SignTextEditFragment.a(this.a) != null)
    {
      i = 2131694302;
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
      i = 2131718593;
      break label117;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtp
 * JD-Core Version:    0.7.0.1
 */