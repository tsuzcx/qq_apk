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
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
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
import java.net.URLEncoder;

public class HeadIconHandler
  extends ChatLayoutHandler
  implements IBaseBubbleClickProcessor, IBaseBubbleLongClickProcessor
{
  private BaseBubbleBuilderHeadIconController jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  
  public HeadIconHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  private int a(TroopInfo paramTroopInfo)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
    Object localObject = AIOLongShotHelper.a();
    if ((localObject != null) && (((AIOLongShotHelper)localObject).a()))
    {
      b(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
      return;
    }
    if ((BaseChatItemLayout.jdField_a_of_type_Boolean) && ((paramChatMessage instanceof MessageForStructing)))
    {
      localObject = ((MessageForStructing)paramChatMessage).structingMsg;
      if ((paramChatMessage.isSendFromLocal()) && ((localObject instanceof AbsShareMsg)) && (((AbsShareMsg)localObject).isSdkShareMsg()) && ((paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768)))
      {
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0)) {
          paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
        return;
      }
      if (((AbsStructMsg)localObject).mMsgServiceID == 14)
      {
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0)) {
          paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
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
    if ((localObject != null) && (paramAnonymousExtInfo.jdField_a_of_type_Int != 2))
    {
      AnonymousChatHelper.a = paramMessageRecord.shmsgseq;
      localObject = URLEncoder.encode(Base64.encodeToString((byte[])localObject, 2));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&gcode=");
      localStringBuilder.append(paramMessageRecord.frienduin);
      localStringBuilder.append("&avatar=");
      localStringBuilder.append(AnonymousChatHelper.a(paramAnonymousExtInfo.jdField_b_of_type_Int));
      localStringBuilder.append("&nick=");
      if (!TextUtils.isEmpty(paramAnonymousExtInfo.jdField_b_of_type_JavaLangString)) {
        str = URLEncoder.encode(paramAnonymousExtInfo.jdField_b_of_type_JavaLangString);
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
    else if (paramAnonymousExtInfo.jdField_a_of_type_Int == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=");
      ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
      ((StringBuilder)localObject).append("&avatar=");
      ((StringBuilder)localObject).append(AnonymousChatHelper.a(paramAnonymousExtInfo.jdField_b_of_type_Int));
      ((StringBuilder)localObject).append("&nick=");
      if (!TextUtils.isEmpty(paramAnonymousExtInfo.jdField_b_of_type_JavaLangString)) {
        str = URLEncoder.encode(paramAnonymousExtInfo.jdField_b_of_type_JavaLangString);
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
    if ((paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 1010) && (paramMessageRecord.istroop != 10002))
    {
      int i = 0;
      if ((!paramBoolean2) && (!paramFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        paramFriendsManager = StrangerChatPie.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBoolean1, paramBoolean2);
        if (paramFriendsManager != null)
        {
          paramAllInOne.extras.putSerializable("param_wzry_data", paramFriendsManager);
        }
        else if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("msg_ext_key")))
        {
          paramFriendsManager = paramMessageRecord.senderuin;
          paramFriendsManager = KplRoleInfo.WZRYUIinfo.createInfo(paramFriendsManager, KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, KplHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFriendsManager)), KplHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, 0);
          paramAllInOne.extras.putSerializable("param_wzry_data", paramFriendsManager);
        }
      }
      if (((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isExtendMatchChatType(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == 20) {
          i = 1;
        }
        ProfileActivity.a(paramView.getContext(), paramAllInOne, i, 2);
        return;
      }
      if (QCircleChatUtil.a(paramMessageRecord))
      {
        if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          return;
        }
        QCircleChatUtil.a(paramMessageRecord.senderuin);
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
    paramAllInOne.reportExtra = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramFriendsManager.putExtra("AllInOne", paramAllInOne);
    if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(paramAllInOne.uin)) {
      paramFriendsManager.putExtra("param_tiny_id", Long.valueOf(paramAllInOne.uin));
    }
    if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString)) {
      paramFriendsManager.putExtra("param_mode", 2);
    } else {
      paramFriendsManager.putExtra("param_mode", 3);
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      RouteUtils.a(paramView.getContext(), paramFriendsManager, "/nearby/people/profile", 9009);
      return;
    }
    RouteUtils.a(paramView.getContext(), paramFriendsManager, "/nearby/people/profile");
  }
  
  private void a(MessageRecord paramMessageRecord, TroopBusinessUtil.TroopBusinessMessage paramTroopBusinessMessage)
  {
    TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramTroopBusinessMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_head", 0, 0, paramMessageRecord.frienduin, "", paramTroopBusinessMessage.c, "");
    if (paramMessageRecord.msgtype == -2051) {
      try
      {
        paramMessageRecord = (MessageForQQStory)paramMessageRecord;
        paramMessageRecord = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.msgAction);
        QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_head", paramMessageRecord, false);
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
    paramAllInOne.reportExtra = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramAllInOne.preWinUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramAllInOne.preWinType = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if ((paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1020))
    {
      if (paramMessageRecord.istroop == 1)
      {
        paramAllInOne.troopUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
        paramAllInOne.troopCode = paramMessageRecord.frienduin;
      }
      else if (3000 == paramMessageRecord.istroop)
      {
        paramAllInOne.discussUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
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
      localObject = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    }
    try
    {
      long l = Long.parseLong(paramMessageRecord.senderuin);
      paramBoolean = ((ITroopRobotService)localObject).checkAndProcessJumpRobotPage(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, l);
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
    TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), paramMessageRecord.frienduin, paramMessageRecord.senderuin, 0, 2000);
    return true;
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((BusinessUtils.b(paramMessageRecord.senderuin)) && (BusinessUtils.a(this.jdField_a_of_type_AndroidContentContext))) {
      return true;
    }
    if (RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      } else {
        ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(this.jdField_a_of_type_AndroidContentContext, null, paramMessageRecord.senderuin);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString))) {
      return true;
    }
    if ("10000".equals(paramMessageRecord.senderuin)) {
      return true;
    }
    if ((paramMessageRecord.istroop == 3000) && (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin))) {
      return true;
    }
    return (paramMessageRecord instanceof MessageForTroopConfess);
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return (paramBoolean) && (((ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, Long.parseLong(paramMessageRecord.senderuin)));
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
        WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
        localObject1 = localObject2;
        if (localWerewolvesHandler.jdField_a_of_type_JavaLangString != null)
        {
          localObject1 = localObject2;
          if (localWerewolvesHandler.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.senderuin)) {
            return true;
          }
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    ProfilePerformanceReport.a();
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
    ((AllInOne)localObject2).reportExtra = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramMessageRecord.frienduin, paramMessageRecord.senderuin);
    boolean bool = false;
    HotChatManager.jdField_a_of_type_Boolean = false;
    paramMessageRecord = new Intent(this.jdField_a_of_type_AndroidContentContext, QQNearbyManager.b());
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
      ProfileUtils.openProfileCard(this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject2);
      return true;
    }
    RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord, "/nearby/people/profile");
    return true;
  }
  
  private boolean a(String paramString, ChatMessage paramChatMessage, BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof HotChatPie))
    {
      HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      HotChatInfo localHotChatInfo = localHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localHotChatInfo != null) && (localHotChatInfo.isGameRoom)) {
        return true;
      }
      ITroopRobotService localITroopRobotService = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
      if ((localHotChatInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localHotChatInfo.ownerUin)) || (((localHotChatInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (localHotChatManager.b())) && (!localHotChatInfo.isOwnerOrAdmin(paramChatMessage.senderuin)) && ((!localHotChatInfo.isRobotHotChat) || (!localITroopRobotService.isRobotUin(paramChatMessage.senderuin))))))
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
    paramViewGroup = AIOLongShotHelper.a();
    paramInt = i;
    if (paramViewGroup != null)
    {
      paramInt = i;
      if (paramViewGroup.a()) {
        paramInt = 1;
      }
    }
    if (paramInt != 0) {
      paramBaseChatItemLayout.setCheckBox(paramChatMessage);
    }
  }
  
  private void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {
      return;
    }
    if (a(paramView, localChatMessage)) {
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool2 = localChatMessage.isSelf();
    boolean bool1;
    String str;
    if (c(localChatMessage))
    {
      bool1 = localFriendsManager.b(localChatMessage.senderuin);
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
    if (localFriendsManager.b(str)) {
      bool1 = true;
    }
    Object localObject;
    if (localChatMessage.istroop == 10009)
    {
      IGameMsgHelperApi localIGameMsgHelperApi = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
      if (bool2) {
        localObject = "0";
      } else {
        localObject = "1";
      }
      localIGameMsgHelperApi.reportForGameMsg("0", "1", "176", "969", "96902", "206995", (String)localObject, "0", "20", "0");
    }
    if (bool2)
    {
      localObject = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      ((AllInOne)localObject).nickname = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      break;
      if (localChatMessage.istroop == 1008)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("need_finish", true);
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfileForResult((Intent)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 2, ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isComeFromReadInJoy());
        return;
      }
      if (localChatMessage.istroop == 1024)
      {
        CrmUtils.a(paramView.getContext(), null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
        return;
      }
      if (bool1)
      {
        localObject = AllInOneFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, str);
      }
      else
      {
        if (localChatMessage.istroop == 1025)
        {
          if (this.jdField_a_of_type_AndroidContentContext != null)
          {
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
            paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
            paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          }
          return;
        }
        if (UinTypeUtil.a(localChatMessage.istroop) == 1044)
        {
          localObject = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
          ((AllInOne)localObject).nickname = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        }
        else
        {
          localObject = AllInOneFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localChatMessage);
        }
      }
    }
    a(localChatMessage, str, (AllInOne)localObject);
    a(paramView, localChatMessage, localFriendsManager, bool1, bool2, str, (AllInOne)localObject);
  }
  
  private boolean b(View paramView, MessageRecord paramMessageRecord)
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
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
      paramView = localHotChatManager.a(paramMessageRecord.frienduin);
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
      if ((!bool) && ((localObject == null) || (((FriendsManager)localObject).b(paramMessageRecord.senderuin)))) {
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
        ((AllInOne)localObject).reportExtra = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        ProfileUtils.openProfileCard(this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject);
        HotChatManager.jdField_a_of_type_Boolean = false;
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
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  private boolean c(View paramView, MessageRecord paramMessageRecord)
  {
    if (((ITempChatPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).onHeadIconClickCusTempConv(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.istroop, paramMessageRecord.senderuin)) {
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
      c(paramView);
      return true;
    }
    boolean bool = AnonymousChatHelper.a(paramMessageRecord);
    int j = 0;
    if (bool)
    {
      localObject = AnonymousChatHelper.a(paramMessageRecord);
      int i;
      if (paramView != null)
      {
        i = j;
        if (((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_a_of_type_JavaLangString == null)
        {
          i = j;
          if (((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_a_of_type_Int == 2) {}
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
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramMessageRecord.frienduin);
      ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
      ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
      if (localTroopInfo != null)
      {
        localITroopInfoHandler.a(localTroopInfo.troopuin);
        localITroopMemberListHandler.a(1, TroopFileHandler.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
      }
      a(paramView, paramMessageRecord, (AnonymousChatHelper.AnonymousExtInfo)localObject, a(localTroopInfo));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio", "Clk_head", 0, 0, paramMessageRecord.frienduin, "", "", "");
      return true;
    }
    if ("1000000".equals(paramMessageRecord.senderuin))
    {
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1");
      return true;
    }
    return false;
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1020) && (paramMessageRecord.istroop != 1004);
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    a(paramInt1, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
    a(paramChatMessage, paramBaseChatItemLayout);
    paramChatMessage = new IChatLayoutListener.ChatLayoutListenerInfo(paramInt1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
    a(ChatLayoutListenerController.jdField_a_of_type_Int, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    b(paramView);
  }
  
  public void a(IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
    if (localObject == null) {
      return;
    }
    localObject = ((HeadIconWrapper)localObject).a();
    if (localObject != null) {
      ((BaseChatItemLayoutViewBasicAbility)localObject).setOnTouchListener(null);
    }
    if ((ConfessMsgUtil.a(paramChatMessage)) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("confessType =  ");
      ((StringBuilder)localObject).append(paramChatMessage.istroop);
      ((StringBuilder)localObject).append(" isSend = ");
      ((StringBuilder)localObject).append(paramChatMessage.isSend());
      QLog.d("HeadIconHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController = new BaseBubbleBuilderHeadIconControllerImpl();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatItemLayout, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.a();
    }
  }
  
  public boolean a(View paramView)
  {
    if (paramView.getId() != 2131364530) {
      return false;
    }
    Object localObject1 = paramView.getContext();
    if (!(localObject1 instanceof BaseActivity)) {
      return true;
    }
    Object localObject2 = (BaseActivity)localObject1;
    localObject1 = (String)paramView.getTag(2131364530);
    paramView = (ChatMessage)paramView.getTag();
    if (paramView != null)
    {
      localObject2 = ((BaseActivity)localObject2).getChatFragment();
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((ChatFragment)localObject2).a();
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
        if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin)) {
          return true;
        }
        ((DiscussChatPie)localObject2).a(paramView.senderuin, (String)localObject1, false);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006210", "0X8006210", 0, 0, "", "", "", "");
        return true;
      }
      if ((localObject2 instanceof FriendChatPie))
      {
        ((BaseChatPie)localObject2).am();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A010", "0X800A010", 0, 0, "", "", "", "");
        return true;
      }
      if (((localObject2 instanceof StrangerChatPie)) || ((localObject2 instanceof NearbyChatPie)) || ((localObject2 instanceof PublicAccountChatPie)))
      {
        ((BaseChatPie)localObject2).am();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A011", "0X800A011", 0, 0, "", "", "", "");
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.HeadIconHandler
 * JD-Core Version:    0.7.0.1
 */