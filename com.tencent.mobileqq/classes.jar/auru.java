import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgRsp;
import mqq.app.MobileQQ;

class auru
  implements boae<WeiyunPB.PwdVerifyMsgRsp>
{
  auru(aurp paramaurp, String paramString) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onFailed. errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    aurp.a(this.jdField_a_of_type_Aurp).a().a(false, 45, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onSucceed");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      boaf.a(aurp.a(this.jdField_a_of_type_Aurp).getApplication().getApplicationContext(), this.jdField_a_of_type_JavaLangString);
    }
    boaf.c(aurp.a(this.jdField_a_of_type_Aurp).getApplication().getApplicationContext(), true);
    aurp.a(this.jdField_a_of_type_Aurp).a().a(true, 45, new Object[] { Integer.valueOf(0), null, paramPwdVerifyMsgRsp.cs_sig.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auru
 * JD-Core Version:    0.7.0.1
 */