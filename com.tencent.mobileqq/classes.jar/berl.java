import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class berl
{
  public besa a;
  public besc a;
  public besn a;
  public String a;
  public List<String> a;
  private Map<String, besc> a;
  public JSONObject a;
  public boolean a;
  public String b;
  public List<String> b;
  private Map<String, String> b;
  
  public berl()
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
  }
  
  public static berl a(String paramString)
  {
    berl localberl = new berl();
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.keys();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        String str = localJSONObject.optString((String)localObject);
        localberl.jdField_b_of_type_JavaUtilMap.put(localObject, str);
      }
      localberl.jdField_a_of_type_Boolean = localJSONObject.optBoolean("debug");
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return localberl;
    }
    localberl.jdField_a_of_type_JavaLangString = localJSONObject.optString("entryPagePath");
    localberl.jdField_a_of_type_Besc = besc.a();
    localberl.jdField_a_of_type_Besc.a(localJSONObject.optJSONObject("global"));
    localberl.jdField_a_of_type_JavaUtilMap = a(localJSONObject.optJSONObject("page"), localberl.jdField_a_of_type_Besc);
    localberl.jdField_a_of_type_JavaUtilList = a(localJSONObject.optJSONArray("pages"));
    localberl.jdField_a_of_type_Besa = besa.a(localJSONObject.optJSONObject("networkTimeout"));
    localberl.jdField_a_of_type_Besn = besn.a(localJSONObject.optJSONObject("tabBar"));
    Object localObject = localJSONObject.optJSONArray("subpackages");
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = localJSONObject.optJSONArray("subPackages");
    }
    localberl.jdField_b_of_type_JavaUtilList = b(paramString);
    localberl.jdField_b_of_type_JavaLangString = localJSONObject.optString("PackageToolVersion");
    localberl.jdField_a_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("permission");
    return localberl;
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
  
  public static Map<String, besc> a(JSONObject paramJSONObject, besc parambesc)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        besc localbesc = parambesc.b();
        localbesc.a(paramJSONObject.optJSONObject(str));
        localHashMap.put(str, localbesc);
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
  
  public besc a(String paramString)
  {
    paramString = b(paramString);
    besc localbesc = (besc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    paramString = localbesc;
    if (localbesc == null) {
      paramString = this.jdField_a_of_type_Besc;
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
 * Qualified Name:     berl
 * JD-Core Version:    0.7.0.1
 */