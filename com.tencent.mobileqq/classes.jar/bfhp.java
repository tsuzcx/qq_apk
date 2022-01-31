import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class bfhp
  extends bfht
{
  bfhp(bfho parambfho)
  {
    super(null);
  }
  
  public boolean a(String paramString, bfim parambfim)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      bfho.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (parambfim.a > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, parambfim.toString() }));
      }
      this.a.put(paramString, parambfim);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, parambfim.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfhp
 * JD-Core Version:    0.7.0.1
 */