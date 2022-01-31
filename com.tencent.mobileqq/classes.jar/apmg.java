import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class apmg
  implements atqq
{
  apmg(apmf paramapmf) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(atqr paramatqr)
  {
    if ((paramatqr != null) && (QLog.isColorLevel())) {
      QLog.d("ForwardShareByServerHelper", 2, "upCallBack updateMsg info =" + paramatqr);
    }
  }
  
  public void b(atqr paramatqr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardShareByServerHelper", 2, "UpCallBack onSend result =" + paramatqr + ", isTimeOut=" + apmf.a(this.a) + ", isFirstShow =" + apmf.b(this.a));
    }
    if (!apmf.b(this.a)) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
        } while (apmf.a(this.a));
        i = paramatqr.jdField_a_of_type_Int;
        if (i != 0) {
          break;
        }
        paramatqr = (String[])paramatqr.jdField_a_of_type_JavaLangObject;
        if ((paramatqr != null) && (paramatqr.length == 2))
        {
          QLog.i("ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + paramatqr[0] + " ," + paramatqr[1]);
          apmf.a(this.a, apmf.a(this.a), paramatqr[0], paramatqr[1]);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ForwardShareByServerHelper", 2, "onSend updateMsg error !");
      return;
    } while (-1 != i);
    apmf.a(this.a, apmf.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmg
 * JD-Core Version:    0.7.0.1
 */