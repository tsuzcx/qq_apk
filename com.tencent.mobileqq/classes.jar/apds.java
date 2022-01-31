import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgRsp;
import mqq.app.MobileQQ;

class apds
  implements bieg<WeiyunPB.PwdVerifyMsgRsp>
{
  apds(apdn paramapdn) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onFailed. errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    apdn.a(this.a).a().a(false, 45, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onSucceed");
    }
    String str = bige.a(paramPwdVerifyMsgRsp.cs_sig.get());
    if (!TextUtils.isEmpty(str)) {
      bieh.a(apdn.a(this.a).getApplication().getApplicationContext(), str);
    }
    bieh.c(apdn.a(this.a).getApplication().getApplicationContext(), true);
    apdn.a(this.a).a().a(true, 45, new Object[] { Integer.valueOf(0), null, paramPwdVerifyMsgRsp.cs_sig.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apds
 * JD-Core Version:    0.7.0.1
 */