import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import mqq.app.MobileQQ;

class apbz
  implements DialogInterface.OnClickListener
{
  apbz(apbu paramapbu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    apbu.a(this.a).b();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0).edit().remove(this.a.jdField_a_of_type_JavaLangString + DBFixManager.g).commit();
    azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_JavaLangString, apbu.f, apbu.f, 0, 0, "", "", "", "");
    apbu.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbz
 * JD-Core Version:    0.7.0.1
 */