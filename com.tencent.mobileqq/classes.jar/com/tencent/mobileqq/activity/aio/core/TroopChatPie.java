package com.tencent.mobileqq.activity.aio.core;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.Editable;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo_tips;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.biz.troopconfig.TroopConfigForAllUser;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOTipsController.AIOTipsListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.confess.ConfessPanel;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.TroopMsgLoader;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.core.tips.TroopTipsController;
import com.tencent.mobileqq.activity.aio.coreui.input.AIOInputState;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.helper.AIOAtHelper;
import com.tencent.mobileqq.activity.aio.helper.ChatPieTipsBarHelper;
import com.tencent.mobileqq.activity.aio.helper.ClockInEntryHelper;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopAskAnonymouslyHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.TroopTipsHelper;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams.Builder;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopMessageSender;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredTipsBar;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.UpgradeBigTroopTipsBar;
import com.tencent.mobileqq.activity.aio.troop.TroopMsgSameFold;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TogetherEntryBean;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.troop.api.handler.ITroopBatchInfohandler;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.observer.GroupAppsObserver;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingHandler;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.GetOnlineMemberTipsRunnable;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troop.utils.TroopMsgData;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.open.agent.TroopAbilityUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.ilive.group.IliveGroupTipsBarHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

public class TroopChatPie
  extends BaseTroopChatPie
{
  boolean H = false;
  boolean I;
  boolean J;
  boolean K = false;
  boolean L = false;
  protected boolean M = false;
  boolean N = false;
  boolean O = true;
  boolean P = false;
  boolean Q = false;
  boolean R = false;
  public boolean S = false;
  private boolean T = false;
  private boolean U;
  private boolean V = false;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler;
  public LinearLayout a;
  public ScrollView a;
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  AnonymousChatHelper.AnonymousStatusListener jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener;
  public QQAnonymousDialog a;
  public TroopNewGuidePopWindow a;
  AIOTipsController.AIOTipsListener jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController$AIOTipsListener = new TroopChatPie.30(this);
  protected ConfessPanel a;
  private TroopMsgObserver jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopMsgObserver = new TroopMsgObserver(this);
  public BigTroopExpiredTipsBar a;
  UpgradeBigTroopTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopChatPie.17(this);
  SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new TroopChatPie.9(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new TroopChatPie.19(this);
  TeamWorkObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver = new TroopChatPie.29(this);
  TroopModifyObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver = new TroopChatPie.18(this);
  private GroupAppsObserver jdField_a_of_type_ComTencentMobileqqTroopObserverGroupAppsObserver;
  private final RoamSettingObserver jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver = new TroopChatPie.8(this);
  TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable;
  TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  protected TroopUsingTimeReport a;
  protected TroopOnlineMemberBar a;
  protected QQCustomDialog a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  protected List<TroopChatPie.OnListViewScrollStateListener> a;
  private Map<Long, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  public volatile long b;
  Handler jdField_b_of_type_AndroidOsHandler = new TroopChatPie.10(this, Looper.getMainLooper());
  private ViewTreeObserver.OnGlobalLayoutListener jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  Runnable jdField_b_of_type_JavaLangRunnable = new TroopChatPie.1(this);
  private Set<Long> jdField_b_of_type_JavaUtilSet = new HashSet();
  private long jdField_c_of_type_Long;
  Runnable jdField_c_of_type_JavaLangRunnable = new GetOnlineMemberTipsRunnable(this);
  private Set<Long> jdField_c_of_type_JavaUtilSet = new HashSet();
  private long jdField_d_of_type_Long;
  Runnable jdField_d_of_type_JavaLangRunnable = new TroopChatPie.26(this);
  String jdField_d_of_type_JavaLangString;
  String e;
  protected int g;
  View g;
  public int h;
  View h;
  protected int i;
  View i;
  int jdField_j_of_type_Int = 0;
  View jdField_j_of_type_AndroidViewView;
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = null;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(5);
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    Object localObject;
    if (paramInt != 3)
    {
      if (paramInt != 102) {
        if (paramInt != 6001)
        {
          if (paramInt != 12005)
          {
            if (paramInt != 13001)
            {
              if (paramInt != 13010)
              {
                if (paramInt != 15001) {
                  return;
                }
                localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel;
                if (localObject != null) {
                  ((ConfessPanel)localObject).a(paramInt, paramIntent);
                }
              }
              else
              {
                paramIntent = paramIntent.getStringExtra("result");
                localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                if ((!android.text.TextUtils.isEmpty(paramIntent)) && (localObject != null) && (!paramIntent.equals(((TroopInfo)localObject).troopname)))
                {
                  ((ITroopModifyHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MODIFY_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent, false);
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
                  ((Intent)localObject).putExtra("uinname", paramIntent);
                  b((Intent)localObject);
                }
              }
            }
            else
            {
              Q();
              paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
              if (paramInt > 0)
              {
                paramIntent = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
                int k = paramInt - 1;
                int m = paramIntent.charAt(k);
                if ((m == 36) || (m == 65509) || (m == 165) || (m == 65284))
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().f();
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().delete(k, paramInt));
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().e();
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(k);
                }
              }
            }
          }
          else {
            TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
        else {
          h(paramIntent);
        }
      }
    }
    else
    {
      localObject = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), null);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
    }
  }
  
  private void a(TroopManager paramTroopManager, TroopInfo paramTroopInfo)
  {
    if ((!this.R) && (paramTroopManager.a.jdField_a_of_type_Boolean) && (paramTroopInfo != null) && (paramTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      int k = paramTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((k < 3) && (paramTroopInfo.wMemberMax < 2000) && (paramTroopInfo.wMemberNum >= 500))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar = new UpgradeBigTroopTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar, new Object[0]))
        {
          this.R = true;
          paramTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, k + 1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
    }
  }
  
  private void a(IliveGroupTipsBarHelper paramIliveGroupTipsBarHelper, boolean paramBoolean)
  {
    l(6);
    a(true);
    boolean bool = paramIliveGroupTipsBarHelper.a();
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramIliveGroupTipsBarHelper.a(bool));
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
    n(bool);
    int k = AIOUtils.b(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
    BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, k, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
    if (QLog.isColorLevel())
    {
      paramIliveGroupTipsBarHelper = new StringBuilder();
      paramIliveGroupTipsBarHelper.append("onSubTitleChanged. isIliveTime=");
      paramIliveGroupTipsBarHelper.append(paramBoolean);
      paramIliveGroupTipsBarHelper.append(",isTipsShow=");
      paramIliveGroupTipsBarHelper.append(bool);
      QLog.d("IliveGroupTipsBarHelper", 2, paramIliveGroupTipsBarHelper.toString());
    }
  }
  
  private boolean a(TroopMsgData paramTroopMsgData)
  {
    long l;
    if (paramTroopMsgData.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(paramTroopMsgData.jdField_b_of_type_Long));
      this.jdField_b_of_type_JavaUtilSet.remove(Long.valueOf(paramTroopMsgData.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramTroopMsgData.jdField_a_of_type_Long));
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramTroopMsgData.jdField_b_of_type_Long));
      l = paramTroopMsgData.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().d(l);
      e(131089);
      return true;
    }
    if (paramTroopMsgData.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramTroopMsgData.jdField_b_of_type_Long));
      this.jdField_b_of_type_JavaUtilSet.add(Long.valueOf(paramTroopMsgData.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramTroopMsgData.jdField_a_of_type_Long), Long.valueOf(paramTroopMsgData.jdField_b_of_type_Long));
      this.jdField_c_of_type_JavaUtilSet.remove(Long.valueOf(paramTroopMsgData.jdField_b_of_type_Long));
      l = paramTroopMsgData.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().d(l);
      e(131089);
      return true;
    }
    return false;
  }
  
  private boolean a(List<ChatMessage> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return (paramBoolean1) && (!this.z) && (!paramBoolean2) && (paramInt > 1) && (paramList.size() >= paramInt);
  }
  
  private long[] a(Set<Long> paramSet)
  {
    int k = ListUtils.a(paramSet);
    if (k > 0)
    {
      long[] arrayOfLong = new long[k];
      k = 0;
      Iterator localIterator = paramSet.iterator();
      for (;;)
      {
        paramSet = arrayOfLong;
        if (!localIterator.hasNext()) {
          break;
        }
        arrayOfLong[k] = ((Long)localIterator.next()).longValue();
        k += 1;
      }
    }
    paramSet = null;
    return paramSet;
  }
  
  private void aH()
  {
    ((StoryManager)SuperManager.a(5)).c();
    ((UserManager)SuperManager.a(2)).d();
    ((TroopStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_STORY_MANAGER)).a();
  }
  
  private void aI()
  {
    TroopBindPublicAccountMgr localTroopBindPublicAccountMgr = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
    localTroopBindPublicAccountMgr.e("");
    if (localTroopBindPublicAccountMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      localTroopBindPublicAccountMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void aJ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b(false);
    }
  }
  
  private void aK()
  {
    TroopOnlineMemberBar localTroopOnlineMemberBar = this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar;
    if (localTroopOnlineMemberBar != null)
    {
      localTroopOnlineMemberBar.a();
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar = null;
    }
  }
  
  private void aL()
  {
    TroopNewGuidePopWindow localTroopNewGuidePopWindow = this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow;
    if (localTroopNewGuidePopWindow != null)
    {
      localTroopNewGuidePopWindow.dismiss();
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = null;
    }
  }
  
  private void aM()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
    if (localObject != null)
    {
      ((FloatView)localObject).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView = null;
    }
  }
  
  private void aN()
  {
    QQAnonymousDialog localQQAnonymousDialog = this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog;
    if (localQQAnonymousDialog != null)
    {
      localQQAnonymousDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = null;
    }
    AnonymousChatHelper.a().b();
    if (this.F) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167114), true);
    }
  }
  
  private void aO()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        String str = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDestroy mConfessReceiver unregisterReceiver, e:");
        localStringBuilder.append(localException.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  private void aP()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null))
    {
      if (Build.VERSION.SDK_INT < 16) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      } else {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
    }
  }
  
  private void aQ()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
      } else {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
      TroopConfessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
  }
  
  private void aR()
  {
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      int k;
      if (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        k = 0;
      } else if (((TroopInfo)localObject).isAdmin()) {
        k = 1;
      } else {
        k = 2;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(k);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, str, localStringBuilder.toString(), "", "");
    }
  }
  
  private void aS()
  {
    if ((TroopConfessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true)) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new TroopChatPie.3(this);
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      label66:
      break label66;
    }
    QLog.e(this.jdField_b_of_type_JavaLangString, 1, "register mConfessReceiver receiver exception.");
  }
  
  private void aT()
  {
    int k = this.jdField_i_of_type_Int;
    Object localObject;
    if (k == 2)
    {
      localObject = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844023);
      ((AnimationDrawable)localObject).setOneShot(true);
      ((AnimationDrawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      ((AnimationDrawable)localObject).start();
      this.T = true;
      return;
    }
    if (k == 3)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844024);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    if (k == 4)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844024);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      boolean bool = ((TogetherControlHelper)a(43)).d();
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (bool)
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (k == 5)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844024);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(3, new Object[] { Integer.valueOf(this.jdField_i_of_type_Int) });
  }
  
  private void aU()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719632)).setMessage(2131697560);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131697558, new TroopChatPie.14(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton("", null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void aV()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719632)).setMessage(2131697561);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691235), new TroopChatPie.15(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131715053), new TroopChatPie.16(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButtonContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691235));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButtonContentDescription(HardCodeUtil.a(2131715051));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void aW()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopObserverGroupAppsObserver = new TroopChatPie.21(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverGroupAppsObserver);
  }
  
  private void aX()
  {
    if (!ChatPieTipsBarHelper.a(this)) {
      l(1);
    }
    this.k.setVisibility(8);
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()))
    {
      ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      a(-16777216, false);
    }
    else
    {
      a(-16777216, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131377646).setVisibility(8);
    AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130843804);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843824);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
    }
    else if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130851067);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130837943);
    }
    if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      this.jdField_a_of_type_JavaLangCharSequence = this.jdField_f_of_type_AndroidWidgetTextView.getText();
    }
    aD();
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
    this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    Object localObject = this.jdField_f_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131690009));
    localStringBuilder.append(AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
    ((TextView)localObject).setText(localStringBuilder.toString());
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
    AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
    a(true);
    localObject = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
    if (localObject != null) {
      ((PlusPanel)localObject).a(true);
    }
    localObject = (AIOEmoticonUIHelper)a(105);
    if (localObject != null) {
      ((AIOEmoticonUIHelper)localObject).b(true);
    }
    this.jdField_h_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener = new TroopChatPie.22(this);
    AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(2131696050);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
    {
      AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130843804);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
      }
    }
    ((TogetherControlHelper)a(43)).f();
    ((ClockInEntryHelper)a(85)).a(false);
  }
  
  private void aY()
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846361));
    } else {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167114), true);
    }
    SimpleUIUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.mSystemBarComp, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
  }
  
  private void aZ()
  {
    if ((BusinessUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (BusinessUtils.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopManager != null) && (localTroopManager.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString))) {
      return;
    }
    TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent.getExtras(), 1, 2000);
  }
  
  private void b(Object paramObject)
  {
    if ((paramObject instanceof ChatMessage))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramObject;
      this.jdField_b_of_type_Long = localMessageRecord.shmsgseq;
      if (!localMessageRecord.isSendFromLocal())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == localMessageRecord.istroop) || ((UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (UinTypeUtil.b(localMessageRecord.istroop)))) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) && ((paramObject instanceof MessageForTroopEffectPic))) {
          AIOAnimationControlManager.a(this, false);
        }
      }
      else if ((((ITroopBatchAddFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().b("highFreqInteract")) && (!this.J))
      {
        this.J = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable = new TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(false);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable);
      }
      paramObject = (TroopAddFriendTipsHelper)a(28);
      if (paramObject != null) {
        paramObject.a(localMessageRecord);
      }
      paramObject = (QQGamePubAIOHelper)a(90);
      if (paramObject != null) {
        paramObject.a(localMessageRecord);
      }
    }
  }
  
  private void ba()
  {
    if (this.V) {
      return;
    }
    ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.V = true;
  }
  
  private void bb()
  {
    ThreadManager.post(new TroopChatPie.27(this), 8, null, true);
  }
  
  private void bc()
  {
    TroopChatPie.28 local28 = new TroopChatPie.28(this);
    ThreadManager.getSubThreadHandler().post(local28);
  }
  
  private void bd()
  {
    boolean bool1 = this.N;
    boolean bool4 = true;
    boolean bool2;
    if ((!bool1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      bool2 = x();
    } else {
      bool2 = false;
    }
    bool1 = bool2;
    if (!bool2)
    {
      localObject = this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow;
      if ((localObject != null) && (((TroopNewGuidePopWindow)localObject).isShowing())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    Object localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if (localObject != null) {
      bool2 = ((AIOAnimationControlManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } else {
      bool2 = false;
    }
    if ((localObject != null) && (bool2) && (bool1)) {
      ((AIOAnimationControlManager)localObject).b = false;
    }
    if ((!bool1) && (bool2))
    {
      AIOAnimationControlManager.jdField_a_of_type_Boolean = true;
      AIOAnimationControlManager.a(this, true);
    }
    localObject = TroopListenTogetherPanel.a(this);
    if (localObject != null)
    {
      boolean bool3 = bool4;
      if (!bool1) {
        if (bool2) {
          bool3 = bool4;
        } else {
          bool3 = false;
        }
      }
      ((TroopListenTogetherPanel)localObject).a(bool3);
    }
  }
  
  private void be()
  {
    this.U = false;
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilSet.clear();
    this.jdField_d_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void f(String paramString)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_e_of_type_JavaLangString = paramString;
    ThreadManager.getSubThreadHandler().post(this.jdField_d_of_type_JavaLangRunnable);
  }
  
  private void h(Intent paramIntent)
  {
    String str1 = paramIntent.getExtras().getString("troop_uin");
    if ((!android.text.TextUtils.isEmpty(str1)) && (!str1.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    String str2 = paramIntent.getExtras().getString("member_uin");
    Object localObject = paramIntent.getExtras().getString("member_display_name");
    if ((paramIntent.getExtras().getBoolean("isApollo")) && (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo != null))
    {
      str1 = "0";
      if ("0".equals(str2)) {
        return;
      }
      paramIntent = null;
      if (!u()) {
        paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2);
      }
      if (android.text.TextUtils.isEmpty(paramIntent)) {
        paramIntent = (Intent)localObject;
      }
      localObject = new StringBuilder("@");
      ((StringBuilder)localObject).append(paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.peerUin = str2;
      this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.atNickName = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      a(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo);
      int k;
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.inputText))
      {
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mTextType == 0)
          {
            k = 6;
            break label343;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mTextType == 1)
          {
            k = 7;
            break label343;
          }
        }
        k = 2;
      }
      else if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText))
      {
        k = 3;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mTextType == 0)
      {
        k = 4;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mTextType == 1)
      {
        k = 5;
      }
      else
      {
        k = 0;
      }
      label343:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int m = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramIntent = new StringBuilder();
      paramIntent.append("");
      paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.actionId);
      String str3 = paramIntent.toString();
      paramIntent = new StringBuilder();
      paramIntent.append("655_");
      paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mPackageId);
      String str4 = paramIntent.toString();
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText)) {
        paramIntent = str1;
      } else {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText;
      }
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str2, k, m, new String[] { str3, str4, paramIntent, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
    a(str2, (String)localObject, true, 4);
  }
  
  private void i(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false))) {
      a().getIntent().putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    }
  }
  
  private void j(Intent paramIntent)
  {
    this.V = false;
    String str = paramIntent.getStringExtra("uin");
    this.K = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b(str, paramIntent);
  }
  
  private void o(int paramInt)
  {
    if (paramInt != 6001)
    {
      if (paramInt != 12006)
      {
        if (paramInt != 15002) {
          return;
        }
        aQ();
        return;
      }
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_choosecancel", paramInt, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l) {
      BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
    }
  }
  
  public void F()
  {
    super.F();
    ((TogetherControlHelper)a(43)).g();
    ((ClockInEntryHelper)a(85)).a(false);
  }
  
  protected void K()
  {
    aq();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      if (localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
        a(0L, 0L);
      }
      if (QVipBigTroopExpiredProcessor.c().mIsEnable)
      {
        localObject = (ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        if (localTroopManager.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          ((ISVIPHandler)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
          QLog.e("vip_pretty.", 1, "get the troop expired info from server");
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("vip_pretty.", 1, "get the troop expired info from local");
          }
          TroopManager.a(localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
        }
      }
    }
    if ((localTroopInfo != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("aio onShow:");
      ((StringBuilder)localObject).append(localTroopInfo.troopuin);
      ((StringBuilder)localObject).append(", sysFlag=");
      ((StringBuilder)localObject).append(localTroopInfo.cGroupRankSysFlag);
      ((StringBuilder)localObject).append(", userFlag=");
      ((StringBuilder)localObject).append(localTroopInfo.cGroupRankUserFlag);
      ((StringBuilder)localObject).append(",newUserFlag=");
      ((StringBuilder)localObject).append(localTroopInfo.cNewGroupRankUserFlag);
      QLog.d("Q.getTroopMemberLevelInfo", 2, ((StringBuilder)localObject).toString());
    }
    super.K();
    boolean bool1 = this.H;
    boolean bool2 = false;
    if (bool1 == true)
    {
      ThreadManager.post(new TroopChatPie.4(this), 1, null, true);
      this.H = false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
    bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Bundle)localObject).containsKey("forward_type"))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(((Bundle)localObject).getString("uin"))) {
            bool1 = true;
          }
        }
      }
    }
    ThreadManager.post(new TroopChatPie.5(this, bool1), 8, null, true);
    a(localTroopManager, localTroopInfo);
  }
  
  public void O()
  {
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopMsgObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    aW();
  }
  
  public void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopMsgObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverGroupAppsObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 35)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = ((ConfessPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558530, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel;
    }
    return super.a(paramInt);
  }
  
  public ImageView a()
  {
    return this.jdField_h_of_type_AndroidWidgetImageView;
  }
  
  protected AIOContext a()
  {
    return new TroopAIOContext();
  }
  
  protected AIOInput a()
  {
    return new AIOInputBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new TroopMessageSender(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new BaseTroopScroller()).a(new TroopListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new TroopMsgLoader()).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected TipsController a()
  {
    return new TroopTipsController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
  }
  
  protected HelperProvider a()
  {
    return new TroopHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public PanelIconLinearLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  }
  
  public EntryModel a()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).createEntryModel(localTroopInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public TroopOnlineMemberBar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar;
  }
  
  protected Boolean a()
  {
    if (this.F) {
      return new Boolean(false);
    }
    return null;
  }
  
  public Runnable a()
  {
    return this.jdField_c_of_type_JavaLangRunnable;
  }
  
  String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int k = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(k + 1), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  @Nullable
  List<ChatMessage> a(List<ChatMessage> paramList)
  {
    boolean bool3 = TroopMsgSameFold.a();
    int m = TroopMsgSameFold.a();
    int n = TroopMsgSameFold.b();
    boolean bool1;
    if (!this.U)
    {
      if (paramList.size() > 0)
      {
        this.jdField_c_of_type_Long = ((ChatMessage)paramList.get(paramList.size() - 1)).shmsgseq;
        this.jdField_d_of_type_Long = ((ChatMessage)paramList.get(0)).shmsgseq;
      }
      this.U = true;
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    boolean bool2;
    if ((this.jdField_d_of_type_Long == 0L) && (this.jdField_c_of_type_Long == 0L)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    if (a(paramList, bool3, m, bool2))
    {
      arrayOfLong1 = a(this.jdField_a_of_type_JavaUtilSet);
      arrayOfLong2 = a(this.jdField_c_of_type_JavaUtilSet);
    }
    for (;;)
    {
      int k;
      try
      {
        Object localObject3 = TroopMsgSameFold.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, m, this.jdField_d_of_type_Long, this.jdField_c_of_type_Long, arrayOfLong1, this.jdField_b_of_type_JavaUtilSet, this.jdField_a_of_type_JavaUtilMap, arrayOfLong2, bool1);
        localObject2 = localObject3;
        if (!bool1) {
          break label482;
        }
        localObject2 = localObject3;
        if (n <= 15) {
          break label482;
        }
        localObject2 = localObject3;
        if (((List)localObject3).size() <= 1) {
          break label482;
        }
        Object localObject1 = null;
        k = 1;
        if (k < ((List)localObject3).size())
        {
          localObject1 = (ChatMessage)((List)localObject3).get(k);
          if (TroopMsgSameFold.d((ChatMessage)localObject1)) {
            break label485;
          }
        }
        localObject2 = localObject3;
        if (!TroopMsgSameFold.b((ChatMessage)localObject1)) {
          break label482;
        }
        localObject2 = localObject3;
        if (((List)localObject3).size() >= 15) {
          break label482;
        }
        TroopMsgSameFold.a("find first msg is fold msg,then get more msg ", new Object[0]);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long - n - 1L);
        if (((List)localObject1).size() > 0)
        {
          this.jdField_d_of_type_Long = ((ChatMessage)((List)localObject1).get(0)).shmsgseq;
          this.jdField_c_of_type_Long = ((ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        long l1 = this.jdField_d_of_type_Long;
        long l2 = this.jdField_c_of_type_Long;
        localObject3 = this.jdField_b_of_type_JavaUtilSet;
        Map localMap = this.jdField_a_of_type_JavaUtilMap;
        try
        {
          localObject1 = TroopMsgSameFold.a((QQAppInterface)localObject2, (List)localObject1, m, l1, l2, arrayOfLong1, (Set)localObject3, localMap, arrayOfLong2, false);
          return localObject1;
        }
        catch (Throwable localThrowable1) {}
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, localThrowable2, new Object[0]);
      }
      catch (Throwable localThrowable2) {}
      break label479;
      if (paramList.size() == 0)
      {
        be();
        this.U = true;
      }
      label479:
      Object localObject2 = paramList;
      label482:
      return localObject2;
      label485:
      k += 1;
    }
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (!t())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a().e();
    }
  }
  
  public void a(int paramInt)
  {
    AIOUtils.o = true;
    int k = Integer.valueOf(paramInt).intValue();
    if (k == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    if (k != 3)
    {
      if ((k == 4) && (this.F)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    else if (this.F) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    m(k);
    super.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "onPanelChanged updateAIOPanelTip. oldPanel=", Integer.valueOf(paramInt1), ", newPanel=", Integer.valueOf(paramInt2) });
    }
    b(false);
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      aD();
    }
    if (paramInt1 == 35)
    {
      if (paramInt2 != 1) {
        bool1 = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(bool1);
    }
    if (paramInt2 == 35) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.b();
    }
    super.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2000) {
      i(paramIntent);
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (b(true))) {
      return;
    }
    if (paramInt2 == -1) {
      a(paramInt1, paramIntent);
    } else if (paramInt2 == 8001)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
    else if (paramInt1 == 12005) {
      aR();
    } else if (paramInt2 == 0) {
      o(paramInt1);
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      if (paramInt2 != 3)
      {
        if (paramInt2 != 110) {
          if (paramInt2 != 130) {
            if (paramInt2 == 131) {}
          }
        }
        switch (paramInt2)
        {
        default: 
          return;
        case 101: 
        case 102: 
          paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131689982));
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
          return;
          Object localObject = paramString;
          if (android.text.TextUtils.isEmpty(paramString)) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131696047);
          }
          paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, localObject);
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
          return;
          localObject = paramString;
          if (android.text.TextUtils.isEmpty(paramString)) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131696055);
          }
          paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, localObject);
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
          return;
          localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          if ((localObject != null) && (((TroopManager)localObject).g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString)))
          {
            ((TroopManager)localObject).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
            return;
          }
          if (android.text.TextUtils.isEmpty(paramString)) {
            break;
          }
          paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, paramString);
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
          return;
        }
      }
      else
      {
        paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131689976));
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog == null) {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = new QQAnonymousDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.show();
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramString = this.jdField_a_of_type_MqqOsMqqHandler;
      TroopChatPie.25 local25 = new TroopChatPie.25(this);
      long l;
      if (AppSetting.d) {
        l = 3000L;
      } else {
        l = 1000L;
      }
      paramString.postDelayed(local25, l);
    }
  }
  
  void a(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong1, paramLong2, new TroopChatPie.6(this, false));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showLowCreditLevelDialog:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      if ((paramLong != 1L) && (paramLong != 2L))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showLowCreditLevelDialog, CreditLevelTipDialog isShowing:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
    if (paramLong == 1L)
    {
      aV();
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_banned").c("Grp_AIO").d("exp_msgbox").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }).a();
      return;
    }
    if ((paramLong == 2L) && (!paramBoolean))
    {
      aU();
      return;
    }
    if ((paramLong == 2L) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719632)).setMessage(2131697559);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131697558, new TroopChatPie.12(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131697557, new TroopChatPie.13(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  protected void a(Intent paramIntent)
  {
    l(0);
    if ((this.F) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      o(false);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
    else if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      o(true);
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843798);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843804);
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.F) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = this.jdField_f_of_type_AndroidWidgetTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131690009));
      ((StringBuilder)localObject2).append(AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    super.a(paramIntent);
    Object localObject1 = paramIntent.getStringExtra("greetingsTitle");
    Object localObject2 = paramIntent.getStringExtra("greetingsContent");
    int k = paramIntent.getIntExtra("types", 0);
    if (k == 1)
    {
      paramIntent = paramIntent.getStringExtra("greetingsMembers");
      if (paramIntent == null) {
        break label438;
      }
    }
    try
    {
      paramIntent = new JSONArray(paramIntent);
      k = 0;
      while (k < paramIntent.length())
      {
        localObject3 = paramIntent.getString(k);
        localObject4 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3);
        localObject3 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3, (String)localObject4, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
        if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject3);
        }
        k += 1;
      }
    }
    catch (JSONException paramIntent)
    {
      Object localObject3;
      Object localObject4;
      label348:
      break label348;
    }
    if (QLog.isColorLevel())
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "TroopChatPie send greetings.get members failed.");
      break label438;
      if (k == 2)
      {
        paramIntent = paramIntent.getStringExtra("greetingsName");
        localObject3 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("@");
        ((StringBuilder)localObject4).append(paramIntent);
        ((StringBuilder)localObject4).append(" ");
        ((Editable)localObject3).insert(0, ((StringBuilder)localObject4).toString());
      }
    }
    label438:
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramIntent = (QWalletAIOLifeCycleHelper)a(27);
      if (paramIntent != null) {
        paramIntent.a("0", (String)localObject2, (String)localObject1);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).m(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    ((TogetherControlHelper)a(43)).g();
    ((ClockInEntryHelper)a(85)).a(false);
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int k = paramIntent.getIntExtra(AlbumConstants.h, -1);
    if (((k == 2) || (k == 1)) && (b(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131378040)
    {
      int k = this.jdField_i_of_type_Int;
      if (k == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar = new TroopOnlineMemberBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips);
        }
        this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(a().jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.b()) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a())
        {
          aD();
          if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.b != 2) {
            new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryClose").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(1);
          paramView = (ITroopOnlineMemberHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_MEMBER_HANDLER);
          if (paramView != null) {
            paramView.a(a().jdField_a_of_type_JavaLangString);
          }
          n(true);
          if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.b == 2)
          {
            TroopReportor.a("Grp_idol", "Grp_AIO", "clk_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
            return;
          }
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryOpen").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        }
      }
      else
      {
        if (k == 3)
        {
          ((TroopListenTogetherPanel)a(33)).b();
          return;
        }
        if (k == 4)
        {
          ((TogetherControlHelper)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          return;
        }
        if (k == 5)
        {
          ((StudyRoomTipBarHelper)a(75)).a();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(1, new Object[] { Integer.valueOf(this.jdField_i_of_type_Int) });
      }
    }
    else
    {
      aZ();
    }
  }
  
  public void a(TroopChatPie.OnListViewScrollStateListener paramOnListViewScrollStateListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnListViewScrollStateListener);
  }
  
  void a(SelfGagInfo paramSelfGagInfo)
  {
    FastImageHelper localFastImageHelper = (FastImageHelper)a(83);
    if (paramSelfGagInfo.jdField_a_of_type_Boolean)
    {
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (8 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()))
      {
        av();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateGagStatus_UI, sendEmptyMessageDelayed-TIMER_ID:");
          localStringBuilder.append(paramSelfGagInfo.jdField_a_of_type_Long);
          localStringBuilder.append(", hasDestory=");
          localStringBuilder.append(this.B);
          QLog.d("troop_gag", 2, localStringBuilder.toString());
        }
        if (!this.B)
        {
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramSelfGagInfo.jdField_a_of_type_Long * 1000L);
        }
      }
      else
      {
        this.M = true;
      }
      localFastImageHelper.a(false);
      if (QLog.isColorLevel())
      {
        paramSelfGagInfo = new StringBuilder();
        paramSelfGagInfo.append("updateGagStatus disable fastimage,  mAllowFastImage = ");
        paramSelfGagInfo.append(localFastImageHelper.a());
        QLog.d("fastimage", 2, paramSelfGagInfo.toString());
      }
    }
    else
    {
      this.M = false;
      ao();
      localFastImageHelper.a();
      if (QLog.isColorLevel())
      {
        paramSelfGagInfo = new StringBuilder();
        paramSelfGagInfo.append("updateGagStatus enable fastimage,  mAllowFastImage = ");
        paramSelfGagInfo.append(localFastImageHelper.a());
        QLog.d("fastimage", 2, paramSelfGagInfo.toString());
      }
    }
  }
  
  public void a(SelfGagInfo paramSelfGagInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (paramSelfGagInfo == null)
      {
        ThreadManager.post(new TroopChatPie.11(this, paramBoolean), 8, null, true);
        return;
      }
      a(paramSelfGagInfo);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    if ((localITroopRobotService.isRobotTroop(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localITroopRobotService.isRobotUin(paramString1)))
    {
      AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(52);
      boolean bool = false;
      if (localAIOShortcutBarHelper != null)
      {
        localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(24);
        localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
        bool = localAIOShortcutBarEvent.a().getBoolean("result");
      }
      if (bool) {
        return;
      }
      AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
      localAIOShortcutBarEvent.a().putString("mCurrentRobotUin", paramString1);
      localAIOShortcutBarEvent.a().putString("mCurrentRobotNickname", paramString2);
      localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
      localITroopRobotService.setCurrentAtRobotUin(paramString1);
    }
    super.a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = (ITroopOnlineMemberService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopOnlineMemberService.class, "");
    String str = ((ITroopOnlineMemberService)localObject).getOnlineTip(paramString);
    ((TroopListenTogetherPanel)a(33)).c();
    if ((!this.F) && (!android.text.TextUtils.isEmpty(str)) && (!ChatPieTipsBarHelper.a(this)))
    {
      if (this.jdField_i_of_type_Int != 2)
      {
        l(2);
        if (paramBoolean) {
          if (((ITroopOnlineMemberService)localObject).getRequestListServiceType(paramString) == 3) {
            TroopReportor.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { paramString });
          } else {
            new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
          }
        }
      }
      a(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar;
      if (localObject != null)
      {
        ((TroopOnlineMemberBar)localObject).a(paramString);
        if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.d();
          m(true);
          return;
        }
        m(false);
        return;
      }
      m(false);
      return;
    }
    if ((!this.F) && (!ChatPieTipsBarHelper.a(this)))
    {
      a(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(1, this, paramList);
    super.a(paramList, paramCharSequence, paramInt);
    if ((0xFFFF & paramInt) == 4)
    {
      ((TroopAioKeywordTipManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER)).a(paramList);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a().f();
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool3 = this.S;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool3)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (k <= m) {
        k = m;
      }
      for (;;)
      {
        bool2 = bool1;
        if (k < m) {
          break;
        }
        bool2 = bool1;
        if (k > n) {
          break;
        }
        try
        {
          Object localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(k);
          bool2 = bool1;
          if (localObject != null)
          {
            bool2 = bool1;
            if (((ChatMessage)localObject).msgtype == -1012)
            {
              localObject = ((ChatMessage)localObject).getExtInfoFromExtStr("troop_new_member_uin");
              if (QLog.isColorLevel())
              {
                String str = this.jdField_b_of_type_JavaLangString;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("isNewMemberGrayTipVisible newMemberUin = ");
                localStringBuilder.append((String)localObject);
                localStringBuilder.append(",detect memberUin = ");
                localStringBuilder.append(paramString);
                QLog.d(str, 2, localStringBuilder.toString());
              }
              bool2 = bool1;
              if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
              {
                bool3 = ((String)localObject).equals(paramString);
                bool2 = bool1;
                if (bool3) {
                  bool2 = true;
                }
              }
            }
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          localIndexOutOfBoundsException.printStackTrace();
          bool2 = bool1;
        }
        k += 1;
        bool1 = bool2;
      }
    }
    return bool2;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewViewGroup == null)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "mAIORootView == null");
      ChatFragment localChatFragment = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getChatFragment();
      if (localChatFragment != null) {
        this.jdField_c_of_type_AndroidViewViewGroup = localChatFragment.a;
      }
    }
    super.a(paramBoolean);
    n(1);
    RobotResourcesManager.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport = new TroopUsingTimeReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    TroopAbilityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), true);
    return true;
  }
  
  public void aA()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new TroopChatPie.23(this));
    View localView = this.jdField_j_of_type_AndroidViewView;
    if ((localView != null) && (this.jdField_i_of_type_AndroidViewView != null))
    {
      localView.startAnimation(localAlphaAnimation);
      this.jdField_i_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    }
  }
  
  public void aB()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new TroopChatPie.24(this));
    this.jdField_j_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    this.jdField_i_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void aC()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!a().isFinishing())) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void aD()
  {
    TroopOnlineMemberBar localTroopOnlineMemberBar = this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar;
    if ((localTroopOnlineMemberBar != null) && (localTroopOnlineMemberBar.a()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a() == 2)
      {
        a(false);
        l(0);
        return;
      }
      n(false);
    }
  }
  
  public void aE()
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView == null) {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365729));
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    String str;
    StringBuilder localStringBuilder;
    if ((localTroopInfo != null) && (localTroopInfo.wMemberNumClient > 0))
    {
      if (QLog.isColorLevel())
      {
        str = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showNewTroopMemberCount wMemberNumClient:");
        localStringBuilder.append(localTroopInfo.wMemberNumClient);
        localStringBuilder.append("  wMemberNum:");
        localStringBuilder.append(localTroopInfo.wMemberNum);
        localStringBuilder.append(" troopUin:");
        localStringBuilder.append(localTroopInfo.troopuin);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
      if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
        {
          boolean bool = ((AudioPanelAioHelper)a(128)).b;
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(bool ^ true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel())
    {
      if (localTroopInfo != null)
      {
        str = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showNewTroopMemberCount count smaller than 0");
        localStringBuilder.append(localTroopInfo.wMemberNumClient);
        QLog.d(str, 2, localStringBuilder.toString());
        return;
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showNewTroopMemberCount info is null");
    }
  }
  
  public void aF()
  {
    if ((this.jdField_h_of_type_AndroidWidgetImageView != null) && (this.jdField_f_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidViewViewGroup != null))
    {
      if (this.jdField_e_of_type_AndroidWidgetTextView == null) {
        return;
      }
      Object localObject2 = (TroopListenTogetherPanel)a(33);
      boolean bool1 = ((TroopListenTogetherPanel)localObject2).c();
      boolean bool2 = ((TroopListenTogetherPanel)localObject2).d();
      TogetherControlHelper localTogetherControlHelper = (TogetherControlHelper)a(43);
      boolean bool4 = localTogetherControlHelper.c();
      StudyRoomTipBarHelper localStudyRoomTipBarHelper = (StudyRoomTipBarHelper)a(75);
      boolean bool3 = localStudyRoomTipBarHelper.d();
      Object localObject1 = (IliveGroupTipsBarHelper)a(81);
      boolean bool5 = ((IliveGroupTipsBarHelper)localObject1).d();
      int k;
      if (bool1)
      {
        l(3);
        a(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(((TroopListenTogetherPanel)localObject2).a(bool2));
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
        n(bool2);
        k = AIOUtils.b(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, k, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
      }
      else if (bool4)
      {
        bool3 = localTogetherControlHelper.a();
        l(4);
        a(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(localTogetherControlHelper.a());
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
        n(bool3);
        k = AIOUtils.b(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, k, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
      }
      else if (bool3)
      {
        l(5);
        a(true);
        bool4 = localStudyRoomTipBarHelper.a();
        this.jdField_f_of_type_AndroidWidgetTextView.setText(localStudyRoomTipBarHelper.a(bool4));
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
        n(bool4);
        k = AIOUtils.b(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, k, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onSubTitleChanged. showStudyRoomTime=");
          ((StringBuilder)localObject2).append(bool3);
          ((StringBuilder)localObject2).append(",isTipsShow=");
          ((StringBuilder)localObject2).append(bool4);
          QLog.d("StudyRoomTipBarHelper", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else if (bool5)
      {
        a((IliveGroupTipsBarHelper)localObject1, bool5);
      }
      else
      {
        localObject2 = ((ITroopOnlineMemberService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopOnlineMemberService.class, "")).getOnlineTip(a().jdField_a_of_type_JavaLangString);
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject2))
        {
          l(2);
          a(true);
          this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
          m(false);
        }
        else
        {
          this.jdField_f_of_type_AndroidWidgetTextView.setText("");
          l(0);
        }
        BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
      }
      ((IliveGroupTipsBarHelper)localObject1).b();
      if ((QLog.isColorLevel()) && (QLog.isColorLevel()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("togetherTime=");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(",hasPannelShow");
        ((StringBuilder)localObject1).append(bool2);
        QLog.d("BaseListenTogetherPanel_Troop", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void aG()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void ai()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  public void ap()
  {
    super.ap();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null)
    {
      TroopChatPie.TroopFileErrorFilterForChatActivity localTroopFileErrorFilterForChatActivity = new TroopChatPie.TroopFileErrorFilterForChatActivity(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopFileErrorFilterForChatActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    b(false);
    if (this.F != AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.F ^= true;
      o(this.F);
    }
    ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void aq()
  {
    super.aq();
    this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    bb();
    ax();
    bc();
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (localIntent != null)
    {
      String str1 = localIntent.getStringExtra("at_member_name");
      String str2 = localIntent.getStringExtra("at_member_uin");
      int k = localIntent.getIntExtra("at_member_source", 0);
      if ((!android.text.TextUtils.isEmpty(str1)) && (!android.text.TextUtils.isEmpty(str2))) {
        a(str2, str1, false, k);
      }
    }
    bd();
    this.O = false;
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 500L);
    aE();
    this.N = true;
  }
  
  void at()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, true);
    }
  }
  
  public void au()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, String.format("updateTroopHonorInteractiveIcon, troopUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
      }
      TroopHonorAIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_f_of_type_AndroidWidgetImageView, this.z);
    }
  }
  
  @TargetApi(11)
  protected void av()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
  }
  
  public void aw()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null) {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkTroopCreditLevel, troopInfo==null:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    long l1 = ((TroopInfo)localObject).troopCreditLevel;
    if ((l1 != 1L) && (l1 != 2L))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkTroopCreditLevel, normal:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(l1);
        QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    long l2 = ((TroopInfo)localObject).dwAdditionalFlag;
    boolean bool3 = false;
    boolean bool1;
    if ((l2 & 1L) == 1L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) == 1L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((bool1) || (bool2)) {
      bool3 = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkTroopCreditLevel:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(bool2);
      QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
    }
    localObject = (ITroopBatchInfohandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_BATCH_INFO_HANDLER);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkTroopCreditLevel, getTroopCreditInfo:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        QLog.i("troop.credit.act", 2, localStringBuilder.toString());
      }
      ((ITroopBatchInfohandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    a(l1, bool3);
  }
  
  void ax()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject == null) {
        return;
      }
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || ((((TroopInfo)localObject).wMemberNum != 0) && (!android.text.TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)))) {}
    }
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      ((ITroopListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a((ArrayList)localObject);
      if (!QLog.isColorLevel()) {
        break label180;
      }
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopInfoIfNeed, sessionInfo.curFriendUin = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      label163:
      label180:
      break label163;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "getTroopInfoIfNeed failed");
    }
  }
  
  void ay()
  {
    ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    if (localITroopMemberListHandler != null) {
      try
      {
        localITroopMemberListHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0L, 2, 0, 0);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_b_of_type_JavaLangString, 2, localException.toString());
        }
      }
    }
  }
  
  void az()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground() != null) {
      g();
    }
    aY();
    this.k.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130851066);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167050));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167050));
    }
    else if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130851067);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167050));
    }
    AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, 2130851075);
    if ((this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_f_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_f_of_type_AndroidWidgetTextView.getText().toString().startsWith(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131690009))))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
      a(false);
    }
    Object localObject = (ITroopOnlineMemberService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopOnlineMemberService.class, "");
    String str = ((ITroopOnlineMemberService)localObject).getOnlineTip(a().jdField_a_of_type_JavaLangString);
    if (!android.text.TextUtils.isEmpty(str))
    {
      l(2);
      if (((ITroopOnlineMemberService)localObject).getRequestListServiceType(a().jdField_a_of_type_JavaLangString) == 3) {
        TroopReportor.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
      } else {
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
      }
      a(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      m(false);
    }
    else
    {
      l(0);
    }
    localObject = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
    if (localObject != null) {
      ((PlusPanel)localObject).a(false);
    }
    localObject = (AIOEmoticonUIHelper)a(105);
    if (localObject != null) {
      ((AIOEmoticonUIHelper)localObject).b(false);
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    this.jdField_h_of_type_AndroidViewView.setVisibility(8);
    AnonymousChatHelper.a().b();
    aB();
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(1.0F, 0.0F, 1.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165396));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130850227);
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    ((TogetherControlHelper)a(43)).f();
    ((ClockInEntryHelper)a(85)).a(false);
  }
  
  public ViewGroup b()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public ImageView b()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView;
  }
  
  public RelativeLayout b()
  {
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  public TipsManager b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    if (paramInt2 == 8)
    {
      bool = this.F;
      return;
    }
    boolean bool = this.F;
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    au();
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handleTroopGagUI", 2, "start");
    }
    if (this.M)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697407, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
      if (QLog.isColorLevel()) {
        QLog.d("doDisableInputStat", 2, "start");
      }
      av();
      return true;
    }
    return false;
  }
  
  public ViewGroup c()
  {
    return this.jdField_b_of_type_AndroidViewViewGroup;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "TroopChatPie";
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    ai();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void c(boolean paramBoolean)
  {
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    if (this.K) {
      ba();
    }
    super.c(paramBoolean);
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.troopcode;
      }
    }
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  public void d(String paramString)
  {
    if (a().isFinishing()) {
      return;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), a().getTitleBarHeight());
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    if (!a().isFinishing())
    {
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        return;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public boolean d()
  {
    if (((AIOAtHelper)a(34)).a()) {
      return true;
    }
    if (((TogetherControlHelper)a(43)).f()) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    ((TroopTipsHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(109)).b();
    if (this.K) {
      ba();
    }
    return super.d();
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.F)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843824);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        return;
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130851067);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130851066);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167050));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167050));
        return;
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130851067);
        this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167050));
      }
    }
  }
  
  public void e(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  protected void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    }
    this.H = true;
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
    TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController$AIOTipsListener);
    ThreadManager.post(new TroopChatPie.CheckGlamourPicturesRunnable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), 2, null, true);
    localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (((TroopManager)localObject).m(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        int k;
        if (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          k = 1;
        } else if (((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          k = 2;
        } else {
          k = 3;
        }
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_AIO").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(k) }).a();
      }
    }
    if (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)
    {
      this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new TroopChatPie.InputOnGlobalLayoutListener(this, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    be();
  }
  
  public void g(int paramInt)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("troopUin : ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
    }
    catch (Exception localException)
    {
      label76:
      StringBuilder localStringBuilder;
      break label76;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onShowFirst : invalid uin!");
    }
    Object localObject1 = null;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("avType : ");
        localStringBuilder.append(((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Int);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Int == 2)
      {
        if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Boolean) {
          ReportController.b(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
      }
      else if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Int == 10)
      {
        if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Boolean) {
          ReportController.b(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
      }
    }
    ((TroopListUI)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a()).h();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetScrollView = new TroopChatPie.2(this, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
      this.jdField_a_of_type_AndroidWidgetScrollView.setScrollbarFadingEnabled(false);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalScrollBarEnabled(false);
      this.jdField_h_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
      localObject1 = new RelativeLayout.LayoutParams(-1, this.jdField_h_of_type_Int);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, 0, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, this.jdField_h_of_type_Int);
    }
    else
    {
      this.jdField_h_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = this.jdField_h_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
      this.jdField_a_of_type_AndroidWidgetScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, this.jdField_h_of_type_Int);
    }
    localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {
      this.L = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equalsIgnoreCase(((TroopInfo)localObject1).troopowneruin);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause, isTroopOwner =");
      localStringBuilder.append(this.L);
      localStringBuilder.append(",troopInfo = ");
      localStringBuilder.append(localObject1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    aS();
    localObject1 = (TogetherEntryBean)QConfigManager.a().a(553);
    if ((localObject1 != null) && (!((TogetherEntryBean)localObject1).jdField_a_of_type_Boolean))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.K = ((Intent)localObject1).getBooleanExtra("open_chat_from_group_rec_confess", false);
    if (this.K)
    {
      j((Intent)localObject1);
      f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.k = this.K;
    m(false);
    super.g(paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    Object localObject1;
    long l1;
    long l2;
    long l3;
    if (k != 29)
    {
      if ((k == 30) || (k != 86)) {
        break label473;
      }
      localObject1 = (List)paramMessage.obj;
      if (localObject1 == null) {
        break label473;
      }
      l1 = ((Long)((List)localObject1).get(0)).longValue();
      l2 = ((Long)((List)localObject1).get(1)).longValue();
      l3 = ((Long)((List)localObject1).get(2)).longValue();
    }
    for (;;)
    {
      try
      {
        l4 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        l5 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if (l4 != l1) {
          break label512;
        }
        if (l2 == l5) {
          break label507;
        }
        if (l3 != l5) {
          break label512;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l4;
        long l5;
        QLog.e(".troop.chat_pie_msg", 1, "MSG_TROOP_ADMIN_OPERATION_NOTIFY: groupUin error", localNumberFormatException);
        break label473;
      }
      if (k != 0)
      {
        localObject1 = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: will reload plusPanel, groupUin:", Long.valueOf(l1) });
          }
          ((PlusPanel)localObject1).a();
        }
        else if (QLog.isColorLevel())
        {
          QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: should reload plusPanel, but mPlusPanel == null, groupUin:", Long.valueOf(l1) });
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition not match: group:", Long.valueOf(l1), "/", Long.valueOf(l4), " uin1/uin2/current: ", Long.valueOf(l2), "/", Long.valueOf(l3), "/", Long.valueOf(l5) });
        break label473;
        Object localObject2 = this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow;
        if ((localObject2 != null) && (((TroopNewGuidePopWindow)localObject2).isShowing())) {
          this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.dismiss();
        }
        this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = new TroopNewGuidePopWindow(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localObject2 = new int[2];
        this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject2);
        k = a();
        int[] arrayOfInt = new int[2];
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationInWindow(arrayOfInt);
        int m = arrayOfInt[1];
        int n = localObject2[1];
        this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.a(k, m - n);
        this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.a(paramMessage.arg1);
      }
      label473:
      if ((paramMessage.what == 60) && (this.F))
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843798);
        return true;
      }
      return super.handleMessage(paramMessage);
      label507:
      k = 1;
      continue;
      label512:
      k = 0;
    }
  }
  
  public void j()
  {
    ai();
    ((TogetherControlHelper)a(43)).g();
    ((ClockInEntryHelper)a(85)).a(false);
  }
  
  public void k()
  {
    if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      int m = 0;
      int k = m;
      if (localObject1 != null)
      {
        localObject1 = ((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        k = m;
        if (localObject1 != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          k = m;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject2))
          {
            k = m;
            if (!android.text.TextUtils.isEmpty(((TroopInfo)localObject1).Administrator)) {
              if (!((String)localObject2).equals(((TroopInfo)localObject1).Administrator))
              {
                k = m;
                if (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2)) {}
              }
              else
              {
                k = 1;
              }
            }
          }
        }
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (k != 0) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
    }
    VasWebviewUtil.a("", "style", "0X8008E61", "", 1, 0, 0, "", "", "");
    aZ();
  }
  
  public void l(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
    if ((this.jdField_h_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      if (paramInt == 3)
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      }
      else if (paramInt == 4)
      {
        if (((TogetherControlHelper)a(43)).d()) {
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        } else {
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      }
      else if (paramInt == 2)
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      }
      else if (paramInt == 5)
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      }
      else
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(2, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "changeSubTitleType, not init ui");
    }
  }
  
  public void m()
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localTroopManager != null) && (localTroopManager.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if ((!this.F) && (!this.G)) {
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850467, 2130850468);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843820);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  void m(int paramInt)
  {
    String str;
    if (paramInt != 2) {
      if (paramInt != 3) {
        if (paramInt != 4) {
          if (paramInt != 5) {
            if (paramInt != 6) {
              if (paramInt != 10) {
                str = null;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      str = "7";
      continue;
      str = "5";
      continue;
      str = "4";
      continue;
      str = "3";
      continue;
      str = "2";
      continue;
      str = "1";
    }
    if (str != null) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOshortcut", "Clk_shortcut", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    }
  }
  
  public void m(boolean paramBoolean)
  {
    if ((!this.T) && (!paramBoolean) && (this.jdField_i_of_type_Int == 2)) {
      n(false);
    }
  }
  
  public void n(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
      ((ITroopSettingHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt, 0);
    }
  }
  
  public void n(boolean paramBoolean)
  {
    Object localObject = (LinearLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetImageView.getLayoutParams();
    this.jdField_h_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramBoolean)
        {
          k = 2130844017;
          localObject = ((Resources)localObject).getDrawable(k);
          if ((!SimpleUIUtil.a()) && (!"2105".equals(ThemeUtil.curThemeId)))
          {
            if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
              ((Drawable)localObject).clearColorFilter();
            } else {
              ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
            }
          }
          else {
            ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053), PorterDuff.Mode.MULTIPLY);
          }
          if (paramBoolean)
          {
            Drawable localDrawable = this.jdField_h_of_type_AndroidWidgetImageView.getDrawable();
            if ((localDrawable instanceof AnimationDrawable)) {
              ((AnimationDrawable)localDrawable).stop();
            }
            ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
            this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
            return;
          }
          if ((Build.VERSION.SDK_INT >= 21) && (!this.T))
          {
            aT();
            return;
          }
          ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      int k = 2130844024;
    }
  }
  
  public void o(boolean paramBoolean)
  {
    ((SimpleUIAIOHelper)a(29)).c(paramBoolean);
    this.F = paramBoolean;
    AnonymousChatHelper.a().a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) || (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_anonyous", paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setHelperProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this, new UpdateParams.Builder().a(paramBoolean).a());
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_g_of_type_AndroidViewView == null)
    {
      this.jdField_g_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_g_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(12, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_g_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.jdField_j_of_type_AndroidViewView == null)
    {
      this.jdField_j_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_j_of_type_AndroidViewView.setBackgroundResource(2130843804);
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_j_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_j_of_type_AndroidViewView, 0);
    }
    if (this.jdField_i_of_type_AndroidViewView == null)
    {
      this.jdField_i_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130843804);
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_i_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_i_of_type_AndroidViewView, 0);
    }
    if (this.jdField_h_of_type_AndroidViewView == null)
    {
      this.jdField_h_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_h_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(2, 2131368875);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_h_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(paramBoolean);
    }
    if (paramBoolean)
    {
      aX();
      ((TroopAskAnonymouslyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(97)).c();
    }
    else
    {
      az();
    }
    m();
    j();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131367417) || (!b(true)))
    {
      super.onClick(paramView);
      if (paramView.getId() == 2131371572) {
        aD();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a().a(paramInt, 500L);
    }
    if (paramInt == 2) {
      aD();
    }
    if (QLog.isColorLevel())
    {
      paramAbsListView = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollState = ");
      localStringBuilder.append(paramInt);
      QLog.d(paramAbsListView, 2, localStringBuilder.toString());
    }
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.S = bool;
    paramAbsListView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramAbsListView.hasNext()) {
      ((TroopChatPie.OnListViewScrollStateListener)paramAbsListView.next()).a(this.S);
    }
    if ((paramInt == 0) && (this.jdField_d_of_type_JavaLangString != null))
    {
      paramAbsListView = ((ITroopBatchAddFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
      this.jdField_d_of_type_JavaLangString = null;
      paramAbsListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131370119) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable;
    if (localObject != null) {
      ((TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable)localObject).a(true);
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.J = false;
    this.I = false;
    if (this.B)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.K) {
      ba();
    }
    ((AIOAtHelper)a(34)).a();
    aM();
    aN();
    aL();
    aI();
    n(0);
    this.N = false;
    this.P = false;
    this.R = false;
    this.Q = false;
    aH();
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
    }
    aK();
    l(0);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport;
    if (localObject != null) {
      ((TroopUsingTimeReport)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel;
    if (localObject != null)
    {
      ((ConfessPanel)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = null;
    }
    be();
    super.p();
    localObject = this.jdField_b_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "doOnDestroy, timerHandler->removeCallbacksAndMessages");
      }
    }
    RobotResourcesManager.a().a();
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    aO();
    TroopFileItemBuilder.jdField_a_of_type_JavaUtilHashMap.clear();
    TroopFileItemBuilder.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    TroopConfessUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    localObject = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
    BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
    this.T = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a().a(null);
    aJ();
    aP();
  }
  
  public void p(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public void s()
  {
    super.s();
    TroopConfessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public void u()
  {
    if (this.F) {
      aY();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow;
    if ((localObject == null) || (!((TroopNewGuidePopWindow)localObject).isShowing()))
    {
      localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (localObject != null) {
        ((AIOAnimationControlManager)localObject).c();
      }
    }
    localObject = this.jdField_a_of_type_AndroidWidgetToast;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable;
    if (localObject != null) {
      ((TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable)localObject).a(true);
    }
    super.u();
  }
  
  public boolean u()
  {
    return false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "update");
    }
    if (paramObject == null) {
      return;
    }
    if (((paramObject instanceof TroopMsgData)) && (a((TroopMsgData)paramObject))) {
      return;
    }
    if ((paramObject instanceof MessageRecord)) {
      b(paramObject);
    } else if ((paramObject instanceof Integer)) {
      switch (((Integer)paramObject).intValue())
      {
      default: 
        break;
      case 123322: 
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a())) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(1, this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a() / 2);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(1);
        }
        break;
      }
    }
    if ((paramObject instanceof MessageForText))
    {
      paramObservable = (MessageForText)paramObject;
      if (paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TroopChatPie.update()");
        }
        AioVipKeywordHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
      }
    }
  }
  
  public void v()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetToast;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    super.v();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
    if (localObject != null) {
      ((FloatView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow;
    if ((localObject == null) || (!((TroopNewGuidePopWindow)localObject).isShowing()))
    {
      localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (localObject != null) {
        ((AIOAnimationControlManager)localObject).c();
      }
    }
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause, isTroopOwner =");
      localStringBuilder.append(this.L);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  protected void w()
  {
    super.w();
    if (this.F)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843798);
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
      a(-16777216, false);
    }
  }
  
  public boolean w()
  {
    return this.M;
  }
  
  boolean x()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic;
    boolean bool = TroopNotificationHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTroopNotificationMsg. hasNewGuide = ");
      localStringBuilder.append(bool);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!bool))
    {
      ThreadManager.post(new TroopChatPie.20(this), 8, null, true);
      return true;
    }
    return false;
  }
  
  public void y()
  {
    super.y();
    ((BaseTroopListUI)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a()).a();
    FloatView localFloatView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
    if (localFloatView != null) {
      localFloatView.setVisibility(0);
    }
    TroopConfessUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.a();
    AIOOpenState.b(true);
  }
  
  public boolean y()
  {
    return this.L;
  }
  
  public void z()
  {
    super.z();
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    String str = localIntent.getStringExtra("uin");
    int k = localIntent.getIntExtra("uintype", -1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != k))) {
      k = 1;
    } else {
      k = 0;
    }
    if ((k != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    be();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */