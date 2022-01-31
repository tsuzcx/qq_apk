import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgRsp;
import mqq.app.MobileQQ;

class apdo
  implements bidp<WeiyunPB.PwdVerifyMsgRsp>
{
  apdo(apdj paramapdj) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onFailed. errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    apdj.a(this.a).a().a(false, 45, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onSucceed");
    }
    String str = bifn.a(paramPwdVerifyMsgRsp.cs_sig.get());
    if (!TextUtils.isEmpty(str)) {
      bidq.a(apdj.a(this.a).getApplication().getApplicationContext(), str);
    }
    bidq.c(apdj.a(this.a).getApplication().getApplicationContext(), true);
    apdj.a(this.a).a().a(true, 45, new Object[] { Integer.valueOf(0), null, paramPwdVerifyMsgRsp.cs_sig.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apdo
 * JD-Core Version:    0.7.0.1
 */