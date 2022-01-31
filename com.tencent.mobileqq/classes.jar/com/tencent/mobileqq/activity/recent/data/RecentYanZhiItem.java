package com.tencent.mobileqq.activity.recent.data;

import abta;
import android.content.Context;
import com.tencent.common.config.AppSetting;
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
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject1 = paramQQAppInterface.a().b(this.mData.senderuin, this.mData.istroop);
    if ((localObject1 instanceof MessageForYanZhi)) {}
    for (localObject1 = (MessageForYanZhi)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.msg_box.RecentYanZhiItem", 2, "MessageForYanZhi == null");
        return;
      }
      ((MessageForYanZhi)localObject1).parse();
      this.mTitleName = paramContext.getString(2131694562);
      Object localObject2 = paramQQAppInterface.a();
      if (localObject2 != null)
      {
        this.mUnreadNum = ((abta)localObject2).a(((MessageForYanZhi)localObject1).frienduin, ((MessageForYanZhi)localObject1).istroop);
        if (this.mUnreadNum <= 1) {}
      }
      for (this.mUnreadNum = 1;; this.mUnreadNum = 0)
      {
        this.mUnreadFlag = 1;
        this.mDisplayTime = ((MessageForYanZhi)localObject1).time;
        localObject2 = a();
        ((MsgSummary)localObject2).strContent = (((MessageForYanZhi)localObject1).likeCount + paramContext.getString(2131694563));
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
        if (!AppSetting.c) {
          break;
        }
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.mTitleName);
        if (this.mMsgExtroInfo != null) {
          paramQQAppInterface.append(this.mMsgExtroInfo + ",");
        }
        paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentYanZhiItem
 * JD-Core Version:    0.7.0.1
 */