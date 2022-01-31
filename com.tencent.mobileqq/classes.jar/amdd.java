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

public class amdd
{
  public String a;
  public ArrayList<Long> a;
  public HashMap<Long, asbv> a;
  public String b;
  public ArrayList<Long> b;
  public String c;
  public ArrayList<Long> c;
  public String d;
  public ArrayList<Long> d;
  public String e = "";
  public String f = "";
  public String g = "";
  
  public amdd()
  {
    this.jdField_a_of_type_JavaLangString = "aHR0cDovL2QudXJsLmNuL215YXBwL3FxX2Rlc2svcXFfdGVybS9URVNULzEwNzQvc2hpcEFuaW1hdGlvbi56aXA=";
    this.jdField_b_of_type_JavaLangString = "518EB9C3CA09942475B9F0A7424CD33E";
    this.jdField_c_of_type_JavaLangString = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vdHdvP3RhcmdldF91aW49eHh4Jl93dj02NzEwODg2NyZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";
    this.jdField_d_of_type_JavaLangString = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vYWxsP193dj02NzEwODg2NyZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static amdd a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfBean", 2, "defaultBean");
    }
    return a(asbg.a());
  }
  
  public static amdd a(String paramString)
  {
    amdd localamdd = new amdd();
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("MutualMarkConfBean", 2, "parse content: " + paramString);
      }
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("IRResource"))
        {
          paramString = localJSONObject.optJSONObject("IRResource");
          localamdd.jdField_a_of_type_JavaLangString = paramString.optString("path");
          localamdd.jdField_b_of_type_JavaLangString = paramString.optString("md5");
          localamdd.jdField_c_of_type_JavaLangString = paramString.optString("c2cIntimateUrl");
          localamdd.jdField_d_of_type_JavaLangString = paramString.optString("intimateListUrl");
        }
        if (localJSONObject.has("tipInfo"))
        {
          paramString = localJSONObject.optJSONObject("tipInfo");
          localamdd.e = paramString.optString("switchInfo");
          localamdd.f = paramString.optString("flashTitle");
          localamdd.g = paramString.optString("flashSubtitle");
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
            a(paramString, localamdd.jdField_b_of_type_JavaUtilArrayList);
            a((JSONArray)localObject, localamdd.jdField_c_of_type_JavaUtilArrayList);
            a(localJSONArray, localamdd.jdField_d_of_type_JavaUtilArrayList);
            if (!localJSONObject.has("IRType")) {
              break label466;
            }
            paramString = localJSONObject.optJSONArray("IRType");
            i = 0;
            if (i >= paramString.length()) {
              break label466;
            }
            localObject = asbv.a(paramString.getJSONObject(i));
            if (localObject == null) {
              break label497;
            }
            if (!localamdd.jdField_d_of_type_JavaUtilArrayList.contains(Long.valueOf(((asbv)localObject).jdField_a_of_type_Long))) {
              break label469;
            }
            ((asbv)localObject).jdField_a_of_type_Boolean = true;
            ((asbv)localObject).b = localamdd.jdField_d_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((asbv)localObject).jdField_a_of_type_Long));
            j = localamdd.jdField_b_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((asbv)localObject).jdField_a_of_type_Long));
            if (j >= 0) {
              ((asbv)localObject).jdField_a_of_type_Int = j;
            }
            localamdd.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((asbv)localObject).jdField_a_of_type_Long), localObject);
            localamdd.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((asbv)localObject).jdField_a_of_type_Long));
            break label497;
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
        return localamdd;
      }
      catch (JSONException paramString)
      {
        QLog.e("MutualMarkConfBean", 1, "parse error->" + paramString.toString());
      }
      label466:
      label469:
      int j = localamdd.jdField_c_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((asbv)localObject).jdField_a_of_type_Long));
      if (j >= 0)
      {
        ((asbv)localObject).b = j;
        continue;
        label497:
        i += 1;
      }
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
  
  public asbv a(long paramLong)
  {
    return (asbv)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public asbw a(long paramLong1, long paramLong2)
  {
    asbv localasbv = (asbv)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localasbv != null) {
      return localasbv.a(paramLong2);
    }
    return null;
  }
  
  public asbw a(String paramString)
  {
    return a(asbg.b(paramString), asbg.a(paramString));
  }
  
  public String a()
  {
    return new String(baaw.decode(amde.a().jdField_d_of_type_JavaLangString, 0));
  }
  
  public String a(String paramString)
  {
    return new String(baaw.decode(amde.a().jdField_c_of_type_JavaLangString, 0)).replace("xxx", paramString);
  }
  
  public ArrayList<asbw> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      Object localObject = (asbv)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject != null) && (((asbv)localObject).jdField_a_of_type_JavaUtilArrayList != null))
      {
        localObject = ((asbv)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          asbw localasbw = (asbw)((Iterator)localObject).next();
          if (localasbw.jdField_a_of_type_Boolean) {
            localArrayList.add(localasbw);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<asbv> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    asbv localasbv1 = (asbv)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localasbv1 != null) && (!TextUtils.isEmpty(localasbv1.jdField_a_of_type_JavaLangString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        asbv localasbv2 = (asbv)((Map.Entry)localIterator.next()).getValue();
        if ((localasbv2 != null) && (localasbv2.jdField_a_of_type_Long != paramLong) && (TextUtils.equals(localasbv1.jdField_a_of_type_JavaLangString, localasbv2.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localasbv2);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(long paramLong)
  {
    asbv localasbv = (asbv)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localasbv != null) {
      return localasbv.a();
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    asbv localasbv = (asbv)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localasbv != null) {
      return localasbv.a(paramLong2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdd
 * JD-Core Version:    0.7.0.1
 */