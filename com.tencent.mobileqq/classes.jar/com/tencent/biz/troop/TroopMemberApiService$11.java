package com.tencent.biz.troop;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

class TroopMemberApiService$11
  extends TransProcessorHandler
{
  TroopMemberApiService$11(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg;
    Bundle localBundle;
    if ((TroopMemberApiService.k(this.a) instanceof QQAppInterface))
    {
      localFileMsg = (FileMsg)paramMessage.obj;
      localBundle = new Bundle();
      localBundle.putInt("seq", this.a.c);
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
    case 1003: 
      do
      {
        do
        {
          return;
          if (localFileMsg.fileType != 64) {
            break;
          }
          this.a.jdField_a_of_type_Int = NearbyPeoplePhotoUploadProcessor.mPhotoId;
        } while (this.a.jdField_a_of_type_Int == this.a.jdField_b_of_type_Int);
        this.a.jdField_b_of_type_Int = this.a.jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = " + this.a.jdField_a_of_type_Int);
        }
        paramMessage = (NearbyCardHandler)((QQAppInterface)TroopMemberApiService.l(this.a)).getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
        if (paramMessage != null) {
          paramMessage.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, true);
        }
        localBundle.putInt("head_id", this.a.jdField_a_of_type_Int);
        localBundle.putString("video_id", this.a.jdField_b_of_type_JavaLangString);
        localBundle.putBoolean("isSuccess", true);
        this.a.a(75, localBundle);
        return;
        if (localFileMsg.fileType == 39)
        {
          this.a.jdField_b_of_type_JavaLangString = ((NearbyPeoplePhotoUploadProcessor)localFileMsg.processor).mVideoId;
          if (QLog.isColorLevel()) {
            QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), big video upload success. videoId = " + this.a.jdField_b_of_type_JavaLangString);
          }
          NearbyVideoUtils.a((QQAppInterface)TroopMemberApiService.m(this.a), this.a.jdField_a_of_type_JavaLangString);
          return;
        }
        localBundle.putBoolean("isSuccess", false);
        this.a.a(75, localBundle);
      } while (!QLog.isColorLevel());
      QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed. STATUS_SEND_ERROR");
    }
    localBundle.putBoolean("isSuccess", false);
    this.a.a(75, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.11
 * JD-Core Version:    0.7.0.1
 */