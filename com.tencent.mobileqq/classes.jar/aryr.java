import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

class aryr
  implements DialogInterface.OnClickListener
{
  aryr(aryn paramaryn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ".db");
    boolean bool = false;
    if ((paramDialogInterface.exists()) && ((float)paramDialogInterface.length() * 1.7F > bhmi.a()))
    {
      bool = true;
      aryn.a(this.a);
      paramDialogInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0);
      String str = paramDialogInterface.getString(this.a.jdField_a_of_type_JavaLangString + DBFixManager.k, "");
      paramDialogInterface.edit().putString(this.a.jdField_a_of_type_JavaLangString + DBFixManager.k, str + "_MemoryAlert").commit();
    }
    for (;;)
    {
      paramDialogInterface = new HashMap();
      paramDialogInterface.put("isMemAlert", String.valueOf(bool));
      bdmc.a(BaseApplication.getContext()).a(null, DBFixManager.n, true, -1L, 0L, paramDialogInterface, null, false);
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_JavaLangString, aryn.c, aryn.c, 0, 0, "", "", "", "");
      return;
      aryn.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryr
 * JD-Core Version:    0.7.0.1
 */