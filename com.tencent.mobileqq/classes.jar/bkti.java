import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class bkti
  extends bktm
{
  bkti(bkth parambkth)
  {
    super(null);
  }
  
  public boolean a(String paramString, bkuf parambkuf)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      bkth.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (parambkuf.a > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, parambkuf.toString() }));
      }
      this.a.put(paramString, parambkuf);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, parambkuf.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkti
 * JD-Core Version:    0.7.0.1
 */