import com.tencent.common.app.AppInterface;
import mqq.manager.Manager;

public class bevk
  implements Manager
{
  public beuo a;
  public beuo b;
  
  public beuo a(bhvb parambhvb)
  {
    if (this.b == null) {}
    try
    {
      parambhvb = new bhuw(parambhvb, 32);
      parambhvb.a();
      this.b = new bevo(parambhvb, true);
      return this.b;
    }
    finally {}
  }
  
  public beuo a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a == null) {}
      try
      {
        if (this.a == null) {
          this.a = new bevo(paramAppInterface.getHttpCommunicatort(), false);
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
      ((bevo)this.a).a();
    }
    if (this.b != null) {
      ((bevo)this.b).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevk
 * JD-Core Version:    0.7.0.1
 */