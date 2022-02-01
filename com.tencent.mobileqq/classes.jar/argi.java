import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class argi
{
  public int a = -1;
  
  public static argi a(araj[] paramArrayOfaraj)
  {
    argi localargi = new argi();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      int j = paramArrayOfaraj.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaraj[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((araj)localObject).a;
          try
          {
            a(new JSONObject((String)localObject), localargi);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localargi);
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
    return localargi;
  }
  
  private static void a(JSONObject paramJSONObject, argi paramargi)
  {
    if (paramJSONObject.has("showMode")) {
      paramargi.a = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argi
 * JD-Core Version:    0.7.0.1
 */