package com.tencent.mobileqq.apollo.game.process.chanel;

import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import org.json.JSONObject;

class CmGameSubProcessHandler$1
  implements APICallback
{
  CmGameSubProcessHandler$1(CmGameSubProcessHandler paramCmGameSubProcessHandler, String paramString, long paramLong, DoraemonAPIManager paramDoraemonAPIManager, CmGameInitParams paramCmGameInitParams) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token", "");
    CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager);
    CmGameInitParams localCmGameInitParams = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams;
    localCmGameInitParams.openId = str;
    localCmGameInitParams.accessToken = paramJSONObject;
    localCmGameInitParams.accessTokenRet = 1;
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameSubProcessHandler.1
 * JD-Core Version:    0.7.0.1
 */