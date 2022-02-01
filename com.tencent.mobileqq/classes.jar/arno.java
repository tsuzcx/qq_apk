import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arno
{
  public List<arnp> a;
  public Map<String, Long> a;
  
  public arno()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static arno a(aqxa[] paramArrayOfaqxa)
  {
    int i = 0;
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    localarno = new arno();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].a);
      Object localObject1;
      Object localObject2;
      if (paramArrayOfaqxa.has("collection"))
      {
        localObject1 = paramArrayOfaqxa.getJSONArray("collection");
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new arnp(((JSONArray)localObject1).getJSONObject(i));
          localarno.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      if (paramArrayOfaqxa.has("collectionTypeAndSize"))
      {
        paramArrayOfaqxa = paramArrayOfaqxa.getJSONObject("collectionTypeAndSize");
        localObject1 = paramArrayOfaqxa.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localarno.jdField_a_of_type_JavaUtilMap.put(localObject2, Long.valueOf(paramArrayOfaqxa.getLong((String)localObject2)));
        }
      }
      return localarno;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      QLog.e("TencentDocFormKeyWordsBean", 1, paramArrayOfaqxa.getLocalizedMessage(), paramArrayOfaqxa);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    arnp localarnp;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localarnp = (arnp)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localarnp.a == null) {
        break label156;
      }
      j = 0;
      if (j >= localarnp.a.length) {
        break label156;
      }
      str = localarnp.a[j];
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
        if (localarnp.b != null)
        {
          j = 0;
          for (;;)
          {
            if (j >= localarnp.b.length) {
              break label149;
            }
            str = localarnp.b[j];
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
 * Qualified Name:     arno
 * JD-Core Version:    0.7.0.1
 */