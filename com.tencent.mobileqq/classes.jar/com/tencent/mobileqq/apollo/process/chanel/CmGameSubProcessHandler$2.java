package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import org.json.JSONObject;

class CmGameSubProcessHandler$2
  implements APICallback
{
  CmGameSubProcessHandler$2(CmGameSubProcessHandler paramCmGameSubProcessHandler, String paramString, long paramLong, DoraemonAPIManager paramDoraemonAPIManager, CmGameInitParams paramCmGameInitParams) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token", "");
    CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.openId = str;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessToken = paramJSONObject;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 1;
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.2
 * JD-Core Version:    0.7.0.1
 */