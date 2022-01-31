import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class apjk
  implements atqq
{
  apjk(apjj paramapjj) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(atqr paramatqr)
  {
    if ((paramatqr != null) && (QLog.isColorLevel())) {
      QLog.d(apjj.a(), 2, "requestNormalShare updateMsg info =" + paramatqr);
    }
  }
  
  public void b(atqr paramatqr)
  {
    apmt.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", apjj.a(this.a, paramatqr));
    QLog.d(apjj.a(), 1, new Object[] { "requestNormalShare onSend result =", paramatqr, ", isTimeOut=", Boolean.valueOf(apjj.a(this.a)) });
    if (apjj.a(this.a)) {
      return;
    }
    if (apjj.a(this.a, paramatqr))
    {
      paramatqr = (String[])paramatqr.jdField_a_of_type_JavaLangObject;
      QLog.i(apjj.a(), 1, "requestNormalShare onSend urls=" + paramatqr[0] + " ," + paramatqr[1]);
      apjj.a(this.a, paramatqr[0], paramatqr[1]);
      return;
    }
    QLog.e(apjj.a(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(paramatqr.jdField_a_of_type_Int) });
    apjj.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apjk
 * JD-Core Version:    0.7.0.1
 */