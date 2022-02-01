import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aots
  extends aouc
{
  public aots(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("mini_appid")) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("fakeUrl")))
        {
          i = 1;
          if (i != 0) {
            return com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
          }
          boolean bool = com.tencent.mobileqq.mini.sdk.MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, 2016, null, null);
          return bool;
        }
      }
      catch (Exception localException)
      {
        QLog.e("HttpOpenMicroAppAction", 1, "doAction error: " + localException.getMessage());
        a("HttpOpenMicroAppAction");
        return false;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aots
 * JD-Core Version:    0.7.0.1
 */