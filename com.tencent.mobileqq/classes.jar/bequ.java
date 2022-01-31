import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class bequ
{
  public berj a;
  public berl a;
  public berw a;
  public String a;
  public List<String> a;
  private Map<String, berl> a;
  public JSONObject a;
  public boolean a;
  public String b;
  public List<String> b;
  private Map<String, String> b;
  
  public bequ()
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
  }
  
  public static bequ a(String paramString)
  {
    bequ localbequ = new bequ();
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.keys();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        String str = localJSONObject.optString((String)localObject);
        localbequ.jdField_b_of_type_JavaUtilMap.put(localObject, str);
      }
      localbequ.jdField_a_of_type_Boolean = localJSONObject.optBoolean("debug");
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return localbequ;
    }
    localbequ.jdField_a_of_type_JavaLangString = localJSONObject.optString("entryPagePath");
    localbequ.jdField_a_of_type_Berl = berl.a();
    localbequ.jdField_a_of_type_Berl.a(localJSONObject.optJSONObject("global"));
    localbequ.jdField_a_of_type_JavaUtilMap = a(localJSONObject.optJSONObject("page"), localbequ.jdField_a_of_type_Berl);
    localbequ.jdField_a_of_type_JavaUtilList = a(localJSONObject.optJSONArray("pages"));
    localbequ.jdField_a_of_type_Berj = berj.a(localJSONObject.optJSONObject("networkTimeout"));
    localbequ.jdField_a_of_type_Berw = berw.a(localJSONObject.optJSONObject("tabBar"));
    Object localObject = localJSONObject.optJSONArray("subpackages");
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = localJSONObject.optJSONArray("subPackages");
    }
    localbequ.jdField_b_of_type_JavaUtilList = b(paramString);
    localbequ.jdField_b_of_type_JavaLangString = localJSONObject.optString("PackageToolVersion");
    localbequ.jdField_a_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("permission");
    return localbequ;
  }
  
  public static List<String> a(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        String str = paramJSONArray.optString(i);
        if (!TextUtils.isEmpty(str)) {
          localLinkedList.add(str);
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public static Map<String, berl> a(JSONObject paramJSONObject, berl paramberl)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        berl localberl = paramberl.b();
        localberl.a(paramJSONObject.optJSONObject(str));
        localHashMap.put(str, localberl);
      }
    }
    return localHashMap;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf("?");
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  private static List<String> b(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optString("root");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localLinkedList.add(localObject);
          }
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public berl a(String paramString)
  {
    paramString = b(paramString);
    berl localberl = (berl)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    paramString = localberl;
    if (localberl == null) {
      paramString = this.jdField_a_of_type_Berl;
    }
    return paramString;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str2 = b(paramString);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    label97:
    label100:
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      if (str3.startsWith("/"))
      {
        paramString = str3.substring(1);
        if (!str2.startsWith("/")) {
          break label97;
        }
      }
      for (String str1 = str2.substring(1);; str1 = str2)
      {
        if (!str1.startsWith(paramString)) {
          break label100;
        }
        return str3;
        paramString = str3;
        break;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bequ
 * JD-Core Version:    0.7.0.1
 */