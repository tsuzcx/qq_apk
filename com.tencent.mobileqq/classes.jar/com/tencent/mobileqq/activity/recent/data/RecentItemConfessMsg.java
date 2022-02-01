package com.tencent.mobileqq.activity.recent.data;

import abwp;
import amtj;
import android.content.Context;
import android.text.TextUtils;
import apsk;
import bfwr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Locale;

public class RecentItemConfessMsg
  extends RecentBaseData
{
  public final ConfessInfo mConfessInfo = new ConfessInfo();
  public MessageRecord mMsg;
  public int mType;
  public String mUin = "";
  public QQMessageFacade.Message msg;
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      if ((this.mType == 1032) && (TextUtils.equals(this.mUin, AppConstants.CONFESS_FRD_REC_UIN)))
      {
        localObject2 = getMsgSummaryTemp();
        str = ContactUtils.getBuddyName(paramQQAppInterface, this.mMsg.senderuin, true);
        localObject1 = str;
        if (TextUtils.equals(str, this.mMsg.senderuin))
        {
          localObject1 = str;
          if (!TextUtils.isEmpty(this.mMsg.msg2)) {
            localObject1 = this.mMsg.msg2;
          }
        }
        ((MsgSummary)localObject2).strContent = String.format(amtj.a(2131712284), new Object[] { localObject1, this.mMsg.msg });
        this.mTitleName = amtj.a(2131712278);
        this.mDisplayTime = this.mMsg.time;
        this.mUnreadNum = this.mMsg.longMsgCount;
        this.mUnreadFlag = 3;
        extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
        makeContentDesc();
        return;
      }
    } while (this.msg == null);
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    String str = "";
    if (this.mType == 1033)
    {
      localObject2 = ContactUtils.getBuddyName(paramQQAppInterface, this.mUin, true);
      if (TextUtils.isEmpty(this.mConfessInfo.topic))
      {
        this.mTitleName = ((String)localObject2);
        localObject1 = str;
      }
    }
    for (;;)
    {
      this.mUnreadNum = paramQQAppInterface.getConversationFacade().a(this.mUin, this.mType, this.mConfessInfo.topicId);
      this.mUnreadFlag = 1;
      this.mDisplayTime = this.msg.time;
      this.mMenuFlag = 1;
      this.mStatus = 0;
      bfwr.a(paramContext, paramQQAppInterface, this.msg, this.msg.istroop, localMsgSummary, (String)localObject1, false, false);
      localMsgSummary.bShowDraft = false;
      extraUpdate(paramQQAppInterface, paramContext, localMsgSummary);
      makeContentDesc();
      return;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 7) {
          localObject1 = apsk.a((String)localObject2, 7.0F);
        }
      }
      this.mTitleName = String.format(Locale.getDefault(), "%s—%s", new Object[] { localObject1, this.mConfessInfo.topic });
      localObject1 = str;
      continue;
      if (this.mType == 1034)
      {
        this.mTitleName = this.mConfessInfo.confessorNick;
        localObject1 = str;
        if (this.msg.msgtype == -2066)
        {
          str = paramQQAppInterface.getCurrentNickname();
          localObject1 = str;
          if (str.length() > 7) {
            localObject1 = apsk.a(str, 7.0F);
          }
        }
      }
      else
      {
        this.mTitleName = ContactUtils.getBuddyName(paramQQAppInterface, this.mUin, true);
        localObject1 = str;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MessageRecord paramMessageRecord)
  {
    this.mMsg = paramMessageRecord;
    if (this.mMsg == null)
    {
      this.mConfessInfo.reset();
      this.mUin = "";
      this.mType = 0;
      return;
    }
    if ((this.mMsg.istroop == 1032) && (TextUtils.equals(this.mMsg.frienduin, AppConstants.CONFESS_FRD_REC_UIN)))
    {
      this.mUin = AppConstants.CONFESS_FRD_REC_UIN;
      this.mType = 1032;
      return;
    }
    paramMessageRecord = this.mMsg.getExtInfoFromExtStr("ext_key_confess_info");
    this.mConfessInfo.parseFromJsonStr(paramMessageRecord);
    this.mUin = this.mMsg.senderuin;
    if (TextUtils.equals(this.mConfessInfo.confessorUinStr, paramString)) {}
    for (this.mType = 1033;; this.mType = 1034)
    {
      if (TextUtils.isEmpty(this.mMsg.selfuin)) {
        this.mMsg.selfuin = paramString;
      }
      if (this.msg == null) {
        this.msg = new QQMessageFacade.Message();
      }
      MessageRecord.copyMessageRecordBaseField(this.msg, this.mMsg);
      this.msg.istroop = this.mType;
      this.msg.frienduin = this.mUin;
      this.msg.emoRecentMsg = null;
      this.msg.fileType = -1;
      paramQQAppInterface.getMessageFacade().decodeMsg(this.msg);
      return;
    }
  }
  
  public long getLastDraftTime()
  {
    return 0L;
  }
  
  public long getLastMsgTime()
  {
    if (this.mMsg == null) {
      return 0L;
    }
    return this.mMsg.time;
  }
  
  public int getRecentUserType()
  {
    return this.mType;
  }
  
  public String getRecentUserUin()
  {
    return this.mUin;
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg
 * JD-Core Version:    0.7.0.1
 */