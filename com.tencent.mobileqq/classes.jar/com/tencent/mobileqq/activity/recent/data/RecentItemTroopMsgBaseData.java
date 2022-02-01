package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfoStub;
import com.tencent.mobileqq.data.TroopInfoStub;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ColorNickManagerProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ContactUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ConversationFacadeProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.HotChatManagerProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.TroopManagerProxy;
import com.tencent.qphone.base.util.QLog;

public class RecentItemTroopMsgBaseData
  extends RecentUserBaseData
{
  protected static final String IS_HOT_CHAT = "IS_HOT_CHAT";
  private static final String TAG = "RecentItemTroopMsgData";
  
  public RecentItemTroopMsgBaseData(BaseRecentUser paramBaseRecentUser)
  {
    super(paramBaseRecentUser);
  }
  
  private void processTroopTimeAndUnreadNumInner(IMCoreAppRuntime paramIMCoreAppRuntime, IMCoreMessageStub paramIMCoreMessageStub)
  {
    if (paramIMCoreMessageStub != null)
    {
      this.mDisplayTime = paramIMCoreMessageStub.getTime();
      if (this.mDisplayTime == 0L) {
        this.mDisplayTime = this.mUser.opTime;
      }
      this.mUnreadNum = RecentRoute.ConversationFacadeProxy.getUnreadCount(paramIMCoreMessageStub, this.mUser.getType(), paramIMCoreAppRuntime);
      return;
    }
    this.mDisplayTime = this.mUser.opTime;
    this.mUnreadNum = 0;
  }
  
  private void processTroopTitleNameAndMenuFlagInner(IMCoreAppRuntime paramIMCoreAppRuntime, TroopInfoStub paramTroopInfoStub)
  {
    Object localObject = RecentRoute.HotChatManagerProxy.getHotCatInfo(paramIMCoreAppRuntime, this.mUser.uin);
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
    if (paramTroopInfoStub != null) {
      localObject = paramTroopInfoStub.getTroopName();
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (this.mTitleName = RecentRoute.ContactUtilsProxy.getTroopName(paramIMCoreAppRuntime, this.mUser.uin, true);; this.mTitleName = ((String)localObject))
    {
      if ((paramTroopInfoStub == null) || (paramTroopInfoStub.hasSetTroopName()) || (paramTroopInfoStub.getMemberNumClient() <= 0)) {
        break label232;
      }
      this.mExtraInfo = ("(" + paramTroopInfoStub.getMemberNumClient() + ")");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecentItemTroopMsgData", 2, "update wMemberNumClient:" + paramTroopInfoStub.getMemberNumClient() + "  wMemberNum:" + paramTroopInfoStub.getMemberNum() + " troopUin:" + paramTroopInfoStub.getTroopUin());
      return;
    }
    label232:
    this.mExtraInfo = "";
  }
  
  public final void dealDraft(IMCoreAppRuntime paramIMCoreAppRuntime, MsgSummary paramMsgSummary)
  {
    super.dealDraft(paramIMCoreAppRuntime, paramMsgSummary);
    if (paramMsgSummary == null) {}
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
        paramIMCoreAppRuntime = paramIMCoreAppRuntime.getMessageFacade();
      } while (paramIMCoreAppRuntime == null);
      paramIMCoreAppRuntime = paramIMCoreAppRuntime.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
    } while ((paramIMCoreAppRuntime == null) || (TextUtils.isEmpty(paramIMCoreAppRuntime.getSummary())));
    this.mDisplayTime = paramIMCoreAppRuntime.getTime();
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = RecentRoute.ColorNickManagerProxy.transformMessageWithAtTroopMember(paramIMCoreAppRuntime.getSummary(), paramIMCoreAppRuntime.getAtInfoStr());
  }
  
  public final void dealStatus(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    super.dealStatus(paramIMCoreAppRuntime);
  }
  
  public void extraUpdate(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, MsgSummary paramMsgSummary)
  {
    dealStatus(paramIMCoreAppRuntime);
    dealDraft(paramIMCoreAppRuntime, paramMsgSummary);
    updateMsgUnreadStateMenu();
    super.extraUpdate(paramIMCoreAppRuntime, paramContext, paramMsgSummary);
  }
  
  public final void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime == null) || (paramContext == null)) {
      return;
    }
    super.update(paramIMCoreAppRuntime, paramContext);
    Object localObject = paramIMCoreAppRuntime.getMessageFacade();
    IMCoreMessageStub localIMCoreMessageStub = null;
    TroopInfoStub localTroopInfoStub = RecentRoute.TroopManagerProxy.getTroopInfo(paramIMCoreAppRuntime, this.mUser.uin);
    if (localObject != null) {
      localIMCoreMessageStub = ((QQMessageFacadeStub)localObject).getLastMessage(this.mUser.uin, this.mUser.getType());
    }
    localObject = new MsgSummary();
    processTroopTimeAndUnreadNumInner(paramIMCoreAppRuntime, localIMCoreMessageStub);
    processTroopTitleNameAndMenuFlagInner(paramIMCoreAppRuntime, localTroopInfoStub);
    TimeManager.getInstance().getMsgDisplayTime(this.mUser.uin, this.mDisplayTime);
    update(paramIMCoreAppRuntime, paramContext, localIMCoreMessageStub, localTroopInfoStub, (MsgSummary)localObject);
  }
  
  protected void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, IMCoreMessageStub paramIMCoreMessageStub, TroopInfoStub paramTroopInfoStub, MsgSummary paramMsgSummary)
  {
    buildMessageBody(paramIMCoreMessageStub, this.mUser.getType(), paramIMCoreAppRuntime, paramContext, paramMsgSummary);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgBaseData
 * JD-Core Version:    0.7.0.1
 */