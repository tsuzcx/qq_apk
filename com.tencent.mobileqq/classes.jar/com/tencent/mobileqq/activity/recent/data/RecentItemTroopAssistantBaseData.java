package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantDataStub;
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
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Message paramMessage)
  {
    if (paramMessage != null)
    {
      this.mUnreadNum = TroopAssistantManagerProxy.a(paramBaseQQAppInterface);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mUnreadNum :");
        localStringBuilder.append(this.mUnreadNum);
        QLog.i("RecentItemTroopAssistant", 2, localStringBuilder.toString());
      }
      this.mDisplayTime = paramMessage.getTime();
      buildMessageBody(paramMessage, 1, paramBaseQQAppInterface, paramContext, this.msgSummary);
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
      }
    }
    else
    {
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
    }
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
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Message paramMessage, MsgSummary paramMsgSummary) {}
  
  public final void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    Object localObject1 = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
    if (localObject1 != null)
    {
      if (!(((IMessageFacade)localObject1).getQQMessageFacadeStub() instanceof QQMessageFacadeStub)) {
        return;
      }
      Object localObject2 = (QQMessageFacadeStub)((IMessageFacade)localObject1).getQQMessageFacadeStub();
      if (localObject2 == null) {
        return;
      }
      localObject1 = TroopAssistantManagerProxy.a(paramBaseQQAppInterface);
      if (localObject1 != null)
      {
        if (TextUtils.isEmpty(((TroopAssistantDataStub)localObject1).getTroopUin())) {
          return;
        }
        if (this.mDisplayTime >= ((TroopAssistantDataStub)localObject1).getLastdrafttime()) {
          return;
        }
        localObject2 = ((QQMessageFacadeStub)localObject2).getDraftSummaryInfo(((TroopAssistantDataStub)localObject1).getTroopUin(), 1);
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((DraftSummaryInfo)localObject2).getSummary())) {
            return;
          }
          this.mDisplayTime = ((DraftSummaryInfo)localObject2).getTime();
          localObject2 = ((DraftSummaryInfo)localObject2).getSummary();
          paramBaseQQAppInterface = ContactUtilsProxy.b(paramBaseQQAppInterface, ((TroopAssistantDataStub)localObject1).getTroopUin(), true);
          if (paramMsgSummary != null)
          {
            paramMsgSummary.bShowDraft = true;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramBaseQQAppInterface);
            ((StringBuilder)localObject1).append(": ");
            ((StringBuilder)localObject1).append((String)localObject2);
            paramMsgSummary.mDraft = QQTextProxy.a(((StringBuilder)localObject1).toString(), 3, 16);
          }
        }
      }
    }
  }
  
  public final void dealStatus(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.mStatus = 0;
    TroopAssistantDataStub localTroopAssistantDataStub = TroopAssistantManagerProxy.a(paramBaseQQAppInterface);
    if (localTroopAssistantDataStub != null)
    {
      if (TextUtils.isEmpty(localTroopAssistantDataStub.getTroopUin())) {
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
        paramBaseQQAppInterface = paramBaseQQAppInterface.getDraftSummaryInfo(localTroopAssistantDataStub.getTroopUin(), 1);
        if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramBaseQQAppInterface.getSummary())))
        {
          this.mStatus = 4;
          return;
        }
        this.mStatus = 0;
      }
    }
  }
  
  protected void extraUpdate(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
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
    if (paramBaseQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(IMCoreResourceRoute.Resource.string.c);
      }
      Object localObject2 = null;
      Object localObject1 = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (localObject1 != null)
      {
        if (!(((IMessageFacade)localObject1).getQQMessageFacadeStub() instanceof QQMessageFacadeStub)) {
          return;
        }
        QQMessageFacadeStub localQQMessageFacadeStub = (QQMessageFacadeStub)((IMessageFacade)localObject1).getQQMessageFacadeStub();
        localObject1 = localObject2;
        if (localQQMessageFacadeStub != null)
        {
          TroopAssistantDataStub localTroopAssistantDataStub = TroopAssistantManagerProxy.a(paramBaseQQAppInterface);
          localObject1 = localObject2;
          if (localTroopAssistantDataStub != null) {
            localObject1 = localQQMessageFacadeStub.getLastMessage(localTroopAssistantDataStub.getTroopUin(), 1);
          }
        }
        this.msgSummary = getMsgSummaryTemp();
        a(paramBaseQQAppInterface, paramContext, (Message)localObject1);
        super.update(paramBaseQQAppInterface, paramContext);
        a(paramBaseQQAppInterface, paramContext, (Message)localObject1, this.msgSummary);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistantBaseData
 * JD-Core Version:    0.7.0.1
 */