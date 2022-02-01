import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aqee
{
  private Map<String, aqef> a = new HashMap();
  
  public static aqee a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    localaqee = new aqee();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].a);
      Iterator localIterator = paramArrayOfaptx.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfaptx.getJSONObject(str);
        localaqee.a.put(str, aqef.a(localJSONObject));
      }
      return localaqee;
    }
    catch (JSONException paramArrayOfaptx) {}
  }
  
  public static aqef a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (aqeb.a() != null)) {
      return (aqef)aqeb.a().a().get(paramString);
    }
    return null;
  }
  
  public Map<String, aqef> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqee
 * JD-Core Version:    0.7.0.1
 */