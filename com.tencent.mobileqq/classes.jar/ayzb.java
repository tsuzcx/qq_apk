import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

class ayzb
  extends Handler
{
  ayzb(ayyy paramayyy, Looper paramLooper, Context paramContext, String paramString1, int paramInt, AppInterface paramAppInterface, String paramString2, String paramString3)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Ayyy.b = true;
      if (this.jdField_a_of_type_Ayyy.jdField_a_of_type_MqqAppNewIntent != null)
      {
        this.jdField_a_of_type_Ayyy.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
        this.jdField_a_of_type_Ayyy.jdField_a_of_type_MqqAppNewIntent = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "lauchApp time out");
      }
      paramMessage = ayyy.a(this.jdField_a_of_type_Ayyy.jdField_a_of_type_JavaLangString);
      bfms.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramMessage, this.jdField_a_of_type_Int);
      ayyy.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Ayyy.b = true;
    if (this.jdField_a_of_type_Ayyy.jdField_a_of_type_MqqAppNewIntent != null)
    {
      this.jdField_a_of_type_Ayyy.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
      this.jdField_a_of_type_Ayyy.jdField_a_of_type_MqqAppNewIntent = null;
    }
    ayyy.a(this.jdField_a_of_type_Ayyy, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.b, this.c, this.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzb
 * JD-Core Version:    0.7.0.1
 */