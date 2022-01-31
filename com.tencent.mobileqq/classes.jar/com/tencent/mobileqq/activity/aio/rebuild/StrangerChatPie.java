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
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.MovieTicketTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import vzi;
import vzj;
import vzk;
import vzl;
import vzm;

public class StrangerChatPie
  extends BaseChatPie
{
  boolean O = false;
  private boolean P;
  private boolean Q;
  private boolean R;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new vzm(this);
  protected MessageObserver a;
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new vzj(this);
  public QidianManager a;
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new vzl(this);
  private String f;
  
  public StrangerChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vzk(this);
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
  
  private void aY()
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
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "1", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "", "1", "", "");
  }
  
  protected void G()
  {
    super.G();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
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
  
  protected void W()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004)
    {
      if (!TextUtils.isEmpty(this.f)) {
        break label131;
      }
      this.f = QWalletSetting.a("", "strangerchat_ext", "");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.f))
      {
        MovieTicketTipsBar localMovieTicketTipsBar = new MovieTicketTipsBar(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localMovieTicketTipsBar, new Object[] { this.f });
      }
      super.W();
      return;
      label131:
      QWalletSetting.a("", "strangerchat_ext", this.f);
    }
  }
  
  public QidianManager a()
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianManager == null) {
      this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164));
    }
    return this.jdField_a_of_type_ComTencentQidianQidianManager;
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((MsgProxyUtils.t(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.c(paramMessageRecord.istroop))));
  }
  
  public void aX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      Intent localIntent = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, 3006, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, null, null, null, null);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
    }
  }
  
  protected void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  protected void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void ak()
  {
    super.ak();
    if (this.O)
    {
      this.O = false;
      aY();
    }
    if (this.P)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.P);
      this.P = false;
    }
  }
  
  public void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1020) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004)) {
        break label109;
      }
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      return;
      label109:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        paramIntent = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramIntent != null) {
          paramIntent = paramIntent.name;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) {
          paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        } else {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
      else
      {
        str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        if (str != null)
        {
          paramIntent = str;
          if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1005) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025))
        {
          paramIntent = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10004) {}
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramIntent = str;
        }
      }
    }
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      PhoneContact localPhoneContact = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("StrangerChatPie.showorhideAddFriend curFriendUin=").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).append(" contact=");
        if (localPhoneContact != null) {
          break label102;
        }
      }
      label102:
      for (String str = "null";; str = "real")
      {
        QLog.d("StrangerChatPie", 2, str);
        if (localPhoneContact == null) {
          break;
        }
        return false;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) {
      return false;
    }
    return !((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025)
    {
      paramIntent = paramIntent.getByteArrayExtra("sigt");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
        if (QLog.isDevelopLevel()) {
          QLog.d("StrangerChatPie", 4, "updateSession()--AIO 已保存 sigt");
        }
      }
      if (a().a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      if (a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) && (QLog.isColorLevel())) {
      QLog.i("addFriendTag", 4, String.format(Locale.getDefault(), "BaseChatPie addFriend uin: %s troopuin: %s sourceId: %d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int) }));
    }
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = paramIntent.getStringExtra("troop_code");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c.trim().length() == 0))
      {
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == null)
        {
          localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = ((HotChatManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        }
      }
    }
    for (;;)
    {
      this.O = paramIntent.getBooleanExtra("fromSencondhandCommunity", false);
      this.Q = paramIntent.getBooleanExtra("from3rdApp", false);
      this.R = paramIntent.getBooleanExtra("from_wpa_for_crm", false);
      this.P = WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      StartupTracker.a("AIO_updateSession_business", null);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) && (QLog.isColorLevel())) {
          QLog.e("StrangerChatPie", 2, "contactUin == null");
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = true;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003)
      {
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
        {
          ChatActivityFacade.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        else
        {
          localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject == null)
          {
            if (StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
            }
          }
          else if ((localObject != null) && (((Card)localObject).strCertificationInfo != null) && (!((Card)localObject).strCertificationInfo.equals(""))) {
            ChatActivityFacade.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009)
      {
        localObject = paramIntent.getByteArrayExtra("rich_status_sig");
        if (QLog.isColorLevel()) {
          QLog.d("StrangerChatPie", 2, "From chatActivity : sameState Sig--->" + HexUtil.a((byte[])localObject));
        }
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
      {
        localObject = paramIntent.getByteArrayExtra("rich_accost_sig");
        if (QLog.isColorLevel()) {
          QLog.d("StrangerChatPie", 2, "From chatActivity : accost Sig--->" + HexUtil.a((byte[])localObject));
        }
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
        }
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
        {
          ChatActivityFacade.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        else
        {
          localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject == null)
          {
            if (StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
            }
          }
          else if ((localObject != null) && (((Card)localObject).strCertificationInfo != null) && (!((Card)localObject).strCertificationInfo.equals(""))) {
            ChatActivityFacade.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004)
      {
        localObject = paramIntent.getByteArrayExtra("rich_movie_sig");
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().j(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
        }
        this.f = paramIntent.getStringExtra("strangerchat_ext");
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010)
      {
        localObject = paramIntent.getByteArrayExtra("rich_date_sig");
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().m(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1029)
      {
        localObject = paramIntent.getByteArrayExtra("rich_campus_circle_sig");
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().l(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
        }
        else
        {
          localObject = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
          if (localObject != null) {
            ((CardHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 15);
          }
          if (QLog.isColorLevel()) {
            QLog.i("StrangerChatPie", 2, "campus temp talk, sig is null, need request sig");
          }
        }
      }
    }
  }
  
  protected boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004);
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if ((paramIntent.hasExtra("key_sub_title_from")) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) || (!a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))))
    {
      paramIntent = paramIntent.getStringExtra("key_sub_title_from");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (this.e.getVisibility() == 8) {
          b(true);
        }
        this.e.setText(paramIntent);
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    if ((this.Q) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StrangerChatPie", 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    super.e(paramBoolean);
  }
  
  protected boolean e()
  {
    if ((this.Q) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    return super.e();
  }
  
  protected void n()
  {
    if (this.b) {
      y();
    }
  }
  
  protected void o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(8, 8);
    }
  }
  
  protected void p()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new vzi(this));
    if ((ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
    {
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131433381));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if ((this.jdField_d_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getText().length() < 6))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void s()
  {
    if ((Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (Utils.a(this.jdField_a_of_type_AndroidContentContext))) {
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals("")))
      {
        bool = true;
        localIntent.putExtra("isShieldMsgSwitchUnClickable", bool);
      }
    }
    else
    {
      if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      localIntent.putExtra("add_friend_source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int);
      localObject = a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, false);
      if (localObject == null) {
        break label250;
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
      label250:
      if (KplRoleInfo.isKplPie(this))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        String str = KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, KplRoleInfo.getGameNickByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject));
        localIntent.putExtra("param_wzry_data", KplRoleInfo.WZRYUIinfo.createInfo((String)localObject, str, KplRoleInfo.getKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, 0));
        localIntent.putExtra("uinname", str);
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.c(paramObservable.istroop)))) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if ((paramObservable != null) && ((paramObservable.istroop == 1001) || (paramObservable.istroop == 10002)) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramObservable.action);
        }
      }
    }
  }
  
  protected void v()
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
        localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          localObject = ((PhoneContact)localObject).name;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) {
          localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        } else {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
      else
      {
        String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1005) {
          if (str != null)
          {
            localObject = str;
            if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = str;
          }
        }
      }
    }
  }
  
  protected void y()
  {
    if ((this.b) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) || (!a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006))
    {
      Object localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (ContactUtils.a(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) == 0)) {
        break label126;
      }
      localObject = ContactUtils.a((PhoneContact)localObject);
      b(true);
      this.e.setText((CharSequence)localObject);
      if (N) {
        this.e.setContentDescription((CharSequence)localObject);
      }
    }
    label126:
    do
    {
      do
      {
        return;
      } while (this.e.getVisibility() != 0);
      b(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 5);
    FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
  }
  
  protected void z()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
    }
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025)) {
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    }
    if (KplRoleInfo.isKplPie(this))
    {
      ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "kpl global has been remove, because StrangerChatPie close");
      }
    }
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie
 * JD-Core Version:    0.7.0.1
 */