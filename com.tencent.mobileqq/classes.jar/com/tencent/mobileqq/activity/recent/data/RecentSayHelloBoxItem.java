package com.tencent.mobileqq.activity.recent.data;

import akpc;
import akpv;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anmg;
import bbcl;
import bbet;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentSayHelloBoxItem
  extends RecentMsgBoxItem
{
  private static final int MAX_UNREADER_MSG_ICON = 6;
  public Object lock = new Object();
  public boolean mHasFlowerMsg;
  public List<MessageRecord> mUnreadMRList = new ArrayList(6);
  
  public RecentSayHelloBoxItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject3 = paramQQAppInterface.a(a()).a(a(), a());
    Object localObject1 = paramQQAppInterface.a();
    int i;
    if (localObject3 == null) {
      i = 0;
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.mUnreadMRList.clear();
        this.mUnreadNum = ((akpc)localObject1).a(a(), a());
        if (i > 0)
        {
          localObject3 = ((List)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
            if ((((akpc)localObject1).a(localMessageRecord.senderuin, localMessageRecord.istroop) > 0) && (this.mUnreadMRList.size() < 6)) {
              this.mUnreadMRList.add(localMessageRecord);
            }
            if (this.mUnreadMRList.size() < 6) {
              continue;
            }
          }
        }
        if ((this.mUnreadNum == 0) && (!this.mUnreadMRList.isEmpty())) {
          this.mUnreadMRList.clear();
        }
        this.mUnreadFlag = 3;
        this.mLastMsg = "";
        this.mExtraInfoColor = 0;
        this.mMsgExtroInfo = "";
        ??? = null;
        localObject3 = paramQQAppInterface.a();
        if (localObject3 != null) {
          ??? = ((QQMessageFacade)localObject3).a(a(), a());
        }
        if (anmg.a(paramQQAppInterface, a(), 1001))
        {
          this.mMsgExtroInfo = paramContext.getResources().getString(2131693287);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131166955);
          ??? = a();
          ((MsgSummary)???).strContent = ((akpc)localObject1).a(a(), 1001, paramContext.getResources().getString(2131693286), 0);
          a(paramQQAppInterface, (MsgSummary)???);
          a(paramQQAppInterface, paramContext, (MsgSummary)???);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg_box", 2, "boxUin" + a() + ",boxType" + a() + ",HasUnreadRedPacketMsg");
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg_box", 2, "boxUin" + a() + ",boxType" + a() + ",unreadNum:" + this.mUnreadNum);
          }
          if (!AppSetting.d) {
            break;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.mTitleName);
          if (this.mUnreadNum != 0) {
            break label785;
          }
          label482:
          if (this.mMsgExtroInfo != null) {
            paramQQAppInterface.append(this.mMsgExtroInfo + ",");
          }
          paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
          this.mContentDesc = paramQQAppInterface.toString();
          return;
          i = ((List)localObject3).size();
        }
      }
      if (anmg.b(paramQQAppInterface, a(), 1001))
      {
        this.mHasFlowerMsg = true;
        this.mUnreadFlag = 1;
        this.mMsgExtroInfo = paramContext.getResources().getString(2131694401);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131166955);
        this.mLastMsg = "";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "boxUin" + a() + ",boxType" + a() + ",HasUnreadGiftMsg");
        }
      }
      else
      {
        if (this.mUnreadNum <= 0) {
          break label689;
        }
        this.mLastMsg = "";
      }
    }
    label689:
    localObject1 = null;
    if (??? != null)
    {
      localObject3 = bbcl.q(paramQQAppInterface, ((QQMessageFacade.Message)???).senderuin);
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = bbcl.b(paramQQAppInterface, ((QQMessageFacade.Message)???).senderuin, false);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label852;
      }
      localObject1 = "";
    }
    label785:
    label852:
    for (;;)
    {
      localObject3 = a();
      bbet.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)???, a(), (MsgSummary)localObject3, (String)localObject1, false, false);
      a(paramQQAppInterface, (MsgSummary)localObject3);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
      break;
      if (this.mUnreadNum == 1)
      {
        paramQQAppInterface.append("有一条未读");
        break label482;
      }
      if (this.mUnreadNum == 2)
      {
        paramQQAppInterface.append("有两条未读");
        break label482;
      }
      if (this.mUnreadNum <= 0) {
        break label482;
      }
      paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
      break label482;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem
 * JD-Core Version:    0.7.0.1
 */