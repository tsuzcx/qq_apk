import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arpc
{
  public static int a = 1;
  public static int b = 2;
  public int c = b;
  
  private static arpc b(String paramString)
  {
    arpc localarpc = new arpc();
    try
    {
      localarpc.c = new JSONObject(paramString).optInt("action", b);
      return localarpc;
    }
    catch (Throwable paramString)
    {
      QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
    }
    return localarpc;
  }
  
  public boolean a()
  {
    return this.c == a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arpc
 * JD-Core Version:    0.7.0.1
 */