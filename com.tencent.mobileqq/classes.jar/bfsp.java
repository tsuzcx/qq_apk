import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import cooperation.wadl.ipc.WadlParams;
import org.json.JSONException;
import org.json.JSONObject;

public class bfsp
{
  public static String a;
  private static int jdField_b_of_type_Int;
  private static String i = ;
  private static String j;
  public int a;
  public long a;
  public WadlParams a;
  private boolean a;
  private long jdField_b_of_type_Long;
  public String b;
  public String c;
  public String d;
  public String e = "";
  public String f;
  public String g;
  public String h;
  private String k;
  private String l;
  
  static
  {
    jdField_a_of_type_JavaLangString = bhsp.a("b84cf5");
    j = bdgk.b();
    try
    {
      jdField_b_of_type_Int = bdgk.e();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static bfsp a()
  {
    bfsp localbfsp = new bfsp();
    try
    {
      localbfsp.jdField_a_of_type_Boolean = AppNetConnInfo.isWifiConn();
      localbfsp.jdField_b_of_type_Long = (bdgk.e() / 1048576L);
      localbfsp.k = String.valueOf(bdgk.b()[1]);
      localbfsp.jdField_b_of_type_JavaLangString = "";
      localbfsp.jdField_a_of_type_Int = 0;
      return localbfsp;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localbfsp;
  }
  
  public bfsp a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public bfsp a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String a()
  {
    return this.l;
  }
  
  public void a(WadlParams paramWadlParams)
  {
    this.jdField_a_of_type_CooperationWadlIpcWadlParams = paramWadlParams;
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public String b()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(i))
        {
          String str1 = i;
          localJSONObject.put("androidId", str1);
          if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
            break label161;
          }
          str1 = jdField_a_of_type_JavaLangString;
          localJSONObject.put("imei", str1);
          if (!TextUtils.isEmpty(j))
          {
            str1 = j;
            localJSONObject.put("imsi", str1);
            localJSONObject.put("mobileCarriers", jdField_b_of_type_Int);
            localJSONObject.put("isWifiStatusOn", this.jdField_a_of_type_Boolean);
            localJSONObject.put("leftMemorySize", this.jdField_b_of_type_Long);
            localJSONObject.put("leftDiskSize", this.k);
            localJSONObject.put("downloadRate", this.jdField_b_of_type_JavaLangString);
            localJSONObject.put("pageUrl", this.f);
            return localJSONObject.toString();
          }
          str1 = "";
          continue;
        }
        str2 = "";
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      continue;
      label161:
      String str2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfsp
 * JD-Core Version:    0.7.0.1
 */