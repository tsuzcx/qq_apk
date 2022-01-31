import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class aqzd
  extends ajuc
{
  aqzd(aqzc paramaqzc) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "onTroopManagerSuccess: invoked. 主动退群 or 解散群", " reqtype: ", Integer.valueOf(paramInt1), " troopUin: ", paramString });
      }
      arbp.a(this.a.app, 1, paramString);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if ((localBaseActivity != null) && (this.a.a.a())) {
        bbmy.a(localBaseActivity, 2131627611, 1).a();
      }
      arbp.a(this.a.app, 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqzd
 * JD-Core Version:    0.7.0.1
 */