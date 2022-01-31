import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amkk
{
  public static int a = 1;
  public static int b = 2;
  public int c = b;
  
  private static amkk b(String paramString)
  {
    amkk localamkk = new amkk();
    try
    {
      localamkk.c = new JSONObject(paramString).optInt("action", b);
      return localamkk;
    }
    catch (Throwable paramString)
    {
      QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
    }
    return localamkk;
  }
  
  public boolean a()
  {
    return this.c == a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amkk
 * JD-Core Version:    0.7.0.1
 */