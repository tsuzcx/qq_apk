package com.tencent.mobileqq.activity.recent.data;

import QQService.EVIPSPEC;
import aagc;
import abta;
import afex;
import aglv;
import agoz;
import alof;
import alto;
import alud;
import ambh;
import amca;
import amjn;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import aobk;
import arwd;
import asmw;
import aufv;
import ausj;
import autj;
import autv;
import axap;
import axas;
import ayzl;
import banh;
import bdeu;
import bdgc;
import bdil;
import bfyh;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import ndv;
import ztp;
import zux;
import zxz;

public class RecentItemChatMsgData
  extends RecentUserBaseData
{
  public int haloState;
  public int mBubbleID;
  private boolean mIsSignMsg;
  public String mQimIconUrl;
  public int mQimOnline;
  
  public RecentItemChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage, MessageForStructing paramMessageForStructing)
  {
    String str1 = paramMessageForStructing.structingMsg.mMsgBrief;
    String str2 = paramContext.getString(2131698833);
    if ((!paramMessageForStructing.isread) && (!TextUtils.isEmpty(str1))) {}
    for (this.mMsgExtroInfo = str2;; this.mMsgExtroInfo = "")
    {
      paramMessage.msg = str1;
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167061);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    if (a(paramMessage))
    {
      paramQQAppInterface = (FeedsManager)paramQQAppInterface.getManager(275);
      paramMessage = paramQQAppInterface.getSummary(a());
      if (!TextUtils.isEmpty(paramMessage))
      {
        this.msgSummary.strContent = paramMessage;
        this.mMsgExtroInfo = alud.a(2131713557);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131166981);
        if (!FeedsManager.isShowStatus(a())) {
          FeedsManager.showStatus(a());
        }
        paramQQAppInterface.reportExposeStatus(a());
      }
    }
    else
    {
      return;
    }
    FeedsManager.hideStatus(a());
  }
  
  private boolean a(alto paramalto, String paramString)
  {
    if ((paramalto == null) || (TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        paramalto = paramalto.b(paramString);
      } while ((paramalto == null) || (!paramalto.isFriend()));
      bool1 = paramalto.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramalto.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  private boolean a(QQMessageFacade.Message paramMessage)
  {
    return (this.mUser.getType() == 0) && (TextUtils.isEmpty(this.mMsgExtroInfo)) && (b() <= 0) && (this.mStatus == 0) && (this.msgSummary.nState == 0) && ((paramMessage == null) || (paramMessage.msgtype != -5040)) && (this.msgSummary.suffix == null) && (this.msgSummary.strPrefix == null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.mIsSignMsg = false;
    QQMessageFacade.Message localMessage = null;
    Object localObject4 = paramQQAppInterface.a();
    if (localObject4 != null) {
      localMessage = ((QQMessageFacade)localObject4).a(this.mUser.uin, this.mUser.getType());
    }
    Object localObject1 = paramQQAppInterface.a();
    label115:
    MsgSummary localMsgSummary;
    Object localObject2;
    if ((localObject1 != null) && (localMessage != null))
    {
      this.mUnreadNum = ((abta)localObject1).a(localMessage.frienduin, localMessage.istroop);
      if (this.mUnreadNum <= 0) {
        break label716;
      }
      this.mBubbleID = ((amca)paramQQAppInterface.a(13)).a(localMessage);
      if (localMessage != null)
      {
        localObject1 = axap.a(paramQQAppInterface, localMessage.frienduin, localMessage.istroop, this.mUnreadNum, localMessage);
        this.mUnreadNum += ((axas)localObject1).a();
        if (((axas)localObject1).a() > 0)
        {
          this.mMsgExtroInfo = ((axas)localObject1).a();
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167008);
        }
      }
      FeedsManager.hideStatus(a());
      localMsgSummary = a();
      localObject2 = null;
    }
    label456:
    Object localObject3;
    label502:
    int i;
    switch (this.mUser.getType())
    {
    default: 
      localObject1 = localObject2;
    case 9501: 
    case 1008: 
      for (;;)
      {
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        if ((!localMsgSummary.bShowDraft) || (!this.mIsSignMsg)) {
          break label3844;
        }
        localMsgSummary.strContent = "";
        this.mMsgExtroInfo = "";
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (!AppSetting.c) {
          break label3955;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.mTitleName).append(",");
        if (this.mUnreadNum != 0) {
          break label3855;
        }
        if (this.mMsgExtroInfo != null) {
          ((StringBuilder)localObject3).append(this.mMsgExtroInfo + ",");
        }
        localObject2 = banh.e(this.mLastMsg.toString());
        paramContext = (Context)localObject2;
        if (localMessage != null)
        {
          paramContext = (Context)localObject2;
          if (localMessage.msgtype == -5040)
          {
            paramContext = (Context)localObject2;
            if (autv.a(paramQQAppInterface, localMessage)) {
              paramContext = autv.a((String)localObject2);
            }
          }
        }
        ((StringBuilder)localObject3).append(paramContext).append(",").append(this.mShowTime);
        if ((this.mUser.getType() != 0) || (!((alto)localObject1).b(this.mUser.uin))) {
          break label3946;
        }
        paramQQAppInterface = ausj.a(paramQQAppInterface, this.mUser.uin, false, 5);
        if (paramQQAppInterface == null) {
          break label3946;
        }
        paramQQAppInterface = paramQQAppInterface.iterator();
        for (;;)
        {
          if (!paramQQAppInterface.hasNext()) {
            break label3946;
          }
          paramContext = (autj)paramQQAppInterface.next();
          if (TextUtils.isEmpty(paramContext.d)) {
            break;
          }
          ((StringBuilder)localObject3).append(paramContext.d).append(",");
        }
        this.mUnreadNum = 0;
        break;
        this.mBubbleID = 0;
        break label115;
        localObject1 = localObject2;
        if (localMessage != null)
        {
          localMsgSummary.strContent = localMessage.msg;
          this.mDisplayTime = localMessage.time;
          this.mAuthenIconId = 0;
          if ((localMessage.msgtype == -4502) && (localMessage.frienduin.equals(alof.y))) {
            this.mTitleName = "QQ物联";
          }
          for (;;)
          {
            if ((localMsgSummary.strContent == null) || (localMsgSummary.strContent.length() == 0)) {
              localMsgSummary.strContent = this.mTitleName;
            }
            this.mMenuFlag = 1;
            if (localMessage.msgtype != -4500) {
              break label946;
            }
            localObject3 = new MessageForDeviceFile();
            ((MessageForDeviceFile)localObject3).msgData = localMessage.msgData;
            ((MessageForDeviceFile)localObject3).parse();
            if (((MessageForDeviceFile)localObject3).msgStatus != 1) {
              break label920;
            }
            localMsgSummary.nState = 2;
            localObject1 = localObject2;
            break;
            localObject1 = ((ztp)paramQQAppInterface.a(51)).a(Long.parseLong(localMessage.frienduin));
            if (localObject1 != null) {
              this.mTitleName = aagc.a((DeviceInfo)localObject1);
            }
          }
          localObject1 = localObject2;
          if (((MessageForDeviceFile)localObject3).msgStatus == 2)
          {
            localMsgSummary.nState = 1;
            localObject1 = localObject2;
            continue;
            if (localMessage.msgtype == -4501)
            {
              localObject1 = new MessageForDevPtt();
              ((MessageForDevPtt)localObject1).msgData = localMessage.msgData;
              ((MessageForDevPtt)localObject1).parse();
              if (((MessageForDevPtt)localObject1).fileSize == -1L)
              {
                localMsgSummary.nState = 2;
                localObject1 = localObject2;
                if (!"device_groupchat".equals(localMessage.extStr)) {
                  continue;
                }
                if (!localMessage.isSend()) {
                  break label1091;
                }
              }
              for (localMessage.nickName = paramQQAppInterface.getApp().getString(2131694674);; localMessage.nickName = bdgc.b(paramQQAppInterface, localMessage.senderuin, true))
              {
                bdil.a(paramContext, paramQQAppInterface, localMessage, this.mUser.getType(), localMsgSummary, localMessage.nickName, true, false);
                localObject1 = localObject2;
                break;
                if (((MessageForDevPtt)localObject1).fileSize != -3L) {
                  break label999;
                }
                localMsgSummary.nState = 1;
                break label999;
              }
            }
            else if (localMessage.msgtype == -4503)
            {
              localObject3 = new MessageForDevShortVideo();
              ((MessageForDevShortVideo)localObject3).msgData = localMessage.msgData;
              ((MessageForDevShortVideo)localObject3).parse();
              if (((MessageForDevShortVideo)localObject3).videoFileStatus == 1005)
              {
                localMsgSummary.nState = 2;
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = localObject2;
                if (((MessageForDevShortVideo)localObject3).videoFileStatus == 1002)
                {
                  localObject1 = ((zxz)paramQQAppInterface.a(49)).a();
                  if (localObject1 != null)
                  {
                    i = 1;
                    if (((zux)localObject1).a(localMessage.uniseq)) {
                      break label1245;
                    }
                  }
                  for (int j = 1;; j = 0)
                  {
                    if ((i & j) == 0) {
                      break label1251;
                    }
                    localMsgSummary.nState = 2;
                    localObject1 = localObject2;
                    break;
                    i = 0;
                    break label1204;
                  }
                  localMsgSummary.nState = 1;
                  localObject1 = localObject2;
                }
              }
            }
            else if (localMessage.msgtype == -4509)
            {
              localObject3 = new MessageForDevLittleVideo();
              ((MessageForDevLittleVideo)localObject3).msgData = localMessage.msgData;
              ((MessageForDevLittleVideo)localObject3).parse();
              if (((MessageForDevLittleVideo)localObject3).videoFileStatus == 1005)
              {
                localMsgSummary.nState = 2;
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = localObject2;
                if (((MessageForDevLittleVideo)localObject3).videoFileStatus == 1002)
                {
                  localObject1 = ((zxz)paramQQAppInterface.a(49)).a();
                  if (!agoz.b((MessageRecord)localObject3)) {
                    if (localObject1 == null) {
                      break label1395;
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    if ((i & ((zux)localObject1).a(localMessage.uniseq)) == 0) {
                      break label1400;
                    }
                    localMsgSummary.nState = 1;
                    localObject1 = localObject2;
                    break;
                  }
                  localMsgSummary.nState = 2;
                  localObject1 = localObject2;
                }
              }
            }
            else
            {
              localObject1 = localObject2;
              if (localMessage.msgtype == -4508)
              {
                if ("device_groupchat".equals(localMessage.extStr))
                {
                  if (localMessage.isSend()) {}
                  for (localMessage.nickName = paramQQAppInterface.getApp().getString(2131694674);; localMessage.nickName = bdgc.b(paramQQAppInterface, localMessage.senderuin, true))
                  {
                    bdil.a(paramContext, paramQQAppInterface, localMessage, this.mUser.getType(), localMsgSummary, localMessage.nickName, true, false);
                    localObject1 = localObject2;
                    break;
                  }
                }
                bdil.a(paramContext, paramQQAppInterface, localMessage, this.mUser.getType(), localMsgSummary, null, true, false);
                localObject1 = localObject2;
                continue;
                a(paramQQAppInterface, paramContext, (QQMessageFacade)localObject4, localMessage);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    case 1006: 
      label660:
      label716:
      label999:
      label1395:
      label1400:
      localObject3 = bdgc.e(paramQQAppInterface, this.mUser.uin);
      label920:
      label946:
      label1091:
      label1245:
      label1251:
      localObject1 = (aufv)paramQQAppInterface.getManager(11);
      label1204:
      if (localObject1 == null) {
        break;
      }
    }
    for (localObject1 = ((aufv)localObject1).c(this.mUser.uin);; localObject1 = null)
    {
      if (localObject1 != null) {
        this.mTitleName = ((PhoneContact)localObject1).name;
      }
      for (;;)
      {
        a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
        if ((localMessage == null) || ((localMessage.getMessageText() == null) && ((localMessage.msgtype != -2011) || (localMessage.msgData == null)))) {
          break label1713;
        }
        this.mDisplayTime = localMessage.time;
        localObject1 = localObject2;
        break;
        if (localObject3 != null) {
          this.mTitleName = bdgc.b(paramQQAppInterface, (String)localObject3, true);
        } else {
          this.mTitleName = this.mUser.uin;
        }
      }
      label1713:
      this.mDisplayTime = 0L;
      localObject1 = localObject2;
      break;
      this.mTitleName = bdgc.b(paramQQAppInterface, this.mUser.uin, true);
      a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
      if ((localMessage != null) && ((localMessage.getMessageText() != null) || ((localMessage.msgtype == -2011) && (localMessage.msgData != null))))
      {
        this.mDisplayTime = localMessage.time;
        localObject1 = localObject2;
        break;
      }
      this.mDisplayTime = 0L;
      localObject1 = localObject2;
      break;
      boolean bool1 = aobk.a(paramQQAppInterface).b(this.mUser.uin);
      if ((this.mUnreadNum > 0) && (bool1))
      {
        this.mMsgExtroInfo = paramContext.getString(2131717874);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167008);
      }
      if (0 == 0) {}
      for (localObject1 = (alto)paramQQAppInterface.getManager(51);; localObject1 = null)
      {
        if ((this.mUser.getType() == 0) && (((alto)localObject1).b(this.mUser.uin)))
        {
          if (aglv.a().a(paramQQAppInterface) != 1) {
            break label2762;
          }
          i = 1;
          label1923:
          this.mQimOnline = 0;
          if ((i != 0) && (aglv.a().a()))
          {
            localObject2 = ((alto)localObject1).e(this.mUser.uin);
            if ((localObject2 != null) && (((Friends)localObject2).netTypeIconId == 11))
            {
              this.mQimOnline = 1;
              ThreadManager.post(new RecentItemChatMsgData.1(this, paramQQAppInterface), 5, null, true);
            }
          }
        }
        label2011:
        boolean bool2;
        if (a((alto)localObject1, this.mUser.uin))
        {
          this.mUnreadFlag = 4;
          if (FriendsStatusUtil.a(this.mUser.uin, paramQQAppInterface)) {
            this.mUnreadFlag = 3;
          }
          bool2 = afex.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface);
          if ((!bool2) || (amjn.a(paramQQAppInterface.c(), paramContext))) {
            break label2775;
          }
          this.mUnreadFlag = 0;
          label2071:
          if ((localMessage == null) || ((localMessage.getMessageText() == null) && (localMessage.msgData == null) && ((localMessage.msgtype != -2011) || (this.mUser.getType() != 0)))) {
            break label2848;
          }
          this.mDisplayTime = localMessage.time;
          if (this.mDisplayTime == 0L) {
            this.mDisplayTime = this.mUser.opTime;
          }
          if (localMessage.msgtype != -2011) {
            break label2859;
          }
          long l = paramQQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("uid" + localMessage.frienduin, 0L);
          localObject2 = ((QQMessageFacade)localObject4).b(this.mUser.uin, this.mUser.getType());
          if ((localObject2 == null) || (!(localObject2 instanceof MessageForStructing))) {
            break label3977;
          }
          localObject3 = (MessageForStructing)localObject2;
          if (((MessageForStructing)localObject3).structingMsg == null) {
            ((MessageForStructing)localObject3).parse();
          }
          if (((MessageForStructing)localObject3).structingMsg == null) {
            break label3977;
          }
          if ((l != localMessage.msgUid) || (((MessageForStructing)localObject3).structingMsg.mMsgServiceID != 76)) {
            break label2804;
          }
          localObject3 = ((MessageForStructing)localObject3).structingMsg.mMsgBrief;
          localObject4 = paramContext.getString(2131698087);
          if ((((MessageRecord)localObject2).isread) || (TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).startsWith((String)localObject4))) {
            break label2788;
          }
          this.mMsgExtroInfo = ((CharSequence)localObject4);
          localMessage.msg = ((String)localObject3).substring(((String)localObject4).length());
          label2368:
          this.mExtraInfoColor = paramContext.getResources().getColor(2131166981);
          i = 0;
        }
        for (;;)
        {
          label2383:
          a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
          if ((i != 0) && (this.mUnreadNum > 0) && ((this.mUser.msg instanceof MessageRecord)) && (!((MessageRecord)this.mUser.msg).isread)) {
            localMsgSummary.suffix = "";
          }
          if ((i == 0) && ((this.mUser.msg instanceof MessageForStructing)) && (localMessage != null) && (localMessage.msgtype != -1034))
          {
            localObject2 = (MessageForStructing)this.mUser.msg;
            if ((!((MessageForStructing)localObject2).isread) && (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 107)) {
              a(paramContext, localMessage, (MessageForStructing)localObject2);
            }
          }
          if ((localMessage != null) && (localMessage.msgtype == -1034))
          {
            localObject2 = new MessageForRichState();
            ((MessageForRichState)localObject2).msg = localMessage.msg;
            ((MessageForRichState)localObject2).mIsParsed = false;
            ((MessageForRichState)localObject2).parse();
            if (paramQQAppInterface.a().f(localMessage.frienduin) < ((MessageForRichState)localObject2).time)
            {
              this.mMsgExtroInfo = alud.a(2131713577);
              this.mExtraInfoColor = paramContext.getResources().getColor(2131166981);
              label2612:
              this.mIsSignMsg = true;
            }
          }
          else
          {
            if ((localMessage != null) && (localMessage.msgtype == -2074))
            {
              localObject2 = new MessageForAIOStoryVideo();
              ((MessageForAIOStoryVideo)localObject2).msg = localMessage.msg;
              ((MessageForAIOStoryVideo)localObject2).mIsParsed = false;
              ((MessageForAIOStoryVideo)localObject2).parse();
              this.mMsgExtroInfo = alud.a(2131713553);
              this.mExtraInfoColor = paramContext.getResources().getColor(2131166977);
            }
            if (!alof.J.equals(this.mUser.uin)) {
              break label2891;
            }
            this.mTitleName = paramContext.getString(2131720531);
          }
          for (;;)
          {
            if ((localMessage == null) || (localMessage.msgtype != -2040)) {
              break label3144;
            }
            localObject2 = new MessageForApproval();
            ((MessageForApproval)localObject2).msgData = localMessage.msgData;
            localMsgSummary.strContent = ((MessageForApproval)localObject2).getFullTitle();
            break;
            label2762:
            i = 0;
            break label1923;
            this.mUnreadFlag = 1;
            break label2011;
            label2775:
            if (!bool2) {
              break label2071;
            }
            this.mUnreadFlag = 3;
            break label2071;
            label2788:
            this.mMsgExtroInfo = "";
            localMessage.msg = ((String)localObject3);
            break label2368;
            label2804:
            if ((((MessageForStructing)localObject3).structingMsg.mMsgServiceID != 107) || (bool1)) {
              break label3977;
            }
            a(paramContext, localMessage, (MessageForStructing)localObject2);
            this.mUser.msg = localObject3;
            i = 1;
            break label2383;
            label2848:
            this.mDisplayTime = this.mUser.opTime;
            label2859:
            i = 0;
            break label2383;
            this.mMsgExtroInfo = alud.a(2131713576);
            this.mExtraInfoColor = paramContext.getResources().getColor(2131166977);
            break label2612;
            label2891:
            if (alof.E.equals(this.mUser.uin))
            {
              this.mTitleName = paramContext.getString(2131720599);
              if ((localMessage != null) && (localMessage.msg != null)) {
                localMsgSummary.strContent = localMessage.msg;
              }
            }
            else if (this.mUser.getType() == 1000)
            {
              localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
              if (localObject2 != null)
              {
                localObject2 = ((TroopManager)localObject2).b(this.mUser.troopUin);
                this.mTitleName = bdgc.a(paramQQAppInterface, this.mUser.uin, (String)localObject2, this.mUser.troopUin, true, null);
              }
            }
            else if (this.mUser.getType() == 1004)
            {
              this.mTitleName = bdgc.c(paramQQAppInterface, this.mUser.troopUin, this.mUser.uin);
              if ((this.mTitleName != null) && (this.mTitleName.equals(this.mUser.uin))) {
                this.mTitleName = bdgc.b(paramQQAppInterface, this.mUser.uin, true);
              }
            }
            else if (this.mUser.getType() == 10007)
            {
              this.mTitleName = asmw.a(this.mUser.uin, paramQQAppInterface);
            }
            else
            {
              this.mTitleName = bdgc.b(paramQQAppInterface, this.mUser.uin, true);
            }
          }
          label3144:
          if ((localMessage != null) && (localMessage.msgtype == -2041))
          {
            localObject2 = paramContext.getString(2131690220);
            localObject3 = paramContext.getString(2131690217);
            localMsgSummary.strContent = ((String)localObject2 + " " + (String)localObject3);
            break;
          }
          if ((localMessage != null) && (localMessage.msgtype == -2025))
          {
            if (this.mUnreadNum <= 0) {
              break label3477;
            }
            localObject3 = paramContext.getString(2131693391);
            localObject4 = localMessage.msg;
            if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject4).startsWith((String)localObject3)))
            {
              this.mExtraInfoColor = paramContext.getResources().getColor(2131167008);
              if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
                break label3450;
              }
              localObject2 = localObject3;
              label3296:
              this.mMsgExtroInfo = ((CharSequence)localObject2);
              localMsgSummary.strContent = ((String)localObject4).replace((CharSequence)localObject3, "");
            }
          }
          for (;;)
          {
            if ((localMessage != null) && (localMessage.msgtype == -2061)) {
              localMsgSummary.strContent = "";
            }
            if ((this.mUser.getType() == 1024) && (!bfyh.b(paramQQAppInterface, this.mUser.uin))) {
              this.mAuthenIconId = ndv.a(paramQQAppInterface, this.mUser.uin);
            }
            if (bdeu.b(this.mUser.uin)) {
              this.mAuthenIconId = 2130841432;
            }
            if ((this.mUser.getType() != 0) || (((alto)localObject1).a(this.mUser.uin) != 1)) {
              break label3974;
            }
            this.mQimIconUrl = ((FlashChatManager)paramQQAppInterface.getManager(217)).a.d;
            break;
            label3450:
            localObject2 = this.mMsgExtroInfo + (String)localObject3;
            break label3296;
            label3477:
            this.mMsgExtroInfo = "";
          }
          this.mTitleName = paramContext.getString(2131696949);
          localObject3 = "";
          localObject1 = null;
          if (localObject4 != null) {
            localObject1 = ((QQMessageFacade)localObject4).b(alof.D, 4000);
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
            if (((MessageRecord)localObject1).msg != null) {
              if (((MessageRecord)localObject1).msgtype == -1033)
              {
                localObject1 = ((MessageRecord)localObject1).msg;
                localObject1 = alud.a(2131713559) + (String)localObject1;
              }
            }
          }
          for (;;)
          {
            localMsgSummary.strContent = ((CharSequence)localObject1);
            if ((localMessage != null) && (localMessage.getMessageText() != null))
            {
              this.mDisplayTime = localMessage.time;
              localObject1 = localObject2;
              break;
              if (((MessageRecord)localObject1).msgtype == -1030)
              {
                if ((aufv)paramQQAppInterface.getManager(11) != null) {}
                localObject1 = alud.a(2131713562) + "";
                continue;
              }
              if (((MessageRecord)localObject1).msgtype == -1039)
              {
                localObject1 = (ambh)paramQQAppInterface.getManager(22);
                if (localObject1 == null) {
                  break label3967;
                }
                localObject1 = paramContext.getResources().getString(2131696951) + ((ambh)localObject1).a();
                continue;
              }
              if (((MessageRecord)localObject1).msgtype != -1040) {
                break label3960;
              }
              localObject4 = (ambh)paramQQAppInterface.getManager(22);
              localObject1 = localObject3;
              if (localObject4 != null) {
                localObject1 = ((ambh)localObject4).a();
              }
              continue;
            }
            this.mDisplayTime = 0L;
            localObject1 = localObject2;
            break;
            this.mTitleName = alud.a(2131713579);
            localMsgSummary.strContent = "可连接ArkIDE进行真机调试";
            this.mUnreadNum = 0;
            localObject1 = localObject2;
            break;
            label3844:
            a(paramQQAppInterface, paramContext, localMessage);
            break label456;
            label3855:
            if (this.mUnreadNum == 1)
            {
              ((StringBuilder)localObject3).append("有一条未读");
              break label502;
            }
            if (this.mUnreadNum == 2)
            {
              ((StringBuilder)localObject3).append("有两条未读");
              break label502;
            }
            if (this.mUnreadNum <= 0) {
              break label502;
            }
            ((StringBuilder)localObject3).append("有").append(this.mUnreadNum).append("条未读,");
            break label502;
            ((StringBuilder)localObject3).append(paramContext.a).append(",");
            break label660;
            label3946:
            this.mContentDesc = ((StringBuilder)localObject3).toString();
            label3955:
            e();
            return;
            label3960:
            localObject1 = "";
            continue;
            label3967:
            localObject1 = "";
          }
          label3974:
          break;
          label3977:
          i = 0;
        }
      }
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade paramQQMessageFacade, QQMessageFacade.Message paramMessage) {}
  
  public long c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData
 * JD-Core Version:    0.7.0.1
 */