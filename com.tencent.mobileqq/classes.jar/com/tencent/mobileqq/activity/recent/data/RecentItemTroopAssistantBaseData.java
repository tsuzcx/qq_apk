package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantDataStub;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color;
import com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string;
import com.tencent.mobileqq.imcore.proxy.msg.QQTextProxy;
import com.tencent.mobileqq.imcore.proxy.troop.TroopAssistantManagerProxy;
import com.tencent.mobileqq.imcore.proxy.utils.ContactUtilsProxy;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;

public class RecentItemTroopAssistantBaseData
  extends RecentUserBaseData
{
  public static final String TAG = "RecentItemTroopAssistant";
  
  public RecentItemTroopAssistantBaseData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 0;
  }
  
  private void a(Context paramContext, MsgSummary paramMsgSummary)
  {
    if ((TextUtils.isEmpty(paramMsgSummary.strContent)) && (TextUtils.isEmpty(paramMsgSummary.suffix)))
    {
      paramMsgSummary.strPrefix = null;
      paramMsgSummary.strContent = paramContext.getString(IMCoreResourceRoute.Resource.string.b);
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, IMCoreMessageStub paramIMCoreMessageStub)
  {
    if (paramIMCoreMessageStub != null)
    {
      this.mUnreadNum = TroopAssistantManagerProxy.a(paramBaseQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("RecentItemTroopAssistant", 2, "mUnreadNum :" + this.mUnreadNum);
      }
      this.mDisplayTime = paramIMCoreMessageStub.getTime();
      buildMessageBody(paramIMCoreMessageStub, 1, paramBaseQQAppInterface, paramContext, this.msgSummary);
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
      }
      return;
    }
    this.mUnreadNum = 0;
    this.mDisplayTime = 0L;
  }
  
  public void a(Context paramContext)
  {
    if (this.mUnreadNum > 0)
    {
      this.mMsgExtroInfo = String.format(paramContext.getString(IMCoreResourceRoute.Resource.string.a), new Object[] { Integer.valueOf(this.mUnreadNum) });
      this.mExtraInfoColor = paramContext.getResources().getColor(IMCoreResourceRoute.Resource.color.b);
      return;
    }
    this.mMsgExtroInfo = "";
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, IMCoreMessageStub paramIMCoreMessageStub, MsgSummary paramMsgSummary) {}
  
  public final void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    Object localObject1 = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
    if ((localObject1 == null) || (!(((IMessageFacade)localObject1).getQQMessageFacadeStub() instanceof QQMessageFacadeStub))) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject2 = (QQMessageFacadeStub)((IMessageFacade)localObject1).getQQMessageFacadeStub();
          } while (localObject2 == null);
          localObject1 = TroopAssistantManagerProxy.a(paramBaseQQAppInterface);
        } while ((localObject1 == null) || (TextUtils.isEmpty(((TroopAssistantDataStub)localObject1).getTroopUin())) || (this.mDisplayTime >= ((TroopAssistantDataStub)localObject1).getLastdrafttime()));
        localObject2 = ((QQMessageFacadeStub)localObject2).getDraftSummaryInfo(((TroopAssistantDataStub)localObject1).getTroopUin(), 1);
      } while ((localObject2 == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject2).getSummary())));
      this.mDisplayTime = ((DraftSummaryInfo)localObject2).getTime();
      localObject2 = ((DraftSummaryInfo)localObject2).getSummary();
      paramBaseQQAppInterface = ContactUtilsProxy.b(paramBaseQQAppInterface, ((TroopAssistantDataStub)localObject1).getTroopUin(), true);
    } while (paramMsgSummary == null);
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = QQTextProxy.a(paramBaseQQAppInterface + ": " + (String)localObject2, 3, 16);
  }
  
  public final void dealStatus(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.mStatus = 0;
    TroopAssistantDataStub localTroopAssistantDataStub = TroopAssistantManagerProxy.a(paramBaseQQAppInterface);
    if ((localTroopAssistantDataStub == null) || (TextUtils.isEmpty(localTroopAssistantDataStub.getTroopUin()))) {}
    do
    {
      do
      {
        return;
        paramBaseQQAppInterface = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      } while ((paramBaseQQAppInterface == null) || (!(paramBaseQQAppInterface.getQQMessageFacadeStub() instanceof QQMessageFacadeStub)));
      paramBaseQQAppInterface = (QQMessageFacadeStub)paramBaseQQAppInterface.getQQMessageFacadeStub();
    } while (paramBaseQQAppInterface == null);
    paramBaseQQAppInterface = paramBaseQQAppInterface.getDraftSummaryInfo(localTroopAssistantDataStub.getTroopUin(), 1);
    if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramBaseQQAppInterface.getSummary())))
    {
      this.mStatus = 4;
      return;
    }
    this.mStatus = 0;
  }
  
  public void extraUpdate(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    a(paramContext, paramMsgSummary);
    dealStatus(paramBaseQQAppInterface);
    dealDraft(paramBaseQQAppInterface, paramMsgSummary);
    super.extraUpdate(paramBaseQQAppInterface, paramContext, paramMsgSummary);
    if (this.mUnreadNum > 0) {
      this.mLastMsg = "";
    }
  }
  
  public final void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface == null) || (paramContext == null)) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(IMCoreResourceRoute.Resource.string.c);
      }
      localObject = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
    } while ((localObject == null) || (!(((IMessageFacade)localObject).getQQMessageFacadeStub() instanceof QQMessageFacadeStub)));
    Object localObject = (QQMessageFacadeStub)((IMessageFacade)localObject).getQQMessageFacadeStub();
    TroopAssistantDataStub localTroopAssistantDataStub;
    if (localObject != null)
    {
      localTroopAssistantDataStub = TroopAssistantManagerProxy.a(paramBaseQQAppInterface);
      if (localTroopAssistantDataStub == null) {}
    }
    for (localObject = ((QQMessageFacadeStub)localObject).getLastMessage(localTroopAssistantDataStub.getTroopUin(), 1);; localObject = null)
    {
      this.msgSummary = getMsgSummaryTemp();
      a(paramBaseQQAppInterface, paramContext, (IMCoreMessageStub)localObject);
      super.update(paramBaseQQAppInterface, paramContext);
      a(paramBaseQQAppInterface, paramContext, (IMCoreMessageStub)localObject, this.msgSummary);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistantBaseData
 * JD-Core Version:    0.7.0.1
 */