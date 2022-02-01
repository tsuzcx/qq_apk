import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class blbt
  extends blbx
{
  blbt(blbs paramblbs)
  {
    super(null);
  }
  
  public boolean a(String paramString, blcq paramblcq)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      blbs.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (paramblcq.a > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, paramblcq.toString() }));
      }
      this.a.put(paramString, paramblcq);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, paramblcq.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbt
 * JD-Core Version:    0.7.0.1
 */