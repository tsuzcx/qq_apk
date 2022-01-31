import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amdr
{
  public int a = -1;
  
  public static amdr a(alzs[] paramArrayOfalzs)
  {
    amdr localamdr = new amdr();
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      int j = paramArrayOfalzs.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfalzs[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((alzs)localObject).a;
          try
          {
            a(new JSONObject((String)localObject), localamdr);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localamdr);
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    return localamdr;
  }
  
  private static void a(JSONObject paramJSONObject, amdr paramamdr)
  {
    if (paramJSONObject.has("showMode")) {
      paramamdr.a = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdr
 * JD-Core Version:    0.7.0.1
 */