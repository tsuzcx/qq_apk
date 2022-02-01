import android.content.Context;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;

public class aolm
  extends aojs
{
  public aolm(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("params");
      if (bool) {}
      try
      {
        JSONObject localJSONObject = new JSONObject(URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("params")));
        if (QLog.isColorLevel()) {
          QLog.i("QwalletToNotifyAction", 2, "urlParamObj: " + localJSONObject);
        }
        if (localJSONObject.optInt("view_type", 0) == 0)
        {
          localJSONObject = localJSONObject.optJSONObject("params");
          if (localJSONObject != null) {
            ReminderListFragment.a(this.jdField_a_of_type_AndroidContentContext, localJSONObject.optString("notice_time"));
          }
        }
      }
      catch (Exception localException1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QwalletToNotifyAction", 2, "JumpAction parse url throw an exception: " + localException1);
        return false;
      }
      return false;
    }
    catch (Exception localException2)
    {
      QLog.e("QwalletToNotifyAction", 1, "doAction error: " + localException2.getMessage());
      a("QwalletToNotifyAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolm
 * JD-Core Version:    0.7.0.1
 */