import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ammg
{
  private Map<String, Long> a = new HashMap();
  
  public static ammg a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    localammg = new ammg();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].a);
      Iterator localIterator = paramArrayOfalzs.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localammg.a.put(str, Long.valueOf(paramArrayOfalzs.getLong(str)));
      }
      return localammg;
    }
    catch (JSONException paramArrayOfalzs)
    {
      QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfalzs.getLocalizedMessage(), paramArrayOfalzs);
    }
  }
  
  public Map<String, Long> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ammg
 * JD-Core Version:    0.7.0.1
 */