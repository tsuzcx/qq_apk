import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class awja
  extends aofu
{
  awja(awiz paramawiz) {}
  
  protected void onPassiveExit(String paramString, int paramInt)
  {
    super.onPassiveExit(paramString, paramInt);
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if ((localBaseActivity != null) && (this.a.a.a())) {
        QQToast.a(localBaseActivity, 2131693012, 1).a();
      }
      awlt.a(this.a.app, 1, paramString);
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    super.onTroopManagerSuccess(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "onTroopManagerSuccess: invoked. 主动退群 or 解散群", " reqtype: ", Integer.valueOf(paramInt1), " troopUin: ", paramString });
      }
      awlt.a(this.a.app, 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awja
 * JD-Core Version:    0.7.0.1
 */