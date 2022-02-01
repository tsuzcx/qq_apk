import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class arbi
{
  private Map<String, Long> a = new HashMap();
  
  public static arbi a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    localarbi = new arbi();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].a);
      Iterator localIterator = paramArrayOfaqlg.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localarbi.a.put(str, Long.valueOf(paramArrayOfaqlg.getLong(str)));
      }
      return localarbi;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfaqlg.getLocalizedMessage(), paramArrayOfaqlg);
    }
  }
  
  public Map<String, Long> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbi
 * JD-Core Version:    0.7.0.1
 */