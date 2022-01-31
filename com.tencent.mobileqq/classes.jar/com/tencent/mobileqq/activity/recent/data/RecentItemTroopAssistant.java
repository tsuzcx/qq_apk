package com.tencent.mobileqq.activity.recent.data;

import abot;
import ajgs;
import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import atwd;
import bahs;
import baig;
import bdbt;
import bdec;
import bdnm;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.qphone.base.util.QLog;
import nav;

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
      this.mMsgExtroInfo = String.format(paramContext.getString(2131720970), new Object[] { Integer.valueOf(this.mUnreadNum) });
      this.mExtraInfoColor = paramContext.getResources().getColor(2131166979);
      return;
    }
    this.mMsgExtroInfo = "";
  }
  
  public void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    String str = bdbt.a(paramQQAppInterface, paramMessage.frienduin, true);
    bdec.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, str, false, false);
    if ((paramMessage.istroop == 1) && (abot.m(paramMessage.msgtype))) {
      paramMsgSummary.strPrefix = str;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.mStatus = 0;
    TroopAssistantData localTroopAssistantData = atwd.a().a(paramQQAppInterface);
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
      this.mTitleName = paramContext.getString(2131720954);
    }
    SpannableString localSpannableString = null;
    Object localObject1 = null;
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    Object localObject2 = localSpannableString;
    Object localObject3;
    if (localQQMessageFacade != null)
    {
      localObject3 = atwd.a();
      localObject4 = ((atwd)localObject3).a(paramQQAppInterface);
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
      this.mUnreadNum = ((atwd)localObject1).a(localQQMessageFacade, paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("RecentItemTroopAssistant", 2, "mUnreadNum :" + this.mUnreadNum);
      }
      this.mDisplayTime = ((QQMessageFacade.Message)localObject2).time;
      a((QQMessageFacade.Message)localObject2, 1, paramQQAppInterface, paramContext, (MsgSummary)localObject4);
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = ajgs.a().a(a(), this.mDisplayTime);
      }
      label210:
      if ((!TextUtils.isEmpty(((MsgSummary)localObject4).strContent)) || (!TextUtils.isEmpty(((MsgSummary)localObject4).suffix)))
      {
        localSpannableString = null;
        if (TextUtils.isEmpty(((MsgSummary)localObject4).strContent)) {
          break label616;
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
    label616:
    for (localObject1 = (String)((String)localObject3).subSequence(((MsgSummary)localObject4).strPrefix.length() + 2, ((MsgSummary)localObject4).strContent.length());; localObject1 = ((MsgSummary)localObject4).suffix.toString())
    {
      if (!TextUtils.isEmpty(((MsgSummary)localObject4).strPrefix)) {
        localSpannableString = new bahs(((MsgSummary)localObject4).strPrefix, 16).a();
      }
      localObject1 = bdnm.a((String)localObject1, (MessageRecord)localObject2, 16, 3);
      localObject3 = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject3).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
      ((MsgSummary)localObject4).strContent = new baig((CharSequence)localObject3, 3, 16);
      if ((TextUtils.isEmpty(((MsgSummary)localObject4).strContent)) && (TextUtils.isEmpty(((MsgSummary)localObject4).suffix)))
      {
        ((MsgSummary)localObject4).strPrefix = null;
        ((MsgSummary)localObject4).strContent = paramContext.getString(2131720958);
      }
      a(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject4);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject4);
      a(paramContext);
      if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localObject2 != null) && (localObject4 != null) && (nav.a((MessageRecord)localObject2))) {
        this.mLastMsg = ((MsgSummary)localObject4).a(paramContext, paramContext.getResources().getString(2131697670), -1);
      }
      if (!AppSetting.c) {
        break;
      }
      if (this.mUnreadNum <= 0) {
        break label630;
      }
      this.mContentDesc = String.format(alpo.a(2131713562), new Object[] { Integer.valueOf(this.mUnreadNum), this.mShowTime });
      return;
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
      break label210;
    }
    label630:
    this.mContentDesc = String.format(alpo.a(2131713568), new Object[] { this.mLastMsg, this.mShowTime });
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
        localTroopAssistantData = atwd.a().a(paramQQAppInterface);
      } while ((localTroopAssistantData == null) || (TextUtils.isEmpty(localTroopAssistantData.troopUin)) || (this.mDisplayTime >= localTroopAssistantData.lastdrafttime));
      localObject = ((QQMessageFacade)localObject).a(localTroopAssistantData.troopUin, 1);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.bShowDraft = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramQQAppInterface = bdbt.a(paramQQAppInterface, localTroopAssistantData.troopUin, true);
    paramMsgSummary.mDraft = new baig(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant
 * JD-Core Version:    0.7.0.1
 */