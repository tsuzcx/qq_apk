package com.tencent.mobileqq.activity.aio.core;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
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
import com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper;
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
import com.tencent.mobileqq.troop.utils.GetOnlineMemberTipsRunnable;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troop.utils.TroopMsgData;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
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
  UpgradeBigTroopTipsBar bA;
  public BigTroopExpiredTipsBar bB;
  protected QQCustomDialog bC;
  boolean bD = false;
  protected int bE = 0;
  public TroopNewGuidePopWindow bF = null;
  public LinearLayout bG;
  public ScrollView bH;
  public int bI;
  protected TroopOnlineMemberBar bJ;
  protected int bK = 0;
  protected TroopUsingTimeReport bL;
  String bM;
  boolean bN;
  boolean bO;
  public volatile long bP;
  TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable bQ;
  boolean bR = false;
  BroadcastReceiver bS;
  protected ConfessPanel bT;
  Runnable bU = new TroopChatPie.1(this);
  boolean bV = false;
  SVIPObserver bW = new TroopChatPie.9(this);
  Handler bX = new TroopChatPie.10(this, Looper.getMainLooper());
  protected boolean bY = false;
  TroopFileError.TroopFileErrorObserver bZ;
  FloatView br;
  Runnable bs;
  Handler bt;
  View bu;
  View bv;
  View bw;
  View bx;
  public QQAnonymousDialog by;
  AnonymousChatHelper.AnonymousStatusListener bz;
  private final RoamSettingObserver cA = new TroopChatPie.8(this);
  private GroupAppsObserver cB;
  private boolean cC = false;
  private ViewTreeObserver.OnGlobalLayoutListener cD;
  BizTroopObserver ca = new TroopChatPie.17(this);
  TroopModifyObserver cb = new TroopChatPie.18(this);
  TroopQZoneUploadAlbumObserver cc = new TroopChatPie.19(this);
  int cd = 0;
  boolean ce = false;
  boolean cf = true;
  Toast cg = null;
  boolean ch = false;
  boolean ci = false;
  boolean cj = false;
  public boolean ck = false;
  Runnable cl = new GetOnlineMemberTipsRunnable(this);
  protected List<TroopChatPie.OnListViewScrollStateListener> cm = new ArrayList(5);
  String cn;
  Runnable co = new TroopChatPie.25(this);
  TeamWorkObserver cp = new TroopChatPie.28(this);
  AIOTipsController.AIOTipsListener cq = new TroopChatPie.29(this);
  private boolean cr = false;
  private long cs;
  private long ct;
  private boolean cu;
  private Set<Long> cv = new HashSet();
  private Set<Long> cw = new HashSet();
  private Map<Long, Long> cx = new HashMap();
  private Set<Long> cy = new HashSet();
  private TroopMsgObserver cz = new TroopMsgObserver(this);
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
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
                localObject = this.bT;
                if (localObject != null) {
                  ((ConfessPanel)localObject).a(paramInt, paramIntent);
                }
              }
              else
              {
                paramIntent = paramIntent.getStringExtra("result");
                localObject = ((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.ah.b);
                if ((!android.text.TextUtils.isEmpty(paramIntent)) && (localObject != null) && (!paramIntent.equals(((TroopInfo)localObject).troopname)))
                {
                  ((ITroopModifyHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_MODIFY_HANDLER)).a(this.ah.b, paramIntent, false);
                  this.ah.e = paramIntent;
                  localObject = this.f.getIntent();
                  ((Intent)localObject).putExtra("uinname", paramIntent);
                  c((Intent)localObject);
                }
              }
            }
            else
            {
              aw();
              paramInt = this.Y.getSelectionStart();
              if (paramInt > 0)
              {
                paramIntent = this.Y.getText();
                int i = paramInt - 1;
                int j = paramIntent.charAt(i);
                if ((j == 36) || (j == 65509) || (j == 165) || (j == 65284))
                {
                  this.i.p().d().f().w();
                  this.Y.setText(this.Y.getText().delete(i, paramInt));
                  this.i.p().d().f().v();
                  this.Y.setSelection(i);
                }
              }
            }
          }
          else {
            TroopGiftUtil.a(this.f, paramIntent, this.d);
          }
        }
        else {
          i(paramIntent);
        }
      }
    }
    else
    {
      localObject = AIOUtils.a(new Intent(this.f, SplashActivity.class), null);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      this.f.startActivity((Intent)localObject);
    }
  }
  
  private void a(TroopManager paramTroopManager, TroopInfo paramTroopInfo)
  {
    if ((!this.cj) && (paramTroopManager.c.d) && (paramTroopInfo != null) && (paramTroopInfo.isTroopOwner(this.d.getCurrentAccountUin())))
    {
      int i = paramTroopManager.D(this.ah.b);
      if ((i < 3) && (paramTroopInfo.wMemberMax < 2000) && (paramTroopInfo.wMemberNum >= 500))
      {
        if (this.bA == null)
        {
          this.bA = new UpgradeBigTroopTipsBar(this.d, this.f, this.aX);
          this.aX.b(this.bA);
        }
        this.bA.a(this.ah.b);
        if (this.aX.a(this.bA, new Object[0]))
        {
          this.cj = true;
          paramTroopManager.b(this.ah.b, i + 1);
          ReportController.b(this.d, "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.ah.b, "", "", "");
        }
      }
    }
  }
  
  private void a(IliveGroupTipsBarHelper paramIliveGroupTipsBarHelper, boolean paramBoolean)
  {
    s(6);
    b(true);
    boolean bool = paramIliveGroupTipsBarHelper.b();
    this.I.setText(paramIliveGroupTipsBarHelper.a(bool));
    SimpleModeHelper.a(this.I, this.f);
    q(bool);
    int i = AIOUtils.b(8.0F, this.I.getResources());
    BaseListenTogetherPanel.a(this.r, 0, i, 0, 0, this.aZ.getRootView());
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
    if (paramTroopMsgData.a == 1)
    {
      this.cv.remove(Long.valueOf(paramTroopMsgData.d));
      this.cw.remove(Long.valueOf(paramTroopMsgData.c));
      this.cx.remove(Long.valueOf(paramTroopMsgData.c));
      this.cy.add(Long.valueOf(paramTroopMsgData.d));
      l = paramTroopMsgData.c;
      this.j.d().d(l);
      j(131089);
      return true;
    }
    if (paramTroopMsgData.a == 2)
    {
      this.cv.add(Long.valueOf(paramTroopMsgData.d));
      this.cw.add(Long.valueOf(paramTroopMsgData.c));
      this.cx.put(Long.valueOf(paramTroopMsgData.c), Long.valueOf(paramTroopMsgData.d));
      this.cy.remove(Long.valueOf(paramTroopMsgData.d));
      l = paramTroopMsgData.c;
      this.j.d().d(l);
      j(131089);
      return true;
    }
    return false;
  }
  
  private boolean a(List<ChatMessage> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return (paramBoolean1) && (!this.aO) && (!paramBoolean2) && (paramInt > 1) && (paramList.size() >= paramInt);
  }
  
  private long[] a(Set<Long> paramSet)
  {
    int i = ListUtils.b(paramSet);
    if (i > 0)
    {
      long[] arrayOfLong = new long[i];
      i = 0;
      Iterator localIterator = paramSet.iterator();
      for (;;)
      {
        paramSet = arrayOfLong;
        if (!localIterator.hasNext()) {
          break;
        }
        arrayOfLong[i] = ((Long)localIterator.next()).longValue();
        i += 1;
      }
    }
    paramSet = null;
    return paramSet;
  }
  
  private void b(Object paramObject)
  {
    if ((paramObject instanceof ChatMessage))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramObject;
      this.bP = localMessageRecord.shmsgseq;
      if (!localMessageRecord.isSendFromLocal())
      {
        if ((this.ah.b.equals(localMessageRecord.frienduin)) && ((this.ah.a == localMessageRecord.istroop) || ((UinTypeUtil.b(this.ah.a)) && (UinTypeUtil.b(localMessageRecord.istroop)))) && (this.f.isResume()) && ((paramObject instanceof MessageForTroopEffectPic))) {
          AIOAnimationControlManager.a(this, false);
        }
      }
      else if ((((ITroopBatchAddFriendService)this.d.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().j("highFreqInteract")) && (!this.bO))
      {
        this.bO = true;
        if (this.bQ == null) {
          this.bQ = new TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable(this, this.d);
        }
        this.bQ.a(false);
        ThreadManager.getSubThreadHandler().post(this.bQ);
      }
      paramObject = (TroopAddFriendTipsHelper)q(28);
      if (paramObject != null) {
        paramObject.a(localMessageRecord);
      }
      paramObject = (QQGamePubAIOHelper)q(90);
      if (paramObject != null) {
        paramObject.b(localMessageRecord);
      }
    }
  }
  
  private void cA()
  {
    ThreadManager.post(new TroopChatPie.26(this), 8, null, true);
  }
  
  private void cB()
  {
    TroopChatPie.27 local27 = new TroopChatPie.27(this);
    ThreadManager.getSubThreadHandler().post(local27);
  }
  
  private void cC()
  {
    boolean bool1 = this.ce;
    boolean bool4 = true;
    boolean bool2;
    if ((!bool1) && (this.ah.a == 1)) {
      bool2 = ((TroopNotificationAIOHelper)q(51)).a();
    } else {
      bool2 = false;
    }
    bool1 = bool2;
    if (!bool2)
    {
      localObject = this.bF;
      if ((localObject != null) && (((TroopNewGuidePopWindow)localObject).isShowing())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    Object localObject = (AIOAnimationControlManager)this.d.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if (localObject != null) {
      bool2 = ((AIOAnimationControlManager)localObject).a(this.ah.b);
    } else {
      bool2 = false;
    }
    if ((localObject != null) && (bool2) && (bool1)) {
      ((AIOAnimationControlManager)localObject).q = false;
    }
    if ((!bool1) && (bool2))
    {
      AIOAnimationControlManager.l = true;
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
      ((TroopListenTogetherPanel)localObject).b(bool3);
    }
  }
  
  private void cD()
  {
    this.cu = false;
    this.cv.clear();
    this.cw.clear();
    this.cx.clear();
    this.cy.clear();
    this.ct = 0L;
    this.cs = 0L;
  }
  
  private void cg()
  {
    ((StoryManager)SuperManager.a(5)).c();
    ((UserManager)SuperManager.a(2)).e();
    ((TroopStoryManager)this.d.getManager(QQManagerFactory.TROOP_STORY_MANAGER)).a();
  }
  
  private void ch()
  {
    TroopBindPublicAccountMgr localTroopBindPublicAccountMgr = (TroopBindPublicAccountMgr)this.d.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
    localTroopBindPublicAccountMgr.g("");
    if (localTroopBindPublicAccountMgr.h(this.ah.b)) {
      localTroopBindPublicAccountMgr.c(this.ah.b);
    }
  }
  
  private void ci()
  {
    if (this.p != null)
    {
      this.p.b(false);
      this.p.a(false);
    }
  }
  
  private void cj()
  {
    TroopOnlineMemberBar localTroopOnlineMemberBar = this.bJ;
    if (localTroopOnlineMemberBar != null)
    {
      localTroopOnlineMemberBar.a();
      this.bJ = null;
    }
  }
  
  private void ck()
  {
    TroopNewGuidePopWindow localTroopNewGuidePopWindow = this.bF;
    if (localTroopNewGuidePopWindow != null)
    {
      localTroopNewGuidePopWindow.dismiss();
      this.bF = null;
    }
  }
  
  private void cl()
  {
    Object localObject = this.bt;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.bs);
    }
    localObject = this.br;
    if (localObject != null)
    {
      ((FloatView)localObject).setVisibility(8);
      this.br.a();
      this.br = null;
    }
  }
  
  private void cm()
  {
    QQAnonymousDialog localQQAnonymousDialog = this.by;
    if (localQQAnonymousDialog != null)
    {
      localQQAnonymousDialog.dismiss();
      this.by = null;
    }
    AnonymousChatHelper.a().c();
    if (this.bm) {
      b(this.f.getResources().getColor(2131168092), true);
    }
  }
  
  private void cn()
  {
    try
    {
      if (this.bS != null)
      {
        this.e.unregisterReceiver(this.bS);
        this.bS = null;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        String str = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDestroy mConfessReceiver unregisterReceiver, e:");
        localStringBuilder.append(localException.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  private void co()
  {
    if ((this.Y != null) && (this.cD != null))
    {
      if (Build.VERSION.SDK_INT < 16) {
        this.Y.getViewTreeObserver().removeGlobalOnLayoutListener(this.cD);
      } else {
        this.Y.getViewTreeObserver().removeOnGlobalLayoutListener(this.cD);
      }
      this.cD = null;
    }
  }
  
  private void cp()
  {
    if (this.n != null)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        this.n.a(8);
      } else {
        this.n.b();
      }
      TroopConfessUtil.a(this.d, false);
    }
  }
  
  private void cq()
  {
    Object localObject = ((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.ah.b);
    if (localObject != null)
    {
      int i;
      if (((TroopInfo)localObject).isTroopOwner(this.d.getCurrentAccountUin())) {
        i = 0;
      } else if (((TroopInfo)localObject).isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
      localObject = this.d;
      String str = this.ah.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, str, localStringBuilder.toString(), "", "");
    }
  }
  
  private void cr()
  {
    if ((TroopConfessUtil.a(this.d, this.ah.b, true)) && (this.bS == null)) {
      this.bS = new TroopChatPie.3(this);
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
      this.e.registerReceiver(this.bS, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      label66:
      break label66;
    }
    QLog.e(this.c, 1, "register mConfessReceiver receiver exception.");
  }
  
  private void cs()
  {
    int i = this.bK;
    Object localObject;
    if (i == 2)
    {
      localObject = (AnimationDrawable)this.e.getResources().getDrawable(2130844978);
      ((AnimationDrawable)localObject).setOneShot(true);
      ((AnimationDrawable)localObject).setBounds(0, 0, UIUtils.a(this.e, 10.0F), UIUtils.a(this.e, 10.0F));
      this.L.setImageDrawable((Drawable)localObject);
      ((AnimationDrawable)localObject).start();
      this.cr = true;
      return;
    }
    if (i == 3)
    {
      localObject = this.e.getResources().getDrawable(2130844979);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.e, 10.0F), UIUtils.a(this.e, 10.0F));
      this.L.setImageDrawable((Drawable)localObject);
      return;
    }
    if (i == 4)
    {
      localObject = this.e.getResources().getDrawable(2130844979);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.e, 10.0F), UIUtils.a(this.e, 10.0F));
      boolean bool = ((TogetherControlHelper)q(43)).f();
      this.L.setImageDrawable((Drawable)localObject);
      if (bool)
      {
        this.L.setVisibility(8);
        return;
      }
      this.L.setVisibility(0);
      return;
    }
    if (i == 5)
    {
      localObject = this.e.getResources().getDrawable(2130844979);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.e, 10.0F), UIUtils.a(this.e, 10.0F));
      this.L.setImageDrawable((Drawable)localObject);
      return;
    }
    this.g.a(3, new Object[] { Integer.valueOf(this.bK) });
  }
  
  private void ct()
  {
    this.bC = DialogUtil.a(this.e, 230).setTitle(this.f.getString(2131917233)).setMessage(2131895333);
    this.bC.setPositiveButton(2131895331, new TroopChatPie.14(this));
    this.bC.setNegativeButton("", null);
    this.bC.setCancelable(false);
    this.bC.show();
  }
  
  private void cu()
  {
    this.bC = DialogUtil.a(this.e, 230).setTitle(this.f.getString(2131917233)).setMessage(2131895334);
    this.bC.setPositiveButton(this.f.getString(2131888181), new TroopChatPie.15(this));
    this.bC.setNegativeButton(HardCodeUtil.a(2131898212), new TroopChatPie.16(this));
    this.bC.setPositiveButtonContentDescription(this.f.getString(2131888181));
    this.bC.setNegativeButtonContentDescription(HardCodeUtil.a(2131898212));
    this.bC.setCancelable(false);
    this.bC.show();
  }
  
  private void cv()
  {
    this.cB = new TroopChatPie.20(this);
    this.d.registObserver(this.cB);
  }
  
  private void cw()
  {
    if (!ChatPieTipsBarHelper.a(this)) {
      s(1);
    }
    this.aM.setVisibility(8);
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()))
    {
      ImmersiveUtils.setStatusTextColor(false, this.f.getWindow());
      b(-16777216, false);
    }
    else
    {
      b(-16777216, false);
    }
    this.X.getBackground().setVisible(true, false);
    this.X.findViewById(2131446058).setVisibility(8);
    AIOUtils.a(this.X, 2130844758);
    this.C.setTextColor(AnonymousChatHelper.c);
    this.B.setTextColor(AnonymousChatHelper.c);
    if (this.s.getVisibility() == 0)
    {
      this.s.setBackgroundResource(2130844778);
      this.s.setTextColor(AnonymousChatHelper.c);
      this.t.setTextColor(AnonymousChatHelper.c);
      if (SimpleModeHelper.b()) {
        SimpleModeHelper.a(this.t, ColorStateList.valueOf(AnonymousChatHelper.c));
      }
    }
    else if (this.w.getVisibility() == 0)
    {
      this.w.setBackgroundResource(2130853298);
      this.w.setPadding(0, 0, 0, 0);
      this.x.setTextColor(AnonymousChatHelper.c);
      this.x.setBackgroundResource(2130837967);
    }
    if (this.I.getVisibility() == 0) {
      this.M = this.I.getText();
    }
    bV();
    this.q.setOnClickListener(null);
    this.r.setOnClickListener(null);
    this.I.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    Object localObject = this.I;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f.getResources().getString(2131886658));
    localStringBuilder.append(AnonymousChatHelper.a().b(this.ah.b).d);
    ((TextView)localObject).setText(localStringBuilder.toString());
    this.I.setTextColor(AnonymousChatHelper.c);
    AIOUtils.a(this.u, null);
    b(true);
    localObject = (PlusPanel)this.ae.d(8);
    if (localObject != null) {
      ((PlusPanel)localObject).a(true);
    }
    localObject = (AIOEmoticonUIHelper)q(105);
    if (localObject != null) {
      ((AIOEmoticonUIHelper)localObject).c(true);
    }
    this.bv.setVisibility(0);
    this.bz = new TroopChatPie.21(this);
    AnonymousChatHelper.a().a(this.bz);
    this.aX.c();
    if (this.Y != null)
    {
      this.Y.setHint(2131893812);
      this.Y.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    if (this.W != null)
    {
      AIOUtils.a(this.W, 2130844758);
      if (this.n.getCurrentPanel() == 8) {
        this.W.setSelected(8);
      }
    }
    ((TogetherControlHelper)q(43)).m();
    ((ClockInEntryHelper)q(85)).a(false);
  }
  
  private void cx()
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      a(this.f.getResources().getDrawable(2130847834));
    } else {
      b(this.f.getResources().getColor(2131168092), true);
    }
    SimpleUIUtil.a(this.f.mSystemBarComp, this.f.getWindow());
  }
  
  private void cy()
  {
    if ((BusinessUtils.c(this.ah.b)) && (BusinessUtils.a(this.e))) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_code", this.ah.c);
    localIntent.putExtra("troop_uin", this.ah.b);
    if ((localTroopManager != null) && (localTroopManager.F(this.ah.c))) {
      return;
    }
    TroopUtils.a(this.f, localIntent.getExtras(), 1, 2000);
  }
  
  private void cz()
  {
    if (this.cC) {
      return;
    }
    ((ConfessManager)this.d.getManager(QQManagerFactory.CONFESS_MANAGER)).c(this.ah.b);
    this.cC = true;
  }
  
  private void h(String paramString)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.co);
    this.cn = paramString;
    ThreadManager.getSubThreadHandler().post(this.co);
  }
  
  private void i(Intent paramIntent)
  {
    String str1 = paramIntent.getExtras().getString("troop_uin");
    if ((!android.text.TextUtils.isEmpty(str1)) && (!str1.equalsIgnoreCase(this.ah.b))) {
      return;
    }
    String str2 = paramIntent.getExtras().getString("member_uin");
    Object localObject = paramIntent.getExtras().getString("member_display_name");
    if ((paramIntent.getExtras().getBoolean("isApollo")) && (this.aH != null))
    {
      str1 = "0";
      if ("0".equals(str2)) {
        return;
      }
      paramIntent = null;
      if (!bF()) {
        paramIntent = ContactUtils.a(this.d, this.ah.b, str2);
      }
      if (android.text.TextUtils.isEmpty(paramIntent)) {
        paramIntent = (Intent)localObject;
      }
      localObject = new StringBuilder("@");
      ((StringBuilder)localObject).append(paramIntent);
      this.aH.mAction.peerUin = str2;
      this.aH.mAction.atNickName = ((StringBuilder)localObject).toString();
      this.aH.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(this.Y.getText().toString());
      this.Y.getText().clear();
      a(this.aH);
      int i;
      if (android.text.TextUtils.isEmpty(this.aH.mAction.inputText))
      {
        if (!android.text.TextUtils.isEmpty(this.aH.mActionText))
        {
          if (this.aH.mTextType == 0)
          {
            i = 6;
            break label343;
          }
          if (this.aH.mTextType == 1)
          {
            i = 7;
            break label343;
          }
        }
        i = 2;
      }
      else if (android.text.TextUtils.isEmpty(this.aH.mActionText))
      {
        i = 3;
      }
      else if (this.aH.mTextType == 0)
      {
        i = 4;
      }
      else if (this.aH.mTextType == 1)
      {
        i = 5;
      }
      else
      {
        i = 0;
      }
      label343:
      localObject = this.d;
      str2 = this.ah.b;
      int j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.ah.a);
      paramIntent = new StringBuilder();
      paramIntent.append("");
      paramIntent.append(this.aH.mAction.actionId);
      String str3 = paramIntent.toString();
      paramIntent = new StringBuilder();
      paramIntent.append("655_");
      paramIntent.append(this.aH.mPackageId);
      String str4 = paramIntent.toString();
      if (android.text.TextUtils.isEmpty(this.aH.mActionText)) {
        paramIntent = str1;
      } else {
        paramIntent = this.aH.mActionText;
      }
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str2, i, j, new String[] { str3, str4, paramIntent, this.aH.mAction.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
    a(str2, (String)localObject, true, 4);
  }
  
  private void j(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false))) {
      aX().getIntent().putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    }
  }
  
  private void k(Intent paramIntent)
  {
    this.cC = false;
    String str = paramIntent.getStringExtra("uin");
    this.bR = ((ConfessManager)this.d.getManager(QQManagerFactory.CONFESS_MANAGER)).b(str, paramIntent);
  }
  
  private void v(int paramInt)
  {
    if (paramInt != 6001)
    {
      if (paramInt != 12006)
      {
        if (paramInt != 15002) {
          return;
        }
        cp();
        return;
      }
      if (AnonymousChatHelper.a().a(this.ah.b)) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_choosecancel", paramInt, 0, this.ah.b, "", "", "");
      return;
    }
    if (this.ah.z) {
      BaseChatpieHelper.a(this.ah, this.Y, this.Z, false);
    }
  }
  
  public void B()
  {
    if ((this.y != null) && (this.y.getVisibility() == 0))
    {
      Object localObject1 = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
      int j = 0;
      int i = j;
      if (localObject1 != null)
      {
        localObject1 = ((TroopManager)localObject1).f(this.ah.b);
        i = j;
        if (localObject1 != null)
        {
          localObject2 = this.d.getCurrentAccountUin();
          i = j;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject2))
          {
            i = j;
            if (!android.text.TextUtils.isEmpty(((TroopInfo)localObject1).Administrator)) {
              if (!((String)localObject2).equals(((TroopInfo)localObject1).Administrator))
              {
                i = j;
                if (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2)) {}
              }
              else
              {
                i = 1;
              }
            }
          }
        }
      }
      Object localObject2 = this.d;
      String str = this.ah.b;
      if (i != 0) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
    }
    VasWebviewUtil.a("", "style", "0X8008E61", "", 1, 0, 0, "", "", "");
    cy();
  }
  
  public void D()
  {
    TroopManager localTroopManager = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localTroopManager != null) && (localTroopManager.F(this.ah.b)))
    {
      this.u.setVisibility(8);
      return;
    }
    if ((!this.bm) && (!this.bn)) {
      a(this.u, 2130852263, 2130852264);
    } else {
      this.u.setImageResource(2130844774);
    }
    this.u.setVisibility(0);
  }
  
  public void K()
  {
    Object localObject = this.bQ;
    if (localObject != null) {
      ((TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable)localObject).a(true);
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.cl);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.co);
    this.bO = false;
    this.bN = false;
    if (this.aY)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.bR) {
      cz();
    }
    ((AIOAtHelper)q(34)).b();
    cl();
    cm();
    ck();
    ch();
    u(0);
    this.ce = false;
    this.ch = false;
    this.cj = false;
    this.ci = false;
    cg();
    if (!android.text.TextUtils.isEmpty(this.ah.b)) {
      FileManagerDataCenter.b(this.d, this.ah.b, this.ah.a, -4021);
    }
    cj();
    s(0);
    localObject = this.bL;
    if (localObject != null) {
      ((TroopUsingTimeReport)localObject).c();
    }
    localObject = this.bT;
    if (localObject != null)
    {
      ((ConfessPanel)localObject).a();
      this.bT = null;
    }
    cD();
    super.K();
    localObject = this.bX;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "doOnDestroy, timerHandler->removeCallbacksAndMessages");
      }
    }
    RobotResourcesManager.a().b();
    this.cm.clear();
    if (this.B != null) {
      this.B.setVisibility(8);
    }
    cn();
    TroopFileItemBuilder.D.clear();
    TroopFileItemBuilder.y.evictAll();
    TroopConfessUtil.b(this.d, false);
    localObject = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
    BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
    this.cr = false;
    this.k.d().d().a(null);
    ci();
    co();
  }
  
  public void O()
  {
    if (this.bm) {
      cx();
    }
    if (this.bZ != null)
    {
      TroopFileError.b(this.d, this.bZ);
      this.bZ = null;
    }
    Object localObject = this.bF;
    if ((localObject == null) || (!((TroopNewGuidePopWindow)localObject).isShowing()))
    {
      localObject = (AIOAnimationControlManager)this.d.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (localObject != null) {
        ((AIOAnimationControlManager)localObject).f();
      }
    }
    localObject = this.cg;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    if (RobotResourcesManager.a().d()) {
      RobotResourcesManager.a().c();
    }
    localObject = this.bQ;
    if (localObject != null) {
      ((TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable)localObject).a(true);
    }
    super.O();
  }
  
  public void P()
  {
    Object localObject = this.cg;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.cl);
    super.P();
    localObject = this.br;
    if (localObject != null) {
      ((FloatView)localObject).setVisibility(8);
    }
    localObject = this.bF;
    if ((localObject == null) || (!((TroopNewGuidePopWindow)localObject).isShowing()))
    {
      localObject = (AIOAnimationControlManager)this.d.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (localObject != null) {
        ((AIOAnimationControlManager)localObject).f();
      }
    }
    if (RobotResourcesManager.a().d()) {
      RobotResourcesManager.a().c();
    }
    if (QLog.isColorLevel())
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause, isTroopOwner =");
      localStringBuilder.append(this.bV);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  protected void Q()
  {
    super.Q();
    if (this.bm)
    {
      this.ba.setBackgroundResource(2130844752);
      AnonymousChatHelper.a().a(this.bz);
      b(-16777216, false);
    }
  }
  
  public void S()
  {
    super.S();
    ((BaseTroopListUI)this.i.e().b()).a();
    FloatView localFloatView = this.br;
    if (localFloatView != null) {
      localFloatView.setVisibility(0);
    }
    TroopConfessUtil.b(this.d, true);
    a(this.ah.b, true);
    this.bL.b();
    AIOOpenState.b(true);
  }
  
  protected Boolean T()
  {
    if (this.bm) {
      return new Boolean(false);
    }
    return null;
  }
  
  public void U()
  {
    super.U();
    Intent localIntent = this.f.getIntent();
    if (localIntent == null) {
      return;
    }
    String str = localIntent.getStringExtra("uin");
    int i = localIntent.getIntExtra("uintype", -1);
    if ((this.ah.b != null) && ((!this.ah.b.equals(str)) || (this.ah.a != i))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (this.bj != null))
    {
      this.bj.d();
      this.bj = null;
    }
    if (this.bZ != null)
    {
      TroopFileError.b(this.d, this.bZ);
      this.bZ = null;
    }
    cD();
  }
  
  public boolean V()
  {
    if (((AIOAtHelper)q(34)).a()) {
      return true;
    }
    if (((TogetherControlHelper)q(43)).k()) {
      return true;
    }
    if (this.bp != null) {
      this.bp.v();
    }
    if (RobotResourcesManager.a().d()) {
      RobotResourcesManager.a().c();
    }
    ((TroopTipsHelper)this.g.a(109)).b();
    if (this.bR) {
      cz();
    }
    return super.V();
  }
  
  String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int i = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(i + 1), this.ah.b, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  public void a()
  {
    super.a();
    if ((this.bp != null) && (!bE())) {
      this.bp.u().c();
    }
  }
  
  public void a(int paramInt)
  {
    AIOUtils.q = true;
    int i = Integer.valueOf(paramInt).intValue();
    if (i == this.n.getCurrentPanel())
    {
      this.n.b();
      return;
    }
    if (i != 3)
    {
      if ((i == 4) && (this.bm)) {
        ReportController.b(this.d, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.ah.b, "", "", "");
      }
    }
    else if (this.bm) {
      ReportController.b(this.d, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.ah.b, "", "", "");
    }
    t(i);
    super.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.d(this.c, 2, new Object[] { "onPanelChanged updateAIOPanelTip. oldPanel=", Integer.valueOf(paramInt1), ", newPanel=", Integer.valueOf(paramInt2) });
    }
    r(false);
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      bV();
    }
    if (paramInt1 == 35)
    {
      if (paramInt2 != 1) {
        bool1 = false;
      }
      this.bT.a(bool1);
    }
    if (paramInt2 == 35) {
      this.bT.b();
    }
    super.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2000) {
      j(paramIntent);
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (r(true))) {
      return;
    }
    if (paramInt2 == -1) {
      a(paramInt1, paramIntent);
    } else if (paramInt2 == 8001)
    {
      if (this.n != null) {
        this.n.b();
      }
    }
    else if (paramInt1 == 12005) {
      cq();
    } else if (paramInt2 == 0) {
      v(paramInt1);
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
          paramString = this.bX.obtainMessage(5, 1, 0, this.f.getString(2131886624));
          this.bX.sendMessage(paramString);
          return;
          Object localObject = paramString;
          if (android.text.TextUtils.isEmpty(paramString)) {
            localObject = this.f.getResources().getString(2131893809);
          }
          paramString = this.bX.obtainMessage(5, 1, 0, localObject);
          this.bX.sendMessage(paramString);
          return;
          localObject = paramString;
          if (android.text.TextUtils.isEmpty(paramString)) {
            localObject = this.f.getResources().getString(2131893817);
          }
          paramString = this.bX.obtainMessage(5, 1, 0, localObject);
          this.bX.sendMessage(paramString);
          return;
          localObject = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
          if ((localObject != null) && (((TroopManager)localObject).F(this.ah.c)))
          {
            ((TroopManager)localObject).E(this.ah.c);
            return;
          }
          if (android.text.TextUtils.isEmpty(paramString)) {
            break;
          }
          paramString = this.bX.obtainMessage(5, 1, 0, paramString);
          this.bX.sendMessage(paramString);
          return;
        }
      }
      else
      {
        paramString = this.bX.obtainMessage(5, 1, 0, this.f.getString(2131886618));
        this.bX.sendMessage(paramString);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.by == null) {
      this.by = new QQAnonymousDialog(this.f);
    }
    this.by.a(paramInt, paramString);
    this.by.show();
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramString = this.m;
      TroopChatPie.24 local24 = new TroopChatPie.24(this);
      long l;
      if (AppSetting.e) {
        l = 3000L;
      } else {
        l = 1000L;
      }
      paramString.postDelayed(local24, l);
    }
  }
  
  void a(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.d, this.ah.b, paramLong1, paramLong2, new TroopChatPie.6(this, false));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showLowCreditLevelDialog:");
      ((StringBuilder)localObject).append(this.ah.b);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.bC;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      if ((paramLong != 1L) && (paramLong != 2L))
      {
        this.bC.dismiss();
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showLowCreditLevelDialog, CreditLevelTipDialog isShowing:");
          ((StringBuilder)localObject).append(this.ah.b);
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
      cu();
      new ReportTask(this.d).a("dc00899").b("Grp_banned").c("Grp_AIO").d("exp_msgbox").a(new String[] { this.ah.b }).a();
      return;
    }
    if ((paramLong == 2L) && (!paramBoolean))
    {
      ct();
      return;
    }
    if ((paramLong == 2L) && (paramBoolean))
    {
      this.bC = DialogUtil.a(this.e, 230).setTitle(this.f.getString(2131917233)).setMessage(2131895332);
      this.bC.setNegativeButton(2131895331, new TroopChatPie.12(this));
      this.bC.setPositiveButton(2131895330, new TroopChatPie.13(this));
      this.bC.setCancelable(false);
      this.bC.show();
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int i = paramIntent.getIntExtra(AlbumConstants.h, -1);
    if (((i == 2) || (i == 1)) && (r(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131446540)
    {
      int i = this.bK;
      if (i == 2)
      {
        if (this.bJ == null) {
          this.bJ = new TroopOnlineMemberBar(this.d, this.e, this.o, this.p, this.bp);
        }
        this.bJ.a(aE().b);
        if (this.bJ.g()) {
          return;
        }
        if (this.bJ.d())
        {
          bV();
          if (this.bJ.n != 2) {
            new ReportTask(this.d).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryClose").a(new String[] { aE().b }).a();
          }
        }
        else
        {
          this.bJ.a(1);
          paramView = (ITroopOnlineMemberHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_MEMBER_HANDLER);
          if (paramView != null) {
            paramView.a(aE().b);
          }
          q(true);
          if (this.bJ.n == 2)
          {
            TroopReportor.a("Grp_idol", "Grp_AIO", "clk_renshu", 0, 0, new String[] { aE().b });
            return;
          }
          new ReportTask(this.d).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryOpen").a(new String[] { aE().b }).a();
        }
      }
      else
      {
        if (i == 3)
        {
          ((TroopListenTogetherPanel)q(33)).i();
          return;
        }
        if (i == 4)
        {
          ((TogetherControlHelper)q(43)).a(this.ah.b);
          return;
        }
        if (i == 5)
        {
          ((StudyRoomTipBarHelper)q(75)).d();
          return;
        }
        this.g.a(1, new Object[] { Integer.valueOf(this.bK) });
      }
    }
    else
    {
      cy();
    }
  }
  
  public void a(TroopChatPie.OnListViewScrollStateListener paramOnListViewScrollStateListener)
  {
    this.cm.add(paramOnListViewScrollStateListener);
  }
  
  void a(SelfGagInfo paramSelfGagInfo)
  {
    FastImageHelper localFastImageHelper = (FastImageHelper)q(83);
    if (paramSelfGagInfo.b)
    {
      if ((1 != this.n.getCurrentPanel()) && (3 != this.n.getCurrentPanel()) && (8 != this.n.getCurrentPanel()))
      {
        bN();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateGagStatus_UI, sendEmptyMessageDelayed-TIMER_ID:");
          localStringBuilder.append(paramSelfGagInfo.d);
          localStringBuilder.append(", hasDestory=");
          localStringBuilder.append(this.aY);
          QLog.d("troop_gag", 2, localStringBuilder.toString());
        }
        if (!this.aY)
        {
          this.bX.removeMessages(1);
          this.bX.sendEmptyMessageDelayed(1, paramSelfGagInfo.d * 1000L);
        }
      }
      else
      {
        this.bY = true;
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
      this.bY = false;
      bz();
      localFastImageHelper.b();
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
    if (this.ah.a == 1)
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
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.d.getRuntimeService(ITroopRobotService.class, "all");
    if ((localITroopRobotService.isRobotTroop(this.ah.b)) && (localITroopRobotService.isRobotUin(paramString1)))
    {
      AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.i.a(52);
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
    Object localObject = (ITroopOnlineMemberService)this.d.getRuntimeService(ITroopOnlineMemberService.class, "");
    String str = ((ITroopOnlineMemberService)localObject).getOnlineTip(paramString);
    ((TroopListenTogetherPanel)q(33)).e();
    if ((!this.bm) && (!android.text.TextUtils.isEmpty(str)) && (!ChatPieTipsBarHelper.a(this)))
    {
      if (this.bK != 2)
      {
        s(2);
        if (paramBoolean) {
          if (((ITroopOnlineMemberService)localObject).getRequestListServiceType(paramString) == 3) {
            TroopReportor.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { paramString });
          } else {
            new ReportTask(this.d).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { aE().b }).a();
          }
        }
      }
      b(true);
      this.I.setText(str);
      this.L.setVisibility(0);
      localObject = this.bJ;
      if (localObject != null)
      {
        ((TroopOnlineMemberBar)localObject).a(paramString);
        if (this.bJ.d())
        {
          this.bJ.c();
          p(true);
          return;
        }
        p(false);
        return;
      }
      p(false);
      return;
    }
    if ((!this.bm) && (!ChatPieTipsBarHelper.a(this)))
    {
      b(false);
      this.I.setText("");
      this.L.setVisibility(8);
    }
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    TroopUtils.a(this.d, this.ah.b, paramList);
    this.g.a(1, this, paramList);
    super.a(paramList, paramCharSequence, paramInt);
    if ((0xFFFF & paramInt) == 4)
    {
      ((TroopAioKeywordTipManager)this.d.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER)).a(paramList);
      if (this.bp != null) {
        this.bp.u().d();
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.aZ == null)
    {
      QLog.e(this.c, 2, "mAIORootView == null");
      ChatFragment localChatFragment = this.f.getChatFragment();
      if (localChatFragment != null) {
        this.aZ = localChatFragment.h;
      }
    }
    super.a(paramBoolean);
    u(1);
    RobotResourcesManager.a().a(this);
    this.bL = new TroopUsingTimeReport(this.d, this.ah.b, "Grp_time", "Grp_AIO", "visit_time");
    TroopAbilityUtils.a(this.d, this.f, this.f.getIntent(), true);
    return true;
  }
  
  public EntryModel aV()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.ah.b);
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).createEntryModel(localTroopInfo, this.ah.b);
  }
  
  public void ai()
  {
    super.ai();
    ((TogetherControlHelper)q(43)).n();
    ((ClockInEntryHelper)q(85)).a(false);
  }
  
  protected void ap()
  {
    bB();
    TroopManager localTroopManager = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.f(this.ah.b);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.d.getCurrentAccountUin())))
    {
      if (localTroopManager.b(this.ah.b) - NetConnInfoCenter.getServerTime() < 259200L) {
        a(0L, 0L);
      }
      if (QVipBigTroopExpiredProcessor.e().mIsEnable)
      {
        localObject = (ISVIPHandler)this.d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        if (localTroopManager.H(this.ah.b))
        {
          ((ISVIPHandler)localObject).a(Long.parseLong(this.ah.b));
          QLog.e("vip_pretty.", 1, "get the troop expired info from server");
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("vip_pretty.", 1, "get the troop expired info from local");
          }
          TroopManager.a(localTroopManager.J(this.ah.b), this.d, this.ah.b, this.e, this, this.aX);
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
    super.ap();
    boolean bool1 = this.bD;
    boolean bool2 = false;
    if (bool1 == true)
    {
      ThreadManager.post(new TroopChatPie.4(this), 1, null, true);
      this.bD = false;
    }
    Object localObject = this.f.getIntent().getExtras();
    bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Bundle)localObject).containsKey("forward_type"))
      {
        bool1 = bool2;
        if (this.ah.b != null)
        {
          bool1 = bool2;
          if (this.ah.b.equals(((Bundle)localObject).getString("uin"))) {
            bool1 = true;
          }
        }
      }
    }
    ThreadManager.post(new TroopChatPie.5(this, bool1), 8, null, true);
    a(localTroopManager, localTroopInfo);
  }
  
  public void au()
  {
    super.au();
    this.d.addDefaultObservers(this.cz);
    this.d.addObserver(this.cA);
    this.d.addObserver(this.ca);
    this.d.addObserver(this.cb);
    this.d.addObserver(this.bW);
    this.d.addObserver(this.cc);
    this.d.addObserver(this.cp);
    if (this.d.getProxyManager() != null) {
      this.d.getProxyManager().addProxyObserver(this.bq);
    }
    cv();
  }
  
  public void av()
  {
    super.av();
    this.d.removeObserver(this.cz);
    this.d.removeObserver(this.cA);
    this.d.removeObserver(this.ca);
    this.d.removeObserver(this.cb);
    this.d.removeObserver(this.bW);
    this.d.removeObserver(this.cc);
    this.d.removeObserver(this.cp);
    this.d.unRegistObserver(this.cB);
    if (this.d.getProxyManager() != null) {
      this.d.getProxyManager().removeProxyObserver(this.bq);
    }
  }
  
  public View b(int paramInt)
  {
    if (paramInt == 35)
    {
      this.bT = ((ConfessPanel)View.inflate(this.e, 2131624083, null));
      this.bT.a(this.d, this.e, this);
      return this.bT;
    }
    return super.b(paramInt);
  }
  
  protected HelperProvider b()
  {
    return new TroopHelperProvider(this.f);
  }
  
  @Nullable
  List<ChatMessage> b(List<ChatMessage> paramList)
  {
    boolean bool3 = TroopMsgSameFold.a();
    int j = TroopMsgSameFold.b();
    int k = TroopMsgSameFold.c();
    boolean bool1;
    if (!this.cu)
    {
      if (paramList.size() > 0)
      {
        this.cs = ((ChatMessage)paramList.get(paramList.size() - 1)).shmsgseq;
        this.ct = ((ChatMessage)paramList.get(0)).shmsgseq;
      }
      this.cu = true;
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    boolean bool2;
    if ((this.ct == 0L) && (this.cs == 0L)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    if (a(paramList, bool3, j, bool2))
    {
      arrayOfLong1 = a(this.cv);
      arrayOfLong2 = a(this.cy);
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject3 = TroopMsgSameFold.a(this.d, paramList, j, this.ct, this.cs, arrayOfLong1, this.cw, this.cx, arrayOfLong2, bool1);
        localObject2 = localObject3;
        if (!bool1) {
          break label482;
        }
        localObject2 = localObject3;
        if (k <= 15) {
          break label482;
        }
        localObject2 = localObject3;
        if (((List)localObject3).size() <= 1) {
          break label482;
        }
        Object localObject1 = null;
        i = 1;
        if (i < ((List)localObject3).size())
        {
          localObject1 = (ChatMessage)((List)localObject3).get(i);
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
        localObject1 = this.d.getMessageFacade().i(this.ah.b, this.ah.a, this.cs - k - 1L);
        if (((List)localObject1).size() > 0)
        {
          this.ct = ((ChatMessage)((List)localObject1).get(0)).shmsgseq;
          this.cs = ((ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq;
        }
        localObject2 = this.d;
        long l1 = this.ct;
        long l2 = this.cs;
        localObject3 = this.cw;
        Map localMap = this.cx;
        try
        {
          localObject1 = TroopMsgSameFold.a((QQAppInterface)localObject2, (List)localObject1, j, l1, l2, arrayOfLong1, (Set)localObject3, localMap, arrayOfLong2, false);
          return localObject1;
        }
        catch (Throwable localThrowable1) {}
        QLog.e(this.c, 1, localThrowable2, new Object[0]);
      }
      catch (Throwable localThrowable2) {}
      break label479;
      if (paramList.size() == 0)
      {
        cD();
        this.cu = true;
      }
      label479:
      Object localObject2 = paramList;
      label482:
      return localObject2;
      label485:
      i += 1;
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    if (paramInt2 == 8)
    {
      bool = this.bm;
      return;
    }
    boolean bool = this.bm;
  }
  
  protected void b(Intent paramIntent)
  {
    s(0);
    if ((this.bm) && (!AnonymousChatHelper.a().a(this.ah.b)))
    {
      s(false);
      this.bu.setVisibility(8);
      this.bv.setVisibility(8);
    }
    else if (AnonymousChatHelper.a().a(this.ah.b))
    {
      s(true);
      this.ba.setBackgroundResource(2130844752);
      this.p.setBackgroundResource(2130844758);
      this.bu.setVisibility(0);
    }
    if ((this.bm) && (AnonymousChatHelper.a().a(this.ah.b)))
    {
      localObject1 = this.I;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.f.getResources().getString(2131886658));
      ((StringBuilder)localObject2).append(AnonymousChatHelper.a().b(this.ah.b).d);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    super.b(paramIntent);
    Object localObject1 = paramIntent.getStringExtra("greetingsTitle");
    Object localObject2 = paramIntent.getStringExtra("greetingsContent");
    int i = paramIntent.getIntExtra("types", 0);
    if (i == 1)
    {
      paramIntent = paramIntent.getStringExtra("greetingsMembers");
      if (paramIntent == null) {
        break label438;
      }
    }
    try
    {
      paramIntent = new JSONArray(paramIntent);
      i = 0;
      while (i < paramIntent.length())
      {
        localObject3 = paramIntent.getString(i);
        localObject4 = ContactUtils.a(this.d, this.ah.b, (String)localObject3);
        localObject3 = AtTroopMemberSpan.a(this.d, this.e, this.ah.b, (String)localObject3, (String)localObject4, false, this.Y, true);
        if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
          this.Y.getEditableText().insert(0, (CharSequence)localObject3);
        }
        i += 1;
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
      QLog.e(this.c, 2, "TroopChatPie send greetings.get members failed.");
      break label438;
      if (i == 2)
      {
        paramIntent = paramIntent.getStringExtra("greetingsName");
        localObject3 = this.Y.getEditableText();
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
      paramIntent = (QWalletAIOLifeCycleHelper)q(27);
      if (paramIntent != null) {
        paramIntent.a("0", (String)localObject2, (String)localObject1);
      }
    }
    if ((this.ah.a == 1) && (((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).Z(this.ah.b)) && (this.aV != null)) {
      this.aV.b();
    }
    this.A.setVisibility(8);
    ((TogetherControlHelper)q(43)).n();
    ((ClockInEntryHelper)q(85)).a(false);
  }
  
  public void bA()
  {
    super.bA();
    if (this.bZ == null)
    {
      TroopChatPie.TroopFileErrorFilterForChatActivity localTroopFileErrorFilterForChatActivity = new TroopChatPie.TroopFileErrorFilterForChatActivity(this.ah.b);
      this.bZ = new TroopFileError.TroopFileErrorObserver(this.f, localTroopFileErrorFilterForChatActivity, this.d);
    }
    TroopFileError.a(this.d, this.bZ);
    r(false);
    if (this.bm != AnonymousChatHelper.a().a(this.ah.b))
    {
      this.bm ^= true;
      s(this.bm);
    }
    ((TroopBindPublicAccountMgr)this.d.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).g(this.ah.b);
  }
  
  protected void bB()
  {
    super.bB();
    this.cd = this.d.getConversationFacade().a(this.ah.b, this.ah.a);
    cA();
    bP();
    cB();
    Intent localIntent = this.f.getIntent();
    if (localIntent != null)
    {
      String str1 = localIntent.getStringExtra("at_member_name");
      String str2 = localIntent.getStringExtra("at_member_uin");
      int i = localIntent.getIntExtra("at_member_source", 0);
      if ((!android.text.TextUtils.isEmpty(str1)) && (!android.text.TextUtils.isEmpty(str2))) {
        a(str2, str1, false, i);
      }
    }
    cC();
    this.cf = false;
    ThreadManager.getSubThreadHandler().removeCallbacks(this.cl);
    ThreadManager.getSubThreadHandler().postDelayed(this.cl, 500L);
    bW();
    this.ce = true;
  }
  
  public boolean bF()
  {
    return false;
  }
  
  void bH()
  {
    if (((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.ah.b) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.post(this.bU, 8, null, true);
    }
  }
  
  public void bI()
  {
    if (this.ah != null)
    {
      if (android.text.TextUtils.isEmpty(this.ah.b)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, String.format("updateTroopHonorInteractiveIcon, troopUin: %s", new Object[] { this.ah.b }));
      }
      if (QQTheme.isNowSimpleUI())
      {
        TroopHonorAIOUtils.a(this.d, this.f, this.ah.b, this.p, this.E, this.G, this.aO);
        return;
      }
      TroopHonorAIOUtils.a(this.d, this.f, this.ah.b, this.p, this.D, this.F, this.aO);
    }
  }
  
  public ImageView bJ()
  {
    return this.L;
  }
  
  public ViewGroup bK()
  {
    return this.q;
  }
  
  public ViewGroup bL()
  {
    return this.r;
  }
  
  public boolean bM()
  {
    return this.bY;
  }
  
  @TargetApi(11)
  protected void bN()
  {
    this.i.p().d().a().b();
  }
  
  public void bO()
  {
    Object localObject = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null) {
      localObject = ((TroopManager)localObject).f(this.ah.b);
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkTroopCreditLevel, troopInfo==null:");
        ((StringBuilder)localObject).append(this.ah.b);
        QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    long l1 = ((TroopInfo)localObject).troopCreditLevel;
    if ((l1 != 1L) && (l1 != 2L))
    {
      localObject = this.bC;
      if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
        this.bC.dismiss();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkTroopCreditLevel, normal:");
        ((StringBuilder)localObject).append(this.ah.b);
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
      ((StringBuilder)localObject).append(this.ah.b);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(bool2);
      QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
    }
    localObject = (ITroopBatchInfohandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_BATCH_INFO_HANDLER);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkTroopCreditLevel, getTroopCreditInfo:");
        localStringBuilder.append(this.ah.b);
        QLog.i("troop.credit.act", 2, localStringBuilder.toString());
      }
      ((ITroopBatchInfohandler)localObject).a(this.ah.b, true);
    }
    a(l1, bool3);
  }
  
  void bP()
  {
    Object localObject;
    if (this.ah.a == 1)
    {
      localObject = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject == null) {
        return;
      }
      localObject = ((TroopManager)localObject).f(this.ah.b);
      if ((localObject == null) || ((((TroopInfo)localObject).wMemberNum != 0) && (!android.text.TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)))) {}
    }
    try
    {
      long l = Long.parseLong(this.ah.b);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      ((ITroopListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a((ArrayList)localObject);
      if (!QLog.isColorLevel()) {
        break label180;
      }
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopInfoIfNeed, sessionInfo.curFriendUin = ");
      localStringBuilder.append(this.ah.b);
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
      QLog.d(this.c, 2, "getTroopInfoIfNeed failed");
    }
  }
  
  void bQ()
  {
    ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    if (localITroopMemberListHandler != null) {
      try
      {
        localITroopMemberListHandler.a(Long.parseLong(this.ah.b), 0L, 2, 0, 0);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.c, 2, localException.toString());
        }
      }
    }
  }
  
  void bR()
  {
    if (this.X.getBackground() != null) {
      t();
    }
    cx();
    this.aM.setVisibility(8);
    this.C.setTextColor(this.f.getResources().getColor(2131167990));
    this.B.setTextColor(this.f.getResources().getColor(2131167990));
    if (this.s.getVisibility() == 0)
    {
      this.s.setBackgroundResource(2130853297);
      this.s.setTextColor(this.f.getResources().getColor(2131167987));
      SimpleModeHelper.a(this.t, this.f);
      if (SimpleModeHelper.b()) {
        SimpleModeHelper.a(this.t, this.t.getResources().getColorStateList(2131168194));
      }
    }
    else if (this.w.getVisibility() == 0)
    {
      this.w.setBackgroundResource(2130853298);
      this.w.setPadding(0, 0, 0, 0);
      this.x.setTextColor(this.f.getResources().getColor(2131167987));
    }
    AIOUtils.a(this.u, 2130853306);
    if ((this.I.getVisibility() == 0) && (this.I.getText() != null) && (this.I.getText().toString().startsWith(this.f.getResources().getString(2131886658))))
    {
      this.I.setText("");
      SimpleModeHelper.a(this.I, this.f);
      b(false);
    }
    Object localObject = (ITroopOnlineMemberService)this.d.getRuntimeService(ITroopOnlineMemberService.class, "");
    String str = ((ITroopOnlineMemberService)localObject).getOnlineTip(aE().b);
    if (!android.text.TextUtils.isEmpty(str))
    {
      s(2);
      if (((ITroopOnlineMemberService)localObject).getRequestListServiceType(aE().b) == 3) {
        TroopReportor.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { aE().b });
      } else {
        new ReportTask(this.d).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { aE().b }).a();
      }
      b(true);
      this.I.setText(str);
      SimpleModeHelper.a(this.I, this.f);
      this.L.setVisibility(0);
      p(false);
    }
    else
    {
      s(0);
    }
    localObject = (PlusPanel)this.ae.d(8);
    if (localObject != null) {
      ((PlusPanel)localObject).a(false);
    }
    localObject = (AIOEmoticonUIHelper)q(105);
    if (localObject != null) {
      ((AIOEmoticonUIHelper)localObject).c(false);
    }
    this.bu.setVisibility(8);
    this.bv.setVisibility(8);
    AnonymousChatHelper.a().c();
    bT();
    if (this.Y != null)
    {
      this.Y.setShadowLayer(1.0F, 0.0F, 1.0F, this.f.getResources().getColor(2131165684));
      this.Y.setHint("");
    }
    if (this.W != null) {
      AIOUtils.a(this.W, 2130852018);
    }
    this.n.a(1);
    ((TogetherControlHelper)q(43)).m();
    ((ClockInEntryHelper)q(85)).a(false);
  }
  
  public void bS()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new TroopChatPie.22(this));
    View localView = this.bx;
    if ((localView != null) && (this.bw != null))
    {
      localView.startAnimation(localAlphaAnimation);
      this.bw.startAnimation(localAlphaAnimation);
    }
  }
  
  public void bT()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new TroopChatPie.23(this));
    this.bx.startAnimation(localAlphaAnimation);
    this.bw.startAnimation(localAlphaAnimation);
  }
  
  public void bU()
  {
    if ((this.ao != null) && (this.ao.isShowing()) && (!aX().isFinishing())) {
      this.ao.dismiss();
    }
  }
  
  public void bV()
  {
    TroopOnlineMemberBar localTroopOnlineMemberBar = this.bJ;
    if ((localTroopOnlineMemberBar != null) && (localTroopOnlineMemberBar.d()))
    {
      if (this.bJ.b() == 2)
      {
        b(false);
        s(0);
        return;
      }
      q(false);
    }
  }
  
  public void bW()
  {
    if (this.B == null) {
      this.B = ((TextView)this.q.findViewById(2131431971));
    }
    TroopInfo localTroopInfo = ((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.ah.b);
    String str;
    StringBuilder localStringBuilder;
    if ((localTroopInfo != null) && (localTroopInfo.wMemberNumClient > 0))
    {
      if (QLog.isColorLevel())
      {
        str = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showNewTroopMemberCount wMemberNumClient:");
        localStringBuilder.append(localTroopInfo.wMemberNumClient);
        localStringBuilder.append("  wMemberNum:");
        localStringBuilder.append(localTroopInfo.wMemberNum);
        localStringBuilder.append(" troopUin:");
        localStringBuilder.append(localTroopInfo.troopuin);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.B.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
      if (this.B.getVisibility() != 0)
      {
        this.B.setVisibility(0);
        this.B.setGravity(16);
        if (this.p != null)
        {
          boolean bool = ((AudioPanelAioHelper)q(128)).i;
          this.p.a(bool ^ true, this.ah.a);
        }
      }
      a(this.ah.b, false);
      return;
    }
    this.B.setVisibility(8);
    if (QLog.isColorLevel())
    {
      if (localTroopInfo != null)
      {
        str = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showNewTroopMemberCount count smaller than 0");
        localStringBuilder.append(localTroopInfo.wMemberNumClient);
        QLog.d(str, 2, localStringBuilder.toString());
        return;
      }
      QLog.d(this.c, 2, "showNewTroopMemberCount info is null");
    }
  }
  
  public ImageView bX()
  {
    return this.A;
  }
  
  public RelativeLayout bY()
  {
    return this.z;
  }
  
  public PanelIconLinearLayout bZ()
  {
    return this.W;
  }
  
  public void bf()
  {
    this.p.c();
  }
  
  protected AIOInput c()
  {
    return new AIOInputBuilder().a(this.i).a(new TroopMessageSender(this.i)).a();
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    bI();
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    bf();
    this.v.setVisibility(0);
  }
  
  public TipsManager ca()
  {
    return this.aX;
  }
  
  public TroopOnlineMemberBar cb()
  {
    return this.bJ;
  }
  
  public void cc()
  {
    if ((this.L != null) && (this.I != null) && (this.r != null))
    {
      if (this.C == null) {
        return;
      }
      Object localObject2 = (TroopListenTogetherPanel)q(33);
      boolean bool1 = ((TroopListenTogetherPanel)localObject2).e();
      boolean bool2 = ((TroopListenTogetherPanel)localObject2).f();
      TogetherControlHelper localTogetherControlHelper = (TogetherControlHelper)q(43);
      boolean bool4 = localTogetherControlHelper.e();
      StudyRoomTipBarHelper localStudyRoomTipBarHelper = (StudyRoomTipBarHelper)q(75);
      boolean bool3 = localStudyRoomTipBarHelper.e();
      Object localObject1 = (IliveGroupTipsBarHelper)q(81);
      boolean bool5 = ((IliveGroupTipsBarHelper)localObject1).e();
      int i;
      if (bool1)
      {
        s(3);
        b(true);
        this.I.setText(((TroopListenTogetherPanel)localObject2).a(bool2));
        SimpleModeHelper.a(this.I, this.f);
        q(bool2);
        i = AIOUtils.b(8.0F, this.I.getResources());
        BaseListenTogetherPanel.a(this.r, 0, i, 0, 0, this.aZ.getRootView());
      }
      else if (bool4)
      {
        bool3 = localTogetherControlHelper.b();
        s(4);
        b(true);
        this.I.setText(localTogetherControlHelper.d());
        SimpleModeHelper.a(this.I, this.f);
        q(bool3);
        i = AIOUtils.b(8.0F, this.I.getResources());
        BaseListenTogetherPanel.a(this.r, 0, i, 0, 0, this.aZ.getRootView());
      }
      else if (bool3)
      {
        s(5);
        b(true);
        bool4 = localStudyRoomTipBarHelper.a();
        this.I.setText(localStudyRoomTipBarHelper.a(bool4));
        SimpleModeHelper.a(this.I, this.f);
        q(bool4);
        i = AIOUtils.b(8.0F, this.I.getResources());
        BaseListenTogetherPanel.a(this.r, 0, i, 0, 0, this.aZ.getRootView());
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
        localObject2 = ((ITroopOnlineMemberService)this.d.getRuntimeService(ITroopOnlineMemberService.class, "")).getOnlineTip(aE().b);
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject2))
        {
          s(2);
          b(true);
          this.I.setText((CharSequence)localObject2);
          SimpleModeHelper.a(this.I, this.f);
          this.L.setVisibility(0);
          p(false);
        }
        else
        {
          this.I.setText("");
          s(0);
        }
        BaseListenTogetherPanel.a(this.r, this.aZ.getRootView());
      }
      ((IliveGroupTipsBarHelper)localObject1).f();
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
  
  public boolean cd()
  {
    return this.bV;
  }
  
  public Runnable ce()
  {
    return this.cl;
  }
  
  public void cf()
  {
    this.bX.removeMessages(1);
    this.bX.sendEmptyMessage(1);
  }
  
  protected AIOContext d()
  {
    return new TroopAIOContext();
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new BaseTroopScroller()).a(new TroopListUI(this.i)).a(new TroopMsgLoader()).a(new UnreadTask(this.i)).a();
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    if ((this.ah.c == null) || (this.ah.c.length() == 0))
    {
      paramIntent = ((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.ah.b);
      if (paramIntent != null) {
        this.ah.c = paramIntent.troopcode;
      }
    }
    long l = this.d.getConversationFacade().e(this.ah.b, this.ah.a);
    this.ah.b().putLong("key_troop_last_read_seq", l);
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  public boolean e(String paramString)
  {
    boolean bool3 = this.ck;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool3)
    {
      int i = this.U.getFirstVisiblePosition();
      int k = this.U.getLastVisiblePosition();
      int j = this.U.getHeaderViewsCount();
      if (i <= j) {
        i = j;
      }
      for (;;)
      {
        bool2 = bool1;
        if (i < j) {
          break;
        }
        bool2 = bool1;
        if (i > k) {
          break;
        }
        try
        {
          Object localObject = (ChatMessage)this.U.getAdapter().getItem(i);
          bool2 = bool1;
          if (localObject != null)
          {
            bool2 = bool1;
            if (((ChatMessage)localObject).msgtype == -1012)
            {
              localObject = ((ChatMessage)localObject).getExtInfoFromExtStr("troop_new_member_uin");
              if (QLog.isColorLevel())
              {
                String str = this.c;
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
        i += 1;
        bool1 = bool2;
      }
    }
    return bool2;
  }
  
  protected TipsController f()
  {
    return new TroopTipsController(this.i);
  }
  
  protected void f(Intent paramIntent)
  {
    super.f(paramIntent);
    if (this.bm)
    {
      if (this.s.getVisibility() == 0)
      {
        this.s.setBackgroundResource(2130844778);
        this.s.setTextColor(AnonymousChatHelper.c);
        this.t.setTextColor(AnonymousChatHelper.c);
        return;
      }
      if (this.w.getVisibility() == 0)
      {
        this.w.setBackgroundResource(2130853298);
        this.x.setTextColor(AnonymousChatHelper.c);
      }
    }
    else
    {
      if (this.s.getVisibility() == 0)
      {
        this.s.setBackgroundResource(2130853297);
        this.s.setTextColor(this.f.getResources().getColor(2131167987));
        this.t.setTextColor(this.f.getResources().getColor(2131167987));
        return;
      }
      if (this.w.getVisibility() == 0)
      {
        this.w.setBackgroundResource(2130853298);
        this.w.setPadding(0, 0, 0, 0);
        this.x.setTextColor(this.f.getResources().getColor(2131167987));
      }
    }
  }
  
  public void f(String paramString)
  {
    if (aX().isFinishing()) {
      return;
    }
    if (this.ao == null) {
      this.ao = new QQProgressDialog(aX(), aX().getTitleBarHeight());
    }
    this.ao.a(paramString);
    if (!aX().isFinishing())
    {
      if (this.ao.isShowing()) {
        return;
      }
      this.ao.show();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (RobotResourcesManager.a().d()) {
      RobotResourcesManager.a().c();
    }
    if (this.bR) {
      cz();
    }
    super.f(paramBoolean);
  }
  
  public void g(String paramString)
  {
    this.bM = paramString;
  }
  
  protected void h()
  {
    this.c = "TroopChatPie";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1;
    long l1;
    long l2;
    long l3;
    if (i != 29)
    {
      if ((i == 30) || (i != 86)) {
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
        l4 = Long.parseLong(this.ah.b);
        l5 = Long.parseLong(this.d.getCurrentUin());
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
      if (i != 0)
      {
        localObject1 = (PlusPanel)this.ae.d(8);
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
        Object localObject2 = this.bF;
        if ((localObject2 != null) && (((TroopNewGuidePopWindow)localObject2).isShowing())) {
          this.bF.dismiss();
        }
        this.bF = new TroopNewGuidePopWindow(this.d, this.f, this.bj, this.ah.b);
        localObject2 = new int[2];
        this.q.getLocationOnScreen((int[])localObject2);
        i = A();
        int[] arrayOfInt = new int[2];
        this.Y.getLocationInWindow(arrayOfInt);
        int j = arrayOfInt[1];
        int k = localObject2[1];
        this.bF.a(i, j - k);
        this.bF.a(paramMessage.arg1);
      }
      label473:
      if ((paramMessage.what == 60) && (this.bm))
      {
        this.ba.setBackgroundResource(2130844752);
        return true;
      }
      return super.handleMessage(paramMessage);
      label507:
      i = 1;
      continue;
      label512:
      i = 0;
    }
  }
  
  public void l(int paramInt)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("troopUin : ");
      ((StringBuilder)localObject2).append(this.ah.b);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      localObject1 = this.d.getAVNotifyCenter().b(Long.valueOf(this.ah.b).longValue(), 1);
    }
    catch (Exception localException)
    {
      label76:
      StringBuilder localStringBuilder;
      break label76;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onShowFirst : invalid uin!");
    }
    Object localObject1 = null;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("avType : ");
        localStringBuilder.append(((AVNotifyCenter.VideoRoomInfo_tips)localObject1).c);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).c == 2)
      {
        if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).b) {
          ReportController.b(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
        }
        this.d.getAVNotifyCenter().c(Long.valueOf(this.ah.b).longValue(), 1);
      }
      else if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).c == 10)
      {
        if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).b) {
          ReportController.b(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
        }
        this.d.getAVNotifyCenter().c(Long.valueOf(this.ah.b).longValue(), 1);
      }
    }
    ((TroopListUI)this.j.b()).z();
    if (this.bG == null)
    {
      this.bG = new LinearLayout(this.e);
      this.bH = new TroopChatPie.2(this, this.e);
      this.bH.setVerticalFadingEdgeEnabled(false);
      this.bH.setScrollbarFadingEnabled(false);
      this.bH.setVerticalScrollBarEnabled(false);
      this.bI = (this.o.getHeight() - this.p.getHeight() - this.X.getHeight() - this.W.getHeight());
      localObject1 = new RelativeLayout.LayoutParams(-1, this.bI);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.e, 50.0F);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.X.getHeight() + this.W.getHeight());
      this.o.addView(this.bH, 0, (ViewGroup.LayoutParams)localObject1);
      this.bH.addView(this.bG, -1, this.bI);
    }
    else
    {
      this.bI = (this.o.getHeight() - this.p.getHeight() - this.X.getHeight() - this.W.getHeight());
      localObject1 = (RelativeLayout.LayoutParams)this.bH.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = this.bI;
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.X.getHeight() + this.W.getHeight());
      this.bH.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.bH.removeAllViews();
      this.bH.addView(this.bG, -1, this.bI);
    }
    localObject1 = ((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.ah.b);
    if (localObject1 != null) {
      this.bV = this.d.getCurrentAccountUin().equalsIgnoreCase(((TroopInfo)localObject1).troopowneruin);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause, isTroopOwner =");
      localStringBuilder.append(this.bV);
      localStringBuilder.append(",troopInfo = ");
      localStringBuilder.append(localObject1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    cr();
    localObject1 = (TogetherEntryBean)QConfigManager.b().b(553);
    if ((localObject1 != null) && (!((TogetherEntryBean)localObject1).a))
    {
      this.A.setVisibility(8);
      this.A.setOnClickListener(null);
    }
    localObject1 = this.f.getIntent();
    this.bR = ((Intent)localObject1).getBooleanExtra("open_chat_from_group_rec_confess", false);
    if (this.bR)
    {
      k((Intent)localObject1);
      h(this.ah.b);
    }
    this.ah.y = this.bR;
    p(false);
    super.l(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131433920) || (!r(true)))
    {
      super.onClick(paramView);
      if (paramView.getId() == 2131438953) {
        bV();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.bp != null) {
      this.bp.u().a(paramInt, 500L);
    }
    if (paramInt == 2) {
      bV();
    }
    if (QLog.isColorLevel())
    {
      paramAbsListView = this.c;
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
    this.ck = bool;
    paramAbsListView = this.cm.iterator();
    while (paramAbsListView.hasNext()) {
      ((TroopChatPie.OnListViewScrollStateListener)paramAbsListView.next()).a(this.ck);
    }
    if ((paramInt == 0) && (this.bM != null))
    {
      paramAbsListView = ((ITroopBatchAddFriendService)this.d.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
      this.bM = null;
      paramAbsListView.a(this.ah.b, 1);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131437281) {
      this.j.d().j();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void p(boolean paramBoolean)
  {
    if ((!this.cr) && (!paramBoolean) && (this.bK == 2)) {
      q(false);
    }
  }
  
  protected void q()
  {
    super.q();
    if (this.f.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      ChatActivityFacade.a(this.d, this.ah, this.f.getIntent());
    }
    this.bD = true;
    ((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).A(this.ah.b);
    Object localObject = this.f.getIntent().getStringExtra("uin");
    TroopAssistantManager.a().e(this.d, (String)localObject);
    this.k.d().d().a(this.cq);
    ThreadManager.post(new TroopChatPie.CheckGlamourPicturesRunnable(this.f), 2, null, true);
    localObject = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if (((TroopManager)localObject).Z(this.ah.b))
    {
      localObject = ((TroopManager)localObject).f(this.ah.b);
      if (localObject != null)
      {
        int i;
        if (((TroopInfo)localObject).isTroopOwner(this.d.getCurrentAccountUin())) {
          i = 1;
        } else if (((TroopInfo)localObject).isTroopAdmin(this.d.getCurrentAccountUin())) {
          i = 2;
        } else {
          i = 3;
        }
        new ReportTask(this.d).a("dc00899").b("Grp_private").c("Grp_AIO").d("exp").a(new String[] { this.ah.b, String.valueOf(i) }).a();
      }
    }
    if (this.cD == null)
    {
      this.cD = new TroopChatPie.InputOnGlobalLayoutListener(this, null);
      this.Y.getViewTreeObserver().addOnGlobalLayoutListener(this.cD);
    }
    cD();
  }
  
  public void q(boolean paramBoolean)
  {
    Object localObject = (LinearLayout.LayoutParams)this.L.getLayoutParams();
    this.L.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = UIUtils.a(this.e, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = UIUtils.a(this.e, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    for (;;)
    {
      try
      {
        localObject = this.e.getResources();
        if (paramBoolean)
        {
          i = 2130844972;
          localObject = ((Resources)localObject).getDrawable(i);
          if ((!SimpleUIUtil.e()) && (!"2105".equals(ThemeUtil.curThemeId)))
          {
            if (!ThemeUtil.isNowThemeIsNight(this.d, false, null)) {
              ((Drawable)localObject).clearColorFilter();
            } else {
              ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
            }
          }
          else {
            ((Drawable)localObject).setColorFilter(this.f.getResources().getColor(2131167990), PorterDuff.Mode.MULTIPLY);
          }
          if (paramBoolean)
          {
            Drawable localDrawable = this.L.getDrawable();
            if ((localDrawable instanceof AnimationDrawable)) {
              ((AnimationDrawable)localDrawable).stop();
            }
            ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.e, 10.0F), UIUtils.a(this.e, 10.0F));
            this.L.setImageDrawable((Drawable)localObject);
            return;
          }
          if ((Build.VERSION.SDK_INT >= 21) && (!this.cr))
          {
            cs();
            return;
          }
          ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.e, 10.0F), UIUtils.a(this.e, 10.0F));
          this.L.setImageDrawable((Drawable)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      int i = 2130844979;
    }
  }
  
  public boolean r(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handleTroopGagUI", 2, "start");
    }
    if (this.bY)
    {
      this.n.b();
      if (paramBoolean) {
        QQToast.makeText(this.d.getApp(), 2131895180, 0).show(this.f.getTitleBarHeight());
      }
      if (QLog.isColorLevel()) {
        QLog.d("doDisableInputStat", 2, "start");
      }
      bN();
      return true;
    }
    return false;
  }
  
  public void s(int paramInt)
  {
    this.bK = paramInt;
    if ((this.L != null) && (this.q != null))
    {
      if (paramInt == 3)
      {
        this.L.setVisibility(0);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
      }
      else if (paramInt == 4)
      {
        if (((TogetherControlHelper)q(43)).f()) {
          this.L.setVisibility(8);
        } else {
          this.L.setVisibility(0);
        }
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
      }
      else if (paramInt == 2)
      {
        this.L.setVisibility(0);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
      }
      else if (paramInt == 5)
      {
        this.L.setVisibility(0);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
      }
      else
      {
        this.L.setVisibility(8);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(null);
      }
      this.g.a(2, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.c, 2, "changeSubTitleType, not init ui");
    }
  }
  
  public void s(boolean paramBoolean)
  {
    ((SimpleUIAIOHelper)q(29)).c(paramBoolean);
    this.bm = paramBoolean;
    AnonymousChatHelper.a().a(paramBoolean, this.ah.b);
    if ((paramBoolean) || (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.d))) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.d, "troop_anonyous", paramBoolean);
    }
    if (this.W != null)
    {
      this.W.a(this.d, this.ah, this);
      this.W.setHelperProvider(this.g);
      this.W.a(this, new UpdateParams.Builder().a(paramBoolean).a());
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.bu == null)
    {
      this.bu = new View(this.f);
      this.bu.setBackgroundColor(Color.rgb(19, 19, 21));
      this.bu.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(12, -1);
      this.p.addView(this.bu, localLayoutParams);
    }
    if (this.bx == null)
    {
      this.bx = new View(this.f);
      this.bx.setBackgroundResource(2130844758);
      this.bx.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.bx.setLayoutParams(localLayoutParams);
      this.p.addView(this.bx, 0);
    }
    if (this.bw == null)
    {
      this.bw = new View(this.f);
      this.bw.setBackgroundResource(2130844758);
      this.bw.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.bw.setLayoutParams(localLayoutParams);
      this.o.addView(this.bw, 0);
    }
    if (this.bv == null)
    {
      this.bv = new View(this.f);
      this.bv.setBackgroundColor(Color.rgb(19, 19, 21));
      this.bv.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(2, 2131435809);
      this.o.addView(this.bv, localLayoutParams);
    }
    if (this.bj != null) {
      this.bj.a(paramBoolean);
    }
    if (paramBoolean)
    {
      cw();
      ((TroopAskAnonymouslyHelper)this.g.a(97)).f();
    }
    else
    {
      bR();
    }
    D();
    z();
    this.V.notifyDataSetChanged();
  }
  
  void t(int paramInt)
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
      ReportController.b(this.d, "P_CliOper", "Grp_AIO", "", "AIOshortcut", "Clk_shortcut", 0, 0, this.ah.b, str, "", "");
    }
  }
  
  public void t(boolean paramBoolean)
  {
    this.bV = paramBoolean;
  }
  
  public void u(int paramInt)
  {
    if ((this.ah.a == 1) && (this.d.getTroopMask(this.ah.b) == 3)) {
      ((ITroopSettingHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER)).a(this.ah.b, this.d.getCurrentAccountUin(), paramInt, 0);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (QLog.isColorLevel()) {
      QLog.i(this.c, 2, "update");
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
        if ((this.bj != null) && (this.bj.a())) {
          this.j.d().b(1, this.bj.b() / 2);
        } else {
          this.j.d().c(1);
        }
        break;
      }
    }
    if ((paramObject instanceof MessageForText))
    {
      paramObservable = (MessageForText)paramObject;
      if (paramObservable.frienduin.equals(this.ah.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TroopChatPie.update()");
        }
        AioVipKeywordHelper.a().a(this.d, this.ah, paramObservable, paramObservable.msg, this.e, paramObservable.isSend());
      }
    }
  }
  
  public void v()
  {
    super.v();
    TroopConfessUtil.a(this.d, false);
  }
  
  public void z()
  {
    bf();
    ((TogetherControlHelper)q(43)).n();
    ((ClockInEntryHelper)q(85)).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */