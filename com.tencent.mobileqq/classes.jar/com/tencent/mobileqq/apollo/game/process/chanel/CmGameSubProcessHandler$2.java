package com.tencent.mobileqq.apollo.game.process.chanel;

import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.ranklist.CmGameUserInfo;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class CmGameSubProcessHandler$2
  implements APICallback
{
  CmGameSubProcessHandler$2(CmGameSubProcessHandler paramCmGameSubProcessHandler, String paramString, long paramLong) {}
  
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
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("ret", 0);
      boolean bool = "cs.get_user_info.local".equals(this.jdField_a_of_type_JavaLangString);
      Object localObject1;
      Object localObject2;
      if (bool)
      {
        localObject1 = CmGameUtil.a(CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler));
        if (localObject1 == null)
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("[getUserInfo], launcher is null, mGameId:");
          paramJSONObject.append(CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler));
          QLog.w("cmgame_process.CmGameSubProcessHandler", 1, paramJSONObject.toString());
          return;
        }
        localObject1 = ((CmGameLauncher)localObject1).a();
        localObject2 = new CmGameUserInfo(paramJSONObject.optString("avatarUrl"), paramJSONObject.optString("nickName"), ((CmGameInitParams)localObject1).openId);
        CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler).put(((CmGameInitParams)localObject1).openId, localObject2);
        localJSONObject1.put("gender", paramJSONObject.optString("gender", ""));
        localJSONObject1.put("city", paramJSONObject.optString("city", ""));
        localJSONObject1.put("province", paramJSONObject.optString("province", ""));
        localJSONObject1.put("country", paramJSONObject.optString("country", ""));
        localJSONObject1.put("openid", ((CmGameInitParams)localObject1).openId);
      }
      else if ("cs.get_app_friends.local".equals(this.jdField_a_of_type_JavaLangString))
      {
        paramJSONObject = paramJSONObject.optJSONArray("appfriends");
        if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
        {
          localObject1 = new JSONArray();
          int j = paramJSONObject.length();
          int i = 0;
          while (i < j)
          {
            localObject2 = paramJSONObject.getJSONObject(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("openid", ((JSONObject)localObject2).optString("openid"));
            Object localObject3 = ((JSONObject)localObject2).optString("openid");
            localObject3 = new CmGameUserInfo(((JSONObject)localObject2).optString("avatarUrl"), ((JSONObject)localObject2).optString("nickName"), (String)localObject3);
            CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler).put(((JSONObject)localObject2).optString("openid"), localObject3);
            ((JSONArray)localObject1).put(localJSONObject2);
            i += 1;
          }
          localJSONObject1.put("friendsInfo", localObject1);
        }
      }
      else if ("cs.get_city.local".equals(this.jdField_a_of_type_JavaLangString))
      {
        localJSONObject1.put("nation", paramJSONObject.optString("nation", ""));
        localJSONObject1.put("province", paramJSONObject.optString("province", ""));
        localJSONObject1.put("city", paramJSONObject.optString("city", ""));
        localJSONObject1.put("district", paramJSONObject.optString("district", ""));
      }
      else if ("cs.get_location.local".equals(this.jdField_a_of_type_JavaLangString))
      {
        localJSONObject1.put("latitude", paramJSONObject.optString("latitude", ""));
        localJSONObject1.put("longitude", paramJSONObject.optString("longitude", ""));
        localJSONObject1.put("speed", paramJSONObject.optString("speed", ""));
        localJSONObject1.put("accuracy", paramJSONObject.optString("accuracy", ""));
        localJSONObject1.put("altitude", paramJSONObject.optString("altitude", ""));
        localJSONObject1.put("verticalAccuracy", paramJSONObject.optString("verticalAccuracy", ""));
        localJSONObject1.put("horizontalAccuracy", paramJSONObject.optString("horizontalAccuracy", ""));
      }
      QLog.isColorLevel();
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_Long, 0, this.jdField_a_of_type_JavaLangString, localJSONObject1.toString());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameSubProcessHandler.2
 * JD-Core Version:    0.7.0.1
 */