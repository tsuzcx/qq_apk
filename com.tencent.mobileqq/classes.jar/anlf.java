import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.6.2;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.6.4;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.6.6;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class anlf
  implements adaa
{
  final String jdField_a_of_type_JavaLangString = "https://open.hudong.qq.com/devtool/authorize";
  
  public anlf(int paramInt1, int paramInt2, String paramString1, String paramString2) {}
  
  private String[] a(int paramInt)
  {
    return new String[] { "Content-Type", "application/x-www-form-urlencoded", "Content-Length", "" + paramInt, "Cookie", "uin=" + this.jdField_b_of_type_JavaLangString + ";skey=" + this.c };
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    String str = "openID=&&accesstoken=&&token=" + this.jdField_a_of_type_Int + "&&gameid=" + this.jdField_b_of_type_Int + "&&subcode=0";
    ThreadManager.post(new ApolloGameUtil.6.2(this, str, a(str.length()), new anlg(this)), 8, null, false);
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = "openID=&&accesstoken=&&token=" + this.jdField_a_of_type_Int + "&&gameid=" + this.jdField_b_of_type_Int + "&&subcode=2";
    ThreadManager.post(new ApolloGameUtil.6.6(this, paramString, a(paramString.length()), new anli(this)), 8, null, false);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    QLog.d("ApolloGameUtil", 2, new Object[] { "get openid and accessToken on Success result = ", paramJSONObject.toString() });
    try
    {
      String str = paramJSONObject.optString("openid");
      paramJSONObject = paramJSONObject.optString("access_token");
      paramJSONObject = "openID=" + str + "&&accesstoken=" + paramJSONObject + "&&token=" + this.jdField_a_of_type_Int + "&&gameid=" + this.jdField_b_of_type_Int + "&&subcode=1";
      ThreadManager.post(new ApolloGameUtil.6.4(this, paramJSONObject, a(paramJSONObject.length()), new anlh(this)), 8, null, false);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("ApolloGameUtil", 2, "getOpenIdAndAccessToken failed ", paramJSONObject);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlf
 * JD-Core Version:    0.7.0.1
 */