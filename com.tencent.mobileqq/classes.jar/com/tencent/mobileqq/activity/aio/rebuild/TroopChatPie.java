package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
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
import android.view.animation.AlphaAnimation;
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
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopSurveyBar;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils.OnHomeworkTroopIdentityCheckListener;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicObserver;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import vwm;
import vwn;
import vwp;
import vwq;
import vwy;
import vwz;
import vxa;
import vxb;
import vxc;
import vxd;
import vxe;
import vxf;
import vxg;
import vxj;
import vxk;
import vxl;
import vxm;
import vxn;
import vxo;
import vxq;
import vxr;
import vxs;
import vxt;
import vxu;
import vxw;
import vxx;
import vxy;
import vxz;
import vya;
import vyb;
import vyc;
import vyd;
import vye;
import vyf;
import vyg;
import vyh;
import vyi;
import vyj;
import vyl;
import vym;

public class TroopChatPie
  extends BaseTroopChatPie
{
  boolean V = false;
  boolean W;
  protected boolean X;
  boolean Y = false;
  boolean Z = true;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler;
  public ScrollView a;
  public Toast a;
  AnonymousChatHelper.AnonymousStatusListener jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener;
  public QQAnonymousDialog a;
  TroopCardAppInfoHelper.IGetAppInfoCB jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB = new vxj(this);
  TroopCardAppInfoHelper jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper;
  TroopNewGuidePopWindow jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = null;
  public GamePartyTipsBar a;
  HomeworkTroopSurveyBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar;
  public HomeworkTroopTipsBar a;
  public TroopAssistTipsBar a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new vxg(this);
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new vwp(this);
  protected MessageObserver a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new vwq(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new vxk(this);
  protected TroopEnterEffectController a;
  public HomeworkTroopController a;
  HWTroopUtils.OnHomeworkTroopIdentityCheckListener jdField_a_of_type_ComTencentMobileqqTroopUtilsHWTroopUtils$OnHomeworkTroopIdentityCheckListener;
  TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  TroopTopicObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicObserver = new vwn(this);
  FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  protected TroopUsingTimeReport a;
  protected TroopInteractGiftAnimationController a;
  public TroopOnlineMemberBar a;
  protected TroopPicEffectsController a;
  private Observer jdField_a_of_type_JavaUtilObserver = new vxw(this);
  public boolean aa = false;
  boolean ab = false;
  public boolean ac;
  public Handler b;
  protected List b;
  protected QQCustomDialog c;
  Runnable c;
  public LinearLayout d;
  QQCustomDialog jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  QQProgressDialog jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  Runnable jdField_d_of_type_JavaLangRunnable = new vxs(this);
  private Runnable e;
  public int m;
  public int n = 2;
  public int o;
  public View o;
  public int p;
  View p;
  public int q;
  public View q;
  public View r;
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_p_of_type_Int = 0;
    this.jdField_b_of_type_AndroidOsHandler = new vwy(this, Looper.getMainLooper());
    this.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vxu(this);
    this.jdField_e_of_type_JavaLangRunnable = new vyd(this);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
  }
  
  private void a(MessageForTroopFile paramMessageForTroopFile)
  {
    if (!TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage("仅群主管理员和文件所有者可以删除该文件").setPositiveButton(17039370, new vyc(this)).show();
      return;
    }
    if (NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
      TroopFileManager localTroopFileManager = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopFileStatusInfo.jdField_a_of_type_Long);
      localTroopFileManager.a(localTroopFileManager.a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_b_of_type_Long, localTroopFileStatusInfo.jdField_e_of_type_Int), (int)paramMessageForTroopFile.shmsgseq, MessageUtils.a(paramMessageForTroopFile.msgUid));
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131433742));
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      paramMessageForTroopFile = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessageForTroopFile, 30000);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131430281, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "clearBAFGrayTipSP troopUin=" + paramString1);
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    String str = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag", paramString2, paramString1 });
    paramString1 = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remark", paramString2, paramString1 });
    localSharedPreferences.edit().putLong(str, 0L).putLong(paramString1, 0L).apply();
  }
  
  private void a(boolean paramBoolean, HWTroopUtils.OnHomeworkTroopIdentityCheckListener paramOnHomeworkTroopIdentityCheckListener)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isHomeworkTroop())) {
      if (paramOnHomeworkTroopIdentityCheckListener != null) {
        HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramOnHomeworkTroopIdentityCheckListener, paramBoolean);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHWTroopUtils$OnHomeworkTroopIdentityCheckListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHWTroopUtils$OnHomeworkTroopIdentityCheckListener = new vyf(this);
      }
      HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHWTroopUtils$OnHomeworkTroopIdentityCheckListener, paramBoolean);
      return;
    }
    if (localTroopInfo == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("Q.aio.TroopChatPie", 2, new Object[] { "checkHomeworkTroopIdentity skip. has troopInfo = ", Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  private void bs()
  {
    ThreadManager.post(new vyh(this), 5, null, true);
  }
  
  private void bt()
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
    o(false);
  }
  
  private void bu()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar = new HomeworkTroopSurveyBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
  }
  
  private void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, new Object[] { "updateHomeworkTroopUI. isNowHomeworkTroop=", Boolean.valueOf(paramBoolean1), ", reloadPanelIcons=", Boolean.valueOf(paramBoolean2) });
    }
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      if (paramBoolean1)
      {
        TroopReportor.a("Grp_edu", "homework", "AioAssign_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "", TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) });
        TroopReportor.a("Grp_edu", "Grp_notice", "CreateNotice_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "", "" });
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController = new HomeworkTroopController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.a(paramBoolean1);
    if (!paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.c(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.d(false);
      return;
    }
    a(true, null);
    if (a().isResume())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.d(true);
      return;
    }
    this.W = true;
  }
  
  private void q(boolean paramBoolean)
  {
    Object localObject;
    if ((this.jdField_p_of_type_Int == 2) && (this.jdField_f_of_type_AndroidWidgetImageView != null))
    {
      localObject = this.jdField_f_of_type_AndroidWidgetImageView.getDrawable();
      if ((localObject instanceof AnimationDrawable))
      {
        localObject = (AnimationDrawable)localObject;
        if (!paramBoolean) {
          break label51;
        }
        if (!((AnimationDrawable)localObject).isRunning()) {
          ((AnimationDrawable)localObject).start();
        }
      }
    }
    label51:
    while (!((AnimationDrawable)localObject).isRunning()) {
      return;
    }
    ((AnimationDrawable)localObject).stop();
  }
  
  private void r(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArrayList localArrayList = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a();
      int i;
      if (localArrayList != null)
      {
        PanelIconLinearLayout localPanelIconLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
        if (localArrayList.contains("emoji"))
        {
          i = 0;
          localPanelIconLinearLayout.setChildVisible(3, i);
          localPanelIconLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
          if (!localArrayList.contains("image")) {
            break label176;
          }
          i = 0;
          label68:
          localPanelIconLinearLayout.setChildVisible(4, i);
          localPanelIconLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
          if (!localArrayList.contains("voice")) {
            break label182;
          }
          i = 0;
          label93:
          localPanelIconLinearLayout.setChildVisible(2, i);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(8, 8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(10, 8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(5, 8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(6, 8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(24, 8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(27, 0);
        this.S = true;
        return;
        i = 8;
        break;
        label176:
        i = 8;
        break label68;
        label182:
        i = 8;
        break label93;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(2, 8);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(27, 8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(8, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(3, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(4, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(2, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(10, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(5, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(6, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(24, 0);
    this.S = false;
  }
  
  protected void D()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow == null) || (!this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing()))
    {
      AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222);
      if (localAIOAnimationControlManager != null) {
        localAIOAnimationControlManager.c();
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    StructMsgItemLayout13.a();
    bm();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a();
    }
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    super.D();
  }
  
  protected void E()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.c();
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    q(false);
    super.E();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow == null) || (!this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing()))
    {
      localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222);
      if (localObject != null) {
        ((AIOAnimationControlManager)localObject).c();
      }
    }
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    Object localObject = (TroopEnterEffectManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(230);
    ((TroopEnterEffectManager)localObject).jdField_a_of_type_Int = 0;
    ((TroopEnterEffectManager)localObject).b = 0;
    ((TroopEnterEffectManager)localObject).c = 0;
    ((TroopEnterEffectManager)localObject).jdField_d_of_type_Int = 0;
  }
  
  protected void F()
  {
    super.F();
    if (this.Q)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130841202);
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
      a(-16777216, false);
    }
    bf();
  }
  
  protected void G()
  {
    super.G();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 2)
    {
      this.P = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
      if (this.P) {
        bc();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController = a();
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    q(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.a();
  }
  
  protected void H()
  {
    super.H();
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    String str = localIntent.getStringExtra("uin");
    int i = localIntent.getIntExtra("uintype", -1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != i))) {}
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b();
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
      }
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.b();
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
      {
        TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
      }
      this.jdField_h_of_type_Boolean = true;
      return;
    }
  }
  
  public void I()
  {
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.c();
    }
    super.I();
  }
  
  public void Q()
  {
    super.Q();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) && (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130841325);
    }
  }
  
  protected void X()
  {
    aZ();
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    TroopInfo localTroopInfo = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L)) {
      a(0L, 0L);
    }
    if ((localTroopInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "aio onShow:" + localTroopInfo.troopuin + ", sysFlag=" + localTroopInfo.cGroupRankSysFlag + ", userFlag=" + localTroopInfo.cGroupRankUserFlag);
    }
    super.X();
    if (this.V == true)
    {
      ThreadManager.post(new vyi(this), 1, null, true);
      this.V = false;
    }
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("forward_type")) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(((Bundle)localObject).getString("uin")))) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new vyj(this, bool), 8, null, true);
      return;
    }
  }
  
  public View a(int paramInt)
  {
    View localView = super.a(paramInt);
    if ((localView instanceof PlusPanel)) {
      ((PlusPanel)localView).setPagerChangedListener(new vxx(this));
    }
    return localView;
  }
  
  public TroopEnterEffectController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController = new TroopEnterEffectController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363474));
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
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController = new TroopPicEffectsController(this.jdField_d_of_type_AndroidWidgetLinearLayout);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController;
  }
  
  public String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int i = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(i + 1), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (!x())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a().e();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, new Object[] { "onPanelChanged updateAIOPanelTip. oldPanel=", Integer.valueOf(paramInt1), ", newPanel=", Integer.valueOf(paramInt2) });
    }
    b(false);
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      bt();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.a();
    }
    super.a(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a()) && (TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (b(true))) {
      return;
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      Object localObject1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
      continue;
      String str2 = paramIntent.getExtras().getString("member_uin");
      String str1 = paramIntent.getExtras().getString("member_display_name");
      Object localObject2;
      int i;
      int j;
      if ((paramIntent.getExtras().getBoolean("isApollo")) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null))
      {
        if (!"0".equals(str2))
        {
          localObject1 = null;
          if (!y()) {
            localObject1 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2);
          }
          localObject2 = localObject1;
          if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = str1;
          }
          localObject1 = new StringBuilder("@").append((String)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.peerUin = str2;
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.atNickName = ((StringBuilder)localObject1).toString();
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.inputText = com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
          a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo);
          i = 0;
          if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.inputText))
          {
            j = 2;
            i = j;
            if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_d_of_type_Int == 0) {
                i = 6;
              }
            }
            else
            {
              label456:
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
              j = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              str2 = "" + this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.actionId;
              if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b)) {
                break label669;
              }
            }
          }
          label669:
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b)
          {
            VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_double_sent", str1, i, j, new String[] { str2, localObject1, this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
            break;
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_d_of_type_Int != 1) {
              break label456;
            }
            i = 7;
            break label456;
            if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b))
            {
              i = 3;
              break label456;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_d_of_type_Int == 0)
            {
              i = 4;
              break label456;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_d_of_type_Int != 1) {
              break label456;
            }
            i = 5;
            break label456;
          }
        }
      }
      else
      {
        a(str2, str1, true, 4);
        continue;
        TroopGiftUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        continue;
        ai();
        i = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
        if (i > 0)
        {
          j = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().charAt(i - 1);
          if ((j == 36) || (j == 65509) || (j == 165) || (j == 65284))
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().delete(i - 1, i));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(i - 1);
            continue;
            localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
            if ((((String)localObject1).length() == 1) && ((((String)localObject1).charAt(0) == '#') || (((String)localObject1).charAt(0) == 65283)))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
              continue;
              if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null)
              {
                localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
                if (localObject1 != null)
                {
                  ((TroopGiftPanel)localObject1).b(paramIntent.getStringExtra("member_uin"));
                  continue;
                  if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null)
                  {
                    localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
                    if (localObject1 != null)
                    {
                      ((TroopGiftPanel)localObject1).a(null);
                      continue;
                      localObject1 = paramIntent.getStringExtra("result");
                      localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                      if ((!android.text.TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null) && (!((String)localObject1).equals(((TroopInfo)localObject2).troopname)))
                      {
                        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1);
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((String)localObject1);
                        localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
                        ((Intent)localObject2).putExtra("uinname", (String)localObject1);
                        b((Intent)localObject2);
                        continue;
                        if (paramInt2 == 8001)
                        {
                          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
                            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
                          }
                        }
                        else if (paramInt1 == 12005)
                        {
                          localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                          if (localObject1 != null)
                          {
                            if (((TroopInfo)localObject1).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                              i = 0;
                            }
                            for (;;)
                            {
                              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", "", "");
                              break;
                              if (((TroopInfo)localObject1).isAdmin()) {
                                i = 1;
                              } else {
                                i = 2;
                              }
                            }
                          }
                        }
                        else if (paramInt2 == 0)
                        {
                          switch (paramInt1)
                          {
                          default: 
                            break;
                          case 12006: 
                            if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
                            for (i = 2;; i = 1)
                            {
                              ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_choosecancel", i, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                              break;
                            }
                          case 12007: 
                            if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null)
                            {
                              localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
                              if (localObject1 != null) {
                                ((TroopGiftPanel)localObject1).a(null);
                              }
                            }
                            break;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog == null) {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = new QQAnonymousDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.show();
    vxt localvxt;
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramString = this.jdField_a_of_type_MqqOsMqqHandler;
      localvxt = new vxt(this);
      if (!AppSetting.b) {
        break label82;
      }
    }
    label82:
    for (long l = 3000L;; l = 1000L)
    {
      paramString.postDelayed(localvxt, l);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong1, paramLong2, new vyl(this, false));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
    }
    if ((this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      if ((paramLong == 1L) || (paramLong == 2L)) {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog, CreditLevelTipDialog isShowing:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
        }
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      if (paramLong == 1L)
      {
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131434764)).setMessage(2131430675);
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131427391), new vxa(this));
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton("取消", new vxb(this));
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButtonContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131427391));
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButtonContentDescription("取消");
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_banned").c("Grp_AIO").d("exp_msgbox").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }).a();
        return;
      }
      if ((paramLong == 2L) && (!paramBoolean))
      {
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131434764)).setMessage(2131430674);
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131430676, new vxc(this));
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton("", null);
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    } while ((paramLong != 2L) || (!paramBoolean));
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131434764)).setMessage(2131430673);
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131430676, new vxd(this));
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131430677, new vxf(this));
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void a(Intent paramIntent)
  {
    v(0);
    if ((this.Q) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      p(false);
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      this.jdField_p_of_type_AndroidViewView.setVisibility(8);
    }
    String str1;
    String str2;
    int i;
    for (;;)
    {
      if ((this.Q) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430435) + AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      }
      super.a(paramIntent);
      str1 = paramIntent.getStringExtra("greetingsTitle");
      str2 = paramIntent.getStringExtra("greetingsContent");
      i = paramIntent.getIntExtra("types", 0);
      if (i == 1)
      {
        Object localObject1 = paramIntent.getStringExtra("greetingsMembers");
        if (localObject1 != null) {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            i = 0;
            for (;;)
            {
              if (i < ((JSONArray)localObject1).length())
              {
                Object localObject2 = ((JSONArray)localObject1).getString(i);
                String str4 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2);
                localObject2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, str4, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
                if ((localObject2 != null) && (((SpannableString)localObject2).length() != 0)) {
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject2);
                }
                i += 1;
                continue;
                if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                p(true);
                this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130841202);
                this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130841208);
                this.jdField_o_of_type_AndroidViewView.setVisibility(0);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.aio.TroopChatPie", 2, "TroopChatPie send greetings.get members failed.");
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!android.text.TextUtils.isEmpty(str1)) {
        b("0", str2, str1);
      }
      if (paramIntent.getBooleanExtra("sendGift", false)) {
        a(true, 1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
      }
      return;
      if (i == 2)
      {
        String str3 = paramIntent.getStringExtra("greetingsName");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, "@" + str3 + " ");
      }
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int i = paramIntent.getIntExtra(AlbumConstants.h, -1);
    if (((i == 2) || (i == 1)) && (b(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(View paramView)
  {
    if (this.jdField_p_of_type_Int == 2)
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
        bt();
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryClose").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(1);
      paramView = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (paramView != null) {
        paramView.r(a().jdField_a_of_type_JavaLangString);
      }
      o(true);
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryOpen").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
      return;
    }
    super.a(paramView);
  }
  
  public void a(TroopChatPie.OnListViewScrollStateListener paramOnListViewScrollStateListener)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramOnListViewScrollStateListener);
  }
  
  public void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo)
  {
    if (paramSelfGagInfo.jdField_a_of_type_Boolean) {
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (8 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && ((this.jdField_e_of_type_Int != 1) || (this.j != 0)))
      {
        Z();
        if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
          this.jdField_f_of_type_AndroidWidgetTextView.setText(paramSelfGagInfo.b);
        }
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "updateGagStatus_UI, sendEmptyMessageDelayed-TIMER_ID:" + paramSelfGagInfo.jdField_a_of_type_Long + ", hasDestory=" + this.I);
        }
        if (!this.I)
        {
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramSelfGagInfo.jdField_a_of_type_Long * 1000L);
        }
        this.jdField_h_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "updateGagStatus disable fastimage,  mAllowFastImage = " + this.jdField_h_of_type_Boolean);
        }
      }
    }
    do
    {
      return;
      this.X = true;
      break;
      this.X = false;
      aX();
      this.jdField_h_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "updateGagStatus enable fastimage,  mAllowFastImage = " + this.jdField_h_of_type_Boolean);
  }
  
  public void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (paramSelfGagInfo == null) {
        ThreadManager.post(new vwz(this, paramBoolean), 8, null, true);
      }
    }
    else {
      return;
    }
    a(paramSelfGagInfo);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a().a(paramInt, 500L);
    }
    if (paramInt == 2) {
      bt();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "scrollState = " + paramInt);
    }
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ac = bool;
      paramAbsListView = this.jdField_b_of_type_JavaUtilList.iterator();
      while (paramAbsListView.hasNext()) {
        ((TroopChatPie.OnListViewScrollStateListener)paramAbsListView.next()).a(this.ac);
      }
    }
  }
  
  public void a(Object paramObject)
  {
    AIOUtils.m = true;
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
      if (this.Q)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        continue;
        if (this.Q) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
        if (this.S)
        {
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_icon_clk").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString }).a();
          continue;
          if (this.Q)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            continue;
            if (this.Q)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              continue;
              if (!y()) {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              }
              if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer == null) {
                this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer = new AIOGiftPanelContainer(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel);
              }
              AIOGiftPanelContainer localAIOGiftPanelContainer = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer;
              if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
              for (int i = 4;; i = 1)
              {
                localAIOGiftPanelContainer.a(0, i);
                break;
              }
              this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(27, true);
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.a();
              TroopRobotManager.a("panel", "exp", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.a(), "", "");
            }
          }
        }
      }
    }
  }
  
  protected void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      i = 1;
      if (paramRecorderParam.a != null) {
        break label130;
      }
    }
    long l2;
    int j;
    String str1;
    Object localObject;
    label130:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l2 = SystemClock.uptimeMillis();
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (i != 0) {
        break label456;
      }
      localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.c);
      if (localObject != null) {
        break label136;
      }
      return;
      i = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool1;
    long l1 = ((MessageRecord)localObject).uniseq;
    PttInfoCollector.a.put(paramString, Long.valueOf(l2));
    if (!bool1)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      label180:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + l1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!z) {
        break label514;
      }
    }
    label514:
    for (int i = 1;; i = 2)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", i, 0, "", "", "", "7.6.0");
      z = true;
      i = a(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.jdField_e_of_type_Int);
      ArrayList localArrayList = new ArrayList();
      String str2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
      boolean bool3 = false;
      boolean bool2 = bool3;
      if (this.S)
      {
        Iterator localIterator = localArrayList.iterator();
        do
        {
          bool2 = bool3;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!localTroopRobotManager.a(((MessageForText.AtTroopMemberInfo)localIterator.next()).uin));
        bool2 = true;
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, str1, paramString, l1, false, paramInt2, paramRecorderParam.c, bool1, paramInt3, i, paramBoolean, paramRecorderParam.jdField_d_of_type_Int, (Bundle)localObject, localArrayList, str2, bool2);
      b(paramInt1, paramInt2);
      a(0, paramString, l1);
      return;
      label456:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 0, paramLong);
      l1 = paramLong;
      if (!MessageForPtt.class.isInstance(localObject)) {
        break;
      }
      ((MessageForPtt)localObject).voiceLength = QQRecorder.a(paramInt2);
      l1 = paramLong;
      break;
      PttBuffer.b(paramString);
      break label180;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
    if ((localTroopRobotManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localTroopRobotManager.b(paramString1)))
    {
      this.jdField_f_of_type_JavaLangString = paramString1;
      localTroopRobotManager.d = paramString1;
      this.g = paramString2;
    }
    super.a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  protected void a(List paramList, CharSequence paramCharSequence, int paramInt)
  {
    super.a(paramList, paramCharSequence, paramInt);
    if ((0xFFFF & paramInt) == 3)
    {
      ((TroopAioKeywordTipManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(224)).a(paramList);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a().f();
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
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
      int i;
      try
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        if (Long.parseLong(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString) != l) {
          break;
        }
        localObject1 = (TroopMemberCard)paramObject[2];
        i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
        if (i > j) {
          break label422;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(i);
        if (!(localObject2 instanceof MessageForQQWalletTips)) {
          break label511;
        }
        localObject2 = (MessageForQQWalletTips)localObject2;
        if ((((MessageForQQWalletTips)localObject2).istroop != 1) || (localObject1 == null) || (!((MessageForQQWalletTips)localObject2).memberUin.equals(String.valueOf(((TroopMemberCard)localObject1).memberUin))) || (!((MessageForQQWalletTips)localObject2).frienduin.equals(String.valueOf(l))) || ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51) == null)) {
          break label511;
        }
        Object localObject3 = ((TroopMemberCard)localObject1).nick;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.TroopChatPie", 2, "handGetTroopMemberCard troopUin=" + ((MessageForQQWalletTips)localObject2).frienduin + ", memberUin=" + ((MessageForQQWalletTips)localObject2).memberUin + ",card=" + ((TroopMemberCard)localObject1).card + ",remark=" + ((TroopMemberCard)localObject1).remark + ",nick=" + ((TroopMemberCard)localObject1).nick + ",saveTroopMemberEx succ=" + true);
        }
        localObject3 = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.TroopChatPie", 2, "handGetTroopMemberCard ref itemView=" + localObject3 + ",index=" + i);
        }
        if (localObject3 == null) {
          break label511;
        }
        localObject3 = (TextView)((View)localObject3).findViewById(2131363766);
        ((MessageForQQWalletTips)localObject2).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (TextView)localObject3);
      }
      catch (Throwable paramObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.aio.TroopChatPie", 2, "handGetTroopMemberCard e=" + paramObject);
      return;
      label422:
      if ((localObject1 == null) || (!android.text.TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(((TroopMemberCard)localObject1).memberUin)))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, new Object[] { "handleGetTroopMemberCard. memberUin = ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      }
      if (!((Boolean)paramObject[3]).booleanValue()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(paramBoolean, null);
        bu();
        return;
      }
      label511:
      i += 1;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return super.a(paramInt, paramView, paramListView);
  }
  
  protected boolean a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewViewGroup == null)
    {
      QLog.e("Q.aio.TroopChatPie", 2, "mAIORootView == null");
      ChatFragment localChatFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment();
      if (localChatFragment != null) {
        this.jdField_c_of_type_AndroidViewViewGroup = localChatFragment.a;
      }
    }
    super.a(paramBoolean);
    be();
    x(1);
    RobotResourcesManager.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport = new TroopUsingTimeReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    return true;
  }
  
  protected void aO()
  {
    super.aO();
    bt();
  }
  
  void aY()
  {
    boolean bool = false;
    super.aY();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null)
    {
      vym localvym = new vym(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localvym, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    b(false);
    if (this.Q != AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (!this.Q) {
        bool = true;
      }
      this.Q = bool;
      p(this.Q);
    }
    ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void aZ()
  {
    super.aZ();
    this.jdField_q_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ThreadManager.post(new vxl(this), 8, null, true);
    bg();
    Object localObject = new vxm(this);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    int i;
    if (localObject != null)
    {
      String str1 = ((Intent)localObject).getStringExtra("at_member_name");
      String str2 = ((Intent)localObject).getStringExtra("at_member_uin");
      i = ((Intent)localObject).getIntExtra("at_member_source", 0);
      if ((!android.text.TextUtils.isEmpty(str1)) && (!android.text.TextUtils.isEmpty(str2))) {
        a(str2, str1, false, i);
      }
    }
    if ((!this.Y) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      if (!BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).getBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false)) {}
    }
    for (;;)
    {
      boolean bool1;
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, l1, l1, l2, "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", (short)34, true, false);
        TroopNewGuidePopWindow.b("http://gdynamic.qpic.cn/gdynamic/");
        bool1 = false;
      }
      catch (Exception localException)
      {
        boolean bool2;
        localException.printStackTrace();
        bool1 = false;
        continue;
      }
      if (!bool1)
      {
        if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow != null) && (this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing()))
        {
          bool1 = true;
          bool2 = false;
          localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222);
          if (localObject != null) {
            bool2 = ((AIOAnimationControlManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
          if ((localObject != null) && (bool2) && (bool1)) {
            ((AIOAnimationControlManager)localObject).b = false;
          }
          if ((!bool1) && (bool2))
          {
            AIOAnimationControlManager.jdField_a_of_type_Boolean = true;
            l(true);
          }
          this.Z = false;
          if (!this.Y)
          {
            if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == null)
            {
              i = 1;
              if (i == 0) {
                break label633;
              }
              if (QLog.isColorLevel()) {
                QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, isTroopTipStatusNull== true, getAppInfoBriefList");
              }
              this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB, true);
            }
          }
          else
          {
            ThreadManager.getSubThreadHandler().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 500L);
            bp();
            this.Y = true;
            if ((this.W) && (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController != null))
            {
              this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.d(true);
              this.W = false;
            }
            localObject = (TroopEnterEffectManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(230);
            if ((((TroopEnterEffectManager)localObject).jdField_a_of_type_Int != 0) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
            {
              ((TroopEnterEffectManager)localObject).a(new TroopEnterEffectController.TroopEnterEffectData(((TroopEnterEffectManager)localObject).jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((TroopEnterEffectManager)localObject).b, ((TroopEnterEffectManager)localObject).c, ((TroopEnterEffectManager)localObject).jdField_d_of_type_Int, ((TroopEnterEffectManager)localObject).jdField_a_of_type_Int));
              localObject = a();
              ((TroopEnterEffectController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              ((TroopEnterEffectController)localObject).a();
            }
            return;
            bool1 = z();
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        i = 0;
        continue;
        label633:
        if (QLog.isColorLevel()) {
          QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, reqNotifyItems");
        }
        TroopAioNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      else
      {
        continue;
        bool1 = false;
      }
    }
  }
  
  public void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals("0"))) {
      aj();
    }
  }
  
  public void ak()
  {
    if (b(true)) {
      return;
    }
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
    boolean bool2 = localTroopRobotManager.a();
    Object localObject = localTroopRobotManager.b;
    String str1 = localTroopRobotManager.jdField_c_of_type_JavaLangString;
    this.U = true;
    ArrayList localArrayList = new ArrayList();
    String str2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    int i = 0;
    label198:
    boolean bool3;
    if (i < localArrayList.size())
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(i);
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
      super.ak();
      if ((bool2) && (!bool1))
      {
        localObject = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
        a(localTroopRobotManager.b, localTroopRobotManager.jdField_c_of_type_JavaLangString, true, 0);
      }
      for (;;)
      {
        this.U = false;
        return;
        bool1 = false;
        break label198;
        i += 1;
        break;
        TroopPobingItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((str2 == null) || (str2.length() <= 3478)) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        }
        if (this.S) {
          r(false);
        }
        this.T = false;
        localTroopRobotManager.a(false);
      }
    }
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.X)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131430256, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      Z();
      bool = true;
    }
    return bool;
  }
  
  protected void bc()
  {
    f(true);
    vxe localvxe = new vxe(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, localvxe);
  }
  
  public void bd()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.post(this.jdField_d_of_type_JavaLangRunnable, 8, null, true);
    }
  }
  
  void be() {}
  
  protected void bf()
  {
    boolean bool3 = false;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject = null;
    if (localTroopManager != null) {
      localObject = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, troopInfo==null:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    long l;
    do
    {
      return;
      l = ((TroopInfo)localObject).troopCreditLevel;
      if ((l == 1L) || (l == 2L)) {
        break;
      }
      if ((this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, normal:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + l);
    return;
    boolean bool1;
    if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
    {
      bool1 = true;
      if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) != 1L) {
        break label362;
      }
    }
    label362:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bool1) || (bool2)) {
        bool3 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + bool1 + ", " + bool2);
      }
      localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, getTroopCreditInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ((TroopHandler)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      a(l, bool3);
      return;
      bool1 = false;
      break;
    }
  }
  
  void bg()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject != null) {
        break label29;
      }
    }
    label29:
    do
    {
      for (;;)
      {
        return;
        localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && ((((TroopInfo)localObject).wMemberNum == 0) || (android.text.TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)))) {
          try
          {
            long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(Long.valueOf(l));
            ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a((ArrayList)localObject);
            if (QLog.isColorLevel())
            {
              QLog.d("Q.aio.TroopChatPie", 2, "getTroopInfoIfNeed, sessionInfo.curFriendUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.aio.TroopChatPie", 2, "getTroopInfoIfNeed failed");
  }
  
  public void bh()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0L, 2, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.aio.TroopChatPie", 2, localException.toString());
    }
  }
  
  void bi()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground() != null) {
      l();
    }
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130843245));
      this.m.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130845508);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494205));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label529;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846136);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494203));
      label117:
      AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, 2130846141);
      if ((this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_e_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getText().toString().startsWith(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430435))))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText("");
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494205));
        b(false);
      }
      String str = ((TroopOnlineMemberManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233)).a(a().jdField_a_of_type_JavaLangString);
      if (android.text.TextUtils.isEmpty(str)) {
        break label563;
      }
      v(2);
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
      b(true);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494205));
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      o(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.b = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(false);
      }
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      this.jdField_p_of_type_AndroidViewView.setVisibility(8);
      AnonymousChatHelper.a().b();
      bl();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(1.0F, 0.0F, 1.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131493128));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494275));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundResource(2130845549);
      }
      bj();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return;
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494247), true);
      break;
      label529:
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label117;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130846137);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      break label117;
      label563:
      v(0);
    }
  }
  
  public void bj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null)
    {
      CmGameMainManager localCmGameMainManager = CmGameMainManager.a();
      if (localCmGameMainManager != null) {
        localCmGameMainManager.d();
      }
    }
  }
  
  public void bk()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new vxq(this));
    if ((this.r != null) && (this.jdField_q_of_type_AndroidViewView != null))
    {
      this.r.startAnimation(localAlphaAnimation);
      this.jdField_q_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    }
  }
  
  public void bl()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new vxr(this));
    this.r.startAnimation(localAlphaAnimation);
    this.jdField_q_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void bm()
  {
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void bn()
  {
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载...");
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected void bo()
  {
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
    String str1;
    int i;
    boolean bool1;
    if (localTroopRobotManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (!this.U)
      {
        AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(0, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString().length(), AtTroopMemberSpan.class);
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        i = 0;
        if (i >= arrayOfAtTroopMemberSpan.length) {
          break label357;
        }
        if (!localTroopRobotManager.b(arrayOfAtTroopMemberSpan[i].a())) {
          break label215;
        }
        String str2 = arrayOfAtTroopMemberSpan[i].a();
        this.jdField_f_of_type_JavaLangString = str2;
        localTroopRobotManager.d = str2;
        this.g = arrayOfAtTroopMemberSpan[i].b();
        if (!this.g.startsWith("@")) {
          break label352;
        }
        this.g = this.g.substring(1);
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel != null)
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.a() != null)
        {
          bool2 = bool1;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.a().equals(this.jdField_f_of_type_JavaLangString)) {
            bool2 = false;
          }
        }
      }
      if (this.T == bool2) {}
      label215:
      do
      {
        do
        {
          do
          {
            return;
            i += 1;
            break;
            this.T = bool2;
            if (bool2) {
              break label305;
            }
            r(false);
          } while (!localTroopRobotManager.a());
          localTroopRobotManager.a();
          TroopRobotManager.a("panel", "talk_out", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.a(), "2", "");
          localTroopRobotManager.b(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "off", new vxy(this));
          return;
        } while (this.S);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.a(str1, this.jdField_f_of_type_JavaLangString, this.g, this, new vxz(this));
        return;
      } while (!this.S);
      label305:
      r(false);
      return;
      label352:
      bool1 = true;
      continue;
      label357:
      bool1 = false;
    }
  }
  
  public void bp()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363973));
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo == null) || (localTroopInfo.hasSetTroopName()) || (localTroopInfo.wMemberNumClient <= 0)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
    } while (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(16);
  }
  
  public void bq()
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    br();
  }
  
  public void br()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getInt("homework_troop_aio_tip_show", 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, new Object[] { "showHomeworkTroopIdentityAIOTip. show = ", Boolean.valueOf(bool) });
      }
      if (!bool) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar = new HomeworkTroopTipsBar(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, true);
      return;
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    if (paramInt2 == 8) {
      if (!this.Q) {}
    }
    for (;;)
    {
      if ((paramInt2 == 2) && (this.Q)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(0);
      }
      return;
      if (!this.Q) {}
    }
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    this.n = 2;
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    if (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      Object localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("clk_recallMsg");
      String str = paramChatMessage.frienduin;
      Object localObject1;
      if (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        localObject1 = "1";
        ((ReportTask)localObject2).a(new String[] { str, localObject1 }).a();
        if (SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label269;
        }
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131430831)).setPositiveButton(17039370, new vya(this, paramChatMessage)).show();
        localObject1 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_guide");
        localObject2 = paramChatMessage.frienduin;
        if (!TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label262;
        }
      }
      label262:
      for (paramChatMessage = "1";; paramChatMessage = "2")
      {
        ((ReportTask)localObject1).a(new String[] { localObject2, paramChatMessage }).a();
        SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        return;
        localObject1 = "2";
        break;
      }
      label269:
      e(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.Q) {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130841227);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130846137);
        return;
      } while (GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846136);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494203));
        return;
      }
    } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130846137);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
  }
  
  public void e(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.a("撤回后，该文件将被删除");
      localActionSheet.b("(若对方非最新版本，则文件删除可能失败。)");
      localActionSheet.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433737), 3);
      localActionSheet.c(2131432998);
      localActionSheet.a(new vyb(this, paramChatMessage, localActionSheet));
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "remove_file", "tips_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    super.e(paramChatMessage);
  }
  
  protected void e(boolean paramBoolean)
  {
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    super.e(paramBoolean);
  }
  
  protected boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.c();
    }
    return super.e();
  }
  
  public void f(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.j = paramInt;
      if (!this.X) {
        break label134;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      AudioUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), false);
      b(true);
    }
    label134:
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711686);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper = new TroopCardAppInfoHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
    this.V = true;
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).j(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
    ThreadManager.post(new vwm(this), 2, null, true);
    int i;
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        if (!((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label243;
        }
        i = 1;
      }
    }
    for (;;)
    {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_AIO").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(i) }).a();
      return;
      label243:
      if (((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  protected void h()
  {
    super.h();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d()) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b() == 15)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar = new TroopAssistTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.jdField_a_of_type_AndroidWidgetToast);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
  }
  
  protected void h(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
    }
    super.h(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    paramIntent = new vym(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    long l1;
    long l2;
    long l3;
    while ((paramMessage.what == 60) && (this.Q))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130841202);
      return true;
      if ((this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow != null) && (this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.isShowing())) {
        this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.dismiss();
      }
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = new TroopNewGuidePopWindow(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      Object localObject = new int[2];
      this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject);
      i = a();
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationInWindow(arrayOfInt);
      int j = arrayOfInt[1];
      int k = localObject[1];
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.a(i, j - k);
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.a(paramMessage.arg1);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
        if (((TroopAioMsgNavigateBar)localObject).a.get())
        {
          ((TroopAioMsgNavigateBar)localObject).a.set(false);
          continue;
          i = paramMessage.arg1;
          localObject = this.jdField_h_of_type_AndroidWidgetImageView;
          if (i == 0) {}
          for (i = 8;; i = 0)
          {
            ((ImageView)localObject).setVisibility(i);
            break;
          }
          localObject = (List)paramMessage.obj;
          if (localObject != null)
          {
            l1 = ((Long)((List)localObject).get(0)).longValue();
            l2 = ((Long)((List)localObject).get(1)).longValue();
            l3 = ((Long)((List)localObject).get(2)).longValue();
          }
        }
      }
    }
    for (;;)
    {
      long l4;
      long l5;
      try
      {
        l4 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        l5 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        if (l4 != l1) {
          break label471;
        }
        if (l2 == l5) {
          break label611;
        }
        if (l3 != l5) {
          break label471;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e(".troop.chat_pie_msg", 1, "MSG_TROOP_ADMIN_OPERATION_NOTIFY: groupUin error", localNumberFormatException);
      }
      if (i != 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: will reload plusPanel, groupUin:", Long.valueOf(l1) });
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
          break;
          break;
          label471:
          i = 0;
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
      label611:
      i = 1;
    }
  }
  
  protected void i(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("uintype", -1);
    boolean bool = paramIntent.getBooleanExtra("isNeedUpdate", false);
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != i))
    {
      this.H = false;
      if ((this.H) && (!localBundle.containsKey("forward_type"))) {
        break label96;
      }
      c(paramIntent);
    }
    label96:
    do
    {
      return;
      this.H = true;
      break;
      if ((this.jdField_d_of_type_Int != 0) || (bool))
      {
        a(true, false);
        return;
      }
    } while (localBundle.getLong("res_share_id", 0L) <= 0L);
    ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
  }
  
  protected void j(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "troopUin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject3 = null;
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.TroopChatPie", 2, "avType : " + ((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Int);
        }
        if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Int != 2) {
          break label713;
        }
        if (((AVNotifyCenter.VideoRoomInfo_tips)localObject1).jdField_a_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
        }
      }
      else
      {
        bs();
        if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
          break label825;
        }
        this.jdField_d_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView = new vye(this, this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setScrollbarFadingEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalScrollBarEnabled(false);
        this.jdField_o_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        localObject1 = new RelativeLayout.LayoutParams(-1, this.jdField_o_of_type_Int);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_d_of_type_AndroidWidgetLinearLayout, -1, this.jdField_o_of_type_Int);
        localObject1 = (TroopEnterEffectManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(230);
        this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController = a();
        ((TroopEnterEffectManager)localObject1).jdField_a_of_type_Int = 0;
        ((TroopEnterEffectManager)localObject1).b = 0;
        ((TroopEnterEffectManager)localObject1).c = 0;
        ((TroopEnterEffectManager)localObject1).jdField_d_of_type_Int = 0;
        ((TroopEnterEffectManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label932;
        }
        new SoLibraryChecker(this.jdField_a_of_type_AndroidContentContext, "3171", "libWXVoice.so", "WXVoice").a();
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vyg(this);
          localObject1 = new IntentFilter();
          ((IntentFilter)localObject1).addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
          this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1, "com.tencent.msg.permission.pushnotify", null);
        }
        TroopReportor.a("Grp_edu", "homework", "AioAssign_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "", TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) });
        TroopReportor.a("Grp_edu", "Grp_notice", "CreateNotice_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "", "" });
        d(true, false);
        bu();
        super.j(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      label932:
      for (;;)
      {
        Object localObject2 = localObject3;
        label825:
        if (QLog.isColorLevel())
        {
          QLog.d("Q.aio.TroopChatPie", 2, "onShowFirst : invalid uin!");
          localObject2 = localObject3;
          continue;
          ReportController.b(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
          continue;
          label713:
          if (((AVNotifyCenter.VideoRoomInfo_tips)localObject2).jdField_a_of_type_Int == 10)
          {
            if (((AVNotifyCenter.VideoRoomInfo_tips)localObject2).jdField_a_of_type_Boolean) {
              ReportController.b(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
              break;
              ReportController.b(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
            }
            this.jdField_o_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).height = this.jdField_o_of_type_Int;
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
            this.jdField_a_of_type_AndroidWidgetScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
            this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_d_of_type_AndroidWidgetLinearLayout, -1, this.jdField_o_of_type_Int);
            continue;
            this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
          }
        }
      }
    }
  }
  
  public void k(boolean paramBoolean)
  {
    if (SharedPreUtils.r(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      a(paramBoolean, 1);
      SharedPreUtils.q(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      return;
    }
    a(paramBoolean, 0);
  }
  
  public void o(boolean paramBoolean)
  {
    Object localObject = (LinearLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetImageView.getLayoutParams();
    this.jdField_f_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    try
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841430);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        ((Drawable)localObject).clearColorFilter();
      }
      while (paramBoolean)
      {
        Drawable localDrawable = this.jdField_f_of_type_AndroidWidgetImageView.getDrawable();
        if ((localDrawable instanceof AnimationDrawable)) {
          ((AnimationDrawable)localDrawable).stop();
        }
        ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
      }
      if (Build.VERSION.SDK_INT < 21)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841437);
        ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      localObject = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841436);
      ((AnimationDrawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      ((AnimationDrawable)localObject).start();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131363481) && (b(true))) {}
    do
    {
      do
      {
        return;
        super.onClick(paramView);
        if (paramView.getId() != 2131361888) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a()));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      return;
    } while (paramView.getId() != 2131361891);
    bt();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    TroopInfo localTroopInfo;
    String str1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() != 0))
    {
      if ((paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '@') && (paramCharSequence.charAt(paramInt1) != 65312)) || (this.jdField_o_of_type_Boolean) || (this.M)) {
        break label397;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "inputing @ in TroopChatPie.");
      }
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localTroopInfo == null) {
        break label357;
      }
      paramCharSequence = TroopMemberListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localTroopInfo.troopuin, 3);
      paramCharSequence.putExtra("param_is_pop_up_style", true);
      paramCharSequence.setFlags(603979776);
      if (!this.Q) {
        break label292;
      }
      paramCharSequence.putExtra("param_chat_mode", 1);
      if (super.f() == 21) {
        paramCharSequence.putExtra("param_troop_send_apollo_msg", true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "open TroopMemberListActivity to choose @ user target.");
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(paramCharSequence, 6001);
      str1 = "2";
    }
    label292:
    label357:
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
              for (;;)
              {
                try
                {
                  str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                  if ((localTroopInfo.troopowneruin == null) || (!localTroopInfo.troopowneruin.equals(str2))) {
                    continue;
                  }
                  paramCharSequence = "0";
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, localTroopInfo.troopuin, "2", paramCharSequence, "");
                  return;
                }
                catch (Exception paramCharSequence)
                {
                  String str2;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("Q.aio.TroopChatPie", 2, "onTextChanged() has an exception.", paramCharSequence);
                  return;
                }
                paramCharSequence.putExtra("param_chat_mode", 0);
                break;
                paramCharSequence = str1;
                if (localTroopInfo.Administrator != null)
                {
                  paramCharSequence = str1;
                  if (localTroopInfo.Administrator.contains(str2)) {
                    paramCharSequence = "1";
                  }
                }
              }
            } while (!QLog.isColorLevel());
            QLog.d("Q.aio.TroopChatPie", 2, "onTextChanged(). troopInfo is null. while inputing @.  troopUin is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            return;
            if ((paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '$') && (paramCharSequence.charAt(paramInt1) != 65509) && (paramCharSequence.charAt(paramInt1) != '¥') && (paramCharSequence.charAt(paramInt1) != 65284)) || (this.jdField_o_of_type_Boolean) || (this.M)) {
              break label724;
            }
          } while (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
          paramInt2 = 0;
          for (;;)
          {
            if (paramInt2 >= paramCharSequence.length()) {
              break label560;
            }
            if ((paramInt2 != paramInt1) && ((paramCharSequence.charAt(paramInt2) == '$') || (paramCharSequence.charAt(paramInt2) == 65509) || (paramCharSequence.charAt(paramInt2) == '¥') || (paramCharSequence.charAt(paramInt2) == 65284))) {
              break;
            }
            paramInt2 += 1;
          }
          paramCharSequence = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        } while ((paramCharSequence == null) || (!TroopInfo.hasPayPrivilege(paramCharSequence.troopPrivilegeFlag, 32)));
        if (paramCharSequence.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          paramInt1 = 0;
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "sign", 0, 0, paramCharSequence.troopuin + "", paramInt1 + "", "", "");
          TroopGiftUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramCharSequence.troopuin, "input", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          if (paramCharSequence.isAdmin()) {
            paramInt1 = 1;
          } else {
            paramInt1 = 2;
          }
        }
        if ((paramInt1 != 0) || (paramInt3 != 1) || (paramCharSequence.length() != 1) || ((paramCharSequence.charAt(0) != '#') && (paramCharSequence.charAt(0) != 65283)) || (this.jdField_o_of_type_Boolean) || (this.M)) {
          break label994;
        }
      } while (((this.Q) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131362132) != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)) || (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      if (QLog.isColorLevel())
      {
        QLog.d("Q.aio.TroopChatPie", 2, "input # ---------------");
        QLog.d("Q.aio.TroopChatPie", 2, "s = " + paramCharSequence + ", start = " + paramInt1 + ", before = " + paramInt2 + ", count = " + paramInt3);
      }
      paramCharSequence = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
    } while (paramCharSequence == null);
    label397:
    label560:
    label724:
    TroopBarUtils.jdField_a_of_type_JavaUtilHashMap.clear();
    paramCharSequence.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "pub_talk", "Clk_call", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    return;
    label994:
    bo();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a()))
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
      SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_gift_panel", false);
    }
    if ((paramView.getId() == 2131363489) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  protected void p(int paramInt)
  {
    if (!this.Q) {
      super.p(paramInt);
    }
  }
  
  public void p(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    this.Q = paramBoolean;
    AnonymousChatHelper.a().a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) || (SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_anonyous", paramBoolean);
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_o_of_type_AndroidViewView == null)
    {
      this.jdField_o_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_o_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(12, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_o_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.r == null)
    {
      this.r = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.r.setBackgroundResource(2130841208);
      this.r.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.r.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.r, 0);
    }
    if (this.jdField_q_of_type_AndroidViewView == null)
    {
      this.jdField_q_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_q_of_type_AndroidViewView.setBackgroundResource(2130841208);
      this.jdField_q_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_q_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_q_of_type_AndroidViewView, 0);
    }
    if (this.jdField_p_of_type_AndroidViewView == null)
    {
      this.jdField_p_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_p_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_p_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(2, 2131363476);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_p_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(paramBoolean);
    }
    if (paramBoolean)
    {
      v(1);
      this.m.setVisibility(8);
      a(-16777216, false);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363477).setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130841208);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130841220);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494205));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130841227);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_a_of_type_JavaLangCharSequence = this.jdField_e_of_type_AndroidWidgetTextView.getText();
        }
        bt();
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430435) + AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
        b(true);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.b = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(true);
        }
        this.jdField_p_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener = new vxo(this);
        AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(2131430453);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundColor(-16777216);
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          }
        }
      }
    }
    for (;;)
    {
      u();
      p();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      ag();
      return;
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130846137);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837562);
      break;
      if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
        bi();
      }
    }
  }
  
  public void s()
  {
    if ((Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (Utils.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ChatSettingForTroop.class);
    localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("vistor_type", 1);
    Object localObject2;
    int i;
    if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      if (localObject1 == null) {
        break label286;
      }
      localObject1 = ((TroopManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label286;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((android.text.TextUtils.isEmpty((CharSequence)localObject2)) || (android.text.TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))) {
        break label286;
      }
      if ((!((String)localObject2).equals(((TroopInfo)localObject1).Administrator)) && (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
        break label274;
      }
      i = 1;
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (i != 0) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
        VasWebviewUtil.reportCommercialDrainage("", "style", "0X8008E61", "", 1, 0, 0, "", "", "");
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
        return;
        label274:
        i = 0;
        break;
      }
      label286:
      i = 0;
    }
  }
  
  public boolean u()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("isFromTroopEffectPic", false))) {
      return false;
    }
    return super.u();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.TroopChatPie", 2, "update");
    }
    if (paramObject == null) {}
    label301:
    for (;;)
    {
      return;
      if ((paramObject instanceof MessageRecord)) {
        if ((paramObject instanceof ChatMessage))
        {
          paramObservable = (MessageRecord)paramObject;
          if ((!paramObservable.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.c(paramObservable.istroop)))) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForTroopEffectPic))) {
            l(false);
          }
        }
      }
      for (;;)
      {
        if (!(paramObject instanceof MessageForText)) {
          break label301;
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
        if ((paramObject instanceof TroopAioAgent.Message)) {
          b(paramObject);
        } else if ((paramObject instanceof Integer)) {
          switch (((Integer)paramObject).intValue())
          {
          case 123321: 
          default: 
            break;
          case 123322: 
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a())) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(1, this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a() / 2);
            } else {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(1);
            }
            break;
          }
        }
      }
    }
  }
  
  public void v(int paramInt)
  {
    this.jdField_p_of_type_Int = paramInt;
    if ((this.jdField_f_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.TroopChatPie", 2, "changeSubTitleType, not init ui");
      }
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return;
    }
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt, 0);
    }
  }
  
  public boolean y()
  {
    return false;
  }
  
  protected void z()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.d();
    }
    if (this.I)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "hasDestory = true return");
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView = null;
    }
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper != null) {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a();
    }
    AnonymousChatHelper.a().b();
    TroopMemberLbsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.Q) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494247), true);
    }
    TroopGiftMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.dismiss();
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer = null;
    }
    ((TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
    ((TroopBindPublicAccountMgr)localObject).e("");
    if (((TroopBindPublicAccountMgr)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((TroopBindPublicAccountMgr)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    x(0);
    this.n = 0;
    this.Y = false;
    this.aa = false;
    this.ab = false;
    localObject = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
    ((TroopRobotManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "off");
    ((TroopRobotManager)localObject).a(null);
    ((StoryManager)SuperManager.a(5)).c();
    ((UserManager)SuperManager.a(2)).d();
    ((TroopStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(207)).a();
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a();
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar = null;
    }
    v(0);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.b();
    }
    super.z();
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "doOnDestroy, timerHandler->removeCallbacksAndMessages");
      }
    }
    RobotResourcesManager.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController.b();
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController = null;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if ((this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_d_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController = null;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      TroopFileItemBuilder.jdField_a_of_type_JavaUtilHashMap.clear();
      TroopFileItemBuilder.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.TroopChatPie", 2, "doOnDestroy unregisterReceiver, e:" + localException.getMessage());
        }
      }
    }
  }
  
  boolean z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "handleTroopNotificationMsg");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.Q, this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!TroopNotificationHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      ThreadManager.post(new vxn(this), 8, null, true);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */