import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class amxf
{
  private Map<String, amxg> a = new HashMap();
  
  public static amxf a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    localamxf = new amxf();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].a);
      Iterator localIterator = paramArrayOfampi.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfampi.getJSONObject(str);
        localamxf.a.put(str, amxg.a(localJSONObject));
      }
      return localamxf;
    }
    catch (JSONException paramArrayOfampi) {}
  }
  
  public static amxg a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (amxc.a() != null)) {
      return (amxg)amxc.a().a().get(paramString);
    }
    return null;
  }
  
  public Map<String, amxg> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxf
 * JD-Core Version:    0.7.0.1
 */