package com.tencent.mobileqq.activity;

import aamh;
import aamj;
import aamk;
import aaml;
import aamm;
import aamn;
import aamo;
import aamp;
import aamq;
import aamr;
import aams;
import aamt;
import aamu;
import aamv;
import aamw;
import aamx;
import aamy;
import aamz;
import aana;
import aanb;
import aanc;
import aand;
import aane;
import aanf;
import aang;
import aanh;
import aani;
import aanj;
import aank;
import aanl;
import aanm;
import aanp;
import aanq;
import aans;
import aant;
import aanu;
import aanv;
import aanw;
import aanx;
import aany;
import aanz;
import aaoc;
import aaod;
import aaog;
import abnn;
import acep;
import acjz;
import afdg;
import agtk;
import agtx;
import agty;
import agud;
import agxq;
import agzt;
import agzu;
import ahab;
import ahai;
import ahap;
import ahay;
import ahbe;
import ahbv;
import ahca;
import ahcb;
import ahco;
import ahcp;
import ahcq;
import ahcw;
import ahek;
import ahwj;
import aing;
import ajed;
import ajex;
import ajey;
import ajfo;
import ajgd;
import ajgf;
import ajgs;
import ajhi;
import ajii;
import ajix;
import ajjh;
import ajjj;
import ajjy;
import ajjz;
import ajkn;
import ajls;
import ajmm;
import ajpv;
import ajrb;
import ajre;
import ajsa;
import ajss;
import ajuc;
import ajuk;
import ajyv;
import akaq;
import akeu;
import akhu;
import akif;
import akij;
import akiq;
import alfo;
import alij;
import amda;
import amdb;
import amdc;
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
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.System;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ansl;
import aodp;
import aoii;
import aosu;
import aqeb;
import aqiw;
import aqiy;
import aqja;
import aqkz;
import areo;
import arih;
import ariz;
import arjb;
import ascr;
import atdh;
import atsk;
import aufl;
import auqh;
import auql;
import awnu;
import awqu;
import awqx;
import awrb;
import awrn;
import awuw;
import axam;
import axfs;
import axkz;
import axoy;
import axpc;
import axpg;
import axqi;
import axqw;
import axvo;
import azkm;
import azlf;
import azlj;
import azlm;
import azvw;
import azys;
import azzv;
import azzz;
import babh;
import babk;
import babp;
import babr;
import badq;
import badx;
import baep;
import baic;
import baig;
import baio;
import baip;
import bajr;
import bawl;
import bawm;
import bbms;
import bbmy;
import beez;
import befe;
import befx;
import begh;
import begr;
import belq;
import benm;
import beoj;
import bffc;
import bgmq;
import biig;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
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
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import ldc;
import mjg;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import mxu;
import myd;
import myn;
import ncw;
import ndn;
import nfp;
import obz;
import ohp;
import oia;
import org.json.JSONException;
import org.json.JSONObject;
import rol;
import rqn;
import rsp;
import sgc;
import sgj;
import ssr;
import stf;
import stg;
import svc;
import urp;
import xfs;
import zqk;

public class Conversation
  extends ajii
  implements acep, ahab, ahap, ajed, ajix, Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, begh, belq, benm, Observer
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
  private aanx jdField_a_of_type_Aanx;
  aany jdField_a_of_type_Aany = new aany(this);
  private aaoc jdField_a_of_type_Aaoc;
  aaod jdField_a_of_type_Aaod = null;
  aaog jdField_a_of_type_Aaog = null;
  abnn jdField_a_of_type_Abnn = new aanh(this);
  afdg jdField_a_of_type_Afdg;
  private agtx jdField_a_of_type_Agtx = new aamr(this);
  private agty jdField_a_of_type_Agty;
  private agud jdField_a_of_type_Agud;
  public agxq a;
  private agzu jdField_a_of_type_Agzu;
  public ahai a;
  public ahbv a;
  private ahcb jdField_a_of_type_Ahcb;
  ahcp jdField_a_of_type_Ahcp;
  public ahek a;
  protected ajey a;
  ajfo jdField_a_of_type_Ajfo = new aamy(this);
  private final ajgf jdField_a_of_type_Ajgf = new aamv(this);
  private final ajgs jdField_a_of_type_Ajgs = new aanb(this);
  ajhi jdField_a_of_type_Ajhi = new aamz(this);
  private final ajjh jdField_a_of_type_Ajjh = new aams(this);
  private ajkn jdField_a_of_type_Ajkn = new aanl(this);
  private final ajmm jdField_a_of_type_Ajmm = new aamx(this);
  private ajrb jdField_a_of_type_Ajrb = new aanz(this);
  private ajre jdField_a_of_type_Ajre = new aang(this);
  private ajsa jdField_a_of_type_Ajsa = new aanm(this);
  private final ajss jdField_a_of_type_Ajss = new aanc(this);
  private final ajuc jdField_a_of_type_Ajuc = new aamt(this);
  ajuk jdField_a_of_type_Ajuk = new aamw(this);
  private akif jdField_a_of_type_Akif = new aamn(this);
  public Dialog a;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aani(this);
  protected Handler.Callback a;
  public GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public ImageView a;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aodp jdField_a_of_type_Aodp;
  private aqeb jdField_a_of_type_Aqeb = new aqeb("tool_adMessage", "com.tencent.mobileqq:tool");
  public areo a;
  private final atdh jdField_a_of_type_Atdh = new aane(this);
  public atsk a;
  bawm jdField_a_of_type_Bawm = null;
  private bbms jdField_a_of_type_Bbms;
  public begr a;
  private Conversation.DateFormatChangeRunnable jdField_a_of_type_ComTencentMobileqqActivityConversation$DateFormatChangeRunnable = new Conversation.DateFormatChangeRunnable(this, null);
  public QQSettingMe a;
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  public FrameHelperActivity a;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private MiniAppPullInterface jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
  public RedTouch a;
  public PullRefreshHeader a;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public Runnable a;
  public String a;
  protected StringBuilder a;
  public ArrayList<alij> a;
  public List<RecentBaseData> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final ldc jdField_a_of_type_Ldc = new aand(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aans(this);
  public MqqHandler a;
  private final sgc jdField_a_of_type_Sgc = new aanf(this);
  public svc a;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  Dialog jdField_b_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new aanj(this);
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  private aqeb jdField_b_of_type_Aqeb = new aqeb("tool_shop", "com.tencent.mobileqq:tool");
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  protected Runnable b;
  public String b;
  final List<String> jdField_b_of_type_JavaUtilList = new ArrayList(40);
  public MqqHandler b;
  public boolean b;
  int jdField_c_of_type_Int;
  public long c;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new aank(this);
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private aqeb jdField_c_of_type_Aqeb = new aqeb("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private Runnable jdField_c_of_type_JavaLangRunnable;
  MqqHandler jdField_c_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this.jdField_a_of_type_Aany);
  public boolean c;
  public int d;
  long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private Runnable jdField_d_of_type_JavaLangRunnable = new Conversation.4(this);
  public boolean d;
  int jdField_e_of_type_Int = 3;
  public long e;
  private View jdField_e_of_type_AndroidViewView;
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
  public boolean p = false;
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
    this.jdField_f_of_type_Int = 17;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new aamh(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new Conversation.27(this);
    this.jdField_a_of_type_Ajey = new aamu(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(BaseApplicationImpl.getContext(), new aanu(this));
    this.jdField_b_of_type_JavaLangRunnable = new Conversation.60(this);
  }
  
  private void C()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Ahai.c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1025);
    this.jdField_j_of_type_Boolean = true;
    if (!this.k) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    BaseApplicationImpl.sApplication.onActivityFocusChanged(a(), true);
  }
  
  private void D()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 50L);
  }
  
  private void E()
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
  
  private void F()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ahai != null)) {}
    }
    else
    {
      return;
    }
    int i3 = this.jdField_a_of_type_Ahai.getCount();
    int i1 = this.jdField_b_of_type_Int + 1;
    label96:
    int i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Object localObject = this.jdField_a_of_type_Ahai.getItem(i1);
        if (!(localObject instanceof RecentBaseData))
        {
          i1 += 1;
        }
        else
        {
          localObject = (RecentBaseData)localObject;
          if (((RecentBaseData)localObject).a())
          {
            i2 = ((RecentBaseData)localObject).b();
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
        E();
        this.jdField_b_of_type_Int = -1;
      }
      break;
      i2 = 0;
      break label124;
      label276:
      break label96;
    }
  }
  
  private void G()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.jdField_f_of_type_Long);
    if ((this.jdField_a_of_type_Ahai != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (ahcw.a().a(str)) {
        this.jdField_f_of_type_Long = l1;
      }
    }
  }
  
  private void H()
  {
    if (arih.a().b()) {
      arih.a().a(3);
    }
  }
  
  private void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMWrapper", 2, "Conversation showUpgradeDetailInfoIfNeccessary mInitTimUpgradeInfo : " + this.F);
    }
    if ((!this.w) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a()))
    {
      if (this.w)
      {
        if ((!ajgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.F))
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
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.show();
      ajgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i1 = ajgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ajgd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1 + 1);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void J()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
  }
  
  private void K()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131299135));
    this.jdField_a_of_type_Aanx = new aanx(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_Aanx, false);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.p = false;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131309736));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311626));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299191));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131310682));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302847));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131654133);
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      awnu.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303650);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131309126));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDescendantInvalidatedFlags(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(a().getDrawable(2130839107));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setIsNeedScrollPositionTop(true);
        Object localObject4 = a();
        if ((localObject4 != null) && ((localObject4 instanceof SplashActivity)))
        {
          Object localObject3 = (SplashActivity)localObject4;
          Object localObject1 = ((SplashActivity)localObject3).jdField_b_of_type_AndroidViewView;
          ((SplashActivity)localObject3).jdField_b_of_type_AndroidViewView = null;
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (localObject4 != null) {
              localObject3 = ((AppActivity)localObject4).getLayoutInflater().inflate(2131496761, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
            }
          }
          if (localObject3 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject3, 0);
            this.jdField_a_of_type_Afdg = new afdg(a(), 1, (View)localObject3);
            this.jdField_b_of_type_AndroidViewView = ((View)localObject3);
          }
          this.jdField_a_of_type_Agxq = new agxq(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          localObject1 = a();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
          if (!ahay.a().jdField_a_of_type_Boolean)
          {
            bool = true;
            this.jdField_a_of_type_Ahai = new ahai((Context)localObject1, (QQAppInterface)localObject3, (XListView)localObject4, this, 0, bool);
            this.jdField_a_of_type_Ahai.b(true);
            this.jdField_a_of_type_Ahai.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Ahai);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
            this.jdField_a_of_type_Ahai.a(this);
            this.jdField_c_of_type_AndroidViewView = new View(a());
            localObject1 = new AbsListView.LayoutParams(-1, 0);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView, null, false);
            localObject1 = ahay.a().jdField_b_of_type_JavaUtilList;
            this.jdField_a_of_type_Ahai.a((List)localObject1);
            this.jdField_a_of_type_Ahai.a(0);
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.q();
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
            this.jdField_a_of_type_Atsk = new atsk(this, this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_a_of_type_Areo = new areo(this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131299197));
            IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
            this.jdField_a_of_type_Agud = new agud(this, this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Agud);
            return;
            a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
            a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848801);
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131101257));
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
            Object localObject2 = null;
          }
        }
      }
    }
  }
  
  private void L()
  {
    Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if ((localManager instanceof auqh))
    {
      int i1 = ((auqh)localManager).a("104000.104001", 100);
      if (i1 > 0) {
        a(8, ajed.aA, 7230);
      }
      QLog.d("Q.recent", 2, "uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "getSubscribeAccountRedDotNum  redNumByPath:" + i1);
    }
  }
  
  private void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "initMiniAppEntryLayout.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface == null)
    {
      if (amda.g()) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface = new MiniAppDesktop(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface = new QQMessagePageMiniAppEntryManager(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
  }
  
  private void N()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    T();
    a(1010, 0L, false);
    a(1023, 0L, false);
    I();
    auql.a(this);
    if (!this.jdField_e_of_type_Boolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2);
    }
    O();
  }
  
  private void O()
  {
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void P()
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajey);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajgf);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuk);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajfo);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajhi);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajss);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajgs);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajkn);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Sgc);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atdh);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajre);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsa);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Ldc);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
        }
        if (this.jdField_a_of_type_Aodp != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aodp);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Abnn);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajrb);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akif);
        localObject1 = (aufl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject1 != null) {
          ((aufl)localObject1).deleteObserver(this);
        }
        localObject1 = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (localObject1 != null) {
          ((auqh)localObject1).deleteObserver(this);
        }
        if (this.jdField_a_of_type_Areo != null) {
          this.jdField_a_of_type_Areo.c();
        }
        ((agtk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).b(this.jdField_a_of_type_Agtx);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(17);
      try
      {
        localObject1 = a();
        if (this.jdField_a_of_type_Aaoc != null)
        {
          ((BaseActivity)localObject1).app.a().b(this.jdField_a_of_type_Aaoc);
          this.jdField_a_of_type_Aaoc.a();
          this.jdField_a_of_type_Aaoc = null;
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
  
  private void Q()
  {
    if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(true))) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidViewView == null);
      localObject = this.jdField_a_of_type_Ahai.getItem(0);
    } while (!(localObject instanceof RecentUserBaseData));
    Object localObject = (RecentUserBaseData)localObject;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    boolean bool;
    label98:
    int i1;
    if ((((RecentUserBaseData)localObject).mUser.getType() == 1) && (!ascr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUserBaseData)localObject).mUser)))
    {
      bool = localTroopManager.b(((RecentUserBaseData)localObject).a());
      if (this.B == bool) {
        break label217;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent", 4, "setLocalSearchBarByShowUpMask:mShowUPMask = " + this.B + ", dstMsg = " + bool);
      }
      if (!bool) {
        break label219;
      }
      i1 = 2130848986;
      label160:
      if (!bool) {
        break label226;
      }
    }
    label217:
    label219:
    label226:
    for (int i2 = 2130848997;; i2 = 2130848996)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(i1);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131300167).setBackgroundResource(i2);
      this.B = bool;
      return;
      if (((RecentUserBaseData)localObject).mUser.showUpTime > 0L)
      {
        bool = true;
        break label98;
      }
      bool = false;
      break label98;
      break;
      i1 = 2130848985;
      break label160;
    }
  }
  
  private void R()
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
      if ((axfs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (axfs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ahai != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          label73:
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition())
          {
            Object localObject = this.jdField_a_of_type_Ahai.getItem(i1);
            if ((!(localObject instanceof RecentItemTencentDocsAssistantData)) || (((RecentItemTencentDocsAssistantData)localObject).b() <= 0)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!ncw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            break label170;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess call");
          }
          if (this.jdField_c_of_type_Aqeb == null) {
            break;
          }
          this.jdField_c_of_type_Aqeb.a();
          return;
          i1 += 1;
          break label73;
        }
      }
    }
  }
  
  private void S()
  {
    this.jdField_a_of_type_Aodp = new aana(this);
  }
  
  private void T()
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
    while (i1 >= this.jdField_a_of_type_Ahai.getCount())
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
      i2 = 0;
      break;
    }
    Object localObject = this.jdField_a_of_type_Ahai.getItem(i1);
    if ((localObject != null) && ((localObject instanceof RecentBaseData)))
    {
      localObject = (RecentBaseData)localObject;
      if (!(localObject instanceof RecentItemImaxADData)) {}
    }
    for (;;)
    {
      i3 += 1;
      break;
      this.jdField_a_of_type_Ahai.a().a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a(), false);
      i1 += i2;
    }
  }
  
  private void U()
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfAgzw[0] = new aanq(this);
  }
  
  private void V()
  {
    if ((this.w) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      ThreadManager.post(new Conversation.53(this), 5, null, true);
    }
  }
  
  private void W()
  {
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_Ahbv != null))
    {
      this.jdField_a_of_type_Ahbv.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1048, 0, 0).sendToTarget();
    }
  }
  
  private void X()
  {
    if (!this.w) {
      break label7;
    }
    label7:
    while (!this.jdField_a_of_type_Agxq.b(20)) {
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
      ThreadManager.post(new Conversation.54(this, this.jdField_a_of_type_Agxq.a(20, 2131296607)), 5, null, false);
      return;
    }
  }
  
  private void Y()
  {
    try
    {
      if (this.jdField_a_of_type_Bbms == null)
      {
        this.jdField_a_of_type_Bbms = new bbms(a(), a().getTitleBarHeight());
        this.jdField_a_of_type_Bbms.c(2131629240);
        this.jdField_a_of_type_Bbms.c(false);
        this.jdField_a_of_type_Bbms.setOnDismissListener(new aanv(this));
      }
      this.jdField_a_of_type_Bbms.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void Z()
  {
    try
    {
      if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 800L);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
        aamj localaamj = new aamj(this);
        aamk localaamk = new aamk(this, localUpgradeTIMWrapper);
        if (TextUtils.isEmpty(localUpgradeTIMWrapper.d))
        {
          paramMessage = ajjy.a(2131636805);
          if (!TextUtils.isEmpty(localUpgradeTIMWrapper.e)) {
            break label323;
          }
          str = ajjy.a(2131636815);
          this.jdField_c_of_type_AndroidAppDialog = babr.a(a(), localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString, localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString, paramMessage, str, null, localaamk, localaamj);
          this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new aaml(this));
          if ((!this.w) || (this.jdField_c_of_type_AndroidAppDialog.isShowing()) || ((this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.isShowing())) || (ajgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            continue;
          }
          this.jdField_c_of_type_AndroidAppDialog.show();
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
          ajgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  
  private void a(AbsListView paramAbsListView)
  {
    int i1;
    if ((paramAbsListView != null) && (this.jdField_a_of_type_Ahai != null))
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
          localObject1 = this.jdField_a_of_type_Ahai.getItem(i2);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemPublicAccountADFolderData))) {
            break label226;
          }
          localObject1 = (RecentItemPublicAccountADFolderData)localObject1;
          if (!aqja.a(paramAbsListView.getChildAt(i2 - i1))) {
            break label226;
          }
          localObject1 = myd.a().a(((RecentItemPublicAccountADFolderData)localObject1).mUser.uin);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Message localMessage = Message.obtain();
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("key_app", new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        ((HashMap)localObject2).put("key_adapter", new WeakReference(this.jdField_a_of_type_Ahai));
        ((HashMap)localObject2).put("key_listview", new WeakReference(paramAbsListView));
        localMessage.obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_ad_id", ((mxu)localObject1).c);
        localMessage.setData((Bundle)localObject2);
        localMessage.what = 1;
        aqiw.a().a(localMessage);
        i2 += 1;
      }
    }
  }
  
  public static void a(MqqHandler paramMqqHandler, Context paramContext)
  {
    paramMqqHandler.removeMessages(1134065);
    if (FriendsStatusUtil.a(paramContext))
    {
      awqx.b(null, "CliOper", "", "", "0X8009EB9", "0X8009EB9", 0, 1, "", "", "", "");
      Message localMessage = paramMqqHandler.obtainMessage(1134065);
      localMessage.arg1 = 2;
      paramMqqHandler.sendMessage(localMessage);
      long l1 = FriendsStatusUtil.a(paramContext);
      if (l1 > 0L) {
        paramMqqHandler.postDelayed(new Conversation.35(paramMqqHandler), l1 * 1000L);
      }
      return;
    }
    paramContext = paramMqqHandler.obtainMessage(1134065);
    paramContext.arg1 = 0;
    paramMqqHandler.sendMessage(paramContext);
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceiverShowUpgradeTips");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) || (!(paramMessage.obj instanceof UpgradeDetailWrapper))) {}
    do
    {
      return;
      paramMessage = (UpgradeDetailWrapper)paramMessage.obj;
      if (ajgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) >= 5)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((ajgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (ajgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog = new UpgradeTipsDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.setOnDismissListener(new aamm(this));
  }
  
  private void b(List<RecentBaseData> paramList)
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
          if (((((RecentUserBaseData)localObject).a() == 1) && (!ascr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUserBaseData)localObject).mUser)) && (localTroopManager.b(((RecentUserBaseData)localObject).a()))) || (((RecentUserBaseData)localObject).mUser.showUpTime != 0L)) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(((RecentUserBaseData)localObject).a()).append("-").append(baip.e(((RecentUserBaseData)localObject).a())).append("-").append(i1).append(" , ");
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
  
  private void c(long paramLong)
  {
    if (this.jdField_g_of_type_Boolean) {
      a(1016, paramLong, true);
    }
  }
  
  private void j(boolean paramBoolean)
  {
    if (this.m != paramBoolean)
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
    if (this.jdField_a_of_type_Svc == null) {
      this.jdField_a_of_type_Svc = new svc(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, (BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301963));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)) {
      this.jdField_a_of_type_Svc.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
    }
    this.jdField_a_of_type_Svc.jdField_f_of_type_Boolean = this.w;
    this.jdField_a_of_type_Svc.b();
    for (this.s = false;; this.s = false)
    {
      this.m = paramBoolean;
      return;
      label149:
      if (this.jdField_a_of_type_Svc != null) {
        this.jdField_a_of_type_Svc.c();
      }
    }
  }
  
  private void k(boolean paramBoolean)
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajey, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajgf, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuk, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajfo, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajhi, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajss, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atdh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajgs);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajkn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Sgc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajre);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Abnn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    Object localObject2 = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject2 != null) {
      ((auqh)localObject2).addObserver(this);
    }
    if (this.jdField_a_of_type_Aodp == null) {
      S();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aodp);
    if (this.jdField_a_of_type_Aaoc == null) {
      this.jdField_a_of_type_Aaoc = new aaoc(this);
    }
    this.jdField_a_of_type_Aaoc.addFilter(new Class[] { axoy.class, axpc.class, C2CPttDownloadProcessor.class, axpg.class, axqw.class, GroupPttDownloadProcessor.class, axqi.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aaoc);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
        localObject2 = (aufl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject2 != null) {
          ((aufl)localObject2).addObserver(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Ldc);
        mjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsa);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajrb);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akif);
        if (this.jdField_a_of_type_Areo != null) {
          this.jdField_a_of_type_Areo.b();
        }
        ((agtk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).a(this.jdField_a_of_type_Agtx);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.w();
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
  
  private void l(boolean paramBoolean)
  {
    if ((!rsp.k) || ((!paramBoolean) && (ncw.a().jdField_a_of_type_Boolean))) {}
    label151:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ahai != null))
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
        if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
          if (!(this.jdField_a_of_type_Ahai.getItem(i1) instanceof RecentItemPublicAccountADFolderData)) {}
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label151;
        }
        if ((this.jdField_a_of_type_Aqeb != null) && (!this.x))
        {
          this.jdField_a_of_type_Aqeb.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.x = true;
        }
        ncw.a().jdField_a_of_type_Boolean = true;
        ThreadManager.getSubThreadHandler().postDelayed(new Conversation.24(this), 1000L);
        return;
        i1 += 1;
        break;
      }
    }
  }
  
  int a()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Ahai.getCount())
    {
      if ((this.jdField_a_of_type_Ahai.getItem(i1) instanceof RecentItemMayKnowFriendVerticalListData)) {
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
      } while (ahcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
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
  
  public ahai a()
  {
    return this.jdField_a_of_type_Ahai;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    baio.a(null, "Recent_Start");
    baio.a(null, "Recent_CreateView");
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
        localObject2 = paramLayoutInflater.inflate(2131493307, null);
      }
      baio.a("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public String a()
  {
    String str = ajjy.a(2131636812);
    if (this.jdField_d_of_type_Int <= 0) {
      return str;
    }
    if (this.jdField_d_of_type_Int > 99) {
      return str + "(99+)";
    }
    return str + "(" + this.jdField_d_of_type_Int + ")";
  }
  
  public svc a()
  {
    return this.jdField_a_of_type_Svc;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onActivityResult, [" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    }
    switch (paramInt1)
    {
    case 21: 
    default: 
    case 14002: 
    case 2: 
    case 1000: 
    case 1300: 
    case 9001: 
    case 9002: 
    case 9010: 
    case 14005: 
    case 14006: 
      Object localObject;
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
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while ((paramIntent == null) || (paramInt2 != -1));
                      localObject = awuw.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
                    } while (localObject == null);
                    String str = paramIntent.getStringExtra("uin");
                    paramInt1 = paramIntent.getIntExtra("uintype", -1);
                    paramInt2 = paramIntent.getIntExtra("cmshow_game_id", -1);
                    baic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramInt1, (AbsStructMsg)localObject, null);
                    bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(paramInt1), 0, new String[] { Integer.toString(paramInt2) });
                    return;
                  } while (a() == null);
                  a().setCanLock(false);
                  return;
                } while (paramInt2 != 0);
                z();
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
                return;
              } while ((-1 != paramInt2) || (paramIntent == null));
              paramIntent = paramIntent.getStringExtra("roomId");
            } while (paramIntent == null);
            azlj.a(a(), paramIntent, true);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
            return;
          } while (paramInt2 != -1);
          bbmy.a(a(), 2, a(2131654673), 0).b(a().getTitleBarHeight());
          return;
        } while (!QLog.isColorLevel());
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + -1);
        return;
        ahbv.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
        return;
        localObject = aing.a();
      } while (localObject == null);
      ((ApolloSurfaceView)localObject).runRenderTask(new Conversation.5(this, (ApolloSurfaceView)localObject, paramInt1, paramInt2, paramIntent));
      return;
    }
    ThreadManager.excute(new Conversation.6(this), 16, null, true);
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
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null))
    {
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.ar_();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    String str;
    akeu localakeu;
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      str = "1";
      localakeu = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject2 = paramRecentBaseData.a();
      localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((paramInt != 7000) || (ajed.x.equals(localObject2))) {
        break label173;
      }
      axam.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, paramBoolean);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str, paramString, "");
    }
    int i2;
    int i1;
    for (;;)
    {
      i2 = a(paramRecentBaseData.a(), paramInt);
      paramRecentBaseData = localakeu.a(false).iterator();
      i1 = 0;
      label162:
      while (paramRecentBaseData.hasNext())
      {
        if (((RecentUser)paramRecentBaseData.next()).showUpTime == 0L) {
          break label1620;
        }
        i1 += 1;
      }
      str = "0";
      break;
      label173:
      if (paramInt == 5000)
      {
        if (this.jdField_a_of_type_Ahcp != null) {
          this.jdField_a_of_type_Ahcp.a(paramRecentBaseData, paramBoolean);
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", str, paramString, "");
      }
      else
      {
        if (paramInt != 5001) {
          break label262;
        }
        ((ajjz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramBoolean);
      }
    }
    label262:
    if (paramInt == 1)
    {
      paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject1 = paramString.d(paramRecentBaseData.a());
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = (ajex)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
        if (paramBoolean)
        {
          i1 = 0;
          label320:
          if (((ajex)localObject2).a((String)localObject1, i1)) {
            break label339;
          }
        }
      }
    }
    label332:
    label339:
    label606:
    label612:
    do
    {
      do
      {
        return;
        i1 = 1;
        break label320;
        paramString = paramString.c(paramRecentBaseData.a());
        if (paramString != null) {}
        switch (paramString.troopmask)
        {
        case 2: 
        case 3: 
        default: 
          i1 = 0;
          localObject1 = new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
          localObject2 = paramRecentBaseData.a();
          if (!paramBoolean) {
            break;
          }
        }
        for (paramString = "0";; paramString = "1")
        {
          ((awrb)localObject1).a(new String[] { localObject2, String.valueOf(i1), paramString }).a();
          break;
          i1 = 0;
          break label391;
          i1 = 3;
          break label391;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.recent", 2, "TroopManage.getTroopCodeByTroopUin return null...");
        }
        i1 = paramRecentBaseData.a();
        if ((localObject2 != null) && (((String)localObject2).length() != 0) && (localakeu != null)) {
          break label612;
        }
      } while (!QLog.isColorLevel());
      paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
      if (localObject2 == null)
      {
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (localakeu != null) {
          break label606;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("Q.recent", 2, paramBoolean);
        return;
        paramBoolean = false;
        break;
      }
      localObject1 = localakeu.b((String)localObject2, i1);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = new RecentUser((String)localObject2, i1);
      }
      if (!ascr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) {
        break;
      }
      if (paramBoolean) {}
      for (paramString.showUpTime = (System.currentTimeMillis() / 1000L);; paramString.showUpTime = 0L)
      {
        localakeu.a(paramString);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        break;
      }
      if ((paramInt == 0) && (((ajjj)localObject1).b((String)localObject2)))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramBoolean) {}
        for (i1 = 1;; i1 = 2)
        {
          awqx.b(paramString, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i1, "0", "0", "", "");
          if (badq.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
            break;
          }
          bbmy.a(a(), 1, 2131630710, 0).b(a().getTitleBarHeight());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "setChatAtTop top: " + paramBoolean + " uin: " + (String)localObject2 + " userType: " + paramInt);
        }
        FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, paramBoolean);
        break;
      }
      i1 = paramRecentBaseData.a();
      if ((localObject2 != null) && (((String)localObject2).length() != 0) && (localakeu != null)) {
        break label976;
      }
    } while (!QLog.isColorLevel());
    label391:
    paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
    if (localObject2 == null)
    {
      paramBoolean = true;
      paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
      if (localakeu != null) {
        break label970;
      }
    }
    label970:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("Q.recent", 2, paramBoolean);
      return;
      paramBoolean = false;
      break;
    }
    label976:
    paramString = localakeu.b((String)localObject2, i1);
    if (paramString == null) {
      paramString = new RecentUser((String)localObject2, i1);
    }
    label1319:
    for (;;)
    {
      label1018:
      int i3;
      if (paramBoolean)
      {
        paramString.showUpTime = (System.currentTimeMillis() / 1000L);
        localakeu.a(paramString);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        if ((i1 != 7210) && (i1 != 7120)) {
          break label1274;
        }
        i3 = paramRecentBaseData.mUnreadNum;
        localObject1 = "0X80064C4";
        if (paramBoolean) {
          localObject1 = "0X80064C3";
        }
        if (i1 != 7120) {
          break label1629;
        }
      }
      label1099:
      label1232:
      label1620:
      label1623:
      label1626:
      label1629:
      for (i2 = 1;; i2 = 0)
      {
        Iterator localIterator = localakeu.a(false).iterator();
        i1 = 0;
        if (localIterator.hasNext())
        {
          if (((RecentUser)localIterator.next()).showUpTime == 0L) {
            break label1626;
          }
          i1 += 1;
        }
        for (;;)
        {
          break label1099;
          paramString.showUpTime = 0L;
          break label1018;
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + i2, (String)localObject1, (String)localObject1, 0, 0, "" + i3, "" + i1, "", "");
          for (;;)
          {
            if ((7220 == paramString.getType()) && (ajed.az.equals(localObject2)))
            {
              ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).c(paramBoolean);
              break;
              label1274:
              if (i1 == 1008)
              {
                i2 = paramRecentBaseData.mUnreadNum;
                localObject1 = "0X80064C8";
                if (paramBoolean) {
                  localObject1 = "0X80064C7";
                }
                localIterator = localakeu.a(false).iterator();
                i1 = 0;
                if (localIterator.hasNext())
                {
                  if (((RecentUser)localIterator.next()).showUpTime == 0L) {
                    break label1623;
                  }
                  i1 += 1;
                }
              }
            }
          }
          for (;;)
          {
            break label1319;
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", paramString.uin, (String)localObject1, (String)localObject1, 0, 0, "" + i2, "" + i1, "", "");
            if (!"2290230341".equals(localObject2)) {
              break label1232;
            }
            if (paramBoolean) {}
            for (localObject1 = "0X80090E6";; localObject1 = "0X800915B")
            {
              if (paramBoolean) {
                awqu.a(4);
              }
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
              break label1232;
              break;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, str, String.valueOf(i1), String.valueOf(i2), "");
            if (paramInt != 7220) {
              break label332;
            }
            if (paramBoolean)
            {
              ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
              return;
            }
            ndn.a(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
            return;
            break label162;
          }
        }
      }
    }
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
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_Agxq != null)) {
        this.jdField_a_of_type_Agxq.a(paramRecentUser.uin);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.getType());
      }
    } while ((paramInt & 0x4) == 0);
    ahcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, -1);
    bbmy.a(a(), ajjy.a(2131636811), 0).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 8) && (paramInt1 != 9)) {
      return;
    }
    a(0, paramInt1, ahay.a(paramString, paramInt2));
  }
  
  public void a(int paramInt, List<RecentBaseData> paramList)
  {
    if ((-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a()) || ((this.G) && (this.H)))
    {
      this.jdField_a_of_type_Aanx.a(paramInt, paramList);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      if (AppSetting.jdField_h_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.8(this));
      }
      return;
    }
    Object localObject;
    int i1;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder().append("doRefreshUI|[").append(paramInt).append(",");
      if (paramList == null)
      {
        i1 = 0;
        QLog.i("Q.recent", 4, i1 + "]，shouldShowConversationMayknow = " + this.p);
      }
    }
    else if (this.jdField_a_of_type_Ahai != null)
    {
      if (paramInt != 0) {
        break label432;
      }
      if (this.p)
      {
        localObject = (ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
        if ((((ajls)localObject).jdField_a_of_type_Boolean) && (((ajls)localObject).a(paramList))) {
          ((ajls)localObject).jdField_a_of_type_Boolean = false;
        }
      }
      this.jdField_a_of_type_Ahai.a(paramList);
      if (this.D)
      {
        this.D = false;
        if (this.E)
        {
          if (!this.jdField_f_of_type_Boolean) {
            break label425;
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addOnLayoutChangeListener(new aanw(this));
        }
      }
    }
    for (;;)
    {
      this.E = false;
      if (paramList != null) {
        ahay.a().a(paramList);
      }
      this.jdField_a_of_type_Ahai.a(0);
      if (AppSetting.jdField_h_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.10(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_d_of_type_Int);
      a(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      if (this.n)
      {
        this.n = false;
        if ((((stg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Svc != null)) {
          this.jdField_a_of_type_Svc.e();
        }
      }
      if (this.y)
      {
        this.y = false;
        R();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
      Q();
      akij.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, 0);
      return;
      i1 = paramList.size();
      break;
      label425:
      Z();
    }
    label432:
    if (paramList == null)
    {
      paramInt = 0;
      label438:
      i1 = 0;
      label440:
      if (i1 < paramInt)
      {
        localObject = (RecentBaseData)paramList.get(i1);
        if (localObject != null) {
          break label479;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label440;
      break;
      paramInt = paramList.size();
      break label438;
      label479:
      this.jdField_a_of_type_Ahai.a((RecentBaseData)localObject);
    }
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    if (!paramBoolean1)
    {
      H();
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
      this.jdField_a_of_type_Agxq.a(8, 0);
    }
    boolean bool1;
    int i1;
    label111:
    boolean bool2;
    if (!paramBoolean1)
    {
      bool1 = true;
      arih.a().a(bool1);
      localObject1 = this.jdField_a_of_type_Agxq;
      if (!bool1) {
        break label244;
      }
      i1 = 2;
      ((agxq)localObject1).a(1, i1);
      bool2 = arih.a().d();
      if ((!bool2) || (paramInt != 1134012)) {
        break label352;
      }
      bool2 = false;
    }
    label352:
    for (;;)
    {
      arih.a().b(bool2);
      localObject1 = this.jdField_a_of_type_Agxq;
      i1 = i2;
      if (bool2) {
        i1 = 2;
      }
      ((agxq)localObject1).a(9, i1);
      this.jdField_a_of_type_Agxq.a(-1, null);
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (alij)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              ((alij)localObject2).b(paramBoolean1);
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
      e(bool1 | bool2 | paramBoolean2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(150);
        ((StringBuilder)localObject1).append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", isNetSupport = ").append(paramBoolean1).append(", loadingState = ").append(arih.a().a()).append(", msg = ").append(paramInt);
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
    int i1 = azys.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    azys.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i1 + 1);
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
    if ((this.jdField_a_of_type_Ahbv != null) && (this.jdField_a_of_type_Ahbv.a())) {
      this.jdField_a_of_type_Ahbv.b();
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
        paramMessage.append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", initLoadingHandle = ").append(paramBoolean).append(", loadingState = ").append(arih.a().a()).append(", what = ").append(i1);
        QLog.i("Q.recent", 2, paramMessage.toString());
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean) {
        break;
      }
      a(i1, true, paramBoolean);
      a(i1, true);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new Conversation.2(this, i1, paramBoolean));
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Ahai == null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = this.jdField_a_of_type_Ahai.a(paramView);
      if ((localRecentBaseData != null) && ("9970".equals(localRecentBaseData.a()))) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
      }
    } while ((localRecentBaseData == null) || (!ajed.aA.equals(localRecentBaseData.a())));
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
      ThreadManager.executeOnSubThread(new Conversation.7(this, i1, i2, i3));
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
    if ((paramString.equals("sp_uin_for_title")) && (i2 == 2131309210))
    {
      y();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "msgtab_list_clk", 2);
      return;
    }
    ajls localajls = (ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramString, 102);
    boolean bool = localajls.a();
    ArrayList localArrayList = localajls.c();
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
      if (i2 == 2131309433)
      {
        if (!badq.g(paramContext))
        {
          bbmy.a(paramContext, paramContext.getResources().getString(2131626719), 0).b(a().getTitleBarHeight());
          return;
        }
        paramString = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((!paramString.b(paramView.uin)) && (!paramString.d(paramView.uin)))
        {
          paramString = paramView.getDisplayName(localajls.a());
          paramContext = AddFriendLogicActivity.a(paramContext, 1, paramView.uin, null, 3045, 25, paramString, null, null, paramContext.getString(2131624088), null);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(25), "", "", "");
          a(paramContext);
        }
        for (;;)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
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
    this.C = true;
    if (this.jdField_e_of_type_Boolean)
    {
      if ((paramRecentBaseData instanceof RecentItemMayKnowFriendData))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, " onRecentBaseDataClick recommend_item_menu");
        }
        y();
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "msgtab_list_clk", 1);
      }
    }
    else {
      return;
    }
    if ((paramRecentBaseData instanceof RecentItemMayKnowFriendVerticalListData))
    {
      a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.a());
      return;
    }
    if ((paramRecentBaseData instanceof RecentItemRecommendTroopData))
    {
      ((ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.a());
      return;
    }
    baio.a(null, "AIO_Click_cost");
    badx.a(null, "pubAcc_aio_open", "");
    azzv.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "AIOTime onRecentBaseDataClick start");
    }
    paramView = null;
    RecentUserBaseData localRecentUserBaseData;
    String str;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      paramView = localRecentUserBaseData.a();
      if (paramView == null) {
        break label730;
      }
      if ((paramView.getType() != 7120) && (paramView.getType() != 7210) && (paramView.getType() != 1008)) {
        break label673;
      }
      str = "0X80067EC";
      if (localRecentUserBaseData.mUnreadNum != 0) {
        break label805;
      }
      str = "0X80067ED";
    }
    label673:
    label805:
    for (int i1 = 0;; i1 = 1)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.uin, paramView.getType());
      if ((localObject != null) && ((localObject instanceof MessageForStructing)))
      {
        localObject = ((MessageForStructing)localObject).structingMsg;
        if (localObject == null) {}
      }
      for (long l1 = ((AbsStructMsg)localObject).msgId;; l1 = 0L)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", str, str, 0, 0, paramView.uin + "", "" + l1, "" + i1, "" + localRecentUserBaseData.mUnreadNum);
        befe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramRecentBaseData);
        akij.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData);
        i1 = ahcq.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData);
        if ((paramView != null) && (paramView.lFlag == 16L) && (i1 == 0) && (this.jdField_a_of_type_Aqeb != null))
        {
          this.jdField_a_of_type_Aqeb.b();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "ad preload tool process hit");
          }
        }
        if ((paramView != null) && (String.valueOf(9970L).equals(paramView.uin)) && (this.jdField_b_of_type_Aqeb != null)) {
          this.jdField_b_of_type_Aqeb.b();
        }
        if ((paramView != null) && (paramView.getType() == 6004) && (this.jdField_c_of_type_Aqeb != null)) {
          this.jdField_c_of_type_Aqeb.b();
        }
        a(i1, paramView);
        if (paramRecentBaseData != null)
        {
          ahco.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramView);
          paramRecentBaseData.b();
          befx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.a());
          this.jdField_i_of_type_Boolean = true;
        }
        if (paramView != null)
        {
          paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
          paramRecentBaseData.setFeedInfoRead(paramView.uin);
          if (!FeedsManager.isShowStatus(paramView.uin)) {
            break label739;
          }
          paramString = (acjz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
          if (paramString != null)
          {
            l1 = paramString.a(paramView.uin);
            FeedsManager.saveToken(paramView.uin, l1);
            paramRecentBaseData.reportClickExpose();
            paramString.a(2, 2);
          }
        }
        for (;;)
        {
          baio.a("AIO_Click_cost", null);
          return;
          if (paramView.getType() == 6004) {
            if (paramRecentBaseData.b() <= 0) {
              break label733;
            }
          }
          label730:
          label733:
          for (i1 = 1;; i1 = 2)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090CC", "0X80090CC", i1, 0, "", "", "", "");
            break;
          }
          label739:
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.uin, paramView.getType());
          if ((paramView != null) && (paramView.msgtype == -1034))
          {
            paramView = (acjz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
            if (paramView != null) {
              paramView.a(2, 1);
            }
          }
        }
      }
    }
  }
  
  public void a(View paramView, Object paramObject)
  {
    sgj localsgj = (sgj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
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
      if (paramView.getId() == 2131297905)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
        paramView = new Intent(a(), ForwardRecentActivity.class);
        paramView.putExtra("forward_type", 13);
        a(paramView);
        return;
      }
      if ((paramView.getId() == 2131301090) || (paramView.getId() == 2131301092) || (paramView.getId() == 2131301093) || (paramView.getId() == 2131301094) || (paramView.getId() == 2131301095) || (paramView.getId() == 2131301096) || (paramView.getId() == 2131301097))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = babh.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, paramView, paramObject, null, true, null, true, true, null, null);
        return;
      }
    } while ((paramView.getId() != 2131303067) || (!localsgj.b(paramObject)));
    localsgj.a(paramView, (RecentItemChatMsgData)paramObject);
  }
  
  public void a(bawm parambawm, bawl parambawl)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) && (parambawl != null) && (parambawl.jdField_d_of_type_Long == 0L) && (parambawl.jdField_a_of_type_Long != 0L)) {
      parambawm.a(parambawl.jdField_a_of_type_Long);
    }
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    I();
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
        paramString = ((RecentUserBaseData)localObject).a();
        i1 = ((RecentUserBaseData)localObject).mPosition;
      }
      if (paramString != null)
      {
        ahco.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
        ahcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i1);
        this.jdField_a_of_type_Aaod.a(paramString);
      }
    }
    for (;;)
    {
      return;
      localObject = (aufl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
      if ((localObject != null) && (paramRecentBaseData != null)) {}
      try
      {
        ((aufl)localObject).b(paramRecentBaseData.a(), paramRecentBaseData.a());
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
        if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
          if (paramRecentBaseData.a() == 3000)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
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
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = a();
    int i1 = paramRecentBaseData.a();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_Ahcp == null)) {
      this.jdField_a_of_type_Ahcp = new ahcp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (azzz.a(paramString1, localResources.getString(2131625680)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
      if (!azzz.a(paramString1, localResources.getString(ahbj.a[4]))) {
        break label408;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        ahcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.a(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
    }
    label408:
    while (!azzz.a(paramString1, localResources.getString(ahbj.a[5])))
    {
      return;
      if (azzz.a(paramString1, localResources.getString(2131625684)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        break;
      }
      if (azzz.a(paramString1, localResources.getString(2131627558)))
      {
        a(i1, paramRecentBaseData, paramString2, false);
        if (i1 != 3000) {
          break;
        }
        new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").a();
        break;
      }
      if (azzz.a(paramString1, localResources.getString(2131627560)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        if (i1 != 3000) {
          break;
        }
        new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").a();
        break;
      }
      if (!azzz.a(paramString1, localResources.getString(2131628781))) {
        break;
      }
      this.jdField_a_of_type_Ahcb.a(a(), paramRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramRecentBaseData.a(), "0X800991D", "0X800991D", 0, 0, "", "", "", "");
      break;
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1.uin, paramString1.getType(), 1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
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
          this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentBaseData.a()).append("-").append(localRecentBaseData.a()).append("-").append(localRecentBaseData.mUnreadNum).append("-").append(localRecentBaseData.mUnreadFlag).append(" , ");
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
    if (this.jdField_a_of_type_Ahai != null) {
      this.jdField_a_of_type_Ahai.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Agxq.a(20, 0);
    ahay.a().a();
    if (this.jdField_a_of_type_Aaod != null) {
      this.jdField_a_of_type_Aaod.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_Atsk != null) {
      this.jdField_a_of_type_Atsk.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        alij localalij = (alij)localIterator.next();
        if (localalij != null) {
          localalij.a(paramLogoutReason);
        }
      }
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_h_of_type_Boolean)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception paramLogoutReason) {}
  }
  
  /* Error */
  protected void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 503	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 428
    //   9: iconst_2
    //   10: new 430	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 431	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 2712
    //   20: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 440	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 447	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 507	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   37: invokevirtual 2715	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   40: ifge +11 -> 51
    //   43: aload_0
    //   44: getfield 507	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   47: iconst_0
    //   48: invokevirtual 2718	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 2720	com/tencent/mobileqq/activity/Conversation:k	(Z)V
    //   56: iload_1
    //   57: ifeq +342 -> 399
    //   60: invokestatic 616	arih:a	()Larih;
    //   63: invokevirtual 2721	arih:a	()V
    //   66: invokestatic 830	ahay:a	()Lahay;
    //   69: invokevirtual 2705	ahay:a	()V
    //   72: aload_0
    //   73: getfield 1557	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   76: ifeq +22 -> 98
    //   79: aload_0
    //   80: getfield 507	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   83: ifnull +15 -> 98
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 1557	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   91: aload_0
    //   92: getfield 507	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   95: invokevirtual 2724	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   98: aload_0
    //   99: getfield 633	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   102: ifnull +15 -> 117
    //   105: aload_0
    //   106: getfield 633	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   109: invokevirtual 2725	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 633	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   117: aload_0
    //   118: getfield 648	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   121: ifnull +15 -> 136
    //   124: aload_0
    //   125: getfield 648	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   128: invokevirtual 656	android/app/Dialog:dismiss	()V
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 648	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   136: aload_0
    //   137: getfield 817	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Afdg	Lafdg;
    //   140: ifnull +14 -> 154
    //   143: aload_0
    //   144: getfield 817	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Afdg	Lafdg;
    //   147: aload_0
    //   148: getfield 534	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   151: invokevirtual 2726	afdg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   154: aload_0
    //   155: getfield 1926	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahcp	Lahcp;
    //   158: ifnull +14 -> 172
    //   161: aload_0
    //   162: getfield 1926	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahcp	Lahcp;
    //   165: aload_0
    //   166: getfield 534	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: invokevirtual 2727	ahcp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   172: aload_0
    //   173: getfield 449	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahai	Lahai;
    //   176: ifnull +25 -> 201
    //   179: aload_0
    //   180: getfield 449	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahai	Lahai;
    //   183: aload_0
    //   184: getfield 534	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   187: invokevirtual 2728	ahai:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   190: aload_0
    //   191: iconst_1
    //   192: bipush 10
    //   194: lconst_0
    //   195: invokestatic 470	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: invokevirtual 473	com/tencent/mobileqq/activity/Conversation:a	(IILjava/lang/Object;)V
    //   201: aload_0
    //   202: getfield 507	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   205: ifnull +11 -> 216
    //   208: aload_0
    //   209: getfield 507	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   212: iconst_0
    //   213: invokevirtual 2731	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   216: aload_0
    //   217: iconst_0
    //   218: invokespecial 1397	com/tencent/mobileqq/activity/Conversation:j	(Z)V
    //   221: aload_0
    //   222: getfield 1573	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Svc	Lsvc;
    //   225: ifnull +14 -> 239
    //   228: aload_0
    //   229: getfield 1573	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Svc	Lsvc;
    //   232: aload_0
    //   233: getfield 534	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   236: invokevirtual 2732	svc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   239: aload_0
    //   240: getfield 964	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   243: ifnull +16 -> 259
    //   246: aload_0
    //   247: getfield 964	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   250: aload_0
    //   251: getfield 534	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   254: invokeinterface 2737 2 0
    //   259: ldc_w 428
    //   262: ldc_w 2739
    //   265: aload_0
    //   266: getfield 534	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   269: getfield 2601	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   272: invokevirtual 2740	com/tencent/mobileqq/app/automator/Automator:b	()Z
    //   275: invokestatic 2164	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   278: invokestatic 2745	urk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   281: aload_0
    //   282: sipush 1055
    //   285: lconst_0
    //   286: iconst_0
    //   287: invokevirtual 645	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   290: aload_0
    //   291: getfield 825	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   294: ifnull +10 -> 304
    //   297: aload_0
    //   298: getfield 825	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Agxq	Lagxq;
    //   301: invokevirtual 2746	agxq:e	()V
    //   304: aload_0
    //   305: getfield 178	com/tencent/mobileqq/activity/Conversation:jdField_j_of_type_Boolean	Z
    //   308: ifeq +13 -> 321
    //   311: aload_0
    //   312: getfield 1095	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   315: bipush 12
    //   317: invokevirtual 464	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   320: pop
    //   321: aload_0
    //   322: getfield 674	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   325: getfield 884	com/tencent/mobileqq/app/FrameHelperActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   328: iconst_4
    //   329: invokevirtual 2747	android/os/Handler:sendEmptyMessage	(I)Z
    //   332: pop
    //   333: aload_0
    //   334: sipush 1035
    //   337: ldc2_w 2748
    //   340: iconst_0
    //   341: invokevirtual 645	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   344: aload_0
    //   345: sipush 1010
    //   348: ldc2_w 2748
    //   351: iconst_1
    //   352: invokevirtual 645	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   355: aload_0
    //   356: sipush 1063
    //   359: lconst_0
    //   360: iconst_1
    //   361: aconst_null
    //   362: invokevirtual 1325	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   365: aload_0
    //   366: sipush 1064
    //   369: ldc2_w 2748
    //   372: iconst_1
    //   373: ldc_w 2751
    //   376: invokevirtual 1325	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   379: aload_0
    //   380: aload_0
    //   381: getfield 534	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   384: bipush 76
    //   386: invokevirtual 940	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   389: checkcast 2612	bawm
    //   392: putfield 188	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bawm	Lbawm;
    //   395: aload_0
    //   396: invokespecial 2753	com/tencent/mobileqq/activity/Conversation:W	()V
    //   399: aload_0
    //   400: sipush 10001
    //   403: ldc2_w 2754
    //   406: iconst_0
    //   407: invokevirtual 645	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   410: aload_0
    //   411: getfield 534	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   414: invokevirtual 1652	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   417: ifne +15 -> 432
    //   420: aload_0
    //   421: getfield 178	com/tencent/mobileqq/activity/Conversation:jdField_j_of_type_Boolean	Z
    //   424: ifeq +8 -> 432
    //   427: aload_0
    //   428: lconst_0
    //   429: invokevirtual 2756	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   432: aload_0
    //   433: ldc_w 2757
    //   436: ldc2_w 2758
    //   439: iconst_0
    //   440: invokevirtual 645	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   443: invokestatic 1181	ncw:a	()Lncw;
    //   446: aload_0
    //   447: getfield 534	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   450: invokevirtual 1003	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   453: invokevirtual 2760	ncw:a	(Ljava/lang/String;)V
    //   456: getstatic 2763	arpa:jdField_g_of_type_Boolean	Z
    //   459: ifeq +13 -> 472
    //   462: invokestatic 2766	arpa:a	()Larpa;
    //   465: aload_0
    //   466: getfield 534	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   469: invokevirtual 2767	arpa:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   472: return
    //   473: astore_2
    //   474: aload_0
    //   475: aconst_null
    //   476: putfield 633	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   479: goto -362 -> 117
    //   482: astore_2
    //   483: aload_0
    //   484: aconst_null
    //   485: putfield 633	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   488: aload_2
    //   489: athrow
    //   490: astore_2
    //   491: aload_0
    //   492: aconst_null
    //   493: putfield 648	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   496: goto -360 -> 136
    //   499: astore_2
    //   500: aload_0
    //   501: aconst_null
    //   502: putfield 648	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   505: aload_2
    //   506: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	Conversation
    //   0	507	1	paramBoolean	boolean
    //   473	1	2	localException1	Exception
    //   482	7	2	localObject1	Object
    //   490	1	2	localException2	Exception
    //   499	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   105	112	473	java/lang/Exception
    //   105	112	482	finally
    //   124	131	490	java/lang/Exception
    //   124	131	499	finally
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
  
  public boolean a(bawm parambawm, bawl parambawl)
  {
    if ((parambawl == null) || (parambawm == null)) {}
    do
    {
      return false;
      if (parambawl.jdField_d_of_type_Long == 3L) {
        parambawm.a(4L, parambawl.jdField_a_of_type_Long);
      }
    } while ((parambawl == null) || (parambawl.jdField_d_of_type_Long != 2L) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) || (!this.w));
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
      for (;;)
      {
        try
        {
          bool1 = ((agtk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).c();
          if (!bool1) {
            bool1 = true;
          }
        }
        catch (Throwable paramListView)
        {
          bool2 = false;
          continue;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "hbEntryManager.canRefreshMsg() = " + bool1);
          }
          bool2 = bool1;
          if (bool1)
          {
            bool2 = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.handlePullRefresh();
              bool2 = bool1;
            }
          }
        }
        catch (Throwable paramListView)
        {
          bool2 = bool1;
          continue;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d()) {
          bool2 = true;
        }
        if (!bool2) {
          continue;
        }
        this.jdField_g_of_type_Boolean = true;
        e(true);
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(40001, 500L);
        return true;
        bool1 = false;
      }
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      baio.a("Conversation_PullToRefresh_start", 0L);
      o();
      ThreadManager.getSubThreadHandler().post(new Conversation.11(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      }
      if (((stg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
      {
        ((stf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a().a(2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "MsgTabNodeListLoader update data");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.handlePullRefresh();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1054);
      a(1064, 200L, true, "qboss_banner_pull_refresh");
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
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130848985);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131300167).setBackgroundResource(2130848996);
      this.B = false;
    }
    w();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.m();
    }
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      awnu.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Atsk.k();
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        alij localalij = (alij)localIterator.next();
        if (localalij != null) {
          localalij.m();
        }
      }
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848801);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131101257));
    }
    if (this.jdField_a_of_type_Ahek != null) {
      this.jdField_a_of_type_Ahek.e();
    }
    if (this.jdField_a_of_type_Svc != null) {
      this.jdField_a_of_type_Svc.j();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onPostThemeChanged();
    }
    if (this.jdField_a_of_type_Agxq != null) {
      this.jdField_a_of_type_Agxq.a(-1, null);
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
    azlm localazlm = (azlm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
    if (localazlm != null) {
      localazlm.a(paramLong);
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
        Y();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    if (this.jdField_a_of_type_Aaog != null) {
      this.jdField_a_of_type_Aaog.c();
    }
  }
  
  public View c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_c_of_type_AndroidViewView;
  }
  
  public void c()
  {
    if (SystemClock.uptimeMillis() - svc.jdField_b_of_type_Long > 500L)
    {
      F();
      if ((this.w) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof HongBaoListView)) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mEnableStory) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mForStory))
      {
        if (this.jdField_a_of_type_Svc != null) {
          this.jdField_a_of_type_Svc.i();
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
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = akhu.a(a());; bool = true)
    {
      if (!bool)
      {
        a().requestPermissions(new aanp(this, paramView), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      d(paramView);
      return;
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "updateLoadingState, showLoadingCircle = " + paramBoolean);
    }
    if (paramBoolean) {
      if (this.jdField_c_of_type_AndroidWidgetImageView == null)
      {
        i1 = this.jdField_a_of_type_AndroidWidgetTextView.getId();
        this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(a());
        this.jdField_c_of_type_AndroidWidgetImageView.setId(2131303817);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, i1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(7.0F * babp.a()));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      }
    }
    while ((this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
      try
      {
        int i1;
        Object localObject = a().getResources().getDrawable(2130839115);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if ((localObject instanceof Animatable)) {
          ((Animatable)localObject).start();
        }
        if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean c()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void d()
  {
    super.d();
    c();
  }
  
  public void d(View paramView)
  {
    Object localObject1 = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1";
    if (paramView == this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch)
    {
      localObject2 = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)localObject2).a(6, "120000");
      localObject1 = biig.a(localAppInfo.buffer.get(), "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1");
      ((auqh)localObject2).a(localAppInfo, null);
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("cmode"))
      {
        if (!((String)localObject1).contains("?")) {
          break label217;
        }
        localObject2 = "&";
        localObject2 = ((String)localObject1).concat((String)localObject2 + "cmode" + "=" + "all");
      }
    }
    localObject1 = new Intent();
    ((Intent)localObject1).setData(Uri.parse((String)localObject2));
    a().startActivity((Intent)localObject1);
    ThreadManager.getUIHandler().postDelayed(new Conversation.51(this), 500L);
    if (paramView != this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch) {}
    for (paramView = "1";; paramView = "3")
    {
      awqx.b(null, "dc00898", "", "", "0X800A2D5", "0X800A2D5", 0, 0, paramView, "", "", "");
      return;
      label217:
      localObject2 = "?";
      break;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.d("Q.recent", 2, "onResume...");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.C = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = true;
    ajls.jdField_e_of_type_Boolean = true;
    if ((jdField_b_of_type_Long == -1L) && (SplashActivity.jdField_a_of_type_Boolean))
    {
      jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      SosoInterface.a(jdField_b_of_type_Long);
    }
    super.d(paramBoolean);
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      if (FrameHelperActivity.b())
      {
        FrameHelperActivity.c(true);
        FrameHelperActivity.s();
      }
      this.jdField_c_of_type_Boolean = false;
    }
    ahcw.a().c();
    if (this.jdField_a_of_type_Afdg != null) {
      this.jdField_a_of_type_Afdg.a();
    }
    if (AppSetting.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(true);
    }
    this.jdField_f_of_type_Boolean = true;
    try
    {
      a().getWindow().setSoftInputMode(32);
      Object localObject1 = this.jdField_a_of_type_Bawm;
      if (localObject1 != null)
      {
        localObject2 = ((bawm)localObject1).a();
        if (localObject2 != null)
        {
          a((bawm)localObject1, (bawl)localObject2);
          if (a((bawm)localObject1, (bawl)localObject2) == true)
          {
            localObject1 = a();
            if ((localObject1 != null) && ((localObject1 instanceof SplashActivity))) {
              ((SplashActivity)localObject1).c();
            }
          }
        }
      }
      if (this.jdField_a_of_type_Agxq != null)
      {
        boolean bool = arih.a().d();
        localObject1 = this.jdField_a_of_type_Agxq;
        if (bool)
        {
          i1 = 2;
          ((agxq)localObject1).a(9, i1);
          arih.a().b(bool);
          this.jdField_a_of_type_Agxq.b();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == 0) {
            break label638;
          }
          i1 = 1;
          localObject1 = this.jdField_a_of_type_Agxq;
          if (i1 == 0) {
            break label643;
          }
          i1 = 2;
          ((agxq)localObject1).a(37, i1);
          if (!aosu.a().a()) {
            break label648;
          }
          i1 = 1;
          localObject1 = this.jdField_a_of_type_Agxq;
          if (i1 == 0) {
            break label653;
          }
          i1 = 2;
          ((agxq)localObject1).a(38, i1);
        }
      }
      else
      {
        alfo.a().c();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent != null)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent = null;
        }
        this.jdField_a_of_type_Int = 0;
        if (!this.jdField_j_of_type_Boolean) {
          break label658;
        }
        if (this.jdField_a_of_type_Long != 1000L) {
          this.jdField_a_of_type_Long = 1000L;
        }
        if (!this.k) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
        }
        if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_Ahai != null)) {
          this.jdField_a_of_type_Ahai.notifyDataSetChanged();
        }
        a(0L);
        k();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
        V();
        if (!this.jdField_b_of_type_Boolean) {
          break label701;
        }
        if (FrameHelperActivity.b()) {
          FrameHelperActivity.s();
        }
        this.jdField_b_of_type_Boolean = false;
        if ((this.jdField_a_of_type_Atsk.jdField_d_of_type_Int != -1) && (this.jdField_a_of_type_Atsk.jdField_d_of_type_Int != 1))
        {
          this.jdField_a_of_type_Atsk.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
          this.jdField_a_of_type_Atsk.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Atsk.d();
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          break label724;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label719;
          }
          localObject2 = (alij)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            if (!this.v) {
              break;
            }
            ((alij)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            ((alij)localObject2).jdField_e_of_type_Boolean = true;
            ((alij)localObject2).j();
          }
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        QLog.e("Q.recent", 1, localException, new Object[0]);
        continue;
        int i1 = 0;
        continue;
        label638:
        i1 = 0;
        continue;
        label643:
        i1 = 0;
        continue;
        label648:
        i1 = 0;
        continue;
        label653:
        i1 = 0;
        continue;
        label658:
        if (!this.A)
        {
          this.A = true;
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1067, 1000L);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1025, 3000L);
        continue;
        label701:
        this.jdField_a_of_type_Atsk.e();
        continue;
        ((alij)localObject2).d();
      }
      label719:
      this.v = false;
      label724:
      if (this.t) {
        this.t = false;
      }
      if (AppSetting.jdField_c_of_type_Boolean) {
        a().setTitle(a(2131628427));
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new Conversation.21(this), 500L);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1070, 3000L);
      ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
      obz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_c_of_type_JavaLangRunnable == null) {
        this.jdField_c_of_type_JavaLangRunnable = new Conversation.22(this);
      }
      ThreadManagerV2.excute(this.jdField_c_of_type_JavaLangRunnable, 32, null, true);
      if (!baig.e(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
        if ((localObject3 == null) || (((List)localObject3).size() == 0))
        {
          baig.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
          if ((localRecentUser.getType() == 1) && (localRecentUser.showUpTime > 0L))
          {
            ((TroopManager)localObject2).a(localRecentUser.uin, localRecentUser.showUpTime);
            localArrayList.add(localRecentUser.uin);
            a(9, localRecentUser.uin, 1);
          }
        }
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (baig.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).contains(localObject3)) {
            localArrayList.remove(localObject3);
          }
        }
        if (localArrayList.size() == 0)
        {
          baig.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          return;
        }
        ((ajex)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(localArrayList, 0);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new Conversation.23(this), 5000L);
      a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      aqiy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahai, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      ncw.a().jdField_a_of_type_Boolean = false;
      if (!paramBoolean) {
        break label1319;
      }
    }
    this.x = true;
    for (;;)
    {
      if (this.jdField_a_of_type_Areo != null) {
        this.jdField_a_of_type_Areo.a();
      }
      l(true);
      R();
      s();
      ApngImage.playByTag(2);
      if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1053)) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1053, 500L);
      }
      if (this.jdField_a_of_type_Svc != null) {
        this.jdField_a_of_type_Svc.l();
      }
      if (this.jdField_a_of_type_Agxq != null) {
        this.jdField_a_of_type_Agxq.g();
      }
      ahcb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      Q();
      if (this.jdField_a_of_type_Ahek != null) {
        this.jdField_a_of_type_Ahek.d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onResume();
      }
      axkz.a(null);
      return;
      label1319:
      this.x = false;
      if (this.jdField_a_of_type_Aqeb != null) {
        this.jdField_a_of_type_Aqeb.d();
      }
    }
  }
  
  protected boolean d()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1);
  }
  
  public void e()
  {
    P();
    t();
    if (this.jdField_a_of_type_Agxq != null) {
      this.jdField_a_of_type_Agxq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Atsk != null) {
      this.jdField_a_of_type_Atsk.c();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        alij localalij = (alij)localIterator.next();
        if (localalij != null) {
          localalij.i();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134065);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134061);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134068);
    awqu.a();
    if (this.jdField_a_of_type_Ahbv != null) {
      this.jdField_a_of_type_Ahbv.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Ahcb != null) {
      this.jdField_a_of_type_Ahcb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_Agzu != null) {
      this.jdField_a_of_type_Agzu.a(a());
    }
    if (this.jdField_a_of_type_Areo != null) {
      this.jdField_a_of_type_Areo.d();
    }
    if (this.jdField_a_of_type_Aaog != null) {
      this.jdField_a_of_type_Aaog.b();
    }
    if (this.jdField_a_of_type_Ahek != null) {
      this.jdField_a_of_type_Ahek.a(a());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_Agxq.a(1);
    boolean bool2 = this.jdField_a_of_type_Agxq.a(9);
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
    switch (arih.a().a())
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
  
  public void f()
  {
    baio.a(null, "Recent_OnCreate");
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a(a());
    this.jdField_a_of_type_Aaod = new aaod(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new babk(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_MqqOsMqqHandler = new babk(ThreadManager.getRecentThreadLooper(), this);
    this.jdField_a_of_type_Ahcb = new ahcb(this.jdField_a_of_type_MqqOsMqqHandler, a());
    this.jdField_a_of_type_Aaog = new aaog(this);
    K();
    J();
    a(false);
    this.jdField_a_of_type_Agzu = new agzu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    baio.a("Recent_OnCreate", null);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aaog != null) {
      this.jdField_a_of_type_Aaog.a(paramBoolean);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null))
    {
      QLog.e("Q.recent", 1, "refreshCameraRedTouch, not inited");
      return;
    }
    if ((amdc.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21))
    {
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      Object localObject = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)localObject).a(6, "120000");
      boolean bool1 = this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      boolean bool2 = this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      if (bool1)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
        ((auqh)localObject).b(localAppInfo, null);
        if (!paramBoolean) {
          awqx.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, "3", "", "", "");
        }
        label161:
        if (!paramBoolean) {
          break label231;
        }
        if (bool1) {
          break label233;
        }
      }
      label231:
      label233:
      for (localObject = "1";; localObject = "3")
      {
        awqx.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, (String)localObject, "", "", "");
        return;
        if ((bool1) || (!bool2)) {
          break label161;
        }
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.b();
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        break label161;
        break;
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
  }
  
  public void h()
  {
    QLog.d("Q.recent", 2, "onResume...");
    ApngImage.pauseByTag(2);
    super.h();
    this.jdField_a_of_type_Atsk.g();
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
        localObject2 = (alij)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((alij)localObject2).e();
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
    ahcw.a().b();
    this.jdField_f_of_type_Boolean = false;
    if ((!this.C) && (!this.D) && (ahca.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      if (System.currentTimeMillis() - this.jdField_h_of_type_Long > 5000L)
      {
        localObject1 = this.jdField_a_of_type_Ahai.b();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ThreadManager.getSubThreadHandler().post(new Conversation.3(this, (QQAppInterface)localObject2, (List)localObject1));
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
      if (this.jdField_a_of_type_Ahbv != null) {
        this.jdField_a_of_type_Ahbv.l();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = false;
      obz.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_b_of_type_Aqeb != null) {
        this.jdField_b_of_type_Aqeb.d();
      }
      if (this.jdField_c_of_type_Aqeb != null) {
        this.jdField_c_of_type_Aqeb.d();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
      awqu.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Svc != null) {
        this.jdField_a_of_type_Svc.m();
      }
      ohp.k();
      akij.a();
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
  
  public void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Svc != null) {
        this.jdField_a_of_type_Svc.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initLater(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.jdField_h_of_type_Boolean) || (a() == null) || (a().isFinishing())) {
      return true;
    }
    beoj.a("conv.handleMessage");
    long l1 = System.currentTimeMillis();
    boolean bool1;
    int i1;
    int i2;
    label651:
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
    case 10: 
    case 9: 
    case 8: 
      for (;;)
      {
        beoj.a();
        return true;
        if (!a(paramMessage)) {
          return true;
        }
        ((ajjz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).b();
        ariz.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        G();
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (ahwj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          ahwj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        boolean bool2 = false;
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()) {
            bool1 = true;
          }
        }
        Object localObject1 = paramMessage.a(bool1);
        this.jdField_a_of_type_Agzu.a((List)localObject1);
        paramMessage = ahay.a().jdField_a_of_type_JavaUtilList;
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject4 = a();
        if (localObject1 != null)
        {
          i1 = ((List)localObject1).size();
          agzt.a((List)localObject1, (QQAppInterface)localObject3, (Context)localObject4, paramMessage, i1);
        }
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_Agzu);
          b(paramMessage);
          u();
          localObject1 = new ArrayList(paramMessage);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, localObject1).sendToTarget();
          a(paramMessage);
          if (this.jdField_a_of_type_Agxq != null) {}
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          localObject1 = new HashMap();
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          awrn.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject1, "");
          localObject1 = (sgj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
          ((sgj)localObject1).b(3, ((sgj)localObject1).a(paramMessage));
          baio.a("Conversation_Refresh_global", System.currentTimeMillis() - l1);
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("Q.recent", 4, "REFRESH_FLAG_GLOBAL, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
          continue;
          i1 = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (!a(paramMessage)) {
          return true;
        }
        if (ahwj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          ahwj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        G();
        localObject3 = ahay.a().jdField_a_of_type_JavaUtilList;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
        this.jdField_a_of_type_Agzu.a((List)localObject4);
        ((List)localObject3).clear();
        RecentUser localRecentUser;
        String str;
        if (localObject4 == null)
        {
          i1 = 0;
          i2 = 0;
          if (i2 >= i1) {
            break label843;
          }
          localRecentUser = (RecentUser)((List)localObject4).get(i2);
          str = ahay.a(localRecentUser.uin, localRecentUser.getType());
          localObject2 = ahay.a().a(str);
          if (localObject2 != null) {
            break label766;
          }
          localObject2 = agzt.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          paramMessage = (Message)localObject2;
          if (localObject2 != null)
          {
            ahay.a().a((RecentBaseData)localObject2, str);
            paramMessage = (Message)localObject2;
          }
        }
        for (;;)
        {
          if (paramMessage != null) {
            ((List)localObject3).add(paramMessage);
          }
          i2 += 1;
          break label651;
          i1 = ((List)localObject4).size();
          break;
          if (!this.jdField_b_of_type_JavaUtilList.contains(str))
          {
            paramMessage = (Message)localObject2;
            if (!this.jdField_b_of_type_JavaUtilList.contains(ahay.a(localRecentUser.uin, -2147483648))) {}
          }
          else
          {
            if ((localObject2 instanceof RecentUserBaseData)) {
              ((RecentUserBaseData)localObject2).a(localRecentUser);
            }
            ((RecentBaseData)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
            paramMessage = (Message)localObject2;
          }
        }
        try
        {
          Collections.sort((List)localObject3, this.jdField_a_of_type_Agzu);
          b((List)localObject3);
          u();
          paramMessage = new ArrayList((Collection)localObject3);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
          a((List)localObject3);
          if (this.jdField_a_of_type_Agxq != null) {
            this.jdField_a_of_type_Agxq.i();
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
          awrn.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - l1, ((List)localObject3).size(), paramMessage, "");
          baio.a("Conversation_Refresh_part", System.currentTimeMillis() - l1);
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("Q.recent", 4, "REFRESH_FLAG_PART, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            paramMessage.printStackTrace();
          }
        }
        if (!a(paramMessage)) {
          return true;
        }
        paramMessage = ahay.a().jdField_a_of_type_JavaUtilList;
        i2 = paramMessage.size();
        localObject2 = new ArrayList(i2);
        i1 = 0;
        if (i1 < i2) {
          for (;;)
          {
            try
            {
              localObject3 = (RecentBaseData)paramMessage.get(i1);
              if (localObject3 == null) {
                i1 += 1;
              }
            }
            catch (Exception paramMessage)
            {
              if (QLog.isDevelopLevel()) {
                QLog.e("Q.recent", 4, paramMessage.toString());
              }
              return true;
            }
            localObject4 = ahay.a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
            if ((this.jdField_b_of_type_JavaUtilList.contains(localObject4)) || (this.jdField_b_of_type_JavaUtilList.contains(ahay.a(((RecentBaseData)localObject3).a(), -2147483648))))
            {
              ((RecentBaseData)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
              ((List)localObject2).add(localObject3);
            }
          }
        }
        u();
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1019, 0, 0, localObject2).sendToTarget();
        a(paramMessage);
        if (this.jdField_c_of_type_Int <= 8)
        {
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_JavaUtilList.clear();
        }
        this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
        this.jdField_d_of_type_Long = System.currentTimeMillis();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
        awrn.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject2, "");
        baio.a("Conversation_Refresh_items", System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        }
      }
    case 11: 
      label766:
      bool1 = a(paramMessage);
      label843:
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "REFRESH_FLAG_RECENT_ITEMS, [" + paramMessage.arg1 + "," + paramMessage.arg2 + "," + paramMessage.obj + "," + this.jdField_j_of_type_Boolean + "," + bool1 + "]");
      }
      if (!bool1) {
        return true;
      }
      i2 = paramMessage.arg2;
      if ((i2 == 8) || (i2 == 9))
      {
        localObject2 = null;
        if ((paramMessage.obj instanceof String)) {
          localObject2 = (String)paramMessage.obj;
        }
        if ((localObject2 != null) && (!this.jdField_b_of_type_JavaUtilList.contains(localObject2))) {
          this.jdField_b_of_type_JavaUtilList.add(localObject2);
        }
        l1 = 0L;
      }
      break;
    }
    for (;;)
    {
      if (i2 >= this.jdField_c_of_type_Int)
      {
        i1 = 8;
        for (;;)
        {
          if (i1 < i2)
          {
            this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(i1);
            i1 += 1;
            continue;
            if (!(paramMessage.obj instanceof Long)) {
              break label2074;
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
      localObject2 = Message.obtain();
      ((Message)localObject2).arg1 = paramMessage.arg1;
      ((Message)localObject2).what = this.jdField_c_of_type_Int;
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject2, l1);
      break;
      ariz.a().k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = rol.a();
      if (paramMessage != null) {
        paramMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramMessage = rqn.a();
      if (paramMessage != null) {
        paramMessage.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      azkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = (azlf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
      if (paramMessage != null) {
        paramMessage.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      for (;;)
      {
        paramMessage = (nfp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
        if (paramMessage != null) {
          paramMessage.e();
        }
        paramMessage = (aqkz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
        if (paramMessage != null) {
          paramMessage.a(true);
        }
        paramMessage = (ajjz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255);
        if (paramMessage != null) {
          paramMessage.a();
        }
        ajyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
        paramMessage = (ansl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(292);
        if (paramMessage != null) {
          paramMessage.d();
        }
        paramMessage = (sgj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
        paramMessage.a(1, paramMessage.a(this.jdField_a_of_type_JavaUtilList));
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
        }
      }
      k(true);
      break;
      a(new Conversation.26(this));
      break;
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1044, 0, 0, null).sendToTarget();
      break;
      paramMessage = (sgj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
      paramMessage.a(2, paramMessage.a(ahay.a().jdField_a_of_type_JavaUtilList));
      break;
      if (this.jdField_a_of_type_Ahek == null) {
        break;
      }
      this.jdField_a_of_type_Ahek.b();
      break;
      label2074:
      l1 = 0L;
    }
  }
  
  public void i()
  {
    super.i();
    if ((this.jdField_a_of_type_Ahbv != null) && (this.jdField_a_of_type_Ahbv.a())) {
      this.jdField_a_of_type_Ahbv.b();
    }
    if (this.jdField_a_of_type_Aqeb != null) {
      this.jdField_a_of_type_Aqeb.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        alij localalij = (alij)localIterator.next();
        if (localalij != null) {
          localalij.k();
        }
      }
    }
    if (this.jdField_a_of_type_Areo != null) {
      this.jdField_a_of_type_Areo.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onStop();
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "notifyCallTabChanged, changed=" + paramBoolean);
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onDestroy");
    }
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ahcb != null) {
      this.jdField_a_of_type_Ahcb.a();
    }
    if (this.jdField_a_of_type_Begr != null)
    {
      this.jdField_a_of_type_Begr.a(null);
      this.jdField_a_of_type_Begr = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a(null);
    }
    this.p = false;
    ahcw.a().a();
    P();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
    if (this.jdField_a_of_type_Aaod != null) {
      this.jdField_a_of_type_Aaod.a();
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Afdg != null) {
      this.jdField_a_of_type_Afdg.b();
    }
    if (this.jdField_a_of_type_Ahai != null) {
      this.jdField_a_of_type_Ahai.b();
    }
    if (this.jdField_a_of_type_Svc != null) {
      this.jdField_a_of_type_Svc.c();
    }
    if (this.jdField_a_of_type_Agxq != null) {
      this.jdField_a_of_type_Agxq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        ((akeu)localObject).e();
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label227:
      break label227;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_c_of_type_MqqOsMqqHandler != null) {
      this.jdField_c_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    ariz.a();
    arjb.a();
    rqn.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        alij localalij = (alij)((Iterator)localObject).next();
        if (localalij != null) {
          localalij.f();
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Areo != null)
    {
      this.jdField_a_of_type_Areo.f();
      this.jdField_a_of_type_Areo = null;
    }
    super.j();
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Ahai == null)
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
  
  public void n()
  {
    a(1069, 0L, true);
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1058);
      }
      this.jdField_g_of_type_Boolean = true;
      H();
      e(true);
      boolean bool1 = this.jdField_a_of_type_Agxq.a(1);
      boolean bool2 = this.jdField_a_of_type_Agxq.a(9);
      if ((bool1) || (bool2)) {
        c(800L);
      }
    }
    else
    {
      return;
    }
    if (bgmq.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      ohp.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
    c(60000L);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      this.jdField_a_of_type_Ahbv.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getWidth() - a().getDimensionPixelSize(2131167521) - a().getDimensionPixelSize(2131167522), a().getDimensionPixelSize(2131167523));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity instanceof MainFragment))) {
        ((MainFragment)this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).n();
      }
      if ((aing.c() <= 0) || (aing.b() <= 0)) {
        break label362;
      }
    }
    label362:
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = false;
      }
      for (int i2 = 1;; i2 = 0)
      {
        bajr.a(aing.a(), "cmshow", "Apollo", "plusentrance", 0, 0, new String[] { "" + i1, "" + i2 });
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
        urp.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
        W();
        xfs.e();
        this.C = true;
        do
        {
          return;
        } while ((paramView != this.jdField_b_of_type_AndroidWidgetImageView) && (paramView != this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch));
        long l1 = System.currentTimeMillis();
        if (Math.abs(l1 - jdField_i_of_type_Long) < 500L)
        {
          jdField_i_of_type_Long = l1;
          return;
        }
        jdField_i_of_type_Long = l1;
        if (QLog.isDevelopLevel()) {
          QLog.d("CameraLaunchPerf", 4, "userClick time=" + System.currentTimeMillis());
        }
        c(paramView);
        return;
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
        T();
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
      azvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        break label333;
      }
      if (this.jdField_a_of_type_Svc != null) {
        this.jdField_a_of_type_Svc.b(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1)) {
        break label433;
      }
      if (this.jdField_a_of_type_Ahai == null) {
        break label254;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i4 = this.jdField_a_of_type_Ahai.getCount();
      this.jdField_b_of_type_Int = Math.max(i1, -1);
      if ((i1 < 0) || (i1 >= i4) || (i1 > i2 - i3)) {
        break label242;
      }
      localObject = this.jdField_a_of_type_Ahai.getItem(i1);
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
    } while ((!((RecentBaseData)localObject).a()) || (((RecentBaseData)localObject).b() <= 0));
    this.jdField_b_of_type_Int = i1;
    label242:
    this.jdField_a_of_type_Ahai.a(false);
    azzv.a(false);
    label254:
    if (paramInt == 0)
    {
      T();
      zqk.a().a("list_conv", false);
      ThreadRegulator.a().b(2);
      a(paramAbsListView);
      aqiy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahai, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      l(false);
      R();
      X();
      v();
      if (this.jdField_a_of_type_Agud != null) {
        this.jdField_a_of_type_Agud.b();
      }
    }
    for (;;)
    {
      label333:
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
      if (this.jdField_a_of_type_Agxq != null) {
        this.jdField_a_of_type_Agxq.b(this.G);
      }
      oia.a(paramAbsListView, paramInt);
      akij.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAbsListView, paramInt);
      return;
      label433:
      if (this.jdField_a_of_type_Ahai == null) {
        break;
      }
      this.jdField_a_of_type_Ahai.a(true);
      azzv.a(true);
      break;
      zqk.a().a("list_conv");
      ThreadRegulator.a().a(2);
      if (this.jdField_a_of_type_Agud != null) {
        this.jdField_a_of_type_Agud.c();
      }
    }
  }
  
  public void p()
  {
    this.jdField_f_of_type_Boolean = true;
    if ((!this.jdField_j_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      C();
      baio.a("Recent_Start", null);
    }
    while (!this.jdField_j_of_type_Boolean) {
      return;
    }
    a(1030, 0L, true);
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131493891, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        if (this.jdField_a_of_type_Ahbv == null)
        {
          this.jdField_a_of_type_Ahbv = new ahbv(localBaseActivity);
          this.jdField_a_of_type_Ahbv.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new aamo(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_Bawm = ((bawm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76));
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
        ((HashMap)localObject2).put("device_mode", babp.d());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        awrn localawrn = awrn.a(BaseApplicationImpl.getContext());
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label378;
        }
        localawrn.a(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
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
      this.jdField_a_of_type_Ahbv = null;
      this.l = false;
      break label208;
      label378:
      l1 = 1L;
    }
  }
  
  public void r()
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
          q();
        }
        w();
        if (this.jdField_a_of_type_Aaog != null) {
          this.jdField_a_of_type_Aaog.a();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aamp(this));
        this.jdField_a_of_type_Ahek = new ahek(this, this.jdField_a_of_type_AndroidViewViewGroup);
        long l1 = System.currentTimeMillis();
        if (amda.e())
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131493891, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
          }
          M();
          long l2 = System.currentTimeMillis();
          QLog.d("AutoMonitor", 1, "init Mini App, cost=" + (l2 - l1));
        }
        ((agtk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).a(this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface);
        if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initUI(a());
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
        if ((this.jdField_a_of_type_Agxq != null) && (this.jdField_e_of_type_Boolean)) {
          this.jdField_a_of_type_Agxq.j();
        }
        if (this.jdField_a_of_type_Agxq != null) {
          this.jdField_a_of_type_Agxq.a(false);
        }
        a(1010, 5000L, false);
        a(1064, 5000L, true, "qboss_banner_login");
        a(1023, 0L, false);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())
        {
          a(1055, 0L, false);
          a(this.jdField_a_of_type_MqqOsMqqHandler, a());
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, new Object[] { "initUiLater() will send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()) });
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())
          {
            a(1061, 0L, false);
            if (QLog.isColorLevel()) {
              QLog.d("Q.recent", 2, "isInRealActionLoginB MSG_CHECK_QQSPORT_RED_PACKET");
            }
          }
          I();
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(12);
          U();
          if (this.jdField_a_of_type_JavaLangString == null)
          {
            this.jdField_a_of_type_JavaLangString = akiq.a().a();
            if (this.jdField_a_of_type_JavaLangString == null)
            {
              this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301493));
              GLSurfaceView localGLSurfaceView = new GLSurfaceView(a());
              localGLSurfaceView.setRenderer(new aamq(this));
              this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(localGLSurfaceView);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_GPU", 2, "GL_RENDERER= " + this.jdField_a_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()) {
            continue;
          }
          a(1059, 0L, false);
          continue;
        }
        if (!this.s) {
          break label616;
        }
      }
      finally {}
      a(1055, 0L, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "initUiLater() mMsgTabStoryNodeListNeedInit fallback logic, send MSG_INIT_MSGTAG_STORY");
      }
      this.s = false;
      continue;
      label616:
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "initUiLater() will not send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()) });
      }
    }
  }
  
  void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_j_of_type_Boolean)) {}
    label124:
    for (;;)
    {
      return;
      if (((nfp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).b())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ahai != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
            if (!(this.jdField_a_of_type_Ahai.getItem(i1) instanceof RecentItemEcShopAssitant)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!ncw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (this.jdField_b_of_type_Aqeb == null)) {
            break label124;
          }
          this.jdField_b_of_type_Aqeb.a();
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
          int i2 = aufl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int i2 = 2;
    Object localObject2;
    if ((paramObject instanceof MessageRecord))
    {
      localObject2 = (MessageRecord)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
      if ((!((MessageRecord)localObject2).isSendFromLocal()) || (((MessageRecord)localObject2).msgtype != -2002)) {}
    }
    label52:
    label210:
    label613:
    do
    {
      do
      {
        do
        {
          break label52;
          break label52;
          do
          {
            return;
          } while ((((MessageRecord)localObject2).isSendFromLocal()) && (((MessageRecord)localObject2).msgtype == -2000) && (!this.jdField_f_of_type_Boolean));
          if ((this.jdField_f_of_type_Boolean) && (myn.a((MessageRecord)localObject2)))
          {
            a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
            l(false);
          }
          if ((this.jdField_f_of_type_Boolean) && (aqja.a((MessageRecord)localObject2))) {
            aqiy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahai, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          }
          int i1 = 10;
          Object localObject1 = Long.valueOf(0L);
          if ((((MessageRecord)localObject2).isSendFromLocal()) && ((!this.jdField_f_of_type_Boolean) || (TextUtils.equals(((MessageRecord)localObject2).frienduin, ajed.ay)) || (TextUtils.equals(((MessageRecord)localObject2).frienduin, ajed.az))))
          {
            i1 = 9;
            localObject1 = ahay.a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
            if (((MessageRecord)localObject2).isSend()) {
              baep.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
            }
            a(i2, i1, localObject1);
            this.H = true;
          }
          for (;;)
          {
            if (!(paramObservable instanceof aufl)) {
              break label613;
            }
            if ((paramObject instanceof Boolean))
            {
              boolean bool = ((Boolean)paramObject).booleanValue();
              if ((!this.jdField_e_of_type_Boolean) && (bool))
              {
                paramObservable = null;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                  paramObservable = (aufl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
                }
                if (paramObservable != null) {
                  paramObservable.a(false);
                }
              }
            }
            if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Agxq == null)) {
              break;
            }
            this.jdField_a_of_type_Agxq.j();
            return;
            if ((!this.jdField_f_of_type_Boolean) && (ahcq.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1024))) {
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1024, 100L);
            }
            i2 = 0;
            break label210;
            if ((paramObject instanceof RecentUser))
            {
              a(200L);
              if ((this.jdField_f_of_type_Boolean) && (((RecentUser)paramObject).getType() == 6004)) {
                this.y = true;
              }
            }
            else if ((paramObject instanceof String[]))
            {
              localObject1 = (String[])paramObject;
              if ((localObject1.length == 2) && (ajed.x.equals(localObject1[0])) && (localObject1[1] != null))
              {
                localObject2 = localObject1[0];
                a(8, localObject1[1], 7000);
              }
            }
            else if ((paramObject instanceof JSONObject))
            {
              JSONObject localJSONObject = (JSONObject)paramObject;
              try
              {
                i1 = localJSONObject.getInt("actionType");
                switch (i1)
                {
                default: 
                  break;
                case 1: 
                  localObject1 = null;
                }
                try
                {
                  localObject2 = localJSONObject.getString("actionUin");
                  localObject1 = localObject2;
                  i1 = localJSONObject.getInt("actionUinType");
                  localObject1 = localObject2;
                }
                catch (JSONException localJSONException2)
                {
                  for (;;)
                  {
                    localJSONException2.printStackTrace();
                    i1 = -1;
                  }
                  a(8, localJSONException1, i1);
                }
                if ((-1 == i1) || (localObject1 == null)) {
                  a(200L);
                }
              }
              catch (JSONException localJSONException1)
              {
                for (;;)
                {
                  localJSONException1.printStackTrace();
                  i1 = -1;
                }
              }
            }
          }
        } while ((!(paramObservable instanceof auqh)) || (!(paramObject instanceof BusinessInfoCheckUpdate.AppInfo)));
        paramObject = (BusinessInfoCheckUpdate.AppInfo)paramObject;
        paramObservable = (auqh)paramObservable;
        paramObservable = auql.a(paramObject);
      } while ((paramObservable == null) || (paramObservable.size() <= 0));
      paramObservable = (auql)paramObservable.get(0);
    } while ((paramObservable.jdField_a_of_type_Int < 1) || (paramObservable.jdField_a_of_type_Int > 4));
    auql.b(this);
  }
  
  void v()
  {
    if ((this.p) && (((ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).b("sp_mayknow_ml_s_a_vl")) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.isShown()) && (!this.jdField_a_of_type_Ahai.isEmpty()))
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
          if (i3 < this.jdField_a_of_type_Ahai.getCount())
          {
            i4 = i1;
            if (this.jdField_a_of_type_Ahai.getItem(i3) != null)
            {
              Object localObject = this.jdField_a_of_type_Ahai.getItem(i3);
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
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, 1, 2130838504, "-conversation-");
  }
  
  public void x()
  {
    Object localObject = a();
    if (this.jdField_e_of_type_Boolean)
    {
      if (localObject == null) {}
      while (this.jdField_a_of_type_Ahek == null) {
        return;
      }
      boolean bool = this.jdField_a_of_type_Ahek.a((ahai)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "moveToCaredItemCyclic: invoked.  canFindUnreadItem: " + bool + " currentCaredType:" + this.jdField_f_of_type_Int + " currentUnreadCaredItemIndex: " + this.jdField_g_of_type_Int);
      }
      int i1 = (int)(a().getResources().getDimension(2131167514) + a().getResources().getDimension(2131167531) / 2.0F);
      int i2 = this.jdField_g_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      if (this.jdField_g_of_type_Int == 0) {
        i1 = 0;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "moveToCaredItemCyclic: invoked. selection1 ", " position: ", Integer.valueOf(i2) });
        }
        this.jdField_a_of_type_Ahek.c();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(i2, i1);
        localObject = new Conversation.56(this, i2);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed((Runnable)localObject, 250L);
      }
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1E3", "0X800A1E3", 0, 0, "", "", "", "");
  }
  
  void y()
  {
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_Begr = begr.a(a());
      this.jdField_a_of_type_Begr.b(2131625677);
      this.jdField_a_of_type_Begr.c(2131625035);
      this.jdField_a_of_type_Begr.a(new aant(this));
    }
    this.jdField_a_of_type_Begr.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation
 * JD-Core Version:    0.7.0.1
 */