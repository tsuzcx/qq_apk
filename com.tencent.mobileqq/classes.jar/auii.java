import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdQueryMsgRsp;
import mqq.app.MobileQQ;

class auii
  implements bmsc<WeiyunPB.PwdQueryMsgRsp>
{
  auii(auie paramauie) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdQueryMsgRsp paramPwdQueryMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd, onFailed. errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    auie.a(this.a).getFileManagerNotifyCenter().a(false, 44, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdQueryMsgRsp paramPwdQueryMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd, onSucceed  need pwd[" + paramPwdQueryMsgRsp.pwd_open.get() + "]");
    }
    bmsd.a(auie.a(this.a).getApplication().getApplicationContext(), true);
    if (paramPwdQueryMsgRsp.pwd_open.get()) {
      bmsd.b(auie.a(this.a).getApplication().getApplicationContext(), true);
    }
    auie.a(this.a).getFileManagerNotifyCenter().a(true, 44, new Object[] { Integer.valueOf(0), null, Boolean.valueOf(paramPwdQueryMsgRsp.pwd_open.get()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auii
 * JD-Core Version:    0.7.0.1
 */