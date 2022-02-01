import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginInstallActivity;
import java.util.HashMap;

public class aoyu
  extends aoxg
{
  public aoyu(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HcePluginInstallActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) && (!bhsr.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"))) && ("2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from_type"))))
      {
        boolean bool = C();
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("QwalletToBuscardAction", 1, "doAction error: " + localException.getMessage());
      a("QwalletToBuscardAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyu
 * JD-Core Version:    0.7.0.1
 */