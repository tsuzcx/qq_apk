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

public class apgd
  implements apgo
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
  DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new apge(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DBFixManager jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager;
  String jdField_a_of_type_JavaLangString;
  private String h = "";
  
  public apgd(Context paramContext, QQAppInterface paramQQAppInterface)
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
    jdField_a_of_type_AndroidAppDialog = new apgm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fixing");
  }
  
  private void d()
  {
    jdField_a_of_type_AndroidAppDialog = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(alud.a(2131703256)).setPositiveButton(alud.a(2131703262), new apgi(this));
    jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new apgj(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fix succ");
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_JavaLangString, e, e, 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    jdField_a_of_type_AndroidAppDialog = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(alud.a(2131703257)).setPositiveButton("重启QQ", new apgk(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fix fail");
  }
  
  private void f()
  {
    jdField_a_of_type_AndroidAppDialog = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(alud.a(2131703259)).setPositiveButton(alud.a(2131703255), new apgf(this)).setNegativeButton(alud.a(2131703261), new apgl(this));
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
    if (this.jdField_a_of_type_Int != apgm.d)
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
    jdField_a_of_type_AndroidAppDialog = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(alud.a(2131703258)).setPositiveButton(alud.a(2131703260), new apgh(this)).setNegativeButton("取消", new apgg(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "checked corrupt");
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_JavaLangString, b, b, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgd
 * JD-Core Version:    0.7.0.1
 */