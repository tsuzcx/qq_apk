import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aral
{
  private Map<String, List<aram>> a = new HashMap();
  
  public static aral a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    localaral = new aral();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].a);
      Iterator localIterator = paramArrayOfaqlg.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfaqlg.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(aram.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localaral.a.put(str, localArrayList);
      }
      return localaral;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfaqlg);
    }
  }
  
  public Map<String, List<aram>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aral
 * JD-Core Version:    0.7.0.1
 */