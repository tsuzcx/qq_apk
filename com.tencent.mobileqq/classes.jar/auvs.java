import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class auvs
  implements DialogInterface.OnClickListener
{
  auvs(auvr paramauvr, boolean paramBoolean, String paramString1, auvz paramauvz, QQAppInterface paramQQAppInterface, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Auvr.b();
      if (!this.jdField_a_of_type_Auvr.a()) {
        break label104;
      }
      this.jdField_a_of_type_Auvr.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 0, 1);
      this.jdField_a_of_type_Auvz.a(this.jdField_a_of_type_JavaLangString, false);
      auvr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "pay_like", this.jdField_a_of_type_JavaLangString, this.b, "", "", "");
    }
    for (;;)
    {
      auvr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_no_warm", this.b);
      return;
      this.jdField_a_of_type_Auvr.c();
      break;
      label104:
      this.jdField_a_of_type_Auvr.a(this.jdField_a_of_type_AndroidAppActivity, this.b);
      auvr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "exp_pay", this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auvs
 * JD-Core Version:    0.7.0.1
 */