import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aosu
{
  private Map<String, aosv> a = new HashMap();
  
  public static aosu a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    localaosu = new aosu();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].a);
      Iterator localIterator = paramArrayOfaoko.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfaoko.getJSONObject(str);
        localaosu.a.put(str, aosv.a(localJSONObject));
      }
      return localaosu;
    }
    catch (JSONException paramArrayOfaoko) {}
  }
  
  public static aosv a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (aosr.a() != null)) {
      return (aosv)aosr.a().a().get(paramString);
    }
    return null;
  }
  
  public Map<String, aosv> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aosu
 * JD-Core Version:    0.7.0.1
 */