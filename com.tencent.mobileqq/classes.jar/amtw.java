import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amtw
{
  public int a = -1;
  
  public static amtw a(amph[] paramArrayOfamph)
  {
    amtw localamtw = new amtw();
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      int j = paramArrayOfamph.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfamph[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((amph)localObject).a;
          try
          {
            a(new JSONObject((String)localObject), localamtw);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localamtw);
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
    return localamtw;
  }
  
  private static void a(JSONObject paramJSONObject, amtw paramamtw)
  {
    if (paramJSONObject.has("showMode")) {
      paramamtw.a = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amtw
 * JD-Core Version:    0.7.0.1
 */