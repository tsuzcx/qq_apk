import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqja
{
  public static int a = 1;
  public static int b = 2;
  public int c = b;
  
  private static aqja b(String paramString)
  {
    aqja localaqja = new aqja();
    try
    {
      localaqja.c = new JSONObject(paramString).optInt("action", b);
      return localaqja;
    }
    catch (Throwable paramString)
    {
      QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
    }
    return localaqja;
  }
  
  public boolean a()
  {
    return this.c == a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqja
 * JD-Core Version:    0.7.0.1
 */