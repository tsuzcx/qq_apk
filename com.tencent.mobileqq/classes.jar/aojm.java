import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aojm
{
  private boolean a;
  
  public static aojm a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aojm localaojm = new aojm();
        localaojm.a = new JSONObject(paramString).optBoolean("needSeparatePersonWithGroup", false);
        return localaojm;
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
 * Qualified Name:     aojm
 * JD-Core Version:    0.7.0.1
 */