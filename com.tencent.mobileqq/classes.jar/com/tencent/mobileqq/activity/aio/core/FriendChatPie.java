package com.tencent.mobileqq.activity.aio.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOTipsController.AIOTipsListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.friendship.IFriendShipAnimManager;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipViewManager;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.input.FriendMessageSender;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.FriendListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.FriendScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.helper.FriendHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.OnlineStatusHelper;
import com.tencent.mobileqq.activity.aio.helper.QidianHelper;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.WpaThirdAppStructMsgUtil;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean.GeneralTogetherItem;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel;
import com.tencent.mobileqq.listentogether.ui.C2CListenTogetherPanel;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper;
import com.tencent.mobileqq.mutualmark.oldlogic.ReCheckInHelper;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.observer.VipGifObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper;
import com.tencent.mobileqq.richstatus.topic.TopicReplyUtil;
import com.tencent.mobileqq.servlet.ReduFriendObserver;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.XPanelContainer;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneEventHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class FriendChatPie
  extends BaseChatPie
{
  TeamWorkObserver bA = new FriendChatPie.19(this);
  AIOTipsController.AIOTipsListener bB = new FriendChatPie.22(this);
  private boolean bC = false;
  private boolean bD = false;
  private boolean bE = false;
  private boolean bF = true;
  private boolean bG = false;
  private OneWayFriendHelper bH;
  private boolean bI = false;
  private ImageView bJ;
  private long bK = -1L;
  private ReduFriendObserver bL = new FriendChatPie.7(this);
  private StrangerObserver bM = new FriendChatPie.8(this);
  private QidianBusinessObserver bN = new FriendChatPie.14(this);
  private boolean bO = false;
  private final OnlineStatusObserver bP = new FriendChatPie.20(this);
  protected FriendHotTipsBar bi;
  protected BabyQAIOPanel bj;
  ReCheckInHelper bk;
  public boolean bl = false;
  View bm;
  boolean bn = false;
  public boolean bo = false;
  public boolean bp = false;
  boolean bq = false;
  IFriendShipAnimManager br;
  protected int bs = 0;
  Runnable bt = new FriendChatPie.3(this);
  protected VipGifObserver bu = new FriendChatPie.6(this);
  protected MessageObserver bv = new FriendChatPie.9(this);
  BabyQObserver bw = new FriendChatPie.11(this);
  FriendListObserver bx = new FriendChatPie.12(this);
  IntimateInfoObserver by = new FriendChatPie.13(this);
  View.OnTouchListener bz = null;
  
  public FriendChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private int a(int[] paramArrayOfInt)
  {
    return this.W.b(this.d, this.ah, this).indexOf(paramArrayOfInt);
  }
  
  private void a(Friends paramFriends)
  {
    if ((((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(this.d) != 1080L) && (paramFriends != null) && (paramFriends.uExtOnlineStatus == 1080L)) {
      ThreadManager.post(new FriendChatPie.24(this), 5, null, false);
    }
    if ((paramFriends != null) && (paramFriends.uExtOnlineStatus == 1080L)) {
      bJ();
    }
  }
  
  private void a(String paramString, int paramInt, long paramLong)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUpdateSendMsgError uin ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" type ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" uniseq ");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 0)
    {
      localObject1 = this.d.getMessageFacade().a(paramString, paramInt, paramLong);
      if ((localObject1 != null) && (((MessageRecord)localObject1).msgtype == -2058) && ((((MessageRecord)localObject1).extraflag == 32768) || (((MessageRecord)localObject1).sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.c, 2, "onUpdateSendMsgError, sticker msg is failed!");
        }
        this.d.getMessageFacade().a((MessageRecord)localObject1, false);
        paramString = UinTypeUtil.a(paramString, paramInt);
        boolean bool3 = EmojiStickerManager.a().F.containsKey(paramString);
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (bool3)
        {
          paramLong = ((Long)EmojiStickerManager.a().F.get(paramString)).longValue();
          if (System.currentTimeMillis() - paramLong > 300000L) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = this.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("send sticker msg fail, is need send Toast ");
          localStringBuilder.append(bool1);
          QLog.i((String)localObject2, 2, localStringBuilder.toString());
        }
        if (bool1)
        {
          EmojiStickerManager.a().F.put(paramString, Long.valueOf(System.currentTimeMillis()));
          ThreadManager.getUIHandler().post(new FriendChatPie.10(this, (MessageRecord)localObject1));
        }
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        Object localObject = this.e.getResources();
        if (paramBoolean1)
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
          if (!paramBoolean1) {
            ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.e, 10.0F), UIUtils.a(this.e, 10.0F));
          }
          this.I.setClickable(false);
          if (paramBoolean2) {
            this.I.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          } else {
            this.I.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
          }
          this.I.setCompoundDrawablePadding(UIUtils.a(this.e, 4.0F));
          this.r.setClickable(true);
          this.r.setOnClickListener(this);
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
  
  private void bC()
  {
    Message localMessage = this.m.obtainMessage(85);
    if (TogetherUtils.a(this.d, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false))
    {
      SingTogetherConfigBean.GeneralTogetherItem localGeneralTogetherItem = ((SingTogetherConfigBean)QConfigManager.b().b(551)).a(4);
      if ((localGeneralTogetherItem != null) && (localGeneralTogetherItem.a)) {
        localMessage.arg1 = 1;
      }
    }
    localMessage.sendToTarget();
  }
  
  private void bD()
  {
    if (this.bO) {
      return;
    }
    ((ConfessManager)this.d.getManager(QQManagerFactory.CONFESS_MANAGER)).a(this.ah.b);
    this.bO = true;
  }
  
  private void bE()
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)q(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.b();
    }
  }
  
  private void bF()
  {
    if (this.bH == null)
    {
      this.bH = new OneWayFriendHelper(this.d, this.ah.a, this.ah.b);
      this.bH.a(new FriendChatPie.23(this));
    }
  }
  
  private void bG()
  {
    OneWayFriendHelper localOneWayFriendHelper = this.bH;
    if (localOneWayFriendHelper != null) {
      localOneWayFriendHelper.a();
    }
  }
  
  private void bH()
  {
    OneWayFriendHelper localOneWayFriendHelper = this.bH;
    if (localOneWayFriendHelper != null)
    {
      localOneWayFriendHelper.b();
      this.bH = null;
    }
  }
  
  private void bI()
  {
    Object localObject = ((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.ah.b);
    if (localObject != null)
    {
      a((Friends)localObject);
      return;
    }
    this.m.removeMessages(99);
    localObject = this.m.obtainMessage(99);
    this.m.sendMessageDelayed((Message)localObject, 500L);
  }
  
  private void bJ()
  {
    if ((this.bJ == null) && (this.p == null))
    {
      ThreadManager.getUIHandler().postDelayed(new FriendChatPie.25(this), 500L);
      return;
    }
    bK();
  }
  
  private void bK()
  {
    if (this.bJ == null)
    {
      this.bJ = new ImageView(this.f);
      int i = this.e.getResources().getDisplayMetrics().widthPixels / 3;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      if (this.p != null) {
        i = this.p.getHeight();
      } else {
        i = 0;
      }
      localLayoutParams.topMargin = i;
      localLayoutParams.addRule(14);
      this.bJ.setLayoutParams(localLayoutParams);
    }
    boolean bool = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).handleOlympicEggAnim(this.d, this.bJ);
    if (this.bJ.getParent() != null) {
      this.aZ.removeView(this.bJ);
    }
    if (bool) {
      this.aZ.addView(this.bJ);
    }
  }
  
  private void c(long paramLong)
  {
    VipGiftManager localVipGiftManager = (VipGiftManager)this.d.getManager(QQManagerFactory.VIP_GIF_MANAGER);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.e();
    if ((localVipGiftDownloadInfo != null) && (this.f.isResume()) && (localVipGiftDownloadInfo.b.equalsIgnoreCase(ae())) && (localVipGiftDownloadInfo.f == 2L) && (paramLong == localVipGiftDownloadInfo.c)) {
      localVipGiftManager.a(localVipGiftDownloadInfo, this.f);
    }
  }
  
  private void i(Intent paramIntent)
  {
    this.bO = false;
    String str = paramIntent.getStringExtra("uin");
    this.bq = paramIntent.getBooleanExtra("open_chat_from_frd_rank_confess", false);
    ConfessManager localConfessManager = (ConfessManager)this.d.getManager(QQManagerFactory.CONFESS_MANAGER);
    if (this.bq)
    {
      this.bn = localConfessManager.c(str, paramIntent);
      return;
    }
    this.bn = localConfessManager.a(str, paramIntent);
  }
  
  public void K()
  {
    if (this.bK > 0L) {
      ThreadManager.getSubThreadHandler().post(new FriendChatPie.2(this));
    }
    if (this.aY)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "hasDestory = true return");
      }
      return;
    }
    this.j.d().j();
    this.j.d().a(false);
    if (this.bn) {
      bD();
    }
    if (!TextUtils.isEmpty(this.ah.b))
    {
      FileManagerDataCenter.b(this.d, this.ah.b, this.ah.a, -4021);
      FileManagerDataCenter.b(this.d, this.ah.b, this.ah.a, -4022);
    }
    if (Utils.c(this.ah.b)) {
      ((BabyQHandler)this.d.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a();
    }
    this.bl = false;
    super.K();
    if ((this.ah != null) && (this.ah.H != null) && (this.ah.H.c != null))
    {
      this.ah.H.c.setCallback(null);
      this.ah.H.c = null;
    }
    IFriendShipAnimManager localIFriendShipAnimManager = this.br;
    if (localIFriendShipAnimManager != null) {
      localIFriendShipAnimManager.c();
    }
    this.bE = false;
    ((QQStoryFeedManager)this.d.getManager(QQManagerFactory.QQ_STORY_FEED_MANAGER)).a();
    if (this.A != null) {
      this.A.setOnClickListener(null);
    }
    this.k.d().d().a(null);
    bH();
    ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).onDestroyOlympicEggAnim(this.d);
  }
  
  public void N()
  {
    super.N();
    if (Utils.c(this.ah.b)) {
      ((BabyQHandler)this.d.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).b();
    }
  }
  
  public void P()
  {
    super.P();
    IFriendShipAnimManager localIFriendShipAnimManager = this.br;
    if (localIFriendShipAnimManager != null) {
      localIFriendShipAnimManager.b();
    }
  }
  
  protected void Q()
  {
    super.Q();
    this.j.d().a(true);
    IFriendShipAnimManager localIFriendShipAnimManager = this.br;
    if (localIFriendShipAnimManager != null) {
      localIFriendShipAnimManager.a();
    }
  }
  
  public void S()
  {
    super.S();
    AIOOpenState.a(true);
  }
  
  public boolean V()
  {
    if ((this.bD) && (this.f.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.d, this.f, this.ah))) {
      return true;
    }
    if (this.bn) {
      bD();
    }
    return super.V();
  }
  
  public void a()
  {
    if (this.bC)
    {
      WpaThirdAppStructMsgUtil.a(this.d, this.f, this.ah, this.bC);
      this.bC = false;
    }
    if (this.bE)
    {
      this.bE = false;
      ReportController.b(this.d, "CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (Integer.valueOf(paramInt).intValue() == 29)
    {
      this.n.a(29);
      BabyQAIOPanel localBabyQAIOPanel = this.bj;
      if (localBabyQAIOPanel != null) {
        localBabyQAIOPanel.a();
      }
      ReportController.b(this.d, "dc00898", "", "", "0X800806C", "0X800806C", 0, 0, "", "", "", "");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QZoneEventHandler.handleActivityEvent(this, paramInt1, paramInt2, paramIntent)) {
      return;
    }
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 13008) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("result");
      paramIntent = str;
      if (str == null) {
        paramIntent = "";
      }
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        if (this.al != null)
        {
          this.al.setFriendComment(this.ah.b, paramIntent, false);
          QZoneHelper.restartQzone();
          return;
        }
        new QQToastNotifier(this.e).notifyUser(2131890911, A(), 0, 1);
        return;
      }
      new QQToastNotifier(this.e).notifyUser(2131892155, A(), 0, 1);
    }
  }
  
  protected void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAddFriendActivity-->uinType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" peerUin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" name=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" phoneNum=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" srcId=");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131446540)
    {
      int i = this.bs;
      if (i == 1)
      {
        ((C2CListenTogetherPanel)q(32)).i();
        return;
      }
      if (i == 2) {
        ((TogetherControlHelper)q(43)).a(this.ah.b);
      }
    }
    else
    {
      super.a(paramView);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    a();
  }
  
  protected void a(Object paramObject)
  {
    if ((paramObject instanceof MessageForStructing))
    {
      paramObject = (MessageForStructing)paramObject;
      if ((paramObject.isread) && (paramObject.structingMsg != null) && (paramObject.structingMsg.mMsgServiceID == 38) && (!TextUtils.isEmpty(paramObject.structingMsg.mResid))) {
        ((VipGiftManager)this.d.getManager(QQManagerFactory.VIP_GIF_MANAGER)).a(paramObject);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    AioFriendTitleHelper localAioFriendTitleHelper = (AioFriendTitleHelper)q(45);
    if ((localAioFriendTitleHelper != null) && (localAioFriendTitleHelper.a(paramBoolean, paramString))) {
      return;
    }
    aX().runOnUiThread(new FriendChatPie.21(this, paramString, paramBoolean));
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
    Intent localIntent = this.f.getIntent();
    String str = localIntent.getStringExtra("PREVIOUS_WINDOW");
    if ((str != null) && (str.equals(((Class)localObject).getName()))) {
      this.bK = NetConnInfoCenter.getServerTime();
    }
    this.bl = true;
    if (localIntent.getBooleanExtra("open_chat_from_avator", false))
    {
      localObject = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel())
      {
        str = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("upload avator ");
        localStringBuilder.append((String)localObject);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (localObject != null) {
        if (ProfileCardUtil.a(this.d, (String)localObject, localIntent))
        {
          QQToast.makeText(aX(), 2, 2131916288, 0).show(A());
          if (Utils.c(this.ah.b)) {
            ThreadManager.executeOnSubThread(new FriendChatPie.1(this), true);
          }
          ReportController.b(this.d, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
        }
        else
        {
          QQToast.makeText(aX(), 1, 2131916287, 0).show(A());
        }
      }
    }
    this.bn = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
    if (this.bn) {
      i(localIntent);
    }
    this.ah.x = this.bn;
    this.br = new FriendShipViewManager(aX());
    localIntent.getStringExtra("uin");
    this.bk = new ReCheckInHelper(this.d);
    bI();
    return super.a(paramBoolean);
  }
  
  public RecordParams.RecorderParam aU()
  {
    if (this.ah.a == 0)
    {
      boolean bool = ((AudioPanelProvider)this.ae.f(2)).e();
      return RecordParams.b(this.d, bool);
    }
    return new RecordParams.RecorderParam(RecordParams.a, 0, 0);
  }
  
  public EntryModel aV()
  {
    if (this.ah.a == 0) {
      return new EntryModel(0, Long.parseLong(this.ah.b), this.ah.e, false);
    }
    return super.aV();
  }
  
  protected void am()
  {
    StartupTracker.a(null, "AIO_onShow_business");
    super.am();
    this.bD = this.f.getIntent().getBooleanExtra("from3rdApp", false);
    this.bC = WpaThirdAppStructMsgUtil.a(this.d, this.ah, this.f.getIntent());
    StartupTracker.a("AIO_onShow_business", null);
    if ((this.ah.a == 1024) && (!CrmUtils.a(this.d, this.d.getCurrentAccountUin(), this.ah.a))) {}
  }
  
  protected void ao()
  {
    boolean bool1;
    if ((!this.al.isGetOnlineListRecently()) && (!this.al.shouldGetOnlineInfo())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    Object localObject2;
    if (!bool1)
    {
      bool1 = CustomOnlineStatusManager.a().a(this.ah.b);
      bool2 = bool1;
      if (QLog.isDevelopLevel())
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("not update friend online info\nisGetOnlineListRecently = ");
        ((StringBuilder)localObject1).append(this.al.isGetOnlineListRecently());
        ((StringBuilder)localObject1).append("\nshouldGetOnlineInfo = ");
        ((StringBuilder)localObject1).append(this.al.shouldGetOnlineInfo());
        QLog.d("CustomOnlineStatusManager", 4, ((StringBuilder)localObject1).toString());
        localObject2 = new StringBuilder();
        if (bool1) {
          localObject1 = "need update online status";
        } else {
          localObject1 = "not need update online status";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" for ");
        ((StringBuilder)localObject2).append(this.ah.b);
        QLog.d("CustomOnlineStatusManager", 4, ((StringBuilder)localObject2).toString());
        bool2 = bool1;
      }
    }
    if (bool2) {
      try
      {
        this.al.getOnlineInfo(this.ah.b, false);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = this.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("friendchatpie onShow_otherThings, ");
          localStringBuilder.append(localNumberFormatException.toString());
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
      }
    }
    if (this.bF)
    {
      this.bF = false;
      ThreadManager.post(this.bt, 8, null, true);
    }
    super.ao();
    if (!((INewFriendService)this.d.getRuntimeService(INewFriendService.class)).handleNewFrdAIOShow(this.ah.a, this.ah.b))
    {
      ChatActivityFacade.a(this.d, this.ah, false);
      ChatActivityFacade.b(this.d, this.ah, false);
      ChatActivityFacade.a(this.d, this.ah);
      ChatActivityFacade.b(this.d, this.ah);
      ChatActivityFacade.c(this.d, this.ah);
    }
    bC();
  }
  
  protected void au()
  {
    super.au();
    this.d.addDefaultObservers(this.bv);
    this.d.addObserver(this.bM);
    this.d.addObserver(this.bx);
    this.d.addObserver(this.by);
    this.d.registObserver(this.bL);
    this.d.registObserver(this.bu);
    this.d.addObserver(this.bN);
    this.d.addObserver(this.bw);
    this.d.addObserver(this.bA);
    this.d.addObserver(this.bP);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.bv);
    this.d.removeObserver(this.bx);
    this.d.removeObserver(this.by);
    if (this.bL != null) {
      this.d.unRegistObserver(this.bL);
    }
    this.d.unRegistObserver(this.bu);
    this.d.removeObserver(this.bM);
    this.d.removeObserver(this.bN);
    this.d.removeObserver(this.bw);
    this.d.removeObserver(this.bA);
    this.d.removeObserver(this.bP);
  }
  
  public View b(int paramInt)
  {
    if (paramInt == 29)
    {
      long l = System.currentTimeMillis();
      this.bj = ((BabyQAIOPanel)View.inflate(this.e, 2131624078, null));
      this.bj.a(this);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openBabyQPanel:");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.d("OpenPanel", 2, localStringBuilder.toString());
      }
      return this.bj;
    }
    return super.b(paramInt);
  }
  
  protected HelperProvider b()
  {
    return new FriendHelperProvider(this.f);
  }
  
  protected String b(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    return ChatActivityUtils.a(this.d, this.e, this.ah.b);
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    long l1 = System.currentTimeMillis();
    if ((this.ah.i) && (this.ah.l) && (!this.ah.k))
    {
      ReportController.b(this.d, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.p.setBackgroundDrawable(QIMUserManager.b().a(2130852228));
      this.p.setRight1Icon(2130852270);
      this.p.a(2130853301);
      if (this.S != null)
      {
        this.S.setVisibility(0);
        this.S.setBackgroundDrawable(QIMUserManager.b().b(2));
      }
      else
      {
        this.S = this.R.inflate();
        this.S.setBackgroundDrawable(QIMUserManager.b().b(2));
      }
    }
    else if ((this.ah.j) && (this.ah.m) && (!this.ah.k))
    {
      this.p.setBackgroundDrawable(TIMUserManager.b().a(2130852228));
      this.p.setRight1Icon(2130852270);
      this.p.a(2130853301);
      if (this.T != null)
      {
        this.T.setVisibility(0);
        this.T.setBackgroundDrawable(TIMUserManager.b().b(2));
      }
      else
      {
        this.T = this.R.inflate();
        this.T.setBackgroundDrawable(TIMUserManager.b().b(2));
      }
    }
    else
    {
      this.p.setBackgroundResource(2130852228);
      this.p.setRight1Icon(2130852269, 2130852270);
      this.p.a(2130853300, 2130853301);
      if (this.R != null) {
        this.R.setVisibility(8);
      }
      if (this.S != null) {
        this.S.setVisibility(8);
      }
      if (this.T != null) {
        this.T.setVisibility(8);
      }
    }
    long l2 = System.currentTimeMillis();
    paramIntent = new StringBuilder();
    paramIntent.append("set title time:");
    paramIntent.append(l2 - l1);
    QLog.d("shinkencai", 2, paramIntent.toString());
  }
  
  protected void b(Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      InputStatusHelper localInputStatusHelper = (InputStatusHelper)q(16);
      if (localInputStatusHelper != null)
      {
        if (paramObject.isSend())
        {
          localInputStatusHelper.d();
          return;
        }
        if (paramObject.time > localInputStatusHelper.b) {
          bE();
        }
      }
    }
  }
  
  protected void b(String paramString)
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)q(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.a(paramString);
    }
  }
  
  public void bA()
  {
    Object localObject = ProfileCardUtil.a(this.d, this.ah.b);
    AllInOne localAllInOne = new AllInOne(this.ah.b, 8);
    localAllInOne.nickname = ContactUtils.a(this.d, this.ah.b);
    if ((TextUtils.isEmpty(localAllInOne.nickname)) || (localAllInOne.nickname.equals(this.ah.b))) {
      localAllInOne.nickname = this.ah.e;
    }
    localAllInOne.preWinUin = this.ah.b;
    localAllInOne.preWinType = this.ah.a;
    localAllInOne.lastActivity = 2;
    localAllInOne.profileEntryType = 117;
    ProfileCardInfo localProfileCardInfo = new ProfileCardInfo();
    localProfileCardInfo.card = ((Card)localObject);
    localProfileCardInfo.allInOne = localAllInOne;
    localObject = BusinessCardUtils.a(this.d, localProfileCardInfo);
    ProfileCardUtil.a(aX(), (BusinessCard)localObject, localAllInOne);
  }
  
  public void bB()
  {
    if ((this.L != null) && (this.I != null) && (this.r != null) && (this.C != null))
    {
      if (this.J == null) {
        return;
      }
      Object localObject = (C2CListenTogetherPanel)q(32);
      boolean bool1 = ((C2CListenTogetherPanel)localObject).e();
      boolean bool2 = ((C2CListenTogetherPanel)localObject).f();
      TogetherControlHelper localTogetherControlHelper = (TogetherControlHelper)q(43);
      boolean bool3 = localTogetherControlHelper.e();
      int i;
      if (bool1)
      {
        this.bs = 1;
        b(true);
        b(((C2CListenTogetherPanel)localObject).a(bool2));
        b(bool2, false);
        i = AIOUtils.b(8.0F, this.I.getResources());
        BaseListenTogetherPanel.a(this.r, 0, i, 0, 0, this.aZ.getRootView());
      }
      else if (bool3)
      {
        this.bs = 2;
        b(true);
        bool3 = localTogetherControlHelper.b();
        b(localTogetherControlHelper.d());
        SimpleModeHelper.a(this.I, this.f);
        b(bool3, localTogetherControlHelper.f());
        localObject = (AioFriendTitleHelper)q(45);
        i = AIOUtils.b(8.0F, this.I.getResources());
        BaseListenTogetherPanel.a(this.r, 0, i, 0, 0, this.aZ.getRootView());
      }
      else
      {
        this.L.setVisibility(8);
        this.I.setClickable(true);
        this.r.setClickable(false);
        this.r.setOnClickListener(null);
        BaseListenTogetherPanel.a(this.r, this.aZ.getRootView());
        this.bs = 0;
        b("");
        ((OnlineStatusHelper)this.g.a(129)).b();
        localObject = (AioFriendTitleHelper)q(45);
        if (localObject != null) {
          ((AioFriendTitleHelper)localObject).b("");
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("togetherTime=");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(",hasPannelShow");
        ((StringBuilder)localObject).append(bool2);
        QLog.d("BaseListenTogetherPanel_C2C", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void bc()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "==refreshTitleReativeIcon==");
    }
    bz();
  }
  
  protected void bg()
  {
    super.bg();
    if (SimpleUIUtil.e())
    {
      QLog.d(this.c, 1, "FriendChatPie updateUI_titleBarForTheme, SimpleUIMode is open now");
      return;
    }
    int i = VipUtils.a(this.d, this.ah.b, false);
    if ((i != 2) && (i != 3)) {
      return;
    }
    try
    {
      this.C.setTextColor(this.e.getResources().getColor(2131168187));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.c, 1, localException, new Object[0]);
    }
  }
  
  public void bo()
  {
    super.bo();
    Object localObject1 = ProfileCardUtil.a(this.d, this.ah.b);
    if (localObject1 != null) {
      localObject1 = ((Card)localObject1).strReMark;
    } else {
      localObject1 = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(this.e);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.d.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(this.ah.b);
      ((StringBuilder)localObject2).append("-grayTipsRemarkMention");
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!((SharedPreferences)localObject1).getBoolean((String)localObject2, false))
      {
        ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, true).apply();
        FriendsStatusUtil.a(this.d, this.ah.b);
      }
    }
  }
  
  public boolean br()
  {
    return this.bI;
  }
  
  @TargetApi(16)
  public boolean bz()
  {
    Object localObject = MutualMarkDataCenter.a(this.d, this.ah.b);
    if ((localObject != null) && ((((Pair)localObject).first != null) || (((Pair)localObject).second != null)))
    {
      if (this.bz == null) {
        this.bz = new FriendChatPie.18(this);
      }
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = (MutualMarkForDisplayInfo)((Pair)localObject).first;
      localObject = (MutualMarkForDisplayInfo)((Pair)localObject).second;
      if (localMutualMarkForDisplayInfo != null)
      {
        VipUtils.a(this.ah.b, localMutualMarkForDisplayInfo, this.d, "C2C_show");
        this.D.setTag(localMutualMarkForDisplayInfo);
        this.E.setTag(localMutualMarkForDisplayInfo);
        this.D.setOnTouchListener(this.bz);
        this.E.setOnTouchListener(this.bz);
      }
      else
      {
        this.D.setOnTouchListener(null);
        this.E.setOnTouchListener(null);
      }
      if (localObject != null)
      {
        VipUtils.a(this.ah.b, (MutualMarkForDisplayInfo)localObject, this.d, "C2C_show");
        this.F.setTag(localObject);
        this.G.setTag(localObject);
        this.F.setOnTouchListener(this.bz);
        this.G.setOnTouchListener(this.bz);
      }
      else
      {
        this.F.setOnTouchListener(null);
        this.G.setOnTouchListener(null);
      }
      this.p.setTitleIconLeftForMutualMark(localMutualMarkForDisplayInfo, (MutualMarkForDisplayInfo)localObject);
      MutualMarkBusinessLogicHelper.a(this.d, this.ah.b, localMutualMarkForDisplayInfo, (MutualMarkForDisplayInfo)localObject);
      if (QLog.isColorLevel())
      {
        String str = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateSession_updateInteractive one:");
        localStringBuilder.append(localMutualMarkForDisplayInfo);
        localStringBuilder.append(" two:");
        localStringBuilder.append(localObject);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return true;
    }
    this.p.setTitleIconLeft();
    this.D.setOnTouchListener(null);
    this.E.setOnTouchListener(null);
    this.F.setOnTouchListener(null);
    this.G.setOnTouchListener(null);
    return false;
  }
  
  protected AIOInput c()
  {
    return new AIOInputBuilder().a(this.i).a(new FriendMessageSender(this.i)).a();
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    bz();
    VipUtils.a(this.d, this.ah.b, this.p, this.H, this.aO);
    this.C.setOnClickListener(new FriendChatPie.17(this));
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    this.v.setVisibility(0);
  }
  
  protected void c(Object paramObject)
  {
    if ((paramObject instanceof MessageForText))
    {
      paramObject = (MessageForText)paramObject;
      String str = paramObject.msg;
      if (paramObject.frienduin.equals(this.ah.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in FriendChatPie.update()");
        }
        AioVipKeywordHelper.a().a(this.d, this.ah, paramObject, str, this.e, paramObject.isSend());
      }
    }
  }
  
  protected AIOContext d()
  {
    return new FriendAIOContext();
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    ThreadManager.post(new FriendChatPie.15(this), 5, null, false);
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new FriendScroller()).a(new FriendListUI(this.i)).a(new UnreadTask(this.i)).a();
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    this.bp = false;
  }
  
  public void f(boolean paramBoolean)
  {
    if ((this.bD) && (this.f.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.d, this.f, this.ah)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    if (this.bn) {
      bD();
    }
    super.f(paramBoolean);
  }
  
  protected void h()
  {
    this.c = "FriendChatPie";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if (j != 70)
    {
      int i = 0;
      if (j != 85)
      {
        if (j != 88)
        {
          if (j != 99)
          {
            if (j != 201) {
              return super.handleMessage(paramMessage);
            }
            if ((this.br != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String[])))
            {
              paramMessage = (String[])paramMessage.obj;
              if (paramMessage.length >= 2)
              {
                this.br.a(3, paramMessage[0], paramMessage[1]);
                return true;
              }
            }
          }
          else
          {
            bI();
            return true;
          }
        }
        else
        {
          paramMessage = this.br;
          if (paramMessage != null)
          {
            paramMessage.a(2);
            return true;
          }
        }
      }
      else
      {
        j = paramMessage.arg1;
        paramMessage = this.O;
        if (j == 0) {
          i = 8;
        }
        paramMessage.setVisibility(i);
        return true;
      }
    }
    else
    {
      paramMessage = this.br;
      if (paramMessage != null) {
        paramMessage.a(1);
      }
    }
    return true;
  }
  
  protected void k(int paramInt)
  {
    super.k(paramInt);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)q(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.d(9);
    }
  }
  
  public void l(int paramInt)
  {
    super.l(paramInt);
    OldMutualMarkLogicHelper.a(this.d, this.ah, this);
    ((FriendListUI)this.j.b()).a();
    if (Utils.c(this.ah.b))
    {
      BabyQHandler localBabyQHandler = (BabyQHandler)this.d.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if ((localBabyQHandler != null) && (localBabyQHandler.c(this.e, this.d.getCurrentAccountUin())))
      {
        this.n.a(29);
        this.bj.a();
        localBabyQHandler.a(this.e, this.d.getCurrentAccountUin(), false);
      }
    }
    ThreadManager.post(new FriendChatPie.16(this), 5, null, true);
    TopicReplyUtil.b(this, this.f.getIntent());
    bF();
    bG();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131436194)
    {
      SingTogetherConfigBean.GeneralTogetherItem localGeneralTogetherItem = ((SingTogetherConfigBean)QConfigManager.b().b(551)).a(4);
      if ((localGeneralTogetherItem != null) && (localGeneralTogetherItem.f > 0))
      {
        if (localGeneralTogetherItem.e != 1) {
          int i = localGeneralTogetherItem.f;
        }
        ((FetchOpenIdManager)this.d.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).a(Long.parseLong(this.ah.b), localGeneralTogetherItem.f, true);
      }
      if ((this.O != null) && (this.O.getVisibility() == 0) && (TogetherUtils.a(this.d, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false)) && (localGeneralTogetherItem != null) && (localGeneralTogetherItem.a)) {
        TogetherUtils.b(this.d, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", false, false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected boolean p()
  {
    return (this.aL) || (super.p());
  }
  
  protected void q()
  {
    super.q();
    this.P = false;
    com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.e = 0L;
    this.k.d().d().a(this.bB);
  }
  
  protected void u()
  {
    if (((QidianHelper)this.g.a(61)).a(false)) {
      this.P = true;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageForPokeEmo))
    {
      localObject = (MessageForPokeEmo)paramObject;
      if ((((MessageForPokeEmo)localObject).frienduin.equals(this.ah.b)) && (!((MessageForPokeEmo)localObject).isread)) {
        ((MessageForPokeEmo)localObject).setIsNeedPlayed(true);
      }
    }
    a(paramObject);
    if (((paramObject instanceof ChatMessage)) && (aY()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.ah.b)) && (this.bo)) {
        OldMutualMarkLogicHelper.b(this.d, this.ah, this);
      }
    }
    super.update(paramObservable, paramObject);
    c(paramObject);
    ChatActivityFacade.a(this, this.d, this.ah, false);
    b(paramObject);
  }
  
  protected void z()
  {
    int i;
    if ((!Utils.c(this.ah.b)) && (!this.d.getCurrentUin().equals(this.ah.b))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.A.setOnClickListener(new FriendChatPie.4(this));
      if (AIOTopRightButtonConfig.a().b(this.d.getCurrentAccountUin()))
      {
        this.A.setVisibility(0);
        this.A.setContentDescription(this.f.getResources().getString(2131896548));
        return;
      }
      this.A.setVisibility(8);
      return;
    }
    this.A.setVisibility(4);
    ThreadManager.post(new FriendChatPie.5(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie
 * JD-Core Version:    0.7.0.1
 */