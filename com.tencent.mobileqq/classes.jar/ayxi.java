import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ayxi
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public ayxi() {}
  
  public ayxi(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  public static String a(List<ayxi> paramList)
  {
    if (paramList == null) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ayxi localayxi = (ayxi)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("i", localayxi.jdField_a_of_type_JavaLangString);
        if (localayxi.jdField_a_of_type_Int != 80) {
          localJSONObject.put("p", localayxi.jdField_a_of_type_Int);
        }
        if (localayxi.c != 1) {
          localJSONObject.put("t", localayxi.c);
        }
        localJSONArray.put(localJSONObject);
      }
      paramList = localJSONArray.toString();
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    return paramList;
  }
  
  public static ArrayList<ayxi> a(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      JSONArray localJSONArray = new JSONArray(paramString);
      int i = 0;
      for (;;)
      {
        paramString = localArrayList;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        localArrayList.add(new ayxi(paramString.getString("i"), paramString.optInt("p", 80), paramString.optInt("t", 1)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxi
 * JD-Core Version:    0.7.0.1
 */