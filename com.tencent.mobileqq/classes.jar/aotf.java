import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aotf
{
  public List<aotg> a;
  public Map<String, Long> a;
  
  public aotf()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static aotf a(aogf[] paramArrayOfaogf)
  {
    int i = 0;
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    localaotf = new aotf();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].a);
      Object localObject1;
      Object localObject2;
      if (paramArrayOfaogf.has("collection"))
      {
        localObject1 = paramArrayOfaogf.getJSONArray("collection");
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new aotg(((JSONArray)localObject1).getJSONObject(i));
          localaotf.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      if (paramArrayOfaogf.has("collectionTypeAndSize"))
      {
        paramArrayOfaogf = paramArrayOfaogf.getJSONObject("collectionTypeAndSize");
        localObject1 = paramArrayOfaogf.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localaotf.jdField_a_of_type_JavaUtilMap.put(localObject2, Long.valueOf(paramArrayOfaogf.getLong((String)localObject2)));
        }
      }
      return localaotf;
    }
    catch (JSONException paramArrayOfaogf)
    {
      QLog.e("TencentDocFormKeyWordsBean", 1, paramArrayOfaogf.getLocalizedMessage(), paramArrayOfaogf);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    aotg localaotg;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localaotg = (aotg)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localaotg.a == null) {
        break label156;
      }
      j = 0;
      if (j >= localaotg.a.length) {
        break label156;
      }
      str = localaotg.a[j];
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
        if (localaotg.b != null)
        {
          j = 0;
          for (;;)
          {
            if (j >= localaotg.b.length) {
              break label149;
            }
            str = localaotg.b[j];
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
 * Qualified Name:     aotf
 * JD-Core Version:    0.7.0.1
 */