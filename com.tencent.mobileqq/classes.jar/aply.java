import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class aply
  implements Manager
{
  private apih a;
  
  public aply()
  {
    QLog.d("ForwardSdkStatusManager", 1, "--> init");
    this.a = new apih();
  }
  
  public apih a()
  {
    return this.a;
  }
  
  public void onDestroy()
  {
    QLog.d("ForwardSdkStatusManager", 1, "--> onDestroy");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aply
 * JD-Core Version:    0.7.0.1
 */