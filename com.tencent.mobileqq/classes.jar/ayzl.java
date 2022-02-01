import android.text.TextUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class ayzl
  extends anyz
{
  ayzl(ayzg paramayzg) {}
  
  public void onGetSubAccountMsg(boolean paramBoolean, String paramString, bdxt parambdxt)
  {
    if (ayzg.a(this.a, paramString, parambdxt))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, subAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    ayzg.a(this.a, paramBoolean, paramString, true);
  }
  
  public void onSubAccountMsgNumConfirm(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (ayzg.a(this.a) == null)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("AccountPanel onSubAccountMsgNumConfirm isSuccess=").append(paramBoolean).append(" subUin=").append(paramString1).append(" set need2ConfirmMsgNum=");
      if (paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("AccountPanel", 2, paramBoolean + " nextAction=" + paramString2);
      if (paramString1.equals(ayzg.a(this.a).getUin())) {
        this.a.a(ayzg.a(this.a));
      }
      ayzg.a(this.a, null);
      return;
    }
  }
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, bdxu parambdxu)
  {
    if (ayzg.a(this.a, paramBoolean, paramString, parambdxu)) {
      return;
    }
    ayzg.a(this.a, paramBoolean, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzl
 * JD-Core Version:    0.7.0.1
 */