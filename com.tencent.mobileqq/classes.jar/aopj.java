import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aopj
{
  public int a = -1;
  
  public static aopj a(aoko[] paramArrayOfaoko)
  {
    aopj localaopj = new aopj();
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      int j = paramArrayOfaoko.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaoko[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((aoko)localObject).a;
          try
          {
            a(new JSONObject((String)localObject), localaopj);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localaopj);
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
    return localaopj;
  }
  
  private static void a(JSONObject paramJSONObject, aopj paramaopj)
  {
    if (paramJSONObject.has("showMode")) {
      paramaopj.a = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aopj
 * JD-Core Version:    0.7.0.1
 */