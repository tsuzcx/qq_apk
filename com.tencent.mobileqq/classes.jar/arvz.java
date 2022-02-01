import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class arvz
  implements DialogInterface.OnCancelListener
{
  arvz(arvy paramarvy) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (arvy.a(this.a).equals("checked corrupt"))
    {
      paramDialogInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0);
      String str = paramDialogInterface.getString(this.a.jdField_a_of_type_JavaLangString + DBFixManager.k, "");
      paramDialogInterface.edit().putString(this.a.jdField_a_of_type_JavaLangString + DBFixManager.k, str + "_Cancel").commit();
      QLog.d(arvy.a(), 1, "dialog cancel");
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvz
 * JD-Core Version:    0.7.0.1
 */