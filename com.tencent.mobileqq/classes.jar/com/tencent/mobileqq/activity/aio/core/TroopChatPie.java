package com.tencent.mobileqq.activity.aio.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOTipsController.AIOTipsListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.confess.ConfessPanel;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.TroopMsgLoader;
import com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.helper.AIOAtHelper;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper;
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
import com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams.Builder;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredTipsBar;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopSurveyBar;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopTipsBar;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TogetherWatchTroopTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.activity.aio.tips.UpgradeBigTroopTipsBar;
import com.tencent.mobileqq.activity.aio.troop.TroopMsgSameFold;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TogetherEntryBean;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.troop.aioapp.GroupAppsObserver;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.troop.groupclass.TroopAioClassController;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker;
import com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
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
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopChatPie
  extends BaseTroopChatPie
{
  boolean U = false;
  protected boolean V = false;
  boolean W;
  boolean X;
  public boolean Y;
  boolean Z = false;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler;
  public ScrollView a;
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  AnonymousChatHelper.AnonymousStatusListener jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener;
  public QQAnonymousDialog a;
  public TroopNewGuidePopWindow a;
  AIOTipsController.AIOTipsListener jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController$AIOTipsListener = new TroopChatPie.35(this);
  protected ConfessPanel a;
  private TroopChatPieInnerBusinessObserver jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPieInnerBusinessObserver = new TroopChatPieInnerBusinessObserver(this);
  private TroopChatPieInnerObserver jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPieInnerObserver = new TroopChatPieInnerObserver(this);
  private TroopMsgObserver jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopMsgObserver = new TroopMsgObserver(this);
  public BigTroopExpiredTipsBar a;
  GamePartyTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar;
  HomeworkTroopSurveyBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar;
  public HomeworkTroopTipsBar a;
  TogetherWatchTroopTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherWatchTroopTipsBar;
  TroopAssistTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar;
  UpgradeBigTroopTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopChatPie.19(this);
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopChatPie.9(this);
  SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new TroopChatPie.11(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new TroopChatPie.20(this);
  TeamWorkObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver = new TroopChatPie.34(this);
  private GroupAppsObserver jdField_a_of_type_ComTencentMobileqqTroopAioappGroupAppsObserver;
  protected TroopEnterEffectController a;
  TroopClassControllerManager jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager;
  TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable;
  TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  protected TroopUsingTimeReport a;
  protected TroopInteractGiftAnimationController a;
  protected TroopOnlineMemberBar a;
  protected TroopPicEffectsController a;
  private Map<Long, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Observer jdField_a_of_type_JavaUtilObserver = new TroopChatPie.27(this);
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  boolean aa = false;
  protected boolean ab = false;
  boolean ac = false;
  boolean ad = true;
  boolean ae = false;
  boolean af = false;
  boolean ag = false;
  public boolean ah = false;
  private boolean ai = false;
  private boolean aj;
  private boolean ak = false;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_b_of_type_AndroidOsHandler = new TroopChatPie.12(this, Looper.getMainLooper());
  private ViewTreeObserver.OnGlobalLayoutListener jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  public LinearLayout b;
  protected QQCustomDialog b;
  Runnable jdField_b_of_type_JavaLangRunnable;
  protected List<TroopChatPie.OnListViewScrollStateListener> b;
  private Set<Long> jdField_b_of_type_JavaUtilSet = new HashSet();
  public volatile long c;
  public QQCustomDialog c;
  Runnable jdField_c_of_type_JavaLangRunnable = new TroopChatPie.1(this);
  private Set<Long> jdField_c_of_type_JavaUtilSet = new HashSet();
  private long jdField_d_of_type_Long;
  Runnable jdField_d_of_type_JavaLangRunnable = new GetOnlineMemberTipsRunnable(this);
  private long jdField_e_of_type_Long;
  Runnable jdField_e_of_type_JavaLangRunnable = new TroopChatPie.31(this);
  String h;
  String i;
  protected int k;
  protected int l = 2;
  public int m;
  View m;
  protected int n;
  View n;
  int jdField_o_of_type_Int = 0;
  View jdField_o_of_type_AndroidViewView;
  View p;
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_k_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = null;
    this.jdField_n_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
  }
  
  private boolean I()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    }
    if (localObject == null)
    {
      bool2 = bool1;
      return bool2;
    }
    localObject = (AtTroopMemberSpan[])((Editable)localObject).getSpans(0, localObject.toString().length(), AtTroopMemberSpan.class);
    int j = 0;
    for (;;)
    {
      bool1 = bool2;
      if (j < localObject.length)
      {
        if (localTroopRobotManager.b(localObject[j].a())) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "needFilterRobot : " + bool1);
        return bool1;
      }
      j += 1;
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            int j;
            do
            {
              do
              {
                return;
                localObject = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
                ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
                this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject);
                return;
                h(paramIntent);
                return;
                TroopGiftUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                return;
                an();
                paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
              } while (paramInt <= 0);
              j = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().charAt(paramInt - 1);
            } while ((j != 36) && (j != 65509) && (j != 165) && (j != 65284));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().delete(paramInt - 1, paramInt));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramInt - 1);
            return;
          } while (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer == null);
          localObject = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
        } while (localObject == null);
        ((TroopGiftPanel)localObject).a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
        return;
        paramIntent = paramIntent.getStringExtra("result");
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } while ((android.text.TextUtils.isEmpty(paramIntent)) || (localObject == null) || (paramIntent.equals(((TroopInfo)localObject).troopname)));
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
      Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      ((Intent)localObject).putExtra("uinname", paramIntent);
      b((Intent)localObject);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(paramInt, paramIntent);
  }
  
  private void a(TroopManager paramTroopManager, TroopInfo paramTroopInfo)
  {
    if ((!this.ag) && (paramTroopManager.a.jdField_a_of_type_Boolean) && (paramTroopInfo != null) && (paramTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      int j = paramTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((j < 3) && (paramTroopInfo.wMemberMax < 2000) && (paramTroopInfo.wMemberNum >= 500))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar = new UpgradeBigTroopTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsUpgradeBigTroopTipsBar, new Object[0]))
        {
          this.ag = true;
          paramTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, j + 1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    int j;
    if ((paramTroopInfo != null) && (TroopInfo.hasPayPrivilege(paramTroopInfo.troopPrivilegeFlag, 32)))
    {
      if (!paramTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label124;
      }
      j = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "sign", 0, 0, paramTroopInfo.troopuin + "", j + "", "", "");
      TroopGiftUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramTroopInfo.troopuin, "input", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      label124:
      if (paramTroopInfo.isAdmin()) {
        j = 1;
      } else {
        j = 2;
      }
    }
  }
  
  private void a(IliveGroupTipsBarHelper paramIliveGroupTipsBarHelper, boolean paramBoolean)
  {
    v(6);
    b(true);
    boolean bool = paramIliveGroupTipsBarHelper.a();
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramIliveGroupTipsBarHelper.a(bool));
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
    u(bool);
    int j = AIOUtils.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
    BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, j, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "onSubTitleChanged. isIliveTime=" + paramBoolean + ",isTipsShow=" + bool);
    }
  }
  
  private boolean a(TroopMsgData paramTroopMsgData)
  {
    long l1;
    if (paramTroopMsgData.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(paramTroopMsgData.b));
      this.jdField_b_of_type_JavaUtilSet.remove(Long.valueOf(paramTroopMsgData.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramTroopMsgData.jdField_a_of_type_Long));
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramTroopMsgData.b));
      l1 = paramTroopMsgData.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().d(l1);
      g(131089);
      return true;
    }
    if (paramTroopMsgData.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramTroopMsgData.b));
      this.jdField_b_of_type_JavaUtilSet.add(Long.valueOf(paramTroopMsgData.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramTroopMsgData.jdField_a_of_type_Long), Long.valueOf(paramTroopMsgData.b));
      this.jdField_c_of_type_JavaUtilSet.remove(Long.valueOf(paramTroopMsgData.b));
      l1 = paramTroopMsgData.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().d(l1);
      g(131089);
      return true;
    }
    return false;
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt)
  {
    return (paramCharSequence.charAt(paramInt) == '$') || (paramCharSequence.charAt(paramInt) == 65509) || (paramCharSequence.charAt(paramInt) == '¥') || (paramCharSequence.charAt(paramInt) == 65284);
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return (paramInt2 == 1) && (a(paramCharSequence, paramInt1)) && (!this.jdField_o_of_type_Boolean) && (!((QWalletAIOLifeCycleHelper)a(27)).jdField_a_of_type_Boolean);
  }
  
  private boolean a(List<ChatMessage> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return (paramBoolean1) && (!this.G) && (!paramBoolean2) && (paramInt > 1) && (paramList.size() >= paramInt);
  }
  
  private long[] a(Set<Long> paramSet)
  {
    long[] arrayOfLong = null;
    int j = ListUtils.a(paramSet);
    if (j > 0)
    {
      arrayOfLong = new long[j];
      paramSet = paramSet.iterator();
      j = 0;
      while (paramSet.hasNext())
      {
        arrayOfLong[j] = ((Long)paramSet.next()).longValue();
        j += 1;
      }
    }
    return arrayOfLong;
  }
  
  private void b(TroopInfo paramTroopInfo)
  {
    String str2 = "2";
    try
    {
      String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str1;
      if ((paramTroopInfo.troopowneruin != null) && (paramTroopInfo.troopowneruin.equals(str3))) {
        str1 = "0";
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, paramTroopInfo.troopuin, "2", str1, "");
        return;
        str1 = str2;
        if (paramTroopInfo.Administrator != null)
        {
          str1 = str2;
          if (paramTroopInfo.Administrator.contains(str3)) {
            str1 = "1";
          }
        }
      }
      return;
    }
    catch (Exception paramTroopInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onTextChanged() has an exception.", paramTroopInfo);
      }
    }
  }
  
  private void bC()
  {
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    localTroopRobotManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "off");
    localTroopRobotManager.a(null);
  }
  
  private void bD()
  {
    ((StoryManager)SuperManager.a(5)).c();
    ((UserManager)SuperManager.a(2)).d();
    ((TroopStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_STORY_MANAGER)).a();
  }
  
  private void bE()
  {
    TroopBindPublicAccountMgr localTroopBindPublicAccountMgr = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
    localTroopBindPublicAccountMgr.e("");
    if (localTroopBindPublicAccountMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      localTroopBindPublicAccountMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void bF()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b(false);
    }
  }
  
  private void bG()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.e();
    }
  }
  
  private void bH()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.b();
    }
  }
  
  private void bI()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController.b();
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController = null;
    }
  }
  
  private void bJ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a();
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar = null;
    }
  }
  
  private void bK()
  {
    TroopGiftMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.dismiss();
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer = null;
    }
  }
  
  private void bL()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView = null;
    }
  }
  
  private void bM()
  {
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = null;
    }
    AnonymousChatHelper.a().b();
    if (this.P) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167091), true);
    }
  }
  
  private void bN()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
          {
            this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
            this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_b_of_type_JavaLangString, 2, "doOnDestroy unregisterReceiver, e:" + localException1.getMessage());
          }
        }
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(this.jdField_b_of_type_JavaLangString, 2, "doOnDestroy mConfessReceiver unregisterReceiver, e:" + localException2.getMessage());
      }
    }
  }
  
  private void bO()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null))
    {
      if (Build.VERSION.SDK_INT >= 16) {
        break label42;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      return;
      label42:
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  private void bP()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  private void bQ()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label33;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
    }
    for (;;)
    {
      TroopConfessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      return;
      label33:
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
  }
  
  private void bR()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    int j;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label102;
      }
      j = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, j + "", "", "");
      return;
      label102:
      if (localTroopInfo.isAdmin()) {
        j = 1;
      } else {
        j = 2;
      }
    }
  }
  
  private void bS()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).o(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      new SoLibraryChecker(this.jdField_a_of_type_AndroidContentContext, "3171", "libWXVoice.so", "WXVoice").a();
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new TroopChatPie.3(this);
      }
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      HomeworkTroopController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "register homework receiver exception.");
      }
    }
  }
  
  private void bT()
  {
    if ((TroopConfessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true)) && (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)) {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new TroopChatPie.4(this);
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "register mConfessReceiver receiver exception.");
    }
  }
  
  private void bU()
  {
    Object localObject;
    if (this.jdField_n_of_type_Int == 2)
    {
      localObject = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844119);
      ((AnimationDrawable)localObject).setOneShot(true);
      ((AnimationDrawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      ((AnimationDrawable)localObject).start();
      this.ai = true;
      return;
    }
    if (this.jdField_n_of_type_Int == 3)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844120);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    if (this.jdField_n_of_type_Int == 4)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844120);
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
    if (this.jdField_n_of_type_Int == 5)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844120);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(3, new Object[] { Integer.valueOf(this.jdField_n_of_type_Int) });
  }
  
  private void bV()
  {
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131719900)).setMessage(2131697554);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131697552, new TroopChatPie.16(this));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton("", null);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void bW()
  {
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131719900)).setMessage(2131697555);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691314), new TroopChatPie.17(this));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131715130), new TroopChatPie.18(this));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButtonContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691314));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButtonContentDescription(HardCodeUtil.a(2131715128));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void bX()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopAioappGroupAppsObserver = new TroopChatPie.22(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAioappGroupAppsObserver);
  }
  
  private void bY()
  {
    if (!ChatPieTipsBarHelper.a(this)) {
      v(1);
    }
    this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()))
    {
      ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
      a(-16777216, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378232).setVisibility(8);
      AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130843884);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label459;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843904);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
    }
    for (;;)
    {
      if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        this.jdField_a_of_type_JavaLangCharSequence = this.jdField_f_of_type_AndroidWidgetTextView.getText();
      }
      by();
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690093) + AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
      b(true);
      Object localObject = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
      if (localObject != null) {
        ((PlusPanel)localObject).a(true);
      }
      localObject = (AIOEmoticonUIHelper)a(105);
      if (localObject != null) {
        ((AIOEmoticonUIHelper)localObject).b(true);
      }
      this.jdField_n_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener = new TroopChatPie.23(this);
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(2131696035);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130843884);
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
        }
      }
      ((TogetherControlHelper)a(43)).f();
      ((ClockInEntryHelper)a(85)).a(false);
      return;
      a(-16777216, false);
      break;
      label459:
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130851151);
        this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130838093);
      }
    }
  }
  
  private void bZ()
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130846481));
    }
    for (;;)
    {
      SimpleUIUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.mSystemBarComp, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
      return;
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167091), true);
    }
  }
  
  private void c(Object paramObject)
  {
    MessageRecord localMessageRecord;
    if ((paramObject instanceof ChatMessage))
    {
      localMessageRecord = (MessageRecord)paramObject;
      this.jdField_c_of_type_Long = localMessageRecord.shmsgseq;
      if (localMessageRecord.isSendFromLocal()) {
        break label142;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == localMessageRecord.istroop) || ((UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (UinTypeUtil.b(localMessageRecord.istroop)))) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForTroopEffectPic))) {
        n(false);
      }
    }
    for (;;)
    {
      paramObject = (TroopAddFriendTipsHelper)a(28);
      if (paramObject != null) {
        paramObject.a(localMessageRecord);
      }
      paramObject = (QQGamePubAIOHelper)a(90);
      if (paramObject != null) {
        paramObject.a(localMessageRecord);
      }
      return;
      label142:
      if ((((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a().b("highFreqInteract")) && (!this.X))
      {
        this.X = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable = new TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(false);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable);
      }
    }
  }
  
  private void ca()
  {
    if ((BusinessUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (BusinessUtils.a(this.jdField_a_of_type_AndroidContentContext))) {}
    TroopManager localTroopManager;
    Intent localIntent;
    do
    {
      return;
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localIntent = new Intent();
      localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localTroopManager != null) && (localTroopManager.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString)));
    TroopUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent.getExtras(), 1, 2000);
  }
  
  private void cb()
  {
    if (this.ak) {
      return;
    }
    ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.ak = true;
  }
  
  private void cc()
  {
    ThreadManager.post(new TroopChatPie.32(this), 8, null, true);
  }
  
  private void cd()
  {
    TroopChatPie.33 local33 = new TroopChatPie.33(this);
    ThreadManager.getSubThreadHandler().post(local33);
  }
  
  private void ce()
  {
    boolean bool3 = false;
    if ((!this.ac) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {}
    for (boolean bool1 = H();; bool1 = false)
    {
      if (!bool1) {
        if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow != null) && (this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing())) {
          bool1 = true;
        }
      }
      for (;;)
      {
        Object localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
        if (localObject != null) {}
        for (boolean bool2 = ((AIOAnimationControlManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; bool2 = false)
        {
          if ((localObject != null) && (bool2) && (bool1)) {
            ((AIOAnimationControlManager)localObject).b = false;
          }
          if ((!bool1) && (bool2))
          {
            AIOAnimationControlManager.jdField_a_of_type_Boolean = true;
            n(true);
          }
          localObject = TroopListenTogetherPanel.a(this);
          if (localObject != null)
          {
            if (!bool1)
            {
              bool1 = bool3;
              if (!bool2) {}
            }
            else
            {
              bool1 = true;
            }
            ((TroopListenTogetherPanel)localObject).a(bool1);
          }
          return;
          bool1 = false;
          break;
        }
      }
    }
  }
  
  private void cf()
  {
    this.aj = false;
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilSet.clear();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
  }
  
  private void h(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras().getString("troop_uin");
    if ((!android.text.TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    String str2;
    String str1;
    do
    {
      return;
      str2 = paramIntent.getExtras().getString("member_uin");
      str1 = paramIntent.getExtras().getString("member_display_name");
      if ((!paramIntent.getExtras().getBoolean("isApollo")) || (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo == null)) {
        break;
      }
    } while ("0".equals(str2));
    paramIntent = null;
    if (!F()) {
      paramIntent = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2);
    }
    localObject = paramIntent;
    if (android.text.TextUtils.isEmpty(paramIntent)) {
      localObject = str1;
    }
    paramIntent = new StringBuilder("@").append((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.peerUin = str2;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.atNickName = paramIntent.toString();
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
    a(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo);
    int j = 0;
    int i1;
    String str3;
    if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.inputText))
    {
      i1 = 2;
      j = i1;
      if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mTextType == 0) {
          j = 6;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        i1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        str2 = "" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.actionId;
        str3 = "655_" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mPackageId;
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText)) {
          break label508;
        }
      }
    }
    label508:
    for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText)
    {
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, j, i1, new String[] { str2, str3, paramIntent, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      j = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mTextType != 1) {
        break;
      }
      j = 7;
      break;
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText))
      {
        j = 3;
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mTextType == 0)
      {
        j = 4;
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mTextType != 1) {
        break;
      }
      j = 5;
      break;
    }
    a(str2, str1, true, 4);
  }
  
  private void i(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a()) && (TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false))) {
      a().getIntent().putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    }
  }
  
  private void j(Intent paramIntent)
  {
    this.ak = false;
    String str = paramIntent.getStringExtra("uin");
    this.Z = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b(str, paramIntent);
  }
  
  private void j(String paramString)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.i = paramString;
    ThreadManager.getSubThreadHandler().post(this.jdField_e_of_type_JavaLangRunnable);
  }
  
  private void w(boolean paramBoolean)
  {
    this.R = paramBoolean;
  }
  
  private void y(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 12006: 
    case 6001: 
      do
      {
        return;
        if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_choosecancel", paramInt, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          return;
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l);
      BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
      return;
    }
    bQ();
  }
  
  private void z(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "inputing @ in TroopChatPie.");
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localTroopInfo != null)
    {
      localIntent = TroopMemberListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localTroopInfo.troopuin, 3);
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.setFlags(603979776);
      if (this.P)
      {
        localIntent.putExtra("param_chat_mode", 1);
        bool = I();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "open TroopMemberListActivity, needfilterrobot:" + bool);
        }
        if (bool) {
          localIntent.putExtra("param_filter_robot", true);
        }
        if (super.g() == 21) {
          localIntent.putExtra("param_troop_send_apollo_msg", true);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "open TroopMemberListActivity to choose @ user target.");
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 6001);
        if (paramInt != 1) {
          break label215;
        }
      }
    }
    label215:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        Intent localIntent;
        boolean bool;
        return;
        localIntent.putExtra("param_chat_mode", 0);
      }
      b(localTroopInfo);
      return;
    }
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onTextChanged(). troopInfo is null. while inputing @.  troopUin is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void B()
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localTroopManager != null) && (localTroopManager.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if ((this.P) || (this.Q)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843900);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850541, 2130850542);
    }
  }
  
  public boolean F()
  {
    return false;
  }
  
  boolean H()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {}
    boolean bool = TroopNotificationHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handleTroopNotificationMsg. hasNewGuide = " + bool);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!bool))
    {
      ThreadManager.post(new TroopChatPie.21(this), 8, null, true);
      return true;
    }
    return false;
  }
  
  public void I()
  {
    super.I();
    bA();
  }
  
  public void J()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.X = false;
    this.W = false;
    bG();
    if (this.I)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.Z) {
      cb();
    }
    ((AIOAtHelper)a(34)).a();
    bL();
    bM();
    bK();
    bE();
    x(0);
    this.l = 0;
    this.ac = false;
    this.ae = false;
    this.ag = false;
    this.af = false;
    bC();
    bD();
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
    }
    bJ();
    v(0);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = null;
    }
    cf();
    super.J();
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "doOnDestroy, timerHandler->removeCallbacksAndMessages");
      }
    }
    RobotResourcesManager.a().a();
    bI();
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    bP();
    bH();
    bN();
    TroopFileItemBuilder.jdField_a_of_type_JavaUtilHashMap.clear();
    TroopFileItemBuilder.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    TroopConfessUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    this.ai = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(null);
    }
    bF();
    bO();
  }
  
  public void N()
  {
    if (this.P) {
      bZ();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow == null) || (!this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing()))
    {
      AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (localAIOAnimationControlManager != null) {
        localAIOAnimationControlManager.c();
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a();
    }
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    super.N();
  }
  
  public void O()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    super.O();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow == null) || (!this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing()))
    {
      localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (localObject != null) {
        ((AIOAnimationControlManager)localObject).c();
      }
    }
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    Object localObject = (TroopEnterEffectManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
    ((TroopEnterEffectManager)localObject).jdField_a_of_type_Int = 0;
    ((TroopEnterEffectManager)localObject).b = 0;
    ((TroopEnterEffectManager)localObject).c = 0;
    ((TroopEnterEffectManager)localObject).d = 0;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "doOnPause, isTroopOwner =" + this.aa);
    }
  }
  
  protected void P()
  {
    super.P();
    if (this.P)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843878);
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
      a(-16777216, false);
    }
  }
  
  public void R()
  {
    super.R();
    ((BaseTroopListUI)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a()).a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController = a();
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.c();
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    TroopConfessUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.a();
  }
  
  public void S()
  {
    super.S();
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    String str = localIntent.getStringExtra("uin");
    int j = localIntent.getIntExtra("uintype", -1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != j))) {}
    for (j = 1;; j = 0)
    {
      if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b();
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
      }
      if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a.b();
        this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
      {
        TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
      }
      cf();
      return;
    }
  }
  
  public void T()
  {
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.c();
    }
    super.T();
  }
  
  public void Y()
  {
    super.Y();
    ((TogetherControlHelper)a(43)).g();
    ((ClockInEntryHelper)a(85)).a(false);
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 35)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = ((ConfessPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558631, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel;; localObject = super.a(paramInt))
    {
      if ((localObject instanceof PlusPanel)) {
        ((PlusPanel)localObject).setPagerChangedListener(new TroopChatPie.28(this));
      }
      return localObject;
    }
  }
  
  public ImageView a()
  {
    return this.jdField_h_of_type_AndroidWidgetImageView;
  }
  
  protected AIOContext a()
  {
    return new TroopAIOContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new BaseTroopScroller()).a(new TroopListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new TroopMsgLoader()).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public PanelIconLinearLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  }
  
  public TogetherWatchTroopTipsBar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherWatchTroopTipsBar;
  }
  
  public EntryModel a()
  {
    return TroopUtils.a(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public TroopEnterEffectController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController = new TroopEnterEffectController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364598));
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController;
  }
  
  public TroopInteractGiftAnimationController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController = new TroopInteractGiftAnimationController();
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController;
  }
  
  public TroopPicEffectsController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController = new TroopPicEffectsController(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController;
  }
  
  protected Boolean a()
  {
    if (this.P) {
      return new Boolean(false);
    }
    return null;
  }
  
  String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int j = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(j + 1), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  @Nullable
  List<ChatMessage> a(List<ChatMessage> paramList)
  {
    boolean bool3 = TroopMsgSameFold.a();
    int i1 = TroopMsgSameFold.a();
    int i2 = TroopMsgSameFold.b();
    boolean bool1 = false;
    if (!this.aj)
    {
      if (paramList.size() > 0)
      {
        this.jdField_d_of_type_Long = ((ChatMessage)paramList.get(paramList.size() - 1)).shmsgseq;
        this.jdField_e_of_type_Long = ((ChatMessage)paramList.get(0)).shmsgseq;
      }
      bool1 = true;
      this.aj = true;
    }
    boolean bool2;
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    if ((this.jdField_e_of_type_Long == 0L) && (this.jdField_d_of_type_Long == 0L))
    {
      bool2 = true;
      if (!a(paramList, bool3, i1, bool2)) {
        break label423;
      }
      arrayOfLong1 = a(this.jdField_a_of_type_JavaUtilSet);
      arrayOfLong2 = a(this.jdField_c_of_type_JavaUtilSet);
    }
    for (;;)
    {
      List localList1;
      try
      {
        localList1 = TroopMsgSameFold.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, i1, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, arrayOfLong1, this.jdField_b_of_type_JavaUtilSet, this.jdField_a_of_type_JavaUtilMap, arrayOfLong2, bool1);
        if ((!bool1) || (i2 <= 15) || (localList1.size() <= 1)) {
          break label446;
        }
        localObject = null;
        j = 1;
        if (j < localList1.size())
        {
          localObject = (ChatMessage)localList1.get(j);
          if (TroopMsgSameFold.d((ChatMessage)localObject)) {
            continue;
          }
        }
        if ((!TroopMsgSameFold.b((ChatMessage)localObject)) || (localList1.size() >= 15)) {
          break label446;
        }
        TroopMsgSameFold.a("find first msg is fold msg,then get more msg ", new Object[0]);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_d_of_type_Long - i2 - 1L);
        if (((List)localObject).size() > 0)
        {
          this.jdField_e_of_type_Long = ((ChatMessage)((List)localObject).get(0)).shmsgseq;
          this.jdField_d_of_type_Long = ((ChatMessage)((List)localObject).get(((List)localObject).size() - 1)).shmsgseq;
        }
        localObject = TroopMsgSameFold.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject, i1, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, arrayOfLong1, this.jdField_b_of_type_JavaUtilSet, this.jdField_a_of_type_JavaUtilMap, arrayOfLong2, false);
        paramList = (List<ChatMessage>)localObject;
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, localThrowable, new Object[0]);
        continue;
      }
      localObject = paramList;
      return localObject;
      bool2 = false;
      break;
      j += 1;
      continue;
      label423:
      List<ChatMessage> localList = paramList;
      if (paramList.size() == 0)
      {
        cf();
        this.aj = true;
        return paramList;
        label446:
        paramList = localList1;
      }
    }
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (!E())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a().e();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "onPanelChanged updateAIOPanelTip. oldPanel=", Integer.valueOf(paramInt1), ", newPanel=", Integer.valueOf(paramInt2) });
    }
    b(false);
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      by();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a();
    }
    if (paramInt1 == 35) {
      if (paramInt2 != 1) {
        break label117;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(bool);
      if (paramInt2 == 35) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.b();
      }
      super.a(paramInt1, paramInt2);
      return;
      label117:
      bool = false;
    }
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
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == 8001)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        }
      }
      else if (paramInt1 == 12005) {
        bR();
      } else if (paramInt2 == 0) {
        y(paramInt1);
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      switch (paramInt2)
      {
      }
    }
    do
    {
      return;
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690066));
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690060));
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
      Object localObject = paramString;
      if (android.text.TextUtils.isEmpty(paramString)) {
        localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131696040);
      }
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, localObject);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
      localObject = paramString;
      if (android.text.TextUtils.isEmpty(paramString)) {
        localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131696032);
      }
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, localObject);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((localObject != null) && (((TroopManager)localObject).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString)))
      {
        ((TroopManager)localObject).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
        return;
      }
    } while (android.text.TextUtils.isEmpty(paramString));
    paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, 1, 0, paramString);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog == null) {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = new QQAnonymousDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.show();
    TroopChatPie.26 local26;
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramString = this.jdField_a_of_type_MqqOsMqqHandler;
      local26 = new TroopChatPie.26(this);
      if (!AppSetting.d) {
        break label82;
      }
    }
    label82:
    for (long l1 = 3000L;; l1 = 1000L)
    {
      paramString.postDelayed(local26, l1);
      return;
    }
  }
  
  void a(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong1, paramLong2, new TroopChatPie.7(this, false));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      if ((paramLong == 1L) || (paramLong == 2L)) {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog, CreditLevelTipDialog isShowing:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
        }
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      if (paramLong == 1L)
      {
        bW();
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_banned").c("Grp_AIO").d("exp_msgbox").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }).a();
        return;
      }
      if ((paramLong == 2L) && (!paramBoolean))
      {
        bV();
        return;
      }
    } while ((paramLong != 2L) || (!paramBoolean));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131719900)).setMessage(2131697553);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131697552, new TroopChatPie.14(this));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131697551, new TroopChatPie.15(this));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void a(Intent paramIntent)
  {
    v(0);
    if ((this.P) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      v(false);
      this.jdField_m_of_type_AndroidViewView.setVisibility(8);
      this.jdField_n_of_type_AndroidViewView.setVisibility(8);
    }
    String str1;
    String str2;
    int j;
    for (;;)
    {
      if ((this.P) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690093) + AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      }
      super.a(paramIntent);
      str1 = paramIntent.getStringExtra("greetingsTitle");
      str2 = paramIntent.getStringExtra("greetingsContent");
      j = paramIntent.getIntExtra("types", 0);
      if (j == 1)
      {
        Object localObject1 = paramIntent.getStringExtra("greetingsMembers");
        if (localObject1 != null) {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            j = 0;
            for (;;)
            {
              if (j < ((JSONArray)localObject1).length())
              {
                Object localObject3 = ((JSONArray)localObject1).getString(j);
                String str3 = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3);
                localObject3 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3, str3, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
                if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject3);
                }
                j += 1;
                continue;
                if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                v(true);
                this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843878);
                this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843884);
                this.jdField_m_of_type_AndroidViewView.setVisibility(0);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.jdField_b_of_type_JavaLangString, 2, "TroopChatPie send greetings.get members failed.");
            }
          }
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      if (!android.text.TextUtils.isEmpty(str1))
      {
        localObject2 = (QWalletAIOLifeCycleHelper)a(27);
        if (localObject2 != null) {
          ((QWalletAIOLifeCycleHelper)localObject2).a("0", str2, str1);
        }
      }
      if (paramIntent.getBooleanExtra("sendGift", false)) {
        a(true, TroopGiftPanel.f);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      ((TogetherControlHelper)a(43)).g();
      ((ClockInEntryHelper)a(85)).a(false);
      return;
      if (j == 2)
      {
        localObject2 = paramIntent.getStringExtra("greetingsName");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, "@" + (String)localObject2 + " ");
      }
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int j = paramIntent.getIntExtra(AlbumConstants.jdField_h_of_type_JavaLangString, -1);
    if (((j == 2) || (j == 1)) && (b(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131378647)
    {
      if (this.jdField_n_of_type_Int == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar = new TroopOnlineMemberBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips);
        }
        this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(a().jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.b()) {}
        do
        {
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a()) {
            break;
          }
          by();
        } while (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.b == 2);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryClose").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
        this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(1);
        paramView = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        if (paramView != null) {
          paramView.s(a().jdField_a_of_type_JavaLangString);
        }
        u(true);
        if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.b == 2)
        {
          TroopReportor.a("Grp_idol", "Grp_AIO", "clk_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
          return;
        }
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryOpen").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
      }
      if (this.jdField_n_of_type_Int == 3)
      {
        ((TroopListenTogetherPanel)a(33)).b();
        return;
      }
      if (this.jdField_n_of_type_Int == 4)
      {
        ((TogetherControlHelper)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return;
      }
      if (this.jdField_n_of_type_Int == 5)
      {
        ((StudyRoomTipBarHelper)a(75)).b();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(1, new Object[] { Integer.valueOf(this.jdField_n_of_type_Int) });
      return;
    }
    ca();
  }
  
  public void a(TroopChatPie.OnListViewScrollStateListener paramOnListViewScrollStateListener)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramOnListViewScrollStateListener);
  }
  
  void a(SelfGagInfo paramSelfGagInfo)
  {
    FastImageHelper localFastImageHelper = (FastImageHelper)a(83);
    if (paramSelfGagInfo.jdField_a_of_type_Boolean) {
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (8 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && ((this.jdField_a_of_type_Int != 1) || (this.jdField_h_of_type_Int != 0)))
      {
        af();
        if (this.jdField_h_of_type_AndroidWidgetTextView != null)
        {
          QLog.d("troop_gag", 1, "fightgag.updateGagStatus_UI:" + paramSelfGagInfo.jdField_b_of_type_JavaLangString);
          this.jdField_h_of_type_AndroidWidgetTextView.setText(paramSelfGagInfo.jdField_b_of_type_JavaLangString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "updateGagStatus_UI, sendEmptyMessageDelayed-TIMER_ID:" + paramSelfGagInfo.jdField_a_of_type_Long + ", hasDestory=" + this.I);
        }
        if (!this.I)
        {
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramSelfGagInfo.jdField_a_of_type_Long * 1000L);
        }
        localFastImageHelper.a(false);
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "updateGagStatus disable fastimage,  mAllowFastImage = " + localFastImageHelper.a());
        }
      }
    }
    do
    {
      return;
      this.ab = true;
      break;
      this.ab = false;
      bi();
      localFastImageHelper.a();
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "updateGagStatus enable fastimage,  mAllowFastImage = " + localFastImageHelper.a());
  }
  
  void a(SelfGagInfo paramSelfGagInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (paramSelfGagInfo == null) {
        ThreadManager.post(new TroopChatPie.13(this, paramBoolean), 8, null, true);
      }
    }
    else {
      return;
    }
    a(paramSelfGagInfo);
  }
  
  public void a(Object paramObject)
  {
    AIOUtils.jdField_o_of_type_Boolean = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int j = ((Integer)paramObject).intValue();
    if (j == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    switch (j)
    {
    }
    for (;;)
    {
      w(j);
      super.a(paramObject);
      return;
      if (this.P)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        continue;
        if (this.P) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
        if (this.R)
        {
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_icon_clk").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString }).a();
          continue;
          if (this.P)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            continue;
            if (this.P) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            }
          }
        }
      }
    }
  }
  
  protected void a(String paramString, long paramLong, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      j = 1;
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label130;
      }
    }
    long l2;
    int i1;
    String str1;
    Object localObject;
    label130:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l2 = SystemClock.uptimeMillis();
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (j != 0) {
        break label482;
      }
      localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.c);
      if (localObject != null) {
        break label136;
      }
      return;
      j = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool1;
    if (!StringUtil.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
    }
    long l1 = ((MessageRecord)localObject).uniseq;
    PttInfoCollector.sPttSendCostRecorder.put(paramString, Long.valueOf(l2));
    if (!bool1)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      label204:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + l1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!z) {
        break label567;
      }
    }
    label567:
    for (int j = 1;; j = 2)
    {
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", j, 0, "", "", "", "8.5.5");
      z = true;
      j = a(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      ArrayList localArrayList = new ArrayList();
      String str2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      boolean bool3 = false;
      boolean bool2 = bool3;
      if (this.R)
      {
        Iterator localIterator = localArrayList.iterator();
        do
        {
          bool2 = bool3;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!localTroopRobotManager.a(((AtTroopMemberInfo)localIterator.next()).uin));
        bool2 = true;
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, str1, paramString, l1, false, paramInt2, paramRecorderParam.c, bool1, paramInt3, j, paramBoolean, paramRecorderParam.d, (Bundle)localObject, localArrayList, str2, bool2, paramInt4);
      b(paramInt1, paramInt2);
      a(0, paramString, l1);
      return;
      label482:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str1, 0, paramLong);
      l1 = paramLong;
      if (!MessageForPtt.class.isInstance(localObject)) {
        break;
      }
      ((MessageForPtt)localObject).voiceLength = QQRecorder.a(paramInt2);
      l1 = paramLong;
      if (StringUtil.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
        break;
      }
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
      l1 = paramLong;
      break;
      PttBuffer.b(paramString);
      break label204;
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "clearBAFGrayTipSP troopUin=" + paramString1);
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    paramString1 = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", paramString2, paramString1 });
    localSharedPreferences.edit().putLong(paramString1, 0L).apply();
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    if ((localTroopRobotManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localTroopRobotManager.b(paramString1)))
    {
      if (I()) {
        return;
      }
      this.jdField_f_of_type_JavaLangString = paramString1;
      localTroopRobotManager.e = paramString1;
      this.g = paramString2;
    }
    super.a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    label172:
    label236:
    do
    {
      return;
      TroopOnlineMemberManager localTroopOnlineMemberManager = (TroopOnlineMemberManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ONLINE_MEMBER_MANAGER);
      String str = localTroopOnlineMemberManager.a(paramString);
      ((TroopListenTogetherPanel)a(33)).c();
      if ((!this.P) && (!android.text.TextUtils.isEmpty(str)) && (!ChatPieTipsBarHelper.a(this)))
      {
        if (this.jdField_n_of_type_Int != 2)
        {
          v(2);
          if (paramBoolean)
          {
            if (localTroopOnlineMemberManager.a(paramString) != 3) {
              break label172;
            }
            TroopReportor.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { paramString });
          }
        }
        for (;;)
        {
          b(true);
          this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar == null) {
            break label236;
          }
          this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(paramString);
          if (!this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a()) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.d();
          t(true);
          return;
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        }
        t(false);
        return;
        t(false);
        return;
      }
    } while ((this.P) || (ChatPieTipsBarHelper.a(this)));
    b(false);
    this.jdField_f_of_type_AndroidWidgetTextView.setText("");
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
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
  
  void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = a();
    } while ((android.text.TextUtils.isEmpty(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString)) || (paramObject == null));
    for (;;)
    {
      int j;
      try
      {
        paramObject = (Object[])paramObject;
        long l1 = ((Long)paramObject[0]).longValue();
        if (Long.parseLong(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString) != l1) {
          break;
        }
        localObject1 = (TroopMemberCard)paramObject[2];
        j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
        if (j > i1) {
          break label426;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(j);
        if (!(localObject2 instanceof MessageForQQWalletTips)) {
          break label550;
        }
        localObject2 = (MessageForQQWalletTips)localObject2;
        if ((((MessageForQQWalletTips)localObject2).istroop != 1) || (localObject1 == null) || (!((MessageForQQWalletTips)localObject2).memberUin.equals(String.valueOf(((TroopMemberCard)localObject1).memberUin))) || (!((MessageForQQWalletTips)localObject2).frienduin.equals(String.valueOf(l1))) || ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER) == null)) {
          break label550;
        }
        Object localObject3 = ((TroopMemberCard)localObject1).nick;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handGetTroopMemberCard troopUin=" + ((MessageForQQWalletTips)localObject2).frienduin + ", memberUin=" + ((MessageForQQWalletTips)localObject2).memberUin + ",card=" + ((TroopMemberCard)localObject1).card + ",remark=" + ((TroopMemberCard)localObject1).remark + ",nick=" + ((TroopMemberCard)localObject1).nick + ",saveTroopMemberEx succ=" + true);
        }
        localObject3 = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, j);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handGetTroopMemberCard ref itemView=" + localObject3 + ",index=" + j);
        }
        if (localObject3 == null) {
          break label550;
        }
        localObject3 = (TextView)((View)localObject3).findViewById(2131368045);
        ((MessageForQQWalletTips)localObject2).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (TextView)localObject3);
      }
      catch (Throwable paramObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(this.jdField_b_of_type_JavaLangString, 2, "handGetTroopMemberCard e=" + paramObject);
      return;
      label426:
      if ((localObject1 == null) || (!android.text.TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(((TroopMemberCard)localObject1).memberUin)))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "handleGetTroopMemberCard. memberUin = ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a instanceof HomeworkTroopController)))
      {
        localObject1 = (HomeworkTroopController)this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a;
        if (((Boolean)paramObject[3]).booleanValue()) {
          break label545;
        }
      }
      label545:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((HomeworkTroopController)localObject1).a(paramBoolean, null, this);
        bA();
        return;
      }
      label550:
      j += 1;
    }
  }
  
  boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!this.ah)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (j > i1) {}
      for (;;)
      {
        bool2 = bool1;
        if (j < i1) {
          break label197;
        }
        bool2 = bool1;
        if (j > i2) {
          break label197;
        }
        try
        {
          Object localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(j);
          if ((localObject == null) || (((ChatMessage)localObject).msgtype != -1012)) {
            break;
          }
          localObject = ((ChatMessage)localObject).getExtInfoFromExtStr("troop_new_member_uin");
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "isNewMemberGrayTipVisible newMemberUin = " + (String)localObject + ",detect memberUin = " + paramString);
          }
          if (android.text.TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          bool2 = ((String)localObject).equals(paramString);
          if (!bool2) {
            break;
          }
          bool1 = true;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          for (;;)
          {
            localIndexOutOfBoundsException.printStackTrace();
          }
        }
        j += 1;
        continue;
        j = i1;
      }
    }
    label197:
    return bool2;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewViewGroup == null)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "mAIORootView == null");
      ChatFragment localChatFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment();
      if (localChatFragment != null) {
        this.jdField_c_of_type_AndroidViewViewGroup = localChatFragment.a;
      }
    }
    super.a(paramBoolean);
    x(1);
    RobotResourcesManager.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport = new TroopUsingTimeReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    TroopAbilityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), true);
    return true;
  }
  
  public void aO()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  protected void aT()
  {
    super.aT();
    by();
  }
  
  protected void ae()
  {
    bk();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      if (localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
        a(0L, 0L);
      }
      if (QVipBigTroopExpiredProcessor.c().mIsEnable)
      {
        localObject = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        if (!localTroopManager.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label333;
        }
        ((SVIPHandler)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        QLog.e("vip_pretty.", 1, "get the troop expired info from server");
      }
    }
    if ((localTroopInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "aio onShow:" + localTroopInfo.troopuin + ", sysFlag=" + localTroopInfo.cGroupRankSysFlag + ", userFlag=" + localTroopInfo.cGroupRankUserFlag + ",newUserFlag=" + localTroopInfo.cNewGroupRankUserFlag);
    }
    super.ae();
    if (this.U == true)
    {
      ThreadManager.post(new TroopChatPie.5(this), 1, null, true);
      this.U = false;
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("forward_type")) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(((Bundle)localObject).getString("uin")))) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new TroopChatPie.6(this, bool), 8, null, true);
      a(localTroopManager, localTroopInfo);
      return;
      label333:
      if (QLog.isColorLevel()) {
        QLog.d("vip_pretty.", 1, "get the troop expired info from local");
      }
      TroopManager.a(localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
      break;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    paramEditable = (QWalletAIOLifeCycleHelper)a(27);
    if (paramEditable != null) {
      paramEditable.b();
    }
  }
  
  public void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopMsgObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPieInnerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPieInnerBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    bX();
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopMsgObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPieInnerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPieInnerBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAioappGroupAppsObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void ao()
  {
    if (b(true)) {
      return;
    }
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    boolean bool2 = localTroopRobotManager.a();
    Object localObject = localTroopRobotManager.jdField_b_of_type_JavaLangString;
    String str1 = localTroopRobotManager.c;
    this.T = true;
    ArrayList localArrayList = new ArrayList();
    String str2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    int j = 0;
    label198:
    boolean bool3;
    if (j < localArrayList.size())
    {
      AtTroopMemberInfo localAtTroopMemberInfo = (AtTroopMemberInfo)localArrayList.get(j);
      if (localTroopRobotManager.a(localAtTroopMemberInfo.uin))
      {
        localObject = "" + localAtTroopMemberInfo.uin;
        str1 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
        if ((bool2) || (localTroopRobotManager.a(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          bool1 = true;
          bool3 = localTroopRobotManager.b(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          bool2 = bool1;
        }
      }
    }
    for (boolean bool1 = bool3;; bool1 = false)
    {
      super.ao();
      if ((bool2) && (!bool1))
      {
        localObject = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
        a(localTroopRobotManager.jdField_b_of_type_JavaLangString, localTroopRobotManager.c, true, 0);
      }
      for (;;)
      {
        this.T = false;
        return;
        bool1 = false;
        break label198;
        j += 1;
        break;
        TroopPobingItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((str2 == null) || (str2.length() <= 3478)) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        }
        if (this.R)
        {
          w(false);
          localObject = (TroopRobotHelper)a(23);
          if (localObject != null) {
            ((TroopRobotHelper)localObject).a(false);
          }
        }
        this.S = false;
        localTroopRobotManager.a();
      }
    }
  }
  
  public void ap()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "clickSendTextButton. isSending:" + this.T);
    }
    if (!this.T) {
      this.T = true;
    }
    for (int j = 1;; j = 0)
    {
      super.ap();
      if (j == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "clickSendTextButton process talking state");
      }
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      boolean bool2 = localTroopRobotManager.a();
      Object localObject = localTroopRobotManager.jdField_b_of_type_JavaLangString;
      String str1 = localTroopRobotManager.c;
      ArrayList localArrayList = new ArrayList();
      String str2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      j = 0;
      label261:
      boolean bool3;
      if (j < localArrayList.size())
      {
        AtTroopMemberInfo localAtTroopMemberInfo = (AtTroopMemberInfo)localArrayList.get(j);
        if (localTroopRobotManager.a(localAtTroopMemberInfo.uin))
        {
          localObject = "" + localAtTroopMemberInfo.uin;
          str1 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
          if ((bool2) || (localTroopRobotManager.a(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            bool1 = true;
            bool3 = localTroopRobotManager.b(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            bool2 = bool1;
          }
        }
      }
      for (boolean bool1 = bool3;; bool1 = false)
      {
        if ((bool2) && (!bool1))
        {
          localObject = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
          a(localTroopRobotManager.jdField_b_of_type_JavaLangString, localTroopRobotManager.c, true, 0);
        }
        for (;;)
        {
          this.T = false;
          return;
          bool1 = false;
          break label261;
          j += 1;
          break;
          TroopPobingItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((str2 == null) || (str2.length() <= 3478)) {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
          }
          if (this.R)
          {
            w(false);
            localObject = (TroopRobotHelper)a(23);
            if (localObject != null) {
              ((TroopRobotHelper)localObject).a(false);
            }
          }
          this.S = false;
          localTroopRobotManager.a();
        }
      }
    }
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
    return this.jdField_d_of_type_AndroidWidgetRelativeLayout;
  }
  
  public TipsManager b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    bo();
  }
  
  void b(List<oidb_0x899.memberlist> paramList)
  {
    ThreadManager.post(new TroopChatPie.10(this, paramList), 8, null, true);
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.ab)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697388, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      af();
      bool = true;
    }
    return bool;
  }
  
  void bA()
  {
    if (y()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar = new HomeworkTroopSurveyBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
  }
  
  public void bB()
  {
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Object localObject = (TroopListenTogetherPanel)a(33);
    boolean bool1 = ((TroopListenTogetherPanel)localObject).c();
    boolean bool2 = ((TroopListenTogetherPanel)localObject).d();
    TogetherControlHelper localTogetherControlHelper = (TogetherControlHelper)a(43);
    boolean bool4 = localTogetherControlHelper.c();
    StudyRoomTipBarHelper localStudyRoomTipBarHelper = (StudyRoomTipBarHelper)a(75);
    boolean bool3 = localStudyRoomTipBarHelper.d();
    IliveGroupTipsBarHelper localIliveGroupTipsBarHelper = (IliveGroupTipsBarHelper)a(81);
    boolean bool5 = localIliveGroupTipsBarHelper.d();
    int j;
    if (bool1)
    {
      v(3);
      b(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(((TroopListenTogetherPanel)localObject).a(bool2));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
      u(bool2);
      j = AIOUtils.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
      BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, j, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
    }
    for (;;)
    {
      localIliveGroupTipsBarHelper.b();
      if ((!QLog.isColorLevel()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("BaseListenTogetherPanel_Troop", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
      return;
      if (bool4)
      {
        bool3 = localTogetherControlHelper.a();
        v(4);
        b(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(localTogetherControlHelper.a());
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
        u(bool3);
        j = AIOUtils.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, j, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
      }
      else if (bool3)
      {
        v(5);
        b(true);
        bool4 = localStudyRoomTipBarHelper.a();
        this.jdField_f_of_type_AndroidWidgetTextView.setText(localStudyRoomTipBarHelper.a(bool4));
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
        u(bool4);
        j = AIOUtils.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, j, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
        if (QLog.isColorLevel()) {
          QLog.d("StudyRoomTipBarHelper", 2, "onSubTitleChanged. showStudyRoomTime=" + bool3 + ",isTipsShow=" + bool4);
        }
      }
      else
      {
        if (!bool5) {
          break label498;
        }
        a(localIliveGroupTipsBarHelper, bool5);
      }
    }
    label498:
    localObject = ((TroopOnlineMemberManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ONLINE_MEMBER_MANAGER)).a(a().jdField_a_of_type_JavaLangString);
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
    {
      v(2);
      b(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      t(false);
    }
    for (;;)
    {
      BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
      break;
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      v(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ((AIOAtHelper)a(34)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  protected void bf()
  {
    super.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
  }
  
  public void bj()
  {
    boolean bool = false;
    super.bj();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null)
    {
      TroopChatPie.TroopFileErrorFilterForChatActivity localTroopFileErrorFilterForChatActivity = new TroopChatPie.TroopFileErrorFilterForChatActivity(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localTroopFileErrorFilterForChatActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    b(false);
    if (this.P != AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (!this.P) {
        bool = true;
      }
      this.P = bool;
      v(this.P);
    }
    ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void bk()
  {
    super.bk();
    this.jdField_o_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    cc();
    bq();
    cd();
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localObject != null)
    {
      String str1 = ((Intent)localObject).getStringExtra("at_member_name");
      String str2 = ((Intent)localObject).getStringExtra("at_member_uin");
      int j = ((Intent)localObject).getIntExtra("at_member_source", 0);
      if ((!android.text.TextUtils.isEmpty(str1)) && (!android.text.TextUtils.isEmpty(str2))) {
        a(str2, str1, false, j);
      }
    }
    ce();
    this.ad = false;
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 500L);
    bz();
    this.ac = true;
    if ((this.Y) && (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a(true);
      this.Y = false;
    }
    localObject = (TroopEnterEffectManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
    if ((((TroopEnterEffectManager)localObject).jdField_a_of_type_Int != 0) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!SimpleUIUtil.a()))
    {
      ((TroopEnterEffectManager)localObject).a(new TroopEnterEffectController.TroopEnterEffectData(((TroopEnterEffectManager)localObject).e, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((TroopEnterEffectManager)localObject).b, ((TroopEnterEffectManager)localObject).c, ((TroopEnterEffectManager)localObject).d, ((TroopEnterEffectManager)localObject).jdField_a_of_type_Int));
      localObject = a();
      ((TroopEnterEffectController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((TroopEnterEffectController)localObject).a();
    }
  }
  
  void bn()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.post(this.jdField_c_of_type_JavaLangRunnable, 8, null, true);
    }
  }
  
  void bo()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, String.format("updateTroopHonorInteractiveIcon, troopUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
    }
    TroopHonorAIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_f_of_type_AndroidWidgetImageView, this.G);
  }
  
  public void bp()
  {
    boolean bool3 = false;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject = null;
    if (localTroopManager != null) {
      localObject = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, troopInfo==null:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    long l1;
    do
    {
      return;
      l1 = ((TroopInfo)localObject).troopCreditLevel;
      if ((l1 == 1L) || (l1 == 2L)) {
        break;
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, normal:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + l1);
    return;
    boolean bool1;
    if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
    {
      bool1 = true;
      if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) != 1L) {
        break label364;
      }
    }
    label364:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bool1) || (bool2)) {
        bool3 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + bool1 + ", " + bool2);
      }
      localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, getTroopCreditInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ((TroopHandler)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      a(l1, bool3);
      return;
      bool1 = false;
      break;
    }
  }
  
  void bq()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null) {
        break label30;
      }
    }
    label30:
    do
    {
      for (;;)
      {
        return;
        localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && ((((TroopInfo)localObject).wMemberNum == 0) || (android.text.TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)))) {
          try
          {
            long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(Long.valueOf(l1));
            ((TroopListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).b((ArrayList)localObject);
            if (QLog.isColorLevel())
            {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "getTroopInfoIfNeed, sessionInfo.curFriendUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "getTroopInfoIfNeed failed");
  }
  
  void br()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0L, 2, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, localException.toString());
    }
  }
  
  void bs()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground() != null) {
      q();
    }
    bZ();
    this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130851150);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167027));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167027));
      AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, 2130851159);
      if ((this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_f_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_f_of_type_AndroidWidgetTextView.getText().toString().startsWith(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690093))))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText("");
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
        b(false);
      }
      localObject = (TroopOnlineMemberManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ONLINE_MEMBER_MANAGER);
      String str = ((TroopOnlineMemberManager)localObject).a(a().jdField_a_of_type_JavaLangString);
      if (android.text.TextUtils.isEmpty(str)) {
        break label626;
      }
      v(2);
      if (((TroopOnlineMemberManager)localObject).a(a().jdField_a_of_type_JavaLangString) != 3) {
        break label568;
      }
      TroopReportor.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
      label304:
      b(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      t(false);
    }
    for (;;)
    {
      localObject = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
      if (localObject != null) {
        ((PlusPanel)localObject).a(false);
      }
      localObject = (AIOEmoticonUIHelper)a(105);
      if (localObject != null) {
        ((AIOEmoticonUIHelper)localObject).b(false);
      }
      this.jdField_m_of_type_AndroidViewView.setVisibility(8);
      this.jdField_n_of_type_AndroidViewView.setVisibility(8);
      AnonymousChatHelper.a().b();
      bv();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(1.0F, 0.0F, 1.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131165420));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130850300);
      }
      bt();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      ((TogetherControlHelper)a(43)).f();
      ((ClockInEntryHelper)a(85)).a(false);
      return;
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130851151);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167027));
      break;
      label568:
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
      break label304;
      label626:
      v(0);
    }
  }
  
  public void bt()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null)
    {
      CmGameMainManager localCmGameMainManager = CmGameMainManager.a();
      if (localCmGameMainManager != null) {
        localCmGameMainManager.f();
      }
    }
  }
  
  public void bu()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new TroopChatPie.24(this));
    if ((this.p != null) && (this.jdField_o_of_type_AndroidViewView != null))
    {
      this.p.startAnimation(localAlphaAnimation);
      this.jdField_o_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    }
  }
  
  public void bv()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new TroopChatPie.25(this));
    this.p.startAnimation(localAlphaAnimation);
    this.jdField_o_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void bw()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!a().isFinishing())) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void bx()
  {
    Object localObject1 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    Object localObject2;
    String str1;
    int j;
    boolean bool;
    if (((TroopRobotManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (!this.T)
      {
        localObject2 = (AtTroopMemberSpan[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(0, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString().length(), AtTroopMemberSpan.class);
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        j = 0;
        if (j >= localObject2.length) {
          break label439;
        }
        if (!((TroopRobotManager)localObject1).b(localObject2[j].a())) {
          break label247;
        }
        String str2 = localObject2[j].a();
        this.jdField_f_of_type_JavaLangString = str2;
        ((TroopRobotManager)localObject1).e = str2;
        this.g = localObject2[j].b();
        if (!this.g.startsWith("@")) {
          break label434;
        }
        this.g = this.g.substring(1);
        bool = true;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a().equals(this.jdField_f_of_type_JavaLangString))) {
        bool = false;
      }
      for (;;)
      {
        ((SimpleUIAIOHelper)a(29)).d(bool);
        if (this.S == bool) {
          if (bool)
          {
            localObject1 = (TroopRobotHelper)a(23);
            if (localObject1 != null) {
              ((TroopRobotHelper)localObject1).a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
            }
          }
        }
        label247:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                j += 1;
                break;
                this.S = bool;
                if (bool) {
                  break label364;
                }
                w(false);
                localObject2 = (TroopRobotHelper)a(23);
                if (localObject2 != null) {
                  ((TroopRobotHelper)localObject2).a(false);
                }
              } while (!((TroopRobotManager)localObject1).a());
              ((TroopRobotManager)localObject1).a();
              TroopRobotManager.a("panel", "talk_out", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(), "2", "");
              ((TroopRobotManager)localObject1).b(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), Long.parseLong(this.jdField_f_of_type_JavaLangString), "off", new TroopChatPie.29(this));
              return;
            } while (this.R);
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(str1, this.jdField_f_of_type_JavaLangString, this.g, this, new TroopChatPie.30(this));
            return;
          } while (!this.R);
          w(false);
          localObject1 = (TroopRobotHelper)a(23);
        } while (localObject1 == null);
        label364:
        ((TroopRobotHelper)localObject1).a(false);
        return;
      }
      label434:
      bool = true;
      continue;
      label439:
      bool = false;
    }
  }
  
  void by()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a() == 2)
      {
        b(false);
        v(0);
      }
    }
    else {
      return;
    }
    u(false);
  }
  
  protected void bz()
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView == null) {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365891));
    }
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (((TroopInfo)localObject).wMemberNumClient <= 0))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        if (localObject != null) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showNewTroopMemberCount count smaller than 0" + ((TroopInfo)localObject).wMemberNumClient);
        }
      }
      else {
        return;
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showNewTroopMemberCount info is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showNewTroopMemberCount wMemberNumClient:" + ((TroopInfo)localObject).wMemberNumClient + "  wMemberNum:" + ((TroopInfo)localObject).wMemberNum + " troopUin:" + ((TroopInfo)localObject).troopuin);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject).wMemberNumClient) }));
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (this.jdField_k_of_type_Boolean) {
          break label285;
        }
      }
    }
    label285:
    for (boolean bool = true;; bool = false)
    {
      ((NavBarAIO)localObject).a(bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      return;
    }
  }
  
  public ViewGroup c()
  {
    return this.jdField_b_of_type_AndroidViewViewGroup;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "TroopChatPie";
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    if (paramInt2 == 8) {
      if (!this.P) {}
    }
    for (;;)
    {
      if ((paramInt2 == 2) && (this.P)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(0);
      }
      return;
      if (!this.P) {}
    }
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    aO();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
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
    this.l = 2;
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.P) {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843904);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130851151);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130851150);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167027));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167027));
        return;
      }
    } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130851151);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167027));
  }
  
  public void e(boolean paramBoolean)
  {
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    if (this.Z) {
      cb();
    }
    super.e(paramBoolean);
  }
  
  public boolean g()
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.c();
    }
    if (this.Z) {
      cb();
    }
    return super.g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject;
    int j;
    long l1;
    long l2;
    long l3;
    while ((paramMessage.what == 60) && (this.P))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843878);
      return true;
      if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow != null) && (this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing())) {
        this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.dismiss();
      }
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = new TroopNewGuidePopWindow(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = new int[2];
      this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject);
      j = a();
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationInWindow(arrayOfInt);
      int i1 = arrayOfInt[1];
      int i2 = localObject[1];
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.a(j, i1 - i2);
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.a(paramMessage.arg1);
      continue;
      localObject = (List)paramMessage.obj;
      if (localObject != null)
      {
        l1 = ((Long)((List)localObject).get(0)).longValue();
        l2 = ((Long)((List)localObject).get(1)).longValue();
        l3 = ((Long)((List)localObject).get(2)).longValue();
      }
    }
    for (;;)
    {
      long l4;
      long l5;
      try
      {
        l4 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        l5 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if (l4 != l1) {
          break label384;
        }
        if (l2 == l5) {
          break label524;
        }
        if (l3 != l5) {
          break label384;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e(".troop.chat_pie_msg", 1, "MSG_TROOP_ADMIN_OPERATION_NOTIFY: groupUin error", localNumberFormatException);
      }
      if (j != 0)
      {
        localObject = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: will reload plusPanel, groupUin:", Long.valueOf(l1) });
          }
          ((PlusPanel)localObject).a();
          break;
          break;
          label384:
          j = 0;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: should reload plusPanel, but mPlusPanel == null, groupUin:", Long.valueOf(l1) });
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition not match: group:", Long.valueOf(l1), "/", Long.valueOf(l4), " uin1/uin2/current: ", Long.valueOf(l2), "/", Long.valueOf(l3), "/", Long.valueOf(l5) });
      break;
      return super.handleMessage(paramMessage);
      label524:
      j = 1;
    }
  }
  
  public void i(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_h_of_type_Int = paramInt;
      if (!this.ab) {
        break label135;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      QQAudioUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), false);
      b(true);
    }
    label135:
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711686);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  public void i(String paramString)
  {
    if (a().isFinishing()) {}
    do
    {
      return;
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), a().getTitleBarHeight());
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    } while ((a().isFinishing()) || (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected void j()
  {
    super.j();
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
    this.U = true;
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController$AIOTipsListener);
    }
    ThreadManager.post(new TroopChatPie.CheckGlamourPicturesRunnable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity), 2, null, true);
    localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    int j;
    if (((TroopManager)localObject).n(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        if (!((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label288;
        }
        j = 1;
      }
    }
    for (;;)
    {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_AIO").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(j) }).a();
      if (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)
      {
        this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new TroopChatPie.InputOnGlobalLayoutListener(this, null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      cf();
      return;
      label288:
      if (((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        j = 2;
      } else {
        j = 3;
      }
    }
  }
  
  protected void k()
  {
    super.k();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d()) && ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b() == 17) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b() == 100) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b() == 11))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar = new TroopAssistTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.jdField_a_of_type_AndroidWidgetToast);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherWatchTroopTipsBar = new TogetherWatchTroopTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherWatchTroopTipsBar);
    AVGameHelper localAVGameHelper = (AVGameHelper)a(71);
    if (localAVGameHelper != null) {
      localAVGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
    }
    ((StudyRoomTipBarHelper)a(75)).a();
  }
  
  public void m(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "troopUin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject3 = null;
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "avType : " + ((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Int);
        }
        if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Int != 2) {
          break label741;
        }
        if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
        }
      }
      else
      {
        ((TroopListUI)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a()).g();
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          break label853;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView = new TroopChatPie.2(this, this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setScrollbarFadingEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalScrollBarEnabled(false);
        this.jdField_m_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        localObject1 = new RelativeLayout.LayoutParams(-1, this.jdField_m_of_type_Int);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, -1, this.jdField_m_of_type_Int);
        localObject1 = (TroopEnterEffectManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
        this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController = a();
        ((TroopEnterEffectManager)localObject1).jdField_a_of_type_Int = 0;
        ((TroopEnterEffectManager)localObject1).b = 0;
        ((TroopEnterEffectManager)localObject1).c = 0;
        ((TroopEnterEffectManager)localObject1).d = 0;
        if (!SimpleUIUtil.a()) {
          ((TroopEnterEffectManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager = ((TroopClassControllerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER));
        }
        if (localObject1 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a(((TroopInfo)localObject1).dwGroupClassExt, true, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          this.aa = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equalsIgnoreCase(((TroopInfo)localObject1).troopowneruin);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doOnPause, isTroopOwner =" + this.aa + ",troopInfo = " + localObject1);
        }
        bT();
        bS();
        localObject1 = (TogetherEntryBean)QConfigManager.a().a(553);
        if ((localObject1 != null) && (!((TogetherEntryBean)localObject1).jdField_a_of_type_Boolean))
        {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
        }
        bA();
        localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
        this.Z = ((Intent)localObject1).getBooleanExtra("open_chat_from_group_rec_confess", false);
        if (this.Z)
        {
          j((Intent)localObject1);
          j(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_k_of_type_Boolean = this.Z;
        t(false);
        super.m(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        label853:
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onShowFirst : invalid uin!");
          localObject2 = localObject3;
          continue;
          ReportController.b(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
          continue;
          label741:
          if (((AVNotifyCenter.VideoRoomInfo_tips)localObject2).jdField_a_of_type_Int == 10)
          {
            if (((AVNotifyCenter.VideoRoomInfo_tips)localObject2).jdField_a_of_type_Boolean) {
              ReportController.b(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
              break;
              ReportController.b(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
            }
            this.jdField_m_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).height = this.jdField_m_of_type_Int;
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
            this.jdField_a_of_type_AndroidWidgetScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
            this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, -1, this.jdField_m_of_type_Int);
          }
        }
      }
    }
  }
  
  public void m(boolean paramBoolean)
  {
    if (SharedPreUtils.m(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      a(paramBoolean, TroopGiftPanel.f);
      SharedPreUtils.k(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      return;
    }
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131367663) && (b(true))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      if (paramView.getId() == 2131371967)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a())) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        }
      }
      else if (paramView.getId() == 2131371965) {
        by();
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a().a(paramInt, 500L);
    }
    if (paramInt == 2) {
      by();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "scrollState = " + paramInt);
    }
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ah = bool;
      paramAbsListView = this.jdField_b_of_type_JavaUtilList.iterator();
      while (paramAbsListView.hasNext()) {
        ((TroopChatPie.OnListViewScrollStateListener)paramAbsListView.next()).a(this.ah);
      }
    }
    if ((paramInt == 0) && (this.jdField_h_of_type_JavaLangString != null))
    {
      paramAbsListView = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
      this.jdField_h_of_type_JavaLangString = null;
      paramAbsListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentWidgetPatchedButton, paramCharSequence, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l = true;
      z(1);
    }
    TroopManager localTroopManager;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onTextChanged:  start=" + paramInt1 + " before=" + paramInt2 + " count=" + paramInt3);
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() == 0));
      if (!a(paramCharSequence, paramInt1, paramInt3)) {
        break;
      }
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    } while (localTroopManager.n(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt2 >= paramCharSequence.length()) {
        break label195;
      }
      if ((paramInt2 != paramInt1) && (a(paramCharSequence, paramInt2))) {
        break;
      }
      paramInt2 += 1;
    }
    label195:
    a(localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    return;
    if ((!this.jdField_o_of_type_Boolean) && (!((QWalletAIOLifeCycleHelper)a(27)).jdField_a_of_type_Boolean)) {
      ((AIOAtHelper)a(34)).b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    bx();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a()))
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_gift_panel", false);
    }
    if (paramView.getId() == 2131370460) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  protected void r(int paramInt)
  {
    if (!this.P) {
      super.r(paramInt);
    }
  }
  
  public void s()
  {
    super.s();
    TroopConfessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  void t(boolean paramBoolean)
  {
    if ((!this.ai) && (!paramBoolean) && (this.jdField_n_of_type_Int == 2)) {
      u(false);
    }
  }
  
  public void u(boolean paramBoolean)
  {
    Object localObject = (LinearLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetImageView.getLayoutParams();
    this.jdField_h_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    try
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      int j;
      if (paramBoolean)
      {
        j = 2130844113;
        localObject = ((Resources)localObject).getDrawable(j);
        if ((!SimpleUIUtil.a()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label185;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030), PorterDuff.Mode.MULTIPLY);
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label217;
        }
        Drawable localDrawable = this.jdField_h_of_type_AndroidWidgetImageView.getDrawable();
        if ((localDrawable instanceof AnimationDrawable)) {
          ((AnimationDrawable)localDrawable).stop();
        }
        ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
        j = 2130844120;
        break;
        label185:
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          ((Drawable)localObject).clearColorFilter();
        } else {
          ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        }
      }
      label217:
      if ((Build.VERSION.SDK_INT < 21) || (this.ai))
      {
        ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      bU();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "update");
    }
    if (paramObject == null) {
      break label27;
    }
    label27:
    label223:
    for (;;)
    {
      return;
      if ((!(paramObject instanceof TroopMsgData)) || (!a((TroopMsgData)paramObject)))
      {
        if ((paramObject instanceof MessageRecord)) {
          c(paramObject);
        }
        for (;;)
        {
          if (!(paramObject instanceof MessageForText)) {
            break label223;
          }
          paramObservable = (MessageForText)paramObject;
          if (!paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TroopChatPie.update()");
          }
          AioVipKeywordHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
          return;
          if ((paramObject instanceof Integer)) {
            switch (((Integer)paramObject).intValue())
            {
            case 123321: 
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
        }
      }
    }
  }
  
  protected void v()
  {
    aO();
    ((TogetherControlHelper)a(43)).g();
    ((ClockInEntryHelper)a(85)).a(false);
  }
  
  public void v(int paramInt)
  {
    this.jdField_n_of_type_Int = paramInt;
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "changeSubTitleType, not init ui");
      }
      return;
    }
    if (paramInt == 3)
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(2, new Object[] { Integer.valueOf(paramInt) });
      return;
      if (paramInt == 4)
      {
        if (((TogetherControlHelper)a(43)).d()) {
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
          break;
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      if (paramInt == 2)
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
    }
  }
  
  public void v(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setHelperProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this, new UpdateParams.Builder().a(true).a());
    }
    ((SimpleUIAIOHelper)a(29)).c(paramBoolean);
    this.P = paramBoolean;
    AnonymousChatHelper.a().a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) || (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_anonyous", paramBoolean);
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_m_of_type_AndroidViewView == null)
    {
      this.jdField_m_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_m_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_m_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(12, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_m_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.p == null)
    {
      this.p = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.p.setBackgroundResource(2130843884);
      this.p.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.p.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.p, 0);
    }
    if (this.jdField_o_of_type_AndroidViewView == null)
    {
      this.jdField_o_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_o_of_type_AndroidViewView.setBackgroundResource(2130843884);
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_o_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_o_of_type_AndroidViewView, 0);
    }
    if (this.jdField_n_of_type_AndroidViewView == null)
    {
      this.jdField_n_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_n_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_n_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(2, 2131369142);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_n_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(paramBoolean);
    }
    if (paramBoolean)
    {
      bY();
      ((TroopAskAnonymouslyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(97)).c();
    }
    for (;;)
    {
      B();
      v();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      return;
      bs();
    }
  }
  
  void w(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOshortcut", "Clk_shortcut", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, "", "");
      }
      return;
      localObject1 = "1";
      continue;
      localObject1 = "2";
      continue;
      localObject1 = "3";
      continue;
      localObject1 = "4";
      continue;
      localObject1 = "5";
      continue;
      localObject1 = "7";
    }
  }
  
  public void x(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt, 0);
    }
  }
  
  protected void y()
  {
    aY();
  }
  
  public void z()
  {
    Object localObject1;
    Object localObject2;
    int j;
    if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 == null) {
        break label196;
      }
      localObject1 = ((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label196;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((android.text.TextUtils.isEmpty((CharSequence)localObject2)) || (android.text.TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))) {
        break label196;
      }
      if ((!((String)localObject2).equals(((TroopInfo)localObject1).Administrator)) && (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
        break label184;
      }
      j = 1;
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (j != 0) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
        VasWebviewUtil.reportCommercialDrainage("", "style", "0X8008E61", "", 1, 0, 0, "", "", "");
        ca();
        return;
        label184:
        j = 0;
        break;
      }
      label196:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */