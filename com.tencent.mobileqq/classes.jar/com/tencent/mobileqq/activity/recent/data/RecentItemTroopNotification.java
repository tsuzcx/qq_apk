package com.tencent.mobileqq.activity.recent.data;

import afnu;
import ahpl;
import ajsf;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import aydb;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemTroopNotification";
  
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
            localObject = localStructMsg.msg;
            if (((structmsg.SystemMsg)localObject).msg_invite_extinfo.has()) {}
            for (localObject = (structmsg.MsgInviteExt)((structmsg.SystemMsg)localObject).msg_invite_extinfo.get(); localObject != null; localObject = null)
            {
              if (((structmsg.MsgInviteExt)localObject).uint32_wait_state.get() == 4) {
                break label113;
              }
              return localStructMsg;
            }
            return localStructMsg;
          }
        }
        label113:
        i -= 1;
      }
    }
    return null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label99:
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(2131691088);
      }
      this.mUnreadNum = afnu.a(paramQQAppInterface);
      String str = aydb.a().a(paramQQAppInterface);
      paramContext = aydb.a().a();
      paramQQAppInterface = paramQQAppInterface.a().b(ajsf.N, 0);
      if (paramQQAppInterface == null) {
        break label279;
      }
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface == null) {
        break;
      }
      if (paramQQAppInterface == null) {
        break label300;
      }
      this.mDisplayTime = paramQQAppInterface.msg_time.get();
      if (((this.mLastMsg == null) || (!this.mLastMsg.equals(str))) && (!TextUtils.isEmpty(str))) {
        this.mLastMsg = str;
      }
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = ahpl.a().a(a(), this.mDisplayTime);
      }
      this.mUser.jumpTabMode = 1;
    } while (!AppSetting.d);
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
      paramQQAppInterface = paramContext;
      break;
      label279:
      paramQQAppInterface = paramContext;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecentItemTroopNotification", 2, "notificationList is null");
      paramQQAppInterface = paramContext;
      break;
      label300:
      QLog.d("RecentItemTroopNotification", 1, "cannot get recent notification info");
      break label99;
      if (this.mUnreadNum == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification
 * JD-Core Version:    0.7.0.1
 */