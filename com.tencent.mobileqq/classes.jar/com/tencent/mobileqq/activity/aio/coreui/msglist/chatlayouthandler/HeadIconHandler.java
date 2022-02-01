package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AllInOneFactory;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconControllerImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatPluginManager;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.net.URLEncoder;

public class HeadIconHandler
  extends ChatLayoutHandler
  implements IBaseBubbleClickProcessor, IBaseBubbleLongClickProcessor
{
  private BaseBubbleBuilderHeadIconController jdField_a_of_type_ComTencentMobileqqActivityAioBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  
  public HeadIconHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  private int a(TroopInfo paramTroopInfo)
  {
    int j = 0;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int i = j;
    if (paramTroopInfo != null)
    {
      i = j;
      if (!TextUtils.isEmpty(str))
      {
        if ((paramTroopInfo.Administrator == null) || (!paramTroopInfo.Administrator.contains(str))) {
          break label50;
        }
        i = 3;
      }
    }
    return i;
    label50:
    if (str.equals(paramTroopInfo.troopowneruin)) {
      return 2;
    }
    return 1;
  }
  
  private void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    Object localObject = AIOLongShotHelper.a();
    if ((localObject != null) && (((AIOLongShotHelper)localObject).a())) {
      b(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
    }
    do
    {
      do
      {
        return;
        if ((!BaseChatItemLayout.jdField_a_of_type_Boolean) || (!(paramChatMessage instanceof MessageForStructing))) {
          break label158;
        }
        localObject = ((MessageForStructing)paramChatMessage).structingMsg;
        if ((!paramChatMessage.isSendFromLocal()) || (!(localObject instanceof AbsShareMsg)) || (!((AbsShareMsg)localObject).isSdkShareMsg()) || ((paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768))) {
          break;
        }
      } while ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox == null) || (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 0));
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      if (((AbsStructMsg)localObject).mMsgServiceID != 14) {
        break;
      }
    } while ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox == null) || (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 0));
    paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    return;
    label158:
    b(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, AnonymousChatHelper.AnonymousExtInfo paramAnonymousExtInfo, int paramInt)
  {
    Object localObject2 = paramAnonymousExtInfo.a();
    Object localObject1 = null;
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    if ((localObject2 != null) && (paramAnonymousExtInfo.jdField_a_of_type_Int != 2))
    {
      AnonymousChatHelper.a = paramMessageRecord.shmsgseq;
      localObject2 = URLEncoder.encode(Base64.encodeToString((byte[])localObject2, 2));
      localObject1 = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=").append((String)localObject2).append("&gcode=").append(paramMessageRecord.frienduin).append("&avatar=").append(AnonymousChatHelper.a(paramAnonymousExtInfo.jdField_b_of_type_Int)).append("&nick=");
      if (TextUtils.isEmpty(paramAnonymousExtInfo.jdField_b_of_type_JavaLangString))
      {
        paramAnonymousExtInfo = "";
        paramAnonymousExtInfo = paramAnonymousExtInfo + "&role=" + String.valueOf(paramInt) + "&self=0";
        localObject1 = paramAnonymousExtInfo;
        if (paramMessageRecord.msgData != null)
        {
          AnonymousChatHelper.a().a(paramMessageRecord.frienduin, (String)localObject2, paramMessageRecord);
          localObject1 = paramAnonymousExtInfo;
          if (QLog.isDevelopLevel())
          {
            QLog.i("HeadIconHandler", 4, "report:" + paramMessageRecord.msgData.toString());
            localObject1 = paramAnonymousExtInfo;
          }
        }
      }
    }
    while (paramAnonymousExtInfo.jdField_a_of_type_Int != 2) {
      for (;;)
      {
        localIntent.putExtra("url", AskAnonymousUtil.a(paramMessageRecord, (String)localObject1));
        ((Activity)paramView.getContext()).startActivity(localIntent);
        return;
        paramAnonymousExtInfo = URLEncoder.encode(paramAnonymousExtInfo.jdField_b_of_type_JavaLangString);
      }
    }
    localObject1 = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(paramMessageRecord.frienduin).append("&avatar=").append(AnonymousChatHelper.a(paramAnonymousExtInfo.jdField_b_of_type_Int)).append("&nick=");
    if (TextUtils.isEmpty(paramAnonymousExtInfo.jdField_b_of_type_JavaLangString)) {}
    for (paramAnonymousExtInfo = "";; paramAnonymousExtInfo = URLEncoder.encode(paramAnonymousExtInfo.jdField_b_of_type_JavaLangString))
    {
      localObject1 = paramAnonymousExtInfo + "&role=" + String.valueOf(paramInt) + "&self=1";
      break;
    }
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, FriendsManager paramFriendsManager, boolean paramBoolean1, boolean paramBoolean2, String paramString, ProfileActivity.AllInOne paramAllInOne)
  {
    int i = 0;
    if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 10002))
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      if (paramMessageRecord.istroop == 1001)
      {
        paramAllInOne.jdField_h_of_type_Int = 10;
        paramView.putExtra("frome_where", 21);
        paramAllInOne.jdField_a_of_type_AndroidOsBundle = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        paramView.putExtra("AllInOne", paramAllInOne);
        if (NearbyCardManager.a(paramAllInOne.jdField_a_of_type_JavaLangString)) {
          paramView.putExtra("param_tiny_id", Long.valueOf(paramAllInOne.jdField_a_of_type_JavaLangString));
        }
        if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString)) {
          break label213;
        }
        paramView.putExtra("param_mode", 2);
      }
      for (;;)
      {
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          break label225;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 9009);
        return;
        if (paramMessageRecord.istroop == 1010)
        {
          paramAllInOne.jdField_h_of_type_Int = 11;
          break;
        }
        if (paramMessageRecord.istroop != 10002) {
          break;
        }
        paramView.putExtra("frome_where", 22);
        break;
        label213:
        paramView.putExtra("param_mode", 3);
      }
      label225:
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    if ((!paramBoolean2) && (!paramFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramFriendsManager = StrangerChatPie.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBoolean1, paramBoolean2);
      if (paramFriendsManager == null) {
        break label329;
      }
      paramAllInOne.b.putSerializable("param_wzry_data", paramFriendsManager);
    }
    while (LimitChatUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == 20) {
        i = 1;
      }
      ProfileActivity.a(paramView.getContext(), paramAllInOne, i, 2);
      return;
      label329:
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("msg_ext_key")))
      {
        paramMessageRecord = paramMessageRecord.senderuin;
        paramMessageRecord = KplRoleInfo.WZRYUIinfo.createInfo(paramMessageRecord, KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, KplRoleInfo.getGameNickByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord)), KplRoleInfo.getKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, 0);
        paramAllInOne.b.putSerializable("param_wzry_data", paramMessageRecord);
      }
    }
    ProfileActivity.b(paramView.getContext(), paramAllInOne);
  }
  
  private void a(MessageRecord paramMessageRecord, TroopBusinessUtil.TroopBusinessMessage paramTroopBusinessMessage)
  {
    TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramTroopBusinessMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_head", 0, 0, paramMessageRecord.frienduin, "", paramTroopBusinessMessage.c, "");
    if (paramMessageRecord.msgtype == -2051) {}
    try
    {
      paramMessageRecord = (MessageForQQStory)paramMessageRecord;
      paramMessageRecord = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.msgAction);
      QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_head", paramMessageRecord, false);
      return;
    }
    catch (Exception paramMessageRecord)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramMessageRecord);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramString.equals(paramAllInOne.jdField_h_of_type_JavaLangString)) {
      paramAllInOne.jdField_h_of_type_JavaLangString = null;
    }
    paramAllInOne.jdField_a_of_type_AndroidOsBundle = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramAllInOne.f = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramAllInOne.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020)) {
      paramAllInOne.d = paramMessageRecord.senderuin;
    }
    for (;;)
    {
      paramAllInOne.g = 2;
      if (paramMessageRecord.istroop != 0) {
        break;
      }
      paramAllInOne.jdField_h_of_type_Int = 1;
      return;
      if (paramMessageRecord.istroop == 1)
      {
        paramAllInOne.d = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
        paramAllInOne.c = paramMessageRecord.frienduin;
      }
      else if (3000 == paramMessageRecord.istroop)
      {
        paramAllInOne.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
    }
    if (paramMessageRecord.istroop == 3000)
    {
      paramAllInOne.jdField_h_of_type_Int = 107;
      return;
    }
    if (paramMessageRecord.istroop == 1)
    {
      paramAllInOne.jdField_h_of_type_Int = 108;
      return;
    }
    paramAllInOne.jdField_h_of_type_Int = 106;
  }
  
  private boolean a(View paramView, MessageRecord paramMessageRecord)
  {
    if (a(paramMessageRecord)) {}
    while ((c(paramView, paramMessageRecord)) || (b(paramView, paramMessageRecord))) {
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    TroopRobotManager localTroopRobotManager;
    if (!paramBoolean)
    {
      bool1 = bool2;
      if (paramMessageRecord.istroop == 1) {
        localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      }
    }
    try
    {
      long l = Long.parseLong(paramMessageRecord.senderuin);
      paramBoolean = localTroopRobotManager.a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, l);
      if (paramBoolean)
      {
        bool1 = true;
        return bool1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("HeadIconHandler", 2, "parseLong error: messageRecord.senderuin = " + paramMessageRecord.senderuin);
      }
      TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), paramMessageRecord.frienduin, paramMessageRecord.senderuin, 0, 2000);
    }
    return true;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((BusinessUtils.b(paramMessageRecord.senderuin)) && (BusinessUtils.a(this.jdField_a_of_type_AndroidContentContext))) {
      return true;
    }
    if (RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        RobotUtils.a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HeadIconHandler", 2, "openRobotProfileCard, robotuin:" + paramMessageRecord.senderuin + " frienduin:" + paramMessageRecord.frienduin);
        }
        return true;
        RobotUtils.a(this.jdField_a_of_type_AndroidContentContext, null, paramMessageRecord.senderuin);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString))) {
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
    return (paramBoolean) && (((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, Long.parseLong(paramMessageRecord.senderuin)));
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, HotChatInfo paramHotChatInfo)
  {
    String str = null;
    if (paramHotChatInfo != null)
    {
      str = paramHotChatInfo.troopCode;
      if (paramHotChatInfo.isGameRoom)
      {
        localObject = (WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
        if ((((WerewolvesHandler)localObject).jdField_a_of_type_JavaLangString != null) && (((WerewolvesHandler)localObject).jdField_a_of_type_JavaLangString.equals(paramMessageRecord.senderuin))) {
          return true;
        }
      }
    }
    ProfilePerformanceReport.a();
    Object localObject = paramMessageRecord.senderuin;
    label131:
    boolean bool;
    if ((paramHotChatInfo != null) && (paramHotChatInfo.isBuLuoHotChat()))
    {
      i = 86;
      localObject = new ProfileActivity.AllInOne((String)localObject, i);
      ((ProfileActivity.AllInOne)localObject).c = str;
      ((ProfileActivity.AllInOne)localObject).d = paramMessageRecord.frienduin;
      if ((paramHotChatInfo == null) || (!paramHotChatInfo.isGameRoom)) {
        break label266;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 113;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_AndroidOsBundle = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      HotChatManager.jdField_a_of_type_Boolean = false;
      paramMessageRecord = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      paramMessageRecord.putExtra("AllInOne", (Parcelable)localObject);
      if (paramHotChatInfo == null) {
        break label276;
      }
      bool = paramHotChatInfo.isGameRoom;
      label206:
      paramMessageRecord.putExtra("is_from_werewolves", bool);
      if (!paramBoolean) {
        break label282;
      }
    }
    label266:
    label276:
    label282:
    for (int i = 2;; i = 3)
    {
      paramMessageRecord.putExtra("param_mode", i);
      if ((!paramBoolean) || (paramHotChatInfo == null) || (!paramHotChatInfo.isGameRoom)) {
        break label288;
      }
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
      return true;
      i = 42;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 31;
      break label131;
      bool = false;
      break label206;
    }
    label288:
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramMessageRecord);
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
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      if ((localHotChatInfo == null) || ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localHotChatInfo.ownerUin)) && (((!localHotChatInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (!localHotChatManager.b())) || (localHotChatInfo.isOwnerOrAdmin(paramChatMessage.senderuin)) || ((localHotChatInfo.isRobotHotChat) && (localTroopRobotManager.b(paramChatMessage.senderuin)))))) {
        break label155;
      }
      ((HotChatPie)paramBaseChatPie).a(paramChatMessage, paramString);
    }
    for (;;)
    {
      return false;
      label155:
      ((HotChatPie)paramBaseChatPie).a(paramChatMessage.senderuin, paramString, false, 1);
    }
  }
  
  private void b(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    if (!MultiMsgUtil.a(paramChatMessage)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramViewGroup = AIOLongShotHelper.a();
      int i = paramInt;
      if (paramViewGroup != null)
      {
        i = paramInt;
        if (paramViewGroup.a()) {
          i = 1;
        }
      }
      if (i != 0) {
        paramBaseChatItemLayout.setCheckBox(paramChatMessage);
      }
      return;
    }
  }
  
  private void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {
      break label11;
    }
    label11:
    while (a(paramView, localChatMessage)) {
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
      label70:
      if (str == null) {
        break label208;
      }
      if (!localFriendsManager.b(str)) {
        break label569;
      }
      bool1 = true;
    }
    label569:
    for (;;)
    {
      Object localObject;
      if (localChatMessage.istroop == 10009)
      {
        if (bool2)
        {
          localObject = "0";
          label107:
          GameMsgUtil.a("0", "1", "176", "969", "96902", "206995", (String)localObject, "0", "20", "0");
        }
      }
      else
      {
        if (!bool2) {
          break label218;
        }
        localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      }
      for (;;)
      {
        a(localChatMessage, str, (ProfileActivity.AllInOne)localObject);
        a(paramView, localChatMessage, localFriendsManager, bool1, bool2, str, (ProfileActivity.AllInOne)localObject);
        return;
        str = localChatMessage.frienduin;
        bool1 = false;
        break label70;
        label208:
        break label11;
        localObject = "1";
        break label107;
        label218:
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
            if (this.jdField_a_of_type_AndroidContentContext == null) {
              break;
            }
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
            paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
            paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            return;
          }
          if ((localChatMessage.istroop == 1037) || (UinTypeUtil.a(localChatMessage.istroop) == 1044))
          {
            localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
            ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
          }
          else
          {
            localObject = AllInOneFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localChatMessage);
          }
        }
      }
    }
  }
  
  private boolean b(View paramView, MessageRecord paramMessageRecord)
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramMessageRecord.frienduin))) {}
    for (boolean bool = true; a(paramView, paramMessageRecord, bool); bool = false) {
      return true;
    }
    if (bool)
    {
      paramView = localHotChatManager.a(paramMessageRecord.frienduin);
      if ((paramView != null) && (paramView.isRobotHotChat))
      {
        bool = true;
        label98:
        if (a(paramMessageRecord, bool)) {
          break label155;
        }
        bool = paramMessageRecord.isSelf();
        if ((!bool) && ((localObject == null) || (((FriendsManager)localObject).b(paramMessageRecord.senderuin)))) {
          break label157;
        }
      }
      label155:
      label157:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label162;
        }
        return a(paramMessageRecord, bool, paramView);
        bool = false;
        break label98;
        break;
      }
      label162:
      if ((paramView != null) && (paramView.isGameRoom))
      {
        localObject = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 42);
        ((ProfileActivity.AllInOne)localObject).c = paramView.troopCode;
        ((ProfileActivity.AllInOne)localObject).d = paramMessageRecord.frienduin;
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 113;
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_AndroidOsBundle = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
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
      paramView.extra().putString("uin", localTroopInfo.associatePubAccount + "");
      QRoute.startUri(paramView, null);
    }
  }
  
  private boolean c(View paramView, MessageRecord paramMessageRecord)
  {
    if (((TempChatPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.istroop, paramMessageRecord.senderuin)) {
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
    if (AnonymousChatHelper.a(paramMessageRecord))
    {
      localObject = AnonymousChatHelper.a(paramMessageRecord);
      if ((paramView == null) || ((((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_a_of_type_JavaLangString == null) && (((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_a_of_type_Int != 2))) {}
      for (int i = 1; i != 0; i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HeadIconHandler", 2, "onHeadIconClick : an_id is null");
        }
        return true;
      }
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramMessageRecord.frienduin);
      TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      TroopInfoHandler localTroopInfoHandler = (TroopInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
      if (localTroopInfo != null)
      {
        localTroopInfoHandler.b(localTroopInfo.troopuin);
        localTroopHandler.a(1, BizTroopHandler.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
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
    if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar != null) {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnTouchListener(null);
    }
    if ((ConfessMsgUtil.a(paramChatMessage)) && (QLog.isColorLevel())) {
      QLog.d("HeadIconHandler", 2, "confessType =  " + paramChatMessage.istroop + " isSend = " + paramChatMessage.isSend());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController = new BaseBubbleBuilderHeadIconControllerImpl();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatItemLayout, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.e();
    }
  }
  
  public boolean a(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return false;
        localObject1 = paramView.getContext();
        if (!(localObject1 instanceof FragmentActivity)) {
          return true;
        }
        localObject2 = (FragmentActivity)localObject1;
        localObject1 = (String)paramView.getTag(2131364643);
        paramView = (ChatMessage)paramView.getTag();
        if (paramView == null) {
          break;
        }
        localObject2 = ((FragmentActivity)localObject2).getChatFragment();
      } while (localObject2 == null);
      localObject2 = ((ChatFragment)localObject2).a();
    } while (localObject2 == null);
    if (a((String)localObject1, paramView, (BaseChatPie)localObject2)) {
      return true;
    }
    if ((localObject2 instanceof TroopChatPie)) {
      ((TroopChatPie)localObject2).a(paramView.senderuin, (String)localObject1, false, 1);
    }
    for (;;)
    {
      return true;
      if ((localObject2 instanceof DiscussChatPie))
      {
        if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin)) {
          return true;
        }
        ((DiscussChatPie)localObject2).a(paramView.senderuin, (String)localObject1, false);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006210", "0X8006210", 0, 0, "", "", "", "");
      }
      else if ((localObject2 instanceof FriendChatPie))
      {
        ((BaseChatPie)localObject2).be();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A010", "0X800A010", 0, 0, "", "", "", "");
      }
      else if (((localObject2 instanceof StrangerChatPie)) || ((localObject2 instanceof NearbyChatPie)) || ((localObject2 instanceof PublicAccountChatPie)))
      {
        ((BaseChatPie)localObject2).be();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A011", "0X800A011", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.HeadIconHandler
 * JD-Core Version:    0.7.0.1
 */