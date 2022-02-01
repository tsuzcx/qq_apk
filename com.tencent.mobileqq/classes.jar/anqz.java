import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;

public class anqz
  extends anrh
{
  public anqz(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2016, null);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("HttpOpenMiniAppAndAdAction", 1, "doAction error: " + localException.getMessage());
      a("HttpOpenMiniAppAndAdAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqz
 * JD-Core Version:    0.7.0.1
 */