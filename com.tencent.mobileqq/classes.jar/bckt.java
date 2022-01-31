import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import cooperation.wadl.ipc.WadlParams;
import org.json.JSONException;
import org.json.JSONObject;

public class bckt
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
    jdField_a_of_type_JavaLangString = befc.a("b84cf5");
    j = babp.b();
    try
    {
      jdField_b_of_type_Int = babp.e();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static bckt a()
  {
    bckt localbckt = new bckt();
    try
    {
      localbckt.jdField_a_of_type_Boolean = AppNetConnInfo.isWifiConn();
      localbckt.jdField_b_of_type_Long = (babp.e() / 1048576L);
      localbckt.k = String.valueOf(babp.b()[1]);
      localbckt.jdField_b_of_type_JavaLangString = "";
      localbckt.jdField_a_of_type_Int = 0;
      return localbckt;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localbckt;
  }
  
  public bckt a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public bckt a(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bckt
 * JD-Core Version:    0.7.0.1
 */