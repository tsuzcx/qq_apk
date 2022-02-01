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

class CmShowWebIPCModule$10
  implements Runnable
{
  CmShowWebIPCModule$10(CmShowWebIPCModule paramCmShowWebIPCModule, QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, float paramFloat, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Object localObject2 = new ApolloFavActionData();
      ((ApolloFavActionData)localObject2).acitonId = this.jdField_a_of_type_Int;
      ((ApolloFavActionData)localObject2).text = this.jdField_a_of_type_JavaLangString;
      ((ApolloFavActionData)localObject2).textType = this.b;
      ((ApolloFavActionData)localObject2).audioId = this.c;
      ((ApolloFavActionData)localObject2).playOriginalAudio = this.d;
      ((ApolloFavActionData)localObject2).audioStartTime = this.jdField_a_of_type_Float;
      long l = System.currentTimeMillis();
      ((ApolloFavActionData)localObject2).favId = l;
      Object localObject1 = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      ((IApolloDaoManagerService)localObject1).insertFavActionPackageData((ApolloFavActionData)localObject2);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("add fav action success +");
        ((StringBuilder)localObject3).append(((ApolloFavActionData)localObject2).toString());
        QLog.d("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject3).toString());
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localObject3 != null)
      {
        localObject2 = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        ((ApolloInfo)localObject2).mAction = ((IApolloDaoManagerService)localObject1).findActionById(this.jdField_a_of_type_Int);
        ((ApolloInfo)localObject2).mActionText = this.jdField_a_of_type_JavaLangString;
        ((ApolloInfo)localObject2).mTextType = this.b;
        ((ApolloInfo)localObject2).mAudioId = this.c;
        ((ApolloInfo)localObject2).mAudioStartTime = this.jdField_a_of_type_Float;
        ((ApolloInfo)localObject2).mPlayOriginalAudio = this.d;
        localObject1 = ((MqqHandler)localObject3).obtainMessage(66);
        ((Message)localObject1).obj = localObject2;
        ((Message)localObject1).sendToTarget();
      }
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("seq", l);
        ((JSONObject)localObject1).put("success", true);
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("addFavAction ipc json error + ");
          ((StringBuilder)localObject3).append(localJSONException.toString());
          QLog.e("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject3).toString());
        }
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("addFavAction", ((JSONObject)localObject1).toString());
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.10
 * JD-Core Version:    0.7.0.1
 */