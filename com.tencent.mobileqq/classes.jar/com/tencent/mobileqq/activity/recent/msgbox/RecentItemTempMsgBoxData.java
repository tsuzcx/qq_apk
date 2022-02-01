package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class RecentItemTempMsgBoxData
  extends AbsRecentUserBusinessBaseData
{
  private static final String TAG = "RecentItemTempMsgBoxData";
  @ParcelAnnotation.NotParcel
  public RecentUser mUser;
  
  public RecentItemTempMsgBoxData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUser = paramRecentUser;
  }
  
  private int a(ConversationFacade paramConversationFacade, int paramInt)
  {
    int i = paramConversationFacade.d(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    if (i > 0) {
      paramInt = i;
    }
    return paramInt;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return QCallFacade.a(paramQQAppInterface, paramString, paramInt, 0, null).a();
  }
  
  public static int a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList, ConversationFacade paramConversationFacade)
  {
    paramQQAppInterface.getMessageFacade();
    int j = 0;
    int k = 0;
    RecentUser localRecentUser;
    int i;
    for (;;)
    {
      if (j < paramList.size())
      {
        localRecentUser = (RecentUser)paramList.get(j);
        if (TextUtils.equals(localRecentUser.uin, AppConstants.FILTER_MSG_UIN))
        {
          j += 1;
        }
        else if (localRecentUser.type == 10007)
        {
          if (!GameMsgUtil.a(paramQQAppInterface, localRecentUser.uin)) {
            break label192;
          }
          i = paramConversationFacade.a(localRecentUser.uin, localRecentUser.getType());
        }
      }
    }
    for (;;)
    {
      i += a(paramQQAppInterface, localRecentUser.uin, localRecentUser.getType());
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemTempMsgBoxData", 2, "getUnreadCount() called with: user.uin = [" + localRecentUser.uin + "], unreadCount = [" + i + "]");
      }
      k += i;
      break;
      i = paramConversationFacade.a(localRecentUser.uin, localRecentUser.getType());
      continue;
      return k;
      label192:
      i = 0;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary, RecentUser paramRecentUser, Message paramMessage)
  {
    paramMessage.prefixOfNickname = "";
    Object localObject = ((TempChatPluginManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(paramRecentUser.type);
    label111:
    int i;
    if (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN))
    {
      if (localObject != null) {
        paramMessage.prefixOfNickname = ((AbstractTempChatPlugin)localObject).a(paramRecentUser.uin, TempChatSource.SOURCE_FROM_MAG_TAB);
      }
    }
    else
    {
      if ((paramMessage.isSend()) && (paramMessage.prefixOfNickname != ""))
      {
        paramMessage.prefixOfNickname = "";
        if (localObject == null) {
          break label310;
        }
        paramMsgSummary.prefixOfContent = ((AbstractTempChatPlugin)localObject).a(paramRecentUser.uin, TempChatSource.SOURCE_FROM_MAG_TAB);
      }
      GameMsgUtil.a(paramQQAppInterface, paramMessage, paramRecentUser.type, paramMsgSummary);
      MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, true, false);
      if (TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN))
      {
        paramMsgSummary.strPrefix = "";
        paramQQAppInterface.getConversationFacade().d(AppConstants.FILTER_MSG_UIN, 10012, 0);
        i = paramQQAppInterface.getConversationFacade().a(AppConstants.FILTER_MSG_UIN, 10012) + FilterMsgBoxUtil.a(paramQQAppInterface, paramMessage);
        if (i == 0) {
          break label374;
        }
      }
    }
    label310:
    label374:
    for (paramMsgSummary.strContent = String.format(paramQQAppInterface.getApplication().getString(2131699294), new Object[] { Integer.valueOf(i) });; paramMsgSummary.strContent = paramQQAppInterface.getApplication().getString(2131698858))
    {
      paramMessage.prefixOfNickname = "";
      paramMessage.nickName = "";
      return;
      Integer localInteger = (Integer)TempMsgBoxUtil.a().get(Integer.valueOf(paramRecentUser.getType()));
      if (localInteger == null) {
        break;
      }
      paramMessage.prefixOfNickname = String.format(paramQQAppInterface.getApplication().getString(2131699290), new Object[] { paramQQAppInterface.getApplication().getString(localInteger.intValue()) });
      break;
      localObject = (Integer)TempMsgBoxUtil.a().get(Integer.valueOf(paramRecentUser.getType()));
      if (localObject == null) {
        break label111;
      }
      paramMsgSummary.prefixOfContent = String.format(paramQQAppInterface.getApplication().getString(2131699290), new Object[] { paramQQAppInterface.getApplication().getString(((Integer)localObject).intValue()) });
      break label111;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ConversationFacade paramConversationFacade, List<RecentUser> paramList, RecentUser paramRecentUser, Message paramMessage)
  {
    this.mDisplayTime = paramMessage.time;
    int j;
    int i;
    if (!((TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a())
    {
      j = a(paramQQAppInterface, paramList, paramConversationFacade);
      i = j;
      if (j == 0) {
        i = a(paramConversationFacade, j);
      }
      if (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN)) {
        break label112;
      }
      j = a(paramConversationFacade, 0);
      this.mDisplayTime = paramRecentUser.lastmsgtime;
    }
    for (;;)
    {
      this.mUser.lastmsgtime = paramRecentUser.lastmsgtime;
      this.mUnreadNum = j;
      return;
      i = a(paramConversationFacade, 0);
      break;
      label112:
      j = i;
      if (!paramMessage.isSend())
      {
        paramMessage.nickName = TempMsgBoxUtil.a(paramQQAppInterface, paramRecentUser);
        j = i;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if (AppSetting.d)
    {
      paramMessage = new StringBuilder();
      paramMessage.append(paramQQAppInterface.getApplication().getString(2131699295));
      paramMessage.append(this.mLastMsg.toString());
      this.mContentDesc = paramMessage.toString();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary, RecentUser paramRecentUser)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
      this.mUser.lastmsgdrafttime = 0L;
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
      if ((localQQMessageFacade != null) && (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN)) && (this.mDisplayTime < paramRecentUser.lastmsgdrafttime)) {
        a(paramQQAppInterface, paramMsgSummary, paramRecentUser, localQQMessageFacade.getDraftSummaryInfo(paramRecentUser.uin, paramRecentUser.getType()));
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary, RecentUser paramRecentUser, DraftSummaryInfo paramDraftSummaryInfo)
  {
    if ((paramDraftSummaryInfo != null) && (!TextUtils.isEmpty(paramDraftSummaryInfo.getSummary())))
    {
      this.mDisplayTime = paramDraftSummaryInfo.getTime();
      this.mUser.lastmsgdrafttime = paramRecentUser.lastmsgdrafttime;
      paramMsgSummary.bShowDraft = true;
      paramDraftSummaryInfo = paramDraftSummaryInfo.getSummary();
      AbstractTempChatPlugin localAbstractTempChatPlugin = ((TempChatPluginManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(paramRecentUser.type);
      if (localAbstractTempChatPlugin == null) {
        break label119;
      }
      paramQQAppInterface = localAbstractTempChatPlugin.a(paramRecentUser.uin, TempChatSource.SOURCE_FROM_MAG_TAB);
    }
    for (;;)
    {
      paramMsgSummary.mDraft = new QQText(paramQQAppInterface + paramDraftSummaryInfo, 3, 16);
      return;
      label119:
      paramRecentUser = (Integer)TempMsgBoxUtil.a().get(Integer.valueOf(paramRecentUser.getType()));
      if (paramRecentUser != null) {
        paramQQAppInterface = String.format(paramQQAppInterface.getApplication().getString(2131699290), new Object[] { paramQQAppInterface.getApplication().getString(paramRecentUser.intValue()) });
      } else {
        paramQQAppInterface = "";
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    this.mStatus = 0;
    if (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN))
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramRecentUser.uin, paramRecentUser.getType());
        if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary()))) {
          break label62;
        }
        this.mStatus = 4;
      }
    }
    return;
    label62:
    this.mStatus = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.mTitleName = paramContext.getString(2131699295);
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    ConversationFacade localConversationFacade = paramQQAppInterface.getConversationFacade();
    List localList = ((TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramQQAppInterface);
    if (localList.isEmpty())
    {
      QLog.e("RecentItemTempMsgBoxData", 1, "update: msgBoxRecentUsers.isEmpty()");
      return;
    }
    Object localObject1 = (RecentUser)localList.get(0);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (RecentUser)localIterator.next();
      if (Math.max(((RecentUser)localObject2).lastmsgtime, ((RecentUser)localObject2).lastmsgdrafttime) > Math.max(((RecentUser)localObject1).lastmsgtime, ((RecentUser)localObject1).lastmsgdrafttime)) {
        localObject1 = localObject2;
      }
    }
    Object localObject2 = localQQMessageFacade.a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
    a(paramQQAppInterface, localConversationFacade, localList, (RecentUser)localObject1, (Message)localObject2);
    a(paramQQAppInterface, paramContext, localMsgSummary, (RecentUser)localObject1, (Message)localObject2);
    this.mMenuFlag &= 0xFFF0FFFF;
    if (this.mUnreadNum != 0) {}
    for (this.mMenuFlag |= 0x10000;; this.mMenuFlag |= 0x20000)
    {
      a(paramQQAppInterface, (RecentUser)localObject1);
      a(paramQQAppInterface, localMsgSummary, (RecentUser)localObject1);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      b();
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemTempMsgBoxData", 2, "update() called with: latestRU = [" + ((RecentUser)localObject1).uin + ", " + ((RecentUser)localObject1).getType() + "], displayTime = [" + this.mDisplayTime + "], lastMsgTime = [" + this.mUser.lastmsgtime + ", " + ((RecentUser)localObject1).lastmsgtime + "], lastDraftTime = [" + this.mUser.lastmsgdrafttime + ", " + ((RecentUser)localObject1).lastmsgdrafttime + "]");
      }
      a(paramQQAppInterface, (Message)localObject2, localMsgSummary);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.RecentItemTempMsgBoxData
 * JD-Core Version:    0.7.0.1
 */