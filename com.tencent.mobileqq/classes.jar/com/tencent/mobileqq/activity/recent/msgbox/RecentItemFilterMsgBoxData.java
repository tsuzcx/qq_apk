package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.MsgUtils;
import java.util.Map;
import mqq.app.MobileQQ;

public class RecentItemFilterMsgBoxData
  extends AbsRecentUserBusinessBaseData
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
  
  private void a(Message paramMessage)
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
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramQQAppInterface = QCallFacade.a(paramQQAppInterface, paramMessage.frienduin, paramMessage.istroop, this.mUnreadNum, paramMessage);
      this.mUnreadNum += paramQQAppInterface.a();
      if (paramQQAppInterface.a() > 0)
      {
        this.mMsgExtroInfo = paramQQAppInterface.a();
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (AppSetting.d)
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
        paramMessage.append(paramQQAppInterface.getApplication().getString(2131719746));
      } else if (this.mUnreadNum == 2) {
        paramMessage.append(paramQQAppInterface.getApplication().getString(2131719747));
      } else if (this.mUnreadNum > 0) {
        paramMessage.append(String.format(paramQQAppInterface.getApplication().getString(2131719745), new Object[] { Integer.valueOf(this.mUnreadNum) }));
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary, DraftSummaryInfo paramDraftSummaryInfo)
  {
    Object localObject;
    if ((paramDraftSummaryInfo != null) && (!android.text.TextUtils.isEmpty(paramDraftSummaryInfo.getSummary())))
    {
      this.mDisplayTime = paramDraftSummaryInfo.getTime();
      paramMsgSummary.bShowDraft = true;
      paramDraftSummaryInfo = paramDraftSummaryInfo.getSummary();
      localObject = ((TempChatPluginManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(getRecentUserType());
      if (localObject == null) {
        break label102;
      }
      paramQQAppInterface = ((AbstractTempChatPlugin)localObject).a(getRecentUserUin(), TempChatSource.SOURCE_FROM_MAG_TAB);
    }
    for (;;)
    {
      paramMsgSummary.mDraft = new QQText(paramQQAppInterface + paramDraftSummaryInfo, 3, 16);
      return;
      label102:
      localObject = (Integer)TempMsgBoxUtil.a().get(Integer.valueOf(getRecentUserType()));
      if (localObject != null) {
        paramQQAppInterface = String.format(paramQQAppInterface.getApplication().getString(2131699290), new Object[] { paramQQAppInterface.getApplication().getString(((Integer)localObject).intValue()) });
      } else {
        paramQQAppInterface = "";
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    this.mTitleName = TempMsgBoxUtil.a(paramQQAppInterface, this.mData);
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage)
  {
    int i = getRecentUserType();
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    if (localMsgSummary == null) {
      return;
    }
    Integer localInteger = (Integer)TempMsgBoxUtil.a().get(Integer.valueOf(getRecentUserType()));
    if (localInteger != null) {
      localMsgSummary.prefixOfContent = String.format(paramQQAppInterface.getApplication().getString(2131699290), new Object[] { paramQQAppInterface.getApplication().getString(localInteger.intValue()) });
    }
    MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, i, localMsgSummary, false, false);
    a(paramQQAppInterface, paramContext, localMsgSummary);
  }
  
  private void b(QQAppInterface paramQQAppInterface, Message paramMessage)
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
  
  private void c()
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
  
  public RecentUser a()
  {
    return this.mData;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Message localMessage = null;
    String str = getRecentUserUin();
    int i = getRecentUserType();
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null) {
      localMessage = localQQMessageFacade.a(str, i);
    }
    b(paramQQAppInterface, localMessage);
    a(paramQQAppInterface, paramContext, localMessage);
    a();
    b(paramQQAppInterface);
    c();
    a(localMessage);
    b(paramQQAppInterface, paramContext, localMessage);
    a(paramQQAppInterface, localMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    a(paramQQAppInterface);
    a(paramQQAppInterface, paramMsgSummary);
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
      if (this.mDisplayTime <= getLastDraftTime())
      {
        QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
        if (localQQMessageFacade != null) {
          a(paramQQAppInterface, paramMsgSummary, localQQMessageFacade.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType()));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.RecentItemFilterMsgBoxData
 * JD-Core Version:    0.7.0.1
 */