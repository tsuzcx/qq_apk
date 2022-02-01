package com.tencent.mobileqq.activity.aio.rebuild;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.MovieTicketTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;

public class StrangerChatPie
  extends BaseChatPie
{
  boolean N = false;
  private boolean O = false;
  private boolean P = false;
  private boolean Q = false;
  protected MessageObserver a;
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new StrangerChatPie.3(this);
  QidianManager jdField_a_of_type_ComTencentQidianQidianManager;
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new StrangerChatPie.5(this);
  private String f;
  
  public StrangerChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new StrangerChatPie.4(this);
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
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a();
    if (localRespondQueryQQBindingStat != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = (localRespondQueryQQBindingStat.nationCode + localRespondQueryQQBindingStat.mobileNo);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "contactUin == null");
    }
    this.jdField_b_of_type_Boolean = false;
    this.c = true;
  }
  
  private void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "" + paramInt;
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, HardCodeUtil.a(2131714445), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong + " errorCode " + paramInt2);
    }
    if (paramInt1 == 1005) {
      z(paramInt2);
    }
    for (;;)
    {
      g(196608);
      return;
      if (paramInt1 == 1004) {
        y(paramInt2);
      } else if (paramInt1 == 1000) {
        a(paramString1, paramInt2, paramString2);
      } else if (paramInt1 == 1020) {
        x(paramInt2);
      } else if (paramInt1 == 1006) {
        w(paramInt2);
      } else if (paramInt1 == 1022) {
        v(paramInt2);
      } else if (paramInt1 == 1023) {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "errorCode" + paramInt2, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      } else if (paramInt1 == 1025) {
        a(paramInt2, paramString2);
      }
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131693125), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    }
    switch (paramInt)
    {
    default: 
      if (paramInt > 100) {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      return;
    case 102: 
    case 103: 
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "Grp_data", "forbid_temp", 0, 0, paramString1, "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  private void bj()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localObject == null) {}
    do
    {
      String str;
      do
      {
        return;
        str = ((Intent)localObject).getStringExtra("gid");
      } while (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str));
      localObject = StructMsgFactory.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
    } while (localObject == null);
    ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (AbsStructMsg)localObject, null);
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "1", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "", "1", "", "");
  }
  
  private void h(Intent paramIntent)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "From chatActivity : accost Sig--->" + HexUtil.bytes2HexStr(arrayOfByte));
    }
    if (arrayOfByte != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
    }
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
      ChatActivityFacade.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    while ((((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) || (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
  }
  
  private void i(Intent paramIntent)
  {
    paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "From chatActivity : sameState Sig--->" + HexUtil.bytes2HexStr(paramIntent));
    }
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
    }
  }
  
  private void j(Intent paramIntent)
  {
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
      ChatActivityFacade.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    while ((((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) || (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
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
  
  private void v(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ChatActivityFacade.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private void w(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1600: 
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131692154), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    case 1601: 
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131692154), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131692153), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  private void x(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697743);
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (CharSequence)localObject, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  private void y(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    String str = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691842), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  private void z(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720696), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    case 55: 
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720695), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public void C()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
      localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ((String)localObject);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          localObject = ((PhoneContact)localObject).name;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString != null) {
          localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
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
  }
  
  public void F()
  {
    if ((this.c) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) || (!a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006))
    {
      PhoneContact localPhoneContact = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (((localPhoneContact == null) || (ContactUtils.a(localPhoneContact.detalStatusFlag, localPhoneContact.iTermType) == 0)) && (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() == 5))
      {
        FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      }
    }
  }
  
  public void J()
  {
    if (this.d != null) {
      this.d.setOnClickListener(null);
    }
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025)) {
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    }
    if (BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentQidianQidianManager != null) {
        break label213;
      }
    }
    label213:
    for (String str = "";; str = this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "8.5.5", "");
      if (KplRoleInfo.isKplPie(this))
      {
        ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "kpl global has been remove, because StrangerChatPie close");
        }
      }
      super.J();
      return;
    }
  }
  
  public void R()
  {
    super.R();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (KplRoleInfo.isKplPie(this))
    {
      localFriendsManager.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "open kpl session, mark global flag");
      }
    }
    do
    {
      return;
      localFriendsManager.jdField_a_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    QLog.d("KplMessage", 2, "not open kpl session, reset global flag");
  }
  
  public QidianManager a()
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianManager == null) {
      this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
    return this.jdField_a_of_type_ComTencentQidianQidianManager;
  }
  
  public String a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && (paramMessageRecord == null) && (paramList.size() == 0)) {
      paramList = ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c);
    }
    for (;;)
    {
      paramMessageRecord = ((TempChatPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (paramMessageRecord != null) {
        paramList = paramMessageRecord.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, TempChatSource.SOURCE_FROM_AIO);
      }
      return paramList;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025) {
        paramList = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) {
        paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131698547);
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10010) {
        paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131719465);
      } else {
        paramList = super.a(paramList, paramMessageRecord);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public boolean a()
  {
    boolean bool = false;
    if ((this.D) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((MsgProxyUtils.l(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (UinTypeUtil.b(paramMessageRecord.istroop))));
  }
  
  public void ad()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.isGetOnlineListRecently()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.shouldGetOnlineInfo())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getOnlineInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004)
    {
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        break label132;
      }
      this.jdField_f_of_type_JavaLangString = QWalletSetting.a("", "strangerchat_ext", "");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
      {
        MovieTicketTipsBar localMovieTicketTipsBar = new MovieTicketTipsBar(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localMovieTicketTipsBar, new Object[] { this.jdField_f_of_type_JavaLangString });
      }
      super.ad();
      return;
      label132:
      QWalletSetting.a("", "strangerchat_ext", this.jdField_f_of_type_JavaLangString);
    }
  }
  
  public void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
  }
  
  public void ao()
  {
    super.ao();
    if (this.N)
    {
      this.N = false;
      bj();
    }
    if (this.O)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.O);
      this.O = false;
    }
  }
  
  public void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1020) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004)) {
        break label124;
      }
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
      this.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      this.e.setOnClickListener(new StrangerChatPie.1(this));
      return;
      label124:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        paramIntent = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramIntent != null) {
          paramIntent = paramIntent.name;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString != null) {
          paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
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
  }
  
  public void bf()
  {
    super.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
  }
  
  public void bi()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      Intent localIntent = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, 3006, 12, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, null, null, null, null);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "StrangerChatPie";
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025)
    {
      paramIntent = paramIntent.getByteArrayExtra("sigt");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 4, "updateSession()--AIO 已保存 sigt");
        }
      }
      if (a().a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      if (a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) && (QLog.isColorLevel())) {
      QLog.i("addFriendTag", 4, String.format(Locale.getDefault(), "BaseChatPie addFriend uin: %s troopuin: %s sourceId: %d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int) }));
    }
  }
  
  public boolean c()
  {
    if (y()) {
      return false;
    }
    if (this.G) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      PhoneContact localPhoneContact = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      String str2;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str2 = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("StrangerChatPie.showorhideAddFriend curFriendUin=").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).append(" contact=");
        if (localPhoneContact != null) {
          break label127;
        }
      }
      label127:
      for (String str1 = "null";; str1 = "real")
      {
        QLog.d(str2, 2, str1);
        if (localPhoneContact == null) {
          break;
        }
        return false;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) {
      return false;
    }
    return !((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020)) {
      k(paramIntent);
    }
    for (;;)
    {
      this.N = paramIntent.getBooleanExtra("fromSencondhandCommunity", false);
      this.P = paramIntent.getBooleanExtra("from3rdApp", false);
      this.Q = paramIntent.getBooleanExtra("from_wpa_for_crm", false);
      this.O = WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      StartupTracker.a("AIO_updateSession_business", null);
      return;
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
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
      {
        h(paramIntent);
      }
      else
      {
        byte[] arrayOfByte;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_movie_sig");
          if (arrayOfByte != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
          }
          this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("strangerchat_ext");
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), arrayOfByte);
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), arrayOfByte);
          }
        }
      }
    }
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if ((paramIntent.hasExtra("key_sub_title_from")) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) || (!a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))))
    {
      paramIntent = paramIntent.getStringExtra("key_sub_title_from");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 8) {
          b(true);
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramIntent);
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.P) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    super.e(paramBoolean);
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10008);
  }
  
  public boolean g()
  {
    if ((this.P) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    return super.g();
  }
  
  public void m(int paramInt)
  {
    super.m(paramInt);
    if (BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      aE();
      if (this.jdField_a_of_type_ComTencentQidianQidianManager != null) {
        break label94;
      }
    }
    label94:
    for (String str = "";; str = this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "8.5.5", "");
      ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      return;
    }
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      b(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719466));
      if (jdField_a_of_type_Boolean) {
        this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719466));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)
    {
      b(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719467));
      if (jdField_a_of_type_Boolean) {
        this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719467));
      }
    }
  }
  
  public void u()
  {
    super.u();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(8, 8);
    }
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
          OpenAppClient.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramObservable.action);
        }
      }
    }
  }
  
  public void v()
  {
    this.d.setOnClickListener(new StrangerChatPie.2(this));
    if ((ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.d.setVisibility(0);
        this.d.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698535));
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025)) {
        this.d.setVisibility(8);
      }
      return;
      this.d.setVisibility(8);
      continue;
      if ((this.e.getText() != null) && (this.e.getText().length() < 6)) {
        this.d.setVisibility(4);
      } else {
        this.d.setVisibility(8);
      }
    }
  }
  
  public void z()
  {
    if ((BusinessUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (BusinessUtils.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    boolean bool;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString.equals("")))
      {
        bool = true;
        localIntent.putExtra("isShieldMsgSwitchUnClickable", bool);
      }
    }
    else
    {
      if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      }
      localIntent.putExtra("add_friend_source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int);
      localIntent.putExtra("real_troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c);
      localObject = a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, false);
      if (localObject == null) {
        break label265;
      }
      localIntent.putExtra("param_wzry_data", (Serializable)localObject);
      localIntent.putExtra("uinname", ((KplRoleInfo.WZRYUIinfo)localObject).nick);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
      return;
      bool = false;
      break;
      label265:
      if (KplRoleInfo.isKplPie(this))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        String str = KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, KplRoleInfo.getGameNickByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject));
        localIntent.putExtra("param_wzry_data", KplRoleInfo.WZRYUIinfo.createInfo((String)localObject, str, KplRoleInfo.getKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, 0));
        localIntent.putExtra("uinname", str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie
 * JD-Core Version:    0.7.0.1
 */