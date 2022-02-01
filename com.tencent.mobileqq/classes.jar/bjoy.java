import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class bjoy
  extends WtloginObserver
{
  public bjoy(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "wtloginObserver.OnCloseCode userAccount=" + paramString + " ret=" + paramInt);
    if (paramInt == 0)
    {
      this.a.a(null);
      this.a.moveTaskToBack(true);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, anzj.a(2131710117) + paramInt + ")", 2000).a();
    this.a.a(null);
    this.a.moveTaskToBack(true);
  }
  
  public void onException(String paramString, int paramInt)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "wtloginObserver.OnException e=" + paramString);
    this.a.a(null);
    this.a.moveTaskToBack(true);
  }
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "wtloginObserver.OnVerifyCode userAccount=" + paramString + " ret=" + paramInt);
    if (paramInt == 0)
    {
      paramArrayOfByte1 = new ArrayList();
      this.a.a.closeCode(paramString, 16L, QuickLoginAuthorityActivity.a(this.a), 1, paramArrayOfByte1, QuickLoginAuthorityActivity.a(this.a));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, anzj.a(2131710116) + paramInt + ")", 2000).a();
    this.a.a(null);
    this.a.moveTaskToBack(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjoy
 * JD-Core Version:    0.7.0.1
 */