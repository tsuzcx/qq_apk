import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class aqcy
  implements auoo
{
  public aqcy(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auop paramauop)
  {
    if (paramauop != null) {
      QLog.d(aqcw.a(), 1, "requestImageShare updateMsg info =" + paramauop);
    }
  }
  
  public void b(auop paramauop)
  {
    this.a.jdField_a_of_type_JavaUtilMap.put(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord, paramauop);
    QLog.d(aqcw.a(), 1, new Object[] { "requestImageShare onSend result =", paramauop, ", isTimeOut=", Boolean.valueOf(aqcw.a(this.a.this$0)) });
    if (this.a.jdField_a_of_type_JavaUtilMap.size() == aqcw.a(this.a.this$0).size())
    {
      aqgh.b("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      aqcw.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcy
 * JD-Core Version:    0.7.0.1
 */