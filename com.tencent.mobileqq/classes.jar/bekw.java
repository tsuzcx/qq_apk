import com.tencent.qphone.base.util.QLog;

public class bekw
{
  private bekp a;
  
  public bekw(bekp parambekp)
  {
    this.a = parambekp;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockView", 2, "notifyChanged : nEventId = " + paramInt);
    }
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekw
 * JD-Core Version:    0.7.0.1
 */