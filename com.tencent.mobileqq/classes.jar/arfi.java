import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arfi
{
  public String a;
  public ArrayList<Long> a;
  public HashMap<Long, axtg> a;
  public String b;
  public ArrayList<Long> b;
  public String c;
  public ArrayList<Long> c;
  public String d;
  public ArrayList<Long> d;
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "https://static-res.qq.com/static-res/interactiveResource";
  
  public arfi()
  {
    this.jdField_a_of_type_JavaLangString = "aHR0cDovL2QudXJsLmNuL215YXBwL3FxX2Rlc2svcXFfdGVybS9URVNULzEwNzQvc2hpcEFuaW1hdGlvbi56aXA=";
    this.jdField_b_of_type_JavaLangString = "518EB9C3CA09942475B9F0A7424CD33E";
    this.jdField_c_of_type_JavaLangString = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vaW50ZXI/dGFyZ2V0X3Vpbj14eHgmX3d2PTY3MTA4ODY3Jl93dng9MiZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";
    this.jdField_d_of_type_JavaLangString = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vYWxsP193dj02NzEwODg2NyZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static arfi a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfBean", 2, "defaultBean");
    }
    return a(axsr.a());
  }
  
  public static arfi a(String paramString)
  {
    int i = 0;
    arfi localarfi = new arfi();
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("MutualMarkConfBean", 2, "parse content: " + paramString);
      }
    }
    for (;;)
    {
      JSONObject localJSONObject;
      Object localObject;
      int j;
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("IRResource"))
        {
          paramString = localJSONObject.optJSONObject("IRResource");
          localarfi.jdField_a_of_type_JavaLangString = paramString.optString("path");
          localarfi.jdField_b_of_type_JavaLangString = paramString.optString("md5");
          localarfi.jdField_c_of_type_JavaLangString = paramString.optString("c2cIntimateUrl");
          localarfi.jdField_d_of_type_JavaLangString = paramString.optString("intimateListUrl");
        }
        if (localJSONObject.has("tipInfo"))
        {
          paramString = localJSONObject.optJSONObject("tipInfo");
          localarfi.e = paramString.optString("switchInfo");
          localarfi.f = paramString.optString("flashTitle");
          localarfi.g = paramString.optString("flashSubtitle");
        }
        if (localJSONObject.has("sort"))
        {
          paramString = localJSONObject.getJSONArray("sort");
          if (localJSONObject.has("aio_left_sort"))
          {
            localObject = localJSONObject.getJSONArray("aio_left_sort");
            if (!localJSONObject.has("aio_right_sort")) {
              continue;
            }
            localJSONArray = localJSONObject.getJSONArray("aio_right_sort");
            a(paramString, localarfi.jdField_b_of_type_JavaUtilArrayList);
            a((JSONArray)localObject, localarfi.jdField_c_of_type_JavaUtilArrayList);
            a(localJSONArray, localarfi.jdField_d_of_type_JavaUtilArrayList);
            if (!localJSONObject.has("IRType")) {
              break label497;
            }
            paramString = localJSONObject.optJSONArray("IRType");
            if (i >= paramString.length()) {
              break label497;
            }
            localObject = axtg.a(paramString.getJSONObject(i));
            if (localObject == null) {
              break label533;
            }
            if (!localarfi.jdField_d_of_type_JavaUtilArrayList.contains(Long.valueOf(((axtg)localObject).jdField_a_of_type_Long))) {
              break label469;
            }
            ((axtg)localObject).jdField_a_of_type_Boolean = true;
            ((axtg)localObject).b = localarfi.jdField_d_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((axtg)localObject).jdField_a_of_type_Long));
            j = localarfi.jdField_b_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((axtg)localObject).jdField_a_of_type_Long));
            if (j >= 0) {
              ((axtg)localObject).jdField_a_of_type_Int = j;
            }
            localarfi.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((axtg)localObject).jdField_a_of_type_Long), localObject);
            localarfi.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((axtg)localObject).jdField_a_of_type_Long));
            break label533;
          }
        }
        else
        {
          paramString = new JSONArray("[7, 12, 8, 6, 4, 1, 2, 3, 5]");
          continue;
        }
        localObject = new JSONArray("[7, 12, 4, 5, 8, 6]");
        continue;
        JSONArray localJSONArray = new JSONArray("[1, 2, 3]");
        continue;
        return localarfi;
      }
      catch (JSONException paramString)
      {
        QLog.e("MutualMarkConfBean", 1, "parse error->" + paramString.toString());
      }
      label469:
      label497:
      do
      {
        j = localarfi.jdField_c_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((axtg)localObject).jdField_a_of_type_Long));
        if (j < 0) {
          break;
        }
        ((axtg)localObject).b = j;
        break;
      } while (!localJSONObject.has("resourceDomain"));
      localarfi.h = new String(bhkv.decode(localJSONObject.optString("resourceDomain"), 0));
      return localarfi;
      label533:
      i += 1;
    }
  }
  
  private static void a(JSONArray paramJSONArray, ArrayList<Long> paramArrayList)
  {
    if (paramJSONArray == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramJSONArray.length())
      {
        paramArrayList.add(Long.valueOf(paramJSONArray.optLong(i)));
        i += 1;
      }
    }
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((!TextUtils.isEmpty(((axtg)localEntry.getValue()).jdField_a_of_type_JavaLangString)) && (((axtg)localEntry.getValue()).jdField_a_of_type_JavaLangString.equals(paramString))) {
          return (int)((axtg)localEntry.getValue()).jdField_a_of_type_Long;
        }
      }
    }
    return 0;
  }
  
  public axtg a(long paramLong)
  {
    return (axtg)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public axti a(long paramLong1, long paramLong2)
  {
    axtg localaxtg = (axtg)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localaxtg != null) {
      return localaxtg.a(paramLong2);
    }
    return null;
  }
  
  public axti a(String paramString)
  {
    return a(axsr.b(paramString), axsr.a(paramString));
  }
  
  public String a()
  {
    return new String(bhkv.decode(arfj.a().jdField_d_of_type_JavaLangString, 0));
  }
  
  public String a(String paramString)
  {
    return new String(bhkv.decode(arfj.a().jdField_c_of_type_JavaLangString, 0)).replace("xxx", paramString);
  }
  
  public ArrayList<axti> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      Object localObject = (axtg)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject != null) && (((axtg)localObject).jdField_a_of_type_JavaUtilArrayList != null))
      {
        localObject = ((axtg)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          axti localaxti = (axti)((Iterator)localObject).next();
          if ((localaxti.jdField_a_of_type_Boolean) && (!localaxti.b)) {
            localArrayList.add(localaxti);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<axtg> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    axtg localaxtg1 = (axtg)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localaxtg1 != null) && (!TextUtils.isEmpty(localaxtg1.jdField_a_of_type_JavaLangString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        axtg localaxtg2 = (axtg)((Map.Entry)localIterator.next()).getValue();
        if ((localaxtg2 != null) && (localaxtg2.jdField_a_of_type_Long != paramLong) && (TextUtils.equals(localaxtg1.jdField_a_of_type_JavaLangString, localaxtg2.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localaxtg2);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(long paramLong)
  {
    axtg localaxtg = (axtg)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localaxtg != null) {
      return localaxtg.a();
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    axtg localaxtg = (axtg)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localaxtg != null) {
      return localaxtg.a(paramLong2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfi
 * JD-Core Version:    0.7.0.1
 */