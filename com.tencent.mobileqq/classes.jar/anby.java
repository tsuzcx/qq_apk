import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anby
{
  public List<anbz> a;
  public Map<String, Long> a;
  
  public anby()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static anby a(amph[] paramArrayOfamph)
  {
    int i = 0;
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    localanby = new anby();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].a);
      Object localObject1;
      Object localObject2;
      if (paramArrayOfamph.has("collection"))
      {
        localObject1 = paramArrayOfamph.getJSONArray("collection");
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new anbz(((JSONArray)localObject1).getJSONObject(i));
          localanby.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      if (paramArrayOfamph.has("collectionTypeAndSize"))
      {
        paramArrayOfamph = paramArrayOfamph.getJSONObject("collectionTypeAndSize");
        localObject1 = paramArrayOfamph.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localanby.jdField_a_of_type_JavaUtilMap.put(localObject2, Long.valueOf(paramArrayOfamph.getLong((String)localObject2)));
        }
      }
      return localanby;
    }
    catch (JSONException paramArrayOfamph)
    {
      QLog.e("TencentDocFormKeyWordsBean", 1, paramArrayOfamph.getLocalizedMessage(), paramArrayOfamph);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    anbz localanbz;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localanbz = (anbz)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localanbz.a == null) {
        break label156;
      }
      j = 0;
      if (j >= localanbz.a.length) {
        break label156;
      }
      str = localanbz.a[j];
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
        if (localanbz.b != null)
        {
          j = 0;
          for (;;)
          {
            if (j >= localanbz.b.length) {
              break label149;
            }
            str = localanbz.b[j];
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
 * Qualified Name:     anby
 * JD-Core Version:    0.7.0.1
 */