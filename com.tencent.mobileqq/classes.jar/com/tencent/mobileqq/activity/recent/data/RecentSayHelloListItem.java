package com.tencent.mobileqq.activity.recent.data;

import abol;
import abot;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import apds;
import baig;
import bdal;
import bdbt;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.qphone.base.util.QLog;

public class RecentSayHelloListItem
  extends RecentBaseData
{
  public int age = -1;
  public int career = -1;
  public boolean charmIcon;
  public int charmLevel;
  public String common;
  public int commonId;
  public int constellation = -1;
  public int gender = -1;
  public boolean haveInitFlag;
  public boolean mHasFlowerMsg;
  MessageRecord messageRecord;
  public int vip = -1;
  
  public RecentSayHelloListItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentDatingBoxItem data is null");
    }
    this.messageRecord = paramMessageRecord;
  }
  
  public int a()
  {
    return this.messageRecord.istroop;
  }
  
  public long a()
  {
    return this.messageRecord.time;
  }
  
  public String a()
  {
    return this.messageRecord.senderuin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = paramQQAppInterface.a();
    Object localObject2 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(a(), a());; localObject1 = null)
    {
      label78:
      MsgSummary localMsgSummary;
      if (localObject1 != null)
      {
        this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
        if ((localObject2 != null) && (localObject1 != null))
        {
          this.mUnreadNum = ((abol)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          if (abot.d((MessageRecord)localObject1)) {
            this.mUnreadFlag = 3;
          }
          localMsgSummary = super.a();
          this.mHasFlowerMsg = false;
          this.mExtraInfoColor = 0;
          this.mMsgExtroInfo = null;
          if (!apds.a(paramQQAppInterface, a(), 1001)) {
            break label366;
          }
          this.mMsgExtroInfo = paramContext.getResources().getString(2131693389);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167006);
          if (localObject2 != null) {
            localMsgSummary.strContent = ((abol)localObject2).a(a(), 1001, paramContext.getResources().getString(2131693388), 0);
          }
          label171:
          localObject2 = bdbt.q(paramQQAppInterface, a());
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = bdbt.b(paramQQAppInterface, a(), false);
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = a();
          }
          this.mTitleName = ((String)localObject2);
          this.mAuthenIconId = 0;
          super.a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          super.a(paramQQAppInterface, paramContext, localMsgSummary);
          if (AppSetting.c)
          {
            paramQQAppInterface = new StringBuilder(24);
            paramQQAppInterface.append(this.mTitleName);
            if (this.mUnreadNum != 0) {
              break label430;
            }
          }
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
        this.mUnreadNum = 0;
        break;
        this.mUnreadNum = 0;
        this.mDisplayTime = 0L;
        break label78;
        label366:
        if (apds.b(paramQQAppInterface, a(), 1001))
        {
          this.mHasFlowerMsg = true;
          this.mMsgExtroInfo = paramContext.getResources().getString(2131694559);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167006);
          break label171;
        }
        super.a((QQMessageFacade.Message)localObject1, a(), paramQQAppInterface, paramContext, localMsgSummary);
        break label171;
        label430:
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
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a(a(), a());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (this.mDisplayTime > l);
    this.mDisplayTime = l;
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new baig(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public boolean a(FansEntity paramFansEntity)
  {
    boolean bool = false;
    if ((this.age != paramFansEntity.age) || (this.gender != paramFansEntity.gender) || (this.career != paramFansEntity.career) || (this.constellation != paramFansEntity.constellation) || (this.vip != paramFansEntity.vip) || (this.charmIcon != paramFansEntity.charmIcon) || (this.charmLevel != paramFansEntity.charmLevel) || (this.commonId != paramFansEntity.commonId) || (!bdal.a(this.common, paramFansEntity.common)))
    {
      this.age = paramFansEntity.age;
      this.gender = paramFansEntity.gender;
      this.career = paramFansEntity.career;
      this.constellation = paramFansEntity.constellation;
      this.vip = paramFansEntity.vip;
      this.charmIcon = paramFansEntity.charmIcon;
      this.haveInitFlag = true;
      this.charmLevel = paramFansEntity.charmLevel;
      this.commonId = paramFansEntity.commonId;
      this.common = paramFansEntity.common;
      bool = true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.msg_box", 4, "haveChange:" + bool + ",FansEntity:" + paramFansEntity.toString());
    }
    return bool;
  }
  
  public long b()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem
 * JD-Core Version:    0.7.0.1
 */