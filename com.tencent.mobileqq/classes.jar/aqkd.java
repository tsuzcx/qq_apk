import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqkd
{
  public List<aqke> a;
  public Map<String, Long> a;
  
  public aqkd()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static aqkd a(aptx[] paramArrayOfaptx)
  {
    int i = 0;
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    localaqkd = new aqkd();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].a);
      Object localObject1;
      Object localObject2;
      if (paramArrayOfaptx.has("collection"))
      {
        localObject1 = paramArrayOfaptx.getJSONArray("collection");
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new aqke(((JSONArray)localObject1).getJSONObject(i));
          localaqkd.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      if (paramArrayOfaptx.has("collectionTypeAndSize"))
      {
        paramArrayOfaptx = paramArrayOfaptx.getJSONObject("collectionTypeAndSize");
        localObject1 = paramArrayOfaptx.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localaqkd.jdField_a_of_type_JavaUtilMap.put(localObject2, Long.valueOf(paramArrayOfaptx.getLong((String)localObject2)));
        }
      }
      return localaqkd;
    }
    catch (JSONException paramArrayOfaptx)
    {
      QLog.e("TencentDocFormKeyWordsBean", 1, paramArrayOfaptx.getLocalizedMessage(), paramArrayOfaptx);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    aqke localaqke;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localaqke = (aqke)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localaqke.a == null) {
        break label156;
      }
      j = 0;
      if (j >= localaqke.a.length) {
        break label156;
      }
      str = localaqke.a[j];
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
        if (localaqke.b != null)
        {
          j = 0;
          for (;;)
          {
            if (j >= localaqke.b.length) {
              break label149;
            }
            str = localaqke.b[j];
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
 * Qualified Name:     aqkd
 * JD-Core Version:    0.7.0.1
 */