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
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
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
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentDatingBoxItem data is null");
    }
    this.messageRecord = paramMessageRecord;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    Object localObject2 = paramQQAppInterface.getConversationFacade();
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(getRecentUserUin(), getRecentUserType());; localObject1 = null)
    {
      label78:
      MsgSummary localMsgSummary;
      if (localObject1 != null)
      {
        this.mDisplayTime = ((Message)localObject1).time;
        if ((localObject2 != null) && (localObject1 != null))
        {
          this.mUnreadNum = ((ConversationFacade)localObject2).a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
          if (UinTypeUtil.a((MessageRecord)localObject1)) {
            this.mUnreadFlag = 3;
          }
          localMsgSummary = super.getMsgSummaryTemp();
          this.mHasFlowerMsg = false;
          this.mExtraInfoColor = 0;
          this.mMsgExtroInfo = null;
          if (!DatingUtil.a(paramQQAppInterface, getRecentUserUin(), 1001)) {
            break label366;
          }
          this.mMsgExtroInfo = paramContext.getResources().getString(2131693215);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
          if (localObject2 != null) {
            localMsgSummary.strContent = ((ConversationFacade)localObject2).a(getRecentUserUin(), 1001, paramContext.getResources().getString(2131693214), 0);
          }
          label171:
          localObject2 = ContactUtils.q(paramQQAppInterface, getRecentUserUin());
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = ContactUtils.c(paramQQAppInterface, getRecentUserUin(), false);
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
              break label430;
            }
          }
        }
      }
      for (;;)
      {
        if (this.mMsgExtroInfo != null) {
          paramQQAppInterface.append(this.mMsgExtroInfo + ",");
        }
        paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
        return;
        this.mUnreadNum = 0;
        break;
        this.mUnreadNum = 0;
        this.mDisplayTime = 0L;
        break label78;
        label366:
        if (DatingUtil.b(paramQQAppInterface, getRecentUserUin(), 1001))
        {
          this.mHasFlowerMsg = true;
          this.mMsgExtroInfo = paramContext.getResources().getString(2131694336);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
          break label171;
        }
        super.buildMessageBody((IMCoreMessageStub)localObject1, getRecentUserType(), paramQQAppInterface, paramContext, localMsgSummary);
        break label171;
        label430:
        if (this.mUnreadNum == 1) {
          paramQQAppInterface.append("有一条未读");
        } else if (this.mUnreadNum == 2) {
          paramQQAppInterface.append("有两条未读");
        } else if (this.mUnreadNum > 0) {
          paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.bShowDraft = false;
          paramMsgSummary.mDraft = null;
          paramQQAppInterface = paramQQAppInterface.getMessageFacade();
        } while (paramQQAppInterface == null);
        paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (this.mDisplayTime > l);
    this.mDisplayTime = l;
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public boolean a(FansEntity paramFansEntity)
  {
    boolean bool = false;
    if ((this.age != paramFansEntity.age) || (this.gender != paramFansEntity.gender) || (this.career != paramFansEntity.career) || (this.constellation != paramFansEntity.constellation) || (this.vip != paramFansEntity.vip) || (this.charmIcon != paramFansEntity.charmIcon) || (this.charmLevel != paramFansEntity.charmLevel) || (this.commonId != paramFansEntity.commonId) || (!Utils.a(this.common, paramFansEntity.common)))
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
      bool = true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.msg_box", 4, "haveChange:" + bool + ",FansEntity:" + paramFansEntity.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem
 * JD-Core Version:    0.7.0.1
 */