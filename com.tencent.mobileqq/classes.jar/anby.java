import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anby
{
  private int a = -1;
  
  public static anby a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      paramArrayOfampi = null;
    }
    anby localanby;
    do
    {
      return paramArrayOfampi;
      localanby = new anby();
      try
      {
        localanby.a = new JSONObject(paramArrayOfampi[0].a).getInt("show_limit");
        return localanby;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfampi = localanby;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localanby;
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
 * Qualified Name:     anby
 * JD-Core Version:    0.7.0.1
 */