package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentSayHelloListItem
  extends RecentBaseData
{
  public int age = -1;
  public int career = -1;
  public boolean charmIcon = false;
  public int charmLevel;
  public String common;
  public int commonId;
  public int constellation = -1;
  public int gender = -1;
  public boolean haveInitFlag = false;
  public boolean mHasFlowerMsg = false;
  MessageRecord messageRecord;
  public int vip = -1;
  
  public RecentSayHelloListItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      this.messageRecord = paramMessageRecord;
      return;
    }
    throw new NullPointerException("RecentDatingBoxItem data is null");
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    Object localObject2 = paramQQAppInterface.getConversationFacade();
    if (localObject1 != null) {
      localObject1 = ((QQMessageFacade)localObject1).getLastMessage(getRecentUserUin(), getRecentUserType());
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      this.mDisplayTime = ((Message)localObject1).time;
      if ((localObject2 != null) && (localObject1 != null)) {
        this.mUnreadNum = ((ConversationFacade)localObject2).a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
      } else {
        this.mUnreadNum = 0;
      }
      if (UinTypeUtil.a((MessageRecord)localObject1)) {
        this.mUnreadFlag = 3;
      }
    }
    else
    {
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
    }
    MsgSummary localMsgSummary = super.getMsgSummaryTemp();
    this.mHasFlowerMsg = false;
    this.mExtraInfoColor = 0;
    this.mMsgExtroInfo = null;
    if (DatingUtil.a(paramQQAppInterface, getRecentUserUin(), 1001))
    {
      this.mMsgExtroInfo = paramContext.getResources().getString(2131693169);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
      if (localObject2 != null) {
        localMsgSummary.strContent = ((ConversationFacade)localObject2).a(getRecentUserUin(), 1001, paramContext.getResources().getString(2131693168), 0);
      }
    }
    else if (DatingUtil.b(paramQQAppInterface, getRecentUserUin(), 1001))
    {
      this.mHasFlowerMsg = true;
      this.mMsgExtroInfo = paramContext.getResources().getString(2131694301);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
    }
    else
    {
      super.buildMessageBody((Message)localObject1, getRecentUserType(), paramQQAppInterface, paramContext, localMsgSummary);
    }
    localObject2 = ContactUtils.g(paramQQAppInterface, getRecentUserUin());
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ContactUtils.a(paramQQAppInterface, getRecentUserUin(), false);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = getRecentUserUin();
    }
    this.mTitleName = ((String)localObject2);
    this.mAuthenIconId = 0;
    super.dealStatus(paramQQAppInterface);
    a(paramQQAppInterface, localMsgSummary);
    super.extraUpdate(paramQQAppInterface, paramContext, localMsgSummary);
    if (AppSetting.d)
    {
      paramQQAppInterface = new StringBuilder(24);
      paramQQAppInterface.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        if (this.mUnreadNum == 1)
        {
          paramQQAppInterface.append("有一条未读");
        }
        else if (this.mUnreadNum == 2)
        {
          paramQQAppInterface.append("有两条未读");
        }
        else if (this.mUnreadNum > 0)
        {
          paramQQAppInterface.append("有");
          paramQQAppInterface.append(this.mUnreadNum);
          paramQQAppInterface.append("条未读");
        }
      }
      if (this.mMsgExtroInfo != null)
      {
        paramContext = new StringBuilder();
        paramContext.append(this.mMsgExtroInfo);
        paramContext.append(",");
        paramQQAppInterface.append(paramContext.toString());
      }
      paramQQAppInterface.append(this.mLastMsg);
      paramQQAppInterface.append(' ');
      paramQQAppInterface.append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.bShowDraft = false;
    paramMsgSummary.mDraft = null;
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramQQAppInterface.getSummary())) {
        return;
      }
      long l = paramQQAppInterface.getTime();
      if (this.mDisplayTime > l) {
        return;
      }
      this.mDisplayTime = l;
      paramMsgSummary.bShowDraft = true;
      paramMsgSummary.mDraft = new QQText(paramQQAppInterface.getSummary(), 3, 16);
    }
  }
  
  public boolean a(FansEntity paramFansEntity)
  {
    int i = this.age;
    int j = paramFansEntity.age;
    boolean bool = true;
    if ((i == j) && (this.gender == paramFansEntity.gender) && (this.career == paramFansEntity.career) && (this.constellation == paramFansEntity.constellation) && (this.vip == paramFansEntity.vip) && (this.charmIcon == paramFansEntity.charmIcon) && (this.charmLevel == paramFansEntity.charmLevel) && (this.commonId == paramFansEntity.commonId) && (Utils.a(this.common, paramFansEntity.common)))
    {
      bool = false;
    }
    else
    {
      this.age = paramFansEntity.age;
      this.gender = paramFansEntity.gender;
      this.career = paramFansEntity.career;
      this.constellation = paramFansEntity.constellation;
      this.vip = paramFansEntity.vip;
      this.charmIcon = paramFansEntity.charmIcon;
      this.haveInitFlag = true;
      this.charmLevel = paramFansEntity.charmLevel;
      this.commonId = paramFansEntity.commonId;
      this.common = paramFansEntity.common;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("haveChange:");
      localStringBuilder.append(bool);
      localStringBuilder.append(",FansEntity:");
      localStringBuilder.append(paramFansEntity.toString());
      QLog.d("Q.msg_box", 4, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramMsgSummary);
    }
  }
  
  public long getLastDraftTime()
  {
    return 0L;
  }
  
  public long getLastMsgTime()
  {
    return this.messageRecord.time;
  }
  
  public int getRecentUserType()
  {
    return this.messageRecord.istroop;
  }
  
  public String getRecentUserUin()
  {
    return this.messageRecord.senderuin;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem
 * JD-Core Version:    0.7.0.1
 */