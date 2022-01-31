import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anbv
{
  private Map<String, List<anbw>> a = new HashMap();
  
  public static anbv a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    localanbv = new anbv();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].a);
      Iterator localIterator = paramArrayOfamph.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfamph.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(anbw.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localanbv.a.put(str, localArrayList);
      }
      return localanbv;
    }
    catch (JSONException paramArrayOfamph)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfamph);
    }
  }
  
  public Map<String, List<anbw>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anbv
 * JD-Core Version:    0.7.0.1
 */