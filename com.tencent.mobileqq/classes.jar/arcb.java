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

public class arcb
{
  public String a;
  public ArrayList<Long> a;
  public HashMap<Long, axmp> a;
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
  
  public arcb()
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
  
  public static arcb a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfBean", 2, "defaultBean");
    }
    return a(axma.a());
  }
  
  public static arcb a(String paramString)
  {
    int i = 0;
    arcb localarcb = new arcb();
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
          localarcb.jdField_a_of_type_JavaLangString = paramString.optString("path");
          localarcb.jdField_b_of_type_JavaLangString = paramString.optString("md5");
          localarcb.jdField_c_of_type_JavaLangString = paramString.optString("c2cIntimateUrl");
          localarcb.jdField_d_of_type_JavaLangString = paramString.optString("intimateListUrl");
        }
        if (localJSONObject.has("tipInfo"))
        {
          paramString = localJSONObject.optJSONObject("tipInfo");
          localarcb.e = paramString.optString("switchInfo");
          localarcb.f = paramString.optString("flashTitle");
          localarcb.g = paramString.optString("flashSubtitle");
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
            a(paramString, localarcb.jdField_b_of_type_JavaUtilArrayList);
            a((JSONArray)localObject, localarcb.jdField_c_of_type_JavaUtilArrayList);
            a(localJSONArray, localarcb.jdField_d_of_type_JavaUtilArrayList);
            if (!localJSONObject.has("IRType")) {
              break label497;
            }
            paramString = localJSONObject.optJSONArray("IRType");
            if (i >= paramString.length()) {
              break label497;
            }
            localObject = axmp.a(paramString.getJSONObject(i));
            if (localObject == null) {
              break label533;
            }
            if (!localarcb.jdField_d_of_type_JavaUtilArrayList.contains(Long.valueOf(((axmp)localObject).jdField_a_of_type_Long))) {
              break label469;
            }
            ((axmp)localObject).jdField_a_of_type_Boolean = true;
            ((axmp)localObject).b = localarcb.jdField_d_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((axmp)localObject).jdField_a_of_type_Long));
            j = localarcb.jdField_b_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((axmp)localObject).jdField_a_of_type_Long));
            if (j >= 0) {
              ((axmp)localObject).jdField_a_of_type_Int = j;
            }
            localarcb.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((axmp)localObject).jdField_a_of_type_Long), localObject);
            localarcb.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((axmp)localObject).jdField_a_of_type_Long));
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
        return localarcb;
      }
      catch (JSONException paramString)
      {
        QLog.e("MutualMarkConfBean", 1, "parse error->" + paramString.toString());
      }
      label469:
      label497:
      do
      {
        j = localarcb.jdField_c_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((axmp)localObject).jdField_a_of_type_Long));
        if (j < 0) {
          break;
        }
        ((axmp)localObject).b = j;
        break;
      } while (!localJSONObject.has("resourceDomain"));
      localarcb.h = new String(bhcu.decode(localJSONObject.optString("resourceDomain"), 0));
      return localarcb;
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
        if ((!TextUtils.isEmpty(((axmp)localEntry.getValue()).jdField_a_of_type_JavaLangString)) && (((axmp)localEntry.getValue()).jdField_a_of_type_JavaLangString.equals(paramString))) {
          return (int)((axmp)localEntry.getValue()).jdField_a_of_type_Long;
        }
      }
    }
    return 0;
  }
  
  public axmp a(long paramLong)
  {
    return (axmp)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public axmr a(long paramLong1, long paramLong2)
  {
    axmp localaxmp = (axmp)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localaxmp != null) {
      return localaxmp.a(paramLong2);
    }
    return null;
  }
  
  public axmr a(String paramString)
  {
    return a(axma.b(paramString), axma.a(paramString));
  }
  
  public String a()
  {
    return new String(bhcu.decode(arcc.a().jdField_d_of_type_JavaLangString, 0));
  }
  
  public String a(String paramString)
  {
    return new String(bhcu.decode(arcc.a().jdField_c_of_type_JavaLangString, 0)).replace("xxx", paramString);
  }
  
  public ArrayList<axmr> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      Object localObject = (axmp)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject != null) && (((axmp)localObject).jdField_a_of_type_JavaUtilArrayList != null))
      {
        localObject = ((axmp)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          axmr localaxmr = (axmr)((Iterator)localObject).next();
          if ((localaxmr.jdField_a_of_type_Boolean) && (!localaxmr.b)) {
            localArrayList.add(localaxmr);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<axmp> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    axmp localaxmp1 = (axmp)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localaxmp1 != null) && (!TextUtils.isEmpty(localaxmp1.jdField_a_of_type_JavaLangString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        axmp localaxmp2 = (axmp)((Map.Entry)localIterator.next()).getValue();
        if ((localaxmp2 != null) && (localaxmp2.jdField_a_of_type_Long != paramLong) && (TextUtils.equals(localaxmp1.jdField_a_of_type_JavaLangString, localaxmp2.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localaxmp2);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(long paramLong)
  {
    axmp localaxmp = (axmp)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localaxmp != null) {
      return localaxmp.a();
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    axmp localaxmp = (axmp)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localaxmp != null) {
      return localaxmp.a(paramLong2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcb
 * JD-Core Version:    0.7.0.1
 */