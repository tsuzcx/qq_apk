import android.text.TextUtils;
import cooperation.wadl.ipc.WadlParams;
import org.json.JSONException;
import org.json.JSONObject;

public class bizs
{
  public static String a;
  private static int b;
  private static String j;
  private static String k;
  public int a;
  public long a;
  public WadlParams a;
  public long b;
  public String b;
  public String c = "";
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  static
  {
    try
    {
      j = bgln.f();
      jdField_b_of_type_Int = bgln.e();
      jdField_a_of_type_JavaLangString = bkfy.a("b84cf5");
      k = bgln.b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static bizs a()
  {
    bizs localbizs = new bizs();
    try
    {
      localbizs.jdField_b_of_type_Long = (bgln.e() / 1048576L);
      localbizs.i = String.valueOf(bgln.b()[1]);
      localbizs.jdField_b_of_type_JavaLangString = "";
      localbizs.jdField_a_of_type_Int = 0;
      return localbizs;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localbizs;
  }
  
  public String a()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(j))
        {
          String str1 = j;
          localJSONObject.put("androidId", str1);
          if (!TextUtils.isEmpty(k))
          {
            str1 = k;
            localJSONObject.put("imsi", str1);
            localJSONObject.put("mobileCarriers", jdField_b_of_type_Int);
            localJSONObject.put("leftMemorySize", this.jdField_b_of_type_Long);
            localJSONObject.put("pageUrl", this.e);
            return localJSONObject.toString();
          }
          str1 = "";
          continue;
        }
        String str2 = "";
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bizs
 * JD-Core Version:    0.7.0.1
 */