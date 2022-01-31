import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class bdzz
  extends bead
{
  bdzz(bdzy parambdzy)
  {
    super(null);
  }
  
  public boolean a(String paramString, beaw parambeaw)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      bdzy.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (parambeaw.a > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, parambeaw.toString() }));
      }
      this.a.put(paramString, parambeaw);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, parambeaw.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdzz
 * JD-Core Version:    0.7.0.1
 */