package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloFavActionData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowModule$11
  implements Runnable
{
  CmShowModule$11(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    int i = 0;
    Object localObject2;
    Object localObject1;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject2 = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      JSONObject localJSONObject = new JSONObject();
      localObject1 = new JSONArray();
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.jdField_a_of_type_JavaLangString);
        if (i >= localJSONArray.length()) {
          break label183;
        }
        Object localObject3 = localJSONArray.getJSONObject(i);
        long l = ((JSONObject)localObject3).optLong("seq");
        int j = ((JSONObject)localObject3).optInt("actionId");
        localObject3 = ((IApolloDaoManagerService)localObject2).findFavActionById(l);
        if ((localObject3 == null) || (j != ((ApolloFavActionData)localObject3).acitonId)) {
          ((JSONArray)localObject1).put(l);
        } else {
          localArrayList.add(localObject3);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CmShowHandler", 2, "delFavAction json error + " + localJSONException.toString());
        }
      }
      return;
      label183:
      if (localArrayList.size() > 0)
      {
        ((IApolloDaoManagerService)localObject2).delFavActionList(localArrayList);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject2 != null)
        {
          localObject2 = ((MqqHandler)localObject2).obtainMessage(66);
          ((Message)localObject2).arg1 = 1;
          ((Message)localObject2).sendToTarget();
          if (QLog.isColorLevel()) {
            QLog.d("CmShowHandler", 2, "del fav action success +" + localJSONException.toString());
          }
        }
      }
      if (((JSONArray)localObject1).length() > 0) {
        localJSONException.put("delHasError", true);
      }
      for (;;)
      {
        localJSONException.put("errorList", ((JSONArray)localObject1).toString());
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("delFavListAction", localJSONException.toString());
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
        localJSONException.put("delHasError", false);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.11
 * JD-Core Version:    0.7.0.1
 */