package com.tencent.mobileqq.activity;

import aavu;
import aavw;
import aavx;
import aavy;
import aavz;
import aawa;
import aawb;
import aawc;
import aawd;
import aawe;
import aawf;
import aawg;
import aawh;
import aawi;
import aawj;
import aawk;
import aawl;
import aawm;
import aawn;
import aawo;
import aawp;
import aawq;
import aawr;
import aaws;
import aawt;
import aawu;
import aawv;
import aaww;
import aawx;
import aawy;
import aaxb;
import aaxd;
import aaxe;
import aaxf;
import aaxg;
import aaxh;
import aaxi;
import aaxj;
import aaxk;
import aaxl;
import aaxm;
import aaxp;
import aaxq;
import aaxt;
import abxn;
import acpa;
import acuo;
import afpa;
import ahfx;
import ahgk;
import ahgl;
import ahgq;
import ahkd;
import ahmg;
import ahmh;
import ahmo;
import ahmv;
import ahnc;
import ahnl;
import ahnr;
import ahoi;
import ahon;
import ahoo;
import ahpb;
import ahpc;
import ahpd;
import ahpj;
import ahqy;
import aiiz;
import ajac;
import ajsd;
import ajsx;
import ajsy;
import ajto;
import ajud;
import ajuf;
import ajut;
import ajvj;
import ajwk;
import ajwz;
import ajxj;
import ajxl;
import ajya;
import ajyd;
import ajyr;
import akaa;
import akat;
import akee;
import akfk;
import akfn;
import akgj;
import akhb;
import akil;
import akit;
import akng;
import akpb;
import aktf;
import akwq;
import akwu;
import akxb;
import alub;
import alww;
import amtb;
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
import aoez;
import aojc;
import aoun;
import aozg;
import apki;
import aqyf;
import ardd;
import ardf;
import ardh;
import arfg;
import asar;
import asel;
import asfd;
import asff;
import asyx;
import atzn;
import auqk;
import avet;
import avps;
import avpw;
import axmv;
import axqv;
import axqy;
import axrc;
import axrn;
import axva;
import ayaq;
import ayfx;
import aylh;
import ayph;
import aypl;
import aypp;
import ayqr;
import ayrf;
import ayvx;
import bame;
import bamx;
import banb;
import bane;
import baxo;
import bbak;
import bbbn;
import bbbr;
import bbcz;
import bbdc;
import bbdh;
import bbdj;
import bbfj;
import bbfq;
import bbgi;
import bbjx;
import bbkb;
import bbkj;
import bbkk;
import bbzt;
import bbzu;
import bcqf;
import bcql;
import bfnk;
import bfnp;
import bfoi;
import bfos;
import bfpc;
import bfub;
import bfvx;
import bfwu;
import bgnk;
import bhvy;
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
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
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
import lno;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import muc;
import nis;
import njb;
import njl;
import nnu;
import nol;
import nqn;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import osx;
import oti;
import saz;
import sdc;
import sfe;
import ssv;
import stc;
import tfk;
import tfy;
import tfz;
import thv;
import vei;
import xop;
import zzz;

public class Conversation
  extends ajwk
  implements acpa, ahmo, ahnc, ajsd, ajwz, Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, bfos, bfub, bfvx, Observer
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
  private aaxk jdField_a_of_type_Aaxk;
  aaxl jdField_a_of_type_Aaxl = new aaxl(this);
  private aaxp jdField_a_of_type_Aaxp;
  aaxq jdField_a_of_type_Aaxq = null;
  public aaxt a;
  abxn jdField_a_of_type_Abxn = new aawt(this);
  afpa jdField_a_of_type_Afpa;
  private ahgk jdField_a_of_type_Ahgk = new aawd(this);
  private ahgl jdField_a_of_type_Ahgl;
  private ahgq jdField_a_of_type_Ahgq;
  public ahkd a;
  private ahmh jdField_a_of_type_Ahmh;
  public ahmv a;
  public ahoi a;
  private ahoo jdField_a_of_type_Ahoo;
  ahpc jdField_a_of_type_Ahpc;
  public ahqy a;
  protected ajsy a;
  ajto jdField_a_of_type_Ajto = new aawk(this);
  private final ajuf jdField_a_of_type_Ajuf = new aawh(this);
  private final ajut jdField_a_of_type_Ajut = new aawn(this);
  ajvj jdField_a_of_type_Ajvj = new aawl(this);
  private final ajxj jdField_a_of_type_Ajxj = new aawe(this);
  private ajyr jdField_a_of_type_Ajyr = new aawx(this);
  private final akat jdField_a_of_type_Akat = new aawj(this);
  private akfk jdField_a_of_type_Akfk = new aaxm(this);
  private akfn jdField_a_of_type_Akfn = new aaws(this);
  private akgj jdField_a_of_type_Akgj = new aawy(this);
  private final akhb jdField_a_of_type_Akhb = new aawo(this);
  private final akil jdField_a_of_type_Akil = new aawf(this);
  akit jdField_a_of_type_Akit = new aawi(this);
  private akwq jdField_a_of_type_Akwq = new aaxj(this);
  public Dialog a;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aawu(this);
  protected Handler.Callback a;
  public GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public ImageView a;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoez jdField_a_of_type_Aoez = new aaxh(this);
  private aoun jdField_a_of_type_Aoun;
  private aqyf jdField_a_of_type_Aqyf = new aqyf("tool_adMessage", "com.tencent.mobileqq:tool");
  public asar a;
  private final atzn jdField_a_of_type_Atzn = new aawq(this);
  public auqk a;
  bbzu jdField_a_of_type_Bbzu = null;
  private bcqf jdField_a_of_type_Bcqf;
  public bfpc a;
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
  public ArrayList<alww> a;
  public List<RecentBaseData> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final lno jdField_a_of_type_Lno = new aawp(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aaxd(this);
  public MqqHandler a;
  private final ssv jdField_a_of_type_Ssv = new aawr(this);
  public thv a;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  Dialog jdField_b_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new aawv(this);
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  private aqyf jdField_b_of_type_Aqyf = new aqyf("tool_shop", "com.tencent.mobileqq:tool");
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  protected Runnable b;
  public String b;
  final List<String> jdField_b_of_type_JavaUtilList = new ArrayList(40);
  public MqqHandler b;
  public boolean b;
  int jdField_c_of_type_Int;
  public long c;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new aaww(this);
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private aqyf jdField_c_of_type_Aqyf = new aqyf("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private Runnable jdField_c_of_type_JavaLangRunnable;
  MqqHandler jdField_c_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this.jdField_a_of_type_Aaxl);
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
    this.jdField_a_of_type_Aaxt = null;
    this.jdField_f_of_type_Int = 17;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new aavu(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new Conversation.26(this);
    this.jdField_a_of_type_Ajsy = new aawg(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(BaseApplicationImpl.getContext(), new aaxf(this));
    this.jdField_b_of_type_JavaLangRunnable = new Conversation.57(this);
  }
  
  private void C()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Ahmv.c();
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
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ahmv != null)) {}
    }
    else
    {
      return;
    }
    int i3 = this.jdField_a_of_type_Ahmv.getCount();
    int i1 = this.jdField_b_of_type_Int + 1;
    label96:
    int i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Object localObject = this.jdField_a_of_type_Ahmv.getItem(i1);
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
    if ((this.jdField_a_of_type_Ahmv != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (ahpj.a().a(str)) {
        this.jdField_f_of_type_Long = l1;
      }
    }
  }
  
  private void H()
  {
    if (asel.a().b()) {
      asel.a().a(3);
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
        if ((!ajud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.F))
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
      ajud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i1 = ajud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ajud.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1 + 1);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void J()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
  }
  
  private void K()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131364694));
    this.jdField_a_of_type_Aaxk = new aaxk(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_Aaxk, false);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.p = false;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131375493));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377439));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364752));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376477));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368472));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720034);
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
      axmv.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369320);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374872));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDescendantInvalidatedFlags(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(a().getDrawable(2130839135));
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
              localObject2 = ((AppActivity)localObject3).getLayoutInflater().inflate(2131562361, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
            }
          }
          if (localObject2 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject2, 0);
            this.jdField_a_of_type_Afpa = new afpa(a(), 1, (View)localObject2);
            this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
          }
          this.jdField_a_of_type_Ahkd = new ahkd(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          localObject1 = a();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
          if (!ahnl.a().jdField_a_of_type_Boolean)
          {
            bool = true;
            this.jdField_a_of_type_Ahmv = new ahmv((Context)localObject1, (QQAppInterface)localObject2, (XListView)localObject3, this, 0, bool);
            this.jdField_a_of_type_Ahmv.b(true);
            this.jdField_a_of_type_Ahmv.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Ahmv);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
            this.jdField_a_of_type_Ahmv.a(this);
            this.jdField_c_of_type_AndroidViewView = new View(a());
            localObject1 = new AbsListView.LayoutParams(-1, 0);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView, null, false);
            if ((TextUtils.isEmpty(ahnl.a().jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(ahnl.a().jdField_a_of_type_JavaLangString))) {
              break label840;
            }
            localObject1 = new ArrayList(16);
            QLog.d("Q.recent", 1, "ignore PreLoadList");
            this.jdField_a_of_type_Ahmv.a((List)localObject1);
            this.jdField_a_of_type_Ahmv.a(0);
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.q();
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
            this.jdField_a_of_type_Auqk = new auqk(this, this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_a_of_type_Asar = new asar(this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364758));
            IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
            this.jdField_a_of_type_Ahgq = new ahgq(this, this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ahgq);
            return;
            a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
            a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849032);
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166851));
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
            label840:
            List localList = ahnl.a().jdField_b_of_type_JavaUtilList;
            continue;
            localList = null;
          }
        }
      }
    }
  }
  
  private void L()
  {
    Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if ((localManager instanceof avps))
    {
      int i1 = ((avps)localManager).a("104000.104001", 100);
      if (i1 > 0) {
        a(8, ajsd.aB, 7230);
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
      if (amtb.g()) {
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
    a(1027, 0L, false);
    I();
    avpw.a(this);
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
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuf);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akit);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajto);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvj);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akhb);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajut);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajyr);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ssv);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atzn);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akfn);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akgj);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoez);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Lno);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
        }
        if (this.jdField_a_of_type_Aoun != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aoun);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Abxn);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akfk);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akwq);
        localObject1 = (avet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject1 != null) {
          ((avet)localObject1).deleteObserver(this);
        }
        localObject1 = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (localObject1 != null) {
          ((avps)localObject1).deleteObserver(this);
        }
        if (this.jdField_a_of_type_Asar != null) {
          this.jdField_a_of_type_Asar.c();
        }
        ((ahfx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).b(this.jdField_a_of_type_Ahgk);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(17);
      try
      {
        localObject1 = a();
        if (this.jdField_a_of_type_Aaxp != null)
        {
          ((BaseActivity)localObject1).app.a().b(this.jdField_a_of_type_Aaxp);
          this.jdField_a_of_type_Aaxp.a();
          this.jdField_a_of_type_Aaxp = null;
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
      localObject = this.jdField_a_of_type_Ahmv.getItem(0);
    } while (!(localObject instanceof RecentUserBaseData));
    Object localObject = (RecentUserBaseData)localObject;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    boolean bool;
    label98:
    int i1;
    if ((((RecentUserBaseData)localObject).mUser.getType() == 1) && (!asyx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUserBaseData)localObject).mUser)))
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
      i1 = 2130849230;
      label160:
      if (!bool) {
        break label226;
      }
    }
    label217:
    label219:
    label226:
    for (int i2 = 2130849241;; i2 = 2130849240)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(i1);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131365763).setBackgroundResource(i2);
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
      i1 = 2130849229;
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
      if ((ayfx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (ayfx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ahmv != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          label73:
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition())
          {
            Object localObject = this.jdField_a_of_type_Ahmv.getItem(i1);
            if ((!(localObject instanceof RecentItemTencentDocsAssistantData)) || (((RecentItemTencentDocsAssistantData)localObject).b() <= 0)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!nnu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            break label170;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess call");
          }
          if (this.jdField_c_of_type_Aqyf == null) {
            break;
          }
          this.jdField_c_of_type_Aqyf.a();
          return;
          i1 += 1;
          break label73;
        }
      }
    }
  }
  
  private void S()
  {
    this.jdField_a_of_type_Aoun = new aawm(this);
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
    while (i1 >= this.jdField_a_of_type_Ahmv.getCount())
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
      i2 = 0;
      break;
    }
    Object localObject = this.jdField_a_of_type_Ahmv.getItem(i1);
    if ((localObject != null) && ((localObject instanceof RecentBaseData)))
    {
      localObject = (RecentBaseData)localObject;
      if (!(localObject instanceof RecentItemImaxADData)) {}
    }
    for (;;)
    {
      i3 += 1;
      break;
      this.jdField_a_of_type_Ahmv.a().a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a(), false);
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
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfAhmj[0] = new aaxb(this);
  }
  
  private void V()
  {
    if ((this.w) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      ThreadManager.post(new Conversation.50(this), 5, null, true);
    }
  }
  
  private void W()
  {
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_Ahoi != null))
    {
      this.jdField_a_of_type_Ahoi.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1048, 0, 0).sendToTarget();
    }
  }
  
  private void X()
  {
    if (!this.w) {
      break label7;
    }
    label7:
    while (!this.jdField_a_of_type_Ahkd.b(21)) {
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
      ThreadManager.post(new Conversation.51(this, this.jdField_a_of_type_Ahkd.a(21, 2131362147)), 5, null, false);
      return;
    }
  }
  
  private void Y()
  {
    try
    {
      if (this.jdField_a_of_type_Bcqf == null)
      {
        this.jdField_a_of_type_Bcqf = new bcqf(a(), a().getTitleBarHeight());
        this.jdField_a_of_type_Bcqf.c(2131694918);
        this.jdField_a_of_type_Bcqf.c(false);
        this.jdField_a_of_type_Bcqf.setOnDismissListener(new aaxg(this));
      }
      this.jdField_a_of_type_Bcqf.show();
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
      if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
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
        aavw localaavw = new aavw(this);
        aavx localaavx = new aavx(this, localUpgradeTIMWrapper);
        if (TextUtils.isEmpty(localUpgradeTIMWrapper.d))
        {
          paramMessage = ajya.a(2131702600);
          if (!TextUtils.isEmpty(localUpgradeTIMWrapper.e)) {
            break label323;
          }
          str = ajya.a(2131702610);
          this.jdField_c_of_type_AndroidAppDialog = bbdj.a(a(), localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString, localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString, paramMessage, str, null, localaavx, localaavw);
          this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new aavy(this));
          if ((!this.w) || (this.jdField_c_of_type_AndroidAppDialog.isShowing()) || ((this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.isShowing())) || (ajud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            continue;
          }
          this.jdField_c_of_type_AndroidAppDialog.show();
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
          ajud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if ((paramAbsListView != null) && (this.jdField_a_of_type_Ahmv != null))
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
          localObject1 = this.jdField_a_of_type_Ahmv.getItem(i2);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemPublicAccountADFolderData))) {
            break label226;
          }
          localObject1 = (RecentItemPublicAccountADFolderData)localObject1;
          if (!ardh.a(paramAbsListView.getChildAt(i2 - i1))) {
            break label226;
          }
          localObject1 = njb.a().a(((RecentItemPublicAccountADFolderData)localObject1).mUser.uin);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Message localMessage = Message.obtain();
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("key_app", new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        ((HashMap)localObject2).put("key_adapter", new WeakReference(this.jdField_a_of_type_Ahmv));
        ((HashMap)localObject2).put("key_listview", new WeakReference(paramAbsListView));
        localMessage.obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_ad_id", ((nis)localObject1).c);
        localMessage.setData((Bundle)localObject2);
        localMessage.what = 1;
        ardd.a().a(localMessage);
        i2 += 1;
      }
    }
  }
  
  public static void a(MqqHandler paramMqqHandler, Context paramContext)
  {
    paramMqqHandler.removeMessages(1134065);
    if (FriendsStatusUtil.a(paramContext))
    {
      axqy.b(null, "CliOper", "", "", "0X8009EB9", "0X8009EB9", 0, 1, "", "", "", "");
      Message localMessage = paramMqqHandler.obtainMessage(1134065);
      localMessage.arg1 = 2;
      paramMqqHandler.sendMessage(localMessage);
      long l1 = FriendsStatusUtil.a(paramContext);
      if (l1 > 0L) {
        paramMqqHandler.postDelayed(new Conversation.34(paramMqqHandler), l1 * 1000L);
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
      if (ajud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) >= 5)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((ajud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (ajud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog = new UpgradeTipsDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.setOnDismissListener(new aavz(this));
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
          if (((((RecentUserBaseData)localObject).a() == 1) && (!asyx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUserBaseData)localObject).mUser)) && (localTroopManager.b(((RecentUserBaseData)localObject).a()))) || (((RecentUserBaseData)localObject).mUser.showUpTime != 0L)) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(((RecentUserBaseData)localObject).a()).append("-").append(bbkk.e(((RecentUserBaseData)localObject).a())).append("-").append(i1).append(" , ");
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
  
  private void i(boolean paramBoolean)
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
    if (this.jdField_a_of_type_Thv == null) {
      this.jdField_a_of_type_Thv = new thv(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, (BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367580));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)) {
      this.jdField_a_of_type_Thv.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
    }
    this.jdField_a_of_type_Thv.jdField_f_of_type_Boolean = this.w;
    this.jdField_a_of_type_Thv.b();
    for (this.s = false;; this.s = false)
    {
      this.m = paramBoolean;
      return;
      label149:
      if (this.jdField_a_of_type_Thv != null) {
        this.jdField_a_of_type_Thv.c();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsy, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuf, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akat, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akit, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajto, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvj, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akhb, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atzn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajut);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajyr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ssv);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akfn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Abxn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoez);
    Object localObject2 = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject2 != null) {
      ((avps)localObject2).addObserver(this);
    }
    if (this.jdField_a_of_type_Aoun == null) {
      S();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aoun);
    if (this.jdField_a_of_type_Aaxp == null) {
      this.jdField_a_of_type_Aaxp = new aaxp(this);
    }
    this.jdField_a_of_type_Aaxp.addFilter(new Class[] { ayph.class, aypl.class, C2CPttDownloadProcessor.class, aypp.class, ayrf.class, GroupPttDownloadProcessor.class, ayqr.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aaxp);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
        localObject2 = (avet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject2 != null) {
          ((avet)localObject2).addObserver(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Lno);
        muc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akgj);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akfk);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akwq);
        if (this.jdField_a_of_type_Asar != null) {
          this.jdField_a_of_type_Asar.b();
        }
        ((ahfx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).a(this.jdField_a_of_type_Ahgk);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.x();
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
    if ((!sfe.k) || ((!paramBoolean) && (nnu.a().jdField_a_of_type_Boolean))) {}
    label151:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ahmv != null))
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
        if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
          if (!(this.jdField_a_of_type_Ahmv.getItem(i1) instanceof RecentItemPublicAccountADFolderData)) {}
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label151;
        }
        if ((this.jdField_a_of_type_Aqyf != null) && (!this.x))
        {
          this.jdField_a_of_type_Aqyf.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.x = true;
        }
        nnu.a().jdField_a_of_type_Boolean = true;
        ThreadManager.getSubThreadHandler().postDelayed(new Conversation.23(this), 1000L);
        return;
        i1 += 1;
        break;
      }
    }
  }
  
  int a()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Ahmv.getCount())
    {
      if ((this.jdField_a_of_type_Ahmv.getItem(i1) instanceof RecentItemMayKnowFriendVerticalListData)) {
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
      } while (ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
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
  
  public ahmv a()
  {
    return this.jdField_a_of_type_Ahmv;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    bbkj.a(null, "Recent_Start");
    bbkj.a(null, "Recent_CreateView");
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
        localObject2 = paramLayoutInflater.inflate(2131558867, null);
      }
      bbkj.a("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public String a()
  {
    String str = ajya.a(2131702607);
    if (this.jdField_d_of_type_Int <= 0) {
      return str;
    }
    if (this.jdField_d_of_type_Int > 99) {
      return str + "(99+)";
    }
    return str + "(" + this.jdField_d_of_type_Int + ")";
  }
  
  public thv a()
  {
    return this.jdField_a_of_type_Thv;
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
                      localObject = axva.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
                    } while (localObject == null);
                    String str = paramIntent.getStringExtra("uin");
                    paramInt1 = paramIntent.getIntExtra("uintype", -1);
                    paramInt2 = paramIntent.getIntExtra("cmshow_game_id", -1);
                    bbjx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramInt1, (AbsStructMsg)localObject, null);
                    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(paramInt1), 0, new String[] { Integer.toString(paramInt2) });
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
            banb.a(a(), paramIntent, true);
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
            return;
          } while (paramInt2 != -1);
          bcql.a(a(), 2, a(2131720582), 0).b(a().getTitleBarHeight());
          return;
        } while (!QLog.isColorLevel());
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + -1);
        return;
        ahoi.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
        return;
        localObject = ajac.a();
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.ao_();
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
    aktf localaktf;
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      str = "1";
      localaktf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject2 = paramRecentBaseData.a();
      localObject1 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((paramInt != 7000) || (ajsd.x.equals(localObject2))) {
        break label173;
      }
      ayaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, paramBoolean);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str, paramString, "");
    }
    int i2;
    int i1;
    for (;;)
    {
      i2 = a(paramRecentBaseData.a(), paramInt);
      paramRecentBaseData = localaktf.a(false).iterator();
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
        if (this.jdField_a_of_type_Ahpc != null) {
          this.jdField_a_of_type_Ahpc.a(paramRecentBaseData, paramBoolean);
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", str, paramString, "");
      }
      else
      {
        if (paramInt != 5001) {
          break label262;
        }
        ((ajyd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramBoolean);
      }
    }
    label262:
    if (paramInt == 1)
    {
      paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject1 = paramString.d(paramRecentBaseData.a());
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = (ajsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
        if (paramBoolean)
        {
          i1 = 0;
          label320:
          if (((ajsx)localObject2).a((String)localObject1, i1)) {
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
          localObject1 = new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
          localObject2 = paramRecentBaseData.a();
          if (!paramBoolean) {
            break;
          }
        }
        for (paramString = "0";; paramString = "1")
        {
          ((axrc)localObject1).a(new String[] { localObject2, String.valueOf(i1), paramString }).a();
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
        if ((localObject2 != null) && (((String)localObject2).length() != 0) && (localaktf != null)) {
          break label612;
        }
      } while (!QLog.isColorLevel());
      paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
      if (localObject2 == null)
      {
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (localaktf != null) {
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
      localObject1 = localaktf.b((String)localObject2, i1);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = new RecentUser((String)localObject2, i1);
      }
      if (!asyx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) {
        break;
      }
      if (paramBoolean) {}
      for (paramString.showUpTime = (System.currentTimeMillis() / 1000L);; paramString.showUpTime = 0L)
      {
        localaktf.a(paramString);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        break;
      }
      if ((paramInt == 0) && (((ajxl)localObject1).b((String)localObject2)))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramBoolean) {}
        for (i1 = 1;; i1 = 2)
        {
          axqy.b(paramString, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i1, "0", "0", "", "");
          if (bbfj.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
            break;
          }
          bcql.a(a(), 1, 2131696414, 0).b(a().getTitleBarHeight());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "setChatAtTop top: " + paramBoolean + " uin: " + (String)localObject2 + " userType: " + paramInt);
        }
        FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, paramBoolean);
        break;
      }
      i1 = paramRecentBaseData.a();
      if ((localObject2 != null) && (((String)localObject2).length() != 0) && (localaktf != null)) {
        break label976;
      }
    } while (!QLog.isColorLevel());
    label391:
    paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
    if (localObject2 == null)
    {
      paramBoolean = true;
      paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
      if (localaktf != null) {
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
    paramString = localaktf.b((String)localObject2, i1);
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
        localaktf.a(paramString);
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
        Iterator localIterator = localaktf.a(false).iterator();
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
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + i2, (String)localObject1, (String)localObject1, 0, 0, "" + i3, "" + i1, "", "");
          for (;;)
          {
            if ((7220 == paramString.getType()) && (ajsd.aA.equals(localObject2)))
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
                localIterator = localaktf.a(false).iterator();
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
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", paramString.uin, (String)localObject1, (String)localObject1, 0, 0, "" + i2, "" + i1, "", "");
            if (!"2290230341".equals(localObject2)) {
              break label1232;
            }
            if (paramBoolean) {}
            for (localObject1 = "0X80090E6";; localObject1 = "0X800915B")
            {
              if (paramBoolean) {
                axqv.a(4);
              }
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
              break label1232;
              break;
            }
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, str, String.valueOf(i1), String.valueOf(i2), "");
            if (paramInt != 7220) {
              break label332;
            }
            if (paramBoolean)
            {
              nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
              return;
            }
            nol.a(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
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
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_Ahkd != null)) {
        this.jdField_a_of_type_Ahkd.a(paramRecentUser.uin);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.getType());
      }
    } while ((paramInt & 0x4) == 0);
    ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, -1);
    bcql.a(a(), ajya.a(2131702606), 0).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 8) && (paramInt1 != 9)) {
      return;
    }
    a(0, paramInt1, ahnl.a(paramString, paramInt2));
  }
  
  public void a(int paramInt, List<RecentBaseData> paramList)
  {
    if ((-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a()) || ((this.G) && (this.H)))
    {
      this.jdField_a_of_type_Aaxk.a(paramInt, paramList);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      if (AppSetting.jdField_i_of_type_Boolean) {
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
    else if (this.jdField_a_of_type_Ahmv != null)
    {
      if (paramInt != 0) {
        break label439;
      }
      if (this.p)
      {
        localObject = (akaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
        if ((((akaa)localObject).jdField_a_of_type_Boolean) && (((akaa)localObject).a(paramList))) {
          ((akaa)localObject).jdField_a_of_type_Boolean = false;
        }
      }
      this.jdField_a_of_type_Ahmv.a(paramList);
      if (this.D)
      {
        this.D = false;
        if (this.E)
        {
          if (!this.jdField_f_of_type_Boolean) {
            break label432;
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addOnLayoutChangeListener(new aaxi(this));
        }
      }
    }
    for (;;)
    {
      this.E = false;
      if (paramList != null) {
        ahnl.a().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      }
      this.jdField_a_of_type_Ahmv.a(0);
      if (AppSetting.jdField_i_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.10(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_d_of_type_Int);
      a(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      if (this.n)
      {
        this.n = false;
        if ((((tfz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Thv != null)) {
          this.jdField_a_of_type_Thv.e();
        }
      }
      if (this.y)
      {
        this.y = false;
        R();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
      Q();
      akwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, 0);
      return;
      i1 = paramList.size();
      break;
      label432:
      Z();
    }
    label439:
    if (paramList == null)
    {
      paramInt = 0;
      label445:
      i1 = 0;
      label447:
      if (i1 < paramInt)
      {
        localObject = (RecentBaseData)paramList.get(i1);
        if (localObject != null) {
          break label486;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label447;
      break;
      paramInt = paramList.size();
      break label445;
      label486:
      this.jdField_a_of_type_Ahmv.a((RecentBaseData)localObject);
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
      this.jdField_a_of_type_Ahkd.a(8, 0);
    }
    boolean bool1;
    int i1;
    label111:
    boolean bool2;
    if (!paramBoolean1)
    {
      bool1 = true;
      asel.a().a(bool1);
      localObject1 = this.jdField_a_of_type_Ahkd;
      if (!bool1) {
        break label244;
      }
      i1 = 2;
      ((ahkd)localObject1).a(1, i1);
      bool2 = asel.a().d();
      if ((!bool2) || (paramInt != 1134012)) {
        break label352;
      }
      bool2 = false;
    }
    label352:
    for (;;)
    {
      asel.a().b(bool2);
      localObject1 = this.jdField_a_of_type_Ahkd;
      i1 = i2;
      if (bool2) {
        i1 = 2;
      }
      ((ahkd)localObject1).a(9, i1);
      this.jdField_a_of_type_Ahkd.a(-1, null);
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (alww)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              ((alww)localObject2).b(paramBoolean1);
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
        ((StringBuilder)localObject1).append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", isNetSupport = ").append(paramBoolean1).append(", loadingState = ").append(asel.a().a()).append(", msg = ").append(paramInt);
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
    int i1 = bbak.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    bbak.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i1 + 1);
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
    if ((this.jdField_a_of_type_Ahoi != null) && (this.jdField_a_of_type_Ahoi.a())) {
      this.jdField_a_of_type_Ahoi.b();
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
        paramMessage.append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", initLoadingHandle = ").append(paramBoolean).append(", loadingState = ").append(asel.a().a()).append(", what = ").append(i1);
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
    if (this.jdField_a_of_type_Ahmv == null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = this.jdField_a_of_type_Ahmv.a(paramView);
      if ((localRecentBaseData != null) && ("9970".equals(localRecentBaseData.a()))) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
      }
    } while ((localRecentBaseData == null) || (!ajsd.aB.equals(localRecentBaseData.a())));
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
    if ((paramString.equals("sp_uin_for_title")) && (i2 == 2131374956))
    {
      y();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "msgtab_list_clk", 2);
      return;
    }
    akaa localakaa = (akaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramString, 102);
    boolean bool = localakaa.a();
    ArrayList localArrayList = localakaa.c();
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
      if (i2 == 2131375183)
      {
        if (!bbfj.g(paramContext))
        {
          bcql.a(paramContext, paramContext.getResources().getString(2131692321), 0).b(a().getTitleBarHeight());
          return;
        }
        paramString = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((!paramString.b(paramView.uin)) && (!paramString.d(paramView.uin)))
        {
          paramString = paramView.getDisplayName(localakaa.a());
          paramContext = AddFriendLogicActivity.a(paramContext, 1, paramView.uin, null, 3045, 25, paramString, null, null, paramContext.getString(2131689628), null);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(25), "", "", "");
          a(paramContext);
        }
        for (;;)
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
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
      ((akaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.a());
      return;
    }
    bbkj.a(null, "AIO_Click_cost");
    bbfq.a(null, "pubAcc_aio_open", "");
    bbbn.a(true);
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
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", str, str, 0, 0, paramView.uin + "", "" + l1, "" + i1, "" + localRecentUserBaseData.mUnreadNum);
        bfnp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramRecentBaseData);
        akwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData);
        i1 = ahpd.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData);
        if ((paramView != null) && (paramView.lFlag == 16L) && (i1 == 0) && (this.jdField_a_of_type_Aqyf != null))
        {
          this.jdField_a_of_type_Aqyf.b();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "ad preload tool process hit");
          }
        }
        if ((paramView != null) && (String.valueOf(9970L).equals(paramView.uin)) && (this.jdField_b_of_type_Aqyf != null)) {
          this.jdField_b_of_type_Aqyf.b();
        }
        if ((paramView != null) && (paramView.getType() == 6004) && (this.jdField_c_of_type_Aqyf != null)) {
          this.jdField_c_of_type_Aqyf.b();
        }
        a(i1, paramView);
        if (paramRecentBaseData != null)
        {
          ahpb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramView);
          paramRecentBaseData.b();
          bfoi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.a());
          this.jdField_i_of_type_Boolean = true;
        }
        if (paramView != null)
        {
          paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
          paramRecentBaseData.setFeedInfoRead(paramView.uin);
          if (!FeedsManager.isShowStatus(paramView.uin)) {
            break label739;
          }
          paramString = (acuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
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
          bbkj.a("AIO_Click_cost", null);
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
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090CC", "0X80090CC", i1, 0, "", "", "", "");
            break;
          }
          label739:
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.uin, paramView.getType());
          if ((paramView != null) && (paramView.msgtype == -1034))
          {
            paramView = (acuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
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
    stc localstc = (stc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
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
      if (paramView.getId() == 2131363450)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
        paramView = new Intent(a(), ForwardRecentActivity.class);
        paramView.putExtra("forward_type", 13);
        a(paramView);
        return;
      }
      if ((paramView.getId() == 2131366700) || (paramView.getId() == 2131366702) || (paramView.getId() == 2131366703) || (paramView.getId() == 2131366704) || (paramView.getId() == 2131366705) || (paramView.getId() == 2131366706) || (paramView.getId() == 2131366707))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = bbcz.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, paramView, paramObject, null, true, null, true, true, null, null);
        return;
      }
    } while ((paramView.getId() != 2131368703) || (!localstc.b(paramObject)));
    localstc.a(paramView, (RecentItemChatMsgData)paramObject);
  }
  
  public void a(bbzu parambbzu, bbzt parambbzt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) && (parambbzt != null) && (parambbzt.jdField_d_of_type_Long == 0L) && (parambbzt.jdField_a_of_type_Long != 0L)) {
      parambbzu.a(parambbzt.jdField_a_of_type_Long);
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
        ahpb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
        ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i1);
        this.jdField_a_of_type_Aaxq.a(paramString);
      }
    }
    for (;;)
    {
      return;
      localObject = (avet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
      if ((localObject != null) && (paramRecentBaseData != null)) {}
      try
      {
        ((avet)localObject).b(paramRecentBaseData.a(), paramRecentBaseData.a());
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
        if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
          if (paramRecentBaseData.a() == 3000)
          {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
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
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = a();
    int i1 = paramRecentBaseData.a();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_Ahpc == null)) {
      this.jdField_a_of_type_Ahpc = new ahpc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (bbbr.a(paramString1, localResources.getString(2131691256)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
      if (!bbbr.a(paramString1, localResources.getString(ahnw.a[4]))) {
        break label408;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.a(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
    }
    label408:
    while (!bbbr.a(paramString1, localResources.getString(ahnw.a[5])))
    {
      return;
      if (bbbr.a(paramString1, localResources.getString(2131691260)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        break;
      }
      if (bbbr.a(paramString1, localResources.getString(2131693199)))
      {
        a(i1, paramRecentBaseData, paramString2, false);
        if (i1 != 3000) {
          break;
        }
        new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").a();
        break;
      }
      if (bbbr.a(paramString1, localResources.getString(2131693201)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        if (i1 != 3000) {
          break;
        }
        new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").a();
        break;
      }
      if (!bbbr.a(paramString1, localResources.getString(2131694443))) {
        break;
      }
      this.jdField_a_of_type_Ahoo.a(a(), paramRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramRecentBaseData.a(), "0X800991D", "0X800991D", 0, 0, "", "", "", "");
      break;
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1.uin, paramString1.getType(), 1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
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
    if (this.jdField_a_of_type_Ahmv != null) {
      this.jdField_a_of_type_Ahmv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Ahkd.a(21, 0);
    ahnl.a().a();
    if (this.jdField_a_of_type_Aaxq != null) {
      this.jdField_a_of_type_Aaxq.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_Auqk != null) {
      this.jdField_a_of_type_Auqk.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        alww localalww = (alww)localIterator.next();
        if (localalww != null) {
          localalww.a(paramLogoutReason);
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
    //   0: invokestatic 509	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 434
    //   9: iconst_2
    //   10: new 436	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 2723
    //   20: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 450	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 453	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 513	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   37: invokevirtual 2726	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   40: ifge +11 -> 51
    //   43: aload_0
    //   44: getfield 513	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   47: iconst_0
    //   48: invokevirtual 2729	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 2731	com/tencent/mobileqq/activity/Conversation:j	(Z)V
    //   56: iload_1
    //   57: ifeq +342 -> 399
    //   60: invokestatic 622	asel:a	()Lasel;
    //   63: invokevirtual 2732	asel:a	()V
    //   66: invokestatic 836	ahnl:a	()Lahnl;
    //   69: invokevirtual 2716	ahnl:a	()V
    //   72: aload_0
    //   73: getfield 1571	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   76: ifeq +22 -> 98
    //   79: aload_0
    //   80: getfield 513	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   83: ifnull +15 -> 98
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 1571	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   91: aload_0
    //   92: getfield 513	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   95: invokevirtual 2735	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   98: aload_0
    //   99: getfield 639	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   102: ifnull +15 -> 117
    //   105: aload_0
    //   106: getfield 639	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   109: invokevirtual 2736	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 639	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   117: aload_0
    //   118: getfield 654	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   121: ifnull +15 -> 136
    //   124: aload_0
    //   125: getfield 654	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   128: invokevirtual 662	android/app/Dialog:dismiss	()V
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 654	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   136: aload_0
    //   137: getfield 823	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Afpa	Lafpa;
    //   140: ifnull +14 -> 154
    //   143: aload_0
    //   144: getfield 823	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Afpa	Lafpa;
    //   147: aload_0
    //   148: getfield 540	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   151: invokevirtual 2737	afpa:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   154: aload_0
    //   155: getfield 1935	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahpc	Lahpc;
    //   158: ifnull +14 -> 172
    //   161: aload_0
    //   162: getfield 1935	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahpc	Lahpc;
    //   165: aload_0
    //   166: getfield 540	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: invokevirtual 2738	ahpc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   172: aload_0
    //   173: getfield 455	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahmv	Lahmv;
    //   176: ifnull +25 -> 201
    //   179: aload_0
    //   180: getfield 455	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahmv	Lahmv;
    //   183: aload_0
    //   184: getfield 540	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   187: invokevirtual 2739	ahmv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   190: aload_0
    //   191: iconst_1
    //   192: bipush 10
    //   194: lconst_0
    //   195: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: invokevirtual 479	com/tencent/mobileqq/activity/Conversation:a	(IILjava/lang/Object;)V
    //   201: aload_0
    //   202: getfield 513	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   205: ifnull +11 -> 216
    //   208: aload_0
    //   209: getfield 513	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   212: iconst_0
    //   213: invokevirtual 2742	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   216: aload_0
    //   217: iconst_0
    //   218: invokespecial 1411	com/tencent/mobileqq/activity/Conversation:i	(Z)V
    //   221: aload_0
    //   222: getfield 1587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Thv	Lthv;
    //   225: ifnull +14 -> 239
    //   228: aload_0
    //   229: getfield 1587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Thv	Lthv;
    //   232: aload_0
    //   233: getfield 540	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   236: invokevirtual 2743	thv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   239: aload_0
    //   240: getfield 985	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   243: ifnull +16 -> 259
    //   246: aload_0
    //   247: getfield 985	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   250: aload_0
    //   251: getfield 540	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   254: invokeinterface 2748 2 0
    //   259: ldc_w 434
    //   262: ldc_w 2750
    //   265: aload_0
    //   266: getfield 540	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   269: getfield 2612	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   272: invokevirtual 2751	com/tencent/mobileqq/app/automator/Automator:b	()Z
    //   275: invokestatic 2175	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   278: invokestatic 2756	ved:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   281: aload_0
    //   282: sipush 1055
    //   285: lconst_0
    //   286: iconst_0
    //   287: invokevirtual 651	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   290: aload_0
    //   291: getfield 831	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkd	Lahkd;
    //   294: ifnull +10 -> 304
    //   297: aload_0
    //   298: getfield 831	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahkd	Lahkd;
    //   301: invokevirtual 2757	ahkd:e	()V
    //   304: aload_0
    //   305: getfield 179	com/tencent/mobileqq/activity/Conversation:jdField_j_of_type_Boolean	Z
    //   308: ifeq +13 -> 321
    //   311: aload_0
    //   312: getfield 1116	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   315: bipush 12
    //   317: invokevirtual 470	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   320: pop
    //   321: aload_0
    //   322: getfield 680	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   325: getfield 907	com/tencent/mobileqq/app/FrameHelperActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   328: iconst_4
    //   329: invokevirtual 2758	android/os/Handler:sendEmptyMessage	(I)Z
    //   332: pop
    //   333: aload_0
    //   334: sipush 1035
    //   337: ldc2_w 2759
    //   340: iconst_0
    //   341: invokevirtual 651	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   344: aload_0
    //   345: sipush 1010
    //   348: ldc2_w 2759
    //   351: iconst_1
    //   352: invokevirtual 651	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   355: aload_0
    //   356: sipush 1063
    //   359: lconst_0
    //   360: iconst_1
    //   361: aconst_null
    //   362: invokevirtual 1346	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   365: aload_0
    //   366: sipush 1064
    //   369: ldc2_w 2759
    //   372: iconst_1
    //   373: ldc_w 2762
    //   376: invokevirtual 1346	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   379: aload_0
    //   380: aload_0
    //   381: getfield 540	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   384: bipush 76
    //   386: invokevirtual 963	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   389: checkcast 2623	bbzu
    //   392: putfield 189	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bbzu	Lbbzu;
    //   395: aload_0
    //   396: invokespecial 2764	com/tencent/mobileqq/activity/Conversation:W	()V
    //   399: aload_0
    //   400: sipush 10001
    //   403: ldc2_w 2765
    //   406: iconst_0
    //   407: invokevirtual 651	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   410: aload_0
    //   411: getfield 540	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   414: invokevirtual 1666	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   417: ifne +15 -> 432
    //   420: aload_0
    //   421: getfield 179	com/tencent/mobileqq/activity/Conversation:jdField_j_of_type_Boolean	Z
    //   424: ifeq +8 -> 432
    //   427: aload_0
    //   428: lconst_0
    //   429: invokevirtual 2767	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   432: aload_0
    //   433: ldc_w 2768
    //   436: ldc2_w 2769
    //   439: iconst_0
    //   440: invokevirtual 651	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   443: invokestatic 1202	nnu:a	()Lnnu;
    //   446: aload_0
    //   447: getfield 540	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   450: invokevirtual 1024	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   453: invokevirtual 2771	nnu:a	(Ljava/lang/String;)V
    //   456: getstatic 2774	aslg:jdField_g_of_type_Boolean	Z
    //   459: ifeq +13 -> 472
    //   462: invokestatic 2777	aslg:a	()Laslg;
    //   465: aload_0
    //   466: getfield 540	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   469: invokevirtual 2778	aslg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   472: return
    //   473: astore_2
    //   474: aload_0
    //   475: aconst_null
    //   476: putfield 639	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   479: goto -362 -> 117
    //   482: astore_2
    //   483: aload_0
    //   484: aconst_null
    //   485: putfield 639	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   488: aload_2
    //   489: athrow
    //   490: astore_2
    //   491: aload_0
    //   492: aconst_null
    //   493: putfield 654	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   496: goto -360 -> 136
    //   499: astore_2
    //   500: aload_0
    //   501: aconst_null
    //   502: putfield 654	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
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
  
  public boolean a(bbzu parambbzu, bbzt parambbzt)
  {
    if ((parambbzt == null) || (parambbzu == null)) {}
    do
    {
      return false;
      if (parambbzt.jdField_d_of_type_Long == 3L) {
        parambbzu.a(4L, parambbzt.jdField_a_of_type_Long);
      }
    } while ((parambbzt == null) || (parambbzt.jdField_d_of_type_Long != 2L) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) || (!this.w));
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
          bool1 = ((ahfx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).c();
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
      bbkj.a("Conversation_PullToRefresh_start", 0L);
      o();
      ThreadManager.getSubThreadHandler().post(new Conversation.11(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      }
      if (((tfz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
      {
        ((tfy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a().a(2);
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
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130849229);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131365763).setBackgroundResource(2130849240);
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
      axmv.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Auqk.k();
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        alww localalww = (alww)localIterator.next();
        if (localalww != null) {
          localalww.m();
        }
      }
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849032);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166851));
    }
    if (this.jdField_a_of_type_Ahqy != null) {
      this.jdField_a_of_type_Ahqy.e();
    }
    if (this.jdField_a_of_type_Thv != null) {
      this.jdField_a_of_type_Thv.j();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onPostThemeChanged();
    }
    if (this.jdField_a_of_type_Ahkd != null) {
      this.jdField_a_of_type_Ahkd.a(-1, null);
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
    bane localbane = (bane)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
    if (localbane != null) {
      localbane.a(paramLong);
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
    if (this.jdField_a_of_type_Aaxt != null) {
      this.jdField_a_of_type_Aaxt.d();
    }
  }
  
  public View c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_c_of_type_AndroidViewView;
  }
  
  public void c()
  {
    if (SystemClock.uptimeMillis() - thv.jdField_b_of_type_Long > 500L)
    {
      F();
      if ((this.w) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof HongBaoListView)) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mEnableStory) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mForStory))
      {
        if (this.jdField_a_of_type_Thv != null) {
          this.jdField_a_of_type_Thv.i();
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
        this.jdField_c_of_type_AndroidWidgetImageView.setId(2131369491);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, i1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(7.0F * bbdh.a()));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      }
    }
    while ((this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
      try
      {
        int i1;
        Object localObject = a().getResources().getDrawable(2130839142);
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
  
  public void d(boolean paramBoolean)
  {
    QLog.d("Q.recent", 2, "onResume...");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.C = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = true;
    akaa.jdField_e_of_type_Boolean = true;
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
    ahpj.a().c();
    if (this.jdField_a_of_type_Afpa != null) {
      this.jdField_a_of_type_Afpa.a();
    }
    if (AppSetting.jdField_i_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(true);
    }
    this.jdField_f_of_type_Boolean = true;
    try
    {
      a().getWindow().setSoftInputMode(32);
      Object localObject1 = this.jdField_a_of_type_Bbzu;
      if (localObject1 != null)
      {
        localObject2 = ((bbzu)localObject1).a();
        if (localObject2 != null)
        {
          a((bbzu)localObject1, (bbzt)localObject2);
          if (a((bbzu)localObject1, (bbzt)localObject2) == true)
          {
            localObject1 = a();
            if ((localObject1 != null) && ((localObject1 instanceof SplashActivity))) {
              ((SplashActivity)localObject1).c();
            }
          }
        }
      }
      if (this.jdField_a_of_type_Ahkd != null)
      {
        boolean bool = asel.a().d();
        localObject1 = this.jdField_a_of_type_Ahkd;
        if (bool)
        {
          i1 = 2;
          ((ahkd)localObject1).a(9, i1);
          asel.a().b(bool);
          this.jdField_a_of_type_Ahkd.b();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == 0) {
            break label638;
          }
          i1 = 1;
          localObject1 = this.jdField_a_of_type_Ahkd;
          if (i1 == 0) {
            break label643;
          }
          i1 = 2;
          ((ahkd)localObject1).a(38, i1);
          if (!apki.a().a()) {
            break label648;
          }
          i1 = 1;
          localObject1 = this.jdField_a_of_type_Ahkd;
          if (i1 == 0) {
            break label653;
          }
          i1 = 2;
          ((ahkd)localObject1).a(39, i1);
        }
      }
      else
      {
        alub.a().c();
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
        if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_Ahmv != null)) {
          this.jdField_a_of_type_Ahmv.notifyDataSetChanged();
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
        if ((this.jdField_a_of_type_Auqk.jdField_d_of_type_Int != -1) && (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int != 1))
        {
          this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
          this.jdField_a_of_type_Auqk.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Auqk.d();
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          break label724;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label719;
          }
          localObject2 = (alww)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            if (!this.v) {
              break;
            }
            ((alww)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            ((alww)localObject2).jdField_e_of_type_Boolean = true;
            ((alww)localObject2).j();
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
        this.jdField_a_of_type_Auqk.e();
        continue;
        ((alww)localObject2).d();
      }
      label719:
      this.v = false;
      label724:
      if (this.t) {
        this.t = false;
      }
      if (AppSetting.jdField_d_of_type_Boolean) {
        a().setTitle(a(2131694070));
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new Conversation.20(this), 500L);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1070, 3000L);
      ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
      onh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_c_of_type_JavaLangRunnable == null) {
        this.jdField_c_of_type_JavaLangRunnable = new Conversation.21(this);
      }
      ThreadManagerV2.excute(this.jdField_c_of_type_JavaLangRunnable, 32, null, true);
      if (!bbkb.e(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
        if ((localObject3 == null) || (((List)localObject3).size() == 0))
        {
          bbkb.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
          if (bbkb.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).contains(localObject3)) {
            localArrayList.remove(localObject3);
          }
        }
        if (localArrayList.size() == 0)
        {
          bbkb.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          return;
        }
        ((ajsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(localArrayList, 0);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new Conversation.22(this), 5000L);
      a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      ardf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahmv, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      nnu.a().jdField_a_of_type_Boolean = false;
      if (!paramBoolean) {
        break label1319;
      }
    }
    this.x = true;
    for (;;)
    {
      if (this.jdField_a_of_type_Asar != null) {
        this.jdField_a_of_type_Asar.a();
      }
      k(true);
      R();
      s();
      ApngImage.playByTag(2);
      if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1053)) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1053, 500L);
      }
      if (this.jdField_a_of_type_Thv != null) {
        this.jdField_a_of_type_Thv.l();
      }
      if (this.jdField_a_of_type_Ahkd != null) {
        this.jdField_a_of_type_Ahkd.g();
      }
      ahoo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      Q();
      if (this.jdField_a_of_type_Ahqy != null) {
        this.jdField_a_of_type_Ahqy.d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onResume();
      }
      aylh.a(null);
      return;
      label1319:
      this.x = false;
      if (this.jdField_a_of_type_Aqyf != null) {
        this.jdField_a_of_type_Aqyf.d();
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
    if (this.jdField_a_of_type_Ahkd != null) {
      this.jdField_a_of_type_Ahkd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Auqk != null) {
      this.jdField_a_of_type_Auqk.c();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        alww localalww = (alww)localIterator.next();
        if (localalww != null) {
          localalww.i();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134065);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134061);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134068);
    axqv.a();
    if (this.jdField_a_of_type_Ahoi != null) {
      this.jdField_a_of_type_Ahoi.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Ahoo != null) {
      this.jdField_a_of_type_Ahoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_Ahmh != null) {
      this.jdField_a_of_type_Ahmh.a(a());
    }
    if (this.jdField_a_of_type_Asar != null) {
      this.jdField_a_of_type_Asar.d();
    }
    if (this.jdField_a_of_type_Aaxt != null) {
      this.jdField_a_of_type_Aaxt.c();
    }
    if (this.jdField_a_of_type_Ahqy != null) {
      this.jdField_a_of_type_Ahqy.a(a());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_Ahkd.a(1);
    boolean bool2 = this.jdField_a_of_type_Ahkd.a(9);
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
    switch (asel.a().a())
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
    bbkj.a(null, "Recent_OnCreate");
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a(a());
    this.jdField_a_of_type_Aaxq = new aaxq(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bbdc(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_MqqOsMqqHandler = new bbdc(ThreadManager.getRecentThreadLooper(), this);
    this.jdField_a_of_type_Ahoo = new ahoo(this.jdField_a_of_type_MqqOsMqqHandler, a());
    this.jdField_a_of_type_Aaxt = new aaxt(this);
    K();
    J();
    a(false);
    this.jdField_a_of_type_Ahmh = new ahmh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bbkj.a("Recent_OnCreate", null);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aaxt != null) {
      this.jdField_a_of_type_Aaxt.a(paramBoolean);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Thv != null) {
        this.jdField_a_of_type_Thv.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initLater(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
    }
  }
  
  public void h()
  {
    QLog.d("Q.recent", 2, "onResume...");
    ApngImage.pauseByTag(2);
    super.h();
    this.jdField_a_of_type_Auqk.g();
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
        localObject2 = (alww)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((alww)localObject2).e();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1053);
    this.J = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (AppSetting.jdField_i_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
    }
    ahpj.a().b();
    this.jdField_f_of_type_Boolean = false;
    if ((!this.C) && (!this.D) && (ahon.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      if (System.currentTimeMillis() - this.jdField_h_of_type_Long > 5000L)
      {
        localObject1 = this.jdField_a_of_type_Ahmv.b();
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
      if (this.jdField_a_of_type_Ahoi != null) {
        this.jdField_a_of_type_Ahoi.l();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = false;
      onh.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_b_of_type_Aqyf != null) {
        this.jdField_b_of_type_Aqyf.d();
      }
      if (this.jdField_c_of_type_Aqyf != null) {
        this.jdField_c_of_type_Aqyf.d();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
      axqv.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Thv != null) {
        this.jdField_a_of_type_Thv.m();
      }
      osx.k();
      akwu.a();
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
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "notifyCallTabChanged, changed=" + paramBoolean);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.jdField_h_of_type_Boolean) || (a() == null) || (a().isFinishing())) {
      return true;
    }
    bfwu.a("conv.handleMessage");
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
        bfwu.a();
        return true;
        if (!a(paramMessage)) {
          return true;
        }
        ((ajyd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).b();
        asfd.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        G();
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (aiiz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          aiiz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        this.jdField_a_of_type_Ahmh.a((List)localObject1);
        paramMessage = ahnl.a().jdField_a_of_type_JavaUtilList;
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject4 = a();
        if (localObject1 != null)
        {
          i1 = ((List)localObject1).size();
          ahmg.a((List)localObject1, (QQAppInterface)localObject3, (Context)localObject4, paramMessage, i1);
        }
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_Ahmh);
          b(paramMessage);
          u();
          localObject1 = new ArrayList(paramMessage);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, localObject1).sendToTarget();
          a(paramMessage);
          if (this.jdField_a_of_type_Ahkd != null) {}
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          localObject1 = new HashMap();
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          axrn.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject1, "");
          localObject1 = (stc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
          ((stc)localObject1).b(3, ((stc)localObject1).a(paramMessage));
          bbkj.a("Conversation_Refresh_global", System.currentTimeMillis() - l1);
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
        if (aiiz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          aiiz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        G();
        localObject3 = ahnl.a().jdField_a_of_type_JavaUtilList;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
        this.jdField_a_of_type_Ahmh.a((List)localObject4);
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
          str = ahnl.a(localRecentUser.uin, localRecentUser.getType());
          localObject2 = ahnl.a().a(str);
          if (localObject2 != null) {
            break label766;
          }
          localObject2 = ahmg.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          paramMessage = (Message)localObject2;
          if (localObject2 != null)
          {
            ahnl.a().a((RecentBaseData)localObject2, str);
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
            if (!this.jdField_b_of_type_JavaUtilList.contains(ahnl.a(localRecentUser.uin, -2147483648))) {}
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
          Collections.sort((List)localObject3, this.jdField_a_of_type_Ahmh);
          b((List)localObject3);
          u();
          paramMessage = new ArrayList((Collection)localObject3);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
          a((List)localObject3);
          if (this.jdField_a_of_type_Ahkd != null) {
            this.jdField_a_of_type_Ahkd.i();
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
          axrn.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - l1, ((List)localObject3).size(), paramMessage, "");
          bbkj.a("Conversation_Refresh_part", System.currentTimeMillis() - l1);
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
        paramMessage = ahnl.a().jdField_a_of_type_JavaUtilList;
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
            localObject4 = ahnl.a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
            if ((this.jdField_b_of_type_JavaUtilList.contains(localObject4)) || (this.jdField_b_of_type_JavaUtilList.contains(ahnl.a(((RecentBaseData)localObject3).a(), -2147483648))))
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
        axrn.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject2, "");
        bbkj.a("Conversation_Refresh_items", System.currentTimeMillis() - l1);
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
      asfd.a().k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = saz.a();
      if (paramMessage != null) {
        paramMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramMessage = sdc.a();
      if (paramMessage != null) {
        paramMessage.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      bame.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = (bamx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
      if (paramMessage != null) {
        paramMessage.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      for (;;)
      {
        paramMessage = (nqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
        if (paramMessage != null) {
          paramMessage.e();
        }
        paramMessage = (arfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
        if (paramMessage != null) {
          paramMessage.a(true);
        }
        paramMessage = (ajyd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255);
        if (paramMessage != null) {
          paramMessage.a();
        }
        akng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
        paramMessage = (aojc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(292);
        if (paramMessage != null) {
          paramMessage.c();
        }
        paramMessage = (stc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
        paramMessage.a(1, paramMessage.a(this.jdField_a_of_type_JavaUtilList));
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
        }
      }
      j(true);
      break;
      a(new Conversation.25(this));
      break;
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1044, 0, 0, null).sendToTarget();
      break;
      paramMessage = (stc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
      paramMessage.a(2, paramMessage.a(ahnl.a().jdField_a_of_type_JavaUtilList));
      break;
      if (this.jdField_a_of_type_Ahqy == null) {
        break;
      }
      this.jdField_a_of_type_Ahqy.b();
      break;
      label2074:
      l1 = 0L;
    }
  }
  
  public void i()
  {
    super.i();
    if ((this.jdField_a_of_type_Ahoi != null) && (this.jdField_a_of_type_Ahoi.a())) {
      this.jdField_a_of_type_Ahoi.b();
    }
    if (this.jdField_a_of_type_Aqyf != null) {
      this.jdField_a_of_type_Aqyf.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        alww localalww = (alww)localIterator.next();
        if (localalww != null) {
          localalww.k();
        }
      }
    }
    if (this.jdField_a_of_type_Asar != null) {
      this.jdField_a_of_type_Asar.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onStop();
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onDestroy");
    }
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ahoo != null) {
      this.jdField_a_of_type_Ahoo.a();
    }
    if (this.jdField_a_of_type_Bfpc != null)
    {
      this.jdField_a_of_type_Bfpc.a(null);
      this.jdField_a_of_type_Bfpc = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a(null);
    }
    this.p = false;
    ahpj.a().a();
    P();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
    if (this.jdField_a_of_type_Aaxq != null) {
      this.jdField_a_of_type_Aaxq.a();
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Afpa != null) {
      this.jdField_a_of_type_Afpa.b();
    }
    if (this.jdField_a_of_type_Ahmv != null) {
      this.jdField_a_of_type_Ahmv.b();
    }
    if (this.jdField_a_of_type_Thv != null) {
      this.jdField_a_of_type_Thv.c();
    }
    if (this.jdField_a_of_type_Ahkd != null) {
      this.jdField_a_of_type_Ahkd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        ((aktf)localObject).e();
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
    asfd.a();
    asff.a();
    sdc.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        alww localalww = (alww)((Iterator)localObject).next();
        if (localalww != null) {
          localalww.f();
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Asar != null)
    {
      this.jdField_a_of_type_Asar.f();
      this.jdField_a_of_type_Asar = null;
    }
    super.j();
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Ahmv == null)
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
      boolean bool1 = this.jdField_a_of_type_Ahkd.a(1);
      boolean bool2 = this.jdField_a_of_type_Ahkd.a(9);
      if ((bool1) || (bool2)) {
        c(800L);
      }
    }
    else
    {
      return;
    }
    if (bhvy.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      osx.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
    c(60000L);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      this.jdField_a_of_type_Ahoi.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getWidth() - a().getDimensionPixelSize(2131298614) - a().getDimensionPixelSize(2131298615), a().getDimensionPixelSize(2131298616));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity instanceof MainFragment))) {
        ((MainFragment)this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).n();
      }
      if ((ajac.c() <= 0) || (ajac.b() <= 0)) {
        break label322;
      }
    }
    label322:
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = false;
      }
      for (int i2 = 1;; i2 = 0)
      {
        VipUtils.a(ajac.a(), "cmshow", "Apollo", "plusentrance", 0, 0, new String[] { "" + i1, "" + i2 });
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
        vei.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
        W();
        xop.e();
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
      baxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if (this.jdField_a_of_type_Thv != null) {
        this.jdField_a_of_type_Thv.b(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1)) {
        break label433;
      }
      if (this.jdField_a_of_type_Ahmv == null) {
        break label254;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i4 = this.jdField_a_of_type_Ahmv.getCount();
      this.jdField_b_of_type_Int = Math.max(i1, -1);
      if ((i1 < 0) || (i1 >= i4) || (i1 > i2 - i3)) {
        break label242;
      }
      localObject = this.jdField_a_of_type_Ahmv.getItem(i1);
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
    this.jdField_a_of_type_Ahmv.a(false);
    bbbn.a(false);
    label254:
    if (paramInt == 0)
    {
      T();
      zzz.a().a("list_conv", false);
      ThreadRegulator.a().b(2);
      a(paramAbsListView);
      ardf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahmv, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      k(false);
      R();
      X();
      v();
      if (this.jdField_a_of_type_Ahgq != null) {
        this.jdField_a_of_type_Ahgq.b();
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
      if (this.jdField_a_of_type_Ahkd != null) {
        this.jdField_a_of_type_Ahkd.b(this.G);
      }
      oti.a(paramAbsListView, paramInt);
      akwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAbsListView, paramInt);
      return;
      label433:
      if (this.jdField_a_of_type_Ahmv == null) {
        break;
      }
      this.jdField_a_of_type_Ahmv.a(true);
      bbbn.a(true);
      break;
      zzz.a().a("list_conv");
      ThreadRegulator.a().a(2);
      if (this.jdField_a_of_type_Ahgq != null) {
        this.jdField_a_of_type_Ahgq.c();
      }
    }
  }
  
  public void p()
  {
    this.jdField_f_of_type_Boolean = true;
    if ((!this.jdField_j_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      C();
      bbkj.a("Recent_Start", null);
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559459, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        if (this.jdField_a_of_type_Ahoi == null)
        {
          this.jdField_a_of_type_Ahoi = new ahoi(localBaseActivity);
          this.jdField_a_of_type_Ahoi.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new aawa(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_Bbzu = ((bbzu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76));
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
        ((HashMap)localObject2).put("device_mode", bbdh.d());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        axrn localaxrn = axrn.a(BaseApplicationImpl.getContext());
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label378;
        }
        localaxrn.a(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
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
      this.jdField_a_of_type_Ahoi = null;
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
        if (this.jdField_a_of_type_Aaxt != null) {
          this.jdField_a_of_type_Aaxt.a();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aawb(this));
        this.jdField_a_of_type_Ahqy = new ahqy(this, this.jdField_a_of_type_AndroidViewViewGroup);
        long l1 = System.currentTimeMillis();
        if (amtb.e())
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559459, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
          }
          M();
          long l2 = System.currentTimeMillis();
          QLog.d("AutoMonitor", 1, "init Mini App, cost=" + (l2 - l1));
        }
        ((ahfx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342)).a(this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface);
        if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initUI(a());
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
        if ((this.jdField_a_of_type_Ahkd != null) && (this.jdField_e_of_type_Boolean)) {
          this.jdField_a_of_type_Ahkd.j();
        }
        if (this.jdField_a_of_type_Ahkd != null) {
          this.jdField_a_of_type_Ahkd.a(false);
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
            this.jdField_a_of_type_JavaLangString = akxb.a().a();
            if (this.jdField_a_of_type_JavaLangString == null)
            {
              this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367103));
              GLSurfaceView localGLSurfaceView = new GLSurfaceView(a());
              localGLSurfaceView.setRenderer(new aawc(this));
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
      if (((nqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).b())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ahmv != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
            if (!(this.jdField_a_of_type_Ahmv.getItem(i1) instanceof RecentItemEcShopAssitant)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!nnu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (this.jdField_b_of_type_Aqyf == null)) {
            break label124;
          }
          this.jdField_b_of_type_Aqyf.a();
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
          int i2 = avet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
          if ((this.jdField_f_of_type_Boolean) && (njl.a((MessageRecord)localObject2)))
          {
            a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
            k(false);
          }
          if ((this.jdField_f_of_type_Boolean) && (ardh.a((MessageRecord)localObject2))) {
            ardf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahmv, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          }
          int i1 = 10;
          Object localObject1 = Long.valueOf(0L);
          if ((((MessageRecord)localObject2).isSendFromLocal()) && ((!this.jdField_f_of_type_Boolean) || (TextUtils.equals(((MessageRecord)localObject2).frienduin, ajsd.az)) || (TextUtils.equals(((MessageRecord)localObject2).frienduin, ajsd.aA))))
          {
            i1 = 9;
            localObject1 = ahnl.a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
            if (((MessageRecord)localObject2).isSend()) {
              bbgi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
            }
            a(i2, i1, localObject1);
            this.H = true;
          }
          for (;;)
          {
            if (!(paramObservable instanceof avet)) {
              break label613;
            }
            if ((paramObject instanceof Boolean))
            {
              boolean bool = ((Boolean)paramObject).booleanValue();
              if ((!this.jdField_e_of_type_Boolean) && (bool))
              {
                paramObservable = null;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                  paramObservable = (avet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
                }
                if (paramObservable != null) {
                  paramObservable.a(false);
                }
              }
            }
            if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Ahkd == null)) {
              break;
            }
            this.jdField_a_of_type_Ahkd.j();
            return;
            if ((!this.jdField_f_of_type_Boolean) && (ahpd.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1024))) {
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
              if ((localObject1.length == 2) && (ajsd.x.equals(localObject1[0])) && (localObject1[1] != null))
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
        } while ((!(paramObservable instanceof avps)) || (!(paramObject instanceof BusinessInfoCheckUpdate.AppInfo)));
        paramObject = (BusinessInfoCheckUpdate.AppInfo)paramObject;
        paramObservable = (avps)paramObservable;
        paramObservable = avpw.a(paramObject);
      } while ((paramObservable == null) || (paramObservable.size() <= 0));
      paramObservable = (avpw)paramObservable.get(0);
    } while ((paramObservable.jdField_a_of_type_Int < 1) || (paramObservable.jdField_a_of_type_Int > 4));
    avpw.b(this);
  }
  
  void v()
  {
    if ((this.p) && (((akaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).b("sp_mayknow_ml_s_a_vl")) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.isShown()) && (!this.jdField_a_of_type_Ahmv.isEmpty()))
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
          if (i3 < this.jdField_a_of_type_Ahmv.getCount())
          {
            i4 = i1;
            if (this.jdField_a_of_type_Ahmv.getItem(i3) != null)
            {
              Object localObject = this.jdField_a_of_type_Ahmv.getItem(i3);
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
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, 1, 2130838515, "-conversation-");
  }
  
  public void x()
  {
    Object localObject = a();
    if (this.jdField_e_of_type_Boolean)
    {
      if (localObject == null) {}
      while (this.jdField_a_of_type_Ahqy == null) {
        return;
      }
      boolean bool = this.jdField_a_of_type_Ahqy.a((ahmv)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "moveToCaredItemCyclic: invoked.  canFindUnreadItem: " + bool + " currentCaredType:" + this.jdField_f_of_type_Int + " currentUnreadCaredItemIndex: " + this.jdField_g_of_type_Int);
      }
      int i1 = (int)(a().getResources().getDimension(2131298607) + a().getResources().getDimension(2131298624) / 2.0F);
      int i2 = this.jdField_g_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      if (this.jdField_g_of_type_Int == 0) {
        i1 = 0;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "moveToCaredItemCyclic: invoked. selection1 ", " position: ", Integer.valueOf(i2) });
        }
        this.jdField_a_of_type_Ahqy.c();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(i2, i1);
        localObject = new Conversation.53(this, i2);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed((Runnable)localObject, 250L);
      }
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1E3", "0X800A1E3", 0, 0, "", "", "", "");
  }
  
  void y()
  {
    if (this.jdField_a_of_type_Bfpc == null)
    {
      this.jdField_a_of_type_Bfpc = bfpc.a(a());
      this.jdField_a_of_type_Bfpc.b(2131691252);
      this.jdField_a_of_type_Bfpc.c(2131690596);
      this.jdField_a_of_type_Bfpc.a(new aaxe(this));
    }
    this.jdField_a_of_type_Bfpc.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation
 * JD-Core Version:    0.7.0.1
 */