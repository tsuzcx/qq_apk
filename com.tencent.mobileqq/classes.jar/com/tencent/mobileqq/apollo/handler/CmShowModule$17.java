package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloGameRoamData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class CmShowModule$17
  implements Runnable
{
  CmShowModule$17(CmShowModule paramCmShowModule, String paramString, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      Object localObject2 = new JSONObject(this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).optLong("timestamp");
      Object localObject1 = new ArrayList();
      localObject2 = ((JSONObject)localObject2).optJSONArray("gameList");
      while (i < ((JSONArray)localObject2).length())
      {
        ApolloGameRoamData localApolloGameRoamData = new ApolloGameRoamData();
        JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
        localApolloGameRoamData.gameId = localJSONObject.optInt("gameId");
        localApolloGameRoamData.type = localJSONObject.optInt("tab");
        ((ArrayList)localObject1).add(localApolloGameRoamData);
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmShowHandler", 2, "IPC_APOLLO_UPDATE_GAME_LIST, update game list");
        }
        localObject2 = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        ((IApolloDaoManagerService)localObject2).removeAllGameRoamData();
        ((IApolloDaoManagerService)localObject2).saveGameRoamData((ArrayList)localObject1);
        ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).onAddOrDelGame();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("result", 0);
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmShowHandler", 1, "IPC_APOLLO_UPDATE_GAME_LIST, exception=", localException);
      Bundle localBundle = new Bundle();
      localBundle.putInt("result", 1);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.17
 * JD-Core Version:    0.7.0.1
 */