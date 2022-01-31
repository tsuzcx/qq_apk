import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class bhja
  extends bhje
{
  bhja(bhiz parambhiz)
  {
    super(null);
  }
  
  public boolean a(String paramString, bhjx parambhjx)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      bhiz.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (parambhjx.a > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, parambhjx.toString() }));
      }
      this.a.put(paramString, parambhjx);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, parambhjx.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhja
 * JD-Core Version:    0.7.0.1
 */