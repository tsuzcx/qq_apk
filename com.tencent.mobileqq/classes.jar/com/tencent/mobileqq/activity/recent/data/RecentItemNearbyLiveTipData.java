package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RecentItemNearbyLiveTipData
  extends RecentMsgBoxItem
{
  public MessageForNearbyLiveTip nearbyLiveTipMsg;
  
  public RecentItemNearbyLiveTipData(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
    this.mMenuFlag |= 0x200000;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      Message localMessage = null;
      Object localObject = paramQQAppInterface.getMessageFacade();
      ConversationFacade localConversationFacade = paramQQAppInterface.getConversationFacade();
      if (localObject != null) {
        localMessage = ((QQMessageFacade)localObject).getLastMessage(this.mData.senderuin, this.mData.istroop);
      }
      localObject = getMsgSummaryTemp();
      if (localMessage == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby.tag_nearby_live_tip", 2, "RecentItemNearbyLiveTipData, msg = null");
        }
        return;
      }
      this.mDisplayTime = localMessage.time;
      this.nearbyLiveTipMsg = ((MessageForNearbyLiveTip)paramQQAppInterface.getMessageFacade().a(localMessage.senderuin, localMessage.istroop, localMessage.uniseq));
      MessageForNearbyLiveTip localMessageForNearbyLiveTip = this.nearbyLiveTipMsg;
      if (localMessageForNearbyLiveTip == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby.tag_nearby_live_tip", 2, "RecentItemNearbyLiveTipData, nearbyLiveTipMsg = null");
        }
        return;
      }
      localMessageForNearbyLiveTip.parse();
      this.mTitleName = this.nearbyLiveTipMsg.nickName;
      ((MsgSummary)localObject).strContent = this.nearbyLiveTipMsg.msg;
      if (localConversationFacade != null) {
        this.mUnreadNum = localConversationFacade.a(localMessage.frienduin, localMessage.istroop);
      } else {
        this.mUnreadNum = 0;
      }
      if (bW_().equals("1822701914")) {
        this.mUnreadFlag = 3;
      }
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
    }
  }
  
  public String bW_()
  {
    String str = this.mData.senderuin;
    try
    {
      long l1 = Long.valueOf(str).longValue();
      Object localObject = str;
      if (l1 > AppConstants.NOW_LIVE_TIP_UIN_BASE)
      {
        long l2 = AppConstants.NOW_LIVE_TIP_UIN_BASE;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(l1 - l2);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData
 * JD-Core Version:    0.7.0.1
 */