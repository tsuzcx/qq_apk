import org.json.JSONObject;

public class beyr
{
  public static boolean b;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public boolean d;
  public long e;
  public long f;
  public long g;
  
  public beyr()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("appid", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("engineType", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("reportType", this.jdField_b_of_type_Int);
      ((JSONObject)localObject).put("verType", this.jdField_c_of_type_Int);
      ((JSONObject)localObject).put("launchId", this.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject).put("clickTime", this.jdField_a_of_type_Long);
      ((JSONObject)localObject).put("loadTime", this.jdField_b_of_type_Long);
      ((JSONObject)localObject).put("launchTime", this.jdField_c_of_type_Long);
      ((JSONObject)localObject).put("launchResult", this.jdField_d_of_type_Int);
      ((JSONObject)localObject).put("activeTime", this.jdField_d_of_type_Long);
      ((JSONObject)localObject).put("showTime", this.e);
      ((JSONObject)localObject).put("hideTime", this.f);
      ((JSONObject)localObject).put("jsError", this.jdField_c_of_type_JavaLangString);
      ((JSONObject)localObject).put("needReportLaunchResult", this.jdField_a_of_type_Boolean);
      ((JSONObject)localObject).put("hasPkg", this.jdField_c_of_type_Boolean);
      ((JSONObject)localObject).put("flutterMode", this.jdField_d_of_type_Boolean);
      ((JSONObject)localObject).put("loadEndTime", this.g);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.e = 0L;
    this.f = 0L;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    this.g = 0L;
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = paramString.getString("appid");
      this.jdField_a_of_type_Int = paramString.getInt("engineType");
      this.jdField_b_of_type_Int = paramString.getInt("reportType");
      this.jdField_c_of_type_Int = paramString.getInt("verType");
      this.jdField_b_of_type_JavaLangString = paramString.getString("launchId");
      this.jdField_a_of_type_Long = paramString.getLong("clickTime");
      this.jdField_b_of_type_Long = paramString.getLong("loadTime");
      this.jdField_c_of_type_Long = paramString.getLong("launchTime");
      this.jdField_d_of_type_Int = paramString.getInt("launchResult");
      this.jdField_d_of_type_Long = paramString.getLong("activeTime");
      this.e = paramString.getLong("showTime");
      this.f = paramString.getLong("hideTime");
      this.jdField_c_of_type_JavaLangString = paramString.getString("jsError");
      this.jdField_a_of_type_Boolean = paramString.getBoolean("needReportLaunchResult");
      this.jdField_c_of_type_Boolean = paramString.getBoolean("hasPkg");
      this.jdField_d_of_type_Boolean = paramString.optBoolean("flutterMode");
      this.g = paramString.optLong("loadEndTime");
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SDK_");
    if (jdField_b_of_type_Boolean)
    {
      str = "hasX5";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.jdField_c_of_type_Boolean) {
        break label53;
      }
    }
    label53:
    for (String str = "_hasPkg";; str = "")
    {
      return str;
      str = "";
      break;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchId: ").append(this.jdField_b_of_type_JavaLangString).append(", appId: ").append(0);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beyr
 * JD-Core Version:    0.7.0.1
 */