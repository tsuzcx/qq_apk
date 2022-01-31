import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amlm
{
  private Map<String, List<amln>> a = new HashMap();
  
  public static amlm a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    localamlm = new amlm();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].a);
      Iterator localIterator = paramArrayOfalzs.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfalzs.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(amln.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localamlm.a.put(str, localArrayList);
      }
      return localamlm;
    }
    catch (JSONException paramArrayOfalzs)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfalzs);
    }
  }
  
  public Map<String, List<amln>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amlm
 * JD-Core Version:    0.7.0.1
 */