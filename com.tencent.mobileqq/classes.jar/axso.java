import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import mqq.manager.Manager;

public class axso
  implements Manager
{
  public axrr a;
  public axrr b;
  
  public axrr a(bakx parambakx)
  {
    if (this.b == null) {}
    try
    {
      parambakx = new HttpCommunicator(parambakx, 32);
      parambakx.a();
      this.b = new axss(parambakx, true);
      return this.b;
    }
    finally {}
  }
  
  public axrr a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a == null) {}
      try
      {
        if (this.a == null) {
          this.a = new axss(paramAppInterface.getHttpCommunicatort(), false);
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
      ((axss)this.a).a();
    }
    if (this.b != null) {
      ((axss)this.b).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axso
 * JD-Core Version:    0.7.0.1
 */