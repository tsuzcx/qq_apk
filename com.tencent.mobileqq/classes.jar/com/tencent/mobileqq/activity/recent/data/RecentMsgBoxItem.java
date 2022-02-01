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
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.qphone.base.util.QLog;

public class RecentMsgBoxItem
  extends RecentBaseData
{
  public MessageRecord mData;
  public int mFromFlag;
  public boolean mHasFlowerMsg = false;
  
  public RecentMsgBoxItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentDatingBoxItem data is null");
    }
    this.mData = paramMessageRecord;
  }
  
  public String a()
  {
    return this.mData.senderuin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label273:
    label370:
    do
    {
      return;
      localObject1 = null;
      localObject2 = paramQQAppInterface.getMessageFacade();
      ConversationFacade localConversationFacade = paramQQAppInterface.getConversationFacade();
      if (localObject2 != null)
      {
        localObject2 = ((QQMessageFacade)localObject2).a(getRecentUserUin(), getRecentUserType());
        localObject3 = paramQQAppInterface.getMessageFacade().a(((Message)localObject2).senderuin, ((Message)localObject2).istroop, ((Message)localObject2).uniseq);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          this.mData = ((MessageRecord)localObject3);
          localObject1 = localObject2;
        }
      }
      if (localObject1 == null) {
        break label542;
      }
      this.mDisplayTime = ((Message)localObject1).time;
      if (localConversationFacade == null) {
        break;
      }
      this.mUnreadNum = localConversationFacade.a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
      if ((localObject1 != null) && (UinTypeUtil.a((MessageRecord)localObject1))) {
        this.mUnreadFlag = 3;
      }
      localObject3 = getMsgSummaryTemp();
      this.mHasFlowerMsg = false;
      if (localObject1 != null)
      {
        if (!DatingUtil.a(paramQQAppInterface, ((Message)localObject1).senderuin, ((Message)localObject1).istroop)) {
          break label555;
        }
        this.mMsgExtroInfo = paramContext.getResources().getString(2131693215);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
        if (localConversationFacade != null) {
          ((MsgSummary)localObject3).strContent = localConversationFacade.a(getRecentUserUin(), 1001, paramContext.getResources().getString(2131693214), 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_boxitem", 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",HasUnreadRedPacketMsg");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_boxitem", 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",unreadNum:" + this.mUnreadNum);
      }
      if ((localObject1 == null) || (((Message)localObject1).istroop != 1001) || (!MiniCardManager.a(getRecentUserUin()))) {
        break label677;
      }
      localObject2 = MiniCardManager.a(getRecentUserUin()).nick.get();
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
      dealStatus(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject3);
      extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
    } while (!AppSetting.d);
    paramQQAppInterface = new StringBuilder(24);
    paramQQAppInterface.append(this.mTitleName);
    if (this.mUnreadNum == 0) {}
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
      label542:
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
      break;
      label555:
      if (DatingUtil.b(paramQQAppInterface, ((Message)localObject1).senderuin, ((Message)localObject1).istroop))
      {
        this.mHasFlowerMsg = true;
        this.mMsgExtroInfo = paramContext.getResources().getString(2131694336);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
        if (!QLog.isColorLevel()) {
          break label273;
        }
        QLog.d("Q.msg_boxitem", 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",HasUnreadGiftMsg");
        break label273;
      }
      this.mMsgExtroInfo = "";
      buildMessageBody((IMCoreMessageStub)localObject1, getRecentUserType(), paramQQAppInterface, paramContext, (MsgSummary)localObject3);
      break label273;
      label677:
      localObject2 = ContactUtils.q(paramQQAppInterface, getRecentUserUin());
      break label370;
      if (this.mUnreadNum == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
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
    return this.mData.time;
  }
  
  public int getRecentUserType()
  {
    return this.mData.istroop;
  }
  
  public String getRecentUserUin()
  {
    return this.mData.senderuin;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem
 * JD-Core Version:    0.7.0.1
 */