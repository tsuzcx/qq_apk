package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

class PublicAccountChatPie$38
  implements BusinessObserver
{
  PublicAccountChatPie$38(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("success:");
      ((StringBuilder)localObject2).append(String.valueOf(paramBoolean));
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (!paramBoolean) {
      return;
    }
    try
    {
      localObject1 = paramBundle.getByteArray("data");
      paramInt = paramBundle.getInt("type", 0);
      if (localObject1 != null)
      {
        paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        localObject2 = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
        if (paramInt == 0)
        {
          paramBundle.mergeFrom((byte[])localObject1);
          paramBoolean = true;
        }
        else
        {
          paramBoolean = PublicAccountChatPie.a((byte[])localObject1, (oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse)localObject2, paramBundle);
        }
        if ((paramBoolean) && (paramBundle.ret_info.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() == 0)) {
          ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountChatPie.38.1(this, paramBundle), 10L);
        }
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.38
 * JD-Core Version:    0.7.0.1
 */