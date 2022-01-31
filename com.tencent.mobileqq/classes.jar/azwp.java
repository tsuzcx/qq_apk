import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class azwp
{
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static String b = "";
  
  public azwp()
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = "";
    b = "";
  }
  
  public azwp(boolean paramBoolean, String paramString1, String paramString2)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    jdField_a_of_type_JavaLangString = paramString1;
    b = paramString2;
  }
  
  public static azwp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str2 = "";
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("globalOpen", 0);
        Object localObject;
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localObject = paramString.optJSONObject("weikeUrls");
          paramString = ((JSONObject)localObject).optString("choose_exam");
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            boolean bool;
            String str1;
            paramString = "";
          }
        }
        try
        {
          localObject = ((JSONObject)localObject).optString("get_exam_info");
          if (i != 1) {
            break label85;
          }
          bool = true;
          return new azwp(bool, paramString, (String)localObject);
        }
        catch (JSONException localJSONException3)
        {
          break label75;
        }
        localJSONException1 = localJSONException1;
        i = 0;
        paramString = "";
      }
      label75:
      str1 = str2;
      continue;
      label85:
      bool = false;
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azwp
 * JD-Core Version:    0.7.0.1
 */