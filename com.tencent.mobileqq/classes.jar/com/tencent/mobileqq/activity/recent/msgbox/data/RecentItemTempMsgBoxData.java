package com.tencent.mobileqq.activity.recent.msgbox.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.msgbox.ITempMsgBoxCallback;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.ITempMsgBoxBusinessHandler;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class RecentItemTempMsgBoxData
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemTempMsgBoxData";
  @ParcelAnnotation.NotParcel
  public RecentUser mUser;
  
  public RecentItemTempMsgBoxData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUser = paramRecentUser;
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    return ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getCallback().a(paramAppInterface, paramString, paramInt, 0, null);
  }
  
  public static int a(AppInterface paramAppInterface, List<RecentUser> paramList, IConversationFacade paramIConversationFacade)
  {
    if (paramList == null) {
      return 0;
    }
    int i = 0;
    int j = 0;
    while (i < paramList.size())
    {
      RecentUser localRecentUser = (RecentUser)paramList.get(i);
      if (!TextUtils.equals(localRecentUser.uin, AppConstants.FILTER_MSG_UIN))
      {
        Object localObject = (String)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getBusinessStringMap().get(Integer.valueOf(localRecentUser.getType()));
        if (localObject != null)
        {
          localObject = (ITempMsgBoxBusinessHandler)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getBusinessHandlerMap().get(localObject);
          if (localObject != null)
          {
            bool = ((ITempMsgBoxBusinessHandler)localObject).a(paramAppInterface, localRecentUser.uin);
            break label135;
          }
        }
        boolean bool = true;
        label135:
        int k;
        if (bool) {
          k = paramIConversationFacade.getUnreadCount(localRecentUser.uin, localRecentUser.getType()) + a(paramAppInterface, localRecentUser.uin, localRecentUser.getType());
        } else {
          k = 0;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getUnreadCount() called with: user.uin = [");
          ((StringBuilder)localObject).append(localRecentUser.uin);
          ((StringBuilder)localObject).append("], unreadCount = [");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append("]");
          QLog.d("RecentItemTempMsgBoxData", 2, ((StringBuilder)localObject).toString());
        }
        j += k;
      }
      i += 1;
    }
    return j;
  }
  
  private int a(IConversationFacade paramIConversationFacade, int paramInt)
  {
    int i = paramIConversationFacade.getReadUnreadMark(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    if (i > 0) {
      return i;
    }
    return paramInt;
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary, RecentUser paramRecentUser, Message paramMessage)
  {
    paramMessage.prefixOfNickname = "";
    Object localObject = ((ITempChatPluginManager)paramBaseQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(paramRecentUser.type);
    if (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN)) {
      if (localObject != null)
      {
        paramMessage.prefixOfNickname = ((AbstractTempChatPlugin)localObject).a(paramRecentUser.uin, TempChatSource.SOURCE_FROM_MAG_TAB);
      }
      else
      {
        Integer localInteger = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(paramRecentUser.getType()));
        if (localInteger != null) {
          paramMessage.prefixOfNickname = String.format(paramBaseQQAppInterface.getApplication().getString(2131699395), new Object[] { paramBaseQQAppInterface.getApplication().getString(localInteger.intValue()) });
        }
      }
    }
    if ((paramMessage.isSend()) && (paramMessage.prefixOfNickname != ""))
    {
      paramMessage.prefixOfNickname = "";
      if (localObject != null)
      {
        paramMsgSummary.prefixOfContent = ((AbstractTempChatPlugin)localObject).a(paramRecentUser.uin, TempChatSource.SOURCE_FROM_MAG_TAB);
      }
      else
      {
        localObject = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(paramRecentUser.getType()));
        if (localObject != null) {
          paramMsgSummary.prefixOfContent = String.format(paramBaseQQAppInterface.getApplication().getString(2131699395), new Object[] { paramBaseQQAppInterface.getApplication().getString(((Integer)localObject).intValue()) });
        }
      }
    }
    localObject = (String)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getBusinessStringMap().get(Integer.valueOf(paramRecentUser.getType()));
    if (localObject != null)
    {
      localObject = (ITempMsgBoxBusinessHandler)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getBusinessHandlerMap().get(localObject);
      if (localObject != null) {
        ((ITempMsgBoxBusinessHandler)localObject).a(paramBaseQQAppInterface, paramMessage, paramRecentUser.getType(), paramMsgSummary);
      }
    }
    ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getCallback().a(paramContext, paramBaseQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, true, false);
    if (TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN))
    {
      paramMsgSummary.strPrefix = "";
      paramContext = (IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "");
      paramContext.increaseUnread(AppConstants.FILTER_MSG_UIN, 10012, 0);
      int i = paramContext.getUnreadCount(AppConstants.FILTER_MSG_UIN, 10012) + ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getAllFilterMsgUnreadNumOfQCall(paramBaseQQAppInterface, paramMessage);
      if (i != 0) {
        paramMsgSummary.strContent = String.format(paramBaseQQAppInterface.getApplication().getString(2131699399), new Object[] { Integer.valueOf(i) });
      } else {
        paramMsgSummary.strContent = paramBaseQQAppInterface.getApplication().getString(2131698937);
      }
    }
    paramMessage.prefixOfNickname = "";
    paramMessage.nickName = "";
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if (AppSetting.d)
    {
      paramMessage = new StringBuilder();
      paramMessage.append(paramBaseQQAppInterface.getApplication().getString(2131699400));
      paramMessage.append(this.mLastMsg.toString());
      this.mContentDesc = paramMessage.toString();
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary, RecentUser paramRecentUser)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
      this.mUser.lastmsgdrafttime = 0L;
      IMessageFacade localIMessageFacade = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      if ((localIMessageFacade != null) && (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN)) && (this.mDisplayTime < paramRecentUser.lastmsgdrafttime)) {
        a(paramBaseQQAppInterface, paramMsgSummary, paramRecentUser, localIMessageFacade.getDraftSummaryInfo(paramRecentUser.uin, paramRecentUser.getType()));
      }
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary, RecentUser paramRecentUser, DraftSummaryInfo paramDraftSummaryInfo)
  {
    if ((paramDraftSummaryInfo != null) && (!TextUtils.isEmpty(paramDraftSummaryInfo.getSummary())))
    {
      this.mDisplayTime = paramDraftSummaryInfo.getTime();
      this.mUser.lastmsgdrafttime = paramRecentUser.lastmsgdrafttime;
      paramMsgSummary.bShowDraft = true;
      String str = paramDraftSummaryInfo.getSummary();
      paramDraftSummaryInfo = "";
      Object localObject = ((ITempChatPluginManager)paramBaseQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(paramRecentUser.type);
      if (localObject != null)
      {
        paramRecentUser = ((AbstractTempChatPlugin)localObject).a(paramRecentUser.uin, TempChatSource.SOURCE_FROM_MAG_TAB);
      }
      else
      {
        localObject = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(paramRecentUser.getType()));
        paramRecentUser = paramDraftSummaryInfo;
        if (localObject != null) {
          paramRecentUser = String.format(paramBaseQQAppInterface.getApplication().getString(2131699395), new Object[] { paramBaseQQAppInterface.getApplication().getString(((Integer)localObject).intValue()) });
        }
      }
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(paramRecentUser);
      paramBaseQQAppInterface.append(str);
      paramMsgSummary.mDraft = new QQText(paramBaseQQAppInterface.toString(), 3, 16);
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    this.mStatus = 0;
    if (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN))
    {
      paramBaseQQAppInterface = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (paramBaseQQAppInterface != null)
      {
        paramBaseQQAppInterface = paramBaseQQAppInterface.getDraftSummaryInfo(paramRecentUser.uin, paramRecentUser.getType());
        if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramBaseQQAppInterface.getSummary())))
        {
          this.mStatus = 4;
          return;
        }
        this.mStatus = 0;
      }
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, IConversationFacade paramIConversationFacade, List<RecentUser> paramList, RecentUser paramRecentUser, Message paramMessage)
  {
    this.mDisplayTime = paramMessage.time;
    int j;
    int i;
    if (!((ITempMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).isMsgBoxRead())
    {
      j = a(paramBaseQQAppInterface, paramList, paramIConversationFacade);
      i = j;
      if (j == 0) {
        i = a(paramIConversationFacade, j);
      }
    }
    else
    {
      i = a(paramIConversationFacade, 0);
    }
    if (TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN))
    {
      j = a(paramIConversationFacade, 0);
      this.mDisplayTime = paramRecentUser.lastmsgtime;
    }
    else
    {
      j = i;
      if (!paramMessage.isSend())
      {
        paramMessage.nickName = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTitleName(paramBaseQQAppInterface, paramRecentUser);
        j = i;
      }
    }
    this.mUser.lastmsgtime = paramRecentUser.lastmsgtime;
    this.mUnreadNum = j;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.update(paramBaseQQAppInterface, paramContext);
      this.mTitleName = paramContext.getString(2131699400);
      MsgSummary localMsgSummary = getMsgSummaryTemp();
      IMessageFacade localIMessageFacade = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      IConversationFacade localIConversationFacade = (IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "");
      List localList = ((ITempMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
      if (localList.isEmpty())
      {
        QLog.e("RecentItemTempMsgBoxData", 1, "update: msgBoxRecentUsers.isEmpty()");
        return;
      }
      Object localObject1 = (RecentUser)localList.get(0);
      Object localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        Object localObject3 = localObject1;
        if (Math.max(localRecentUser.lastmsgtime, localRecentUser.lastmsgdrafttime) > Math.max(((RecentUser)localObject1).lastmsgtime, ((RecentUser)localObject1).lastmsgdrafttime)) {
          localObject3 = localRecentUser;
        }
        localObject1 = localObject3;
      }
      localObject2 = localIMessageFacade.getLastMessage(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
      a(paramBaseQQAppInterface, localIConversationFacade, localList, (RecentUser)localObject1, (Message)localObject2);
      a(paramBaseQQAppInterface, paramContext, localMsgSummary, (RecentUser)localObject1, (Message)localObject2);
      this.mMenuFlag &= 0xFFF0FFFF;
      if (this.mUnreadNum != 0) {
        this.mMenuFlag |= 0x10000;
      } else {
        this.mMenuFlag |= 0x20000;
      }
      a(paramBaseQQAppInterface, (RecentUser)localObject1);
      a(paramBaseQQAppInterface, localMsgSummary, (RecentUser)localObject1);
      extraUpdate(paramBaseQQAppInterface, paramContext, localMsgSummary);
      b();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("update() called with: latestRU = [");
        paramContext.append(((RecentUser)localObject1).uin);
        paramContext.append(", ");
        paramContext.append(((RecentUser)localObject1).getType());
        paramContext.append("], displayTime = [");
        paramContext.append(this.mDisplayTime);
        paramContext.append("], lastMsgTime = [");
        paramContext.append(this.mUser.lastmsgtime);
        paramContext.append(", ");
        paramContext.append(((RecentUser)localObject1).lastmsgtime);
        paramContext.append("], lastDraftTime = [");
        paramContext.append(this.mUser.lastmsgdrafttime);
        paramContext.append(", ");
        paramContext.append(((RecentUser)localObject1).lastmsgdrafttime);
        paramContext.append("]");
        QLog.d("RecentItemTempMsgBoxData", 2, paramContext.toString());
      }
      a(paramBaseQQAppInterface, (Message)localObject2, localMsgSummary);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.data.RecentItemTempMsgBoxData
 * JD-Core Version:    0.7.0.1
 */