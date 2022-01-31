import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anav
{
  public static int a = 1;
  public static int b = 2;
  public int c = b;
  
  private static anav b(String paramString)
  {
    anav localanav = new anav();
    try
    {
      localanav.c = new JSONObject(paramString).optInt("action", b);
      return localanav;
    }
    catch (Throwable paramString)
    {
      QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
    }
    return localanav;
  }
  
  public boolean a()
  {
    return this.c == a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anav
 * JD-Core Version:    0.7.0.1
 */