import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aquz
{
  private Map<String, aqva> a = new HashMap();
  
  public static aquz a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    localaquz = new aquz();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].a);
      Iterator localIterator = paramArrayOfaqlg.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfaqlg.getJSONObject(str);
        localaquz.a.put(str, aqva.a(localJSONObject));
      }
      return localaquz;
    }
    catch (JSONException paramArrayOfaqlg) {}
  }
  
  public static aqva a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (aquw.a() != null)) {
      return (aqva)aquw.a().a().get(paramString);
    }
    return null;
  }
  
  public Map<String, aqva> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aquz
 * JD-Core Version:    0.7.0.1
 */