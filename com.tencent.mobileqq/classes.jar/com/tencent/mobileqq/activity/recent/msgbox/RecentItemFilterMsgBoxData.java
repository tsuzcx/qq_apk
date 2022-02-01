package com.tencent.mobileqq.activity.recent.msgbox;

import acmw;
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
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.QQTextProxy;
import java.util.Map;
import mqq.app.MobileQQ;

public class RecentItemFilterMsgBoxData
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemFilterMsgBoxData";
  private RecentUser mData;
  public boolean mIsSetTop;
  
  public RecentItemFilterMsgBoxData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mData = paramRecentUser;
  }
  
  private void a()
  {
    this.mUnreadFlag = 3;
  }
  
  private void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.getTime() != 0L))
    {
      this.mDisplayTime = paramMessage.getTime();
      if (this.mDisplayTime == 0L) {
        this.mDisplayTime = this.mData.opTime;
      }
      return;
    }
    this.mDisplayTime = this.mData.opTime;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.mTitleName = almj.a(paramQQAppInterface, this.mData);
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
  
  private void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (AppSetting.c)
    {
      paramMessage = new StringBuilder();
      paramMessage.append(this.mTitleName).append(",");
      if (this.mUnreadNum != 0) {
        break label94;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        paramMessage.append(this.mMsgExtroInfo).append(",");
      }
      paramMessage.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.mLastMsg.toString())).append(",").append(this.mShowTime);
      this.mContentDesc = paramMessage.toString();
      return;
      label94:
      if (this.mUnreadNum == 1) {
        paramMessage.append(paramQQAppInterface.getApplication().getString(2131719190));
      } else if (this.mUnreadNum == 2) {
        paramMessage.append(paramQQAppInterface.getApplication().getString(2131719191));
      } else if (this.mUnreadNum > 0) {
        paramMessage.append(String.format(paramQQAppInterface.getApplication().getString(2131719189), new Object[] { Integer.valueOf(this.mUnreadNum) }));
      }
    }
  }
  
  private void a(IMCoreAppRuntime paramIMCoreAppRuntime, MsgSummary paramMsgSummary, DraftSummaryInfo paramDraftSummaryInfo)
  {
    Integer localInteger;
    if ((paramDraftSummaryInfo != null) && (!android.text.TextUtils.isEmpty(paramDraftSummaryInfo.getSummary())))
    {
      this.mDisplayTime = paramDraftSummaryInfo.getTime();
      paramMsgSummary.bShowDraft = true;
      paramDraftSummaryInfo = paramDraftSummaryInfo.getSummary();
      localInteger = (Integer)almj.a().get(Integer.valueOf(getRecentUserType()));
      if (localInteger == null) {
        break label118;
      }
    }
    label118:
    for (paramIMCoreAppRuntime = String.format(paramIMCoreAppRuntime.getApplication().getString(2131698944), new Object[] { paramIMCoreAppRuntime.getApplication().getString(localInteger.intValue()) }) + paramDraftSummaryInfo;; paramIMCoreAppRuntime = paramDraftSummaryInfo)
    {
      paramMsgSummary.mDraft = RecentRoute.QQTextProxy.generalQQText(paramIMCoreAppRuntime, 3, 16);
      return;
    }
  }
  
  private void b()
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
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    int i = getRecentUserType();
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    if (localMsgSummary == null) {
      return;
    }
    Integer localInteger = (Integer)almj.a().get(Integer.valueOf(getRecentUserType()));
    if (localInteger != null) {
      localMsgSummary.prefixOfContent = String.format(paramQQAppInterface.getApplication().getString(2131698944), new Object[] { paramQQAppInterface.getApplication().getString(localInteger.intValue()) });
    }
    bhfj.a(paramContext, paramQQAppInterface, paramMessage, i, localMsgSummary, false, false);
    extraUpdate(paramQQAppInterface, paramContext, localMsgSummary);
  }
  
  private void b(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramQQAppInterface = paramQQAppInterface.getConversationFacade();
      if (paramQQAppInterface != null)
      {
        this.mUnreadNum = paramQQAppInterface.a(paramMessage.frienduin, paramMessage.istroop);
        return;
      }
      this.mUnreadNum = 0;
      return;
    }
    this.mUnreadNum = 0;
  }
  
  public RecentUser a()
  {
    return this.mData;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    QQMessageFacade.Message localMessage = null;
    String str = getRecentUserUin();
    int i = getRecentUserType();
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null) {
      localMessage = localQQMessageFacade.getLastMessage(str, i);
    }
    b(paramQQAppInterface, localMessage);
    a(paramQQAppInterface, paramContext, localMessage);
    a();
    a(paramQQAppInterface);
    b();
    a(localMessage);
    b(paramQQAppInterface, paramContext, localMessage);
    a(paramQQAppInterface, localMessage);
  }
  
  public void dealDraft(IMCoreAppRuntime paramIMCoreAppRuntime, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
      if (this.mDisplayTime <= getLastDraftTime())
      {
        QQMessageFacadeStub localQQMessageFacadeStub = paramIMCoreAppRuntime.getMessageFacade();
        if (localQQMessageFacadeStub != null) {
          a(paramIMCoreAppRuntime, paramMsgSummary, localQQMessageFacadeStub.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType()));
        }
      }
    }
  }
  
  public void extraUpdate(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, MsgSummary paramMsgSummary)
  {
    dealStatus(paramIMCoreAppRuntime);
    dealDraft(paramIMCoreAppRuntime, paramMsgSummary);
    super.extraUpdate(paramIMCoreAppRuntime, paramContext, paramMsgSummary);
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
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.RecentItemFilterMsgBoxData
 * JD-Core Version:    0.7.0.1
 */