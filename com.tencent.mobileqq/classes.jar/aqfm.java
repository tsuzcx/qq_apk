import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class aqfm
  implements Manager
{
  private aqbu a;
  
  public aqfm()
  {
    QLog.d("ForwardSdkStatusManager", 1, "--> init");
    this.a = new aqbu();
  }
  
  public aqbu a()
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
 * Qualified Name:     aqfm
 * JD-Core Version:    0.7.0.1
 */