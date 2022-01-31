import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ancd
{
  private int a = -1;
  
  public static ancd a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      paramArrayOfamph = null;
    }
    ancd localancd;
    do
    {
      return paramArrayOfamph;
      localancd = new ancd();
      try
      {
        localancd.a = new JSONObject(paramArrayOfamph[0].a).getInt("show_limit");
        return localancd;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfamph = localancd;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localancd;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean a()
  {
    return this.a == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ancd
 * JD-Core Version:    0.7.0.1
 */