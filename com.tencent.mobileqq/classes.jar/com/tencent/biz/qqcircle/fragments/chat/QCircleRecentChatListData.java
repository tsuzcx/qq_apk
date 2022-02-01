package com.tencent.biz.qqcircle.fragments.chat;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostChatHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.data.DraftSummaryInfoInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleBlankRecentChatListData;
import mqq.app.MobileQQ;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

public class QCircleRecentChatListData
  extends QCircleBlankRecentChatListData
  implements QCircleRecentDataInterface
{
  private static final String TAG = "QCircleRecentChatListData";
  private QQCirclePrivateMsgShow.UserPMGiftInfo mGiftInfo;
  private MessageRecord mMessageRecord;
  
  public QCircleRecentChatListData(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      this.mMessageRecord = paramMessageRecord;
      return;
    }
    throw new NullPointerException("QCircleRecentChatListData data is null");
  }
  
  public void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    paramBaseQQAppInterface = ((IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class)).getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
    if (paramBaseQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramBaseQQAppInterface.getSummary())) {
        return;
      }
      long l = paramBaseQQAppInterface.getTime();
      if (this.mDisplayTime > l) {
        return;
      }
      this.mDisplayTime = l;
      if (paramMsgSummary != null)
      {
        paramMsgSummary.bShowDraft = true;
        paramBaseQQAppInterface.getSummary();
      }
    }
  }
  
  public byte[] getGiftInfo()
  {
    QQCirclePrivateMsgShow.UserPMGiftInfo localUserPMGiftInfo = this.mGiftInfo;
    if ((localUserPMGiftInfo != null) && (localUserPMGiftInfo.get() != null)) {
      return ((QQCirclePrivateMsgShow.UserPMGiftInfo)this.mGiftInfo.get()).toByteArray();
    }
    return null;
  }
  
  public long getLastDraftTime()
  {
    return 0L;
  }
  
  public CharSequence getLastMsg()
  {
    return this.mLastMsg;
  }
  
  public long getLastMsgTime()
  {
    return this.mMessageRecord.time;
  }
  
  public CharSequence getMsgExtraInfo()
  {
    return this.mMsgExtroInfo;
  }
  
  public int getRecentUserType()
  {
    return this.mMessageRecord.istroop;
  }
  
  public String getRecentUserUin()
  {
    return this.mMessageRecord.senderuin;
  }
  
  public String getShowTime()
  {
    return this.mShowTime;
  }
  
  public String getTaskId()
  {
    return this.mMessageRecord.getExtInfoFromExtStr("key_qcircle_extra_info");
  }
  
  public void setGiftInfo(QQCirclePrivateMsgShow.UserPMGiftInfo paramUserPMGiftInfo)
  {
    this.mGiftInfo = paramUserPMGiftInfo;
  }
  
  public void setGiftInfo(byte[] paramArrayOfByte)
  {
    try
    {
      QQCirclePrivateMsgShow.UserPMGiftInfo localUserPMGiftInfo = new QQCirclePrivateMsgShow.UserPMGiftInfo();
      localUserPMGiftInfo.mergeFrom(paramArrayOfByte);
      setGiftInfo(localUserPMGiftInfo);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("QCircleRecentChatListData", 1, "setGiftInfoError", paramArrayOfByte);
    }
  }
  
  public void update()
  {
    update((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), MobileQQ.sMobileQQ.getApplicationContext());
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Message localMessage = ((IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class)).getLastMessage(getRecentUserUin(), getRecentUserType());
    this.mExtraInfoColor = 0;
    this.mMsgExtroInfo = null;
    if (localMessage != null)
    {
      this.mDisplayTime = localMessage.time;
      this.mUnreadNum = QCircleHostChatHelper.getUnReadNum(localMessage.frienduin, localMessage.istroop);
      if (QCircleHostChatHelper.isOneWayBoxConversation(localMessage)) {
        this.mUnreadFlag = 3;
      }
    }
    else
    {
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
    }
    MsgSummary localMsgSummary = super.getMsgSummaryTemp();
    super.buildMessageBody(localMessage, getRecentUserType(), paramBaseQQAppInterface, paramContext, localMsgSummary);
    this.mTitleName = HostDataTransUtils.getBuddyName(getRecentUserUin(), true);
    this.mAuthenIconId = 0;
    super.dealStatus(paramBaseQQAppInterface);
    dealDraft(paramBaseQQAppInterface, localMsgSummary);
    super.extraUpdate(paramBaseQQAppInterface, paramContext, localMsgSummary);
    if (QCircleHostConstants._AppSetting.enableTalkBack())
    {
      paramBaseQQAppInterface = new StringBuilder(24);
      paramBaseQQAppInterface.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        if (this.mUnreadNum == 1) {
          paramBaseQQAppInterface.append(paramContext.getResources().getString(2131699005));
        } else if (this.mUnreadNum == 2) {
          paramBaseQQAppInterface.append(paramContext.getResources().getString(2131699006));
        } else if (this.mUnreadNum > 0) {
          paramBaseQQAppInterface.append(paramContext.getResources().getString(2131699004, new Object[] { Integer.valueOf(this.mUnreadNum) }));
        }
      }
      if (this.mMsgExtroInfo != null)
      {
        paramContext = new StringBuilder();
        paramContext.append(this.mMsgExtroInfo);
        paramContext.append(",");
        paramBaseQQAppInterface.append(paramContext.toString());
      }
      paramBaseQQAppInterface.append(this.mLastMsg);
      paramBaseQQAppInterface.append(' ');
      paramBaseQQAppInterface.append(this.mShowTime);
      this.mContentDesc = paramBaseQQAppInterface.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.chat.QCircleRecentChatListData
 * JD-Core Version:    0.7.0.1
 */