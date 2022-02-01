import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp;

class auih
  implements bmsc<WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp>
{
  auih(auie paramauie, auir paramauir) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp paramWeiyunShareAddFromMobileQQMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink onFailed: errorCode[" + paramInt + "], errorMsg[" + paramString + "]");
    }
    if (this.jdField_a_of_type_Auir != null) {
      this.jdField_a_of_type_Auir.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp paramWeiyunShareAddFromMobileQQMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink succeed");
    }
    if (this.jdField_a_of_type_Auir != null) {
      this.jdField_a_of_type_Auir.a(paramWeiyunShareAddFromMobileQQMsgRsp.raw_url.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auih
 * JD-Core Version:    0.7.0.1
 */