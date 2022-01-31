import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.CSProcessorImpl;
import com.tencent.qqprotect.qsec.QSecFramework.IGoingUpHandler;

public class amdy
  implements QSecFramework.IGoingUpHandler
{
  public amdy(CSProcessorImpl paramCSProcessorImpl) {}
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if ((paramObject1 != null) && ((paramObject1 instanceof String)) && (paramObject2 != null) && ((paramObject2 instanceof byte[])))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.CSP", 2, String.format("Cookie: %08X, cmd: %s", new Object[] { Integer.valueOf(paramInt1), paramObject1 }));
      }
      if (paramInt1 != 0) {
        this.a.a((String)paramObject1, (byte[])paramObject2, new ameb(this.a, paramInt1));
      }
    }
    else
    {
      return 0;
    }
    this.a.a((String)paramObject1, (byte[])paramObject2, null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amdy
 * JD-Core Version:    0.7.0.1
 */