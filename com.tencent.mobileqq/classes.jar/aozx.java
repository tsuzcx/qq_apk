import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aozx
  extends aoxg
{
  public aozx(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      aaej.a(this.jdField_a_of_type_AndroidContentContext, this.c, this.jdField_a_of_type_JavaUtilHashMap);
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
 * Qualified Name:     aozx
 * JD-Core Version:    0.7.0.1
 */