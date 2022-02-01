package com.tencent.mobileqq.activity.aio.helper;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.qqwallet.birthday_hb_reminder_srv.HbList;
import tencent.im.qqwallet.birthday_hb_reminder_srv.ListQueryReply;

class QWalletAIOLifeCycleHelper$6
  implements BusinessObserver
{
  QWalletAIOLifeCycleHelper$6(QWalletAIOLifeCycleHelper paramQWalletAIOLifeCycleHelper, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive:type:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",isSuccess:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(",bundle:");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.d("QWalletAIOLifeCycleHelper", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = paramBundle.getByteArray("data");
        if ((localObject1 == null) || (localObject1.length <= 0) || (!paramBoolean)) {
          break label428;
        }
        paramBundle = new birthday_hb_reminder_srv.ListQueryReply();
        paramBundle.mergeFrom((byte[])localObject1);
        paramInt = paramBundle.ret_code.get();
        localObject1 = paramBundle.ret_msg.get();
        i = paramBundle.pack_count.get();
        ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putInt(this.a.getCurrentUin(), i);
        paramBundle = paramBundle.hb_list.get();
        if (!QLog.isColorLevel()) {
          break label429;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("retCode:");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(",message:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",packCount:");
        ((StringBuilder)localObject2).append(i);
        QLog.d("QWalletAIOLifeCycleHelper", 2, ((StringBuilder)localObject2).toString());
      }
      catch (Throwable paramBundle)
      {
        int i;
        Object localObject2;
        String str;
        paramBundle.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onReceive fail exception:");
        ((StringBuilder)localObject1).append(paramBundle.getMessage());
        QLog.e("QWalletAIOLifeCycleHelper", 1, ((StringBuilder)localObject1).toString());
      }
      if (paramInt < paramBundle.size())
      {
        localObject1 = (birthday_hb_reminder_srv.HbList)paramBundle.get(paramInt);
        ((birthday_hb_reminder_srv.HbList)localObject1).listid.get();
        i = ((birthday_hb_reminder_srv.HbList)localObject1).state.get();
        ((birthday_hb_reminder_srv.HbList)localObject1).amount.get();
        localObject2 = ((birthday_hb_reminder_srv.HbList)localObject1).uin.get();
        ((birthday_hb_reminder_srv.HbList)localObject1).name.get();
        str = ((birthday_hb_reminder_srv.HbList)localObject1).birthdate.get();
        ((birthday_hb_reminder_srv.HbList)localObject1).arrival_time.get();
        ((birthday_hb_reminder_srv.HbList)localObject1).create_time.get();
        ((birthday_hb_reminder_srv.HbList)localObject1).modify_time.get();
        if (i == 2) {
          ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putBoolean(this.a.getCurrentUin(), (String)localObject2, str, true);
        }
        paramInt += 1;
      }
      else
      {
        label428:
        label429:
        while (paramInt != 1) {
          return;
        }
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.6
 * JD-Core Version:    0.7.0.1
 */