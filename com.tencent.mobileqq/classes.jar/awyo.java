import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class awyo
  extends awyp
{
  PeakAppInterface a;
  
  public awyo(PeakAppInterface paramPeakAppInterface)
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
      a(new biqe(this.a));
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
    a(paramToServiceMsg, null, axbp.class);
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    super.a(paramBoolean, paramToServiceMsg, paramFromServiceMsg, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyo
 * JD-Core Version:    0.7.0.1
 */