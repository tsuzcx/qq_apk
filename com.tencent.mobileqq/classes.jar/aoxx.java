import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aoxx
  extends aoxg
{
  public aoxx(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      uyx.a(this.jdField_a_of_type_AndroidContentContext, this.c, this.jdField_a_of_type_JavaUtilHashMap);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleAction", 1, "doAction error: " + localException.getMessage());
      a("QCircleAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxx
 * JD-Core Version:    0.7.0.1
 */