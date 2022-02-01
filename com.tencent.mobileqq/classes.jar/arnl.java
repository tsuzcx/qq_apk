import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arnl
{
  private Map<String, List<arnm>> a = new HashMap();
  
  public static arnl a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    localarnl = new arnl();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].a);
      Iterator localIterator = paramArrayOfaqxa.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfaqxa.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(arnm.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localarnl.a.put(str, localArrayList);
      }
      return localarnl;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfaqxa);
    }
  }
  
  public Map<String, List<arnm>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnl
 * JD-Core Version:    0.7.0.1
 */