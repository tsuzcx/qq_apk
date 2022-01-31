import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aotc
{
  private Map<String, List<aotd>> a = new HashMap();
  
  public static aotc a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    localaotc = new aotc();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].a);
      Iterator localIterator = paramArrayOfaogf.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfaogf.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(aotd.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localaotc.a.put(str, localArrayList);
      }
      return localaotc;
    }
    catch (JSONException paramArrayOfaogf)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfaogf);
    }
  }
  
  public Map<String, List<aotd>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aotc
 * JD-Core Version:    0.7.0.1
 */