import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp;

class aomr
  implements bgun<WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp>
{
  aomr(aomp paramaomp, aonc paramaonc) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp paramWeiyunShareAddFromMobileQQMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink onFailed: errorCode[" + paramInt + "], errorMsg[" + paramString + "]");
    }
    if (this.jdField_a_of_type_Aonc != null) {
      this.jdField_a_of_type_Aonc.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp paramWeiyunShareAddFromMobileQQMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink succeed");
    }
    if (this.jdField_a_of_type_Aonc != null) {
      this.jdField_a_of_type_Aonc.a(paramWeiyunShareAddFromMobileQQMsgRsp.raw_url.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomr
 * JD-Core Version:    0.7.0.1
 */