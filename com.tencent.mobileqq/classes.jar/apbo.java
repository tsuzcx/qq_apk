import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class apbo
  implements RadioGroup.OnCheckedChangeListener
{
  public apbo(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime, String paramString) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131365503) {
      DBFixConfigActivity.a = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(DBFixManager.b, 0).edit().putInt(this.jdField_a_of_type_JavaLangString + DBFixManager.c, DBFixConfigActivity.a).commit();
      return;
      if (paramInt == 2131365022) {
        DBFixConfigActivity.a = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbo
 * JD-Core Version:    0.7.0.1
 */