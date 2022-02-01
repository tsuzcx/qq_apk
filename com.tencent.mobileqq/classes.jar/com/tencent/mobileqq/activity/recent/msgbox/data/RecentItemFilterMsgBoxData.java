package com.tencent.mobileqq.activity.recent.msgbox.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.msgbox.ITempMsgBoxCallback;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class RecentItemFilterMsgBoxData
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemFilterMsgBoxData";
  @ParcelAnnotation.NotParcel
  public RecentUser mUser;
  
  public RecentItemFilterMsgBoxData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUser = paramRecentUser;
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
        this.mMsgExtroInfo = localITempMsgBoxCallback.b(paramBaseQQAppInterface, paramMessage.frienduin, paramMessage.istroop, this.mUnreadNum, paramMessage);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
      }
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    if (AppSetting.e)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(",");
      localStringBuilder.append(paramBaseQQAppInterface.getApplication().getString(2131896912));
      int i = ((IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(AppConstants.FILTER_MSG_UIN, 10012) + ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getAllFilterMsgUnreadNumOfQCall(paramBaseQQAppInterface, paramMessage);
      if (i > 0)
      {
        localStringBuilder.append(",");
        localStringBuilder.append(String.format(paramBaseQQAppInterface.getApplication().getString(2131917139), new Object[] { Integer.valueOf(i) }));
      }
      this.mContentDesc = localStringBuilder.toString();
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary, IConversationFacade paramIConversationFacade, Message paramMessage)
  {
    paramMsgSummary.strPrefix = "";
    paramIConversationFacade.increaseUnread(AppConstants.FILTER_MSG_UIN, 10012, 0);
    int i = paramIConversationFacade.getUnreadCount(AppConstants.FILTER_MSG_UIN, 10012) + ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getAllFilterMsgUnreadNumOfQCall(paramBaseQQAppInterface, paramMessage);
    if (i != 0)
    {
      paramMsgSummary.strContent = String.format(paramBaseQQAppInterface.getApplication().getString(2131896913), new Object[] { Integer.valueOf(i) });
      return;
    }
    paramMsgSummary.strContent = "";
  }
  
  private void a(IConversationFacade paramIConversationFacade, Message paramMessage)
  {
    if (paramMessage != null)
    {
      this.mUnreadNum = paramIConversationFacade.getUnreadCount(paramMessage.frienduin, paramMessage.istroop);
      paramMessage.nickName = null;
    }
    else
    {
      this.mUnreadNum = 0;
    }
    this.mDisplayTime = paramMessage.time;
    this.mUser.lastmsgtime = paramMessage.time;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.update(paramBaseQQAppInterface, paramContext);
      this.mTitleName = paramBaseQQAppInterface.getApplication().getString(2131896912);
      MsgSummary localMsgSummary = getMsgSummaryTemp();
      IMessageFacade localIMessageFacade = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      IConversationFacade localIConversationFacade = (IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "");
      Object localObject2 = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getFilterBoxRecentUsers(paramBaseQQAppInterface);
      boolean bool = ((List)localObject2).isEmpty();
      String str = "RecentItemFilterMsgBoxData";
      if (bool)
      {
        QLog.e("RecentItemFilterMsgBoxData", 1, "update: msgBoxRecentUsers.isEmpty()");
        return;
      }
      Object localObject1 = (RecentUser)((List)localObject2).get(0);
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)localIterator.next();
        localObject2 = localObject1;
        if (Math.max(localRecentUser.lastmsgtime, localRecentUser.lastmsgdrafttime) > Math.max(((RecentUser)localObject1).lastmsgtime, ((RecentUser)localObject1).lastmsgdrafttime)) {
          localObject2 = localRecentUser;
        }
        localObject1 = localObject2;
      }
      localObject2 = localIMessageFacade.getLastMessage(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
      a(localIConversationFacade, (Message)localObject2);
      a(paramBaseQQAppInterface, paramContext, (Message)localObject2);
      this.mUnreadFlag = 0;
      a(paramBaseQQAppInterface, localMsgSummary, localIConversationFacade, (Message)localObject2);
      extraUpdate(paramBaseQQAppInterface, paramContext, localMsgSummary);
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
        QLog.d(str, 2, paramContext.toString());
      }
      a(paramBaseQQAppInterface, (Message)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.data.RecentItemFilterMsgBoxData
 * JD-Core Version:    0.7.0.1
 */