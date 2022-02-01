import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class bjhx
  extends bjib
{
  bjhx(bjhw parambjhw)
  {
    super(null);
  }
  
  public boolean a(String paramString, bjiu parambjiu)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      bjhw.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (parambjiu.a > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, parambjiu.toString() }));
      }
      this.a.put(paramString, parambjiu);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, parambjiu.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjhx
 * JD-Core Version:    0.7.0.1
 */