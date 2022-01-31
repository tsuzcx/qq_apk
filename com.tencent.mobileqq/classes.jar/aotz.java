import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aotz
{
  private Map<String, Long> a = new HashMap();
  
  public static aotz a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    localaotz = new aotz();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].a);
      Iterator localIterator = paramArrayOfaogf.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localaotz.a.put(str, Long.valueOf(paramArrayOfaogf.getLong(str)));
      }
      return localaotz;
    }
    catch (JSONException paramArrayOfaogf)
    {
      QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfaogf.getLocalizedMessage(), paramArrayOfaogf);
    }
  }
  
  public Map<String, Long> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aotz
 * JD-Core Version:    0.7.0.1
 */