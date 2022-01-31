package com.tencent.mobileqq.apollo.activity;

import ajmu;
import ajya;
import akpb;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import axqy;
import bame;
import banb;
import bane;
import bbcz;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import myb;

public class RecentHotchatItem
  extends RecentBaseData
{
  private static final String TAG = "RecentHotchatItem";
  private static RecentHotchatItem sDivider;
  private AioPushData mGameData;
  private HotChatItemData mOriginalData;
  public int mType = 3;
  
  public RecentHotchatItem(HotChatItemData paramHotChatItemData)
  {
    this.mOriginalData = paramHotChatItemData;
    if (c() > 0) {}
    for (int i = 2;; i = 1)
    {
      this.mType = i;
      return;
    }
  }
  
  public static RecentHotchatItem a()
  {
    if (sDivider == null)
    {
      sDivider = new RecentHotchatItem(null);
      sDivider.mType = 4;
    }
    return sDivider;
  }
  
  public int a()
  {
    return 1;
  }
  
  public long a()
  {
    if (this.mOriginalData == null) {
      return 0L;
    }
    return this.mOriginalData.mLatestMsgSec;
  }
  
  public AioPushData a()
  {
    return this.mGameData;
  }
  
  public String a()
  {
    if (this.mOriginalData == null) {
      return "";
    }
    return this.mOriginalData.mTroopUin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    b(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("RecentHotchatItem", 2, "[update] " + c() + " " + a() + " " + a() + " " + d());
    }
    QQMessageFacade.Message localMessage = null;
    Object localObject4 = a();
    int i = a();
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {
      localMessage = ((QQMessageFacade)localObject1).a((String)localObject4, i);
    }
    label163:
    int j;
    if (localMessage != null)
    {
      this.mDisplayTime = localMessage.time;
      localObject1 = paramQQAppInterface.a();
      if (localObject1 != null)
      {
        this.mUnreadNum = ((akpb)localObject1).a(localMessage.frienduin, localMessage.istroop);
        if ((bame.a((String)localObject4)) || (bame.c((String)localObject4)))
        {
          this.mMsgExtroInfo = BaseApplicationImpl.getContext().getString(2131720284);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131166931);
        }
        j = this.mMenuFlag;
        localObject1 = (TroopManager)paramQQAppInterface.getManager(52);
        if (localObject1 == null) {
          break label1204;
        }
      }
    }
    label287:
    label676:
    label758:
    label763:
    Object localObject2;
    label408:
    label1204:
    for (localObject1 = ((TroopManager)localObject1).b((String)localObject4);; localObject2 = null)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((TroopInfo)localObject1).troopname;
        localObject1 = ((TroopInfo)localObject1).troopmemo;
      }
      for (;;)
      {
        this.mMenuFlag = (j & 0xFFFFF0FF | 0x100);
        long l1;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          this.mTitleName = bbcz.a(paramQQAppInterface, (String)localObject4, true);
          localObject4 = a();
          if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
            localMessage.nickName = localMessage.senderuin;
          }
          a(localMessage, i, paramQQAppInterface, paramContext, (MsgSummary)localObject4);
          if ((TextUtils.isEmpty(((MsgSummary)localObject4).strContent)) && (TextUtils.isEmpty(((MsgSummary)localObject4).suffix)))
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = "";
            }
            ((MsgSummary)localObject4).strContent = ((CharSequence)localObject3);
          }
          a(paramQQAppInterface);
          a(paramQQAppInterface, (MsgSummary)localObject4);
          a(paramQQAppInterface, paramContext, (MsgSummary)localObject4);
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
          break label408;
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
        if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localMessage != null) && (localObject4 != null) && (myb.a(localMessage))) {
          this.mLastMsg = ((MsgSummary)localObject4).a(paramContext, paramContext.getResources().getString(2131697495), -1);
        }
        this.mMenuFlag &= 0xFFFFFF0F;
        j = this.mMenuFlag;
        if (b())
        {
          i = 32;
          this.mMenuFlag = (i | j);
          if (this.mOriginalData.mState != 1) {
            break label1017;
          }
          if ((d()) && ((!d()) || (!this.mOriginalData.mIsRead4List))) {
            break label896;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentHotchatItem", 2, "[update] kicked out");
          }
          paramQQAppInterface = ajya.a(2131713166);
          ((MsgSummary)localObject4).a();
          this.mLastMsg = ((MsgSummary)localObject4).a(paramContext, paramQQAppInterface, -1);
          this.mUnreadFlag = 0;
          if (!AppSetting.d) {
            break label1119;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.mTitleName);
          if (this.mUnreadNum != 0) {
            break label1121;
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
          break label163;
          this.mDisplayTime = 0L;
          this.mUnreadNum = 0;
          break label163;
          this.mTitleName = ((String)localObject3);
          break label287;
          i = 16;
          break label676;
          if ((!e()) || (c())) {
            break label758;
          }
          this.mMsgExtroInfo = "";
          this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131166955);
          localObject1 = this.mGameData.wording;
          ((MsgSummary)localObject4).a();
          this.mLastMsg = ((MsgSummary)localObject4).a(paramContext, (String)localObject1, -1);
          paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a(100);
          }
          if (!QLog.isColorLevel()) {
            break label758;
          }
          QLog.d("RecentHotchatItem", 2, "[update] " + this.mGameData);
          break label758;
          label1017:
          if ((e()) && (!c()))
          {
            this.mMsgExtroInfo = "";
            this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131166955);
            paramQQAppInterface = this.mGameData.wording;
            ((MsgSummary)localObject4).a();
            this.mLastMsg = ((MsgSummary)localObject4).a(paramContext, paramQQAppInterface, -1);
            if (QLog.isColorLevel()) {
              QLog.d("RecentHotchatItem", 2, "[update] " + this.mGameData);
            }
          }
          this.mUnreadFlag = 3;
          break label763;
          label1119:
          break;
          label1121:
          if (this.mUnreadNum == 1) {
            paramQQAppInterface.append("有一条未读");
          } else if (this.mUnreadNum == 2) {
            paramQQAppInterface.append("有两条未读");
          } else if (this.mUnreadNum > 0) {
            paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
          }
        }
        localObject2 = null;
        localObject3 = null;
      }
    }
  }
  
  public long b()
  {
    if (this.mOriginalData == null) {
      return 0L;
    }
    return this.mOriginalData.mDraftSec;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.mOriginalData != null) && (this.mOriginalData.mGameId <= 0) && (!TextUtils.isEmpty(this.mOriginalData.mHotChatCode)) && (paramQQAppInterface != null))
    {
      Object localObject = (ajmu)paramQQAppInterface.getManager(155);
      if (localObject != null)
      {
        localObject = ((ajmu)localObject).a(this.mOriginalData.mHotChatCode);
        if (localObject != null) {
          this.mOriginalData.mGameId = ((ApolloGameData)localObject).gameId;
        }
      }
    }
    if ((paramQQAppInterface != null) && (c() > 0))
    {
      paramQQAppInterface = (ajmu)paramQQAppInterface.getManager(155);
      if (paramQQAppInterface != null) {
        this.mGameData = paramQQAppInterface.a(c(), c());
      }
    }
  }
  
  public boolean b()
  {
    return (this.mOriginalData != null) && (this.mOriginalData.mIsMakeTop);
  }
  
  public int c()
  {
    if (this.mOriginalData == null) {
      return -1;
    }
    return this.mOriginalData.mGameId;
  }
  
  public String c()
  {
    if (this.mOriginalData == null) {
      return "";
    }
    return this.mOriginalData.mHotChatCode;
  }
  
  public boolean c()
  {
    return (this.mOriginalData != null) && (this.mOriginalData.mIsRead4List);
  }
  
  public boolean d()
  {
    return (this.mOriginalData != null) && (this.mGameData != null) && (!this.mGameData.isShow);
  }
  
  public boolean e()
  {
    return this.mGameData != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.RecentHotchatItem
 * JD-Core Version:    0.7.0.1
 */