import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aoyi
{
  private Map<String, Long> a = new HashMap();
  
  public static aoyi a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    localaoyi = new aoyi();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].a);
      Iterator localIterator = paramArrayOfaoko.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localaoyi.a.put(str, Long.valueOf(paramArrayOfaoko.getLong(str)));
      }
      return localaoyi;
    }
    catch (JSONException paramArrayOfaoko)
    {
      QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfaoko.getLocalizedMessage(), paramArrayOfaoko);
    }
  }
  
  public Map<String, Long> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoyi
 * JD-Core Version:    0.7.0.1
 */