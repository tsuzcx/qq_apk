import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class amhb
{
  private Map<String, amhc> a = new HashMap();
  
  public static amhb a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    localamhb = new amhb();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].a);
      Iterator localIterator = paramArrayOfalzs.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfalzs.getJSONObject(str);
        localamhb.a.put(str, amhc.a(localJSONObject));
      }
      return localamhb;
    }
    catch (JSONException paramArrayOfalzs) {}
  }
  
  public static amhc a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (amgy.a() != null)) {
      return (amhc)amgy.a().a().get(paramString);
    }
    return null;
  }
  
  public Map<String, amhc> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhb
 * JD-Core Version:    0.7.0.1
 */