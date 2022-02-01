package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class RewardNoticeActivity$3
  implements IApolloExtensionObserver
{
  RewardNoticeActivity$3(RewardNoticeActivity paramRewardNoticeActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Bundle)paramObject;
    long l = paramObject.getLong("pendantId");
    String str = paramObject.getString("uin");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePendantAuth isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" pendantId:");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(str);
      QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject).toString());
    }
    if (l != -1L)
    {
      if (str == null) {
        return;
      }
      if (paramBoolean)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject = localFriendsManager.x(str);
        paramObject = localObject;
        if (localObject == null)
        {
          paramObject = new ExtensionInfo();
          paramObject.uin = str;
        }
        paramObject.pendantId = l;
        paramObject.timestamp = System.currentTimeMillis();
        localFriendsManager.a(paramObject);
        if (!TextUtils.isEmpty(this.a.q)) {
          QQToast.makeText(this.a.app.getApp(), 2, this.a.q, 0).show();
        }
      }
      else
      {
        int i = paramObject.getInt("result");
        if (NetworkUtil.isNetSupport(this.a)) {
          paramObject = "4";
        } else {
          paramObject = "3";
        }
        if (i != 1004)
        {
          if (i != 6001) {
            if (i != 2001) {
              if (i == 2002) {}
            }
          }
          for (;;)
          {
            i = -1;
            break;
            i = 2131914349;
            paramObject = "1";
            break;
            i = 2131914348;
            paramObject = "0";
            break;
            paramObject = "2";
          }
        }
        i = 2131914347;
        if ((i != -1) && (QLog.isColorLevel()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handlePendantAuth error:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(paramObject);
          QLog.e("Q.BabyQ", 2, ((StringBuilder)localObject).toString());
        }
        QQToast.makeText(this.a.app.getApp(), 1, HardCodeUtil.a(2131910922), 0).show();
      }
      this.a.finish();
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RewardNoticeActivity.3
 * JD-Core Version:    0.7.0.1
 */