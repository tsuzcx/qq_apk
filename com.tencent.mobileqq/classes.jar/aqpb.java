import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqpb
{
  public boolean a;
  
  public static aqpb a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        aqpb localaqpb = new aqpb();
        if (new JSONObject(paramString).optInt("openSwitch", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localaqpb.a = bool;
          return localaqpb;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("GlobalSearchConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpb
 * JD-Core Version:    0.7.0.1
 */