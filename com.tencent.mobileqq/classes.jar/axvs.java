import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class axvs
  implements DialogInterface.OnClickListener
{
  axvs(axvr paramaxvr, boolean paramBoolean, String paramString1, axvz paramaxvz, QQAppInterface paramQQAppInterface, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Axvr.b();
      if (!this.jdField_a_of_type_Axvr.a()) {
        break label104;
      }
      this.jdField_a_of_type_Axvr.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 0, 1);
      this.jdField_a_of_type_Axvz.a(this.jdField_a_of_type_JavaLangString, false);
      axvr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "pay_like", this.jdField_a_of_type_JavaLangString, this.b, "", "", "");
    }
    for (;;)
    {
      axvr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_no_warm", this.b);
      return;
      this.jdField_a_of_type_Axvr.c();
      break;
      label104:
      this.jdField_a_of_type_Axvr.a(this.jdField_a_of_type_AndroidAppActivity, this.b);
      axvr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "exp_pay", this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvs
 * JD-Core Version:    0.7.0.1
 */