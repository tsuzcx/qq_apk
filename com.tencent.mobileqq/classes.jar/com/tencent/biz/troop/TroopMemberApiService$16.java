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

class TroopMemberApiService$16
  extends TransProcessorHandler
{
  TroopMemberApiService$16(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((TroopMemberApiService.g(this.a) instanceof QQAppInterface))
    {
      FileMsg localFileMsg = (FileMsg)paramMessage.obj;
      Bundle localBundle = new Bundle();
      localBundle.putInt("seq", this.a.l);
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
        this.a.i = NearbyPeoplePhotoUploadProcessor.mPhotoId;
        if (this.a.i != this.a.j)
        {
          paramMessage = this.a;
          paramMessage.j = paramMessage.i;
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = ");
            paramMessage.append(this.a.i);
            QLog.i("TroopMemberApiService", 2, paramMessage.toString());
          }
          paramMessage = (INearbyCardHandler)((QQAppInterface)TroopMemberApiService.h(this.a)).getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
          if (paramMessage != null) {
            paramMessage.a(this.a.k, this.a.i, true);
          }
          localBundle.putInt("head_id", this.a.i);
          localBundle.putString("video_id", this.a.k);
          localBundle.putBoolean("isSuccess", true);
          this.a.a(75, localBundle);
        }
      }
      else
      {
        if (localFileMsg.fileType == 39)
        {
          this.a.k = ((NearbyPeoplePhotoUploadProcessor)localFileMsg.processor).mVideoId;
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("mPhotoUploadHandler.handleMessage(), big video upload success. videoId = ");
            paramMessage.append(this.a.k);
            QLog.i("TroopMemberApiService", 2, paramMessage.toString());
          }
          ((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).uploadThumbPhoto((QQAppInterface)TroopMemberApiService.i(this.a), this.a.h);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.16
 * JD-Core Version:    0.7.0.1
 */