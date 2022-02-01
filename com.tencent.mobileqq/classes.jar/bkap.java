import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class bkap
  extends bkat
{
  bkap(bkao parambkao)
  {
    super(null);
  }
  
  public boolean a(String paramString, bkbm parambkbm)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      bkao.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (parambkbm.a > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, parambkbm.toString() }));
      }
      this.a.put(paramString, parambkbm);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, parambkbm.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkap
 * JD-Core Version:    0.7.0.1
 */