import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqki
{
  private int a = -1;
  
  public static aqki a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      paramArrayOfaptx = null;
    }
    aqki localaqki;
    do
    {
      return paramArrayOfaptx;
      localaqki = new aqki();
      try
      {
        localaqki.a = new JSONObject(paramArrayOfaptx[0].a).getInt("show_limit");
        return localaqki;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfaptx = localaqki;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localaqki;
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
 * Qualified Name:     aqki
 * JD-Core Version:    0.7.0.1
 */