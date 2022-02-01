package com.tencent.mobileqq.activity;

import abiz;
import adab;
import adlb;
import aehs;
import aeht;
import aehu;
import aehv;
import aehw;
import aehx;
import aehy;
import aehz;
import aeia;
import aeib;
import aeic;
import aeid;
import aeie;
import aeif;
import aeig;
import aeih;
import aeii;
import aeij;
import aeik;
import aeil;
import aeim;
import aein;
import aeio;
import aeip;
import aeiq;
import aeir;
import aeis;
import aeit;
import aeiu;
import aeiv;
import aeiw;
import aeiz;
import aejb;
import aejc;
import aejd;
import aeje;
import aejf;
import aejg;
import aejh;
import aeji;
import aejj;
import aejk;
import aejl;
import aejm;
import aejn;
import aejq;
import aejr;
import aejv;
import aejy;
import aejz;
import afjb;
import agej;
import aggr;
import aixg;
import ajtf;
import akgx;
import aljw;
import almc;
import alme;
import alml;
import alms;
import almz;
import alni;
import alno;
import alof;
import alok;
import alol;
import aloy;
import alpa;
import alpb;
import alrd;
import amjp;
import anbd;
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
import antf;
import antz;
import anua;
import anuw;
import anvl;
import anvn;
import anwb;
import anwt;
import anxr;
import anyh;
import anyu;
import anyw;
import anzj;
import anzm;
import aoaa;
import aobl;
import aocj;
import aody;
import aoex;
import aogi;
import aogl;
import aohk;
import aohy;
import aoib;
import aojs;
import aoka;
import aonz;
import aorc;
import aori;
import apaw;
import apec;
import apeg;
import apen;
import aqcz;
import aqgb;
import arfd;
import asvt;
import atag;
import atpa;
import atur;
import audx;
import avsm;
import avxv;
import avxx;
import avxz;
import awaa;
import awwb;
import awzv;
import axan;
import axap;
import axug;
import ayxl;
import azie;
import azti;
import banv;
import banw;
import baou;
import bbav;
import bbba;
import bdgb;
import bdli;
import bdll;
import bdlq;
import bdmc;
import bdow;
import bdup;
import bduy;
import bduz;
import bdwt;
import becb;
import behm;
import berp;
import berv;
import besa;
import bese;
import beth;
import betv;
import beyb;
import bgts;
import bgul;
import bguq;
import bgut;
import bhed;
import bhih;
import bhiu;
import bhjs;
import bhjx;
import bhlg;
import bhlj;
import bhlo;
import bhlq;
import bhnv;
import bhnx;
import bhoq;
import bhse;
import bhsi;
import bhsq;
import bhsr;
import biku;
import bikv;
import bjbs;
import blha;
import blhf;
import blhw;
import blih;
import blir;
import blnt;
import blpp;
import blqm;
import bmim;
import bnrf;
import bntn;
import bnty;
import bnua;
import bnwq;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.mini.entry.MiniAppDesktop;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTipsDialog;
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
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import lnc;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import mvd;
import mve;
import nqw;
import nqx;
import nwf;
import nwo;
import nwy;
import obj;
import ocd;
import oek;
import org.json.JSONException;
import org.json.JSONObject;
import ozs;
import pfs;
import pge;
import tug;
import twk;
import tyi;
import vjo;
import wjd;
import wjk;
import wvs;
import wwg;
import wwh;
import wyd;
import yup;

public class Conversation
  extends anxr
  implements alml, almz, Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, antf, anyh, bhed, blih, blnt, blpp, Observer
{
  public static long b;
  private static long jdField_j_of_type_Long;
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
  private aejk jdField_a_of_type_Aejk;
  aejl jdField_a_of_type_Aejl = new aejl(this);
  private aejq jdField_a_of_type_Aejq;
  protected aejr a;
  aejv jdField_a_of_type_Aejv = null;
  public aejy a;
  public aejz a;
  afjb jdField_a_of_type_Afjb = new aeir(this);
  ajtf jdField_a_of_type_Ajtf;
  public aljw a;
  private alme jdField_a_of_type_Alme;
  public alms a;
  public alof a;
  private alol jdField_a_of_type_Alol;
  alpa jdField_a_of_type_Alpa;
  public alrd a;
  public Dialog a;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aeis(this);
  public GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  protected anua a;
  anuw jdField_a_of_type_Anuw = new aeih(this);
  private final anvn jdField_a_of_type_Anvn = new aeie(this);
  private final anwb jdField_a_of_type_Anwb = new aeil(this);
  anwt jdField_a_of_type_Anwt = new aeij(this);
  private final anyu jdField_a_of_type_Anyu = new aeib(this);
  private aoaa jdField_a_of_type_Aoaa = new aeiv(this);
  private final aocj jdField_a_of_type_Aocj = new aeig(this);
  private aogi jdField_a_of_type_Aogi = new aejn(this);
  private aogl jdField_a_of_type_Aogl = new aeiq(this);
  private aohk jdField_a_of_type_Aohk = new aeiw(this);
  aohy jdField_a_of_type_Aohy = new aeii(this);
  private final aoib jdField_a_of_type_Aoib = new aeim(this);
  private final aojs jdField_a_of_type_Aojs = new aeic(this);
  aoka jdField_a_of_type_Aoka = new aeif(this);
  private apec jdField_a_of_type_Apec = new aejj(this);
  private asvt jdField_a_of_type_Asvt = new aejg(this);
  private atpa jdField_a_of_type_Atpa;
  private avsm jdField_a_of_type_Avsm = new avsm("tool_adMessage", "com.tencent.mobileqq:tool");
  public awwb a;
  private final ayxl jdField_a_of_type_Ayxl = new aeio(this);
  private azie jdField_a_of_type_Azie = new aejc(this);
  public azti a;
  private bduz jdField_a_of_type_Bduz = new aejh(this);
  bikv jdField_a_of_type_Bikv = null;
  private bjbs jdField_a_of_type_Bjbs;
  public blir a;
  private bntn jdField_a_of_type_Bntn;
  private bnty jdField_a_of_type_Bnty;
  private QCircleObserver jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver = new aejm(this);
  private Conversation.DateFormatChangeRunnable jdField_a_of_type_ComTencentMobileqqActivityConversation$DateFormatChangeRunnable = new Conversation.DateFormatChangeRunnable(this, null);
  public QQSettingMe a;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  public FrameHelperActivity a;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private MiniAppPullInterface jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
  public RedTouch a;
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog;
  public PullRefreshHeader a;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public Runnable a;
  public String a;
  protected StringBuilder a;
  public ArrayList<aqgb> a;
  public List<RecentBaseData> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final lnc jdField_a_of_type_Lnc = new aein(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aejb(this);
  public MqqHandler a;
  private final wjd jdField_a_of_type_Wjd = new aeip(this);
  public wyd a;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  Dialog jdField_b_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new aeit(this);
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private avsm jdField_b_of_type_Avsm = new avsm("tool_shop", "com.tencent.mobileqq:tool");
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  protected Runnable b;
  private String jdField_b_of_type_JavaLangString;
  final List<String> jdField_b_of_type_JavaUtilList = new ArrayList(40);
  public MqqHandler b;
  public boolean b;
  int jdField_c_of_type_Int;
  public long c;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new aeiu(this);
  View jdField_c_of_type_AndroidViewView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private avsm jdField_c_of_type_Avsm = new avsm("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private Runnable jdField_c_of_type_JavaLangRunnable;
  MqqHandler jdField_c_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this.jdField_a_of_type_Aejl);
  public boolean c;
  public int d;
  long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private Runnable jdField_d_of_type_JavaLangRunnable = new Conversation.3(this);
  public boolean d;
  int jdField_e_of_type_Int = 3;
  public long e;
  private View jdField_e_of_type_AndroidViewView;
  private Runnable jdField_e_of_type_JavaLangRunnable = new Conversation.23(this);
  protected boolean e;
  public volatile int f;
  long f;
  public boolean f;
  public volatile int g;
  public boolean g;
  private int jdField_h_of_type_Int;
  private long jdField_h_of_type_Long;
  public boolean h;
  private long jdField_i_of_type_Long;
  boolean jdField_i_of_type_Boolean = false;
  boolean jdField_j_of_type_Boolean = false;
  private long jdField_k_of_type_Long = -1L;
  boolean jdField_k_of_type_Boolean = false;
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
    this.jdField_a_of_type_Aejz = null;
    this.jdField_f_of_type_Int = 17;
    this.jdField_a_of_type_Aejr = new aejr(this, null);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new Conversation.28(this);
    this.jdField_a_of_type_Anua = new aeid(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(BaseApplicationImpl.getContext(), new aeje(this));
    this.jdField_b_of_type_JavaLangRunnable = new Conversation.61(this);
  }
  
  private void C()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Alms.c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1025);
    this.jdField_j_of_type_Boolean = true;
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    BaseApplicationImpl.sApplication.onActivityFocusChanged(a(), true);
  }
  
  private void D()
  {
    aori.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void E()
  {
    bhiu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
  }
  
  private void F()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof ARMapHongBaoListView)))
    {
      if (this.jdField_a_of_type_Bntn == null) {
        this.jdField_a_of_type_Bntn = new bntn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, (ARMapHongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      }
      this.jdField_a_of_type_Bntn.a();
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_Bnty == null) {
      this.jdField_a_of_type_Bnty = new bnty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Bnty.a();
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
      this.jdField_k_of_type_Long = SystemClock.elapsedRealtime();
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Alms != null)) {}
    }
    else
    {
      return;
    }
    int i3 = this.jdField_a_of_type_Alms.getCount();
    int i1 = this.jdField_b_of_type_Int + 1;
    label96:
    int i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Object localObject = this.jdField_a_of_type_Alms.getItem(i1);
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
    if ((this.jdField_a_of_type_Alms != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (TimeManager.getInstance().setDateFormat(str)) {
        this.jdField_f_of_type_Long = l1;
      }
    }
  }
  
  private void M()
  {
    if (awzv.a().b()) {
      awzv.a().a(3);
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
        if ((!anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.F))
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
      anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i1 = anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      anvl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1 + 1);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void O()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
  }
  
  private void P()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131365049));
    this.jdField_a_of_type_Aejk = new aejk(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_Aejk, false);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.p = false;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376925));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379037));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365112));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377988));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379648));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379656));
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
      bdgb.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370065);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376259));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDescendantInvalidatedFlags(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(a().getDrawable(2130839405));
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
              localObject2 = ((AppActivity)localObject3).getLayoutInflater().inflate(2131562855, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
            }
          }
          if (localObject2 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject2, 0);
            this.jdField_a_of_type_Ajtf = new ajtf(a(), 1, (View)localObject2);
            this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
          }
          this.jdField_a_of_type_Aljw = new aljw(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          localObject1 = a();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
          if (!alni.a().jdField_a_of_type_Boolean)
          {
            bool = true;
            this.jdField_a_of_type_Alms = new alms((Context)localObject1, (QQAppInterface)localObject2, (XListView)localObject3, this, 0, bool);
            this.jdField_a_of_type_Alms.b(true);
            this.jdField_a_of_type_Alms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Alms);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
            this.jdField_a_of_type_Alms.a(this);
            this.jdField_c_of_type_AndroidViewView = new View(a());
            localObject1 = new AbsListView.LayoutParams(-1, 0);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView, null, false);
            if ((TextUtils.isEmpty(alni.a().jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(alni.a().jdField_a_of_type_JavaLangString))) {
              break label900;
            }
            localObject1 = new ArrayList(16);
            QLog.d("Q.recent", 1, "ignore PreLoadList");
            this.jdField_a_of_type_Alms.a((List)localObject1);
            this.jdField_a_of_type_Alms.a(0);
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.q();
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
            this.jdField_a_of_type_Azti = new azti(this, this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_a_of_type_Awwb = new awwb(this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131365120));
            IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
            a("initUI");
            localObject1 = banv.a;
            if ((localObject1 != null) && (bnua.a(((banw)localObject1).l)) && (!TextUtils.isEmpty(bnua.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())))) {
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1062);
            }
            return;
            a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
            a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850099);
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166987));
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166987));
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
            List localList = alni.a().jdField_b_of_type_JavaUtilList;
            continue;
            localList = null;
          }
        }
      }
    }
  }
  
  private void Q()
  {
    int i1 = agej.a(10.0F, a());
    agej.a(this.jdField_a_of_type_AndroidWidgetTextView, i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new mve());
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aehw(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(new aehx(this));
  }
  
  private void R()
  {
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
  
  private void S()
  {
    Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if ((localManager instanceof bbav))
    {
      int i1 = ((bbav)localManager).a("104000.104001", 100);
      if (i1 > 0) {
        a(8, antf.aB, 7230);
      }
      QLog.d("Q.recent", 2, "uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "getSubscribeAccountRedDotNum  redNumByPath:" + i1);
    }
  }
  
  private void T()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "initMiniAppEntryLayout.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface == null)
    {
      if (arfd.c()) {
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
        if (!this.jdField_k_of_type_Boolean)
        {
          boolean bool = this.jdField_h_of_type_Boolean;
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.jdField_k_of_type_Boolean = true;
        if (!this.l) {
          q();
        }
        v();
        if ((!this.m) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())) {
          c(2);
        }
        if (this.jdField_a_of_type_Aejz != null) {
          this.jdField_a_of_type_Aejz.a();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aehz(this));
        this.jdField_a_of_type_Alrd = new alrd(this, this.jdField_a_of_type_AndroidViewViewGroup);
        W();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
        V();
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())
        {
          a(this.jdField_a_of_type_MqqOsMqqHandler, a());
          a(1055, 0L, false);
          if (QLog.isColorLevel())
          {
            QLog.d("Q.recent", 2, new Object[] { "initUiLater() will send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()) });
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
        QLog.d("Q.recent", 2, new Object[] { "initUiLater() will not send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()) });
      }
    }
  }
  
  private void V()
  {
    if ((this.jdField_a_of_type_Aljw != null) && (this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_Aljw.j();
    }
    if (this.jdField_a_of_type_Aljw != null) {
      this.jdField_a_of_type_Aljw.a(false);
    }
    a(1010, 5000L, false);
    a(1064, 5000L, true, "qboss_banner_login");
    a(1023, 0L, false);
    a(1076, 1000L, false);
  }
  
  private void W()
  {
    long l1 = System.currentTimeMillis();
    if (arfd.a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559652, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
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
      this.jdField_b_of_type_JavaLangString = apen.a().a();
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367595));
        GLSurfaceView localGLSurfaceView = new GLSurfaceView(a());
        localGLSurfaceView.setRenderer(new aeia(this));
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
    N();
    bbba.a(this);
    if (!this.jdField_e_of_type_Boolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2);
    }
    Z();
    ((bdup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(361)).a(a());
  }
  
  private void Z()
  {
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == -1) {
      QQToast.a(a(), 2, a(2131719024), 0).b(a().getTitleBarHeight());
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((-1 == paramInt) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        bguq.a(a(), paramIntent, true);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean, String paramString, apaw paramapaw)
  {
    int i2 = a(paramRecentBaseData.getRecentUserUin(), paramInt);
    paramRecentBaseData = paramapaw.getRecentList(false).iterator();
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, paramString, String.valueOf(i1), String.valueOf(i2), "");
      if (paramInt == 7220)
      {
        if (paramBoolean) {
          ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
        }
      }
      else {
        return;
      }
      ocd.a(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
      return;
    }
  }
  
  private void a(int paramInt, List<RecentBaseData> paramList)
  {
    if ((-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a()) || ((this.G) && (this.H)))
    {
      this.jdField_a_of_type_Aejk.a(paramInt, paramList);
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
    else if (this.jdField_a_of_type_Alms != null)
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_d_of_type_Int);
      a(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      if (this.y)
      {
        this.y = false;
        aq();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
      ap();
      apeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, 0);
      nqw.a.c();
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
    a(9003, 400L, true);
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
        aehs localaehs = new aehs(this);
        aeht localaeht = new aeht(this, localUpgradeTIMWrapper);
        if (TextUtils.isEmpty(localUpgradeTIMWrapper.d))
        {
          paramMessage = anzj.a(2131701498);
          if (!TextUtils.isEmpty(localUpgradeTIMWrapper.e)) {
            break label323;
          }
          str = anzj.a(2131701508);
          this.jdField_c_of_type_AndroidAppDialog = bhlq.a(a(), localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString, localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString, paramMessage, str, null, localaeht, localaehs);
          this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new aehu(this));
          if ((!this.w) || (this.jdField_c_of_type_AndroidAppDialog.isShowing()) || ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.isShowing())) || (anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            continue;
          }
          this.jdField_c_of_type_AndroidAppDialog.show();
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
          anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      paramMessage = alni.a().jdField_a_of_type_JavaUtilList;
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
          String str = alni.a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          if ((this.jdField_b_of_type_JavaUtilList.contains(str)) || (this.jdField_b_of_type_JavaUtilList.contains(alni.a(localRecentBaseData.getRecentUserUin(), -2147483648))))
          {
            localRecentBaseData.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
            ((List)localObject).add(localRecentBaseData);
          }
        }
      }
      t();
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
      bdmc.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - paramLong, paramMessage.size(), (HashMap)localObject, "");
      bhsq.a("Conversation_Refresh_items", System.currentTimeMillis() - paramLong);
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + paramLong + "," + (System.currentTimeMillis() - paramLong) + "]");
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, int paramInt)
  {
    blhf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, paramRecentBaseData);
    apeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData);
    if ((paramRecentUser != null) && (paramRecentUser.lFlag == 16L) && (paramInt == 0) && (this.jdField_a_of_type_Avsm != null))
    {
      this.jdField_a_of_type_Avsm.b();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "ad preload tool process hit");
      }
    }
    if ((paramRecentUser != null) && (String.valueOf(9970L).equals(paramRecentUser.uin)) && (this.jdField_b_of_type_Avsm != null)) {
      this.jdField_b_of_type_Avsm.b();
    }
    if ((paramRecentUser != null) && (paramRecentUser.getType() == 6004) && (this.jdField_c_of_type_Avsm != null)) {
      this.jdField_c_of_type_Avsm.b();
    }
    if (paramRecentUser != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
      paramRecentBaseData.setFeedInfoRead(paramRecentUser.uin);
      if (!FeedsManager.isShowStatus(paramRecentUser.uin)) {
        break label217;
      }
      aggr localaggr = (aggr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
      if (localaggr != null)
      {
        long l1 = localaggr.a(paramRecentUser.uin);
        FeedsManager.saveToken(paramRecentUser.uin, l1);
        paramRecentBaseData.reportClickExpose();
        localaggr.a(2, 2);
      }
    }
    label217:
    do
    {
      do
      {
        return;
        paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramRecentUser.uin, paramRecentUser.getType());
      } while ((paramRecentBaseData == null) || (paramRecentBaseData.msgtype != -1034));
      paramRecentBaseData = (aggr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
    } while (paramRecentBaseData == null);
    paramRecentBaseData.a(2, 1);
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString1, boolean paramBoolean, String paramString2)
  {
    if (this.jdField_a_of_type_Alpa != null) {
      this.jdField_a_of_type_Alpa.a(paramRecentBaseData, paramBoolean);
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", paramString2, paramString1, "");
  }
  
  private void a(AbsListView paramAbsListView)
  {
    int i1;
    if ((paramAbsListView != null) && (this.jdField_a_of_type_Alms != null))
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
          localObject1 = this.jdField_a_of_type_Alms.getItem(i2);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemPublicAccountADFolderData))) {
            break label226;
          }
          localObject1 = (RecentItemPublicAccountADFolderData)localObject1;
          if (!avxz.a(paramAbsListView.getChildAt(i2 - i1))) {
            break label226;
          }
          localObject1 = nwo.a().a(((RecentItemPublicAccountADFolderData)localObject1).mUser.uin);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Message localMessage = Message.obtain();
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("key_app", new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        ((HashMap)localObject2).put("key_adapter", new WeakReference(this.jdField_a_of_type_Alms));
        ((HashMap)localObject2).put("key_listview", new WeakReference(paramAbsListView));
        localMessage.obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_ad_id", ((nwf)localObject1).c);
        localMessage.setData((Bundle)localObject2);
        localMessage.what = 1;
        avxv.a().a(localMessage);
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
    ThreadManager.getSubThreadHandler().post(new Conversation.17(this, paramString));
  }
  
  private void a(String paramString1, @NonNull String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    a(new Conversation.18(this, paramString2, paramString1));
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    if (((paramObservable instanceof bbav)) && ((paramObject instanceof BusinessInfoCheckUpdate.AppInfo)))
    {
      paramObservable = bbba.a((BusinessInfoCheckUpdate.AppInfo)paramObject);
      if ((paramObservable != null) && (paramObservable.size() > 0))
      {
        paramObservable = (bbba)paramObservable.get(0);
        if ((paramObservable.jdField_a_of_type_Int >= 1) && (paramObservable.jdField_a_of_type_Int <= 4)) {
          bbba.b(this);
        }
      }
    }
  }
  
  public static void a(MqqHandler paramMqqHandler, Context paramContext)
  {
    paramMqqHandler.removeMessages(1134065);
    if (FriendsStatusUtil.a(paramContext))
    {
      bdll.b(null, "CliOper", "", "", "0X8009EB9", "0X8009EB9", 0, 1, "", "", "", "");
      Message localMessage = paramMqqHandler.obtainMessage(1134065);
      localMessage.arg1 = 2;
      paramMqqHandler.sendMessage(localMessage);
      long l1 = FriendsStatusUtil.a(paramContext);
      if (l1 > 0L) {
        paramMqqHandler.postDelayed(new Conversation.37(paramMqqHandler), l1 * 1000L);
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
      bdll.b(localQQAppInterface, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i1, "0", "0", "", "");
      if (bhnv.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
        break;
      }
      QQToast.a(a(), 1, 2131695458, 0).b(a().getTitleBarHeight());
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
      x();
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
      ((aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.getRecentUserUin());
      return true;
    }
    return false;
  }
  
  private boolean a(RecentBaseData paramRecentBaseData, boolean paramBoolean, apaw paramapaw, String paramString)
  {
    int i1 = paramRecentBaseData.getRecentUserType();
    if ((paramString == null) || (paramString.length() == 0) || (paramapaw == null))
    {
      if (QLog.isColorLevel())
      {
        paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
        if (paramString != null) {
          break label85;
        }
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (paramapaw != null) {
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
    RecentUser localRecentUser = (RecentUser)paramapaw.findRecentUser(paramString, i1);
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
        paramapaw.saveRecentUser(localRecentUser);
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
        paramapaw = paramapaw.getRecentList(false).iterator();
        i1 = 0;
        if (paramapaw.hasNext())
        {
          if (((RecentUser)paramapaw.next()).showUpTime == 0L) {
            break label606;
          }
          i1 += 1;
        }
        for (;;)
        {
          break label218;
          localRecentUser.showUpTime = 0L;
          break;
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + i2, paramRecentBaseData, paramRecentBaseData, 0, 0, "" + i3, "" + i1, "", "");
          do
          {
            if ((7220 == localRecentUser.getType()) && (antf.aA.equals(paramString))) {
              ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).c(paramBoolean);
            }
            return false;
          } while (i1 != 1008);
          i2 = paramRecentBaseData.mUnreadNum;
          paramRecentBaseData = "0X80064C8";
          if (paramBoolean) {
            paramRecentBaseData = "0X80064C7";
          }
          paramapaw = paramapaw.getRecentList(false).iterator();
          i1 = 0;
          if (paramapaw.hasNext())
          {
            if (((RecentUser)paramapaw.next()).showUpTime == 0L) {
              break label603;
            }
            i1 += 1;
          }
          for (;;)
          {
            break label429;
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", localRecentUser.uin, paramRecentBaseData, paramRecentBaseData, 0, 0, "" + i2, "" + i1, "", "");
            if (!"2290230341".equals(paramString)) {
              break;
            }
            if (paramBoolean) {}
            for (paramRecentBaseData = "0X80090E6";; paramRecentBaseData = "0X800915B")
            {
              if (paramBoolean) {
                bdli.a(4);
              }
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramRecentBaseData, paramRecentBaseData, 0, 0, "", "", "", "");
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
    while (!this.jdField_a_of_type_Aljw.b(22)) {
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
      ThreadManager.post(new Conversation.54(this, this.jdField_a_of_type_Aljw.a(22, 2131362236)), 5, null, false);
      return;
    }
  }
  
  private void aB()
  {
    try
    {
      if (this.jdField_a_of_type_Bjbs == null)
      {
        this.jdField_a_of_type_Bjbs = new bjbs(a(), a().getTitleBarHeight());
        this.jdField_a_of_type_Bjbs.c(2131694168);
        this.jdField_a_of_type_Bjbs.c(false);
        this.jdField_a_of_type_Bjbs.setOnDismissListener(new aejf(this));
      }
      this.jdField_a_of_type_Bjbs.show();
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
      if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anua);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvn);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoka);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anwt);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoib);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anwb);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoaa);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Wjd);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayxl);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogl);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aohk);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Azie);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asvt);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aohy);
        bduy.b(this.jdField_a_of_type_Bduz);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Lnc);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
        }
        if (this.jdField_a_of_type_Atpa != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Afjb);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogi);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Apec);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver);
        localObject1 = (baou)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject1 != null) {
          ((baou)localObject1).deleteObserver(this);
        }
        localObject1 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (localObject1 != null) {
          ((bbav)localObject1).deleteObserver(this);
        }
        if (this.jdField_a_of_type_Awwb != null) {
          this.jdField_a_of_type_Awwb.c();
        }
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(17);
      try
      {
        localObject1 = a();
        if (this.jdField_a_of_type_Aejq != null)
        {
          berp.b(this.jdField_a_of_type_Aejq);
          this.jdField_a_of_type_Aejq.a();
          this.jdField_a_of_type_Aejq = null;
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
    if (this.jdField_a_of_type_Awwb != null) {
      this.jdField_a_of_type_Awwb.a();
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
    if (this.jdField_a_of_type_Alrd != null) {
      this.jdField_a_of_type_Alrd.d();
    }
  }
  
  private void af()
  {
    if (this.jdField_a_of_type_Wyd != null) {
      this.jdField_a_of_type_Wyd.k();
    }
  }
  
  private void ag()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent = null;
    }
  }
  
  private void ah()
  {
    if ((jdField_b_of_type_Long == -1L) && (SplashActivity.jdField_a_of_type_Boolean))
    {
      jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      SosoInterface.a(jdField_b_of_type_Long);
    }
  }
  
  private void ai()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new Conversation.24(this), 500L);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1070, 3000L);
    ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    ozs.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    am();
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1053)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1053, 500L);
    }
    alol.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void aj()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (FrameHelperActivity.b())
      {
        FrameHelperActivity.c(true);
        FrameHelperActivity.s();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void ak()
  {
    Object localObject = this.jdField_a_of_type_Bikv;
    if (localObject != null)
    {
      biku localbiku = ((bikv)localObject).a();
      if (localbiku != null)
      {
        a((bikv)localObject, localbiku);
        if (a((bikv)localObject, localbiku))
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
        aqgb localaqgb = (aqgb)localIterator.next();
        if (localaqgb != null) {
          if (this.v)
          {
            localaqgb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
            localaqgb.jdField_c_of_type_Boolean = true;
            localaqgb.c();
          }
          else
          {
            localaqgb.d();
          }
        }
      }
      this.v = false;
    }
  }
  
  private void am()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null) {
      this.jdField_c_of_type_JavaLangRunnable = new Conversation.25(this);
    }
    ThreadManagerV2.excute(this.jdField_c_of_type_JavaLangRunnable, 32, null, true);
  }
  
  private void an()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (FrameHelperActivity.b()) {
        FrameHelperActivity.s();
      }
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Azti.jdField_d_of_type_Int != -1) && (this.jdField_a_of_type_Azti.jdField_d_of_type_Int != 1))
      {
        this.jdField_a_of_type_Azti.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
        this.jdField_a_of_type_Azti.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Azti.d();
    }
    for (;;)
    {
      if (this.t) {
        this.t = false;
      }
      return;
      this.jdField_a_of_type_Azti.e();
    }
  }
  
  private void ao()
  {
    int i2 = 2;
    aljw localaljw;
    if (this.jdField_a_of_type_Aljw != null)
    {
      boolean bool = awzv.a().d();
      localaljw = this.jdField_a_of_type_Aljw;
      if (!bool) {
        break label134;
      }
      i1 = 2;
      localaljw.a(10, i1);
      awzv.a().b(bool);
      this.jdField_a_of_type_Aljw.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == 0) {
        break label139;
      }
      i1 = 1;
      label65:
      localaljw = this.jdField_a_of_type_Aljw;
      if (i1 == 0) {
        break label144;
      }
      i1 = 2;
      label77:
      localaljw.a(41, i1);
      bool = audx.a().a();
      localaljw = this.jdField_a_of_type_Aljw;
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
      localaljw.a(42, i1);
      if (this.jdField_a_of_type_Aljw != null) {
        this.jdField_a_of_type_Aljw.g();
      }
      a("onResume");
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
      localObject = this.jdField_a_of_type_Alms.getItem(0);
    } while (!(localObject instanceof RecentUserBaseData));
    Object localObject = (RecentUserBaseData)localObject;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    boolean bool;
    label101:
    int i1;
    if ((((RecentUserBaseData)localObject).mUser.getType() == 1) && (!axug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)((RecentUserBaseData)localObject).mUser)))
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
      i1 = 2130850332;
      label163:
      if (!bool) {
        break label229;
      }
    }
    label220:
    label222:
    label229:
    for (int i2 = 2130850343;; i2 = 2130850342)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(i1);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366151).setBackgroundResource(i2);
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
      i1 = 2130850331;
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
      if ((becb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (becb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Alms != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          label73:
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition())
          {
            Object localObject = this.jdField_a_of_type_Alms.getItem(i1);
            if ((!(localObject instanceof RecentItemTencentDocsAssistantData)) || (((RecentItemTencentDocsAssistantData)localObject).getUnreadNum() <= 0)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!obj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            break label170;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess call");
          }
          if (this.jdField_c_of_type_Avsm == null) {
            break;
          }
          this.jdField_c_of_type_Avsm.a();
          return;
          i1 += 1;
          break label73;
        }
      }
    }
  }
  
  private void ar()
  {
    if (this.jdField_a_of_type_Alrd != null) {
      this.jdField_a_of_type_Alrd.b();
    }
  }
  
  private void as()
  {
    a(new Conversation.27(this));
  }
  
  private void at()
  {
    axan.a().k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = tug.a();
    if (localObject != null) {
      ((tug)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    localObject = twk.a();
    if (localObject != null) {
      ((twk)localObject).i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bgts.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = (bgul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
    if (localObject != null) {
      ((bgul)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      localObject = (oek)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      if (localObject != null) {
        ((oek)localObject).e();
      }
      localObject = (awaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
      if (localObject != null) {
        ((awaa)localObject).a(true);
      }
      localObject = (anzm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255);
      if (localObject != null) {
        ((anzm)localObject).a();
      }
      aorc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
      localObject = (atag)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(292);
      if (localObject != null) {
        ((atag)localObject).c();
      }
      localObject = (wjk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
      ((wjk)localObject).a(1, ((wjk)localObject).a(this.jdField_a_of_type_JavaUtilList));
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
    aobl localaobl = (aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if (localaobl.c())
    {
      localaobl.c();
      return;
    }
    this.p = localaobl.d();
    ArrayList localArrayList = localaobl.c();
    if ((this.p) && (localArrayList != null) && (localArrayList.size() > 0))
    {
      localaobl.d();
      return;
    }
    localaobl.e();
    this.p = false;
  }
  
  private void av()
  {
    this.jdField_a_of_type_Atpa = new aeik(this);
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
    while (i1 >= this.jdField_a_of_type_Alms.getCount())
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
      i2 = 0;
      break;
    }
    Object localObject = this.jdField_a_of_type_Alms.getItem(i1);
    if ((localObject != null) && ((localObject instanceof RecentBaseData)))
    {
      localObject = (RecentBaseData)localObject;
      if (!(localObject instanceof RecentItemImaxADData)) {}
    }
    for (;;)
    {
      i3 += 1;
      break;
      this.jdField_a_of_type_Alms.a().a(((RecentBaseData)localObject).getRecentUserType(), ((RecentBaseData)localObject).getRecentUserUin(), false);
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
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfAlmg[0] = new aeiz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfAlmg[1] = new akgx();
  }
  
  private void ay()
  {
    if ((this.w) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      ThreadManager.post(new Conversation.53(this), 5, null, true);
    }
  }
  
  private void az()
  {
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_Alof != null))
    {
      this.jdField_a_of_type_Alof.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
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
    ApolloSurfaceView localApolloSurfaceView = anbd.a();
    if (localApolloSurfaceView != null) {
      localApolloSurfaceView.runRenderTask(new Conversation.4(this, localApolloSurfaceView, paramInt1, paramInt2, paramIntent));
    }
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    AbsStructMsg localAbsStructMsg;
    if ((paramIntent != null) && (paramInt == -1))
    {
      localAbsStructMsg = bdow.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg != null) {}
    }
    else
    {
      return;
    }
    String str = paramIntent.getStringExtra("uin");
    paramInt = paramIntent.getIntExtra("uintype", -1);
    int i1 = paramIntent.getIntExtra("cmshow_game_id", -1);
    bhse.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramInt, localAbsStructMsg, null);
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
      if (anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) >= 5)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog = new UpgradeTipsDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.setOnDismissListener(new aehv(this));
  }
  
  private void b(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {}
    for (;;)
    {
      return;
      if (amjp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        amjp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      L();
      List localList1 = alni.a().jdField_a_of_type_JavaUtilList;
      List localList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().getRecentList(false);
      this.jdField_a_of_type_Alme.a(localList2);
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
        str = alni.a(localRecentUser.uin, localRecentUser.getType());
        localRecentBaseData = alni.a().a(str);
        if (localRecentBaseData != null) {
          break label202;
        }
        localRecentBaseData = almc.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
        paramMessage = localRecentBaseData;
        if (localRecentBaseData != null)
        {
          alni.a().a(localRecentBaseData, str);
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
          if (!this.jdField_b_of_type_JavaUtilList.contains(alni.a(localRecentUser.uin, -2147483648))) {}
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
        Collections.sort(localList1, this.jdField_a_of_type_Alme);
        d(localList1);
        t();
        paramMessage = new ArrayList(localList1);
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
        a(localList1);
        if (this.jdField_a_of_type_Aljw != null) {
          this.jdField_a_of_type_Aljw.i();
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
        bdmc.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - paramLong, localList1.size(), paramMessage, "");
        bhsq.a("Conversation_Refresh_part", System.currentTimeMillis() - paramLong);
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramRecentUser.uin, paramRecentUser.getType());
      if ((localObject != null) && ((localObject instanceof MessageForStructing)))
      {
        localObject = ((MessageForStructing)localObject).structingMsg;
        if (localObject == null) {}
      }
      for (long l1 = ((AbsStructMsg)localObject).msgId;; l1 = 0L)
      {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", paramRecentBaseData, paramRecentBaseData, 0, 0, paramRecentUser.uin + "", "" + l1, "" + i1, "" + paramInt);
        label210:
        do
        {
          return;
        } while (paramRecentUser.getType() != 6004);
        if (paramInt > 0) {}
        for (paramInt = 1;; paramInt = 2)
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090CC", "0X80090CC", paramInt, 0, "", "", "", "");
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
      if ((paramObject.length == 2) && (antf.x.equals(paramObject[0])) && (paramObject[1] != null))
      {
        Object localObject = paramObject[0];
        a(8, paramObject[1], 7000);
      }
    }
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
      this.jdField_a_of_type_Alms.a(localRecentBaseData);
    }
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    if ((paramObservable instanceof baou))
    {
      if ((paramObject instanceof Boolean))
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        if ((!this.jdField_e_of_type_Boolean) && (bool))
        {
          paramObservable = null;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            paramObservable = (baou)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
          }
          if (paramObservable != null) {
            paramObservable.a(false);
          }
        }
      }
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Aljw != null)) {
        this.jdField_a_of_type_Aljw.j();
      }
    }
  }
  
  private boolean b(RecentBaseData paramRecentBaseData, boolean paramBoolean, apaw paramapaw, String paramString)
  {
    boolean bool = false;
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.getRecentUserUin());
    int i1;
    if (!TextUtils.isEmpty(str))
    {
      paramapaw = (antz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      if (paramBoolean) {}
      for (i1 = 0; !paramapaw.a(str, i1); i1 = 1) {
        return true;
      }
      paramapaw = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
      if (paramapaw != null) {}
      switch (paramapaw.troopmask)
      {
      case 2: 
      case 3: 
      default: 
        i1 = 0;
        label127:
        paramapaw = new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
        paramString = paramRecentBaseData.getRecentUserUin();
        if (paramBoolean)
        {
          paramRecentBaseData = "0";
          label177:
          paramapaw.a(new String[] { paramString, String.valueOf(i1), paramRecentBaseData }).a();
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
      if ((paramString == null) || (paramString.length() == 0) || (paramapaw == null))
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
          if (paramapaw == null) {
            paramBoolean = true;
          }
          QLog.d("Q.recent", 2, paramBoolean);
          return true;
        }
      }
      localObject = (RecentUser)paramapaw.findRecentUser(paramString, i1);
      paramRecentBaseData = (RecentBaseData)localObject;
      if (localObject == null) {
        paramRecentBaseData = new RecentUser(paramString, i1);
      }
    } while (!axug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData));
    if (paramBoolean) {}
    for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
    {
      paramapaw.saveRecentUser(paramRecentBaseData);
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
        QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync from=", Integer.valueOf(paramInt), " isInRealActionLoginB=", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()), " isLoadUIAfterMsgSync=", Boolean.valueOf(this.m) });
        if (1 == paramInt)
        {
          this.r = true;
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
          a(1072, 500L, true);
          a(9003, 500L, true);
          a(1073, 30000L, true);
          a(1077, 1200L, true);
          if (this.jdField_a_of_type_Aejz != null) {
            this.jdField_a_of_type_Aejz.f();
          }
          aody.b();
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
        this.jdField_a_of_type_Aljw.a();
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
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "REFRESH_FLAG_RECENT_ITEMS, [" + paramMessage.arg1 + "," + paramMessage.arg2 + "," + paramMessage.obj + "," + this.jdField_j_of_type_Boolean + "," + bool + "]");
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
    ((anzm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).b();
    axan.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    L();
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (amjp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      amjp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        Object localObject = paramMessage.getRecentList(bool);
        this.jdField_a_of_type_Alme.a((List)localObject);
        paramMessage = alni.a().jdField_a_of_type_JavaUtilList;
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        BaseActivity localBaseActivity = a();
        int i1;
        if (localObject != null)
        {
          i1 = ((List)localObject).size();
          almc.a((List)localObject, localQQAppInterface, localBaseActivity, paramMessage, i1);
        }
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_Alme);
          d(paramMessage);
          t();
          localObject = new ArrayList(paramMessage);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, localObject).sendToTarget();
          a(paramMessage);
          if (this.jdField_a_of_type_Aljw != null) {}
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          localObject = new HashMap();
          ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
          bdmc.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - paramLong, paramMessage.size(), (HashMap)localObject, "");
          localObject = (wjk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
          ((wjk)localObject).b(3, ((wjk)localObject).a(paramMessage));
          bhsq.a("Conversation_Refresh_global", System.currentTimeMillis() - paramLong);
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
      aobl localaobl = (aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      if ((localaobl.jdField_a_of_type_Boolean) && (localaobl.a(paramList))) {
        localaobl.jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Alms.a(paramList);
    if (this.D)
    {
      this.D = false;
      if (this.E)
      {
        if (!this.jdField_f_of_type_Boolean) {
          break label122;
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addOnLayoutChangeListener(new aeji(this));
      }
    }
    for (;;)
    {
      this.E = false;
      if (paramList != null) {
        alni.a().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      }
      this.jdField_a_of_type_Alms.a(0);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localMessageRecord.frienduin, localMessageRecord.istroop);
      if ((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.msgtype != -2002)) {
        break label53;
      }
    }
    label53:
    while ((localMessageRecord.isSendFromLocal()) && (localMessageRecord.msgtype == -2000) && (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    if ((this.jdField_f_of_type_Boolean) && (nwy.a(localMessageRecord)))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      m(false);
    }
    if ((this.jdField_f_of_type_Boolean) && (avxz.a(localMessageRecord))) {
      avxx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Alms, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
    }
    if ((this.jdField_f_of_type_Boolean) && (vjo.a(localMessageRecord.istroop))) {
      p();
    }
    int i4 = 10;
    Long localLong = Long.valueOf(0L);
    int i1;
    int i2;
    if ((localMessageRecord.isSendFromLocal()) && ((!this.jdField_f_of_type_Boolean) || (TextUtils.equals(localMessageRecord.frienduin, antf.az)) || (TextUtils.equals(localMessageRecord.frienduin, antf.aA))))
    {
      i1 = 2;
      i2 = 9;
      paramObject = alni.a(localMessageRecord.frienduin, localMessageRecord.istroop);
    }
    for (;;)
    {
      if (localMessageRecord.isSend()) {
        bhoq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
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
        if (alpb.jdField_b_of_type_Boolean)
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
          if (((((RecentUserBaseData)localObject).getRecentUserType() == 1) && (!axug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)((RecentUserBaseData)localObject).mUser)) && (localTroopManager.b(((RecentUserBaseData)localObject).getRecentUserUin()))) || (((RecentUserBaseData)localObject).mUser.showUpTime != 0L)) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(((RecentUserBaseData)localObject).getRecentUserType()).append("-").append(bhsr.e(((RecentUserBaseData)localObject).getRecentUserUin())).append("-").append(i1).append(" , ");
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
  
  private boolean d()
  {
    if (!bhsi.d(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().getRecentList(false);
      if ((localObject2 == null) || (((List)localObject2).size() == 0))
      {
        bhsi.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
        if (bhsi.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).contains(localObject2)) {
          localArrayList.remove(localObject2);
        }
      }
      if (localArrayList.size() == 0)
      {
        bhsi.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        return true;
      }
      ((antz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(localArrayList, 0);
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
    if (this.jdField_a_of_type_Wyd == null) {
      this.jdField_a_of_type_Wyd = new wyd(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, (BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368103));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)) {
      this.jdField_a_of_type_Wyd.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
    }
    this.jdField_a_of_type_Wyd.jdField_f_of_type_Boolean = this.w;
    this.jdField_a_of_type_Wyd.b();
    for (this.s = false;; this.s = false)
    {
      this.n = paramBoolean;
      return;
      label149:
      if (this.jdField_a_of_type_Wyd != null) {
        this.jdField_a_of_type_Wyd.c();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anua, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvn, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoka, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anwt, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoib, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayxl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anwb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoaa);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Wjd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Afjb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azie);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asvt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aohy);
    bduy.a(this.jdField_a_of_type_Bduz);
    Object localObject2 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject2 != null) {
      ((bbav)localObject2).addObserver(this);
    }
    if (this.jdField_a_of_type_Atpa == null) {
      av();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
    if (this.jdField_a_of_type_Aejq == null) {
      this.jdField_a_of_type_Aejq = new aejq(this);
    }
    this.jdField_a_of_type_Aejq.addFilter(new Class[] { berv.class, besa.class, C2CPttDownloadProcessor.class, bese.class, betv.class, GroupPttDownloadProcessor.class, beth.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aejq);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
        localObject2 = (baou)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject2 != null) {
          ((baou)localObject2).addObserver(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Lnc);
        mvd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aohk);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogi);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Apec);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver);
        if (this.jdField_a_of_type_Awwb != null) {
          this.jdField_a_of_type_Awwb.b();
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
    if ((!paramBoolean) && (this.jdField_a_of_type_Avsm != null)) {
      this.jdField_a_of_type_Avsm.d();
    }
    m(true);
    aq();
    r();
  }
  
  private void l(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_k_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Aejz != null) {
        this.jdField_a_of_type_Aejz.a(false);
      }
      aejy localaejy = this.jdField_a_of_type_Aejy;
      if (localaejy != null) {
        localaejy.a(false);
      }
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if ((!tyi.jdField_k_of_type_Boolean) || ((!paramBoolean) && (obj.a().jdField_a_of_type_Boolean))) {}
    label151:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Alms != null))
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
        if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
          if (!(this.jdField_a_of_type_Alms.getItem(i1) instanceof RecentItemPublicAccountADFolderData)) {}
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label151;
        }
        if ((this.jdField_a_of_type_Avsm != null) && (!this.x))
        {
          this.jdField_a_of_type_Avsm.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.x = true;
        }
        obj.a().jdField_a_of_type_Boolean = true;
        ThreadManager.getSubThreadHandler().postDelayed(new Conversation.26(this), 1000L);
        return;
        i1 += 1;
        break;
      }
    }
  }
  
  int a()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Alms.getCount())
    {
      if ((this.jdField_a_of_type_Alms.getItem(i1) instanceof RecentItemMayKnowFriendVerticalListData)) {
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
      } while (alpb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
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
  
  public alms a()
  {
    return this.jdField_a_of_type_Alms;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    bhsq.a(null, "Recent_Start");
    bhsq.a(null, "Recent_CreateView");
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
        localObject2 = paramLayoutInflater.inflate(2131558968, null);
      }
      bhsq.a("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public String a()
  {
    String str = anzj.a(2131701505);
    if (this.jdField_d_of_type_Int <= 0) {
      return str;
    }
    if (this.jdField_d_of_type_Int > 99) {
      return str + "(99+)";
    }
    return str + "(" + this.jdField_d_of_type_Int + ")";
  }
  
  public wyd a()
  {
    return this.jdField_a_of_type_Wyd;
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
      z();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
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
      alof.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
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
    if (!c())
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
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null))
    {
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.aq_();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    String str1;
    apaw localapaw;
    String str2;
    anyw localanyw;
    if (paramBoolean)
    {
      str1 = "1";
      localapaw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      str2 = paramRecentBaseData.getRecentUserUin();
      localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((paramInt != 7000) || (antf.x.equals(str2))) {
        break label125;
      }
      bdwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, paramBoolean);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str1, paramString, "");
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
            a(paramInt, paramRecentBaseData, paramBoolean, str1, localapaw);
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
              ((anzm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramBoolean);
            }
          }
          if (paramInt != 1) {
            break label194;
          }
        } while (!b(paramRecentBaseData, paramBoolean, localapaw, str2));
        return;
        if ((paramInt != 0) || (!localanyw.b(str2))) {
          break label221;
        }
      } while (!a(paramInt, paramBoolean, str2));
      return;
    } while (!a(paramRecentBaseData, paramBoolean, localapaw, str2));
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
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_Aljw != null)) {
        this.jdField_a_of_type_Aljw.a(paramRecentUser.uin);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.getType());
      }
    } while ((paramInt & 0x4) == 0);
    alpb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, -1);
    QQToast.a(a(), anzj.a(2131701504), 0).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 8) && (paramInt1 != 9)) {
      return;
    }
    a(0, paramInt1, alni.a(paramString, paramInt2));
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_Aljw.a(9, 0);
    }
    boolean bool1;
    int i1;
    label111:
    boolean bool2;
    if (!paramBoolean1)
    {
      bool1 = true;
      awzv.a().a(bool1);
      localObject1 = this.jdField_a_of_type_Aljw;
      if (!bool1) {
        break label244;
      }
      i1 = 2;
      ((aljw)localObject1).a(1, i1);
      bool2 = awzv.a().d();
      if ((!bool2) || (paramInt != 1134012)) {
        break label352;
      }
      bool2 = false;
    }
    label352:
    for (;;)
    {
      awzv.a().b(bool2);
      localObject1 = this.jdField_a_of_type_Aljw;
      i1 = i2;
      if (bool2) {
        i1 = 2;
      }
      ((aljw)localObject1).a(10, i1);
      this.jdField_a_of_type_Aljw.a(-1, null);
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aqgb)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              ((aqgb)localObject2).a(paramBoolean1);
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
        ((StringBuilder)localObject1).append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", isNetSupport = ").append(paramBoolean1).append(", loadingState = ").append(awzv.a().a()).append(", msg = ").append(paramInt);
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
    int i1 = bhih.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    bhih.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i1 + 1);
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
    if ((this.jdField_a_of_type_Alof != null) && (this.jdField_a_of_type_Alof.a())) {
      this.jdField_a_of_type_Alof.b();
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
        paramMessage.append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", initLoadingHandle = ").append(paramBoolean).append(", loadingState = ").append(awzv.a().a()).append(", what = ").append(i1);
        QLog.i("Q.recent", 2, paramMessage.toString());
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean) {
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
    if (this.jdField_a_of_type_Alms == null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = this.jdField_a_of_type_Alms.a(paramView);
      if ((localRecentBaseData != null) && ("9970".equals(localRecentBaseData.getRecentUserUin()))) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
      }
    } while ((localRecentBaseData == null) || (!antf.aB.equals(localRecentBaseData.getRecentUserUin())));
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
    if ((paramString.equals("sp_uin_for_title")) && (i2 == 2131376341))
    {
      x();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "msgtab_list_clk", 2);
      return;
    }
    aobl localaobl = (aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramString, 102);
    boolean bool = localaobl.a();
    ArrayList localArrayList = localaobl.c();
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
      if (i2 == 2131376575)
      {
        if (!bhnv.g(paramContext))
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131691989), 0).b(a().getTitleBarHeight());
          return;
        }
        paramString = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((!paramString.b(paramView.uin)) && (!paramString.d(paramView.uin)))
        {
          paramString = paramView.getDisplayName(localaobl.a());
          paramContext = AddFriendLogicActivity.a(paramContext, 1, paramView.uin, null, 3045, 25, paramString, null, null, paramContext.getString(2131689551), null);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(25), "", "", "");
          a(paramContext);
        }
        for (;;)
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
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
    bhsq.a(null, "AIO_Click_cost");
    bhnx.a(null, "pubAcc_aio_open", "");
    bhjs.a(true);
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
      int i1 = alpb.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData);
      a(paramRecentBaseData, paramView, i1);
      a(i1, paramView);
      if (paramRecentBaseData != null)
      {
        aloy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramView);
        paramRecentBaseData.clearUnReadNum();
        blhw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.getRecentUserUin());
        this.jdField_i_of_type_Boolean = true;
      }
      bhsq.a("AIO_Click_cost", null);
      return;
      paramView = null;
    }
  }
  
  public void a(View paramView, Object paramObject)
  {
    wjk localwjk = (wjk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
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
      if (paramView.getId() == 2131363713)
      {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
        paramView = new Intent(a(), ForwardRecentActivity.class);
        paramView.putExtra("forward_type", 13);
        a(paramView);
        return;
      }
      if ((paramView.getId() == 2131367148) || (paramView.getId() == 2131367150) || (paramView.getId() == 2131367151) || (paramView.getId() == 2131367152) || (paramView.getId() == 2131367153) || (paramView.getId() == 2131367154) || (paramView.getId() == 2131367155))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = bhlg.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, paramView, paramObject, null, true, null, true, true, null, null);
        return;
      }
    } while ((paramView.getId() != 2131369396) || (!localwjk.b(paramObject)));
    localwjk.a(paramView, (RecentItemChatMsgData)paramObject);
  }
  
  public void a(bikv parambikv, biku parambiku)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) && (parambiku != null) && (parambiku.jdField_d_of_type_Long == 0L) && (parambiku.jdField_a_of_type_Long != 0L)) {
      parambikv.a(parambiku.jdField_a_of_type_Long);
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
        aloy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
        alpb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i1);
        this.jdField_a_of_type_Aejv.a(paramString);
      }
    }
    for (;;)
    {
      return;
      localObject = (baou)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
      if ((localObject != null) && (paramRecentBaseData != null)) {}
      try
      {
        ((baou)localObject).b(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
        if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
          if (paramRecentBaseData.getRecentUserType() == 3000)
          {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
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
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
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
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_Alpa == null)) {
      this.jdField_a_of_type_Alpa = new alpa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (bhjx.a(paramString1, localResources.getString(2131691106)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
      if (!bhjx.a(paramString1, localResources.getString(alnt.a[4]))) {
        break label411;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        alpb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)paramString1.getRecentUser(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
    }
    label411:
    while (!bhjx.a(paramString1, localResources.getString(alnt.a[5])))
    {
      return;
      if (bhjx.a(paramString1, localResources.getString(2131691109)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        break;
      }
      if (bhjx.a(paramString1, localResources.getString(2131692805)))
      {
        a(i1, paramRecentBaseData, paramString2, false);
        if (i1 != 3000) {
          break;
        }
        new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").a();
        break;
      }
      if (bhjx.a(paramString1, localResources.getString(2131692807)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        if (i1 != 3000) {
          break;
        }
        new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").a();
        break;
      }
      if (!bhjx.a(paramString1, localResources.getString(2131693878))) {
        break;
      }
      this.jdField_a_of_type_Alol.a(a(), paramRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramRecentBaseData.getRecentUserUin(), "0X800991D", "0X800991D", 0, 0, "", "", "", "");
      break;
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramString1 = (RecentUser)((RecentUserBaseData)paramRecentBaseData).getRecentUser();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1.uin, paramString1.getType(), 1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
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
    if (this.jdField_a_of_type_Alms != null) {
      this.jdField_a_of_type_Alms.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Aljw.a(22, 0);
    alni.a().a();
    bnwq.a().a();
    if (this.jdField_a_of_type_Aejv != null) {
      this.jdField_a_of_type_Aejv.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_Azti != null) {
      this.jdField_a_of_type_Azti.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aqgb localaqgb = (aqgb)localIterator.next();
        if (localaqgb != null) {
          localaqgb.a(paramLogoutReason);
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
    //   0: invokestatic 572	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 458
    //   9: iconst_2
    //   10: new 460	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 3449
    //   20: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 474	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 477	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 535	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   37: ifnull +21 -> 58
    //   40: aload_0
    //   41: getfield 535	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   44: invokevirtual 3452	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   47: ifge +11 -> 58
    //   50: aload_0
    //   51: getfield 535	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   54: iconst_0
    //   55: invokevirtual 3455	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   58: aload_0
    //   59: iconst_0
    //   60: invokespecial 3457	com/tencent/mobileqq/activity/Conversation:j	(Z)V
    //   63: iload_1
    //   64: ifeq +391 -> 455
    //   67: invokestatic 694	awzv:a	()Lawzv;
    //   70: invokevirtual 3458	awzv:a	()V
    //   73: invokestatic 911	alni:a	()Lalni;
    //   76: invokevirtual 3436	alni:a	()V
    //   79: invokestatic 3441	bnwq:a	()Lbnwq;
    //   82: invokevirtual 3442	bnwq:a	()V
    //   85: aload_0
    //   86: getfield 2608	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   89: ifeq +22 -> 111
    //   92: aload_0
    //   93: getfield 535	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   96: ifnull +15 -> 111
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 2608	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   104: aload_0
    //   105: getfield 535	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   108: invokevirtual 3461	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   111: aload_0
    //   112: getfield 712	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   115: ifnull +15 -> 130
    //   118: aload_0
    //   119: getfield 712	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   122: invokevirtual 3462	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 712	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   130: aload_0
    //   131: getfield 728	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   134: ifnull +15 -> 149
    //   137: aload_0
    //   138: getfield 728	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   141: invokevirtual 736	android/app/Dialog:dismiss	()V
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield 728	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   149: aload_0
    //   150: getfield 898	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajtf	Lajtf;
    //   153: ifnull +14 -> 167
    //   156: aload_0
    //   157: getfield 898	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajtf	Lajtf;
    //   160: aload_0
    //   161: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   164: invokevirtual 3463	ajtf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   167: aload_0
    //   168: getfield 1701	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Alpa	Lalpa;
    //   171: ifnull +14 -> 185
    //   174: aload_0
    //   175: getfield 1701	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Alpa	Lalpa;
    //   178: aload_0
    //   179: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: invokevirtual 3464	alpa:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   185: aload_0
    //   186: getfield 479	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Alms	Lalms;
    //   189: ifnull +25 -> 214
    //   192: aload_0
    //   193: getfield 479	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Alms	Lalms;
    //   196: aload_0
    //   197: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   200: invokevirtual 3465	alms:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   203: aload_0
    //   204: iconst_1
    //   205: bipush 10
    //   207: lconst_0
    //   208: invokestatic 500	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   211: invokevirtual 503	com/tencent/mobileqq/activity/Conversation:a	(IILjava/lang/Object;)V
    //   214: aload_0
    //   215: getfield 535	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   218: ifnull +11 -> 229
    //   221: aload_0
    //   222: getfield 535	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   225: iconst_0
    //   226: invokevirtual 3468	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   229: aload_0
    //   230: iconst_0
    //   231: invokespecial 1635	com/tencent/mobileqq/activity/Conversation:i	(Z)V
    //   234: aload_0
    //   235: getfield 2076	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Wyd	Lwyd;
    //   238: ifnull +14 -> 252
    //   241: aload_0
    //   242: getfield 2076	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Wyd	Lwyd;
    //   245: aload_0
    //   246: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   249: invokevirtual 3469	wyd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   252: aload_0
    //   253: getfield 1111	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   256: ifnull +16 -> 272
    //   259: aload_0
    //   260: getfield 1111	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   263: aload_0
    //   264: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   267: invokeinterface 3472 2 0
    //   272: aload_0
    //   273: getfield 539	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bntn	Lbntn;
    //   276: ifnull +14 -> 290
    //   279: aload_0
    //   280: getfield 539	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bntn	Lbntn;
    //   283: aload_0
    //   284: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   287: invokevirtual 3473	bntn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   290: aload_0
    //   291: getfield 548	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bnty	Lbnty;
    //   294: ifnull +14 -> 308
    //   297: aload_0
    //   298: getfield 548	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bnty	Lbnty;
    //   301: aload_0
    //   302: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   305: invokevirtual 3474	bnty:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   308: ldc_w 458
    //   311: ldc_w 3476
    //   314: aload_0
    //   315: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   318: getfield 1137	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   321: invokevirtual 1140	com/tencent/mobileqq/app/automator/Automator:b	()Z
    //   324: invokestatic 1180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   327: invokestatic 3481	yuk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   330: aload_0
    //   331: sipush 1055
    //   334: lconst_0
    //   335: iconst_0
    //   336: invokevirtual 725	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   339: aload_0
    //   340: getfield 906	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aljw	Laljw;
    //   343: ifnull +10 -> 353
    //   346: aload_0
    //   347: getfield 906	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aljw	Laljw;
    //   350: invokevirtual 3482	aljw:e	()V
    //   353: aload_0
    //   354: getfield 183	com/tencent/mobileqq/activity/Conversation:jdField_j_of_type_Boolean	Z
    //   357: ifeq +13 -> 370
    //   360: aload_0
    //   361: getfield 1189	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   364: bipush 12
    //   366: invokevirtual 494	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   369: pop
    //   370: aload_0
    //   371: getfield 753	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   374: getfield 982	com/tencent/mobileqq/app/FrameHelperActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   377: iconst_4
    //   378: invokevirtual 2598	android/os/Handler:sendEmptyMessage	(I)Z
    //   381: pop
    //   382: aload_0
    //   383: sipush 1035
    //   386: ldc2_w 2712
    //   389: iconst_0
    //   390: invokevirtual 725	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   393: aload_0
    //   394: sipush 1010
    //   397: ldc2_w 2712
    //   400: iconst_1
    //   401: invokevirtual 725	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   404: aload_0
    //   405: sipush 1063
    //   408: lconst_0
    //   409: iconst_1
    //   410: aconst_null
    //   411: invokevirtual 1212	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   414: aload_0
    //   415: sipush 1064
    //   418: ldc2_w 2712
    //   421: iconst_1
    //   422: ldc_w 3484
    //   425: invokevirtual 1212	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   428: aload_0
    //   429: aload_0
    //   430: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   433: bipush 76
    //   435: invokevirtual 1089	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   438: checkcast 2126	bikv
    //   441: putfield 195	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bikv	Lbikv;
    //   444: aload_0
    //   445: invokespecial 3486	com/tencent/mobileqq/activity/Conversation:az	()V
    //   448: aload_0
    //   449: ldc_w 3488
    //   452: invokespecial 1011	com/tencent/mobileqq/activity/Conversation:a	(Ljava/lang/String;)V
    //   455: aload_0
    //   456: sipush 10001
    //   459: ldc2_w 3489
    //   462: iconst_0
    //   463: invokevirtual 725	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   466: aload_0
    //   467: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   470: invokevirtual 2846	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   473: ifne +15 -> 488
    //   476: aload_0
    //   477: getfield 183	com/tencent/mobileqq/activity/Conversation:jdField_j_of_type_Boolean	Z
    //   480: ifeq +8 -> 488
    //   483: aload_0
    //   484: lconst_0
    //   485: invokevirtual 1797	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   488: aload_0
    //   489: ldc_w 3491
    //   492: ldc2_w 2099
    //   495: iconst_0
    //   496: invokevirtual 725	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   499: invokestatic 2243	obj:a	()Lobj;
    //   502: aload_0
    //   503: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   506: invokevirtual 1278	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   509: invokevirtual 3492	obj:a	(Ljava/lang/String;)V
    //   512: getstatic 3495	axgj:jdField_g_of_type_Boolean	Z
    //   515: ifeq +13 -> 528
    //   518: invokestatic 3498	axgj:a	()Laxgj;
    //   521: aload_0
    //   522: getfield 522	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   525: invokevirtual 3499	axgj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   528: iload_1
    //   529: ifeq +7 -> 536
    //   532: aload_0
    //   533: invokespecial 2600	com/tencent/mobileqq/activity/Conversation:R	()V
    //   536: return
    //   537: astore_2
    //   538: aload_0
    //   539: aconst_null
    //   540: putfield 712	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   543: goto -413 -> 130
    //   546: astore_2
    //   547: aload_0
    //   548: aconst_null
    //   549: putfield 712	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   552: aload_2
    //   553: athrow
    //   554: astore_2
    //   555: aload_0
    //   556: aconst_null
    //   557: putfield 728	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   560: goto -411 -> 149
    //   563: astore_2
    //   564: aload_0
    //   565: aconst_null
    //   566: putfield 728	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   569: aload_2
    //   570: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	this	Conversation
    //   0	571	1	paramBoolean	boolean
    //   537	1	2	localException1	Exception
    //   546	7	2	localObject1	Object
    //   554	1	2	localException2	Exception
    //   563	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   118	125	537	java/lang/Exception
    //   118	125	546	finally
    //   137	144	554	java/lang/Exception
    //   137	144	563	finally
  }
  
  public boolean a()
  {
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.s();
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
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.hideMiniAppEntry();
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onViewCompleteVisableAndReleased %s", new Object[] { Boolean.valueOf(this.jdField_g_of_type_Boolean) }));
    }
    return a(paramListView);
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
  
  public boolean a(bikv parambikv, biku parambiku)
  {
    if ((parambiku == null) || (parambikv == null)) {}
    do
    {
      return false;
      if (parambiku.jdField_d_of_type_Long == 3L) {
        parambikv.a(4L, parambiku.jdField_a_of_type_Long);
      }
    } while ((parambiku == null) || (parambiku.jdField_d_of_type_Long != 2L) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) || (!this.w));
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
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d()) {
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
      bhsq.a("Conversation_PullToRefresh_start", 0L);
      n();
      ThreadManager.getSubThreadHandler().post(new Conversation.10(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      }
      if (((wwh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
      {
        ((wwg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a().a(2);
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
      a(9003, 500L, true);
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "send MSG_CHECK_MEDAL_GUIDE");
    return true;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "conversation onPostThemeChanged");
    }
    if ((!ThemeUtil.isDefaultTheme()) && (this.B) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850331);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366151).setBackgroundResource(2130850342);
      this.B = false;
    }
    v();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.m();
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
      bdgb.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Azti.k();
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aqgb localaqgb = (aqgb)localIterator.next();
        if (localaqgb != null) {
          localaqgb.i();
        }
      }
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850099);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166987));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166987));
    }
    if (this.jdField_a_of_type_Alrd != null) {
      this.jdField_a_of_type_Alrd.e();
    }
    if (this.jdField_a_of_type_Wyd != null) {
      this.jdField_a_of_type_Wyd.i();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onPostThemeChanged();
    }
    if (this.jdField_a_of_type_Aljw != null) {
      this.jdField_a_of_type_Aljw.a(-1, null);
    }
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "conversation onPostThemeChanged refresh because simple theme switch!");
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(10);
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.q();
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public void b(long paramLong)
  {
    bgut localbgut = (bgut)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
    if (localbgut != null) {
      localbgut.a(paramLong);
    }
  }
  
  public void b(View paramView) {}
  
  public void b(boolean paramBoolean)
  {
    a(true);
    this.D = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_i_of_type_Long = System.currentTimeMillis();
      if (this.jdField_f_of_type_Boolean)
      {
        this.E = true;
        aB();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    if (this.jdField_a_of_type_Aejz != null) {
      this.jdField_a_of_type_Aejz.d();
    }
  }
  
  public View c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_c_of_type_AndroidViewView;
  }
  
  public void c()
  {
    aa();
    s();
    if (this.jdField_a_of_type_Aljw != null) {
      this.jdField_a_of_type_Aljw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Azti != null) {
      this.jdField_a_of_type_Azti.c();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aqgb localaqgb = (aqgb)((Iterator)localObject).next();
        if (localaqgb != null) {
          localaqgb.b();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134065);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134061);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134068);
    bdli.a();
    if (this.jdField_a_of_type_Alof != null) {
      this.jdField_a_of_type_Alof.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Alol != null) {
      this.jdField_a_of_type_Alol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_Alme != null) {
      this.jdField_a_of_type_Alme.a(a());
    }
    if (this.jdField_a_of_type_Awwb != null) {
      this.jdField_a_of_type_Awwb.d();
    }
    if (this.jdField_a_of_type_Aejz != null) {
      this.jdField_a_of_type_Aejz.c();
    }
    Object localObject = this.jdField_a_of_type_Aejy;
    if (localObject != null) {
      ((aejy)localObject).a();
    }
    if (this.jdField_a_of_type_Alrd != null) {
      this.jdField_a_of_type_Alrd.a(a());
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "updateLoadingState, showLoadingCircle = " + paramBoolean);
    }
    if (paramBoolean) {
      try
      {
        Drawable localDrawable = a().getResources().getDrawable(2130839412);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(agej.a(5.0F, a()));
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
  
  protected boolean c()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1);
  }
  
  public void d()
  {
    super.d();
    j();
  }
  
  public void d(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_Aljw.a(1);
    boolean bool2 = this.jdField_a_of_type_Aljw.a(10);
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
    switch (awzv.a().a())
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
  
  public void e()
  {
    bhsq.a(null, "Recent_OnCreate");
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a(a());
    this.jdField_a_of_type_Aejv = new aejv(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bhlj(Looper.getMainLooper(), this.jdField_a_of_type_Aejr);
    this.jdField_b_of_type_MqqOsMqqHandler = new bhlj(ThreadManager.getRecentThreadLooper(), this);
    this.jdField_a_of_type_Alol = new alol(this.jdField_a_of_type_MqqOsMqqHandler, a());
    this.jdField_a_of_type_Aejz = new aejz(this);
    P();
    O();
    a(false);
    this.jdField_a_of_type_Alme = new alme(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bhsq.a("Recent_OnCreate", null);
  }
  
  public void e(boolean paramBoolean)
  {
    QLog.d("Q.recent", 2, "onResume...");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.C = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = true;
    this.jdField_f_of_type_Boolean = true;
    this.x = paramBoolean;
    aobl.jdField_e_of_type_Boolean = true;
    ah();
    super.e(paramBoolean);
    if (AppSetting.jdField_c_of_type_Boolean) {
      a().setTitle(a(2131693469));
    }
    ab();
    TimeManager.getInstance().resumeCountDownTimer();
    if (this.jdField_a_of_type_Ajtf != null) {
      this.jdField_a_of_type_Ajtf.a();
    }
    if (AppSetting.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(true);
    }
    try
    {
      a().getWindow().setSoftInputMode(32);
      aqcz.a().c();
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_j_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Long != 1000L) {
          this.jdField_a_of_type_Long = 1000L;
        }
        if (!this.jdField_k_of_type_Boolean) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
        }
        if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_Alms != null)) {
          this.jdField_a_of_type_Alms.notifyDataSetChanged();
        }
        a(0L);
        k();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
        aj();
        ak();
        ao();
        ay();
        ag();
        an();
        al();
        ai();
        d();
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
        a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
        avxx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Alms, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
        obj.a().jdField_a_of_type_Boolean = false;
        ac();
        k(paramBoolean);
        ApngImage.playByTag(2);
        af();
        ap();
        ae();
        ad();
        behm.a(null);
        l(paramBoolean);
        aixg.a(a(), paramBoolean);
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
    if (this.jdField_a_of_type_Aejz != null) {
      this.jdField_a_of_type_Aejz.c(paramBoolean);
    }
  }
  
  public void g()
  {
    QLog.d("Q.recent", 2, "onPause...");
    ApngImage.pauseByTag(2);
    super.g();
    this.jdField_a_of_type_Azti.g();
    if (jdField_b_of_type_Long > 0L)
    {
      jdField_b_of_type_Long = 0L;
      SosoInterface.a(jdField_b_of_type_Long);
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aqgb)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((aqgb)localObject2).e();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1053);
    this.J = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (AppSetting.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
    }
    TimeManager.getInstance().pauseCountDownTimer();
    this.jdField_f_of_type_Boolean = false;
    if ((!this.C) && (!this.D) && (alok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      if (System.currentTimeMillis() - this.jdField_i_of_type_Long > 5000L)
      {
        localObject1 = this.jdField_a_of_type_Alms.a();
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
      if (this.jdField_a_of_type_Alof != null) {
        this.jdField_a_of_type_Alof.l();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = false;
      ozs.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_b_of_type_Avsm != null) {
        this.jdField_b_of_type_Avsm.d();
      }
      if (this.jdField_c_of_type_Avsm != null) {
        this.jdField_c_of_type_Avsm.d();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
      bdli.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Wyd != null) {
        this.jdField_a_of_type_Wyd.l();
      }
      pfs.k();
      apeg.a();
      if (this.jdField_a_of_type_Aejz == null) {
        break;
      }
      this.jdField_a_of_type_Aejz.e();
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
      if (this.jdField_a_of_type_Wyd != null) {
        this.jdField_a_of_type_Wyd.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initLater(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
    }
  }
  
  public void h()
  {
    super.h();
    if ((this.jdField_a_of_type_Alof != null) && (this.jdField_a_of_type_Alof.a())) {
      this.jdField_a_of_type_Alof.b();
    }
    if (this.jdField_a_of_type_Avsm != null) {
      this.jdField_a_of_type_Avsm.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aqgb localaqgb = (aqgb)localIterator.next();
        if (localaqgb != null) {
          localaqgb.f();
        }
      }
    }
    if (this.jdField_a_of_type_Awwb != null) {
      this.jdField_a_of_type_Awwb.e();
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
  
  public boolean h_()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.jdField_h_of_type_Boolean) || (a() == null) || (a().isFinishing())) {
      return true;
    }
    blqm.a("conv.handleMessage");
    long l1 = System.currentTimeMillis();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      blqm.a();
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
      paramMessage = (wjk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
      paramMessage.a(2, paramMessage.a(alni.a().jdField_a_of_type_JavaUtilList));
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
    if (this.jdField_a_of_type_Alol != null) {
      this.jdField_a_of_type_Alol.a();
    }
    if (this.jdField_a_of_type_Blir != null)
    {
      this.jdField_a_of_type_Blir.a(null);
      this.jdField_a_of_type_Blir = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.a(null);
    }
    this.p = false;
    TimeManager.getInstance().stopCountDownTimer();
    aa();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
    if (this.jdField_a_of_type_Aejv != null) {
      this.jdField_a_of_type_Aejv.a();
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Ajtf != null) {
      this.jdField_a_of_type_Ajtf.b();
    }
    if (this.jdField_a_of_type_Alms != null) {
      this.jdField_a_of_type_Alms.b();
    }
    if (this.jdField_a_of_type_Wyd != null) {
      this.jdField_a_of_type_Wyd.c();
    }
    if (this.jdField_a_of_type_Aljw != null) {
      this.jdField_a_of_type_Aljw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_Alrd != null) {
      this.jdField_a_of_type_Alrd.h();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    try
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (localObject != null) {
        ((apaw)localObject).b();
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
    axan.a();
    axap.a();
    twk.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aqgb localaqgb = (aqgb)((Iterator)localObject).next();
        if (localaqgb != null) {
          localaqgb.g();
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Awwb != null)
    {
      this.jdField_a_of_type_Awwb.f();
      this.jdField_a_of_type_Awwb = null;
    }
    if (this.jdField_a_of_type_Bntn != null)
    {
      this.jdField_a_of_type_Bntn.b();
      this.jdField_a_of_type_Bntn = null;
    }
    if (this.jdField_a_of_type_Bnty != null)
    {
      this.jdField_a_of_type_Bnty.b();
      this.jdField_a_of_type_Bnty = null;
    }
    if (this.jdField_e_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    }
    super.i();
  }
  
  public void j()
  {
    if (SystemClock.uptimeMillis() - wyd.jdField_b_of_type_Long > 500L)
    {
      K();
      if ((this.w) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof HongBaoListView)) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mEnableStory) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mForStory))
      {
        if (this.jdField_a_of_type_Wyd != null) {
          this.jdField_a_of_type_Wyd.h();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.hideMiniAppEntry();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onFrameTabClick|mIsChatList:" + this.jdField_e_of_type_Boolean);
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Alms == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "refreshRecentHeadView|mChatAdapter is null.");
      }
      return;
    }
    Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(7);
    this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
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
      boolean bool1 = this.jdField_a_of_type_Aljw.a(1);
      boolean bool2 = this.jdField_a_of_type_Aljw.a(10);
      if ((bool1) || (bool2)) {
        c(800L);
      }
    }
    else
    {
      return;
    }
    if (bnrf.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      pfs.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
    c(60000L);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void o()
  {
    this.jdField_f_of_type_Boolean = true;
    if ((!this.jdField_j_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      C();
      bhsq.a("Recent_Start", null);
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
      this.jdField_a_of_type_Alof.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getWidth() - a().getDimensionPixelSize(2131298737) - a().getDimensionPixelSize(2131298738), a().getDimensionPixelSize(2131298739));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity instanceof MainFragment))) {
        ((MainFragment)this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).n();
      }
      if ((anbd.c() <= 0) || (anbd.b() <= 0)) {
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
        VipUtils.a(anbd.a(), "cmshow", "Apollo", "plusentrance", 0, 0, new String[] { "" + i1, "" + i2 });
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
        yup.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
        az();
        abiz.e();
        this.C = true;
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if ((paramView == this.jdField_b_of_type_AndroidWidgetImageView) || (paramView == this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch))
          {
            long l1 = System.currentTimeMillis();
            if (Math.abs(l1 - jdField_j_of_type_Long) < 500L) {
              jdField_j_of_type_Long = l1;
            } else {
              jdField_j_of_type_Long = l1;
            }
          }
        }
      }
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (this.jdField_h_of_type_Int != paramInt1)
    {
      long l1 = SystemClock.elapsedRealtime();
      double d1 = 1000.0D * (1.0D / (l1 - this.jdField_h_of_type_Long));
      if (paramInt1 > this.jdField_h_of_type_Int)
      {
        bool = true;
        this.z = bool;
        this.jdField_h_of_type_Int = paramInt1;
        this.jdField_h_of_type_Long = l1;
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
        this.jdField_k_of_type_Long = -1L;
      }
      if ((this.I) && (SystemClock.elapsedRealtime() - this.jdField_k_of_type_Long > 800L))
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
        if (QLog.isColorLevel()) {
          QLog.d("Conversation", 2, "onScroll cost time is below 1000 ms, isScroll2TopFlag: " + this.I + ", startScrollTime: " + this.jdField_k_of_type_Long);
        }
        this.I = false;
        this.jdField_k_of_type_Long = -1L;
      }
      return;
      bool = false;
      break;
      aonz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if (this.jdField_a_of_type_Wyd != null) {
        this.jdField_a_of_type_Wyd.b(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1)) {
        break label419;
      }
      if (this.jdField_a_of_type_Alms == null) {
        break label254;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i4 = this.jdField_a_of_type_Alms.getCount();
      this.jdField_b_of_type_Int = Math.max(i1, -1);
      if ((i1 < 0) || (i1 >= i4) || (i1 > i2 - i3)) {
        break label242;
      }
      localObject = this.jdField_a_of_type_Alms.getItem(i1);
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
    this.jdField_a_of_type_Alms.a(false);
    bhjs.a(false);
    label254:
    if (paramInt == 0)
    {
      aw();
      adlb.a().a("list_conv", false);
      ThreadRegulator.a().b(2);
      a(paramAbsListView);
      avxx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Alms, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      m(false);
      aq();
      aA();
      u();
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
      if (this.jdField_a_of_type_Aljw != null) {
        this.jdField_a_of_type_Aljw.b(this.G);
      }
      pge.a(paramAbsListView, paramInt);
      apeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAbsListView, paramInt);
      return;
      label419:
      if (this.jdField_a_of_type_Alms == null) {
        break;
      }
      this.jdField_a_of_type_Alms.a(true);
      bhjs.a(true);
      break;
      adlb.a().a("list_conv");
      ThreadRegulator.a().a(2);
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Aejz != null) {
      this.jdField_a_of_type_Aejz.b(false);
    }
    aejy localaejy = this.jdField_a_of_type_Aejy;
    if (localaejy != null) {
      localaejy.b(false);
    }
  }
  
  public void q()
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559652, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        if (this.jdField_a_of_type_Alof == null)
        {
          this.jdField_a_of_type_Alof = new alof(localBaseActivity);
          this.jdField_a_of_type_Alof.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new aehy(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_Bikv = ((bikv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76));
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
        ((HashMap)localObject2).put("device_mode", bhlo.d());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        bdmc localbdmc = bdmc.a(BaseApplicationImpl.getContext());
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label378;
        }
        localbdmc.a(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
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
      this.jdField_a_of_type_Alof = null;
      this.l = false;
      break label208;
      label378:
      l1 = 1L;
    }
  }
  
  void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_j_of_type_Boolean)) {}
    label124:
    for (;;)
    {
      return;
      if (((oek)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).b())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Alms != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
            if (!(this.jdField_a_of_type_Alms.getItem(i1) instanceof RecentItemEcShopAssitant)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!obj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (this.jdField_b_of_type_Avsm == null)) {
            break label124;
          }
          this.jdField_b_of_type_Avsm.a();
          return;
          i1 += 1;
          break;
        }
      }
    }
  }
  
  void s()
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void t()
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
          int i2 = baou.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localQQMessageFacade != null) {
            i1 = localQQMessageFacade.b();
          }
          this.jdField_d_of_type_Int = (i1 + i2);
          if (QLog.isColorLevel())
          {
            QLog.d("fetchUnReadCount", 2, String.format("Conversation, mUnReadCount[%s], msgUnReadCount[%s], callUnReadCount[%s], isCallTabShow[%s]", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(i1), Integer.valueOf(i2), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) }));
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
  
  void u()
  {
    if ((this.p) && (((aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).b("sp_mayknow_ml_s_a_vl")) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.isShown()) && (!this.jdField_a_of_type_Alms.isEmpty()))
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
          if (i3 < this.jdField_a_of_type_Alms.getCount())
          {
            i4 = i1;
            if (this.jdField_a_of_type_Alms.getItem(i3) != null)
            {
              Object localObject = this.jdField_a_of_type_Alms.getItem(i3);
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
  
  public void update(Observable paramObservable, Object paramObject)
  {
    d(paramObject);
    c(paramObject);
    b(paramObject);
    a(paramObject);
    b(paramObservable, paramObject);
    a(paramObservable, paramObject);
  }
  
  public void v()
  {
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, 1, 2130838779, "-conversation-");
  }
  
  public void w()
  {
    Object localObject = a();
    if (this.jdField_e_of_type_Boolean)
    {
      if (localObject == null) {}
      while (this.jdField_a_of_type_Alrd == null) {
        return;
      }
      boolean bool = this.jdField_a_of_type_Alrd.a((alms)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "moveToCaredItemCyclic: invoked.  canFindUnreadItem: " + bool + " currentCaredType:" + this.jdField_f_of_type_Int + " currentUnreadCaredItemIndex: " + this.jdField_g_of_type_Int);
      }
      int i1 = (int)(a().getResources().getDimension(2131298730) + a().getResources().getDimension(2131298747) / 2.0F);
      int i2 = this.jdField_g_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      if (this.jdField_g_of_type_Int == 0) {
        i1 = 0;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "moveToCaredItemCyclic: invoked. selection1 ", " position: ", Integer.valueOf(i2) });
        }
        this.jdField_a_of_type_Alrd.c();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(i2, i1);
        localObject = new Conversation.57(this, i2);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed((Runnable)localObject, 250L);
      }
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1E3", "0X800A1E3", 0, 0, "", "", "", "");
  }
  
  void x()
  {
    if (this.jdField_a_of_type_Blir == null)
    {
      this.jdField_a_of_type_Blir = blir.a(a());
      this.jdField_a_of_type_Blir.b(2131691104);
      this.jdField_a_of_type_Blir.c(2131690580);
      this.jdField_a_of_type_Blir.a(new aejd(this));
    }
    this.jdField_a_of_type_Blir.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation
 * JD-Core Version:    0.7.0.1
 */