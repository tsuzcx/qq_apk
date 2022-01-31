import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class arzc
  implements DialogInterface.OnClickListener
{
  arzc(arys paramarys) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (arys.a(this.a))
      {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", aruc.e.intValue());
        this.a.l();
      }
      azmz.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", "multi_account", "click_next", 0, 1, 0);
    }
    while (paramInt != 0) {
      return;
    }
    paramDialogInterface = this.a.jdField_a_of_type_AndroidAppActivity;
    Activity localActivity = this.a.jdField_a_of_type_AndroidAppActivity;
    paramDialogInterface.setResult(0);
    azmz.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", "multi_account", "click_cancel", 0, 1, 0);
    this.a.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzc
 * JD-Core Version:    0.7.0.1
 */