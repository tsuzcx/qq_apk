package com.tencent.mobileqq.activity.recent.data;

import QQService.EVIPSPEC;
import abgm;
import abhu;
import abkw;
import absz;
import agij;
import ahwv;
import ahzx;
import aizi;
import allz;
import alma;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import anvk;
import anvx;
import aoce;
import aocy;
import aomh;
import aqne;
import aulx;
import avdu;
import awyz;
import axlr;
import axms;
import axnc;
import bapk;
import bapn;
import bcrg;
import bhbx;
import bhfj;
import bjxa;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import nwu;

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
      localObject = paramContext.getString(2131690140);
      paramContext = paramContext.getString(2131690139);
      this.msgSummary.strContent = ((String)localObject + " " + paramContext);
    }
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage, MessageForStructing paramMessageForStructing)
  {
    String str1 = paramMessageForStructing.structingMsg.mMsgBrief;
    String str2 = paramContext.getString(2131698221);
    if ((!paramMessageForStructing.isread) && (!android.text.TextUtils.isEmpty(str1))) {}
    for (this.mMsgExtroInfo = str2;; this.mMsgExtroInfo = "")
    {
      paramMessage.msg = str1;
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167200);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.mUser.getType() == 1024) && (!bjxa.b(paramQQAppInterface, this.mUser.uin))) {
      this.mAuthenIconId = nwu.a(paramQQAppInterface, this.mUser.uin);
    }
    if (bhbx.b(this.mUser.uin)) {
      this.mAuthenIconId = 2130841803;
    }
  }
  
  private boolean a(anvk paramanvk, String paramString)
  {
    if ((paramanvk == null) || (android.text.TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        paramanvk = paramanvk.b(paramString);
      } while ((paramanvk == null) || (!paramanvk.isFriend()));
      bool1 = paramanvk.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramanvk.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  private boolean a(QQMessageFacade.Message paramMessage)
  {
    return (this.mUser.getType() == 0) && (android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (getUnreadNum() <= 0) && (this.mStatus == 0) && (this.msgSummary.nState == 0) && ((paramMessage == null) || (paramMessage.msgtype != -5040)) && (this.msgSummary.suffix == null) && (this.msgSummary.strPrefix == null);
  }
  
  private void b()
  {
    alma localalma = allz.a().a(getRecentUserType(), getRecentUserUin());
    if (localalma != null) {
      this.mTitleName = localalma.c;
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
    anvk localanvk = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.mUser.getType() == 0) && (localanvk.b(this.mUser.uin))) {
      if (ahwv.a().a(paramQQAppInterface) != 1) {
        break label160;
      }
    }
    label160:
    for (int i = 1;; i = 0)
    {
      this.mQimOnline = 0;
      if ((i != 0) && (ahwv.a().a()))
      {
        Friends localFriends = localanvk.e(this.mUser.uin);
        if ((localFriends != null) && (localFriends.netTypeIconId == 11))
        {
          this.mQimOnline = 1;
          ThreadManager.post(new RecentItemChatMsgData.2(this, paramQQAppInterface), 5, null, true);
        }
      }
      if ((this.mUser.getType() == 0) && (localanvk.a(this.mUser.uin) == 1)) {
        this.mQimIconUrl = ((FlashChatManager)paramQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a.d;
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
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    this.mTitleName = paramContext.getString(2131696214);
    String str = "";
    Object localObject = null;
    if (localQQMessageFacade != null) {
      localObject = localQQMessageFacade.getMsgList(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
      if (((MessageRecord)localObject).msg != null) {
        if (((MessageRecord)localObject).msgtype == -1033)
        {
          paramQQAppInterface = ((MessageRecord)localObject).msg;
          paramQQAppInterface = anvx.a(2131712626) + paramQQAppInterface;
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
          if ((awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER) != null) {}
          paramQQAppInterface = anvx.a(2131712629) + "";
          continue;
        }
        if (((MessageRecord)localObject).msgtype == -1039)
        {
          paramQQAppInterface = (aoce)paramQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER);
          if (paramQQAppInterface == null) {
            break label316;
          }
          paramQQAppInterface = paramContext.getResources().getString(2131696216) + paramQQAppInterface.a();
          continue;
        }
        if (((MessageRecord)localObject).msgtype == -1040)
        {
          paramContext = (aoce)paramQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER);
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
      label316:
      paramQQAppInterface = "";
    }
  }
  
  private void c()
  {
    if ((AppConstants.VOTE_MSG_UIN.equals(this.mUser.uin)) && (this.msg != null) && (this.msg.msg != null)) {
      this.msgSummary.strContent = this.msg.msg;
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
      str1 = paramContext.getString(2131693069);
      str2 = this.msg.msg;
      if ((!android.text.TextUtils.isEmpty(str2)) && (str2.startsWith(str1)))
      {
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
        if (!android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) {
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
      anvk localanvk = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mTitleName).append(",");
      Object localObject;
      if (this.mUnreadNum == 0)
      {
        if (this.mMsgExtroInfo != null) {
          localStringBuilder.append(this.mMsgExtroInfo + ",");
        }
        String str = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.mLastMsg.toString());
        localObject = str;
        if (this.msg != null)
        {
          localObject = str;
          if (this.msg.msgtype == -5040)
          {
            localObject = str;
            if (axnc.a(paramQQAppInterface, this.msg)) {
              localObject = axnc.a(str);
            }
          }
        }
        localStringBuilder.append((String)localObject).append(",").append(this.mShowTime);
        if ((this.mUser.getType() == 0) && (localanvk.b(this.mUser.uin)))
        {
          paramQQAppInterface = axlr.a(paramQQAppInterface, this.mUser.uin, false, 5);
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
            break label348;
          }
          localObject = (axms)paramQQAppInterface.next();
          if (!android.text.TextUtils.isEmpty(((axms)localObject).d))
          {
            localStringBuilder.append(((axms)localObject).d).append(",");
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
          localStringBuilder.append(((axms)localObject).a).append(",");
        }
      }
      label348:
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
    e();
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
          for (paramMessage.nickName = paramQQAppInterface.getApp().getString(2131694215);; paramMessage.nickName = ContactUtils.getBuddyName(paramQQAppInterface, paramMessage.senderuin, true))
          {
            bhfj.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, paramMessage.nickName, true, false);
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
        paramQQAppInterface = ((abkw)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
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
      paramQQAppInterface = ((abkw)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
      if (!ahzx.a(paramContext))
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
      for (paramMessage.nickName = paramQQAppInterface.getApp().getString(2131694215);; paramMessage.nickName = ContactUtils.getBuddyName(paramQQAppInterface, paramMessage.senderuin, true))
      {
        bhfj.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, paramMessage.nickName, true, false);
        return;
      }
    }
    bhfj.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, null, true, false);
  }
  
  private void d()
  {
    if ((this.msg != null) && (this.msg.msgtype == -2061)) {
      this.msgSummary.strContent = "";
    }
  }
  
  private void d(Context paramContext)
  {
    if ((this.msg != null) && (this.msg.msgtype == -2074))
    {
      MessageForAIOStoryVideo localMessageForAIOStoryVideo = new MessageForAIOStoryVideo();
      localMessageForAIOStoryVideo.msg = this.msg.msg;
      localMessageForAIOStoryVideo.mIsParsed = false;
      localMessageForAIOStoryVideo.parse();
      this.mMsgExtroInfo = anvx.a(2131712620);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167106);
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (this.mUnreadNum > 0)
    {
      this.mBubbleID = ((aocy)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(this.msg);
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
    c();
    a(paramContext);
    c(paramContext);
    d();
    a(paramQQAppInterface);
    b();
  }
  
  private void e()
  {
    this.mTitleName = anvx.a(2131712646);
    this.msgSummary.strContent = "可连接ArkIDE进行真机调试";
    this.mUnreadNum = 0;
  }
  
  private void e(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.mUser.getType() != 0)
    {
      processC2CDisplayTimeInner();
      this.mTitleName = ContactUtils.getBuddyName(paramQQAppInterface, this.mUser.uin, true);
      buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
    }
  }
  
  private void f(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = aqne.a(paramQQAppInterface).b(this.mUser.uin);
    this.mArgsBundle.putBoolean("isSpecialCareFriend", bool);
    if ((this.mUnreadNum > 0) && (bool))
    {
      this.mMsgExtroInfo = paramContext.getString(2131716740);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
    }
  }
  
  private void g(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((this.mUser.getType() == 0) && (((aizi)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).b(this.mUser.uin)))
    {
      this.mMsgExtroInfo = paramContext.getString(2131694270);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
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
            localObject1 = paramQQAppInterface.getMessageFacade();
          } while (this.msg.msgtype != -2011);
          l = paramQQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("uid" + this.msg.frienduin, 0L);
          localObject1 = ((QQMessageFacade)localObject1).getLastMsgForMsgTab(this.mUser.uin, this.mUser.getType());
        } while ((localObject1 == null) || (!(localObject1 instanceof MessageForStructing)));
        localObject2 = (MessageForStructing)localObject1;
        if (((MessageForStructing)localObject2).structingMsg == null) {
          ((MessageForStructing)localObject2).parse();
        }
      } while (((MessageForStructing)localObject2).structingMsg == null);
      if ((l == this.msg.msgUid) && (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 76))
      {
        localObject2 = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
        String str = paramContext.getString(2131697401);
        if ((!((MessageRecord)localObject1).isread) && (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).startsWith(str))) {
          this.mMsgExtroInfo = str;
        }
        for (this.msg.msg = ((String)localObject2).substring(str.length());; this.msg.msg = ((String)localObject2))
        {
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167110);
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
    if (AppConstants.QQBROADCAST_MSG_UIN.equals(this.mUser.uin)) {
      this.mTitleName = paramContext.getString(2131719140);
    }
    do
    {
      do
      {
        return;
        if (AppConstants.VOTE_MSG_UIN.equals(this.mUser.uin))
        {
          this.mTitleName = paramContext.getString(2131719172);
          return;
        }
        if (this.mUser.getType() != 1000) {
          break;
        }
        paramContext = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      } while (paramContext == null);
      paramContext = paramContext.b(this.mUser.troopUin);
      this.mTitleName = ContactUtils.getTroopNickName(paramQQAppInterface, this.mUser.uin, paramContext, this.mUser.troopUin, true, null);
      return;
      if (this.mUser.getType() != 1004) {
        break;
      }
      this.mTitleName = ContactUtils.getDiscussionMemberShowName(paramQQAppInterface, this.mUser.troopUin, this.mUser.uin);
    } while ((this.mTitleName == null) || (!this.mTitleName.equals(this.mUser.uin)));
    this.mTitleName = ContactUtils.getBuddyName(paramQQAppInterface, this.mUser.uin, true);
    return;
    if (this.mUser.getType() == 10007)
    {
      this.mTitleName = avdu.a(this.mUser.uin, paramQQAppInterface);
      return;
    }
    this.mTitleName = ContactUtils.getBuddyName(paramQQAppInterface, this.mUser.uin, true);
  }
  
  private void j(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((this.msg != null) && (this.msg.msgtype == -1034))
    {
      MessageForRichState localMessageForRichState = new MessageForRichState();
      localMessageForRichState.msg = this.msg.msg;
      localMessageForRichState.mIsParsed = false;
      localMessageForRichState.parse();
      if (paramQQAppInterface.getMsgCache().f(this.msg.frienduin) >= localMessageForRichState.time) {
        break label105;
      }
      this.mMsgExtroInfo = anvx.a(2131712644);
    }
    for (this.mExtraInfoColor = paramContext.getResources().getColor(2131167110);; this.mExtraInfoColor = paramContext.getResources().getColor(2131167106))
    {
      this.mArgsBundle.putBoolean("IS_SIGN_MSG", true);
      return;
      label105:
      this.mMsgExtroInfo = anvx.a(2131712643);
    }
  }
  
  private void k(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool;
    if (a((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER), this.mUser.uin))
    {
      this.mUnreadFlag = 4;
      if (FriendsStatusUtil.a(this.mUser.uin, paramQQAppInterface)) {
        this.mUnreadFlag = 3;
      }
      bool = agij.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface);
      if ((!bool) || (aomh.a(paramQQAppInterface.getCurrentUin(), paramContext))) {
        break label96;
      }
      this.mUnreadFlag = 0;
    }
    label96:
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
    this.mTitleName = ContactUtils.getBuddyName(paramQQAppInterface, this.mUser.uin, true);
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
    String str = ContactUtils.getUinByPhoneNum(paramQQAppInterface, this.mUser.uin);
    Object localObject = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (localObject != null) {}
    for (localObject = ((awyz)localObject).c(this.mUser.uin);; localObject = null)
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
          this.mTitleName = ContactUtils.getBuddyName(paramQQAppInterface, str, true);
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
      if ((this.msg.msgtype != -4502) || (!this.msg.frienduin.equals(AppConstants.SMARTDEVICE_SEARCH_UIN))) {
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
      DeviceInfo localDeviceInfo = ((abgm)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.msg.frienduin));
      if (localDeviceInfo != null) {
        this.mTitleName = absz.a(localDeviceInfo);
      }
    }
  }
  
  private void o(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.msg != null)
    {
      paramQQAppInterface = bapk.a(paramQQAppInterface, this.msg.frienduin, this.msg.istroop, this.mUnreadNum, this.msg);
      this.mUnreadNum += paramQQAppInterface.a();
      if (paramQQAppInterface.a() > 0)
      {
        this.mMsgExtroInfo = paramQQAppInterface.a();
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
      }
    }
  }
  
  private void p(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (a(this.msg))
    {
      paramQQAppInterface = (FeedsManager)paramQQAppInterface.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER);
      String str = paramQQAppInterface.getSummary(getRecentUserUin());
      if (!android.text.TextUtils.isEmpty(str))
      {
        this.msgSummary.strContent = str;
        this.mMsgExtroInfo = anvx.a(2131712624);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167110);
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