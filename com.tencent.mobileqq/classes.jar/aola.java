import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aola
{
  public int a = -1;
  
  public static aola a(aogf[] paramArrayOfaogf)
  {
    aola localaola = new aola();
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      int j = paramArrayOfaogf.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaogf[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((aogf)localObject).a;
          try
          {
            a(new JSONObject((String)localObject), localaola);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localaola);
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
    return localaola;
  }
  
  private static void a(JSONObject paramJSONObject, aola paramaola)
  {
    if (paramJSONObject.has("showMode")) {
      paramaola.a = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aola
 * JD-Core Version:    0.7.0.1
 */