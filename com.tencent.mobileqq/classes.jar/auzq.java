import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class auzq
  implements azrg
{
  public auzq(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(azrh paramazrh)
  {
    if (paramazrh != null) {
      QLog.d(auzo.a(), 1, "requestImageShare updateMsg info =" + paramazrh);
    }
  }
  
  public void b(azrh paramazrh)
  {
    this.a.jdField_a_of_type_JavaUtilMap.put(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord, paramazrh);
    QLog.d(auzo.a(), 1, new Object[] { "requestImageShare onSend result =", paramazrh, ", isTimeOut=", Boolean.valueOf(auzo.a(this.a.this$0)) });
    if (this.a.jdField_a_of_type_JavaUtilMap.size() == auzo.a(this.a.this$0).size())
    {
      avcw.b("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      auzo.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzq
 * JD-Core Version:    0.7.0.1
 */