import android.text.TextUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class axta
  extends amwl
{
  axta(axsv paramaxsv) {}
  
  public void onGetSubAccountMsg(boolean paramBoolean, String paramString, bcqu parambcqu)
  {
    if (axsv.a(this.a, paramString, parambcqu))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, subAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    axsv.a(this.a, paramBoolean, paramString, true);
  }
  
  public void onSubAccountMsgNumConfirm(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (axsv.a(this.a) == null)) {
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
      if (paramString1.equals(axsv.a(this.a).getUin())) {
        this.a.a(axsv.a(this.a));
      }
      axsv.a(this.a, null);
      return;
    }
  }
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, bcqv parambcqv)
  {
    if (axsv.a(this.a, paramBoolean, paramString, parambcqv)) {
      return;
    }
    axsv.a(this.a, paramBoolean, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axta
 * JD-Core Version:    0.7.0.1
 */