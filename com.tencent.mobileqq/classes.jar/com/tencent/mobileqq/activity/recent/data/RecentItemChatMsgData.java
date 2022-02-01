package com.tencent.mobileqq.activity.recent.data;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatPluginManager;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
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
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

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
  protected Message msg;
  
  public RecentItemChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
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
      localObject = paramContext.getString(2131690197);
      paramContext = paramContext.getString(2131690196);
      this.msgSummary.strContent = ((String)localObject + " " + paramContext);
    }
  }
  
  private void a(Context paramContext, Message paramMessage, MessageForStructing paramMessageForStructing)
  {
    String str1 = paramMessageForStructing.structingMsg.mMsgBrief;
    String str2 = paramContext.getString(2131698497);
    if ((!paramMessageForStructing.isread) && (!android.text.TextUtils.isEmpty(str1))) {}
    for (this.mMsgExtroInfo = str2;; this.mMsgExtroInfo = "")
    {
      paramMessage.msg = str1;
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167207);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ((TempChatPluginManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(getRecentUserType());
    if (paramQQAppInterface != null) {
      this.mTitleName = paramQQAppInterface.b(getRecentUserUin());
    }
  }
  
  private boolean a(Message paramMessage)
  {
    return (this.mUser.getType() == 0) && (android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (getUnreadNum() <= 0) && (this.mStatus == 0) && (this.msgSummary.nState == 0) && ((paramMessage == null) || (paramMessage.msgtype != -5040)) && (this.msgSummary.suffix == null) && (this.msgSummary.strPrefix == null);
  }
  
  private boolean a(FriendsManager paramFriendsManager, String paramString)
  {
    if ((paramFriendsManager == null) || (android.text.TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        paramFriendsManager = paramFriendsManager.b(paramString);
      } while ((paramFriendsManager == null) || (!paramFriendsManager.isFriend()));
      bool1 = paramFriendsManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramFriendsManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    } while ((!bool1) && (!bool2));
    return true;
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
    if ((this.mUser.getType() == 1024) && (!QidianManager.b(paramQQAppInterface, this.mUser.uin))) {
      this.mAuthenIconId = CrmUtils.a(paramQQAppInterface, this.mUser.uin);
    }
    if (Utils.b(this.mUser.uin)) {
      this.mAuthenIconId = 2130841947;
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
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage)
  {
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    this.mTitleName = paramContext.getString(2131696467);
    String str = "";
    Object localObject = null;
    if (localQQMessageFacade != null) {
      localObject = localQQMessageFacade.b(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
      if (((MessageRecord)localObject).msg != null) {
        if (((MessageRecord)localObject).msgtype == -1033)
        {
          paramQQAppInterface = ((MessageRecord)localObject).msg;
          paramQQAppInterface = HardCodeUtil.a(2131713122) + paramQQAppInterface;
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
          if ((PhoneContactManager)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER) != null) {}
          paramQQAppInterface = HardCodeUtil.a(2131713125) + "";
          continue;
        }
        if (((MessageRecord)localObject).msgtype == -1039)
        {
          paramQQAppInterface = (RecommendTroopManagerImp)paramQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER);
          if (paramQQAppInterface == null) {
            break label316;
          }
          paramQQAppInterface = paramContext.getResources().getString(2131696469) + paramQQAppInterface.a();
          continue;
        }
        if (((MessageRecord)localObject).msgtype == -1040)
        {
          paramContext = (RecommendTroopManagerImp)paramQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER);
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
    switch (this.mUser.getType())
    {
    default: 
      this.mArgsBundle.putBoolean("isEnableUnreadState", false);
      return;
    }
    this.mArgsBundle.putBoolean("isEnableUnreadState", true);
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
      str1 = paramContext.getString(2131693215);
      str2 = this.msg.msg;
      if ((!android.text.TextUtils.isEmpty(str2)) && (str2.startsWith(str1)))
      {
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
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
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.mUser.getType() == 0) && (localFriendsManager.b(this.mUser.uin))) {
      if (QIMUserManager.a().a(paramQQAppInterface) != 1) {
        break label160;
      }
    }
    label160:
    for (int i = 1;; i = 0)
    {
      this.mQimOnline = 0;
      if ((i != 0) && (QIMUserManager.a().a()))
      {
        Friends localFriends = localFriendsManager.e(this.mUser.uin);
        if ((localFriends != null) && (localFriends.netTypeIconId == 11))
        {
          this.mQimOnline = 1;
          ThreadManager.post(new RecentItemChatMsgData.2(this, paramQQAppInterface), 5, null, true);
        }
      }
      if ((this.mUser.getType() == 0) && (localFriendsManager.a(this.mUser.uin) == 1)) {
        this.mQimIconUrl = ((FlashChatManager)paramQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a.d;
      }
      return;
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
    f();
  }
  
  private void c(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage)
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
          for (paramMessage.nickName = paramQQAppInterface.getApp().getString(2131694419);; paramMessage.nickName = ContactUtils.c(paramQQAppInterface, paramMessage.senderuin, true))
          {
            MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, paramMessage.nickName, true, false);
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
        paramQQAppInterface = ((DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
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
      paramQQAppInterface = ((DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
      if (!DeviceMsgChatPie.b(paramContext))
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
      for (paramMessage.nickName = paramQQAppInterface.getApp().getString(2131694419);; paramMessage.nickName = ContactUtils.c(paramQQAppInterface, paramMessage.senderuin, true))
      {
        MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, paramMessage.nickName, true, false);
        return;
      }
    }
    MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, null, true, false);
  }
  
  private void d()
  {
    if ((AppConstants.VOTE_MSG_UIN.equals(this.mUser.uin)) && (this.msg != null) && (this.msg.msg != null)) {
      this.msgSummary.strContent = this.msg.msg;
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
      this.mMsgExtroInfo = HardCodeUtil.a(2131713116);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167113);
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (AppSetting.d)
    {
      FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
            if (ReactivePushHelper.a(paramQQAppInterface, this.msg)) {
              localObject = ReactivePushHelper.a(str);
            }
          }
        }
        localStringBuilder.append((String)localObject).append(",").append(this.mShowTime);
        if ((this.mUser.getType() == 0) && (localFriendsManager.b(this.mUser.uin)))
        {
          paramQQAppInterface = MutualMarkDataCenter.a(paramQQAppInterface, this.mUser.uin, false, 5);
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
          localObject = (MutualMarkForDisplayInfo)paramQQAppInterface.next();
          if (!android.text.TextUtils.isEmpty(((MutualMarkForDisplayInfo)localObject).d))
          {
            localStringBuilder.append(((MutualMarkForDisplayInfo)localObject).d).append(",");
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
          localStringBuilder.append(((MutualMarkForDisplayInfo)localObject).a).append(",");
        }
      }
      label348:
      this.mContentDesc = localStringBuilder.toString();
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    e(paramQQAppInterface, paramContext);
    f(paramQQAppInterface, paramContext);
    g(paramQQAppInterface, paramContext);
    h(paramQQAppInterface, paramContext);
    i(paramQQAppInterface, paramContext);
    k(paramQQAppInterface, paramContext);
    c(paramQQAppInterface);
    b(paramContext);
    j(paramQQAppInterface, paramContext);
    d(paramContext);
    d();
    a(paramContext);
    c(paramContext);
    e();
    b(paramQQAppInterface);
    a(paramQQAppInterface);
  }
  
  private void e()
  {
    if ((this.msg != null) && (this.msg.msgtype == -2061)) {
      this.msgSummary.strContent = "";
    }
  }
  
  private void e(QQAppInterface paramQQAppInterface)
  {
    if (this.mUnreadNum > 0)
    {
      this.mBubbleID = ((SVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(this.msg);
      return;
    }
    this.mBubbleID = 0;
  }
  
  private void e(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.mUser.getType() != 0)
    {
      a();
      this.mTitleName = ContactUtils.c(paramQQAppInterface, this.mUser.uin, true);
      buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
    }
  }
  
  private void f()
  {
    this.mTitleName = HardCodeUtil.a(2131713142);
    this.msgSummary.strContent = "可连接ArkIDE进行真机调试";
    this.mUnreadNum = 0;
  }
  
  private void f(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = MessageNotificationSettingManager.a(paramQQAppInterface).b(this.mUser.uin);
    this.mArgsBundle.putBoolean("isSpecialCareFriend", bool);
    if ((this.mUnreadNum > 0) && (bool))
    {
      this.mMsgExtroInfo = paramContext.getString(2131717235);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
    }
  }
  
  private void g(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((this.mUser.getType() == 0) && (((NewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).b(this.mUser.uin)))
    {
      this.mMsgExtroInfo = paramContext.getString(2131694474);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
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
        String str = paramContext.getString(2131697655);
        if ((!((MessageRecord)localObject1).isread) && (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).startsWith(str))) {
          this.mMsgExtroInfo = str;
        }
        for (this.msg.msg = ((String)localObject2).substring(str.length());; this.msg.msg = ((String)localObject2))
        {
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167117);
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
      this.mTitleName = paramContext.getString(2131719682);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (AppConstants.VOTE_MSG_UIN.equals(this.mUser.uin))
          {
            this.mTitleName = paramContext.getString(2131719730);
            return;
          }
          if (this.mUser.getType() != 1000) {
            break;
          }
          paramContext = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        } while (paramContext == null);
        paramContext = paramContext.b(this.mUser.troopUin);
        this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUser.uin, paramContext, this.mUser.troopUin, true, null);
        return;
        if (this.mUser.getType() != 1004) {
          break;
        }
        this.mTitleName = ContactUtils.c(paramQQAppInterface, this.mUser.troopUin, this.mUser.uin);
      } while ((this.mTitleName == null) || (!this.mTitleName.equals(this.mUser.uin)));
      this.mTitleName = ContactUtils.c(paramQQAppInterface, this.mUser.uin, true);
      return;
      if (this.mUser.getType() == 10007)
      {
        this.mTitleName = GameMsgUtil.a(this.mUser.uin, paramQQAppInterface);
        return;
      }
      if ((!QFileAssistantUtils.a()) || (!QFileAssistantUtils.a(this.mUser.uin))) {
        break;
      }
      this.mTitleName = ContactUtils.c(paramQQAppInterface, this.mUser.uin, true);
    } while ((this.mTitleName == null) || (!this.mTitleName.equals(this.mUser.uin)));
    this.mTitleName = paramContext.getString(2131698224);
    return;
    this.mTitleName = ContactUtils.c(paramQQAppInterface, this.mUser.uin, true);
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
      this.mMsgExtroInfo = HardCodeUtil.a(2131713140);
    }
    for (this.mExtraInfoColor = paramContext.getResources().getColor(2131167117);; this.mExtraInfoColor = paramContext.getResources().getColor(2131167113))
    {
      this.mArgsBundle.putBoolean("IS_SIGN_MSG", true);
      return;
      label105:
      this.mMsgExtroInfo = HardCodeUtil.a(2131713139);
    }
  }
  
  private void k(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool;
    if (a((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER), this.mUser.uin))
    {
      this.mUnreadFlag = 4;
      if (FriendsStatusUtil.a(this.mUser.uin, paramQQAppInterface)) {
        this.mUnreadFlag = 3;
      }
      bool = HiddenChatHelper.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface);
      if ((!bool) || (HiddenChatUtil.a(paramQQAppInterface.getCurrentUin(), paramContext))) {
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
    this.mTitleName = ContactUtils.c(paramQQAppInterface, this.mUser.uin, true);
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
    String str = ContactUtils.e(paramQQAppInterface, this.mUser.uin);
    Object localObject = (PhoneContactManager)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (localObject != null) {}
    for (localObject = ((PhoneContactManager)localObject).c(this.mUser.uin);; localObject = null)
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
          this.mTitleName = ContactUtils.c(paramQQAppInterface, str, true);
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
      DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.msg.frienduin));
      if (localDeviceInfo != null) {
        this.mTitleName = SmartDeviceUtil.a(localDeviceInfo);
      }
    }
  }
  
  private void o(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.msg != null)
    {
      paramQQAppInterface = QCallFacade.a(paramQQAppInterface, this.msg.frienduin, this.msg.istroop, this.mUnreadNum, this.msg);
      this.mUnreadNum += paramQQAppInterface.a();
      if (paramQQAppInterface.a() > 0)
      {
        this.mMsgExtroInfo = paramQQAppInterface.a();
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
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
        this.mMsgExtroInfo = HardCodeUtil.a(2131713120);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167117);
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
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.update(paramQQAppInterface, paramContext);
    this.msg = null;
    if ((this.mLastMessage instanceof Message)) {
      this.msg = ((Message)this.mLastMessage);
    }
    o(paramQQAppInterface, paramContext);
    c();
    c(paramQQAppInterface, paramContext);
    b(paramQQAppInterface, paramContext);
    e(paramQQAppInterface);
    extraUpdate(paramQQAppInterface, paramContext, this.msgSummary);
    d(paramQQAppInterface);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage) {}
  
  public final void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData
 * JD-Core Version:    0.7.0.1
 */