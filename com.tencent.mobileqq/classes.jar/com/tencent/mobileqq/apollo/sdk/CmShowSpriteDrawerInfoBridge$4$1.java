package com.tencent.mobileqq.apollo.sdk;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmShowSpriteDrawerInfoBridge$4$1
  implements Runnable
{
  CmShowSpriteDrawerInfoBridge$4$1(CmShowSpriteDrawerInfoBridge.4 param4, String paramString, CmShowSpriteActionScript paramCmShowSpriteActionScript) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.jdField_a_of_type_JavaLangString).optJSONArray("sprites");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("dressInfos", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeDress('").append(localJSONObject.toString()).append("');");
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteActionScript.a(((StringBuilder)localObject).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "checkfDressChanged onCallback e:", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.4.1
 * JD-Core Version:    0.7.0.1
 */