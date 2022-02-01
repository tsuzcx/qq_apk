import android.content.Context;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ansc
  extends anrh
{
  public ansc(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("scheme")) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgid")) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busiid")))
      {
        String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msgid");
        String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("busiid");
        String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("scheme");
        String str1 = "";
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("domain")) {
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("domain");
        }
        QQNotifySettingFragment.a(this.jdField_a_of_type_AndroidContentContext, str2, str3, str4, str1);
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("QQNotifySettingAction", 1, "doAction error: " + localException.getMessage());
      a("QQNotifySettingAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansc
 * JD-Core Version:    0.7.0.1
 */