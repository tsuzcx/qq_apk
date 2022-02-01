import android.text.TextUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class azfs
  extends aocj
{
  azfs(azfn paramazfn) {}
  
  public void a(boolean paramBoolean, String paramString, bdxe parambdxe)
  {
    if (azfn.a(this.a, paramBoolean, paramString, parambdxe)) {
      return;
    }
    azfn.a(this.a, paramBoolean, paramString, false);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (azfn.a(this.a) == null)) {
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
      if (paramString1.equals(azfn.a(this.a).getUin())) {
        this.a.a(azfn.a(this.a));
      }
      azfn.a(this.a, null);
      return;
    }
  }
  
  public void b(boolean paramBoolean, String paramString, bdxd parambdxd)
  {
    if (azfn.a(this.a, paramString, parambdxd))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, subAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    azfn.a(this.a, paramBoolean, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfs
 * JD-Core Version:    0.7.0.1
 */