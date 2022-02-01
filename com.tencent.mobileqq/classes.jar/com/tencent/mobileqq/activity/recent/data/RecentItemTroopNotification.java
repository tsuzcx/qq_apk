package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class RecentItemTroopNotification
  extends AbsRecentUserBusinessBaseData
{
  private static final String TAG = "RecentItemTroopNotification";
  public boolean unDealMsgCountNumFlag = false;
  
  public RecentItemTroopNotification(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  @Nullable
  private structmsg.StructMsg a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        Object localObject = (MessageRecord)paramList.get(i);
        if ((localObject instanceof MessageForSystemMsg))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localObject).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg.has()))
          {
            structmsg.SystemMsg localSystemMsg = localStructMsg.msg;
            if (localSystemMsg.msg_invite_extinfo.has()) {
              localObject = (structmsg.MsgInviteExt)localSystemMsg.msg_invite_extinfo.get();
            } else {
              localObject = null;
            }
            int j = localSystemMsg.group_msg_type.get();
            if ((j != 13) && (j != 6) && ((localObject == null) || (((structmsg.MsgInviteExt)localObject).uint32_wait_state.get() != 4))) {
              return localStructMsg;
            }
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(2131888047);
      }
      this.mUnreadNum = TroopNotificationUtils.a(paramQQAppInterface);
      String str = GroupSystemMsgController.a().a(paramQQAppInterface);
      structmsg.StructMsg localStructMsg = GroupSystemMsgController.a().e();
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().h(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = a(paramQQAppInterface);
        if (paramQQAppInterface == null)
        {
          QLog.d("RecentItemTroopNotification", 1, "cannot found recent notification from cache");
          paramQQAppInterface = localStructMsg;
        }
      }
      else
      {
        paramQQAppInterface = localStructMsg;
        if (QLog.isColorLevel())
        {
          QLog.d("RecentItemTroopNotification", 2, "notificationList is null");
          paramQQAppInterface = localStructMsg;
        }
      }
      if (paramQQAppInterface != null) {
        this.mDisplayTime = paramQQAppInterface.msg_time.get();
      } else {
        QLog.d("RecentItemTroopNotification", 1, "cannot get recent notification info");
      }
      if (((this.mLastMsg == null) || (!this.mLastMsg.equals(str))) && (!TextUtils.isEmpty(str))) {
        this.mLastMsg = str;
      }
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
      }
      int i;
      if (this.mUnreadNum == 0)
      {
        i = TroopNotifyHelper.g();
        this.unDealMsgCountNumFlag = TroopNotifyHelper.a(i);
      }
      else
      {
        this.unDealMsgCountNumFlag = false;
        i = 0;
      }
      if (this.unDealMsgCountNumFlag)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B52C", "0X800B52C", 0, 0, "", "", null, null);
        long l = System.currentTimeMillis();
        this.mUnreadNum = i;
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(paramContext.getString(2131917599));
        paramQQAppInterface.append(String.valueOf(this.mUnreadNum));
        paramQQAppInterface.append(paramContext.getString(2131917600));
        this.mLastMsg = paramQQAppInterface.toString();
        TroopNotifyHelper.a(true);
        i = TroopNotifyHelper.a() + 1;
        TroopNotifyHelper.b(i);
        int j = TroopNotifyHelper.c() + 1;
        TroopNotifyHelper.c(j);
        TroopNotifyHelper.b(System.currentTimeMillis());
        if (QLog.isColorLevel())
        {
          QLog.d("RecentItemTroopNotification", 2, new Object[] { "unDealMsgCountNunFlag", "oneWeekCount =", Integer.valueOf(i), "oneDayCount =", Integer.valueOf(j), "mUnreadNum =", Integer.valueOf(this.mUnreadNum) });
          QLog.d("RecentItemTroopNotification", 2, new Object[] { "unDealMsgCountNunFlag cost=", Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      else
      {
        TroopNotifyHelper.a(false);
      }
      this.mUser.jumpTabMode = 1;
      if (AppSetting.e)
      {
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.mTitleName);
        if (this.mUnreadNum == 1)
        {
          paramQQAppInterface.append("有一条未读");
        }
        else if (this.mUnreadNum == 2)
        {
          paramQQAppInterface.append("有两条未读");
        }
        else if (this.mUnreadNum > 0)
        {
          paramQQAppInterface.append("有");
          paramQQAppInterface.append(this.mUnreadNum);
          paramQQAppInterface.append("条未读");
        }
        if (this.mMsgExtroInfo != null)
        {
          paramQQAppInterface.append(this.mMsgExtroInfo);
          paramQQAppInterface.append(",");
        }
        paramQQAppInterface.append(this.mLastMsg);
        paramQQAppInterface.append(',');
        paramQQAppInterface.append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification
 * JD-Core Version:    0.7.0.1
 */