package com.tencent.biz.troop;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

class TroopMemberApiService$15
  extends TransProcessorHandler
{
  TroopMemberApiService$15(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((TroopMemberApiService.g(this.a) instanceof QQAppInterface))
    {
      FileMsg localFileMsg = (FileMsg)paramMessage.obj;
      Bundle localBundle = new Bundle();
      localBundle.putInt("seq", this.a.c);
      int i = paramMessage.what;
      if (i != 1003)
      {
        if (i != 1005) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed. STATUS_SEND_ERROR");
        }
        localBundle.putBoolean("isSuccess", false);
        this.a.a(75, localBundle);
        return;
      }
      if (localFileMsg.fileType == 64)
      {
        this.a.jdField_a_of_type_Int = NearbyPeoplePhotoUploadProcessor.mPhotoId;
        if (this.a.jdField_a_of_type_Int != this.a.jdField_b_of_type_Int)
        {
          paramMessage = this.a;
          paramMessage.jdField_b_of_type_Int = paramMessage.jdField_a_of_type_Int;
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = ");
            paramMessage.append(this.a.jdField_a_of_type_Int);
            QLog.i("TroopMemberApiService", 2, paramMessage.toString());
          }
          paramMessage = (INearbyCardHandler)((QQAppInterface)TroopMemberApiService.h(this.a)).getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
          if (paramMessage != null) {
            paramMessage.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, true);
          }
          localBundle.putInt("head_id", this.a.jdField_a_of_type_Int);
          localBundle.putString("video_id", this.a.jdField_b_of_type_JavaLangString);
          localBundle.putBoolean("isSuccess", true);
          this.a.a(75, localBundle);
        }
      }
      else
      {
        if (localFileMsg.fileType == 39)
        {
          this.a.jdField_b_of_type_JavaLangString = ((NearbyPeoplePhotoUploadProcessor)localFileMsg.processor).mVideoId;
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("mPhotoUploadHandler.handleMessage(), big video upload success. videoId = ");
            paramMessage.append(this.a.jdField_b_of_type_JavaLangString);
            QLog.i("TroopMemberApiService", 2, paramMessage.toString());
          }
          ((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).uploadThumbPhoto((QQAppInterface)TroopMemberApiService.i(this.a), this.a.jdField_a_of_type_JavaLangString);
          return;
        }
        localBundle.putBoolean("isSuccess", false);
        this.a.a(75, localBundle);
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.15
 * JD-Core Version:    0.7.0.1
 */