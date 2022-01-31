package com.tencent.mobileqq.activity.aio.rebuild;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.friendship.FriendShipViewManager;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTips;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgFriendSet;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.jumplightalk.AIOJumpLightalkConfig;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.VipGifObserver;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.ReduFriendObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import vpp;
import vpq;
import vpr;
import vps;
import vpu;
import vpw;
import vpx;
import vpy;
import vpz;
import vqa;
import vqb;
import vqc;
import vqd;
import vqe;
import vqf;
import vqg;
import vqh;
import vqj;
import vqk;
import vql;

public class FriendChatPie
  extends BaseChatPie
{
  public boolean O;
  public boolean P = false;
  boolean Q = false;
  private boolean R;
  private boolean S;
  private boolean T;
  private boolean U = true;
  private boolean V;
  private boolean W;
  public BabyQAIOPanel a;
  FriendShipViewManager jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager;
  public FriendHotTipsBar a;
  public GamePartyTipsBar a;
  private GatherContactsTips jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips;
  BabyQObserver jdField_a_of_type_ComTencentMobileqqAppBabyQObserver = new vpu(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new vpw(this);
  private StrangerObserver jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new vpr(this);
  private AIOJumpLightalkConfig jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig;
  protected VipGifObserver a;
  private ReduFriendObserver jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver = new vpq(this);
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new vpy(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new vpx(this);
  private View.OnClickListener b;
  public QidianManager b;
  protected MessageObserver c;
  Runnable c;
  Runnable d;
  public String g;
  private long h = -1L;
  public View q;
  
  public FriendChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangRunnable = new vqe(this);
    this.jdField_d_of_type_JavaLangRunnable = new vqf(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new vqg(this);
    this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver = new vql(this);
    this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver = new vps(this);
    if (paramQQAppInterface.a(164)) {
      this.jdField_b_of_type_ComTencentQidianQidianManager = ((QidianManager)paramQQAppInterface.getManager(164));
    }
  }
  
  private void aX()
  {
    ThreadManager.post(new vqa(this), 5, null, false);
  }
  
  private void aY()
  {
    ThreadManager.post(new vqb(this), 5, null, false);
  }
  
  private void aZ()
  {
    if (this.W) {
      return;
    }
    ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.W = true;
  }
  
  private void b(long paramLong)
  {
    VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
    if ((localVipGiftDownloadInfo != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && (localVipGiftDownloadInfo.b.equalsIgnoreCase(a())) && (localVipGiftDownloadInfo.d == 2L) && (paramLong == localVipGiftDownloadInfo.a)) {
      localVipGiftManager.a(localVipGiftDownloadInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
  }
  
  private void k(Intent paramIntent)
  {
    this.W = false;
    String str = paramIntent.getStringExtra("uin");
    this.Q = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a(str, paramIntent);
  }
  
  private void v(int paramInt)
  {
    if (AppSetting.jdField_b_of_type_Boolean) {}
    switch (paramInt)
    {
    case 2130845786: 
    case 2130845789: 
    case 2130845790: 
    case 2130845791: 
    case 2130845792: 
    case 2130845793: 
    case 2130845794: 
    case 2130845796: 
    case 2130845798: 
    case 2130845800: 
    default: 
      return;
    case 2130845802: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 3));
      return;
    case 2130845788: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 4));
      return;
    case 2130845799: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 1));
      return;
    case 2130845785: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 2));
      return;
    case 2130845801: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 5));
      return;
    case 2130845787: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 6));
      return;
    case 2130845795: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 36));
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 37));
  }
  
  protected void C()
  {
    super.C();
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).c();
    }
  }
  
  protected void D()
  {
    super.D();
  }
  
  protected void E()
  {
    super.E();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager.c();
    }
  }
  
  protected void F()
  {
    super.F();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager.d();
    }
    if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      QIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a(), this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, this.jdField_a_of_type_ComTencentWidgetPatchedButton, this.jdField_d_of_type_AndroidViewViewGroup);
      TIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a(), this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, this.jdField_a_of_type_ComTencentWidgetPatchedButton, this.jdField_d_of_type_AndroidViewViewGroup);
    }
  }
  
  protected void V()
  {
    StartupTracker.a(null, "AIO_onShow_business");
    super.V();
    this.S = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.R = WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    StartupTracker.a("AIO_onShow_business", null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
    Object localObject;
    do
    {
      return;
      ThreadManager.post(new vqk(this), 8, null, false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localObject = GoldMsgChatHelper.a().a((List)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    } while (localObject == null);
    a((MessageRecord)localObject, 500L);
  }
  
  protected void W()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      if (this.U)
      {
        this.U = false;
        ThreadManager.post(this.jdField_d_of_type_JavaLangRunnable, 8, null, true);
      }
      super.W();
      if (((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        ChatActivityFacade.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendChatPie", 2, "friendchatpie onShow_otherThings, " + localNumberFormatException.toString());
        }
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ChatActivityFacade.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 29)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel = ((BabyQAIOPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130968625, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "openBabyQPanel:" + (System.currentTimeMillis() - l));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel;
    }
    return super.a(paramInt);
  }
  
  public AIOJumpLightalkConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig;
  }
  
  public QQRecorder.RecorderParam a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      boolean bool = super.p();
      return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
    }
    return new QQRecorder.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 13008) {
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("result");
        paramIntent = str;
        if (str == null) {
          paramIntent = "";
        }
        if (!NetworkUtil.d(BaseApplication.getContext())) {
          break label123;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
          break label99;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent, false);
        paramIntent = new QZoneDistributedAppCtrl.Control();
        paramIntent.jdField_a_of_type_Int = 5;
        QZoneDistributedAppCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a(paramIntent);
      }
    }
    label99:
    label123:
    while (paramInt1 != 13009)
    {
      String str;
      return;
      new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(2131435764, a(), 0, 1);
      return;
      new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(2131434595, a(), 0, 1);
      return;
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendChatPie", 2, "showAddFriendActivity-->uinType=" + paramInt1 + " peerUin=" + paramString1 + " name=" + paramString2 + " phoneNum=" + paramString3 + " srcId=" + paramInt2);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    long l1;
    if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      l1 = System.currentTimeMillis();
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)) {
        break label214;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(QIMUserManager.a().a(2130845743));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845773);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130846139);
      if (this.jdField_c_of_type_AndroidViewView == null) {
        break label186;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(QIMUserManager.a().b(2));
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("shinkencai", 2, "set title time:" + (l2 - l1));
      return;
      label186:
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(QIMUserManager.a().b(2));
      continue;
      label214:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(TIMUserManager.a().a(2130845743));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845773);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130846139);
        if (this.jdField_d_of_type_AndroidViewView != null)
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(TIMUserManager.a().b(2));
        }
        else
        {
          this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(TIMUserManager.a().b(2));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130845743);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845772, 2130845773);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130846138, 2130846139);
        if (this.jdField_a_of_type_AndroidViewViewStub != null) {
          this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
        }
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
        if (this.jdField_d_of_type_AndroidViewView != null) {
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
  
  public void a(GoldMsgChatHelper.GoldMsgFriendSet paramGoldMsgFriendSet)
  {
    if (paramGoldMsgFriendSet != null)
    {
      this.P = true;
      if ((TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_AndroidWidgetTextView.getText()))) {
        this.jdField_g_of_type_JavaLangString = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
      }
      paramGoldMsgFriendSet = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131432303);
      b(true);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramGoldMsgFriendSet);
      if (N) {
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramGoldMsgFriendSet);
      }
      a().removeMessages(84);
      a().sendEmptyMessageDelayed(84, 5000L);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    super.a(paramEmoticonInfo);
    if (this.R)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.R);
      this.R = false;
    }
    if (this.T)
    {
      this.T = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if (((Integer)paramObject).intValue() == 29)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806C", "0X800806C", 0, 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    int j = 0;
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    paramString1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString1, paramString2, (FriendsManager)localObject1);
    Object localObject2 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), (String)paramString1.get(0));
    paramString2 = (String)((List)localObject2).get(0);
    paramString1.remove(0);
    ((List)localObject2).remove(0);
    localObject1 = new UniteGrayTipParam(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString2, 0, -5020, 2097155, MessageCache.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    int i;
    Object localObject3;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject3 = new Bundle();
        String str = (String)((List)localObject2).get(i);
        if (!TextUtils.isEmpty(str))
        {
          ((Bundle)localObject3).putString("image_resource", str);
          int k = paramString2.lastIndexOf(str);
          if (k >= 0)
          {
            ((UniteGrayTipParam)localObject1).a(k, str.length() + k, (Bundle)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("reactive", 2, "addReactiveGrayTip grayStr=" + paramString2 + "iconPos=" + k + "icon=" + str + "grayStr=" + paramString2);
            }
          }
        }
        i += 1;
      }
    }
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      i = j;
      while (i < paramString1.size())
      {
        localObject2 = new Bundle();
        localObject3 = (String)paramString1.get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          ((Bundle)localObject2).putInt("key_action", 11);
          ((Bundle)localObject2).putString("key_action_DATA", (String)localObject3);
          j = paramString2.lastIndexOf((String)localObject3);
          if (j >= 0) {
            ((UniteGrayTipParam)localObject1).a(j, ((String)localObject3).length() + j, (Bundle)localObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("reactive", 2, "addReactiveGrayTip grayStr=" + paramString2 + "spanPos=" + j + "iconName=" + (String)localObject3);
          }
        }
        i += 1;
      }
    }
    localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject1);
    UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
  }
  
  public boolean a(String paramString, Boolean paramBoolean, int paramInt1, int paramInt2, boolean paramBoolean1, ExtensionInfo paramExtensionInfo, int paramInt3)
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt(paramString, 0);
    if ((i >= paramInt3) || ((paramInt1 & paramInt2) > 0) || (!paramBoolean1)) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("reactivetip", 2, "checkReactiveGraytip remindTimes=" + i + "isRemind=" + paramInt1 + "needRemind=" + paramBoolean1 + "isNeed=" + bool);
      }
      return bool;
      localEditor.putInt(paramString, i + 1);
      localEditor.commit();
      if (paramBoolean.booleanValue()) {
        paramExtensionInfo.isGrayTipMultiRemind |= paramInt2;
      } else {
        paramExtensionInfo.isGrayTipRemind |= paramInt2;
      }
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    String str = localIntent.getStringExtra("PREVIOUS_WINDOW");
    if ((str != null) && (str.equals(FriendProfileCardActivity.class.getName()))) {
      this.h = NetConnInfoCenter.getServerTime();
    }
    this.O = true;
    if (localIntent.getBooleanExtra("open_chat_from_avator", false))
    {
      str = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel()) {
        QLog.d("FriendChatPie", 2, "upload avator " + str);
      }
      if (str != null)
      {
        if (!ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localIntent)) {
          break label235;
        }
        QQToast.a(a(), 2, 2131435909, 0).b(a());
        if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          ThreadManager.executeOnSubThread(new vpp(this), true);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.Q = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
      if (this.Q) {
        k(localIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j = this.Q;
      return super.a(paramBoolean);
      label235:
      QQToast.a(a(), 1, 2131435908, 0).b(a());
    }
  }
  
  public int[] a(FriendsManager paramFriendsManager, ExtensionInfo paramExtensionInfo, String paramString)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = -1;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = -1;
    tmp11_7;
    int k = -1;
    int m = -1;
    if ((paramFriendsManager == null) || (paramExtensionInfo == null)) {
      return arrayOfInt;
    }
    if (!paramFriendsManager.b(paramString)) {
      return arrayOfInt;
    }
    boolean bool1 = paramFriendsManager.d();
    int n = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramExtensionInfo, bool1);
    int i1 = paramFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramExtensionInfo, bool1);
    long l1 = paramExtensionInfo.lastChatTime;
    long l2 = paramExtensionInfo.lastpraiseTime;
    long l3 = paramExtensionInfo.lastQzoneVisitTime;
    int i = HotReactiveHelper.b();
    boolean bool2 = HotReactiveHelper.a(i, l1 * 1000L);
    boolean bool3 = HotReactiveHelper.a(i, l2 * 1000L);
    boolean bool4 = HotReactiveHelper.a(i, l3 * 1000L);
    int i2 = paramFriendsManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramExtensionInfo, bool1);
    int i3 = paramFriendsManager.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramExtensionInfo, bool1);
    int j;
    if (n == 0) {
      if (i3 == 0) {
        if (i1 == 0)
        {
          i = m;
          j = k;
          if (i2 > 0)
          {
            if (i2 != 2) {
              break label319;
            }
            if (!bool3) {
              break label311;
            }
            i = 2130845789;
            j = 2;
          }
        }
      }
    }
    label311:
    label319:
    do
    {
      do
      {
        do
        {
          do
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendChatPie", 2, "getShowInteractiveType showType=" + j + "closeFriendType=" + n + "interactivetype=" + i1 + "linkType=" + i2);
            }
            v(i);
            arrayOfInt[0] = i;
            arrayOfInt[1] = j;
            return arrayOfInt;
            i = 2130845788;
            break;
            i = m;
            j = k;
          } while (i2 != 1);
          if (bool3) {}
          for (i = 2130845803;; i = 2130845802)
          {
            j = 1;
            break;
          }
          if (i1 == 2)
          {
            if (bool2) {}
            for (i = 2130845786;; i = 2130845785)
            {
              j = 4;
              break;
            }
          }
          i = m;
          j = k;
        } while (i1 != 1);
        if (bool2) {}
        for (i = 2130845800;; i = 2130845799)
        {
          j = 3;
          break;
        }
        if (i3 == 1)
        {
          if (bool4) {}
          for (i = 2130845796;; i = 2130845795)
          {
            j = 7;
            break;
          }
        }
        i = m;
        j = k;
      } while (i3 != 2);
      if (bool4) {}
      for (i = 2130845798;; i = 2130845797)
      {
        j = 8;
        break;
      }
      if (n == 1)
      {
        if (paramExtensionInfo.isQzoneLover) {}
        for (i = 2130845794;; i = 2130845801)
        {
          j = 5;
          break;
        }
      }
      i = m;
      j = k;
    } while (n != 2);
    if (paramExtensionInfo.isQzoneLover) {}
    for (i = 2130845793;; i = 2130845787)
    {
      j = 6;
      break;
    }
  }
  
  public void aF()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendChatPie", 2, "==refreshTitleReativeIcon==");
    }
    y();
  }
  
  protected void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBabyQObserver);
  }
  
  protected void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBabyQObserver);
  }
  
  public void ak()
  {
    super.ak();
    if (this.R)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.R);
      this.R = false;
    }
    if (this.T)
    {
      this.T = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    y();
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if ((this.jdField_b_of_type_ComTencentQidianQidianManager != null) && (this.jdField_b_of_type_ComTencentQidianQidianManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_b_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if ((this.jdField_b_of_type_ComTencentQidianQidianManager != null) && (this.jdField_b_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      CrmUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    ThreadManager.post(new vpz(this), 5, null, false);
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
  }
  
  protected void e(boolean paramBoolean)
  {
    if ((this.S) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendChatPie", 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    if (this.Q) {
      aZ();
    }
    super.e(paramBoolean);
  }
  
  protected boolean e()
  {
    if ((this.S) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    if (this.Q) {
      aZ();
    }
    return super.e();
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.a = 0L;
  }
  
  protected void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips = new GatherContactsTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = new LightalkBlueTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.handleMessage(paramMessage);
    case 70: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager = new FriendShipViewManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager.a == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager.a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager.b();
        return true;
      }
      break;
    case 84: 
      if (!this.I)
      {
        TextView localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
        if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {}
        for (paramMessage = "";; paramMessage = this.jdField_g_of_type_JavaLangString)
        {
          localTextView.setText(paramMessage);
          if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
            break;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setText("");
          b(false);
          return true;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
        return true;
      }
      break;
    }
    return true;
  }
  
  protected void i(Intent paramIntent)
  {
    super.i(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips.a();
    }
  }
  
  protected void j(int paramInt)
  {
    super.j(paramInt);
    if (BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164));
    }
    aY();
    aX();
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      BabyQHandler localBabyQHandler = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if ((localBabyQHandler != null) && (localBabyQHandler.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
        localBabyQHandler.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
    }
  }
  
  protected void n()
  {
    if ((this.jdField_b_of_type_ComTencentQidianQidianManager != null) && (this.jdField_b_of_type_ComTencentQidianQidianManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))) {
      this.jdField_a_of_type_Boolean = true;
    }
    y();
  }
  
  protected void p()
  {
    if (!Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new vqh(this));
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131433364));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    ThreadManager.post(new vqj(this), 5, null, false);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject != null) && ((paramObject instanceof MessageForPokeEmo)))
    {
      localObject = (MessageForPokeEmo)paramObject;
      if ((((MessageForPokeEmo)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!((MessageForPokeEmo)localObject).isread)) {
        ((MessageForPokeEmo)localObject).setIsNeedPlayed(true);
      }
    }
    if ((paramObject != null) && ((paramObject instanceof MessageForStructing)) && (!((MessageForStructing)paramObject).isread))
    {
      localObject = (MessageForStructing)paramObject;
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mResid)) || (!((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75)).a((MessageForStructing)localObject))) {}
    }
    if (((paramObject instanceof ChatMessage)) && (q()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!((MessageRecord)localObject).isSendFromLocal()) && (GoldMsgChatHelper.c((MessageRecord)localObject)) && (GoldMsgChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
        a((MessageRecord)localObject, 500L);
      }
    }
    super.update(paramObservable, paramObject);
    if ((paramObject != null) && ((paramObject instanceof MessageForText)))
    {
      paramObservable = (MessageForText)paramObject;
      paramObject = paramObservable.msg;
      if (paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in FriendChatPie.update()");
        }
        AioVipKeywordHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObject, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
      }
    }
    ChatActivityFacade.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
  }
  
  protected void y()
  {
    System.currentTimeMillis();
    Object localObject;
    if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f)) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494205));
          localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((localObject == null) || ((ContactUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) == 0) && (TextUtils.isEmpty(((Friends)localObject).strTermDesc)))) {
            break label238;
          }
          localObject = ContactUtils.b((Friends)localObject);
          this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(2.0F, BaseApplicationImpl.getContext().getResources()));
          this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(QIMUserManager.a().b(5), null, null, null);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 2, 0, "", "", "", "");
          this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          b(true);
        }
      }
    }
    label238:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494206));
                      break;
                    } while (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0);
                    b(false);
                  } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 5);
                  FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
                  return;
                  if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
                    break label479;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c) {
                    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494205));
                  }
                  for (;;)
                  {
                    localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    if ((localObject == null) || ((ContactUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) == 0) && (TextUtils.isEmpty(((Friends)localObject).strTermDesc)))) {
                      break;
                    }
                    localObject = ContactUtils.b((Friends)localObject);
                    this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                    this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(2.0F, BaseApplicationImpl.getContext().getResources()));
                    this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(TIMUserManager.a().b(5), null, null, null);
                    b(true);
                    return;
                    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494206));
                  }
                } while (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0);
                b(false);
                return;
                this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494205));
                this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
                this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(null);
                System.currentTimeMillis();
              } while ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_ComTencentQidianQidianManager != null) && (this.jdField_b_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
              localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
            } while (l());
            localObject = ((FriendsManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if ((localObject == null) || ((ContactUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) == 0) && ((TextUtils.isEmpty(((Friends)localObject).strTermDesc)) || (!((Friends)localObject).strTermDesc.contains("TIM"))))) {
              break label697;
            }
            localObject = ContactUtils.b((Friends)localObject);
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
              break label691;
            }
            b(true);
          } while (this.P);
          this.jdField_g_of_type_JavaLangString = ((String)localObject);
          this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        } while (!N);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        return;
        b(false);
        return;
      } while (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0);
      b(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 5);
    label479:
    FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    label691:
    label697:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
  }
  
  @TargetApi(16)
  public boolean y()
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    localObject = a((FriendsManager)localObject, ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    int i = localObject[0];
    int j = localObject[1];
    if (i != -1)
    {
      t(i);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(new vqd(this));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendChatPie", 2, "updateSession_updateInteractive showInteractive=" + bool);
      }
      return bool;
      t(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
    }
  }
  
  protected void z()
  {
    if (this.h > 0L) {
      ThreadManager.getSubThreadHandler().post(new vqc(this));
    }
    if (this.I) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendChatPie", 2, "hasDestory = true return");
      }
    }
    do
    {
      return;
      if (this.Q) {
        aZ();
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
        MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4022);
      }
      if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).b();
      }
      this.O = false;
      super.z();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a.setCallback(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a = null;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips.a()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips.b()))) {
        ThreadManager.executeOnSubThread(this.jdField_c_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager.e();
      }
      this.T = false;
      if ((this.jdField_b_of_type_ComTencentQidianQidianManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) || (this.jdField_b_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
        this.jdField_b_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      if ((this.jdField_b_of_type_ComTencentQidianQidianManager != null) && (this.jdField_b_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      }
    } while (this.jdField_d_of_type_AndroidWidgetImageView == null);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie
 * JD-Core Version:    0.7.0.1
 */