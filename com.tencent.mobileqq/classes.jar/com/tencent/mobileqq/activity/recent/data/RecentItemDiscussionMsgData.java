package com.tencent.mobileqq.activity.recent.data;

import abta;
import abti;
import ajlh;
import ajlr;
import ajlv;
import ajmj;
import alri;
import alrk;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import axap;
import axas;
import bamp;
import banh;
import bdgc;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemDiscussionMsgData
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemDiscussionMsgData";
  
  public RecentItemDiscussionMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a(Context paramContext)
  {
    if (a().msg == null) {
      this.mContentDesc = "";
    }
    for (;;)
    {
      return;
      if ((a().msg instanceof ajlr))
      {
        ajlr localajlr = (ajlr)a().msg;
        this.mMsgExtroInfo = localajlr.a;
        this.mContentDesc = localajlr.b;
        if ((a().msg instanceof ajlv)) {
          this.mContentDesc = String.format(alud.a(2131713565), new Object[] { this.mTitleName });
        }
      }
      for (int i = 2131167008; (!TextUtils.isEmpty(this.mMsgExtroInfo)) && (i > 0); i = 0)
      {
        this.mExtraInfoColor = paramContext.getResources().getColor(i);
        return;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = null;
    Object localObject2 = paramQQAppInterface.a();
    if (localObject2 != null) {
      localObject1 = ((QQMessageFacade)localObject2).a(this.mUser.uin, this.mUser.getType());
    }
    if (localObject1 != null) {
      if ((((QQMessageFacade.Message)localObject1).istroop == 3000) && (((QQMessageFacade.Message)localObject1).msg == null) && (((QQMessageFacade.Message)localObject1).time == 0L)) {
        this.mDisplayTime = this.mUser.lastmsgtime;
      }
    }
    for (;;)
    {
      localObject2 = paramQQAppInterface.a();
      label125:
      alrk localalrk;
      if (localObject2 != null)
      {
        this.mUnreadNum = ((abta)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        localObject2 = axap.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, this.mUnreadNum, (QQMessageFacade.Message)localObject1);
        this.mUnreadNum += ((axas)localObject2).a();
        if (((axas)localObject2).a() > 0)
        {
          this.mMsgExtroInfo = ((axas)localObject2).a();
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167008);
        }
        label191:
        localObject2 = null;
        localalrk = (alrk)paramQQAppInterface.getManager(53);
        if (localalrk != null) {
          localObject2 = localalrk.a(this.mUser.uin);
        }
        if ((this.mUnreadNum <= 0) || (!abti.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))) {
          break label897;
        }
        this.mUnreadFlag = 3;
        if ((localObject2 != null) || (ajlh.a().b(this.mUser.uin))) {}
      }
      try
      {
        long l = Long.parseLong(this.mUser.uin);
        ((alri)paramQQAppInterface.a(6)).a(l);
        ajlh.a().a(this.mUser.uin, true);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).senderuin)))
        {
          if (((QQMessageFacade.Message)localObject1).senderuin.equals(((QQMessageFacade.Message)localObject1).frienduin)) {
            ((QQMessageFacade.Message)localObject1).nickName = "";
          }
        }
        else
        {
          this.mTitleName = bdgc.c(paramQQAppInterface, this.mUser.uin);
          if (TextUtils.isEmpty(this.mTitleName)) {
            this.mTitleName = bdgc.a(paramContext, (DiscussionInfo)localObject2);
          }
          if (!TextUtils.isEmpty(this.mTitleName)) {
            this.mTitleName_cs = new bamp(this.mTitleName, 1);
          }
          MsgSummary localMsgSummary = a();
          a((QQMessageFacade.Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
          String str = "";
          localObject2 = str;
          if (localalrk != null)
          {
            int i = localalrk.a(this.mUser.uin);
            localObject2 = str;
            if (i > 0) {
              localObject2 = "(" + i + ")";
            }
          }
          this.mExtraInfo = ((CharSequence)localObject2);
          a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          if (((a().msg instanceof ajmj)) && (this.mUnreadNum > 0))
          {
            localMsgSummary.suffix = "";
            localMsgSummary.strPrefix = "";
          }
          a(paramQQAppInterface, paramContext, localMsgSummary);
          if (localMsgSummary.bShowDraft) {
            break label1010;
          }
          a(paramContext);
          if ((localObject1 != null) && (((QQMessageFacade.Message)localObject1).msgtype == -2025) && (this.mUnreadNum > 0) && (!localMsgSummary.bShowDraft))
          {
            localObject1 = paramContext.getString(2131693391);
            if ((!TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith((String)localObject1)))
            {
              if (this.mExtraInfoColor == 0) {
                this.mExtraInfoColor = paramContext.getResources().getColor(2131167008);
              }
              if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
                break label1043;
              }
              paramQQAppInterface = (QQAppInterface)localObject1;
              this.mMsgExtroInfo = paramQQAppInterface;
              this.mLastMsg = this.mLastMsg.toString().replace((CharSequence)localObject1, "");
            }
          }
          paramQQAppInterface = a();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
            paramQQAppInterface.reParse();
          }
          if (AppSetting.c)
          {
            if (this.mTitleName == null) {
              break label1069;
            }
            paramQQAppInterface = this.mTitleName + alud.a(2131713566);
            paramContext = new StringBuilder();
            paramContext.append(paramQQAppInterface).append(",");
            if (this.mUnreadNum != 0) {
              break label1079;
            }
            if (this.mMsgExtroInfo != null) {
              paramContext.append(this.mMsgExtroInfo + ",");
            }
            paramContext.append(banh.e(this.mLastMsg.toString())).append(",").append(this.mShowTime);
            this.mContentDesc = paramContext.toString();
          }
          e();
          return;
          this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
          continue;
          this.mUnreadNum = 0;
          break label125;
          this.mUnreadNum = 0;
          this.mDisplayTime = 0L;
          break label191;
          label897:
          this.mUnreadFlag = 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("discussion", 2, localNumberFormatException.toString());
            continue;
            if (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).frienduin)) {
              ((QQMessageFacade.Message)localObject1).nickName = bdgc.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).senderuin, (MessageRecord)localObject1);
            }
            if (TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName)) {
              ((QQMessageFacade.Message)localObject1).nickName = bdgc.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, true);
            }
            label1043:
            label1069:
            label1079:
            if (TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName))
            {
              ((QQMessageFacade.Message)localObject1).nickName = ((QQMessageFacade.Message)localObject1).senderuin;
              continue;
              label1010:
              if ((a().msg instanceof ajlr))
              {
                this.mMsgExtroInfo = ((ajlr)a().msg).a;
                continue;
                paramQQAppInterface = this.mMsgExtroInfo + (String)localObject1;
                continue;
                paramQQAppInterface = alud.a(2131713566);
                continue;
                if (this.mUnreadNum == 1) {
                  paramContext.append("有一条未读");
                } else if (this.mUnreadNum == 2) {
                  paramContext.append("有两条未读");
                } else if (this.mUnreadNum > 0) {
                  paramContext.append("有").append(this.mUnreadNum).append("条未读,");
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData
 * JD-Core Version:    0.7.0.1
 */