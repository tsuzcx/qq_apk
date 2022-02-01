package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
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
  
  private StringBuilder a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(",").append(paramQQAppInterface.getApplication().getString(2131698859));
    int i = paramQQAppInterface.getConversationFacade().a(AppConstants.FILTER_MSG_UIN, 10012) + FilterMsgBoxUtil.a(paramQQAppInterface, paramMessage);
    if (i > 0) {
      localStringBuilder.append(",").append(String.format(paramQQAppInterface.getApplication().getString(2131719851), new Object[] { Integer.valueOf(i) }));
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
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary, DraftSummaryInfo paramDraftSummaryInfo)
  {
    Object localObject;
    if ((paramDraftSummaryInfo != null) && (!android.text.TextUtils.isEmpty(paramDraftSummaryInfo.getSummary())))
    {
      this.mDisplayTime = paramDraftSummaryInfo.getTime();
      paramMsgSummary.bShowDraft = true;
      paramDraftSummaryInfo = paramDraftSummaryInfo.getSummary();
      localObject = ((TempChatPluginManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(getRecentUserType());
      if (localObject == null) {
        break label102;
      }
      paramBaseQQAppInterface = ((AbstractTempChatPlugin)localObject).a(getRecentUserUin(), TempChatSource.SOURCE_FROM_MAG_TAB);
    }
    for (;;)
    {
      paramMsgSummary.mDraft = new QQText(paramBaseQQAppInterface + paramDraftSummaryInfo, 3, 16);
      return;
      label102:
      localObject = (Integer)TempMsgBoxUtil.a().get(Integer.valueOf(getRecentUserType()));
      if (localObject != null) {
        paramBaseQQAppInterface = String.format(paramBaseQQAppInterface.getApplication().getString(2131699290), new Object[] { paramBaseQQAppInterface.getApplication().getString(((Integer)localObject).intValue()) });
      } else {
        paramBaseQQAppInterface = "";
      }
    }
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
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage, int paramInt, MsgSummary paramMsgSummary)
  {
    paramMessage.prefixOfNickname = "";
    Object localObject;
    if (paramInt != 10012)
    {
      localObject = ((TempChatPluginManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(getRecentUserType());
      if (localObject == null) {
        break label162;
      }
      paramMsgSummary.prefixOfContent = ((AbstractTempChatPlugin)localObject).a(getRecentUserUin(), TempChatSource.SOURCE_FROM_MAG_TAB);
    }
    for (;;)
    {
      GameMsgUtil.a(paramQQAppInterface, paramMessage, paramInt, paramMsgSummary);
      MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, false, false);
      if (paramInt == 10012)
      {
        paramMsgSummary.strPrefix = "";
        paramQQAppInterface.getConversationFacade().d(AppConstants.FILTER_MSG_UIN, 10012, 0);
        paramInt = paramQQAppInterface.getConversationFacade().a(AppConstants.FILTER_MSG_UIN, 10012) + FilterMsgBoxUtil.a(paramQQAppInterface, paramMessage);
        if (paramInt == 0) {
          break;
        }
        paramMsgSummary.strContent = String.format(paramQQAppInterface.getApplication().getString(2131698860), new Object[] { Integer.valueOf(paramInt) });
      }
      return;
      label162:
      localObject = (Integer)TempMsgBoxUtil.a().get(Integer.valueOf(getRecentUserType()));
      if (localObject != null) {
        paramMsgSummary.prefixOfContent = String.format(paramQQAppInterface.getApplication().getString(2131699290), new Object[] { paramQQAppInterface.getApplication().getString(((Integer)localObject).intValue()) });
      }
    }
    paramMsgSummary.strContent = "";
  }
  
  private void a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (AppSetting.d)
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
  
  private void a(QQAppInterface paramQQAppInterface, Message paramMessage, String paramString)
  {
    ConversationFacade localConversationFacade;
    if (paramMessage != null)
    {
      this.mDisplayTime = paramMessage.time;
      localConversationFacade = paramQQAppInterface.getConversationFacade();
      if ((getRecentUserType() == 10007) && (!GameMsgUtil.a(paramQQAppInterface, paramString)))
      {
        this.mUnreadNum = 0;
        paramMessage.nickName = null;
      }
    }
    for (;;)
    {
      if (android.text.TextUtils.equals(paramString, AppConstants.FILTER_MSG_UIN)) {
        this.mDisplayTime = this.mData.lastmsgtime;
      }
      return;
      if (localConversationFacade != null)
      {
        this.mUnreadNum = localConversationFacade.a(paramMessage.frienduin, paramMessage.istroop);
        break;
      }
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
      this.mTitleName = paramQQAppInterface.getApplication().getString(2131698859);
      return;
    }
    this.mTitleName = TempMsgBoxUtil.a(paramQQAppInterface, this.mData);
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
  
  private StringBuilder b(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    paramMessage = new StringBuilder();
    paramMessage.append(this.mTitleName).append(",");
    if (this.mUnreadNum == 0)
    {
      if (this.mMsgExtroInfo != null) {
        paramMessage.append(this.mMsgExtroInfo).append(",");
      }
      Integer localInteger = (Integer)TempMsgBoxUtil.a().get(Integer.valueOf(getRecentUserType()));
      if (localInteger == null) {
        break label237;
      }
      paramQQAppInterface = String.format(paramQQAppInterface.getApplication().getString(2131699290), new Object[] { paramQQAppInterface.getApplication().getString(localInteger.intValue()) });
      paramMessage.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.mLastMsg.toString().replace(paramQQAppInterface, ""))).append(",");
    }
    for (;;)
    {
      paramMessage.append(this.mShowTime);
      return paramMessage;
      if (this.mUnreadNum == 1)
      {
        paramMessage.append(paramQQAppInterface.getApplication().getString(2131719746));
        break;
      }
      if (this.mUnreadNum == 2)
      {
        paramMessage.append(paramQQAppInterface.getApplication().getString(2131719747));
        break;
      }
      if (this.mUnreadNum <= 0) {
        break;
      }
      paramMessage.append(String.format(paramQQAppInterface.getApplication().getString(2131719745), new Object[] { Integer.valueOf(this.mUnreadNum) }));
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
    Message localMessage;
    String str;
    int i;
    Object localObject;
    do
    {
      return;
      localMessage = null;
      str = getRecentUserUin();
      i = getRecentUserType();
      localObject = paramQQAppInterface.getMessageFacade();
      if (localObject != null) {
        localMessage = ((QQMessageFacade)localObject).a(str, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentTempMsgBoxItem", 2, new Object[] { "getLastMessage: ", localMessage });
      }
      a(paramQQAppInterface, str, i);
      a(paramQQAppInterface, localMessage, str);
      a(paramQQAppInterface, paramContext, localMessage);
      a(str);
      localObject = getMsgSummaryTemp();
    } while (localObject == null);
    a(paramQQAppInterface, paramContext, localMessage, i, (MsgSummary)localObject);
    dealStatus(paramQQAppInterface);
    dealDraft(paramQQAppInterface, (MsgSummary)localObject);
    extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject);
    a();
    a(paramQQAppInterface, localMessage);
    GameMsgUtil.a(paramQQAppInterface, i, str);
  }
  
  public void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
      if (this.mDisplayTime <= getLastDraftTime())
      {
        QQMessageFacade localQQMessageFacade = ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade();
        if (localQQMessageFacade != null) {
          a(paramBaseQQAppInterface, paramMsgSummary, localQQMessageFacade.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType()));
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
    return "RecentTempMsgBoxItem{mData=" + this.mData + '}';
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.RecentTempMsgBoxItem
 * JD-Core Version:    0.7.0.1
 */