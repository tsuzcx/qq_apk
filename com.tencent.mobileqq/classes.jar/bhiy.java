import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class bhiy
  extends MqqHandler
{
  bhiy(bhix parambhix) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 104: 
      do
      {
        return;
        paramMessage = (String)paramMessage.obj;
        if ((this.a.jdField_a_of_type_Baim != null) && (!TextUtils.isEmpty(paramMessage)))
        {
          this.a.jdField_a_of_type_Baim.a(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(bhix.jdField_a_of_type_JavaLangString, 2, "captcha sig is empty");
      return;
    }
    bhix.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhiy
 * JD-Core Version:    0.7.0.1
 */