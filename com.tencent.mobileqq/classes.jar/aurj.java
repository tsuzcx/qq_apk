import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class aurj
  implements DialogInterface.OnClickListener
{
  aurj(auri paramauri, boolean paramBoolean, String paramString1, aurq paramaurq, QQAppInterface paramQQAppInterface, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Auri.b();
      if (!this.jdField_a_of_type_Auri.a()) {
        break label104;
      }
      this.jdField_a_of_type_Auri.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 0, 1);
      this.jdField_a_of_type_Aurq.a(this.jdField_a_of_type_JavaLangString, false);
      auri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "pay_like", this.jdField_a_of_type_JavaLangString, this.b, "", "", "");
    }
    for (;;)
    {
      auri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_no_warm", this.b);
      return;
      this.jdField_a_of_type_Auri.c();
      break;
      label104:
      this.jdField_a_of_type_Auri.a(this.jdField_a_of_type_AndroidAppActivity, this.b);
      auri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "exp_pay", this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aurj
 * JD-Core Version:    0.7.0.1
 */