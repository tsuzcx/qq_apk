import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqka
{
  private Map<String, List<aqkb>> a = new HashMap();
  
  public static aqka a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    localaqka = new aqka();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].a);
      Iterator localIterator = paramArrayOfaptx.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfaptx.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(aqkb.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localaqka.a.put(str, localArrayList);
      }
      return localaqka;
    }
    catch (JSONException paramArrayOfaptx)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfaptx);
    }
  }
  
  public Map<String, List<aqkb>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqka
 * JD-Core Version:    0.7.0.1
 */