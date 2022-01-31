import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aogz
{
  private boolean a;
  
  public static aogz a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        aogz localaogz = new aogz();
        if (new JSONObject(paramString).optInt("showTakeSameEntrance", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localaogz.a = bool;
          return localaogz;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("PttAutoChangeProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aogz
 * JD-Core Version:    0.7.0.1
 */