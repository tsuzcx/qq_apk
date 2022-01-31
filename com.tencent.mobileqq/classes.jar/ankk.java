import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ankk
  implements CompoundButton.OnCheckedChangeListener
{
  public ankk(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    akry.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(akry.jdField_a_of_type_JavaLangString, 0).edit().putBoolean(akry.b, paramBoolean).commit();
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getApplicationContext(), ajya.a(2131702870), 1).a();
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ankk
 * JD-Core Version:    0.7.0.1
 */