import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arat
{
  private int a = -1;
  
  public static arat a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      paramArrayOfaqlg = null;
    }
    arat localarat;
    do
    {
      return paramArrayOfaqlg;
      localarat = new arat();
      try
      {
        localarat.a = new JSONObject(paramArrayOfaqlg[0].a).getInt("show_limit");
        return localarat;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfaqlg = localarat;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localarat;
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
 * Qualified Name:     arat
 * JD-Core Version:    0.7.0.1
 */