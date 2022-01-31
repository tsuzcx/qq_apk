import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anbq
{
  private Map<String, List<anbr>> a = new HashMap();
  
  public static anbq a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    localanbq = new anbq();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].a);
      Iterator localIterator = paramArrayOfampi.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfampi.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(anbr.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localanbq.a.put(str, localArrayList);
      }
      return localanbq;
    }
    catch (JSONException paramArrayOfampi)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfampi);
    }
  }
  
  public Map<String, List<anbr>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anbq
 * JD-Core Version:    0.7.0.1
 */