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
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
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
    Object localObject = this.msg;
    if ((localObject != null) && (((Message)localObject).msgtype == -2040))
    {
      localObject = new MessageForApproval();
      ((MessageForApproval)localObject).msgData = this.msg.msgData;
      this.msgSummary.strContent = ((MessageForApproval)localObject).getFullTitle();
    }
    localObject = this.msg;
    if ((localObject != null) && (((Message)localObject).msgtype == -2041))
    {
      localObject = paramContext.getString(2131887012);
      paramContext = paramContext.getString(2131887011);
      MsgSummary localMsgSummary = this.msgSummary;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramContext);
      localMsgSummary.strContent = localStringBuilder.toString();
    }
  }
  
  private void a(Context paramContext, Message paramMessage, MessageForStructing paramMessageForStructing)
  {
    String str1 = paramMessageForStructing.structingMsg.mMsgBrief;
    String str2 = paramContext.getString(2131896510);
    if ((!paramMessageForStructing.isread) && (!android.text.TextUtils.isEmpty(str1))) {
      this.mMsgExtroInfo = str2;
    } else {
      this.mMsgExtroInfo = "";
    }
    paramMessage.msg = str1;
    this.mExtraInfoColor = paramContext.getResources().getColor(2131168222);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ((ITempChatPluginManager)paramQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(getRecentUserType());
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFriendsManager != null)
    {
      if (android.text.TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramFriendsManager = paramFriendsManager.c(paramString);
      bool1 = bool2;
      if (paramFriendsManager != null)
      {
        bool1 = bool2;
        if (paramFriendsManager.isFriend())
        {
          bool1 = paramFriendsManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
          boolean bool3 = paramFriendsManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
          if (!bool1)
          {
            bool1 = bool2;
            if (!bool3) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(Context paramContext)
  {
    boolean bool = this.mArgsBundle.getBoolean("lastIsReceipt", false);
    if ((bool) && (this.mUnreadNum > 0) && ((this.mUser.msg instanceof MessageRecord)) && (!((MessageRecord)this.mUser.msg).isread)) {
      this.msgSummary.suffix = "";
    }
    if ((!bool) && ((this.mUser.msg instanceof MessageForStructing)))
    {
      Object localObject = this.msg;
      if ((localObject != null) && (((Message)localObject).msgtype != -1034))
      {
        localObject = (MessageForStructing)this.mUser.msg;
        if ((!((MessageForStructing)localObject).isread) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 107)) {
          a(paramContext, this.msg, (MessageForStructing)localObject);
        }
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.mUser.getType() == 1024) && (!QidianManager.a(paramQQAppInterface, this.mUser.uin))) {
      this.mAuthenIconId = CrmUtils.d(paramQQAppInterface, this.mUser.uin);
    }
    if (Utils.c(this.mUser.uin)) {
      this.mAuthenIconId = 2130842755;
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
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    this.mTitleName = paramContext.getString(2131894260);
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = ((QQMessageFacade)localObject1).h(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
    } else {
      localObject2 = null;
    }
    String str = "";
    localObject1 = str;
    if (localObject2 != null)
    {
      localObject1 = str;
      if (((List)localObject2).size() > 0)
      {
        localObject2 = (MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1);
        localObject1 = str;
        if (((MessageRecord)localObject2).msg != null) {
          if (((MessageRecord)localObject2).msgtype == -1033)
          {
            paramQQAppInterface = ((MessageRecord)localObject2).msg;
            paramContext = new StringBuilder();
            paramContext.append(HardCodeUtil.a(2131910656));
            paramContext.append(paramQQAppInterface);
            localObject1 = paramContext.toString();
          }
          else if (((MessageRecord)localObject2).msgtype == -1030)
          {
            paramQQAppInterface = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(HardCodeUtil.a(2131910659));
            paramQQAppInterface.append("");
            localObject1 = paramQQAppInterface.toString();
          }
          else if (((MessageRecord)localObject2).msgtype == -1039)
          {
            paramQQAppInterface = (IRecommendTroopService)paramQQAppInterface.getRuntimeService(IRecommendTroopService.class, "");
            localObject1 = str;
            if (paramQQAppInterface != null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramContext.getResources().getString(2131894262));
              ((StringBuilder)localObject1).append(paramQQAppInterface.getLastMessage());
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
          else
          {
            localObject1 = str;
            if (((MessageRecord)localObject2).msgtype == -1040)
            {
              paramQQAppInterface = (IRecommendTroopService)paramQQAppInterface.getRuntimeService(IRecommendTroopService.class, "");
              localObject1 = str;
              if (paramQQAppInterface != null) {
                localObject1 = paramQQAppInterface.getLastMessage();
              }
            }
          }
        }
      }
    }
    this.msgSummary.strContent = ((CharSequence)localObject1);
    if ((paramMessage != null) && (paramMessage.getMessageText() != null))
    {
      this.mDisplayTime = paramMessage.time;
      return;
    }
    this.mDisplayTime = 0L;
  }
  
  private void c()
  {
    int i = this.mUser.getType();
    if ((i != 0) && (i != 1000) && (i != 1021) && (i != 10004) && (i != 10008) && (i != 10010)) {
      switch (i)
      {
      default: 
        this.mArgsBundle.putBoolean("isEnableUnreadState", false);
        return;
      }
    }
    this.mArgsBundle.putBoolean("isEnableUnreadState", true);
  }
  
  private void c(Context paramContext)
  {
    Object localObject = this.msg;
    if ((localObject != null) && (((Message)localObject).msgtype == -2025)) {
      if (this.mUnreadNum > 0)
      {
        localObject = paramContext.getString(2131890709);
        String str = this.msg.msg;
        if ((!android.text.TextUtils.isEmpty(str)) && (str.startsWith((String)localObject)))
        {
          this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
          if (android.text.TextUtils.isEmpty(this.mMsgExtroInfo))
          {
            paramContext = (Context)localObject;
          }
          else
          {
            paramContext = new StringBuilder();
            paramContext.append(this.mMsgExtroInfo);
            paramContext.append((String)localObject);
            paramContext = paramContext.toString();
          }
          this.mMsgExtroInfo = paramContext;
          this.msgSummary.strContent = str.replace((CharSequence)localObject, "");
        }
      }
      else
      {
        this.mMsgExtroInfo = "";
      }
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.mUser.getType() == 0) && (localFriendsManager.n(this.mUser.uin)))
    {
      int i;
      if (QIMUserManager.b().a(paramQQAppInterface) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      this.mQimOnline = 0;
      if ((i != 0) && (QIMUserManager.b().a()))
      {
        Friends localFriends = localFriendsManager.m(this.mUser.uin);
        if ((localFriends != null) && (localFriends.netTypeIconId == 11))
        {
          this.mQimOnline = 1;
          ThreadManager.post(new RecentItemChatMsgData.2(this, paramQQAppInterface), 5, null, true);
        }
      }
    }
    if ((this.mUser.getType() == 0) && (localFriendsManager.p(this.mUser.uin) == 1)) {
      this.mQimIconUrl = ((FlashChatManager)paramQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c.d;
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
    if (i != 1006)
    {
      if (i != 1008)
      {
        if (i != 1021)
        {
          if (i != 1031)
          {
            if (i != 4000)
            {
              if (i != 9501) {
                return;
              }
              n(paramQQAppInterface, paramContext);
              return;
            }
            b(paramQQAppInterface, paramContext, this.msg);
            return;
          }
          j();
          return;
        }
        l(paramQQAppInterface, paramContext);
        return;
      }
      a(paramQQAppInterface, paramContext, this.msg);
      return;
    }
    m(paramQQAppInterface, paramContext);
  }
  
  private void c(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage)
  {
    if (paramMessage.msgtype == -4500)
    {
      paramQQAppInterface = new MessageForDeviceFile();
      paramQQAppInterface.msgData = paramMessage.msgData;
      paramQQAppInterface.parse();
      if (paramQQAppInterface.msgStatus == 1)
      {
        this.msgSummary.nState = 2;
        return;
      }
      if (paramQQAppInterface.msgStatus == 2) {
        this.msgSummary.nState = 1;
      }
    }
    else if (paramMessage.msgtype == -4501)
    {
      MessageForDevPtt localMessageForDevPtt = new MessageForDevPtt();
      localMessageForDevPtt.msgData = paramMessage.msgData;
      localMessageForDevPtt.parse();
      if (localMessageForDevPtt.fileSize == -1L) {
        this.msgSummary.nState = 2;
      } else if (localMessageForDevPtt.fileSize == -3L) {
        this.msgSummary.nState = 1;
      }
      if ("device_groupchat".equals(paramMessage.extStr))
      {
        if (paramMessage.isSend()) {
          paramMessage.nickName = paramQQAppInterface.getApp().getString(2131892063);
        } else {
          paramMessage.nickName = ContactUtils.a(paramQQAppInterface, paramMessage.senderuin, true);
        }
        MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, paramMessage.nickName, true, false);
      }
    }
    else
    {
      int k = paramMessage.msgtype;
      int j = 0;
      int i = 0;
      if (k == -4503)
      {
        paramContext = new MessageForDevShortVideo();
        paramContext.msgData = paramMessage.msgData;
        paramContext.parse();
        if (paramContext.videoFileStatus == 1005)
        {
          this.msgSummary.nState = 2;
          return;
        }
        if (paramContext.videoFileStatus == 1002)
        {
          paramQQAppInterface = ((DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
          if (paramQQAppInterface != null) {
            i = 1;
          }
          if (((paramQQAppInterface.a(paramMessage.uniseq) ^ true) & i))
          {
            this.msgSummary.nState = 2;
            return;
          }
          this.msgSummary.nState = 1;
        }
      }
      else if (paramMessage.msgtype == -4509)
      {
        paramContext = new MessageForDevLittleVideo();
        paramContext.msgData = paramMessage.msgData;
        paramContext.parse();
        if (paramContext.videoFileStatus == 1005)
        {
          this.msgSummary.nState = 2;
          return;
        }
        if (paramContext.videoFileStatus == 1002)
        {
          paramQQAppInterface = ((DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
          if (!DeviceMsgChatPie.a(paramContext))
          {
            i = j;
            if (paramQQAppInterface != null) {
              i = 1;
            }
            if (!(paramQQAppInterface.a(paramMessage.uniseq) & i))
            {
              this.msgSummary.nState = 2;
              return;
            }
          }
          this.msgSummary.nState = 1;
        }
      }
      else if (paramMessage.msgtype == -4508)
      {
        if ("device_groupchat".equals(paramMessage.extStr))
        {
          if (paramMessage.isSend()) {
            paramMessage.nickName = paramQQAppInterface.getApp().getString(2131892063);
          } else {
            paramMessage.nickName = ContactUtils.a(paramQQAppInterface, paramMessage.senderuin, true);
          }
          MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, paramMessage.nickName, true, false);
          return;
        }
        MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), this.msgSummary, null, true, false);
      }
    }
  }
  
  private void d(Context paramContext)
  {
    Object localObject = this.msg;
    if ((localObject != null) && (((Message)localObject).msgtype == -2074))
    {
      localObject = new MessageForAIOStoryVideo();
      ((MessageForAIOStoryVideo)localObject).msg = this.msg.msg;
      ((MessageForAIOStoryVideo)localObject).mIsParsed = false;
      ((MessageForAIOStoryVideo)localObject).parse();
      this.mMsgExtroInfo = HardCodeUtil.a(2131910650);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131168118);
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (AppSetting.e)
    {
      FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mTitleName);
      localStringBuilder.append(",");
      if (this.mUnreadNum != 0) {
        if (this.mUnreadNum == 1)
        {
          localStringBuilder.append("有一条未读");
        }
        else if (this.mUnreadNum == 2)
        {
          localStringBuilder.append("有两条未读");
        }
        else if (this.mUnreadNum > 0)
        {
          localStringBuilder.append("有");
          localStringBuilder.append(this.mUnreadNum);
          localStringBuilder.append("条未读,");
        }
      }
      if (this.mMsgExtroInfo != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.mMsgExtroInfo);
        ((StringBuilder)localObject).append(",");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      String str = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.mLastMsg.toString());
      Message localMessage = this.msg;
      Object localObject = str;
      if (localMessage != null)
      {
        localObject = str;
        if (localMessage.msgtype == -5040)
        {
          localObject = str;
          if (ReactivePushHelper.a(paramQQAppInterface, this.msg)) {
            localObject = ReactivePushHelper.a(str);
          }
        }
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",");
      localStringBuilder.append(this.mShowTime);
      if ((this.mUser.getType() == 0) && (localFriendsManager.n(this.mUser.uin)))
      {
        paramQQAppInterface = MutualMarkDataCenter.a(paramQQAppInterface, this.mUser.uin, false, 5);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.iterator();
          while (paramQQAppInterface.hasNext())
          {
            localObject = (MutualMarkForDisplayInfo)paramQQAppInterface.next();
            if (!android.text.TextUtils.isEmpty(((MutualMarkForDisplayInfo)localObject).t))
            {
              localStringBuilder.append(((MutualMarkForDisplayInfo)localObject).t);
              localStringBuilder.append(",");
            }
            else
            {
              localStringBuilder.append(((MutualMarkForDisplayInfo)localObject).o);
              localStringBuilder.append(",");
            }
          }
        }
      }
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
    h();
    a(paramContext);
    c(paramContext);
    i();
    b(paramQQAppInterface);
    a(paramQQAppInterface);
  }
  
  private void e(QQAppInterface paramQQAppInterface)
  {
    if (this.mUnreadNum > 0)
    {
      this.mBubbleID = ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b(this.msg);
      return;
    }
    this.mBubbleID = 0;
  }
  
  private void e(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.mUser.getType() != 0)
    {
      a();
      this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUser.uin, true);
      buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
    }
  }
  
  private void f(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = MessageNotificationSettingManager.a(paramQQAppInterface).b(this.mUser.uin);
    this.mArgsBundle.putBoolean("isSpecialCareFriend", bool);
    if ((this.mUnreadNum > 0) && (bool))
    {
      this.mMsgExtroInfo = paramContext.getString(2131914367);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
    }
  }
  
  private void g(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((this.mUser.getType() == 0) && (((INewFriendService)paramQQAppInterface.getRuntimeService(INewFriendService.class)).isNewFriend(this.mUser.uin)))
    {
      this.mMsgExtroInfo = paramContext.getString(2131892119);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
    }
  }
  
  private void h()
  {
    if (AppConstants.VOTE_MSG_UIN.equals(this.mUser.uin))
    {
      Message localMessage = this.msg;
      if ((localMessage != null) && (localMessage.msg != null)) {
        this.msgSummary.strContent = this.msg.msg;
      }
    }
  }
  
  private void h(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = this.msg;
    if (localObject1 != null)
    {
      if ((((Message)localObject1).getMessageText() == null) && (this.msg.msgData == null))
      {
        if (this.msg.msgtype != -2011) {
          return;
        }
        if (this.mUser.getType() != 0) {
          return;
        }
      }
      this.mDisplayTime = this.msg.time;
      if (this.mDisplayTime == 0L) {
        this.mDisplayTime = this.mUser.opTime;
      }
      localObject1 = paramQQAppInterface.getMessageFacade();
      if (this.msg.msgtype == -2011)
      {
        Object localObject2 = paramQQAppInterface.getApplication();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("now_msg_sp");
        ((StringBuilder)localObject3).append(paramQQAppInterface.getCurrentAccountUin());
        localObject2 = ((MobileQQ)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("uid");
        ((StringBuilder)localObject3).append(this.msg.frienduin);
        long l = ((SharedPreferences)localObject2).getLong(((StringBuilder)localObject3).toString(), 0L);
        localObject1 = ((QQMessageFacade)localObject1).r(this.mUser.uin, this.mUser.getType());
        if ((localObject1 != null) && ((localObject1 instanceof MessageForStructing)))
        {
          localObject2 = (MessageForStructing)localObject1;
          if (((MessageForStructing)localObject2).structingMsg == null) {
            ((MessageForStructing)localObject2).parse();
          }
          if (((MessageForStructing)localObject2).structingMsg != null)
          {
            if ((l == this.msg.msgUid) && (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 76))
            {
              localObject2 = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
              localObject3 = paramContext.getString(2131895434);
              if ((!((MessageRecord)localObject1).isread) && (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).startsWith((String)localObject3)))
              {
                this.mMsgExtroInfo = ((CharSequence)localObject3);
                this.msg.msg = ((String)localObject2).substring(((String)localObject3).length());
              }
              else
              {
                this.mMsgExtroInfo = "";
                this.msg.msg = ((String)localObject2);
              }
              this.mExtraInfoColor = paramContext.getResources().getColor(2131168122);
              buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
              return;
            }
            if ((((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 107) && (!this.mArgsBundle.getBoolean("isSpecialCareFriend", false)))
            {
              a(paramContext, this.msg, (MessageForStructing)localObject2);
              this.mUser.msg = localObject2;
              this.mArgsBundle.putBoolean("lastIsReceipt", true);
              buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
            }
          }
        }
      }
    }
  }
  
  private void i()
  {
    Message localMessage = this.msg;
    if ((localMessage != null) && (localMessage.msgtype == -2061)) {
      this.msgSummary.strContent = "";
    }
  }
  
  private void i(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (AppConstants.QQBROADCAST_MSG_UIN.equals(this.mUser.uin))
    {
      this.mTitleName = paramContext.getString(2131916962);
      return;
    }
    if (AppConstants.VOTE_MSG_UIN.equals(this.mUser.uin))
    {
      this.mTitleName = paramContext.getString(2131917014);
      return;
    }
    if (this.mUser.getType() == 1000)
    {
      paramContext = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramContext != null)
      {
        paramContext = paramContext.k(this.mUser.troopUin);
        this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUser.uin, paramContext, this.mUser.troopUin, true, null);
      }
    }
    else if (this.mUser.getType() == 1004)
    {
      this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUser.troopUin, this.mUser.uin);
      if ((this.mTitleName != null) && (this.mTitleName.equals(this.mUser.uin))) {
        this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUser.uin, true);
      }
    }
    else
    {
      if ((this.mUser.getType() == 10007) && (!AppConstants.GAME_MSG_BOX_UIN.equals(this.mUser.uin)))
      {
        this.mTitleName = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameRoleNickName(this.mUser.uin, paramQQAppInterface);
        return;
      }
      if ((QFileAssistantUtils.b()) && (QFileAssistantUtils.a(this.mUser.uin)))
      {
        this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUser.uin, true);
        if ((this.mTitleName != null) && (this.mTitleName.equals(this.mUser.uin))) {
          this.mTitleName = paramContext.getString(2131896189);
        }
      }
      else
      {
        this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUser.uin, true);
      }
    }
  }
  
  private void j()
  {
    this.mTitleName = HardCodeUtil.a(2131910676);
    this.msgSummary.strContent = "可连接ArkIDE进行真机调试";
    this.mUnreadNum = 0;
  }
  
  private void j(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject = this.msg;
    if ((localObject != null) && (((Message)localObject).msgtype == -1034))
    {
      localObject = new MessageForRichState();
      ((MessageForRichState)localObject).msg = this.msg.msg;
      ((MessageForRichState)localObject).mIsParsed = false;
      ((MessageForRichState)localObject).parse();
      if (paramQQAppInterface.getMsgCache().z(this.msg.frienduin) < ((MessageForRichState)localObject).time)
      {
        this.mMsgExtroInfo = HardCodeUtil.a(2131910674);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131168122);
      }
      else
      {
        this.mMsgExtroInfo = HardCodeUtil.a(2131910673);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131168118);
      }
      this.mArgsBundle.putBoolean("IS_SIGN_MSG", true);
    }
  }
  
  private void k(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (a((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER), this.mUser.uin)) {
      this.mUnreadFlag = 4;
    } else {
      this.mUnreadFlag = 1;
    }
    if (FriendsStatusUtil.a(this.mUser.uin, paramQQAppInterface)) {
      this.mUnreadFlag = 3;
    }
    boolean bool = HiddenChatHelper.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface);
    if ((bool) && (!HiddenChatUtil.a(paramQQAppInterface.getCurrentUin(), paramContext)))
    {
      this.mUnreadFlag = 0;
      return;
    }
    if (bool) {
      this.mUnreadFlag = 3;
    }
  }
  
  private void l(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUser.uin, true);
    buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
    paramQQAppInterface = this.msg;
    if ((paramQQAppInterface != null) && ((paramQQAppInterface.getMessageText() != null) || ((this.msg.msgtype == -2011) && (this.msg.msgData != null))))
    {
      this.mDisplayTime = this.msg.time;
      return;
    }
    this.mDisplayTime = 0L;
  }
  
  private void m(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str = ContactUtils.b(paramQQAppInterface, this.mUser.uin);
    Object localObject = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (localObject != null) {
      localObject = ((IPhoneContactService)localObject).queryContactByCodeNumber(this.mUser.uin);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      this.mTitleName = ((PhoneContact)localObject).name;
    } else if (str != null) {
      this.mTitleName = ContactUtils.a(paramQQAppInterface, str, true);
    } else {
      this.mTitleName = this.mUser.uin;
    }
    buildMessageBody(this.msg, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
    paramQQAppInterface = this.msg;
    if ((paramQQAppInterface != null) && ((paramQQAppInterface.getMessageText() != null) || ((this.msg.msgtype == -2011) && (this.msg.msgData != null))))
    {
      this.mDisplayTime = this.msg.time;
      return;
    }
    this.mDisplayTime = 0L;
  }
  
  private void n(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.msg != null)
    {
      this.msgSummary.strContent = this.msg.msg;
      this.mDisplayTime = this.msg.time;
      this.mAuthenIconId = 0;
      if ((this.msg.msgtype == -4502) && (this.msg.frienduin.equals(AppConstants.SMARTDEVICE_SEARCH_UIN)))
      {
        this.mTitleName = "QQ物联";
      }
      else
      {
        DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.parseLong(this.msg.frienduin));
        if (localDeviceInfo != null) {
          this.mTitleName = SmartDeviceUtil.a(localDeviceInfo);
        }
      }
      if ((this.msgSummary.strContent == null) || (this.msgSummary.strContent.length() == 0)) {
        this.msgSummary.strContent = this.mTitleName;
      }
      this.mMenuFlag = 1;
      c(paramQQAppInterface, paramContext, this.msg);
    }
  }
  
  private void o(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Message localMessage = this.msg;
    if (localMessage != null)
    {
      paramQQAppInterface = QCallFacade.a(paramQQAppInterface, localMessage.frienduin, this.msg.istroop, this.mUnreadNum, this.msg);
      this.mUnreadNum += paramQQAppInterface.a();
      if (paramQQAppInterface.a() > 0)
      {
        this.mMsgExtroInfo = paramQQAppInterface.b();
        this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
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
        this.mMsgExtroInfo = HardCodeUtil.a(2131910654);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131168122);
        if (!FeedsManager.isShowStatus(getRecentUserUin())) {
          FeedsManager.showStatus(getRecentUserUin());
        }
        paramQQAppInterface.reportExposeStatus(getRecentUserUin());
        return;
      }
      FeedsManager.hideStatus(getRecentUserUin());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.update(paramQQAppInterface, paramContext);
      this.msg = null;
      if ((this.mLastMessage instanceof Message)) {
        this.msg = this.mLastMessage;
      }
      o(paramQQAppInterface, paramContext);
      c();
      c(paramQQAppInterface, paramContext);
      b(paramQQAppInterface, paramContext);
      e(paramQQAppInterface);
      extraUpdate(paramQQAppInterface, paramContext, this.msgSummary);
      d(paramQQAppInterface);
      processUnReadNum(paramContext.getResources().getColor(2131168122), 99);
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage) {}
  
  protected void processUnReadNum(int paramInt1, int paramInt2)
  {
    if (!android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) {
      return;
    }
    super.processUnReadNum(paramInt1, paramInt2);
  }
  
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