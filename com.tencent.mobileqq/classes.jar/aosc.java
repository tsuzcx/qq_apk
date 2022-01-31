import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aosc
{
  public static int a = 1;
  public static int b = 2;
  public int c = b;
  
  private static aosc b(String paramString)
  {
    aosc localaosc = new aosc();
    try
    {
      localaosc.c = new JSONObject(paramString).optInt("action", b);
      return localaosc;
    }
    catch (Throwable paramString)
    {
      QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
    }
    return localaosc;
  }
  
  public boolean a()
  {
    return this.c == a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aosc
 * JD-Core Version:    0.7.0.1
 */