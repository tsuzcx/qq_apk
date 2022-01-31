import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixDialogActivity;
import com.tencent.mobileqq.database.corrupt.DBFixDialogUI.2;
import com.tencent.mobileqq.database.corrupt.DBFixDialogUI.8;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ankn
  implements anky
{
  public static Dialog a;
  public static String b = "0X8007960";
  public static String c = "0X8007961";
  public static String d = "0X8007962";
  public static String e = "0X8007963";
  public static String f = "0X8007964";
  private static String g = "DBFix";
  private int jdField_a_of_type_Int;
  public Context a;
  DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new anko(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DBFixManager jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager;
  String jdField_a_of_type_JavaLangString;
  private String h = "";
  
  public ankn(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager = ((DBFixManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(205));
  }
  
  private void a(Dialog paramDialog, String paramString)
  {
    QLog.d(g, 1, "DBFixDialogUI showDialog, " + paramString);
    this.h = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new DBFixDialogUI.2(this, paramDialog));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.a(true);
    jdField_a_of_type_AndroidAppDialog = new ankw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fixing");
  }
  
  private void d()
  {
    jdField_a_of_type_AndroidAppDialog = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(ajya.a(2131702872)).setPositiveButton(ajya.a(2131702878), new anks(this));
    jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new ankt(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fix succ");
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_JavaLangString, e, e, 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    jdField_a_of_type_AndroidAppDialog = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(ajya.a(2131702873)).setPositiveButton("重启QQ", new anku(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fix fail");
  }
  
  private void f()
  {
    jdField_a_of_type_AndroidAppDialog = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(ajya.a(2131702875)).setPositiveButton(ajya.a(2131702871), new ankp(this)).setNegativeButton(ajya.a(2131702877), new ankv(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "memory alert");
  }
  
  public void a()
  {
    jdField_a_of_type_AndroidAppDialog = null;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof DBFixDialogActivity)) {
      ((DBFixDialogActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.a(false);
    if (this.jdField_a_of_type_Int != ankw.d)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (((SharedPreferences)localObject).getInt(str + DBFixManager.e, 0) == DBFixManager.jdField_a_of_type_Int)
      {
        QLog.d(g, 1, "DBFixDialogUI 2, max count, delete db");
        this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.b(false);
        this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.b();
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.d);
        ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.e);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new DBFixDialogUI.8(this, paramInt));
  }
  
  public void b()
  {
    jdField_a_of_type_AndroidAppDialog = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(ajya.a(2131702874)).setPositiveButton(ajya.a(2131702876), new ankr(this)).setNegativeButton("取消", new ankq(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "checked corrupt");
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_JavaLangString, b, b, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ankn
 * JD-Core Version:    0.7.0.1
 */