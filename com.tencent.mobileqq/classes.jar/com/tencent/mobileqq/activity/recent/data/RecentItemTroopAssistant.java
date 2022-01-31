package com.tencent.mobileqq.activity.recent.data;

import ahcw;
import ajjy;
import akbm;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import ariz;
import axjq;
import axkd;
import babh;
import bado;
import bami;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.qphone.base.util.QLog;
import mnf;

public class RecentItemTroopAssistant
  extends RecentUserBaseData
{
  public static final String TAG = "RecentItemTroopAssistant";
  
  public RecentItemTroopAssistant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 0;
  }
  
  public void a(Context paramContext)
  {
    if (this.mUnreadNum > 0)
    {
      this.mMsgExtroInfo = String.format(paramContext.getString(2131654525), new Object[] { Integer.valueOf(this.mUnreadNum) });
      this.mExtraInfoColor = paramContext.getResources().getColor(2131101336);
      return;
    }
    this.mMsgExtroInfo = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.mStatus = 0;
    TroopAssistantData localTroopAssistantData = ariz.a().a(paramQQAppInterface);
    if ((localTroopAssistantData == null) || (TextUtils.isEmpty(localTroopAssistantData.troopUin))) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.a(localTroopAssistantData.troopUin, 1);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
    {
      this.mStatus = 4;
      return;
    }
    this.mStatus = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = paramContext.getString(2131654509);
    }
    SpannableString localSpannableString = null;
    Object localObject1 = null;
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    Object localObject2 = localSpannableString;
    Object localObject3;
    if (localQQMessageFacade != null)
    {
      localObject3 = ariz.a();
      localObject4 = ((ariz)localObject3).a(paramQQAppInterface);
      localObject1 = localObject3;
      localObject2 = localSpannableString;
      if (localObject4 != null)
      {
        localObject2 = localQQMessageFacade.a(((TroopAssistantData)localObject4).troopUin, 1);
        localObject1 = localObject3;
      }
    }
    Object localObject4 = a();
    if (localObject2 != null)
    {
      this.mUnreadNum = ((ariz)localObject1).a(localQQMessageFacade, paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("RecentItemTroopAssistant", 2, "mUnreadNum :" + this.mUnreadNum);
      }
      this.mDisplayTime = ((QQMessageFacade.Message)localObject2).time;
      a((QQMessageFacade.Message)localObject2, 1, paramQQAppInterface, paramContext, (MsgSummary)localObject4);
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = ahcw.a().a(a(), this.mDisplayTime);
      }
      label210:
      if ((!TextUtils.isEmpty(((MsgSummary)localObject4).strContent)) || (!TextUtils.isEmpty(((MsgSummary)localObject4).suffix)))
      {
        localSpannableString = null;
        if (TextUtils.isEmpty(((MsgSummary)localObject4).strContent)) {
          break label613;
        }
        localObject3 = ((MsgSummary)localObject4).strContent.toString();
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(((MsgSummary)localObject4).strPrefix))
        {
          localObject1 = localObject3;
          if (TextUtils.indexOf(((MsgSummary)localObject4).strContent, ((MsgSummary)localObject4).strPrefix) == 0)
          {
            localObject1 = localObject3;
            if (((MsgSummary)localObject4).strContent.length() <= ((MsgSummary)localObject4).strPrefix.length() + 2) {}
          }
        }
      }
    }
    label613:
    for (localObject1 = (String)((String)localObject3).subSequence(((MsgSummary)localObject4).strPrefix.length() + 2, ((MsgSummary)localObject4).strContent.length());; localObject1 = ((MsgSummary)localObject4).suffix.toString())
    {
      if (!TextUtils.isEmpty(((MsgSummary)localObject4).strPrefix)) {
        localSpannableString = new axjq(((MsgSummary)localObject4).strPrefix, 16).a();
      }
      localObject1 = bami.a((String)localObject1, (MessageRecord)localObject2, 16, 3);
      localObject3 = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject3).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
      ((MsgSummary)localObject4).strContent = new axkd((CharSequence)localObject3, 3, 16);
      if ((TextUtils.isEmpty(((MsgSummary)localObject4).strContent)) && (TextUtils.isEmpty(((MsgSummary)localObject4).suffix)))
      {
        ((MsgSummary)localObject4).strPrefix = null;
        ((MsgSummary)localObject4).strContent = paramContext.getString(2131654513);
      }
      a(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject4);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject4);
      a(paramContext);
      if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localObject2 != null) && (localObject4 != null) && (mnf.a((MessageRecord)localObject2))) {
        this.mLastMsg = ((MsgSummary)localObject4).a(paramContext, paramContext.getResources().getString(2131631782), -1);
      }
      if (!AppSetting.c) {
        break;
      }
      if (this.mUnreadNum <= 0) {
        break label627;
      }
      this.mContentDesc = String.format(ajjy.a(2131647391), new Object[] { Integer.valueOf(this.mUnreadNum), this.mShowTime });
      return;
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
      break label210;
    }
    label627:
    this.mContentDesc = String.format(ajjy.a(2131647397), new Object[] { this.mLastMsg, this.mShowTime });
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
    if (this.mUnreadNum > 0) {
      this.mLastMsg = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {}
    TroopAssistantData localTroopAssistantData;
    do
    {
      do
      {
        return;
        localTroopAssistantData = ariz.a().a(paramQQAppInterface);
      } while ((localTroopAssistantData == null) || (TextUtils.isEmpty(localTroopAssistantData.troopUin)) || (this.mDisplayTime >= localTroopAssistantData.lastdrafttime));
      localObject = ((QQMessageFacade)localObject).a(localTroopAssistantData.troopUin, 1);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.bShowDraft = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramQQAppInterface = babh.a(paramQQAppInterface, localTroopAssistantData.troopUin, true);
    paramMsgSummary.mDraft = new axkd(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
  
  public void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    String str = babh.a(paramQQAppInterface, paramMessage.frienduin, true);
    bado.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, str, false, false);
    if ((paramMessage.istroop == 1) && (akbm.l(paramMessage.msgtype))) {
      paramMsgSummary.strPrefix = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant
 * JD-Core Version:    0.7.0.1
 */