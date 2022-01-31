import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

public class ammc
  implements DialogInterface.OnDismissListener
{
  public ammc(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onDismiss|pickerType : " + this.a.i);
    }
    if (this.a.i == 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.a.jdField_a_of_type_Ajty.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      paramDialogInterface = this.a.jdField_a_of_type_Ajty.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      if (AppSetting.d)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajyc.a(2131702343) + paramDialogInterface);
        bawi.a(this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, ajyc.a(2131702346) + paramDialogInterface);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "onDismiss|mCurAgeIndex1 : " + this.a.f + ", mCurAgeIndex2 : " + this.a.g + ", mAgeSelectIndex1 : " + this.a.jdField_b_of_type_Int + ", mAgeSelectIndex2 : " + this.a.jdField_c_of_type_Int);
      }
      axqw.b(this.a.app, "CliOper", "", "", "0X8004243", "0X8004243", 0, 0, this.a.jdField_b_of_type_Int + "", this.a.jdField_c_of_type_Int + "", "", "");
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = null;
      if (ConditionSearchFriendActivity.a(this.a) > 0)
      {
        this.a.jdField_e_of_type_AndroidViewView.scrollBy(0, -ConditionSearchFriendActivity.a(this.a));
        ConditionSearchFriendActivity.a(this.a, 0);
      }
      return;
      if (this.a.i == 3)
      {
        this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
        this.a.jdField_a_of_type_Ajty.b(this.a.d);
        if (AppSetting.d)
        {
          this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajyc.a(2131702345) + ajty.c[this.a.d]);
          bawi.a(this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, ajyc.a(2131702356) + ajty.c[this.a.d]);
        }
        axqw.b(this.a.app, "CliOper", "", "", "0X8006F0B", "0X8006F0B", 0, 0, this.a.d + "", "", "", "");
      }
      else
      {
        this.a.jdField_c_of_type_AndroidWidgetTextView = null;
        paramDialogInterface = ConditionSearchFriendActivity.a(this.a);
        String[] arrayOfString = new String[4];
        arrayOfString[0] = this.a.jdField_b_of_type_JavaLangString;
        arrayOfString[1] = this.a.jdField_a_of_type_ArrayOfJavaLangString[0];
        arrayOfString[2] = this.a.jdField_a_of_type_ArrayOfJavaLangString[1];
        arrayOfString[3] = this.a.jdField_a_of_type_ArrayOfJavaLangString[2];
        if (this.a.i == 1)
        {
          this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
          this.a.jdField_a_of_type_Ajty.a(0, paramDialogInterface);
          this.a.jdField_a_of_type_Ajty.b(arrayOfString);
          if (AppSetting.d)
          {
            this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajyc.a(2131702342) + paramDialogInterface);
            bawi.a(this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, ajyc.a(2131702341) + paramDialogInterface);
          }
        }
        else if (this.a.i == 2)
        {
          this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
          this.a.jdField_a_of_type_Ajty.a(1, paramDialogInterface);
          this.a.jdField_a_of_type_Ajty.c(arrayOfString);
          if (AppSetting.d)
          {
            this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajyc.a(2131702352) + paramDialogInterface);
            bawi.a(this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, ajyc.a(2131702353) + paramDialogInterface);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ammc
 * JD-Core Version:    0.7.0.1
 */