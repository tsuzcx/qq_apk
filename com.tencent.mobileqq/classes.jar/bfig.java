import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class bfig
  extends bfik
{
  bfig(bfif parambfif)
  {
    super(null);
  }
  
  public boolean a(String paramString, bfjd parambfjd)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      bfif.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (parambfjd.a > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, parambfjd.toString() }));
      }
      this.a.put(paramString, parambfjd);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, parambfjd.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfig
 * JD-Core Version:    0.7.0.1
 */