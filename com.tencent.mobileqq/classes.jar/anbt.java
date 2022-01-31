import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anbt
{
  public List<anbu> a;
  public Map<String, Long> a;
  
  public anbt()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static anbt a(ampi[] paramArrayOfampi)
  {
    int i = 0;
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    localanbt = new anbt();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].a);
      Object localObject1;
      Object localObject2;
      if (paramArrayOfampi.has("collection"))
      {
        localObject1 = paramArrayOfampi.getJSONArray("collection");
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new anbu(((JSONArray)localObject1).getJSONObject(i));
          localanbt.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      if (paramArrayOfampi.has("collectionTypeAndSize"))
      {
        paramArrayOfampi = paramArrayOfampi.getJSONObject("collectionTypeAndSize");
        localObject1 = paramArrayOfampi.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localanbt.jdField_a_of_type_JavaUtilMap.put(localObject2, Long.valueOf(paramArrayOfampi.getLong((String)localObject2)));
        }
      }
      return localanbt;
    }
    catch (JSONException paramArrayOfampi)
    {
      QLog.e("TencentDocFormKeyWordsBean", 1, paramArrayOfampi.getLocalizedMessage(), paramArrayOfampi);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    anbu localanbu;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localanbu = (anbu)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localanbu.a == null) {
        break label156;
      }
      j = 0;
      if (j >= localanbu.a.length) {
        break label156;
      }
      str = localanbu.a[j];
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
        if (localanbu.b != null)
        {
          j = 0;
          for (;;)
          {
            if (j >= localanbu.b.length) {
              break label149;
            }
            str = localanbu.b[j];
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
 * Qualified Name:     anbt
 * JD-Core Version:    0.7.0.1
 */