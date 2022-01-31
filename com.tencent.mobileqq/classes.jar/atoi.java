import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class atoi
  extends amab
{
  atoi(atof paramatof) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0)) {
      atof.a(atof.a(this.a), 1, paramString);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    if ((atof.a(this.a).a() == 1) && (atof.a(this.a).a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      if (atof.a(this.a) != null)
      {
        atof.a(this.a).finish();
        QQToast.a(atof.a(this.a), 2131693353, 1).a();
      }
      atof.a(atof.a(this.a), 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atoi
 * JD-Core Version:    0.7.0.1
 */