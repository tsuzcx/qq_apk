import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import org.json.JSONObject;

class amyb
  implements adaa
{
  amyb(amxx paramamxx, String paramString, long paramLong, adad paramadad, CmGameInitParams paramCmGameInitParams) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    amxx.a(this.jdField_a_of_type_Amxx, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    amxx.a(this.jdField_a_of_type_Amxx, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token", "");
    amxx.a(this.jdField_a_of_type_Amxx, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Adad);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.openId = str;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessToken = paramJSONObject;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 1;
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyb
 * JD-Core Version:    0.7.0.1
 */