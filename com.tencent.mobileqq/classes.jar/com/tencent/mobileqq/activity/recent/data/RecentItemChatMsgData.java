package com.tencent.mobileqq.activity.recent.data;

import QQService.EVIPSPEC;
import abur;
import abvz;
import abzb;
import ache;
import aguy;
import aifn;
import aiit;
import ajka;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import antf;
import anyw;
import anzj;
import aoga;
import aogu;
import aorf;
import aqqr;
import auvi;
import avlf;
import axfr;
import axsi;
import axtj;
import axtt;
import baou;
import baox;
import bcrg;
import behh;
import bhjx;
import bhlg;
import bhnt;
import bkgt;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
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
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import nok;

public class RecentItemChatMsgData
  extends RecentItemChatMsgBaseData
{
  private static final String IS_LAST_RECEIPT = "lastIsReceipt";
  private static final String IS_SIGN_MSG = "IS_SIGN_MSG";
  private static final String IS_SPECIAL_CARE_FRIEND = "isSpecialCareFriend";
  @ParcelAnnotation.NotParcel
  private static ArrayList<Integer> sC2CLikeUINType = new RecentItemChatMsgData.1(32);
  public int haloState;
  public int mBubbleID;
  public String mQimIconUrl;
  public int mQimOnline;
  @ParcelAnnotation.NotParcel
  public RecentUser mUser;
  @ParcelAnnotation.NotParcel
  protected QQMessageFacade.Message msg;
  
  public RecentItemChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUser = paramRecentUser;
  }
  
  private void a()
  {
    switch (this.mUser.getType())
    {
    }
    for (;;)
    {
      this.mArgsBundle.putBoolean("isEnableUnreadState", false);
      return;
      this.mArgsBundle.putBoolean("isEnableUnreadState", true);
    }
  }
  
  private void a(Context paramContext)
  {
    Object localObject;
    if ((this.msg != null) && (this.msg.msgtype == -2040))
    {
      localObject = new MessageForApproval();
      ((MessageForApproval)localObject).msgData = this.msg.msgData;
      this.msgSummary.strContent = ((MessageForApproval)localObject).getFullTitle();
    }
    if ((this.msg != null) && (this.msg.msgtype == -2041))
    {
      localObject = paramContext.getString(2131690083);
      paramContext = paramContext.getString(2131690082);
      this.msgSummary.strContent = ((String)localObject + " " + paramContext);
    }
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage, MessageForStructing paramMessageForStructing)
  {
    String str1 = paramMessageForStructing.structingMsg.mMsgBrief;
    String str2 = paramContext.getString(2131697791);
    if ((!paramMessageForStructing.isread) && (!TextUtils.isEmpty(str1))) {}
    for (this.mMsgExtroInfo = str2;; this.mMsgExtroInfo = "")
    {
      paramMessage.msg = str1;
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167157);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.mUser.getType() == 1024) && (!bkgt.b(paramQQAppInterface, this.mUser.uin))) {
      this.mAuthenIconId = nok.a(paramQQAppInterface, this.mUser.uin);
    }
    if (bhjx.b(this.mUser.uin)) {
      this.mAuthenIconId = 2130841751;
    }
  }
  
  private boolean a(anyw paramanyw, String paramString)
  {
    if ((paramanyw == null) || (TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        paramanyw = paramanyw.b(paramString);
      } while ((paramanyw == null) || (!paramanyw.isFriend()));
      bool1 = paramanyw.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramanyw.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  private boolean a(QQMessageFacade.Message paramMessage)
  {
    return (this.mUser.getType() == 0) && (TextUtils.isEmpty(this.mMsgExtroInfo)) && (getUnreadNum() <= 0) && (this.mStatus == 0) && (this.msgSummary.nState == 0) && ((paramMessage == null) || (paramMessage.msgtype != -5040)) && (this.msgSummary.suffix == null) && (this.msgSummary.strPrefix == null);
  }
  
  private void b()
  {
    if ((antf.E.equals(this.mUser.uin)) && (this.msg != null) && (this.msg.msg != null)) {
      this.msgSummary.strContent = this.msg.msg;
    }
  }
  
  private void b(Context paramContext)
  {
    boolean bool = this.mArgsBundle.getBoolean("lastIsReceipt", false);
    if ((bool) && (this.mUnreadNum > 0) && ((this.mUser.msg instanceof MessageRecord)) && (!((MessageRecord)this.mUser.msg).isread)) {
      this.msgSummary.suffix = "";
    }
    if ((!bool) && ((this.mUser.msg instanceof MessageForStructing)) && (this.msg != null) && (this.msg.msgtype != -1034))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)this.mUser.msg;
      if ((!localMessageForStructing.isread) && (localMessageForStructing.structingMsg.mMsgServiceID == 107)) {
        a(paramContext, this.msg, localMessageForStructing);
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    anyw localanyw = (anyw)paramQQAppInterface.getManager(51);
    if ((this.mUser.getType() == 0) && (localanyw.b(this.mUser.uin))) {
      if (aifn.a().a(paramQQAppInterface) != 1) {
        break label159;
      }
    }
    label159:
    for (int i = 1;; i = 0)
    {
      this.mQimOnline = 0;
      if ((i != 0) && (aifn.a().a()))
      {
        Friends localFriends = localanyw.e(this.mUser.uin);
        if ((localFriends != null) && (localFriends.netTypeIconId == 11))
        {
          this.mQimOnline = 1;
          ThreadManager.post(new RecentItemChatMsgData.2(this, paramQQAppInterface), 5, null, true);
        }
      }
      if ((this.mUser.getType() == 0) && (localanyw.a(this.mUser.uin) == 1)) {
        this.mQimIconUrl = ((FlashChatManager)paramQQAppInterface.getManager(217)).a.d;
      }
      return;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    FeedsManager.hideStatus(getRecentUserUin());
    if ((this.msgSummary.bShowDraft) && (this.mArgsBundle.getBoolean("IS_SIGN_MSG", false)))
    {
      this.msgSummary.strContent = "";
      this.mMsgExtroInfo = "";
      return;
    }
    p(paramQQAppInterface, paramContext);
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    this.mTitleName = paramContext.getString(2131695822);
    String str = "";
    Object localObject = null;
    if (localQQMessageFacade != null) {
      localObject = localQQMessageFacade.b(antf.D, 4000);
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
      if (((MessageRecord)localObject).msg != null) {
        if (((MessageRecord)localObject).msgtype == -1033)
        {
          paramQQAppInterface = ((MessageRecord)localObject).msg;
          paramQQAppInterface = anzj.a(2131712047) + paramQQAppInterface;
        }
      }
    }
    for (;;)
    {
      this.msgSummary.strContent = paramQQAppInterface;
      if ((paramMessage != null) && (paramMessage.getMessageText() != null))
      {
        this.mDisplayTime = paramMessage.time;
        return;
        if (((MessageRecord)localObject).msgtype == -1030)
        {
          if ((axfr)paramQQAppInterface.getManager(11) != null) {}
          paramQQAppInterface = anzj.a(2131712050) + "";
          continue;
        }
        if (((MessageRecord)localObject).msgtype == -1039)
        {
          paramQQAppInterface = (aoga)paramQQAppInterface.getManager(22);
          if (paramQQAppInterface == null) {
            break label313;
          }
          paramQQAppInterface = paramContext.getResources().getString(2131695824) + paramQQAppInterface.a();
          continue;
        }
        if (((MessageRecord)localObject).msgtype == -1040)
        {
          paramContext = (aoga)paramQQAppInterface.getManager(22);
          paramQQAppInterface = str;
          if (paramContext != null) {
            paramQQAppInterface = paramContext.a();
          }
        }
      }
      else
      {
        this.mDisplayTime = 0L;
        return;
      }
      paramQQAppInterface = "";
      continue;
      label313:
      paramQQAppInterface = "";
    }
  }
  
  private void c()
  {
    if ((this.msg != null) && (this.msg.msgtype == -2061)) {
      this.msgSummary.strContent = "";
    }
  }
  
  private void c(Context paramContext)
  {
    String str1;
    String str2;
    if ((this.msg != null) && (this.msg.msgtype == -2025))
    {
      if (this.mUnreadNum <= 0) {
        break label129;
      }
      str1 = paramContext.getString(2131692883);
      str2 = this.msg.msg;
      if ((!TextUtils.isEmpty(str2)) && (str2.startsWith(str1)))
      {
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167102);
        if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
          break label104;
        }
      }
    }
    label104:
    for (paramContext = str1;; paramContext = this.mMsgExtroInfo + str1)
    {
      this.mMsgExtroInfo = paramContext;
      this.msgSummary.strContent = str2.replace(str1, "");
      return;
    }
    label129:
    this.mMsgExtroInfo = "";
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    if (AppSetting.c)
    {
      anyw localanyw = (anyw)paramQQAppInterface.getManager(51);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mTitleName).append(",");
      Object localObject;
      if (this.mUnreadNum == 0)
      {
        if (this.mMsgExtroInfo != null) {
          localStringBuilder.append(this.mMsgExtroInfo + ",");
        }
        String str = behh.e(this.mLastMsg.toString());
        localObject = str;
        if (this.msg != null)
        {
          localObject = str;
          if (this.msg.msgtype == -5040)
          {
            localObject = str;
            if (axtt.a(paramQQAppInterface, this.msg)) {
              localObject = axtt.a(str);
            }
          }
        }
        localStringBuilder.append((String)localObject).append(",").append(this.mShowTime);
        if ((this.mUser.getType() == 0) && (localanyw.b(this.mUser.uin)))
        {
          paramQQAppInterface = axsi.a(paramQQAppInterface, this.mUser.uin, false, 5);
          if (paramQQAppInterface != null) {
            paramQQAppInterface = paramQQAppInterface.iterator();
          }
        }
      }
      else
      {
        for (;;)
        {
          if (!paramQQAppInterface.hasNext()) {
            break label347;
          }
          localObject = (axtj)paramQQAppInterface.next();
          if (!TextUtils.isEmpty(((axtj)localObject).d))
          {
            localStringBuilder.append(((axtj)localObject).d).append(",");
            continue;
            if (this.mUnreadNum == 1)
            {
              localStringBuilder.append("有一条未读");
              break;
            }
            if (this.mUnreadNum == 2)
            {
              localStringBuilder.append("有两条未读");
              break;
            }
            if (this.mUnreadNum <= 0) {
              break;
            }
            localStringBuilder.append("有").append(this.mUnreadNum).append("条未读,");
            break;
          }
          localStringBuilder.append(((axtj)localObject).a).append(",");
        }
      }
      label347:
      this.mContentDesc = localStringBuilder.toString();
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int i = this.mUser.getType();
    if (sC2CLikeUINType.contains(Integer.valueOf(i)))
    {
      d(paramQQAppInterface, paramContext);
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 1006: 
      m(paramQQAppInterface, paramContext);
      return;
    case 9501: 
      n(paramQQAppInterface, paramContext);
      return;
    case 1008: 
      a(paramQQAppInterface, paramContext, this.msg);
      return;
    case 1021: 
      l(paramQQAppInterface, paramContext);
      return;
    case 4000: 
      b(paramQQAppInterface, paramContext, this.msg);
      return;
    }
    d();
  }
  
  private void c(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    int i = 0;
    int j = 0;
    if (paramMessage.msgtype == -4500)
    {
      paramQQAppInterface = new MessageForDeviceFile();
      paramQQAppInterface.msgData = paramMessage.msgData;
      paramQQAppInterface.parse();
      if (paramQQAppInterface.msgStatus == 1) {
        this.msgSummary.nState = 2;
      }
    }
    label52:
    label123:
    do
    {
      do
      {
        do
        {
          break label52;
          return;
          MessageForDevPtt localMessageForDevPtt;
          if (paramQQAppInterface.msgStatus == 2)
          {
            this.msgSummary.nState = 1;
            return;
            if (paramMessage.msgtype != -4501) {
              break label220;
            }
            localMessageForDevPtt = new MessageForDevPtt();
            localMessageForDevPtt.msgData = paramMessage.msgData;
            localMessageForDevPtt.parse();
            if (localMessageForDevPtt.fileSize == -1L)
            {
              this.msgSummary.nState = 2;
              if (!"device_groupchat".equals(paramMessage.extStr)) {
                break label202;
              }
              if (!paramMessage.isSend()) {
                break label204;
              }
            }
          }
          for (paramMessage.nickName = paramQQAppInterface.getApp().getString(2131693925);; paramMessage.nickName = bhlg.b(paramQQAppInterface, paramMessage.senderuin, true))
          {
            bhnt.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, paramMessage.nickName, true, false);
            return;
            if (localMessageForDevPtt.fileSize != -3L) {
              break label123;
            }
            this.msgSummary.nState = 1;
            break label123;
            break;
            break;
          }
          if (paramMessage.msgtype != -4503) {
            break;
          }
          paramContext = new MessageForDevShortVideo();
          paramContext.msgData = paramMessage.msgData;
          paramContext.parse();
          if (paramContext.videoFileStatus == 1005)
          {
            this.msgSummary.nState = 2;
            return;
          }
        } while (paramContext.videoFileStatus != 1002);
        paramQQAppInterface = ((abzb)paramQQAppInterface.a(49)).a();
        if (paramQQAppInterface != null) {}
        for (i = 1;; i = 0)
        {
          if (!paramQQAppInterface.a(paramMessage.uniseq)) {
            j = 1;
          }
          if ((i & j) == 0) {
            break;
          }
          this.msgSummary.nState = 2;
          return;
        }
        this.msgSummary.nState = 1;
        return;
        if (paramMessage.msgtype != -4509) {
          break;
        }
        paramContext = new MessageForDevLittleVideo();
        paramContext.msgData = paramMessage.msgData;
        paramContext.parse();
        if (paramContext.videoFileStatus == 1005)
        {
          this.msgSummary.nState = 2;
          return;
        }
      } while (paramContext.videoFileStatus != 1002);
      paramQQAppInterface = ((abzb)paramQQAppInterface.a(49)).a();
      if (!aiit.b(paramContext))
      {
        if (paramQQAppInterface != null) {
          i = 1;
        }
        if (!(paramQQAppInterface.a(paramMessage.uniseq) & i)) {}
      }
      else
      {
        this.msgSummary.nState = 1;
        return;
      }
      this.msgSummary.nState = 2;
      return;
    } while (paramMessage.msgtype != -4508);
    label202:
    label204:
    label220:
    if ("device_groupchat".equals(paramMessage.extStr))
    {
      if (paramMessage.isSend()) {}
      for (paramMessage.nickName = paramQQAppInterface.getApp().getString(2131693925);; paramMessage.nickName = bhlg.b(paramQQAppInterface, paramMessage.senderuin, true))
      {
        bhnt.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, paramMessage.nickName, true, false);
        return;
      }
    }
    bhnt.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, null, true, false);
  }
  
  private void d()
  {
    this.mTitleName = anzj.a(2131712067);
    this.msgSummary.strContent = "可连接ArkIDE进行真机调试";
    this.mUnreadNum = 0;
  }
  
  private void d(Context paramContext)
  {
    if ((this.msg != null) && (this.msg.msgtype == -2074))
    {
      MessageForAIOStoryVideo localMessageForAIOStoryVideo = new MessageForAIOStoryVideo();
      localMessageForAIOStoryVideo.msg = this.msg.msg;
      localMessageForAIOStoryVideo.mIsParsed = false;
      localMessageForAIOStoryVideo.parse();
      this.mMsgExtroInfo = anzj.a(2131712041);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167070);
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (this.mUnreadNum > 0)
    {
      this.mBubbleID = ((aogu)paramQQAppInterface.a(13)).a(this.msg);
      return;
    }
    this.mBubbleID = 0;
  }
  
  private void d(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    e(paramQQAppInterface, paramContext);
    f(paramQQAppInterface, paramContext);
    g(paramQQAppInterface, paramContext);
    h(paramQQAppInterface, paramContext);
    i(paramQQAppInterface, paramContext);
    k(paramQQAppInterface, paramContext);
    b(paramQQAppInterface);
    b(paramContext);
    j(paramQQAppInterface, paramContext);
    d(paramContext);
    b();
    a(paramContext);
    c(paramContext);
    c();
    a(paramQQAppInterface);
  }
  
  private void e(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.mUser.getType() != 0)
    {
      processC2CDisplayTimeInner();
      this.mTitleName = bhlg.b(paramQQAppInterface, this.mUser.uin, true);
      buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
    }
  }
  
  private void f(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = aqqr.a(paramQQAppInterface).b(this.mUser.uin);
    this.mArgsBundle.putBoolean("isSpecialCareFriend", bool);
    if ((this.mUnreadNum > 0) && (bool))
    {
      this.mMsgExtroInfo = paramContext.getString(2131716145);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167102);
    }
  }
  
  private void g(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((this.mUser.getType() == 0) && (((ajka)paramQQAppInterface.getManager(34)).b(this.mUser.uin)))
    {
      this.mMsgExtroInfo = paramContext.getString(2131693980);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167102);
    }
  }
  
  private void h(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((this.msg == null) || ((this.msg.getMessageText() == null) && (this.msg.msgData == null) && ((this.msg.msgtype != -2011) || (this.mUser.getType() != 0)))) {}
    Object localObject1;
    Object localObject2;
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            return;
            this.mDisplayTime = this.msg.time;
            if (this.mDisplayTime == 0L) {
              this.mDisplayTime = this.mUser.opTime;
            }
            localObject1 = paramQQAppInterface.a();
          } while (this.msg.msgtype != -2011);
          l = paramQQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("uid" + this.msg.frienduin, 0L);
          localObject1 = ((QQMessageFacade)localObject1).b(this.mUser.uin, this.mUser.getType());
        } while ((localObject1 == null) || (!(localObject1 instanceof MessageForStructing)));
        localObject2 = (MessageForStructing)localObject1;
        if (((MessageForStructing)localObject2).structingMsg == null) {
          ((MessageForStructing)localObject2).parse();
        }
      } while (((MessageForStructing)localObject2).structingMsg == null);
      if ((l == this.msg.msgUid) && (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 76))
      {
        localObject2 = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
        String str = paramContext.getString(2131696982);
        if ((!((MessageRecord)localObject1).isread) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).startsWith(str))) {
          this.mMsgExtroInfo = str;
        }
        for (this.msg.msg = ((String)localObject2).substring(str.length());; this.msg.msg = ((String)localObject2))
        {
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167074);
          buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
          return;
          this.mMsgExtroInfo = "";
        }
      }
    } while ((((MessageForStructing)localObject2).structingMsg.mMsgServiceID != 107) || (this.mArgsBundle.getBoolean("isSpecialCareFriend", false)));
    a(paramContext, this.msg, (MessageForStructing)localObject1);
    this.mUser.msg = localObject2;
    this.mArgsBundle.putBoolean("lastIsReceipt", true);
    buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
  }
  
  private void i(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (antf.J.equals(this.mUser.uin)) {
      this.mTitleName = paramContext.getString(2131718502);
    }
    do
    {
      do
      {
        return;
        if (antf.E.equals(this.mUser.uin))
        {
          this.mTitleName = paramContext.getString(2131718534);
          return;
        }
        if (this.mUser.getType() != 1000) {
          break;
        }
        paramContext = (TroopManager)paramQQAppInterface.getManager(52);
      } while (paramContext == null);
      paramContext = paramContext.b(this.mUser.troopUin);
      this.mTitleName = bhlg.a(paramQQAppInterface, this.mUser.uin, paramContext, this.mUser.troopUin, true, null);
      return;
      if (this.mUser.getType() != 1004) {
        break;
      }
      this.mTitleName = bhlg.c(paramQQAppInterface, this.mUser.troopUin, this.mUser.uin);
    } while ((this.mTitleName == null) || (!this.mTitleName.equals(this.mUser.uin)));
    this.mTitleName = bhlg.b(paramQQAppInterface, this.mUser.uin, true);
    return;
    if (this.mUser.getType() == 10007)
    {
      this.mTitleName = avlf.a(this.mUser.uin, paramQQAppInterface);
      return;
    }
    this.mTitleName = bhlg.b(paramQQAppInterface, this.mUser.uin, true);
  }
  
  private void j(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((this.msg != null) && (this.msg.msgtype == -1034))
    {
      MessageForRichState localMessageForRichState = new MessageForRichState();
      localMessageForRichState.msg = this.msg.msg;
      localMessageForRichState.mIsParsed = false;
      localMessageForRichState.parse();
      if (paramQQAppInterface.a().f(this.msg.frienduin) >= localMessageForRichState.time) {
        break label105;
      }
      this.mMsgExtroInfo = anzj.a(2131712065);
    }
    for (this.mExtraInfoColor = paramContext.getResources().getColor(2131167074);; this.mExtraInfoColor = paramContext.getResources().getColor(2131167070))
    {
      this.mArgsBundle.putBoolean("IS_SIGN_MSG", true);
      return;
      label105:
      this.mMsgExtroInfo = anzj.a(2131712064);
    }
  }
  
  private void k(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool;
    if (a((anyw)paramQQAppInterface.getManager(51), this.mUser.uin))
    {
      this.mUnreadFlag = 4;
      if (FriendsStatusUtil.a(this.mUser.uin, paramQQAppInterface)) {
        this.mUnreadFlag = 3;
      }
      bool = aguy.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface);
      if ((!bool) || (aorf.a(paramQQAppInterface.c(), paramContext))) {
        break label95;
      }
      this.mUnreadFlag = 0;
    }
    label95:
    while (!bool)
    {
      return;
      this.mUnreadFlag = 1;
      break;
    }
    this.mUnreadFlag = 3;
  }
  
  private void l(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mTitleName = bhlg.b(paramQQAppInterface, this.mUser.uin, true);
    buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
    if ((this.msg != null) && ((this.msg.getMessageText() != null) || ((this.msg.msgtype == -2011) && (this.msg.msgData != null))))
    {
      this.mDisplayTime = this.msg.time;
      return;
    }
    this.mDisplayTime = 0L;
  }
  
  private void m(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str = bhlg.e(paramQQAppInterface, this.mUser.uin);
    Object localObject = (axfr)paramQQAppInterface.getManager(11);
    if (localObject != null) {}
    for (localObject = ((axfr)localObject).c(this.mUser.uin);; localObject = null)
    {
      if (localObject != null) {
        this.mTitleName = ((PhoneContact)localObject).name;
      }
      for (;;)
      {
        buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
        if ((this.msg == null) || ((this.msg.getMessageText() == null) && ((this.msg.msgtype != -2011) || (this.msg.msgData == null)))) {
          break;
        }
        this.mDisplayTime = this.msg.time;
        return;
        if (str != null) {
          this.mTitleName = bhlg.b(paramQQAppInterface, str, true);
        } else {
          this.mTitleName = this.mUser.uin;
        }
      }
      this.mDisplayTime = 0L;
      return;
    }
  }
  
  private void n(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.msg != null)
    {
      this.msgSummary.strContent = this.msg.msg;
      this.mDisplayTime = this.msg.time;
      this.mAuthenIconId = 0;
      if ((this.msg.msgtype != -4502) || (!this.msg.frienduin.equals(antf.y))) {
        break label125;
      }
      this.mTitleName = "QQ物联";
    }
    for (;;)
    {
      if ((this.msgSummary.strContent == null) || (this.msgSummary.strContent.length() == 0)) {
        this.msgSummary.strContent = this.mTitleName;
      }
      this.mMenuFlag = 1;
      c(paramQQAppInterface, paramContext, this.msg);
      return;
      label125:
      DeviceInfo localDeviceInfo = ((abur)paramQQAppInterface.a(51)).a(Long.parseLong(this.msg.frienduin));
      if (localDeviceInfo != null) {
        this.mTitleName = ache.a(localDeviceInfo);
      }
    }
  }
  
  private void o(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.msg != null)
    {
      paramQQAppInterface = baou.a(paramQQAppInterface, this.msg.frienduin, this.msg.istroop, this.mUnreadNum, this.msg);
      this.mUnreadNum += paramQQAppInterface.a();
      if (paramQQAppInterface.a() > 0)
      {
        this.mMsgExtroInfo = paramQQAppInterface.a();
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167102);
      }
    }
  }
  
  private void p(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (a(this.msg))
    {
      paramQQAppInterface = (FeedsManager)paramQQAppInterface.getManager(275);
      String str = paramQQAppInterface.getSummary(getRecentUserUin());
      if (!TextUtils.isEmpty(str))
      {
        this.msgSummary.strContent = str;
        this.mMsgExtroInfo = anzj.a(2131712045);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167074);
        if (!FeedsManager.isShowStatus(getRecentUserUin())) {
          FeedsManager.showStatus(getRecentUserUin());
        }
        paramQQAppInterface.reportExposeStatus(getRecentUserUin());
      }
    }
    else
    {
      return;
    }
    FeedsManager.hideStatus(getRecentUserUin());
  }
  
  public RecentUser a()
  {
    return this.mUser;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.update(paramQQAppInterface, paramContext);
    this.msg = null;
    if ((this.mLastMessage instanceof QQMessageFacade.Message)) {
      this.msg = ((QQMessageFacade.Message)this.mLastMessage);
    }
    o(paramQQAppInterface, paramContext);
    a();
    c(paramQQAppInterface, paramContext);
    b(paramQQAppInterface, paramContext);
    d(paramQQAppInterface);
    extraUpdate(paramQQAppInterface, paramContext, this.msgSummary);
    c(paramQQAppInterface);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage) {}
  
  public final void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData
 * JD-Core Version:    0.7.0.1
 */