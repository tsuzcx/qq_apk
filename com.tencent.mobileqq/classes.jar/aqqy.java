import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqqy
{
  public int a = -1;
  
  public static aqqy a(aqlg[] paramArrayOfaqlg)
  {
    aqqy localaqqy = new aqqy();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      int j = paramArrayOfaqlg.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaqlg[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((aqlg)localObject).a;
          try
          {
            a(new JSONObject((String)localObject), localaqqy);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localaqqy);
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
    return localaqqy;
  }
  
  private static void a(JSONObject paramJSONObject, aqqy paramaqqy)
  {
    if (paramJSONObject.has("showMode")) {
      paramaqqy.a = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqqy
 * JD-Core Version:    0.7.0.1
 */