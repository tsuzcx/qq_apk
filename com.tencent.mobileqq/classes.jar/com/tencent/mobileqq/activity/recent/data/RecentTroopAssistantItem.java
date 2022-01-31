package com.tencent.mobileqq.activity.recent.data;

import akpb;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import axqy;
import ayjw;
import aykk;
import bame;
import banb;
import bane;
import bbcz;
import bbos;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import myb;

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
  
  public int a()
  {
    return 1;
  }
  
  public long a()
  {
    return this.mData.lastmsgtime;
  }
  
  public String a()
  {
    return this.mData.troopUin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    QQMessageFacade.Message localMessage = null;
    String str = a();
    int i = a();
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {
      localMessage = ((QQMessageFacade)localObject1).a(str, i);
    }
    int j;
    if (localMessage != null)
    {
      this.mDisplayTime = localMessage.time;
      localObject1 = paramQQAppInterface.a();
      if (localObject1 != null)
      {
        this.mUnreadNum = ((akpb)localObject1).a(localMessage.frienduin, localMessage.istroop);
        if ((bame.a(str)) || (bame.c(str)))
        {
          this.mMsgExtroInfo = BaseApplicationImpl.getContext().getString(2131720284);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131166955);
        }
        j = this.mMenuFlag;
        localObject1 = (TroopManager)paramQQAppInterface.getManager(52);
        if (localObject1 == null) {
          break label1145;
        }
      }
    }
    label212:
    label1145:
    for (TroopInfo localTroopInfo = ((TroopManager)localObject1).b(str);; localTroopInfo = null)
    {
      Object localObject3;
      if (localTroopInfo != null)
      {
        localObject3 = localTroopInfo.getTroopName();
        localObject1 = localTroopInfo.troopmemo;
      }
      for (;;)
      {
        this.mMenuFlag = (j & 0xFFFFF0FF | 0x100);
        MsgSummary localMsgSummary;
        label378:
        long l1;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          this.mTitleName = bbcz.a(paramQQAppInterface, str, true);
          localMsgSummary = a();
          if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
            localMessage.nickName = localMessage.senderuin;
          }
          a(localMessage, i, paramQQAppInterface, paramContext, localMsgSummary);
          if ((localMsgSummary.nState == 0) && ((!TextUtils.isEmpty(localMsgSummary.strContent)) || (!TextUtils.isEmpty(localMsgSummary.suffix))))
          {
            SpannableString localSpannableString = null;
            if (TextUtils.isEmpty(localMsgSummary.strContent)) {
              break label1041;
            }
            Object localObject4 = localMsgSummary.strContent.toString();
            localObject3 = localObject4;
            if (!TextUtils.isEmpty(localMsgSummary.strPrefix))
            {
              localObject3 = localObject4;
              if (TextUtils.indexOf(localMsgSummary.strContent, localMsgSummary.strPrefix) == 0) {
                localObject3 = (String)((String)localObject4).subSequence(localMsgSummary.strPrefix.length() + 2, localMsgSummary.strContent.length());
              }
            }
            if (!TextUtils.isEmpty(localMsgSummary.strPrefix)) {
              localSpannableString = new ayjw(localMsgSummary.strPrefix, 16).a();
            }
            localObject3 = bbos.a((String)localObject3, localMessage, 16, 3);
            localObject4 = new SpannableStringBuilder();
            if (localSpannableString != null) {
              ((SpannableStringBuilder)localObject4).append(localSpannableString).append(": ");
            }
            ((SpannableStringBuilder)localObject4).append((CharSequence)localObject3);
            localMsgSummary.strContent = new aykk((CharSequence)localObject4, 3, 16);
          }
          if ((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix)))
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = "";
            }
            localMsgSummary.strContent = ((CharSequence)localObject3);
          }
          a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          a(paramQQAppInterface, paramContext, localMsgSummary);
          l1 = 0L;
        }
        try
        {
          long l2 = Long.parseLong(a());
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          boolean bool;
          break label550;
        }
        this.mIsGroupVideo = paramQQAppInterface.a().c(l1);
        bool = this.mIsGroupVideoNotify;
        this.mIsGroupVideoNotify = paramQQAppInterface.a().b(l1);
        if (this.mIsGroupVideoNotify)
        {
          localObject1 = (bane)paramQQAppInterface.getManager(164);
          if ((localObject1 != null) && (((bane)localObject1).a(a()) == 2)) {
            this.mIsGroupVideoNotify = false;
          }
        }
        if ((this.mIsGroupVideoNotify) && (TextUtils.isEmpty(this.mMsgExtroInfo)))
        {
          this.mMsgExtroInfo = paramQQAppInterface.getApp().getString(2131698052);
          this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131166955);
        }
        if ((this.mIsGroupVideoNotify) && (!bool))
        {
          localObject1 = String.valueOf(l1);
          axqy.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject1, "" + banb.a(paramQQAppInterface, (String)localObject1), "", "");
        }
        if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localMessage != null) && (localMsgSummary != null) && (myb.a(localMessage))) {
          this.mLastMsg = localMsgSummary.a(paramContext, paramContext.getResources().getString(2131697495), -1);
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
          if (!AppSetting.d) {
            break;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.mTitleName);
          if (this.mUnreadNum != 0) {
            break label1062;
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
          this.mDisplayTime = 0L;
          this.mUnreadNum = 0;
          break;
          this.mTitleName = ((String)localObject3);
          break label212;
          localObject3 = localMsgSummary.suffix.toString();
          break label378;
          i = 16;
          break label906;
          if (this.mUnreadNum == 1) {
            paramQQAppInterface.append("有一条未读");
          } else if (this.mUnreadNum == 2) {
            paramQQAppInterface.append("有两条未读");
          } else if (this.mUnreadNum > 0) {
            paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
          }
        }
        Object localObject2 = null;
        localObject3 = null;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public long b()
  {
    return this.mData.lastdrafttime;
  }
  
  public long c()
  {
    return this.mTroopCreditLevel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem
 * JD-Core Version:    0.7.0.1
 */