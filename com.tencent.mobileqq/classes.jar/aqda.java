import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class aqda
  implements auoq
{
  public aqda(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor)
  {
    if (paramauor != null) {
      QLog.d(aqcy.a(), 1, "requestImageShare updateMsg info =" + paramauor);
    }
  }
  
  public void b(auor paramauor)
  {
    this.a.jdField_a_of_type_JavaUtilMap.put(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord, paramauor);
    QLog.d(aqcy.a(), 1, new Object[] { "requestImageShare onSend result =", paramauor, ", isTimeOut=", Boolean.valueOf(aqcy.a(this.a.this$0)) });
    if (this.a.jdField_a_of_type_JavaUtilMap.size() == aqcy.a(this.a.this$0).size())
    {
      aqgj.b("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      aqcy.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqda
 * JD-Core Version:    0.7.0.1
 */