import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arqk
{
  private int a = -1;
  
  public static arqk a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      paramArrayOfaraj = null;
    }
    arqk localarqk;
    do
    {
      return paramArrayOfaraj;
      localarqk = new arqk();
      try
      {
        localarqk.a = new JSONObject(paramArrayOfaraj[0].a).getInt("show_limit");
        return localarqk;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfaraj = localarqk;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localarqk;
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
 * Qualified Name:     arqk
 * JD-Core Version:    0.7.0.1
 */