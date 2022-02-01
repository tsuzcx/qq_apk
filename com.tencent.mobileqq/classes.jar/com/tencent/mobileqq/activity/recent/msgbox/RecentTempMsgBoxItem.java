package com.tencent.mobileqq.activity.recent.msgbox;

import acmw;
import allw;
import almj;
import android.content.Context;
import android.content.res.Resources;
import bapk;
import bapn;
import bhfj;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.QQTextProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.MobileQQ;

public class RecentTempMsgBoxItem
  extends RecentBaseData
{
  private static final String TAG = "RecentTempMsgBoxItem";
  private RecentUser mData;
  public boolean mIsSetTop;
  
  public RecentTempMsgBoxItem(RecentUser paramRecentUser)
  {
    if (paramRecentUser == null) {
      throw new NullPointerException("TempMsgBoxData is null");
    }
    this.mData = paramRecentUser;
  }
  
  private StringBuilder a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(",").append(paramQQAppInterface.getApplication().getString(2131698563));
    int i = paramQQAppInterface.getConversationFacade().a(AppConstants.FILTER_MSG_UIN, 10012) + allw.a(paramQQAppInterface, paramMessage);
    if (i > 0) {
      localStringBuilder.append(",").append(String.format(paramQQAppInterface.getApplication().getString(2131719296), new Object[] { Integer.valueOf(i) }));
    }
    return localStringBuilder;
  }
  
  private void a()
  {
    boolean bool;
    int j;
    if (this.mData.showUpTime != 0L)
    {
      bool = true;
      this.mIsSetTop = bool;
      this.mMenuFlag &= 0xFFFFFF0F;
      j = this.mMenuFlag;
      if (!this.mIsSetTop) {
        break label59;
      }
    }
    label59:
    for (int i = 32;; i = 16)
    {
      this.mMenuFlag = (i | j);
      return;
      bool = false;
      break;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramQQAppInterface = bapk.a(paramQQAppInterface, paramMessage.frienduin, paramMessage.istroop, this.mUnreadNum, paramMessage);
      this.mUnreadNum += paramQQAppInterface.a();
      if (paramQQAppInterface.a() > 0)
      {
        this.mMsgExtroInfo = paramQQAppInterface.a();
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary)
  {
    paramMessage.prefixOfNickname = "";
    if ((paramInt != 10012) && (!almj.a(paramQQAppInterface, paramMsgSummary, this.mData.uin, this.mData.type)))
    {
      Integer localInteger = (Integer)almj.a().get(Integer.valueOf(getRecentUserType()));
      if (localInteger != null) {
        paramMsgSummary.prefixOfContent = String.format(paramQQAppInterface.getApplication().getString(2131698944), new Object[] { paramQQAppInterface.getApplication().getString(localInteger.intValue()) });
      }
    }
    bhfj.a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, false, false);
    if (paramInt == 10012)
    {
      paramMsgSummary.strPrefix = "";
      paramQQAppInterface.getConversationFacade().d(AppConstants.FILTER_MSG_UIN, 10012, 0);
      paramInt = paramQQAppInterface.getConversationFacade().a(AppConstants.FILTER_MSG_UIN, 10012) + allw.a(paramQQAppInterface, paramMessage);
      if (paramInt != 0) {
        paramMsgSummary.strContent = String.format(paramQQAppInterface.getApplication().getString(2131698564), new Object[] { Integer.valueOf(paramInt) });
      }
    }
    else
    {
      return;
    }
    paramMsgSummary.strContent = "";
  }
  
  private void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (AppSetting.c)
    {
      new StringBuilder();
      if (getRecentUserType() != 10012) {
        break label40;
      }
    }
    label40:
    for (paramQQAppInterface = a(paramQQAppInterface, paramMessage);; paramQQAppInterface = b(paramQQAppInterface, paramMessage))
    {
      this.mContentDesc = paramQQAppInterface.toString();
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, String paramString)
  {
    if (paramMessage != null)
    {
      this.mDisplayTime = paramMessage.time;
      paramQQAppInterface = paramQQAppInterface.getConversationFacade();
      if (paramQQAppInterface != null)
      {
        this.mUnreadNum = paramQQAppInterface.a(paramMessage.frienduin, paramMessage.istroop);
        paramMessage.nickName = null;
      }
    }
    for (;;)
    {
      if (android.text.TextUtils.equals(paramString, AppConstants.FILTER_MSG_UIN)) {
        this.mDisplayTime = this.mData.lastmsgtime;
      }
      return;
      this.mUnreadNum = 0;
      break;
      this.mDisplayTime = 0L;
      this.mUnreadNum = 0;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (android.text.TextUtils.equals(paramString, AppConstants.FILTER_MSG_UIN))
    {
      this.mTitleName = paramQQAppInterface.getApplication().getString(2131698563);
      return;
    }
    this.mTitleName = almj.a(paramQQAppInterface, this.mData);
  }
  
  private void a(String paramString)
  {
    if (android.text.TextUtils.equals(paramString, AppConstants.FILTER_MSG_UIN))
    {
      this.mUnreadFlag = 0;
      return;
    }
    this.mUnreadFlag = 1;
  }
  
  private StringBuilder b(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    paramMessage = new StringBuilder();
    paramMessage.append(this.mTitleName).append(",");
    if (this.mUnreadNum == 0)
    {
      if (this.mMsgExtroInfo != null) {
        paramMessage.append(this.mMsgExtroInfo).append(",");
      }
      Integer localInteger = (Integer)almj.a().get(Integer.valueOf(getRecentUserType()));
      if (localInteger == null) {
        break label237;
      }
      paramQQAppInterface = String.format(paramQQAppInterface.getApplication().getString(2131698944), new Object[] { paramQQAppInterface.getApplication().getString(localInteger.intValue()) });
      paramMessage.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.mLastMsg.toString().replace(paramQQAppInterface, ""))).append(",");
    }
    for (;;)
    {
      paramMessage.append(this.mShowTime);
      return paramMessage;
      if (this.mUnreadNum == 1)
      {
        paramMessage.append(paramQQAppInterface.getApplication().getString(2131719190));
        break;
      }
      if (this.mUnreadNum == 2)
      {
        paramMessage.append(paramQQAppInterface.getApplication().getString(2131719191));
        break;
      }
      if (this.mUnreadNum <= 0) {
        break;
      }
      paramMessage.append(String.format(paramQQAppInterface.getApplication().getString(2131719189), new Object[] { Integer.valueOf(this.mUnreadNum) }));
      break;
      label237:
      paramMessage.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.mLastMsg.toString())).append(",");
    }
  }
  
  public RecentUser a()
  {
    return this.mData;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    QQMessageFacade.Message localMessage;
    Object localObject;
    int i;
    do
    {
      return;
      localMessage = null;
      localObject = getRecentUserUin();
      i = getRecentUserType();
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
      if (localQQMessageFacade != null) {
        localMessage = localQQMessageFacade.getLastMessage((String)localObject, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentTempMsgBoxItem", 2, new Object[] { "getLastMessage: ", localMessage });
      }
      a(paramQQAppInterface, (String)localObject, i);
      a(paramQQAppInterface, localMessage, (String)localObject);
      a(paramQQAppInterface, paramContext, localMessage);
      a((String)localObject);
      localObject = getMsgSummaryTemp();
    } while (localObject == null);
    a(paramQQAppInterface, paramContext, localMessage, i, (MsgSummary)localObject);
    dealStatus(paramQQAppInterface);
    dealDraft(paramQQAppInterface, (MsgSummary)localObject);
    extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject);
    a();
    a(paramQQAppInterface, localMessage);
  }
  
  public void dealDraft(IMCoreAppRuntime paramIMCoreAppRuntime, MsgSummary paramMsgSummary)
  {
    Object localObject;
    Integer localInteger;
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
      if (this.mDisplayTime <= getLastDraftTime())
      {
        localObject = paramIMCoreAppRuntime.getMessageFacade();
        if (localObject != null)
        {
          localObject = ((QQMessageFacadeStub)localObject).getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
          if ((localObject != null) && (!android.text.TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())))
          {
            this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
            paramMsgSummary.bShowDraft = true;
            localObject = ((DraftSummaryInfo)localObject).getSummary();
            localInteger = (Integer)almj.a().get(Integer.valueOf(getRecentUserType()));
            if (localInteger == null) {
              break label168;
            }
          }
        }
      }
    }
    label168:
    for (paramIMCoreAppRuntime = String.format(paramIMCoreAppRuntime.getApplication().getString(2131698944), new Object[] { paramIMCoreAppRuntime.getApplication().getString(localInteger.intValue()) }) + (String)localObject;; paramIMCoreAppRuntime = (IMCoreAppRuntime)localObject)
    {
      paramMsgSummary.mDraft = RecentRoute.QQTextProxy.generalQQText(paramIMCoreAppRuntime, 3, 16);
      return;
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
    return "RecentTempMsgBoxItem{mData=" + this.mData + '}';
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.RecentTempMsgBoxItem
 * JD-Core Version:    0.7.0.1
 */