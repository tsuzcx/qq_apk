import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework.IGoingUpHandler;
import com.tencent.qqprotect.qsec.RptImpl;

public class amfl
  implements QSecFramework.IGoingUpHandler
{
  public amfl(RptImpl paramRptImpl) {}
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if ((paramObject1 != null) && ((paramObject1 instanceof String)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.Rpt", 2, String.format("Op: %d, Rid: %d, val: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), (String)paramObject1 }));
      }
      this.a.a(paramInt1, paramInt2, (String)paramObject1);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amfl
 * JD-Core Version:    0.7.0.1
 */