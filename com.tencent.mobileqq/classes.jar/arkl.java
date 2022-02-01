import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class arkl
{
  private Map<String, arkm> a = new HashMap();
  
  public static arkl a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    localarkl = new arkl();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].a);
      Iterator localIterator = paramArrayOfaraj.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfaraj.getJSONObject(str);
        localarkl.a.put(str, arkm.a(localJSONObject));
      }
      return localarkl;
    }
    catch (JSONException paramArrayOfaraj) {}
  }
  
  public static arkm a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (arki.a() != null)) {
      return (arkm)arki.a().a().get(paramString);
    }
    return null;
  }
  
  public Map<String, arkm> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkl
 * JD-Core Version:    0.7.0.1
 */