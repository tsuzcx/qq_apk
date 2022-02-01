import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class arhl
{
  private Map<String, arhm> a = new HashMap();
  
  public static arhl a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    localarhl = new arhl();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].a);
      Iterator localIterator = paramArrayOfaqxa.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfaqxa.getJSONObject(str);
        localarhl.a.put(str, arhm.a(localJSONObject));
      }
      return localarhl;
    }
    catch (JSONException paramArrayOfaqxa) {}
  }
  
  public static arhm a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (arhi.a() != null)) {
      return (arhm)arhi.a().a().get(paramString);
    }
    return null;
  }
  
  public Map<String, arhm> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhl
 * JD-Core Version:    0.7.0.1
 */