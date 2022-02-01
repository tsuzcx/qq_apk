import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amea
  implements View.OnClickListener
{
  amea(amdz paramamdz) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365586) {}
    ameg localameg;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localameg = (ameg)paramView.getTag();
      if ((localameg != null) && (localameg.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localameg.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
      {
        PhoneContact localPhoneContact = localameg.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (localameg.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
        {
          if (localameg.jdField_a_of_type_JavaLangString.startsWith("+")) {}
          for (boolean bool = this.a.a.a.a(localameg.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.a.a.a.a(localameg.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
          {
            localameg.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
            if (!AppSetting.c) {
              break;
            }
            if (!localameg.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label266;
            }
            if (!localameg.jdField_a_of_type_Boolean) {
              break label225;
            }
            paramView.setContentDescription(localameg.b.getText() + this.a.a.a.getString(2131717857));
            break;
          }
          label225:
          paramView.setContentDescription(localameg.b.getText().toString() + anzj.a(2131706876));
        }
      }
    }
    label266:
    if (localameg.jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.a.a(localameg.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localameg.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localameg.b.getText() + this.a.a.a.getString(i));
        break;
      }
      paramView.setContentDescription(localameg.b.getText().toString() + anzj.a(2131706873));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amea
 * JD-Core Version:    0.7.0.1
 */