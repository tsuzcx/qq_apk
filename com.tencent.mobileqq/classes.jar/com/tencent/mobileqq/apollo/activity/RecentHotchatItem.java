package com.tencent.mobileqq.apollo.activity;

import abwp;
import amir;
import amtj;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import bcef;
import bfdg;
import bfee;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import nmy;

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
    if (a() > 0) {}
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
    if (this.mOriginalData == null) {
      return -1;
    }
    return this.mOriginalData.mGameId;
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
    return this.mOriginalData.mHotChatCode;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.mOriginalData != null) && (this.mOriginalData.mGameId <= 0) && (!TextUtils.isEmpty(this.mOriginalData.mHotChatCode)) && (paramQQAppInterface != null))
    {
      Object localObject = (amir)paramQQAppInterface.getManager(155);
      if (localObject != null)
      {
        localObject = ((amir)localObject).a(this.mOriginalData.mHotChatCode);
        if (localObject != null) {
          this.mOriginalData.mGameId = ((ApolloGameData)localObject).gameId;
        }
      }
    }
    if ((paramQQAppInterface != null) && (a() > 0))
    {
      paramQQAppInterface = (amir)paramQQAppInterface.getManager(155);
      if (paramQQAppInterface != null) {
        this.mGameData = paramQQAppInterface.a(a(), a());
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("RecentHotchatItem", 2, "[update] " + a() + " " + getRecentUserUin() + " " + getRecentUserType() + " " + c());
    }
    QQMessageFacade.Message localMessage = null;
    Object localObject4 = getRecentUserUin();
    int i = getRecentUserType();
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    if (localObject1 != null) {
      localMessage = ((QQMessageFacade)localObject1).getLastMessage((String)localObject4, i);
    }
    label163:
    int j;
    if (localMessage != null)
    {
      this.mDisplayTime = localMessage.time;
      localObject1 = paramQQAppInterface.getConversationFacade();
      if (localObject1 != null)
      {
        this.mUnreadNum = ((abwp)localObject1).a(localMessage.frienduin, localMessage.istroop);
        if ((bfdg.a((String)localObject4)) || (bfdg.c((String)localObject4)))
        {
          this.mMsgExtroInfo = BaseApplicationImpl.getContext().getString(2131718959);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167096);
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
          this.mTitleName = ContactUtils.getTroopName(paramQQAppInterface, (String)localObject4, true);
          localObject4 = getMsgSummaryTemp();
          if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
            localMessage.nickName = localMessage.senderuin;
          }
          buildMessageBody(localMessage, i, paramQQAppInterface, paramContext, (MsgSummary)localObject4);
          if ((TextUtils.isEmpty(((MsgSummary)localObject4).strContent)) && (TextUtils.isEmpty(((MsgSummary)localObject4).suffix)))
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = "";
            }
            ((MsgSummary)localObject4).strContent = ((CharSequence)localObject3);
          }
          dealStatus(paramQQAppInterface);
          dealDraft(paramQQAppInterface, (MsgSummary)localObject4);
          extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject4);
          l1 = 0L;
        }
        try
        {
          long l2 = Long.parseLong(getRecentUserUin());
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          boolean bool;
          break label408;
        }
        this.mIsGroupVideo = paramQQAppInterface.getAVNotifyCenter().c(l1);
        bool = this.mIsGroupVideoNotify;
        this.mIsGroupVideoNotify = paramQQAppInterface.getAVNotifyCenter().b(l1);
        if (this.mIsGroupVideoNotify)
        {
          localObject1 = (bfee)paramQQAppInterface.getManager(164);
          if ((localObject1 != null) && (((bfee)localObject1).a(getRecentUserUin()) == 2)) {
            this.mIsGroupVideoNotify = false;
          }
        }
        if ((this.mIsGroupVideoNotify) && (TextUtils.isEmpty(this.mMsgExtroInfo)))
        {
          this.mMsgExtroInfo = paramQQAppInterface.getApp().getString(2131697273);
          this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131167124);
        }
        if ((this.mIsGroupVideoNotify) && (!bool))
        {
          localObject1 = String.valueOf(l1);
          bcef.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject1, "" + TroopUtils.getTroopIdentity(paramQQAppInterface, (String)localObject1), "", "");
        }
        if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localMessage != null) && (localObject4 != null) && (nmy.a(localMessage))) {
          this.mLastMsg = ((MsgSummary)localObject4).parseMsgWithExtraInfo(paramContext, paramContext.getResources().getString(2131696698), -1);
        }
        this.mMenuFlag &= 0xFFFFFF0F;
        j = this.mMenuFlag;
        if (a())
        {
          i = 32;
          this.mMenuFlag = (i | j);
          if (this.mOriginalData.mState != 1) {
            break label1017;
          }
          if ((c()) && ((!c()) || (!this.mOriginalData.mIsRead4List))) {
            break label896;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentHotchatItem", 2, "[update] kicked out");
          }
          paramQQAppInterface = amtj.a(2131712270);
          ((MsgSummary)localObject4).reset();
          this.mLastMsg = ((MsgSummary)localObject4).parseMsgWithExtraInfo(paramContext, paramQQAppInterface, -1);
          this.mUnreadFlag = 0;
          if (!AppSetting.c) {
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
          if ((!d()) || (b())) {
            break label758;
          }
          this.mMsgExtroInfo = "";
          this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131167124);
          localObject1 = this.mGameData.wording;
          ((MsgSummary)localObject4).reset();
          this.mLastMsg = ((MsgSummary)localObject4).parseMsgWithExtraInfo(paramContext, (String)localObject1, -1);
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
          if ((d()) && (!b()))
          {
            this.mMsgExtroInfo = "";
            this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131167124);
            paramQQAppInterface = this.mGameData.wording;
            ((MsgSummary)localObject4).reset();
            this.mLastMsg = ((MsgSummary)localObject4).parseMsgWithExtraInfo(paramContext, paramQQAppInterface, -1);
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
  
  public boolean a()
  {
    return (this.mOriginalData != null) && (this.mOriginalData.mIsMakeTop);
  }
  
  public boolean b()
  {
    return (this.mOriginalData != null) && (this.mOriginalData.mIsRead4List);
  }
  
  public boolean c()
  {
    return (this.mOriginalData != null) && (this.mGameData != null) && (!this.mGameData.isShow);
  }
  
  public boolean d()
  {
    return this.mGameData != null;
  }
  
  public long getLastDraftTime()
  {
    if (this.mOriginalData == null) {
      return 0L;
    }
    return this.mOriginalData.mDraftSec;
  }
  
  public long getLastMsgTime()
  {
    if (this.mOriginalData == null) {
      return 0L;
    }
    return this.mOriginalData.mLatestMsgSec;
  }
  
  public int getRecentUserType()
  {
    return 1;
  }
  
  public String getRecentUserUin()
  {
    if (this.mOriginalData == null) {
      return "";
    }
    return this.mOriginalData.mTroopUin;
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.RecentHotchatItem
 * JD-Core Version:    0.7.0.1
 */