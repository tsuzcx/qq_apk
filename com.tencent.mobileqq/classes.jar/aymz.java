import android.text.TextUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class aymz
  extends anqd
{
  aymz(aymu paramaymu) {}
  
  public void a(boolean paramBoolean, String paramString, bdej parambdej)
  {
    if (aymu.a(this.a, paramBoolean, paramString, parambdej)) {
      return;
    }
    aymu.a(this.a, paramBoolean, paramString, false);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (aymu.a(this.a) == null)) {
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
      if (paramString1.equals(aymu.a(this.a).getUin())) {
        this.a.a(aymu.a(this.a));
      }
      aymu.a(this.a, null);
      return;
    }
  }
  
  public void b(boolean paramBoolean, String paramString, bdei parambdei)
  {
    if (aymu.a(this.a, paramString, parambdei))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, subAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    aymu.a(this.a, paramBoolean, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymz
 * JD-Core Version:    0.7.0.1
 */