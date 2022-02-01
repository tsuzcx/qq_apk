import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqpc
{
  private boolean a;
  
  public static aqpc a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqpc localaqpc = new aqpc();
        localaqpc.a = new JSONObject(paramString).optBoolean("needSeparatePersonWithGroup", false);
        return localaqpc;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("GlobalSearchConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "needSeparate:" + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpc
 * JD-Core Version:    0.7.0.1
 */