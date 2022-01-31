import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

public class aocz
  implements DialogInterface.OnDismissListener
{
  public aocz(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onDismiss|pickerType : " + this.a.i);
    }
    if (this.a.i == 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.a.jdField_a_of_type_Allj.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      paramDialogInterface = this.a.jdField_a_of_type_Allj.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      if (AppSetting.c)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(alpo.a(2131702726) + paramDialogInterface);
        bcvq.a(this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, alpo.a(2131702729) + paramDialogInterface);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "onDismiss|mCurAgeIndex1 : " + this.a.f + ", mCurAgeIndex2 : " + this.a.g + ", mAgeSelectIndex1 : " + this.a.jdField_b_of_type_Int + ", mAgeSelectIndex2 : " + this.a.jdField_c_of_type_Int);
      }
      azmj.b(this.a.app, "CliOper", "", "", "0X8004243", "0X8004243", 0, 0, this.a.jdField_b_of_type_Int + "", this.a.jdField_c_of_type_Int + "", "", "");
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
        this.a.jdField_a_of_type_Allj.b(this.a.d);
        if (AppSetting.c)
        {
          this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(alpo.a(2131702728) + allj.c[this.a.d]);
          bcvq.a(this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, alpo.a(2131702739) + allj.c[this.a.d]);
        }
        azmj.b(this.a.app, "CliOper", "", "", "0X8006F0B", "0X8006F0B", 0, 0, this.a.d + "", "", "", "");
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
          this.a.jdField_a_of_type_Allj.a(0, paramDialogInterface);
          this.a.jdField_a_of_type_Allj.b(arrayOfString);
          if (AppSetting.c)
          {
            this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(alpo.a(2131702725) + paramDialogInterface);
            bcvq.a(this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, alpo.a(2131702724) + paramDialogInterface);
          }
        }
        else if (this.a.i == 2)
        {
          this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
          this.a.jdField_a_of_type_Allj.a(1, paramDialogInterface);
          this.a.jdField_a_of_type_Allj.c(arrayOfString);
          if (AppSetting.c)
          {
            this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(alpo.a(2131702735) + paramDialogInterface);
            bcvq.a(this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, alpo.a(2131702736) + paramDialogInterface);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocz
 * JD-Core Version:    0.7.0.1
 */