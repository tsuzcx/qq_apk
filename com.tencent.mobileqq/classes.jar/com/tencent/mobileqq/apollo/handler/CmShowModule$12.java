package com.tencent.mobileqq.apollo.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.drawer.CardDrawerStatus;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
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

class CmShowModule$12
  implements Runnable
{
  CmShowModule$12(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    boolean bool = false;
    Object localObject1;
    Object localObject2;
    label281:
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      do
      {
        for (;;)
        {
          try
          {
            localObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString);
            JSONObject localJSONObject = new JSONObject();
            localObject2 = ((JSONObject)localObject1).optString("optType");
            if (!"flower".equals(localObject2)) {
              break label281;
            }
            localObject1 = ((JSONObject)localObject1).optJSONObject("data");
            if (localObject1 != null)
            {
              localObject1 = ((JSONObject)localObject1).optString("toUin");
              localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
              Calendar localCalendar = Calendar.getInstance();
              ((SharedPreferences)localObject2).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "apollo_today_has_vote" + (String)localObject1 + localCalendar.get(1) + localCalendar.get(2) + localCalendar.get(5), true).commit();
              localJSONObject.put("result", 0);
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("writeRet", localJSONObject.toString());
              this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
              return;
            }
            localJSONObject.put("result", 1);
            localJSONObject.put("msg", HardCodeUtil.a(2131706679));
            continue;
            QLog.e("CmShowHandler", 2, "delFavAction json error + " + localJSONException.toString());
          }
          catch (JSONException localJSONException)
          {
            if (!QLog.isColorLevel()) {
              break label797;
            }
          }
          return;
          if ("gameIntro".equals(localObject2))
          {
            localObject1 = ((JSONObject)localObject1).optJSONObject("data");
            if (localObject1 != null)
            {
              i = ((JSONObject)localObject1).optInt("gameId");
              BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit().putBoolean("apollo_game_first_clk_" + i, false).commit();
              localJSONException.put("result", 0);
              if (QLog.isColorLevel()) {
                QLog.d("CmShowHandler", 2, "gameIntro from web write, gameId:" + i);
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
              if (QLog.isColorLevel()) {
                QLog.d("CmShowHandler", 2, new Object[] { "lifeChange, gameId", Integer.valueOf(i), ", game coin count=" + j });
              }
              ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
              if (localObject1 != null) {
                ((MqqHandler)localObject1).obtainMessage(76).sendToTarget();
              }
              localJSONException.put("result", 0);
            }
            else
            {
              localJSONException.put("result", 1);
              localJSONException.put("msg", HardCodeUtil.a(2131706699));
            }
          }
          else
          {
            if (!"danUpgrade".equals(localObject2)) {
              break;
            }
            ((ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 128, "refreshAction");
            if (QLog.isColorLevel()) {
              QLog.d("CmShowHandler", 2, "ipc call danUpgrade,maybe have new slave action");
            }
            localJSONException.put("result", 0);
          }
        }
        if (!"drawerAudio".equals(localObject2)) {
          break;
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("data");
      } while (localObject1 == null);
      if (((JSONObject)localObject1).has("audio"))
      {
        i = ((JSONObject)localObject1).optInt("audio");
        break label798;
      }
    }
    for (;;)
    {
      CardDrawerStatus.a(bool);
      break;
      QLog.e("ApolloJsApi", 1, "drawerVoice has no val");
      i = 0;
      break label798;
      if (!"lastShopScheme".equals(localObject2)) {
        break;
      }
      localObject1 = ((JSONObject)localObject1).optJSONObject("data");
      if (QLog.isColorLevel()) {
        QLog.d("CmShowHandler", 2, new Object[] { "lastShopScheme, data=", localObject1 });
      }
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((JSONObject)localObject1).optString("lastShopScheme");
      ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).updateLastShopTabInfo((String)localObject1);
      break;
      label797:
      label798:
      do
      {
        bool = true;
        break;
        return;
        if (i == 0) {
          break;
        }
      } while (i != 1);
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.12
 * JD-Core Version:    0.7.0.1
 */