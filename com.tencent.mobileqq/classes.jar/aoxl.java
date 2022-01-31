import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoxl
{
  private Map<String, List<aoxm>> a = new HashMap();
  
  public static aoxl a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    localaoxl = new aoxl();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].a);
      Iterator localIterator = paramArrayOfaoko.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfaoko.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(aoxm.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localaoxl.a.put(str, localArrayList);
      }
      return localaoxl;
    }
    catch (JSONException paramArrayOfaoko)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfaoko);
    }
  }
  
  public Map<String, List<aoxm>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoxl
 * JD-Core Version:    0.7.0.1
 */