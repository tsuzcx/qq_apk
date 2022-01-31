import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoli
{
  private boolean a;
  
  public static aoli a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        aoli localaoli = new aoli();
        if (new JSONObject(paramString).optInt("showTakeSameEntrance", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localaoli.a = bool;
          return localaoli;
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
 * Qualified Name:     aoli
 * JD-Core Version:    0.7.0.1
 */