import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class avft
  extends andd
{
  avft(avfq paramavfq) {}
  
  protected void onPassiveExit(String paramString, int paramInt)
  {
    super.onPassiveExit(paramString, paramInt);
    if ((avfq.a(this.a).a() == 1) && (avfq.a(this.a).a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      if (avfq.a(this.a) != null)
      {
        avfq.a(this.a).finish();
        QQToast.a(avfq.a(this.a), 2131692906, 1).a();
      }
      avfq.a(avfq.a(this.a), 1, paramString);
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    super.onTroopManagerSuccess(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0)) {
      avfq.a(avfq.a(this.a), 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avft
 * JD-Core Version:    0.7.0.1
 */