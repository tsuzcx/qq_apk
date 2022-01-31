import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import mqq.manager.Manager;

public class bavd
  implements Manager
{
  public baue a;
  public baue b;
  
  public baue a(bdpy parambdpy)
  {
    if (this.b == null) {}
    try
    {
      parambdpy = new HttpCommunicator(parambdpy, 32);
      parambdpy.a();
      this.b = new bavh(parambdpy, true);
      return this.b;
    }
    finally {}
  }
  
  public baue a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a == null) {}
      try
      {
        if (this.a == null) {
          this.a = new bavh(paramAppInterface.getHttpCommunicatort(), false);
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
      ((bavh)this.a).a();
    }
    if (this.b != null) {
      ((bavh)this.b).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavd
 * JD-Core Version:    0.7.0.1
 */