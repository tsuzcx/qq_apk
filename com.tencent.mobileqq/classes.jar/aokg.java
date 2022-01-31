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

public class aokg
{
  public String a;
  public ArrayList<Long> a;
  public HashMap<Long, auoy> a;
  public String b;
  public ArrayList<Long> b;
  public String c;
  public ArrayList<Long> c;
  public String d;
  public ArrayList<Long> d;
  public String e = "";
  public String f = "";
  public String g = "";
  
  public aokg()
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
  
  public static aokg a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfBean", 2, "defaultBean");
    }
    return a(auoj.a());
  }
  
  public static aokg a(String paramString)
  {
    aokg localaokg = new aokg();
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
          localaokg.jdField_a_of_type_JavaLangString = paramString.optString("path");
          localaokg.jdField_b_of_type_JavaLangString = paramString.optString("md5");
          localaokg.jdField_c_of_type_JavaLangString = paramString.optString("c2cIntimateUrl");
          localaokg.jdField_d_of_type_JavaLangString = paramString.optString("intimateListUrl");
        }
        if (localJSONObject.has("tipInfo"))
        {
          paramString = localJSONObject.optJSONObject("tipInfo");
          localaokg.e = paramString.optString("switchInfo");
          localaokg.f = paramString.optString("flashTitle");
          localaokg.g = paramString.optString("flashSubtitle");
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
            a(paramString, localaokg.jdField_b_of_type_JavaUtilArrayList);
            a((JSONArray)localObject, localaokg.jdField_c_of_type_JavaUtilArrayList);
            a(localJSONArray, localaokg.jdField_d_of_type_JavaUtilArrayList);
            if (!localJSONObject.has("IRType")) {
              break label466;
            }
            paramString = localJSONObject.optJSONArray("IRType");
            i = 0;
            if (i >= paramString.length()) {
              break label466;
            }
            localObject = auoy.a(paramString.getJSONObject(i));
            if (localObject == null) {
              break label497;
            }
            if (!localaokg.jdField_d_of_type_JavaUtilArrayList.contains(Long.valueOf(((auoy)localObject).jdField_a_of_type_Long))) {
              break label469;
            }
            ((auoy)localObject).jdField_a_of_type_Boolean = true;
            ((auoy)localObject).b = localaokg.jdField_d_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((auoy)localObject).jdField_a_of_type_Long));
            j = localaokg.jdField_b_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((auoy)localObject).jdField_a_of_type_Long));
            if (j >= 0) {
              ((auoy)localObject).jdField_a_of_type_Int = j;
            }
            localaokg.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((auoy)localObject).jdField_a_of_type_Long), localObject);
            localaokg.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((auoy)localObject).jdField_a_of_type_Long));
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
        return localaokg;
      }
      catch (JSONException paramString)
      {
        QLog.e("MutualMarkConfBean", 1, "parse error->" + paramString.toString());
      }
      label466:
      label469:
      int j = localaokg.jdField_c_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((auoy)localObject).jdField_a_of_type_Long));
      if (j >= 0)
      {
        ((auoy)localObject).b = j;
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
  
  public auoy a(long paramLong)
  {
    return (auoy)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public auoz a(long paramLong1, long paramLong2)
  {
    auoy localauoy = (auoy)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localauoy != null) {
      return localauoy.a(paramLong2);
    }
    return null;
  }
  
  public auoz a(String paramString)
  {
    return a(auoj.b(paramString), auoj.a(paramString));
  }
  
  public String a()
  {
    return new String(bdbi.decode(aokh.a().jdField_d_of_type_JavaLangString, 0));
  }
  
  public String a(String paramString)
  {
    return new String(bdbi.decode(aokh.a().jdField_c_of_type_JavaLangString, 0)).replace("xxx", paramString);
  }
  
  public ArrayList<auoz> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      Object localObject = (auoy)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject != null) && (((auoy)localObject).jdField_a_of_type_JavaUtilArrayList != null))
      {
        localObject = ((auoy)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          auoz localauoz = (auoz)((Iterator)localObject).next();
          if ((localauoz.jdField_a_of_type_Boolean) && (!localauoz.b)) {
            localArrayList.add(localauoz);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<auoy> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    auoy localauoy1 = (auoy)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localauoy1 != null) && (!TextUtils.isEmpty(localauoy1.jdField_a_of_type_JavaLangString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        auoy localauoy2 = (auoy)((Map.Entry)localIterator.next()).getValue();
        if ((localauoy2 != null) && (localauoy2.jdField_a_of_type_Long != paramLong) && (TextUtils.equals(localauoy1.jdField_a_of_type_JavaLangString, localauoy2.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localauoy2);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(long paramLong)
  {
    auoy localauoy = (auoy)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localauoy != null) {
      return localauoy.a();
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    auoy localauoy = (auoy)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localauoy != null) {
      return localauoy.a(paramLong2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aokg
 * JD-Core Version:    0.7.0.1
 */