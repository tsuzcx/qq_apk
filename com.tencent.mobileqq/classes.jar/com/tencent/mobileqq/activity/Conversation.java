package com.tencent.mobileqq.activity;

import abol;
import abqw;
import acms;
import acmu;
import acmv;
import acmw;
import acmx;
import acmy;
import acmz;
import acna;
import acnb;
import acnc;
import acnd;
import acne;
import acnf;
import acng;
import acnh;
import acni;
import acnj;
import acnk;
import acnl;
import acnm;
import acnn;
import acno;
import acnp;
import acnq;
import acnr;
import acns;
import acnt;
import acnu;
import acnv;
import acnw;
import acnz;
import acob;
import acoc;
import acod;
import acoe;
import acof;
import acog;
import acoh;
import acoi;
import acoj;
import acok;
import acol;
import acoo;
import acop;
import acos;
import adov;
import aegk;
import aely;
import ahmr;
import aiah;
import ajbm;
import ajdp;
import ajdq;
import ajdx;
import ajee;
import ajel;
import ajeu;
import ajfa;
import ajfr;
import ajfw;
import ajfx;
import ajgk;
import ajgl;
import ajgm;
import ajgs;
import ajih;
import akaj;
import akro;
import aljq;
import alkk;
import alkl;
import allb;
import allq;
import alls;
import almg;
import almw;
import alny;
import alon;
import alox;
import aloz;
import alpo;
import alpr;
import alqf;
import alro;
import alsi;
import alvt;
import alxa;
import alxd;
import alxz;
import alyo;
import alyr;
import amab;
import amaj;
import amev;
import amjk;
import amng;
import amnk;
import amnr;
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
import anku;
import annx;
import aokd;
import apxc;
import aqbb;
import aqnl;
import aqse;
import ardf;
import asot;
import astr;
import astt;
import astv;
import asvu;
import atrr;
import atvl;
import atwd;
import atwf;
import aupu;
import avqr;
import awhw;
import awwg;
import axho;
import axhu;
import azib;
import azmg;
import azmj;
import azmo;
import azmz;
import azqu;
import azwl;
import azwu;
import azwv;
import azyl;
import badt;
import bajd;
import bamw;
import banc;
import bang;
import bank;
import baom;
import bapa;
import batw;
import bckr;
import bclk;
import bclo;
import bclr;
import bcwi;
import bcze;
import bdah;
import bdal;
import bdbt;
import bdbw;
import bdcb;
import bdcd;
import bdee;
import bdel;
import bdfe;
import bdir;
import bdiv;
import bdjd;
import bdje;
import bdyu;
import bdyv;
import bepp;
import bhoe;
import bhok;
import bhpd;
import bhpo;
import bhpy;
import bhuy;
import bhwu;
import bhxr;
import bioj;
import bjxj;
import bjzr;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.mobileqq.widget.QQToast;
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
import lpr;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import mww;
import nlo;
import nlx;
import nmh;
import nrc;
import nrt;
import ntw;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import oxp;
import oya;
import ssp;
import suv;
import swy;
import uhn;
import uhu;
import uuc;
import uuq;
import uur;
import uwn;
import wta;
import zdi;

public class Conversation
  extends alny
  implements aegk, ajdx, ajel, aljq, alon, Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, bhpo, bhuy, bhwu, Observer
{
  public static long b;
  private static long jdField_i_of_type_Long;
  public static boolean r = true;
  private boolean A = true;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I;
  private boolean J;
  private boolean K;
  int jdField_a_of_type_Int = 0;
  public long a;
  private acoj jdField_a_of_type_Acoj;
  acok jdField_a_of_type_Acok = new acok(this);
  private acoo jdField_a_of_type_Acoo;
  acop jdField_a_of_type_Acop = null;
  public acos a;
  adov jdField_a_of_type_Adov = new acnr(this);
  ahmr jdField_a_of_type_Ahmr;
  public ajbm a;
  private ajdq jdField_a_of_type_Ajdq;
  public ajee a;
  public ajfr a;
  private ajfx jdField_a_of_type_Ajfx;
  ajgl jdField_a_of_type_Ajgl;
  public ajih a;
  protected alkl a;
  allb jdField_a_of_type_Allb = new acnh(this);
  private final alls jdField_a_of_type_Alls = new acne(this);
  private final almg jdField_a_of_type_Almg = new acnl(this);
  almw jdField_a_of_type_Almw = new acnj(this);
  private final alox jdField_a_of_type_Alox = new acnb(this);
  private alqf jdField_a_of_type_Alqf = new acnv(this);
  private final alsi jdField_a_of_type_Alsi = new acng(this);
  private alxa jdField_a_of_type_Alxa = new acol(this);
  private alxd jdField_a_of_type_Alxd = new acnq(this);
  private alxz jdField_a_of_type_Alxz = new acnw(this);
  alyo jdField_a_of_type_Alyo = new acni(this);
  private final alyr jdField_a_of_type_Alyr = new acnm(this);
  private final amab jdField_a_of_type_Amab = new acnc(this);
  amaj jdField_a_of_type_Amaj = new acnf(this);
  private amng jdField_a_of_type_Amng = new acoi(this);
  public Dialog a;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new acns(this);
  protected Handler.Callback a;
  public GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public ImageView a;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private apxc jdField_a_of_type_Apxc = new acof(this);
  private aqnl jdField_a_of_type_Aqnl;
  private asot jdField_a_of_type_Asot = new asot("tool_adMessage", "com.tencent.mobileqq:tool");
  public atrr a;
  private final avqr jdField_a_of_type_Avqr = new acno(this);
  public awhw a;
  private azwv jdField_a_of_type_Azwv = new acog(this);
  bdyv jdField_a_of_type_Bdyv = null;
  private bepp jdField_a_of_type_Bepp;
  public bhpy a;
  private bjzr jdField_a_of_type_Bjzr;
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
  public ArrayList<annx> a;
  public List<RecentBaseData> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final lpr jdField_a_of_type_Lpr = new acnn(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new acob(this);
  public MqqHandler a;
  private final uhn jdField_a_of_type_Uhn = new acnp(this);
  public uwn a;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  Dialog jdField_b_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new acnt(this);
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  private asot jdField_b_of_type_Asot = new asot("tool_shop", "com.tencent.mobileqq:tool");
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  protected Runnable b;
  public String b;
  final List<String> jdField_b_of_type_JavaUtilList = new ArrayList(40);
  public MqqHandler b;
  public boolean b;
  int jdField_c_of_type_Int;
  public long c;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new acnu(this);
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private asot jdField_c_of_type_Asot = new asot("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private Runnable jdField_c_of_type_JavaLangRunnable;
  MqqHandler jdField_c_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this.jdField_a_of_type_Acok);
  public boolean c;
  public int d;
  long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private Runnable jdField_d_of_type_JavaLangRunnable = new Conversation.4(this);
  public boolean d;
  int jdField_e_of_type_Int = 3;
  public long e;
  private View jdField_e_of_type_AndroidViewView;
  private Runnable jdField_e_of_type_JavaLangRunnable = new Conversation.20(this);
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
  boolean q = false;
  public volatile boolean s;
  public boolean t;
  boolean u = false;
  boolean v = false;
  public boolean w;
  private boolean y;
  private boolean z;
  
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
    this.jdField_a_of_type_Acos = null;
    this.jdField_f_of_type_Int = 17;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new acms(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new Conversation.25(this);
    this.jdField_a_of_type_Alkl = new acnd(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(BaseApplicationImpl.getContext(), new acod(this));
    this.jdField_b_of_type_JavaLangRunnable = new Conversation.57(this);
  }
  
  private void D()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Ajee.c();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof ARMapHongBaoListView)))
    {
      if (this.jdField_a_of_type_Bjzr == null) {
        this.jdField_a_of_type_Bjzr = new bjzr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, (ARMapHongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      }
      this.jdField_a_of_type_Bjzr.a();
    }
  }
  
  private void F()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 50L);
  }
  
  private void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "scrollToTopIfNeccessary: " + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() >= 0)
    {
      this.J = true;
      this.jdField_j_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.smoothScrollToPosition(0);
    }
  }
  
  private void H()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ajee != null)) {}
    }
    else
    {
      return;
    }
    int i3 = this.jdField_a_of_type_Ajee.getCount();
    int i1 = this.jdField_b_of_type_Int + 1;
    label96:
    int i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Object localObject = this.jdField_a_of_type_Ajee.getItem(i1);
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
        if (r) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.smoothScrollToPosition(this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount());
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "scrollToNextUnreadItem|findUnreadItem:" + bool + ",mCurrentUnreadItem" + this.jdField_b_of_type_Int);
        return;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount(), 0);
        continue;
        if (r) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setIsNeedScrollPositionTop(r);
        }
        G();
        this.jdField_b_of_type_Int = -1;
      }
      break;
      i2 = 0;
      break label124;
      label276:
      break label96;
    }
  }
  
  private void I()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.jdField_f_of_type_Long);
    if ((this.jdField_a_of_type_Ajee != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (ajgs.a().a(str)) {
        this.jdField_f_of_type_Long = l1;
      }
    }
  }
  
  private void J()
  {
    if (atvl.a().b()) {
      atvl.a().a(3);
    }
  }
  
  private void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMWrapper", 2, "Conversation showUpgradeDetailInfoIfNeccessary mInitTimUpgradeInfo : " + this.G);
    }
    if ((!this.x) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a()))
    {
      if (this.x)
      {
        if ((!allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.G))
        {
          a(1134047, 0L, true);
          this.G = true;
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
      allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i1 = allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      allq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1 + 1);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void L()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
  }
  
  private void M()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131364773));
    this.jdField_a_of_type_Acoj = new acoj(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_Acoj, false);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.p = false;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131375981));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377976));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364832));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376977));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368659));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720570);
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
      azib.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369554);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375340));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDescendantInvalidatedFlags(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(a().getDrawable(2130839219));
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
              localObject2 = ((AppActivity)localObject3).getLayoutInflater().inflate(2131562565, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
            }
          }
          if (localObject2 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject2, 0);
            this.jdField_a_of_type_Ahmr = new ahmr(a(), 1, (View)localObject2);
            this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
          }
          this.jdField_a_of_type_Ajbm = new ajbm(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          localObject1 = a();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
          if (!ajeu.a().jdField_a_of_type_Boolean)
          {
            bool = true;
            this.jdField_a_of_type_Ajee = new ajee((Context)localObject1, (QQAppInterface)localObject2, (XListView)localObject3, this, 0, bool);
            this.jdField_a_of_type_Ajee.b(true);
            this.jdField_a_of_type_Ajee.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Ajee);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
            this.jdField_a_of_type_Ajee.a(this);
            this.jdField_c_of_type_AndroidViewView = new View(a());
            localObject1 = new AbsListView.LayoutParams(-1, 0);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView, null, false);
            if ((TextUtils.isEmpty(ajeu.a().jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(ajeu.a().jdField_a_of_type_JavaLangString))) {
              break label812;
            }
            localObject1 = new ArrayList(16);
            QLog.d("Q.recent", 1, "ignore PreLoadList");
            this.jdField_a_of_type_Ajee.a((List)localObject1);
            this.jdField_a_of_type_Ajee.a(0);
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.q();
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
            this.jdField_a_of_type_Awhw = new awhw(this, this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_a_of_type_Atrr = new atrr(this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364839));
            IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
            return;
            a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
            a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849463);
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166898));
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
            label812:
            List localList = ajeu.a().jdField_b_of_type_JavaUtilList;
            continue;
            localList = null;
          }
        }
      }
    }
  }
  
  private void N()
  {
    Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if ((localManager instanceof axho))
    {
      int i1 = ((axho)localManager).a("104000.104001", 100);
      if (i1 > 0) {
        a(8, aljq.aB, 7230);
      }
      QLog.d("Q.recent", 2, "uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "getSubscribeAccountRedDotNum  redNumByPath:" + i1);
    }
  }
  
  private void O()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "initMiniAppEntryLayout.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface == null)
    {
      if (aokd.g()) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface = new MiniAppDesktop(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface = new QQMessagePageMiniAppEntryManager(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
  }
  
  private void P()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    W();
    a(1010, 0L, false);
    a(1023, 0L, false);
    a(1027, 0L, false);
    K();
    axhu.a(this);
    if (!this.jdField_e_of_type_Boolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2);
    }
    Q();
    ((azwl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(361)).a(a());
  }
  
  private void Q()
  {
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void R()
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alls);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amaj);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Allb);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Almw);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alyr);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Almg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alqf);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Uhn);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Avqr);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alxd);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alxz);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Apxc);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alyo);
        azwu.b(this.jdField_a_of_type_Azwv);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Lpr);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
        }
        if (this.jdField_a_of_type_Aqnl != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Adov);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alxa);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amng);
        localObject1 = (awwg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject1 != null) {
          ((awwg)localObject1).deleteObserver(this);
        }
        localObject1 = (axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (localObject1 != null) {
          ((axho)localObject1).deleteObserver(this);
        }
        if (this.jdField_a_of_type_Atrr != null) {
          this.jdField_a_of_type_Atrr.c();
        }
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(17);
      try
      {
        localObject1 = a();
        if (this.jdField_a_of_type_Acoo != null)
        {
          bamw.b(this.jdField_a_of_type_Acoo);
          this.jdField_a_of_type_Acoo.a();
          this.jdField_a_of_type_Acoo = null;
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
  
  private void S()
  {
    if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(true))) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidViewView == null);
      localObject = this.jdField_a_of_type_Ajee.getItem(0);
    } while (!(localObject instanceof RecentUserBaseData));
    Object localObject = (RecentUserBaseData)localObject;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    boolean bool;
    label98:
    int i1;
    if ((((RecentUserBaseData)localObject).mUser.getType() == 1) && (!aupu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUserBaseData)localObject).mUser)))
    {
      bool = localTroopManager.b(((RecentUserBaseData)localObject).a());
      if (this.C == bool) {
        break label217;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent", 4, "setLocalSearchBarByShowUpMask:mShowUPMask = " + this.C + ", dstMsg = " + bool);
      }
      if (!bool) {
        break label219;
      }
      i1 = 2130849661;
      label160:
      if (!bool) {
        break label226;
      }
    }
    label217:
    label219:
    label226:
    for (int i2 = 2130849672;; i2 = 2130849671)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(i1);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131365849).setBackgroundResource(i2);
      this.C = bool;
      return;
      if (((RecentUserBaseData)localObject).mUser.showUpTime > 0L)
      {
        bool = true;
        break label98;
      }
      bool = false;
      break label98;
      break;
      i1 = 2130849660;
      break label160;
    }
  }
  
  private void T()
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
      if ((badt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (badt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ajee != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          label73:
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition())
          {
            Object localObject = this.jdField_a_of_type_Ajee.getItem(i1);
            if ((!(localObject instanceof RecentItemTencentDocsAssistantData)) || (((RecentItemTencentDocsAssistantData)localObject).b() <= 0)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!nrc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            break label170;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess call");
          }
          if (this.jdField_c_of_type_Asot == null) {
            break;
          }
          this.jdField_c_of_type_Asot.a();
          return;
          i1 += 1;
          break label73;
        }
      }
    }
  }
  
  private void U()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "updateMayKnowOrTroopRecommend");
    }
    alro localalro = (alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if (localalro.c())
    {
      localalro.c();
      return;
    }
    this.q = localalro.d();
    ArrayList localArrayList = localalro.c();
    if ((this.q) && (localArrayList != null) && (localArrayList.size() > 0))
    {
      localalro.d();
      return;
    }
    localalro.e();
    this.q = false;
  }
  
  private void V()
  {
    this.jdField_a_of_type_Aqnl = new acnk(this);
  }
  
  private void W()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentDataListManager", 2, "preloadNextScreenUserFaceIcon:" + this.A);
    }
    int i1;
    int i2;
    int i3;
    if (this.A)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() + 1;
      i2 = 1;
      i3 = 0;
      if ((i2 != 0) && (i3 < 10) && (i1 >= 0)) {
        break label103;
      }
    }
    label103:
    while (i1 >= this.jdField_a_of_type_Ajee.getCount())
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
      i2 = 0;
      break;
    }
    Object localObject = this.jdField_a_of_type_Ajee.getItem(i1);
    if ((localObject != null) && ((localObject instanceof RecentBaseData)))
    {
      localObject = (RecentBaseData)localObject;
      if (!(localObject instanceof RecentItemImaxADData)) {}
    }
    for (;;)
    {
      i3 += 1;
      break;
      this.jdField_a_of_type_Ajee.a().a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a(), false);
      i1 += i2;
    }
  }
  
  private void X()
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfAjds[0] = new acnz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfAjds[1] = new aiah();
  }
  
  private void Y()
  {
    if ((this.x) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      ThreadManager.post(new Conversation.50(this), 5, null, true);
    }
  }
  
  private void Z()
  {
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_Ajfr != null))
    {
      this.jdField_a_of_type_Ajfr.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1048, 0, 0).sendToTarget();
    }
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync from=", Integer.valueOf(paramInt), " isInRealActionLoginB=", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()), " isLoadUIAfterMsgSync=", Boolean.valueOf(this.m) });
        if (1 == paramInt)
        {
          this.s = true;
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
          a(1072, 500L, true);
          if (this.jdField_a_of_type_Acos != null) {
            this.jdField_a_of_type_Acos.f();
          }
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
        this.jdField_a_of_type_Ajbm.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync cost=", Long.valueOf(System.currentTimeMillis() - l1), " all done!" });
        } else {
          QLog.d("Q.recent", 2, "doAfterMsgSync all done!");
        }
      }
      finally {}
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
        acmu localacmu = new acmu(this);
        acmv localacmv = new acmv(this, localUpgradeTIMWrapper);
        if (TextUtils.isEmpty(localUpgradeTIMWrapper.d))
        {
          paramMessage = alpo.a(2131702972);
          if (!TextUtils.isEmpty(localUpgradeTIMWrapper.e)) {
            break label323;
          }
          str = alpo.a(2131702982);
          this.jdField_c_of_type_AndroidAppDialog = bdcd.a(a(), localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString, localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString, paramMessage, str, null, localacmv, localacmu);
          this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new acmw(this));
          if ((!this.x) || (this.jdField_c_of_type_AndroidAppDialog.isShowing()) || ((this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.isShowing())) || (allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            continue;
          }
          this.jdField_c_of_type_AndroidAppDialog.show();
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
          allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if ((paramAbsListView != null) && (this.jdField_a_of_type_Ajee != null))
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
          localObject1 = this.jdField_a_of_type_Ajee.getItem(i2);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemPublicAccountADFolderData))) {
            break label226;
          }
          localObject1 = (RecentItemPublicAccountADFolderData)localObject1;
          if (!astv.a(paramAbsListView.getChildAt(i2 - i1))) {
            break label226;
          }
          localObject1 = nlx.a().a(((RecentItemPublicAccountADFolderData)localObject1).mUser.uin);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Message localMessage = Message.obtain();
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("key_app", new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        ((HashMap)localObject2).put("key_adapter", new WeakReference(this.jdField_a_of_type_Ajee));
        ((HashMap)localObject2).put("key_listview", new WeakReference(paramAbsListView));
        localMessage.obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_ad_id", ((nlo)localObject1).c);
        localMessage.setData((Bundle)localObject2);
        localMessage.what = 1;
        astr.a().a(localMessage);
        i2 += 1;
      }
    }
  }
  
  public static void a(MqqHandler paramMqqHandler, Context paramContext)
  {
    paramMqqHandler.removeMessages(1134065);
    if (FriendsStatusUtil.a(paramContext))
    {
      azmj.b(null, "CliOper", "", "", "0X8009EB9", "0X8009EB9", 0, 1, "", "", "", "");
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
  
  private void aa()
  {
    if (!this.x) {
      break label7;
    }
    label7:
    while (!this.jdField_a_of_type_Ajbm.b(21)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getChildCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() >= 0)) {}
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 == 0)
      {
        this.K = false;
        return;
      }
      if (this.K) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "checkPushBannerReport");
      }
      this.K = true;
      ThreadManager.post(new Conversation.51(this, this.jdField_a_of_type_Ajbm.a(21, 2131362155)), 5, null, false);
      return;
    }
  }
  
  private void ab()
  {
    try
    {
      if (this.jdField_a_of_type_Bepp == null)
      {
        this.jdField_a_of_type_Bepp = new bepp(a(), a().getTitleBarHeight());
        this.jdField_a_of_type_Bepp.c(2131695075);
        this.jdField_a_of_type_Bepp.c(false);
        this.jdField_a_of_type_Bepp.setOnDismissListener(new acoe(this));
      }
      this.jdField_a_of_type_Bepp.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ac()
  {
    try
    {
      if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 800L);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
      if (allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) >= 5)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog = new UpgradeTipsDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.setOnDismissListener(new acmx(this));
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
          if (((((RecentUserBaseData)localObject).a() == 1) && (!aupu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUserBaseData)localObject).mUser)) && (localTroopManager.b(((RecentUserBaseData)localObject).a()))) || (((RecentUserBaseData)localObject).mUser.showUpTime != 0L)) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(((RecentUserBaseData)localObject).a()).append("-").append(bdje.e(((RecentUserBaseData)localObject).a())).append("-").append(i1).append(" , ");
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
    if (this.n != paramBoolean)
    {
      if (!paramBoolean) {
        break label149;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null)
      {
        QLog.e("Q.recent", 1, "Error State that mChatTopReflesh is null! ui Not Init! will updateMsgTabStoryNodeView(true) later.");
        this.t = true;
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_Uwn == null) {
      this.jdField_a_of_type_Uwn = new uwn(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, (BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367709));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)) {
      this.jdField_a_of_type_Uwn.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
    }
    this.jdField_a_of_type_Uwn.jdField_f_of_type_Boolean = this.x;
    this.jdField_a_of_type_Uwn.b();
    for (this.t = false;; this.t = false)
    {
      this.n = paramBoolean;
      return;
      label149:
      if (this.jdField_a_of_type_Uwn != null) {
        this.jdField_a_of_type_Uwn.c();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alkl, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alls, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alsi, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amaj, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Allb, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Almw, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alyr, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Avqr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Almg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alqf);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Uhn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alxd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Adov);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Apxc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alyo);
    azwu.a(this.jdField_a_of_type_Azwv);
    Object localObject2 = (axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject2 != null) {
      ((axho)localObject2).addObserver(this);
    }
    if (this.jdField_a_of_type_Aqnl == null) {
      V();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqnl);
    if (this.jdField_a_of_type_Acoo == null) {
      this.jdField_a_of_type_Acoo = new acoo(this);
    }
    this.jdField_a_of_type_Acoo.addFilter(new Class[] { banc.class, bang.class, C2CPttDownloadProcessor.class, bank.class, bapa.class, GroupPttDownloadProcessor.class, baom.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Acoo);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
        localObject2 = (awwg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject2 != null) {
          ((awwg)localObject2).addObserver(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Lpr);
        mww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alxz);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alxa);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amng);
        if (this.jdField_a_of_type_Atrr != null) {
          this.jdField_a_of_type_Atrr.b();
        }
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
    if ((!swy.k) || ((!paramBoolean) && (nrc.a().jdField_a_of_type_Boolean))) {}
    label151:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ajee != null))
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
        if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
          if (!(this.jdField_a_of_type_Ajee.getItem(i1) instanceof RecentItemPublicAccountADFolderData)) {}
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label151;
        }
        if ((this.jdField_a_of_type_Asot != null) && (!this.y))
        {
          this.jdField_a_of_type_Asot.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.y = true;
        }
        nrc.a().jdField_a_of_type_Boolean = true;
        ThreadManager.getSubThreadHandler().postDelayed(new Conversation.23(this), 1000L);
        return;
        i1 += 1;
        break;
      }
    }
  }
  
  public void K_()
  {
    R();
    u();
    if (this.jdField_a_of_type_Ajbm != null) {
      this.jdField_a_of_type_Ajbm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Awhw != null) {
      this.jdField_a_of_type_Awhw.c();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        annx localannx = (annx)localIterator.next();
        if (localannx != null) {
          localannx.b();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134065);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134061);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134068);
    azmg.a();
    if (this.jdField_a_of_type_Ajfr != null) {
      this.jdField_a_of_type_Ajfr.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Ajfx != null) {
      this.jdField_a_of_type_Ajfx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_Ajdq != null) {
      this.jdField_a_of_type_Ajdq.a(a());
    }
    if (this.jdField_a_of_type_Atrr != null) {
      this.jdField_a_of_type_Atrr.d();
    }
    if (this.jdField_a_of_type_Acos != null) {
      this.jdField_a_of_type_Acos.c();
    }
    if (this.jdField_a_of_type_Ajih != null) {
      this.jdField_a_of_type_Ajih.a(a());
    }
  }
  
  int a()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Ajee.getCount())
    {
      if ((this.jdField_a_of_type_Ajee.getItem(i1) instanceof RecentItemMayKnowFriendVerticalListData)) {
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
      } while (ajgm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
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
  
  public ajee a()
  {
    return this.jdField_a_of_type_Ajee;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    bdjd.a(null, "Recent_Start");
    bdjd.a(null, "Recent_CreateView");
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
        localObject2 = paramLayoutInflater.inflate(2131558904, null);
      }
      bdjd.a("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public String a()
  {
    String str = alpo.a(2131702979);
    if (this.jdField_d_of_type_Int <= 0) {
      return str;
    }
    if (this.jdField_d_of_type_Int > 99) {
      return str + "(99+)";
    }
    return str + "(" + this.jdField_d_of_type_Int + ")";
  }
  
  public uwn a()
  {
    return this.jdField_a_of_type_Uwn;
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
                      localObject = azqu.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
                    } while (localObject == null);
                    String str = paramIntent.getStringExtra("uin");
                    paramInt1 = paramIntent.getIntExtra("uintype", -1);
                    paramInt2 = paramIntent.getIntExtra("cmshow_game_id", -1);
                    bdir.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramInt1, (AbsStructMsg)localObject, null);
                    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(paramInt1), 0, new String[] { Integer.toString(paramInt2) });
                    return;
                  } while (a() == null);
                  a().setCanLock(false);
                  return;
                } while (paramInt2 != 0);
                A();
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
                return;
              } while ((-1 != paramInt2) || (paramIntent == null));
              paramIntent = paramIntent.getStringExtra("roomId");
            } while (paramIntent == null);
            bclo.a(a(), paramIntent, true);
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
            return;
          } while (paramInt2 != -1);
          QQToast.a(a(), 2, a(2131721122), 0).b(a().getTitleBarHeight());
          return;
        } while (!QLog.isColorLevel());
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + -1);
        return;
        ajfr.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
        return;
        localObject = akro.a();
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.aw_();
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
    amjk localamjk;
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      str = "1";
      localamjk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject2 = paramRecentBaseData.a();
      localObject1 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((paramInt != 7000) || (aljq.x.equals(localObject2))) {
        break label173;
      }
      azyl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, paramBoolean);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str, paramString, "");
    }
    int i2;
    int i1;
    for (;;)
    {
      i2 = a(paramRecentBaseData.a(), paramInt);
      paramRecentBaseData = localamjk.a(false).iterator();
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
        if (this.jdField_a_of_type_Ajgl != null) {
          this.jdField_a_of_type_Ajgl.a(paramRecentBaseData, paramBoolean);
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", str, paramString, "");
      }
      else
      {
        if (paramInt != 5001) {
          break label262;
        }
        ((alpr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramBoolean);
      }
    }
    label262:
    if (paramInt == 1)
    {
      paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject1 = paramString.d(paramRecentBaseData.a());
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = (alkk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
        if (paramBoolean)
        {
          i1 = 0;
          label320:
          if (((alkk)localObject2).a((String)localObject1, i1)) {
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
          localObject1 = new azmo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
          localObject2 = paramRecentBaseData.a();
          if (!paramBoolean) {
            break;
          }
        }
        for (paramString = "0";; paramString = "1")
        {
          ((azmo)localObject1).a(new String[] { localObject2, String.valueOf(i1), paramString }).a();
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
        if ((localObject2 != null) && (((String)localObject2).length() != 0) && (localamjk != null)) {
          break label612;
        }
      } while (!QLog.isColorLevel());
      paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
      if (localObject2 == null)
      {
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (localamjk != null) {
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
      localObject1 = localamjk.b((String)localObject2, i1);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = new RecentUser((String)localObject2, i1);
      }
      if (!aupu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) {
        break;
      }
      if (paramBoolean) {}
      for (paramString.showUpTime = (System.currentTimeMillis() / 1000L);; paramString.showUpTime = 0L)
      {
        localamjk.a(paramString);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        break;
      }
      if ((paramInt == 0) && (((aloz)localObject1).b((String)localObject2)))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramBoolean) {}
        for (i1 = 1;; i1 = 2)
        {
          azmj.b(paramString, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i1, "0", "0", "", "");
          if (bdee.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
            break;
          }
          QQToast.a(a(), 1, 2131696588, 0).b(a().getTitleBarHeight());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "setChatAtTop top: " + paramBoolean + " uin: " + (String)localObject2 + " userType: " + paramInt);
        }
        FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, paramBoolean);
        break;
      }
      i1 = paramRecentBaseData.a();
      if ((localObject2 != null) && (((String)localObject2).length() != 0) && (localamjk != null)) {
        break label976;
      }
    } while (!QLog.isColorLevel());
    label391:
    paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
    if (localObject2 == null)
    {
      paramBoolean = true;
      paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
      if (localamjk != null) {
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
    paramString = localamjk.b((String)localObject2, i1);
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
        localamjk.a(paramString);
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
        Iterator localIterator = localamjk.a(false).iterator();
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
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + i2, (String)localObject1, (String)localObject1, 0, 0, "" + i3, "" + i1, "", "");
          for (;;)
          {
            if ((7220 == paramString.getType()) && (aljq.aA.equals(localObject2)))
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
                localIterator = localamjk.a(false).iterator();
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
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", paramString.uin, (String)localObject1, (String)localObject1, 0, 0, "" + i2, "" + i1, "", "");
            if (!"2290230341".equals(localObject2)) {
              break label1232;
            }
            if (paramBoolean) {}
            for (localObject1 = "0X80090E6";; localObject1 = "0X800915B")
            {
              if (paramBoolean) {
                azmg.a(4);
              }
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
              break label1232;
              break;
            }
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, str, String.valueOf(i1), String.valueOf(i2), "");
            if (paramInt != 7220) {
              break label332;
            }
            if (paramBoolean)
            {
              nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
              return;
            }
            nrt.a(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
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
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_Ajbm != null)) {
        this.jdField_a_of_type_Ajbm.a(paramRecentUser.uin);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.getType());
      }
    } while ((paramInt & 0x4) == 0);
    ajgm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, -1);
    QQToast.a(a(), alpo.a(2131702978), 0).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 8) && (paramInt1 != 9)) {
      return;
    }
    a(0, paramInt1, ajeu.a(paramString, paramInt2));
  }
  
  public void a(int paramInt, List<RecentBaseData> paramList)
  {
    if ((-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a()) || ((this.H) && (this.I)))
    {
      this.jdField_a_of_type_Acoj.a(paramInt, paramList);
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
        QLog.i("Q.recent", 4, i1 + "]，shouldShowConversationMayknow = " + this.q);
      }
    }
    else if (this.jdField_a_of_type_Ajee != null)
    {
      if (paramInt != 0) {
        break label439;
      }
      if (this.q)
      {
        localObject = (alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
        if ((((alro)localObject).jdField_a_of_type_Boolean) && (((alro)localObject).a(paramList))) {
          ((alro)localObject).jdField_a_of_type_Boolean = false;
        }
      }
      this.jdField_a_of_type_Ajee.a(paramList);
      if (this.E)
      {
        this.E = false;
        if (this.F)
        {
          if (!this.jdField_f_of_type_Boolean) {
            break label432;
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addOnLayoutChangeListener(new acoh(this));
        }
      }
    }
    for (;;)
    {
      this.F = false;
      if (paramList != null) {
        ajeu.a().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      }
      this.jdField_a_of_type_Ajee.a(0);
      if (AppSetting.jdField_h_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.10(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_d_of_type_Int);
      a(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      if (this.o)
      {
        this.o = false;
        if ((((uur)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Uwn != null)) {
          this.jdField_a_of_type_Uwn.e();
        }
      }
      if (this.z)
      {
        this.z = false;
        T();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
      S();
      amnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, 0);
      return;
      i1 = paramList.size();
      break;
      label432:
      ac();
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
      this.jdField_a_of_type_Ajee.a((RecentBaseData)localObject);
    }
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    if (!paramBoolean1)
    {
      J();
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
      this.jdField_a_of_type_Ajbm.a(8, 0);
    }
    boolean bool1;
    int i1;
    label111:
    boolean bool2;
    if (!paramBoolean1)
    {
      bool1 = true;
      atvl.a().a(bool1);
      localObject1 = this.jdField_a_of_type_Ajbm;
      if (!bool1) {
        break label244;
      }
      i1 = 2;
      ((ajbm)localObject1).a(1, i1);
      bool2 = atvl.a().d();
      if ((!bool2) || (paramInt != 1134012)) {
        break label352;
      }
      bool2 = false;
    }
    label352:
    for (;;)
    {
      atvl.a().b(bool2);
      localObject1 = this.jdField_a_of_type_Ajbm;
      i1 = i2;
      if (bool2) {
        i1 = 2;
      }
      ((ajbm)localObject1).a(9, i1);
      this.jdField_a_of_type_Ajbm.a(-1, null);
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (annx)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              ((annx)localObject2).a(paramBoolean1);
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
        ((StringBuilder)localObject1).append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", isNetSupport = ").append(paramBoolean1).append(", loadingState = ").append(atvl.a().a()).append(", msg = ").append(paramInt);
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
    int i1 = bcze.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    bcze.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i1 + 1);
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
    if ((this.jdField_a_of_type_Ajfr != null) && (this.jdField_a_of_type_Ajfr.a())) {
      this.jdField_a_of_type_Ajfr.b();
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
        paramMessage.append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", initLoadingHandle = ").append(paramBoolean).append(", loadingState = ").append(atvl.a().a()).append(", what = ").append(i1);
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
    if (this.jdField_a_of_type_Ajee == null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = this.jdField_a_of_type_Ajee.a(paramView);
      if ((localRecentBaseData != null) && ("9970".equals(localRecentBaseData.a()))) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
      }
    } while ((localRecentBaseData == null) || (!aljq.aB.equals(localRecentBaseData.a())));
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
    if ((paramString.equals("sp_uin_for_title")) && (i2 == 2131375426))
    {
      z();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "msgtab_list_clk", 2);
      return;
    }
    alro localalro = (alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramString, 102);
    boolean bool = localalro.a();
    ArrayList localArrayList = localalro.c();
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
      if (i2 == 2131375665)
      {
        if (!bdee.g(paramContext))
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131692397), 0).b(a().getTitleBarHeight());
          return;
        }
        paramString = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((!paramString.b(paramView.uin)) && (!paramString.d(paramView.uin)))
        {
          paramString = paramView.getDisplayName(localalro.a());
          paramContext = AddFriendLogicActivity.a(paramContext, 1, paramView.uin, null, 3045, 25, paramString, null, null, paramContext.getString(2131689628), null);
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(25), "", "", "");
          a(paramContext);
        }
        for (;;)
        {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
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
    this.D = true;
    if (this.jdField_e_of_type_Boolean)
    {
      if ((paramRecentBaseData instanceof RecentItemMayKnowFriendData))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, " onRecentBaseDataClick recommend_item_menu");
        }
        z();
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
      ((alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.a());
      return;
    }
    bdjd.a(null, "AIO_Click_cost");
    bdel.a(null, "pubAcc_aio_open", "");
    bdah.a(true);
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
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", str, str, 0, 0, paramView.uin + "", "" + l1, "" + i1, "" + localRecentUserBaseData.mUnreadNum);
        bhok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramRecentBaseData);
        amnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData);
        i1 = ajgm.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData);
        if ((paramView != null) && (paramView.lFlag == 16L) && (i1 == 0) && (this.jdField_a_of_type_Asot != null))
        {
          this.jdField_a_of_type_Asot.b();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "ad preload tool process hit");
          }
        }
        if ((paramView != null) && (String.valueOf(9970L).equals(paramView.uin)) && (this.jdField_b_of_type_Asot != null)) {
          this.jdField_b_of_type_Asot.b();
        }
        if ((paramView != null) && (paramView.getType() == 6004) && (this.jdField_c_of_type_Asot != null)) {
          this.jdField_c_of_type_Asot.b();
        }
        a(i1, paramView);
        if (paramRecentBaseData != null)
        {
          ajgk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramView);
          paramRecentBaseData.b();
          bhpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.a());
          this.jdField_i_of_type_Boolean = true;
        }
        if (paramView != null)
        {
          paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
          paramRecentBaseData.setFeedInfoRead(paramView.uin);
          if (!FeedsManager.isShowStatus(paramView.uin)) {
            break label739;
          }
          paramString = (aely)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
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
          bdjd.a("AIO_Click_cost", null);
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
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090CC", "0X80090CC", i1, 0, "", "", "", "");
            break;
          }
          label739:
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.uin, paramView.getType());
          if ((paramView != null) && (paramView.msgtype == -1034))
          {
            paramView = (aely)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
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
    uhu localuhu = (uhu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
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
      if (paramView.getId() == 2131363490)
      {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
        paramView = new Intent(a(), ForwardRecentActivity.class);
        paramView.putExtra("forward_type", 13);
        a(paramView);
        return;
      }
      if ((paramView.getId() == 2131366819) || (paramView.getId() == 2131366821) || (paramView.getId() == 2131366822) || (paramView.getId() == 2131366823) || (paramView.getId() == 2131366824) || (paramView.getId() == 2131366825) || (paramView.getId() == 2131366826))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = bdbt.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, paramView, paramObject, null, true, null, true, true, null, null);
        return;
      }
    } while ((paramView.getId() != 2131368912) || (!localuhu.b(paramObject)));
    localuhu.a(paramView, (RecentItemChatMsgData)paramObject);
  }
  
  public void a(bdyv parambdyv, bdyu parambdyu)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) && (parambdyu != null) && (parambdyu.jdField_d_of_type_Long == 0L) && (parambdyu.jdField_a_of_type_Long != 0L)) {
      parambdyv.a(parambdyu.jdField_a_of_type_Long);
    }
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    K();
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
        ajgk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
        ajgm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i1);
        this.jdField_a_of_type_Acop.a(paramString);
      }
    }
    for (;;)
    {
      return;
      localObject = (awwg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
      if ((localObject != null) && (paramRecentBaseData != null)) {}
      try
      {
        ((awwg)localObject).b(paramRecentBaseData.a(), paramRecentBaseData.a());
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
        if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
          if (paramRecentBaseData.a() == 3000)
          {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
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
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = a();
    int i1 = paramRecentBaseData.a();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_Ajgl == null)) {
      this.jdField_a_of_type_Ajgl = new ajgl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (bdal.a(paramString1, localResources.getString(2131691309)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
      if (!bdal.a(paramString1, localResources.getString(ajff.a[4]))) {
        break label408;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        ajgm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.a(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
    }
    label408:
    while (!bdal.a(paramString1, localResources.getString(ajff.a[5])))
    {
      return;
      if (bdal.a(paramString1, localResources.getString(2131691313)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        break;
      }
      if (bdal.a(paramString1, localResources.getString(2131693300)))
      {
        a(i1, paramRecentBaseData, paramString2, false);
        if (i1 != 3000) {
          break;
        }
        new azmo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").a();
        break;
      }
      if (bdal.a(paramString1, localResources.getString(2131693302)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        if (i1 != 3000) {
          break;
        }
        new azmo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").a();
        break;
      }
      if (!bdal.a(paramString1, localResources.getString(2131694600))) {
        break;
      }
      this.jdField_a_of_type_Ajfx.a(a(), paramRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramRecentBaseData.a(), "0X800991D", "0X800991D", 0, 0, "", "", "", "");
      break;
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1.uin, paramString1.getType(), 1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
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
    if (this.jdField_a_of_type_Ajee != null) {
      this.jdField_a_of_type_Ajee.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Ajbm.a(21, 0);
    ajeu.a().a();
    if (this.jdField_a_of_type_Acop != null) {
      this.jdField_a_of_type_Acop.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_Awhw != null) {
      this.jdField_a_of_type_Awhw.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        annx localannx = (annx)localIterator.next();
        if (localannx != null) {
          localannx.a(paramLogoutReason);
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
    //   0: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 447
    //   9: iconst_2
    //   10: new 449	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 450	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 2817
    //   20: invokevirtual 456	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 459	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 466	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 505	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   37: invokevirtual 2820	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   40: ifge +11 -> 51
    //   43: aload_0
    //   44: getfield 505	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   47: iconst_0
    //   48: invokevirtual 2823	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 2825	com/tencent/mobileqq/activity/Conversation:j	(Z)V
    //   56: iload_1
    //   57: ifeq +360 -> 417
    //   60: invokestatic 646	atvl:a	()Latvl;
    //   63: invokevirtual 2826	atvl:a	()V
    //   66: invokestatic 861	ajeu:a	()Lajeu;
    //   69: invokevirtual 2810	ajeu:a	()V
    //   72: aload_0
    //   73: getfield 1646	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   76: ifeq +22 -> 98
    //   79: aload_0
    //   80: getfield 505	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   83: ifnull +15 -> 98
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 1646	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   91: aload_0
    //   92: getfield 505	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   95: invokevirtual 2829	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   98: aload_0
    //   99: getfield 663	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   102: ifnull +15 -> 117
    //   105: aload_0
    //   106: getfield 663	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   109: invokevirtual 2830	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 663	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   117: aload_0
    //   118: getfield 678	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   121: ifnull +15 -> 136
    //   124: aload_0
    //   125: getfield 678	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   128: invokevirtual 686	android/app/Dialog:dismiss	()V
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 678	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   136: aload_0
    //   137: getfield 848	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahmr	Lahmr;
    //   140: ifnull +14 -> 154
    //   143: aload_0
    //   144: getfield 848	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ahmr	Lahmr;
    //   147: aload_0
    //   148: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   151: invokevirtual 2831	ahmr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   154: aload_0
    //   155: getfield 2057	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajgl	Lajgl;
    //   158: ifnull +14 -> 172
    //   161: aload_0
    //   162: getfield 2057	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajgl	Lajgl;
    //   165: aload_0
    //   166: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: invokevirtual 2832	ajgl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   172: aload_0
    //   173: getfield 468	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajee	Lajee;
    //   176: ifnull +25 -> 201
    //   179: aload_0
    //   180: getfield 468	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajee	Lajee;
    //   183: aload_0
    //   184: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   187: invokevirtual 2833	ajee:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   190: aload_0
    //   191: iconst_1
    //   192: bipush 10
    //   194: lconst_0
    //   195: invokestatic 489	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: invokevirtual 492	com/tencent/mobileqq/activity/Conversation:a	(IILjava/lang/Object;)V
    //   201: aload_0
    //   202: getfield 505	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   205: ifnull +11 -> 216
    //   208: aload_0
    //   209: getfield 505	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   212: iconst_0
    //   213: invokevirtual 2836	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   216: aload_0
    //   217: iconst_0
    //   218: invokespecial 1438	com/tencent/mobileqq/activity/Conversation:i	(Z)V
    //   221: aload_0
    //   222: getfield 1664	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Uwn	Luwn;
    //   225: ifnull +14 -> 239
    //   228: aload_0
    //   229: getfield 1664	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Uwn	Luwn;
    //   232: aload_0
    //   233: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   236: invokevirtual 2837	uwn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   239: aload_0
    //   240: getfield 1002	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   243: ifnull +16 -> 259
    //   246: aload_0
    //   247: getfield 1002	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   250: aload_0
    //   251: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   254: invokeinterface 2842 2 0
    //   259: aload_0
    //   260: getfield 509	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bjzr	Lbjzr;
    //   263: ifnull +14 -> 277
    //   266: aload_0
    //   267: getfield 509	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bjzr	Lbjzr;
    //   270: aload_0
    //   271: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   274: invokevirtual 2843	bjzr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   277: ldc_w 447
    //   280: ldc_w 2845
    //   283: aload_0
    //   284: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   287: getfield 1328	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   290: invokevirtual 1331	com/tencent/mobileqq/app/automator/Automator:b	()Z
    //   293: invokestatic 1336	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   296: invokestatic 2850	wsv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   299: aload_0
    //   300: sipush 1055
    //   303: lconst_0
    //   304: iconst_0
    //   305: invokevirtual 675	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   308: aload_0
    //   309: getfield 856	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   312: ifnull +10 -> 322
    //   315: aload_0
    //   316: getfield 856	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajbm	Lajbm;
    //   319: invokevirtual 2851	ajbm:e	()V
    //   322: aload_0
    //   323: getfield 180	com/tencent/mobileqq/activity/Conversation:jdField_j_of_type_Boolean	Z
    //   326: ifeq +13 -> 339
    //   329: aload_0
    //   330: getfield 1138	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   333: bipush 12
    //   335: invokevirtual 483	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   338: pop
    //   339: aload_0
    //   340: getfield 705	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   343: getfield 932	com/tencent/mobileqq/app/FrameHelperActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   346: iconst_4
    //   347: invokevirtual 2852	android/os/Handler:sendEmptyMessage	(I)Z
    //   350: pop
    //   351: aload_0
    //   352: sipush 1035
    //   355: ldc2_w 2853
    //   358: iconst_0
    //   359: invokevirtual 675	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   362: aload_0
    //   363: sipush 1010
    //   366: ldc2_w 2853
    //   369: iconst_1
    //   370: invokevirtual 675	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   373: aload_0
    //   374: sipush 1063
    //   377: lconst_0
    //   378: iconst_1
    //   379: aconst_null
    //   380: invokevirtual 1366	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   383: aload_0
    //   384: sipush 1064
    //   387: ldc2_w 2853
    //   390: iconst_1
    //   391: ldc_w 2856
    //   394: invokevirtual 1366	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   397: aload_0
    //   398: aload_0
    //   399: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   402: bipush 76
    //   404: invokevirtual 980	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   407: checkcast 2722	bdyv
    //   410: putfield 192	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bdyv	Lbdyv;
    //   413: aload_0
    //   414: invokespecial 2858	com/tencent/mobileqq/activity/Conversation:Z	()V
    //   417: aload_0
    //   418: sipush 10001
    //   421: ldc2_w 2859
    //   424: iconst_0
    //   425: invokevirtual 675	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   428: aload_0
    //   429: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   432: invokevirtual 1752	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   435: ifne +15 -> 450
    //   438: aload_0
    //   439: getfield 180	com/tencent/mobileqq/activity/Conversation:jdField_j_of_type_Boolean	Z
    //   442: ifeq +8 -> 450
    //   445: aload_0
    //   446: lconst_0
    //   447: invokevirtual 2861	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   450: aload_0
    //   451: ldc_w 2862
    //   454: ldc2_w 2863
    //   457: iconst_0
    //   458: invokevirtual 675	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   461: invokestatic 1217	nrc:a	()Lnrc;
    //   464: aload_0
    //   465: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   468: invokevirtual 1041	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   471: invokevirtual 2865	nrc:a	(Ljava/lang/String;)V
    //   474: getstatic 2868	aucf:jdField_g_of_type_Boolean	Z
    //   477: ifeq +13 -> 490
    //   480: invokestatic 2871	aucf:a	()Laucf;
    //   483: aload_0
    //   484: getfield 514	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   487: invokevirtual 2872	aucf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   490: return
    //   491: astore_2
    //   492: aload_0
    //   493: aconst_null
    //   494: putfield 663	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   497: goto -380 -> 117
    //   500: astore_2
    //   501: aload_0
    //   502: aconst_null
    //   503: putfield 663	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   506: aload_2
    //   507: athrow
    //   508: astore_2
    //   509: aload_0
    //   510: aconst_null
    //   511: putfield 678	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   514: goto -378 -> 136
    //   517: astore_2
    //   518: aload_0
    //   519: aconst_null
    //   520: putfield 678	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   523: aload_2
    //   524: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	this	Conversation
    //   0	525	1	paramBoolean	boolean
    //   491	1	2	localException1	Exception
    //   500	7	2	localObject1	Object
    //   508	1	2	localException2	Exception
    //   517	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   105	112	491	java/lang/Exception
    //   105	112	500	finally
    //   124	131	508	java/lang/Exception
    //   124	131	517	finally
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
  
  public boolean a(bdyv parambdyv, bdyu parambdyu)
  {
    if ((parambdyu == null) || (parambdyv == null)) {}
    do
    {
      return false;
      if (parambdyu.jdField_d_of_type_Long == 3L) {
        parambdyv.a(4L, parambdyu.jdField_a_of_type_Long);
      }
    } while ((parambdyu == null) || (parambdyu.jdField_d_of_type_Long != 2L) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) || (!this.x));
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
      bdjd.a("Conversation_PullToRefresh_start", 0L);
      o();
      ThreadManager.getSubThreadHandler().post(new Conversation.11(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      }
      if (((uur)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
      {
        ((uuq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a().a(2);
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
    if ((!ThemeUtil.isDefaultTheme()) && (this.C) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130849660);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131365849).setBackgroundResource(2130849671);
      this.C = false;
    }
    x();
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
      azib.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Awhw.k();
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        annx localannx = (annx)localIterator.next();
        if (localannx != null) {
          localannx.i();
        }
      }
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849463);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166898));
    }
    if (this.jdField_a_of_type_Ajih != null) {
      this.jdField_a_of_type_Ajih.e();
    }
    if (this.jdField_a_of_type_Uwn != null) {
      this.jdField_a_of_type_Uwn.j();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onPostThemeChanged();
    }
    if (this.jdField_a_of_type_Ajbm != null) {
      this.jdField_a_of_type_Ajbm.a(-1, null);
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
    bclr localbclr = (bclr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
    if (localbclr != null) {
      localbclr.a(paramLong);
    }
  }
  
  public void b(View paramView) {}
  
  public void b(boolean paramBoolean)
  {
    a(true);
    this.E = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      if (this.jdField_f_of_type_Boolean)
      {
        this.F = true;
        ab();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    if (this.jdField_a_of_type_Acos != null) {
      this.jdField_a_of_type_Acos.d();
    }
  }
  
  public View c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_c_of_type_AndroidViewView;
  }
  
  public void c()
  {
    if (SystemClock.uptimeMillis() - uwn.jdField_b_of_type_Long > 500L)
    {
      H();
      if ((this.x) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof HongBaoListView)) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mEnableStory) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mForStory))
      {
        if (this.jdField_a_of_type_Uwn != null) {
          this.jdField_a_of_type_Uwn.i();
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
        this.jdField_c_of_type_AndroidWidgetImageView.setId(2131369753);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, i1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(7.0F * bdcb.a()));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      }
    }
    while ((this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
      try
      {
        int i1;
        Object localObject = a().getResources().getDrawable(2130839226);
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
    boolean bool1 = this.jdField_a_of_type_Ajbm.a(1);
    boolean bool2 = this.jdField_a_of_type_Ajbm.a(9);
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
    switch (atvl.a().a())
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
    bdjd.a(null, "Recent_OnCreate");
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a(a());
    this.jdField_a_of_type_Acop = new acop(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bdbw(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_MqqOsMqqHandler = new bdbw(ThreadManager.getRecentThreadLooper(), this);
    this.jdField_a_of_type_Ajfx = new ajfx(this.jdField_a_of_type_MqqOsMqqHandler, a());
    this.jdField_a_of_type_Acos = new acos(this);
    M();
    L();
    a(false);
    this.jdField_a_of_type_Ajdq = new ajdq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bdjd.a("Recent_OnCreate", null);
  }
  
  public void e(boolean paramBoolean)
  {
    QLog.d("Q.recent", 2, "onResume...");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.D = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = true;
    alro.jdField_e_of_type_Boolean = true;
    if ((jdField_b_of_type_Long == -1L) && (SplashActivity.jdField_a_of_type_Boolean))
    {
      jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      SosoInterface.a(jdField_b_of_type_Long);
    }
    super.e(paramBoolean);
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
    ajgs.a().c();
    if (this.jdField_a_of_type_Ahmr != null) {
      this.jdField_a_of_type_Ahmr.a();
    }
    if (AppSetting.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(true);
    }
    this.jdField_f_of_type_Boolean = true;
    try
    {
      a().getWindow().setSoftInputMode(32);
      Object localObject1 = this.jdField_a_of_type_Bdyv;
      if (localObject1 != null)
      {
        localObject2 = ((bdyv)localObject1).a();
        if (localObject2 != null)
        {
          a((bdyv)localObject1, (bdyu)localObject2);
          if (a((bdyv)localObject1, (bdyu)localObject2) == true)
          {
            localObject1 = a();
            if ((localObject1 != null) && ((localObject1 instanceof SplashActivity))) {
              ((SplashActivity)localObject1).c();
            }
          }
        }
      }
      if (this.jdField_a_of_type_Ajbm != null)
      {
        boolean bool = atvl.a().d();
        localObject1 = this.jdField_a_of_type_Ajbm;
        if (bool)
        {
          i1 = 2;
          ((ajbm)localObject1).a(9, i1);
          atvl.a().b(bool);
          this.jdField_a_of_type_Ajbm.b();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == 0) {
            break label638;
          }
          i1 = 1;
          localObject1 = this.jdField_a_of_type_Ajbm;
          if (i1 == 0) {
            break label643;
          }
          i1 = 2;
          ((ajbm)localObject1).a(38, i1);
          if (!ardf.a().a()) {
            break label648;
          }
          i1 = 1;
          localObject1 = this.jdField_a_of_type_Ajbm;
          if (i1 == 0) {
            break label653;
          }
          i1 = 2;
          ((ajbm)localObject1).a(39, i1);
        }
      }
      else
      {
        anku.a().c();
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
        if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_Ajee != null)) {
          this.jdField_a_of_type_Ajee.notifyDataSetChanged();
        }
        a(0L);
        j();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
        Y();
        if (!this.jdField_b_of_type_Boolean) {
          break label701;
        }
        if (FrameHelperActivity.b()) {
          FrameHelperActivity.s();
        }
        this.jdField_b_of_type_Boolean = false;
        if ((this.jdField_a_of_type_Awhw.jdField_d_of_type_Int != -1) && (this.jdField_a_of_type_Awhw.jdField_d_of_type_Int != 1))
        {
          this.jdField_a_of_type_Awhw.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
          this.jdField_a_of_type_Awhw.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Awhw.d();
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          break label724;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label719;
          }
          localObject2 = (annx)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            if (!this.w) {
              break;
            }
            ((annx)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            ((annx)localObject2).jdField_c_of_type_Boolean = true;
            ((annx)localObject2).c();
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
        if (!this.B)
        {
          this.B = true;
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1067, 1000L);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1025, 3000L);
        continue;
        label701:
        this.jdField_a_of_type_Awhw.e();
        continue;
        ((annx)localObject2).d();
      }
      label719:
      this.w = false;
      label724:
      if (this.u) {
        this.u = false;
      }
      if (AppSetting.jdField_c_of_type_Boolean) {
        a().setTitle(a(2131694186));
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new Conversation.21(this), 500L);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1070, 3000L);
      ((axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
      ors.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_c_of_type_JavaLangRunnable == null) {
        this.jdField_c_of_type_JavaLangRunnable = new Conversation.22(this);
      }
      ThreadManagerV2.excute(this.jdField_c_of_type_JavaLangRunnable, 32, null, true);
      if (!bdiv.e(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
        if ((localObject3 == null) || (((List)localObject3).size() == 0))
        {
          bdiv.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
          if (bdiv.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).contains(localObject3)) {
            localArrayList.remove(localObject3);
          }
        }
        if (localArrayList.size() == 0)
        {
          bdiv.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          return;
        }
        ((alkk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(localArrayList, 0);
      }
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
      a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      astt.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ajee, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      nrc.a().jdField_a_of_type_Boolean = false;
      if (!paramBoolean) {
        break label1334;
      }
    }
    this.y = true;
    for (;;)
    {
      if (this.jdField_a_of_type_Atrr != null) {
        this.jdField_a_of_type_Atrr.a();
      }
      k(true);
      T();
      t();
      ApngImage.playByTag(2);
      if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1053)) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1053, 500L);
      }
      if (this.jdField_a_of_type_Uwn != null) {
        this.jdField_a_of_type_Uwn.l();
      }
      if (this.jdField_a_of_type_Ajbm != null) {
        this.jdField_a_of_type_Ajbm.g();
      }
      ajfx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      S();
      if (this.jdField_a_of_type_Ajih != null) {
        this.jdField_a_of_type_Ajih.d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onResume();
      }
      bajd.a(null);
      if ((!paramBoolean) || (this.jdField_a_of_type_Acos == null)) {
        break;
      }
      this.jdField_a_of_type_Acos.a(false);
      return;
      label1334:
      this.y = false;
      if (this.jdField_a_of_type_Asot != null) {
        this.jdField_a_of_type_Asot.d();
      }
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Acos != null) {
      this.jdField_a_of_type_Acos.c(paramBoolean);
    }
  }
  
  public void g()
  {
    QLog.d("Q.recent", 2, "onPause...");
    ApngImage.pauseByTag(2);
    super.g();
    this.jdField_a_of_type_Awhw.g();
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
        localObject2 = (annx)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((annx)localObject2).e();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1053);
    this.K = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (AppSetting.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
    }
    ajgs.a().b();
    this.jdField_f_of_type_Boolean = false;
    if ((!this.D) && (!this.E) && (ajfw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      if (System.currentTimeMillis() - this.jdField_h_of_type_Long > 5000L)
      {
        localObject1 = this.jdField_a_of_type_Ajee.b();
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
      if (this.jdField_a_of_type_Ajfr != null) {
        this.jdField_a_of_type_Ajfr.l();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = false;
      ors.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_b_of_type_Asot != null) {
        this.jdField_b_of_type_Asot.d();
      }
      if (this.jdField_c_of_type_Asot != null) {
        this.jdField_c_of_type_Asot.d();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
      azmg.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Uwn != null) {
        this.jdField_a_of_type_Uwn.m();
      }
      oxp.k();
      amnk.a();
      if (this.jdField_a_of_type_Acos == null) {
        break;
      }
      this.jdField_a_of_type_Acos.e();
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
      if (this.jdField_a_of_type_Uwn != null) {
        this.jdField_a_of_type_Uwn.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initLater(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
    }
  }
  
  public void h()
  {
    super.h();
    if ((this.jdField_a_of_type_Ajfr != null) && (this.jdField_a_of_type_Ajfr.a())) {
      this.jdField_a_of_type_Ajfr.b();
    }
    if (this.jdField_a_of_type_Asot != null) {
      this.jdField_a_of_type_Asot.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        annx localannx = (annx)localIterator.next();
        if (localannx != null) {
          localannx.f();
        }
      }
    }
    if (this.jdField_a_of_type_Atrr != null) {
      this.jdField_a_of_type_Atrr.e();
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
    bhxr.a("conv.handleMessage");
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
        bhxr.a();
        return true;
        if (!a(paramMessage)) {
          return true;
        }
        ((alpr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).b();
        atwd.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        I();
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (akaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          akaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        this.jdField_a_of_type_Ajdq.a((List)localObject1);
        paramMessage = ajeu.a().jdField_a_of_type_JavaUtilList;
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject4 = a();
        if (localObject1 != null)
        {
          i1 = ((List)localObject1).size();
          ajdp.a((List)localObject1, (QQAppInterface)localObject3, (Context)localObject4, paramMessage, i1);
        }
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_Ajdq);
          b(paramMessage);
          v();
          localObject1 = new ArrayList(paramMessage);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, localObject1).sendToTarget();
          a(paramMessage);
          if (this.jdField_a_of_type_Ajbm != null) {}
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          localObject1 = new HashMap();
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          azmz.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject1, "");
          localObject1 = (uhu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
          ((uhu)localObject1).b(3, ((uhu)localObject1).a(paramMessage));
          bdjd.a("Conversation_Refresh_global", System.currentTimeMillis() - l1);
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
        if (akaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          akaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        I();
        localObject3 = ajeu.a().jdField_a_of_type_JavaUtilList;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
        this.jdField_a_of_type_Ajdq.a((List)localObject4);
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
          str = ajeu.a(localRecentUser.uin, localRecentUser.getType());
          localObject2 = ajeu.a().a(str);
          if (localObject2 != null) {
            break label766;
          }
          localObject2 = ajdp.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          paramMessage = (Message)localObject2;
          if (localObject2 != null)
          {
            ajeu.a().a((RecentBaseData)localObject2, str);
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
            if (!this.jdField_b_of_type_JavaUtilList.contains(ajeu.a(localRecentUser.uin, -2147483648))) {}
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
          Collections.sort((List)localObject3, this.jdField_a_of_type_Ajdq);
          b((List)localObject3);
          v();
          paramMessage = new ArrayList((Collection)localObject3);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
          a((List)localObject3);
          if (this.jdField_a_of_type_Ajbm != null) {
            this.jdField_a_of_type_Ajbm.i();
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
          azmz.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - l1, ((List)localObject3).size(), paramMessage, "");
          bdjd.a("Conversation_Refresh_part", System.currentTimeMillis() - l1);
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
        paramMessage = ajeu.a().jdField_a_of_type_JavaUtilList;
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
            localObject4 = ajeu.a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
            if ((this.jdField_b_of_type_JavaUtilList.contains(localObject4)) || (this.jdField_b_of_type_JavaUtilList.contains(ajeu.a(((RecentBaseData)localObject3).a(), -2147483648))))
            {
              ((RecentBaseData)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
              ((List)localObject2).add(localObject3);
            }
          }
        }
        v();
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
        azmz.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject2, "");
        bdjd.a("Conversation_Refresh_items", System.currentTimeMillis() - l1);
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
      atwd.a().k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = ssp.a();
      if (paramMessage != null) {
        paramMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramMessage = suv.a();
      if (paramMessage != null) {
        paramMessage.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      bckr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = (bclk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
      if (paramMessage != null) {
        paramMessage.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      for (;;)
      {
        paramMessage = (ntw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
        if (paramMessage != null) {
          paramMessage.e();
        }
        paramMessage = (asvu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
        if (paramMessage != null) {
          paramMessage.a(true);
        }
        paramMessage = (alpr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255);
        if (paramMessage != null) {
          paramMessage.a();
        }
        amev.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
        paramMessage = (aqbb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(292);
        if (paramMessage != null) {
          paramMessage.c();
        }
        paramMessage = (uhu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
        paramMessage.a(1, paramMessage.a(this.jdField_a_of_type_JavaUtilList));
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
        }
      }
      j(true);
      break;
      a(new Conversation.24(this));
      break;
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1044, 0, 0, null).sendToTarget();
      break;
      paramMessage = (uhu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
      paramMessage.a(2, paramMessage.a(ajeu.a().jdField_a_of_type_JavaUtilList));
      break;
      if (this.jdField_a_of_type_Ajih == null) {
        break;
      }
      this.jdField_a_of_type_Ajih.b();
      break;
      label2074:
      l1 = 0L;
    }
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_Ajee == null)
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onDestroy");
    }
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ajfx != null) {
      this.jdField_a_of_type_Ajfx.a();
    }
    if (this.jdField_a_of_type_Bhpy != null)
    {
      this.jdField_a_of_type_Bhpy.a(null);
      this.jdField_a_of_type_Bhpy = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a(null);
    }
    this.q = false;
    ajgs.a().a();
    R();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
    if (this.jdField_a_of_type_Acop != null) {
      this.jdField_a_of_type_Acop.a();
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Ahmr != null) {
      this.jdField_a_of_type_Ahmr.b();
    }
    if (this.jdField_a_of_type_Ajee != null) {
      this.jdField_a_of_type_Ajee.b();
    }
    if (this.jdField_a_of_type_Uwn != null) {
      this.jdField_a_of_type_Uwn.c();
    }
    if (this.jdField_a_of_type_Ajbm != null) {
      this.jdField_a_of_type_Ajbm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        ((amjk)localObject).f();
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
    atwd.a();
    atwf.a();
    suv.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        annx localannx = (annx)((Iterator)localObject).next();
        if (localannx != null) {
          localannx.g();
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Atrr != null)
    {
      this.jdField_a_of_type_Atrr.f();
      this.jdField_a_of_type_Atrr = null;
    }
    if (this.jdField_a_of_type_Bjzr != null)
    {
      this.jdField_a_of_type_Bjzr.b();
      this.jdField_a_of_type_Bjzr = null;
    }
    if (this.jdField_e_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    }
    super.k();
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
      J();
      d(true);
      boolean bool1 = this.jdField_a_of_type_Ajbm.a(1);
      boolean bool2 = this.jdField_a_of_type_Ajbm.a(9);
      if ((bool1) || (bool2)) {
        c(800L);
      }
    }
    else
    {
      return;
    }
    if (bjxj.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      oxp.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
    c(60000L);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      this.jdField_a_of_type_Ajfr.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getWidth() - a().getDimensionPixelSize(2131298642) - a().getDimensionPixelSize(2131298643), a().getDimensionPixelSize(2131298644));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity instanceof MainFragment))) {
        ((MainFragment)this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).n();
      }
      if ((akro.c() <= 0) || (akro.b() <= 0)) {
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
        VipUtils.a(akro.a(), "cmshow", "Apollo", "plusentrance", 0, 0, new String[] { "" + i1, "" + i2 });
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
        wta.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
        Z();
        zdi.e();
        this.D = true;
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
        this.A = bool;
        this.jdField_h_of_type_Int = paramInt1;
        this.jdField_g_of_type_Long = l1;
        if (QLog.isDebugVersion()) {
          QLog.d("RecentDataListManager", 2, "onScroll:" + d1 + " for Direction:" + this.A);
        }
        if (d1 > 25.0D) {
          break label328;
        }
        W();
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
        this.J = false;
        this.jdField_j_of_type_Long = -1L;
      }
      if ((this.J) && (SystemClock.elapsedRealtime() - this.jdField_j_of_type_Long > 800L))
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
        if (QLog.isColorLevel()) {
          QLog.d("Conversation", 2, "onScroll cost time is below 1000 ms, isScroll2TopFlag: " + this.J + ", startScrollTime: " + this.jdField_j_of_type_Long);
        }
        this.J = false;
        this.jdField_j_of_type_Long = -1L;
      }
      return;
      bool = false;
      break;
      bcwi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      this.H = true;
      ApngImage.pauseByTag(2);
      this.jdField_a_of_type_Int = paramInt;
      if (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
        break label319;
      }
      if (this.jdField_a_of_type_Uwn != null) {
        this.jdField_a_of_type_Uwn.b(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1)) {
        break label419;
      }
      if (this.jdField_a_of_type_Ajee == null) {
        break label254;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i4 = this.jdField_a_of_type_Ajee.getCount();
      this.jdField_b_of_type_Int = Math.max(i1, -1);
      if ((i1 < 0) || (i1 >= i4) || (i1 > i2 - i3)) {
        break label242;
      }
      localObject = this.jdField_a_of_type_Ajee.getItem(i1);
      if ((localObject instanceof RecentBaseData)) {
        break label214;
      }
    }
    label214:
    do
    {
      i1 += 1;
      break label162;
      this.H = false;
      break;
      localObject = (RecentBaseData)localObject;
    } while ((!((RecentBaseData)localObject).a()) || (((RecentBaseData)localObject).b() <= 0));
    this.jdField_b_of_type_Int = i1;
    label242:
    this.jdField_a_of_type_Ajee.a(false);
    bdah.a(false);
    label254:
    if (paramInt == 0)
    {
      W();
      abqw.a().a("list_conv", false);
      ThreadRegulator.a().b(2);
      a(paramAbsListView);
      astt.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ajee, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      k(false);
      T();
      aa();
      w();
    }
    for (;;)
    {
      label319:
      if ((!this.H) && (this.I))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Conversation", 2, "onScrollStateChanged call with msg incoming");
        }
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(10);
        this.I = false;
      }
      if (paramInt == 0)
      {
        if (this.jdField_i_of_type_Boolean) {
          a(100L);
        }
        ApngImage.playByTag(2);
      }
      if (this.jdField_a_of_type_Ajbm != null) {
        this.jdField_a_of_type_Ajbm.b(this.H);
      }
      oya.a(paramAbsListView, paramInt);
      amnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAbsListView, paramInt);
      return;
      label419:
      if (this.jdField_a_of_type_Ajee == null) {
        break;
      }
      this.jdField_a_of_type_Ajee.a(true);
      bdah.a(true);
      break;
      abqw.a().a("list_conv");
      ThreadRegulator.a().a(2);
    }
  }
  
  public void p()
  {
    this.jdField_f_of_type_Boolean = true;
    if ((!this.jdField_j_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      D();
      bdjd.a("Recent_Start", null);
    }
    while (!this.jdField_j_of_type_Boolean) {
      return;
    }
    a(1030, 0L, true);
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_Acos != null) {
      this.jdField_a_of_type_Acos.b(false);
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559511, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        if (this.jdField_a_of_type_Ajfr == null)
        {
          this.jdField_a_of_type_Ajfr = new ajfr(localBaseActivity);
          this.jdField_a_of_type_Ajfr.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new acmy(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_Bdyv = ((bdyv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76));
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
        ((HashMap)localObject2).put("device_mode", bdcb.d());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        azmz localazmz = azmz.a(BaseApplicationImpl.getContext());
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label378;
        }
        localazmz.a(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
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
      this.jdField_a_of_type_Ajfr = null;
      this.l = false;
      break label208;
      label378:
      l1 = 1L;
    }
  }
  
  public void s()
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
        x();
        if ((!this.m) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())) {
          a(2);
        }
        if (this.jdField_a_of_type_Acos != null) {
          this.jdField_a_of_type_Acos.a();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new acmz(this));
        this.jdField_a_of_type_Ajih = new ajih(this, this.jdField_a_of_type_AndroidViewViewGroup);
        long l1 = System.currentTimeMillis();
        if (aokd.e())
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559511, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
          }
          O();
          long l2 = System.currentTimeMillis();
          QLog.d("AutoMonitor", 1, "init Mini App, cost=" + (l2 - l1));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initUI(a());
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
        if ((this.jdField_a_of_type_Ajbm != null) && (this.jdField_e_of_type_Boolean)) {
          this.jdField_a_of_type_Ajbm.j();
        }
        if (this.jdField_a_of_type_Ajbm != null) {
          this.jdField_a_of_type_Ajbm.a(false);
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
          K();
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(12);
          X();
          if (this.jdField_a_of_type_JavaLangString == null)
          {
            this.jdField_a_of_type_JavaLangString = amnr.a().a();
            if (this.jdField_a_of_type_JavaLangString == null)
            {
              this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367230));
              GLSurfaceView localGLSurfaceView = new GLSurfaceView(a());
              localGLSurfaceView.setRenderer(new acna(this));
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
        if (!this.t) {
          break label621;
        }
      }
      finally {}
      a(1055, 0L, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "initUiLater() mMsgTabStoryNodeListNeedInit fallback logic, send MSG_INIT_MSGTAG_STORY");
      }
      this.t = false;
      continue;
      label621:
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "initUiLater() will not send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()) });
      }
    }
  }
  
  void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_j_of_type_Boolean)) {}
    label124:
    for (;;)
    {
      return;
      if (((ntw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).b())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Ajee != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
            if (!(this.jdField_a_of_type_Ajee.getItem(i1) instanceof RecentItemEcShopAssitant)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!nrc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (this.jdField_b_of_type_Asot == null)) {
            break label124;
          }
          this.jdField_b_of_type_Asot.a();
          return;
          i1 += 1;
          break;
        }
      }
    }
  }
  
  void u()
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
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
          if ((this.jdField_f_of_type_Boolean) && (nmh.a((MessageRecord)localObject2)))
          {
            a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
            k(false);
          }
          if ((this.jdField_f_of_type_Boolean) && (astv.a((MessageRecord)localObject2))) {
            astt.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ajee, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          }
          int i1 = 10;
          Object localObject1 = Long.valueOf(0L);
          if ((((MessageRecord)localObject2).isSendFromLocal()) && ((!this.jdField_f_of_type_Boolean) || (TextUtils.equals(((MessageRecord)localObject2).frienduin, aljq.az)) || (TextUtils.equals(((MessageRecord)localObject2).frienduin, aljq.aA))))
          {
            i1 = 9;
            localObject1 = ajeu.a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
            if (((MessageRecord)localObject2).isSend()) {
              bdfe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
            }
            a(i2, i1, localObject1);
            this.I = true;
          }
          for (;;)
          {
            if (!(paramObservable instanceof awwg)) {
              break label613;
            }
            if ((paramObject instanceof Boolean))
            {
              boolean bool = ((Boolean)paramObject).booleanValue();
              if ((!this.jdField_e_of_type_Boolean) && (bool))
              {
                paramObservable = null;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                  paramObservable = (awwg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
                }
                if (paramObservable != null) {
                  paramObservable.a(false);
                }
              }
            }
            if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Ajbm == null)) {
              break;
            }
            this.jdField_a_of_type_Ajbm.j();
            return;
            if ((!this.jdField_f_of_type_Boolean) && (ajgm.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1024))) {
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1024, 100L);
            }
            i2 = 0;
            break label210;
            if ((paramObject instanceof RecentUser))
            {
              a(200L);
              if ((this.jdField_f_of_type_Boolean) && (((RecentUser)paramObject).getType() == 6004)) {
                this.z = true;
              }
            }
            else if ((paramObject instanceof String[]))
            {
              localObject1 = (String[])paramObject;
              if ((localObject1.length == 2) && (aljq.x.equals(localObject1[0])) && (localObject1[1] != null))
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
        } while ((!(paramObservable instanceof axho)) || (!(paramObject instanceof BusinessInfoCheckUpdate.AppInfo)));
        paramObject = (BusinessInfoCheckUpdate.AppInfo)paramObject;
        paramObservable = (axho)paramObservable;
        paramObservable = axhu.a(paramObject);
      } while ((paramObservable == null) || (paramObservable.size() <= 0));
      paramObservable = (axhu)paramObservable.get(0);
    } while ((paramObservable.jdField_a_of_type_Int < 1) || (paramObservable.jdField_a_of_type_Int > 4));
    axhu.b(this);
  }
  
  public void v()
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
          int i2 = awwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  
  void w()
  {
    if ((this.q) && (((alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).b("sp_mayknow_ml_s_a_vl")) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.isShown()) && (!this.jdField_a_of_type_Ajee.isEmpty()))
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
          if (i3 < this.jdField_a_of_type_Ajee.getCount())
          {
            i4 = i1;
            if (this.jdField_a_of_type_Ajee.getItem(i3) != null)
            {
              Object localObject = this.jdField_a_of_type_Ajee.getItem(i3);
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
  
  public void x()
  {
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, 1, 2130838592, "-conversation-");
  }
  
  public void y()
  {
    Object localObject = a();
    if (this.jdField_e_of_type_Boolean)
    {
      if (localObject == null) {}
      while (this.jdField_a_of_type_Ajih == null) {
        return;
      }
      boolean bool = this.jdField_a_of_type_Ajih.a((ajee)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "moveToCaredItemCyclic: invoked.  canFindUnreadItem: " + bool + " currentCaredType:" + this.jdField_f_of_type_Int + " currentUnreadCaredItemIndex: " + this.jdField_g_of_type_Int);
      }
      int i1 = (int)(a().getResources().getDimension(2131298635) + a().getResources().getDimension(2131298652) / 2.0F);
      int i2 = this.jdField_g_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      if (this.jdField_g_of_type_Int == 0) {
        i1 = 0;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "moveToCaredItemCyclic: invoked. selection1 ", " position: ", Integer.valueOf(i2) });
        }
        this.jdField_a_of_type_Ajih.c();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(i2, i1);
        localObject = new Conversation.53(this, i2);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed((Runnable)localObject, 250L);
      }
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1E3", "0X800A1E3", 0, 0, "", "", "", "");
  }
  
  void z()
  {
    if (this.jdField_a_of_type_Bhpy == null)
    {
      this.jdField_a_of_type_Bhpy = bhpy.a(a());
      this.jdField_a_of_type_Bhpy.b(2131691305);
      this.jdField_a_of_type_Bhpy.c(2131690648);
      this.jdField_a_of_type_Bhpy.a(new acoc(this));
    }
    this.jdField_a_of_type_Bhpy.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation
 * JD-Core Version:    0.7.0.1
 */