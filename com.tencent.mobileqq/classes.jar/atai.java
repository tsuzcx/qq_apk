import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class atai
  implements DialogInterface.OnClickListener
{
  atai(atah paramatah, boolean paramBoolean, String paramString1, atap paramatap, QQAppInterface paramQQAppInterface, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Atah.b();
      if (!this.jdField_a_of_type_Atah.a()) {
        break label104;
      }
      this.jdField_a_of_type_Atah.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 0, 1);
      this.jdField_a_of_type_Atap.a(this.jdField_a_of_type_JavaLangString, false);
      atah.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "pay_like", this.jdField_a_of_type_JavaLangString, this.b, "", "", "");
    }
    for (;;)
    {
      atah.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_no_warm", this.b);
      return;
      this.jdField_a_of_type_Atah.c();
      break;
      label104:
      this.jdField_a_of_type_Atah.a(this.jdField_a_of_type_AndroidAppActivity, this.b);
      atah.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "exp_pay", this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atai
 * JD-Core Version:    0.7.0.1
 */