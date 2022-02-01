package com.tencent.mobileqq.activity.recent.data;

import adab;
import adak;
import alqb;
import alqg;
import alqt;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anwo;
import anws;
import anzj;
import baou;
import baox;
import begp;
import behh;
import bhlg;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemDiscussionMsgData
  extends AbsRecentUserBusinessBaseData
{
  private static final String TAG = "RecentItemDiscussionMsgData";
  
  public RecentItemDiscussionMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a()
  {
    String str;
    StringBuilder localStringBuilder;
    if (AppSetting.c)
    {
      if (this.mTitleName == null) {
        break label137;
      }
      str = this.mTitleName + anzj.a(2131712054);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str).append(",");
      if (this.mUnreadNum != 0) {
        break label146;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        localStringBuilder.append(this.mMsgExtroInfo + ",");
      }
      localStringBuilder.append(behh.e(this.mLastMsg.toString())).append(",").append(this.mShowTime);
      this.mContentDesc = localStringBuilder.toString();
      return;
      label137:
      str = anzj.a(2131712054);
      break;
      label146:
      if (this.mUnreadNum == 1) {
        localStringBuilder.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        localStringBuilder.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        localStringBuilder.append("有").append(this.mUnreadNum).append("条未读,");
      }
    }
  }
  
  private void a(Context paramContext)
  {
    if (a().msg == null) {
      this.mContentDesc = "";
    }
    for (;;)
    {
      return;
      if ((a().msg instanceof alqb))
      {
        alqb localalqb = (alqb)a().msg;
        this.mMsgExtroInfo = localalqb.a;
        this.mContentDesc = localalqb.b;
        if ((a().msg instanceof alqg)) {
          this.mContentDesc = String.format(anzj.a(2131712053), new Object[] { this.mTitleName });
        }
      }
      for (int i = 2131167102; (!TextUtils.isEmpty(this.mMsgExtroInfo)) && (i > 0); i = 0)
      {
        this.mExtraInfoColor = paramContext.getResources().getColor(i);
        return;
      }
    }
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((paramMessage != null) && (paramMessage.msgtype == -2025) && (this.mUnreadNum > 0) && (!paramMsgSummary.bShowDraft))
    {
      paramMessage = paramContext.getString(2131692883);
      if ((!TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith(paramMessage)))
      {
        if (this.mExtraInfoColor == 0) {
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167102);
        }
        if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
          break label118;
        }
      }
    }
    label118:
    for (paramContext = paramMessage;; paramContext = this.mMsgExtroInfo + paramMessage)
    {
      this.mMsgExtroInfo = paramContext;
      this.mLastMsg = this.mLastMsg.toString().replace(paramMessage, "");
      return;
    }
  }
  
  private void a(Context paramContext, MsgSummary paramMsgSummary)
  {
    if (!paramMsgSummary.bShowDraft) {
      a(paramContext);
    }
    while (!(a().msg instanceof alqb)) {
      return;
    }
    this.mMsgExtroInfo = ((alqb)a().msg).a;
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage != null)
    {
      adab localadab;
      if ((paramMessage.istroop == 3000) && (paramMessage.msg == null) && (paramMessage.time == 0L))
      {
        this.mDisplayTime = this.mUser.lastmsgtime;
        localadab = paramQQAppInterface.a();
        if (localadab == null) {
          break label140;
        }
      }
      label140:
      for (this.mUnreadNum = localadab.a(paramMessage.frienduin, paramMessage.istroop);; this.mUnreadNum = 0)
      {
        paramQQAppInterface = baou.a(paramQQAppInterface, paramMessage.frienduin, paramMessage.istroop, this.mUnreadNum, paramMessage);
        this.mUnreadNum += paramQQAppInterface.a();
        if (paramQQAppInterface.a() > 0)
        {
          this.mMsgExtroInfo = paramQQAppInterface.a();
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167102);
        }
        return;
        this.mDisplayTime = paramMessage.time;
        break;
      }
    }
    this.mUnreadNum = 0;
    this.mDisplayTime = 0L;
  }
  
  private void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage != null) && (!TextUtils.isEmpty(paramMessage.senderuin)))
    {
      if (!paramMessage.senderuin.equals(paramMessage.frienduin)) {
        break label35;
      }
      paramMessage.nickName = "";
    }
    label35:
    do
    {
      return;
      if (!TextUtils.isEmpty(paramMessage.frienduin)) {
        paramMessage.nickName = bhlg.a(paramQQAppInterface, paramMessage.frienduin, paramMessage.senderuin, paramMessage);
      }
      if (TextUtils.isEmpty(paramMessage.nickName)) {
        paramMessage.nickName = bhlg.b(paramQQAppInterface, paramMessage.senderuin, true);
      }
    } while (!TextUtils.isEmpty(paramMessage.nickName));
    paramMessage.nickName = paramMessage.senderuin;
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.mUnreadNum > 0) && (adak.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType())))
    {
      this.mUnreadFlag = 3;
      return;
    }
    this.mUnreadFlag = 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject2 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(this.mUser.uin, this.mUser.getType());; localObject1 = null)
    {
      a(paramQQAppInterface, paramContext, (QQMessageFacade.Message)localObject1);
      b(paramQQAppInterface);
      anws localanws = (anws)paramQQAppInterface.getManager(53);
      if (localanws != null) {
        localObject2 = localanws.a(this.mUser.uin);
      }
      if ((localObject2 == null) && (!TimeManager.getInstance().checkContainsKey(this.mUser.uin))) {}
      try
      {
        long l = Long.parseLong(this.mUser.uin);
        ((anwo)paramQQAppInterface.a(6)).a(l);
        TimeManager.getInstance().putToOneTimeTaskMap(this.mUser.uin, true);
        a(paramQQAppInterface, (QQMessageFacade.Message)localObject1);
        this.mTitleName = bhlg.c(paramQQAppInterface, this.mUser.uin);
        if (TextUtils.isEmpty(this.mTitleName)) {
          this.mTitleName = bhlg.a(paramContext, (DiscussionInfo)localObject2);
        }
        if (!TextUtils.isEmpty(this.mTitleName)) {
          this.mTitleNameCs = new begp(this.mTitleName, 1);
        }
        MsgSummary localMsgSummary = getMsgSummaryTemp();
        a((QQMessageFacade.Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
        String str = "";
        localObject2 = str;
        if (localanws != null)
        {
          int i = localanws.a(this.mUser.uin);
          localObject2 = str;
          if (i > 0) {
            localObject2 = "(" + i + ")";
          }
        }
        this.mExtraInfo = ((CharSequence)localObject2);
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        if (((a().msg instanceof alqt)) && (this.mUnreadNum > 0))
        {
          localMsgSummary.suffix = "";
          localMsgSummary.strPrefix = "";
        }
        a(paramQQAppInterface, paramContext, localMsgSummary);
        a(paramContext, localMsgSummary);
        a(paramContext, (QQMessageFacade.Message)localObject1, localMsgSummary);
        paramQQAppInterface = a();
        if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
          paramQQAppInterface.reParse();
        }
        a();
        updateMsgUnreadStateMenu();
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("discussion", 2, localNumberFormatException.toString());
          }
        }
      }
    }
  }
  
  protected boolean isEnableUnreadState()
  {
    return this.mUser.getType() == 3000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData
 * JD-Core Version:    0.7.0.1
 */