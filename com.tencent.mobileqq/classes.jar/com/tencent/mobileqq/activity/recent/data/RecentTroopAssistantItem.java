package com.tencent.mobileqq.activity.recent.data;

import acmw;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import bdla;
import begq;
import bglm;
import bgmk;
import bhmb;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import nty;

public class RecentTroopAssistantItem
  extends RecentBaseData
{
  private static String TAG = "RecentTroopAssistantItem";
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
        localSpannableString = new begq(paramMsgSummary.strPrefix, 16).a();
      }
      paramMessage = bhmb.a((String)localObject, paramMessage, 16, 3);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessage);
      paramMsgSummary.strContent = new QQText((CharSequence)localObject, 3, 16);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (this.mIsGroupVideoNotify)
    {
      localObject = (bgmk)paramQQAppInterface.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
      if ((localObject != null) && (((bgmk)localObject).a(getRecentUserUin()) == 2)) {
        this.mIsGroupVideoNotify = false;
      }
    }
    if ((this.mIsGroupVideoNotify) && (TextUtils.isEmpty(this.mMsgExtroInfo)))
    {
      this.mMsgExtroInfo = paramQQAppInterface.getApp().getString(2131697550);
      this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131167138);
    }
    if ((this.mIsGroupVideoNotify) && (!paramBoolean))
    {
      localObject = String.valueOf(paramLong);
      bdla.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject, "" + TroopUtils.getTroopIdentity(paramQQAppInterface, (String)localObject), "", "");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      this.mTitleName = ContactUtils.getTroopName(paramQQAppInterface, paramString1, true);
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
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    if (localObject1 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).getLastMessage(str, i);; localMessage = null)
    {
      label88:
      int j;
      if (localMessage != null)
      {
        this.mDisplayTime = localMessage.time;
        localObject1 = paramQQAppInterface.getConversationFacade();
        if (localObject1 != null)
        {
          this.mUnreadNum = ((acmw)localObject1).a(localMessage.frienduin, localMessage.istroop);
          if ((bglm.a(str)) || (bglm.c(str)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "show TroopNotification orange mark.");
            }
            this.mMsgExtroInfo = BaseApplicationImpl.getContext().getString(2131719354);
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
          }
          j = this.mMenuFlag;
          localObject1 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          if (localObject1 == null) {
            break label608;
          }
        }
      }
      label608:
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
            if (localMsgSummary == null) {
              break;
            }
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
              this.mIsGroupVideo = paramQQAppInterface.getAVNotifyCenter().c(l);
              boolean bool = this.mIsGroupVideoNotify;
              this.mIsGroupVideoNotify = paramQQAppInterface.getAVNotifyCenter().b(l);
              a(paramQQAppInterface, l, bool);
              if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localMessage != null) && (localMsgSummary != null) && (nty.a(localMessage))) {
                this.mLastMsg = localMsgSummary.parseMsgWithExtraInfo(paramContext, paramContext.getResources().getString(2131696965), -1);
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
              paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
              this.mMenuFlag &= 0xFFFFFF0F;
              j = this.mMenuFlag;
              if (paramQQAppInterface.b(str))
              {
                i = 32;
                this.mMenuFlag = (i | j);
                a();
                return;
                this.mUnreadNum = 0;
                break label88;
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