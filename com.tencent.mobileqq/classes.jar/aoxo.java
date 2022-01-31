import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoxo
{
  public List<aoxp> a;
  public Map<String, Long> a;
  
  public aoxo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static aoxo a(aoko[] paramArrayOfaoko)
  {
    int i = 0;
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    localaoxo = new aoxo();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].a);
      Object localObject1;
      Object localObject2;
      if (paramArrayOfaoko.has("collection"))
      {
        localObject1 = paramArrayOfaoko.getJSONArray("collection");
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new aoxp(((JSONArray)localObject1).getJSONObject(i));
          localaoxo.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      if (paramArrayOfaoko.has("collectionTypeAndSize"))
      {
        paramArrayOfaoko = paramArrayOfaoko.getJSONObject("collectionTypeAndSize");
        localObject1 = paramArrayOfaoko.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localaoxo.jdField_a_of_type_JavaUtilMap.put(localObject2, Long.valueOf(paramArrayOfaoko.getLong((String)localObject2)));
        }
      }
      return localaoxo;
    }
    catch (JSONException paramArrayOfaoko)
    {
      QLog.e("TencentDocFormKeyWordsBean", 1, paramArrayOfaoko.getLocalizedMessage(), paramArrayOfaoko);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    aoxp localaoxp;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localaoxp = (aoxp)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localaoxp.a == null) {
        break label156;
      }
      j = 0;
      if (j >= localaoxp.a.length) {
        break label156;
      }
      str = localaoxp.a[j];
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
        if (localaoxp.b != null)
        {
          j = 0;
          for (;;)
          {
            if (j >= localaoxp.b.length) {
              break label149;
            }
            str = localaoxp.b[j];
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
 * Qualified Name:     aoxo
 * JD-Core Version:    0.7.0.1
 */