import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anao
{
  public static int a = 1;
  public static int b = 2;
  public int c = b;
  
  private static anao b(String paramString)
  {
    anao localanao = new anao();
    try
    {
      localanao.c = new JSONObject(paramString).optInt("action", b);
      return localanao;
    }
    catch (Throwable paramString)
    {
      QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
    }
    return localanao;
  }
  
  public boolean a()
  {
    return this.c == a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anao
 * JD-Core Version:    0.7.0.1
 */