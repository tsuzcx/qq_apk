import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aoxo
  extends aouc
{
  public aoxo(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if ("openPlayer".equals(this.jdField_a_of_type_JavaUtilHashMap.get("action"))) {
        bool = vfa.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
      }
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("WeishiPublicAccountVideoAction", 1, "doAction error: " + localException.getMessage());
      a("WeishiPublicAccountVideoAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxo
 * JD-Core Version:    0.7.0.1
 */