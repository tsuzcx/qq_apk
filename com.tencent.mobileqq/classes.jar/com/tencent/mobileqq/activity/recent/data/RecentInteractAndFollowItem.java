package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RecentInteractAndFollowItem
  extends RecentMsgBoxItem
{
  public static final String TAG = "Q.msg_box.RecentInteractAndFollowItem";
  private int messageType = 0;
  
  public RecentInteractAndFollowItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  public int a()
  {
    if (this.messageType == 3) {
      return this.mUnreadNum;
    }
    return 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      Object localObject = paramQQAppInterface.getMessageFacade().r(this.mData.senderuin, this.mData.istroop);
      MessageForInteractAndFollow localMessageForInteractAndFollow = null;
      if ((localObject instanceof MessageForInteractAndFollow)) {
        localMessageForInteractAndFollow = (MessageForInteractAndFollow)localObject;
      }
      if (localMessageForInteractAndFollow == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg_box.RecentInteractAndFollowItem", 2, "messageForInteractAndFollow == null");
        }
        return;
      }
      localMessageForInteractAndFollow.parse();
      this.messageType = localMessageForInteractAndFollow.type;
      if (localMessageForInteractAndFollow.type == 1)
      {
        this.mTitleName = paramContext.getString(2131891937);
      }
      else if (localMessageForInteractAndFollow.type == 2)
      {
        this.mTitleName = paramContext.getString(2131891936);
      }
      else
      {
        if (localMessageForInteractAndFollow.type != 3) {
          break label386;
        }
        this.mTitleName = paramContext.getString(2131891938);
      }
      this.mUnreadFlag = 3;
      this.mDisplayTime = localMessageForInteractAndFollow.timeStamp;
      localObject = paramQQAppInterface.getConversationFacade();
      if (localObject != null) {
        this.mUnreadNum = ((ConversationFacade)localObject).a(localMessageForInteractAndFollow.frienduin, localMessageForInteractAndFollow.istroop);
      } else {
        this.mUnreadNum = 0;
      }
      localObject = getMsgSummaryTemp();
      ((MsgSummary)localObject).strContent = localMessageForInteractAndFollow.context;
      extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject);
      if (AppSetting.e)
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
      return;
      label386:
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("RecentInteractAndFollowItem, type  =");
        paramQQAppInterface.append(localMessageForInteractAndFollow.type);
        QLog.i("Q.msg_box.RecentInteractAndFollowItem", 2, paramQQAppInterface.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentInteractAndFollowItem
 * JD-Core Version:    0.7.0.1
 */