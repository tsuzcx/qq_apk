import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoxt
{
  private int a = -1;
  
  public static aoxt a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      paramArrayOfaoko = null;
    }
    aoxt localaoxt;
    do
    {
      return paramArrayOfaoko;
      localaoxt = new aoxt();
      try
      {
        localaoxt.a = new JSONObject(paramArrayOfaoko[0].a).getInt("show_limit");
        return localaoxt;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfaoko = localaoxt;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localaoxt;
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
 * Qualified Name:     aoxt
 * JD-Core Version:    0.7.0.1
 */