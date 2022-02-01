package com.tencent.mobileqq.activity.recent.msgbox;

import acmw;
import allw;
import almg;
import almj;
import android.content.Context;
import android.text.TextUtils;
import bapk;
import bapn;
import bhfj;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.QQTextProxy;
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
  
  private int a(acmw paramacmw, int paramInt)
  {
    int i = paramacmw.d(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    if (i > 0) {
      paramInt = i;
    }
    return paramInt;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return bapk.a(paramQQAppInterface, paramString, paramInt, 0, null).a();
  }
  
  public static int a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList, acmw paramacmw)
  {
    int i = 0;
    int j = 0;
    if (i < paramList.size())
    {
      RecentUser localRecentUser = (RecentUser)paramList.get(i);
      if (TextUtils.equals(localRecentUser.uin, AppConstants.FILTER_MSG_UIN)) {}
      for (;;)
      {
        i += 1;
        break;
        int k = paramacmw.a(localRecentUser.uin, localRecentUser.getType()) + a(paramQQAppInterface, localRecentUser.uin, localRecentUser.getType());
        if (QLog.isColorLevel()) {
          QLog.d("RecentItemTempMsgBoxData", 2, "getUnreadCount() called with: user.uin = [" + localRecentUser.uin + "], unreadCount = [" + k + "]");
        }
        j += k;
      }
    }
    return j;
  }
  
  private void a(QQAppInterface paramQQAppInterface, acmw paramacmw, List<RecentUser> paramList, RecentUser paramRecentUser, QQMessageFacade.Message paramMessage)
  {
    this.mDisplayTime = paramMessage.time;
    int j;
    int i;
    if (!((almg)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a())
    {
      j = a(paramQQAppInterface, paramList, paramacmw);
      i = j;
      if (j == 0) {
        i = a(paramacmw, j);
      }
      if (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN)) {
        break label112;
      }
      j = a(paramacmw, 0);
      this.mDisplayTime = paramRecentUser.lastmsgtime;
    }
    for (;;)
    {
      this.mUser.lastmsgtime = paramRecentUser.lastmsgtime;
      this.mUnreadNum = j;
      return;
      i = a(paramacmw, 0);
      break;
      label112:
      j = i;
      if (!paramMessage.isSend())
      {
        paramMessage.nickName = almj.a(paramQQAppInterface, paramRecentUser);
        j = i;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary, RecentUser paramRecentUser, QQMessageFacade.Message paramMessage)
  {
    paramMessage.prefixOfNickname = "";
    Integer localInteger;
    if ((!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN)) && (!almj.a(paramQQAppInterface, paramMsgSummary, paramRecentUser.uin, paramRecentUser.type)))
    {
      localInteger = (Integer)almj.a().get(Integer.valueOf(paramRecentUser.getType()));
      if (localInteger != null) {
        paramMessage.prefixOfNickname = String.format(paramQQAppInterface.getApplication().getString(2131698944), new Object[] { paramQQAppInterface.getApplication().getString(localInteger.intValue()) });
      }
    }
    if ((paramMessage.isSend()) && (paramMessage.prefixOfNickname != ""))
    {
      paramMessage.prefixOfNickname = "";
      localInteger = (Integer)almj.a().get(Integer.valueOf(paramRecentUser.getType()));
      if (localInteger != null) {
        paramMsgSummary.prefixOfContent = String.format(paramQQAppInterface.getApplication().getString(2131698944), new Object[] { paramQQAppInterface.getApplication().getString(localInteger.intValue()) });
      }
    }
    bhfj.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, true, false);
    int i;
    if (TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN))
    {
      paramMsgSummary.strPrefix = "";
      paramQQAppInterface.getConversationFacade().d(AppConstants.FILTER_MSG_UIN, 10012, 0);
      i = paramQQAppInterface.getConversationFacade().a(AppConstants.FILTER_MSG_UIN, 10012) + allw.a(paramQQAppInterface, paramMessage);
      if (i == 0) {
        break label308;
      }
    }
    label308:
    for (paramMsgSummary.strContent = String.format(paramQQAppInterface.getApplication().getString(2131698948), new Object[] { Integer.valueOf(i) });; paramMsgSummary.strContent = paramQQAppInterface.getApplication().getString(2131698562))
    {
      paramMessage.prefixOfNickname = "";
      paramMessage.nickName = "";
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    if (AppSetting.c)
    {
      paramMessage = new StringBuilder();
      paramMessage.append(paramQQAppInterface.getApplication().getString(2131698949));
      paramMessage.append(this.mLastMsg.toString());
      this.mContentDesc = paramMessage.toString();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary, RecentUser paramRecentUser)
  {
    Object localObject;
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
      this.mUser.lastmsgdrafttime = 0L;
      localObject = paramQQAppInterface.getMessageFacade();
      if ((localObject != null) && (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN)) && (this.mDisplayTime < paramRecentUser.lastmsgdrafttime))
      {
        localObject = ((QQMessageFacadeStub)localObject).getDraftSummaryInfo(paramRecentUser.uin, paramRecentUser.getType());
        if ((localObject != null) && (!TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())))
        {
          this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
          this.mUser.lastmsgdrafttime = paramRecentUser.lastmsgdrafttime;
          paramMsgSummary.bShowDraft = true;
          localObject = ((DraftSummaryInfo)localObject).getSummary();
          paramRecentUser = (Integer)almj.a().get(Integer.valueOf(paramRecentUser.getType()));
          if (paramRecentUser == null) {
            break label207;
          }
        }
      }
    }
    label207:
    for (paramQQAppInterface = String.format(paramQQAppInterface.getApplication().getString(2131698944), new Object[] { paramQQAppInterface.getApplication().getString(paramRecentUser.intValue()) });; paramQQAppInterface = "")
    {
      paramMsgSummary.mDraft = RecentRoute.QQTextProxy.generalQQText(paramQQAppInterface + (String)localObject, 3, 16);
      return;
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
    this.mTitleName = paramContext.getString(2131698949);
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    acmw localacmw = paramQQAppInterface.getConversationFacade();
    List localList = ((almg)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramQQAppInterface);
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
    Object localObject2 = localQQMessageFacade.getLastMessage(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
    a(paramQQAppInterface, localacmw, localList, (RecentUser)localObject1, (QQMessageFacade.Message)localObject2);
    a(paramQQAppInterface, paramContext, localMsgSummary, (RecentUser)localObject1, (QQMessageFacade.Message)localObject2);
    this.mMenuFlag &= 0xFFF0FFFF;
    if (this.mUnreadNum != 0) {}
    for (this.mMenuFlag |= 0x10000;; this.mMenuFlag |= 0x20000)
    {
      a(paramQQAppInterface, (RecentUser)localObject1);
      a(paramQQAppInterface, localMsgSummary, (RecentUser)localObject1);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      updateMsgUnreadStateMenu();
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemTempMsgBoxData", 2, "update() called with: latestRU = [" + ((RecentUser)localObject1).uin + ", " + ((RecentUser)localObject1).getType() + "], displayTime = [" + this.mDisplayTime + "], lastMsgTime = [" + this.mUser.lastmsgtime + ", " + ((RecentUser)localObject1).lastmsgtime + "], lastDraftTime = [" + this.mUser.lastmsgdrafttime + ", " + ((RecentUser)localObject1).lastmsgdrafttime + "]");
      }
      a(paramQQAppInterface, (QQMessageFacade.Message)localObject2, localMsgSummary);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.RecentItemTempMsgBoxData
 * JD-Core Version:    0.7.0.1
 */