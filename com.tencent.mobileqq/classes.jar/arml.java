import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arml
{
  public static int a = 1;
  public static int b = 2;
  public int c = b;
  
  private static arml b(String paramString)
  {
    arml localarml = new arml();
    try
    {
      localarml.c = new JSONObject(paramString).optInt("action", b);
      return localarml;
    }
    catch (Throwable paramString)
    {
      QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
    }
    return localarml;
  }
  
  public boolean a()
  {
    return this.c == a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arml
 * JD-Core Version:    0.7.0.1
 */