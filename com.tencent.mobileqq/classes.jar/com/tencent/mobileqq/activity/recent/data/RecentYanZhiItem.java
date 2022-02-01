package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForYanZhi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RecentYanZhiItem
  extends RecentMsgBoxItem
{
  public static final String TAG = "Q.msg_box.RecentYanZhiItem";
  
  public RecentYanZhiItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      Object localObject = paramQQAppInterface.getMessageFacade().r(this.mData.senderuin, this.mData.istroop);
      MessageForYanZhi localMessageForYanZhi = null;
      if ((localObject instanceof MessageForYanZhi)) {
        localMessageForYanZhi = (MessageForYanZhi)localObject;
      }
      if (localMessageForYanZhi == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg_box.RecentYanZhiItem", 2, "MessageForYanZhi == null");
        }
        return;
      }
      localMessageForYanZhi.parse();
      this.mTitleName = paramContext.getString(2131891940);
      localObject = paramQQAppInterface.getConversationFacade();
      if (localObject != null)
      {
        this.mUnreadNum = ((ConversationFacade)localObject).a(localMessageForYanZhi.frienduin, localMessageForYanZhi.istroop);
        if (this.mUnreadNum > 1) {
          this.mUnreadNum = 1;
        }
      }
      else
      {
        this.mUnreadNum = 0;
      }
      this.mUnreadFlag = 1;
      this.mDisplayTime = localMessageForYanZhi.time;
      localObject = getMsgSummaryTemp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localMessageForYanZhi.likeCount);
      localStringBuilder.append(paramContext.getString(2131891941));
      ((MsgSummary)localObject).strContent = localStringBuilder.toString();
      extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject);
      if (AppSetting.e)
      {
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.mTitleName);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentYanZhiItem
 * JD-Core Version:    0.7.0.1
 */