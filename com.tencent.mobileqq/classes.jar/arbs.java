import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class arbs
  extends ajuc
{
  arbs(arbp paramarbp) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0)) {
      arbp.a(arbp.a(this.a), 1, paramString);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    if ((arbp.a(this.a).a() == 1) && (arbp.a(this.a).a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      if (arbp.a(this.a) != null)
      {
        arbp.a(this.a).finish();
        bbmy.a(arbp.a(this.a), 2131627611, 1).a();
      }
      arbp.a(arbp.a(this.a), 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbs
 * JD-Core Version:    0.7.0.1
 */