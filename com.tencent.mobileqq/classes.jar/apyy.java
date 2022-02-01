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

public class apyy
{
  public String a;
  public ArrayList<Long> a;
  public HashMap<Long, awgn> a;
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
  
  public apyy()
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
  
  public static apyy a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfBean", 2, "defaultBean");
    }
    return a(awfy.a());
  }
  
  public static apyy a(String paramString)
  {
    int i = 0;
    apyy localapyy = new apyy();
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
          localapyy.jdField_a_of_type_JavaLangString = paramString.optString("path");
          localapyy.jdField_b_of_type_JavaLangString = paramString.optString("md5");
          localapyy.jdField_c_of_type_JavaLangString = paramString.optString("c2cIntimateUrl");
          localapyy.jdField_d_of_type_JavaLangString = paramString.optString("intimateListUrl");
        }
        if (localJSONObject.has("tipInfo"))
        {
          paramString = localJSONObject.optJSONObject("tipInfo");
          localapyy.e = paramString.optString("switchInfo");
          localapyy.f = paramString.optString("flashTitle");
          localapyy.g = paramString.optString("flashSubtitle");
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
            a(paramString, localapyy.jdField_b_of_type_JavaUtilArrayList);
            a((JSONArray)localObject, localapyy.jdField_c_of_type_JavaUtilArrayList);
            a(localJSONArray, localapyy.jdField_d_of_type_JavaUtilArrayList);
            if (!localJSONObject.has("IRType")) {
              break label497;
            }
            paramString = localJSONObject.optJSONArray("IRType");
            if (i >= paramString.length()) {
              break label497;
            }
            localObject = awgn.a(paramString.getJSONObject(i));
            if (localObject == null) {
              break label533;
            }
            if (!localapyy.jdField_d_of_type_JavaUtilArrayList.contains(Long.valueOf(((awgn)localObject).jdField_a_of_type_Long))) {
              break label469;
            }
            ((awgn)localObject).jdField_a_of_type_Boolean = true;
            ((awgn)localObject).b = localapyy.jdField_d_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((awgn)localObject).jdField_a_of_type_Long));
            j = localapyy.jdField_b_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((awgn)localObject).jdField_a_of_type_Long));
            if (j >= 0) {
              ((awgn)localObject).jdField_a_of_type_Int = j;
            }
            localapyy.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((awgn)localObject).jdField_a_of_type_Long), localObject);
            localapyy.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((awgn)localObject).jdField_a_of_type_Long));
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
        return localapyy;
      }
      catch (JSONException paramString)
      {
        QLog.e("MutualMarkConfBean", 1, "parse error->" + paramString.toString());
      }
      label469:
      label497:
      do
      {
        j = localapyy.jdField_c_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((awgn)localObject).jdField_a_of_type_Long));
        if (j < 0) {
          break;
        }
        ((awgn)localObject).b = j;
        break;
      } while (!localJSONObject.has("resourceDomain"));
      localapyy.h = new String(bfuc.decode(localJSONObject.optString("resourceDomain"), 0));
      return localapyy;
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
        if ((!TextUtils.isEmpty(((awgn)localEntry.getValue()).jdField_a_of_type_JavaLangString)) && (((awgn)localEntry.getValue()).jdField_a_of_type_JavaLangString.equals(paramString))) {
          return (int)((awgn)localEntry.getValue()).jdField_a_of_type_Long;
        }
      }
    }
    return 0;
  }
  
  public awgn a(long paramLong)
  {
    return (awgn)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public awgp a(long paramLong1, long paramLong2)
  {
    awgn localawgn = (awgn)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localawgn != null) {
      return localawgn.a(paramLong2);
    }
    return null;
  }
  
  public awgp a(String paramString)
  {
    return a(awfy.b(paramString), awfy.a(paramString));
  }
  
  public String a()
  {
    return new String(bfuc.decode(apyz.a().jdField_d_of_type_JavaLangString, 0));
  }
  
  public String a(String paramString)
  {
    return new String(bfuc.decode(apyz.a().jdField_c_of_type_JavaLangString, 0)).replace("xxx", paramString);
  }
  
  public ArrayList<awgp> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      Object localObject = (awgn)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject != null) && (((awgn)localObject).jdField_a_of_type_JavaUtilArrayList != null))
      {
        localObject = ((awgn)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          awgp localawgp = (awgp)((Iterator)localObject).next();
          if ((localawgp.jdField_a_of_type_Boolean) && (!localawgp.b)) {
            localArrayList.add(localawgp);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<awgn> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    awgn localawgn1 = (awgn)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localawgn1 != null) && (!TextUtils.isEmpty(localawgn1.jdField_a_of_type_JavaLangString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        awgn localawgn2 = (awgn)((Map.Entry)localIterator.next()).getValue();
        if ((localawgn2 != null) && (localawgn2.jdField_a_of_type_Long != paramLong) && (TextUtils.equals(localawgn1.jdField_a_of_type_JavaLangString, localawgn2.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localawgn2);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(long paramLong)
  {
    awgn localawgn = (awgn)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localawgn != null) {
      return localawgn.a();
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    awgn localawgn = (awgn)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localawgn != null) {
      return localawgn.a(paramLong2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apyy
 * JD-Core Version:    0.7.0.1
 */