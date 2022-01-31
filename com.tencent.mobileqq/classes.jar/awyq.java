import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class awyq
  extends awyr
{
  PeakAppInterface a;
  
  public awyq(PeakAppInterface paramPeakAppInterface)
  {
    this.a = paramPeakAppInterface;
  }
  
  public AppInterface a()
  {
    return this.a;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      a(new biqv(this.a));
      super.b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg, null, axbr.class);
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    super.a(paramBoolean, paramToServiceMsg, paramFromServiceMsg, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyq
 * JD-Core Version:    0.7.0.1
 */