import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aotk
{
  private int a = -1;
  
  public static aotk a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      paramArrayOfaogf = null;
    }
    aotk localaotk;
    do
    {
      return paramArrayOfaogf;
      localaotk = new aotk();
      try
      {
        localaotk.a = new JSONObject(paramArrayOfaogf[0].a).getInt("show_limit");
        return localaotk;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfaogf = localaotk;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localaotk;
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
 * Qualified Name:     aotk
 * JD-Core Version:    0.7.0.1
 */