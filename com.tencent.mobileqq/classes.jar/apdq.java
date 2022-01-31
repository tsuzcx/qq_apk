import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp;

class apdq
  implements bieg<WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp>
{
  apdq(apdn paramapdn, apeb paramapeb) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp paramWeiyunShareAddFromMobileQQMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink onFailed: errorCode[" + paramInt + "], errorMsg[" + paramString + "]");
    }
    if (this.jdField_a_of_type_Apeb != null) {
      this.jdField_a_of_type_Apeb.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp paramWeiyunShareAddFromMobileQQMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink succeed");
    }
    if (this.jdField_a_of_type_Apeb != null) {
      this.jdField_a_of_type_Apeb.a(paramWeiyunShareAddFromMobileQQMsgRsp.raw_url.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apdq
 * JD-Core Version:    0.7.0.1
 */