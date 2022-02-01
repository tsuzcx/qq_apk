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
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOTipsController.AIOTipsListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.friendship.IFriendShipAnimManager;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipViewManager;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.FriendListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.drawer.AIODrawerDpc;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.IntimateInfoChatDrawer;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.WpaThirdAppStructMsgUtil;
import com.tencent.mobileqq.activity.aio.reply.ReplyMsgUtils;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.StrangerObserver;
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
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel;
import com.tencent.mobileqq.listentogether.ui.C2CListenTogetherPanel;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper;
import com.tencent.mobileqq.mutualmark.oldlogic.ReCheckInHelper;
import com.tencent.mobileqq.observer.VipGifObserver;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper;
import com.tencent.mobileqq.richstatus.topic.TopicReplyUtil;
import com.tencent.mobileqq.servlet.ReduFriendObserver;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.theme.ThemeUtil;
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
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.XPanelContainer;
import cooperation.qzone.api.QZoneEventHandler;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime.Status;
import mqq.os.MqqHandler;

public class FriendChatPie
  extends BaseChatPie
{
  public boolean N = false;
  boolean O = false;
  public boolean P = false;
  public boolean Q = false;
  boolean R = false;
  private boolean S = false;
  private boolean T = false;
  private boolean U = false;
  private boolean V = true;
  private boolean W = false;
  private boolean X = false;
  private boolean Y = false;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  AIOTipsController.AIOTipsListener jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController$AIOTipsListener = new FriendChatPie.25(this);
  protected BabyQAIOPanel a;
  IFriendShipAnimManager jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager;
  protected FriendHotTipsBar a;
  GamePartyTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar;
  BabyQObserver jdField_a_of_type_ComTencentMobileqqAppBabyQObserver = new FriendChatPie.13(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new FriendChatPie.14(this);
  protected MessageObserver a;
  private StrangerObserver jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new FriendChatPie.10(this);
  IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new FriendChatPie.15(this);
  ReCheckInHelper jdField_a_of_type_ComTencentMobileqqMutualmarkOldlogicReCheckInHelper;
  protected VipGifObserver a;
  private OneWayFriendHelper jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper;
  private ReduFriendObserver jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver = new FriendChatPie.9(this);
  TeamWorkObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver = new FriendChatPie.23(this);
  public QidianManager a;
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new FriendChatPie.18(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new FriendChatPie.16(this);
  private long jdField_b_of_type_Long = -1L;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new FriendChatPie.4(this);
  Runnable jdField_b_of_type_JavaLangRunnable = new FriendChatPie.3(this);
  private View.OnClickListener c;
  String f;
  protected int k = 0;
  View m;
  
  public FriendChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new FriendChatPie.5(this);
    this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver = new FriendChatPie.8(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new FriendChatPie.11(this);
    if (paramQQAppInterface.isCreateManager(QQManagerFactory.QIDIAN_MANAGER)) {
      this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
  }
  
  private int a(int[] paramArrayOfInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this).indexOf(paramArrayOfInt);
  }
  
  private void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onUpdateSendMsgError uin " + paramString + " type " + paramInt + " uniseq " + paramLong);
    }
    MessageRecord localMessageRecord;
    boolean bool;
    if (paramInt == 0)
    {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong);
      if ((localMessageRecord != null) && (localMessageRecord.msgtype == -2058) && ((localMessageRecord.extraflag == 32768) || (localMessageRecord.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onUpdateSendMsgError, sticker msg is failed!");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord, false);
        paramString = UinTypeUtil.a(paramString, paramInt);
        if (!EmojiStickerManager.a().b.containsKey(paramString)) {
          break label263;
        }
        paramLong = ((Long)EmojiStickerManager.a().b.get(paramString)).longValue();
        if (System.currentTimeMillis() - paramLong <= 300000L) {
          break label269;
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "send sticker msg fail, is need send Toast " + bool);
      }
      if (bool)
      {
        EmojiStickerManager.a().b.put(paramString, Long.valueOf(System.currentTimeMillis()));
        ThreadManager.getUIHandler().post(new FriendChatPie.12(this, localMessageRecord));
      }
      return;
      label263:
      bool = true;
      continue;
      label269:
      bool = false;
    }
  }
  
  private void bj()
  {
    Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    boolean bool;
    OnlineStatusItem localOnlineStatusItem;
    if ((localFriends != null) && ((ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType) != 0) || ((!TextUtils.isEmpty(localFriends.strTermDesc)) && (localFriends.strTermDesc.contains("TIM"))))) {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        bool = true;
        localOnlineStatusItem = OnLineStatusHelper.a().a(AppRuntime.Status.online, localFriends.uExtOnlineStatus, bool);
        if ((ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType) != 4) || (localOnlineStatusItem.a <= 0L) || (localOnlineStatusItem == null)) {
          break label227;
        }
        bool = true;
        label132:
        String str = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends, this.jdField_f_of_type_AndroidWidgetTextView, 1, localOnlineStatusItem, Boolean.valueOf(bool));
        if ((TextUtils.isEmpty(str)) || (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break label232;
        }
        b(true);
        this.jdField_f_of_type_JavaLangString = str;
        c(str);
        OnLineStatusHelper.a().a(localFriends, this.jdField_f_of_type_AndroidWidgetTextView, false, localOnlineStatusItem);
        if (jdField_a_of_type_Boolean) {
          this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(str);
        }
      }
    }
    label227:
    label232:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        bool = false;
        break label132;
        b(false);
        OnLineStatusHelper.a().a(localFriends, this.jdField_f_of_type_AndroidWidgetTextView, true, localOnlineStatusItem);
        return;
      } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
      b(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 5);
    FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
  }
  
  private void bk()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167030));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167030));
      Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localFriends == null) || ((ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType) == 0) && (TextUtils.isEmpty(localFriends.strTermDesc)))) {
        break label256;
      }
      c(ContactUtils.b(localFriends));
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(2.0F, BaseApplicationImpl.getContext().getResources()));
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(QIMUserManager.a().b(5), null, null, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 2, 0, "", "", "", "");
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "not setOnClickListener");
      }
      b(true);
    }
    label256:
    do
    {
      do
      {
        return;
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167031));
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167031));
        break;
      } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
      b(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 5);
    FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
  }
  
  private void bl()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167030));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167030));
      Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localFriends == null) || ((ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType) == 0) && (TextUtils.isEmpty(localFriends.strTermDesc)))) {
        break label193;
      }
      c(ContactUtils.b(localFriends));
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(2.0F, BaseApplicationImpl.getContext().getResources()));
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(TIMUserManager.a().b(5), null, null, null);
      b(true);
    }
    label193:
    while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167031));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167031));
      break;
    }
    b(false);
  }
  
  private void bm()
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
  
  private void bn()
  {
    if (this.Y) {
      return;
    }
    ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.Y = true;
  }
  
  private void bo()
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.b();
    }
  }
  
  private void bp()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper = new OneWayFriendHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper.a(new FriendChatPie.26(this));
    }
  }
  
  private void bq()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper.a();
    }
  }
  
  private void br()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper.b();
      this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper = null;
    }
  }
  
  private void c(long paramLong)
  {
    VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
    if ((localVipGiftDownloadInfo != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && (localVipGiftDownloadInfo.jdField_b_of_type_JavaLangString.equalsIgnoreCase(b())) && (localVipGiftDownloadInfo.d == 2L) && (paramLong == localVipGiftDownloadInfo.a)) {
      localVipGiftManager.a(localVipGiftDownloadInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      int i;
      if (paramBoolean1)
      {
        i = 2130844113;
        localObject = ((Resources)localObject).getDrawable(i);
        if ((!SimpleUIUtil.a()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label132;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030), PorterDuff.Mode.MULTIPLY);
        label64:
        if (!paramBoolean1) {
          break label166;
        }
        label68:
        this.jdField_f_of_type_AndroidWidgetTextView.setClickable(false);
        if (!paramBoolean2) {
          break label196;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
        this.jdField_b_of_type_AndroidViewViewGroup.setClickable(true);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
        return;
        i = 2130844120;
        break;
        label132:
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
        {
          ((Drawable)localObject).clearColorFilter();
          break label64;
        }
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        break label64;
        label166:
        ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        break label68;
        label196:
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h(Intent paramIntent)
  {
    this.Y = false;
    String str = paramIntent.getStringExtra("uin");
    this.R = paramIntent.getBooleanExtra("open_chat_from_frd_rank_confess", false);
    ConfessManager localConfessManager = (ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
    if (this.R)
    {
      this.O = localConfessManager.c(str, paramIntent);
      return;
    }
    this.O = localConfessManager.a(str, paramIntent);
  }
  
  public boolean B()
  {
    return this.X;
  }
  
  @TargetApi(16)
  public boolean E()
  {
    Object localObject = MutualMarkDataCenter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || ((((Pair)localObject).first == null) && (((Pair)localObject).second == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new FriendChatPie.22(this);
    }
    MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = (MutualMarkForDisplayInfo)((Pair)localObject).first;
    localObject = (MutualMarkForDisplayInfo)((Pair)localObject).second;
    if (localMutualMarkForDisplayInfo != null)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localMutualMarkForDisplayInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_e_of_type_AndroidWidgetImageView.setTag(localMutualMarkForDisplayInfo);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      if (localObject == null) {
        break label259;
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (MutualMarkForDisplayInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_f_of_type_AndroidWidgetImageView.setTag(localObject);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localMutualMarkForDisplayInfo, (MutualMarkForDisplayInfo)localObject);
      MutualMarkBusinessLogicHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localMutualMarkForDisplayInfo, (MutualMarkForDisplayInfo)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updateSession_updateInteractive one:" + localMutualMarkForDisplayInfo + " two:" + localObject);
      }
      return true;
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      break;
      label259:
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
    }
  }
  
  protected void F()
  {
    if (((C2CListenTogetherPanel)a(32)).c()) {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "updateOnlineStatus, isListenTogetherTime");
      }
    }
    do
    {
      return;
      if (!((TogetherControlHelper)a(43)).c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_b_of_type_JavaLangString, 2, "updateOnlineStatus, isTogetherTime");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))
    {
      bk();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      bl();
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167030));
    this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167030));
    this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    if ((CustomOnlineStatusManager.a().a()) || (OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "setOnClickListener");
      }
      if ((!this.jdField_c_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || (o())) {
        break;
      }
      bj();
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(null);
    }
  }
  
  public void J()
  {
    if (this.jdField_b_of_type_Long > 0L) {
      ThreadManager.getSubThreadHandler().post(new FriendChatPie.2(this));
    }
    if (this.I)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    if (this.O) {
      bn();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4022);
    }
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a();
    }
    this.N = false;
    super.J();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a.setCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager.c();
    }
    this.U = false;
    ((QQStoryFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQ_STORY_FEED_MANAGER)).a();
    if (this.d != null) {
      this.d.setOnClickListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(null);
    }
    br();
  }
  
  public void M()
  {
    super.M();
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).b();
    }
  }
  
  public void O()
  {
    super.O();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager.b();
    }
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager.a();
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 29)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel = ((BabyQAIOPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558625, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "openBabyQPanel:" + (System.currentTimeMillis() - l));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel;
    }
    return super.a(paramInt);
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new FriendListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public BaseChatDrawer a()
  {
    if (!AIODrawerDpc.a())
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, not support!");
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    if ((!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(String.valueOf(66600000L))))
    {
      QLog.d("intimate_relationship", 1, String.format("createChatDrawer, not friendUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
      return null;
    }
    if (!FriendIntimateRelationshipHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "aio intimate is close");
      }
      return null;
    }
    return new IntimateInfoChatDrawer(this);
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
      boolean bool = super.s();
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
    Object localObject = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
    localAllInOne.jdField_h_of_type_JavaLangString = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(localAllInOne.jdField_h_of_type_JavaLangString)) || (localAllInOne.jdField_h_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      localAllInOne.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
    }
    localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localAllInOne.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localAllInOne.g = 2;
    localAllInOne.jdField_h_of_type_Int = 117;
    ProfileCardInfo localProfileCardInfo = new ProfileCardInfo();
    localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
    localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
    localObject = BusinessCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localProfileCardInfo);
    ProfileCardUtil.a(a(), (BusinessCard)localObject, localAllInOne);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QZoneEventHandler.handleActivityEvent(this, paramInt1, paramInt2, paramIntent)) {}
    do
    {
      do
      {
        return;
        super.a(paramInt1, paramInt2, paramIntent);
        if (paramInt1 != 13008) {
          break;
        }
      } while (paramIntent == null);
      String str = paramIntent.getStringExtra("result");
      paramIntent = str;
      if (str == null) {
        paramIntent = "";
      }
      if (NetworkUtil.d(BaseApplication.getContext()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setFriendComment(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent, false);
          paramIntent = new QZoneDistributedAppCtrl.Control();
          paramIntent.cmd = 5;
          QZoneDistributedAppCtrl.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).submitCtrl(paramIntent);
          return;
        }
        new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(2131693407, a(), 0, 1);
        return;
      }
      new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(2131694507, a(), 0, 1);
      return;
    } while (paramInt1 != 13009);
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "refreshHeadMessage==> aio cache is find! origUid" + paramLong1 + ", time" + paramLong2);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong2, paramLong1);
    int i;
    MessageRecord localMessageRecord;
    if ((localList != null) && (localList.size() > 0))
    {
      i = 0;
      if (i >= localList.size()) {
        break label289;
      }
      localMessageRecord = (MessageRecord)localList.get(i);
      if ((MsgProxyUtils.b(localMessageRecord)) || ((localMessageRecord instanceof MessageForSafeGrayTips))) {
        break label186;
      }
    }
    for (;;)
    {
      if ((localMessageRecord != null) && (!UniteGrayTipUtil.a(localMessageRecord)))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(localMessageRecord.uniseq);
        if (i != -1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt1, i, i, null, 10);
        }
      }
      label186:
      do
      {
        do
        {
          return;
          i += 1;
          break;
          if (localMessageRecord.msgtype == -2006) {
            QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, HardCodeUtil.a(2131704889), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          }
        } while (paramInt2 != 1);
        ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
        return;
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697693, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      } while (paramInt2 != 1);
      ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
      return;
      label289:
      localMessageRecord = null;
    }
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, Runnable paramRunnable)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697207, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      if (paramInt2 == 1) {
        ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
      }
    }
    do
    {
      return;
      if (ReplyMsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong2, paramLong1) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "refreshHeadMessage==> db is find! origUid" + paramLong1 + ", time" + paramLong2);
        }
        ((FriendListUI)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a()).a(paramLong1, paramLong2, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt1, 0, -1, paramRunnable, 10);
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697693, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    } while (paramInt2 != 1);
    ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, MessageRecord paramMessageRecord)
  {
    a(paramInt, paramLong1, paramLong2, paramMessageRecord, 0, 0);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, MessageRecord paramMessageRecord, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "refreshHeadMessage==>type:" + paramInt1 + "|origUid:" + paramLong1);
    }
    paramMessageRecord = new FriendChatPie.17(this);
    boolean bool = a(paramLong1, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c(paramInt2);
    if (!bool)
    {
      a(paramInt1, paramLong1, paramLong2, paramInt3, paramMessageRecord);
      return;
    }
    a(paramInt1, paramLong1, paramLong2, paramInt3);
  }
  
  protected void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showAddFriendActivity-->uinType=" + paramInt1 + " peerUin=" + paramString1 + " name=" + paramString2 + " phoneNum=" + paramString3 + " srcId=" + paramInt2);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(QIMUserManager.a().a(2130850507));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850548);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130851154);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(QIMUserManager.a().b(2));
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("shinkencai", 2, "set title time:" + (l2 - l1));
      return;
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(QIMUserManager.a().b(2));
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(TIMUserManager.a().a(2130850507));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850548);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130851154);
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(TIMUserManager.a().b(2));
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(TIMUserManager.a().b(2));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850507);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850547, 2130850548);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130851153, 2130851154);
        if (this.jdField_a_of_type_AndroidViewViewStub != null) {
          this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
        }
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131378647)
    {
      if (this.k == 1) {
        ((C2CListenTogetherPanel)a(32)).b();
      }
      while (this.k != 2) {
        return;
      }
      ((TogetherControlHelper)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    super.a(paramView);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (this.S)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.S);
      this.S = false;
    }
    if (this.U)
    {
      this.U = false;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
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
  
  protected boolean a()
  {
    boolean bool = false;
    if ((this.D) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  protected boolean a(long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      ChatMessage localChatMessage;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
      } while ((MsgProxyUtils.b(localChatMessage)) || (localChatMessage.msgUid != paramLong1) || (localChatMessage.time != paramLong2));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "refreshHeadMessage==>isFind:" + bool);
      }
      return bool;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    String str = localIntent.getStringExtra("PREVIOUS_WINDOW");
    if ((str != null) && (str.equals(FriendProfileCardActivity.class.getName()))) {
      this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
    }
    this.N = true;
    if (localIntent.getBooleanExtra("open_chat_from_avator", false))
    {
      str = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "upload avator " + str);
      }
      if (str != null)
      {
        if (!ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localIntent)) {
          break label274;
        }
        QQToast.a(a(), 2, 2131719066, 0).b(a());
        if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          ThreadManager.executeOnSubThread(new FriendChatPie.1(this), true);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.O = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
      if (this.O) {
        h(localIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j = this.O;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager = new FriendShipViewManager(a());
      localIntent.getStringExtra("uin");
      this.jdField_a_of_type_ComTencentMobileqqMutualmarkOldlogicReCheckInHelper = new ReCheckInHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return super.a(paramBoolean);
      label274:
      QQToast.a(a(), 1, 2131719065, 0).b(a());
    }
  }
  
  public void aL()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "==refreshTitleReativeIcon==");
    }
    E();
  }
  
  protected void aP()
  {
    super.aP();
    if (SimpleUIUtil.a())
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "FriendChatPie updateUI_titleBarForTheme, SimpleUIMode is open now");
      return;
    }
    switch (VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))
    {
    default: 
      return;
    }
    try
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167177));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  protected void ac()
  {
    StartupTracker.a(null, "AIO_onShow_business");
    super.ac();
    this.T = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.S = WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    StartupTracker.a("AIO_onShow_business", null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
  }
  
  protected void ad()
  {
    boolean bool1;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.isGetOnlineListRecently()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.shouldGetOnlineInfo())) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      String str;
      if (!bool1)
      {
        bool2 = CustomOnlineStatusManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (QLog.isDevelopLevel())
        {
          QLog.d("CustomOnlineStatusManager", 4, "not update friend online info\nisGetOnlineListRecently = " + this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.isGetOnlineListRecently() + "\nshouldGetOnlineInfo = " + this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.shouldGetOnlineInfo());
          StringBuilder localStringBuilder = new StringBuilder();
          if (!bool2) {
            break label292;
          }
          str = "need update online status";
          QLog.d("CustomOnlineStatusManager", 4, str + " for " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
      if (bool2) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getOnlineInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
        if (this.V)
        {
          this.V = false;
          ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, true);
        }
        super.ad();
        if (!((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          ChatActivityFacade.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          ChatActivityFacade.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        bm();
        return;
        bool1 = false;
        continue;
        label292:
        str = "not need update online status";
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "friendchatpie onShow_otherThings, " + localNumberFormatException.toString());
          }
        }
      }
    }
  }
  
  protected void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBabyQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
  }
  
  protected void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBabyQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
  }
  
  public void ao()
  {
    super.ao();
    if (this.S)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.S);
      this.S = false;
    }
    if (this.U)
    {
      this.U = false;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    E();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_g_of_type_AndroidWidgetImageView, this.G);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new FriendChatPie.21(this));
  }
  
  protected void b(Object paramObject)
  {
    if (((paramObject instanceof MessageForStructing)) && (((MessageForStructing)paramObject).isread))
    {
      paramObject = (MessageForStructing)paramObject;
      if ((paramObject.structingMsg == null) || (paramObject.structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(paramObject.structingMsg.mResid)) || (!((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER)).a(paramObject))) {}
    }
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    AioFriendTitleHelper localAioFriendTitleHelper = (AioFriendTitleHelper)a(45);
    if ((localAioFriendTitleHelper != null) && (localAioFriendTitleHelper.a(paramBoolean, paramString))) {
      return;
    }
    a().runOnUiThread(new FriendChatPie.24(this, paramString, paramBoolean));
  }
  
  public void be()
  {
    super.be();
    Object localObject1 = "";
    Object localObject2 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localObject2 != null) {
      localObject1 = ((Card)localObject2).strReMark;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "-" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "-grayTipsRemarkMention";
      if (!((SharedPreferences)localObject1).getBoolean((String)localObject2, false))
      {
        ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, true).apply();
        FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  protected void bf()
  {
    super.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
  }
  
  public void bi()
  {
    if ((this.h == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_g_of_type_AndroidWidgetTextView == null)) {}
    for (;;)
    {
      return;
      Object localObject = (C2CListenTogetherPanel)a(32);
      boolean bool1 = ((C2CListenTogetherPanel)localObject).c();
      boolean bool2 = ((C2CListenTogetherPanel)localObject).d();
      TogetherControlHelper localTogetherControlHelper = (TogetherControlHelper)a(43);
      boolean bool3 = localTogetherControlHelper.c();
      int i;
      if (bool1)
      {
        this.k = 1;
        b(true);
        c(((C2CListenTogetherPanel)localObject).a(bool2));
        e(bool2, false);
        i = AIOUtils.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseListenTogetherPanel_C2C", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
        return;
        if (bool3)
        {
          this.k = 2;
          b(true);
          bool3 = localTogetherControlHelper.a();
          c(localTogetherControlHelper.a());
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
          e(bool3, localTogetherControlHelper.d());
          localObject = (AioFriendTitleHelper)a(45);
          i = AIOUtils.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
          BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
        }
        else
        {
          this.h.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetTextView.setClickable(true);
          this.jdField_b_of_type_AndroidViewViewGroup.setClickable(false);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          BaseListenTogetherPanel.a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
          this.k = 0;
          c("");
          F();
          localObject = (AioFriendTitleHelper)a(45);
          if (localObject != null) {
            ((AioFriendTitleHelper)localObject).b("");
          }
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
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      CrmUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    ThreadManager.post(new FriendChatPie.19(this), 5, null, false);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  protected void c(Object paramObject)
  {
    InputStatusHelper localInputStatusHelper;
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      localInputStatusHelper = (InputStatusHelper)a(16);
      if (localInputStatusHelper != null)
      {
        if (!paramObject.isSend()) {
          break label38;
        }
        localInputStatusHelper.d();
      }
    }
    label38:
    while (paramObject.time <= localInputStatusHelper.jdField_b_of_type_Long) {
      return;
    }
    bo();
  }
  
  protected void c(String paramString)
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.a(paramString);
    }
  }
  
  protected boolean c()
  {
    return B();
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.Q = false;
  }
  
  protected void d(Object paramObject)
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
  
  public void e(boolean paramBoolean)
  {
    if ((this.T) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    if (this.O) {
      bn();
    }
    super.e(paramBoolean);
  }
  
  public boolean g()
  {
    if ((this.T) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    if (this.O) {
      bn();
    }
    return super.g();
  }
  
  protected void h(int paramInt)
  {
    super.h(paramInt);
    ShortcutBarAIOHelper localShortcutBarAIOHelper = (ShortcutBarAIOHelper)a(52);
    if (localShortcutBarAIOHelper != null) {
      localShortcutBarAIOHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.handleMessage(paramMessage);
    case 70: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager.a(1);
        return true;
      }
      break;
    case 88: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager.a(2);
        return true;
      }
      break;
    case 85: 
      int i = paramMessage.arg1;
      paramMessage = this.j;
      if (i == 0) {}
      for (i = 8;; i = 0)
      {
        paramMessage.setVisibility(i);
        return true;
      }
    case 201: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String[])))
      {
        paramMessage = (String[])paramMessage.obj;
        if (paramMessage.length >= 2) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipIFriendShipAnimManager.a(3, paramMessage[0], paramMessage[1]);
        }
        return true;
      }
      break;
    }
    return true;
  }
  
  protected void j()
  {
    super.j();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.a = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController$AIOTipsListener);
    }
  }
  
  protected void k()
  {
    super.k();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = new LightalkBlueTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
  }
  
  public void m(int paramInt)
  {
    super.m(paramInt);
    if (BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
    OldMutualMarkLogicHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    ((FriendListUI)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a()).a();
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if ((localObject != null) && (((BabyQHandler)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
        ((BabyQHandler)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
    }
    if (((this instanceof BusinessCmrTmpChatPie)) || (BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      aE();
      if (this.jdField_a_of_type_ComTencentQidianQidianManager != null) {
        break label252;
      }
    }
    label252:
    for (Object localObject = "";; localObject = this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.5.5", "");
      ThreadManager.post(new FriendChatPie.20(this), 5, null, true);
      TopicReplyUtil.b(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      bp();
      bq();
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    SingTogetherConfigBean.GeneralTogetherItem localGeneralTogetherItem;
    if (paramView.getId() == 2131369501)
    {
      localGeneralTogetherItem = ((SingTogetherConfigBean)QConfigManager.a().a(551)).a(4);
      if ((localGeneralTogetherItem != null) && (localGeneralTogetherItem.d > 0))
      {
        if (localGeneralTogetherItem.c != 1) {
          break label109;
        }
        ((FetchOpenIdManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localGeneralTogetherItem.d, true);
      }
      if ((this.j != null) && (this.j.getVisibility() == 0)) {
        break label117;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label109:
      int i = localGeneralTogetherItem.d;
      break;
      label117:
      if ((TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false)) && (localGeneralTogetherItem != null) && (localGeneralTogetherItem.jdField_a_of_type_Boolean)) {
        TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", false, false);
      }
    }
  }
  
  protected void t()
  {
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))) {
      this.jdField_b_of_type_Boolean = true;
    }
    F();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageForPokeEmo))
    {
      localObject = (MessageForPokeEmo)paramObject;
      if ((((MessageForPokeEmo)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (((MessageForPokeEmo)localObject).isread)) {
        ((MessageForPokeEmo)localObject).setIsNeedPlayed(true);
      }
    }
    b(paramObject);
    if (((paramObject instanceof ChatMessage)) && (t()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.P)) {
        OldMutualMarkLogicHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      }
    }
    super.update(paramObservable, paramObject);
    d(paramObject);
    ChatActivityFacade.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    c(paramObject);
  }
  
  protected void v()
  {
    int i;
    if ((!Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      i = 1;
    }
    while (i != 0)
    {
      this.d.setOnClickListener(new FriendChatPie.6(this));
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.d.setVisibility(0);
        this.d.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698535));
        return;
        i = 0;
      }
      else
      {
        this.d.setVisibility(8);
        return;
      }
    }
    this.d.setVisibility(4);
    ThreadManager.post(new FriendChatPie.7(this), 5, null, false);
  }
  
  protected void y()
  {
    aY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie
 * JD-Core Version:    0.7.0.1
 */