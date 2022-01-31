import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class bazn
{
  public String a;
  public ArrayList<bazs> a;
  
  public bazn(String paramString, ArrayList<bazs> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public static String a(HashMap<String, bazn> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramHashMap = paramHashMap.values().iterator();
      while (paramHashMap.hasNext())
      {
        bazn localbazn = (bazn)paramHashMap.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("n", localbazn.jdField_a_of_type_JavaLangString);
        localJSONObject.put("l", bazs.a(localbazn.jdField_a_of_type_JavaUtilArrayList));
        localJSONArray.put(localJSONObject);
      }
      paramHashMap = localJSONArray.toString();
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      return null;
    }
    return paramHashMap;
  }
  
  public static HashMap<String, bazn> a(String paramString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      JSONArray localJSONArray = new JSONArray(paramString);
      int i = 0;
      for (;;)
      {
        paramString = localHashMap;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        String str = paramString.getString("n");
        localHashMap.put(str, new bazn(str, bazs.a(paramString.getString("l"))));
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazn
 * JD-Core Version:    0.7.0.1
 */