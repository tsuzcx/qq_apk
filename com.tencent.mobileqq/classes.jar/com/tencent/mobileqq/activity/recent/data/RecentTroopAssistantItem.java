package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RecentTroopAssistantItem
  extends RecentBaseData
{
  private static String TAG = "RecentTroopAssistantItem";
  private TroopAssistantData mData;
  public long mTroopCreditLevel = 5L;
  
  public RecentTroopAssistantItem(TroopAssistantData paramTroopAssistantData)
  {
    if (paramTroopAssistantData != null)
    {
      this.mData = paramTroopAssistantData;
      this.mUnreadFlag = 3;
      return;
    }
    throw new NullPointerException("TroopAssistantData is null");
  }
  
  private void a()
  {
    if (AppSetting.e)
    {
      StringBuilder localStringBuilder1 = new StringBuilder(24);
      localStringBuilder1.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        if (this.mUnreadNum == 1)
        {
          localStringBuilder1.append("有一条未读");
        }
        else if (this.mUnreadNum == 2)
        {
          localStringBuilder1.append("有两条未读");
        }
        else if (this.mUnreadNum > 0)
        {
          localStringBuilder1.append("有");
          localStringBuilder1.append(this.mUnreadNum);
          localStringBuilder1.append("条未读");
        }
      }
      if (this.mMsgExtroInfo != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(this.mMsgExtroInfo);
        localStringBuilder2.append(",");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder1.append(this.mLastMsg);
      localStringBuilder1.append(' ');
      localStringBuilder1.append(this.mShowTime);
      this.mContentDesc = localStringBuilder1.toString();
    }
  }
  
  private void a(Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((paramMsgSummary.nState == 0) && ((!TextUtils.isEmpty(paramMsgSummary.strContent)) || (!TextUtils.isEmpty(paramMsgSummary.suffix))))
    {
      SpannableString localSpannableString = null;
      if (!TextUtils.isEmpty(paramMsgSummary.strContent))
      {
        String str = paramMsgSummary.strContent.toString();
        localObject = str;
        if (!TextUtils.isEmpty(paramMsgSummary.strPrefix))
        {
          localObject = str;
          if (TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) == 0) {
            localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());
          }
        }
      }
      else
      {
        localObject = paramMsgSummary.suffix.toString();
      }
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new ColorNickText(paramMsgSummary.strPrefix, 16).b();
      }
      paramMessage = ColorNickManager.a((String)localObject, paramMessage, 16, 3);
      Object localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessage);
      paramMsgSummary.strContent = new QQText((CharSequence)localObject, 3, 16);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (this.mIsGroupVideoNotify)
    {
      localObject = (TroopVideoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
      if ((localObject != null) && (((TroopVideoManager)localObject).a(getRecentUserUin()) == 2)) {
        this.mIsGroupVideoNotify = false;
      }
    }
    if ((this.mIsGroupVideoNotify) && (TextUtils.isEmpty(this.mMsgExtroInfo)))
    {
      this.mMsgExtroInfo = paramQQAppInterface.getApp().getString(2131895583);
      this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131168153);
    }
    if ((this.mIsGroupVideoNotify) && (!paramBoolean))
    {
      localObject = String.valueOf(paramLong);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopUtils.a(paramQQAppInterface, (String)localObject));
      ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      this.mTitleName = ContactUtils.a(paramQQAppInterface, paramString1, true);
      return;
    }
    this.mTitleName = paramString2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str;
    int i;
    Object localObject1;
    Message localMessage;
    TroopInfo localTroopInfo;
    MsgSummary localMsgSummary;
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      str = getRecentUserUin();
      i = getRecentUserType();
      localObject1 = paramQQAppInterface.getMessageFacade();
      Object localObject2 = null;
      if (localObject1 != null) {
        localMessage = ((QQMessageFacade)localObject1).getLastMessage(str, i);
      } else {
        localMessage = null;
      }
      if (localMessage != null)
      {
        this.mDisplayTime = localMessage.time;
        localObject1 = paramQQAppInterface.getConversationFacade();
        if (localObject1 != null) {
          this.mUnreadNum = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
        } else {
          this.mUnreadNum = 0;
        }
      }
      else
      {
        this.mDisplayTime = 0L;
        this.mUnreadNum = 0;
      }
      if ((TroopNotificationHelper.a(str)) || (TroopNotificationHelper.c(str)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "show TroopNotification orange mark.");
        }
        this.mMsgExtroInfo = BaseApplicationImpl.getContext().getString(2131917246);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
      }
      j = this.mMenuFlag;
      localObject1 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 != null) {
        localTroopInfo = ((TroopManager)localObject1).f(str);
      } else {
        localTroopInfo = null;
      }
      if (localTroopInfo != null)
      {
        localObject2 = localTroopInfo.getTroopDisplayName();
        localObject1 = localTroopInfo.troopmemo;
      }
      else
      {
        localObject1 = null;
      }
      this.mMenuFlag = (j & 0xFFFFF0FF | 0x100);
      a(paramQQAppInterface, str, (String)localObject2);
      localMsgSummary = getMsgSummaryTemp();
      if (localMsgSummary == null) {
        return;
      }
      if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
        localMessage.nickName = localMessage.senderuin;
      }
      buildMessageBody(localMessage, i, paramQQAppInterface, paramContext, localMsgSummary);
      a(localMessage, localMsgSummary);
      if ((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localMsgSummary.strContent = ((CharSequence)localObject2);
      }
      dealStatus(paramQQAppInterface);
      dealDraft(paramQQAppInterface, localMsgSummary);
      extraUpdate(paramQQAppInterface, paramContext, localMsgSummary);
    }
    try
    {
      l = Long.parseLong(getRecentUserUin());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label390:
      boolean bool;
      break label390;
    }
    l = 0L;
    this.mIsGroupVideo = paramQQAppInterface.getAVNotifyCenter().d(l);
    bool = this.mIsGroupVideoNotify;
    this.mIsGroupVideoNotify = paramQQAppInterface.getAVNotifyCenter().c(l);
    a(paramQQAppInterface, l, bool);
    if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localMessage != null) && (localMsgSummary != null) && (AnonymousChatHelper.c(localMessage))) {
      this.mLastMsg = localMsgSummary.a(paramContext, AnonymousChatHelper.d(localMessage), -1);
    }
    if (localTroopInfo != null)
    {
      this.mTroopCreditLevel = localTroopInfo.troopCreditLevel;
      if (this.mTroopCreditLevel == 0L) {
        this.mTroopCreditLevel = 5L;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("RecentTroopAssistantItem->update,");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(this.mTroopCreditLevel);
        QLog.i("troop.credit.act", 2, ((StringBuilder)localObject1).toString());
      }
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    this.mMenuFlag &= 0xFFFFFF0F;
    int j = this.mMenuFlag;
    if (paramQQAppInterface.o(str)) {
      i = 32;
    } else {
      i = 16;
    }
    this.mMenuFlag = (i | j);
    a();
    processUnReadNum(paramContext.getResources().getColor(2131168122), 999);
  }
  
  public long getFaceExtraFlag()
  {
    return this.mTroopCreditLevel;
  }
  
  public long getLastDraftTime()
  {
    return this.mData.lastdrafttime;
  }
  
  public long getLastMsgTime()
  {
    return this.mData.lastmsgtime;
  }
  
  public int getRecentUserType()
  {
    return 1;
  }
  
  public String getRecentUserUin()
  {
    return this.mData.troopUin;
  }
  
  public boolean isUnreadMsgNumInTabNum()
  {
    return false;
  }
  
  protected void processUnReadNum(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
      return;
    }
    super.processUnReadNum(paramInt1, paramInt2);
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem
 * JD-Core Version:    0.7.0.1
 */