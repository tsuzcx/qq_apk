package com.tencent.mobileqq.activity.home;

import aafi;
import abwp;
import adct;
import adcw;
import adcx;
import aebt;
import aezm;
import ahrr;
import aioc;
import ajbm;
import ajbn;
import ajbo;
import ajbp;
import ajbr;
import ajbs;
import ajbt;
import ajbu;
import ajbv;
import ajbw;
import ajbx;
import ajby;
import ajbz;
import ajca;
import ajcb;
import ajcc;
import ajcd;
import ajce;
import ajcf;
import ajcg;
import ajch;
import ajci;
import ajcj;
import ajck;
import ajcl;
import ajcm;
import ajcn;
import ajco;
import ajcp;
import ajcq;
import ajcr;
import ajcu;
import ajcw;
import ajcx;
import ajcy;
import ajcz;
import ajda;
import ajdb;
import ajdc;
import ajdd;
import ajde;
import ajdf;
import ajdg;
import ajdh;
import ajdi;
import ajdl;
import ajdm;
import ajev;
import akho;
import akju;
import akjw;
import akkd;
import akkk;
import akkr;
import akla;
import aklg;
import aklx;
import akmb;
import akmc;
import akmp;
import akmr;
import akms;
import akou;
import alem;
import alvx;
import amoo;
import amop;
import ampt;
import ampv;
import amqk;
import amrc;
import amrz;
import amsp;
import amsu;
import amsw;
import amtj;
import amtm;
import amua;
import amvo;
import amwl;
import amxz;
import amyp;
import amzx;
import anaa;
import anaz;
import anbn;
import anbq;
import andd;
import andl;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anhl;
import anjl;
import anjy;
import anuz;
import anxo;
import anxs;
import anxz;
import aowk;
import aozm;
import apyt;
import arht;
import armn;
import asbj;
import ashb;
import asqh;
import aufo;
import aukv;
import aukx;
import aukz;
import auna;
import avji;
import avnc;
import avnu;
import avnw;
import awhn;
import axkt;
import axvm;
import ayhx;
import azid;
import azie;
import azjc;
import azvi;
import azvn;
import bbyp;
import bcec;
import bcef;
import bcek;
import bchh;
import bcof;
import bcoo;
import bcoq;
import bcqk;
import bcvs;
import bdai;
import bfdg;
import bfdz;
import bfee;
import bfnp;
import bfrr;
import bfse;
import bfta;
import bftf;
import bfum;
import bfur;
import bfwu;
import bfxn;
import bfyv;
import bfyz;
import bfzg;
import bgrd;
import bgre;
import bhht;
import bjmp;
import bjmv;
import bjnm;
import bjnw;
import bjsd;
import bjts;
import bjun;
import bkmt;
import bkwm;
import bkyu;
import bkzf;
import bkzh;
import blbw;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTencentDocsAssistantData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.mini.entry.MiniAppDesktop;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTipsDialog;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qqcircle.chat.QCircleChatUtil;
import cooperation.qqcircle.chat.QCircleObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import lmt;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import mum;
import mun;
import nsf;
import nsg;
import nxq;
import nxz;
import nyj;
import ocw;
import odq;
import ofx;
import org.json.JSONException;
import org.json.JSONObject;
import pay;
import ple;
import plq;
import uaw;
import uda;
import uex;
import vlc;
import vlj;
import vxi;
import vxw;
import vxx;
import vzt;
import xwa;

public class Conversation
  extends amrz
  implements akkd, akkr, amsp, Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, bfnp, bjsd, bjts, AppConstants, AbsListView.OnScrollListener, Observer
{
  public static long b;
  private static long jdField_i_of_type_Long;
  public static boolean q = true;
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I;
  private boolean J;
  int jdField_a_of_type_Int = 0;
  public long a;
  adct jdField_a_of_type_Adct = null;
  public adcw a;
  public adcx a;
  aebt jdField_a_of_type_Aebt = new ajcm(this);
  aioc jdField_a_of_type_Aioc;
  private ajdf jdField_a_of_type_Ajdf;
  ajdg jdField_a_of_type_Ajdg = new ajdg(this);
  private ajdl jdField_a_of_type_Ajdl;
  protected ajdm a;
  public akho a;
  private akjw jdField_a_of_type_Akjw;
  public akkk a;
  public aklx a;
  private akmc jdField_a_of_type_Akmc;
  akmr jdField_a_of_type_Akmr;
  public akou a;
  protected amop a;
  private final ampv jdField_a_of_type_Ampv = new ajbz(this);
  private final amqk jdField_a_of_type_Amqk = new ajcg(this);
  amrc jdField_a_of_type_Amrc = new ajce(this);
  private final amsu jdField_a_of_type_Amsu = new ajbw(this);
  private amua jdField_a_of_type_Amua = new ajcq(this);
  private final amwl jdField_a_of_type_Amwl = new ajcb(this);
  private amzx jdField_a_of_type_Amzx = new ajdi(this);
  private anaa jdField_a_of_type_Anaa = new ajcl(this);
  private anaz jdField_a_of_type_Anaz = new ajcr(this);
  anbn jdField_a_of_type_Anbn = new ajcd(this);
  private final anbq jdField_a_of_type_Anbq = new ajch(this);
  private final andd jdField_a_of_type_Andd = new ajbx(this);
  andl jdField_a_of_type_Andl = new ajca(this);
  public Dialog a;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ajcn(this);
  public GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  private anxo jdField_a_of_type_Anxo = new ajde(this);
  private arht jdField_a_of_type_Arht = new ajdb(this);
  private asbj jdField_a_of_type_Asbj;
  private aufo jdField_a_of_type_Aufo = new aufo("tool_adMessage", "com.tencent.mobileqq:tool");
  public avji a;
  private final axkt jdField_a_of_type_Axkt = new ajcj(this);
  private axvm jdField_a_of_type_Axvm = new ajcx(this);
  public ayhx a;
  private bcoq jdField_a_of_type_Bcoq = new ajdc(this);
  bgre jdField_a_of_type_Bgre = null;
  private bhht jdField_a_of_type_Bhht;
  public bjnw a;
  private bkyu jdField_a_of_type_Bkyu;
  private bkzf jdField_a_of_type_Bkzf;
  public QQSettingMe a;
  private Conversation.DateFormatChangeRunnable jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DateFormatChangeRunnable = new Conversation.DateFormatChangeRunnable(this, null);
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ajcc(this);
  public FrameHelperActivity a;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private MiniAppPullInterface jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
  public RedTouch a;
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog;
  public PullRefreshHeader a;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private QCircleObserver jdField_a_of_type_CooperationQqcircleChatQCircleObserver = new ajdh(this);
  public Runnable a;
  public String a;
  protected StringBuilder a;
  public ArrayList<aozm> a;
  public List<RecentBaseData> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final lmt jdField_a_of_type_Lmt = new ajci(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new ajcw(this);
  public MqqHandler a;
  private final vlc jdField_a_of_type_Vlc = new ajck(this);
  public vzt a;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  Dialog jdField_b_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new ajco(this);
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private aufo jdField_b_of_type_Aufo = new aufo("tool_shop", "com.tencent.mobileqq:tool");
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  protected Runnable b;
  private String jdField_b_of_type_JavaLangString;
  final List<String> jdField_b_of_type_JavaUtilList = new ArrayList(40);
  public MqqHandler b;
  public boolean b;
  int jdField_c_of_type_Int;
  public long c;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new ajcp(this);
  View jdField_c_of_type_AndroidViewView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private aufo jdField_c_of_type_Aufo = new aufo("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private Runnable jdField_c_of_type_JavaLangRunnable;
  MqqHandler jdField_c_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), this.jdField_a_of_type_Ajdg);
  public boolean c;
  public int d;
  long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private Runnable jdField_d_of_type_JavaLangRunnable = new Conversation.3(this);
  public boolean d;
  int jdField_e_of_type_Int = 3;
  public long e;
  private View jdField_e_of_type_AndroidViewView;
  private Runnable jdField_e_of_type_JavaLangRunnable = new Conversation.24(this);
  protected boolean e;
  public volatile int f;
  long f;
  public boolean f;
  public volatile int g;
  private long g;
  public boolean g;
  private int jdField_h_of_type_Int;
  private long jdField_h_of_type_Long;
  public boolean h;
  boolean jdField_i_of_type_Boolean = false;
  private long jdField_j_of_type_Long = -1L;
  boolean jdField_j_of_type_Boolean = false;
  boolean k = false;
  boolean l = false;
  boolean m = false;
  boolean n = false;
  boolean o = false;
  boolean p = false;
  public volatile boolean r;
  public boolean s;
  boolean t = false;
  boolean u = false;
  public boolean v;
  private boolean x;
  private boolean y;
  private boolean z = true;
  
  static
  {
    jdField_b_of_type_Long = -1L;
  }
  
  public Conversation()
  {
    this.jdField_a_of_type_Long = 2000L;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_a_of_type_Adcx = null;
    this.jdField_f_of_type_Int = 17;
    this.jdField_a_of_type_Ajdm = new ajdm(this, null);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new Conversation.29(this);
    this.jdField_a_of_type_Amop = new ajby(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(BaseApplicationImpl.getContext(), new ajcz(this));
    this.jdField_b_of_type_JavaLangRunnable = new Conversation.62(this);
  }
  
  private void D()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Akkk.c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1025);
    this.jdField_j_of_type_Boolean = true;
    if (!this.k) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    BaseApplicationImpl.sApplication.onActivityFocusChanged(a(), true);
  }
  
  private void E()
  {
    anjy.a().a();
  }
  
  private void F()
  {
    bfse.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
  }
  
  private void G()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof ARMapHongBaoListView)))
    {
      if (this.jdField_a_of_type_Bkyu == null) {
        this.jdField_a_of_type_Bkyu = new bkyu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, (ARMapHongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      }
      this.jdField_a_of_type_Bkyu.a();
    }
  }
  
  private void H()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 50L);
  }
  
  private void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "scrollToTopIfNeccessary: " + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() >= 0)
    {
      this.I = true;
      this.jdField_j_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.smoothScrollToPosition(0);
    }
  }
  
  private void J()
  {
    ThreadManager.excute(new Conversation.5(this), 16, null, true);
  }
  
  private void K()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Akkk != null)) {}
    }
    else
    {
      return;
    }
    int i3 = this.jdField_a_of_type_Akkk.getCount();
    int i1 = this.jdField_b_of_type_Int + 1;
    label96:
    int i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Object localObject = this.jdField_a_of_type_Akkk.getItem(i1);
        if (!(localObject instanceof RecentBaseData))
        {
          i1 += 1;
        }
        else
        {
          localObject = (RecentBaseData)localObject;
          if (((RecentBaseData)localObject).isUnreadMsgNumInTabNum())
          {
            i2 = ((RecentBaseData)localObject).getUnreadNum();
            label124:
            if (i2 <= 0) {
              break label276;
            }
            if (this.jdField_b_of_type_Int != i1) {
              this.jdField_b_of_type_Int = i1;
            }
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        if (q) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.smoothScrollToPosition(this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount());
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "scrollToNextUnreadItem|findUnreadItem:" + bool + ",mCurrentUnreadItem" + this.jdField_b_of_type_Int);
        return;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount(), 0);
        continue;
        if (q) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setIsNeedScrollPositionTop(q);
        }
        I();
        this.jdField_b_of_type_Int = -1;
      }
      break;
      i2 = 0;
      break label124;
      label276:
      break label96;
    }
  }
  
  private void L()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.jdField_f_of_type_Long);
    if ((this.jdField_a_of_type_Akkk != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (TimeManager.getInstance().setDateFormat(str)) {
        this.jdField_f_of_type_Long = l1;
      }
    }
  }
  
  private void M()
  {
    if (avnc.a().b()) {
      avnc.a().a(3);
    }
  }
  
  private void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMWrapper", 2, "Conversation showUpgradeDetailInfoIfNeccessary mInitTimUpgradeInfo : " + this.F);
    }
    if ((!this.w) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.a()))
    {
      if (this.w)
      {
        if ((!ampt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.F))
        {
          a(1134047, 0L, true);
          this.F = true;
        }
        a(1134057, 0L, true);
      }
      return;
    }
    if ((this.jdField_c_of_type_AndroidAppDialog != null) && (this.jdField_c_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
      this.jdField_c_of_type_AndroidAppDialog = null;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.show();
      ampt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i1 = ampt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ampt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1 + 1);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void O()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
  }
  
  private void P()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131365076));
    this.jdField_a_of_type_Ajdf = new ajdf(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_Ajdf, false);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isInCallList = false;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376679));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378806));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365139));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377757));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379430));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379438));
    Q();
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      bbyp.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370062);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376025));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDescendantInvalidatedFlags(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(a().getDrawable(2130839440));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setIsNeedScrollPositionTop(true);
        Object localObject3 = a();
        if ((localObject3 != null) && ((localObject3 instanceof SplashActivity)))
        {
          Object localObject2 = (SplashActivity)localObject3;
          Object localObject1 = ((SplashActivity)localObject2).jdField_b_of_type_AndroidViewView;
          ((SplashActivity)localObject2).jdField_b_of_type_AndroidViewView = null;
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = ((AppActivity)localObject3).getLayoutInflater().inflate(2131562734, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
            }
          }
          if (localObject2 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject2, 0);
            this.jdField_a_of_type_Aioc = new aioc(a(), 1, (View)localObject2);
            this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
          }
          this.jdField_a_of_type_Akho = new akho(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          localObject1 = a();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
          if (!akla.a().jdField_a_of_type_Boolean)
          {
            bool = true;
            this.jdField_a_of_type_Akkk = new akkk((Context)localObject1, (QQAppInterface)localObject2, (XListView)localObject3, this, 0, bool);
            this.jdField_a_of_type_Akkk.b(true);
            this.jdField_a_of_type_Akkk.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Akkk);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
            this.jdField_a_of_type_Akkk.a(this);
            this.jdField_c_of_type_AndroidViewView = new View(a());
            localObject1 = new AbsListView.LayoutParams(-1, 0);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView, null, false);
            if ((TextUtils.isEmpty(akla.a().jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(akla.a().jdField_a_of_type_JavaLangString))) {
              break label900;
            }
            localObject1 = new ArrayList(16);
            QLog.d("Q.recent", 1, "ignore PreLoadList");
            this.jdField_a_of_type_Akkk.a((List)localObject1);
            this.jdField_a_of_type_Akkk.a(0);
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.r();
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
            this.jdField_a_of_type_Ayhx = new ayhx(this, this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_a_of_type_Avji = new avji(this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131365147));
            IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
            b("initUI");
            localObject1 = azid.a;
            if ((localObject1 != null) && (bkzh.a(((azie)localObject1).l)) && (!TextUtils.isEmpty(bkzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())))) {
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1062);
            }
            return;
            a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
            a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850016);
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167009));
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167009));
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          boolean bool;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.recent", 2, "initUI setOverscrollHeader error" + localThrowable.getMessage());
            continue;
            bool = false;
            continue;
            label900:
            List localList = akla.a().jdField_b_of_type_JavaUtilList;
            continue;
            localList = null;
          }
        }
      }
    }
  }
  
  private void Q()
  {
    int i1 = AIOUtils.dp2px(10.0F, a());
    AIOUtils.expandViewTouchDelegate(this.jdField_a_of_type_AndroidWidgetTextView, i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new mun());
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ajbr(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(new ajbs(this));
  }
  
  private void R()
  {
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).getOnlineInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
  }
  
  private void S()
  {
    Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if ((localManager instanceof azvi))
    {
      int i1 = ((azvi)localManager).a("104000.104001", 100);
      if (i1 > 0) {
        a(8, AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230);
      }
      QLog.d("Q.recent", 2, "uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "getSubscribeAccountRedDotNum  redNumByPath:" + i1);
    }
  }
  
  private void T()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "initMiniAppEntryLayout.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface == null)
    {
      if (apyt.c()) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface = new MiniAppDesktop(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface = new QQMessagePageMiniAppEntryManager(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
  }
  
  private void U()
  {
    for (;;)
    {
      try
      {
        if (!this.k)
        {
          boolean bool = this.jdField_h_of_type_Boolean;
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.k = true;
        if (!this.l) {
          r();
        }
        w();
        if ((!this.m) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.b())) {
          c(2);
        }
        if (this.jdField_a_of_type_Adcx != null) {
          this.jdField_a_of_type_Adcx.a();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new ajbu(this));
        this.jdField_a_of_type_Akou = new akou(this, this.jdField_a_of_type_AndroidViewViewGroup);
        W();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
        V();
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.b())
        {
          a(this.jdField_a_of_type_MqqOsMqqHandler, a());
          a(1055, 0L, false);
          if (QLog.isColorLevel())
          {
            QLog.d("Q.recent", 2, new Object[] { "initUiLater() will send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.b()) });
            QLog.d("Q.recent", 2, "isInRealActionLoginB MSG_CHECK_QQSPORT_RED_PACKET");
          }
          a(1061, 0L, false);
          a(1059, 0L, false);
          N();
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(12);
          ax();
          X();
          continue;
        }
        if (!this.s) {
          break label316;
        }
      }
      finally {}
      a(1055, 0L, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "initUiLater() mMsgTabStoryNodeListNeedInit fallback logic, send MSG_INIT_MSGTAG_STORY");
      }
      this.s = false;
      continue;
      label316:
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "initUiLater() will not send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.b()) });
      }
    }
  }
  
  private void V()
  {
    if ((this.jdField_a_of_type_Akho != null) && (this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_Akho.k();
    }
    if (this.jdField_a_of_type_Akho != null) {
      this.jdField_a_of_type_Akho.a(false);
    }
    a(1010, 5000L, false);
    a(1064, 5000L, true, "qboss_banner_login");
    a(5000, "tianshu_req_splash_type_login", true);
    a(1023, 0L, false);
    a(1076, 1000L, false);
  }
  
  private void W()
  {
    long l1 = System.currentTimeMillis();
    if (apyt.a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559654, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
      }
      T();
      long l2 = System.currentTimeMillis();
      QLog.d("AutoMonitor", 1, "init Mini App, cost=" + (l2 - l1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initUI(a());
    }
  }
  
  private void X()
  {
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      this.jdField_b_of_type_JavaLangString = anxz.a().a();
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367624));
        GLSurfaceView localGLSurfaceView = new GLSurfaceView(a());
        localGLSurfaceView.setRenderer(new ajbv(this));
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(localGLSurfaceView);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_GPU", 2, "GL_RENDERER= " + this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void Y()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    aw();
    a(1010, 0L, false);
    a(1023, 0L, false);
    a(1027, 0L, false);
    a(1078, 3000L, true);
    N();
    azvn.a(this);
    if (!this.jdField_e_of_type_Boolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).getOnlineFriend(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2);
    }
    Z();
    ((bcof)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(361)).a(a());
  }
  
  private void Z()
  {
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == -1) {
      QQToast.a(a(), 2, a(2131719309), 0).b(a().getTitleBarHeight());
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((-1 == paramInt) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        TroopUtils.enterTroopAio(a(), paramIntent, true);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean, String paramString, anuz paramanuz)
  {
    int i2 = a(paramRecentBaseData.getRecentUserUin(), paramInt);
    paramRecentBaseData = paramanuz.getRecentList(false).iterator();
    int i1 = 0;
    if (paramRecentBaseData.hasNext())
    {
      if (((RecentUser)paramRecentBaseData.next()).showUpTime == 0L) {
        break label178;
      }
      i1 += 1;
    }
    label178:
    for (;;)
    {
      break;
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, paramString, String.valueOf(i1), String.valueOf(i2), "");
      if (paramInt == 7220)
      {
        if (paramBoolean) {
          odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
        }
      }
      else {
        return;
      }
      odq.a(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
      return;
    }
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1072);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 9003;
    localMessage.obj = paramString;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, paramInt);
  }
  
  private void a(int paramInt, List<RecentBaseData> paramList)
  {
    if ((-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a()) || ((this.G) && (this.H)))
    {
      this.jdField_a_of_type_Ajdf.a(paramInt, paramList);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      if (AppSetting.jdField_h_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.7(this));
      }
      return;
    }
    int i1;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doRefreshUI|[").append(paramInt).append(",");
      if (paramList == null)
      {
        i1 = 0;
        QLog.i("Q.recent", 2, i1 + "]，shouldShowConversationMayknow = " + this.p);
      }
    }
    else if (this.jdField_a_of_type_Akkk != null)
    {
      if (paramInt != 0) {
        break label273;
      }
      c(paramList);
    }
    for (;;)
    {
      if (AppSetting.jdField_h_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.8(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshMsgTabUnreadNum(false, this.jdField_d_of_type_Int);
      a(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      if (this.y)
      {
        this.y = false;
        aq();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
      ap();
      anxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, 0);
      nsf.a.c();
      return;
      i1 = paramList.size();
      break;
      label273:
      b(paramList);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onNetWorkStateChange isNetWorkConnect = " + paramBoolean + " what = " + paramInt);
    }
    if (paramInt != 10003) {}
    while (!paramBoolean) {
      return;
    }
    a(1064, 200L, true, "qboss_banner_net_change");
    a(1072, 400L, true);
    a(500, "tianshu_req_splash_type_net_change", true);
  }
  
  private void a(Message paramMessage)
  {
    for (;;)
    {
      UpgradeTIMWrapper localUpgradeTIMWrapper;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("UpgradeTIMWrapper", 2, "Conversation onReceiveShowTIMUpgradeTips");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_c_of_type_AndroidAppDialog == null))
        {
          boolean bool = paramMessage.obj instanceof UpgradeTIMWrapper;
          if (bool) {}
        }
        else
        {
          return;
        }
        localUpgradeTIMWrapper = (UpgradeTIMWrapper)paramMessage.obj;
        if ((localUpgradeTIMWrapper == null) || (TextUtils.isEmpty(localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(localUpgradeTIMWrapper.c))) {
          continue;
        }
        ajbm localajbm = new ajbm(this);
        ajbn localajbn = new ajbn(this, localUpgradeTIMWrapper);
        if (TextUtils.isEmpty(localUpgradeTIMWrapper.d))
        {
          paramMessage = amtj.a(2131701733);
          if (!TextUtils.isEmpty(localUpgradeTIMWrapper.e)) {
            break label323;
          }
          str = amtj.a(2131701743);
          this.jdField_c_of_type_AndroidAppDialog = bfur.a(a(), localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString, localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString, paramMessage, str, null, localajbn, localajbm);
          this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new ajbo(this));
          if ((!this.w) || (this.jdField_c_of_type_AndroidAppDialog.isShowing()) || ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.isShowing())) || (ampt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            continue;
          }
          this.jdField_c_of_type_AndroidAppDialog.show();
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
          ampt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          a(1134048, 0L, true);
          continue;
        }
        paramMessage = localUpgradeTIMWrapper.d;
      }
      finally {}
      continue;
      label323:
      String str = localUpgradeTIMWrapper.e;
    }
  }
  
  private void a(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {}
    label91:
    do
    {
      return;
      paramMessage = akla.a().jdField_a_of_type_JavaUtilList;
      int i2 = paramMessage.size();
      Object localObject = new ArrayList(i2);
      int i1 = 0;
      if (i1 < i2) {
        for (;;)
        {
          RecentBaseData localRecentBaseData;
          try
          {
            localRecentBaseData = (RecentBaseData)paramMessage.get(i1);
            if (localRecentBaseData != null) {
              break label91;
            }
            i1 += 1;
          }
          catch (Exception paramMessage) {}
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.e("Q.recent", 4, paramMessage.toString());
          return;
          String str = akla.a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          if ((this.jdField_b_of_type_JavaUtilList.contains(str)) || (this.jdField_b_of_type_JavaUtilList.contains(akla.a(localRecentBaseData.getRecentUserUin(), -2147483648))))
          {
            localRecentBaseData.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
            ((List)localObject).add(localRecentBaseData);
          }
        }
      }
      u();
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1019, 0, 0, localObject).sendToTarget();
      a(paramMessage);
      if (this.jdField_c_of_type_Int <= 8)
      {
        this.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_JavaUtilList.clear();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - paramLong, paramMessage.size(), (HashMap)localObject, "");
      bfzg.a("Conversation_Refresh_items", System.currentTimeMillis() - paramLong);
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + paramLong + "," + (System.currentTimeMillis() - paramLong) + "]");
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, int paramInt)
  {
    bjmv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, paramRecentBaseData);
    anxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData);
    if ((paramRecentUser != null) && (paramRecentUser.lFlag == 16L) && (paramInt == 0) && (this.jdField_a_of_type_Aufo != null))
    {
      this.jdField_a_of_type_Aufo.b();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "ad preload tool process hit");
      }
    }
    if ((paramRecentUser != null) && (String.valueOf(9970L).equals(paramRecentUser.uin)) && (this.jdField_b_of_type_Aufo != null)) {
      this.jdField_b_of_type_Aufo.b();
    }
    if ((paramRecentUser != null) && (paramRecentUser.getType() == 6004) && (this.jdField_c_of_type_Aufo != null)) {
      this.jdField_c_of_type_Aufo.b();
    }
    if (paramRecentUser != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
      paramRecentBaseData.setFeedInfoRead(paramRecentUser.uin);
      if (!FeedsManager.isShowStatus(paramRecentUser.uin)) {
        break label217;
      }
      aezm localaezm = (aezm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
      if (localaezm != null)
      {
        long l1 = localaezm.a(paramRecentUser.uin);
        FeedsManager.saveToken(paramRecentUser.uin, l1);
        paramRecentBaseData.reportClickExpose();
        localaezm.a(2, 2);
      }
    }
    label217:
    do
    {
      do
      {
        return;
        paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMsgForMsgTab(paramRecentUser.uin, paramRecentUser.getType());
      } while ((paramRecentBaseData == null) || (paramRecentBaseData.msgtype != -1034));
      paramRecentBaseData = (aezm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
    } while (paramRecentBaseData == null);
    paramRecentBaseData.a(2, 1);
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString1, boolean paramBoolean, String paramString2)
  {
    if (this.jdField_a_of_type_Akmr != null) {
      this.jdField_a_of_type_Akmr.a(paramRecentBaseData, paramBoolean);
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", paramString2, paramString1, "");
  }
  
  private void a(AbsListView paramAbsListView)
  {
    int i1;
    if ((paramAbsListView != null) && (this.jdField_a_of_type_Akkk != null))
    {
      i1 = paramAbsListView.getFirstVisiblePosition();
      if (i1 <= 0) {
        break label233;
      }
      i1 -= 1;
    }
    label226:
    label233:
    for (;;)
    {
      int i3 = paramAbsListView.getLastVisiblePosition();
      int i2 = i1;
      for (;;)
      {
        Object localObject1;
        if (i2 < i3 + 1)
        {
          localObject1 = this.jdField_a_of_type_Akkk.getItem(i2);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemPublicAccountADFolderData))) {
            break label226;
          }
          localObject1 = (RecentItemPublicAccountADFolderData)localObject1;
          if (!aukz.a(paramAbsListView.getChildAt(i2 - i1))) {
            break label226;
          }
          localObject1 = nxz.a().a(((RecentItemPublicAccountADFolderData)localObject1).mUser.uin);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Message localMessage = Message.obtain();
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("key_app", new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        ((HashMap)localObject2).put("key_adapter", new WeakReference(this.jdField_a_of_type_Akkk));
        ((HashMap)localObject2).put("key_listview", new WeakReference(paramAbsListView));
        localMessage.obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_ad_id", ((nxq)localObject1).c);
        localMessage.setData((Bundle)localObject2);
        localMessage.what = 1;
        aukv.a().a(localMessage);
        i2 += 1;
      }
    }
  }
  
  private void a(Object paramObject)
  {
    JSONObject localJSONObject;
    if ((paramObject instanceof JSONObject)) {
      localJSONObject = (JSONObject)paramObject;
    }
    int i1;
    try
    {
      i1 = localJSONObject.getInt("actionType");
      switch (i1)
      {
      }
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
        i1 = -1;
      }
      paramObject = null;
      try
      {
        String str = localJSONObject.getString("actionUin");
        paramObject = str;
        i1 = localJSONObject.getInt("actionUinType");
        paramObject = str;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          i1 = -1;
        }
        a(8, paramObject, i1);
      }
      if ((-1 == i1) || (paramObject == null))
      {
        a(200L);
        return;
      }
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Bkzf == null) {
      this.jdField_a_of_type_Bkzf = new bkzf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Bkzf.a(paramString);
  }
  
  private void a(String paramString1, @NonNull String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    b(new Conversation.19(this, paramString2, paramString1));
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    if (((paramObservable instanceof azvi)) && ((paramObject instanceof BusinessInfoCheckUpdate.AppInfo)))
    {
      paramObservable = azvn.a((BusinessInfoCheckUpdate.AppInfo)paramObject);
      if ((paramObservable != null) && (paramObservable.size() > 0))
      {
        paramObservable = (azvn)paramObservable.get(0);
        if ((paramObservable.jdField_a_of_type_Int >= 1) && (paramObservable.jdField_a_of_type_Int <= 4)) {
          azvn.b(this);
        }
      }
    }
  }
  
  public static void a(MqqHandler paramMqqHandler, Context paramContext)
  {
    paramMqqHandler.removeMessages(1134065);
    if (FriendsStatusUtil.a(paramContext))
    {
      bcef.b(null, "CliOper", "", "", "0X8009EB9", "0X8009EB9", 0, 1, "", "", "", "");
      Message localMessage = paramMqqHandler.obtainMessage(1134065);
      localMessage.arg1 = 2;
      paramMqqHandler.sendMessage(localMessage);
      long l1 = FriendsStatusUtil.a(paramContext);
      if (l1 > 0L) {
        paramMqqHandler.postDelayed(new Conversation.38(paramMqqHandler), l1 * 1000L);
      }
      return;
    }
    paramContext = paramMqqHandler.obtainMessage(1134065);
    paramContext.arg1 = 0;
    paramMqqHandler.sendMessage(paramContext);
  }
  
  private boolean a(int paramInt, boolean paramBoolean, String paramString)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 2)
    {
      bcef.b(localQQAppInterface, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i1, "0", "0", "", "");
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
        break;
      }
      QQToast.a(a(), 1, 2131695597, 0).b(a().getTitleBarHeight());
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "setChatAtTop top: " + paramBoolean + " uin: " + paramString + " userType: " + paramInt);
    }
    FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramBoolean);
    return false;
  }
  
  private boolean a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData instanceof RecentItemMayKnowFriendData))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, " onRecentBaseDataClick recommend_item_menu");
      }
      z();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "msgtab_list_clk", 1);
      return true;
    }
    if ((paramRecentBaseData instanceof RecentItemMayKnowFriendVerticalListData))
    {
      a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.getRecentUserUin());
      return true;
    }
    if ((paramRecentBaseData instanceof RecentItemRecommendTroopData))
    {
      ((amvo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.getRecentUserUin());
      return true;
    }
    return false;
  }
  
  private boolean a(RecentBaseData paramRecentBaseData, boolean paramBoolean, anuz paramanuz, String paramString)
  {
    int i1 = paramRecentBaseData.getRecentUserType();
    if ((paramString == null) || (paramString.length() == 0) || (paramanuz == null))
    {
      if (QLog.isColorLevel())
      {
        paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
        if (paramString != null) {
          break label85;
        }
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (paramanuz != null) {
          break label90;
        }
      }
      label85:
      label90:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("Q.recent", 2, paramBoolean);
        return true;
        paramBoolean = false;
        break;
      }
    }
    RecentUser localRecentUser = (RecentUser)paramanuz.findRecentUser(paramString, i1);
    if (localRecentUser == null) {
      localRecentUser = new RecentUser(paramString, i1);
    }
    label389:
    label429:
    for (;;)
    {
      int i3;
      if (paramBoolean)
      {
        localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
        paramanuz.saveRecentUser(localRecentUser);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        if ((i1 != 7210) && (i1 != 7120)) {
          break label389;
        }
        i3 = paramRecentBaseData.mUnreadNum;
        paramRecentBaseData = "0X80064C4";
        if (paramBoolean) {
          paramRecentBaseData = "0X80064C3";
        }
        if (i1 != 7120) {
          break label609;
        }
      }
      label218:
      label603:
      label606:
      label609:
      for (int i2 = 1;; i2 = 0)
      {
        paramanuz = paramanuz.getRecentList(false).iterator();
        i1 = 0;
        if (paramanuz.hasNext())
        {
          if (((RecentUser)paramanuz.next()).showUpTime == 0L) {
            break label606;
          }
          i1 += 1;
        }
        for (;;)
        {
          break label218;
          localRecentUser.showUpTime = 0L;
          break;
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + i2, paramRecentBaseData, paramRecentBaseData, 0, 0, "" + i3, "" + i1, "", "");
          do
          {
            if ((7220 == localRecentUser.getType()) && (AppConstants.KANDIAN_MERGE_UIN.equals(paramString))) {
              ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).c(paramBoolean);
            }
            return false;
          } while (i1 != 1008);
          i2 = paramRecentBaseData.mUnreadNum;
          paramRecentBaseData = "0X80064C8";
          if (paramBoolean) {
            paramRecentBaseData = "0X80064C7";
          }
          paramanuz = paramanuz.getRecentList(false).iterator();
          i1 = 0;
          if (paramanuz.hasNext())
          {
            if (((RecentUser)paramanuz.next()).showUpTime == 0L) {
              break label603;
            }
            i1 += 1;
          }
          for (;;)
          {
            break label429;
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", localRecentUser.uin, paramRecentBaseData, paramRecentBaseData, 0, 0, "" + i2, "" + i1, "", "");
            if (!"2290230341".equals(paramString)) {
              break;
            }
            if (paramBoolean) {}
            for (paramRecentBaseData = "0X80090E6";; paramRecentBaseData = "0X800915B")
            {
              if (paramBoolean) {
                bcec.a(4);
              }
              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramRecentBaseData, paramRecentBaseData, 0, 0, "", "", "", "");
              break;
            }
          }
        }
      }
    }
  }
  
  private void aA()
  {
    if (!this.w) {
      break label7;
    }
    label7:
    while (!this.jdField_a_of_type_Akho.b(24)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getChildCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() >= 0)) {}
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 == 0)
      {
        this.J = false;
        return;
      }
      if (this.J) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "checkPushBannerReport");
      }
      this.J = true;
      ThreadManager.post(new Conversation.55(this, this.jdField_a_of_type_Akho.a(24, 2131362234)), 5, null, false);
      return;
    }
  }
  
  private void aB()
  {
    try
    {
      if (this.jdField_a_of_type_Bhht == null)
      {
        this.jdField_a_of_type_Bhht = new bhht(a(), a().getTitleBarHeight());
        this.jdField_a_of_type_Bhht.c(2131694271);
        this.jdField_a_of_type_Bhht.c(false);
        this.jdField_a_of_type_Bhht.setOnDismissListener(new ajda(this));
      }
      this.jdField_a_of_type_Bhht.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void aC()
  {
    try
    {
      if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 800L);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void aa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "removeObservers" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      Object localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amsu);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Andd);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amop);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ampv);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amwl);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Andl);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amrc);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anbq);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amqk);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amua);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Vlc);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Axkt);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anaa);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anaz);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axvm);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Arht);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anbn);
        bcoo.b(this.jdField_a_of_type_Bcoq);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().deleteObserver(this.jdField_a_of_type_Lmt);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
        }
        if (this.jdField_a_of_type_Asbj != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Asbj);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aebt);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amzx);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anxo);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
        localObject1 = (azjc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject1 != null) {
          ((azjc)localObject1).deleteObserver(this);
        }
        localObject1 = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (localObject1 != null) {
          ((azvi)localObject1).deleteObserver(this);
        }
        if (this.jdField_a_of_type_Avji != null) {
          this.jdField_a_of_type_Avji.c();
        }
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(17);
      try
      {
        localObject1 = a();
        if (this.jdField_a_of_type_Ajdl != null)
        {
          BaseTransProcessor.removeHandler(this.jdField_a_of_type_Ajdl);
          this.jdField_a_of_type_Ajdl.a();
          this.jdField_a_of_type_Ajdl = null;
        }
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, localException.toString());
          }
        }
      }
      return;
    }
  }
  
  private void ab()
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void ac()
  {
    if (this.jdField_a_of_type_Avji != null) {
      this.jdField_a_of_type_Avji.a();
    }
  }
  
  private void ad()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onResume();
    }
  }
  
  private void ae()
  {
    if (this.jdField_a_of_type_Akou != null) {
      this.jdField_a_of_type_Akou.d();
    }
  }
  
  private void af()
  {
    if (this.jdField_a_of_type_Vzt != null) {
      this.jdField_a_of_type_Vzt.k();
    }
  }
  
  private void ag()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.upgradeData != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.upgradeData);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.upgradeData = null;
    }
  }
  
  private void ah()
  {
    if ((jdField_b_of_type_Long == -1L) && (SplashActivity.jdField_a_of_type_Boolean))
    {
      jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      SosoInterface.saveNormalEnterConversationTime(jdField_b_of_type_Long);
    }
  }
  
  private void ai()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new Conversation.25(this), 500L);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1070, 3000L);
    ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    pay.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    am();
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1053)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1053, 500L);
    }
    akmc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void aj()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (FrameHelperActivity.b())
      {
        FrameHelperActivity.c(true);
        FrameHelperActivity.t();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void ak()
  {
    Object localObject = this.jdField_a_of_type_Bgre;
    if (localObject != null)
    {
      bgrd localbgrd = ((bgre)localObject).a();
      if (localbgrd != null)
      {
        a((bgre)localObject, localbgrd);
        if (a((bgre)localObject, localbgrd))
        {
          localObject = a();
          if ((localObject instanceof SplashActivity)) {
            ((SplashActivity)localObject).c();
          }
        }
      }
    }
  }
  
  private void al()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aozm localaozm = (aozm)localIterator.next();
        if (localaozm != null) {
          if (this.v)
          {
            localaozm.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
            localaozm.jdField_c_of_type_Boolean = true;
            localaozm.c();
          }
          else
          {
            localaozm.d();
          }
        }
      }
      this.v = false;
    }
  }
  
  private void am()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null) {
      this.jdField_c_of_type_JavaLangRunnable = new Conversation.26(this);
    }
    ThreadManagerV2.excute(this.jdField_c_of_type_JavaLangRunnable, 32, null, true);
  }
  
  private void an()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (FrameHelperActivity.b()) {
        FrameHelperActivity.t();
      }
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Ayhx.jdField_d_of_type_Int != -1) && (this.jdField_a_of_type_Ayhx.jdField_d_of_type_Int != 1))
      {
        this.jdField_a_of_type_Ayhx.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
        this.jdField_a_of_type_Ayhx.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Ayhx.d();
    }
    for (;;)
    {
      if (this.t) {
        this.t = false;
      }
      return;
      this.jdField_a_of_type_Ayhx.e();
    }
  }
  
  private void ao()
  {
    int i2 = 2;
    akho localakho;
    if (this.jdField_a_of_type_Akho != null)
    {
      boolean bool = avnc.a().d();
      localakho = this.jdField_a_of_type_Akho;
      if (!bool) {
        break label134;
      }
      i1 = 2;
      localakho.a(12, i1);
      avnc.a().b(bool);
      this.jdField_a_of_type_Akho.c();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink().a() == 0) {
        break label139;
      }
      i1 = 1;
      label65:
      localakho = this.jdField_a_of_type_Akho;
      if (i1 == 0) {
        break label144;
      }
      i1 = 2;
      label77:
      localakho.a(43, i1);
      bool = asqh.a().a();
      localakho = this.jdField_a_of_type_Akho;
      if (!bool) {
        break label149;
      }
    }
    label134:
    label139:
    label144:
    label149:
    for (int i1 = i2;; i1 = 0)
    {
      localakho.a(44, i1);
      if (this.jdField_a_of_type_Akho != null) {
        this.jdField_a_of_type_Akho.h();
      }
      b("onResume");
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label65;
      i1 = 0;
      break label77;
    }
  }
  
  private void ap()
  {
    if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(true))) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidViewView == null);
      localObject = this.jdField_a_of_type_Akkk.getItem(0);
    } while (!(localObject instanceof RecentUserBaseData));
    Object localObject = (RecentUserBaseData)localObject;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    boolean bool;
    label101:
    int i1;
    if ((((RecentUserBaseData)localObject).mUser.getType() == 1) && (!awhn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)((RecentUserBaseData)localObject).mUser)))
    {
      bool = localTroopManager.b(((RecentUserBaseData)localObject).getRecentUserUin());
      if (this.B == bool) {
        break label220;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent", 4, "setLocalSearchBarByShowUpMask:mShowUPMask = " + this.B + ", dstMsg = " + bool);
      }
      if (!bool) {
        break label222;
      }
      i1 = 2130850253;
      label163:
      if (!bool) {
        break label229;
      }
    }
    label220:
    label222:
    label229:
    for (int i2 = 2130850264;; i2 = 2130850263)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(i1);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366179).setBackgroundResource(i2);
      this.B = bool;
      return;
      if (((RecentUserBaseData)localObject).mUser.showUpTime > 0L)
      {
        bool = true;
        break label101;
      }
      bool = false;
      break label101;
      break;
      i1 = 2130850252;
      break label163;
    }
  }
  
  private void aq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess start");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_j_of_type_Boolean)) {
      break label30;
    }
    label30:
    label170:
    for (;;)
    {
      return;
      if ((bcvs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (bcvs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Akkk != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          label73:
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition())
          {
            Object localObject = this.jdField_a_of_type_Akkk.getItem(i1);
            if ((!(localObject instanceof RecentItemTencentDocsAssistantData)) || (((RecentItemTencentDocsAssistantData)localObject).getUnreadNum() <= 0)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!ocw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            break label170;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess call");
          }
          if (this.jdField_c_of_type_Aufo == null) {
            break;
          }
          this.jdField_c_of_type_Aufo.a();
          return;
          i1 += 1;
          break label73;
        }
      }
    }
  }
  
  private void ar()
  {
    if (this.jdField_a_of_type_Akou != null) {
      this.jdField_a_of_type_Akou.b();
    }
  }
  
  private void as()
  {
    b(new Conversation.28(this));
  }
  
  private void at()
  {
    avnu.a().k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = uaw.a();
    if (localObject != null) {
      ((uaw)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    localObject = uda.a();
    if (localObject != null) {
      ((uda)localObject).i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bfdg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = (bfdz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
    if (localObject != null) {
      ((bfdz)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      localObject = (ofx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      if (localObject != null) {
        ((ofx)localObject).e();
      }
      localObject = (auna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
      if (localObject != null) {
        ((auna)localObject).a(true);
      }
      localObject = (amtm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255);
      if (localObject != null) {
        ((amtm)localObject).a();
      }
      anjl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
      localObject = (armn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(292);
      if (localObject != null) {
        ((armn)localObject).c();
      }
      localObject = (vlj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
      ((vlj)localObject).a(1, ((vlj)localObject).a(this.jdField_a_of_type_JavaUtilList));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
      }
    }
  }
  
  private void au()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "updateMayKnowOrTroopRecommend");
    }
    amvo localamvo = (amvo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if (localamvo.c())
    {
      localamvo.c();
      return;
    }
    this.p = localamvo.d();
    ArrayList localArrayList = localamvo.c();
    if ((this.p) && (localArrayList != null) && (localArrayList.size() > 0))
    {
      localamvo.d();
      return;
    }
    localamvo.e();
    this.p = false;
  }
  
  private void av()
  {
    this.jdField_a_of_type_Asbj = new ajcf(this);
  }
  
  private void aw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentDataListManager", 2, "preloadNextScreenUserFaceIcon:" + this.z);
    }
    int i1;
    int i2;
    int i3;
    if (this.z)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() + 1;
      i2 = 1;
      i3 = 0;
      if ((i2 != 0) && (i3 < 10) && (i1 >= 0)) {
        break label103;
      }
    }
    label103:
    while (i1 >= this.jdField_a_of_type_Akkk.getCount())
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
      i2 = 0;
      break;
    }
    Object localObject = this.jdField_a_of_type_Akkk.getItem(i1);
    if ((localObject != null) && ((localObject instanceof RecentBaseData)))
    {
      localObject = (RecentBaseData)localObject;
      if (!(localObject instanceof RecentItemImaxADData)) {}
    }
    for (;;)
    {
      i3 += 1;
      break;
      this.jdField_a_of_type_Akkk.a().a(((RecentBaseData)localObject).getRecentUserType(), ((RecentBaseData)localObject).getRecentUserUin(), false);
      i1 += i2;
    }
  }
  
  private void ax()
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfAkjy[0] = new ajcu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfAkjy[1] = new ajev();
  }
  
  private void ay()
  {
    if ((this.w) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      ThreadManager.post(new Conversation.54(this), 5, null, true);
    }
  }
  
  private void az()
  {
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_Aklx != null))
    {
      this.jdField_a_of_type_Aklx.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1048, 0, 0).sendToTarget();
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt + ", src: " + -1);
    }
  }
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ApolloSurfaceView localApolloSurfaceView = alvx.a();
    if (localApolloSurfaceView != null) {
      localApolloSurfaceView.runRenderTask(new Conversation.4(this, localApolloSurfaceView, paramInt1, paramInt2, paramIntent));
    }
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    AbsStructMsg localAbsStructMsg;
    if ((paramIntent != null) && (paramInt == -1))
    {
      localAbsStructMsg = bchh.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg != null) {}
    }
    else
    {
      return;
    }
    String str = paramIntent.getStringExtra("uin");
    paramInt = paramIntent.getIntExtra("uintype", -1);
    int i1 = paramIntent.getIntExtra("cmshow_game_id", -1);
    bfyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramInt, localAbsStructMsg, null);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(paramInt), 0, new String[] { Integer.toString(i1) });
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceiverShowUpgradeTips");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) || (!(paramMessage.obj instanceof UpgradeDetailWrapper))) {}
    do
    {
      return;
      paramMessage = (UpgradeDetailWrapper)paramMessage.obj;
      if (ampt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) >= 5)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((ampt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (ampt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog = new UpgradeTipsDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.setOnDismissListener(new ajbp(this));
  }
  
  private void b(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {}
    for (;;)
    {
      return;
      if (alem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        alem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      L();
      List localList1 = akla.a().jdField_a_of_type_JavaUtilList;
      List localList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().getRecentList(false);
      this.jdField_a_of_type_Akjw.a(localList2);
      localList1.clear();
      int i1;
      int i2;
      label81:
      RecentUser localRecentUser;
      String str;
      RecentBaseData localRecentBaseData;
      if (localList2 == null)
      {
        i1 = 0;
        i2 = 0;
        if (i2 >= i1) {
          break label279;
        }
        localRecentUser = (RecentUser)localList2.get(i2);
        str = akla.a(localRecentUser.uin, localRecentUser.getType());
        localRecentBaseData = akla.a().a(str);
        if (localRecentBaseData != null) {
          break label202;
        }
        localRecentBaseData = akju.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
        paramMessage = localRecentBaseData;
        if (localRecentBaseData != null)
        {
          akla.a().a(localRecentBaseData, str);
          paramMessage = localRecentBaseData;
        }
      }
      for (;;)
      {
        if (paramMessage != null) {
          localList1.add(paramMessage);
        }
        i2 += 1;
        break label81;
        i1 = localList2.size();
        break;
        label202:
        if (!this.jdField_b_of_type_JavaUtilList.contains(str))
        {
          paramMessage = localRecentBaseData;
          if (!this.jdField_b_of_type_JavaUtilList.contains(akla.a(localRecentUser.uin, -2147483648))) {}
        }
        else
        {
          if ((localRecentBaseData instanceof RecentUserBaseData)) {
            ((RecentUserBaseData)localRecentBaseData).setRecentUser(localRecentUser);
          }
          localRecentBaseData.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          paramMessage = localRecentBaseData;
        }
      }
      try
      {
        label279:
        Collections.sort(localList1, this.jdField_a_of_type_Akjw);
        d(localList1);
        u();
        paramMessage = new ArrayList(localList1);
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
        a(localList1);
        if (this.jdField_a_of_type_Akho != null) {
          this.jdField_a_of_type_Akho.j();
        }
        if (this.jdField_c_of_type_Int <= 9) {
          this.jdField_c_of_type_Int = 0;
        }
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
        this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
        this.jdField_d_of_type_Long = System.currentTimeMillis();
        paramMessage = new HashMap();
        paramMessage.put(BaseConstants.RDM_NoChangeFailCode, "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - paramLong, localList1.size(), paramMessage, "");
        bfzg.a("Conversation_Refresh_part", System.currentTimeMillis() - paramLong);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("Q.recent", 4, "REFRESH_FLAG_PART, [" + paramLong + "," + (System.currentTimeMillis() - paramLong) + "]");
        return;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          paramMessage.printStackTrace();
        }
      }
    }
  }
  
  private void b(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, int paramInt)
  {
    if (paramRecentUser != null)
    {
      if ((paramRecentUser.getType() != 7120) && (paramRecentUser.getType() != 7210) && (paramRecentUser.getType() != 1008)) {
        break label210;
      }
      paramRecentBaseData = "0X80067EC";
      if (paramInt != 0) {
        break label274;
      }
      paramRecentBaseData = "0X80067ED";
    }
    label274:
    for (int i1 = 0;; i1 = 1)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMsgForMsgTab(paramRecentUser.uin, paramRecentUser.getType());
      if ((localObject != null) && ((localObject instanceof MessageForStructing)))
      {
        localObject = ((MessageForStructing)localObject).structingMsg;
        if (localObject == null) {}
      }
      for (long l1 = ((AbsStructMsg)localObject).msgId;; l1 = 0L)
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", paramRecentBaseData, paramRecentBaseData, 0, 0, paramRecentUser.uin + "", "" + l1, "" + i1, "" + paramInt);
        label210:
        do
        {
          return;
        } while (paramRecentUser.getType() != 6004);
        if (paramInt > 0) {}
        for (paramInt = 1;; paramInt = 2)
        {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090CC", "0X80090CC", paramInt, 0, "", "", "", "");
          return;
        }
      }
    }
  }
  
  private void b(Object paramObject)
  {
    if ((paramObject instanceof String[]))
    {
      paramObject = (String[])paramObject;
      if ((paramObject.length == 2) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramObject[0])) && (paramObject[1] != null))
      {
        Object localObject = paramObject[0];
        a(8, paramObject[1], 7000);
      }
    }
  }
  
  private void b(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.18(this, paramString));
  }
  
  private void b(List<RecentBaseData> paramList)
  {
    int i1;
    int i2;
    label8:
    RecentBaseData localRecentBaseData;
    if (paramList == null)
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1) {
        return;
      }
      localRecentBaseData = (RecentBaseData)paramList.get(i2);
      if (localRecentBaseData != null) {
        break label47;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label8;
      i1 = paramList.size();
      break;
      label47:
      this.jdField_a_of_type_Akkk.a(localRecentBaseData);
    }
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    if ((paramObservable instanceof azjc))
    {
      if ((paramObject instanceof Boolean))
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        if ((!this.jdField_e_of_type_Boolean) && (bool))
        {
          paramObservable = null;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            paramObservable = (azjc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
          }
          if (paramObservable != null) {
            paramObservable.a(false);
          }
        }
      }
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Akho != null)) {
        this.jdField_a_of_type_Akho.k();
      }
    }
  }
  
  private boolean b(RecentBaseData paramRecentBaseData, boolean paramBoolean, anuz paramanuz, String paramString)
  {
    boolean bool = false;
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.getRecentUserUin());
    int i1;
    if (!TextUtils.isEmpty(str))
    {
      paramanuz = (amoo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(22);
      if (paramBoolean) {}
      for (i1 = 0; !paramanuz.a(str, i1); i1 = 1) {
        return true;
      }
      paramanuz = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
      if (paramanuz != null) {}
      switch (paramanuz.troopmask)
      {
      case 2: 
      case 3: 
      default: 
        i1 = 0;
        label127:
        paramanuz = new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
        paramString = paramRecentBaseData.getRecentUserUin();
        if (paramBoolean)
        {
          paramRecentBaseData = "0";
          label177:
          paramanuz.a(new String[] { paramString, String.valueOf(i1), paramRecentBaseData }).a();
        }
        break;
      }
    }
    do
    {
      return false;
      i1 = 0;
      break label127;
      i1 = 3;
      break label127;
      paramRecentBaseData = "1";
      break label177;
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent", 2, "TroopManage.getTroopCodeByTroopUin return null...");
      }
      i1 = paramRecentBaseData.getRecentUserType();
      if ((paramString == null) || (paramString.length() == 0) || (paramanuz == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
        if (paramString == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
          paramBoolean = bool;
          if (paramanuz == null) {
            paramBoolean = true;
          }
          QLog.d("Q.recent", 2, paramBoolean);
          return true;
        }
      }
      localObject = (RecentUser)paramanuz.findRecentUser(paramString, i1);
      paramRecentBaseData = (RecentBaseData)localObject;
      if (localObject == null) {
        paramRecentBaseData = new RecentUser(paramString, i1);
      }
    } while (!awhn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData));
    if (paramBoolean) {}
    for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
    {
      paramanuz.saveRecentUser(paramRecentBaseData);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      break;
    }
  }
  
  private void c(int paramInt)
  {
    for (;;)
    {
      try
      {
        QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync from=", Integer.valueOf(paramInt), " isInRealActionLoginB=", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.b()), " isLoadUIAfterMsgSync=", Boolean.valueOf(this.m) });
        if (1 == paramInt)
        {
          this.r = true;
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
          a(1072, 500L, true);
          a(500, "tianshu_req_splash_type_after_sync", true);
          a(1073, 30000L, true);
          a(1077, 1200L, true);
          if (this.jdField_a_of_type_Adcx != null) {
            this.jdField_a_of_type_Adcx.f();
          }
          amxz.b();
        }
        if (!this.m)
        {
          boolean bool = this.jdField_h_of_type_Boolean;
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.m = true;
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_Akho.a();
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
        R();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync cost=", Long.valueOf(System.currentTimeMillis() - l1), " all done!" });
        } else {
          QLog.d("Q.recent", 2, "doAfterMsgSync all done!");
        }
      }
      finally {}
    }
  }
  
  private void c(long paramLong)
  {
    if (this.jdField_g_of_type_Boolean) {
      a(1016, paramLong, true);
    }
  }
  
  private void c(Message paramMessage)
  {
    boolean bool = a(paramMessage);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "REFRESH_FLAG_RECENT_ITEMS, [" + paramMessage.arg1 + "," + paramMessage.arg2 + "," + paramMessage.obj + "," + this.jdField_j_of_type_Boolean + "," + bool + "]");
    }
    if (!bool) {
      return;
    }
    int i2 = paramMessage.arg2;
    Object localObject;
    long l1;
    if ((i2 == 8) || (i2 == 9))
    {
      localObject = null;
      if ((paramMessage.obj instanceof String)) {
        localObject = (String)paramMessage.obj;
      }
      if ((localObject != null) && (!this.jdField_b_of_type_JavaUtilList.contains(localObject))) {
        this.jdField_b_of_type_JavaUtilList.add(localObject);
      }
      l1 = 0L;
    }
    for (;;)
    {
      if (i2 >= this.jdField_c_of_type_Int)
      {
        int i1 = 8;
        for (;;)
        {
          if (i1 < i2)
          {
            this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(i1);
            i1 += 1;
            continue;
            if (!(paramMessage.obj instanceof Long)) {
              break label323;
            }
            l1 = ((Long)paramMessage.obj).longValue();
            break;
          }
        }
        this.jdField_c_of_type_Int = i2;
      }
      if ((!this.jdField_j_of_type_Boolean) || (this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(this.jdField_c_of_type_Int))) {
        break;
      }
      long l2 = Math.abs(System.currentTimeMillis() - this.jdField_d_of_type_Long);
      l1 = Math.max(this.jdField_a_of_type_Long - l2, l1);
      localObject = Message.obtain();
      ((Message)localObject).arg1 = paramMessage.arg1;
      ((Message)localObject).what = this.jdField_c_of_type_Int;
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, l1);
      return;
      label323:
      l1 = 0L;
    }
  }
  
  private void c(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {
      return;
    }
    ((amtm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).b();
    avnu.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    L();
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if (alem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      alem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.b())) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        Object localObject = paramMessage.getRecentList(bool);
        this.jdField_a_of_type_Akjw.a((List)localObject);
        paramMessage = akla.a().jdField_a_of_type_JavaUtilList;
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        BaseActivity localBaseActivity = a();
        int i1;
        if (localObject != null)
        {
          i1 = ((List)localObject).size();
          akju.a((List)localObject, localQQAppInterface, localBaseActivity, paramMessage, i1);
        }
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_Akjw);
          d(paramMessage);
          u();
          localObject = new ArrayList(paramMessage);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, localObject).sendToTarget();
          a(paramMessage);
          if (this.jdField_a_of_type_Akho != null) {}
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          localObject = new HashMap();
          ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - paramLong, paramMessage.size(), (HashMap)localObject, "");
          localObject = (vlj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
          ((vlj)localObject).b(3, ((vlj)localObject).a(paramMessage));
          bfzg.a("Conversation_Refresh_global", System.currentTimeMillis() - paramLong);
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i("Q.recent", 4, "REFRESH_FLAG_GLOBAL, [" + paramLong + "," + (System.currentTimeMillis() - paramLong) + "]");
          return;
          i1 = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  private void c(Object paramObject)
  {
    if ((paramObject instanceof RecentUser))
    {
      a(200L);
      if ((this.jdField_f_of_type_Boolean) && (((RecentUser)paramObject).getType() == 6004)) {
        this.y = true;
      }
    }
  }
  
  private void c(List<RecentBaseData> paramList)
  {
    if (this.p)
    {
      amvo localamvo = (amvo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      if ((localamvo.jdField_a_of_type_Boolean) && (localamvo.a(paramList))) {
        localamvo.jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Akkk.a(paramList);
    if (this.D)
    {
      this.D = false;
      if (this.E)
      {
        if (!this.jdField_f_of_type_Boolean) {
          break label122;
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addOnLayoutChangeListener(new ajdd(this));
      }
    }
    for (;;)
    {
      this.E = false;
      if (paramList != null) {
        akla.a().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      }
      this.jdField_a_of_type_Akkk.a(0);
      return;
      label122:
      aC();
    }
  }
  
  private void d(Object paramObject)
  {
    int i3 = 0;
    MessageRecord localMessageRecord;
    if ((paramObject instanceof MessageRecord))
    {
      localMessageRecord = (MessageRecord)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshMultiAIOUnreadNum(localMessageRecord.frienduin, localMessageRecord.istroop);
      if ((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.msgtype != -2002)) {
        break label53;
      }
    }
    label53:
    while ((localMessageRecord.isSendFromLocal()) && (localMessageRecord.msgtype == -2000) && (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    if ((this.jdField_f_of_type_Boolean) && (nyj.a(localMessageRecord)))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      m(false);
    }
    if ((this.jdField_f_of_type_Boolean) && (aukz.a(localMessageRecord))) {
      aukx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Akkk, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
    }
    if ((this.jdField_f_of_type_Boolean) && (QCircleChatUtil.isQCircleChatType(localMessageRecord.istroop))) {
      q();
    }
    int i4 = 10;
    Long localLong = Long.valueOf(0L);
    int i1;
    int i2;
    if ((localMessageRecord.isSendFromLocal()) && ((!this.jdField_f_of_type_Boolean) || (TextUtils.equals(localMessageRecord.frienduin, AppConstants.NEW_KANDIAN_UIN)) || (TextUtils.equals(localMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))))
    {
      i1 = 2;
      i2 = 9;
      paramObject = akla.a(localMessageRecord.frienduin, localMessageRecord.istroop);
    }
    for (;;)
    {
      if (localMessageRecord.isSend()) {
        bfxn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
      }
      a(i1, i2, paramObject);
      this.H = true;
      return;
      paramObject = localLong;
      i2 = i4;
      i1 = i3;
      if (!this.jdField_f_of_type_Boolean)
      {
        paramObject = localLong;
        i2 = i4;
        i1 = i3;
        if (akms.jdField_b_of_type_Boolean)
        {
          paramObject = localLong;
          i2 = i4;
          i1 = i3;
          if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1024))
          {
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1024, 100L);
            paramObject = localLong;
            i2 = i4;
            i1 = i3;
          }
        }
      }
    }
  }
  
  private void d(List<RecentBaseData> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    ArrayList localArrayList;
    for (;;)
    {
      localArrayList = new ArrayList(paramList);
      this.jdField_a_of_type_JavaLangStringBuilder.append("SortedRecentInfo, [");
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      int i2 = paramList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = (RecentBaseData)paramList.get(i1);
        if ((localObject instanceof RecentUserBaseData))
        {
          localObject = (RecentUserBaseData)localObject;
          if (((((RecentUserBaseData)localObject).getRecentUserType() == 1) && (!awhn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)((RecentUserBaseData)localObject).mUser)) && (localTroopManager.b(((RecentUserBaseData)localObject).getRecentUserUin()))) || (((RecentUserBaseData)localObject).mUser.showUpTime != 0L)) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(((RecentUserBaseData)localObject).getRecentUserType()).append("-").append(StringUtil.getSimpleUinForPrint(((RecentUserBaseData)localObject).getRecentUserUin())).append("-").append(i1).append(" , ");
          }
        }
        i1 += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("]");
    localArrayList.clear();
    QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  private boolean f()
  {
    if (!bfyz.d(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().getRecentList(false);
      if ((localObject2 == null) || (((List)localObject2).size() == 0))
      {
        bfyz.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        return true;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser.getType() == 1) && (localRecentUser.showUpTime > 0L))
        {
          ((TroopManager)localObject1).a(localRecentUser.uin, localRecentUser.showUpTime);
          localArrayList.add(localRecentUser.uin);
          a(9, localRecentUser.uin, 1);
        }
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (bfyz.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).contains(localObject2)) {
          localArrayList.remove(localObject2);
        }
      }
      if (localArrayList.size() == 0)
      {
        bfyz.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        return true;
      }
      ((amoo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(22)).a(localArrayList, 0);
    }
    return false;
  }
  
  private void i(boolean paramBoolean)
  {
    if (this.n != paramBoolean)
    {
      if (!paramBoolean) {
        break label149;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null)
      {
        QLog.e("Q.recent", 1, "Error State that mChatTopReflesh is null! ui Not Init! will updateMsgTabStoryNodeView(true) later.");
        this.s = true;
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_Vzt == null) {
      this.jdField_a_of_type_Vzt = new vzt(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, (BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368133));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)) {
      this.jdField_a_of_type_Vzt.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
    }
    this.jdField_a_of_type_Vzt.jdField_f_of_type_Boolean = this.w;
    this.jdField_a_of_type_Vzt.b();
    for (this.s = false;; this.s = false)
    {
      this.n = paramBoolean;
      return;
      label149:
      if (this.jdField_a_of_type_Vzt != null) {
        this.jdField_a_of_type_Vzt.c();
      }
    }
  }
  
  private void j(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "addObservers" + paramBoolean + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    AtomicBoolean localAtomicBoolean = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
    if (!paramBoolean) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 200L);
      return;
    }
    finally {}
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Andd, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amop, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ampv, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amwl, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Andl, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amrc, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anbq, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Axkt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amqk);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amua);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Vlc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anaa);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aebt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axvm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Arht);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anbn);
    bcoo.a(this.jdField_a_of_type_Bcoq);
    Object localObject2 = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject2 != null) {
      ((azvi)localObject2).addObserver(this);
    }
    if (this.jdField_a_of_type_Asbj == null) {
      av();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Asbj);
    if (this.jdField_a_of_type_Ajdl == null) {
      this.jdField_a_of_type_Ajdl = new ajdl(this);
    }
    this.jdField_a_of_type_Ajdl.addFilter(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, C2CPttDownloadProcessor.class, C2CPttUploadProcessor.class, GroupPicUploadProcessor.class, GroupPttDownloadProcessor.class, ForwardImageProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().addHandle(this.jdField_a_of_type_Ajdl);
    try
    {
      localObject2 = new IntentFilter("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      localObject2 = new IntentFilter("com.tencent.mobileqq.action.SECURITY_DETECT_PUSH_BANNER");
      a().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      localObject2 = new IntentFilter("android.intent.action.TIME_SET");
      ((IntentFilter)localObject2).addAction("android.intent.action.DATE_CHANGED");
      ((IntentFilter)localObject2).addAction("android.intent.action.TIMEZONE_CHANGED");
      a().registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amsu, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
        localObject2 = (azjc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject2 != null) {
          ((azjc)localObject2).addObserver(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getGAudioHandler().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().addObserver(this.jdField_a_of_type_Lmt);
        mum.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anaz);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amzx);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anxo);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
        if (this.jdField_a_of_type_Avji != null) {
          this.jdField_a_of_type_Avji.b();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("AfterAddObservers");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, localException.toString());
        }
      }
    }
  }
  
  private void k(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_a_of_type_Aufo != null)) {
      this.jdField_a_of_type_Aufo.d();
    }
    m(true);
    aq();
    s();
  }
  
  private void l(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.k))
    {
      if (this.jdField_a_of_type_Adcx != null) {
        this.jdField_a_of_type_Adcx.a(false);
      }
      adcw localadcw = this.jdField_a_of_type_Adcw;
      if (localadcw != null) {
        localadcw.a(false);
      }
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if ((!uex.k) || ((!paramBoolean) && (ocw.a().jdField_a_of_type_Boolean))) {}
    label151:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Akkk != null))
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
        if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
          if (!(this.jdField_a_of_type_Akkk.getItem(i1) instanceof RecentItemPublicAccountADFolderData)) {}
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label151;
        }
        if ((this.jdField_a_of_type_Aufo != null) && (!this.x))
        {
          this.jdField_a_of_type_Aufo.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.x = true;
        }
        ocw.a().jdField_a_of_type_Boolean = true;
        ThreadManager.getSubThreadHandler().postDelayed(new Conversation.27(this), 1000L);
        return;
        i1 += 1;
        break;
      }
    }
  }
  
  public void Y_()
  {
    super.Y_();
    d();
  }
  
  int a()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Akkk.getCount())
    {
      if ((this.jdField_a_of_type_Akkk.getItem(i1) instanceof RecentItemMayKnowFriendVerticalListData)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  protected int a(String paramString, int paramInt)
  {
    int i1 = 4;
    int i2 = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i2;
    case 1000: 
    case 1004: 
    case 1006: 
    case 1021: 
    case 0: 
      do
      {
        i1 = paramInt;
        return i1;
        paramInt = 1;
      } while (akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
      return 4;
    case 3000: 
      return 2;
    case 1: 
      return 3;
    case 1001: 
    case 1003: 
    case 10002: 
    case 10004: 
      return 5;
    case 1005: 
      return 6;
    case 1008: 
    case 1009: 
    case 1012: 
    case 1020: 
    case 1022: 
      return 7;
    case 5000: 
      return 8;
    case 7120: 
    case 7200: 
      return 9;
    case 6000: 
      return 10;
    }
    return 11;
  }
  
  public akkk a()
  {
    return this.jdField_a_of_type_Akkk;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    bfzg.a(null, "Recent_Start");
    bfzg.a(null, "Recent_CreateView");
    Object localObject1 = a();
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof SplashActivity)))
    {
      localObject2 = (SplashActivity)localObject1;
      localObject1 = ((SplashActivity)localObject2).jdField_a_of_type_AndroidViewView;
      ((SplashActivity)localObject2).jdField_a_of_type_AndroidViewView = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramLayoutInflater.inflate(2131558976, null);
      }
      bfzg.a("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public String a()
  {
    String str = amtj.a(2131701740);
    if (this.jdField_d_of_type_Int <= 0) {
      return str;
    }
    if (this.jdField_d_of_type_Int > 99) {
      return str + "(99+)";
    }
    return str + "(" + this.jdField_d_of_type_Int + ")";
  }
  
  public vzt a()
  {
    return this.jdField_a_of_type_Vzt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onActivityResult, [" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    }
    switch (paramInt1)
    {
    default: 
    case 14002: 
    case 2: 
    case 1000: 
      do
      {
        do
        {
          return;
          b(paramInt2, paramIntent);
          return;
        } while (a() == null);
        a().setCanLock(false);
        return;
      } while (paramInt2 != 0);
      A();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.exit(false);
      return;
    case 1300: 
      a(paramInt2, paramIntent);
      return;
    case 9001: 
      a(paramInt2);
      return;
    case 9002: 
      b(paramInt1);
      return;
    case 9010: 
      aklx.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
      return;
    case 14005: 
    case 14006: 
      b(paramInt1, paramInt2, paramIntent);
      return;
    }
    J();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "refreshRecentList invalidate params arg1: " + paramInt1 + ", arg2: " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshRecentList|invalidate to refresh");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt2 <= 10) && (paramInt2 >= 8)) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2);
        return;
        if ((paramInt2 != 10) || ((paramObject instanceof Long))) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2 + ", obj: " + paramObject);
      return;
      if (((paramInt2 != 8) && (paramInt2 != 9)) || ((paramObject instanceof String))) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2 + ", obj:" + paramObject);
    return;
    if (!d())
    {
      this.jdField_i_of_type_Boolean = false;
      Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(11);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramObject;
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    this.jdField_i_of_type_Boolean = true;
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(paramInt);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "sendQbossRequest[what:" + paramInt + ",delay:" + paramLong + ",refreshType:" + paramString);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(paramInt);
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.obj = paramString;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    String str1;
    anuz localanuz;
    String str2;
    amsw localamsw;
    if (paramBoolean)
    {
      str1 = "1";
      localanuz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      str2 = paramRecentBaseData.getRecentUserUin();
      localamsw = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((paramInt != 7000) || (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(str2))) {
        break label125;
      }
      bcqk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, paramBoolean);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str1, paramString, "");
    }
    label125:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            a(paramInt, paramRecentBaseData, paramBoolean, str1, localanuz);
            return;
            str1 = "0";
            break;
            if (paramInt == 5000)
            {
              a(paramRecentBaseData, paramString, paramBoolean, str1);
            }
            else
            {
              if (paramInt != 5001) {
                break label174;
              }
              ((amtm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramBoolean);
            }
          }
          if (paramInt != 1) {
            break label194;
          }
        } while (!b(paramRecentBaseData, paramBoolean, localanuz, str2));
        return;
        if ((paramInt != 0) || (!localamsw.b(str2))) {
          break label221;
        }
      } while (!a(paramInt, paramBoolean, str2));
      return;
    } while (!a(paramRecentBaseData, paramBoolean, localanuz, str2));
    label174:
    label194:
    label221:
    return;
  }
  
  protected void a(int paramInt, RecentUser paramRecentUser)
  {
    if ((paramRecentUser == null) || (paramInt == 0)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshAfterClick|[" + paramRecentUser + "," + paramInt + "]");
      }
    }
    do
    {
      return;
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_Akho != null)) {
        this.jdField_a_of_type_Akho.a(paramRecentUser.uin);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.getType());
      }
    } while ((paramInt & 0x4) == 0);
    akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, -1);
    QQToast.a(a(), amtj.a(2131701739), 0).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 8) && (paramInt1 != 9)) {
      return;
    }
    a(0, paramInt1, akla.a(paramString, paramInt2));
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    if (!paramBoolean1)
    {
      M();
      c(800L);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(AVNotifyCenter.class);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((MqqHandler)localObject1).obtainMessage(10010);
      ((Message)localObject2).obj = Boolean.valueOf(paramBoolean1);
      ((MqqHandler)localObject1).sendMessage((Message)localObject2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isMSFConnect) {
      this.jdField_a_of_type_Akho.a(11, 0);
    }
    boolean bool1;
    int i1;
    label111:
    boolean bool2;
    if (!paramBoolean1)
    {
      bool1 = true;
      avnc.a().a(bool1);
      localObject1 = this.jdField_a_of_type_Akho;
      if (!bool1) {
        break label244;
      }
      i1 = 2;
      ((akho)localObject1).a(1, i1);
      bool2 = avnc.a().d();
      if ((!bool2) || (paramInt != 1134012)) {
        break label352;
      }
      bool2 = false;
    }
    label352:
    for (;;)
    {
      avnc.a().b(bool2);
      localObject1 = this.jdField_a_of_type_Akho;
      i1 = i2;
      if (bool2) {
        i1 = 2;
      }
      ((akho)localObject1).a(12, i1);
      this.jdField_a_of_type_Akho.a(-1, null);
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aozm)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              ((aozm)localObject2).a(paramBoolean1);
              continue;
              bool1 = false;
              break;
              label244:
              i1 = 0;
              break label111;
            }
          }
        }
      }
      d(bool1 | bool2 | paramBoolean2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(150);
        ((StringBuilder)localObject1).append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isMSFConnect).append(", isNetSupport = ").append(paramBoolean1).append(", loadingState = ").append(avnc.a().a()).append(", msg = ").append(paramInt);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
  }
  
  public void a(long paramLong)
  {
    a(0, 10, Long.valueOf(paramLong));
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.b();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int i1 = bfrr.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    bfrr.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i1 + 1);
    a(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((this.jdField_a_of_type_Aklx != null) && (this.jdField_a_of_type_Aklx.a())) {
      this.jdField_a_of_type_Aklx.b();
    }
    super.a(paramConfiguration);
  }
  
  public void a(Message paramMessage, boolean paramBoolean)
  {
    if (paramMessage == null) {}
    for (int i1 = 0;; i1 = paramMessage.what)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder(150);
        paramMessage.append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isMSFConnect).append(", initLoadingHandle = ").append(paramBoolean).append(", loadingState = ").append(avnc.a().a()).append(", what = ").append(i1);
        QLog.i("Q.recent", 2, paramMessage.toString());
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isMSFConnect) {
        break;
      }
      a(i1, true, paramBoolean);
      a(i1, true);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new Conversation.1(this, i1, paramBoolean));
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Akkk == null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = this.jdField_a_of_type_Akkk.a(paramView);
      if ((localRecentBaseData != null) && ("9970".equals(localRecentBaseData.getRecentUserUin()))) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
      }
    } while ((localRecentBaseData == null) || (!AppConstants.SERVICE_ACCOUNT_FOLDER_UIN.equals(localRecentBaseData.getRecentUserUin())));
    int i1;
    if (localRecentBaseData.mUnreadFlag == 2)
    {
      i1 = 1;
      if (localRecentBaseData.mUnreadFlag != 1) {
        break label168;
      }
    }
    label168:
    for (int i2 = localRecentBaseData.mUnreadNum;; i2 = 0)
    {
      int i3 = -1;
      if ((paramView.getTag(-1) instanceof Integer)) {
        i3 = ((Integer)paramView.getTag(-1)).intValue() + 1;
      }
      ThreadManager.executeOnSubThread(new Conversation.6(this, i1, i2, i3));
      return;
      i1 = 0;
      break;
    }
  }
  
  public void a(View paramView, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onMsgTabRecommendBClick uin = " + paramString);
    }
    int i2 = paramView.getId();
    if ((paramString.equals("sp_uin_for_title")) && (i2 == 2131376108))
    {
      z();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "msgtab_list_clk", 2);
      return;
    }
    amvo localamvo = (amvo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramString, 102);
    boolean bool = localamvo.a();
    ArrayList localArrayList = localamvo.c();
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      paramView = (MayKnowRecommend)localArrayList.get(i1);
      if (!paramView.uin.equals(paramString)) {}
    }
    for (;;)
    {
      i1 -= a();
      if (paramView == null)
      {
        QLog.d("Q.recent", 1, "onMsgTabRecommendBClick recommend is null ");
        return;
        i1 += 1;
        break;
      }
      if (i2 == 2131376341)
      {
        if (!NetworkUtil.isNetworkAvailable(paramContext))
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131692035), 0).b(a().getTitleBarHeight());
          return;
        }
        paramString = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((!paramString.b(paramView.uin)) && (!paramString.d(paramView.uin)))
        {
          paramString = paramView.getDisplayName(localamvo.a());
          paramContext = AddFriendLogicActivity.a(paramContext, 1, paramView.uin, null, 3045, 25, paramString, null, null, paramContext.getString(2131689550), null);
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(25), "", "", "");
          a(paramContext);
        }
        for (;;)
        {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", 25, 1, paramView.recommendReason, i1, paramView.algBuffer, 2);
          return;
          if (paramString.b(paramView.uin)) {
            paramView.friendStatus = 2;
          } else {
            paramView.friendStatus = 1;
          }
        }
      }
      paramString = paramView.getRecommendName(bool);
      if (!TextUtils.isEmpty(paramString)) {
        localAllInOne.l = paramString;
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        localAllInOne.jdField_h_of_type_JavaLangString = paramView.nick;
      }
      localAllInOne.jdField_h_of_type_Int = 88;
      paramString = new Bundle();
      paramString.putString("recommend_reason", paramView.recommendReason);
      paramString.putInt("recommend_pos", i1);
      paramString.putByteArray("recommend_algh_id", paramView.algBuffer);
      paramString.putInt("key_display_type", 2);
      ProfileActivity.a(paramContext, localAllInOne, paramString);
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_clk", 25, 0, paramView.recommendReason, i1, paramView.algBuffer, 2);
      return;
      i1 = 0;
      paramView = null;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_Boolean) || (a(paramView, paramRecentBaseData))) {
      return;
    }
    this.C = true;
    bfzg.a(null, "AIO_Click_cost");
    bfwu.a(null, "pubAcc_aio_open", "");
    bfta.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "AIOTime onRecentBaseDataClick start");
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramView = (RecentUser)((RecentUserBaseData)paramRecentBaseData).getRecentUser();
      b(paramRecentBaseData, paramView, paramRecentBaseData.mUnreadNum);
    }
    for (;;)
    {
      int i1 = akms.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData);
      a(paramRecentBaseData, paramView, i1);
      a(i1, paramView);
      if (paramRecentBaseData != null)
      {
        akmp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramView);
        paramRecentBaseData.clearUnReadNum();
        bjnm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.getRecentUserUin());
        this.jdField_i_of_type_Boolean = true;
      }
      bfzg.a("AIO_Click_cost", null);
      return;
      paramView = null;
    }
  }
  
  public void a(View paramView, Object paramObject)
  {
    vlj localvlj = (vlj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick not RecentBaseData");
    }
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v == null");
      }
    }
    do
    {
      return;
      if (paramView.getId() == 2131363742)
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
        paramView = new Intent(a(), ForwardRecentActivity.class);
        paramView.putExtra("forward_type", 13);
        a(paramView);
        return;
      }
      if ((paramView.getId() == 2131367164) || (paramView.getId() == 2131367166) || (paramView.getId() == 2131367167) || (paramView.getId() == 2131367168) || (paramView.getId() == 2131367169) || (paramView.getId() == 2131367170) || (paramView.getId() == 2131367171))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = ContactUtils.getFriendShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, paramView, paramObject, null, true, null, true, true, null, null);
        return;
      }
    } while ((paramView.getId() != 2131369392) || (!localvlj.b(paramObject)));
    localvlj.a(paramView, (RecentItemChatMsgData)paramObject);
  }
  
  public void a(bgre parambgre, bgrd parambgrd)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.c()) && (parambgrd != null) && (parambgrd.jdField_d_of_type_Long == 0L) && (parambgrd.jdField_a_of_type_Long != 0L)) {
      parambgre.a(parambgrd.jdField_a_of_type_Long);
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    Object localObject;
    if (this.jdField_e_of_type_Boolean)
    {
      paramString = null;
      int i1 = -1;
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        localObject = (RecentUserBaseData)paramRecentBaseData;
        paramString = (RecentUser)((RecentUserBaseData)localObject).getRecentUser();
        i1 = ((RecentUserBaseData)localObject).mPosition;
      }
      if (paramString != null)
      {
        akmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
        akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i1);
        this.jdField_a_of_type_Adct.a(paramString);
      }
    }
    for (;;)
    {
      return;
      localObject = (azjc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
      if ((localObject != null) && (paramRecentBaseData != null)) {}
      try
      {
        ((azjc)localObject).b(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
        if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
          if (paramRecentBaseData.getRecentUserType() == 3000)
          {
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.recent", 2, "delRecentCallByUin Error");
          }
        }
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    N();
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = a();
    int i1 = paramRecentBaseData.getRecentUserType();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_Akmr == null)) {
      this.jdField_a_of_type_Akmr = new akmr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (bftf.a(paramString1, localResources.getString(2131691146)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
      if (!bftf.a(paramString1, localResources.getString(akll.a[4]))) {
        break label411;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)paramString1.getRecentUser(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
    }
    label411:
    while (!bftf.a(paramString1, localResources.getString(akll.a[5])))
    {
      return;
      if (bftf.a(paramString1, localResources.getString(2131691149)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        break;
      }
      if (bftf.a(paramString1, localResources.getString(2131692856)))
      {
        a(i1, paramRecentBaseData, paramString2, false);
        if (i1 != 3000) {
          break;
        }
        new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").a();
        break;
      }
      if (bftf.a(paramString1, localResources.getString(2131692858)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        if (i1 != 3000) {
          break;
        }
        new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").a();
        break;
      }
      if (!bftf.a(paramString1, localResources.getString(2131693977))) {
        break;
      }
      this.jdField_a_of_type_Akmc.a(a(), paramRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramRecentBaseData.getRecentUserUin(), "0X800991D", "0X800991D", 0, 0, "", "", "", "");
      break;
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramString1 = (RecentUser)((RecentUserBaseData)paramRecentBaseData).getRecentUser();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString1.uin, paramString1.getType(), 1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
  }
  
  protected void a(List<RecentBaseData> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    ArrayList localArrayList;
    for (;;)
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(paramList);
      this.jdField_a_of_type_JavaLangStringBuilder.append("unreadinfo, [");
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
        if ((localRecentBaseData != null) && (localRecentBaseData.mUnreadNum > 0)) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentBaseData.getRecentUserType()).append("-").append(localRecentBaseData.getRecentUserUin()).append("-").append(localRecentBaseData.mUnreadNum).append("-").append(localRecentBaseData.mUnreadFlag).append(" , ");
        }
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("]");
    localArrayList.clear();
    QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.springBackOverScrollHeaderView();
    }
    if (this.jdField_a_of_type_Akkk != null) {
      this.jdField_a_of_type_Akkk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Akho.a(24, 0);
    akla.a().a();
    blbw.a().a();
    if (this.jdField_a_of_type_Adct != null) {
      this.jdField_a_of_type_Adct.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_Ayhx != null) {
      this.jdField_a_of_type_Ayhx.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aozm localaozm = (aozm)localIterator.next();
        if (localaozm != null) {
          localaozm.a(paramLogoutReason);
        }
      }
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_h_of_type_Boolean)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      label183:
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1073);
      return;
    }
    catch (Exception paramLogoutReason)
    {
      break label183;
    }
  }
  
  /* Error */
  protected void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 563	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 458
    //   9: iconst_2
    //   10: new 460	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 3495
    //   20: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 474	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 477	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 534	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   37: ifnull +21 -> 58
    //   40: aload_0
    //   41: getfield 534	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   44: invokevirtual 3498	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   47: ifge +11 -> 58
    //   50: aload_0
    //   51: getfield 534	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   54: iconst_0
    //   55: invokevirtual 3501	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   58: aload_0
    //   59: iconst_0
    //   60: invokespecial 3503	com/tencent/mobileqq/activity/home/Conversation:j	(Z)V
    //   63: iload_1
    //   64: ifeq +402 -> 466
    //   67: invokestatic 685	avnc:a	()Lavnc;
    //   70: invokevirtual 3504	avnc:a	()V
    //   73: invokestatic 906	akla:a	()Lakla;
    //   76: invokevirtual 3482	akla:a	()V
    //   79: invokestatic 3487	blbw:a	()Lblbw;
    //   82: invokevirtual 3488	blbw:a	()V
    //   85: aload_0
    //   86: getfield 2648	com/tencent/mobileqq/activity/home/Conversation:jdField_g_of_type_Boolean	Z
    //   89: ifeq +22 -> 111
    //   92: aload_0
    //   93: getfield 534	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   96: ifnull +15 -> 111
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 2648	com/tencent/mobileqq/activity/home/Conversation:jdField_g_of_type_Boolean	Z
    //   104: aload_0
    //   105: getfield 534	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   108: invokevirtual 3507	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   111: aload_0
    //   112: getfield 703	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   115: ifnull +15 -> 130
    //   118: aload_0
    //   119: getfield 703	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   122: invokevirtual 3508	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 703	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   130: aload_0
    //   131: getfield 719	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   134: ifnull +15 -> 149
    //   137: aload_0
    //   138: getfield 719	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   141: invokevirtual 727	android/app/Dialog:dismiss	()V
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield 719	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   149: aload_0
    //   150: getfield 893	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Aioc	Laioc;
    //   153: ifnull +14 -> 167
    //   156: aload_0
    //   157: getfield 893	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Aioc	Laioc;
    //   160: aload_0
    //   161: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   164: invokevirtual 3509	aioc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   167: aload_0
    //   168: getfield 1730	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Akmr	Lakmr;
    //   171: ifnull +14 -> 185
    //   174: aload_0
    //   175: getfield 1730	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Akmr	Lakmr;
    //   178: aload_0
    //   179: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: invokevirtual 3510	akmr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   185: aload_0
    //   186: getfield 479	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Akkk	Lakkk;
    //   189: ifnull +25 -> 214
    //   192: aload_0
    //   193: getfield 479	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Akkk	Lakkk;
    //   196: aload_0
    //   197: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   200: invokevirtual 3511	akkk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   203: aload_0
    //   204: iconst_1
    //   205: bipush 10
    //   207: lconst_0
    //   208: invokestatic 500	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   211: invokevirtual 503	com/tencent/mobileqq/activity/home/Conversation:a	(IILjava/lang/Object;)V
    //   214: aload_0
    //   215: getfield 534	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   218: ifnull +11 -> 229
    //   221: aload_0
    //   222: getfield 534	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   225: iconst_0
    //   226: invokevirtual 3514	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   229: aload_0
    //   230: iconst_0
    //   231: invokespecial 1662	com/tencent/mobileqq/activity/home/Conversation:i	(Z)V
    //   234: aload_0
    //   235: getfield 2106	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Vzt	Lvzt;
    //   238: ifnull +14 -> 252
    //   241: aload_0
    //   242: getfield 2106	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Vzt	Lvzt;
    //   245: aload_0
    //   246: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   249: invokevirtual 3515	vzt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   252: aload_0
    //   253: getfield 1111	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   256: ifnull +16 -> 272
    //   259: aload_0
    //   260: getfield 1111	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   263: aload_0
    //   264: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   267: invokeinterface 3518 2 0
    //   272: aload_0
    //   273: getfield 538	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Bkyu	Lbkyu;
    //   276: ifnull +14 -> 290
    //   279: aload_0
    //   280: getfield 538	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Bkyu	Lbkyu;
    //   283: aload_0
    //   284: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   287: invokevirtual 3519	bkyu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   290: aload_0
    //   291: getfield 1821	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Bkzf	Lbkzf;
    //   294: ifnull +14 -> 308
    //   297: aload_0
    //   298: getfield 1821	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Bkzf	Lbkzf;
    //   301: aload_0
    //   302: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   305: invokevirtual 3520	bkzf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   308: ldc_w 458
    //   311: ldc_w 3522
    //   314: aload_0
    //   315: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   318: getfield 1138	com/tencent/mobileqq/app/QQAppInterface:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   321: invokevirtual 1141	com/tencent/mobileqq/app/automator/Automator:b	()Z
    //   324: invokestatic 1181	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   327: invokestatic 3527	xvv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   330: aload_0
    //   331: sipush 1055
    //   334: lconst_0
    //   335: iconst_0
    //   336: invokevirtual 716	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   339: aload_0
    //   340: getfield 901	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Akho	Lakho;
    //   343: ifnull +10 -> 353
    //   346: aload_0
    //   347: getfield 901	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Akho	Lakho;
    //   350: invokevirtual 3528	akho:f	()V
    //   353: aload_0
    //   354: getfield 183	com/tencent/mobileqq/activity/home/Conversation:jdField_j_of_type_Boolean	Z
    //   357: ifeq +13 -> 370
    //   360: aload_0
    //   361: getfield 1190	com/tencent/mobileqq/activity/home/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   364: bipush 12
    //   366: invokevirtual 494	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   369: pop
    //   370: aload_0
    //   371: getfield 746	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   374: getfield 978	com/tencent/mobileqq/app/FrameHelperActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   377: iconst_4
    //   378: invokevirtual 2638	android/os/Handler:sendEmptyMessage	(I)Z
    //   381: pop
    //   382: aload_0
    //   383: sipush 1035
    //   386: ldc2_w 2751
    //   389: iconst_0
    //   390: invokevirtual 716	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   393: aload_0
    //   394: sipush 1010
    //   397: ldc2_w 2751
    //   400: iconst_1
    //   401: invokevirtual 716	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   404: aload_0
    //   405: sipush 1063
    //   408: lconst_0
    //   409: iconst_1
    //   410: aconst_null
    //   411: invokevirtual 1213	com/tencent/mobileqq/activity/home/Conversation:a	(IJZLjava/lang/String;)V
    //   414: aload_0
    //   415: sipush 1064
    //   418: ldc2_w 2751
    //   421: iconst_1
    //   422: ldc_w 3530
    //   425: invokevirtual 1213	com/tencent/mobileqq/activity/home/Conversation:a	(IJZLjava/lang/String;)V
    //   428: aload_0
    //   429: sipush 500
    //   432: ldc_w 3532
    //   435: iconst_1
    //   436: invokespecial 1218	com/tencent/mobileqq/activity/home/Conversation:a	(ILjava/lang/String;Z)V
    //   439: aload_0
    //   440: aload_0
    //   441: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   444: bipush 76
    //   446: invokevirtual 1089	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   449: checkcast 2156	bgre
    //   452: putfield 195	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_Bgre	Lbgre;
    //   455: aload_0
    //   456: invokespecial 3534	com/tencent/mobileqq/activity/home/Conversation:az	()V
    //   459: aload_0
    //   460: ldc_w 3536
    //   463: invokespecial 1007	com/tencent/mobileqq/activity/home/Conversation:b	(Ljava/lang/String;)V
    //   466: aload_0
    //   467: sipush 10001
    //   470: ldc2_w 3537
    //   473: iconst_0
    //   474: invokevirtual 716	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   477: aload_0
    //   478: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   481: invokevirtual 2886	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   484: ifne +15 -> 499
    //   487: aload_0
    //   488: getfield 183	com/tencent/mobileqq/activity/home/Conversation:jdField_j_of_type_Boolean	Z
    //   491: ifeq +8 -> 499
    //   494: aload_0
    //   495: lconst_0
    //   496: invokevirtual 1819	com/tencent/mobileqq/activity/home/Conversation:a	(J)V
    //   499: aload_0
    //   500: ldc_w 3539
    //   503: ldc2_w 1278
    //   506: iconst_0
    //   507: invokevirtual 716	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   510: invokestatic 2275	ocw:a	()Locw;
    //   513: aload_0
    //   514: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   517: invokevirtual 1286	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   520: invokevirtual 3540	ocw:a	(Ljava/lang/String;)V
    //   523: getstatic 3543	avtq:jdField_g_of_type_Boolean	Z
    //   526: ifeq +13 -> 539
    //   529: invokestatic 3546	avtq:a	()Lavtq;
    //   532: aload_0
    //   533: getfield 529	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   536: invokevirtual 3547	avtq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   539: iload_1
    //   540: ifeq +7 -> 547
    //   543: aload_0
    //   544: invokespecial 2640	com/tencent/mobileqq/activity/home/Conversation:R	()V
    //   547: return
    //   548: astore_2
    //   549: aload_0
    //   550: aconst_null
    //   551: putfield 703	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   554: goto -424 -> 130
    //   557: astore_2
    //   558: aload_0
    //   559: aconst_null
    //   560: putfield 703	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   563: aload_2
    //   564: athrow
    //   565: astore_2
    //   566: aload_0
    //   567: aconst_null
    //   568: putfield 719	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   571: goto -422 -> 149
    //   574: astore_2
    //   575: aload_0
    //   576: aconst_null
    //   577: putfield 719	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   580: aload_2
    //   581: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	Conversation
    //   0	582	1	paramBoolean	boolean
    //   548	1	2	localException1	Exception
    //   557	7	2	localObject1	Object
    //   565	1	2	localException2	Exception
    //   574	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   118	125	548	java/lang/Exception
    //   118	125	557	finally
    //   137	144	565	java/lang/Exception
    //   137	144	574	finally
  }
  
  public boolean a()
  {
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.t();
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(79);
      if (localPortalManager != null) {
        localPortalManager.a(a(), false);
      }
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.isMiniAppLauncherOpened()))
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.hideMiniAppEntry(0);
      return true;
    }
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    if (((!this.jdField_f_of_type_Boolean) && (paramMessage.arg1 == 0)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "isRefreshRecentDataNecessary[isForeground:" + this.jdField_f_of_type_Boolean + ",msg.arg1:" + paramMessage.arg1 + ",isLogin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin());
      }
      return false;
    }
    return true;
  }
  
  public boolean a(bgre parambgre, bgrd parambgrd)
  {
    if ((parambgrd == null) || (parambgre == null)) {}
    do
    {
      return false;
      if (parambgrd.jdField_d_of_type_Long == 3L) {
        parambgre.a(4L, parambgrd.jdField_a_of_type_Long);
      }
    } while ((parambgrd == null) || (parambgrd.jdField_d_of_type_Long != 2L) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.c()) || (!this.w));
    return true;
  }
  
  public boolean a(ListView paramListView)
  {
    if ((paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) || (this.jdField_g_of_type_Boolean)) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
      }
      int i1 = 0;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().d()) {
        i1 = 1;
      }
      if (i1 != 0)
      {
        this.jdField_g_of_type_Boolean = true;
        d(true);
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(40001, 500L);
        return true;
      }
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      bfzg.a("Conversation_PullToRefresh_start", 0L);
      n();
      ThreadManager.getSubThreadHandler().post(new Conversation.10(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      }
      if (((vxx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
      {
        ((vxw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a().a(2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "MsgTabNodeListLoader update data");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.handlePullRefresh();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1054);
      a(1064, 200L, true, "qboss_banner_pull_refresh");
      a(1072, 500L, true);
      a(500, "tianshu_req_splash_type_pull_down", true);
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "send MSG_CHECK_MEDAL_GUIDE");
    return true;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b(long paramLong)
  {
    bfee localbfee = (bfee)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
    if (localbfee != null) {
      localbfee.a(paramLong);
    }
  }
  
  public void b(View paramView) {}
  
  public void b(boolean paramBoolean)
  {
    a(true);
    this.D = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      if (this.jdField_f_of_type_Boolean)
      {
        this.E = true;
        aB();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    if (this.jdField_a_of_type_Adcx != null) {
      this.jdField_a_of_type_Adcx.d();
    }
  }
  
  public View c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_c_of_type_AndroidViewView;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "conversation onPostThemeChanged");
    }
    if ((!ThemeUtil.isDefaultTheme()) && (this.B) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850252);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366179).setBackgroundResource(2130850263);
      this.B = false;
    }
    w();
    ap();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.l();
    }
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("ThemeChanged");
      bbyp.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Ayhx.k();
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aozm localaozm = (aozm)localIterator.next();
        if (localaozm != null) {
          localaozm.i();
        }
      }
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850016);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167009));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167009));
    }
    if (this.jdField_a_of_type_Akou != null) {
      this.jdField_a_of_type_Akou.e();
    }
    if (this.jdField_a_of_type_Vzt != null) {
      this.jdField_a_of_type_Vzt.i();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onPostThemeChanged();
    }
    if (this.jdField_a_of_type_Akho != null) {
      this.jdField_a_of_type_Akho.a(-1, null);
    }
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "conversation onPostThemeChanged refresh because simple theme switch!");
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(10);
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.r();
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "updateLoadingState, showLoadingCircle = " + paramBoolean);
    }
    if (paramBoolean) {
      try
      {
        Drawable localDrawable = a().getResources().getDrawable(2130839447);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(5.0F, a()));
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, localDrawable, null);
        if ((localDrawable instanceof Animatable)) {
          ((Animatable)localDrawable).start();
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("LoadingComplete");
  }
  
  public boolean c()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void d()
  {
    if (SystemClock.uptimeMillis() - vzt.jdField_b_of_type_Long > 500L)
    {
      K();
      if ((this.w) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof HongBaoListView)) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mEnableStory) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mForStory))
      {
        if (this.jdField_a_of_type_Vzt != null) {
          this.jdField_a_of_type_Vzt.h();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.hideMiniAppEntry(-1);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onFrameTabClick|mIsChatList:" + this.jdField_e_of_type_Boolean);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_Akho.a(1);
    boolean bool2 = this.jdField_a_of_type_Akho.a(12);
    if (paramBoolean)
    {
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(4);
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(3);
    }
    if ((bool1) || (bool2))
    {
      c(false);
      return;
    }
    switch (avnc.a().a())
    {
    default: 
      return;
    }
    for (;;)
    {
      c(false);
      return;
      c(true);
      if (this.jdField_c_of_type_MqqOsMqqHandler.hasMessages(4)) {
        break;
      }
      this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(4, 180000L);
      return;
      c(true);
      if (this.jdField_c_of_type_MqqOsMqqHandler.hasMessages(3)) {
        break;
      }
      this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 180000L);
      return;
      c(false);
    }
  }
  
  protected boolean d()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1);
  }
  
  public void e()
  {
    bfzg.a(null, "Recent_OnCreate");
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a(a());
    this.jdField_a_of_type_Adct = new adct(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bfum(Looper.getMainLooper(), this.jdField_a_of_type_Ajdm);
    this.jdField_b_of_type_MqqOsMqqHandler = new bfum(ThreadManager.getRecentThreadLooper(), this);
    this.jdField_a_of_type_Akmc = new akmc(this.jdField_a_of_type_MqqOsMqqHandler, a());
    this.jdField_a_of_type_Adcx = new adcx(this);
    P();
    O();
    a(false);
    this.jdField_a_of_type_Akjw = new akjw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bfzg.a("Recent_OnCreate", null);
  }
  
  public void e(boolean paramBoolean)
  {
    QLog.d("Q.recent", 2, "onResume...");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.C = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isConversationTabShow = true;
    this.jdField_f_of_type_Boolean = true;
    this.x = paramBoolean;
    amvo.jdField_e_of_type_Boolean = true;
    ah();
    super.e(paramBoolean);
    if (AppSetting.jdField_c_of_type_Boolean) {
      a().setTitle(a(2131693564));
    }
    ab();
    TimeManager.getInstance().resumeCountDownTimer();
    if (this.jdField_a_of_type_Aioc != null) {
      this.jdField_a_of_type_Aioc.a();
    }
    if (AppSetting.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setMainActivityState(true);
    }
    try
    {
      a().getWindow().setSoftInputMode(32);
      aowk.a().c();
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_j_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Long != 1000L) {
          this.jdField_a_of_type_Long = 1000L;
        }
        if (!this.k) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
        }
        if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_Akkk != null)) {
          this.jdField_a_of_type_Akkk.notifyDataSetChanged();
        }
        a(0L);
        j();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
        aj();
        ak();
        ao();
        ay();
        ag();
        an();
        al();
        ai();
        f();
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
        a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
        aukx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Akkk, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
        ocw.a().jdField_a_of_type_Boolean = false;
        ac();
        k(paramBoolean);
        ApngImage.playByTag(2);
        af();
        ap();
        ae();
        ad();
        bdai.a(null);
        l(paramBoolean);
        ahrr.a(a(), paramBoolean);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.recent", 1, localException, new Object[0]);
        continue;
        if (!this.A)
        {
          this.A = true;
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1067, 1000L);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1025, 3000L);
      }
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Adcx != null) {
      this.jdField_a_of_type_Adcx.c(paramBoolean);
    }
  }
  
  public void g()
  {
    QLog.d("Q.recent", 2, "onPause...");
    ApngImage.pauseByTag(2);
    super.g();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Ayhx.g();
    if (jdField_b_of_type_Long > 0L)
    {
      jdField_b_of_type_Long = 0L;
      SosoInterface.saveNormalEnterConversationTime(jdField_b_of_type_Long);
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aozm)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((aozm)localObject2).e();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1053);
    this.J = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (AppSetting.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setMainActivityState(false);
    }
    TimeManager.getInstance().pauseCountDownTimer();
    if ((!this.C) && (!this.D) && (akmb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      if (System.currentTimeMillis() - this.jdField_h_of_type_Long > 5000L)
      {
        localObject1 = this.jdField_a_of_type_Akkk.b();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ThreadManager.getSubThreadHandler().post(new Conversation.2(this, (QQAppInterface)localObject2, (List)localObject1));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.t();
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10000);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1070);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
      }
      if (this.jdField_a_of_type_Aklx != null) {
        this.jdField_a_of_type_Aklx.k();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isConversationTabShow = false;
      pay.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_b_of_type_Aufo != null) {
        this.jdField_b_of_type_Aufo.d();
      }
      if (this.jdField_c_of_type_Aufo != null) {
        this.jdField_c_of_type_Aufo.d();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
      bcec.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Vzt != null) {
        this.jdField_a_of_type_Vzt.l();
      }
      ple.k();
      anxs.a();
      if (this.jdField_a_of_type_Adcx == null) {
        break;
      }
      this.jdField_a_of_type_Adcx.e();
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "just switch account, don't save RU");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "enter AIO or switching account, don't save RU");
        }
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Vzt != null) {
        this.jdField_a_of_type_Vzt.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initLater(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
    }
  }
  
  public void h()
  {
    super.h();
    if ((this.jdField_a_of_type_Aklx != null) && (this.jdField_a_of_type_Aklx.a())) {
      this.jdField_a_of_type_Aklx.b();
    }
    if (this.jdField_a_of_type_Aufo != null) {
      this.jdField_a_of_type_Aufo.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aozm localaozm = (aozm)localIterator.next();
        if (localaozm != null) {
          localaozm.f();
        }
      }
    }
    if (this.jdField_a_of_type_Avji != null) {
      this.jdField_a_of_type_Avji.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onStop();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "notifyCallTabChanged, changed=" + paramBoolean);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.jdField_h_of_type_Boolean) || (a() == null) || (a().isFinishing())) {
      return true;
    }
    bjun.a("conv.handleMessage");
    long l1 = System.currentTimeMillis();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      bjun.a();
      return true;
      c(paramMessage, l1);
      continue;
      b(paramMessage, l1);
      continue;
      a(paramMessage, l1);
      continue;
      c(paramMessage);
      continue;
      at();
      continue;
      j(true);
      continue;
      as();
      continue;
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1044, 0, 0, null).sendToTarget();
      continue;
      paramMessage = (vlj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
      paramMessage.a(2, paramMessage.a(akla.a().jdField_a_of_type_JavaUtilList));
      continue;
      ar();
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onDestroy");
    }
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_Akmc != null) {
      this.jdField_a_of_type_Akmc.a();
    }
    if (this.jdField_a_of_type_Bjnw != null)
    {
      this.jdField_a_of_type_Bjnw.a(null);
      this.jdField_a_of_type_Bjnw = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.a(null);
    }
    this.p = false;
    TimeManager.getInstance().stopCountDownTimer();
    aa();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
    if (this.jdField_a_of_type_Adct != null) {
      this.jdField_a_of_type_Adct.a();
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Aioc != null) {
      this.jdField_a_of_type_Aioc.b();
    }
    if (this.jdField_a_of_type_Akkk != null) {
      this.jdField_a_of_type_Akkk.b();
    }
    if (this.jdField_a_of_type_Vzt != null) {
      this.jdField_a_of_type_Vzt.c();
    }
    if (this.jdField_a_of_type_Akho != null) {
      this.jdField_a_of_type_Akho.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_Akou != null) {
      this.jdField_a_of_type_Akou.h();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    try
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      if (localObject != null) {
        ((anuz)localObject).b();
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label241:
      break label241;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_c_of_type_MqqOsMqqHandler != null) {
      this.jdField_c_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    avnu.a();
    avnw.a();
    uda.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aozm localaozm = (aozm)((Iterator)localObject).next();
        if (localaozm != null) {
          localaozm.g();
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Avji != null)
    {
      this.jdField_a_of_type_Avji.f();
      this.jdField_a_of_type_Avji = null;
    }
    if (this.jdField_a_of_type_Bkyu != null)
    {
      this.jdField_a_of_type_Bkyu.b();
      this.jdField_a_of_type_Bkyu = null;
    }
    if (this.jdField_a_of_type_Bkzf != null)
    {
      this.jdField_a_of_type_Bkzf.a();
      this.jdField_a_of_type_Bkzf = null;
    }
    if (this.jdField_e_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_Adcx != null) {
      this.jdField_a_of_type_Adcx.g();
    }
    super.i();
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_Akkk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "refreshRecentHeadView|mChatAdapter is null.");
      }
      return;
    }
    Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(7);
    this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void k()
  {
    aa();
    t();
    if (this.jdField_a_of_type_Akho != null) {
      this.jdField_a_of_type_Akho.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Ayhx != null) {
      this.jdField_a_of_type_Ayhx.c();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aozm localaozm = (aozm)((Iterator)localObject).next();
        if (localaozm != null) {
          localaozm.b();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134065);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134061);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134068);
    bcec.a();
    if (this.jdField_a_of_type_Aklx != null) {
      this.jdField_a_of_type_Aklx.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Akmc != null) {
      this.jdField_a_of_type_Akmc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_Akjw != null) {
      this.jdField_a_of_type_Akjw.a(a());
    }
    if (this.jdField_a_of_type_Avji != null) {
      this.jdField_a_of_type_Avji.d();
    }
    if (this.jdField_a_of_type_Adcx != null) {
      this.jdField_a_of_type_Adcx.c();
    }
    Object localObject = this.jdField_a_of_type_Adcw;
    if (localObject != null) {
      ((adcw)localObject).a();
    }
    if (this.jdField_a_of_type_Akou != null) {
      this.jdField_a_of_type_Akou.a(a());
    }
  }
  
  public void l()
  {
    a(1068, 0L, true);
  }
  
  public void m()
  {
    a(1069, 0L, true);
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1058);
      }
      this.jdField_g_of_type_Boolean = true;
      M();
      d(true);
      boolean bool1 = this.jdField_a_of_type_Akho.a(1);
      boolean bool2 = this.jdField_a_of_type_Akho.a(12);
      if ((bool1) || (bool2)) {
        c(800L);
      }
    }
    else
    {
      return;
    }
    if (bkwm.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      ple.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.c();
    c(60000L);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void o()
  {
    if ((!this.jdField_j_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      D();
      bfzg.a("Recent_Start", null);
    }
    while (!this.jdField_j_of_type_Boolean) {
      return;
    }
    a(1030, 0L, true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      this.jdField_a_of_type_Aklx.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getWidth() - a().getDimensionPixelSize(2131298802) - a().getDimensionPixelSize(2131298803), a().getDimensionPixelSize(2131298804));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity instanceof MainFragment))) {
        ((MainFragment)this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).o();
      }
      if ((alvx.c() <= 0) || (alvx.b() <= 0)) {
        break label333;
      }
    }
    label333:
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = false;
      }
      for (int i2 = 1;; i2 = 0)
      {
        VipUtils.a(alvx.a(), "cmshow", "Apollo", "plusentrance", 0, 0, new String[] { "" + i1, "" + i2 });
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
        xwa.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
        az();
        aafi.e();
        this.C = true;
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if ((paramView == this.jdField_b_of_type_AndroidWidgetImageView) || (paramView == this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch))
          {
            long l1 = System.currentTimeMillis();
            if (Math.abs(l1 - jdField_i_of_type_Long) < 500L) {
              jdField_i_of_type_Long = l1;
            } else {
              jdField_i_of_type_Long = l1;
            }
          }
        }
      }
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null))
    {
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.ag_();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (this.jdField_h_of_type_Int != paramInt1)
    {
      long l1 = SystemClock.elapsedRealtime();
      double d1 = 1000.0D * (1.0D / (l1 - this.jdField_g_of_type_Long));
      if (paramInt1 > this.jdField_h_of_type_Int)
      {
        bool = true;
        this.z = bool;
        this.jdField_h_of_type_Int = paramInt1;
        this.jdField_g_of_type_Long = l1;
        if (QLog.isDebugVersion()) {
          QLog.d("RecentDataListManager", 2, "onScroll:" + d1 + " for Direction:" + this.z);
        }
        if (d1 > 25.0D) {
          break label328;
        }
        aw();
      }
    }
    else
    {
      label117:
      if (paramInt1 + paramInt2 == paramInt3)
      {
        paramInt3 = ((ListView)paramAbsListView).getHeaderViewsCount();
        if (paramInt1 > paramInt3) {
          break label338;
        }
        paramInt3 = paramAbsListView.getChildAt(paramInt3 - paramInt1).getTop();
        paramInt2 = paramAbsListView.getChildAt(paramInt2 - 2).getBottom();
      }
    }
    label328:
    label338:
    for (paramInt2 = Math.max(0, paramInt3 + (paramAbsListView.getHeight() - paramInt2));; paramInt2 = 0)
    {
      paramAbsListView = (AbsListView.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      if ((paramAbsListView != null) && (paramAbsListView.height != paramInt2))
      {
        paramAbsListView.height = paramInt2;
        this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramAbsListView);
      }
      if (paramInt1 == 0)
      {
        this.I = false;
        this.jdField_j_of_type_Long = -1L;
      }
      if ((this.I) && (SystemClock.elapsedRealtime() - this.jdField_j_of_type_Long > 800L))
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
        if (QLog.isColorLevel()) {
          QLog.d("Conversation", 2, "onScroll cost time is below 1000 ms, isScroll2TopFlag: " + this.I + ", startScrollTime: " + this.jdField_j_of_type_Long);
        }
        this.I = false;
        this.jdField_j_of_type_Long = -1L;
      }
      return;
      bool = false;
      break;
      anhl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label117;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Conversation", 2, "onScrollStateChanged:" + paramInt);
    }
    if ((paramAbsListView instanceof ARMapHongBaoListView)) {
      ((ARMapHongBaoListView)paramAbsListView).setScrollState(paramInt);
    }
    int i1;
    label162:
    Object localObject;
    if (paramInt != 0)
    {
      this.G = true;
      ApngImage.pauseByTag(2);
      this.jdField_a_of_type_Int = paramInt;
      if (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
        break label319;
      }
      if (this.jdField_a_of_type_Vzt != null) {
        this.jdField_a_of_type_Vzt.b(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1)) {
        break label419;
      }
      if (this.jdField_a_of_type_Akkk == null) {
        break label254;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i4 = this.jdField_a_of_type_Akkk.getCount();
      this.jdField_b_of_type_Int = Math.max(i1, -1);
      if ((i1 < 0) || (i1 >= i4) || (i1 > i2 - i3)) {
        break label242;
      }
      localObject = this.jdField_a_of_type_Akkk.getItem(i1);
      if ((localObject instanceof RecentBaseData)) {
        break label214;
      }
    }
    label214:
    do
    {
      i1 += 1;
      break label162;
      this.G = false;
      break;
      localObject = (RecentBaseData)localObject;
    } while ((!((RecentBaseData)localObject).isUnreadMsgNumInTabNum()) || (((RecentBaseData)localObject).getUnreadNum() <= 0));
    this.jdField_b_of_type_Int = i1;
    label242:
    this.jdField_a_of_type_Akkk.a(false);
    bfta.a(false);
    label254:
    if (paramInt == 0)
    {
      aw();
      DropFrameMonitor.getInstance().stopMonitorScene("list_conv", false);
      ThreadRegulator.a().b(2);
      a(paramAbsListView);
      aukx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Akkk, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      m(false);
      aq();
      aA();
      v();
    }
    for (;;)
    {
      label319:
      if ((!this.G) && (this.H))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Conversation", 2, "onScrollStateChanged call with msg incoming");
        }
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(10);
        this.H = false;
      }
      if (paramInt == 0)
      {
        if (this.jdField_i_of_type_Boolean) {
          a(100L);
        }
        ApngImage.playByTag(2);
      }
      if (this.jdField_a_of_type_Akho != null) {
        this.jdField_a_of_type_Akho.b(this.G);
      }
      plq.a(paramAbsListView, paramInt);
      anxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAbsListView, paramInt);
      return;
      label419:
      if (this.jdField_a_of_type_Akkk == null) {
        break;
      }
      this.jdField_a_of_type_Akkk.a(true);
      bfta.a(true);
      break;
      DropFrameMonitor.getInstance().startMonitorScene("list_conv");
      ThreadRegulator.a().a(2);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onViewCompleteVisableAndReleased %s", new Object[] { Boolean.valueOf(this.jdField_g_of_type_Boolean) }));
    }
    return a(paramListView);
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void p()
  {
    this.jdField_f_of_type_Boolean = true;
    if (SetSplash.c())
    {
      a(new Conversation.15(this));
      return;
    }
    o();
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_Adcx != null) {
      this.jdField_a_of_type_Adcx.b(false);
    }
    adcw localadcw = this.jdField_a_of_type_Adcw;
    if (localadcw != null) {
      localadcw.b(false);
    }
  }
  
  public void r()
  {
    long l1 = 0L;
    try
    {
      if (!this.l)
      {
        boolean bool = this.jdField_h_of_type_Boolean;
        if (!bool) {
          break label23;
        }
      }
    }
    finally
    {
      try
      {
        label23:
        BaseActivity localBaseActivity;
        LayoutInflater localLayoutInflater;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559654, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        if (this.jdField_a_of_type_Aklx == null)
        {
          this.jdField_a_of_type_Aklx = new aklx(localBaseActivity);
          this.jdField_a_of_type_Aklx.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new ajbt(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_Bgre = ((bgre)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76));
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label350;
        }
      }
      localObject1 = finally;
    }
    return;
    this.l = true;
    localBaseActivity = a();
    localLayoutInflater = LayoutInflater.from(localBaseActivity);
    Object localObject2 = "in main thread ";
    label208:
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, (String)localObject2 + localException2.toString());
    }
    for (;;)
    {
      try
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("device_mode", DeviceInfoUtil.getDeviceModel());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label378;
        }
        localStatisticCollector.collectPerformance(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
      }
      catch (Exception localException1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent", 2, localException1.toString());
      break;
      label350:
      String str1 = "not in main thread ";
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = null;
      this.jdField_a_of_type_Aklx = null;
      this.l = false;
      break label208;
      label378:
      l1 = 1L;
    }
  }
  
  void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_j_of_type_Boolean)) {}
    label124:
    for (;;)
    {
      return;
      if (((ofx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).b())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Akkk != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
            if (!(this.jdField_a_of_type_Akkk.getItem(i1) instanceof RecentItemEcShopAssitant)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!ocw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (this.jdField_b_of_type_Aufo == null)) {
            break label124;
          }
          this.jdField_b_of_type_Aufo.a();
          return;
          i1 += 1;
          break;
        }
      }
    }
  }
  
  void t()
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void u()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
          int i2 = azjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
          if (localQQMessageFacade != null) {
            i1 = localQQMessageFacade.getUnreadMsgsNum();
          }
          this.jdField_d_of_type_Int = (i1 + i2);
          if (QLog.isColorLevel())
          {
            QLog.d("fetchUnReadCount", 2, String.format("Conversation, mUnReadCount[%s], msgUnReadCount[%s], callUnReadCount[%s], isCallTabShow[%s]", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(i1), Integer.valueOf(i2), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallTabShow) }));
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    d(paramObject);
    c(paramObject);
    b(paramObject);
    a(paramObject);
    b(paramObservable, paramObject);
    a(paramObservable, paramObject);
  }
  
  void v()
  {
    if ((this.p) && (((amvo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).b("sp_mayknow_ml_s_a_vl")) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.isShown()) && (!this.jdField_a_of_type_Akkk.isEmpty()))
    {
      int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
      int i5 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i4;
      for (int i1 = -1; i3 <= i5; i1 = i4)
      {
        i4 = i1;
        if (i3 >= 0)
        {
          i4 = i1;
          if (i3 < this.jdField_a_of_type_Akkk.getCount())
          {
            i4 = i1;
            if (this.jdField_a_of_type_Akkk.getItem(i3) != null)
            {
              Object localObject = this.jdField_a_of_type_Akkk.getItem(i3);
              i4 = i1;
              if ((localObject instanceof RecentItemMayKnowFriendVerticalListData))
              {
                int i2 = i1;
                if (i1 < 0) {
                  i2 = a();
                }
                localObject = ((RecentItemMayKnowFriendVerticalListData)localObject).a();
                i4 = i2;
                if ((((RecentUser)localObject).extraInfo instanceof MayKnowRecommend))
                {
                  localObject = (MayKnowRecommend)((RecentUser)localObject).extraInfo;
                  localArrayList1.add(((MayKnowRecommend)localObject).uin);
                  localArrayList2.add(((MayKnowRecommend)localObject).recommendReason);
                  localArrayList3.add(Integer.valueOf(i3 - i2));
                  localArrayList4.add(((MayKnowRecommend)localObject).algBuffer);
                  i4 = i2;
                }
              }
            }
          }
        }
        i3 += 1;
      }
      if (!localArrayList1.isEmpty()) {
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 25, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 2, null);
      }
    }
  }
  
  public void w()
  {
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, 1, 2130838892, "-conversation-");
  }
  
  public void x()
  {
    Object localObject = a();
    if (this.jdField_e_of_type_Boolean)
    {
      if (localObject == null) {}
      while (this.jdField_a_of_type_Akou == null) {
        return;
      }
      boolean bool = this.jdField_a_of_type_Akou.a((akkk)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "moveToCaredItemCyclic: invoked.  canFindUnreadItem: " + bool + " currentCaredType:" + this.jdField_f_of_type_Int + " currentUnreadCaredItemIndex: " + this.jdField_g_of_type_Int);
      }
      int i1 = (int)(a().getResources().getDimension(2131298795) + a().getResources().getDimension(2131298812) / 2.0F);
      int i2 = this.jdField_g_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      if (this.jdField_g_of_type_Int == 0) {
        i1 = 0;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "moveToCaredItemCyclic: invoked. selection1 ", " position: ", Integer.valueOf(i2) });
        }
        this.jdField_a_of_type_Akou.c();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(i2, i1);
        localObject = new Conversation.58(this, i2);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed((Runnable)localObject, 250L);
      }
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1E3", "0X800A1E3", 0, 0, "", "", "", "");
  }
  
  void z()
  {
    if (this.jdField_a_of_type_Bjnw == null)
    {
      this.jdField_a_of_type_Bjnw = bjnw.a(a());
      this.jdField_a_of_type_Bjnw.b(2131691144);
      this.jdField_a_of_type_Bjnw.c(2131690620);
      this.jdField_a_of_type_Bjnw.a(new ajcy(this));
    }
    this.jdField_a_of_type_Bjnw.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation
 * JD-Core Version:    0.7.0.1
 */