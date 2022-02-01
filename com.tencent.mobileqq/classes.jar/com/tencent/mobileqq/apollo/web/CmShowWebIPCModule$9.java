package com.tencent.mobileqq.apollo.web;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowWebIPCModule$9
  implements Runnable
{
  CmShowWebIPCModule$9(CmShowWebIPCModule paramCmShowWebIPCModule, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 != null)
    {
      List localList = ((IApolloDaoManagerService)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).getFavPackageActionList();
      localObject1 = new JSONObject();
      Object localObject2 = new JSONArray();
      if (localList != null)
      {
        int i = 0;
        try
        {
          while (i < localList.size())
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("seq", ((ApolloFavActionData)localList.get(i)).favId);
            localJSONObject.put("actionId", ((ApolloFavActionData)localList.get(i)).acitonId);
            localJSONObject.put("actionText", ((ApolloFavActionData)localList.get(i)).text);
            localJSONObject.put("textType", ((ApolloFavActionData)localList.get(i)).textType);
            localJSONObject.put("audioId", ((ApolloFavActionData)localList.get(i)).audioId);
            if (!Float.isNaN(((ApolloFavActionData)localList.get(i)).audioStartTime)) {
              localJSONObject.put("audioStartTime", ((ApolloFavActionData)localList.get(i)).audioStartTime);
            }
            ((JSONArray)localObject2).put(localJSONObject);
            i += 1;
          }
          ((JSONObject)localObject1).put("favActionSet", localObject2);
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getLocalFavAction json error ");
            ((StringBuilder)localObject2).append(localJSONException.toString());
            QLog.e("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("getFavResult", ((JSONObject)localObject1).toString());
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.9
 * JD-Core Version:    0.7.0.1
 */