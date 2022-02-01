import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bmfw
{
  private static HashMap<String, Long> a = new HashMap();
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      a.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  public static void b(String paramString)
  {
    if ((!QLog.isColorLevel()) || (!a.containsKey(paramString))) {
      return;
    }
    long l = ((Long)a.get(paramString)).longValue();
    a.remove(paramString);
    QLog.d("ElapseStat", 2, paramString + " elpase:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfw
 * JD-Core Version:    0.7.0.1
 */