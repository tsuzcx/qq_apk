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
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
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
  private boolean bi = false;
  private boolean bj = false;
  boolean bk = false;
  protected MessageObserver bl = new StrangerChatPie.3(this);
  private boolean bm = false;
  private String bn;
  private QidianBusinessObserver bo = new StrangerChatPie.4(this);
  
  public StrangerChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
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
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
    if (localRespondQueryQQBindingStat != null)
    {
      SessionInfo localSessionInfo = this.ah;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localRespondQueryQQBindingStat.nationCode);
      localStringBuilder.append(localRespondQueryQQBindingStat.mobileNo);
      localSessionInfo.f = localStringBuilder.toString();
    }
    this.ah.g = ContactUtils.b(this.d, this.ah.b);
    if ((this.ah.g == null) && (QLog.isColorLevel())) {
      QLog.e(this.c, 2, "contactUin == null");
    }
    this.P = false;
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
      QQToast.makeText(this.f, str, 0).show(this.f.getTitleBarHeight());
      return;
    }
    QQToast.makeText(this.f, HardCodeUtil.a(2131911880), 0).show(this.f.getTitleBarHeight());
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    Object localObject;
    if ((paramString1 != null) && (paramString1.equals(this.ah.b)) && (paramInt1 == this.ah.a))
    {
      if (QLog.isColorLevel())
      {
        localObject = this.c;
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
        w(paramInt2);
      }
      else if (paramInt1 == 1004)
      {
        v(paramInt2);
      }
      else if (paramInt1 == 1000)
      {
        a(paramString1, paramInt2, paramString2);
      }
      else if (paramInt1 == 1020)
      {
        u(paramInt2);
      }
      else if (paramInt1 == 1006)
      {
        t(paramInt2);
      }
      else if (paramInt1 == 1022)
      {
        s(paramInt2);
      }
      else if (paramInt1 == 1023)
      {
        paramString1 = this.f;
        paramString2 = new StringBuilder();
        paramString2.append("errorCode");
        paramString2.append(paramInt2);
        QQToast.makeText(paramString1, paramString2.toString(), 0).show(this.f.getTitleBarHeight());
      }
      else if (paramInt1 == 1025)
      {
        a(paramInt2, paramString2);
      }
      j(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = this.c;
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
      str = String.format(this.f.getString(2131890199), new Object[] { this.ah.e });
    }
    switch (paramInt)
    {
    default: 
      if (paramInt > 100)
      {
        QQToast.makeText(this.f, str, 0).show(this.f.getTitleBarHeight());
        return;
      }
      break;
    case 104: 
      QQToast.makeText(this.f, str, 0).show(this.f.getTitleBarHeight());
      return;
    case 102: 
    case 103: 
      QQToast.makeText(this.f, str, 0).show(this.f.getTitleBarHeight());
      ReportController.b(this.d, "dc00899", "Grp_set", "", "Grp_data", "forbid_temp", 0, 0, paramString1, "", "", "");
    }
  }
  
  private void bz()
  {
    Object localObject = this.f.getIntent();
    if (localObject == null) {
      return;
    }
    String str = ((Intent)localObject).getStringExtra("gid");
    if (ChatActivityUtils.a(this.d.getCurrentAccountUin(), this.ah.b, str))
    {
      localObject = StructMsgFactory.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
      if (localObject != null)
      {
        ShareMsgHelper.a(this.d, this.ah.b, this.ah.a, (AbsStructMsg)localObject, null);
        if (((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.ah.b))
        {
          ReportController.b(this.d, "P_CliOper", "Pb_account_lifeservice", this.ah.b, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "1", "", "", "");
          return;
        }
        ReportController.b(this.d, "P_CliOper", "Pb_account_lifeservice", this.ah.b, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "", "1", "", "");
      }
    }
  }
  
  private void i(Intent paramIntent)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("From chatActivity : accost Sig--->");
      localStringBuilder.append(HexUtil.bytes2HexStr(arrayOfByte));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (arrayOfByte != null) {
      this.d.getMsgCache().g(this.ah.b, arrayOfByte);
    }
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
    {
      ChatActivityFacade.g(this.d, this.ah);
      return;
    }
    if ((((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.ah.b) == null) && (StringUtil.verifyUin(this.ah.b))) {
      ((CardHandler)this.d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.d.getCurrentAccountUin(), this.ah.b, (byte)1, 0);
    }
  }
  
  private void j(Intent paramIntent)
  {
    paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("From chatActivity : sameState Sig--->");
      localStringBuilder.append(HexUtil.bytes2HexStr(paramIntent));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramIntent != null) {
      this.d.getMsgCache().f(this.ah.b, paramIntent);
    }
  }
  
  private void k(Intent paramIntent)
  {
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
    {
      ChatActivityFacade.g(this.d, this.ah);
      return;
    }
    if ((((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.ah.b) == null) && (StringUtil.verifyUin(this.ah.b))) {
      ((CardHandler)this.d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.d.getCurrentAccountUin(), this.ah.b, (byte)1, 0);
    }
  }
  
  private void l(Intent paramIntent)
  {
    this.ah.d = paramIntent.getStringExtra("troop_code");
    if ((this.ah.d == null) || (this.ah.d.trim().length() == 0))
    {
      paramIntent = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
      this.ah.d = paramIntent.k(this.ah.c);
      if (this.ah.d == null)
      {
        paramIntent = (HotChatManager)this.d.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        this.ah.d = paramIntent.f(this.ah.c);
      }
    }
  }
  
  private void s(int paramInt)
  {
    if (paramInt != 16) {
      return;
    }
    ChatActivityFacade.d(this.d, this.ah);
  }
  
  private void t(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1602: 
      QQToast.makeText(this.f, this.f.getString(2131889042), 0).show(this.f.getTitleBarHeight());
      return;
    case 1601: 
      QQToast.makeText(this.f, this.f.getString(2131889043), 0).show(this.f.getTitleBarHeight());
      return;
    }
    QQToast.makeText(this.f, this.f.getString(2131889043), 0).show(this.f.getTitleBarHeight());
  }
  
  private void u(int paramInt)
  {
    if (paramInt != 40) {
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    Object localObject = (HotChatManager)this.d.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    localObject = this.f.getString(2131895522);
    QQToast.makeText(this.f, (CharSequence)localObject, 0).show(this.f.getTitleBarHeight());
  }
  
  private void v(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    String str = String.format(this.f.getString(2131888726), new Object[] { this.ah.e });
    QQToast.makeText(this.f, str, 0).show(this.f.getTitleBarHeight());
  }
  
  private void w(int paramInt)
  {
    if (paramInt != 55)
    {
      if ((paramInt != 211) && (paramInt != 1603))
      {
        QQToast.makeText(this.f, this.f.getString(2131918091), 0).show(this.f.getTitleBarHeight());
        return;
      }
      QQToast.makeText(this.f, this.f.getString(2131918090), 0).show(this.f.getTitleBarHeight());
    }
  }
  
  public void B()
  {
    if ((BusinessUtils.c(this.ah.b)) && (BusinessUtils.a(this.e))) {
      return;
    }
    Intent localIntent = new Intent(this.f, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.ah.b);
    localIntent.putExtra("uinname", this.ah.e);
    localIntent.putExtra("uintype", this.ah.a);
    if (this.ah.a == 1006)
    {
      boolean bool;
      if ((this.ah.g != null) && (!this.ah.g.equals(""))) {
        bool = false;
      } else {
        bool = true;
      }
      localIntent.putExtra("isShieldMsgSwitchUnClickable", bool);
    }
    if ((1000 == this.ah.a) || (1004 == this.ah.a)) {
      localIntent.putExtra("troop_uin", this.ah.c);
    }
    localIntent.putExtra("add_friend_source_id", this.ah.t);
    localIntent.putExtra("real_troop_uin", this.ah.d);
    Object localObject = a(this.e, this.ah.a, false, false);
    if (localObject != null)
    {
      localIntent.putExtra("param_wzry_data", (Serializable)localObject);
      localIntent.putExtra("uinname", ((KplRoleInfo.WZRYUIinfo)localObject).nick);
    }
    else if (KplHelper.a(this))
    {
      localObject = this.ah.b;
      String str = KplRoleInfo.WZRYUIinfo.buildNickName(this.ah.e, KplHelper.a(this.d, (String)localObject));
      localIntent.putExtra("param_wzry_data", KplRoleInfo.WZRYUIinfo.createInfo((String)localObject, str, KplHelper.a(this.d), 0, 0));
      localIntent.putExtra("uinname", str);
    }
    this.f.startActivityForResult(localIntent, 2000);
  }
  
  protected void E()
  {
    Object localObject;
    if ((this.ah.a != 1000) && (this.ah.a != 1020) && (this.ah.a != 1004))
    {
      if (this.ah.a == 1006)
      {
        localObject = ((IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.ah.b);
        if (localObject != null) {
          localObject = ((PhoneContact)localObject).name;
        } else if (this.ah.g != null) {
          localObject = ContactUtils.a(this.d, this.ah.g, this.ah.c, ContactUtils.c(this.ah.a), 3);
        } else {
          localObject = this.ah.b;
        }
      }
      else
      {
        String str = ContactUtils.a(this.d, this.ah.b, this.ah.c, ContactUtils.c(this.ah.a), 3);
        localObject = str;
        if (this.ah.a == 1005) {
          if (str != null)
          {
            localObject = str;
            if (!str.equals(this.ah.b)) {}
          }
          else
          {
            this.al.getFriendInfo(this.ah.b);
            localObject = str;
          }
        }
      }
    }
    else {
      localObject = ContactUtils.a(this.d, this.ah.b, this.ah.d, ContactUtils.c(this.ah.a), 3);
    }
    this.ah.e = ((String)localObject);
  }
  
  public void K()
  {
    if (this.A != null) {
      this.A.setOnClickListener(null);
    }
    if (KplHelper.a(this))
    {
      ((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).a = false;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "kpl global has been remove, because StrangerChatPie close");
      }
    }
    super.K();
  }
  
  public void S()
  {
    super.S();
    FriendsManager localFriendsManager = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (KplHelper.a(this))
    {
      localFriendsManager.a = true;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "open kpl session, mark global flag");
      }
    }
    else
    {
      localFriendsManager.a = false;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "not open kpl session, reset global flag");
      }
    }
  }
  
  public boolean V()
  {
    if ((this.bj) && (this.f.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.d, this.f, this.ah))) {
      return true;
    }
    return super.V();
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  protected void ao()
  {
    if ((this.ah.a == 1006) && (!this.al.isGetOnlineListRecently()) && (!this.al.shouldGetOnlineInfo())) {
      this.al.getOnlineInfo(this.ah.b, true);
    }
    if (this.ah.a == 10004)
    {
      if (TextUtils.isEmpty(this.bn)) {
        this.bn = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString("", "strangerchat_ext", "");
      } else {
        ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putString("", "strangerchat_ext", this.bn);
      }
      if (!TextUtils.isEmpty(this.bn))
      {
        MovieTicketTipsBar localMovieTicketTipsBar = new MovieTicketTipsBar(this.e);
        this.aX.a(localMovieTicketTipsBar, new Object[] { this.bn });
      }
    }
    super.ao();
  }
  
  protected void au()
  {
    super.au();
    this.d.addObserver(this.bl);
    this.d.addObserver(this.bo);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.bl);
    this.d.removeObserver(this.bo);
  }
  
  protected HelperProvider b()
  {
    return new StrangerHelperProvider(this.f);
  }
  
  protected String b(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    if ((1000 == this.ah.a) && (paramMessageRecord == null) && (paramList.size() == 0)) {
      paramList = ChatActivityUtils.a(this.e, this.d, this.ah.d);
    } else if (this.ah.a == 1025) {
      paramList = ChatActivityUtils.a(this.d, this.e, this.ah.b);
    } else if (this.ah.a == 10004) {
      paramList = this.e.getString(2131896560);
    } else if (this.ah.a == 10010) {
      paramList = this.e.getString(2131916725);
    } else {
      paramList = super.b(paramList, paramMessageRecord);
    }
    paramMessageRecord = ((ITempChatPluginManager)this.d.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(this.ah.a);
    if (paramMessageRecord != null) {
      paramList = paramMessageRecord.b(this.ah.b, TempChatSource.SOURCE_FROM_AIO);
    }
    return paramList;
  }
  
  public void bL()
  {
    if (this.bk)
    {
      this.bk = false;
      bz();
    }
    if (this.bi)
    {
      WpaThirdAppStructMsgUtil.a(this.d, this.f, this.ah, this.bi);
      this.bi = false;
    }
  }
  
  public void bM()
  {
    if (this.ah.a == 1006)
    {
      Intent localIntent = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.f, 2, this.ah.b, null, 3006, 12, this.ah.e, null, null, null, null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f, localIntent);
    }
  }
  
  protected AIOInput c()
  {
    return new AIOInputBuilder().a(this.i).a(new StrangerMessageSender(this.i)).a();
  }
  
  protected void c(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      if ((this.ah.a != 1000) && (this.ah.a != 1020) && (this.ah.a != 1004))
      {
        if (this.ah.a == 1006)
        {
          paramIntent = ((IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.ah.b);
          if (paramIntent != null) {
            paramIntent = paramIntent.name;
          } else if (this.ah.g != null) {
            paramIntent = ContactUtils.a(this.d, this.ah.g, this.ah.c, ContactUtils.c(this.ah.a), 3);
          } else {
            paramIntent = this.ah.b;
          }
        }
        else
        {
          str = ContactUtils.a(this.d, this.ah.b, this.ah.c, ContactUtils.c(this.ah.a), 3);
          if (str != null)
          {
            paramIntent = str;
            if (!str.equals(this.ah.b)) {}
          }
          else if ((this.ah.a != 1005) && (this.ah.a != 1025) && (this.ah.a != 10004))
          {
            paramIntent = str;
            if (this.ah.a != 10010) {}
          }
          else
          {
            this.al.getFriendInfo(this.ah.b);
            paramIntent = str;
          }
        }
      }
      else {
        paramIntent = ContactUtils.a(this.d, this.ah.b, this.ah.d, ContactUtils.c(this.ah.a), 3);
      }
    }
    this.ah.e = paramIntent;
    this.C.setText(this.ah.e);
    this.C.setOnClickListener(new StrangerChatPie.1(this));
  }
  
  protected AIOContext d()
  {
    return new StrangerContext();
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    if ((this.ah.a == 1004) && (QLog.isColorLevel())) {
      QLog.i("addFriendTag", 4, String.format(Locale.getDefault(), "BaseChatPie addFriend uin: %s troopuin: %s sourceId: %d", new Object[] { this.ah.b, this.ah.c, Integer.valueOf(this.ah.t) }));
    }
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new Scroller()).a(new ListUI(this.i)).a(new UnreadTask(this.i)).a(new StrangerMsgListRefresher(this.i)).a();
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    if ((this.ah.a != 1000) && (this.ah.a != 1020))
    {
      if (this.ah.a == 1004)
      {
        this.ah.d = this.ah.c;
        this.P = false;
      }
      else if (this.ah.a == 1006)
      {
        a();
      }
      else if (this.ah.a == 1003)
      {
        k(paramIntent);
      }
      else if (this.ah.a == 1009)
      {
        j(paramIntent);
      }
      else if ((this.ah.a != 1001) && (this.ah.a != 10002))
      {
        byte[] arrayOfByte;
        if (this.ah.a == 10004)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_movie_sig");
          if (arrayOfByte != null) {
            this.d.getMsgCache().i(this.ah.b, arrayOfByte);
          }
          this.bn = paramIntent.getStringExtra("strangerchat_ext");
        }
        else if (this.ah.a == 1010)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.d.getMsgCache().k(this.ah.b, arrayOfByte);
          }
        }
        else if (this.ah.a == 10008)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.d.getMsgCache().d(this.ah.b, this.d.getCurrentUin(), arrayOfByte);
          }
        }
        else if (this.ah.a == 10010)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.d.getMsgCache().o(this.ah.b, arrayOfByte);
          }
        }
        else if (this.ah.a == 10013)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).addKanDianChatSessionKey(this.ah.b, this.d.getCurrentUin(), arrayOfByte);
          }
        }
      }
      else
      {
        i(paramIntent);
      }
    }
    else {
      l(paramIntent);
    }
    this.bk = paramIntent.getBooleanExtra("fromSencondhandCommunity", false);
    this.bj = paramIntent.getBooleanExtra("from3rdApp", false);
    this.bm = paramIntent.getBooleanExtra("from_wpa_for_crm", false);
    this.bi = WpaThirdAppStructMsgUtil.a(this.d, this.ah, paramIntent);
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  protected void f(Intent paramIntent)
  {
    super.f(paramIntent);
    if ((paramIntent.hasExtra("key_sub_title_from")) && ((this.ah.a != 1025) || (!((StrangerQidianHelper)this.g.a(61)).a(true))))
    {
      paramIntent = paramIntent.getStringExtra("key_sub_title_from");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (this.I.getVisibility() == 8) {
          b(true);
        }
        this.I.setText(paramIntent);
        this.P = false;
      }
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if ((this.bj) && (this.f.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.d, this.f, this.ah)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    super.f(paramBoolean);
  }
  
  protected void h()
  {
    this.c = "StrangerChatPie";
  }
  
  public void l(int paramInt)
  {
    super.l(paramInt);
    ((TempMsgManager)this.d.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(this.ah, this);
  }
  
  protected boolean p()
  {
    return (this.aL) || (super.p());
  }
  
  protected void u()
  {
    if (this.ah.a == 1006)
    {
      b(true);
      this.I.setText(this.f.getResources().getString(2131916726));
      if (b) {
        this.I.setContentDescription(this.f.getResources().getString(2131916726));
      }
    }
    if (this.ah.a == 1004)
    {
      b(true);
      this.I.setText(this.f.getResources().getString(2131916727));
      if (b) {
        this.I.setContentDescription(this.f.getResources().getString(2131916727));
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (this.ah.b.equals(paramObservable.frienduin)) && ((this.ah.a == paramObservable.istroop) || ((UinTypeUtil.b(this.ah.a)) && (UinTypeUtil.b(paramObservable.istroop)))) && ((this.ah.a == 1001) || (this.ah.a == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.d.getMessageFacade().B();
        if ((paramObservable != null) && ((paramObservable.istroop == 1001) || (paramObservable.istroop == 10002)) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.f.getApplicationContext(), paramObservable.action);
        }
      }
    }
  }
  
  protected boolean x()
  {
    return (this.ah.a != 1006) && (this.ah.a != 1000) && (this.ah.a != 10004) && (this.ah.a != 1004) && (this.ah.a != 10008) && (this.ah.a != 10013);
  }
  
  protected void y()
  {
    super.y();
    if (this.ah.a == 1003) {
      this.W.setChildVisible(8, 8);
    }
  }
  
  protected void z()
  {
    this.A.setOnClickListener(new StrangerChatPie.2(this));
    if ((!ChatActivityUtils.b(this.d, this.ah)) && (!CrmUtils.a(this.d, this.ah.b, this.ah.a)) && (this.ah.a != 1))
    {
      if ((this.C.getText() != null) && (this.C.getText().length() < 6)) {
        this.A.setVisibility(4);
      } else {
        this.A.setVisibility(8);
      }
    }
    else if (AIOTopRightButtonConfig.a().b(this.d.getCurrentAccountUin()))
    {
      this.A.setVisibility(0);
      this.A.setContentDescription(this.f.getResources().getString(2131896548));
    }
    else
    {
      this.A.setVisibility(8);
    }
    if ((this.ah.a != 0) && (this.ah.a != 1025)) {
      this.A.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie
 * JD-Core Version:    0.7.0.1
 */