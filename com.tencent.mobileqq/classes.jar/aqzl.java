import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqzl
{
  public static int a = 1;
  public static int b = 2;
  public int c = b;
  
  private static aqzl b(String paramString)
  {
    aqzl localaqzl = new aqzl();
    try
    {
      localaqzl.c = new JSONObject(paramString).optInt("action", b);
      return localaqzl;
    }
    catch (Throwable paramString)
    {
      QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
    }
    return localaqzl;
  }
  
  public boolean a()
  {
    return this.c == a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzl
 * JD-Core Version:    0.7.0.1
 */