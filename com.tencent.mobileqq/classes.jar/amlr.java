import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amlr
{
  private int a = -1;
  
  public static amlr a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      paramArrayOfalzs = null;
    }
    amlr localamlr;
    do
    {
      return paramArrayOfalzs;
      localamlr = new amlr();
      try
      {
        localamlr.a = new JSONObject(paramArrayOfalzs[0].a).getInt("show_limit");
        return localamlr;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfalzs = localamlr;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localamlr;
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
 * Qualified Name:     amlr
 * JD-Core Version:    0.7.0.1
 */