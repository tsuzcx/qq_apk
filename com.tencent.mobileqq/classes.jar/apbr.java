import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class apbr
  implements CompoundButton.OnCheckedChangeListener
{
  public apbr(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(amid.a, 0).edit().putBoolean(amid.b, paramBoolean).commit();
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getApplicationContext(), alpo.a(2131703242), 1).a();
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbr
 * JD-Core Version:    0.7.0.1
 */