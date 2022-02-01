package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfoStub;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
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
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (this.mTitleName = ContactUtilsProxy.b(paramBaseQQAppInterface, this.mUser.uin, true);; this.mTitleName = ((String)localObject))
    {
      if ((paramTroopInfo == null) || (paramTroopInfo.hasSetTroopName()) || (paramTroopInfo.getMemberNumClient() <= 0)) {
        break label218;
      }
      this.mExtraInfo = ("(" + paramTroopInfo.getMemberNumClient() + ")");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecentItemTroopMsgData", 2, "update wMemberNumClient:" + paramTroopInfo.getMemberNumClient() + "  wMemberNum:" + paramTroopInfo.getMemberNum() + " troopUin:" + paramTroopInfo.getTroopUin());
      return;
    }
    label218:
    this.mExtraInfo = "";
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, IMCoreMessageStub paramIMCoreMessageStub)
  {
    if (paramIMCoreMessageStub != null)
    {
      this.mDisplayTime = paramIMCoreMessageStub.getTime();
      if (this.mDisplayTime == 0L) {
        this.mDisplayTime = this.mUser.opTime;
      }
      this.mUnreadNum = ConversationFacadeProxy.a(paramIMCoreMessageStub, this.mUser.getType(), paramBaseQQAppInterface);
      return;
    }
    this.mDisplayTime = this.mUser.opTime;
    this.mUnreadNum = 0;
  }
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, IMCoreMessageStub paramIMCoreMessageStub, TroopInfo paramTroopInfo, MsgSummary paramMsgSummary)
  {
    buildMessageBody(paramIMCoreMessageStub, this.mUser.getType(), paramBaseQQAppInterface, paramContext, paramMsgSummary);
  }
  
  public final void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    super.dealDraft(paramBaseQQAppInterface, paramMsgSummary);
    if (paramMsgSummary == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramMsgSummary.bShowDraft = false;
            paramMsgSummary.mDraft = null;
          } while (this.mDisplayTime > getLastDraftTime());
          paramBaseQQAppInterface = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
        } while ((paramBaseQQAppInterface == null) || (!(paramBaseQQAppInterface.getQQMessageFacadeStub() instanceof QQMessageFacadeStub)));
        paramBaseQQAppInterface = (QQMessageFacadeStub)paramBaseQQAppInterface.getQQMessageFacadeStub();
      } while (paramBaseQQAppInterface == null);
      paramBaseQQAppInterface = paramBaseQQAppInterface.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
    } while ((paramBaseQQAppInterface == null) || (TextUtils.isEmpty(paramBaseQQAppInterface.getSummary())));
    this.mDisplayTime = paramBaseQQAppInterface.getTime();
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = ColorNickManagerProxy.a(paramBaseQQAppInterface.getSummary(), paramBaseQQAppInterface.getAtInfoStr());
  }
  
  public final void dealStatus(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super.dealStatus(paramBaseQQAppInterface);
  }
  
  public void extraUpdate(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    dealStatus(paramBaseQQAppInterface);
    dealDraft(paramBaseQQAppInterface, paramMsgSummary);
    b();
    super.extraUpdate(paramBaseQQAppInterface, paramContext, paramMsgSummary);
  }
  
  public final void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface == null) || (paramContext == null)) {}
    do
    {
      return;
      super.update(paramBaseQQAppInterface, paramContext);
      localObject1 = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
    } while ((localObject1 == null) || (!(((IMessageFacade)localObject1).getQQMessageFacadeStub() instanceof QQMessageFacadeStub)));
    Object localObject2 = (QQMessageFacadeStub)((IMessageFacade)localObject1).getQQMessageFacadeStub();
    Object localObject1 = null;
    TroopInfo localTroopInfo = TroopManagerProxy.a(paramBaseQQAppInterface, this.mUser.uin);
    if (localObject2 != null) {
      localObject1 = ((QQMessageFacadeStub)localObject2).getLastMessage(this.mUser.uin, this.mUser.getType());
    }
    localObject2 = new MsgSummary();
    a(paramBaseQQAppInterface, (IMCoreMessageStub)localObject1);
    a(paramBaseQQAppInterface, localTroopInfo);
    TimeManager.a().a(this.mUser.uin, this.mDisplayTime);
    a(paramBaseQQAppInterface, paramContext, (IMCoreMessageStub)localObject1, localTroopInfo, (MsgSummary)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgBaseData
 * JD-Core Version:    0.7.0.1
 */