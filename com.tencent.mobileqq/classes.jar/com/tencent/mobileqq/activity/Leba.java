package com.tencent.mobileqq.activity;

import aczy;
import aefo;
import aefp;
import aefq;
import aefr;
import aefs;
import aeft;
import aefu;
import aefv;
import aefw;
import aefx;
import aefy;
import aefz;
import aega;
import aegb;
import aegc;
import aegd;
import aege;
import aegf;
import aegh;
import aegj;
import aegk;
import aegn;
import aegr;
import aesx;
import ajzt;
import ajzu;
import ajzy;
import akae;
import akaf;
import akag;
import akah;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anun;
import anvi;
import anvx;
import anxl;
import anxo;
import aoav;
import aozh;
import aquz;
import aqvd;
import aqvh;
import arpq;
import aslz;
import aves;
import avli;
import awdb;
import awdc;
import awdg;
import awdq;
import awds;
import awqd;
import awzb;
import axny;
import axob;
import axod;
import axpo;
import axqc;
import axql;
import aymd;
import ayme;
import ayqy;
import ayqz;
import ayrb;
import azfe;
import bbbq;
import bcmz;
import bcvc;
import bcvr;
import bdfk;
import bdkb;
import bdla;
import bdlf;
import bdlr;
import bdmn;
import bdvn;
import bdvp;
import bgyd;
import bhdz;
import bheh;
import bhey;
import bhhr;
import bhnp;
import bill;
import bjkp;
import bkyc;
import bkyh;
import bkyp;
import blas;
import blfw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.report.NearbyReportRunnable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.theme.TextHook;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import cooperation.qqcircle.chat.QCircleObserver;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.whitelist.QCirclePreLoadManager;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import ntj;
import ntq;
import nyv;
import ook;
import org.json.JSONObject;
import pwb;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;
import vvh;
import wms;
import ykq;
import ykv;

public class Leba
  extends anun
  implements aegn, akah, View.OnClickListener, ViewStub.OnInflateListener, awdg, AbsListView.OnScrollListener, QzoneConfig.QzoneConfigChangeListener
{
  public static int a;
  static long jdField_b_of_type_Long;
  private static List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_d_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_e_of_type_JavaUtilList = new ArrayList();
  protected final long a;
  private aegr jdField_a_of_type_Aegr;
  private ajzt jdField_a_of_type_Ajzt;
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aefp(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  anvi jdField_a_of_type_Anvi = new aegb(this);
  private aoav jdField_a_of_type_Aoav = new aega(this);
  private aozh jdField_a_of_type_Aozh = new aefz(this);
  private aslz jdField_a_of_type_Aslz = new aege(this);
  private avli jdField_a_of_type_Avli = new avli("qzone_leba", "com.tencent.mobileqq:qzone");
  private awdc jdField_a_of_type_Awdc;
  axod jdField_a_of_type_Axod = new aegc(this);
  private ayqy jdField_a_of_type_Ayqy = new aefy(this);
  private ayqz jdField_a_of_type_Ayqz = new aefx(this);
  private ayrb jdField_a_of_type_Ayrb = new aefw(this);
  bdvp jdField_a_of_type_Bdvp = new aegh(this);
  public bkyc a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aegd(this);
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new aefo(this);
  FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  protected TimerTaskManager a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private QCircleObserver jdField_a_of_type_CooperationQqcircleChatQCircleObserver = new aegf(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new Leba.1(this);
  protected final String a;
  protected List<HotWordSearchEntryDataModel.HotSearchItem> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  qqshop_code.SRsp jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = -1;
  private aegr jdField_b_of_type_Aegr;
  private View jdField_b_of_type_AndroidViewView;
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private avli jdField_b_of_type_Avli = new avli("web_leba", "com.tencent.mobileqq:tool");
  private String jdField_b_of_type_JavaLangString;
  private List<arpq> jdField_b_of_type_JavaUtilList;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageSwitcher jdField_c_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private volatile String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private volatile int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private ImageSwitcher jdField_d_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private volatile boolean jdField_d_of_type_Boolean;
  private final int jdField_e_of_type_Int = 1;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private boolean jdField_h_of_type_Boolean = true;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m = true;
  
  static
  {
    jdField_c_of_type_JavaUtilList.add("jiankang.qq.com");
    jdField_c_of_type_JavaUtilList.add("guahao.com");
    jdField_c_of_type_JavaUtilList.add("91160.com");
    jdField_d_of_type_JavaUtilList.add("m.gamecenter.qq.com");
    jdField_d_of_type_JavaUtilList.add("web.gamecenter.qq.com");
    jdField_d_of_type_JavaUtilList.add("imgcache.qq.com");
    jdField_d_of_type_JavaUtilList.add("imgcache.gtimg.cn");
    jdField_d_of_type_JavaUtilList.add("youxi.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("cdn.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("comic.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("reader.sh.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("ac.tc.qq.com");
    jdField_e_of_type_JavaUtilList.add("img-qq.ac.qq.com");
  }
  
  public Leba()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = awqd.a();
    this.jdField_a_of_type_JavaLangString = ("mobileMP" + System.currentTimeMillis());
    this.jdField_a_of_type_Long = 30000L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bkyc = new bkyc(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private void A()
  {
    if (QSecFramework.a().a(1001).booleanValue()) {
      QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(81), Integer.valueOf(1), Integer.valueOf(6), "nearbyClick1", null }, null);
    }
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - jdField_b_of_type_Long);
    if ((l2 >= 0L) && (l2 < 2000L)) {
      return;
    }
    jdField_b_of_type_Long = l1;
    Object localObject3 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    Object localObject2 = ((bbbq)localObject3).a(String.valueOf(100510));
    ((aymd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(100510);
    ajzy.jdField_a_of_type_Int |= 0x1;
    Object localObject1 = ((bbbq)localObject3).a("100510.100517");
    if (((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.has()) {}
    Object localObject4;
    int n;
    for (localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "god buffer: " + (String)localObject1);
      }
      if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.has()) || (!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.has())) {
        break label1146;
      }
      localObject4 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.get();
      if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
        break label1146;
      }
      localObject4 = ((List)localObject4).iterator();
      for (n = 2; ((Iterator)localObject4).hasNext(); n = 1) {
        if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject4).next()).red_type.get() != 3) {
          break label1143;
        }
      }
    }
    for (;;)
    {
      ((bbbq)localObject3).b("100510.100517");
      localObject3 = (ntj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
      ((ntj)localObject3).a(60);
      ((ntj)localObject3).a(59);
      localObject3 = (ntq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
      NearbyReportRunnable localNearbyReportRunnable;
      if (((ntq)localObject3).a())
      {
        ayme.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "home", "official_push_click");
        if (this.jdField_f_of_type_Int != 0)
        {
          localObject4 = (axny)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
          localNearbyReportRunnable = new NearbyReportRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
          localNearbyReportRunnable.a((axny)localObject4);
          localNearbyReportRunnable.a(new String[] { String.valueOf(this.jdField_f_of_type_Int), "" });
          ThreadManagerV2.excute(localNearbyReportRunnable, 16, null, false);
        }
      }
      ((ntq)localObject3).a(false);
      int i1;
      boolean bool;
      if (this.jdField_a_of_type_Ajzt == null)
      {
        i1 = -1;
        this.jdField_a_of_type_Bkyc.post(new Leba.22(this));
        localObject4 = (axny)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        localNearbyReportRunnable = new NearbyReportRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        localNearbyReportRunnable.a((axny)localObject4);
        ThreadManagerV2.excute(localNearbyReportRunnable, 16, null, false);
        if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) || (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 1)) {
          break label1137;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          axql.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        axpo.b(0);
        if (!axqc.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
        {
          localObject2 = new Intent(a(), NearbyActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", n);
          if ((i1 == 56) || (i1 == 57)) {
            ((Intent)localObject2).putExtra("nearby_main_init_tab", 1);
          }
          NearbyFakeActivity.a(a(), (Intent)localObject2);
          label775:
          if (i1 != 59) {
            break label973;
          }
          new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_clk_red").a();
        }
        for (;;)
        {
          axob.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1);
          if (bool) {
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
          }
          pwb.a().a("FuJin", bool);
          return;
          i1 = this.jdField_a_of_type_Ajzt.a();
          break;
          localObject2 = new Intent(a(), NearbyGuideActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", n);
          a().startActivity((Intent)localObject2);
          break label775;
          label973:
          if (i1 == 60)
          {
            localObject1 = ((ntq)localObject3).a(60);
            if ((localObject1 != null) && (((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get() == 1822701914L)) {
              new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_clk_red").a();
            } else {
              new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_clk_red").a();
            }
          }
          else if (i1 == 61)
          {
            new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_clk_red").a();
          }
        }
        label1137:
        bool = false;
      }
      label1143:
      break;
      label1146:
      n = 2;
    }
  }
  
  private void F()
  {
    if ((a() != null) && (a().app != null))
    {
      awzb localawzb = (awzb)a().app.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localawzb != null)
      {
        if (this.jdField_f_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localawzb.a(3);
        }
        localawzb.a(false);
      }
    }
    this.jdField_f_of_type_Boolean = false;
  }
  
  private void G()
  {
    int n = a();
    if (n != 0) {
      QCircleLpReportDc05504.report("", 1, 2, n, "1", "", this.jdField_b_of_type_JavaLangString, null, "", "", null, -1, -1);
    }
  }
  
  private void H()
  {
    ajzy.a().jdField_a_of_type_Boolean = true;
    anxo.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void I()
  {
    J();
    K();
    this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(1134006, 200L);
    N();
    if ((this.jdField_a_of_type_Ajzt != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Ajzt.b();
    }
  }
  
  private void J()
  {
    ThreadManager.post(new Leba.33(this), 5, null, false);
  }
  
  private void K()
  {
    if ((!d()) || (bdfk.a()))
    {
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      QLog.e("QCircleEeveeRedPoint_Leba", 1, "updateQQCircleRedFlag hide");
      return;
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
    QLog.e("QCircleEeveeRedPoint_Leba", 1, "updateQQCircleRedFlag show");
    ThreadManager.post(new Leba.34(this), 5, null, false);
  }
  
  private void L()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_Int = 0;
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    QLog.d("QCircleEeveeRedPoint_Leba", 1, "resetQQCircleRedDot redDot");
  }
  
  private void M()
  {
    int n = a();
    if ((n != 0) && (this.jdField_a_of_type_Boolean))
    {
      QCircleLpReportDc05504.report("", 1, 1, n, "1", "", this.jdField_b_of_type_JavaLangString, null, "", "", null, -1, -1);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void N()
  {
    if (bdfk.a()) {}
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        QLog.i("Leba", 1, "updateIconEntryRedTouch app == null");
        return;
      }
      localAppInfo = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("150000");
    } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b(53).a().a(localAppInfo);
    a(localAppInfo);
  }
  
  private void O()
  {
    Object localObject = (ntq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((ntq)localObject).a(1);
      if (localRedDotInfo != null) {
        ntj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
      }
      localObject = ((ntq)localObject).a(6);
      if (localObject != null) {
        ntj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject);
      }
    }
  }
  
  private void P()
  {
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.gamecenter.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.music");
    this.jdField_a_of_type_JavaUtilSet.add("com.qq.yijianfankui");
    this.jdField_a_of_type_JavaUtilSet.add("com.life.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.citylife.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.android.txnews.new2");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.Health");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.ketang");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.zhibojian");
    this.jdField_a_of_type_JavaUtilSet.add("qzone_feedlist");
  }
  
  private void Q()
  {
    awdq localawdq = new awdq();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localawdq.jdField_a_of_type_Boolean = bool;
      localawdq.jdField_a_of_type_Long = 10000L;
      localawdq.jdField_a_of_type_Int = 0;
      localawdq.jdField_b_of_type_Int = b();
      localawdq.jdField_d_of_type_Int = 2;
      if (this.jdField_a_of_type_Ajzt != null) {
        localawdq.jdField_d_of_type_Int = awds.a(this.jdField_a_of_type_Ajzt.b());
      }
      a(localawdq);
      return;
    }
  }
  
  private void R()
  {
    awdq localawdq = new awdq();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localawdq.jdField_a_of_type_Boolean = bool;
      localawdq.jdField_a_of_type_Long = 10004L;
      localawdq.jdField_a_of_type_Int = 0;
      localawdq.jdField_b_of_type_Int = c();
      localawdq.jdField_d_of_type_Int = 0;
      a(localawdq);
      return;
    }
  }
  
  private int a()
  {
    int n = 0;
    if ((this.jdField_c_of_type_Int > 0) && (this.jdField_b_of_type_Boolean)) {
      n = 3;
    }
    do
    {
      return n;
      if (this.jdField_b_of_type_Boolean) {
        return 1;
      }
      if (this.jdField_c_of_type_Int > 0) {
        return 2;
      }
      if (this.jdField_d_of_type_Boolean) {
        return 5;
      }
    } while (!this.jdField_e_of_type_Boolean);
    return 6;
  }
  
  private arpq a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        arpq localarpq = (arpq)localIterator.next();
        if ((localarpq != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))) {
          return localarpq;
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && ((this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) || (d())))
    {
      ajzy.jdField_a_of_type_Int |= 0x2;
      if (QLog.isColorLevel()) {
        QLog.d("Leba", 2, "updateRefreshFlagForQQCircle " + paramInt);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, List<String> paramList, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    b(new Leba.35(this, paramInt, paramBoolean1, paramBoolean2, paramBoolean4, paramString, paramBoolean3, paramList));
  }
  
  private void a(awdq paramawdq)
  {
    if (paramawdq == null)
    {
      QLog.i("Q.lebatab.leba", 1, "reportPluginClick  reportInfo == null ");
      return;
    }
    QLog.i("Q.lebatab.leba", 1, String.format("reportPluginClick id = %d pos = %d type = %d mode = %b hasAssistsText = %d", new Object[] { Long.valueOf(paramawdq.jdField_a_of_type_Long), Integer.valueOf(paramawdq.jdField_a_of_type_Int), Integer.valueOf(paramawdq.jdField_b_of_type_Int), Boolean.valueOf(paramawdq.jdField_a_of_type_Boolean), Integer.valueOf(paramawdq.jdField_c_of_type_Int) }));
    if (paramawdq.jdField_a_of_type_Boolean)
    {
      bdmn localbdmn = awds.a("plugin_clk");
      localbdmn.jdField_a_of_type_JavaLangString = String.valueOf(paramawdq.jdField_a_of_type_Long);
      localbdmn.jdField_c_of_type_JavaLangString = String.valueOf(paramawdq.jdField_a_of_type_Int);
      localbdmn.d = String.valueOf(paramawdq.jdField_b_of_type_Int);
      localbdmn.e = String.valueOf(paramawdq.jdField_c_of_type_Int);
      localbdmn.f = String.valueOf(paramawdq.jdField_d_of_type_Int);
      localbdmn.g = ThemeUtil.getCurrentThemeId();
      if (g()) {}
      for (paramawdq = "1";; paramawdq = "2")
      {
        localbdmn.h = paramawdq;
        bdkb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbdmn);
        return;
      }
    }
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(paramawdq.jdField_a_of_type_Long), String.valueOf(paramawdq.jdField_a_of_type_Int), String.valueOf(paramawdq.jdField_b_of_type_Int), "");
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(paramAppInfo);
  }
  
  private int b()
  {
    int i1 = 0;
    int n;
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      n = 7;
    }
    do
    {
      do
      {
        return n;
        if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          return 4;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          return 5;
        }
        n = i1;
      } while (this.jdField_f_of_type_AndroidWidgetTextView == null);
      n = i1;
    } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
    return 6;
  }
  
  private String b()
  {
    Object localObject2 = bhnp.a("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((arpq)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((arpq)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((bheh)localObject3).b("url");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject2 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
        }
      }
      return localObject2;
    }
    try
    {
      localObject1 = URLDecoder.decode((String)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
  }
  
  private void b(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    blas.a(this.jdField_b_of_type_AndroidWidgetTextView, 8, 0, 0);
    paramString = this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    if ((paramString instanceof ViewGroup.MarginLayoutParams))
    {
      paramString = (ViewGroup.MarginLayoutParams)paramString;
      if ((this.jdField_a_of_type_Ajzt != null) && (this.jdField_a_of_type_Ajzt.b() == 1)) {
        paramString.bottomMargin = (a().getDimensionPixelSize(2131297114) + ViewUtils.dpToPx(8.0F));
      }
    }
    else
    {
      return;
    }
    paramString.bottomMargin = a().getDimensionPixelSize(2131297114);
  }
  
  private void b(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mLebaHelper == null)) {
      return;
    }
    WebProcessManager.c(true);
    s();
    int n = awds.a(paramBoolean, paramRedTypeInfo);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(n), "");
    paramRedTypeInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mLebaHelper.a();
    LebaPluginInfo localLebaPluginInfo;
    if (paramRedTypeInfo != null)
    {
      n = 0;
      if (n < paramRedTypeInfo.size())
      {
        localLebaPluginInfo = (LebaPluginInfo)paramRedTypeInfo.get(n);
        if (localLebaPluginInfo == null) {}
        while ((TextUtils.isEmpty(localLebaPluginInfo.strPkgName)) || (!localLebaPluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          n += 1;
          break;
        }
      }
    }
    for (long l1 = localLebaPluginInfo.uiResId;; l1 = 0L)
    {
      ThreadManager.postImmediately(new Leba.7(this, l1), null, false);
      q();
      if (!paramBoolean) {
        break;
      }
      paramRedTypeInfo = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (paramRedTypeInfo == null) {
        break;
      }
      paramRedTypeInfo.b(0, 31);
      return;
    }
  }
  
  private int c()
  {
    int i1 = 0;
    int n;
    boolean bool1;
    boolean bool2;
    if (this.jdField_c_of_type_Int > 0)
    {
      n = 1;
      bool1 = this.jdField_b_of_type_Boolean;
      bool2 = this.jdField_c_of_type_Boolean;
      if (n == 0) {
        break label42;
      }
      if (!bool1) {
        break label40;
      }
      n = 7;
    }
    label40:
    label42:
    do
    {
      return n;
      n = 0;
      break;
      return 4;
      if (bool1) {
        return 5;
      }
      n = i1;
    } while (!bool2);
    return 8;
  }
  
  public static boolean d()
  {
    return (QzoneConfig.isQQCircleShowLebaEntrance()) && (QzoneConfig.isQQCircleShowLebaBySwitchButton());
  }
  
  private boolean f()
  {
    return (this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_Ajzt != null) && (this.jdField_a_of_type_Ajzt.b() == 1);
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "preloadWebProcess");
    }
    WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
    if (localWebProcessManager == null) {
      return;
    }
    if (localWebProcessManager.d()) {
      localWebProcessManager.a(202);
    }
    t();
  }
  
  private void t()
  {
    ThreadManager.executeOnSubThread(new Leba.8(this));
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "preloadForGameCenter");
    }
    if (!SonicPreloader.isWifiOrG3OrG4())
    {
      QLog.d("Q.lebatab.leba", 1, "preloadForGameCenter, net type not match, abort");
      return;
    }
    String str = b();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("Q.lebatab.leba", 1, "preloadForGameCenter, gameCenterUrl null");
      return;
    }
    long l2 = System.currentTimeMillis();
    Object localObject1 = a();
    if ((localObject1 != null) && (((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {}
    for (long l1 = ((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;; l1 = 489L)
    {
      localObject1 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      Object localObject2 = ((bbbq)localObject1).a("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbbq)localObject1).a(String.valueOf(l1));
      Object localObject3 = SonicPreloader.getSonicPreloadDataList((BusinessInfoCheckUpdate.AppInfo)localObject2, 0);
      SparseArray localSparseArray = SonicPreloader.getSonicPreloadDataList(localAppInfo, 1002);
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int n;
      if ((localObject3 != null) && (((SparseArray)localObject3).size() > 0))
      {
        n = 0;
        if (n < ((SparseArray)localObject3).size())
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject3).valueAt(n);
          if (localSonicPreloadData.id != 1002) {
            break label372;
          }
          localSonicPreloadData.url = str;
          ((ArrayList)localObject2).add(localSonicPreloadData);
        }
      }
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        localObject3 = (SonicPreloadData)localSparseArray.valueAt(0);
        ((SonicPreloadData)localObject3).url = str;
        localArrayList.add(localObject3);
      }
      localObject3 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
      if (((WebProcessManager)localObject3).a((ArrayList)localObject2)) {
        ((bbbq)localObject1).b(String.valueOf("200010.200011"));
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        if (((WebProcessManager)localObject3).a(localArrayList)) {
          localAppInfo.preload_ts.set(System.currentTimeMillis());
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label429;
        }
        QLog.d("Q.lebatab.leba", 2, "preloadForGameCenter cost:" + (System.currentTimeMillis() - l2));
        return;
        label372:
        n += 1;
        break;
        QLog.d("Q.lebatab.leba", 1, new Object[] { "preload for gamecenter, gameCenterUrl=", str });
        localArrayList.add(new SonicPreloadData(0, str, true, 0L, 1));
        ((WebProcessManager)localObject3).a(localArrayList);
      }
      label429:
      break;
    }
  }
  
  private void v()
  {
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      QLog.d("Leba", 1, "hideQQCircleAfterAccountChanged");
    }
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131379099));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379020));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131376760));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369984));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)a(2131369278));
    this.jdField_i_of_type_AndroidWidgetTextView.setText(2131719164);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369245));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    o();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_b_of_type_AndroidWidgetImageView).b(53).a();
    N();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850109);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167023));
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayrb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayqz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayqy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeLebaListener(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aozh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoav);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Axod);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aslz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
      bdvn.b(this.jdField_a_of_type_Bdvp);
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131369986));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369976));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(a().getDrawable(2130850257));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnScrollListener(this);
      }
    }
    else
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      Object localObject;
      if (this.jdField_c_of_type_AndroidViewView == null)
      {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561198, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
        this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131375502);
        localObject = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131370049);
        if ((localObject instanceof ThemeImageView)) {
          ((ThemeImageView)localObject).setMaskShape(blfw.jdField_c_of_type_Int);
        }
        ((ImageView)localObject).setImageResource(2130845299);
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130839458);
        ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131370050)).setText(2131719159);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375504));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375555));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375716));
        this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376056));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_c_of_type_AndroidViewView.findViewById(2131375505));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new aefq(this));
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375517));
        this.jdField_c_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_c_of_type_AndroidViewView.findViewById(2131375506));
        this.jdField_c_of_type_AndroidWidgetImageSwitcher.setFactory(new aefr(this));
        z();
        this.jdField_a_of_type_Aegr = new aegr(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_c_of_type_AndroidWidgetImageSwitcher, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bkyc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376947));
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369975));
        this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131369978);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131366280));
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        bgyd.a(this.jdField_a_of_type_AndroidWidgetEditText, a(2131691141));
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380145));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363845));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.l = BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("has_search_bar", false);
        d();
        this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new aefs(this));
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          bgyd.b(this.jdField_c_of_type_AndroidViewView);
          bgyd.a(this.jdField_d_of_type_AndroidViewView, anvx.a(2131719159), Button.class.getName());
        }
      }
      if (this.jdField_a_of_type_Ajzt != null)
      {
        localObject = new ajzu();
        ((ajzu)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ((ajzu)localObject).jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
        ((ajzu)localObject).jdField_a_of_type_AndroidContentContext = a();
        ((ajzu)localObject).jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
        ((ajzu)localObject).jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView;
        ((ajzu)localObject).jdField_a_of_type_Awdg = this;
        this.jdField_a_of_type_Ajzt.a((ajzu)localObject);
      }
      if (this.jdField_a_of_type_Awdc == null)
      {
        this.jdField_a_of_type_Awdc = new awdc(a());
        this.jdField_a_of_type_Awdc.a(this.jdField_a_of_type_AndroidViewView);
        int n = a().getTitleBarHeight();
        int i1 = (int)bhdz.a(a(), 5.0F);
        this.jdField_a_of_type_Awdc.b();
        this.jdField_a_of_type_Awdc.a(n - i1);
      }
      m();
    }
  }
  
  private void z()
  {
    this.jdField_e_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131374485);
    if ((!d()) || (bdfk.a())) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131370049));
      if ((this.jdField_d_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.jdField_d_of_type_AndroidWidgetImageView).setMaskShape(blfw.jdField_c_of_type_Int);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845302);
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130839458);
      ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374490)).setText(2131719158);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374492));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374493));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374491));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374494));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_e_of_type_AndroidViewView.findViewById(2131374487));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new aeft(this));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374489));
      this.jdField_d_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_e_of_type_AndroidViewView.findViewById(2131374488));
      this.jdField_d_of_type_AndroidWidgetImageSwitcher.setFactory(new aefu(this));
      this.jdField_b_of_type_Aegr = new aegr(this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_d_of_type_AndroidWidgetImageSwitcher, this.jdField_f_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bkyc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void B()
  {
    super.B();
  }
  
  public void Z_()
  {
    o();
    d();
  }
  
  public aegk a(arpq paramarpq, String paramString, short paramShort, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ("com.cmshow.game.android".equals(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_tab_game", 0, 0);
    }
    Object localObject;
    short s;
    String str;
    if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))
    {
      paramString = a("vipGameCenter");
      List localList;
      int n;
      if (TextUtils.isEmpty(paramString))
      {
        paramString = paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;
        QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use plugin info url=" + paramString);
        localObject = paramString;
        s = paramShort;
        if (!paramBoolean1) {
          break label368;
        }
        str = "-1";
        localList = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(String.valueOf(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId)).missions.get();
        localObject = str;
        if (localList == null) {
          break label305;
        }
        localObject = str;
        if (localList.size() <= 0) {
          break label305;
        }
        localObject = "-1";
        n = 0;
        label182:
        if (n >= localList.size()) {
          break label305;
        }
        if (n != 0) {
          break label264;
        }
      }
      label264:
      for (localObject = (String)localList.get(n);; localObject = (String)localObject + "_" + (String)localList.get(n))
      {
        n += 1;
        break label182;
        if (paramString.startsWith("http")) {
          paramShort = 0;
        }
        QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use IndividuationUrl url=" + paramString);
        break;
      }
      label305:
      if (paramShort == 0)
      {
        paramString = paramString + "&missions=" + (String)localObject;
        QLog.i("Q.lebatab.leba", 1, "[dealGameCenterUrl] add redPointId :" + paramString);
        s = paramShort;
        localObject = paramString;
      }
    }
    for (;;)
    {
      label368:
      if (paramBoolean2)
      {
        if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 0L) {
          break label609;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          paramBoolean3 = true;
        }
      }
      label405:
      label609:
      for (;;)
      {
        pwb.a().b((int)paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean3);
        for (;;)
        {
          paramString = new aegk();
          paramString.jdField_a_of_type_JavaLangString = ((String)localObject);
          paramString.jdField_a_of_type_Short = s;
          paramString.jdField_b_of_type_Boolean = paramBoolean3;
          paramString.jdField_c_of_type_Boolean = paramBoolean1;
          paramString.jdField_d_of_type_Boolean = paramBoolean2;
          paramString.jdField_a_of_type_Arpq = paramarpq;
          return paramString;
          if (paramShort != 2) {
            break label612;
          }
          str = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramString).b("url");
          paramString = paramString.replace(str, str + URLEncoder.encode(new StringBuilder().append("&missions=").append((String)localObject).toString()));
          break;
          paramBoolean3 = false;
          break label405;
          pwb.a().b((int)paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean1);
          if ("com.tx.xingqubuluo.android".equals(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
            paramBoolean3 = paramBoolean1;
          }
          if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 7966L) {
            paramBoolean3 = paramBoolean1;
          }
        }
      }
      label612:
      break;
      localObject = paramString;
      s = paramShort;
    }
  }
  
  protected Intent a(Class<?> paramClass)
  {
    return new Intent(a(), paramClass);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559365, null);
    this.jdField_a_of_type_Ajzt = new ajzt();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public bheh a(arpq paramarpq, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bheh parambheh)
  {
    if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
      parambheh.e("platformId=qq_m");
    }
    do
    {
      return parambheh;
      if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.xingqubuluo.android")) {
        return b(paramarpq, paramAppInfo, parambheh);
      }
      if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.read.android"))
      {
        parambheh.a("ChannelID", "100020");
        return parambheh;
      }
    } while (!a(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
    return c(paramarpq, paramAppInfo, parambheh);
  }
  
  public bheh a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    return bhey.a(paramQQAppInterface, paramContext, paramString);
  }
  
  public String a()
  {
    return anvx.a(2131705492);
  }
  
  public String a(String paramString)
  {
    return bhnp.a(paramString);
  }
  
  public void a()
  {
    super.a();
    Z_();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onAccountChanged");
    }
    if (this.jdField_a_of_type_Aegr != null) {
      this.jdField_a_of_type_Aegr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_b_of_type_Aegr != null) {
      this.jdField_b_of_type_Aegr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    L();
    ajzy.a().a();
    I();
    if (this.jdField_a_of_type_Awdc != null) {
      this.jdField_a_of_type_Awdc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    QCircleEeveeMananger.getInstance().onSend(4, null, null);
    QCirclePreLoadManager localQCirclePreLoadManager = QCirclePreLoadManager.getInstance();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();; str = "")
    {
      localQCirclePreLoadManager.requestWhiteList(str);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onIconDownload, status=" + paramInt + ", url=" + paramString);
    }
    if ((paramInt != 2) || (paramDrawable == null) || (paramVarArgs == null) || (paramVarArgs.length < 1)) {}
    while ((paramVarArgs[0] == null) || (!(paramVarArgs[0] instanceof Integer))) {
      return;
    }
    ((Integer)paramVarArgs[0]).intValue();
  }
  
  public void a(aegk paramaegk)
  {
    String str1 = paramaegk.jdField_a_of_type_JavaLangString;
    Object localObject2 = paramaegk.jdField_b_of_type_JavaLangString;
    int n = paramaegk.jdField_a_of_type_Short;
    boolean bool1 = paramaegk.jdField_a_of_type_Boolean;
    boolean bool2 = paramaegk.jdField_b_of_type_Boolean;
    String str2 = paramaegk.jdField_c_of_type_JavaLangString;
    boolean bool3 = paramaegk.jdField_c_of_type_Boolean;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramaegk.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
    int i1 = paramaegk.jdField_a_of_type_Int;
    int i2 = paramaegk.jdField_b_of_type_Int;
    Object localObject1 = paramaegk.jdField_a_of_type_AndroidViewView;
    boolean bool4 = paramaegk.jdField_d_of_type_Boolean;
    localObject1 = paramaegk.jdField_a_of_type_Arpq;
    bbbq localbbbq = paramaegk.jdField_a_of_type_Bbbq;
    if ((str1 == null) || ("".equals(str1))) {
      a((arpq)localObject1, localAppInfo, localbbbq);
    }
    String str3;
    do
    {
      return;
      str3 = (String)awdb.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      if (n != 0) {
        break;
      }
      paramaegk = new akaf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).a(str1);
      paramaegk = new akag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getvKeyHexStr()).a(paramaegk);
      str1 = new akae(bool3, localAppInfo).a(paramaegk);
      localObject2 = a(QQBrowserActivity.class);
      if (str1.contains("plg_nld=1")) {
        ((Intent)localObject2).putExtra("reportNld", true);
      }
      paramaegk = str1;
      if (!TextUtils.isEmpty(str2))
      {
        ((Intent)localObject2).putExtra("redTouch", str2);
        paramaegk = str1;
        if (str1.contains("red_touch=1")) {
          paramaegk = str1 + "&" + str2;
        }
      }
      this.jdField_b_of_type_Avli.b();
      ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject2).putExtra("plugin_start_time", System.nanoTime());
      ((Intent)localObject2).putExtra("click_start_time", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("is_from_leba", true);
      ((Intent)localObject2).putExtra("leba_resid", ((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
      ((Intent)localObject2).putExtra("has_red_dot", bool2);
      ((Intent)localObject2).putExtra("url", paramaegk);
      if (!TextUtils.isEmpty(str3)) {
        ((Intent)localObject2).putExtra("big_brother_source_key", str3);
      }
    } while (!a((arpq)localObject1, paramaegk, (Intent)localObject2, bool3, bool2, localAppInfo));
    a((Intent)localObject2);
    while (n != 2)
    {
      a((arpq)localObject1, localAppInfo, localbbbq);
      b((arpq)localObject1);
      return;
    }
    paramaegk = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), str1);
    if (paramaegk != null)
    {
      paramaegk = a((arpq)localObject1, localAppInfo, paramaegk);
      paramaegk.a("from_leba", "fromleba");
      paramaegk.a("leba_resid", String.valueOf(((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      paramaegk.a("config_res_plugin_item_name", (String)localObject2);
      paramaegk.a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
      paramaegk.a(bool1);
      paramaegk.c(((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
      paramaegk.f(str2);
      paramaegk.b(bool2);
      paramaegk.a(localAppInfo);
      if (!TextUtils.isEmpty(str3)) {
        paramaegk.a("download_sourceid", str3);
      }
      if ((((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 8059L) || (!MiniAppLauncher.isMiniAppUrl(str1))) {
        break label678;
      }
      MiniAppLauncher.startMiniApp(a(), str1, 2050, null);
    }
    for (;;)
    {
      bkyh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (arpq)localObject1, i1, i2);
      if (this.jdField_a_of_type_JavaUtilSet.contains(((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
        this.jdField_b_of_type_Avli.b();
      }
      a((arpq)localObject1);
      break;
      label678:
      a(paramaegk);
    }
  }
  
  public void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      ook localook = (ook)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      String str1 = String.valueOf(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = bkyp.a(str2, "code", paramMessage.auth_code.get());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("url", str3);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.i("AuthCode", 2, "newUrl:" + str3);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          a(str2);
          if (localook != null) {
            localook.a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localook != null) {
            localook.a(134246777, null, "not_jump", str1, "", 0L, false);
          }
          this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp = paramMessage;
        }
      }
      catch (Exception paramMessage)
      {
        QLog.e("AuthCode", 1, "authcode resp exception:" + paramMessage);
        return;
      }
      finally
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (localook != null) {
            localook.a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
      }
    }
  }
  
  public void a(View paramView, arpq paramarpq)
  {
    if (c()) {
      ThreadManager.post(new Leba.18(this, paramView, paramarpq), 8, null, true);
    }
  }
  
  public void a(View paramView, arpq paramarpq, awdq paramawdq)
  {
    if ((paramarpq == null) || (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "onPluginClick item == null || item.info == null");
      return;
    }
    for (;;)
    {
      try
      {
        QLog.i("Q.lebatab.leba", 1, "onPluginClick item = " + paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.toString());
        a(paramawdq);
        paramawdq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
        if ((paramarpq != null) && (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nyv.jdField_a_of_type_Int))
        {
          ykv.a("dynamic", "clk_story", 0, ((ntq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).c(), new String[0]);
          a(paramView, paramarpq);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.w("Q.lebatab.leba", 1, "onPluginClick", paramView);
        return;
      }
      if ((paramarpq != null) && (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7719L == paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        A();
        paramawdq.a(100510, 31);
        return;
      }
      if ((paramarpq != null) && (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (826L == paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        c(paramView, paramarpq);
        return;
      }
      if ((paramarpq != null) && (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7720L == paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        ExtendFriendPublicFragmentActivity.a(a(), 2);
        if ((paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId <= 0L)) {
          break;
        }
        paramawdq.a((int)paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, 31);
        return;
      }
      if ((paramarpq != null) && (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7759L == paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        aquz localaquz = ((aqvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
        String str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramawdq = str;
        if (localaquz != null)
        {
          paramawdq = str;
          if (!TextUtils.isEmpty(localaquz.l)) {
            paramawdq = localaquz.l;
          }
        }
        paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = paramawdq;
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean, arpq paramarpq)
  {
    if ((paramarpq == null) || (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    String str1 = paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;
    String str2 = paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName;
    short s = paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sResSubType;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (paramView != null)
    {
      bool1 = bool3;
      if ((paramView instanceof RedTouch)) {
        bool1 = ((RedTouch)paramView).a();
      }
    }
    paramarpq = a(paramarpq, str1, s, bool1, paramBoolean, false);
    arpq localarpq = paramarpq.jdField_a_of_type_Arpq;
    str1 = paramarpq.jdField_a_of_type_JavaLangString;
    s = paramarpq.jdField_a_of_type_Short;
    bool3 = paramarpq.jdField_c_of_type_Boolean;
    boolean bool4 = paramarpq.jdField_d_of_type_Boolean;
    paramBoolean = paramarpq.jdField_b_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str2 + ",url=" + str1 + ",type=" + s);
    }
    bbbq localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "");
    int i2 = 0;
    int i1 = 0;
    int i3 = 0;
    int n = 0;
    if (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId > 0L) {
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
      {
        str1 = MobileReportManager.getStringWithRedAppinfo(str1, localAppInfo);
        if (localAppInfo.type.get() == 0) {
          paramBoolean = true;
        }
        if (!localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
          break label844;
        }
        paramBoolean |= true;
      }
    }
    label519:
    label556:
    label844:
    for (;;)
    {
      new ArrayList();
      if ((localAppInfo.red_display_info != null) && (localAppInfo.red_display_info.red_type_info != null))
      {
        paramarpq = localAppInfo.red_display_info.red_type_info.get();
        if ((paramarpq == null) || (paramarpq.size() < 2)) {}
      }
      for (n = ((BusinessInfoCheckUpdate.RedTypeInfo)paramarpq.get(1)).red_type.get();; n = 0)
      {
        i2 = localAppInfo.num.get();
        paramarpq = "status=" + n + "&number=" + i2 + "&path=" + localAppInfo.path.get();
        i1 = n;
        n = i2;
        Object localObject = (bcvc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
        if (localObject != null) {
          if (((bcvc)localObject).a(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "") != -1)
          {
            bool1 = true;
            if (!bool4) {
              break label751;
            }
            localbbbq.b(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "");
            bool2 = bool1;
            if (bool1) {
              b(new Leba.21(this));
            }
          }
        }
        for (bool2 = bool1;; bool2 = false)
        {
          bool1 = paramBoolean;
          paramBoolean = bool2;
          for (;;)
          {
            localObject = new aegk();
            ((aegk)localObject).jdField_a_of_type_JavaLangString = str1;
            ((aegk)localObject).jdField_b_of_type_JavaLangString = str2;
            ((aegk)localObject).jdField_a_of_type_Short = s;
            ((aegk)localObject).jdField_a_of_type_Boolean = paramBoolean;
            ((aegk)localObject).jdField_b_of_type_Boolean = bool1;
            ((aegk)localObject).jdField_c_of_type_JavaLangString = paramarpq;
            ((aegk)localObject).jdField_c_of_type_Boolean = bool3;
            ((aegk)localObject).jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localAppInfo;
            ((aegk)localObject).jdField_a_of_type_Int = i1;
            ((aegk)localObject).jdField_b_of_type_Int = n;
            ((aegk)localObject).jdField_a_of_type_AndroidViewView = paramView;
            ((aegk)localObject).jdField_d_of_type_Boolean = bool4;
            ((aegk)localObject).jdField_a_of_type_Arpq = localarpq;
            ((aegk)localObject).jdField_a_of_type_Bbbq = localbbbq;
            a((aegk)localObject);
            return;
            paramarpq = "status=" + -1 + "&number=0" + "&path=" + localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
            break;
            bool1 = false;
            break label519;
            label751:
            localbbbq.a((int)localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, 31);
            break label556;
            if (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
            {
              bool2 = a(false);
              paramarpq = null;
              bool1 = paramBoolean;
              n = i3;
              i1 = i2;
              paramBoolean = bool2;
            }
            else
            {
              paramarpq = null;
              bool1 = paramBoolean;
              n = i3;
              i1 = i2;
              paramBoolean = bool2;
            }
          }
        }
      }
    }
  }
  
  public void a(arpq paramarpq)
  {
    if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
    {
      bdlr.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bdlr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_Avli.b();
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
      paramarpq = (bcvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
      if (paramarpq != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
        }
        paramarpq.a(true);
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
    }
  }
  
  protected void a(arpq paramarpq, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bbbq parambbbq)
  {
    if ((paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId > 0L))
    {
      parambbbq = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
      String str = String.valueOf(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
      if ((paramAppInfo != null) && (parambbbq != null) && (parambbbq.a(str))) {
        ThreadManager.getFileThreadHandler().post(new Leba.23(this, str, paramAppInfo));
      }
      if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals(bill.jdField_a_of_type_JavaLangString)) {
        ThreadManager.post(new Leba.24(this), 5, null, false);
      }
      if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 7759L) {
        aqvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  protected void a(bheh parambheh)
  {
    if (parambheh != null) {
      parambheh.a();
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    VipUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, new String[0]);
  }
  
  void a(String paramString)
  {
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).c(paramString);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, aegj paramaegj)
  {
    if (paramaegj == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramaegj.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.lebatab.leba", 1, paramString, new Object[0]);
      paramaegj.a();
      return;
    }
    String str1;
    int n;
    if (paramString.equals(a().getString(2131693476)))
    {
      str1 = a().getString(2131693473);
      paramString = a().getString(2131693478);
      n = 1;
    }
    for (;;)
    {
      if (n != 0)
      {
        SharedPreferences localSharedPreferences = a().getSharedPreferences("laba_and_qwallet_check_enter", 4);
        if (localSharedPreferences != null)
        {
          String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          str2 = bjkp.a("check_app_exemption__" + str2 + "_" + paramString);
          boolean bool = localSharedPreferences.getBoolean(str2, false);
          QLog.i("Q.lebatab.leba", 1, "checkEnterApp..checkKey:" + str2 + ",hasCheck:" + bool + "，checkName：" + paramString);
          if (!bool)
          {
            b(new Leba.40(this, str1, localSharedPreferences, str2, paramaegj));
            return;
            if (paramString.equals(a().getString(2131693475)))
            {
              str1 = a().getString(2131693472);
              paramString = a().getString(2131693477);
              n = 1;
              continue;
            }
            if (!paramString.equals(a().getString(2131693474))) {
              break label320;
            }
            str1 = a().getString(2131693471);
            n = 1;
            continue;
          }
        }
      }
      paramaegj.a();
      return;
      label320:
      paramString = null;
      str1 = null;
      n = 0;
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onLogout");
    }
  }
  
  public void a(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    pwb.a().a(3, paramBoolean);
    this.jdField_a_of_type_Bkyc.postDelayed(new Leba.9(this, paramBoolean, paramRedTypeInfo), 150L);
    LpReportInfo_pf00064.allReport(637, 31, 1);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == nyv.jdField_a_of_type_Int;
  }
  
  public boolean a(arpq paramarpq, String paramString, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int n = 0;
    if ((paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 3053L) && (paramString.indexOf("fetchCode=1") > -1))
    {
      long l1 = NetConnInfoCenter.getServerTime();
      if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
        }
        paramIntent.putExtra("url", bkyp.a(paramString, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
        a(paramIntent);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        a(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
        paramarpq = (ook)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
        if (paramarpq != null) {
          paramarpq.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
        }
        return false;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      a(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
      this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(1134007, 1000L);
      return false;
    }
    if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 5647L)
    {
      StringBuilder localStringBuilder;
      if (!paramString.contains("?"))
      {
        paramString = paramString + "?hasRedDot=" + paramBoolean2;
        if ((!paramBoolean2) || (paramAppInfo == null)) {
          break label522;
        }
        localStringBuilder = new StringBuilder();
        paramAppInfo = paramAppInfo.missions.get();
        if (paramAppInfo.size() <= 0) {
          break label425;
        }
        label316:
        if (n >= paramAppInfo.size()) {
          break label425;
        }
        if (n != paramAppInfo.size() - 1) {
          break label398;
        }
        localStringBuilder.append((String)paramAppInfo.get(n));
      }
      for (;;)
      {
        n += 1;
        break label316;
        paramString = paramString + "&hasRedDot=" + paramBoolean2;
        break;
        label398:
        localStringBuilder.append((String)paramAppInfo.get(n)).append("_");
      }
      label425:
      paramString = paramString + "&missions=" + localStringBuilder.toString();
    }
    label522:
    for (;;)
    {
      paramIntent.putExtra("url", paramString);
      if ("com.cmshow.game.android".equals(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))
      {
        paramIntent.putExtra("fragment_class", CmGameFragment.class.getCanonicalName());
        paramIntent.putExtra("hide_operation_bar", true);
        paramIntent.putExtra("hide_more_button", true);
        paramIntent.putExtra("portraitOnly", true);
      }
      return true;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    bcvr localbcvr = (bcvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    boolean bool = paramBoolean;
    if (localbcvr != null) {
      if (localbcvr.a(2) <= 0)
      {
        bool = paramBoolean;
        if (localbcvr.a(1) <= 0) {}
      }
      else
      {
        bool = true;
      }
    }
    return bool;
  }
  
  public void ae_()
  {
    this.jdField_a_of_type_Bkyc.post(new Leba.2(this));
  }
  
  public bheh b(arpq paramarpq, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bheh parambheh)
  {
    paramarpq = (ntq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramarpq.d();
    if (n > 0) {
      localStringBuffer.append("redid=" + n);
    }
    int i1 = paramarpq.a();
    if (i1 > 0) {
      if (localStringBuffer.length() != 0) {
        break label256;
      }
    }
    label256:
    for (paramarpq = "";; paramarpq = "&rpnumber=" + i1)
    {
      localStringBuffer.append(paramarpq);
      QLog.i("Leba", 1, "xqbl redid=" + n + ",rpnumber=" + i1);
      try
      {
        paramarpq = new JSONObject(paramAppInfo.buffer.get());
        if (paramarpq != null)
        {
          paramarpq = paramarpq.optJSONObject("param");
          if (paramarpq != null)
          {
            paramAppInfo = paramarpq.optJSONObject((String)paramAppInfo.missions.get(0));
            if (paramAppInfo != null)
            {
              paramarpq = paramAppInfo.optString("_red_ext_bid");
              paramAppInfo = paramAppInfo.optString("_red_ext_pid");
              if (!TextUtils.isEmpty(paramarpq)) {
                localStringBuffer.append("&bid=").append(paramarpq);
              }
              if (!TextUtils.isEmpty(paramAppInfo)) {
                localStringBuffer.append("&pid=").append(paramAppInfo);
              }
            }
          }
        }
      }
      catch (Exception paramarpq)
      {
        for (;;)
        {
          QLog.i("Leba", 1, "handerSpecialWhenJumpScheme", paramarpq);
        }
      }
      if (localStringBuffer.length() > 0) {
        parambheh.e(localStringBuffer.toString());
      }
      return parambheh;
    }
  }
  
  public void b(View paramView, arpq paramarpq)
  {
    if ((paramarpq == null) || (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    a(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, new aefv(this, paramView, paramarpq));
  }
  
  public void b(arpq paramarpq)
  {
    if (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) {
      StatisticCollector.getInstance(a()).reportActionCount(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
    }
    if (paramarpq.jdField_a_of_type_Long == 1047L) {
      azfe.a().jdField_a_of_type_Int = 4;
    }
    b(new Leba.42(this));
    if (!paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist")) {
      this.jdField_f_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      y();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.initLebaHelper();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_Bkyc);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addLebaListener(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayrb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ayqz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayqy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aozh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoav);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Axod);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aslz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
      bdvn.a(this.jdField_a_of_type_Bdvp);
      if (paramBoolean) {
        v();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.lebatab.leba", 1, "leba fillData->initLebaView exception:" + localException, localException);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public bheh c(arpq paramarpq, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bheh parambheh)
  {
    Object localObject = (ntq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    paramAppInfo = ((ntq)localObject).a();
    paramarpq = paramAppInfo;
    if (paramAppInfo == null)
    {
      paramarpq = paramAppInfo;
      if (((wms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "check invisible red point for msgtab");
        }
        paramarpq = ((ntq)localObject).a(52);
        if (paramarpq != null) {
          break label224;
        }
        paramarpq = ((ntq)localObject).a(35);
      }
    }
    label224:
    for (;;)
    {
      paramAppInfo = parambheh;
      if (paramarpq != null)
      {
        paramAppInfo = parambheh;
        if (paramarpq.uint32_appid.get() == 37) {
          localObject = null;
        }
      }
      try
      {
        paramAppInfo = new JSONObject(paramarpq.str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
        localObject = paramAppInfo;
      }
      catch (Exception paramAppInfo)
      {
        for (;;)
        {
          ykq.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { paramAppInfo.getMessage() });
          continue;
          paramarpq = String.valueOf(paramarpq.uint32_appid.get());
        }
      }
      paramAppInfo = parambheh;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppInfo = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject);
      }
      if (paramarpq == null)
      {
        paramarpq = "";
        paramAppInfo.a("redid", paramarpq);
        paramAppInfo.a("lebaVersion", "old");
        return paramAppInfo;
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onSwitchOutofLeba");
    }
  }
  
  void c(View paramView, arpq paramarpq)
  {
    if (paramarpq == null) {
      return;
    }
    paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = anxl.jdField_a_of_type_JavaLangString;
    String str = bhhr.c(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {
      paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = str.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("enterXQBL", 2, "跳转url = " + paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
    }
    b(paramView, paramarpq);
    O();
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
  }
  
  boolean c()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.m;
      if (this.m)
      {
        this.m = false;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.postDelayed(new Leba.19(this), 1000L);
        return bool2;
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
    return bool2;
  }
  
  protected void d()
  {
    int i1 = 0;
    Object localObject;
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      boolean bool = bcmz.a();
      localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (!bool) {
        break label77;
      }
      n = 0;
      ((RelativeLayout)localObject).setVisibility(n);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        localObject = this.jdField_b_of_type_AndroidViewView;
        if (bool) {
          break label83;
        }
      }
    }
    label77:
    label83:
    for (int n = i1;; n = 8)
    {
      ((View)localObject).setVisibility(n);
      if ((bdvn.a()) && (this.jdField_a_of_type_Ajzt != null)) {}
      try
      {
        this.jdField_a_of_type_Ajzt.d();
        return;
      }
      catch (Exception localException)
      {
        QLog.d("leba_study", 1, "refreshSearchBar", localException);
      }
      n = 8;
      break;
    }
  }
  
  public void e()
  {
    super.e();
    w();
    P();
    ((ViewStub)a(2131378187)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131365001)).setOnFirstDrawListener(this);
    this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
    QzoneConfig.getInstance().addListener(this);
    aves.d();
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onResume" + ajzy.jdField_a_of_type_Int);
    }
    AbstractGifImage.resumeAll();
    pwb.a().c();
    if (this.k)
    {
      ThreadRegulator.a().b(4);
      this.k = false;
    }
    aesx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Aegr != null) {
      this.jdField_a_of_type_Aegr.c();
    }
    if (this.jdField_b_of_type_Aegr != null) {
      this.jdField_b_of_type_Aegr.c();
    }
    ThreadManager.post(new Leba.4(this), 5, null, false);
    ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(System.currentTimeMillis());
    if ((!this.jdField_g_of_type_Boolean) || ((ajzy.jdField_a_of_type_Int & 0x4) != 0)) {
      this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.c(true);
      this.jdField_a_of_type_Bkyc.postDelayed(new Leba.5(this), 100L);
      ThreadManagerV2.excute(new Leba.6(this, (axny)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
      N();
      Z_();
      Object localObject;
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setFocusable(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(2131691098));
        localObject = a(2131693749);
        this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131693749));
      }
      if (this.jdField_a_of_type_Ajzt != null) {
        this.jdField_a_of_type_Ajzt.a();
      }
      if (this.jdField_a_of_type_Awdc != null) {
        this.jdField_a_of_type_Awdc.b(true);
      }
      ApngImage.playByTag(4);
      if ((paramBoolean) && (!this.j) && (a() != null))
      {
        this.j = true;
        ThreadManagerV2.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper().c();
      }
      return;
      if (ajzy.jdField_a_of_type_Int > 0)
      {
        localObject = new ArrayList();
        anxo.a((List)localObject, ajzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
          if (this.jdField_a_of_type_Ajzt != null)
          {
            this.jdField_a_of_type_Ajzt.b();
            I();
          }
        }
        ajzy.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  public void g()
  {
    ApngImage.pauseByTag(4);
    super.g();
    WebProcessManager.c(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.b();
    }
    this.jdField_a_of_type_Avli.d();
    this.jdField_b_of_type_Avli.d();
    axpo.c(0);
    this.jdField_a_of_type_Bkyc.removeMessages(1134010);
    if (this.jdField_a_of_type_Aegr != null) {
      this.jdField_a_of_type_Aegr.b();
    }
    if (this.jdField_b_of_type_Aegr != null) {
      this.jdField_b_of_type_Aegr.b();
    }
    if (this.jdField_a_of_type_Ajzt != null) {
      this.jdField_a_of_type_Ajzt.a(b(), f(), c());
    }
    if (this.jdField_a_of_type_Awdc != null) {
      this.jdField_a_of_type_Awdc.c();
    }
    this.jdField_a_of_type_Bkyc.postDelayed(new Leba.3(this), 500L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onPause");
    }
    this.jdField_a_of_type_Boolean = true;
    a(3);
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onStop");
    }
  }
  
  public void i()
  {
    x();
    if (this.jdField_a_of_type_Aegr != null) {
      this.jdField_a_of_type_Aegr.d();
    }
    if (this.jdField_b_of_type_Aegr != null) {
      this.jdField_b_of_type_Aegr.d();
    }
    if (this.jdField_a_of_type_Awdc != null) {
      this.jdField_a_of_type_Awdc.d();
    }
    super.i();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.post(new Leba.10(this), 10, null, false);
    WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.a(202);
    }
  }
  
  public void k()
  {
    super.k();
    x();
    if (this.jdField_a_of_type_Aegr != null) {
      this.jdField_a_of_type_Aegr.d();
    }
    if (this.jdField_b_of_type_Aegr != null) {
      this.jdField_b_of_type_Aegr.d();
    }
  }
  
  protected void l()
  {
    Object localObject = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    int i1;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbbq)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        i1 = 0;
        int n = i1;
        if (i1 == -1)
        {
          localAppInfo = ((bbbq)localObject).a("886.100171");
          n = i1;
          if (localAppInfo != null)
          {
            n = i1;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              n = i1;
              if (localAppInfo.type.get() != -1) {
                n = 1;
              }
            }
          }
        }
        i1 = n;
        if (n == -1)
        {
          localObject = ((bbbq)localObject).a("886.100172");
          i1 = n;
          if (localObject != null)
          {
            i1 = n;
            if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)
            {
              i1 = n;
              if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != -1) {
                i1 = 2;
              }
            }
          }
        }
        if (i1 != -1) {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, i1 + "", "", "", "");
        }
        if (((ntq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a()) {
          ayme.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "entry", "official_push_exp");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "ReportTroopAndActivityStatics, redDotFrom=" + i1);
      }
      return;
      i1 = -1;
      break;
      i1 = -1;
    }
  }
  
  void m()
  {
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, 4, 2130838912, "-leba-");
    if (ThemeUtil.isNowThemeIsAnimate()) {
      this.jdField_i_of_type_Boolean = true;
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onPostThemeChanged");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(null);
    }
    m();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(11340002, 0L);
      Z_();
      if (this.jdField_a_of_type_Ajzt != null) {
        this.jdField_a_of_type_Ajzt.c();
      }
      if (this.jdField_a_of_type_Aegr != null) {
        this.jdField_a_of_type_Aegr.e();
      }
      if (this.jdField_b_of_type_Aegr != null) {
        this.jdField_b_of_type_Aegr.e();
      }
      if (this.jdField_a_of_type_Awdc != null) {
        this.jdField_a_of_type_Awdc.f();
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        TextHook.updateFont(this.jdField_c_of_type_AndroidViewView);
      }
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850109);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167023));
    }
  }
  
  public void o()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      boolean bool1 = bdfk.a();
      boolean bool2 = bdvn.a();
      QLog.i("leba_study", 1, "refreshMgrBtn isSimpleUI=" + bool1 + ",isStudyMode=" + bool2);
      if ((bool1) || (bool2)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    if (!c()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369245: 
      case 2131369262: 
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
        H();
        break;
      case 2131374485: 
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localHashMap1.put("key_enable_splash", "1");
        localHashMap1.put("key_jump_from", "3");
        if (this.jdField_b_of_type_Boolean) {}
        for (localObject = "1";; localObject = "0")
        {
          localHashMap1.put("key_show_active_red_dot", localObject);
          localHashMap1.put("key_unread_red_num", this.jdField_c_of_type_Int + "");
          if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
            localHashMap2.put("key_red_dot_trans_info", this.jdField_a_of_type_ArrayOfByte);
          }
          if (this.jdField_b_of_type_Int > 0) {
            localHashMap1.put("key_assign_show_tab_type", this.jdField_b_of_type_Int + "");
          }
          vvh.a(a(), "openfolder", localHashMap1, localHashMap2);
          R();
          G();
          a(1);
          break;
        }
      case 2131375502: 
        if (QLog.isColorLevel()) {
          QLog.d("HardCoder", 2, "launch qzone");
        }
        jdField_a_of_type_Int = aczy.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootQzone");
        localObject = (arpq)ajzy.a().jdField_a_of_type_JavaUtilHashMap.get("qzone_feedlist");
        QLog.d("Q.lebatab.leba", 1, "user clicked qzone feed entry.");
        ThreadManager.postImmediately(new Leba.31(this, (arpq)localObject), null, true);
        Q();
        MiniSdkLauncher.preLaunchMiniAppCheckinFromLeba();
      }
    }
  }
  
  public void onConfigChange()
  {
    QLog.d("Leba", 1, "onConfigChange");
    b(new Leba.39(this));
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    b(false);
    if (!this.jdField_g_of_type_Boolean) {
      e(true);
    }
    this.jdField_g_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      return;
      if (this.jdField_i_of_type_Boolean)
      {
        if (paramInt != 0)
        {
          ApngImage.pauseByTag(4);
          if (QLog.isColorLevel()) {
            QLog.e("Q.lebatab.leba", 2, "onScrollStateChanged not SCROLL_STATE_IDLE");
          }
        }
        if (paramInt == 0)
        {
          ApngImage.playByTag(4);
          if (QLog.isColorLevel()) {
            QLog.e("Q.lebatab.leba", 2, "onScrollStateChanged SCROLL_STATE_IDLE");
          }
        }
      }
    } while (this.jdField_a_of_type_Ajzt == null);
    this.jdField_a_of_type_Ajzt.a(paramAbsListView, paramInt);
  }
  
  public void q()
  {
    QLog.d("Leba", 1, "onLebaTabChange");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      awzb localawzb = (awzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
      bcvt.jdField_a_of_type_Boolean = true;
      if (localawzb != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localawzb.a(3);
      }
      QCircleEeveeMananger.getInstance().onSend(3, null, null);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mLebaHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mLebaHelper.b();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mLebaHelper.e();
      }
    }
    if (!e()) {
      E();
    }
    a(2);
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)) {}
    ook localook;
    do
    {
      return;
      localook = (ook)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localook == null);
    localook.a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */