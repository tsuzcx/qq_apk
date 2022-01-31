package com.tencent.mobileqq.activity.aio.rebuild;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.assistant.PubAccountTipsManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.tips.PubAccountTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vashealth.SportManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.PublicMenuBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.XPanelContainer;
import cooperation.comic.PluginPreloader;
import cooperation.comic.QQComicPreloadManager;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import vwp;
import vws;
import vwt;
import vwu;
import vwv;
import vwx;
import vwy;
import vwz;
import vxa;
import vxb;
import vxe;
import vxf;
import vxg;
import vxh;
import vxi;
import vxj;
import vxk;
import vxm;
import vxo;
import vxp;
import vxq;
import vxr;
import vxs;
import vxt;
import vxu;
import vxv;
import vxx;
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
import vym;
import vyn;
import vyo;
import vyp;
import vyr;
import vys;
import vyt;
import vyv;
import vyw;
import vyx;
import vyy;
import vza;
import vzb;
import vzc;
import vzd;
import vzf;
import vzg;
import vzh;

public class PublicAccountChatPie
  extends BaseChatPie
{
  private int A;
  private int B = -1;
  private int C;
  private int D;
  private int E;
  public boolean O = false;
  public boolean P = false;
  public boolean Q;
  public boolean R = false;
  public boolean S = false;
  public boolean T = false;
  public boolean U;
  public boolean V;
  public boolean W;
  boolean X = false;
  public boolean Y = false;
  boolean Z = false;
  public Handler a;
  protected SpannableString a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public PublicAccountManager a;
  public PubAccountTipsManager a;
  EcShopObserver jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver = new vyn(this);
  public CustomMenuBar a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  protected MessageObserver a;
  public PublicAccountHandler a;
  public PublicAccountObserver a;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  public PublicAccountInfo a;
  public PreloadProcHitSession a;
  public AbsStructMsg a;
  public TroopEntranceBar a;
  PublicMenuBar jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = null;
  public QidianManager a;
  public QidianBusinessObserver a;
  public ActionSheet a;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new vys(this);
  private NewIntent jdField_a_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new vxf(this);
  private vzh jdField_a_of_type_Vzh;
  public int[] a;
  public boolean aa = false;
  public boolean ab = false;
  public boolean ac = false;
  public boolean ad;
  boolean ae = false;
  boolean af = false;
  public boolean ag;
  public boolean ah;
  public boolean ai = false;
  public boolean aj = false;
  public boolean ak = false;
  public boolean al = false;
  public boolean am = false;
  public boolean an;
  private boolean ao;
  private boolean ap;
  private boolean aq;
  private boolean ar;
  private boolean as;
  private boolean at;
  private boolean au;
  private boolean av;
  protected SpannableString b;
  public View.OnClickListener b;
  private PublicMenuBar jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar;
  protected PatchedButton b;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_b_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  private QQCustomDialog jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  List jdField_c_of_type_JavaUtilList = new ArrayList();
  private NewIntent jdField_c_of_type_MqqAppNewIntent;
  protected LinearLayout d;
  public QQProgressDialog d;
  private LinearLayout e;
  public String f;
  public Dialog g;
  public String g;
  long jdField_h_of_type_Long = -1L;
  private Dialog jdField_h_of_type_AndroidAppDialog;
  public String h;
  long i;
  public String i;
  long jdField_j_of_type_Long = -1L;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  public String j;
  long jdField_k_of_type_Long = 0L;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  public String k;
  private long l;
  public String l;
  public int m;
  private long m;
  public String m;
  public int n;
  private long jdField_n_of_type_Long;
  protected ImageView n;
  private String jdField_n_of_type_JavaLangString = "";
  public int o;
  public View o;
  protected ImageView o;
  public int p;
  public View p;
  public ImageView p;
  protected int q;
  View jdField_q_of_type_AndroidViewView;
  private ImageView jdField_q_of_type_AndroidWidgetImageView;
  protected int r;
  View jdField_r_of_type_AndroidViewView;
  private ImageView jdField_r_of_type_AndroidWidgetImageView;
  public int s;
  View s;
  public int t;
  private View t;
  public int u;
  private View u;
  public int v;
  private View v;
  private int jdField_w_of_type_Int;
  private View jdField_w_of_type_AndroidViewView;
  private int x;
  private int y;
  private int z;
  
  public PublicAccountChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_o_of_type_AndroidViewView = null;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_n_of_type_Int = -1;
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = 3;
    this.jdField_i_of_type_Long = -1L;
    this.jdField_q_of_type_Int = 2130837555;
    this.jdField_r_of_type_Int = 2130837554;
    this.jdField_l_of_type_Long = 9223372036854775807L;
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("web_public_account", "com.tencent.mobileqq:tool");
    this.jdField_a_of_type_AndroidOsHandler = new vwp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vzg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new vym(this);
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new vyv(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new vyy(this);
  }
  
  private void A(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new vxj(this, paramInt), 500L);
  }
  
  private void B(int paramInt)
  {
    if (this.jdField_e_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams1;
    do
    {
      return;
      localLayoutParams1 = (LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.jdField_e_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams1);
      }
      if (localLayoutParams2.gravity != paramInt)
      {
        localLayoutParams2.gravity = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams2);
      }
      localLayoutParams1 = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    } while (localLayoutParams1.gravity == paramInt);
    localLayoutParams1.gravity = paramInt;
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams1);
  }
  
  private void a(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1)) {
      B(80);
    }
    while (!CustomMenuBar.a()) {
      return;
    }
    B(16);
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.addUpdateListener(new vws(this, paramView, paramInt1, paramInt2));
    localValueAnimator.addListener(paramAnimatorListener);
    localValueAnimator.setDuration(500L).start();
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getBoolean("firstIntoAIO", true))
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(Color.parseColor("#B3000000"));
      localLinearLayout.setVisibility(0);
      localLinearLayout.setClickable(true);
      localLinearLayout.setOnClickListener(new vyj(this, paramRelativeLayout, localLinearLayout));
      Object localObject = new ImageView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((ImageView)localObject).setImageResource(2130839697);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      Resources localResources = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
      localLayoutParams.width = AIOUtils.a(73.0F, localResources);
      localLayoutParams.height = AIOUtils.a(73.0F, localResources);
      localLayoutParams.topMargin = AIOUtils.a(100.0F, localResources);
      localLayoutParams.gravity = 17;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((TextView)localObject).setText("下滑拉取更多消息");
      ((TextView)localObject).setTextSize(2, 18.0F);
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = AIOUtils.a(28.0F, localResources);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      paramRelativeLayout.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
      localSharedPreferences.edit().putBoolean("firstIntoAIO", false).commit();
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new vxk(this, paramAccountDetail), 10L);
  }
  
  private void a(MessageForStructing paramMessageForStructing)
  {
    int i1 = 0;
    if (paramMessageForStructing.structingMsg == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramMessageForStructing.structingMsg;
      this.jdField_n_of_type_JavaLangString = paramMessageForStructing.getExtInfoFromExtStr("msg_template_id");
      this.jdField_m_of_type_Int = paramMessageForStructing.structingMsg.mPromotionType;
      this.jdField_f_of_type_JavaLangString = paramMessageForStructing.structingMsg.mPromotionMsg;
      this.jdField_g_of_type_JavaLangString = paramMessageForStructing.structingMsg.mPromotionMenus;
      this.jdField_n_of_type_Int = paramMessageForStructing.structingMsg.mPromotionMenuDestructiveIndex;
      try
      {
        if (this.jdField_g_of_type_JavaLangString == null) {
          continue;
        }
        this.av = false;
        paramMessageForStructing = this.jdField_g_of_type_JavaLangString.split(",");
        if (paramMessageForStructing == null) {
          continue;
        }
        int i2 = paramMessageForStructing.length;
        this.jdField_a_of_type_ArrayOfInt = new int[i2];
        while (i1 < i2)
        {
          paramMessageForStructing[i1] = paramMessageForStructing[i1].trim();
          this.jdField_a_of_type_ArrayOfInt[i1] = Integer.parseInt(paramMessageForStructing[i1]);
          i1 += 1;
        }
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        this.av = true;
      }
    }
  }
  
  private void a(String paramString, int paramInt, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("need_report", false))
    {
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_6", "msg_push");
      long l1 = paramIntent.getLongExtra("incoming_msguid", 0L);
      long l2 = paramIntent.getLongExtra("incoming_shmsgseq", 0L);
      if (l1 > 0L) {
        ThreadManager.post(new vxu(this, paramString, paramInt, l1, l2), 5, null, true);
      }
    }
    if (paramIntent.hasExtra("need_report")) {
      paramIntent.removeExtra("need_report");
    }
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (localObject != null) {}
    for (localObject = ((PublicAccountDataManager)localObject).b(paramString);; localObject = null)
    {
      if (localObject == null)
      {
        paramQQAppInterface = paramQQAppInterface.a();
        if (paramQQAppInterface != null)
        {
          paramString = paramQQAppInterface.a(paramString, 1008);
          if ((paramString != null) && (paramString.msgtype == -2011))
          {
            paramQQAppInterface = new MessageForStructing();
            MessageForStructing.copyMessageRecordBaseField(paramQQAppInterface, paramString);
            paramQQAppInterface.parse();
            if ((paramQQAppInterface.structingMsg != null) && ((paramQQAppInterface.structingMsg.mPromotionType == 1) || (paramQQAppInterface.structingMsg.mPromotionType == 2))) {
              return true;
            }
          }
        }
      }
      return false;
    }
  }
  
  private void b(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.b(paramAccountDetail);
    localEntityManager.a();
  }
  
  private void bq()
  {
    ThreadManager.postImmediately(new vzd(this), null, true);
  }
  
  private void br()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null) {
      A();
    }
  }
  
  private void bs()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("op", "0");
      localBundle.putString("puin", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      localBundle.putString("Referer", "https://buluo.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new HttpWebCgiAsyncTask2("https://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new vxh(this), 1000, null).a(localHashMap);
      aZ();
      return;
    }
  }
  
  private void bt()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("public_aio_setting", 0);
    String str = "firstOpen_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (localSharedPreferences.getBoolean(str, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.executeOnSubThread(new vxr(this, localSharedPreferences, str));
  }
  
  private void bu()
  {
    if (this.jdField_n_of_type_Long == 0L) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (localObject != null) {
      localHashMap.put("uin", localObject);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {
      localHashMap.put("puin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    localHashMap.put("menu_click", "" + this.jdField_s_of_type_Int);
    localHashMap.put("menu_to_webview", "" + this.jdField_u_of_type_Int);
    localHashMap.put("article_click", "" + this.jdField_t_of_type_Int);
    localHashMap.put("article_to_webview", "" + this.jdField_v_of_type_Int);
    localHashMap.put("net_type", "" + NetworkCenter.a().a());
    localHashMap.put("unread_count", "" + this.A);
    long l1 = System.currentTimeMillis() - this.jdField_n_of_type_Long;
    if ((this.jdField_v_of_type_Int != 0) || (this.jdField_u_of_type_Int != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("public account webview preload data: ");
        ((StringBuilder)localObject).append("duration: ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", entered: ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", exinfo: ");
        ((StringBuilder)localObject).append(localHashMap.toString());
        QLog.d("Q.aio.BaseChatPie", 2, ((StringBuilder)localObject).toString());
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPublicAccountWebviewPreload", bool, l1, 0L, localHashMap, "");
      this.jdField_n_of_type_Long = 0L;
      this.A = 0;
      this.jdField_u_of_type_Int = 0;
      this.jdField_s_of_type_Int = 0;
      this.jdField_t_of_type_Int = 0;
      this.jdField_v_of_type_Int = 0;
      return;
    }
  }
  
  private void bv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountDataManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      return;
    }
    Object localObject = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), PublicAccountServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("7.6.3,3,3560");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      label162:
      ((NewIntent)localObject).putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new vxv(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label162;
    }
  }
  
  private void bw()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localPublicAccountDataManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localPublicAccountDataManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      bx();
    }
  }
  
  private void bx()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    SosoInterface.a(new vye(this, 1, true, true, 0L, false, false, "PublicAccountChatPie"));
  }
  
  private void by()
  {
    a((RelativeLayout)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getParent());
  }
  
  private void c(AccountDetail paramAccountDetail)
  {
    if (this.jdField_o_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject1 = (TextView)this.jdField_o_of_type_AndroidViewView.findViewById(2131363043);
    Object localObject2 = (TextView)this.jdField_o_of_type_AndroidViewView.findViewById(2131363044);
    ImageView localImageView = (ImageView)this.jdField_o_of_type_AndroidViewView.findViewById(2131362719);
    if (this.at) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0);
        ((TextView)localObject1).setText(localTroopInfo.troopname);
        ((TextView)localObject2).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131430060), new Object[] { paramAccountDetail.name }));
        localImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localTroopInfo.troopuin));
        localObject1 = "";
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = ((TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          break label318;
        }
        localObject2 = "";
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "exp_temp", 0, 0, (String)localObject1, "" + (String)localObject2, "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new vyb(this, localImageView);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
      localObject1 = (ImageView)this.jdField_o_of_type_AndroidViewView.findViewById(2131362720);
      if (paramAccountDetail.certifiedGrade != 0) {
        break label375;
      }
      ((ImageView)localObject1).setVisibility(8);
      return;
      label318:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break;
      ((TextView)localObject1).setText(paramAccountDetail.name);
      if (this.jdField_f_of_type_JavaLangString != null) {
        ((TextView)localObject2).setText(this.jdField_f_of_type_JavaLangString);
      }
      localImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().jdField_a_of_type_JavaLangString, (byte)3));
    }
    label375:
    ((ImageView)localObject1).setVisibility(0);
  }
  
  private void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "unfollow");
    }
    A(2131430031);
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "unfollow");
    mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
    localUnFollowRequest.uin.set((int)Long.parseLong(paramString));
    localNewIntent.putExtra("data", localUnFollowRequest.toByteArray());
    this.jdField_b_of_type_MqqObserverBusinessObserver = new vxi(this, paramString);
    localNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    this.D += 1;
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "unfollow exit");
    }
  }
  
  public boolean A()
  {
    return (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) || (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getVisibility() == 8);
  }
  
  protected void D()
  {
    super.D();
    long l1 = NetConnInfoCenter.getServerTime() * 1000L;
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      int i1 = this.jdField_b_of_type_JavaUtilList.size() - 1;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C35", "0X8005C35", 0, 1, 0, (String)this.jdField_b_of_type_JavaUtilList.get(i1), String.valueOf(this.jdField_h_of_type_Long), String.valueOf(l1), (String)this.jdField_c_of_type_JavaUtilList.get(i1));
    }
    if (this.U)
    {
      if (this.V) {
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 0, "new", String.valueOf(l1 - this.jdField_j_of_type_Long), "", "", false);
      }
    }
    else {
      return;
    }
    PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 0, "old", String.valueOf(l1 - this.jdField_j_of_type_Long), "", "", false);
  }
  
  protected void E()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
      ((EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87)).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    super.E();
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
  }
  
  protected void F()
  {
    super.F();
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(37, 500L);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.c();
    }
    if ((PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("输城市名查天气");
    }
    if ((!this.ap) && (this.aq))
    {
      this.aq = false;
      ThreadManager.postImmediately(new vyr(this), null, true);
    }
    this.jdField_j_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    if (ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
    }
    for (;;)
    {
      EcShopHandler localEcShopHandler = (EcShopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(68);
      if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        long l1 = 0L;
        if (EcShopAssistantManager.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {
          l1 = ((Long)EcShopAssistantManager.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).longValue();
        }
        if ((!TextUtils.isEmpty((String)EcShopAssistantManager.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) && (System.currentTimeMillis() - l1 <= EcShopAssistantManager.jdField_a_of_type_Int)) {
          break;
        }
        EcShopAssistantManager.b.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
        localEcShopHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      return;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      if ((this.jdField_d_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getText().length() < 6)) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      } else {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130843935);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  protected void G()
  {
    if ((this.at) && (this.au)) {
      return;
    }
    ArkAppCenter.a().post(new vyo(this));
    super.G();
    if (!this.au) {
      ThreadManager.post(new vyp(this), 5, null, false);
    }
    this.au = true;
  }
  
  protected void H()
  {
    super.H();
    this.ap = false;
    this.aq = false;
  }
  
  protected void X()
  {
    if ((this.as) && (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) > 0)) {
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.X();
    Object localObject;
    if (PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(2, new vxs(this));
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      if (localObject != null)
      {
        int i2 = ((List)localObject).size();
        int i1 = 0;
        if (i1 >= i2) {
          break label357;
        }
        ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(i1);
        if (localChatMessage == null) {}
        while ((localChatMessage.msgtype != -5008) && (localChatMessage.msgtype != -3006))
        {
          i1 += 1;
          break;
        }
      }
    }
    label357:
    for (boolean bool = false;; bool = true)
    {
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(0, 0, 0, 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "first time fetch newest weather :" + bool);
      }
      for (;;)
      {
        localObject = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
        if ((localObject != null) && (((EcShopAssistantManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          ThreadManager.post(new vyf(this), 5, null, true);
        }
        NowVideoController.a().a(1000L);
        return;
        if (("3026775809".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSystemService("sensor")).getDefaultSensor(19) != null)) {
          ((SportManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(259)).a("public account");
        }
      }
    }
  }
  
  public Map a(AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg != null) {
      try
      {
        if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
        {
          paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).mMsgActionData;
          if ((paramAbsStructMsg != null) && (!TextUtils.isEmpty(paramAbsStructMsg)))
          {
            paramAbsStructMsg = URLUtil.b(paramAbsStructMsg.substring(paramAbsStructMsg.indexOf("?") + 1));
            return paramAbsStructMsg;
          }
        }
      }
      catch (Exception paramAbsStructMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, paramAbsStructMsg.getMessage());
        }
      }
    }
    return null;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.aq = true;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.U) {
      x(2131430057);
    }
  }
  
  public void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3, paramInt, 1, paramBusinessObserver);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.ai) {
      bn();
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  protected void a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((TroopInfo)localIterator.next()).troopuin.equals(paramMessage.frienduin));
      }
      for (int i1 = 1; (paramMessage.istroop != 1) || (i1 == 0); i1 = 0)
      {
        super.a(paramMessage);
        return;
      }
    }
  }
  
  public void a(PublicAccountInfo paramPublicAccountInfo)
  {
    PublicAccountDataManager localPublicAccountDataManager;
    if (paramPublicAccountInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + paramPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + paramPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + paramPublicAccountInfo.mIsAgreeSyncLbs);
      }
      localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localPublicAccountDataManager == null) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "showEqqLbsEnableDialog(): pam is null");
        }
      }
    }
    for (;;)
    {
      return;
      if ((paramPublicAccountInfo.isSyncLbs) && (!paramPublicAccountInfo.mIsSyncLbsSelected) && (!paramPublicAccountInfo.mIsAgreeSyncLbs) && (!this.ar))
      {
        String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131428081);
        String str2 = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131428082), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
        this.jdField_g_of_type_AndroidAppDialog = DialogUtil.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, str1, str2, 2131428083, 2131428084, new vxx(this, paramPublicAccountInfo, localPublicAccountDataManager), new vxz(this, paramPublicAccountInfo, localPublicAccountDataManager));
        this.jdField_g_of_type_AndroidAppDialog.setOnDismissListener(new vya(this));
        this.jdField_g_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
          this.jdField_g_of_type_AndroidAppDialog.show();
        }
        this.ar = true;
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.aio.BaseChatPie", 2, "showEqqLbsEnableDialog(): END");
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.BaseChatPie", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  void a(AbsListView paramAbsListView)
  {
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    int i1 = paramAbsListView.getFirstVisiblePosition();
    ChatMessage localChatMessage;
    if (i1 <= paramAbsListView.getLastVisiblePosition())
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1);
      if (localChatMessage != null) {}
    }
    for (;;)
    {
      i1 += 1;
      break;
      String str3;
      long l1;
      try
      {
        String str1;
        if ((!localChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("")) && (!localChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("true")))
        {
          localArrayList5.add(localChatMessage);
          str3 = localChatMessage.getExtInfoFromExtStr("pa_msgId");
          str1 = str3;
          if (TextUtils.isEmpty(str3)) {
            str1 = "0";
          }
          l1 = Long.parseLong(str1);
          if (localChatMessage.getExtInfoFromExtStr("pa_should_report").equals("true"))
          {
            localArrayList4.add(Long.valueOf(l1));
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "Report message at index: " + String.valueOf(i1) + ". MessageId is " + l1);
            }
          }
          localChatMessage.saveExtInfoToExtStr("pa_msgHasRead", "true");
          str3 = localChatMessage.getExtInfoFromExtStr("msg_template_id");
          str1 = str3;
          if (str3 == null) {
            str1 = "";
          }
          PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80057C4", "0X80057C4", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(l1), str1, "", false);
        }
        if (!localChatMessage.getExtInfoFromExtStr("ad_msgHasRead").equals("false")) {
          continue;
        }
        localChatMessage.saveExtInfoToExtStr("ad_msgHasRead", "true");
        String str4 = localChatMessage.getExtInfoFromExtStr("pa_msgId");
        String str5 = localChatMessage.getExtInfoFromExtStr("gdt_msgClick");
        str3 = "0";
        String str6 = localChatMessage.getExtInfoFromExtStr("gdt_view_id");
        try
        {
          JSONObject localJSONObject = new JSONObject(str5);
          str1 = str3;
          if (localJSONObject.has("ad_id")) {
            str1 = localJSONObject.getString("ad_id");
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            String str2 = str3;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.aio.BaseChatPie", 2, " parse ad_id error");
              str2 = str3;
            }
          }
        }
        localArrayList1.add(str4);
        this.jdField_c_of_type_JavaUtilList.add(str1);
        localArrayList2.add(str5);
        localArrayList3.add(str6);
        if (localArrayList5.contains(localChatMessage)) {
          continue;
        }
        localArrayList5.add(localChatMessage);
      }
      catch (Exception localException2) {}
      b(localArrayList5);
      if (!localArrayList4.isEmpty()) {}
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, 0L, l1, l2, 2, localArrayList4);
        paramAbsListView = localArrayList5.iterator();
        while (paramAbsListView.hasNext()) {
          if ("1".equals(((ChatMessage)paramAbsListView.next()).getExtInfoFromExtStr("is_AdArrive_Msg")))
          {
            if (this.jdField_h_of_type_Long == -1L) {
              this.jdField_h_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
            }
            this.jdField_b_of_type_JavaUtilList = localArrayList1;
            PAReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList2, localArrayList1, localArrayList3);
          }
        }
        return;
      }
      catch (Exception paramAbsListView)
      {
        return;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(37);
      NowVideoController.a().a(500L);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.ai) || (this.an)) {}
    label249:
    label251:
    int i1;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((this.jdField_o_of_type_AndroidViewView != null) && (this.jdField_u_of_type_AndroidViewView != null) && (this.jdField_p_of_type_Int != 5))
          {
            if (this.y > paramInt3)
            {
              this.jdField_p_of_type_Int = 4;
              this.y = paramInt3;
              switch (this.jdField_p_of_type_Int)
              {
              }
            }
            for (;;)
            {
              if ((!this.ao) && (!this.S)) {
                break label249;
              }
              if ((!this.ab) || (this.S)) {
                break label251;
              }
              this.ab = false;
              return;
              if (this.y >= paramInt3) {
                break;
              }
              this.jdField_p_of_type_Int = 3;
              break;
              if ((paramInt3 > paramInt2) && (!this.ao))
              {
                this.x = this.jdField_u_of_type_AndroidViewView.getLayoutParams().height;
                c(this.jdField_u_of_type_AndroidViewView);
                this.ao = true;
              }
              this.jdField_p_of_type_Int = 2;
              this.ab = true;
              continue;
              if ((paramInt3 == paramInt2) && (this.ao))
              {
                if (this.x != 0) {
                  a(this.jdField_u_of_type_AndroidViewView, this.x);
                }
                this.ao = false;
                this.S = true;
              }
              this.jdField_p_of_type_Int = 2;
              this.ab = true;
            }
          }
        }
        if (this.jdField_o_of_type_AndroidViewView.getHeight() != 0) {
          this.x = this.jdField_o_of_type_AndroidViewView.getHeight();
        }
        i1 = this.jdField_w_of_type_Int - i();
        this.jdField_w_of_type_Int = i();
        if (this.jdField_C_of_type_Int * i1 < 0)
        {
          this.jdField_C_of_type_Int = i1;
          return;
        }
        this.jdField_C_of_type_Int = i1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "Move = " + String.valueOf(i1));
        }
        switch (this.jdField_o_of_type_Int)
        {
        default: 
          return;
        }
      } while (((i1 <= 5) || (!this.aa)) && ((paramInt1 != this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()) || (i1 <= 0) || (!this.aa) || (this.R)));
      this.R = true;
      paramAbsListView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.x);
      paramAbsListView.setFillAfter(true);
      paramAbsListView.setDuration(250L);
      paramAbsListView.setAnimationListener(new vwx(this));
      this.jdField_o_of_type_AndroidViewView.startAnimation(paramAbsListView);
      return;
    } while (((i1 >= -5) || (!this.aa)) && (((!this.S) && ((paramInt1 + paramInt2 != paramInt3) || (i1 >= 0) || (!this.aa))) || (this.R)));
    this.R = true;
    paramAbsListView = new TranslateAnimation(0.0F, 0.0F, -this.x, 0.0F);
    paramAbsListView.setFillAfter(true);
    paramAbsListView.setDuration(250L);
    paramAbsListView.setAnimationListener(new vwy(this));
    this.jdField_o_of_type_AndroidViewView.startAnimation(paramAbsListView);
  }
  
  protected void a(List paramList, CharSequence paramCharSequence)
  {
    this.ah = true;
    super.a(paramList, paramCharSequence);
    int i1;
    long l1;
    if (this.jdField_u_of_type_Boolean)
    {
      if (paramList.size() <= 0) {
        break label177;
      }
      paramList = (ChatMessage)paramList.get(paramList.size() - 1);
      i1 = paramList.msgtype;
      l1 = paramList.msgseq;
      if (!(paramList instanceof MessageForStructing)) {
        break label174;
      }
      paramList = (MessageForStructing)paramList;
      if (paramList.structingMsg == null) {
        break label174;
      }
      l1 = paramList.structingMsg.msgId;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064D4", "0X80064D4", 0, 0, "", "" + i1, "" + l1, "");
      return;
      label174:
      continue;
      label177:
      l1 = 0L;
      i1 = -1;
    }
  }
  
  public void a(Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "qidianWpaClick ... mQidianKefu = " + this.ak);
    }
    v(2131430029);
    Object localObject;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      localObject = (String)paramMap.get("AssignType");
      String str = (String)paramMap.get("AssignID");
      paramMap = (Map)localObject;
      localObject = str;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMap, (String)localObject, null, new vyx(this));
      return;
      localObject = null;
      paramMap = null;
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!A()) {
        this.B = 2;
      }
      for (;;)
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        super.a(paramBoolean1, paramChatMessage, paramBoolean2);
        return;
        if (!z()) {
          this.B = 1;
        } else {
          this.B = 0;
        }
      }
    }
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    switch (this.B)
    {
    }
    for (;;)
    {
      this.B = -1;
      return;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        continue;
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
        {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
          continue;
          if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "listView onViewCompleteVisableAndReleased");
    }
    if (!this.U) {
      return super.a(paramInt, paramView, paramListView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0))
    {
      this.W = true;
      b(System.currentTimeMillis());
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.a).a(this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 21, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
    }
    return true;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Vzh = new vzh(this, null);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Vzh, (IntentFilter)localObject);
    this.I = false;
    this.jdField_C_of_type_Boolean = false;
    br();
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager = PublicAccountManager.a();
    bj();
    super.a(paramBoolean);
    if (this.ai) {
      bl();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0) {
      this.ad = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar = new TroopEntranceBar();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.addObserver(this);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    this.jdField_m_of_type_Long = System.currentTimeMillis();
    this.z = ((Intent)localObject).getIntExtra("red_hot_count", 0);
    String str = ((Intent)localObject).getStringExtra("from");
    this.Z = ((Intent)localObject).getBooleanExtra("shouldreport", false);
    this.jdField_n_of_type_Long = System.currentTimeMillis();
    this.jdField_t_of_type_Int = 0;
    this.jdField_v_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_u_of_type_Int = 0;
    this.A = this.z;
    PublicAccountUtil.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("is_come_from_readinjoy", false);
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localPublicAccountInfo == null) || (PublicAccountUtil.a(localPublicAccountInfo.accountFlag) != -2)) {
        break label588;
      }
      this.as = true;
      bb();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.f();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b > 0) {
        break label470;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
    }
    for (;;)
    {
      PublicAccountHandler.jdField_a_of_type_JavaLangString = null;
      this.X = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("has_unread_msg", false);
      if ((str == null) || (!str.equals("starShortcut"))) {
        break;
      }
      PublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Intent)localObject).getStringExtra("starhomeurl"), ((Intent)localObject).getStringExtra("uin"), str);
      return true;
      label470:
      int i2 = ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (i2 == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
      }
      else
      {
        int i1;
        if ((i2 & 0xF) == 0)
        {
          i1 = 1;
          label532:
          if (i2 >> 4 != 1) {
            break label566;
          }
          i2 = 1;
          label541:
          if ((i1 == 0) || (i2 == 0)) {
            break label571;
          }
          this.at = true;
        }
        for (;;)
        {
          bq();
          break;
          i1 = 0;
          break label532;
          label566:
          i2 = 0;
          break label541;
          label571:
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.e();
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b();
        }
        label588:
        bq();
      }
    }
    if ((NetworkUtil.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()) == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals("2632129500"))) {
      HtmlOffline.b("108", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new vzc(this));
    }
    if ("3105932915".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (QQComicPreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141);
      if (localObject != null) {
        PluginPreloader.a(((QQComicPreloadManager)localObject).a(5));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    this.U = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "doOnCreate, isMediaAndOtherSubscript = " + this.U);
    }
    this.jdField_i_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    if (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "doOnCreate, preload web process");
        }
        ((WebProcessManager)localObject).e();
      }
    }
    if (this.U)
    {
      by();
      bg();
      bi();
    }
    if (this.U) {
      if (this.V) {
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "new", "", "", false);
      }
    }
    for (;;)
    {
      if (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.Q = true;
      }
      return true;
      PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "old", "", "", false);
      continue;
      PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", false);
      if ("2290230341".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E2", "0X80090E2", 0, 0, "", "", "", "");
        QZoneReport.a(2);
      }
    }
  }
  
  public void aX()
  {
    ChatMessage localChatMessage;
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() >= 1)
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().get(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1);
      str1 = "0";
      if (localChatMessage != null)
      {
        localObject = localChatMessage.getExtInfoFromExtStr("gdt_msgClick");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("ad_id")) {
        str1 = ((JSONObject)localObject).getString("ad_id");
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        String str2 = "0";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "old", String.valueOf(l1 - this.jdField_i_of_type_Long), "", "");
    }
    Object localObject = localChatMessage.getExtInfoFromExtStr("pa_msgId");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "" + localChatMessage.frienduin, "0X8005C38", "0X8005C38", 0, 1, 0, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
    if (this.U)
    {
      l1 = NetConnInfoCenter.getServerTime() * 1000L;
      if (this.V) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "new", String.valueOf(l1 - this.jdField_i_of_type_Long), "", "");
      }
    }
    else
    {
      return;
    }
  }
  
  public void aY()
  {
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  @TargetApi(11)
  public void aZ()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new vwt(this));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_u_of_type_AndroidViewView);
      this.ao = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    a(this.jdField_u_of_type_AndroidViewView, this.jdField_u_of_type_AndroidViewView.getHeight(), 0, new vwu(this));
    this.jdField_o_of_type_AndroidViewView.setTranslationY(0.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_o_of_type_AndroidViewView.getHeight());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new vwv(this));
    this.jdField_o_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  protected void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
    if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
  }
  
  protected void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    super.afterTextChanged(paramEditable);
    a(paramEditable);
    PatchedButton localPatchedButton;
    if (this.jdField_e_of_type_Int == 0)
    {
      if (!this.jdField_e_of_type_Boolean) {
        break label75;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131433631);
      localPatchedButton = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() <= 0) {
        break label70;
      }
      bool1 = bool2;
      localPatchedButton.setEnabled(bool1);
    }
    label70:
    label75:
    do
    {
      do
      {
        return;
        bool1 = false;
        break;
      } while ((this.jdField_p_of_type_AndroidWidgetImageView != null) && (this.jdField_p_of_type_AndroidWidgetImageView.getVisibility() == 0));
      localPatchedButton = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() > 0) {
        bool1 = true;
      }
      localPatchedButton.setEnabled(bool1);
    } while (paramEditable.length() <= 0);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131433631);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
  }
  
  public void ap()
  {
    super.ap();
    if (this.jdField_l_of_type_AndroidViewView != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_l_of_type_AndroidViewView.getLayoutParams();
        if (localLayoutParams != null)
        {
          if (!A())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getId());
            return;
          }
          if (!z())
          {
            localLayoutParams.addRule(2, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b(int paramInt)
  {
    int i1 = 0xFFFF0000 & paramInt;
    super.b(paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (((i1 == 196608) || (i1 == 131072)) && (localList.size() > 0))
    {
      i1 = 0;
      int i3 = localList.size() - 1;
      if (i3 >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(i3);
        int i2 = i1;
        if (i1 == 0)
        {
          if ((this.jdField_l_of_type_Long == 9223372036854775807L) || (localChatMessage.uniseq == this.jdField_l_of_type_Long)) {
            i1 = 1;
          }
          i2 = i1;
          if (this.jdField_l_of_type_Long == 9223372036854775807L) {}
        }
        for (;;)
        {
          i3 -= 1;
          break;
          if (i2 != 0) {
            break label174;
          }
          i1 = i2;
        }
        label174:
        if (((localChatMessage instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.b(localChatMessage)) || (StructLongMessageDownloadProcessor.d(localChatMessage))))
        {
          String str = localChatMessage.getExtInfoFromExtStr("longMsg_State");
          if ((str == null) || (!String.valueOf(3).equals(str))) {
            break label239;
          }
        }
        for (;;)
        {
          this.jdField_l_of_type_Long = localChatMessage.uniseq;
          i1 = i2;
          break;
          label239:
          localChatMessage.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
          StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localChatMessage);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "REFRESH_FLAG_RELOAD  to load long message");
      }
    }
    if (paramInt != 131072) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(20);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(37);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.U) {
      x(2131430058);
    }
  }
  
  public void b(long paramLong)
  {
    try
    {
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_r_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    if (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void b(QQAppInterface paramQQAppInterface)
  {
    super.b(paramQQAppInterface);
    if ((ServiceAccountFolderManager.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ServiceAccountFolderManager.a().a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    super.b(paramChatMessage);
    Object localObject = paramChatMessage.frienduin;
    int i1 = paramChatMessage.istroop;
    if (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, i1))
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject = paramChatMessage.a((String)localObject, i1);
      if (localObject != null) {
        paramChatMessage.b((RecentUser)localObject);
      }
    }
  }
  
  void b(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "saveReadedToDB");
    }
    ThreadManager.postImmediately(new vwz(this, paramList), null, false);
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EF8", "0X8004EF8", 0, 0, Integer.toString(paramInt), "", "", "");
    if (this.jdField_b_of_type_MqqAppNewIntent != null)
    {
      PublicAccountManager.a().a(this.jdField_b_of_type_MqqAppNewIntent);
      this.jdField_b_of_type_MqqAppNewIntent = null;
    }
    this.jdField_b_of_type_MqqAppNewIntent = PublicAccountManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt, paramBoolean, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new vyc(this));
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        return (((PublicAccountInfo)localObject).accountFlag & 0x40000000) == 1073741824;
      }
      return false;
    }
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        return false;
      }
      return (((AccountDetail)localObject).accountFlag & 0x40000000) == 1073741824;
    }
    return false;
  }
  
  public void ba()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        this.jdField_o_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext()).inflate(2130968657, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      } while (this.jdField_o_of_type_AndroidViewView == null);
      this.jdField_o_of_type_AndroidViewView.setClickable(true);
      this.jdField_o_of_type_AndroidViewView.findViewById(2131362719).setOnClickListener(new vxa(this));
      if (this.jdField_m_of_type_Int != 2) {
        break;
      }
      this.jdField_o_of_type_AndroidViewView.findViewById(2131363041).setVisibility(8);
      this.jdField_o_of_type_AndroidViewView.findViewById(2131363045).setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_o_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      this.jdField_u_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext()).inflate(2130968656, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    } while (this.jdField_u_of_type_AndroidViewView == null);
    label218:
    int i1;
    label268:
    label380:
    MenuItem localMenuItem1;
    if (this.jdField_m_of_type_Int == 2)
    {
      this.jdField_u_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131559055));
      if ((!this.ai) && (!this.an)) {
        break label560;
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (this.P))
        {
          c((AccountDetail)localObject);
          this.P = false;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = ((PublicMenuBar)this.jdField_o_of_type_AndroidViewView.findViewById(2131363046));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setOnMenuItemClickListener(new vxb(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a();
      if (this.ai) {
        break label605;
      }
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      if (!this.at) {
        break label598;
      }
      i1 = 2131436131;
      localObject = new MenuItem("DO_NOT_FOLLOW", ((FragmentActivity)localObject).getString(i1), a().getResources().getDrawable(2130839733), 0);
      localMenuItem1 = new MenuItem("DO_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131436132), a().getResources().getDrawable(2130839692), 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((MenuItem)localObject, 2130969526);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem1, 2130969526);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setSwitchButtonVisibility(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(0);
      return;
      if (!this.ai) {
        break;
      }
      this.jdField_o_of_type_AndroidViewView.findViewById(2131363041).setVisibility(8);
      this.jdField_o_of_type_AndroidViewView.findViewById(2131363045).setVisibility(8);
      break;
      if (!this.ai) {
        break label218;
      }
      this.jdField_u_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131559055));
      break label218;
      label560:
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter();
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_u_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter((ListAdapter)localObject);
      break label268;
      label598:
      i1 = 2131436133;
      break label380;
      label605:
      localObject = new MenuItem("DO_CANCEL", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131434598), a().getResources().getDrawable(2130839733), 0);
      localMenuItem1 = new MenuItem("DO_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131436132), a().getResources().getDrawable(2130839692), 1);
      MenuItem localMenuItem2 = new MenuItem("DO_NOT_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131436131), a().getResources().getDrawable(2130839733), 0);
      this.jdField_r_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((MenuItem)localObject, 2130969526);
      this.jdField_q_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem2, 2130969526);
      this.jdField_s_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem1, 2130969526);
    }
  }
  
  public void bb()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_j_of_type_AndroidViewView != null) {
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_k_of_type_AndroidViewView != null) {
      this.jdField_k_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void bc()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a("确定后你将不再收到通知消息");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a("确定", 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new vxe(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new vxg(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.ac = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void bd()
  {
    if (this.ap) {
      break label7;
    }
    label7:
    label766:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        Object localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
        this.jdField_q_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131361893));
        if (this.jdField_q_of_type_AndroidWidgetImageView != null) {
          this.jdField_q_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131430047));
        }
        if (this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar);
        }
        if (this.jdField_o_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_o_of_type_AndroidViewView);
          this.jdField_o_of_type_AndroidViewView = null;
        }
        if (this.jdField_u_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_u_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363051));
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130968658, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363051));
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) {
            break label766;
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.b(a()));
          if (CustomMenuBar.a())
          {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131493279));
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(AIOUtils.a(48.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
          {
            Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
            Object localObject2 = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getLayoutParams();
            if ((localObject3 != null) && (localObject2 != null) && ((localObject3 instanceof RelativeLayout.LayoutParams)) && ((localObject2 instanceof RelativeLayout.LayoutParams)))
            {
              localObject3 = (RelativeLayout.LayoutParams)localObject3;
              int[] arrayOfInt = ((RelativeLayout.LayoutParams)localObject3).getRules();
              if ((arrayOfInt.length > 2) && (arrayOfInt[2] == 2131363494))
              {
                ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131363051);
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                localObject2 = (RelativeLayout.LayoutParams)localObject2;
                ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131363494);
                this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          if (this.T)
          {
            localObject1 = new TranslateAnimation(0.0F, 0.0F, AIOUtils.a(34.0F, (Resources)localObject1), 0.0F);
            ((TranslateAnimation)localObject1).setDuration(250L);
            ((TranslateAnimation)localObject1).setFillAfter(true);
            ((TranslateAnimation)localObject1).setAnimationListener(new vxm(this));
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.startAnimation((Animation)localObject1);
          }
          localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363047);
          ((View)localObject1).setOnClickListener(new vxo(this));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject1);
          this.jdField_t_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363048);
          bt();
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("menuEventSharePre", 0);
          if (!((SharedPreferences)localObject1).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            localObject1 = ((SharedPreferences)localObject1).edit();
            ((SharedPreferences.Editor)localObject1).putInt(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
            ((SharedPreferences.Editor)localObject1).commit();
          }
          this.jdField_q_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new vxp(this));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new vxq(this));
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          c((List)localObject1);
          this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            o(true);
          }
          this.ap = true;
          if (this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager == null) {
            this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager = new PubAccountTipsManager(this.jdField_a_of_type_AndroidContentContext);
          }
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
          if ((!((Intent)localObject1).hasExtra("pub_account_type")) || (!"type_ecshop_account".equals(((Intent)localObject1).getStringExtra("pub_account_type")))) {
            break;
          }
          localObject1 = ((Intent)localObject1).getStringExtra("ecshop_distance_tip");
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager.a((String)localObject1, this);
          this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (View)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconPv", "Pv_shopnearbyicon", 0, 0, "", "", "", "");
          return;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
      }
    }
  }
  
  public void be()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
    {
      if ((this.jdField_d_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getText().length() < 6)) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void bf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "follow");
    }
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).ext.set("4");
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new vyd(this);
    this.jdField_c_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
    PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "follow exit");
    }
  }
  
  public void bg()
  {
    ThreadManager.post(new vyi(this), 8, null, true);
  }
  
  @TargetApi(11)
  protected void bh()
  {
    if (this.jdField_n_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.jdField_e_of_type_Int != 1) {
        break;
      }
      this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130842202);
      this.jdField_n_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!VersionUtils.e());
    this.jdField_n_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.jdField_e_of_type_Int == 2)
    {
      this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.e()) {
        this.jdField_n_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130845670);
        }
        for (;;)
        {
          this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131433396));
          return;
          this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130845964);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130845669);
      }
      for (;;)
      {
        this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131433395));
        return;
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130845965);
      }
    }
    this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130845670);
      }
      for (;;)
      {
        this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131433396));
        label246:
        if (!VersionUtils.e()) {
          break;
        }
        this.jdField_n_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130845964);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130845669);
    }
    for (;;)
    {
      this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131433395));
      break label246;
      break;
      this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130845965);
    }
  }
  
  public void bi()
  {
    this.jdField_v_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969229, null);
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_v_of_type_AndroidViewView.findViewById(2131363945));
    if (!this.V) {
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_v_of_type_AndroidViewView.findViewById(2131363944));
    this.jdField_r_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_v_of_type_AndroidViewView.findViewById(2131363301));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_v_of_type_AndroidViewView.findViewById(2131363049));
  }
  
  void bj()
  {
    bp();
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164));
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("qd_wpa_key");
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("qd_kfuin");
      this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_type");
      this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_key");
      this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_ext");
      this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("rkey");
      this.ai = true;
      this.aj = false;
      this.ak = false;
      this.al = false;
      this.am = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(str, this.jdField_i_of_type_JavaLangString);
      return;
    }
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQidianQidianManager.b(str);
    if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
    {
      this.ai = true;
      this.aj = true;
      this.jdField_j_of_type_JavaLangString = null;
      this.jdField_k_of_type_JavaLangString = null;
      this.jdField_l_of_type_JavaLangString = null;
      this.jdField_m_of_type_JavaLangString = null;
      this.ak = true;
      this.al = false;
      this.am = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      return;
    }
    this.ai = false;
    this.aj = false;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.ak = false;
    this.al = false;
    this.am = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  }
  
  protected void bk()
  {
    this.ai = false;
    this.aj = false;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.ak = false;
    this.al = false;
    this.am = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
    this.an = false;
  }
  
  public void bl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "checkQDAccountValid ...");
    }
    ThreadManager.post(new vyt(this), 8, null, false);
  }
  
  public void bm()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateHeader ... ");
      if (this.jdField_o_of_type_AndroidViewView == null) {
        break label68;
      }
    }
    label68:
    for (Object localObject = Integer.valueOf(this.jdField_o_of_type_AndroidViewView.getVisibility());; localObject = "")
    {
      QLog.d("Q.aio.BaseChatPie", 2, localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) && (this.aj)) {
        break;
      }
      return;
    }
    if (this.al)
    {
      this.jdField_r_of_type_AndroidViewView.setVisibility(0);
      this.jdField_q_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_r_of_type_AndroidViewView.setVisibility(8);
    this.jdField_q_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void bn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "updateWpaUiForQidian: mQidianAccountValid = " + this.aj + ", mQidianKefu = " + this.ak + ", mQidianShield: " + this.al);
    }
    if (this.aj) {
      if (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
        break label274;
      }
    }
    label274:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        bd();
        return;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      LinearLayout localLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (this.al) {
        i1 = 8;
      }
      for (;;)
      {
        localLinearLayout.setVisibility(i1);
        if (this.jdField_q_of_type_AndroidWidgetImageView == null) {
          this.jdField_q_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131361893));
        }
        this.jdField_q_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        if (this.jdField_o_of_type_AndroidViewView == null) {
          ba();
        }
        bm();
        return;
        if (this.ak) {
          i1 = 0;
        } else {
          i1 = 8;
        }
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
  }
  
  public void bo()
  {
    if ((!this.aj) || (!this.am)) {}
    int i1;
    do
    {
      return;
      if (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {}
      for (i1 = 1; (this.al) && (i1 == 0); i1 = 0)
      {
        AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131427344), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, true);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
        return;
      }
    } while ((this.al) || (i1 != 0));
  }
  
  public void bp()
  {
    ThreadManager.executeOnSubThread(new vzb(this));
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    bh();
    if (paramInt2 == 8) {
      if (this.jdField_o_of_type_AndroidWidgetImageView != null)
      {
        if (!CustomMenuBar.a()) {
          break label289;
        }
        this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130845713);
      }
    }
    for (;;)
    {
      if (!this.jdField_e_of_type_Boolean)
      {
        SpannableString localSpannableString;
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837627);
          localSpannableString = new SpannableString("文字输入");
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837958);
          localSpannableString = new SpannableString("语音输入");
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if ((QLog.isColorLevel()) && (this.jdField_p_of_type_AndroidWidgetImageView != null)) {
          QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.jdField_p_of_type_AndroidWidgetImageView.getVisibility());
        }
        if (paramInt2 != 2) {
          break;
        }
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (paramInt1 != 2) && (AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(false);
        }
      }
      return;
      label289:
      this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130845645);
      continue;
      if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
        if (CustomMenuBar.a()) {
          this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130845712);
        } else {
          this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130845644);
        }
      }
    }
    Object localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject).setSelected(bool);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
        break;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131433631);
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramIntent);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new vxt(this));
    bw();
    bp();
  }
  
  public void c(View paramView)
  {
    paramView.getLayoutParams().height = 0;
    paramView.requestLayout();
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage) + 1;
    if (i1 <= this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1)
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1);
      if ((localChatMessage != null) && (localChatMessage.msgtype == -1048))
      {
        super.c(paramChatMessage);
        i(localChatMessage);
        return;
      }
    }
    super.c(paramChatMessage);
  }
  
  public void c(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.b(a()));
      if ((paramList == null) || (paramList.isEmpty()))
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (this.jdField_j_of_type_AndroidViewView != null) {
          this.jdField_j_of_type_AndroidViewView.setVisibility(0);
        }
        if (this.jdField_k_of_type_AndroidViewView != null) {
          this.jdField_k_of_type_AndroidViewView.setVisibility(0);
        }
        if (this.jdField_q_of_type_AndroidWidgetImageView != null) {
          this.jdField_q_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      else
      {
        if (this.jdField_q_of_type_AndroidWidgetImageView != null) {
          this.jdField_q_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        int i3 = paramList.size();
        int i1 = 0;
        while ((i1 < i3) && (i1 <= 2))
        {
          Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i1);
          Object localObject1;
          String str;
          label198:
          label218:
          MenuItem localMenuItem;
          label261:
          label285:
          mobileqq_mp.ButtonInfo localButtonInfo;
          if (((mobileqq_mp.ButtonInfo)localObject2).key.has())
          {
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).key.get();
            if (!((mobileqq_mp.ButtonInfo)localObject2).name.has()) {
              break label408;
            }
            str = ((mobileqq_mp.ButtonInfo)localObject2).name.get();
            if (!((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
              break label415;
            }
            i2 = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
            localMenuItem = new MenuItem((String)localObject1, str, null, i2);
            localMenuItem.a((mobileqq_mp.ButtonInfo)localObject2);
            if (!((mobileqq_mp.ButtonInfo)localObject2).sub_button.has()) {
              break label420;
            }
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).sub_button.get();
            if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
              break label445;
            }
            localObject2 = ((List)localObject1).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label445;
            }
            localButtonInfo = (mobileqq_mp.ButtonInfo)((Iterator)localObject2).next();
            if (!localButtonInfo.key.has()) {
              break label426;
            }
            localObject1 = localButtonInfo.key.get();
            label328:
            if (!localButtonInfo.name.has()) {
              break label433;
            }
            str = localButtonInfo.name.get();
            label349:
            if (!localButtonInfo.id.has()) {
              break label440;
            }
          }
          label408:
          label415:
          label420:
          label426:
          label433:
          label440:
          for (int i2 = localButtonInfo.id.get();; i2 = 0)
          {
            localObject1 = new MenuItem((String)localObject1, str, null, i2);
            ((MenuItem)localObject1).a(localButtonInfo);
            localMenuItem.a((MenuItem)localObject1);
            break label285;
            localObject1 = "";
            break;
            str = "";
            break label198;
            i2 = 0;
            break label218;
            localObject1 = null;
            break label261;
            localObject1 = "";
            break label328;
            str = "";
            break label349;
          }
          label445:
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localMenuItem, a());
          i1 += 1;
        }
      }
    }
  }
  
  protected void d()
  {
    super.d();
    this.jdField_b_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363499));
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setContentDescription("发送");
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363496));
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.topMargin = 1;
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363498));
    localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.topMargin = 1;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
    if (CustomMenuBar.a()) {
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-1);
    }
    for (;;)
    {
      this.jdField_p_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131365601));
      this.jdField_p_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131365600));
      this.jdField_o_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131364075));
      this.jdField_n_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130844545);
        this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130837588);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130845774);
        if (!CustomMenuBar.a()) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131493279));
      }
      return;
      B(80);
    }
    int i1 = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, i1, 0, i1);
  }
  
  protected boolean d()
  {
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return (localPublicAccountInfo == null) || ((localPublicAccountInfo.accountFlag & 0x10000000) == 0);
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131432414));
    }
  }
  
  public void e(String paramString)
  {
    boolean bool = true;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppSchemeCenter", 2, "args:" + paramString);
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.getJSONObject("bidInfo");
      if (((JSONObject)localObject).optInt("isshow", 0) == 1) {}
      for (;;)
      {
        String str = ((JSONObject)localObject).getString("icon");
        localObject = ((JSONObject)localObject).getString("url");
        int i1 = paramString.getInt("bid");
        int i2 = paramString.getInt("cid");
        int i3 = paramString.getInt("web");
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new vza(this, bool, str, (String)localObject, i1, i2, i3));
        return;
        bool = false;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  protected void f(boolean paramBoolean)
  {
    if (this.U)
    {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
        {
          if (this.jdField_v_of_type_AndroidViewView == null) {
            bi();
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_v_of_type_AndroidViewView);
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
      return;
    }
    super.f(paramBoolean);
  }
  
  protected void g(Intent paramIntent)
  {
    br();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)
    {
      localObject = paramIntent.getStringExtra("uin");
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localObject))
      {
        bu();
        this.jdField_n_of_type_Long = System.currentTimeMillis();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0) {
      this.ad = true;
    }
    bj();
    if (this.ai)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (this.jdField_j_of_type_AndroidViewView != null) {
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_k_of_type_AndroidViewView != null) {
        this.jdField_k_of_type_AndroidViewView.setVisibility(8);
      }
    }
    super.g(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    if (this.ai) {
      bl();
    }
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (!this.ai))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a()))) {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(a());
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      c((List)localObject);
      this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        o(true);
      }
    }
    Object localObject = paramIntent.getStringExtra("from");
    if ((localObject != null) && (((String)localObject).equals("starShortcut"))) {
      PublicAccountManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("starhomeurl"), paramIntent.getStringExtra("uin"), (String)localObject);
    }
    this.au = false;
  }
  
  protected void h()
  {
    PubAccountTips localPubAccountTips = new PubAccountTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localPubAccountTips);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1000, new Object[0]);
      continue;
      if (this.jdField_t_of_type_AndroidViewView != null)
      {
        this.jdField_t_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20, 10000L);
        continue;
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        if ((this.jdField_t_of_type_AndroidViewView != null) && (this.jdField_t_of_type_AndroidViewView.getVisibility() == 0))
        {
          this.jdField_t_of_type_AndroidViewView.setVisibility(8);
          continue;
          a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "ChatActivityConstants.MSG_PUBLICACCOUNT_ACCOUNTDETAIL");
          }
          Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
          if (localObject != null)
          {
            localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              this.jdField_d_of_type_AndroidWidgetTextView.setText(((AccountDetail)localObject).name);
              if (this.P)
              {
                c((AccountDetail)localObject);
                this.P = false;
              }
              if (this.jdField_g_of_type_AndroidAppDialog == null) {}
              be();
            }
          }
          if (this.O)
          {
            this.O = false;
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
            aY();
            continue;
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
          }
        }
      }
    }
  }
  
  public int i()
  {
    int i1 = 0;
    View localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if ((this.jdField_w_of_type_AndroidViewView != null) && (localView != this.jdField_w_of_type_AndroidViewView))
    {
      this.jdField_w_of_type_Int = 0;
      this.jdField_w_of_type_AndroidViewView = localView;
      return 0;
    }
    if (localView != null) {
      i1 = -localView.getTop();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "ScrollY: " + String.valueOf(i1) + "  OldScrollY: " + String.valueOf(this.jdField_w_of_type_Int));
    }
    this.jdField_w_of_type_AndroidViewView = localView;
    return i1;
  }
  
  /* Error */
  public void i(ChatMessage paramChatMessage)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_0
    //   4: getfield 1349	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1	Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;
    //   7: aload_1
    //   8: invokevirtual 2616	com/tencent/mobileqq/activity/aio/ChatAdapter1:a	(Lcom/tencent/mobileqq/data/ChatMessage;)I
    //   11: istore_2
    //   12: invokestatic 884	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +30 -> 45
    //   18: ldc_w 2809
    //   21: iconst_2
    //   22: new 755	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 2811
    //   32: invokevirtual 760	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_2
    //   36: invokevirtual 848	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 763	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 904	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: iload_2
    //   46: ifge +4 -> 50
    //   49: return
    //   50: aload_0
    //   51: getfield 1643	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   54: invokevirtual 2812	com/tencent/mobileqq/bubble/ChatXListView:getFirstVisiblePosition	()I
    //   57: istore_3
    //   58: iload_2
    //   59: iload_3
    //   60: isub
    //   61: istore 4
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 1643	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   68: iload 4
    //   70: invokevirtual 2796	com/tencent/mobileqq/bubble/ChatXListView:getChildAt	(I)Landroid/view/View;
    //   73: putfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   76: aload_0
    //   77: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   80: ifnonnull +66 -> 146
    //   83: invokestatic 884	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +51 -> 137
    //   89: ldc_w 2809
    //   92: iconst_2
    //   93: new 755	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 2816
    //   103: invokevirtual 760	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload 4
    //   108: invokevirtual 848	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc_w 2818
    //   114: invokevirtual 760	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload_3
    //   118: invokevirtual 848	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc_w 2820
    //   124: invokevirtual 760	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload_2
    //   128: invokevirtual 848	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: invokevirtual 763	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 904	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_0
    //   138: getfield 1349	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1	Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;
    //   141: aload_1
    //   142: invokevirtual 2822	com/tencent/mobileqq/activity/aio/ChatAdapter1:a	(Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   145: return
    //   146: aload_0
    //   147: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   150: invokevirtual 2825	android/view/View:isDrawingCacheEnabled	()Z
    //   153: istore 5
    //   155: aload_0
    //   156: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   159: invokevirtual 2828	android/view/View:willNotCacheDrawing	()Z
    //   162: istore 6
    //   164: aload_0
    //   165: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   168: iconst_1
    //   169: invokevirtual 2831	android/view/View:setDrawingCacheEnabled	(Z)V
    //   172: aload_0
    //   173: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   176: iconst_0
    //   177: invokevirtual 2834	android/view/View:setWillNotCacheDrawing	(Z)V
    //   180: aload_0
    //   181: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   184: invokevirtual 2838	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   187: astore 7
    //   189: aload 9
    //   191: astore 8
    //   193: aload 7
    //   195: ifnull +10 -> 205
    //   198: aload 7
    //   200: invokestatic 2844	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   203: astore 8
    //   205: invokestatic 884	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +31 -> 239
    //   211: ldc_w 2809
    //   214: iconst_2
    //   215: new 755	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 2846
    //   225: invokevirtual 760	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 8
    //   230: invokevirtual 2517	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 763	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 904	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aload 8
    //   241: ifnull +273 -> 514
    //   244: aload_0
    //   245: getfield 2848	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   248: ifnull -199 -> 49
    //   251: new 449	android/widget/ImageView
    //   254: dup
    //   255: aload_0
    //   256: getfield 1069	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   259: invokespecial 450	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   262: astore 9
    //   264: aload 9
    //   266: aload 8
    //   268: invokevirtual 2852	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   271: new 2854	android/widget/FrameLayout
    //   274: dup
    //   275: aload_0
    //   276: getfield 1069	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   279: invokespecial 2855	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   282: astore 10
    //   284: new 2857	android/widget/FrameLayout$LayoutParams
    //   287: dup
    //   288: aload_0
    //   289: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   292: invokevirtual 2860	android/view/View:getWidth	()I
    //   295: aload_0
    //   296: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   299: invokevirtual 1632	android/view/View:getHeight	()I
    //   302: invokespecial 2861	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   305: astore 7
    //   307: aload 7
    //   309: bipush 51
    //   311: putfield 2862	android/widget/FrameLayout$LayoutParams:gravity	I
    //   314: aload 7
    //   316: aload_0
    //   317: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   320: invokevirtual 2865	android/view/View:getLeft	()I
    //   323: putfield 2868	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   326: aload 7
    //   328: aload_0
    //   329: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   332: invokevirtual 2801	android/view/View:getTop	()I
    //   335: putfield 2869	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   338: aload 7
    //   340: iconst_0
    //   341: putfield 2872	android/widget/FrameLayout$LayoutParams:rightMargin	I
    //   344: aload 7
    //   346: iconst_0
    //   347: putfield 2873	android/widget/FrameLayout$LayoutParams:bottomMargin	I
    //   350: aload_0
    //   351: getfield 2848	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   354: aload 10
    //   356: aload 7
    //   358: invokevirtual 2874	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   361: aload 10
    //   363: aload 9
    //   365: new 2857	android/widget/FrameLayout$LayoutParams
    //   368: dup
    //   369: iconst_m1
    //   370: iconst_m1
    //   371: invokespecial 2861	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   374: invokevirtual 2875	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   377: aload_0
    //   378: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   381: iconst_4
    //   382: invokevirtual 2164	android/view/View:setVisibility	(I)V
    //   385: new 2877	android/view/animation/LinearInterpolator
    //   388: dup
    //   389: invokespecial 2878	android/view/animation/LinearInterpolator:<init>	()V
    //   392: astore 11
    //   394: new 2880	android/view/animation/AnimationSet
    //   397: dup
    //   398: iconst_1
    //   399: invokespecial 2881	android/view/animation/AnimationSet:<init>	(Z)V
    //   402: astore 12
    //   404: new 2883	android/view/animation/AlphaAnimation
    //   407: dup
    //   408: fconst_1
    //   409: fconst_0
    //   410: invokespecial 2886	android/view/animation/AlphaAnimation:<init>	(FF)V
    //   413: astore 7
    //   415: aload 7
    //   417: ldc2_w 2887
    //   420: invokevirtual 2889	android/view/animation/AlphaAnimation:setDuration	(J)V
    //   423: aload 7
    //   425: aload 11
    //   427: invokevirtual 2893	android/view/animation/AlphaAnimation:setInterpolator	(Landroid/view/animation/Interpolator;)V
    //   430: aload 12
    //   432: aload 7
    //   434: invokevirtual 2896	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   437: aload_1
    //   438: invokevirtual 2899	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   441: ifeq +133 -> 574
    //   444: new 1650	android/view/animation/TranslateAnimation
    //   447: dup
    //   448: fconst_0
    //   449: aload_0
    //   450: getfield 2901	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   453: invokevirtual 2904	android/view/View:getRight	()I
    //   456: i2f
    //   457: fconst_0
    //   458: fconst_0
    //   459: invokespecial 1653	android/view/animation/TranslateAnimation:<init>	(FFFF)V
    //   462: astore 7
    //   464: aload 7
    //   466: ldc2_w 2887
    //   469: invokevirtual 1660	android/view/animation/TranslateAnimation:setDuration	(J)V
    //   472: aload 7
    //   474: aload 11
    //   476: invokevirtual 2905	android/view/animation/TranslateAnimation:setInterpolator	(Landroid/view/animation/Interpolator;)V
    //   479: aload 12
    //   481: aload 7
    //   483: invokevirtual 2896	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   486: aload 9
    //   488: aload 12
    //   490: invokevirtual 2906	android/widget/ImageView:startAnimation	(Landroid/view/animation/Animation;)V
    //   493: aload_0
    //   494: getfield 265	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   497: new 2908	vyk
    //   500: dup
    //   501: aload_0
    //   502: aload 10
    //   504: invokespecial 2911	vyk:<init>	(Lcom/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie;Landroid/widget/FrameLayout;)V
    //   507: ldc2_w 2887
    //   510: invokevirtual 278	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   513: pop
    //   514: aload_0
    //   515: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   518: iload 5
    //   520: invokevirtual 2831	android/view/View:setDrawingCacheEnabled	(Z)V
    //   523: aload_0
    //   524: getfield 2814	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_p_of_type_AndroidViewView	Landroid/view/View;
    //   527: iload 6
    //   529: invokevirtual 2834	android/view/View:setWillNotCacheDrawing	(Z)V
    //   532: aload 8
    //   534: ifnull +64 -> 598
    //   537: aload_0
    //   538: getfield 265	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   541: new 2913	vyl
    //   544: dup
    //   545: aload_0
    //   546: aload_1
    //   547: invokespecial 2916	vyl:<init>	(Lcom/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   550: ldc2_w 2917
    //   553: invokevirtual 278	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   556: pop
    //   557: return
    //   558: astore 7
    //   560: aconst_null
    //   561: astore 7
    //   563: goto -374 -> 189
    //   566: astore 7
    //   568: aconst_null
    //   569: astore 7
    //   571: goto -382 -> 189
    //   574: new 1650	android/view/animation/TranslateAnimation
    //   577: dup
    //   578: fconst_0
    //   579: aload_0
    //   580: getfield 2901	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   583: invokevirtual 2904	android/view/View:getRight	()I
    //   586: ineg
    //   587: i2f
    //   588: fconst_0
    //   589: fconst_0
    //   590: invokespecial 1653	android/view/animation/TranslateAnimation:<init>	(FFFF)V
    //   593: astore 7
    //   595: goto -131 -> 464
    //   598: aload_0
    //   599: getfield 1349	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1	Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;
    //   602: aload_1
    //   603: invokevirtual 2822	com/tencent/mobileqq/activity/aio/ChatAdapter1:a	(Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   606: return
    //   607: astore 7
    //   609: aload 9
    //   611: astore 8
    //   613: goto -408 -> 205
    //   616: astore 7
    //   618: aload 9
    //   620: astore 8
    //   622: goto -417 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	625	0	this	PublicAccountChatPie
    //   0	625	1	paramChatMessage	ChatMessage
    //   11	117	2	i1	int
    //   57	61	3	i2	int
    //   61	46	4	i3	int
    //   153	366	5	bool1	boolean
    //   162	366	6	bool2	boolean
    //   187	295	7	localObject1	Object
    //   558	1	7	localException1	Exception
    //   561	1	7	localObject2	Object
    //   566	1	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   569	25	7	localTranslateAnimation	TranslateAnimation
    //   607	1	7	localException2	Exception
    //   616	1	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   191	430	8	localObject3	Object
    //   1	618	9	localImageView	ImageView
    //   282	221	10	localFrameLayout	android.widget.FrameLayout
    //   392	83	11	localLinearInterpolator	android.view.animation.LinearInterpolator
    //   402	87	12	localAnimationSet	android.view.animation.AnimationSet
    // Exception table:
    //   from	to	target	type
    //   180	189	558	java/lang/Exception
    //   180	189	566	java/lang/OutOfMemoryError
    //   198	205	607	java/lang/Exception
    //   198	205	616	java/lang/OutOfMemoryError
  }
  
  public void j()
  {
    if (!this.U) {
      super.j();
    }
  }
  
  @TargetApi(11)
  protected void k(int paramInt)
  {
    super.k(paramInt);
    ImageSpan localImageSpan;
    SpannableString localSpannableString;
    if (paramInt != this.jdField_e_of_type_Int)
    {
      if (paramInt != 1) {
        break label84;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837627);
        localSpannableString = new SpannableString("文字输入");
        localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    }
    label323:
    for (;;)
    {
      bh();
      return;
      label84:
      if (paramInt == 2)
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837958);
          localSpannableString = new SpannableString("语音输入");
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        if (VersionUtils.e())
        {
          if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
            this.jdField_o_of_type_AndroidWidgetImageView.setAlpha(0.6F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(0.6F);
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
        }
      }
      else
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837958);
          localSpannableString = new SpannableString("语音输入");
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131433631);
        }
        for (;;)
        {
          if (!VersionUtils.e()) {
            break label323;
          }
          if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
            this.jdField_o_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
          break;
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        }
      }
    }
  }
  
  public void o(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      }
      if (this.jdField_j_of_type_AndroidViewView != null) {
        this.jdField_j_of_type_AndroidViewView.setVisibility(4);
      }
      if (this.jdField_k_of_type_AndroidViewView != null) {
        this.jdField_k_of_type_AndroidViewView.setVisibility(4);
      }
      ap();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131361893) {
      o(true);
    }
    if (2131363474 == paramView.getId())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EFD", "0X8004EFD", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8004F08", "0X8004F08", 0, 0, "", "", "", "");
      PAStartupTracker.a(null, "pubAcc_profile_display", "");
    }
    if (paramView.getId() == 2131363499)
    {
      long l1 = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_p_of_type_AndroidWidgetImageView != null)) {
        QLog.d("Q.aio.BaseChatPie", 2, " onClick fun_btn start mInputStat = " + this.jdField_e_of_type_Int + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.jdField_p_of_type_AndroidWidgetImageView.getVisibility() + " currentPanel:" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() + " currenttime:" + System.currentTimeMillis());
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) && (this.jdField_p_of_type_AndroidWidgetImageView != null) && (this.jdField_p_of_type_AndroidWidgetImageView.getVisibility() != 0))
      {
        ak();
        if (PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) && (((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "city_search_click", 0, 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, " onClick fun_btn end mInputStat = " + this.jdField_e_of_type_Int + "text.length" + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "cast time :" + (l2 - l1));
        }
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800584F", "0X800584F", 0, 0, "", "", "", "", false);
      }
    }
    if ((paramView.getId() == 2131364075) && (this.jdField_e_of_type_Int != 1))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3) {
        break label856;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
        this.jdField_o_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437051));
      }
    }
    if (paramView.getId() == 2131365600)
    {
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8)
      {
        if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
          this.jdField_o_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437051));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("fastimage", 2, "BaseCHatPie onClick keybordicon removeFastImage");
          }
          a(true);
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      }
    }
    else
    {
      label659:
      if (paramView.getId() == 2131365601)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) {
          break label989;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        if (this.jdField_p_of_type_AndroidWidgetImageView != null)
        {
          this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(this.jdField_q_of_type_Int);
          this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433407));
        }
      }
      label726:
      if (paramView.getId() == 2131361888) {
        ac();
      }
      if ((this.U) && (paramView.getId() == 2131363499)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C9C", "0X8005C9C", 0, 1, 0, "", "", "", "");
      }
      if ((!(paramView.getTag() instanceof String)) || (!PubAccountTipsManager.jdField_a_of_type_JavaLangString.equals((String)paramView.getTag())) || (this.jdField_a_of_type_AndroidContentContext == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label1162;
      }
      if (System.currentTimeMillis() - this.jdField_k_of_type_Long >= 1000L) {
        break label1038;
      }
    }
    label856:
    label989:
    Object localObject1;
    label1038:
    Object localObject2;
    label1162:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      if ((this.jdField_p_of_type_AndroidWidgetImageView != null) && (this.jdField_p_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        p(false);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      Y();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
      if ((this.jdField_p_of_type_AndroidWidgetImageView != null) && (this.jdField_p_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        p(false);
      }
      if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
        this.jdField_o_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437053));
      }
      k(0);
      break label659;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      if (this.jdField_p_of_type_AndroidWidgetImageView == null) {
        break label726;
      }
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(this.jdField_r_of_type_Int);
      this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433408));
      break label726;
      this.jdField_k_of_type_Long = System.currentTimeMillis();
      localObject1 = new StringBuilder("http://gouwu.qq.com/m/html/shop_map.html?_wv=1027&shop_uin=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", ((StringBuilder)localObject1).toString());
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconClk", "Clk_shopnearbyicon", 0, 0, "", "", "", "");
      if (paramView.getId() != 2131364003) {
        break label1333;
      }
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (!ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label1333;
      }
      localObject2 = (String)EcShopAssistantManager.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtra("uin", (String)localObject2);
    localIntent = AIOUtils.a(localIntent, null);
    if (((FriendsManager)localObject1).b((String)localObject2)) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Shop_customservice", "Clk_shopcustomservice", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      label1333:
      super.onClick(paramView);
      return;
      localIntent.putExtra("uintype", 1005);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + "-客服");
      localIntent.putExtra("key_sub_title_from", "来自\"QQ咨询\"");
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.aa = true;
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  protected void p()
  {
    super.p();
    be();
  }
  
  protected void p(boolean paramBoolean)
  {
    int i2 = 8;
    if (this.jdField_p_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_p_of_type_AndroidWidgetImageView.clearAnimation();
    Object localObject = this.jdField_p_of_type_AndroidWidgetImageView;
    if (paramBoolean)
    {
      i1 = 0;
      label30:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      i1 = i2;
      if (!paramBoolean) {
        i1 = 0;
      }
      ((XEditTextEx)localObject).setVisibility(i1);
      if (this.jdField_f_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
        if (!paramBoolean) {
          break label159;
        }
      }
    }
    label159:
    for (int i1 = 4;; i1 = 0)
    {
      ((PatchedButton)localObject).setVisibility(i1);
      if (!paramBoolean) {
        break;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837627);
        SpannableString localSpannableString = new SpannableString("文字输入");
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
      return;
      i1 = 8;
      break label30;
    }
  }
  
  public void s()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.ai) {
      localIntent.putExtra("qidian_chat", true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      localIntent.putExtra("public_account_msg_id", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
    }
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    PublicAccountUtil.a(localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 1, PublicAccountUtil.jdField_a_of_type_Boolean);
  }
  
  protected void u()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845900, 2130845901);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131430118));
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageRecord))
    {
      localObject = ((MessageRecord)paramObject).getExtInfoFromExtStr("welcome_msg");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("true"))) {
        ThreadManager.post(new vyg(this), 8, null, false);
      }
      this.ad = true;
    }
    if ((ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((paramObject instanceof MessageRecord))) {
      ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.update(paramObservable, paramObject);
    int i1;
    if ((paramObservable instanceof TroopEntranceBar)) {
      if ((paramObject instanceof Integer))
      {
        i1 = ((Integer)paramObject).intValue();
        if (i1 != 0) {
          break label153;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b();
      }
    }
    label152:
    label153:
    do
    {
      do
      {
        do
        {
          do
          {
            break label152;
            break label152;
            for (;;)
            {
              bq();
              return;
              if (i1 == 1) {
                this.at = true;
              }
            }
            if (!(paramObservable instanceof QQMessageFacade)) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar == null);
          paramObject = (TroopManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(51);
          paramObservable = ((QQMessageFacade)paramObservable).a();
        } while (paramObservable == null);
        paramObservable = paramObject.b(paramObservable.frienduin);
      } while ((paramObservable == null) || (paramObservable.associatePubAccount != Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue()));
      paramObject = Message.obtain();
      paramObject.what = 9;
      localObject = new Bundle();
      ((Bundle)localObject).putString("troopUin", paramObservable.troopuin);
      paramObject.setData((Bundle)localObject);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
      return;
    } while (!this.U);
    ThreadManager.post(new vyh(this), 5, null, false);
  }
  
  public void v(int paramInt)
  {
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      if (!this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
  
  protected boolean v()
  {
    if ((!this.ae) && (this.U))
    {
      this.ae = true;
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1);
    }
    while ((this.af) || (!this.U)) {
      return true;
    }
    this.af = true;
    return false;
  }
  
  public void w(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  public void x(int paramInt)
  {
    try
    {
      this.jdField_k_of_type_AndroidWidgetTextView.setText(paramInt);
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_r_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean x()
  {
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if (localObject != null) {}
    for (localObject = ((PublicAccountDataManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject == null) && (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null))
      {
        PublicAccountUtil.a();
        PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return true;
      }
      return false;
    }
  }
  
  public void y(int paramInt)
  {
    try
    {
      this.jdField_r_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        return;
        this.jdField_k_of_type_AndroidWidgetTextView.setText(2131434353);
        continue;
        this.jdField_k_of_type_AndroidWidgetTextView.setText(2131434349);
        continue;
        this.jdField_k_of_type_AndroidWidgetTextView.setText(2131430059);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean y()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1008);
      if (localObject != null) {
        if (((QQMessageFacade.Message)localObject).msgtype == -2011)
        {
          localMessageForStructing = new MessageForStructing();
          MessageForStructing.copyMessageRecordBaseField(localMessageForStructing, (MessageRecord)localObject);
          localMessageForStructing.parse();
          if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mPromotionType == 1) || (localMessageForStructing.structingMsg.mPromotionType == 2))) {
            a(localMessageForStructing);
          }
        }
        else
        {
          while ((((QQMessageFacade.Message)localObject).msgtype == -2009) && (((QQMessageFacade.Message)localObject).isSend()))
          {
            MessageForStructing localMessageForStructing;
            return true;
          }
          if ((((QQMessageFacade.Message)localObject).msgtype == -5008) && (!((QQMessageFacade.Message)localObject).isSend()))
          {
            this.jdField_m_of_type_Int = 1;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  protected void z()
  {
    ReadinjoySPEventReport.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_m_of_type_Long, this.X, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a());
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(null);
    }
    if (this.I)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "hasDestory = true return");
      }
      return;
    }
    PublicAccountUtil.a();
    if (this.jdField_a_of_type_Vzh != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Vzh);
      label88:
      this.jdField_a_of_type_Vzh = null;
      if (this.jdField_b_of_type_MqqAppNewIntent != null) {
        PublicAccountManager.a().a(this.jdField_b_of_type_MqqAppNewIntent);
      }
      if (this.jdField_c_of_type_MqqAppNewIntent != null) {
        this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
      }
      super.z();
      if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(a());
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_AndroidContentContext);
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ChatMessage)localIterator.next();
        if (MessageForStructing.class.isInstance(localObject))
        {
          localObject = ((MessageForStructing)localObject).structingMsg;
          if (StructMsgForGeneralShare.class.isInstance(localObject)) {
            ((StructMsgForGeneralShare)localObject).unInitPay();
          }
        }
      }
      if ((this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      if ((this.jdField_h_of_type_AndroidAppDialog != null) && (this.jdField_h_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_h_of_type_AndroidAppDialog.dismiss();
        this.jdField_h_of_type_AndroidAppDialog = null;
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      }
      if ((this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
      {
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.e();
      }
      aX();
      bu();
      if (this.jdField_m_of_type_Long != 0L)
      {
        this.jdField_m_of_type_Long = (System.currentTimeMillis() - this.jdField_m_of_type_Long);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064D5", "0X80064D5", 0, 0, "", "" + this.jdField_m_of_type_Long, "" + this.E, "");
        this.jdField_m_of_type_Long = 0L;
        this.z = 0;
      }
      if (this.ad) {
        ThreadManager.executeOnSubThread(new vzf(this));
      }
      bk();
      PublicAccountUtil.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      break label88;
    }
  }
  
  public void z(int paramInt)
  {
    if (this.jdField_h_of_type_AndroidAppDialog == null)
    {
      this.jdField_h_of_type_AndroidAppDialog = new Dialog(a(), 2131624516);
      this.jdField_h_of_type_AndroidAppDialog.setContentView(2130970070);
    }
    TextView localTextView1 = (TextView)this.jdField_h_of_type_AndroidAppDialog.findViewById(2131363378);
    TextView localTextView2 = (TextView)this.jdField_h_of_type_AndroidAppDialog.findViewById(2131364130);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_h_of_type_AndroidAppDialog.setOnCancelListener(new vyw(this));
      this.jdField_h_of_type_AndroidAppDialog.show();
      return;
      localTextView1.setText(2131427342);
      localTextView2.setText(2131427343);
      continue;
      localTextView1.setText(2131427339);
      localTextView2.setText(2131427341);
      continue;
      localTextView1.setText(2131427340);
      localTextView2.setText(2131427341);
    }
  }
  
  public boolean z()
  {
    return (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie
 * JD-Core Version:    0.7.0.1
 */