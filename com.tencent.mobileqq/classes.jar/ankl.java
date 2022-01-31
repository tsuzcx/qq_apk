import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ankl
  implements CompoundButton.OnCheckedChangeListener
{
  public ankl(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    akry.b = paramBoolean;
    this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(akry.a, 0).edit().putBoolean(akry.c, paramBoolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ankl
 * JD-Core Version:    0.7.0.1
 */