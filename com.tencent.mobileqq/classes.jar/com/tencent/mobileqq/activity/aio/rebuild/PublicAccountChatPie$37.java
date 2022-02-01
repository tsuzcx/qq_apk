package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

class PublicAccountChatPie$37
  implements BusinessObserver
{
  PublicAccountChatPie$37(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("data");
        paramInt = paramBundle.getInt("type", 0);
        if (arrayOfByte == null) {
          continue;
        }
        paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
        if (paramInt == 0) {
          paramBundle.mergeFrom(arrayOfByte);
        }
        for (paramBoolean = true; (paramBoolean) && (paramBundle.ret_info.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() == 0); paramBoolean = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).convert0xcf8ToMobileMP(arrayOfByte, localGetPublicAccountDetailInfoResponse, paramBundle))
        {
          ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountChatPie.37.1(this, paramBundle), 10L);
          return;
        }
        return;
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.37
 * JD-Core Version:    0.7.0.1
 */