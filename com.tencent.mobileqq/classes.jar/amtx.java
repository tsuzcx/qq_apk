import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amtx
{
  public int a = -1;
  
  public static amtx a(ampi[] paramArrayOfampi)
  {
    amtx localamtx = new amtx();
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      int j = paramArrayOfampi.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfampi[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((ampi)localObject).a;
          try
          {
            a(new JSONObject((String)localObject), localamtx);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localamtx);
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
    return localamtx;
  }
  
  private static void a(JSONObject paramJSONObject, amtx paramamtx)
  {
    if (paramJSONObject.has("showMode")) {
      paramamtx.a = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amtx
 * JD-Core Version:    0.7.0.1
 */