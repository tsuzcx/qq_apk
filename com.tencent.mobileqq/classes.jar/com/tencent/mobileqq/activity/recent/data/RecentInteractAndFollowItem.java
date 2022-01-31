package com.tencent.mobileqq.activity.recent.data;

import akaq;
import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RecentInteractAndFollowItem
  extends RecentMsgBoxItem
{
  public static final String TAG = "Q.msg_box.RecentInteractAndFollowItem";
  
  public RecentInteractAndFollowItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject1 = paramQQAppInterface.a().b(this.mData.senderuin, this.mData.istroop);
    if ((localObject1 instanceof MessageForInteractAndFollow)) {}
    for (localObject1 = (MessageForInteractAndFollow)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.msg_box.RecentInteractAndFollowItem", 2, "messageForInteractAndFollow == null");
        return;
      }
      ((MessageForInteractAndFollow)localObject1).parse();
      if (((MessageForInteractAndFollow)localObject1).type == 1)
      {
        this.mTitleName = paramContext.getString(2131628747);
        label84:
        this.mUnreadFlag = 3;
        this.mDisplayTime = ((MessageForInteractAndFollow)localObject1).timeStamp;
        Object localObject2 = paramQQAppInterface.a();
        if (localObject2 == null) {
          break label321;
        }
        this.mUnreadNum = ((akaq)localObject2).a(((MessageForInteractAndFollow)localObject1).frienduin, ((MessageForInteractAndFollow)localObject1).istroop);
        label125:
        localObject2 = a();
        ((MsgSummary)localObject2).strContent = ((MessageForInteractAndFollow)localObject1).context;
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
        if (!AppSetting.c) {
          break;
        }
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.mTitleName);
        if (this.mUnreadNum != 0) {
          break label329;
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
        if (((MessageForInteractAndFollow)localObject1).type == 2)
        {
          this.mTitleName = paramContext.getString(2131628746);
          break label84;
        }
        if (((MessageForInteractAndFollow)localObject1).type == 3)
        {
          this.mTitleName = paramContext.getString(2131628748);
          break label84;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.msg_box.RecentInteractAndFollowItem", 2, "RecentInteractAndFollowItem, type  =" + ((MessageForInteractAndFollow)localObject1).type);
        return;
        label321:
        this.mUnreadNum = 0;
        break label125;
        label329:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentInteractAndFollowItem
 * JD-Core Version:    0.7.0.1
 */