import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdQueryMsgRsp;
import mqq.app.MobileQQ;

class aray
  implements bkkj<WeiyunPB.PwdQueryMsgRsp>
{
  aray(arau paramarau) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdQueryMsgRsp paramPwdQueryMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd, onFailed. errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    arau.a(this.a).a().a(false, 44, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdQueryMsgRsp paramPwdQueryMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd, onSucceed  need pwd[" + paramPwdQueryMsgRsp.pwd_open.get() + "]");
    }
    bkkk.a(arau.a(this.a).getApplication().getApplicationContext(), true);
    if (paramPwdQueryMsgRsp.pwd_open.get()) {
      bkkk.b(arau.a(this.a).getApplication().getApplicationContext(), true);
    }
    arau.a(this.a).a().a(true, 44, new Object[] { Integer.valueOf(0), null, Boolean.valueOf(paramPwdQueryMsgRsp.pwd_open.get()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aray
 * JD-Core Version:    0.7.0.1
 */