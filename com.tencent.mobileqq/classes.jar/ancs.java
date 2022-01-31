import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ancs
{
  private Map<String, Long> a = new HashMap();
  
  public static ancs a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    localancs = new ancs();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].a);
      Iterator localIterator = paramArrayOfamph.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localancs.a.put(str, Long.valueOf(paramArrayOfamph.getLong(str)));
      }
      return localancs;
    }
    catch (JSONException paramArrayOfamph)
    {
      QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfamph.getLocalizedMessage(), paramArrayOfamph);
    }
  }
  
  public Map<String, Long> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ancs
 * JD-Core Version:    0.7.0.1
 */