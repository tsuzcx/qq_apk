import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class amxe
{
  private Map<String, amxf> a = new HashMap();
  
  public static amxe a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    localamxe = new amxe();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].a);
      Iterator localIterator = paramArrayOfamph.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfamph.getJSONObject(str);
        localamxe.a.put(str, amxf.a(localJSONObject));
      }
      return localamxe;
    }
    catch (JSONException paramArrayOfamph) {}
  }
  
  public static amxf a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (amxb.a() != null)) {
      return (amxf)amxb.a().a().get(paramString);
    }
    return null;
  }
  
  public Map<String, amxf> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxe
 * JD-Core Version:    0.7.0.1
 */