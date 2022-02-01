import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arqf
{
  public List<arqg> a;
  public Map<String, Long> a;
  
  public arqf()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static arqf a(araj[] paramArrayOfaraj)
  {
    int i = 0;
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    localarqf = new arqf();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].a);
      Object localObject1;
      Object localObject2;
      if (paramArrayOfaraj.has("collection"))
      {
        localObject1 = paramArrayOfaraj.getJSONArray("collection");
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new arqg(((JSONArray)localObject1).getJSONObject(i));
          localarqf.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      if (paramArrayOfaraj.has("collectionTypeAndSize"))
      {
        paramArrayOfaraj = paramArrayOfaraj.getJSONObject("collectionTypeAndSize");
        localObject1 = paramArrayOfaraj.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localarqf.jdField_a_of_type_JavaUtilMap.put(localObject2, Long.valueOf(paramArrayOfaraj.getLong((String)localObject2)));
        }
      }
      return localarqf;
    }
    catch (JSONException paramArrayOfaraj)
    {
      QLog.e("TencentDocFormKeyWordsBean", 1, paramArrayOfaraj.getLocalizedMessage(), paramArrayOfaraj);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    arqg localarqg;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localarqg = (arqg)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localarqg.a == null) {
        break label156;
      }
      j = 0;
      if (j >= localarqg.a.length) {
        break label156;
      }
      str = localarqg.a[j];
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
        if (localarqg.b != null)
        {
          j = 0;
          for (;;)
          {
            if (j >= localarqg.b.length) {
              break label149;
            }
            str = localarqg.b[j];
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
 * Qualified Name:     arqf
 * JD-Core Version:    0.7.0.1
 */