package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfoStub;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.business.ColorNickManagerProxy;
import com.tencent.mobileqq.imcore.proxy.business.HotChatManagerProxy;
import com.tencent.mobileqq.imcore.proxy.msg.ConversationFacadeProxy;
import com.tencent.mobileqq.imcore.proxy.troop.TroopManagerProxy;
import com.tencent.mobileqq.imcore.proxy.utils.ContactUtilsProxy;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;

public class RecentItemTroopMsgBaseData
  extends RecentUserBaseData
{
  protected static final String IS_HOT_CHAT = "IS_HOT_CHAT";
  private static final String TAG = "RecentItemTroopMsgData";
  
  public RecentItemTroopMsgBaseData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    if (paramMessage != null)
    {
      this.mDisplayTime = paramMessage.getTime();
      if (this.mDisplayTime == 0L) {
        this.mDisplayTime = this.mUser.opTime;
      }
      this.mUnreadNum = ConversationFacadeProxy.a(paramMessage, this.mUser.getType(), paramBaseQQAppInterface);
      return;
    }
    this.mDisplayTime = this.mUser.opTime;
    this.mUnreadNum = 0;
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, TroopInfo paramTroopInfo)
  {
    Object localObject = HotChatManagerProxy.a(paramBaseQQAppInterface, this.mUser.uin);
    if (localObject != null)
    {
      this.mArgsBundle.putBoolean("IS_HOT_CHAT", true);
      this.mUnreadFlag = 3;
      this.mTitleName = ((HotChatInfoStub)localObject).getName();
      return;
    }
    this.mArgsBundle.putBoolean("IS_HOT_CHAT", false);
    this.mMenuFlag = (this.mMenuFlag & 0xFFFFF0FF | 0x100);
    localObject = null;
    if (paramTroopInfo != null) {
      localObject = paramTroopInfo.getTroopDisplayName();
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      this.mTitleName = ContactUtilsProxy.b(paramBaseQQAppInterface, this.mUser.uin, true);
    } else {
      this.mTitleName = ((String)localObject);
    }
    if ((paramTroopInfo != null) && (!paramTroopInfo.hasSetTroopName()) && (paramTroopInfo.getMemberNumClient() > 0))
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("(");
      paramBaseQQAppInterface.append(paramTroopInfo.getMemberNumClient());
      paramBaseQQAppInterface.append(")");
      this.mExtraInfo = paramBaseQQAppInterface.toString();
      if (QLog.isColorLevel())
      {
        paramBaseQQAppInterface = new StringBuilder();
        paramBaseQQAppInterface.append("update wMemberNumClient:");
        paramBaseQQAppInterface.append(paramTroopInfo.getMemberNumClient());
        paramBaseQQAppInterface.append("  wMemberNum:");
        paramBaseQQAppInterface.append(paramTroopInfo.getMemberNum());
        paramBaseQQAppInterface.append(" troopUin:");
        paramBaseQQAppInterface.append(paramTroopInfo.getTroopUin());
        QLog.d("RecentItemTroopMsgData", 2, paramBaseQQAppInterface.toString());
      }
    }
    else
    {
      this.mExtraInfo = "";
    }
  }
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Message paramMessage, TroopInfo paramTroopInfo, MsgSummary paramMsgSummary)
  {
    buildMessageBody(paramMessage, this.mUser.getType(), paramBaseQQAppInterface, paramContext, paramMsgSummary);
  }
  
  public final void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    super.dealDraft(paramBaseQQAppInterface, paramMsgSummary);
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.bShowDraft = false;
    paramMsgSummary.mDraft = null;
    if (this.mDisplayTime > getLastDraftTime()) {
      return;
    }
    paramBaseQQAppInterface = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
    if (paramBaseQQAppInterface != null)
    {
      if (!(paramBaseQQAppInterface.getQQMessageFacadeStub() instanceof QQMessageFacadeStub)) {
        return;
      }
      paramBaseQQAppInterface = (QQMessageFacadeStub)paramBaseQQAppInterface.getQQMessageFacadeStub();
      if (paramBaseQQAppInterface == null) {
        return;
      }
      paramBaseQQAppInterface = paramBaseQQAppInterface.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
      if (paramBaseQQAppInterface != null)
      {
        if (TextUtils.isEmpty(paramBaseQQAppInterface.getSummary())) {
          return;
        }
        this.mDisplayTime = paramBaseQQAppInterface.getTime();
        paramMsgSummary.bShowDraft = true;
        paramMsgSummary.mDraft = ColorNickManagerProxy.a(paramBaseQQAppInterface.getSummary(), paramBaseQQAppInterface.getAtInfoStr());
      }
    }
  }
  
  public final void dealStatus(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super.dealStatus(paramBaseQQAppInterface);
  }
  
  protected void extraUpdate(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    dealStatus(paramBaseQQAppInterface);
    dealDraft(paramBaseQQAppInterface, paramMsgSummary);
    d();
    super.extraUpdate(paramBaseQQAppInterface, paramContext, paramMsgSummary);
  }
  
  public final void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.update(paramBaseQQAppInterface, paramContext);
      Object localObject1 = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (localObject1 != null)
      {
        if (!(((IMessageFacade)localObject1).getQQMessageFacadeStub() instanceof QQMessageFacadeStub)) {
          return;
        }
        Object localObject2 = (QQMessageFacadeStub)((IMessageFacade)localObject1).getQQMessageFacadeStub();
        localObject1 = null;
        TroopInfo localTroopInfo = TroopManagerProxy.a(paramBaseQQAppInterface, this.mUser.uin);
        if (localObject2 != null) {
          localObject1 = ((QQMessageFacadeStub)localObject2).getLastMessage(this.mUser.uin, this.mUser.getType());
        }
        localObject2 = new MsgSummary();
        a(paramBaseQQAppInterface, (Message)localObject1);
        a(paramBaseQQAppInterface, localTroopInfo);
        TimeManager.a().a(this.mUser.uin, this.mDisplayTime);
        a(paramBaseQQAppInterface, paramContext, (Message)localObject1, localTroopInfo, (MsgSummary)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgBaseData
 * JD-Core Version:    0.7.0.1
 */