import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class auhs
  implements ayyt
{
  public auhs(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(ayyu paramayyu)
  {
    if (paramayyu != null) {
      QLog.d(auhq.a(), 1, "requestImageShare updateMsg info =" + paramayyu);
    }
  }
  
  public void b(ayyu paramayyu)
  {
    this.a.jdField_a_of_type_JavaUtilMap.put(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord, paramayyu);
    QLog.d(auhq.a(), 1, new Object[] { "requestImageShare onSend result =", paramayyu, ", isTimeOut=", Boolean.valueOf(auhq.a(this.a.this$0)) });
    if (this.a.jdField_a_of_type_JavaUtilMap.size() == auhq.a(this.a.this$0).size())
    {
      aukw.b("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      auhq.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhs
 * JD-Core Version:    0.7.0.1
 */