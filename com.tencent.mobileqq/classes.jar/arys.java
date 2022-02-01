import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import mqq.app.MobileQQ;

class arys
  implements DialogInterface.OnClickListener
{
  arys(aryn paramaryn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    aryn.a(this.a).b();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0).edit().remove(this.a.jdField_a_of_type_JavaLangString + DBFixManager.g).commit();
    bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_JavaLangString, aryn.f, aryn.f, 0, 0, "", "", "", "");
    aryn.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arys
 * JD-Core Version:    0.7.0.1
 */