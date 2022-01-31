import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ancn
{
  private Map<String, Long> a = new HashMap();
  
  public static ancn a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    localancn = new ancn();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].a);
      Iterator localIterator = paramArrayOfampi.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localancn.a.put(str, Long.valueOf(paramArrayOfampi.getLong(str)));
      }
      return localancn;
    }
    catch (JSONException paramArrayOfampi)
    {
      QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfampi.getLocalizedMessage(), paramArrayOfampi);
    }
  }
  
  public Map<String, Long> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ancn
 * JD-Core Version:    0.7.0.1
 */