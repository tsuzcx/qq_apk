import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arnt
{
  private int a = -1;
  
  public static arnt a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      paramArrayOfaqxa = null;
    }
    arnt localarnt;
    do
    {
      return paramArrayOfaqxa;
      localarnt = new arnt();
      try
      {
        localarnt.a = new JSONObject(paramArrayOfaqxa[0].a).getInt("show_limit");
        return localarnt;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfaqxa = localarnt;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localarnt;
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
 * Qualified Name:     arnt
 * JD-Core Version:    0.7.0.1
 */