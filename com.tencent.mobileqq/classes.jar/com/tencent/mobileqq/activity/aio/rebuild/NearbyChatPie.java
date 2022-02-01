package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.tips.NearbyMarketGrayTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowReq;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class NearbyChatPie
  extends BaseChatPie
{
  boolean N = true;
  public boolean O = false;
  protected boolean P = false;
  boolean Q = false;
  boolean R = false;
  boolean S = false;
  protected boolean T = true;
  ProtoUtils.TroopProtocolObserver jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver = new NearbyChatPie.14(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new NearbyChatPie.11(this);
  protected MessageObserver a;
  ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new NearbyChatPie.12(this);
  NearbyRelevantObserver jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver = new NearbyChatPie.13(this);
  protected NearbyGiftPanelDialog a;
  protected TroopGiftPanelForNearby a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  String f;
  String g = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("from_where_to_aio");
  public String h;
  int k;
  int l = -1;
  
  public NearbyChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_k_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new NearbyChatPieObserver(this);
  }
  
  private void a()
  {
    if (a().getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", this.R);
      localIntent.putExtra("uin", a().getIntent().getStringExtra("tinyId"));
      a().setResult(-1, localIntent);
    }
  }
  
  private void a(Integer paramInteger, String paramString)
  {
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case 1: 
      ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(1));
      if (this.T)
      {
        paramInteger = "2";
        a(paramString, Integer.valueOf(paramInteger).intValue(), new NearbyChatPie.5(this));
        paramString = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) {
          break label171;
        }
        paramInteger = "0";
        label125:
        if (!paramString.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label177;
        }
      }
      label171:
      label177:
      for (paramString = "1";; paramString = "0")
      {
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "follow_aio", 0, 0, paramInteger, "0", paramString, "");
        return;
        paramInteger = "1";
        break;
        paramInteger = "1";
        break label125;
      }
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
    {
      paramInteger = "0";
      if (!this.T) {
        break label315;
      }
    }
    label315:
    for (paramString = "0";; paramString = "1")
    {
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "block_aio", 0, 0, paramInteger, "0", paramString, "");
      return;
      paramInteger = "1";
      break;
    }
  }
  
  private void a(String paramString, int paramInt, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    NowSummaryCard.NearbyUserFollowReq localNearbyUserFollowReq = new NowSummaryCard.NearbyUserFollowReq();
    localNearbyUserFollowReq.from.set(0);
    localNearbyUserFollowReq.id_type.set(0);
    localNearbyUserFollowReq.target_id.set(Long.valueOf(paramString).longValue());
    localNearbyUserFollowReq.operation.set(paramInt);
    ProtoUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramTroopProtocolObserver, localNearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
  }
  
  private void i(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramString));
    if (NearbyCardManager.a(paramString)) {}
    for (int i = 0;; i = 1)
    {
      ((MiniCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MINI_CARD_MANAGER)).a(localArrayList, i, new NearbyChatPie.7(this));
      return;
    }
  }
  
  public void C()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void J()
  {
    super.J();
  }
  
  public void N()
  {
    super.N();
  }
  
  public void S()
  {
    super.S();
    this.O = false;
  }
  
  public void T()
  {
    super.T();
  }
  
  public String a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
    {
      paramList = this.jdField_a_of_type_AndroidContentContext;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
      for (int i = 2131698546;; i = 2131694340) {
        return paramList.getString(i);
      }
    }
    return super.a(paramList, paramMessageRecord);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 2000) && (paramIntent != null)) {
      this.T = paramIntent.getBooleanExtra("follow_flag", false);
    }
    if ((paramInt1 == 12007) && (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.a(null);
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    super.a(paramIntent, paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = (InputMethodManager)a().getSystemService("input_method");
    Object localObject2 = a().getWindow().peekDecorView();
    if ((localObject2 != null) && (((View)localObject2).getWindowToken() != null)) {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(((View)localObject2).getWindowToken(), 0);
    }
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = a();
      NearbyChatPie.15 local15 = new NearbyChatPie.15(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby((QQAppInterface)localObject1, (Context)localObject2, local15, true, false, bool, this);
        this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog = new NearbyGiftPanelDialog(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.c, false, true);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002) {
        break label190;
      }
    }
    label190:
    for (paramInt = 8;; paramInt = 6)
    {
      ((NearbyGiftPanelDialog)localObject1).a(paramBoolean, true, paramInt);
      an();
      return;
      bool = false;
      break;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (UinTypeUtil.b(paramMessageRecord.istroop))));
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return paramBoolean;
  }
  
  public void aC()
  {
    if (this.P) {
      return;
    }
    super.aC();
  }
  
  public void aM()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a();
    }
  }
  
  public void ac()
  {
    super.ac();
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) {
        break label168;
      }
      i = 2131698546;
      localObject = ((Context)localObject).getString(i);
      b(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (jdField_a_of_type_Boolean) {
        this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().j(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null)) {
        break label175;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != -1) {
        NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
      }
      return;
      label168:
      i = 2131694340;
      break;
      label175:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().m(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null)) {
        i = 0;
      } else {
        i = -1;
      }
    }
  }
  
  public void ae()
  {
    super.ae();
    if (!this.v) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf("3").intValue(), this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver);
    }
  }
  
  public void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void ao()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {}
    for (String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();; str = null)
    {
      super.ao();
      if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() > 0) && (this.jdField_f_of_type_JavaLangString.equals(str))) {
        ThreadManager.post(new NearbyChatPie.9(this, str), 5, null, false);
      }
      this.jdField_f_of_type_JavaLangString = null;
      if ((this.g != null) && (this.g.equals("nearby_recommend_people")) && (this.N)) {
        ThreadManager.post(new NearbyChatPie.10(this), 1, null, false);
      }
      this.R = true;
      return;
    }
  }
  
  MqqHandler b()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new NearbyChatPie.3(this));
    if (QLog.isDevelopLevel()) {
      DatingUtil.a(this.jdField_b_of_type_JavaLangString, new Object[] { "updateSession_updateTitle", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    }
  }
  
  public void bf()
  {
    super.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "NearbyChatPie";
  }
  
  public boolean c()
  {
    ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    return (!this.T) && (!localShieldMsgManger.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!y());
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009)
    {
      paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "From chatActivity : sameState Sig--->" + HexUtil.bytes2HexStr(paramIntent));
      }
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
      }
    }
    for (;;)
    {
      this.r = this.P;
      if (-1 == this.l) {
        ThreadManager.post(new NearbyChatPie.2(this), 8, null, false);
      }
      StartupTracker.a("AIO_updateSession_business", null);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
      {
        this.l = paramIntent.getIntExtra("gender", -1);
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "From chatActivity : accost Sig--->" + HexUtil.bytes2HexStr(arrayOfByte));
        }
        if (arrayOfByte != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, arrayOfByte);
        }
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
          ChatActivityFacade.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        } else {
          ThreadManager.post(new NearbyChatPie.1(this), 5, null, false);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010)
      {
        this.l = paramIntent.getIntExtra("gender", -1);
        this.jdField_k_of_type_Int = paramIntent.getIntExtra("dating_from_id", 0);
        paramIntent = paramIntent.getByteArrayExtra("rich_date_sig");
        if (paramIntent != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().k(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
        }
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    a();
    super.e(paramBoolean);
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1010);
  }
  
  public boolean g()
  {
    a();
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a();
      super.g();
      return true;
    }
    return super.g();
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.handleMessage(paramMessage);
    }
    this.O = false;
    paramMessage = (String)paramMessage.obj;
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessage);
    return true;
  }
  
  public void k()
  {
    if (this.P) {
      return;
    }
    super.k();
    NearbyMarketGrayTips localNearbyMarketGrayTips = new NearbyMarketGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
    localNearbyMarketGrayTips.a(this.l);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localNearbyMarketGrayTips);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showAddFriendAndShield() ==== called.");
    }
    Object localObject2;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      localObject2 = new NearbyChatPie.4(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560069, null));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131362584);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131297598));
      localLayoutParams.addRule(3, 2131377159);
      if (!this.D) {
        localLayoutParams.topMargin = 0;
      }
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374169));
      TextView localTextView = this.jdField_k_of_type_AndroidWidgetTextView;
      if (this.T)
      {
        localObject1 = HardCodeUtil.a(2131707130);
        localTextView.setText((CharSequence)localObject1);
        this.jdField_k_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296474));
        this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_k_of_type_AndroidWidgetTextView.getText());
        this.jdField_k_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject2);
        this.jdField_k_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
        this.j = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374170));
        this.j.setText(HardCodeUtil.a(2131707132));
        this.j.setTag(Integer.valueOf(2));
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString.equals("")))) {
          break label538;
        }
        this.j.setEnabled(false);
        this.j.setClickable(false);
        label321:
        this.j.setGravity(17);
        this.j.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131296474));
        this.j.setOnClickListener((View.OnClickListener)localObject2);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {
          this.j.setVisibility(8);
        }
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131362584);
        this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = this.c.findViewById(2131374581);
      if (localObject1 != null)
      {
        localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297598) + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299166));
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) {
        break label557;
      }
    }
    label538:
    label557:
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_float", 0, 0, (String)localObject1, "", "", "");
      return;
      localObject1 = HardCodeUtil.a(2131707129);
      break;
      this.j.setEnabled(true);
      this.j.setClickable(true);
      break label321;
    }
  }
  
  public void m(int paramInt)
  {
    super.m(paramInt);
    ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  public void m(boolean paramBoolean)
  {
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((paramObservable.istroop == 0) && (!this.S))
      {
        this.S = true;
        a().runOnUiThread(new NearbyChatPie.8(this));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && ((this.jdField_k_of_type_Int == 2) || (this.jdField_k_of_type_Int == 3)) && (paramObservable.isSendFromLocal()) && (Utils.a(paramObservable.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        if (this.jdField_k_of_type_Int != 2) {
          break label328;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004946", "0X8004946", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_k_of_type_Int = 0;
      if ((!paramObservable.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (UinTypeUtil.b(paramObservable.istroop)))) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a();
        if ((paramObservable != null) && (paramObservable.istroop == 1001) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramObservable.action);
        }
      }
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
        n(false);
      }
      return;
      label328:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004945", "0X8004945", 0, 0, "", "", "", "");
    }
  }
  
  public void v()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001))
    {
      super.v();
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new NearbyChatPie.6(this));
    if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698535));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void z()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("add_friend_source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int);
    localIntent.putExtra("follow_flag", this.T);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie
 * JD-Core Version:    0.7.0.1
 */