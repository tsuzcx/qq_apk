package com.tencent.mobileqq.apollo.web;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.drawer.CardDrawerStatus;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowWebIPCModule$13
  implements Runnable
{
  CmShowWebIPCModule$13(CmShowWebIPCModule paramCmShowWebIPCModule, QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (;;)
    {
      boolean bool1;
      int i;
      try
      {
        localObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString);
        JSONObject localJSONObject = new JSONObject();
        Object localObject2 = ((JSONObject)localObject1).optString("optType");
        boolean bool2 = "flower".equals(localObject2);
        bool1 = true;
        if (bool2)
        {
          localObject1 = ((JSONObject)localObject1).optJSONObject("data");
          if (localObject1 != null)
          {
            localObject1 = ((JSONObject)localObject1).optString("toUin");
            Object localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
            localObject2 = Calendar.getInstance();
            localObject3 = ((SharedPreferences)localObject3).edit();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localStringBuilder.append("apollo_today_has_vote");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(((Calendar)localObject2).get(1));
            localStringBuilder.append(((Calendar)localObject2).get(2));
            localStringBuilder.append(((Calendar)localObject2).get(5));
            ((SharedPreferences.Editor)localObject3).putBoolean(localStringBuilder.toString(), true).commit();
            localJSONObject.put("result", 0);
          }
          else
          {
            localJSONObject.put("result", 1);
            localJSONObject.put("msg", HardCodeUtil.a(2131706701));
          }
        }
        else
        {
          bool2 = "gameIntro".equals(localObject2);
          if (bool2)
          {
            localObject1 = ((JSONObject)localObject1).optJSONObject("data");
            if (localObject1 != null)
            {
              i = ((JSONObject)localObject1).optInt("gameId");
              localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("apollo_game_first_clk_");
              ((StringBuilder)localObject2).append(i);
              ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), false).commit();
              localJSONObject.put("result", 0);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("gameIntro from web write, gameId:");
                ((StringBuilder)localObject1).append(i);
                QLog.d("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject1).toString());
              }
            }
          }
          else if ("lifeChange".equals(localObject2))
          {
            localObject1 = ((JSONObject)localObject1).optJSONObject("data");
            if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
            {
              i = ((JSONObject)localObject1).optInt("gameId");
              int j = ((JSONObject)localObject1).optInt("life");
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(", game coin count=");
                ((StringBuilder)localObject1).append(j);
                QLog.d("[cmshow]CmShowHandler", 2, new Object[] { "lifeChange, gameId", Integer.valueOf(i), ((StringBuilder)localObject1).toString() });
              }
              ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
              if (localObject1 != null) {
                ((MqqHandler)localObject1).obtainMessage(76).sendToTarget();
              }
              localJSONObject.put("result", 0);
            }
            else
            {
              localJSONObject.put("result", 1);
              localJSONObject.put("msg", HardCodeUtil.a(2131706721));
            }
          }
          else if ("danUpgrade".equals(localObject2))
          {
            ((ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 128L, "refreshAction");
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]CmShowHandler", 2, "ipc call danUpgrade,maybe have new slave action");
            }
            localJSONObject.put("result", 0);
          }
          else if ("drawerAudio".equals(localObject2))
          {
            localObject1 = ((JSONObject)localObject1).optJSONObject("data");
            if (localObject1 != null)
            {
              if (((JSONObject)localObject1).has("audio"))
              {
                i = ((JSONObject)localObject1).optInt("audio");
                break label865;
              }
              QLog.e("ApolloJsApi", 1, "drawerVoice has no val");
              i = 0;
              break label865;
              CardDrawerStatus.a(bool1);
            }
          }
          else if ("lastShopScheme".equals(localObject2))
          {
            localObject1 = ((JSONObject)localObject1).optJSONObject("data");
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]CmShowHandler", 2, new Object[] { "lastShopScheme, data=", localObject1 });
            }
            if (localObject1 != null)
            {
              localObject1 = ((JSONObject)localObject1).optString("lastShopScheme");
              ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).updateLastShopTabInfo((String)localObject1);
            }
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("writeRet", localJSONObject.toString());
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("delFavAction json error + ");
          ((StringBuilder)localObject1).append(localJSONException.toString());
          QLog.e("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject1).toString());
        }
      }
      return;
      label865:
      if (i == 0) {
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.13
 * JD-Core Version:    0.7.0.1
 */