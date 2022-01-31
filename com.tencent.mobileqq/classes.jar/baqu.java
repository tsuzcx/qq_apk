import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import mqq.manager.Manager;

public class baqu
  implements Manager
{
  public bapv a;
  public bapv b;
  
  public bapv a(bdlp parambdlp)
  {
    if (this.b == null) {}
    try
    {
      parambdlp = new HttpCommunicator(parambdlp, 32);
      parambdlp.a();
      this.b = new baqy(parambdlp, true);
      return this.b;
    }
    finally {}
  }
  
  public bapv a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a == null) {}
      try
      {
        if (this.a == null) {
          this.a = new baqy(paramAppInterface.getHttpCommunicatort(), false);
        }
        return this.a;
      }
      finally {}
    }
    return null;
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      ((baqy)this.a).a();
    }
    if (this.b != null) {
      ((baqy)this.b).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqu
 * JD-Core Version:    0.7.0.1
 */