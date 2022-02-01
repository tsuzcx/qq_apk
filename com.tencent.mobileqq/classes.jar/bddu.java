import com.tencent.qphone.base.util.QLog;

public class bddu
{
  private bddn a;
  
  public bddu(bddn parambddn)
  {
    this.a = parambddn;
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
 * Qualified Name:     bddu
 * JD-Core Version:    0.7.0.1
 */