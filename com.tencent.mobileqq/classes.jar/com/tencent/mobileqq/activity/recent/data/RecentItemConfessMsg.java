package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessShareHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import java.util.Locale;

public class RecentItemConfessMsg
  extends RecentBaseData
{
  public final ConfessInfo mConfessInfo = new ConfessInfo();
  public MessageRecord mMsg = null;
  public int mType = 0;
  public String mUin = "";
  public Message msg = null;
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      if ((this.mType == 1032) && (TextUtils.equals(this.mUin, AppConstants.CONFESS_FRD_REC_UIN)))
      {
        localMsgSummary = getMsgSummaryTemp();
        localObject2 = ContactUtils.a(paramQQAppInterface, this.mMsg.senderuin, true);
        localObject1 = localObject2;
        if (TextUtils.equals((CharSequence)localObject2, this.mMsg.senderuin))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.mMsg.msg2)) {
            localObject1 = this.mMsg.msg2;
          }
        }
        localMsgSummary.strContent = String.format(HardCodeUtil.a(2131713102), new Object[] { localObject1, this.mMsg.msg });
        this.mTitleName = HardCodeUtil.a(2131713096);
        this.mDisplayTime = this.mMsg.time;
        this.mUnreadNum = this.mMsg.longMsgCount;
        this.mUnreadFlag = 3;
        extraUpdate(paramQQAppInterface, paramContext, localMsgSummary);
        makeContentDesc();
        return;
      }
      if (this.msg == null) {
        return;
      }
      MsgSummary localMsgSummary = getMsgSummaryTemp();
      int i = this.mType;
      if (i == 1033)
      {
        localObject2 = ContactUtils.a(paramQQAppInterface, this.mUin, true);
        if (TextUtils.isEmpty(this.mConfessInfo.topic))
        {
          this.mTitleName = ((String)localObject2);
        }
        else
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((String)localObject2).length() > 7) {
              localObject1 = ConfessShareHelper.a((String)localObject2, 7.0F);
            }
          }
          this.mTitleName = String.format(Locale.getDefault(), "%s—%s", new Object[] { localObject1, this.mConfessInfo.topic });
        }
      }
      else if (i == 1034)
      {
        this.mTitleName = this.mConfessInfo.confessorNick;
        if (this.msg.msgtype == -2066)
        {
          localObject2 = paramQQAppInterface.getCurrentNickname();
          localObject1 = localObject2;
          if (((String)localObject2).length() <= 7) {
            break label383;
          }
          localObject1 = ConfessShareHelper.a((String)localObject2, 7.0F);
          break label383;
        }
      }
      else
      {
        this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUin, true);
      }
      Object localObject1 = "";
      label383:
      this.mUnreadNum = paramQQAppInterface.getConversationFacade().a(this.mUin, this.mType, this.mConfessInfo.topicId);
      this.mUnreadFlag = 1;
      this.mDisplayTime = this.msg.time;
      this.mMenuFlag = 1;
      this.mStatus = 0;
      Object localObject2 = this.msg;
      MsgUtils.a(paramContext, paramQQAppInterface, (Message)localObject2, ((Message)localObject2).istroop, localMsgSummary, (String)localObject1, false, false);
      localMsgSummary.bShowDraft = false;
      extraUpdate(paramQQAppInterface, paramContext, localMsgSummary);
      makeContentDesc();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MessageRecord paramMessageRecord)
  {
    this.mMsg = paramMessageRecord;
    paramMessageRecord = this.mMsg;
    if (paramMessageRecord == null)
    {
      this.mConfessInfo.reset();
      this.mUin = "";
      this.mType = 0;
      return;
    }
    if ((paramMessageRecord.istroop == 1032) && (TextUtils.equals(this.mMsg.frienduin, AppConstants.CONFESS_FRD_REC_UIN)))
    {
      this.mUin = AppConstants.CONFESS_FRD_REC_UIN;
      this.mType = 1032;
      return;
    }
    paramMessageRecord = this.mMsg.getExtInfoFromExtStr("ext_key_confess_info");
    this.mConfessInfo.parseFromJsonStr(paramMessageRecord);
    this.mUin = this.mMsg.senderuin;
    if (TextUtils.equals(this.mConfessInfo.confessorUinStr, paramString)) {
      this.mType = 1033;
    } else {
      this.mType = 1034;
    }
    if (TextUtils.isEmpty(this.mMsg.selfuin)) {
      this.mMsg.selfuin = paramString;
    }
    if (this.msg == null) {
      this.msg = new Message();
    }
    MessageRecord.copyMessageRecordBaseField(this.msg, this.mMsg);
    paramString = this.msg;
    paramString.istroop = this.mType;
    paramString.frienduin = this.mUin;
    paramString.emoRecentMsg = null;
    paramString.fileType = -1;
    paramQQAppInterface.getMessageFacade().a(this.msg);
  }
  
  public long getLastDraftTime()
  {
    return 0L;
  }
  
  public long getLastMsgTime()
  {
    MessageRecord localMessageRecord = this.mMsg;
    if (localMessageRecord == null) {
      return 0L;
    }
    return localMessageRecord.time;
  }
  
  public int getRecentUserType()
  {
    return this.mType;
  }
  
  public String getRecentUserUin()
  {
    return this.mUin;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg
 * JD-Core Version:    0.7.0.1
 */