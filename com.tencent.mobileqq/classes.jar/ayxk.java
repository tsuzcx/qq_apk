import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ayxk
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public ayxk() {}
  
  public ayxk(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  public static String a(List<ayxk> paramList)
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
        ayxk localayxk = (ayxk)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("i", localayxk.jdField_a_of_type_JavaLangString);
        if (localayxk.jdField_a_of_type_Int != 80) {
          localJSONObject.put("p", localayxk.jdField_a_of_type_Int);
        }
        if (localayxk.c != 1) {
          localJSONObject.put("t", localayxk.c);
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
  
  public static ArrayList<ayxk> a(String paramString)
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
        localArrayList.add(new ayxk(paramString.getString("i"), paramString.optInt("p", 80), paramString.optInt("t", 1)));
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
 * Qualified Name:     ayxk
 * JD-Core Version:    0.7.0.1
 */