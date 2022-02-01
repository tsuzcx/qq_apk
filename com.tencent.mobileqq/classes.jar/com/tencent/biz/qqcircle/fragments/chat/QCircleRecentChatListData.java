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
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import cooperation.qqcircle.chat.QCircleBlankRecentChatListData;
import mqq.app.MobileQQ;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

public class QCircleRecentChatListData
  extends QCircleBlankRecentChatListData
  implements QCircleRecentDataInterface
{
  private QQCirclePrivateMsgShow.UserPMGiftInfo mGiftInfo;
  private MessageRecord mMessageRecord;
  
  public QCircleRecentChatListData(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("QCircleRecentChatListData data is null");
    }
    this.mMessageRecord = paramMessageRecord;
  }
  
  public void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    paramBaseQQAppInterface = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class);
    if (paramBaseQQAppInterface == null) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
          paramBaseQQAppInterface = paramBaseQQAppInterface.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
        } while ((paramBaseQQAppInterface == null) || (TextUtils.isEmpty(paramBaseQQAppInterface.getSummary())));
        l = paramBaseQQAppInterface.getTime();
      } while (this.mDisplayTime > l);
      this.mDisplayTime = l;
    } while (paramMsgSummary == null);
    paramMsgSummary.bShowDraft = true;
    paramBaseQQAppInterface.getSummary();
  }
  
  public QQCirclePrivateMsgShow.UserPMGiftInfo getGiftInfo()
  {
    return this.mGiftInfo;
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
  
  public void update()
  {
    update((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), MobileQQ.sMobileQQ.getApplicationContext());
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class);
    if (localObject != null) {}
    for (localObject = (Message)((IMessageFacade)localObject).getLastMessage(getRecentUserUin(), getRecentUserType());; localObject = null)
    {
      this.mExtraInfoColor = 0;
      this.mMsgExtroInfo = null;
      if (localObject != null)
      {
        this.mDisplayTime = ((Message)localObject).time;
        this.mUnreadNum = QCircleHostChatHelper.getUnReadNum(((Message)localObject).frienduin, ((Message)localObject).istroop);
        if (QCircleHostChatHelper.isOneWayBoxConversation((MessageRecord)localObject)) {
          this.mUnreadFlag = 3;
        }
        MsgSummary localMsgSummary = super.getMsgSummaryTemp();
        super.buildMessageBody((IMCoreMessageStub)localObject, getRecentUserType(), paramBaseQQAppInterface, paramContext, localMsgSummary);
        this.mTitleName = HostDataTransUtils.getBuddyName(getRecentUserUin(), true);
        this.mAuthenIconId = 0;
        super.dealStatus(paramBaseQQAppInterface);
        dealDraft(paramBaseQQAppInterface, localMsgSummary);
        super.extraUpdate(paramBaseQQAppInterface, paramContext, localMsgSummary);
        if (!QCircleHostConstants._AppSetting.enableTalkBack()) {
          break;
        }
        paramBaseQQAppInterface = new StringBuilder(24);
        paramBaseQQAppInterface.append(this.mTitleName);
        if (this.mUnreadNum != 0) {
          break label251;
        }
      }
      for (;;)
      {
        if (this.mMsgExtroInfo != null) {
          paramBaseQQAppInterface.append(this.mMsgExtroInfo + ",");
        }
        paramBaseQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
        this.mContentDesc = paramBaseQQAppInterface.toString();
        return;
        this.mUnreadNum = 0;
        this.mDisplayTime = 0L;
        break;
        label251:
        if (this.mUnreadNum == 1) {
          paramBaseQQAppInterface.append(paramContext.getResources().getString(2131698926));
        } else if (this.mUnreadNum == 2) {
          paramBaseQQAppInterface.append(paramContext.getResources().getString(2131698927));
        } else if (this.mUnreadNum > 0) {
          paramBaseQQAppInterface.append(paramContext.getResources().getString(2131698925, new Object[] { Integer.valueOf(this.mUnreadNum) }));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.chat.QCircleRecentChatListData
 * JD-Core Version:    0.7.0.1
 */