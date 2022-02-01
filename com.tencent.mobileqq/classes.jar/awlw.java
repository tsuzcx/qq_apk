import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class awlw
  extends aofu
{
  awlw(awlt paramawlt) {}
  
  protected void onPassiveExit(String paramString, int paramInt)
  {
    super.onPassiveExit(paramString, paramInt);
    if ((awlt.a(this.a).a() == 1) && (awlt.a(this.a).a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      if (awlt.a(this.a) != null)
      {
        awlt.a(this.a).finish();
        QQToast.a(awlt.a(this.a), 2131693012, 1).a();
      }
      awlt.a(awlt.a(this.a), 1, paramString);
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    super.onTroopManagerSuccess(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0)) {
      awlt.a(awlt.a(this.a), 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlw
 * JD-Core Version:    0.7.0.1
 */