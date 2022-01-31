import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class arxm
  extends akil
{
  arxm(arxj paramarxj) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0)) {
      arxj.a(arxj.a(this.a), 1, paramString);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    if ((arxj.a(this.a).a() == 1) && (arxj.a(this.a).a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      if (arxj.a(this.a) != null)
      {
        arxj.a(this.a).finish();
        bcql.a(arxj.a(this.a), 2131693252, 1).a();
      }
      arxj.a(arxj.a(this.a), 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxm
 * JD-Core Version:    0.7.0.1
 */