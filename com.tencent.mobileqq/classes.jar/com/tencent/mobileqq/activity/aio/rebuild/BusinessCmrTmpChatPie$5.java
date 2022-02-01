package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class BusinessCmrTmpChatPie$5
  implements BusinessObserver
{
  BusinessCmrTmpChatPie$5(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("BusinessChatPie", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean) {
      this.a.l(2131695217);
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        localObject = new mobileqq_mp.FollowResponse();
        ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          ((FriendListHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, false);
          paramBundle = (EnterpriseQQHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
          if (paramBundle != null) {
            paramBundle.a(SystemClock.uptimeMillis());
          }
        }
        else if (paramInt == 58)
        {
          this.a.l(2131695212);
        }
        else if (paramInt == 65)
        {
          this.a.l(2131695185);
        }
        else if (paramInt == 20)
        {
          this.a.l(2131695186);
        }
        else
        {
          this.a.l(2131695217);
        }
      }
      label224:
      ChatActivityUtils.b();
    }
    catch (Exception paramBundle)
    {
      break label224;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.5
 * JD-Core Version:    0.7.0.1
 */