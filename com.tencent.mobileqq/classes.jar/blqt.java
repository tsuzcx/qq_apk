import android.text.TextUtils;
import android.util.Pair;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class blqt
{
  private static final HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_a_of_type_Int;
  private final ConcurrentHashMap<String, Pair<Integer, String>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put("obj_ownerid", Integer.valueOf(11));
    jdField_a_of_type_JavaUtilHashMap.put("obj_pos", Integer.valueOf(12));
    jdField_a_of_type_JavaUtilHashMap.put("mod", Integer.valueOf(16));
    jdField_a_of_type_JavaUtilHashMap.put("land_page", Integer.valueOf(42));
    jdField_a_of_type_JavaUtilHashMap.put("detailpage_from", Integer.valueOf(43));
    jdField_a_of_type_JavaUtilHashMap.put("algo_id", Integer.valueOf(44));
  }
  
  public blqt a()
  {
    blqt localblqt = new blqt();
    localblqt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
    return localblqt;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = bkyk.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!TextUtils.isEmpty((CharSequence)((Pair)localEntry.getValue()).second))
      {
        if (i > 0) {
          localStringBuilder.append('&');
        }
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append('=');
        localStringBuilder.append((String)((Pair)localEntry.getValue()).second);
        i += 1;
      }
    }
    return URLEncoder.encode(localStringBuilder.toString());
  }
  
  public String a(String paramString1, String paramString2)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (localInteger != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, new Pair(localInteger, paramString2));
    }
    return paramString2;
  }
  
  public List<String> a(List<String> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = null;
      return localObject;
    }
    if (paramList.size() > this.jdField_a_of_type_Int + 1) {}
    for (;;)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      for (;;)
      {
        localObject = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(((Map.Entry)localObject).getKey())) {
          paramList.set(((Integer)((Pair)((Map.Entry)localObject).getValue()).first).intValue(), ((Pair)((Map.Entry)localObject).getValue()).second);
        }
      }
      localObject = new ArrayList(this.jdField_a_of_type_Int + 1);
      ((List)localObject).addAll(paramList);
      paramList = (List<String>)localObject;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Int = 0;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDecoder.decode(paramString).split("&");
    int j = paramString.length;
    int i = 0;
    label35:
    String str1;
    int k;
    if (i < j)
    {
      str1 = paramString[i];
      k = str1.indexOf("=");
      if (k > 0) {
        break label66;
      }
    }
    for (;;)
    {
      i += 1;
      break label35;
      break;
      label66:
      String str2 = str1.substring(0, k);
      int m = str2.lastIndexOf("_");
      if (m > 0)
      {
        String str3 = str2.substring(m + 1, str2.length());
        if (TextUtils.isDigitsOnly(str3))
        {
          int n = Integer.parseInt(str3) - 2;
          if (n > 8)
          {
            if (n > this.jdField_a_of_type_Int) {
              this.jdField_a_of_type_Int = n;
            }
            str2 = str2.substring(0, m);
            str1 = str1.substring(k + 1, str1.length());
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, new Pair(Integer.valueOf(n), str1));
          }
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramInt <= 8)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, new Pair(Integer.valueOf(paramInt), paramString2));
  }
  
  @Deprecated
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    blqp.d = a("land_page", paramJSONObject.optString("land_page_id", blqp.d));
    blqp.b = a("obj_ownerid", paramJSONObject.optString("obj_ownerid", blqp.b));
    blqp.g = a("algo_id", paramJSONObject.optString("algo_id", "0"));
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    blqp.a = a("mod", paramJSONObject.optString("mod_18", blqp.a));
    blqp.e = a("obj_pos", paramJSONObject.optString("obj_pos_14", blqp.e));
    blqp.f = a("detailpage_from", paramJSONObject.optString("detailpage_from_45", blqp.f));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = bkyk.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!TextUtils.isEmpty((CharSequence)((Pair)localEntry.getValue()).second))
      {
        if (i > 0) {
          localStringBuilder.append('&');
        }
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append('_');
        localStringBuilder.append(((Integer)((Pair)localEntry.getValue()).first).intValue() + 2);
        localStringBuilder.append('=');
        localStringBuilder.append((String)((Pair)localEntry.getValue()).second);
        i += 1;
      }
    }
    return URLEncoder.encode(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqt
 * JD-Core Version:    0.7.0.1
 */