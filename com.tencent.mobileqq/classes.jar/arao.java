import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arao
{
  public List<arap> a;
  public Map<String, Long> a;
  
  public arao()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static arao a(aqlg[] paramArrayOfaqlg)
  {
    int i = 0;
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    localarao = new arao();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].a);
      Object localObject1;
      Object localObject2;
      if (paramArrayOfaqlg.has("collection"))
      {
        localObject1 = paramArrayOfaqlg.getJSONArray("collection");
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new arap(((JSONArray)localObject1).getJSONObject(i));
          localarao.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      if (paramArrayOfaqlg.has("collectionTypeAndSize"))
      {
        paramArrayOfaqlg = paramArrayOfaqlg.getJSONObject("collectionTypeAndSize");
        localObject1 = paramArrayOfaqlg.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localarao.jdField_a_of_type_JavaUtilMap.put(localObject2, Long.valueOf(paramArrayOfaqlg.getLong((String)localObject2)));
        }
      }
      return localarao;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      QLog.e("TencentDocFormKeyWordsBean", 1, paramArrayOfaqlg.getLocalizedMessage(), paramArrayOfaqlg);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    arap localarap;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localarap = (arap)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localarap.a == null) {
        break label156;
      }
      j = 0;
      if (j >= localarap.a.length) {
        break label156;
      }
      str = localarap.a[j];
      if ((paramString == null) || (paramString.indexOf(str) < 0)) {
        break label133;
      }
    }
    label133:
    label149:
    label156:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        if (localarap.b != null)
        {
          j = 0;
          for (;;)
          {
            if (j >= localarap.b.length) {
              break label149;
            }
            str = localarap.b[j];
            if ((paramString != null) && (paramString.indexOf(str) >= 0))
            {
              bool1 = true;
              return bool1;
              j += 1;
              break;
            }
            j += 1;
          }
        }
        return true;
      }
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arao
 * JD-Core Version:    0.7.0.1
 */