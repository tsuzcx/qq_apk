package com.tencent.mobileqq.activity;

import abev;
import acvy;
import adcd;
import adyo;
import adys;
import adyt;
import adyu;
import adyv;
import adyw;
import adyx;
import adyy;
import adyz;
import adza;
import adzb;
import adzc;
import adzd;
import adze;
import adzf;
import adzg;
import adzh;
import adzi;
import adzj;
import adzk;
import adzl;
import adzm;
import adzn;
import adzo;
import adzp;
import adzq;
import adzr;
import adzs;
import adzt;
import adzu;
import adzv;
import adzw;
import adzx;
import aeaa;
import aeac;
import aead;
import aeae;
import aeaf;
import aeag;
import aeah;
import aeai;
import aeaj;
import aeak;
import aeal;
import aeam;
import aean;
import aeaq;
import aear;
import aeau;
import aeav;
import aezu;
import afur;
import afwx;
import aini;
import ajhw;
import ajvo;
import akyh;
import alan;
import alao;
import alav;
import albc;
import albj;
import albs;
import alby;
import alcp;
import alcu;
import alcv;
import aldi;
import aldj;
import aldk;
import alfl;
import alxx;
import ampj;
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
import anhk;
import anie;
import anif;
import aniz;
import anjo;
import anjq;
import anke;
import ankx;
import anlv;
import anml;
import anmu;
import anmw;
import anni;
import annl;
import annz;
import anpk;
import anqd;
import ansp;
import anty;
import anub;
import anuy;
import anvm;
import anvp;
import anxg;
import anxo;
import aobo;
import aoen;
import aong;
import aoqm;
import aoqq;
import aoqx;
import appj;
import apsl;
import aqpv;
import asgf;
import askk;
import asyw;
import atcx;
import atmc;
import aval;
import avfs;
import avfu;
import avfw;
import avhx;
import awdj;
import awhd;
import awhv;
import awhx;
import axbp;
import ayes;
import aypl;
import azav;
import azwe;
import baif;
import baik;
import bcnj;
import bcsq;
import bcst;
import bcsy;
import bctj;
import bcwd;
import bdby;
import bdch;
import bdci;
import bddy;
import bdjg;
import bdoq;
import bdsx;
import bdtd;
import bdth;
import bdtl;
import bdun;
import bdvb;
import bdzi;
import bftr;
import bfuk;
import bfup;
import bfus;
import bgec;
import bgig;
import bgit;
import bgjr;
import bgjw;
import bglf;
import bgli;
import bgln;
import bglp;
import bgnt;
import bgnv;
import bgoo;
import bgsc;
import bgsg;
import bgso;
import bgsp;
import bhkf;
import bhkg;
import biau;
import bkfv;
import bkgb;
import bkgt;
import bkhe;
import bkho;
import bkmq;
import bkom;
import bkpj;
import blhj;
import bmqa;
import bmsi;
import bmvi;
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
import lmo;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import mue;
import muf;
import nuk;
import nuu;
import nve;
import nzz;
import oat;
import oda;
import org.json.JSONException;
import org.json.JSONObject;
import pha;
import pmy;
import pnk;
import tue;
import twi;
import tyg;
import vhk;
import wfi;
import wfp;
import wrx;
import wsl;
import wsm;
import wui;
import yqu;

public class Conversation
  extends anlv
  implements alav, albj, Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, anhk, anml, bgec, bkhe, bkmq, bkom, Observer
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
  private aeak jdField_a_of_type_Aeak;
  aeal jdField_a_of_type_Aeal = new aeal(this);
  private aeaq jdField_a_of_type_Aeaq;
  aear jdField_a_of_type_Aear = null;
  public aeau a;
  public aeav a;
  aezu jdField_a_of_type_Aezu = new adzs(this);
  ajhw jdField_a_of_type_Ajhw;
  public akyh a;
  private alao jdField_a_of_type_Alao;
  public albc a;
  public alcp a;
  private alcv jdField_a_of_type_Alcv;
  aldj jdField_a_of_type_Aldj;
  public alfl a;
  public Dialog a;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new adzt(this);
  protected Handler.Callback a;
  public GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  protected anif a;
  aniz jdField_a_of_type_Aniz = new adzi(this);
  private final anjq jdField_a_of_type_Anjq = new adzf(this);
  private final anke jdField_a_of_type_Anke = new adzm(this);
  ankx jdField_a_of_type_Ankx = new adzk(this);
  private final anmu jdField_a_of_type_Anmu = new adzc(this);
  private annz jdField_a_of_type_Annz = new adzw(this);
  private final anqd jdField_a_of_type_Anqd = new adzh(this);
  private anty jdField_a_of_type_Anty = new aean(this);
  private anub jdField_a_of_type_Anub = new adzr(this);
  private anuy jdField_a_of_type_Anuy = new adzx(this);
  anvm jdField_a_of_type_Anvm = new adzj(this);
  private final anvp jdField_a_of_type_Anvp = new adzn(this);
  private final anxg jdField_a_of_type_Anxg = new adzd(this);
  anxo jdField_a_of_type_Anxo = new adzg(this);
  private aoqm jdField_a_of_type_Aoqm = new aeaj(this);
  private asgf jdField_a_of_type_Asgf = new aeah(this);
  private asyw jdField_a_of_type_Asyw;
  private aval jdField_a_of_type_Aval = new aval("tool_adMessage", "com.tencent.mobileqq:tool");
  public awdj a;
  private final ayes jdField_a_of_type_Ayes = new adzp(this);
  private aypl jdField_a_of_type_Aypl = new aead(this);
  public azav a;
  private bdci jdField_a_of_type_Bdci = new aeai(this);
  bhkg jdField_a_of_type_Bhkg = null;
  private biau jdField_a_of_type_Biau;
  public bkho a;
  private bmsi jdField_a_of_type_Bmsi;
  private QCircleObserver jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver = new aeam(this);
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
  public ArrayList<apsl> a;
  public List<RecentBaseData> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final lmo jdField_a_of_type_Lmo = new adzo(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aeac(this);
  public MqqHandler a;
  private final wfi jdField_a_of_type_Wfi = new adzq(this);
  public wui a;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  Dialog jdField_b_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new adzu(this);
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private aval jdField_b_of_type_Aval = new aval("tool_shop", "com.tencent.mobileqq:tool");
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  protected Runnable b;
  private String jdField_b_of_type_JavaLangString;
  final List<String> jdField_b_of_type_JavaUtilList = new ArrayList(40);
  public MqqHandler b;
  public boolean b;
  int jdField_c_of_type_Int;
  public long c;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new adzv(this);
  View jdField_c_of_type_AndroidViewView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private aval jdField_c_of_type_Aval = new aval("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private Runnable jdField_c_of_type_JavaLangRunnable;
  MqqHandler jdField_c_of_type_MqqOsMqqHandler = new bkfv(Looper.getMainLooper(), this.jdField_a_of_type_Aeal);
  public boolean c;
  public int d;
  long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private Runnable jdField_d_of_type_JavaLangRunnable = new Conversation.4(this);
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
    this.jdField_a_of_type_Aeav = null;
    this.jdField_f_of_type_Int = 17;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new adyo(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new Conversation.29(this);
    this.jdField_a_of_type_Anif = new adze(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(BaseApplicationImpl.getContext(), new aeaf(this));
    this.jdField_b_of_type_JavaLangRunnable = new Conversation.62(this);
  }
  
  private void E()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof ARMapHongBaoListView)))
    {
      if (this.jdField_a_of_type_Bmsi == null) {
        this.jdField_a_of_type_Bmsi = new bmsi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, (ARMapHongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      }
      this.jdField_a_of_type_Bmsi.a();
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
      this.I = true;
      this.jdField_k_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.smoothScrollToPosition(0);
    }
  }
  
  private void H()
  {
    ThreadManager.excute(new Conversation.6(this), 16, null, true);
  }
  
  private void I()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Albc != null)) {}
    }
    else
    {
      return;
    }
    int i3 = this.jdField_a_of_type_Albc.getCount();
    int i1 = this.jdField_b_of_type_Int + 1;
    label96:
    int i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Object localObject = this.jdField_a_of_type_Albc.getItem(i1);
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
  
  private void J()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.jdField_f_of_type_Long);
    if ((this.jdField_a_of_type_Albc != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (TimeManager.getInstance().setDateFormat(str)) {
        this.jdField_f_of_type_Long = l1;
      }
    }
  }
  
  private void K()
  {
    if (awhd.a().b()) {
      awhd.a().a(3);
    }
  }
  
  private void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMWrapper", 2, "Conversation showUpgradeDetailInfoIfNeccessary mInitTimUpgradeInfo : " + this.F);
    }
    if ((!this.w) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.a()))
    {
      if (this.w)
      {
        if ((!anjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.F))
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
      anjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i1 = anjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      anjo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1 + 1);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void M()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
  }
  
  private void N()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131365002));
    this.jdField_a_of_type_Aeak = new aeak(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_Aeak, false);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.p = false;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376788));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378874));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365063));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377835));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379480));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379488));
    O();
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
      bcnj.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369967);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376119));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDescendantInvalidatedFlags(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(a().getDrawable(2130839397));
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
              localObject2 = ((AppActivity)localObject3).getLayoutInflater().inflate(2131562821, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
            }
          }
          if (localObject2 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject2, 0);
            this.jdField_a_of_type_Ajhw = new ajhw(a(), 1, (View)localObject2);
            this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
          }
          this.jdField_a_of_type_Akyh = new akyh(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          localObject1 = a();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
          if (!albs.a().jdField_a_of_type_Boolean)
          {
            bool = true;
            this.jdField_a_of_type_Albc = new albc((Context)localObject1, (QQAppInterface)localObject2, (XListView)localObject3, this, 0, bool);
            this.jdField_a_of_type_Albc.b(true);
            this.jdField_a_of_type_Albc.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Albc);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
            this.jdField_a_of_type_Albc.a(this);
            this.jdField_c_of_type_AndroidViewView = new View(a());
            localObject1 = new AbsListView.LayoutParams(-1, 0);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView, null, false);
            if ((TextUtils.isEmpty(albs.a().jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(albs.a().jdField_a_of_type_JavaLangString))) {
              break label855;
            }
            localObject1 = new ArrayList(16);
            QLog.d("Q.recent", 1, "ignore PreLoadList");
            this.jdField_a_of_type_Albc.a((List)localObject1);
            this.jdField_a_of_type_Albc.a(0);
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.q();
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
            this.jdField_a_of_type_Azav = new azav(this, this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_a_of_type_Awdj = new awdj(this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131365071));
            IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
            a("initUI");
            return;
            a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
            a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850087);
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166983));
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166983));
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
            label855:
            List localList = albs.a().jdField_b_of_type_JavaUtilList;
            continue;
            localList = null;
          }
        }
      }
    }
  }
  
  private void O()
  {
    int i1 = afur.a(10.0F, a());
    afur.a(this.jdField_a_of_type_AndroidWidgetTextView, i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new muf());
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new adyx(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(new adyy(this));
  }
  
  private void P()
  {
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
  
  private void Q()
  {
    Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if ((localManager instanceof baif))
    {
      int i1 = ((baif)localManager).a("104000.104001", 100);
      if (i1 > 0) {
        a(8, anhk.aB, 7230);
      }
      QLog.d("Q.recent", 2, "uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "getSubscribeAccountRedDotNum  redNumByPath:" + i1);
    }
  }
  
  private void R()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "initMiniAppEntryLayout.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface == null)
    {
      if (aqpv.c()) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface = new MiniAppDesktop(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface = new QQMessagePageMiniAppEntryManager(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
  }
  
  private void S()
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
        if (this.jdField_a_of_type_Aeav != null) {
          this.jdField_a_of_type_Aeav.a();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new adza(this));
        this.jdField_a_of_type_Alfl = new alfl(this, this.jdField_a_of_type_AndroidViewViewGroup);
        U();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
        T();
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
          L();
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(12);
          av();
          V();
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
  
  private void T()
  {
    if ((this.jdField_a_of_type_Akyh != null) && (this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_Akyh.j();
    }
    if (this.jdField_a_of_type_Akyh != null) {
      this.jdField_a_of_type_Akyh.a(false);
    }
    a(1010, 5000L, false);
    a(1064, 5000L, true, "qboss_banner_login");
    a(1023, 0L, false);
    a(1076, 1000L, false);
  }
  
  private void U()
  {
    long l1 = System.currentTimeMillis();
    if (aqpv.a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559646, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
      }
      R();
      long l2 = System.currentTimeMillis();
      QLog.d("AutoMonitor", 1, "init Mini App, cost=" + (l2 - l1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initUI(a());
    }
  }
  
  private void V()
  {
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      this.jdField_b_of_type_JavaLangString = aoqx.a().a();
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367533));
        GLSurfaceView localGLSurfaceView = new GLSurfaceView(a());
        localGLSurfaceView.setRenderer(new adzb(this));
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(localGLSurfaceView);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_GPU", 2, "GL_RENDERER= " + this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void W()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    au();
    a(1010, 0L, false);
    a(1023, 0L, false);
    a(1027, 0L, false);
    L();
    baik.a(this);
    if (!this.jdField_e_of_type_Boolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2);
    }
    X();
    ((bdby)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(361)).a(a());
  }
  
  private void X()
  {
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void Y()
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anmu);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anxg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anif);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anjq);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anqd);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anxo);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aniz);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ankx);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvp);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anke);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Annz);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Wfi);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayes);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anub);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuy);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aypl);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asgf);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvm);
        bdch.b(this.jdField_a_of_type_Bdci);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Lmo);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
        }
        if (this.jdField_a_of_type_Asyw != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Asyw);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aezu);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anty);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoqm);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver);
        localObject1 = (azwe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject1 != null) {
          ((azwe)localObject1).deleteObserver(this);
        }
        localObject1 = (baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (localObject1 != null) {
          ((baif)localObject1).deleteObserver(this);
        }
        if (this.jdField_a_of_type_Awdj != null) {
          this.jdField_a_of_type_Awdj.c();
        }
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(17);
      try
      {
        localObject1 = a();
        if (this.jdField_a_of_type_Aeaq != null)
        {
          bdsx.b(this.jdField_a_of_type_Aeaq);
          this.jdField_a_of_type_Aeaq.a();
          this.jdField_a_of_type_Aeaq = null;
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
  
  private void Z()
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == -1) {
      QQToast.a(a(), 2, a(2131718874), 0).b(a().getTitleBarHeight());
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((-1 == paramInt) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        bfup.a(a(), paramIntent, true);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean, String paramString, aong paramaong)
  {
    int i2 = a(paramRecentBaseData.getRecentUserUin(), paramInt);
    paramRecentBaseData = paramaong.getRecentList(false).iterator();
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, paramString, String.valueOf(i1), String.valueOf(i2), "");
      if (paramInt == 7220)
      {
        if (paramBoolean) {
          oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
        }
      }
      else {
        return;
      }
      oat.a(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
      return;
    }
  }
  
  private void a(int paramInt, List<RecentBaseData> paramList)
  {
    if ((-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a()) || ((this.G) && (this.H)))
    {
      this.jdField_a_of_type_Aeak.a(paramInt, paramList);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      if (AppSetting.jdField_h_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.8(this));
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
        QLog.i("Q.recent", 4, i1 + "]，shouldShowConversationMayknow = " + this.p);
      }
    }
    else if (this.jdField_a_of_type_Albc != null)
    {
      if (paramInt != 0) {
        break label267;
      }
      c(paramList);
    }
    for (;;)
    {
      if (AppSetting.jdField_h_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.9(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_d_of_type_Int);
      a(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      if (this.y)
      {
        this.y = false;
        ao();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
      an();
      aoqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, 0);
      return;
      i1 = paramList.size();
      break;
      label267:
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
        adyt localadyt = new adyt(this);
        adyu localadyu = new adyu(this, localUpgradeTIMWrapper);
        if (TextUtils.isEmpty(localUpgradeTIMWrapper.d))
        {
          paramMessage = anni.a(2131701391);
          if (!TextUtils.isEmpty(localUpgradeTIMWrapper.e)) {
            break label323;
          }
          str = anni.a(2131701401);
          this.jdField_c_of_type_AndroidAppDialog = bglp.a(a(), localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString, localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString, paramMessage, str, null, localadyu, localadyt);
          this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new adyv(this));
          if ((!this.w) || (this.jdField_c_of_type_AndroidAppDialog.isShowing()) || ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.isShowing())) || (anjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            continue;
          }
          this.jdField_c_of_type_AndroidAppDialog.show();
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
          anjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      paramMessage = albs.a().jdField_a_of_type_JavaUtilList;
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
          String str = albs.a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          if ((this.jdField_b_of_type_JavaUtilList.contains(str)) || (this.jdField_b_of_type_JavaUtilList.contains(albs.a(localRecentBaseData.getRecentUserUin(), -2147483648))))
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
      bctj.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - paramLong, paramMessage.size(), (HashMap)localObject, "");
      bgso.a("Conversation_Refresh_items", System.currentTimeMillis() - paramLong);
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + paramLong + "," + (System.currentTimeMillis() - paramLong) + "]");
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, int paramInt)
  {
    bkgb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, paramRecentBaseData);
    aoqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData);
    if ((paramRecentUser != null) && (paramRecentUser.lFlag == 16L) && (paramInt == 0) && (this.jdField_a_of_type_Aval != null))
    {
      this.jdField_a_of_type_Aval.b();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "ad preload tool process hit");
      }
    }
    if ((paramRecentUser != null) && (String.valueOf(9970L).equals(paramRecentUser.uin)) && (this.jdField_b_of_type_Aval != null)) {
      this.jdField_b_of_type_Aval.b();
    }
    if ((paramRecentUser != null) && (paramRecentUser.getType() == 6004) && (this.jdField_c_of_type_Aval != null)) {
      this.jdField_c_of_type_Aval.b();
    }
    if (paramRecentUser != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
      paramRecentBaseData.setFeedInfoRead(paramRecentUser.uin);
      if (!FeedsManager.isShowStatus(paramRecentUser.uin)) {
        break label217;
      }
      afwx localafwx = (afwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
      if (localafwx != null)
      {
        long l1 = localafwx.a(paramRecentUser.uin);
        FeedsManager.saveToken(paramRecentUser.uin, l1);
        paramRecentBaseData.reportClickExpose();
        localafwx.a(2, 2);
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
      paramRecentBaseData = (afwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
    } while (paramRecentBaseData == null);
    paramRecentBaseData.a(2, 1);
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString1, boolean paramBoolean, String paramString2)
  {
    if (this.jdField_a_of_type_Aldj != null) {
      this.jdField_a_of_type_Aldj.a(paramRecentBaseData, paramBoolean);
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", paramString2, paramString1, "");
  }
  
  private void a(AbsListView paramAbsListView)
  {
    int i1;
    if ((paramAbsListView != null) && (this.jdField_a_of_type_Albc != null))
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
          localObject1 = this.jdField_a_of_type_Albc.getItem(i2);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemPublicAccountADFolderData))) {
            break label226;
          }
          localObject1 = (RecentItemPublicAccountADFolderData)localObject1;
          if (!avfw.a(paramAbsListView.getChildAt(i2 - i1))) {
            break label226;
          }
          localObject1 = nuu.a().a(((RecentItemPublicAccountADFolderData)localObject1).mUser.uin);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Message localMessage = Message.obtain();
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("key_app", new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        ((HashMap)localObject2).put("key_adapter", new WeakReference(this.jdField_a_of_type_Albc));
        ((HashMap)localObject2).put("key_listview", new WeakReference(paramAbsListView));
        localMessage.obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_ad_id", ((nuk)localObject1).c);
        localMessage.setData((Bundle)localObject2);
        localMessage.what = 1;
        avfs.a().a(localMessage);
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
    ThreadManager.getSubThreadHandler().post(new Conversation.18(this, paramString));
  }
  
  private void a(String paramString1, @NonNull String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    a(new Conversation.19(this, paramString2, paramString1));
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    if (((paramObservable instanceof baif)) && ((paramObject instanceof BusinessInfoCheckUpdate.AppInfo)))
    {
      paramObservable = baik.a((BusinessInfoCheckUpdate.AppInfo)paramObject);
      if ((paramObservable != null) && (paramObservable.size() > 0))
      {
        paramObservable = (baik)paramObservable.get(0);
        if ((paramObservable.jdField_a_of_type_Int >= 1) && (paramObservable.jdField_a_of_type_Int <= 4)) {
          baik.b(this);
        }
      }
    }
  }
  
  public static void a(MqqHandler paramMqqHandler, Context paramContext)
  {
    paramMqqHandler.removeMessages(1134065);
    if (FriendsStatusUtil.a(paramContext))
    {
      bcst.b(null, "CliOper", "", "", "0X8009EB9", "0X8009EB9", 0, 1, "", "", "", "");
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
      bcst.b(localQQAppInterface, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i1, "0", "0", "", "");
      if (bgnt.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
        break;
      }
      QQToast.a(a(), 1, 2131695415, 0).b(a().getTitleBarHeight());
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
      ((anpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.getRecentUserUin());
      return true;
    }
    return false;
  }
  
  private boolean a(RecentBaseData paramRecentBaseData, boolean paramBoolean, aong paramaong, String paramString)
  {
    int i1 = paramRecentBaseData.getRecentUserType();
    if ((paramString == null) || (paramString.length() == 0) || (paramaong == null))
    {
      if (QLog.isColorLevel())
      {
        paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
        if (paramString != null) {
          break label85;
        }
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (paramaong != null) {
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
    RecentUser localRecentUser = (RecentUser)paramaong.findRecentUser(paramString, i1);
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
        paramaong.saveRecentUser(localRecentUser);
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
        paramaong = paramaong.getRecentList(false).iterator();
        i1 = 0;
        if (paramaong.hasNext())
        {
          if (((RecentUser)paramaong.next()).showUpTime == 0L) {
            break label606;
          }
          i1 += 1;
        }
        for (;;)
        {
          break label218;
          localRecentUser.showUpTime = 0L;
          break;
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + i2, paramRecentBaseData, paramRecentBaseData, 0, 0, "" + i3, "" + i1, "", "");
          do
          {
            if ((7220 == localRecentUser.getType()) && (anhk.aA.equals(paramString))) {
              ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).c(paramBoolean);
            }
            return false;
          } while (i1 != 1008);
          i2 = paramRecentBaseData.mUnreadNum;
          paramRecentBaseData = "0X80064C8";
          if (paramBoolean) {
            paramRecentBaseData = "0X80064C7";
          }
          paramaong = paramaong.getRecentList(false).iterator();
          i1 = 0;
          if (paramaong.hasNext())
          {
            if (((RecentUser)paramaong.next()).showUpTime == 0L) {
              break label603;
            }
            i1 += 1;
          }
          for (;;)
          {
            break label429;
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", localRecentUser.uin, paramRecentBaseData, paramRecentBaseData, 0, 0, "" + i2, "" + i1, "", "");
            if (!"2290230341".equals(paramString)) {
              break;
            }
            if (paramBoolean) {}
            for (paramRecentBaseData = "0X80090E6";; paramRecentBaseData = "0X800915B")
            {
              if (paramBoolean) {
                bcsq.a(4);
              }
              bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramRecentBaseData, paramRecentBaseData, 0, 0, "", "", "", "");
              break;
            }
          }
        }
      }
    }
  }
  
  private void aA()
  {
    try
    {
      if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
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
    if (this.jdField_a_of_type_Awdj != null) {
      this.jdField_a_of_type_Awdj.a();
    }
  }
  
  private void ab()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onResume();
    }
  }
  
  private void ac()
  {
    if (this.jdField_a_of_type_Alfl != null) {
      this.jdField_a_of_type_Alfl.d();
    }
  }
  
  private void ad()
  {
    if (this.jdField_a_of_type_Wui != null) {
      this.jdField_a_of_type_Wui.k();
    }
  }
  
  private void ae()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent = null;
    }
  }
  
  private void af()
  {
    if ((jdField_b_of_type_Long == -1L) && (SplashActivity.jdField_a_of_type_Boolean))
    {
      jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      SosoInterface.a(jdField_b_of_type_Long);
    }
  }
  
  private void ag()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new Conversation.25(this), 500L);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1070, 3000L);
    ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    pha.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ak();
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1053)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1053, 500L);
    }
    alcv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void ah()
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
  
  private void ai()
  {
    Object localObject = this.jdField_a_of_type_Bhkg;
    if (localObject != null)
    {
      bhkf localbhkf = ((bhkg)localObject).a();
      if (localbhkf != null)
      {
        a((bhkg)localObject, localbhkf);
        if (a((bhkg)localObject, localbhkf))
        {
          localObject = a();
          if ((localObject instanceof SplashActivity)) {
            ((SplashActivity)localObject).c();
          }
        }
      }
    }
  }
  
  private void aj()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        apsl localapsl = (apsl)localIterator.next();
        if (localapsl != null) {
          if (this.v)
          {
            localapsl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
            localapsl.jdField_c_of_type_Boolean = true;
            localapsl.c();
          }
          else
          {
            localapsl.d();
          }
        }
      }
      this.v = false;
    }
  }
  
  private void ak()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null) {
      this.jdField_c_of_type_JavaLangRunnable = new Conversation.26(this);
    }
    ThreadManagerV2.excute(this.jdField_c_of_type_JavaLangRunnable, 32, null, true);
  }
  
  private void al()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (FrameHelperActivity.b()) {
        FrameHelperActivity.s();
      }
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Azav.jdField_d_of_type_Int != -1) && (this.jdField_a_of_type_Azav.jdField_d_of_type_Int != 1))
      {
        this.jdField_a_of_type_Azav.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
        this.jdField_a_of_type_Azav.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Azav.d();
    }
    for (;;)
    {
      if (this.t) {
        this.t = false;
      }
      return;
      this.jdField_a_of_type_Azav.e();
    }
  }
  
  private void am()
  {
    int i2 = 2;
    akyh localakyh;
    if (this.jdField_a_of_type_Akyh != null)
    {
      boolean bool = awhd.a().d();
      localakyh = this.jdField_a_of_type_Akyh;
      if (!bool) {
        break label134;
      }
      i1 = 2;
      localakyh.a(10, i1);
      awhd.a().b(bool);
      this.jdField_a_of_type_Akyh.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == 0) {
        break label139;
      }
      i1 = 1;
      label65:
      localakyh = this.jdField_a_of_type_Akyh;
      if (i1 == 0) {
        break label144;
      }
      i1 = 2;
      label77:
      localakyh.a(40, i1);
      bool = atmc.a().a();
      localakyh = this.jdField_a_of_type_Akyh;
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
      localakyh.a(41, i1);
      if (this.jdField_a_of_type_Akyh != null) {
        this.jdField_a_of_type_Akyh.g();
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
  
  private void an()
  {
    if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(true))) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidViewView == null);
      localObject = this.jdField_a_of_type_Albc.getItem(0);
    } while (!(localObject instanceof RecentUserBaseData));
    Object localObject = (RecentUserBaseData)localObject;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    boolean bool;
    label101:
    int i1;
    if ((((RecentUserBaseData)localObject).mUser.getType() == 1) && (!axbp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)((RecentUserBaseData)localObject).mUser)))
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
      i1 = 2130850320;
      label163:
      if (!bool) {
        break label229;
      }
    }
    label220:
    label222:
    label229:
    for (int i2 = 2130850331;; i2 = 2130850330)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(i1);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366102).setBackgroundResource(i2);
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
      i1 = 2130850319;
      break label163;
    }
  }
  
  private void ao()
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
      if ((bdjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (bdjg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Albc != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          label73:
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition())
          {
            Object localObject = this.jdField_a_of_type_Albc.getItem(i1);
            if ((!(localObject instanceof RecentItemTencentDocsAssistantData)) || (((RecentItemTencentDocsAssistantData)localObject).getUnreadNum() <= 0)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!nzz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            break label170;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess call");
          }
          if (this.jdField_c_of_type_Aval == null) {
            break;
          }
          this.jdField_c_of_type_Aval.a();
          return;
          i1 += 1;
          break label73;
        }
      }
    }
  }
  
  private void ap()
  {
    if (this.jdField_a_of_type_Alfl != null) {
      this.jdField_a_of_type_Alfl.b();
    }
  }
  
  private void aq()
  {
    a(new Conversation.28(this));
  }
  
  private void ar()
  {
    awhv.a().k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = tue.a();
    if (localObject != null) {
      ((tue)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    localObject = twi.a();
    if (localObject != null) {
      ((twi)localObject).j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bftr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = (bfuk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
    if (localObject != null) {
      ((bfuk)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      localObject = (oda)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      if (localObject != null) {
        ((oda)localObject).e();
      }
      localObject = (avhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
      if (localObject != null) {
        ((avhx)localObject).a(true);
      }
      localObject = (annl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255);
      if (localObject != null) {
        ((annl)localObject).a();
      }
      aoen.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
      localObject = (askk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(292);
      if (localObject != null) {
        ((askk)localObject).c();
      }
      localObject = (wfp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
      ((wfp)localObject).a(1, ((wfp)localObject).a(this.jdField_a_of_type_JavaUtilList));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
      }
    }
  }
  
  private void as()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "updateMayKnowOrTroopRecommend");
    }
    anpk localanpk = (anpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if (localanpk.c())
    {
      localanpk.c();
      return;
    }
    this.p = localanpk.d();
    ArrayList localArrayList = localanpk.c();
    if ((this.p) && (localArrayList != null) && (localArrayList.size() > 0))
    {
      localanpk.d();
      return;
    }
    localanpk.e();
    this.p = false;
  }
  
  private void at()
  {
    this.jdField_a_of_type_Asyw = new adzl(this);
  }
  
  private void au()
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
    while (i1 >= this.jdField_a_of_type_Albc.getCount())
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
      i2 = 0;
      break;
    }
    Object localObject = this.jdField_a_of_type_Albc.getItem(i1);
    if ((localObject != null) && ((localObject instanceof RecentBaseData)))
    {
      localObject = (RecentBaseData)localObject;
      if (!(localObject instanceof RecentItemImaxADData)) {}
    }
    for (;;)
    {
      i3 += 1;
      break;
      this.jdField_a_of_type_Albc.a().a(((RecentBaseData)localObject).getRecentUserType(), ((RecentBaseData)localObject).getRecentUserUin(), false);
      i1 += i2;
    }
  }
  
  private void av()
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfAlaq[0] = new aeaa(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfAlaq[1] = new ajvo();
  }
  
  private void aw()
  {
    if ((this.w) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      ThreadManager.post(new Conversation.54(this), 5, null, true);
    }
  }
  
  private void ax()
  {
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_Alcp != null))
    {
      this.jdField_a_of_type_Alcp.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1048, 0, 0).sendToTarget();
    }
  }
  
  private void ay()
  {
    if (!this.w) {
      break label7;
    }
    label7:
    while (!this.jdField_a_of_type_Akyh.b(22)) {
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
      ThreadManager.post(new Conversation.55(this, this.jdField_a_of_type_Akyh.a(22, 2131362225)), 5, null, false);
      return;
    }
  }
  
  private void az()
  {
    try
    {
      if (this.jdField_a_of_type_Biau == null)
      {
        this.jdField_a_of_type_Biau = new biau(a(), a().getTitleBarHeight());
        this.jdField_a_of_type_Biau.c(2131694150);
        this.jdField_a_of_type_Biau.c(false);
        this.jdField_a_of_type_Biau.setOnDismissListener(new aeag(this));
      }
      this.jdField_a_of_type_Biau.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
    ApolloSurfaceView localApolloSurfaceView = ampj.a();
    if (localApolloSurfaceView != null) {
      localApolloSurfaceView.runRenderTask(new Conversation.5(this, localApolloSurfaceView, paramInt1, paramInt2, paramIntent));
    }
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    AbsStructMsg localAbsStructMsg;
    if ((paramIntent != null) && (paramInt == -1))
    {
      localAbsStructMsg = bcwd.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg != null) {}
    }
    else
    {
      return;
    }
    String str = paramIntent.getStringExtra("uin");
    paramInt = paramIntent.getIntExtra("uintype", -1);
    int i1 = paramIntent.getIntExtra("cmshow_game_id", -1);
    bgsc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramInt, localAbsStructMsg, null);
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
      if (anjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) >= 5)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((anjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (anjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog = new UpgradeTipsDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.setOnDismissListener(new adyw(this));
  }
  
  private void b(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {}
    for (;;)
    {
      return;
      if (alxx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        alxx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      J();
      List localList1 = albs.a().jdField_a_of_type_JavaUtilList;
      List localList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().getRecentList(false);
      this.jdField_a_of_type_Alao.a(localList2);
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
        str = albs.a(localRecentUser.uin, localRecentUser.getType());
        localRecentBaseData = albs.a().a(str);
        if (localRecentBaseData != null) {
          break label202;
        }
        localRecentBaseData = alan.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
        paramMessage = localRecentBaseData;
        if (localRecentBaseData != null)
        {
          albs.a().a(localRecentBaseData, str);
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
          if (!this.jdField_b_of_type_JavaUtilList.contains(albs.a(localRecentUser.uin, -2147483648))) {}
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
        Collections.sort(localList1, this.jdField_a_of_type_Alao);
        d(localList1);
        t();
        paramMessage = new ArrayList(localList1);
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
        a(localList1);
        if (this.jdField_a_of_type_Akyh != null) {
          this.jdField_a_of_type_Akyh.i();
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
        bctj.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - paramLong, localList1.size(), paramMessage, "");
        bgso.a("Conversation_Refresh_part", System.currentTimeMillis() - paramLong);
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
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", paramRecentBaseData, paramRecentBaseData, 0, 0, paramRecentUser.uin + "", "" + l1, "" + i1, "" + paramInt);
        label210:
        do
        {
          return;
        } while (paramRecentUser.getType() != 6004);
        if (paramInt > 0) {}
        for (paramInt = 1;; paramInt = 2)
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090CC", "0X80090CC", paramInt, 0, "", "", "", "");
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
      if ((paramObject.length == 2) && (anhk.x.equals(paramObject[0])) && (paramObject[1] != null))
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
      this.jdField_a_of_type_Albc.a(localRecentBaseData);
    }
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    if ((paramObservable instanceof azwe))
    {
      if ((paramObject instanceof Boolean))
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        if ((!this.jdField_e_of_type_Boolean) && (bool))
        {
          paramObservable = null;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            paramObservable = (azwe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
          }
          if (paramObservable != null) {
            paramObservable.a(false);
          }
        }
      }
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Akyh != null)) {
        this.jdField_a_of_type_Akyh.j();
      }
    }
  }
  
  private boolean b(RecentBaseData paramRecentBaseData, boolean paramBoolean, aong paramaong, String paramString)
  {
    boolean bool = false;
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.getRecentUserUin());
    int i1;
    if (!TextUtils.isEmpty(str))
    {
      paramaong = (anie)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      if (paramBoolean) {}
      for (i1 = 0; !paramaong.a(str, i1); i1 = 1) {
        return true;
      }
      paramaong = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
      if (paramaong != null) {}
      switch (paramaong.troopmask)
      {
      case 2: 
      case 3: 
      default: 
        i1 = 0;
        label127:
        paramaong = new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
        paramString = paramRecentBaseData.getRecentUserUin();
        if (paramBoolean)
        {
          paramRecentBaseData = "0";
          label177:
          paramaong.a(new String[] { paramString, String.valueOf(i1), paramRecentBaseData }).a();
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
      if ((paramString == null) || (paramString.length() == 0) || (paramaong == null))
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
          if (paramaong == null) {
            paramBoolean = true;
          }
          QLog.d("Q.recent", 2, paramBoolean);
          return true;
        }
      }
      localObject = (RecentUser)paramaong.findRecentUser(paramString, i1);
      paramRecentBaseData = (RecentBaseData)localObject;
      if (localObject == null) {
        paramRecentBaseData = new RecentUser(paramString, i1);
      }
    } while (!axbp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData));
    if (paramBoolean) {}
    for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
    {
      paramaong.saveRecentUser(paramRecentBaseData);
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
          a(1073, 30000L, true);
          if (this.jdField_a_of_type_Aeav != null) {
            this.jdField_a_of_type_Aeav.f();
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
        this.jdField_a_of_type_Akyh.a();
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
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
    ((annl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).b();
    awhv.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    J();
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (alxx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      alxx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        Object localObject = paramMessage.getRecentList(bool);
        this.jdField_a_of_type_Alao.a((List)localObject);
        paramMessage = albs.a().jdField_a_of_type_JavaUtilList;
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        BaseActivity localBaseActivity = a();
        int i1;
        if (localObject != null)
        {
          i1 = ((List)localObject).size();
          alan.a((List)localObject, localQQAppInterface, localBaseActivity, paramMessage, i1);
        }
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_Alao);
          d(paramMessage);
          t();
          localObject = new ArrayList(paramMessage);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, localObject).sendToTarget();
          a(paramMessage);
          if (this.jdField_a_of_type_Akyh != null) {}
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          localObject = new HashMap();
          ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
          bctj.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - paramLong, paramMessage.size(), (HashMap)localObject, "");
          localObject = (wfp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
          ((wfp)localObject).b(3, ((wfp)localObject).a(paramMessage));
          bgso.a("Conversation_Refresh_global", System.currentTimeMillis() - paramLong);
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
      anpk localanpk = (anpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      if ((localanpk.jdField_a_of_type_Boolean) && (localanpk.a(paramList))) {
        localanpk.jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Albc.a(paramList);
    if (this.D)
    {
      this.D = false;
      if (this.E)
      {
        if (!this.jdField_f_of_type_Boolean) {
          break label122;
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addOnLayoutChangeListener(new adys(this));
      }
    }
    for (;;)
    {
      this.E = false;
      if (paramList != null) {
        albs.a().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      }
      this.jdField_a_of_type_Albc.a(0);
      return;
      label122:
      aA();
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
    if ((this.jdField_f_of_type_Boolean) && (nve.a(localMessageRecord)))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      m(false);
    }
    if ((this.jdField_f_of_type_Boolean) && (avfw.a(localMessageRecord))) {
      avfu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Albc, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
    }
    if ((this.jdField_f_of_type_Boolean) && (vhk.a(localMessageRecord.istroop))) {
      p();
    }
    int i4 = 10;
    Long localLong = Long.valueOf(0L);
    int i1;
    int i2;
    if ((localMessageRecord.isSendFromLocal()) && ((!this.jdField_f_of_type_Boolean) || (TextUtils.equals(localMessageRecord.frienduin, anhk.az)) || (TextUtils.equals(localMessageRecord.frienduin, anhk.aA))))
    {
      i1 = 2;
      i2 = 9;
      paramObject = albs.a(localMessageRecord.frienduin, localMessageRecord.istroop);
    }
    for (;;)
    {
      if (localMessageRecord.isSend()) {
        bgoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
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
        if (aldk.jdField_b_of_type_Boolean)
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
          if (((((RecentUserBaseData)localObject).getRecentUserType() == 1) && (!axbp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)((RecentUserBaseData)localObject).mUser)) && (localTroopManager.b(((RecentUserBaseData)localObject).getRecentUserUin()))) || (((RecentUserBaseData)localObject).mUser.showUpTime != 0L)) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(((RecentUserBaseData)localObject).getRecentUserType()).append("-").append(bgsp.e(((RecentUserBaseData)localObject).getRecentUserUin())).append("-").append(i1).append(" , ");
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
  
  private boolean e()
  {
    if (!bgsg.e(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().getRecentList(false);
      if ((localObject2 == null) || (((List)localObject2).size() == 0))
      {
        bgsg.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
        if (bgsg.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).contains(localObject2)) {
          localArrayList.remove(localObject2);
        }
      }
      if (localArrayList.size() == 0)
      {
        bgsg.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        return true;
      }
      ((anie)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(localArrayList, 0);
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
    if (this.jdField_a_of_type_Wui == null) {
      this.jdField_a_of_type_Wui = new wui(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, (BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368031));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)) {
      this.jdField_a_of_type_Wui.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
    }
    this.jdField_a_of_type_Wui.jdField_f_of_type_Boolean = this.w;
    this.jdField_a_of_type_Wui.b();
    for (this.s = false;; this.s = false)
    {
      this.n = paramBoolean;
      return;
      label149:
      if (this.jdField_a_of_type_Wui != null) {
        this.jdField_a_of_type_Wui.c();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anxg, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anif, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anjq, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anqd, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anxo, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aniz, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ankx, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvp, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayes);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anke);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Annz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Wfi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anub);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aezu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aypl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asgf);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvm);
    bdch.a(this.jdField_a_of_type_Bdci);
    Object localObject2 = (baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject2 != null) {
      ((baif)localObject2).addObserver(this);
    }
    if (this.jdField_a_of_type_Asyw == null) {
      at();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Asyw);
    if (this.jdField_a_of_type_Aeaq == null) {
      this.jdField_a_of_type_Aeaq = new aeaq(this);
    }
    this.jdField_a_of_type_Aeaq.addFilter(new Class[] { bdtd.class, bdth.class, C2CPttDownloadProcessor.class, bdtl.class, bdvb.class, GroupPttDownloadProcessor.class, bdun.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aeaq);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anmu, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
        localObject2 = (azwe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (localObject2 != null) {
          ((azwe)localObject2).addObserver(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Lmo);
        mue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuy);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anty);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoqm);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver);
        if (this.jdField_a_of_type_Awdj != null) {
          this.jdField_a_of_type_Awdj.b();
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
    if ((!paramBoolean) && (this.jdField_a_of_type_Aval != null)) {
      this.jdField_a_of_type_Aval.d();
    }
    m(true);
    ao();
    r();
  }
  
  private void l(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_k_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Aeav != null) {
        this.jdField_a_of_type_Aeav.a(false);
      }
      aeau localaeau = this.jdField_a_of_type_Aeau;
      if (localaeau != null) {
        localaeau.a(false);
      }
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if ((!tyg.jdField_k_of_type_Boolean) || ((!paramBoolean) && (nzz.a().jdField_a_of_type_Boolean))) {}
    label151:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Albc != null))
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
        if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
          if (!(this.jdField_a_of_type_Albc.getItem(i1) instanceof RecentItemPublicAccountADFolderData)) {}
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label151;
        }
        if ((this.jdField_a_of_type_Aval != null) && (!this.x))
        {
          this.jdField_a_of_type_Aval.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.x = true;
        }
        nzz.a().jdField_a_of_type_Boolean = true;
        ThreadManager.getSubThreadHandler().postDelayed(new Conversation.27(this), 1000L);
        return;
        i1 += 1;
        break;
      }
    }
  }
  
  private void y()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Albc.c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1025);
    this.jdField_j_of_type_Boolean = true;
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    BaseApplicationImpl.sApplication.onActivityFocusChanged(a(), true);
  }
  
  private void z()
  {
    bgit.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
  }
  
  int a()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Albc.getCount())
    {
      if ((this.jdField_a_of_type_Albc.getItem(i1) instanceof RecentItemMayKnowFriendVerticalListData)) {
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
      } while (aldk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
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
  
  public albc a()
  {
    return this.jdField_a_of_type_Albc;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    bgso.a(null, "Recent_Start");
    bgso.a(null, "Recent_CreateView");
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
        localObject2 = paramLayoutInflater.inflate(2131558969, null);
      }
      bgso.a("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public String a()
  {
    String str = anni.a(2131701398);
    if (this.jdField_d_of_type_Int <= 0) {
      return str;
    }
    if (this.jdField_d_of_type_Int > 99) {
      return str + "(99+)";
    }
    return str + "(" + this.jdField_d_of_type_Int + ")";
  }
  
  public wui a()
  {
    return this.jdField_a_of_type_Wui;
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
      B();
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
      alcp.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
      return;
    case 14005: 
    case 14006: 
      b(paramInt1, paramInt2, paramIntent);
      return;
    }
    H();
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
    aong localaong;
    String str2;
    anmw localanmw;
    if (paramBoolean)
    {
      str1 = "1";
      localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      str2 = paramRecentBaseData.getRecentUserUin();
      localanmw = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((paramInt != 7000) || (anhk.x.equals(str2))) {
        break label125;
      }
      bddy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, paramBoolean);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str1, paramString, "");
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
            a(paramInt, paramRecentBaseData, paramBoolean, str1, localaong);
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
              ((annl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramBoolean);
            }
          }
          if (paramInt != 1) {
            break label194;
          }
        } while (!b(paramRecentBaseData, paramBoolean, localaong, str2));
        return;
        if ((paramInt != 0) || (!localanmw.b(str2))) {
          break label221;
        }
      } while (!a(paramInt, paramBoolean, str2));
      return;
    } while (!a(paramRecentBaseData, paramBoolean, localaong, str2));
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
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_Akyh != null)) {
        this.jdField_a_of_type_Akyh.a(paramRecentUser.uin);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.getType());
      }
    } while ((paramInt & 0x4) == 0);
    aldk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, -1);
    QQToast.a(a(), anni.a(2131701397), 0).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 8) && (paramInt1 != 9)) {
      return;
    }
    a(0, paramInt1, albs.a(paramString, paramInt2));
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    if (!paramBoolean1)
    {
      K();
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
      this.jdField_a_of_type_Akyh.a(9, 0);
    }
    boolean bool1;
    int i1;
    label111:
    boolean bool2;
    if (!paramBoolean1)
    {
      bool1 = true;
      awhd.a().a(bool1);
      localObject1 = this.jdField_a_of_type_Akyh;
      if (!bool1) {
        break label244;
      }
      i1 = 2;
      ((akyh)localObject1).a(1, i1);
      bool2 = awhd.a().d();
      if ((!bool2) || (paramInt != 1134012)) {
        break label352;
      }
      bool2 = false;
    }
    label352:
    for (;;)
    {
      awhd.a().b(bool2);
      localObject1 = this.jdField_a_of_type_Akyh;
      i1 = i2;
      if (bool2) {
        i1 = 2;
      }
      ((akyh)localObject1).a(10, i1);
      this.jdField_a_of_type_Akyh.a(-1, null);
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (apsl)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              ((apsl)localObject2).a(paramBoolean1);
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
        ((StringBuilder)localObject1).append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", isNetSupport = ").append(paramBoolean1).append(", loadingState = ").append(awhd.a().a()).append(", msg = ").append(paramInt);
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
    int i1 = bgig.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    bgig.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i1 + 1);
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
    if ((this.jdField_a_of_type_Alcp != null) && (this.jdField_a_of_type_Alcp.a())) {
      this.jdField_a_of_type_Alcp.b();
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
        paramMessage.append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", initLoadingHandle = ").append(paramBoolean).append(", loadingState = ").append(awhd.a().a()).append(", what = ").append(i1);
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
    if (this.jdField_a_of_type_Albc == null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = this.jdField_a_of_type_Albc.a(paramView);
      if ((localRecentBaseData != null) && ("9970".equals(localRecentBaseData.getRecentUserUin()))) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
      }
    } while ((localRecentBaseData == null) || (!anhk.aB.equals(localRecentBaseData.getRecentUserUin())));
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
    if ((paramString.equals("sp_uin_for_title")) && (i2 == 2131376201))
    {
      x();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "msgtab_list_clk", 2);
      return;
    }
    anpk localanpk = (anpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramString, 102);
    boolean bool = localanpk.a();
    ArrayList localArrayList = localanpk.c();
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
      if (i2 == 2131376443)
      {
        if (!bgnt.g(paramContext))
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131691985), 0).b(a().getTitleBarHeight());
          return;
        }
        paramString = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((!paramString.b(paramView.uin)) && (!paramString.d(paramView.uin)))
        {
          paramString = paramView.getDisplayName(localanpk.a());
          paramContext = AddFriendLogicActivity.a(paramContext, 1, paramView.uin, null, 3045, 25, paramString, null, null, paramContext.getString(2131689550), null);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(25), "", "", "");
          a(paramContext);
        }
        for (;;)
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
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
    bgso.a(null, "AIO_Click_cost");
    bgnv.a(null, "pubAcc_aio_open", "");
    bgjr.a(true);
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
      int i1 = aldk.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData);
      a(paramRecentBaseData, paramView, i1);
      a(i1, paramView);
      if (paramRecentBaseData != null)
      {
        aldi.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramView);
        paramRecentBaseData.clearUnReadNum();
        bkgt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.getRecentUserUin());
        this.jdField_i_of_type_Boolean = true;
      }
      bgso.a("AIO_Click_cost", null);
      return;
      paramView = null;
    }
  }
  
  public void a(View paramView, Object paramObject)
  {
    wfp localwfp = (wfp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
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
      if (paramView.getId() == 2131363688)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
        paramView = new Intent(a(), ForwardRecentActivity.class);
        paramView.putExtra("forward_type", 13);
        a(paramView);
        return;
      }
      if ((paramView.getId() == 2131367097) || (paramView.getId() == 2131367099) || (paramView.getId() == 2131367100) || (paramView.getId() == 2131367101) || (paramView.getId() == 2131367102) || (paramView.getId() == 2131367103) || (paramView.getId() == 2131367104))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = bglf.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, paramView, paramObject, null, true, null, true, true, null, null);
        return;
      }
    } while ((paramView.getId() != 2131369306) || (!localwfp.b(paramObject)));
    localwfp.a(paramView, (RecentItemChatMsgData)paramObject);
  }
  
  public void a(bhkg parambhkg, bhkf parambhkf)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) && (parambhkf != null) && (parambhkf.jdField_d_of_type_Long == 0L) && (parambhkf.jdField_a_of_type_Long != 0L)) {
      parambhkg.a(parambhkf.jdField_a_of_type_Long);
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
        aldi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
        aldk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i1);
        this.jdField_a_of_type_Aear.a(paramString);
      }
    }
    for (;;)
    {
      return;
      localObject = (azwe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
      if ((localObject != null) && (paramRecentBaseData != null)) {}
      try
      {
        ((azwe)localObject).b(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
        if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
          if (paramRecentBaseData.getRecentUserType() == 3000)
          {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
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
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    L();
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = a();
    int i1 = paramRecentBaseData.getRecentUserType();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_Aldj == null)) {
      this.jdField_a_of_type_Aldj = new aldj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (bgjw.a(paramString1, localResources.getString(2131691106)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
      if (!bgjw.a(paramString1, localResources.getString(alcd.a[4]))) {
        break label411;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        aldk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)paramString1.getRecentUser(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
    }
    label411:
    while (!bgjw.a(paramString1, localResources.getString(alcd.a[5])))
    {
      return;
      if (bgjw.a(paramString1, localResources.getString(2131691109)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        break;
      }
      if (bgjw.a(paramString1, localResources.getString(2131692797)))
      {
        a(i1, paramRecentBaseData, paramString2, false);
        if (i1 != 3000) {
          break;
        }
        new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").a();
        break;
      }
      if (bgjw.a(paramString1, localResources.getString(2131692799)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        if (i1 != 3000) {
          break;
        }
        new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").a();
        break;
      }
      if (!bgjw.a(paramString1, localResources.getString(2131693861))) {
        break;
      }
      this.jdField_a_of_type_Alcv.a(a(), paramRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramRecentBaseData.getRecentUserUin(), "0X800991D", "0X800991D", 0, 0, "", "", "", "");
      break;
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramString1 = (RecentUser)((RecentUserBaseData)paramRecentBaseData).getRecentUser();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1.uin, paramString1.getType(), 1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
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
    if (this.jdField_a_of_type_Albc != null) {
      this.jdField_a_of_type_Albc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Akyh.a(22, 0);
    albs.a().a();
    bmvi.a().a();
    if (this.jdField_a_of_type_Aear != null) {
      this.jdField_a_of_type_Aear.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_Azav != null) {
      this.jdField_a_of_type_Azav.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        apsl localapsl = (apsl)localIterator.next();
        if (localapsl != null) {
          localapsl.a(paramLogoutReason);
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
    //   0: invokestatic 489	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 491
    //   9: iconst_2
    //   10: new 493	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 494	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 3405
    //   20: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 576	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 513	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 1205	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 451	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   37: ifnull +21 -> 58
    //   40: aload_0
    //   41: getfield 451	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   44: invokevirtual 3408	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   47: ifge +11 -> 58
    //   50: aload_0
    //   51: getfield 451	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   54: iconst_0
    //   55: invokevirtual 3411	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   58: aload_0
    //   59: iconst_0
    //   60: invokespecial 3413	com/tencent/mobileqq/activity/Conversation:j	(Z)V
    //   63: iload_1
    //   64: ifeq +373 -> 437
    //   67: invokestatic 633	awhd:a	()Lawhd;
    //   70: invokevirtual 3414	awhd:a	()V
    //   73: invokestatic 852	albs:a	()Lalbs;
    //   76: invokevirtual 3392	albs:a	()V
    //   79: invokestatic 3397	bmvi:a	()Lbmvi;
    //   82: invokevirtual 3398	bmvi:a	()V
    //   85: aload_0
    //   86: getfield 2545	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   89: ifeq +22 -> 111
    //   92: aload_0
    //   93: getfield 451	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   96: ifnull +15 -> 111
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 2545	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   104: aload_0
    //   105: getfield 451	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   108: invokevirtual 3417	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   111: aload_0
    //   112: getfield 651	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   115: ifnull +15 -> 130
    //   118: aload_0
    //   119: getfield 651	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   122: invokevirtual 3418	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 651	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   130: aload_0
    //   131: getfield 667	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   134: ifnull +15 -> 149
    //   137: aload_0
    //   138: getfield 667	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   141: invokevirtual 675	android/app/Dialog:dismiss	()V
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield 667	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   149: aload_0
    //   150: getfield 839	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajhw	Lajhw;
    //   153: ifnull +14 -> 167
    //   156: aload_0
    //   157: getfield 839	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Ajhw	Lajhw;
    //   160: aload_0
    //   161: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   164: invokevirtual 3419	ajhw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   167: aload_0
    //   168: getfield 1708	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aldj	Laldj;
    //   171: ifnull +14 -> 185
    //   174: aload_0
    //   175: getfield 1708	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aldj	Laldj;
    //   178: aload_0
    //   179: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: invokevirtual 3420	aldj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   185: aload_0
    //   186: getfield 551	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Albc	Lalbc;
    //   189: ifnull +25 -> 214
    //   192: aload_0
    //   193: getfield 551	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Albc	Lalbc;
    //   196: aload_0
    //   197: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   200: invokevirtual 3421	albc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   203: aload_0
    //   204: iconst_1
    //   205: bipush 10
    //   207: lconst_0
    //   208: invokestatic 2539	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   211: invokevirtual 2648	com/tencent/mobileqq/activity/Conversation:a	(IILjava/lang/Object;)V
    //   214: aload_0
    //   215: getfield 451	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   218: ifnull +11 -> 229
    //   221: aload_0
    //   222: getfield 451	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   225: iconst_0
    //   226: invokevirtual 3424	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   229: aload_0
    //   230: iconst_0
    //   231: invokespecial 1647	com/tencent/mobileqq/activity/Conversation:i	(Z)V
    //   234: aload_0
    //   235: getfield 1979	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Wui	Lwui;
    //   238: ifnull +14 -> 252
    //   241: aload_0
    //   242: getfield 1979	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Wui	Lwui;
    //   245: aload_0
    //   246: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   249: invokevirtual 3425	wui:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   252: aload_0
    //   253: getfield 1036	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   256: ifnull +16 -> 272
    //   259: aload_0
    //   260: getfield 1036	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   263: aload_0
    //   264: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   267: invokeinterface 3428 2 0
    //   272: aload_0
    //   273: getfield 455	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bmsi	Lbmsi;
    //   276: ifnull +14 -> 290
    //   279: aload_0
    //   280: getfield 455	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bmsi	Lbmsi;
    //   283: aload_0
    //   284: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   287: invokevirtual 3429	bmsi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   290: ldc_w 491
    //   293: ldc_w 3431
    //   296: aload_0
    //   297: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   300: getfield 1062	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   303: invokevirtual 1065	com/tencent/mobileqq/app/automator/Automator:b	()Z
    //   306: invokestatic 1108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   309: invokestatic 3436	yqp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   312: aload_0
    //   313: sipush 1055
    //   316: lconst_0
    //   317: iconst_0
    //   318: invokevirtual 664	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   321: aload_0
    //   322: getfield 847	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Akyh	Lakyh;
    //   325: ifnull +10 -> 335
    //   328: aload_0
    //   329: getfield 847	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Akyh	Lakyh;
    //   332: invokevirtual 3437	akyh:e	()V
    //   335: aload_0
    //   336: getfield 182	com/tencent/mobileqq/activity/Conversation:jdField_j_of_type_Boolean	Z
    //   339: ifeq +13 -> 352
    //   342: aload_0
    //   343: getfield 1117	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   346: bipush 12
    //   348: invokevirtual 1121	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   351: pop
    //   352: aload_0
    //   353: getfield 694	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   356: getfield 923	com/tencent/mobileqq/app/FrameHelperActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   359: iconst_4
    //   360: invokevirtual 2532	android/os/Handler:sendEmptyMessage	(I)Z
    //   363: pop
    //   364: aload_0
    //   365: sipush 1035
    //   368: ldc2_w 2652
    //   371: iconst_0
    //   372: invokevirtual 664	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   375: aload_0
    //   376: sipush 1010
    //   379: ldc2_w 2652
    //   382: iconst_1
    //   383: invokevirtual 664	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   386: aload_0
    //   387: sipush 1063
    //   390: lconst_0
    //   391: iconst_1
    //   392: aconst_null
    //   393: invokevirtual 1144	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   396: aload_0
    //   397: sipush 1064
    //   400: ldc2_w 2652
    //   403: iconst_1
    //   404: ldc_w 3439
    //   407: invokevirtual 1144	com/tencent/mobileqq/activity/Conversation:a	(IJZLjava/lang/String;)V
    //   410: aload_0
    //   411: aload_0
    //   412: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   415: bipush 76
    //   417: invokevirtual 1014	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   420: checkcast 2029	bhkg
    //   423: putfield 194	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Bhkg	Lbhkg;
    //   426: aload_0
    //   427: invokespecial 3441	com/tencent/mobileqq/activity/Conversation:ax	()V
    //   430: aload_0
    //   431: ldc_w 3443
    //   434: invokespecial 952	com/tencent/mobileqq/activity/Conversation:a	(Ljava/lang/String;)V
    //   437: aload_0
    //   438: sipush 10001
    //   441: ldc2_w 3444
    //   444: iconst_0
    //   445: invokevirtual 664	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   448: aload_0
    //   449: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   452: invokevirtual 2782	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   455: ifne +15 -> 470
    //   458: aload_0
    //   459: getfield 182	com/tencent/mobileqq/activity/Conversation:jdField_j_of_type_Boolean	Z
    //   462: ifeq +8 -> 470
    //   465: aload_0
    //   466: lconst_0
    //   467: invokevirtual 1805	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   470: aload_0
    //   471: ldc_w 3446
    //   474: ldc2_w 3447
    //   477: iconst_0
    //   478: invokevirtual 664	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   481: invokestatic 2147	nzz:a	()Lnzz;
    //   484: aload_0
    //   485: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   488: invokevirtual 1215	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   491: invokevirtual 3449	nzz:a	(Ljava/lang/String;)V
    //   494: getstatic 3452	awnr:jdField_g_of_type_Boolean	Z
    //   497: ifeq +13 -> 510
    //   500: invokestatic 3455	awnr:a	()Lawnr;
    //   503: aload_0
    //   504: getfield 460	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   507: invokevirtual 3456	awnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   510: aload_0
    //   511: invokespecial 2813	com/tencent/mobileqq/activity/Conversation:P	()V
    //   514: return
    //   515: astore_2
    //   516: aload_0
    //   517: aconst_null
    //   518: putfield 651	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   521: goto -391 -> 130
    //   524: astore_2
    //   525: aload_0
    //   526: aconst_null
    //   527: putfield 651	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   530: aload_2
    //   531: athrow
    //   532: astore_2
    //   533: aload_0
    //   534: aconst_null
    //   535: putfield 667	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   538: goto -389 -> 149
    //   541: astore_2
    //   542: aload_0
    //   543: aconst_null
    //   544: putfield 667	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   547: aload_2
    //   548: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	549	0	this	Conversation
    //   0	549	1	paramBoolean	boolean
    //   515	1	2	localException1	Exception
    //   524	7	2	localObject1	Object
    //   532	1	2	localException2	Exception
    //   541	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   118	125	515	java/lang/Exception
    //   118	125	524	finally
    //   137	144	532	java/lang/Exception
    //   137	144	541	finally
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
  
  public boolean a(bhkg parambhkg, bhkf parambhkf)
  {
    if ((parambhkf == null) || (parambhkg == null)) {}
    do
    {
      return false;
      if (parambhkf.jdField_d_of_type_Long == 3L) {
        parambhkg.a(4L, parambhkf.jdField_a_of_type_Long);
      }
    } while ((parambhkf == null) || (parambhkf.jdField_d_of_type_Long != 2L) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) || (!this.w));
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
      bgso.a("Conversation_PullToRefresh_start", 0L);
      n();
      ThreadManager.getSubThreadHandler().post(new Conversation.11(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      }
      if (((wsm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
      {
        ((wsl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a().a(2);
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
    if ((!ThemeUtil.isDefaultTheme()) && (this.B) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850319);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366102).setBackgroundResource(2130850330);
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
      bcnj.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Azav.k();
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        apsl localapsl = (apsl)localIterator.next();
        if (localapsl != null) {
          localapsl.i();
        }
      }
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850087);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166983));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166983));
    }
    if (this.jdField_a_of_type_Alfl != null) {
      this.jdField_a_of_type_Alfl.e();
    }
    if (this.jdField_a_of_type_Wui != null) {
      this.jdField_a_of_type_Wui.i();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onPostThemeChanged();
    }
    if (this.jdField_a_of_type_Akyh != null) {
      this.jdField_a_of_type_Akyh.a(-1, null);
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
    bfus localbfus = (bfus)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
    if (localbfus != null) {
      localbfus.a(paramLong);
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
        az();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    if (this.jdField_a_of_type_Aeav != null) {
      this.jdField_a_of_type_Aeav.d();
    }
  }
  
  public View c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_c_of_type_AndroidViewView;
  }
  
  public void c()
  {
    Y();
    s();
    if (this.jdField_a_of_type_Akyh != null) {
      this.jdField_a_of_type_Akyh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Azav != null) {
      this.jdField_a_of_type_Azav.c();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        apsl localapsl = (apsl)((Iterator)localObject).next();
        if (localapsl != null) {
          localapsl.b();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134065);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134061);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134068);
    bcsq.a();
    if (this.jdField_a_of_type_Alcp != null) {
      this.jdField_a_of_type_Alcp.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Alcv != null) {
      this.jdField_a_of_type_Alcv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_Alao != null) {
      this.jdField_a_of_type_Alao.a(a());
    }
    if (this.jdField_a_of_type_Awdj != null) {
      this.jdField_a_of_type_Awdj.d();
    }
    if (this.jdField_a_of_type_Aeav != null) {
      this.jdField_a_of_type_Aeav.c();
    }
    Object localObject = this.jdField_a_of_type_Aeau;
    if (localObject != null) {
      ((aeau)localObject).a();
    }
    if (this.jdField_a_of_type_Alfl != null) {
      this.jdField_a_of_type_Alfl.a(a());
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
        Drawable localDrawable = a().getResources().getDrawable(2130839404);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(afur.a(5.0F, a()));
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
    i();
  }
  
  public void d(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_Akyh.a(1);
    boolean bool2 = this.jdField_a_of_type_Akyh.a(10);
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
    switch (awhd.a().a())
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
    bgso.a(null, "Recent_OnCreate");
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a(a());
    this.jdField_a_of_type_Aear = new aear(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bgli(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_MqqOsMqqHandler = new bgli(ThreadManager.getRecentThreadLooper(), this);
    this.jdField_a_of_type_Alcv = new alcv(this.jdField_a_of_type_MqqOsMqqHandler, a());
    this.jdField_a_of_type_Aeav = new aeav(this);
    N();
    M();
    a(false);
    this.jdField_a_of_type_Alao = new alao(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bgso.a("Recent_OnCreate", null);
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
    anpk.jdField_e_of_type_Boolean = true;
    af();
    super.e(paramBoolean);
    if (AppSetting.jdField_c_of_type_Boolean) {
      a().setTitle(a(2131693457));
    }
    Z();
    TimeManager.getInstance().resumeCountDownTimer();
    if (this.jdField_a_of_type_Ajhw != null) {
      this.jdField_a_of_type_Ajhw.a();
    }
    if (AppSetting.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(true);
    }
    try
    {
      a().getWindow().setSoftInputMode(32);
      appj.a().c();
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_j_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Long != 1000L) {
          this.jdField_a_of_type_Long = 1000L;
        }
        if (!this.jdField_k_of_type_Boolean) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
        }
        if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_Albc != null)) {
          this.jdField_a_of_type_Albc.notifyDataSetChanged();
        }
        a(0L);
        j();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
        ah();
        ai();
        am();
        aw();
        ae();
        al();
        aj();
        ag();
        e();
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
        a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
        avfu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Albc, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
        nzz.a().jdField_a_of_type_Boolean = false;
        aa();
        k(paramBoolean);
        ApngImage.playByTag(2);
        ad();
        an();
        ac();
        ab();
        bdoq.a(null);
        l(paramBoolean);
        aini.a(a(), paramBoolean);
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
    if (this.jdField_a_of_type_Aeav != null) {
      this.jdField_a_of_type_Aeav.c(paramBoolean);
    }
  }
  
  public void g()
  {
    QLog.d("Q.recent", 2, "onPause...");
    ApngImage.pauseByTag(2);
    super.g();
    this.jdField_a_of_type_Azav.g();
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
        localObject2 = (apsl)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((apsl)localObject2).e();
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
    if ((!this.C) && (!this.D) && (alcu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      if (System.currentTimeMillis() - this.jdField_i_of_type_Long > 5000L)
      {
        localObject1 = this.jdField_a_of_type_Albc.a();
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
      if (this.jdField_a_of_type_Alcp != null) {
        this.jdField_a_of_type_Alcp.l();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = false;
      pha.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_b_of_type_Aval != null) {
        this.jdField_b_of_type_Aval.d();
      }
      if (this.jdField_c_of_type_Aval != null) {
        this.jdField_c_of_type_Aval.d();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
      bcsq.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Wui != null) {
        this.jdField_a_of_type_Wui.l();
      }
      pmy.k();
      aoqq.a();
      if (this.jdField_a_of_type_Aeav == null) {
        break;
      }
      this.jdField_a_of_type_Aeav.e();
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
      if (this.jdField_a_of_type_Wui != null) {
        this.jdField_a_of_type_Wui.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initLater(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
    }
  }
  
  public boolean g_()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void h()
  {
    super.h();
    if ((this.jdField_a_of_type_Alcp != null) && (this.jdField_a_of_type_Alcp.a())) {
      this.jdField_a_of_type_Alcp.b();
    }
    if (this.jdField_a_of_type_Aval != null) {
      this.jdField_a_of_type_Aval.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        apsl localapsl = (apsl)localIterator.next();
        if (localapsl != null) {
          localapsl.f();
        }
      }
    }
    if (this.jdField_a_of_type_Awdj != null) {
      this.jdField_a_of_type_Awdj.e();
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
    bkpj.a("conv.handleMessage");
    long l1 = System.currentTimeMillis();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      bkpj.a();
      return true;
      c(paramMessage, l1);
      continue;
      b(paramMessage, l1);
      continue;
      a(paramMessage, l1);
      continue;
      c(paramMessage);
      continue;
      ar();
      continue;
      j(true);
      continue;
      aq();
      continue;
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1044, 0, 0, null).sendToTarget();
      continue;
      paramMessage = (wfp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
      paramMessage.a(2, paramMessage.a(albs.a().jdField_a_of_type_JavaUtilList));
      continue;
      ap();
    }
  }
  
  public void i()
  {
    if (SystemClock.uptimeMillis() - wui.jdField_b_of_type_Long > 500L)
    {
      I();
      if ((this.w) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof HongBaoListView)) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mEnableStory) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mForStory))
      {
        if (this.jdField_a_of_type_Wui != null) {
          this.jdField_a_of_type_Wui.h();
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
  
  protected void j()
  {
    if (this.jdField_a_of_type_Albc == null)
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
    if (this.jdField_a_of_type_Alcv != null) {
      this.jdField_a_of_type_Alcv.a();
    }
    if (this.jdField_a_of_type_Bkho != null)
    {
      this.jdField_a_of_type_Bkho.a(null);
      this.jdField_a_of_type_Bkho = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.a(null);
    }
    this.p = false;
    TimeManager.getInstance().stopCountDownTimer();
    Y();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
    if (this.jdField_a_of_type_Aear != null) {
      this.jdField_a_of_type_Aear.a();
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Ajhw != null) {
      this.jdField_a_of_type_Ajhw.b();
    }
    if (this.jdField_a_of_type_Albc != null) {
      this.jdField_a_of_type_Albc.b();
    }
    if (this.jdField_a_of_type_Wui != null) {
      this.jdField_a_of_type_Wui.c();
    }
    if (this.jdField_a_of_type_Akyh != null) {
      this.jdField_a_of_type_Akyh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_Alfl != null) {
      this.jdField_a_of_type_Alfl.h();
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
        ((aong)localObject).b();
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
    awhv.a();
    awhx.a();
    twi.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        apsl localapsl = (apsl)((Iterator)localObject).next();
        if (localapsl != null) {
          localapsl.g();
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Awdj != null)
    {
      this.jdField_a_of_type_Awdj.f();
      this.jdField_a_of_type_Awdj = null;
    }
    if (this.jdField_a_of_type_Bmsi != null)
    {
      this.jdField_a_of_type_Bmsi.b();
      this.jdField_a_of_type_Bmsi = null;
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
      K();
      d(true);
      boolean bool1 = this.jdField_a_of_type_Akyh.a(1);
      boolean bool2 = this.jdField_a_of_type_Akyh.a(10);
      if ((bool1) || (bool2)) {
        c(800L);
      }
    }
    else
    {
      return;
    }
    if (bmqa.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      pmy.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
    c(60000L);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void o()
  {
    this.jdField_f_of_type_Boolean = true;
    if ((!this.jdField_j_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      y();
      bgso.a("Recent_Start", null);
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
      this.jdField_a_of_type_Alcp.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getWidth() - a().getDimensionPixelSize(2131298724) - a().getDimensionPixelSize(2131298725), a().getDimensionPixelSize(2131298726));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity instanceof MainFragment))) {
        ((MainFragment)this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).n();
      }
      if ((ampj.c() <= 0) || (ampj.b() <= 0)) {
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
        VipUtils.a(ampj.a(), "cmshow", "Apollo", "plusentrance", 0, 0, new String[] { "" + i1, "" + i2 });
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
        yqu.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
        ax();
        abev.e();
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
        au();
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
      aobo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if (this.jdField_a_of_type_Wui != null) {
        this.jdField_a_of_type_Wui.b(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1)) {
        break label419;
      }
      if (this.jdField_a_of_type_Albc == null) {
        break label254;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i4 = this.jdField_a_of_type_Albc.getCount();
      this.jdField_b_of_type_Int = Math.max(i1, -1);
      if ((i1 < 0) || (i1 >= i4) || (i1 > i2 - i3)) {
        break label242;
      }
      localObject = this.jdField_a_of_type_Albc.getItem(i1);
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
    this.jdField_a_of_type_Albc.a(false);
    bgjr.a(false);
    label254:
    if (paramInt == 0)
    {
      au();
      adcd.a().a("list_conv", false);
      ThreadRegulator.a().b(2);
      a(paramAbsListView);
      avfu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Albc, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      m(false);
      ao();
      ay();
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
      if (this.jdField_a_of_type_Akyh != null) {
        this.jdField_a_of_type_Akyh.b(this.G);
      }
      pnk.a(paramAbsListView, paramInt);
      aoqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAbsListView, paramInt);
      return;
      label419:
      if (this.jdField_a_of_type_Albc == null) {
        break;
      }
      this.jdField_a_of_type_Albc.a(true);
      bgjr.a(true);
      break;
      adcd.a().a("list_conv");
      ThreadRegulator.a().a(2);
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Aeav != null) {
      this.jdField_a_of_type_Aeav.b(false);
    }
    aeau localaeau = this.jdField_a_of_type_Aeau;
    if (localaeau != null) {
      localaeau.b(false);
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559646, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        if (this.jdField_a_of_type_Alcp == null)
        {
          this.jdField_a_of_type_Alcp = new alcp(localBaseActivity);
          this.jdField_a_of_type_Alcp.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new adyz(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_Bhkg = ((bhkg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76));
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
        ((HashMap)localObject2).put("device_mode", bgln.d());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        bctj localbctj = bctj.a(BaseApplicationImpl.getContext());
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label378;
        }
        localbctj.a(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
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
      this.jdField_a_of_type_Alcp = null;
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
      if (((oda)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).b())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_Albc != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
            if (!(this.jdField_a_of_type_Albc.getItem(i1) instanceof RecentItemEcShopAssitant)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!nzz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (this.jdField_b_of_type_Aval == null)) {
            break label124;
          }
          this.jdField_b_of_type_Aval.a();
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
          int i2 = azwe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if ((this.p) && (((anpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).b("sp_mayknow_ml_s_a_vl")) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.isShown()) && (!this.jdField_a_of_type_Albc.isEmpty()))
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
          if (i3 < this.jdField_a_of_type_Albc.getCount())
          {
            i4 = i1;
            if (this.jdField_a_of_type_Albc.getItem(i3) != null)
            {
              Object localObject = this.jdField_a_of_type_Albc.getItem(i3);
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
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, 1, 2130838759, "-conversation-");
  }
  
  public void w()
  {
    Object localObject = a();
    if (this.jdField_e_of_type_Boolean)
    {
      if (localObject == null) {}
      while (this.jdField_a_of_type_Alfl == null) {
        return;
      }
      boolean bool = this.jdField_a_of_type_Alfl.a((albc)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "moveToCaredItemCyclic: invoked.  canFindUnreadItem: " + bool + " currentCaredType:" + this.jdField_f_of_type_Int + " currentUnreadCaredItemIndex: " + this.jdField_g_of_type_Int);
      }
      int i1 = (int)(a().getResources().getDimension(2131298717) + a().getResources().getDimension(2131298734) / 2.0F);
      int i2 = this.jdField_g_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      if (this.jdField_g_of_type_Int == 0) {
        i1 = 0;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "moveToCaredItemCyclic: invoked. selection1 ", " position: ", Integer.valueOf(i2) });
        }
        this.jdField_a_of_type_Alfl.c();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(i2, i1);
        localObject = new Conversation.58(this, i2);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed((Runnable)localObject, 250L);
      }
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1E3", "0X800A1E3", 0, 0, "", "", "", "");
  }
  
  void x()
  {
    if (this.jdField_a_of_type_Bkho == null)
    {
      this.jdField_a_of_type_Bkho = bkho.a(a());
      this.jdField_a_of_type_Bkho.b(2131691104);
      this.jdField_a_of_type_Bkho.c(2131690582);
      this.jdField_a_of_type_Bkho.a(new aeae(this));
    }
    this.jdField_a_of_type_Bkho.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation
 * JD-Core Version:    0.7.0.1
 */