import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aoly
  extends aojs
{
  public aoly(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      blsi localblsi = blsi.a();
      localblsi.a = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localblsi.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      blsb.a((Activity)this.jdField_a_of_type_AndroidContentContext, localblsi, -1);
      return true;
    }
    return false;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzonePublishQueueAction", 1, "doAction error: " + localException.getMessage());
      a("QzonePublishQueueAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoly
 * JD-Core Version:    0.7.0.1
 */