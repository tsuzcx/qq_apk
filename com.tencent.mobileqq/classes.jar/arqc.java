import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arqc
{
  private Map<String, List<arqd>> a = new HashMap();
  
  public static arqc a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    localarqc = new arqc();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].a);
      Iterator localIterator = paramArrayOfaraj.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfaraj.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(arqd.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localarqc.a.put(str, localArrayList);
      }
      return localarqc;
    }
    catch (JSONException paramArrayOfaraj)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfaraj);
    }
  }
  
  public Map<String, List<arqd>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arqc
 * JD-Core Version:    0.7.0.1
 */