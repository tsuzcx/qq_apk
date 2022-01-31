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
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
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
import com.tencent.mobileqq.app.qzonelover.QzoneLoverService;
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
import vxx;
import vxy;
import vxz;
import vya;
import vyc;
import vye;
import vyf;
import vyg;
import vyh;
import vyi;
import vyj;
import vyk;
import vyl;
import vym;
import vyn;
import vyo;
import vyp;
import vyr;
import vys;
import vyt;

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
  private boolean X;
  private boolean Y;
  public BabyQAIOPanel a;
  FriendShipViewManager jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipViewManager;
  public FriendHotTipsBar a;
  public GamePartyTipsBar a;
  private GatherContactsTips jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips;
  BabyQObserver jdField_a_of_type_ComTencentMobileqqAppBabyQObserver = new vyc(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new vye(this);
  private StrangerObserver jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new vxz(this);
  private AIOJumpLightalkConfig jdField_a_of_type_ComTencentMobileqqJumplightalkAIOJumpLightalkConfig;
  protected VipGifObserver a;
  private ReduFriendObserver jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver = new vxy(this);
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new vyg(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new vyf(this);
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
    this.jdField_c_of_type_JavaLangRunnable = new vym(this);
    this.jdField_d_of_type_JavaLangRunnable = new vyn(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new vyo(this);
    this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver = new vyt(this);
    this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver = new vya(this);
    if (paramQQAppInterface.a(164)) {
      this.jdField_b_of_type_ComTencentQidianQidianManager = ((QidianManager)paramQQAppInterface.getManager(164));
    }
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    for (;;)
    {
      return false;
      int[] arrayOfInt = new int[20];
      int[] tmp12_11 = arrayOfInt;
      tmp12_11[0] = -1000;
      int[] tmp18_12 = tmp12_11;
      tmp18_12[1] = -1001;
      int[] tmp24_18 = tmp18_12;
      tmp24_18[2] = -2009;
      int[] tmp30_24 = tmp24_18;
      tmp30_24[3] = -2045;
      int[] tmp36_30 = tmp30_24;
      tmp36_30[4] = -2009;
      int[] tmp42_36 = tmp36_30;
      tmp42_36[5] = -2001;
      int[] tmp48_42 = tmp42_36;
      tmp48_42[6] = -2005;
      int[] tmp55_48 = tmp48_42;
      tmp55_48[7] = -2010;
      int[] tmp62_55 = tmp55_48;
      tmp62_55[8] = -2000;
      int[] tmp69_62 = tmp62_55;
      tmp69_62[9] = -2002;
      int[] tmp76_69 = tmp69_62;
      tmp76_69[10] = -2008;
      int[] tmp83_76 = tmp76_69;
      tmp83_76[11] = -2022;
      int[] tmp90_83 = tmp83_76;
      tmp90_83[12] = -30002;
      int[] tmp97_90 = tmp90_83;
      tmp97_90[13] = -2011;
      int[] tmp104_97 = tmp97_90;
      tmp104_97[14] = -2020;
      int[] tmp111_104 = tmp104_97;
      tmp111_104[15] = -2025;
      int[] tmp118_111 = tmp111_104;
      tmp118_111[16] = -2065;
      int[] tmp125_118 = tmp118_111;
      tmp125_118[17] = -2066;
      int[] tmp132_125 = tmp125_118;
      tmp132_125[18] = -3000;
      int[] tmp139_132 = tmp132_125;
      tmp139_132[19] = -1035;
      tmp139_132;
      int i = 0;
      while (i < arrayOfInt.length)
      {
        if (paramChatMessage.msgtype == arrayOfInt[i]) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void aX()
  {
    ThreadManager.post(new vyi(this), 5, null, false);
  }
  
  private void aY()
  {
    ThreadManager.post(new vyj(this), 5, null, false);
  }
  
  private void aZ()
  {
    if (this.X) {}
    for (;;)
    {
      return;
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      ExtensionInfo localExtensionInfo = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      if (localExtensionInfo != null)
      {
        int i = localFriendsManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localExtensionInfo, localFriendsManager.d());
        long l = localExtensionInfo.loverLastChatTime;
        boolean bool = HotReactiveHelper.a(HotReactiveHelper.b(), l * 1000L, localExtensionInfo.loverTransFlag);
        if ((i != 0) && (bool)) {}
        for (i = 1; i != 0; i = 0)
        {
          b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
          return;
        }
      }
    }
  }
  
  private void b(long paramLong)
  {
    VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
    if ((localVipGiftDownloadInfo != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && (localVipGiftDownloadInfo.b.equalsIgnoreCase(a())) && (localVipGiftDownloadInfo.d == 2L) && (paramLong == localVipGiftDownloadInfo.a)) {
      localVipGiftManager.a(localVipGiftDownloadInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
  }
  
  private void b(List paramList)
  {
    if ((QzoneLoverService.a().a()) && (a(paramList)))
    {
      this.X = true;
      QzoneLoverService.a().b();
      if (QLog.isColorLevel()) {
        QLog.i("FriendChatPie", 2, "checkLightingQzoneLover enter!!!!!!!!");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("FriendChatPie", 2, "checkLightingQzoneLover not enter!!!!!!!!");
  }
  
  private void ba()
  {
    if (this.Y) {
      return;
    }
    ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.Y = true;
  }
  
  private void k(Intent paramIntent)
  {
    this.Y = false;
    String str = paramIntent.getStringExtra("uin");
    this.Q = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a(str, paramIntent);
  }
  
  private void v(int paramInt)
  {
    if (AppSetting.jdField_b_of_type_Boolean) {}
    switch (paramInt)
    {
    case 2130845994: 
    case 2130845997: 
    case 2130845998: 
    case 2130845999: 
    case 2130846000: 
    case 2130846002: 
    case 2130846004: 
    case 2130846006: 
    case 2130846008: 
    case 2130846010: 
    default: 
      return;
    case 2130846012: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 3));
      return;
    case 2130845996: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 4));
      return;
    case 2130846009: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 1));
      return;
    case 2130845993: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 2));
      return;
    case 2130846011: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 5));
      return;
    case 2130845995: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 6));
      return;
    case 2130846003: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 59));
      return;
    case 2130846001: 
      this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 60));
      return;
    case 2130846005: 
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
      ThreadManager.post(new vys(this), 8, null, false);
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
      new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(2131435797, a(), 0, 1);
      return;
      new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(2131434628, a(), 0, 1);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(QIMUserManager.a().a(2130845951));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845981);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130846349);
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(TIMUserManager.a().a(2130845951));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845981);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130846349);
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130845951);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845980, 2130845981);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130846348, 2130846349);
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
      paramGoldMsgFriendSet = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131432331);
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
  
  public boolean a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    long l1 = MessageCache.a();
    Time localTime1 = new Time();
    localTime1.set(1000L * l1);
    Time localTime2 = new Time();
    boolean bool1 = false;
    boolean bool2 = false;
    int i = paramList.size() - 1;
    for (;;)
    {
      boolean bool3 = bool2;
      boolean bool4 = bool1;
      if (i >= 0) {}
      try
      {
        localChatMessage = (ChatMessage)paramList.get(i);
        if (localChatMessage == null)
        {
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          break label428;
        }
        long l2 = Math.abs(localChatMessage.time - l1);
        if (l2 <= 86400L) {
          break label206;
        }
        bool4 = bool1;
        bool3 = bool2;
      }
      catch (Throwable paramList)
      {
        for (;;)
        {
          ChatMessage localChatMessage;
          bool4 = false;
          bool3 = false;
          QLog.e("FriendChatPie", 1, "hasInteractiveToday error: " + paramList.getMessage());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendChatPie", 2, "hasInteractiveToday selfSend:" + bool4 + " friendSend: " + bool3);
      }
      if ((bool4) && (bool3))
      {
        return true;
        label206:
        if (!a(localChatMessage))
        {
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          break label428;
        }
        if ((TextUtils.equals(localChatMessage.senderuin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.equals(localChatMessage.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
        {
          localTime2.set(localChatMessage.time * 1000L);
          if ((localTime1.year == localTime2.year) && (localTime1.yearDay == localTime2.yearDay))
          {
            bool3 = TextUtils.equals(localChatMessage.senderuin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if (bool3)
            {
              bool3 = true;
              bool4 = bool1;
            }
            for (;;)
            {
              bool1 = bool3;
              bool2 = bool4;
              if (!bool4) {
                break label428;
              }
              bool1 = bool3;
              bool2 = bool4;
              if (!bool3) {
                break label428;
              }
              break;
              bool4 = true;
              bool3 = bool2;
            }
          }
        }
      }
      else
      {
        return false;
      }
      bool3 = bool2;
      bool2 = bool1;
      bool1 = bool3;
      label428:
      i -= 1;
      bool3 = bool2;
      bool2 = bool1;
      bool1 = bool3;
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
        QQToast.a(a(), 2, 2131435944, 0).b(a());
        if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          ThreadManager.executeOnSubThread(new vxx(this), true);
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
      QQToast.a(a(), 1, 2131435943, 0).b(a());
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
    int i3 = paramFriendsManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramExtensionInfo, bool1);
    long l1 = paramExtensionInfo.lastChatTime;
    long l2 = paramExtensionInfo.loverLastChatTime;
    long l3 = paramExtensionInfo.lastpraiseTime;
    long l4 = paramExtensionInfo.lastQzoneVisitTime;
    int i = HotReactiveHelper.b();
    boolean bool2 = HotReactiveHelper.a(i, l1 * 1000L);
    boolean bool3 = HotReactiveHelper.a(i, l2 * 1000L, paramExtensionInfo.loverTransFlag);
    boolean bool4 = HotReactiveHelper.a(i, l3 * 1000L);
    boolean bool5 = HotReactiveHelper.a(i, l4 * 1000L);
    int i2 = paramFriendsManager.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramExtensionInfo, bool1);
    int i4 = paramFriendsManager.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramExtensionInfo, bool1);
    int j;
    if (n == 0) {
      if (i4 == 0) {
        if (i1 == 0)
        {
          i = m;
          j = k;
          if (i2 > 0)
          {
            if (i2 != 2) {
              break label378;
            }
            if (bool4)
            {
              i = 2130845997;
              j = 2;
            }
          }
          else
          {
            label262:
            if (i3 != 2) {
              break label605;
            }
            if (!bool3) {
              break label597;
            }
            i = 2130846002;
            j = 10;
          }
        }
      }
    }
    label378:
    while (i3 != 1) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendChatPie", 2, "getShowInteractiveType showType=" + j + "closeFriendType=" + n + "interactivetype=" + i1 + "linkType=" + i2);
        }
        v(i);
        arrayOfInt[0] = i;
        arrayOfInt[1] = j;
        return arrayOfInt;
        i = 2130845996;
        break;
        i = m;
        j = k;
        if (i2 != 1) {
          break label262;
        }
        if (bool4) {}
        for (i = 2130846013;; i = 2130846012)
        {
          j = 1;
          break;
        }
        if (i1 == 2)
        {
          if (bool2) {}
          for (i = 2130845994;; i = 2130845993)
          {
            j = 4;
            break;
          }
        }
        i = m;
        j = k;
        if (i1 != 1) {
          break label262;
        }
        if (bool2) {}
        for (i = 2130846010;; i = 2130846009)
        {
          j = 3;
          break;
        }
        if (i4 == 1)
        {
          if (bool5) {}
          for (i = 2130846006;; i = 2130846005)
          {
            j = 7;
            break;
          }
        }
        i = m;
        j = k;
        if (i4 != 2) {
          break label262;
        }
        if (bool5) {}
        for (i = 2130846008;; i = 2130846007)
        {
          j = 8;
          break;
        }
        if (n == 1)
        {
          i = 2130846011;
          j = 5;
          break label262;
        }
        i = m;
        j = k;
        if (n != 2) {
          break label262;
        }
        i = 2130845995;
        j = 6;
        break label262;
        i = 2130846001;
      }
    }
    label597:
    label605:
    if (bool3) {}
    for (i = 2130846004;; i = 2130846003)
    {
      j = 9;
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
    ThreadManager.post(new vyh(this), 5, null, false);
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.X = false;
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
      ba();
    }
    super.e(paramBoolean);
  }
  
  protected boolean e()
  {
    if ((this.S) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    if (this.Q) {
      ba();
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
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new vyp(this));
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131433395));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    ThreadManager.post(new vyr(this), 5, null, false);
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
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if ((!((MessageRecord)localObject).isSendFromLocal()) && (GoldMsgChatHelper.c((MessageRecord)localObject)) && (GoldMsgChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
          a((MessageRecord)localObject, 500L);
        }
        if (this.W) {
          aZ();
        }
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
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494218));
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
                      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494219));
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
                    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494218));
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
                    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494219));
                  }
                } while (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0);
                b(false);
                return;
                this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494218));
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
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(new vyl(this));
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
      ThreadManager.getSubThreadHandler().post(new vyk(this));
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
        ba();
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
      ((QQStoryFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).a();
    } while (this.jdField_d_of_type_AndroidWidgetImageView == null);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie
 * JD-Core Version:    0.7.0.1
 */