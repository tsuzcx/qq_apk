package com.tencent.mobileqq.activity.aio.rebuild;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.StrangerHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.StrangerQidianHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.StrangerMessageSender;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.StrangerMsgListRefresher;
import com.tencent.mobileqq.activity.aio.tips.MovieTicketTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Observable;

public class StrangerChatPie
  extends BaseChatPie
{
  boolean D = false;
  private boolean E = false;
  private boolean F = false;
  private boolean G = false;
  protected MessageObserver a;
  private QidianBusinessObserver a;
  private String d;
  
  public StrangerChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new StrangerChatPie.3(this);
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new StrangerChatPie.4(this);
  }
  
  public static Serializable a(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerChatPie", 2, String.format(Locale.getDefault(), "hasWzryInfo [%d, %b, %b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getIntent();
      localObject1 = localObject2;
      if (paramContext != null)
      {
        localObject1 = localObject2;
        if (!paramBoolean1)
        {
          localObject1 = localObject2;
          if (!paramBoolean2)
          {
            localObject1 = localObject2;
            if (paramInt == 1022)
            {
              localObject1 = localObject2;
              if (paramContext.hasExtra("param_wzry_data")) {
                localObject1 = paramContext.getSerializableExtra("param_wzry_data");
              }
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  private void a()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
    if (localRespondQueryQQBindingStat != null)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localRespondQueryQQBindingStat.nationCode);
      localStringBuilder.append(localRespondQueryQQBindingStat.mobileNo);
      localSessionInfo.e = localStringBuilder.toString();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) && (QLog.isColorLevel())) {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "contactUin == null");
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramInt != 55)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(paramInt);
        str = paramString.toString();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131714366), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    Object localObject;
    if ((paramString1 != null) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateSendMsgError uin ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" type ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" uniseq ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" errorCode ");
        localStringBuilder.append(paramInt2);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (paramInt1 == 1005)
      {
        p(paramInt2);
      }
      else if (paramInt1 == 1004)
      {
        o(paramInt2);
      }
      else if (paramInt1 == 1000)
      {
        a(paramString1, paramInt2, paramString2);
      }
      else if (paramInt1 == 1020)
      {
        n(paramInt2);
      }
      else if (paramInt1 == 1006)
      {
        m(paramInt2);
      }
      else if (paramInt1 == 1022)
      {
        l(paramInt2);
      }
      else if (paramInt1 == 1023)
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        paramString2 = new StringBuilder();
        paramString2.append("errorCode");
        paramString2.append(paramInt2);
        QQToast.a(paramString1, paramString2.toString(), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
      else if (paramInt1 == 1025)
      {
        a(paramInt2, paramString2);
      }
      e(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = this.jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateSendMsgError exception uin ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" type ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" uniseq ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d(paramString2, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693085), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    }
    switch (paramInt)
    {
    default: 
      if (paramInt > 100)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      break;
    case 104: 
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    case 102: 
    case 103: 
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "Grp_data", "forbid_temp", 0, 0, paramString1, "", "", "");
    }
  }
  
  private void aq()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (localObject == null) {
      return;
    }
    String str = ((Intent)localObject).getStringExtra("gid");
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str))
    {
      localObject = StructMsgFactory.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
      if (localObject != null)
      {
        ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (AbsStructMsg)localObject, null);
        if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "1", "", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "", "1", "", "");
      }
    }
  }
  
  private void h(Intent paramIntent)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("From chatActivity : accost Sig--->");
      localStringBuilder.append(HexUtil.bytes2HexStr(arrayOfByte));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (arrayOfByte != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
    }
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
    {
      ChatActivityFacade.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    if ((((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) && (StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
    }
  }
  
  private void i(Intent paramIntent)
  {
    paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("From chatActivity : sameState Sig--->");
      localStringBuilder.append(HexUtil.bytes2HexStr(paramIntent));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
    }
  }
  
  private void j(Intent paramIntent)
  {
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
    {
      ChatActivityFacade.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    if ((((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) && (StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
    }
  }
  
  private void k(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = paramIntent.getStringExtra("troop_code");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c.trim().length() == 0))
    {
      paramIntent = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = paramIntent.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == null)
      {
        paramIntent = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  private void l(int paramInt)
  {
    if (paramInt != 16) {
      return;
    }
    ChatActivityFacade.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private void m(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1602: 
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692072), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    case 1601: 
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692073), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692073), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  private void n(int paramInt)
  {
    if (paramInt != 40) {
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697749);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (CharSequence)localObject, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  private void o(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691764), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  private void p(int paramInt)
  {
    if (paramInt != 55)
    {
      if ((paramInt != 211) && (paramInt != 1603))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720415), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720414), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
  }
  
  protected void J()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.isGetOnlineListRecently()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.shouldGetOnlineInfo())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getOnlineInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004)
    {
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        this.jdField_d_of_type_JavaLangString = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString("", "strangerchat_ext", "");
      } else {
        ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putString("", "strangerchat_ext", this.jdField_d_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        MovieTicketTipsBar localMovieTicketTipsBar = new MovieTicketTipsBar(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localMovieTicketTipsBar, new Object[] { this.jdField_d_of_type_JavaLangString });
      }
    }
    super.J();
  }
  
  protected void O()
  {
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
  }
  
  protected AIOContext a()
  {
    return new StrangerContext();
  }
  
  protected AIOInput a()
  {
    return new AIOInputBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new StrangerMessageSender(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new StrangerMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected HelperProvider a()
  {
    return new StrangerHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  protected String a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && (paramMessageRecord == null) && (paramList.size() == 0)) {
      paramList = ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c);
    } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025) {
      paramList = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) {
      paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131698613);
    } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10010) {
      paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131719183);
    } else {
      paramList = super.a(paramList, paramMessageRecord);
    }
    paramMessageRecord = ((ITempChatPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (paramMessageRecord != null) {
      paramList = paramMessageRecord.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, TempChatSource.SOURCE_FROM_AIO);
    }
    return paramList;
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  protected boolean a()
  {
    boolean bool2 = this.x;
    boolean bool1 = false;
    if ((bool2) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void ao()
  {
    if (this.D)
    {
      this.D = false;
      aq();
    }
    if (this.E)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.E);
      this.E = false;
    }
  }
  
  public void ap()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      Intent localIntent = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, 3006, 12, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, null, null, null, null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1020) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
        {
          paramIntent = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (paramIntent != null) {
            paramIntent = paramIntent.name;
          } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) {
            paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
          } else {
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          }
        }
        else
        {
          str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
          if (str != null)
          {
            paramIntent = str;
            if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1005) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10004))
          {
            paramIntent = str;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10010) {}
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            paramIntent = str;
          }
        }
      }
      else {
        paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    this.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    this.e.setOnClickListener(new StrangerChatPie.1(this));
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "StrangerChatPie";
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) && (QLog.isColorLevel())) {
      QLog.i("addFriendTag", 4, String.format(Locale.getDefault(), "BaseChatPie addFriend uin: %s troopuin: %s sourceId: %d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int) }));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.F) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    super.c(paramBoolean);
  }
  
  protected boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10008);
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1020))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
        this.jdField_b_of_type_Boolean = false;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        a();
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003)
      {
        j(paramIntent);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009)
      {
        i(paramIntent);
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002))
      {
        byte[] arrayOfByte;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_movie_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
          }
          this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("strangerchat_ext");
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().k(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10008)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), arrayOfByte);
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10010)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().o(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10009)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), arrayOfByte);
          }
        }
      }
      else
      {
        h(paramIntent);
      }
    }
    else {
      k(paramIntent);
    }
    this.D = paramIntent.getBooleanExtra("fromSencondhandCommunity", false);
    this.F = paramIntent.getBooleanExtra("from3rdApp", false);
    this.G = paramIntent.getBooleanExtra("from_wpa_for_crm", false);
    this.E = WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  public boolean d()
  {
    if ((this.F) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    return super.d();
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if ((paramIntent.hasExtra("key_sub_title_from")) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) || (!((StrangerQidianHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(61)).a(true))))
    {
      paramIntent = paramIntent.getStringExtra("key_sub_title_from");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (this.f.getVisibility() == 8) {
          a(true);
        }
        this.f.setText(paramIntent);
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
    ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      a(true);
      this.f.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719184));
      if (jdField_a_of_type_Boolean) {
        this.f.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719184));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)
    {
      a(true);
      this.f.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719185));
      if (jdField_a_of_type_Boolean) {
        this.f.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719185));
      }
    }
  }
  
  protected void i()
  {
    super.i();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(8, 8);
    }
  }
  
  protected void j()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new StrangerChatPie.2(this));
    if ((!ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1))
    {
      if ((this.e.getText() != null) && (this.e.getText().length() < 6)) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      } else {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698601));
    }
    else
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void k()
  {
    if ((BusinessUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (BusinessUtils.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      boolean bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals(""))) {
        bool = false;
      } else {
        bool = true;
      }
      localIntent.putExtra("isShieldMsgSwitchUnClickable", bool);
    }
    if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    }
    localIntent.putExtra("add_friend_source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int);
    localIntent.putExtra("real_troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c);
    Object localObject = a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, false);
    if (localObject != null)
    {
      localIntent.putExtra("param_wzry_data", (Serializable)localObject);
      localIntent.putExtra("uinname", ((KplRoleInfo.WZRYUIinfo)localObject).nick);
    }
    else if (KplHelper.a(this))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      String str = KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, KplHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject));
      localIntent.putExtra("param_wzry_data", KplRoleInfo.WZRYUIinfo.createInfo((String)localObject, str, KplHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, 0));
      localIntent.putExtra("uinname", str);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
  }
  
  protected void n()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1020) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        localObject = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          localObject = ((PhoneContact)localObject).name;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) {
          localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        } else {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
      else
      {
        String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1005) {
          if (str != null)
          {
            localObject = str;
            if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = str;
          }
        }
      }
    }
    else {
      localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ((String)localObject);
  }
  
  public void p()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
    }
    if (KplHelper.a(this))
    {
      ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "kpl global has been remove, because StrangerChatPie close");
      }
    }
    super.p();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (UinTypeUtil.b(paramObservable.istroop)))) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a();
        if ((paramObservable != null) && ((paramObservable.istroop == 1001) || (paramObservable.istroop == 10002)) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), paramObservable.action);
        }
      }
    }
  }
  
  public void y()
  {
    super.y();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (KplHelper.a(this))
    {
      localFriendsManager.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "open kpl session, mark global flag");
      }
    }
    else
    {
      localFriendsManager.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "not open kpl session, reset global flag");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie
 * JD-Core Version:    0.7.0.1
 */