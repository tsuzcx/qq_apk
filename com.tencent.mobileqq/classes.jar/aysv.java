import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import mqq.manager.Manager;

public class aysv
  implements Manager
{
  public ayry a;
  public ayry b;
  
  public ayry a(bbmh parambbmh)
  {
    if (this.b == null) {}
    try
    {
      parambbmh = new HttpCommunicator(parambbmh, 32);
      parambbmh.a();
      this.b = new aysz(parambbmh, true);
      return this.b;
    }
    finally {}
  }
  
  public ayry a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a == null) {}
      try
      {
        if (this.a == null) {
          this.a = new aysz(paramAppInterface.getHttpCommunicatort(), false);
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
      ((aysz)this.a).a();
    }
    if (this.b != null) {
      ((aysz)this.b).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aysv
 * JD-Core Version:    0.7.0.1
 */