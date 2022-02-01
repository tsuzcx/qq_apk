package com.tencent.mobileqq.activity.recent.data;

import ajeq;
import ajfo;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import anhk;
import bdgn;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.TimeManager;
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
  public boolean unDealMsgCountNunFlag;
  
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
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = paramContext.getString(2131690949);
    }
    this.mUnreadNum = ajeq.a(paramQQAppInterface);
    String str = bdgn.a().a(paramQQAppInterface);
    structmsg.StructMsg localStructMsg = bdgn.a().a();
    paramQQAppInterface = paramQQAppInterface.a().b(anhk.N, 0);
    label101:
    int i;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface == null) {
          break label514;
        }
        this.mDisplayTime = paramQQAppInterface.msg_time.get();
        if (((this.mLastMsg == null) || (!this.mLastMsg.equals(str))) && (!TextUtils.isEmpty(str))) {
          this.mLastMsg = str;
        }
        if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
          this.mShowTime = TimeManager.getInstance().getMsgDisplayTime(getRecentUserUin(), this.mDisplayTime);
        }
        if (this.mUnreadNum != 0) {
          break label576;
        }
        i = ajfo.c();
        this.unDealMsgCountNunFlag = ajfo.a(ajfo.c());
      }
    }
    for (;;)
    {
      if (this.unDealMsgCountNunFlag)
      {
        long l = System.currentTimeMillis();
        this.mUnreadNum = i;
        this.mLastMsg = (paramContext.getString(2131718844) + String.valueOf(this.mUnreadNum) + paramContext.getString(2131718845));
        ajfo.a(true);
        i = ajfo.a() + 1;
        ajfo.a(i);
        int j = ajfo.b() + 1;
        ajfo.b(j);
        ajfo.b(System.currentTimeMillis());
        if (QLog.isColorLevel())
        {
          QLog.d("RecentItemTroopNotification", 2, new Object[] { "unDealMsgCountNunFlag", "oneWeekCount =", Integer.valueOf(i), "oneDayCount =", Integer.valueOf(j), "mUnreadNum =", Integer.valueOf(this.mUnreadNum) });
          QLog.d("RecentItemTroopNotification", 2, new Object[] { "unDealMsgCountNunFlag cost=", Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      this.mUser.jumpTabMode = 1;
      if (!AppSetting.c) {
        break;
      }
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
        paramQQAppInterface = localStructMsg;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RecentItemTroopNotification", 2, "notificationList is null");
        paramQQAppInterface = localStructMsg;
        break;
        label514:
        QLog.d("RecentItemTroopNotification", 1, "cannot get recent notification info");
        break label101;
        if (this.mUnreadNum == 2) {
          paramQQAppInterface.append("有两条未读");
        } else if (this.mUnreadNum > 0) {
          paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
        }
      }
      label576:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification
 * JD-Core Version:    0.7.0.1
 */