import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class apjl
  implements atqq
{
  public apjl(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(atqr paramatqr)
  {
    if (paramatqr != null) {
      QLog.d(apjj.a(), 1, "requestImageShare updateMsg info =" + paramatqr);
    }
  }
  
  public void b(atqr paramatqr)
  {
    this.a.jdField_a_of_type_JavaUtilMap.put(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord, paramatqr);
    QLog.d(apjj.a(), 1, new Object[] { "requestImageShare onSend result =", paramatqr, ", isTimeOut=", Boolean.valueOf(apjj.a(this.a.this$0)) });
    if (this.a.jdField_a_of_type_JavaUtilMap.size() == apjj.a(this.a.this$0).size())
    {
      apmt.b("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      apjj.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apjl
 * JD-Core Version:    0.7.0.1
 */