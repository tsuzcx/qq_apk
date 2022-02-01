import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class aurp
  implements azla
{
  public aurp(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    this.a.jdField_a_of_type_JavaUtilMap.put(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord, paramazlb);
    QLog.d(aurn.a(), 1, new Object[] { "requestImageShare onSend result =", paramazlb, ", isTimeOut=", Boolean.valueOf(aurn.a(this.a.this$0)) });
    if (this.a.jdField_a_of_type_JavaUtilMap.size() == aurn.a(this.a.this$0).size())
    {
      auuv.b("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      aurn.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void updateMsg(azlb paramazlb)
  {
    if (paramazlb != null) {
      QLog.d(aurn.a(), 1, "requestImageShare updateMsg info =" + paramazlb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurp
 * JD-Core Version:    0.7.0.1
 */