package com.tencent.mobileqq.apollo.web;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowWebIPCModule$12
  implements Runnable
{
  CmShowWebIPCModule$12(CmShowWebIPCModule paramCmShowWebIPCModule, QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject3;
    Object localObject2;
    ArrayList localArrayList;
    if (localObject1 != null)
    {
      localObject3 = (IApolloDaoManagerService)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(this.jdField_a_of_type_JavaLangString);
        i = 0;
        if (i < localJSONArray.length())
        {
          Object localObject4 = localJSONArray.getJSONObject(i);
          long l = ((JSONObject)localObject4).optLong("seq");
          int j = ((JSONObject)localObject4).optInt("actionId");
          localObject4 = ((IApolloDaoManagerService)localObject3).findFavActionById(l);
          if ((localObject4 != null) && (j == ((ApolloFavActionData)localObject4).acitonId))
          {
            localArrayList.add(localObject4);
            break label386;
          }
          ((JSONArray)localObject2).put(l);
          break label386;
        }
        if (localArrayList.size() > 0)
        {
          ((IApolloDaoManagerService)localObject3).delFavActionList(localArrayList);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
          if (localObject3 != null)
          {
            localObject3 = ((MqqHandler)localObject3).obtainMessage(66);
            ((Message)localObject3).arg1 = 1;
            ((Message)localObject3).sendToTarget();
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("del fav action success +");
              ((StringBuilder)localObject3).append(((JSONObject)localObject1).toString());
              QLog.d("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
        i = ((JSONArray)localObject2).length();
        if (i > 0) {
          ((JSONObject)localObject1).put("delHasError", true);
        } else {
          ((JSONObject)localObject1).put("delHasError", false);
        }
        ((JSONObject)localObject1).put("errorList", ((JSONArray)localObject2).toString());
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("delFavListAction", ((JSONObject)localObject1).toString());
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delFavAction json error + ");
          ((StringBuilder)localObject2).append(localJSONException.toString());
          QLog.e("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return;
      label386:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.12
 * JD-Core Version:    0.7.0.1
 */