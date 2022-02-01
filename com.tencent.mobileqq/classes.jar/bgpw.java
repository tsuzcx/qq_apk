import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class bgpw
  extends MqqHandler
{
  bgpw(bgpv parambgpv) {}
  
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
        if ((this.a.jdField_a_of_type_Azvp != null) && (!TextUtils.isEmpty(paramMessage)))
        {
          this.a.jdField_a_of_type_Azvp.a(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(bgpv.jdField_a_of_type_JavaLangString, 2, "captcha sig is empty");
      return;
    }
    bgpv.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpw
 * JD-Core Version:    0.7.0.1
 */