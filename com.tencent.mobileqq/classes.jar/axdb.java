import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class axdb
  implements DialogInterface.OnClickListener
{
  axdb(axda paramaxda, boolean paramBoolean, String paramString1, axdi paramaxdi, QQAppInterface paramQQAppInterface, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Axda.b();
      if (!this.jdField_a_of_type_Axda.a()) {
        break label104;
      }
      this.jdField_a_of_type_Axda.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 0, 1);
      this.jdField_a_of_type_Axdi.a(this.jdField_a_of_type_JavaLangString, false);
      axda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "pay_like", this.jdField_a_of_type_JavaLangString, this.b, "", "", "");
    }
    for (;;)
    {
      axda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_no_warm", this.b);
      return;
      this.jdField_a_of_type_Axda.c();
      break;
      label104:
      this.jdField_a_of_type_Axda.a(this.jdField_a_of_type_AndroidAppActivity, this.b);
      axda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "exp_pay", this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axdb
 * JD-Core Version:    0.7.0.1
 */