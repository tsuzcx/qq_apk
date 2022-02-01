import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class arqx
{
  private Map<String, Long> a = new HashMap();
  
  public static arqx a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    localarqx = new arqx();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].a);
      Iterator localIterator = paramArrayOfaraj.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localarqx.a.put(str, Long.valueOf(paramArrayOfaraj.getLong(str)));
      }
      return localarqx;
    }
    catch (JSONException paramArrayOfaraj)
    {
      QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfaraj.getLocalizedMessage(), paramArrayOfaraj);
    }
  }
  
  public Map<String, Long> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arqx
 * JD-Core Version:    0.7.0.1
 */