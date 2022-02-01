package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowModule$10
  implements Runnable
{
  CmShowModule$10(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject2;
    ApolloFavActionData localApolloFavActionData;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject2 = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      localApolloFavActionData = ((IApolloDaoManagerService)localObject2).findFavActionById(this.jdField_a_of_type_Long);
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject.put("seq", this.jdField_a_of_type_Long);
          if (localApolloFavActionData != null) {
            continue;
          }
          localJSONObject.put("ret", 1);
          if (QLog.isColorLevel()) {
            QLog.d("CmShowHandler", 2, "del fav but local has not the action");
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e("CmShowHandler", 2, "delFavAction json error + " + localJSONException.toString());
          return;
          ((IApolloDaoManagerService)localObject2).delFavAction(localApolloFavActionData);
          localJSONException.put("ret", 0);
          MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
          if (localMqqHandler == null) {
            continue;
          }
          Object localObject1 = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          ((ApolloInfo)localObject1).mAction = ((IApolloDaoManagerService)localObject2).findActionById(this.jdField_a_of_type_Int);
          ((ApolloInfo)localObject1).mActionText = localApolloFavActionData.text;
          ((ApolloInfo)localObject1).mTextType = localApolloFavActionData.textType;
          localObject2 = localMqqHandler.obtainMessage(66);
          ((Message)localObject2).obj = localObject1;
          ((Message)localObject2).arg1 = 1;
          ((Message)localObject2).sendToTarget();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CmShowHandler", 2, "del fav action success +" + localJSONException.toString());
          continue;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("delFavAction", localJSONObject.toString());
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
        if (this.jdField_a_of_type_Int == localApolloFavActionData.acitonId) {
          continue;
        }
        localJSONObject.put("ret", 2);
        if (QLog.isColorLevel()) {
          QLog.d("CmShowHandler", 2, "del fav action fail +" + localJSONObject.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.10
 * JD-Core Version:    0.7.0.1
 */