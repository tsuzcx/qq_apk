import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amcn
{
  private boolean a;
  
  public static amcn a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amcn localamcn = new amcn();
        localamcn.a = new JSONObject(paramString).optBoolean("needSeparatePersonWithGroup", false);
        return localamcn;
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
 * Qualified Name:     amcn
 * JD-Core Version:    0.7.0.1
 */