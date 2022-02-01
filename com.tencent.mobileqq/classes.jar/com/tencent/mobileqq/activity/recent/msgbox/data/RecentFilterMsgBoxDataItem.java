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
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import java.util.Map;
import mqq.app.MobileQQ;

public class RecentFilterMsgBoxDataItem
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemFilterMsgBoxData";
  private RecentUser mData;
  public boolean mIsSetTop;
  
  public RecentFilterMsgBoxDataItem(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mData = paramRecentUser;
  }
  
  private void a()
  {
    this.mUnreadFlag = 3;
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
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    if (AppSetting.d)
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
      paramMessage.append(((ITextUtilsApi)QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(this.mLastMsg.toString()));
      paramMessage.append(",");
      paramMessage.append(this.mShowTime);
      this.mContentDesc = paramMessage.toString();
    }
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
  
  private void a(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.getTime() != 0L))
    {
      this.mDisplayTime = paramMessage.getTime();
      if (this.mDisplayTime == 0L) {
        this.mDisplayTime = this.mData.opTime;
      }
    }
    else
    {
      this.mDisplayTime = this.mData.opTime;
    }
  }
  
  private void b(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Message paramMessage)
  {
    int i = getRecentUserType();
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    if (localMsgSummary == null) {
      return;
    }
    Integer localInteger = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(getRecentUserType()));
    if (localInteger != null) {
      localMsgSummary.prefixOfContent = String.format(paramBaseQQAppInterface.getApplication().getString(2131699395), new Object[] { paramBaseQQAppInterface.getApplication().getString(localInteger.intValue()) });
    }
    ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getCallback().a(paramContext, paramBaseQQAppInterface, paramMessage, i, localMsgSummary, false, false);
    extraUpdate(paramBaseQQAppInterface, paramContext, localMsgSummary);
  }
  
  private void b(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramBaseQQAppInterface = (IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "");
      if (paramBaseQQAppInterface != null)
      {
        this.mUnreadNum = paramBaseQQAppInterface.getUnreadCount(paramMessage.frienduin, paramMessage.istroop);
        return;
      }
      this.mUnreadNum = 0;
      return;
    }
    this.mUnreadNum = 0;
  }
  
  private void c()
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
  
  protected void extraUpdate(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    dealStatus(paramBaseQQAppInterface);
    dealDraft(paramBaseQQAppInterface, paramMsgSummary);
    super.extraUpdate(paramBaseQQAppInterface, paramContext, paramMsgSummary);
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
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    Object localObject = getRecentUserUin();
    int i = getRecentUserType();
    IMessageFacade localIMessageFacade = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
    if (localIMessageFacade != null) {
      localObject = localIMessageFacade.getLastMessage((String)localObject, i);
    } else {
      localObject = null;
    }
    b(paramBaseQQAppInterface, (Message)localObject);
    a(paramBaseQQAppInterface, paramContext, (Message)localObject);
    a();
    a(paramBaseQQAppInterface);
    c();
    a((Message)localObject);
    b(paramBaseQQAppInterface, paramContext, (Message)localObject);
    a(paramBaseQQAppInterface, (Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.data.RecentFilterMsgBoxDataItem
 * JD-Core Version:    0.7.0.1
 */