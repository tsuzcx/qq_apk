package com.tencent.mobileqq.activity.recent.data;

import acvy;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import bcst;
import bdnf;
import bdnt;
import bftr;
import bfup;
import bfus;
import bglf;
import bgwv;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import njo;

public class RecentTroopAssistantItem
  extends RecentBaseData
{
  private TroopAssistantData mData;
  public long mTroopCreditLevel = 5L;
  
  public RecentTroopAssistantItem(TroopAssistantData paramTroopAssistantData)
  {
    if (paramTroopAssistantData == null) {
      throw new NullPointerException("TroopAssistantData is null");
    }
    this.mData = paramTroopAssistantData;
    this.mUnreadFlag = 3;
  }
  
  private void a()
  {
    StringBuilder localStringBuilder;
    if (AppSetting.c)
    {
      localStringBuilder = new StringBuilder(24);
      localStringBuilder.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        break label96;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        localStringBuilder.append(this.mMsgExtroInfo + ",");
      }
      localStringBuilder.append(this.mLastMsg).append(' ').append(this.mShowTime);
      this.mContentDesc = localStringBuilder.toString();
      return;
      label96:
      if (this.mUnreadNum == 1) {
        localStringBuilder.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        localStringBuilder.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        localStringBuilder.append("有").append(this.mUnreadNum).append("条未读");
      }
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    SpannableString localSpannableString;
    String str;
    if ((paramMsgSummary.nState == 0) && ((!TextUtils.isEmpty(paramMsgSummary.strContent)) || (!TextUtils.isEmpty(paramMsgSummary.suffix))))
    {
      localSpannableString = null;
      if (TextUtils.isEmpty(paramMsgSummary.strContent)) {
        break label194;
      }
      str = paramMsgSummary.strContent.toString();
      localObject = str;
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix))
      {
        localObject = str;
        if (TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) != 0) {}
      }
    }
    label194:
    for (Object localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());; localObject = paramMsgSummary.suffix.toString())
    {
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new bdnf(paramMsgSummary.strPrefix, 16).a();
      }
      paramMessage = bgwv.a((String)localObject, paramMessage, 16, 3);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessage);
      paramMsgSummary.strContent = new bdnt((CharSequence)localObject, 3, 16);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (this.mIsGroupVideoNotify)
    {
      localObject = (bfus)paramQQAppInterface.getManager(164);
      if ((localObject != null) && (((bfus)localObject).a(getRecentUserUin()) == 2)) {
        this.mIsGroupVideoNotify = false;
      }
    }
    if ((this.mIsGroupVideoNotify) && (TextUtils.isEmpty(this.mMsgExtroInfo)))
    {
      this.mMsgExtroInfo = paramQQAppInterface.getApp().getString(2131697082);
      this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131167092);
    }
    if ((this.mIsGroupVideoNotify) && (!paramBoolean))
    {
      localObject = String.valueOf(paramLong);
      bcst.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject, "" + bfup.a(paramQQAppInterface, (String)localObject), "", "");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      this.mTitleName = bglf.a(paramQQAppInterface, paramString1, true);
      return;
    }
    this.mTitleName = paramString2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject3 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    String str = getRecentUserUin();
    int i = getRecentUserType();
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).a(str, i);; localMessage = null)
    {
      int j;
      if (localMessage != null)
      {
        this.mDisplayTime = localMessage.time;
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null)
        {
          this.mUnreadNum = ((acvy)localObject1).a(localMessage.frienduin, localMessage.istroop);
          if ((bftr.a(str)) || (bftr.c(str)))
          {
            this.mMsgExtroInfo = BaseApplicationImpl.getContext().getString(2131718575);
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
          }
          j = this.mMenuFlag;
          localObject1 = (TroopManager)paramQQAppInterface.getManager(52);
          if (localObject1 == null) {
            break label585;
          }
        }
      }
      label585:
      for (TroopInfo localTroopInfo = ((TroopManager)localObject1).b(str);; localTroopInfo = null)
      {
        if (localTroopInfo != null) {
          localObject3 = localTroopInfo.getTroopName();
        }
        Object localObject2;
        for (localObject1 = localTroopInfo.troopmemo;; localObject2 = null) {
          for (;;)
          {
            this.mMenuFlag = (j & 0xFFFFF0FF | 0x100);
            a(paramQQAppInterface, str, (String)localObject3);
            MsgSummary localMsgSummary = getMsgSummaryTemp();
            if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
              localMessage.nickName = localMessage.senderuin;
            }
            buildMessageBody(localMessage, i, paramQQAppInterface, paramContext, localMsgSummary);
            a(localMessage, localMsgSummary);
            if ((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix)))
            {
              localObject3 = localObject1;
              if (localObject1 == null) {
                localObject3 = "";
              }
              localMsgSummary.strContent = ((CharSequence)localObject3);
            }
            dealStatus(paramQQAppInterface);
            dealDraft(paramQQAppInterface, localMsgSummary);
            extraUpdate(paramQQAppInterface, paramContext, localMsgSummary);
            try
            {
              l = Long.parseLong(getRecentUserUin());
              this.mIsGroupVideo = paramQQAppInterface.a().c(l);
              boolean bool = this.mIsGroupVideoNotify;
              this.mIsGroupVideoNotify = paramQQAppInterface.a().b(l);
              a(paramQQAppInterface, l, bool);
              if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localMessage != null) && (localMsgSummary != null) && (njo.a(localMessage))) {
                this.mLastMsg = localMsgSummary.parseMsgWithExtraInfo(paramContext, paramContext.getResources().getString(2131696514), -1);
              }
              if (localTroopInfo != null)
              {
                this.mTroopCreditLevel = localTroopInfo.troopCreditLevel;
                if (this.mTroopCreditLevel == 0L) {
                  this.mTroopCreditLevel = 5L;
                }
                if (QLog.isColorLevel()) {
                  QLog.i("troop.credit.act", 2, "RecentTroopAssistantItem->update," + str + "," + this.mTroopCreditLevel);
                }
              }
              paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
              this.mMenuFlag &= 0xFFFFFF0F;
              j = this.mMenuFlag;
              if (paramQQAppInterface.b(str))
              {
                i = 32;
                this.mMenuFlag = (i | j);
                a();
                return;
                this.mUnreadNum = 0;
                break;
                this.mDisplayTime = 0L;
                this.mUnreadNum = 0;
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                long l = 0L;
                continue;
                i = 16;
              }
            }
          }
        }
      }
    }
  }
  
  public long getFaceExtraFlag()
  {
    return this.mTroopCreditLevel;
  }
  
  public long getLastDraftTime()
  {
    return this.mData.lastdrafttime;
  }
  
  public long getLastMsgTime()
  {
    return this.mData.lastmsgtime;
  }
  
  public int getRecentUserType()
  {
    return 1;
  }
  
  public String getRecentUserUin()
  {
    return this.mData.troopUin;
  }
  
  public boolean isUnreadMsgNumInTabNum()
  {
    return false;
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem
 * JD-Core Version:    0.7.0.1
 */