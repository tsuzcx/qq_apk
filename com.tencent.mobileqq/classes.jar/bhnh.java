import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class bhnh
  extends bhnl
{
  bhnh(bhng parambhng)
  {
    super(null);
  }
  
  public boolean a(String paramString, bhoe parambhoe)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      bhng.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (parambhoe.a > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, parambhoe.toString() }));
      }
      this.a.put(paramString, parambhoe);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, parambhoe.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhnh
 * JD-Core Version:    0.7.0.1
 */