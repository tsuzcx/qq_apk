import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aool
{
  private Map<String, aoom> a = new HashMap();
  
  public static aool a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    localaool = new aool();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].a);
      Iterator localIterator = paramArrayOfaogf.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfaogf.getJSONObject(str);
        localaool.a.put(str, aoom.a(localJSONObject));
      }
      return localaool;
    }
    catch (JSONException paramArrayOfaogf) {}
  }
  
  public static aoom a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (aooi.a() != null)) {
      return (aoom)aooi.a().a().get(paramString);
    }
    return null;
  }
  
  public Map<String, aoom> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aool
 * JD-Core Version:    0.7.0.1
 */