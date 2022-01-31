import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class amwz
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public amwz()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = -1;
  }
  
  public static amwz a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amwz localamwz = new amwz();
        paramString = new JSONObject(paramString);
        Object localObject = paramString.optJSONArray("whiteList");
        if (localObject != null) {
          localamwz.jdField_a_of_type_JavaLangString = ((JSONArray)localObject).toString();
        }
        localObject = paramString.optJSONObject("jumpLimit");
        if (localObject != null) {
          localamwz.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).toString();
        }
        localObject = paramString.optJSONArray("whiteListv2");
        if (localObject != null) {
          localamwz.c = ((JSONArray)localObject).toString();
        }
        int i = paramString.optInt("aio_pre_safecheck", -1);
        if (i != -1) {
          localamwz.jdField_a_of_type_Int = i;
        }
        localObject = paramString.optJSONArray("kbWhiteList");
        if (localObject != null) {
          localamwz.d = ((JSONArray)localObject).toString();
        }
        i = paramString.optInt("force_https_enable", -1);
        if (i != -1) {
          localamwz.jdField_b_of_type_Int = i;
        }
        localObject = paramString.optJSONArray("force_https_whitelist");
        if (localObject != null) {
          localamwz.e = ((JSONArray)localObject).toString();
        }
        paramString = paramString.optJSONArray("force_https_blacklist");
        if (paramString != null) {
          localamwz.f = paramString.toString();
        }
        QLog.d("ConfBean", 2, "confBean = " + localamwz.toString());
        return localamwz;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("whitelistStr:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" limit:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" whiteListV2:").append(this.c);
    localStringBuilder.append(" aioPreCheckSwitch:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" kbWhiteList:").append(this.d);
    localStringBuilder.append(" forceHttpsEnable:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" forceHttpsWhitelist:").append(this.e);
    localStringBuilder.append(" forceHttpsBlacklist:").append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwz
 * JD-Core Version:    0.7.0.1
 */