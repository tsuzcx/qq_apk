import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aqkv
{
  private Map<String, Long> a = new HashMap();
  
  public static aqkv a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    localaqkv = new aqkv();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].a);
      Iterator localIterator = paramArrayOfaptx.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localaqkv.a.put(str, Long.valueOf(paramArrayOfaptx.getLong(str)));
      }
      return localaqkv;
    }
    catch (JSONException paramArrayOfaptx)
    {
      QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfaptx.getLocalizedMessage(), paramArrayOfaptx);
    }
  }
  
  public Map<String, Long> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqkv
 * JD-Core Version:    0.7.0.1
 */