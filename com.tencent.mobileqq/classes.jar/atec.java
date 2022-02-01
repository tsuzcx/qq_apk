import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgRsp;
import mqq.app.MobileQQ;

class atec
  implements blfl<WeiyunPB.PwdVerifyMsgRsp>
{
  atec(atdx paramatdx, String paramString) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onFailed. errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    atdx.a(this.jdField_a_of_type_Atdx).getFileManagerNotifyCenter().a(false, 45, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onSucceed");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      blfm.a(atdx.a(this.jdField_a_of_type_Atdx).getApplication().getApplicationContext(), this.jdField_a_of_type_JavaLangString);
    }
    blfm.c(atdx.a(this.jdField_a_of_type_Atdx).getApplication().getApplicationContext(), true);
    atdx.a(this.jdField_a_of_type_Atdx).getFileManagerNotifyCenter().a(true, 45, new Object[] { Integer.valueOf(0), null, paramPwdVerifyMsgRsp.cs_sig.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atec
 * JD-Core Version:    0.7.0.1
 */