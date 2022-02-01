import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class arog
{
  private Map<String, Long> a = new HashMap();
  
  public static arog a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    localarog = new arog();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].a);
      Iterator localIterator = paramArrayOfaqxa.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localarog.a.put(str, Long.valueOf(paramArrayOfaqxa.getLong(str)));
      }
      return localarog;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfaqxa.getLocalizedMessage(), paramArrayOfaqxa);
    }
  }
  
  public Map<String, Long> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arog
 * JD-Core Version:    0.7.0.1
 */