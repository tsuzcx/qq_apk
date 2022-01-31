import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class arwi
  implements awfy
{
  public arwi(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awfz paramawfz)
  {
    if (paramawfz != null) {
      QLog.d(arwg.a(), 1, "requestImageShare updateMsg info =" + paramawfz);
    }
  }
  
  public void b(awfz paramawfz)
  {
    this.a.jdField_a_of_type_JavaUtilMap.put(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord, paramawfz);
    QLog.d(arwg.a(), 1, new Object[] { "requestImageShare onSend result =", paramawfz, ", isTimeOut=", Boolean.valueOf(arwg.a(this.a.this$0)) });
    if (this.a.jdField_a_of_type_JavaUtilMap.size() == arwg.a(this.a.this$0).size())
    {
      arzy.b("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      arwg.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwi
 * JD-Core Version:    0.7.0.1
 */