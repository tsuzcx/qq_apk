import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bqox
  extends bqow
{
  public static boolean b;
  public List<bqpa> a = new ArrayList();
  public Map<String, Map<String, bqoy>> a;
  public int c;
  public String f;
  public String g = "default";
  public String h;
  public String i;
  
  public bqox(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public static List<bqpa> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < paramJSONArray.length())
    {
      localArrayList.add(new bqpa(paramJSONArray.getJSONObject(j)));
      j += 1;
    }
    return localArrayList;
  }
  
  public static Map<String, Map<String, bqoy>> a(JSONArray paramJSONArray)
  {
    Object localObject1;
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          HashMap localHashMap1 = new HashMap(paramJSONArray.length());
          int j = 0;
          for (;;)
          {
            localObject1 = localHashMap1;
            if (j >= paramJSONArray.length()) {
              break;
            }
            Object localObject2 = paramJSONArray.getJSONObject(j);
            localObject1 = ((JSONObject)localObject2).getString("id");
            localObject2 = ((JSONObject)localObject2).getJSONArray("res");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              HashMap localHashMap2 = new HashMap(((JSONArray)localObject2).length());
              int k = 0;
              while (k < ((JSONArray)localObject2).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(k);
                bqoy localbqoy = new bqoy();
                localbqoy.a = localJSONObject.getString("resname");
                localbqoy.b = localJSONObject.getString("resurl");
                localbqoy.d = localJSONObject.getString("cityname");
                localbqoy.c = localJSONObject.getString("md5");
                localHashMap2.put(localbqoy.d, localbqoy);
                k += 1;
              }
              localHashMap1.put(localObject1, localHashMap2);
            }
            j += 1;
          }
        }
        localObject1 = null;
      }
      catch (JSONException paramJSONArray)
      {
        QLog.e("FacePackage", 1, paramJSONArray, new Object[0]);
      }
    }
    return localObject1;
  }
  
  public bqpa a(String paramString)
  {
    if ((!bhsr.a(paramString)) && (this.a != null))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        bqpa localbqpa = (bqpa)localIterator.next();
        if (paramString.equals(localbqpa.a)) {
          return localbqpa;
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    return "InformationFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((bqpa)this.a.get(paramInt)).c;
    }
    return null;
  }
  
  public int b()
  {
    return this.a.size();
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((bqpa)this.a.get(paramInt)).d;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqox
 * JD-Core Version:    0.7.0.1
 */