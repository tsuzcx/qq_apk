import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aowy
  extends aouc
{
  public aowy(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      zqm.a(this.jdField_a_of_type_AndroidContentContext, this.c, this.jdField_a_of_type_JavaUtilHashMap);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("SubScribeAction", 1, "doAction error: " + localException.getMessage());
      a("SubScribeAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowy
 * JD-Core Version:    0.7.0.1
 */