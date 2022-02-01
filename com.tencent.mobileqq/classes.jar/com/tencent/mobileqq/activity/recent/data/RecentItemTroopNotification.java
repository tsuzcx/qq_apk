package com.tencent.mobileqq.activity.recent.data;

import aiku;
import ailu;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import bcef;
import bcsz;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class RecentItemTroopNotification
  extends AbsRecentUserBusinessBaseData
{
  private static final String TAG = "RecentItemTroopNotification";
  public boolean unDealMsgCountNumFlag;
  
  public RecentItemTroopNotification(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  @Nullable
  private structmsg.StructMsg a(List<MessageRecord> paramList)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    structmsg.StructMsg localStructMsg;
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = (MessageRecord)paramList.get(i);
        if ((localObject1 instanceof MessageForSystemMsg))
        {
          localStructMsg = ((MessageForSystemMsg)localObject1).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg.has()))
          {
            structmsg.SystemMsg localSystemMsg = localStructMsg.msg;
            if (!localSystemMsg.msg_invite_extinfo.has()) {
              break label133;
            }
            localObject1 = (structmsg.MsgInviteExt)localSystemMsg.msg_invite_extinfo.get();
            label105:
            int j = localSystemMsg.group_msg_type.get();
            if ((j != 13) && (j != 6)) {
              break label139;
            }
          }
        }
        label133:
        label139:
        do
        {
          i -= 1;
          break;
          localObject1 = null;
          break label105;
          if (localObject1 == null) {
            break label163;
          }
        } while (((structmsg.MsgInviteExt)localObject1).uint32_wait_state.get() == 4);
        localObject1 = localStructMsg;
      }
    }
    return localObject1;
    label163:
    return localStructMsg;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    structmsg.StructMsg localStructMsg;
    label101:
    int i;
    label191:
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(2131690989);
      }
      this.mUnreadNum = aiku.a(paramQQAppInterface);
      String str = bcsz.a().a(paramQQAppInterface);
      localStructMsg = bcsz.a().a();
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().getMsgList(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
      if (paramQQAppInterface == null) {
        break label511;
      }
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface == null) {
        break;
      }
      if (paramQQAppInterface == null) {
        break label535;
      }
      this.mDisplayTime = paramQQAppInterface.msg_time.get();
      if (((this.mLastMsg == null) || (!this.mLastMsg.equals(str))) && (!TextUtils.isEmpty(str))) {
        this.mLastMsg = str;
      }
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = TimeManager.getInstance().getMsgDisplayTime(getRecentUserUin(), this.mDisplayTime);
      }
      if (this.mUnreadNum != 0) {
        break label547;
      }
      i = ailu.c();
      this.unDealMsgCountNumFlag = ailu.a(i);
      if (!this.unDealMsgCountNumFlag) {
        break label557;
      }
      bcef.b(null, "dc00898", "", "", "0X800B52C", "0X800B52C", 0, 0, "", "", null, null);
      long l = System.currentTimeMillis();
      this.mUnreadNum = i;
      this.mLastMsg = (paramContext.getString(2131719260) + String.valueOf(this.mUnreadNum) + paramContext.getString(2131719261));
      ailu.a(true);
      i = ailu.a() + 1;
      ailu.a(i);
      int j = ailu.b() + 1;
      ailu.b(j);
      ailu.b(System.currentTimeMillis());
      if (QLog.isColorLevel())
      {
        QLog.d("RecentItemTroopNotification", 2, new Object[] { "unDealMsgCountNunFlag", "oneWeekCount =", Integer.valueOf(i), "oneDayCount =", Integer.valueOf(j), "mUnreadNum =", Integer.valueOf(this.mUnreadNum) });
        QLog.d("RecentItemTroopNotification", 2, new Object[] { "unDealMsgCountNunFlag cost=", Long.valueOf(System.currentTimeMillis() - l) });
      }
      this.mUser.jumpTabMode = 1;
    } while (!AppSetting.c);
    label395:
    paramQQAppInterface = new StringBuilder(24);
    paramQQAppInterface.append(this.mTitleName);
    if (this.mUnreadNum == 1) {
      paramQQAppInterface.append("有一条未读");
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        paramQQAppInterface.append(this.mMsgExtroInfo).append(",");
      }
      paramQQAppInterface.append(this.mLastMsg).append(',').append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
      return;
      QLog.d("RecentItemTroopNotification", 1, "cannot found recent notification from cache");
      paramQQAppInterface = localStructMsg;
      break;
      label511:
      paramQQAppInterface = localStructMsg;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecentItemTroopNotification", 2, "notificationList is null");
      paramQQAppInterface = localStructMsg;
      break;
      label535:
      QLog.d("RecentItemTroopNotification", 1, "cannot get recent notification info");
      break label101;
      label547:
      this.unDealMsgCountNumFlag = false;
      i = 0;
      break label191;
      label557:
      ailu.a(false);
      break label395;
      if (this.mUnreadNum == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification
 * JD-Core Version:    0.7.0.1
 */