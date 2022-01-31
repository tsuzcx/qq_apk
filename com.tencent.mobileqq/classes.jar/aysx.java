import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import mqq.manager.Manager;

public class aysx
  implements Manager
{
  public aysa a;
  public aysa b;
  
  public aysa a(bbmv parambbmv)
  {
    if (this.b == null) {}
    try
    {
      parambbmv = new HttpCommunicator(parambbmv, 32);
      parambbmv.a();
      this.b = new aytb(parambbmv, true);
      return this.b;
    }
    finally {}
  }
  
  public aysa a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a == null) {}
      try
      {
        if (this.a == null) {
          this.a = new aytb(paramAppInterface.getHttpCommunicatort(), false);
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
      ((aytb)this.a).a();
    }
    if (this.b != null) {
      ((aytb)this.b).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aysx
 * JD-Core Version:    0.7.0.1
 */