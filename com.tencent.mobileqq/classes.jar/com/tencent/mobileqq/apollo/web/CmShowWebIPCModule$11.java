package com.tencent.mobileqq.apollo.web;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowWebIPCModule$11
  implements Runnable
{
  CmShowWebIPCModule$11(CmShowWebIPCModule paramCmShowWebIPCModule, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 != null)
    {
      Object localObject3 = (IApolloDaoManagerService)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
      ApolloFavActionData localApolloFavActionData = ((IApolloDaoManagerService)localObject3).findFavActionById(this.jdField_a_of_type_Long);
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("seq", this.jdField_a_of_type_Long);
        if (localApolloFavActionData == null)
        {
          ((JSONObject)localObject1).put("ret", 1);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]CmShowHandler", 2, "del fav but local has not the action");
          }
        }
        else if (this.jdField_a_of_type_Int != localApolloFavActionData.acitonId)
        {
          ((JSONObject)localObject1).put("ret", 2);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("del fav action fail +");
            ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
            QLog.d("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          ((IApolloDaoManagerService)localObject3).delFavAction(localApolloFavActionData);
          ((JSONObject)localObject1).put("ret", 0);
          MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
          if (localMqqHandler != null)
          {
            localObject2 = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
            ((ApolloInfo)localObject2).mAction = ((IApolloDaoManagerService)localObject3).findActionById(this.jdField_a_of_type_Int);
            ((ApolloInfo)localObject2).mActionText = localApolloFavActionData.text;
            ((ApolloInfo)localObject2).mTextType = localApolloFavActionData.textType;
            localObject3 = localMqqHandler.obtainMessage(66);
            ((Message)localObject3).obj = localObject2;
            ((Message)localObject3).arg1 = 1;
            ((Message)localObject3).sendToTarget();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("del fav action success +");
              ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
              QLog.d("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("delFavAction", ((JSONObject)localObject1).toString());
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delFavAction json error + ");
          ((StringBuilder)localObject2).append(localJSONException.toString());
          QLog.e("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.11
 * JD-Core Version:    0.7.0.1
 */