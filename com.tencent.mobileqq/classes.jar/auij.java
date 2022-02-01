import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgRsp;
import mqq.app.MobileQQ;

class auij
  implements bmsc<WeiyunPB.PwdVerifyMsgRsp>
{
  auij(auie paramauie, String paramString) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onFailed. errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    auie.a(this.jdField_a_of_type_Auie).getFileManagerNotifyCenter().a(false, 45, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onSucceed");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      bmsd.a(auie.a(this.jdField_a_of_type_Auie).getApplication().getApplicationContext(), this.jdField_a_of_type_JavaLangString);
    }
    bmsd.c(auie.a(this.jdField_a_of_type_Auie).getApplication().getApplicationContext(), true);
    auie.a(this.jdField_a_of_type_Auie).getFileManagerNotifyCenter().a(true, 45, new Object[] { Integer.valueOf(0), null, paramPwdVerifyMsgRsp.cs_sig.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auij
 * JD-Core Version:    0.7.0.1
 */