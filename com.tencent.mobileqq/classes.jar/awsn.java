import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class awsn
  extends aojs
{
  awsn(awsk paramawsk) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0)) {
      awsk.a(awsk.a(this.a), 1, paramString);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    if ((awsk.a(this.a).a() == 1) && (awsk.a(this.a).a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      if (awsk.a(this.a) != null)
      {
        awsk.a(this.a).finish();
        QQToast.a(awsk.a(this.a), 2131692855, 1).a();
      }
      awsk.a(awsk.a(this.a), 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsn
 * JD-Core Version:    0.7.0.1
 */