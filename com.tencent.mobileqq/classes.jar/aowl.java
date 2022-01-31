import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aowl
{
  public static int a = 1;
  public static int b = 2;
  public int c = b;
  
  private static aowl b(String paramString)
  {
    aowl localaowl = new aowl();
    try
    {
      localaowl.c = new JSONObject(paramString).optInt("action", b);
      return localaowl;
    }
    catch (Throwable paramString)
    {
      QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
    }
    return localaowl;
  }
  
  public boolean a()
  {
    return this.c == a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aowl
 * JD-Core Version:    0.7.0.1
 */