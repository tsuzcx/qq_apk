import android.text.TextUtils;
import cooperation.wadl.ipc.WadlParams;
import org.json.JSONException;
import org.json.JSONObject;

public class bkar
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
      j = bhlo.f();
      jdField_b_of_type_Int = bhlo.e();
      jdField_a_of_type_JavaLangString = blhc.a("b84cf5");
      k = bhlo.b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static bkar a()
  {
    bkar localbkar = new bkar();
    try
    {
      localbkar.jdField_b_of_type_Long = (bhlo.e() / 1048576L);
      localbkar.i = String.valueOf(bhlo.b()[1]);
      localbkar.jdField_b_of_type_JavaLangString = "";
      localbkar.jdField_a_of_type_Int = 0;
      return localbkar;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localbkar;
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
 * Qualified Name:     bkar
 * JD-Core Version:    0.7.0.1
 */