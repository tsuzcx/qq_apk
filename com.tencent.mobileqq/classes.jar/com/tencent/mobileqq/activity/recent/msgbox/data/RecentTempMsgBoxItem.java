package com.tencent.mobileqq.activity.recent.msgbox.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.msgbox.ITempMsgBoxCallback;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.ITempMsgBoxBusinessHandler;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;

public class RecentTempMsgBoxItem
  extends RecentUserBaseData
{
  private static final String TAG = "RecentTempMsgBoxItem";
  private RecentUser mData;
  public boolean mIsSetTop;
  
  public RecentTempMsgBoxItem(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mData = paramRecentUser;
  }
  
  private StringBuilder a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    paramMessage = new StringBuilder();
    paramMessage.append(this.mTitleName);
    paramMessage.append(",");
    if (this.mUnreadNum != 0) {
      if (this.mUnreadNum == 1) {
        paramMessage.append(paramBaseQQAppInterface.getApplication().getString(2131719470));
      } else if (this.mUnreadNum == 2) {
        paramMessage.append(paramBaseQQAppInterface.getApplication().getString(2131719471));
      } else if (this.mUnreadNum > 0) {
        paramMessage.append(String.format(paramBaseQQAppInterface.getApplication().getString(2131719469), new Object[] { Integer.valueOf(this.mUnreadNum) }));
      }
    }
    if (this.mMsgExtroInfo != null)
    {
      paramMessage.append(this.mMsgExtroInfo);
      paramMessage.append(",");
    }
    Integer localInteger = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(getRecentUserType()));
    if (localInteger != null)
    {
      paramBaseQQAppInterface = String.format(paramBaseQQAppInterface.getApplication().getString(2131699395), new Object[] { paramBaseQQAppInterface.getApplication().getString(localInteger.intValue()) });
      paramBaseQQAppInterface = this.mLastMsg.toString().replace(paramBaseQQAppInterface, "");
      paramMessage.append(((ITextUtilsApi)QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(paramBaseQQAppInterface));
      paramMessage.append(",");
    }
    else
    {
      paramMessage.append(((ITextUtilsApi)QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(this.mLastMsg.toString()));
      paramMessage.append(",");
    }
    paramMessage.append(this.mShowTime);
    return paramMessage;
  }
  
  private void a()
  {
    boolean bool;
    if (this.mData.showUpTime != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsSetTop = bool;
    this.mMenuFlag &= 0xFFFFFF0F;
    int j = this.mMenuFlag;
    int i;
    if (this.mIsSetTop) {
      i = 32;
    } else {
      i = 16;
    }
    this.mMenuFlag = (j | i);
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.mTitleName = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTitleName(paramBaseQQAppInterface, this.mData);
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Message paramMessage)
  {
    if (paramMessage != null)
    {
      ITempMsgBoxCallback localITempMsgBoxCallback = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getCallback();
      int i = localITempMsgBoxCallback.a(paramBaseQQAppInterface, paramMessage.frienduin, paramMessage.istroop, this.mUnreadNum, paramMessage);
      this.mUnreadNum += i;
      if (i > 0)
      {
        this.mMsgExtroInfo = localITempMsgBoxCallback.a(paramBaseQQAppInterface, paramMessage.frienduin, paramMessage.istroop, this.mUnreadNum, paramMessage);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
      }
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Message paramMessage, int paramInt, MsgSummary paramMsgSummary)
  {
    paramMessage.prefixOfNickname = "";
    Object localObject = ((ITempChatPluginManager)paramBaseQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(getRecentUserType());
    if (localObject != null)
    {
      paramMsgSummary.prefixOfContent = ((AbstractTempChatPlugin)localObject).a(getRecentUserUin(), TempChatSource.SOURCE_FROM_MAG_TAB);
    }
    else
    {
      localObject = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(getRecentUserType()));
      if (localObject != null) {
        paramMsgSummary.prefixOfContent = String.format(paramBaseQQAppInterface.getApplication().getString(2131699395), new Object[] { paramBaseQQAppInterface.getApplication().getString(((Integer)localObject).intValue()) });
      }
    }
    localObject = (String)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getBusinessStringMap().get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = (ITempMsgBoxBusinessHandler)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getBusinessHandlerMap().get(localObject);
      if (localObject != null) {
        ((ITempMsgBoxBusinessHandler)localObject).a(paramBaseQQAppInterface, paramMessage, paramInt, paramMsgSummary);
      }
    }
    ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getCallback().a(paramContext, paramBaseQQAppInterface, paramMessage, paramInt, paramMsgSummary, false, false);
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    if (AppSetting.d) {
      this.mContentDesc = a(paramBaseQQAppInterface, paramMessage).toString();
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage, String paramString)
  {
    if (paramMessage != null)
    {
      this.mDisplayTime = paramMessage.time;
      IConversationFacade localIConversationFacade = (IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "");
      int i = getRecentUserType();
      boolean bool2 = true;
      Object localObject = (String)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getBusinessStringMap().get(Integer.valueOf(i));
      boolean bool1 = bool2;
      if (localObject != null)
      {
        localObject = (ITempMsgBoxBusinessHandler)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getBusinessHandlerMap().get(localObject);
        bool1 = bool2;
        if (localObject != null) {
          bool1 = ((ITempMsgBoxBusinessHandler)localObject).a(paramBaseQQAppInterface, paramString);
        }
      }
      if (!bool1) {
        this.mUnreadNum = 0;
      } else {
        this.mUnreadNum = localIConversationFacade.getUnreadCount(paramMessage.frienduin, paramMessage.istroop);
      }
      paramMessage.nickName = null;
      return;
    }
    this.mDisplayTime = 0L;
    this.mUnreadNum = 0;
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary, DraftSummaryInfo paramDraftSummaryInfo)
  {
    if ((paramDraftSummaryInfo != null) && (!TextUtils.isEmpty(paramDraftSummaryInfo.getSummary())))
    {
      this.mDisplayTime = paramDraftSummaryInfo.getTime();
      paramMsgSummary.bShowDraft = true;
      String str = paramDraftSummaryInfo.getSummary();
      paramDraftSummaryInfo = "";
      Object localObject = ((ITempChatPluginManager)paramBaseQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(getRecentUserType());
      if (localObject != null)
      {
        paramDraftSummaryInfo = ((AbstractTempChatPlugin)localObject).a(getRecentUserUin(), TempChatSource.SOURCE_FROM_MAG_TAB);
      }
      else
      {
        localObject = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(getRecentUserType()));
        if (localObject != null) {
          paramDraftSummaryInfo = String.format(paramBaseQQAppInterface.getApplication().getString(2131699395), new Object[] { paramBaseQQAppInterface.getApplication().getString(((Integer)localObject).intValue()) });
        }
      }
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(paramDraftSummaryInfo);
      paramBaseQQAppInterface.append(str);
      paramMsgSummary.mDraft = new QQText(paramBaseQQAppInterface.toString(), 3, 16);
    }
  }
  
  private void c()
  {
    this.mUnreadFlag = 1;
  }
  
  public RecentUser a()
  {
    return this.mData;
  }
  
  public void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
      if (this.mDisplayTime <= getLastDraftTime())
      {
        IMessageFacade localIMessageFacade = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
        if (localIMessageFacade != null) {
          a(paramBaseQQAppInterface, paramMsgSummary, localIMessageFacade.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType()));
        }
      }
    }
  }
  
  public long getLastDraftTime()
  {
    return this.mData.lastmsgdrafttime;
  }
  
  public long getLastMsgTime()
  {
    return this.mData.lastmsgtime;
  }
  
  public int getRecentUserType()
  {
    return this.mData.getType();
  }
  
  public String getRecentUserUin()
  {
    return this.mData.uin;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecentTempMsgBoxItem{mData=");
    localStringBuilder.append(this.mData);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      Message localMessage = null;
      String str = getRecentUserUin();
      int i = getRecentUserType();
      Object localObject = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (localObject != null) {
        localMessage = ((IMessageFacade)localObject).getLastMessage(str, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentTempMsgBoxItem", 2, new Object[] { "getLastMessage: ", localMessage });
      }
      a(paramBaseQQAppInterface);
      a(paramBaseQQAppInterface, localMessage, str);
      a(paramBaseQQAppInterface, paramContext, localMessage);
      c();
      localObject = getMsgSummaryTemp();
      if (localObject == null) {
        return;
      }
      a(paramBaseQQAppInterface, paramContext, localMessage, i, (MsgSummary)localObject);
      dealStatus(paramBaseQQAppInterface);
      dealDraft(paramBaseQQAppInterface, (MsgSummary)localObject);
      extraUpdate(paramBaseQQAppInterface, paramContext, (MsgSummary)localObject);
      a();
      a(paramBaseQQAppInterface, localMessage);
      paramContext = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getBusinessHandlerMap().values().iterator();
      while (paramContext.hasNext()) {
        ((ITempMsgBoxBusinessHandler)paramContext.next()).a(paramBaseQQAppInterface, i, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.data.RecentTempMsgBoxItem
 * JD-Core Version:    0.7.0.1
 */