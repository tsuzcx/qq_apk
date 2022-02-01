import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ardb
{
  public int a = -1;
  
  public static ardb a(aqxa[] paramArrayOfaqxa)
  {
    ardb localardb = new ardb();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      int j = paramArrayOfaqxa.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaqxa[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((aqxa)localObject).a;
          try
          {
            a(new JSONObject((String)localObject), localardb);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localardb);
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
    return localardb;
  }
  
  private static void a(JSONObject paramJSONObject, ardb paramardb)
  {
    if (paramJSONObject.has("showMode")) {
      paramardb.a = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardb
 * JD-Core Version:    0.7.0.1
 */