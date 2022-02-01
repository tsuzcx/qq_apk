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
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
  public boolean D = false;
  boolean E = false;
  public boolean F = false;
  public boolean G = false;
  boolean H = false;
  private boolean I = false;
  private boolean J = false;
  private boolean K = false;
  private boolean L = true;
  private boolean M = false;
  private boolean N = false;
  private boolean O = false;
  private long jdField_a_of_type_Long = -1L;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  AIOTipsController.AIOTipsListener jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController$AIOTipsListener = new FriendChatPie.21(this);
  protected BabyQAIOPanel a;
  IFriendShipAnimManager jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager;
  protected FriendHotTipsBar a;
  BabyQObserver jdField_a_of_type_ComTencentMobileqqAppBabyQObserver = new FriendChatPie.11(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new FriendChatPie.12(this);
  protected MessageObserver a;
  IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new FriendChatPie.13(this);
  ReCheckInHelper jdField_a_of_type_ComTencentMobileqqMutualmarkOldlogicReCheckInHelper;
  protected VipGifObserver a;
  private OneWayFriendHelper jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper;
  private ReduFriendObserver jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver = new FriendChatPie.7(this);
  private StrangerObserver jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver = new FriendChatPie.8(this);
  TeamWorkObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver = new FriendChatPie.19(this);
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new FriendChatPie.14(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new FriendChatPie.3(this);
  protected int g;
  View g;
  
  public FriendChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver = new FriendChatPie.6(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new FriendChatPie.9(this);
  }
  
  private int a(int[] paramArrayOfInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this).indexOf(paramArrayOfInt);
  }
  
  private void a(String paramString, int paramInt, long paramLong)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong);
      if ((localObject1 != null) && (((MessageRecord)localObject1).msgtype == -2058) && ((((MessageRecord)localObject1).extraflag == 32768) || (((MessageRecord)localObject1).sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onUpdateSendMsgError, sticker msg is failed!");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, false);
        paramString = UinTypeUtil.a(paramString, paramInt);
        boolean bool3 = EmojiStickerManager.a().b.containsKey(paramString);
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (bool3)
        {
          paramLong = ((Long)EmojiStickerManager.a().b.get(paramString)).longValue();
          if (System.currentTimeMillis() - paramLong > 300000L) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = this.jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("send sticker msg fail, is need send Toast ");
          localStringBuilder.append(bool1);
          QLog.i((String)localObject2, 2, localStringBuilder.toString());
        }
        if (bool1)
        {
          EmojiStickerManager.a().b.put(paramString, Long.valueOf(System.currentTimeMillis()));
          ThreadManager.getUIHandler().post(new FriendChatPie.10(this, (MessageRecord)localObject1));
        }
      }
    }
  }
  
  private void aq()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(85);
    if (TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false))
    {
      SingTogetherConfigBean.GeneralTogetherItem localGeneralTogetherItem = ((SingTogetherConfigBean)QConfigManager.a().a(551)).a(4);
      if ((localGeneralTogetherItem != null) && (localGeneralTogetherItem.jdField_a_of_type_Boolean)) {
        localMessage.arg1 = 1;
      }
    }
    localMessage.sendToTarget();
  }
  
  private void ar()
  {
    if (this.O) {
      return;
    }
    ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.O = true;
  }
  
  private void as()
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.b();
    }
  }
  
  private void at()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper = new OneWayFriendHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper.a(new FriendChatPie.22(this));
    }
  }
  
  private void au()
  {
    OneWayFriendHelper localOneWayFriendHelper = this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper;
    if (localOneWayFriendHelper != null) {
      localOneWayFriendHelper.a();
    }
  }
  
  private void av()
  {
    OneWayFriendHelper localOneWayFriendHelper = this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper;
    if (localOneWayFriendHelper != null)
    {
      localOneWayFriendHelper.b();
      this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper = null;
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramBoolean1)
        {
          i = 2130844017;
          localObject = ((Resources)localObject).getDrawable(i);
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
          if (!paramBoolean1) {
            ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          }
          this.jdField_f_of_type_AndroidWidgetTextView.setClickable(false);
          if (paramBoolean2) {
            this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          } else {
            this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
          }
          this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
          this.jdField_b_of_type_AndroidViewViewGroup.setClickable(true);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      int i = 2130844024;
    }
  }
  
  private void c(long paramLong)
  {
    VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
    if ((localVipGiftDownloadInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) && (localVipGiftDownloadInfo.jdField_b_of_type_JavaLangString.equalsIgnoreCase(b())) && (localVipGiftDownloadInfo.d == 2L) && (paramLong == localVipGiftDownloadInfo.jdField_a_of_type_Long)) {
      localVipGiftManager.a(localVipGiftDownloadInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
  }
  
  private void h(Intent paramIntent)
  {
    this.O = false;
    String str = paramIntent.getStringExtra("uin");
    this.H = paramIntent.getBooleanExtra("open_chat_from_frd_rank_confess", false);
    ConfessManager localConfessManager = (ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
    if (this.H)
    {
      this.E = localConfessManager.c(str, paramIntent);
      return;
    }
    this.E = localConfessManager.a(str, paramIntent);
  }
  
  protected void I()
  {
    StartupTracker.a(null, "AIO_onShow_business");
    super.I();
    this.J = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.I = WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    StartupTracker.a("AIO_onShow_business", null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
  }
  
  protected void J()
  {
    boolean bool1;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.isGetOnlineListRecently()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.shouldGetOnlineInfo())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    Object localObject2;
    if (!bool1)
    {
      bool1 = CustomOnlineStatusManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      bool2 = bool1;
      if (QLog.isDevelopLevel())
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("not update friend online info\nisGetOnlineListRecently = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.isGetOnlineListRecently());
        ((StringBuilder)localObject1).append("\nshouldGetOnlineInfo = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.shouldGetOnlineInfo());
        QLog.d("CustomOnlineStatusManager", 4, ((StringBuilder)localObject1).toString());
        localObject2 = new StringBuilder();
        if (bool1) {
          localObject1 = "need update online status";
        } else {
          localObject1 = "not need update online status";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" for ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        QLog.d("CustomOnlineStatusManager", 4, ((StringBuilder)localObject2).toString());
        bool2 = bool1;
      }
    }
    if (bool2) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getOnlineInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = this.jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("friendchatpie onShow_otherThings, ");
          localStringBuilder.append(localNumberFormatException.toString());
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
      }
    }
    if (this.L)
    {
      this.L = false;
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, true);
    }
    super.J();
    if (!((INewFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class)).handleNewFrdAIOShow(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ChatActivityFacade.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    aq();
  }
  
  protected void O()
  {
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBabyQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBabyQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 29)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel = ((BabyQAIOPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558525, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a(this);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openBabyQPanel:");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.d("OpenPanel", 2, localStringBuilder.toString());
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel;
    }
    return super.a(paramInt);
  }
  
  protected AIOContext a()
  {
    return new FriendAIOContext();
  }
  
  protected AIOInput a()
  {
    return new AIOInputBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new FriendMessageSender(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new FriendScroller()).a(new FriendListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected HelperProvider a()
  {
    return new FriendHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public EntryModel a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      return new EntryModel(0, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, false);
    }
    return super.a();
  }
  
  public RecordParams.RecorderParam a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      boolean bool = ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).b();
      return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
    }
    return new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
  }
  
  protected String a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    if (this.I)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.I);
      this.I = false;
    }
    if (this.K)
    {
      this.K = false;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (Integer.valueOf(paramInt).intValue() == 29)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
      BabyQAIOPanel localBabyQAIOPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel;
      if (localBabyQAIOPanel != null) {
        localBabyQAIOPanel.a();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806C", "0X800806C", 0, 0, "", "", "", "");
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
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setFriendComment(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent, false);
          QZoneHelper.restartQzone();
          return;
        }
        new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(2131693362, a(), 0, 1);
        return;
      }
      new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(2131694473, a(), 0, 1);
    }
  }
  
  protected void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
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
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(QIMUserManager.a().a(2130850433));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850474);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130851070);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(QIMUserManager.a().b(2));
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(QIMUserManager.a().b(2));
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(TIMUserManager.a().a(2130850433));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850474);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130851070);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(TIMUserManager.a().b(2));
      }
      else
      {
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(TIMUserManager.a().b(2));
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850433);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850473, 2130850474);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130851069, 2130851070);
      if (this.jdField_a_of_type_AndroidViewViewStub != null) {
        this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
    long l2 = System.currentTimeMillis();
    paramIntent = new StringBuilder();
    paramIntent.append("set title time:");
    paramIntent.append(l2 - l1);
    QLog.d("shinkencai", 2, paramIntent.toString());
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131378040)
    {
      int i = this.jdField_g_of_type_Int;
      if (i == 1)
      {
        ((C2CListenTogetherPanel)a(32)).b();
        return;
      }
      if (i == 2) {
        ((TogetherControlHelper)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
        ((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER)).a(paramObject);
      }
    }
  }
  
  protected void a(String paramString)
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    AioFriendTitleHelper localAioFriendTitleHelper = (AioFriendTitleHelper)a(45);
    if ((localAioFriendTitleHelper != null) && (localAioFriendTitleHelper.a(paramBoolean, paramString))) {
      return;
    }
    a().runOnUiThread(new FriendChatPie.20(this, paramString, paramBoolean));
  }
  
  protected boolean a()
  {
    boolean bool2 = this.x;
    boolean bool1 = false;
    if ((bool2) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    String str = localIntent.getStringExtra("PREVIOUS_WINDOW");
    if ((str != null) && (str.equals(((Class)localObject).getName()))) {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    }
    this.D = true;
    if (localIntent.getBooleanExtra("open_chat_from_avator", false))
    {
      localObject = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel())
      {
        str = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("upload avator ");
        localStringBuilder.append((String)localObject);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (localObject != null) {
        if (ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, localIntent))
        {
          QQToast.a(a(), 2, 2131718782, 0).b(a());
          if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            ThreadManager.executeOnSubThread(new FriendChatPie.1(this), true);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
        }
        else
        {
          QQToast.a(a(), 1, 2131718781, 0).b(a());
        }
      }
    }
    this.E = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
    if (this.E) {
      h(localIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j = this.E;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager = new FriendShipViewManager(a());
    localIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqMutualmarkOldlogicReCheckInHelper = new ReCheckInHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return super.a(paramBoolean);
  }
  
  public void af()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "==refreshTitleReativeIcon==");
    }
    t();
  }
  
  protected void aj()
  {
    super.aj();
    if (SimpleUIUtil.a())
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "FriendChatPie updateUI_titleBarForTheme, SimpleUIMode is open now");
      return;
    }
    int i = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    if ((i != 2) && (i != 3)) {
      return;
    }
    try
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167202));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  public void am()
  {
    super.am();
    Object localObject1 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {
      localObject1 = ((Card)localObject1).strReMark;
    } else {
      localObject1 = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("-grayTipsRemarkMention");
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!((SharedPreferences)localObject1).getBoolean((String)localObject2, false))
      {
        ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, true).apply();
        FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void ao()
  {
    Object localObject = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    AllInOne localAllInOne = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
    localAllInOne.nickname = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(localAllInOne.nickname)) || (localAllInOne.nickname.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      localAllInOne.nickname = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
    }
    localAllInOne.preWinUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localAllInOne.preWinType = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localAllInOne.lastActivity = 2;
    localAllInOne.profileEntryType = 117;
    ProfileCardInfo localProfileCardInfo = new ProfileCardInfo();
    localProfileCardInfo.card = ((Card)localObject);
    localProfileCardInfo.allInOne = localAllInOne;
    localObject = BusinessCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localProfileCardInfo);
    ProfileCardUtil.a(a(), (BusinessCard)localObject, localAllInOne);
  }
  
  public void ap()
  {
    if ((this.h != null) && (this.jdField_f_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_e_of_type_AndroidWidgetTextView != null))
    {
      if (this.jdField_g_of_type_AndroidWidgetTextView == null) {
        return;
      }
      Object localObject = (C2CListenTogetherPanel)a(32);
      boolean bool1 = ((C2CListenTogetherPanel)localObject).c();
      boolean bool2 = ((C2CListenTogetherPanel)localObject).d();
      TogetherControlHelper localTogetherControlHelper = (TogetherControlHelper)a(43);
      boolean bool3 = localTogetherControlHelper.c();
      int i;
      if (bool1)
      {
        this.jdField_g_of_type_Int = 1;
        a(true);
        a(((C2CListenTogetherPanel)localObject).a(bool2));
        b(bool2, false);
        i = AIOUtils.b(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0, this.c.getRootView());
      }
      else if (bool3)
      {
        this.jdField_g_of_type_Int = 2;
        a(true);
        bool3 = localTogetherControlHelper.a();
        a(localTogetherControlHelper.a());
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
        b(bool3, localTogetherControlHelper.d());
        localObject = (AioFriendTitleHelper)a(45);
        i = AIOUtils.b(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0, this.c.getRootView());
      }
      else
      {
        this.h.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetTextView.setClickable(true);
        this.jdField_b_of_type_AndroidViewViewGroup.setClickable(false);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
        BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, this.c.getRootView());
        this.jdField_g_of_type_Int = 0;
        a("");
        ((OnlineStatusHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(129)).b();
        localObject = (AioFriendTitleHelper)a(45);
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
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    t();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_g_of_type_AndroidWidgetImageView, this.z);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new FriendChatPie.17(this));
  }
  
  protected void b(Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
      if (localInputStatusHelper != null)
      {
        if (paramObject.isSend())
        {
          localInputStatusHelper.d();
          return;
        }
        if (paramObject.time > localInputStatusHelper.b) {
          as();
        }
      }
    }
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "FriendChatPie";
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    ThreadManager.post(new FriendChatPie.15(this), 5, null, false);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  protected void c(Object paramObject)
  {
    if ((paramObject instanceof MessageForText))
    {
      paramObject = (MessageForText)paramObject;
      String str = paramObject.msg;
      if (paramObject.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in FriendChatPie.update()");
        }
        AioVipKeywordHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObject, str, this.jdField_a_of_type_AndroidContentContext, paramObject.isSend());
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.J) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    if (this.E) {
      ar();
    }
    super.c(paramBoolean);
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.G = false;
  }
  
  public boolean d()
  {
    if ((this.J) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    if (this.E) {
      ar();
    }
    return super.d();
  }
  
  protected void f()
  {
    super.f();
    this.jdField_b_of_type_Boolean = false;
    com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController$AIOTipsListener);
  }
  
  protected void f(int paramInt)
  {
    super.f(paramInt);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)a(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.c(9);
    }
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
    OldMutualMarkLogicHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    ((FriendListUI)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a()).a();
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      BabyQHandler localBabyQHandler = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if ((localBabyQHandler != null) && (localBabyQHandler.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
        localBabyQHandler.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
    }
    ThreadManager.post(new FriendChatPie.16(this), 5, null, true);
    TopicReplyUtil.b(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    at();
    au();
  }
  
  protected void h()
  {
    if (((QidianHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(61)).a(false)) {
      this.jdField_b_of_type_Boolean = true;
    }
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
          if (j != 201) {
            return super.handleMessage(paramMessage);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String[])))
          {
            paramMessage = (String[])paramMessage.obj;
            if (paramMessage.length >= 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager.a(3, paramMessage[0], paramMessage[1]);
              return true;
            }
          }
        }
        else
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager;
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
        paramMessage = this.j;
        if (j == 0) {
          i = 8;
        }
        paramMessage.setVisibility(i);
        return true;
      }
    }
    else
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager;
      if (paramMessage != null) {
        paramMessage.a(1);
      }
    }
    return true;
  }
  
  protected void j()
  {
    int i;
    if ((!Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.d.setOnClickListener(new FriendChatPie.4(this));
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.d.setVisibility(0);
        this.d.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698601));
        return;
      }
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(4);
    ThreadManager.post(new FriendChatPie.5(this), 5, null, false);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131369216)
    {
      SingTogetherConfigBean.GeneralTogetherItem localGeneralTogetherItem = ((SingTogetherConfigBean)QConfigManager.a().a(551)).a(4);
      if ((localGeneralTogetherItem != null) && (localGeneralTogetherItem.d > 0))
      {
        if (localGeneralTogetherItem.c != 1) {
          int i = localGeneralTogetherItem.d;
        }
        ((FetchOpenIdManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localGeneralTogetherItem.d, true);
      }
      if ((this.j != null) && (this.j.getVisibility() == 0) && (TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false)) && (localGeneralTogetherItem != null) && (localGeneralTogetherItem.jdField_a_of_type_Boolean)) {
        TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", false, false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      ThreadManager.getSubThreadHandler().post(new FriendChatPie.2(this));
    }
    if (this.B)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    if (this.E) {
      ar();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4022);
    }
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a();
    }
    this.D = false;
    super.p();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a.setCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a = null;
    }
    IFriendShipAnimManager localIFriendShipAnimManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager;
    if (localIFriendShipAnimManager != null) {
      localIFriendShipAnimManager.c();
    }
    this.K = false;
    ((QQStoryFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQ_STORY_FEED_MANAGER)).a();
    if (this.d != null) {
      this.d.setOnClickListener(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a().a(null);
    av();
  }
  
  public boolean q()
  {
    return this.N;
  }
  
  public void t()
  {
    super.t();
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).b();
    }
  }
  
  @TargetApi(16)
  public boolean t()
  {
    Object localObject = MutualMarkDataCenter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && ((((Pair)localObject).first != null) || (((Pair)localObject).second != null)))
    {
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null) {
        this.jdField_a_of_type_AndroidViewView$OnTouchListener = new FriendChatPie.18(this);
      }
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = (MutualMarkForDisplayInfo)((Pair)localObject).first;
      localObject = (MutualMarkForDisplayInfo)((Pair)localObject).second;
      if (localMutualMarkForDisplayInfo != null)
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localMutualMarkForDisplayInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
        this.jdField_e_of_type_AndroidWidgetImageView.setTag(localMutualMarkForDisplayInfo);
        this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      else
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      }
      if (localObject != null)
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (MutualMarkForDisplayInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
        this.jdField_f_of_type_AndroidWidgetImageView.setTag(localObject);
        this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      else
      {
        this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localMutualMarkForDisplayInfo, (MutualMarkForDisplayInfo)localObject);
      MutualMarkBusinessLogicHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localMutualMarkForDisplayInfo, (MutualMarkForDisplayInfo)localObject);
      if (QLog.isColorLevel())
      {
        String str = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateSession_updateInteractive one:");
        localStringBuilder.append(localMutualMarkForDisplayInfo);
        localStringBuilder.append(" two:");
        localStringBuilder.append(localObject);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
    return false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageForPokeEmo))
    {
      localObject = (MessageForPokeEmo)paramObject;
      if ((((MessageForPokeEmo)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!((MessageForPokeEmo)localObject).isread)) {
        ((MessageForPokeEmo)localObject).setIsNeedPlayed(true);
      }
    }
    a(paramObject);
    if (((paramObject instanceof ChatMessage)) && (l()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.F)) {
        OldMutualMarkLogicHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      }
    }
    super.update(paramObservable, paramObject);
    c(paramObject);
    ChatActivityFacade.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    b(paramObject);
  }
  
  public void v()
  {
    super.v();
    IFriendShipAnimManager localIFriendShipAnimManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager;
    if (localIFriendShipAnimManager != null) {
      localIFriendShipAnimManager.b();
    }
  }
  
  protected void w()
  {
    super.w();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(true);
    IFriendShipAnimManager localIFriendShipAnimManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager;
    if (localIFriendShipAnimManager != null) {
      localIFriendShipAnimManager.a();
    }
  }
  
  public void y()
  {
    super.y();
    AIOOpenState.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie
 * JD-Core Version:    0.7.0.1
 */