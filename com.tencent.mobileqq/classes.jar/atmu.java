import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class atmu
  implements ayeo
{
  public atmu(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(ayep paramayep)
  {
    this.a.jdField_a_of_type_JavaUtilMap.put(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord, paramayep);
    QLog.d(atms.a(), 1, new Object[] { "requestImageShare onSend result =", paramayep, ", isTimeOut=", Boolean.valueOf(atms.a(this.a.this$0)) });
    if (this.a.jdField_a_of_type_JavaUtilMap.size() == atms.a(this.a.this$0).size())
    {
      atqa.b("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      atms.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void updateMsg(ayep paramayep)
  {
    if (paramayep != null) {
      QLog.d(atms.a(), 1, "requestImageShare updateMsg info =" + paramayep);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmu
 * JD-Core Version:    0.7.0.1
 */