import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class asar
  implements awkh
{
  public asar(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki)
  {
    if (paramawki != null) {
      QLog.d(asap.a(), 1, "requestImageShare updateMsg info =" + paramawki);
    }
  }
  
  public void b(awki paramawki)
  {
    this.a.jdField_a_of_type_JavaUtilMap.put(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord, paramawki);
    QLog.d(asap.a(), 1, new Object[] { "requestImageShare onSend result =", paramawki, ", isTimeOut=", Boolean.valueOf(asap.a(this.a.this$0)) });
    if (this.a.jdField_a_of_type_JavaUtilMap.size() == asap.a(this.a.this$0).size())
    {
      aseh.b("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      asap.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asar
 * JD-Core Version:    0.7.0.1
 */