import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aozm
  extends aoxg
{
  public aozm(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      bmtk localbmtk = bmtk.a();
      localbmtk.a = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localbmtk.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      bmtd.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbmtk, -1);
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
 * Qualified Name:     aozm
 * JD-Core Version:    0.7.0.1
 */