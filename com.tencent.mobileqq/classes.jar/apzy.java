import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class apzy
{
  public int a = -1;
  
  public static apzy a(aptx[] paramArrayOfaptx)
  {
    apzy localapzy = new apzy();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      int j = paramArrayOfaptx.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaptx[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((aptx)localObject).a;
          try
          {
            a(new JSONObject((String)localObject), localapzy);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localapzy);
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
    return localapzy;
  }
  
  private static void a(JSONObject paramJSONObject, apzy paramapzy)
  {
    if (paramJSONObject.has("showMode")) {
      paramapzy.a = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apzy
 * JD-Core Version:    0.7.0.1
 */