package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.component.network.utils.Base64;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AllInOneFactory;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconControllerImpl;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatService;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.io.Serializable;
import java.net.URLEncoder;

public class HeadIconHandler
  extends ChatLayoutHandler
  implements IBaseBubbleClickProcessor, IBaseBubbleLongClickProcessor
{
  private BaseBubbleBuilderHeadIconController a;
  private IFaceDecoder g;
  
  public HeadIconHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  private int a(TroopInfo paramTroopInfo)
  {
    String str = this.b.getCurrentAccountUin();
    if ((paramTroopInfo != null) && (!TextUtils.isEmpty(str)))
    {
      if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(str))) {
        return 3;
      }
      if (str.equals(paramTroopInfo.troopowneruin)) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    Object localObject = AIOLongShotHelper.f();
    if ((localObject != null) && (((AIOLongShotHelper)localObject).c()))
    {
      b(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
      return;
    }
    if ((BaseChatItemLayout.ad) && ((paramChatMessage instanceof MessageForStructing)))
    {
      localObject = ((MessageForStructing)paramChatMessage).structingMsg;
      if ((paramChatMessage.isSendFromLocal()) && ((localObject instanceof AbsShareMsg)) && (((AbsShareMsg)localObject).isSdkShareMsg()) && ((paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768)))
      {
        if ((paramBaseChatItemLayout.ac != null) && (paramBaseChatItemLayout.ac.getVisibility() == 0)) {
          paramBaseChatItemLayout.ac.setVisibility(8);
        }
        return;
      }
      if (((AbsStructMsg)localObject).mMsgServiceID == 14)
      {
        if ((paramBaseChatItemLayout.ac != null) && (paramBaseChatItemLayout.ac.getVisibility() == 0)) {
          paramBaseChatItemLayout.ac.setVisibility(8);
        }
        return;
      }
    }
    b(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, AnonymousChatHelper.AnonymousExtInfo paramAnonymousExtInfo, int paramInt)
  {
    Object localObject = paramAnonymousExtInfo.a();
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    String str = "";
    if ((localObject != null) && (paramAnonymousExtInfo.a != 2))
    {
      AnonymousChatHelper.f = paramMessageRecord.shmsgseq;
      localObject = URLEncoder.encode(Base64.encodeToString((byte[])localObject, 2));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&gcode=");
      localStringBuilder.append(paramMessageRecord.frienduin);
      localStringBuilder.append("&avatar=");
      localStringBuilder.append(AnonymousChatHelper.a(paramAnonymousExtInfo.d));
      localStringBuilder.append("&nick=");
      if (!TextUtils.isEmpty(paramAnonymousExtInfo.c)) {
        str = URLEncoder.encode(paramAnonymousExtInfo.c);
      }
      localStringBuilder.append(str);
      localStringBuilder.append("&role=");
      localStringBuilder.append(String.valueOf(paramInt));
      localStringBuilder.append("&self=0");
      str = localStringBuilder.toString();
      paramAnonymousExtInfo = str;
      if (paramMessageRecord.msgData != null)
      {
        AnonymousChatHelper.a().a(paramMessageRecord.frienduin, (String)localObject, paramMessageRecord);
        paramAnonymousExtInfo = str;
        if (QLog.isDevelopLevel())
        {
          paramAnonymousExtInfo = new StringBuilder();
          paramAnonymousExtInfo.append("report:");
          paramAnonymousExtInfo.append(paramMessageRecord.msgData.toString());
          QLog.i("HeadIconHandler", 4, paramAnonymousExtInfo.toString());
          paramAnonymousExtInfo = str;
        }
      }
    }
    else if (paramAnonymousExtInfo.a == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=");
      ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
      ((StringBuilder)localObject).append("&avatar=");
      ((StringBuilder)localObject).append(AnonymousChatHelper.a(paramAnonymousExtInfo.d));
      ((StringBuilder)localObject).append("&nick=");
      if (!TextUtils.isEmpty(paramAnonymousExtInfo.c)) {
        str = URLEncoder.encode(paramAnonymousExtInfo.c);
      }
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("&role=");
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append("&self=1");
      paramAnonymousExtInfo = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramAnonymousExtInfo = null;
    }
    localIntent.putExtra("url", AskAnonymousUtil.a(paramMessageRecord, paramAnonymousExtInfo));
    ((Activity)paramView.getContext()).startActivity(localIntent);
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, FriendsManager paramFriendsManager, boolean paramBoolean1, boolean paramBoolean2, String paramString, AllInOne paramAllInOne)
  {
    int j = paramMessageRecord.istroop;
    int i = 21;
    if ((j != 1001) && (paramMessageRecord.istroop != 1010) && (paramMessageRecord.istroop != 10002))
    {
      j = 0;
      if ((!paramBoolean2) && (!paramFriendsManager.n(this.c.b)))
      {
        Object localObject = StrangerChatPie.a(this.d, this.c.a, paramBoolean1, paramBoolean2);
        if (localObject != null)
        {
          paramAllInOne.extras.putSerializable("param_wzry_data", (Serializable)localObject);
        }
        else if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("msg_ext_key")))
        {
          localObject = paramMessageRecord.senderuin;
          localObject = KplRoleInfo.WZRYUIinfo.createInfo((String)localObject, KplRoleInfo.WZRYUIinfo.buildNickName(this.c.e, KplHelper.a(this.b, (String)localObject)), KplHelper.a(this.b), 0, 0);
          paramAllInOne.extras.putSerializable("param_wzry_data", (Serializable)localObject);
        }
      }
      if (((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isExtendMatchChatType(this.c.a))
      {
        if (paramFriendsManager.n(this.c.b))
        {
          i = j;
          if (this.c.s == 20) {
            i = 1;
          }
          ProfileActivity.a(paramView.getContext(), paramAllInOne, i, 2);
          return;
        }
        if (paramString.equals(this.b.getCurrentUin())) {
          i = 24;
        }
        ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).startExtendFriendCardOnClickAvatar(this.d, paramString, i);
        return;
      }
      if (QCircleChatUtil.a(paramMessageRecord))
      {
        if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equals(this.b.getCurrentAccountUin()))) {
          return;
        }
        QCircleChatUtil.a(paramMessageRecord.senderuin);
        return;
      }
      paramFriendsManager = (IRIJPrivateChatService)this.b.getRuntimeService(IRIJPrivateChatService.class, "");
      if (paramFriendsManager.isKanDianPrivateChatMsg(paramMessageRecord))
      {
        paramFriendsManager.jumpKanDianProfilePage(paramView.getContext(), paramMessageRecord.senderuin);
        return;
      }
      ProfileUtils.openProfileCard(paramView.getContext(), paramAllInOne);
      return;
    }
    paramFriendsManager = new Intent();
    if (paramMessageRecord.istroop == 1001)
    {
      paramAllInOne.profileEntryType = 10;
      paramFriendsManager.putExtra("frome_where", 21);
    }
    else if (paramMessageRecord.istroop == 1010)
    {
      paramAllInOne.profileEntryType = 11;
    }
    else if (paramMessageRecord.istroop == 10002)
    {
      paramFriendsManager.putExtra("frome_where", 22);
    }
    paramAllInOne.reportExtra = NewReportPlugin.a(this.c);
    paramFriendsManager.putExtra("AllInOne", paramAllInOne);
    if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(paramAllInOne.uin)) {
      paramFriendsManager.putExtra("param_tiny_id", Long.valueOf(paramAllInOne.uin));
    }
    if (Utils.a(this.b.getCurrentAccountUin(), paramString)) {
      paramFriendsManager.putExtra("param_mode", 2);
    } else {
      paramFriendsManager.putExtra("param_mode", 3);
    }
    if ((this.d instanceof Activity))
    {
      RouteUtils.a(paramView.getContext(), paramFriendsManager, "/nearby/people/profile", 9009);
      return;
    }
    RouteUtils.a(paramView.getContext(), paramFriendsManager, "/nearby/people/profile");
  }
  
  private void a(MessageRecord paramMessageRecord, TroopBusinessUtil.TroopBusinessMessage paramTroopBusinessMessage)
  {
    TroopBusinessUtil.a(this.b, this.d, paramTroopBusinessMessage);
    ReportController.b(this.b, "P_CliOper", "Grp_AIO", "", "five_m", "clk_head", 0, 0, paramMessageRecord.frienduin, "", paramTroopBusinessMessage.d, "");
    if (paramMessageRecord.msgtype == -2051) {
      try
      {
        paramMessageRecord = (MessageForQQStory)paramMessageRecord;
        paramMessageRecord = JumpParser.a(this.b, this.d, paramMessageRecord.msgAction);
        QQStoryItemBuilder.a(this.b, this.c.a, "clk_head", paramMessageRecord, false);
        return;
      }
      catch (Exception paramMessageRecord)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramMessageRecord);
        }
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, AllInOne paramAllInOne)
  {
    if (paramString.equals(paramAllInOne.nickname)) {
      paramAllInOne.nickname = null;
    }
    paramAllInOne.reportExtra = NewReportPlugin.a(this.c);
    paramAllInOne.preWinUin = this.c.b;
    paramAllInOne.preWinType = this.c.a;
    if ((paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1020))
    {
      if (paramMessageRecord.istroop == 1)
      {
        paramAllInOne.troopUin = this.c.c;
        paramAllInOne.troopCode = paramMessageRecord.frienduin;
      }
      else if (3000 == paramMessageRecord.istroop)
      {
        paramAllInOne.discussUin = this.c.b;
      }
    }
    else {
      paramAllInOne.troopUin = paramMessageRecord.senderuin;
    }
    paramAllInOne.lastActivity = 2;
    if (paramMessageRecord.istroop == 0)
    {
      paramAllInOne.profileEntryType = 1;
      return;
    }
    if (paramMessageRecord.istroop == 3000)
    {
      paramAllInOne.profileEntryType = 107;
      return;
    }
    if (paramMessageRecord.istroop == 1)
    {
      paramAllInOne.profileEntryType = 108;
      return;
    }
    paramAllInOne.profileEntryType = 106;
  }
  
  private boolean a(View paramView, MessageRecord paramMessageRecord)
  {
    if (a(paramMessageRecord)) {
      return true;
    }
    if (c(paramView, paramMessageRecord)) {
      return true;
    }
    return b(paramView, paramMessageRecord);
  }
  
  private boolean a(View paramView, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject;
    if ((!paramBoolean) && (paramMessageRecord.istroop == 1)) {
      localObject = (ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all");
    }
    try
    {
      long l = Long.parseLong(paramMessageRecord.senderuin);
      paramBoolean = ((ITroopRobotService)localObject).checkAndProcessJumpRobotPage(this.d, paramMessageRecord.frienduin, l);
      if (!paramBoolean) {
        break label108;
      }
      return true;
    }
    catch (Exception localException)
    {
      label63:
      break label63;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseLong error: messageRecord.senderuin = ");
      ((StringBuilder)localObject).append(paramMessageRecord.senderuin);
      QLog.e("HeadIconHandler", 2, ((StringBuilder)localObject).toString());
    }
    label108:
    TroopMemberCardUtils.a(this.b, (Activity)paramView.getContext(), paramMessageRecord.frienduin, paramMessageRecord.senderuin, 0, 2000);
    return true;
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((BusinessUtils.c(paramMessageRecord.senderuin)) && (BusinessUtils.a(this.d))) {
      return true;
    }
    if (RobotUtils.a(this.b, paramMessageRecord.senderuin))
    {
      if (this.c.a == 1) {
        ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(this.d, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      } else {
        ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(this.d, null, paramMessageRecord.senderuin);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openRobotProfileCard, robotuin:");
        localStringBuilder.append(paramMessageRecord.senderuin);
        localStringBuilder.append(" frienduin:");
        localStringBuilder.append(paramMessageRecord.frienduin);
        QLog.d("HeadIconHandler", 2, localStringBuilder.toString());
      }
      return true;
    }
    if ((this.c.a == 1) && (((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).F(this.c.c))) {
      return true;
    }
    if ("10000".equals(paramMessageRecord.senderuin)) {
      return true;
    }
    if ((paramMessageRecord.istroop == 3000) && (ContactUtils.h(this.b, paramMessageRecord.frienduin))) {
      return true;
    }
    return (paramMessageRecord instanceof MessageForTroopConfess);
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return (paramBoolean) && (((ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(this.d, paramMessageRecord.frienduin, Long.parseLong(paramMessageRecord.senderuin)));
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, HotChatInfo paramHotChatInfo)
  {
    Object localObject1;
    if (paramHotChatInfo != null)
    {
      localObject2 = paramHotChatInfo.troopCode;
      localObject1 = localObject2;
      if (paramHotChatInfo.isGameRoom)
      {
        WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.b.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
        localObject1 = localObject2;
        if (localWerewolvesHandler.e != null)
        {
          localObject1 = localObject2;
          if (localWerewolvesHandler.e.equals(paramMessageRecord.senderuin)) {
            return true;
          }
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    ProfilePerformanceReport.b();
    Object localObject2 = paramMessageRecord.senderuin;
    int i;
    if ((paramHotChatInfo != null) && (paramHotChatInfo.isBuLuoHotChat())) {
      i = 86;
    } else {
      i = 42;
    }
    localObject2 = new AllInOne((String)localObject2, i);
    ((AllInOne)localObject2).troopCode = localObject1;
    ((AllInOne)localObject2).troopUin = paramMessageRecord.frienduin;
    if ((paramHotChatInfo != null) && (paramHotChatInfo.isGameRoom)) {
      ((AllInOne)localObject2).profileEntryType = 113;
    } else {
      ((AllInOne)localObject2).profileEntryType = 31;
    }
    ((AllInOne)localObject2).reportExtra = NewReportPlugin.a(this.c);
    ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramMessageRecord.frienduin, paramMessageRecord.senderuin);
    boolean bool = false;
    HotChatManager.a = false;
    paramMessageRecord = new Intent(this.d, QQNearbyManager.b());
    paramMessageRecord.putExtra("AllInOne", (Parcelable)localObject2);
    if (paramHotChatInfo != null) {
      bool = paramHotChatInfo.isGameRoom;
    }
    paramMessageRecord.putExtra("is_from_werewolves", bool);
    if (paramBoolean) {
      i = 2;
    } else {
      i = 3;
    }
    paramMessageRecord.putExtra("param_mode", i);
    if ((paramBoolean) && (paramHotChatInfo != null) && (paramHotChatInfo.isGameRoom))
    {
      ProfileUtils.openProfileCard(this.d, (AllInOne)localObject2);
      return true;
    }
    RouteUtils.a(this.d, paramMessageRecord, "/nearby/people/profile");
    return true;
  }
  
  private boolean a(String paramString, ChatMessage paramChatMessage, BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof HotChatPie))
    {
      HotChatManager localHotChatManager = (HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      HotChatInfo localHotChatInfo = localHotChatManager.c(this.c.b);
      if ((localHotChatInfo != null) && (localHotChatInfo.isGameRoom)) {
        return true;
      }
      ITroopRobotService localITroopRobotService = (ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all");
      if ((localHotChatInfo != null) && ((this.b.getCurrentAccountUin().equals(localHotChatInfo.ownerUin)) || (((localHotChatInfo.isOwnerOrAdmin(this.b.getCurrentAccountUin())) || (localHotChatManager.b())) && (!localHotChatInfo.isOwnerOrAdmin(paramChatMessage.senderuin)) && ((!localHotChatInfo.isRobotHotChat) || (!localITroopRobotService.isRobotUin(paramChatMessage.senderuin))))))
      {
        ((HotChatPie)paramBaseChatPie).a(paramChatMessage, paramString);
        return false;
      }
      ((HotChatPie)paramBaseChatPie).a(paramChatMessage.senderuin, paramString, false, 1);
    }
    return false;
  }
  
  private void b(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    int i = MultiMsgUtil.a(paramChatMessage) ^ true;
    paramViewGroup = AIOLongShotHelper.f();
    paramInt = i;
    if (paramViewGroup != null)
    {
      paramInt = i;
      if (paramViewGroup.c()) {
        paramInt = 1;
      }
    }
    if (paramInt != 0) {
      paramBaseChatItemLayout.setCheckBox(paramChatMessage);
    }
  }
  
  private boolean b(View paramView, MessageRecord paramMessageRecord)
  {
    Object localObject = (FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
    HotChatManager localHotChatManager = (HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    boolean bool;
    if ((localHotChatManager != null) && (localHotChatManager.b(paramMessageRecord.frienduin))) {
      bool = true;
    } else {
      bool = false;
    }
    if (a(paramView, paramMessageRecord, bool)) {
      return true;
    }
    if (bool)
    {
      paramView = localHotChatManager.c(paramMessageRecord.frienduin);
      if ((paramView != null) && (paramView.isRobotHotChat)) {
        bool = true;
      } else {
        bool = false;
      }
      if (a(paramMessageRecord, bool)) {
        return true;
      }
      bool = paramMessageRecord.isSelf();
      int i;
      if ((!bool) && ((localObject == null) || (((FriendsManager)localObject).n(paramMessageRecord.senderuin)))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return a(paramMessageRecord, bool, paramView);
      }
      if ((paramView != null) && (paramView.isGameRoom))
      {
        localObject = new AllInOne(paramMessageRecord.senderuin, 42);
        ((AllInOne)localObject).troopCode = paramView.troopCode;
        ((AllInOne)localObject).troopUin = paramMessageRecord.frienduin;
        ((AllInOne)localObject).profileEntryType = 113;
        ((AllInOne)localObject).reportExtra = NewReportPlugin.a(this.c);
        ProfileUtils.openProfileCard(this.d, (AllInOne)localObject);
        HotChatManager.a = false;
        return true;
      }
    }
    return false;
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForStructing)) && (TroopBindPublicAccountMgr.a(paramMessageRecord));
  }
  
  private void c(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {
      return;
    }
    if (a(paramView, localChatMessage)) {
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool2 = localChatMessage.isSelf();
    boolean bool1;
    String str;
    if (c(localChatMessage))
    {
      bool1 = localFriendsManager.n(localChatMessage.senderuin);
      str = localChatMessage.senderuin;
    }
    else
    {
      str = localChatMessage.frienduin;
      bool1 = false;
    }
    if (str == null) {
      return;
    }
    if (localFriendsManager.n(str)) {
      bool1 = true;
    }
    Object localObject;
    if (bool2)
    {
      localObject = new AllInOne(this.b.getCurrentAccountUin(), 0);
      ((AllInOne)localObject).nickname = this.b.getCurrentNickname();
    }
    for (;;)
    {
      break;
      if (localChatMessage.istroop == 1008)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("need_finish", true);
        ((Intent)localObject).putExtra("uin", this.c.b);
        ((Intent)localObject).putExtra("uinname", this.c.e);
        ((Intent)localObject).putExtra("uintype", this.c.a);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfileForResult((Intent)localObject, this.b, (Activity)paramView.getContext(), this.c.b, -1, 2000, 2, ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isComeFromReadInJoy());
        return;
      }
      if (localChatMessage.istroop == 1024)
      {
        CrmUtils.a(paramView.getContext(), null, this.c.b, true, -1, true, 2000);
        return;
      }
      if (bool1)
      {
        localObject = AllInOneFactory.a(this.b, localChatMessage, str);
      }
      else
      {
        if (localChatMessage.istroop == 1025)
        {
          if (this.d != null)
          {
            paramView = new Intent(this.d, ChatSettingActivity.class);
            paramView.putExtra("uin", this.c.b);
            paramView.putExtra("uinname", this.c.e);
            paramView.putExtra("uintype", this.c.a);
            this.d.startActivity(paramView);
          }
          return;
        }
        if (UinTypeUtil.e(localChatMessage.istroop) == 1044)
        {
          localObject = new AllInOne(this.c.b, 96);
          ((AllInOne)localObject).nickname = this.c.e;
        }
        else
        {
          localObject = AllInOneFactory.a(this.b, str, this.c, localChatMessage);
        }
      }
    }
    a(localChatMessage, str, (AllInOne)localObject);
    a(paramView, localChatMessage, localFriendsManager, bool1, bool2, str, (AllInOne)localObject);
  }
  
  private boolean c(View paramView, MessageRecord paramMessageRecord)
  {
    if (((ITempChatPluginManager)this.b.getRuntimeService(ITempChatPluginManager.class, "")).onHeadIconClickCusTempConv(this.d, paramMessageRecord.istroop, paramMessageRecord.senderuin)) {
      return true;
    }
    Object localObject = TroopBusinessUtil.a(paramMessageRecord);
    if (localObject != null)
    {
      a(paramMessageRecord, (TroopBusinessUtil.TroopBusinessMessage)localObject);
      return true;
    }
    if (b(paramMessageRecord))
    {
      d(paramView);
      return true;
    }
    boolean bool = AnonymousChatHelper.c(paramMessageRecord);
    int j = 0;
    if (bool)
    {
      localObject = AnonymousChatHelper.g(paramMessageRecord);
      int i;
      if (paramView != null)
      {
        i = j;
        if (((AnonymousChatHelper.AnonymousExtInfo)localObject).b == null)
        {
          i = j;
          if (((AnonymousChatHelper.AnonymousExtInfo)localObject).a == 2) {}
        }
      }
      else
      {
        i = 1;
      }
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HeadIconHandler", 2, "onHeadIconClick : an_id is null");
        }
        return true;
      }
      TroopInfo localTroopInfo = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramMessageRecord.frienduin);
      ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
      ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
      if (localTroopInfo != null)
      {
        localITroopInfoHandler.a(localTroopInfo.troopuin);
        localITroopMemberListHandler.a(1, TroopFileHandler.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
      }
      a(paramView, paramMessageRecord, (AnonymousChatHelper.AnonymousExtInfo)localObject, a(localTroopInfo));
      ReportController.b(this.b, "P_CliOper", "Grp_anon", "", "aio", "Clk_head", 0, 0, paramMessageRecord.frienduin, "", "", "");
      return true;
    }
    if ("1000000".equals(paramMessageRecord.senderuin))
    {
      TroopUtils.a(this.b, (Activity)paramView.getContext(), this.c.b, "1");
      return true;
    }
    return false;
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1020) && (paramMessageRecord.istroop != 1004);
  }
  
  private void d(View paramView)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.c.b);
    if ((localTroopInfo != null) && (localTroopInfo.associatePubAccount != 0L))
    {
      paramView = new ActivityURIRequest(paramView.getContext(), "/pubaccount/detail");
      Bundle localBundle = paramView.extra();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localTroopInfo.associatePubAccount);
      localStringBuilder.append("");
      localBundle.putString("uin", localStringBuilder.toString());
      QRoute.startUri(paramView, null);
    }
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    a(paramInt1, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
    a(paramChatMessage, paramBaseChatItemLayout);
    paramChatMessage = new IChatLayoutListener.ChatLayoutListenerInfo(paramInt1, paramInt2, this.c, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
    a(ChatLayoutListenerController.a, paramChatMessage);
  }
  
  public void a(IFaceDecoder paramIFaceDecoder)
  {
    this.g = paramIFaceDecoder;
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
    if (localObject == null) {
      return;
    }
    localObject = ((HeadIconWrapper)localObject).c();
    if (localObject != null) {
      ((BaseChatItemLayoutViewBasicAbility)localObject).setOnTouchListener(null);
    }
    if ((ConfessMsgUtil.b(paramChatMessage)) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("confessType =  ");
      ((StringBuilder)localObject).append(paramChatMessage.istroop);
      ((StringBuilder)localObject).append(" isSend = ");
      ((StringBuilder)localObject).append(paramChatMessage.isSend());
      QLog.d("HeadIconHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a == null) {
      this.a = new BaseBubbleBuilderHeadIconControllerImpl();
    }
    this.a.a(paramChatMessage, this.b, this.d, this.c, paramBaseChatItemLayout, this.e, this.f, this.g);
    if (this.a.h()) {
      this.a.a();
    }
  }
  
  public boolean a(View paramView)
  {
    if (paramView.getId() != 2131430587) {
      return false;
    }
    Object localObject1 = paramView.getContext();
    if (!(localObject1 instanceof BaseActivity)) {
      return true;
    }
    Object localObject2 = (BaseActivity)localObject1;
    localObject1 = (String)paramView.getTag(2131430587);
    paramView = (ChatMessage)paramView.getTag();
    if (paramView != null)
    {
      localObject2 = ((BaseActivity)localObject2).getChatFragment();
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((ChatFragment)localObject2).k();
      if (localObject2 == null) {
        return false;
      }
      if (a((String)localObject1, paramView, (BaseChatPie)localObject2)) {
        return true;
      }
      if ((localObject2 instanceof TroopChatPie))
      {
        ((TroopChatPie)localObject2).a(paramView.senderuin, (String)localObject1, false, 1);
        return true;
      }
      if ((localObject2 instanceof DiscussChatPie))
      {
        if (ContactUtils.h(this.b, paramView.frienduin)) {
          return true;
        }
        ((DiscussChatPie)localObject2).a(paramView.senderuin, (String)localObject1, false);
        ReportController.b(this.b, "CliOper", "", "", "0X8006210", "0X8006210", 0, 0, "", "", "", "");
        return true;
      }
      if ((localObject2 instanceof FriendChatPie))
      {
        ((BaseChatPie)localObject2).bo();
        ReportController.b(this.b, "dc00898", "", "", "0X800A010", "0X800A010", 0, 0, "", "", "", "");
        return true;
      }
      if (((localObject2 instanceof StrangerChatPie)) || ((localObject2 instanceof NearbyChatPie)) || ((localObject2 instanceof PublicAccountChatPie)))
      {
        ((BaseChatPie)localObject2).bo();
        ReportController.b(this.b, "dc00898", "", "", "0X800A011", "0X800A011", 0, 0, "", "", "", "");
      }
    }
    return true;
  }
  
  public void b(View paramView)
  {
    c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.HeadIconHandler
 * JD-Core Version:    0.7.0.1
 */