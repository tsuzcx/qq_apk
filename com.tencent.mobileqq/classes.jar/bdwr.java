import com.tencent.common.app.AppInterface;
import mqq.manager.Manager;

public class bdwr
  implements Manager
{
  public bdvu a;
  public bdvu b;
  
  public bdvu a(bguy parambguy)
  {
    if (this.b == null) {}
    try
    {
      parambguy = new bgut(parambguy, 32);
      parambguy.a();
      this.b = new bdwv(parambguy, true);
      return this.b;
    }
    finally {}
  }
  
  public bdvu a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a == null) {}
      try
      {
        if (this.a == null) {
          this.a = new bdwv(paramAppInterface.getHttpCommunicatort(), false);
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
      ((bdwv)this.a).a();
    }
    if (this.b != null) {
      ((bdwv)this.b).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwr
 * JD-Core Version:    0.7.0.1
 */