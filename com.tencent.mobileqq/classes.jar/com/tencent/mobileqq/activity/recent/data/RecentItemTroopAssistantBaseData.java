package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.TroopAssistantDataStub;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color;
import com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ContactUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.QQTextProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.TroopAssistantManagerProxy;
import com.tencent.qphone.base.util.QLog;

public class RecentItemTroopAssistantBaseData
  extends RecentUserBaseData
{
  public static final String TAG = "RecentItemTroopAssistant";
  
  public RecentItemTroopAssistantBaseData(BaseRecentUser paramBaseRecentUser)
  {
    super(paramBaseRecentUser);
    this.mUnreadFlag = 0;
  }
  
  private void processEmptyContent(Context paramContext, MsgSummary paramMsgSummary)
  {
    if ((TextUtils.isEmpty(paramMsgSummary.strContent)) && (TextUtils.isEmpty(paramMsgSummary.suffix)))
    {
      paramMsgSummary.strPrefix = null;
      paramMsgSummary.strContent = paramContext.getString(IMCoreResourceRoute.Resource.string.troop_assistant_detail);
    }
  }
  
  private void processUnreadNumInner(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, IMCoreMessageStub paramIMCoreMessageStub)
  {
    if (paramIMCoreMessageStub != null)
    {
      this.mUnreadNum = RecentRoute.TroopAssistantManagerProxy.getTroopAssistantUnreadNum(paramIMCoreAppRuntime);
      if (QLog.isColorLevel()) {
        QLog.i("RecentItemTroopAssistant", 2, "mUnreadNum :" + this.mUnreadNum);
      }
      this.mDisplayTime = paramIMCoreMessageStub.getTime();
      buildMessageBody(paramIMCoreMessageStub, 1, paramIMCoreAppRuntime, paramContext, this.msgSummary);
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = TimeManager.getInstance().getMsgDisplayTime(getRecentUserUin(), this.mDisplayTime);
      }
      return;
    }
    this.mUnreadNum = 0;
    this.mDisplayTime = 0L;
  }
  
  public final void dealDraft(IMCoreAppRuntime paramIMCoreAppRuntime, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    Object localObject = paramIMCoreAppRuntime.getMessageFacade();
    if (localObject == null) {}
    TroopAssistantDataStub localTroopAssistantDataStub;
    do
    {
      do
      {
        return;
        localTroopAssistantDataStub = RecentRoute.TroopAssistantManagerProxy.getFirstData(paramIMCoreAppRuntime);
      } while ((localTroopAssistantDataStub == null) || (TextUtils.isEmpty(localTroopAssistantDataStub.getTroopUin())) || (this.mDisplayTime >= localTroopAssistantDataStub.getLastdrafttime()));
      localObject = ((QQMessageFacadeStub)localObject).getDraftSummaryInfo(localTroopAssistantDataStub.getTroopUin(), 1);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.bShowDraft = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramIMCoreAppRuntime = RecentRoute.ContactUtilsProxy.getTroopName(paramIMCoreAppRuntime, localTroopAssistantDataStub.getTroopUin(), true);
    paramMsgSummary.mDraft = RecentRoute.QQTextProxy.generalQQText(paramIMCoreAppRuntime + ": " + (String)localObject, 3, 16);
  }
  
  public void dealMsgAttention(Context paramContext)
  {
    if (this.mUnreadNum > 0)
    {
      this.mMsgExtroInfo = String.format(paramContext.getString(IMCoreResourceRoute.Resource.string.troop_assistant_num_unreadmsg), new Object[] { Integer.valueOf(this.mUnreadNum) });
      this.mExtraInfoColor = paramContext.getResources().getColor(IMCoreResourceRoute.Resource.color.skin_gray2_theme_version2);
      return;
    }
    this.mMsgExtroInfo = "";
  }
  
  public final void dealStatus(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    this.mStatus = 0;
    TroopAssistantDataStub localTroopAssistantDataStub = RecentRoute.TroopAssistantManagerProxy.getFirstData(paramIMCoreAppRuntime);
    if ((localTroopAssistantDataStub == null) || (TextUtils.isEmpty(localTroopAssistantDataStub.getTroopUin()))) {}
    do
    {
      return;
      paramIMCoreAppRuntime = paramIMCoreAppRuntime.getMessageFacade();
    } while (paramIMCoreAppRuntime == null);
    paramIMCoreAppRuntime = paramIMCoreAppRuntime.getDraftSummaryInfo(localTroopAssistantDataStub.getTroopUin(), 1);
    if ((paramIMCoreAppRuntime != null) && (!TextUtils.isEmpty(paramIMCoreAppRuntime.getSummary())))
    {
      this.mStatus = 4;
      return;
    }
    this.mStatus = 0;
  }
  
  public void extraUpdate(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, MsgSummary paramMsgSummary)
  {
    processEmptyContent(paramContext, paramMsgSummary);
    dealStatus(paramIMCoreAppRuntime);
    dealDraft(paramIMCoreAppRuntime, paramMsgSummary);
    super.extraUpdate(paramIMCoreAppRuntime, paramContext, paramMsgSummary);
    if (this.mUnreadNum > 0) {
      this.mLastMsg = "";
    }
  }
  
  public final void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime == null) || (paramContext == null)) {
      return;
    }
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = paramContext.getString(IMCoreResourceRoute.Resource.string.troop_assistant);
    }
    Object localObject2 = null;
    QQMessageFacadeStub localQQMessageFacadeStub = paramIMCoreAppRuntime.getMessageFacade();
    Object localObject1 = localObject2;
    if (localQQMessageFacadeStub != null)
    {
      TroopAssistantDataStub localTroopAssistantDataStub = RecentRoute.TroopAssistantManagerProxy.getFirstData(paramIMCoreAppRuntime);
      localObject1 = localObject2;
      if (localTroopAssistantDataStub != null) {
        localObject1 = localQQMessageFacadeStub.getLastMessage(localTroopAssistantDataStub.getTroopUin(), 1);
      }
    }
    this.msgSummary = getMsgSummaryTemp();
    processUnreadNumInner(paramIMCoreAppRuntime, paramContext, (IMCoreMessageStub)localObject1);
    super.update(paramIMCoreAppRuntime, paramContext);
    update(paramIMCoreAppRuntime, paramContext, (IMCoreMessageStub)localObject1, this.msgSummary);
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, IMCoreMessageStub paramIMCoreMessageStub, MsgSummary paramMsgSummary) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistantBaseData
 * JD-Core Version:    0.7.0.1
 */