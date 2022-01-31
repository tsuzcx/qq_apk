import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

public class ammb
  implements DialogInterface.OnDismissListener
{
  public ammb(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onDismiss|pickerType : " + this.a.i);
    }
    if (this.a.i == 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.a.jdField_a_of_type_Ajtw.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      paramDialogInterface = this.a.jdField_a_of_type_Ajtw.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      if (AppSetting.d)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajya.a(2131702354) + paramDialogInterface);
        baww.a(this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, ajya.a(2131702357) + paramDialogInterface);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "onDismiss|mCurAgeIndex1 : " + this.a.f + ", mCurAgeIndex2 : " + this.a.g + ", mAgeSelectIndex1 : " + this.a.jdField_b_of_type_Int + ", mAgeSelectIndex2 : " + this.a.jdField_c_of_type_Int);
      }
      axqy.b(this.a.app, "CliOper", "", "", "0X8004243", "0X8004243", 0, 0, this.a.jdField_b_of_type_Int + "", this.a.jdField_c_of_type_Int + "", "", "");
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
        this.a.jdField_a_of_type_Ajtw.b(this.a.d);
        if (AppSetting.d)
        {
          this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajya.a(2131702356) + ajtw.c[this.a.d]);
          baww.a(this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, ajya.a(2131702367) + ajtw.c[this.a.d]);
        }
        axqy.b(this.a.app, "CliOper", "", "", "0X8006F0B", "0X8006F0B", 0, 0, this.a.d + "", "", "", "");
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
          this.a.jdField_a_of_type_Ajtw.a(0, paramDialogInterface);
          this.a.jdField_a_of_type_Ajtw.b(arrayOfString);
          if (AppSetting.d)
          {
            this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajya.a(2131702353) + paramDialogInterface);
            baww.a(this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, ajya.a(2131702352) + paramDialogInterface);
          }
        }
        else if (this.a.i == 2)
        {
          this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
          this.a.jdField_a_of_type_Ajtw.a(1, paramDialogInterface);
          this.a.jdField_a_of_type_Ajtw.c(arrayOfString);
          if (AppSetting.d)
          {
            this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajya.a(2131702363) + paramDialogInterface);
            baww.a(this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, ajya.a(2131702364) + paramDialogInterface);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ammb
 * JD-Core Version:    0.7.0.1
 */