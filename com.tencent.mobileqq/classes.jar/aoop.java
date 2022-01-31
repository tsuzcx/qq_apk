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

public class aoop
{
  public String a;
  public ArrayList<Long> a;
  public HashMap<Long, auth> a;
  public String b;
  public ArrayList<Long> b;
  public String c;
  public ArrayList<Long> c;
  public String d;
  public ArrayList<Long> d;
  public String e = "";
  public String f = "";
  public String g = "";
  
  public aoop()
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
  
  public static aoop a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfBean", 2, "defaultBean");
    }
    return a(auss.a());
  }
  
  public static aoop a(String paramString)
  {
    aoop localaoop = new aoop();
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
          localaoop.jdField_a_of_type_JavaLangString = paramString.optString("path");
          localaoop.jdField_b_of_type_JavaLangString = paramString.optString("md5");
          localaoop.jdField_c_of_type_JavaLangString = paramString.optString("c2cIntimateUrl");
          localaoop.jdField_d_of_type_JavaLangString = paramString.optString("intimateListUrl");
        }
        if (localJSONObject.has("tipInfo"))
        {
          paramString = localJSONObject.optJSONObject("tipInfo");
          localaoop.e = paramString.optString("switchInfo");
          localaoop.f = paramString.optString("flashTitle");
          localaoop.g = paramString.optString("flashSubtitle");
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
            a(paramString, localaoop.jdField_b_of_type_JavaUtilArrayList);
            a((JSONArray)localObject, localaoop.jdField_c_of_type_JavaUtilArrayList);
            a(localJSONArray, localaoop.jdField_d_of_type_JavaUtilArrayList);
            if (!localJSONObject.has("IRType")) {
              break label466;
            }
            paramString = localJSONObject.optJSONArray("IRType");
            i = 0;
            if (i >= paramString.length()) {
              break label466;
            }
            localObject = auth.a(paramString.getJSONObject(i));
            if (localObject == null) {
              break label497;
            }
            if (!localaoop.jdField_d_of_type_JavaUtilArrayList.contains(Long.valueOf(((auth)localObject).jdField_a_of_type_Long))) {
              break label469;
            }
            ((auth)localObject).jdField_a_of_type_Boolean = true;
            ((auth)localObject).b = localaoop.jdField_d_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((auth)localObject).jdField_a_of_type_Long));
            j = localaoop.jdField_b_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((auth)localObject).jdField_a_of_type_Long));
            if (j >= 0) {
              ((auth)localObject).jdField_a_of_type_Int = j;
            }
            localaoop.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((auth)localObject).jdField_a_of_type_Long), localObject);
            localaoop.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((auth)localObject).jdField_a_of_type_Long));
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
        return localaoop;
      }
      catch (JSONException paramString)
      {
        QLog.e("MutualMarkConfBean", 1, "parse error->" + paramString.toString());
      }
      label466:
      label469:
      int j = localaoop.jdField_c_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((auth)localObject).jdField_a_of_type_Long));
      if (j >= 0)
      {
        ((auth)localObject).b = j;
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
  
  public auth a(long paramLong)
  {
    return (auth)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public auti a(long paramLong1, long paramLong2)
  {
    auth localauth = (auth)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localauth != null) {
      return localauth.a(paramLong2);
    }
    return null;
  }
  
  public auti a(String paramString)
  {
    return a(auss.b(paramString), auss.a(paramString));
  }
  
  public String a()
  {
    return new String(bdfr.decode(aooq.a().jdField_d_of_type_JavaLangString, 0));
  }
  
  public String a(String paramString)
  {
    return new String(bdfr.decode(aooq.a().jdField_c_of_type_JavaLangString, 0)).replace("xxx", paramString);
  }
  
  public ArrayList<auti> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      Object localObject = (auth)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject != null) && (((auth)localObject).jdField_a_of_type_JavaUtilArrayList != null))
      {
        localObject = ((auth)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          auti localauti = (auti)((Iterator)localObject).next();
          if ((localauti.jdField_a_of_type_Boolean) && (!localauti.b)) {
            localArrayList.add(localauti);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<auth> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    auth localauth1 = (auth)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localauth1 != null) && (!TextUtils.isEmpty(localauth1.jdField_a_of_type_JavaLangString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        auth localauth2 = (auth)((Map.Entry)localIterator.next()).getValue();
        if ((localauth2 != null) && (localauth2.jdField_a_of_type_Long != paramLong) && (TextUtils.equals(localauth1.jdField_a_of_type_JavaLangString, localauth2.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localauth2);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(long paramLong)
  {
    auth localauth = (auth)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localauth != null) {
      return localauth.a();
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    auth localauth = (auth)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localauth != null) {
      return localauth.a(paramLong2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoop
 * JD-Core Version:    0.7.0.1
 */