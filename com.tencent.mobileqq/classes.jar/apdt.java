import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp;

class apdt
  implements bidp<WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp>
{
  apdt(apdj paramapdj, apdx paramapdx) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp paramAioPicAndVideoCopyToWeiyunMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "saveAioMedia2Weiyun Failed errorCode=" + paramInt + "; errorMsg=" + paramString);
    }
    if (this.jdField_a_of_type_Apdx != null) {
      this.jdField_a_of_type_Apdx.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp paramAioPicAndVideoCopyToWeiyunMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "saveAioMedia2Weiyun Success");
    }
    if (this.jdField_a_of_type_Apdx != null) {
      this.jdField_a_of_type_Apdx.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apdt
 * JD-Core Version:    0.7.0.1
 */