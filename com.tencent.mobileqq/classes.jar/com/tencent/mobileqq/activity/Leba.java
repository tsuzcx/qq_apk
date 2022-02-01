package com.tencent.mobileqq.activity;

import addy;
import aemg;
import aemh;
import aemi;
import aemj;
import aemk;
import aeml;
import aemm;
import aemn;
import aemo;
import aemp;
import aemq;
import aemr;
import aems;
import aemt;
import aemu;
import aemv;
import aemw;
import aemx;
import aemz;
import aenb;
import aenc;
import aenf;
import aenj;
import aezt;
import ajvd;
import ajve;
import ajvi;
import ajvm;
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
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aniz;
import anlv;
import anmu;
import anni;
import anov;
import anoy;
import anry;
import aooo;
import aqji;
import aqjm;
import aqjq;
import arcs;
import asgf;
import aval;
import avrh;
import avri;
import avrm;
import avrw;
import avry;
import awdz;
import awnb;
import axby;
import axcb;
import axcd;
import axdl;
import axdz;
import axei;
import axzw;
import axzx;
import ayes;
import ayet;
import ayev;
import aysz;
import baif;
import bbum;
import bccg;
import bccv;
import bcnj;
import bcru;
import bcst;
import bcsy;
import bctj;
import bcts;
import bcul;
import bdch;
import bdci;
import bgfz;
import bgme;
import bgmp;
import bgng;
import bgsg;
import bgyg;
import bhtw;
import bisz;
import bkfv;
import bkgb;
import bkgj;
import bkhe;
import bkpg;
import bkzc;
import blyl;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.leba.mgr.LebaTableMgrFragment;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
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
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import common.config.service.QzoneConfig;
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
import niz;
import njg;
import noq;
import odu;
import org.json.JSONObject;
import pmy;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;
import uxo;
import viy;
import vqu;
import vrf;
import wsm;
import yqp;
import yqu;

public class Leba
  extends anlv
  implements aenf, ajvm, View.OnClickListener, ViewStub.OnInflateListener, avrm, bkhe, bkzc
{
  public static int a;
  static long jdField_b_of_type_Long;
  private static List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_d_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_e_of_type_JavaUtilList = new ArrayList();
  protected final long a;
  private aenj jdField_a_of_type_Aenj;
  private ajvd jdField_a_of_type_Ajvd;
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aemh(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aniz jdField_a_of_type_Aniz = new aemv(this);
  anmu jdField_a_of_type_Anmu = new aemt(this);
  private anry jdField_a_of_type_Anry = new aems(this);
  private aooo jdField_a_of_type_Aooo = new aemr(this);
  private asgf jdField_a_of_type_Asgf = new aemw(this);
  private aval jdField_a_of_type_Aval = new aval("qzone_leba", "com.tencent.mobileqq:qzone");
  private avri jdField_a_of_type_Avri;
  axcd jdField_a_of_type_Axcd = new aemu(this);
  private ayes jdField_a_of_type_Ayes = new aemq(this);
  private ayet jdField_a_of_type_Ayet = new aemp(this);
  private ayev jdField_a_of_type_Ayev = new aemo(this);
  bdci jdField_a_of_type_Bdci = new aemz(this);
  public bkfv a;
  private QCircleObserver jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver = new aemx(this);
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new aemg(this);
  FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  protected TimerTaskManager a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private Runnable jdField_a_of_type_JavaLangRunnable = new Leba.1(this);
  protected final String a;
  protected List<HotWordSearchEntryDataModel.HotSearchItem> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  qqshop_code.SRsp jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1;
  private aenj jdField_b_of_type_Aenj;
  private View jdField_b_of_type_AndroidViewView;
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private aval jdField_b_of_type_Aval = new aval("web_leba", "com.tencent.mobileqq:tool");
  private volatile String jdField_b_of_type_JavaLangString;
  private List<arcs> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
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
  private boolean jdField_d_of_type_Boolean = true;
  private volatile int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private boolean jdField_h_of_type_Boolean;
  private boolean i = true;
  private volatile boolean j = true;
  private volatile boolean k;
  
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
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = awdz.a();
    this.jdField_a_of_type_JavaLangString = ("mobileMP" + System.currentTimeMillis());
    this.jdField_a_of_type_Long = 30000L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bkfv = new bkfv(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private void E()
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
    Object localObject3 = (baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    Object localObject2 = ((baif)localObject3).a(String.valueOf(100510));
    ((axzw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160)).a(100510);
    ajvi.jdField_a_of_type_Int |= 0x1;
    Object localObject1 = ((baif)localObject3).a("100510.100517");
    if (((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.has()) {}
    int m;
    for (localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "god buffer: " + (String)localObject1);
      }
      if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.has()) || (!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.has())) {
        break label1082;
      }
      Object localObject4 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.get();
      if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
        break label1082;
      }
      localObject4 = ((List)localObject4).iterator();
      for (m = 2; ((Iterator)localObject4).hasNext(); m = 1) {
        if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject4).next()).red_type.get() != 3) {
          break label1079;
        }
      }
    }
    for (;;)
    {
      ((baif)localObject3).b("100510.100517");
      localObject3 = (niz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43);
      ((niz)localObject3).a(60);
      ((niz)localObject3).a(59);
      localObject3 = (njg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
      if (((njg)localObject3).a())
      {
        axzx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "home", "official_push_click");
        if (this.jdField_c_of_type_Int != 0) {
          ThreadManagerV2.excute(new Leba.22(this, (axby)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
        }
      }
      ((njg)localObject3).a(false);
      int n;
      boolean bool;
      if (this.jdField_a_of_type_Ajvd == null)
      {
        n = -1;
        this.jdField_a_of_type_Bkfv.post(new Leba.23(this));
        ThreadManagerV2.excute(new Leba.24(this, (axby)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
        if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) || (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 1)) {
          break label1073;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
        bcst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          axei.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        axdl.b(0);
        if (!axdz.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
        {
          localObject2 = new Intent(a(), NearbyActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", m);
          if ((n == 56) || (n == 57)) {
            ((Intent)localObject2).putExtra("nearby_main_init_tab", 1);
          }
          NearbyFakeActivity.a(a(), (Intent)localObject2);
          label711:
          if (n != 59) {
            break label909;
          }
          new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_clk_red").a();
        }
        for (;;)
        {
          axcb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, n);
          if (bool) {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
          }
          pmy.a().a("FuJin", bool);
          return;
          n = this.jdField_a_of_type_Ajvd.a();
          break;
          localObject2 = new Intent(a(), NearbyGuideActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", m);
          a().startActivity((Intent)localObject2);
          break label711;
          label909:
          if (n == 60)
          {
            localObject1 = ((njg)localObject3).a(60);
            if ((localObject1 != null) && (((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get() == 1822701914L)) {
              new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_clk_red").a();
            } else {
              new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_clk_red").a();
            }
          }
          else if (n == 61)
          {
            new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_clk_red").a();
          }
        }
        label1073:
        bool = false;
      }
      label1079:
      break;
      label1082:
      m = 2;
    }
  }
  
  private void F()
  {
    if ((a() != null) && (a().app != null))
    {
      awnb localawnb = (awnb)a().app.getManager(10);
      if (localawnb != null)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localawnb.a(3);
        }
        localawnb.a(false);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void G()
  {
    int m = a();
    if (m != 0) {
      if (!vqu.a()) {
        break label50;
      }
    }
    label50:
    for (String str = "1";; str = "0")
    {
      vrf.a("", 1, 2, m, str, "", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", null, -1, -1);
      return;
    }
  }
  
  private void H()
  {
    ajvi.a().jdField_a_of_type_Boolean = true;
    ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("150000");
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {}
    for (int m = 1; m != 0; m = 0)
    {
      PublicFragmentActivity.a(a(), LebaTableMgrFragment.class);
      return;
    }
    a(new Intent(a(), LebaListMgrActivity.class));
  }
  
  private void I()
  {
    J();
    K();
    this.jdField_a_of_type_Bkfv.sendEmptyMessageDelayed(1134006, 200L);
    N();
    if ((this.jdField_a_of_type_Ajvd != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Ajvd.b();
    }
  }
  
  private void J()
  {
    ThreadManager.post(new Leba.35(this), 5, null, false);
  }
  
  private void K()
  {
    if ((!QzoneConfig.isQQCircleShowLebaEntrance()) || (bcnj.a()) || (this.jdField_c_of_type_Boolean))
    {
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
      QLog.e("Leba", 1, "updateQQCircleRedFlag hide");
      return;
    }
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    QLog.e("Leba", 1, "updateQQCircleRedFlag show");
    ThreadManager.post(new Leba.36(this), 5, null, false);
  }
  
  private void L()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_Int = 0;
    this.k = false;
    this.jdField_e_of_type_Int = 0;
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    QLog.d("Leba", 1, "resetQQCircleRedDot redDot");
  }
  
  private void M()
  {
    int m = a();
    if ((m != 0) && (this.j)) {
      if (!vqu.a()) {
        break label62;
      }
    }
    label62:
    for (String str = "1";; str = "0")
    {
      vrf.a("", 1, 1, m, str, "", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "", "", null, -1, -1);
      this.j = false;
      return;
    }
  }
  
  private void N()
  {
    if (bcnj.a()) {}
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        QLog.i("Leba", 1, "updateIconEntryRedTouch app == null");
        return;
      }
      localAppInfo = ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("150000");
    } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).a().a(localAppInfo);
    a(localAppInfo);
  }
  
  private void O()
  {
    Object localObject = (njg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((njg)localObject).a(1);
      if (localRedDotInfo != null) {
        niz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
      }
      localObject = ((njg)localObject).a(6);
      if (localObject != null) {
        niz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject);
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
    avrw localavrw = new avrw();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localavrw.jdField_a_of_type_Boolean = bool;
      localavrw.jdField_a_of_type_Long = 10000L;
      localavrw.jdField_a_of_type_Int = 0;
      localavrw.jdField_b_of_type_Int = b();
      localavrw.jdField_d_of_type_Int = 2;
      if (this.jdField_a_of_type_Ajvd != null) {
        localavrw.jdField_d_of_type_Int = avry.a(this.jdField_a_of_type_Ajvd.b());
      }
      a(localavrw);
      return;
    }
  }
  
  private void R()
  {
    avrw localavrw = new avrw();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localavrw.jdField_a_of_type_Boolean = bool;
      localavrw.jdField_a_of_type_Long = 10004L;
      localavrw.jdField_a_of_type_Int = 0;
      localavrw.jdField_b_of_type_Int = c();
      localavrw.jdField_d_of_type_Int = 0;
      a(localavrw);
      return;
    }
  }
  
  private int a()
  {
    int n = 0;
    int m;
    if ((this.jdField_d_of_type_Int > 0) && (this.k) && (this.jdField_e_of_type_Int > 0)) {
      m = 3;
    }
    do
    {
      do
      {
        return m;
        if ((this.k) && (this.jdField_e_of_type_Int > 0)) {
          return 1;
        }
        if (this.jdField_d_of_type_Int > 0) {
          return 2;
        }
        m = n;
      } while (this.jdField_d_of_type_Int != 0);
      m = n;
    } while (this.k);
    return 4;
  }
  
  private arcs a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        arcs localarcs = (arcs)localIterator.next();
        if ((localarcs != null) && (localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName != null) && (localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName != null) && (localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))) {
          return localarcs;
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_d_of_type_AndroidViewView != null) && ((this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) || (QzoneConfig.isQQCircleShowLebaEntrance())))
    {
      ajvi.jdField_a_of_type_Int |= 0x2;
      if (QLog.isColorLevel()) {
        QLog.d("Leba", 2, "updateRefreshFlagForQQCircle " + paramInt);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean, List<String> paramList)
  {
    if (paramList == null) {}
    for (int m = 0;; m = paramList.size())
    {
      QLog.d("Leba", 1, "isEevee: " + vqu.a() + ", showQQCircleRedDot: " + paramInt + ", " + paramBoolean + ", " + paramList);
      if (this.jdField_d_of_type_Int != paramInt)
      {
        this.jdField_d_of_type_Int = paramInt;
        this.j = true;
      }
      if (this.k != paramBoolean)
      {
        this.k = paramBoolean;
        this.j = true;
      }
      if (this.jdField_e_of_type_Int != m)
      {
        this.jdField_e_of_type_Int = m;
        this.j = true;
      }
      a(new Leba.37(this, paramInt, paramBoolean, m, paramList));
      return;
    }
  }
  
  private void a(avrw paramavrw)
  {
    if (paramavrw == null)
    {
      QLog.i("Q.lebatab.leba", 1, "reportPluginClick  reportInfo == null ");
      return;
    }
    QLog.i("Q.lebatab.leba", 1, String.format("reportPluginClick id = %d pos = %d type = %d mode = %b hasAssistsText = %d", new Object[] { Long.valueOf(paramavrw.jdField_a_of_type_Long), Integer.valueOf(paramavrw.jdField_a_of_type_Int), Integer.valueOf(paramavrw.jdField_b_of_type_Int), Boolean.valueOf(paramavrw.jdField_a_of_type_Boolean), Integer.valueOf(paramavrw.jdField_c_of_type_Int) }));
    if (paramavrw.jdField_a_of_type_Boolean)
    {
      bcul localbcul = avry.a("plugin_clk");
      localbcul.jdField_a_of_type_JavaLangString = String.valueOf(paramavrw.jdField_a_of_type_Long);
      localbcul.jdField_c_of_type_JavaLangString = String.valueOf(paramavrw.jdField_a_of_type_Int);
      localbcul.d = String.valueOf(paramavrw.jdField_b_of_type_Int);
      localbcul.e = String.valueOf(paramavrw.jdField_c_of_type_Int);
      localbcul.f = String.valueOf(paramavrw.jdField_d_of_type_Int);
      localbcul.g = ThemeUtil.getCurrentThemeId();
      bcru.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbcul);
      return;
    }
    bcst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(paramavrw.jdField_a_of_type_Long), String.valueOf(paramavrw.jdField_a_of_type_Int), String.valueOf(paramavrw.jdField_b_of_type_Int), "");
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private int b()
  {
    int n = 0;
    int m;
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      m = 7;
    }
    do
    {
      do
      {
        return m;
        if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          return 4;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          return 5;
        }
        m = n;
      } while (this.jdField_e_of_type_AndroidWidgetTextView == null);
      m = n;
    } while (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0);
    return 6;
  }
  
  private String b()
  {
    Object localObject2 = bgyg.a("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((arcs)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((arcs)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = bgng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((bgmp)localObject3).b("url");
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
  
  private void b(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null)) {
      return;
    }
    WebProcessManager.c(true);
    s();
    int m = avry.a(paramBoolean, paramRedTypeInfo);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(m), "");
    paramRedTypeInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
    LebaPluginInfo localLebaPluginInfo;
    if (paramRedTypeInfo != null)
    {
      m = 0;
      if (m < paramRedTypeInfo.size())
      {
        localLebaPluginInfo = (LebaPluginInfo)paramRedTypeInfo.get(m);
        if (localLebaPluginInfo == null) {}
        while ((TextUtils.isEmpty(localLebaPluginInfo.strPkgName)) || (!localLebaPluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          m += 1;
          break;
        }
      }
    }
    for (long l = localLebaPluginInfo.uiResId;; l = 0L)
    {
      ThreadManager.postImmediately(new Leba.7(this, l), null, false);
      q();
      return;
    }
  }
  
  private int c()
  {
    int i1 = 1;
    int i2 = 0;
    int m;
    int n;
    if (this.jdField_d_of_type_Int > 0)
    {
      m = 1;
      if (this.jdField_e_of_type_Int <= 0) {
        break label62;
      }
      n = 1;
      label23:
      if ((!this.k) || (this.jdField_e_of_type_Int != 0) || (this.jdField_d_of_type_Int != 0)) {
        break label67;
      }
      label44:
      if (m == 0) {
        break label74;
      }
      if (n == 0) {
        break label72;
      }
      m = 7;
    }
    label62:
    label67:
    label72:
    label74:
    do
    {
      return m;
      m = 0;
      break;
      n = 0;
      break label23;
      i1 = 0;
      break label44;
      return 4;
      if (n != 0) {
        return 5;
      }
      m = i2;
    } while (i1 == 0);
    return 8;
  }
  
  private boolean e()
  {
    return (this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  private boolean f()
  {
    return (this.jdField_a_of_type_Ajvd != null) && (this.jdField_a_of_type_Ajvd.b() == 1);
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "preloadWebProcess");
    }
    WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
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
    if ((localObject1 != null) && (((arcs)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {}
    for (long l1 = ((arcs)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;; l1 = 489L)
    {
      localObject1 = (baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      Object localObject2 = ((baif)localObject1).a("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((baif)localObject1).a(String.valueOf(l1));
      Object localObject3 = SonicPreloader.getSonicPreloadDataList((BusinessInfoCheckUpdate.AppInfo)localObject2, 0);
      SparseArray localSparseArray = SonicPreloader.getSonicPreloadDataList(localAppInfo, 1002);
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int m;
      if ((localObject3 != null) && (((SparseArray)localObject3).size() > 0))
      {
        m = 0;
        if (m < ((SparseArray)localObject3).size())
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject3).valueAt(m);
          if (localSonicPreloadData.id != 1002) {
            break label370;
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
      localObject3 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (((WebProcessManager)localObject3).a((ArrayList)localObject2)) {
        ((baif)localObject1).b(String.valueOf("200010.200011"));
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        if (((WebProcessManager)localObject3).a(localArrayList)) {
          localAppInfo.preload_ts.set(System.currentTimeMillis());
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label427;
        }
        QLog.d("Q.lebatab.leba", 2, "preloadForGameCenter cost:" + (System.currentTimeMillis() - l2));
        return;
        label370:
        m += 1;
        break;
        QLog.d("Q.lebatab.leba", 1, new Object[] { "preload for gamecenter, gameCenterUrl=", str });
        localArrayList.add(new SonicPreloadData(0, str, true, 0L, 1));
        ((WebProcessManager)localObject3).a(localArrayList);
      }
      label427:
      break;
    }
  }
  
  private void v()
  {
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_Boolean = true;
      QLog.d("Leba", 1, "hideQQCircleAfterAccountChanged");
    }
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131378874));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378796));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131376599));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369729));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)a(2131368994));
    this.jdField_h_of_type_AndroidWidgetTextView.setText(2131718390);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131368961));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (bcnj.a()) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_b_of_type_AndroidWidgetImageView).a(53).a();
    N();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      bcnj.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850087);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166983));
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayev);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayet);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayes);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anmu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aooo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anry);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aniz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Axcd);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asgf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver);
      bdch.b(this.jdField_a_of_type_Bdci);
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131369731));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369722));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(a().getDrawable(2130850222));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnScrollListener(this);
      }
    }
    else
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      Object localObject;
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561225, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
        this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131375355);
        localObject = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369787);
        if ((localObject instanceof ThemeImageView)) {
          ((ThemeImageView)localObject).setMaskShape(bkpg.jdField_c_of_type_Int);
        }
        ((ImageView)localObject).setImageResource(2130845320);
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839394);
        ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369788)).setText(2131718385);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375357));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375405));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375566));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375906));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131375358));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new aemi(this));
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375370));
        this.jdField_c_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131375359));
        this.jdField_c_of_type_AndroidWidgetImageSwitcher.setFactory(new aemj(this));
        z();
        this.jdField_a_of_type_Aenj = new aenj(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_c_of_type_AndroidWidgetImageSwitcher, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bkfv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376788));
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369721));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131366102));
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        bgfz.a(this.jdField_a_of_type_AndroidWidgetEditText, a(2131691016));
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131379885));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363719));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_h_of_type_Boolean = BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("has_search_bar", false);
        j();
        this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new aemk(this));
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          bgfz.b(this.jdField_b_of_type_AndroidViewView);
          bgfz.a(this.jdField_c_of_type_AndroidViewView, anni.a(2131718385), Button.class.getName());
        }
      }
      if (this.jdField_a_of_type_Ajvd != null)
      {
        localObject = new ajve();
        ((ajve)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ((ajve)localObject).jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
        ((ajve)localObject).jdField_a_of_type_AndroidContentContext = a();
        ((ajve)localObject).jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
        ((ajve)localObject).jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
        ((ajve)localObject).jdField_a_of_type_Avrm = this;
        this.jdField_a_of_type_Ajvd.a((ajve)localObject);
      }
      if (this.jdField_a_of_type_Avri == null)
      {
        this.jdField_a_of_type_Avri = new avri(a());
        this.jdField_a_of_type_Avri.a(this.jdField_a_of_type_AndroidViewView);
        int m = a().getTitleBarHeight();
        int n = (int)bgme.a(a(), 5.0F);
        this.jdField_a_of_type_Avri.b();
        this.jdField_a_of_type_Avri.a(m - n);
      }
      n();
    }
  }
  
  private void z()
  {
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131374344);
    if ((!QzoneConfig.isQQCircleShowLebaEntrance()) || (bcnj.a())) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131369787));
      if ((this.jdField_d_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.jdField_d_of_type_AndroidWidgetImageView).setMaskShape(bkpg.jdField_c_of_type_Int);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845323);
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130839394);
      ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374349)).setText(2131718384);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374351));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374350));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374352));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_d_of_type_AndroidViewView.findViewById(2131374346));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new aeml(this));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374348));
      this.jdField_d_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_d_of_type_AndroidViewView.findViewById(2131374347));
      this.jdField_d_of_type_AndroidWidgetImageSwitcher.setFactory(new aemm(this));
      this.jdField_b_of_type_Aenj = new aenj(this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_d_of_type_AndroidWidgetImageSwitcher, this.jdField_f_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bkfv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void A()
  {
    super.A();
  }
  
  public aenc a(arcs paramarcs, String paramString, short paramShort, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ("com.cmshow.game.android".equals(paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_tab_game", 0, 0);
    }
    Object localObject;
    short s;
    String str;
    if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))
    {
      paramString = a("vipGameCenter");
      List localList;
      int m;
      if (TextUtils.isEmpty(paramString))
      {
        paramString = paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;
        QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use plugin info url=" + paramString);
        localObject = paramString;
        s = paramShort;
        if (!paramBoolean1) {
          break label367;
        }
        str = "-1";
        localList = ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId)).missions.get();
        localObject = str;
        if (localList == null) {
          break label304;
        }
        localObject = str;
        if (localList.size() <= 0) {
          break label304;
        }
        localObject = "-1";
        m = 0;
        label181:
        if (m >= localList.size()) {
          break label304;
        }
        if (m != 0) {
          break label263;
        }
      }
      label263:
      for (localObject = (String)localList.get(m);; localObject = (String)localObject + "_" + (String)localList.get(m))
      {
        m += 1;
        break label181;
        if (paramString.startsWith("http")) {
          paramShort = 0;
        }
        QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use IndividuationUrl url=" + paramString);
        break;
      }
      label304:
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
      label367:
      if (paramBoolean2)
      {
        if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 0L) {
          break label608;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          paramBoolean3 = true;
        }
      }
      label404:
      label608:
      for (;;)
      {
        pmy.a().b((int)paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean3);
        for (;;)
        {
          paramString = new aenc();
          paramString.jdField_a_of_type_JavaLangString = ((String)localObject);
          paramString.jdField_a_of_type_Short = s;
          paramString.jdField_b_of_type_Boolean = paramBoolean3;
          paramString.jdField_c_of_type_Boolean = paramBoolean1;
          paramString.jdField_d_of_type_Boolean = paramBoolean2;
          paramString.jdField_a_of_type_Arcs = paramarcs;
          return paramString;
          if (paramShort != 2) {
            break label611;
          }
          str = bgng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramString).b("url");
          paramString = paramString.replace(str, str + URLEncoder.encode(new StringBuilder().append("&missions=").append((String)localObject).toString()));
          break;
          paramBoolean3 = false;
          break label404;
          pmy.a().b((int)paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean1);
          if ("com.tx.xingqubuluo.android".equals(paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
            paramBoolean3 = paramBoolean1;
          }
          if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 7966L) {
            paramBoolean3 = paramBoolean1;
          }
        }
      }
      label611:
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559310, null);
    this.jdField_a_of_type_Ajvd = new ajvd();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public bgmp a(arcs paramarcs, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bgmp parambgmp)
  {
    if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
      parambgmp.e("platformId=qq_m");
    }
    do
    {
      return parambgmp;
      if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.xingqubuluo.android")) {
        return b(paramarcs, paramAppInfo, parambgmp);
      }
      if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.read.android"))
      {
        parambgmp.a("ChannelID", "100020");
        return parambgmp;
      }
    } while (!a(paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
    return c(paramarcs, paramAppInfo, parambgmp);
  }
  
  public bgmp a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    return bgng.a(paramQQAppInterface, paramContext, paramString);
  }
  
  public String a()
  {
    return anni.a(2131704804);
  }
  
  public String a(String paramString)
  {
    return bgyg.a(paramString);
  }
  
  public void a()
  {
    super.a();
    j();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onAccountChanged");
    }
    if (this.jdField_a_of_type_Aenj != null) {
      this.jdField_a_of_type_Aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_b_of_type_Aenj != null) {
      this.jdField_b_of_type_Aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    L();
    ajvi.a().a();
    I();
    if (this.jdField_a_of_type_Avri != null) {
      this.jdField_a_of_type_Avri.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    viy.a().a(4, null, null);
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
  
  public void a(aenc paramaenc)
  {
    Object localObject2 = paramaenc.jdField_a_of_type_JavaLangString;
    Object localObject1 = paramaenc.jdField_b_of_type_JavaLangString;
    int m = paramaenc.jdField_a_of_type_Short;
    boolean bool1 = paramaenc.jdField_a_of_type_Boolean;
    boolean bool2 = paramaenc.jdField_b_of_type_Boolean;
    String str1 = paramaenc.jdField_c_of_type_JavaLangString;
    boolean bool3 = paramaenc.jdField_c_of_type_Boolean;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramaenc.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
    int n = paramaenc.jdField_a_of_type_Int;
    int i1 = paramaenc.jdField_b_of_type_Int;
    Object localObject3 = paramaenc.jdField_a_of_type_AndroidViewView;
    boolean bool4 = paramaenc.jdField_d_of_type_Boolean;
    localObject3 = paramaenc.jdField_a_of_type_Arcs;
    baif localbaif = paramaenc.jdField_a_of_type_Baif;
    if ((localObject2 == null) || ("".equals(localObject2))) {
      a((arcs)localObject3, localAppInfo, localbaif);
    }
    String str2;
    do
    {
      return;
      str2 = (String)avrh.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((arcs)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      if (m != 0) {
        break;
      }
      localObject1 = localObject2;
      if (((String)localObject2).contains("plg_uin=1")) {
        localObject1 = (String)localObject2 + "&mqquin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      paramaenc = (aenc)localObject1;
      if (((String)localObject1).contains("plg_vkey=1")) {
        paramaenc = (String)localObject1 + "&mqqvkey=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
      }
      localObject2 = a(QQBrowserActivity.class);
      if (paramaenc.contains("plg_nld=1")) {
        ((Intent)localObject2).putExtra("reportNld", true);
      }
      localObject1 = paramaenc;
      if (!TextUtils.isEmpty(str1))
      {
        ((Intent)localObject2).putExtra("redTouch", str1);
        localObject1 = paramaenc;
        if (paramaenc.contains("red_touch=1")) {
          localObject1 = paramaenc + "&" + str1;
        }
      }
      this.jdField_b_of_type_Aval.b();
      ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject2).putExtra("plugin_start_time", System.nanoTime());
      ((Intent)localObject2).putExtra("click_start_time", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("is_from_leba", true);
      ((Intent)localObject2).putExtra("leba_resid", ((arcs)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
      ((Intent)localObject2).putExtra("has_red_dot", bool2);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      if (!TextUtils.isEmpty(str2)) {
        ((Intent)localObject2).putExtra("big_brother_source_key", str2);
      }
    } while (!a((arcs)localObject3, (String)localObject1, (Intent)localObject2, bool3, bool2, localAppInfo));
    a((Intent)localObject2);
    while (m != 2)
    {
      a((arcs)localObject3, localAppInfo, localbaif);
      b((arcs)localObject3);
      return;
    }
    paramaenc = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject2);
    if (paramaenc != null)
    {
      paramaenc = a((arcs)localObject3, localAppInfo, paramaenc);
      paramaenc.a("from_leba", "fromleba");
      paramaenc.a("leba_resid", String.valueOf(((arcs)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      paramaenc.a("config_res_plugin_item_name", (String)localObject1);
      paramaenc.a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
      paramaenc.a(bool1);
      paramaenc.c(((arcs)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
      paramaenc.f(str1);
      paramaenc.b(bool2);
      paramaenc.a(localAppInfo);
      if (!TextUtils.isEmpty(str2)) {
        paramaenc.a("download_sourceid", str2);
      }
      if ((((arcs)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 8059L) || (!MiniAppLauncher.isMiniAppUrl((String)localObject2))) {
        break label716;
      }
      MiniAppLauncher.startMiniApp(a(), (String)localObject2, 2050, null);
    }
    for (;;)
    {
      bkgb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (arcs)localObject3, n, i1);
      if (this.jdField_a_of_type_JavaUtilSet.contains(((arcs)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
        this.jdField_b_of_type_Aval.b();
      }
      a((arcs)localObject3);
      break;
      label716:
      a(paramaenc);
    }
  }
  
  public void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      odu localodu = (odu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      String str1 = String.valueOf(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = bkgj.a(str2, "code", paramMessage.auth_code.get());
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
          if (localodu != null) {
            localodu.a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localodu != null) {
            localodu.a(134246777, null, "not_jump", str1, "", 0L, false);
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
          if (localodu != null) {
            localodu.a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
      }
    }
  }
  
  public void a(View paramView, arcs paramarcs)
  {
    if (c()) {
      ThreadManager.post(new Leba.18(this, paramView, paramarcs), 8, null, true);
    }
  }
  
  public void a(View paramView, arcs paramarcs, avrw paramavrw)
  {
    if ((paramarcs == null) || (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "onPluginClick item == null || item.info == null");
      return;
    }
    for (;;)
    {
      try
      {
        QLog.i("Q.lebatab.leba", 1, "onPluginClick item = " + paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.toString());
        a(paramavrw);
        paramavrw = (baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if ((paramarcs != null) && (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == noq.jdField_a_of_type_Int))
        {
          yqu.a("dynamic", "clk_story", 0, ((njg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).c(), new String[0]);
          a(paramView, paramarcs);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.w("Q.lebatab.leba", 1, "onPluginClick", paramView);
        return;
      }
      if ((paramarcs != null) && (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7719L == paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        E();
        paramavrw.a(100510, 31);
        return;
      }
      if ((paramarcs != null) && (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (826L == paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        c(paramView, paramarcs);
        return;
      }
      if ((paramarcs != null) && (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7720L == paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        ExtendFriendPublicFragmentActivity.a(a(), 2);
        if ((paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId <= 0L)) {
          break;
        }
        paramavrw.a((int)paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, 31);
        return;
      }
      if ((paramarcs != null) && (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7759L == paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        aqji localaqji = ((aqjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
        String str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramavrw = str;
        if (localaqji != null)
        {
          paramavrw = str;
          if (!TextUtils.isEmpty(localaqji.l)) {
            paramavrw = localaqji.l;
          }
        }
        paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = paramavrw;
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean, arcs paramarcs)
  {
    if ((paramarcs == null) || (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    String str1 = paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;
    String str2 = paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName;
    short s = paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sResSubType;
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
    paramarcs = a(paramarcs, str1, s, bool1, paramBoolean, false);
    arcs localarcs = paramarcs.jdField_a_of_type_Arcs;
    str1 = paramarcs.jdField_a_of_type_JavaLangString;
    s = paramarcs.jdField_a_of_type_Short;
    bool3 = paramarcs.jdField_c_of_type_Boolean;
    boolean bool4 = paramarcs.jdField_d_of_type_Boolean;
    paramBoolean = paramarcs.jdField_b_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str2 + ",url=" + str1 + ",type=" + s);
    }
    baif localbaif = (baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localbaif.a(localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "");
    int i1 = 0;
    int n = 0;
    int i2 = 0;
    int m = 0;
    if (localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId > 0L) {
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
      {
        str1 = blyl.a(str1, localAppInfo);
        if (localAppInfo.type.get() == 0) {
          paramBoolean = true;
        }
        if (!localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
          break label842;
        }
        paramBoolean |= true;
      }
    }
    label517:
    label554:
    label842:
    for (;;)
    {
      new ArrayList();
      if ((localAppInfo.red_display_info != null) && (localAppInfo.red_display_info.red_type_info != null))
      {
        paramarcs = localAppInfo.red_display_info.red_type_info.get();
        if ((paramarcs == null) || (paramarcs.size() < 2)) {}
      }
      for (m = ((BusinessInfoCheckUpdate.RedTypeInfo)paramarcs.get(1)).red_type.get();; m = 0)
      {
        i1 = localAppInfo.num.get();
        paramarcs = "status=" + m + "&number=" + i1 + "&path=" + localAppInfo.path.get();
        n = m;
        m = i1;
        Object localObject = (bccg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
        if (localObject != null) {
          if (((bccg)localObject).a(localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "") != -1)
          {
            bool1 = true;
            if (!bool4) {
              break label749;
            }
            localbaif.b(localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "");
            bool2 = bool1;
            if (bool1) {
              a(new Leba.21(this));
            }
          }
        }
        for (bool2 = bool1;; bool2 = false)
        {
          bool1 = paramBoolean;
          paramBoolean = bool2;
          for (;;)
          {
            localObject = new aenc();
            ((aenc)localObject).jdField_a_of_type_JavaLangString = str1;
            ((aenc)localObject).jdField_b_of_type_JavaLangString = str2;
            ((aenc)localObject).jdField_a_of_type_Short = s;
            ((aenc)localObject).jdField_a_of_type_Boolean = paramBoolean;
            ((aenc)localObject).jdField_b_of_type_Boolean = bool1;
            ((aenc)localObject).jdField_c_of_type_JavaLangString = paramarcs;
            ((aenc)localObject).jdField_c_of_type_Boolean = bool3;
            ((aenc)localObject).jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localAppInfo;
            ((aenc)localObject).jdField_a_of_type_Int = n;
            ((aenc)localObject).jdField_b_of_type_Int = m;
            ((aenc)localObject).jdField_a_of_type_AndroidViewView = paramView;
            ((aenc)localObject).jdField_d_of_type_Boolean = bool4;
            ((aenc)localObject).jdField_a_of_type_Arcs = localarcs;
            ((aenc)localObject).jdField_a_of_type_Baif = localbaif;
            a((aenc)localObject);
            return;
            paramarcs = "status=" + -1 + "&number=0" + "&path=" + localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
            break;
            bool1 = false;
            break label517;
            label749:
            localbaif.a((int)localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, 31);
            break label554;
            if (localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
            {
              bool2 = a(false);
              paramarcs = null;
              bool1 = paramBoolean;
              m = i2;
              n = i1;
              paramBoolean = bool2;
            }
            else
            {
              paramarcs = null;
              bool1 = paramBoolean;
              m = i2;
              n = i1;
              paramBoolean = bool2;
            }
          }
        }
      }
    }
  }
  
  public void a(arcs paramarcs)
  {
    if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
    {
      bcts.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bcts.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_Aval.b();
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
      paramarcs = (bccv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (paramarcs != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
        }
        paramarcs.a(true);
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
    }
  }
  
  protected void a(arcs paramarcs, BusinessInfoCheckUpdate.AppInfo paramAppInfo, baif parambaif)
  {
    if ((paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId > 0L))
    {
      parambaif = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      String str = String.valueOf(paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
      if ((paramAppInfo != null) && (parambaif != null) && (parambaif.a(str))) {
        ThreadManager.getFileThreadHandler().post(new Leba.25(this, str, paramAppInfo));
      }
      if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals(bhtw.jdField_a_of_type_JavaLangString)) {
        ThreadManager.post(new Leba.26(this), 5, null, false);
      }
      if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 7759L) {
        aqjq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  protected void a(bgmp parambgmp)
  {
    if (parambgmp != null) {
      parambgmp.a();
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    VipUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, new String[0]);
  }
  
  void a(String paramString)
  {
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).c(paramString);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, aenb paramaenb)
  {
    if (paramaenb == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramaenb.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.lebatab.leba", 1, paramString, new Object[0]);
      paramaenb.a();
      return;
    }
    String str1;
    int m;
    if (paramString.equals(a().getString(2131693195)))
    {
      str1 = a().getString(2131693192);
      paramString = a().getString(2131693197);
      m = 1;
    }
    for (;;)
    {
      if (m != 0)
      {
        SharedPreferences localSharedPreferences = a().getSharedPreferences("laba_and_qwallet_check_enter", 4);
        if (localSharedPreferences != null)
        {
          String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          str2 = bisz.a("check_app_exemption__" + str2 + "_" + paramString);
          boolean bool = localSharedPreferences.getBoolean(str2, false);
          QLog.i("Q.lebatab.leba", 1, "checkEnterApp..checkKey:" + str2 + ",hasCheck:" + bool + "，checkName：" + paramString);
          if (!bool)
          {
            a(new Leba.42(this, str1, localSharedPreferences, str2, paramaenb));
            return;
            if (paramString.equals(a().getString(2131693194)))
            {
              str1 = a().getString(2131693191);
              paramString = a().getString(2131693196);
              m = 1;
              continue;
            }
            if (!paramString.equals(a().getString(2131693193))) {
              break label320;
            }
            str1 = a().getString(2131693190);
            m = 1;
            continue;
          }
        }
      }
      paramaenb.a();
      return;
      label320:
      paramString = null;
      str1 = null;
      m = 0;
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
    pmy.a().a(3, paramBoolean);
    this.jdField_a_of_type_Bkfv.postDelayed(new Leba.9(this, paramBoolean, paramRedTypeInfo), 150L);
    LpReportInfo_pf00064.allReport(637, 31, 1);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == noq.jdField_a_of_type_Int;
  }
  
  public boolean a(arcs paramarcs, String paramString, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int m = 0;
    if ((paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 3053L) && (paramString.indexOf("fetchCode=1") > -1))
    {
      long l = NetConnInfoCenter.getServerTime();
      if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
        }
        paramIntent.putExtra("url", bkgj.a(paramString, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
        a(paramIntent);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        a(paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
        paramarcs = (odu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
        if (paramarcs != null) {
          paramarcs.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
        }
        return false;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      a(paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
      this.jdField_a_of_type_Bkfv.sendEmptyMessageDelayed(1134007, 1000L);
      return false;
    }
    if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 5647L)
    {
      StringBuilder localStringBuilder;
      if (!paramString.contains("?"))
      {
        paramString = paramString + "?hasRedDot=" + paramBoolean2;
        if ((!paramBoolean2) || (paramAppInfo == null)) {
          break label521;
        }
        localStringBuilder = new StringBuilder();
        paramAppInfo = paramAppInfo.missions.get();
        if (paramAppInfo.size() <= 0) {
          break label424;
        }
        label315:
        if (m >= paramAppInfo.size()) {
          break label424;
        }
        if (m != paramAppInfo.size() - 1) {
          break label397;
        }
        localStringBuilder.append((String)paramAppInfo.get(m));
      }
      for (;;)
      {
        m += 1;
        break label315;
        paramString = paramString + "&hasRedDot=" + paramBoolean2;
        break;
        label397:
        localStringBuilder.append((String)paramAppInfo.get(m)).append("_");
      }
      label424:
      paramString = paramString + "&missions=" + localStringBuilder.toString();
    }
    label521:
    for (;;)
    {
      paramIntent.putExtra("url", paramString);
      if ("com.cmshow.game.android".equals(paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))
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
    bccv localbccv = (bccv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    boolean bool = paramBoolean;
    if (localbccv != null) {
      if (localbccv.a(2) <= 0)
      {
        bool = paramBoolean;
        if (localbccv.a(1) <= 0) {}
      }
      else
      {
        bool = true;
      }
    }
    return bool;
  }
  
  public void am_()
  {
    this.jdField_a_of_type_Bkfv.post(new Leba.2(this));
  }
  
  public bgmp b(arcs paramarcs, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bgmp parambgmp)
  {
    paramarcs = (njg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramarcs.d();
    if (m > 0) {
      localStringBuffer.append("redid=" + m);
    }
    int n = paramarcs.a();
    if (n > 0) {
      if (localStringBuffer.length() != 0) {
        break label255;
      }
    }
    label255:
    for (paramarcs = "";; paramarcs = "&rpnumber=" + n)
    {
      localStringBuffer.append(paramarcs);
      QLog.i("Leba", 1, "xqbl redid=" + m + ",rpnumber=" + n);
      try
      {
        paramarcs = new JSONObject(paramAppInfo.buffer.get());
        if (paramarcs != null)
        {
          paramarcs = paramarcs.optJSONObject("param");
          if (paramarcs != null)
          {
            paramAppInfo = paramarcs.optJSONObject((String)paramAppInfo.missions.get(0));
            if (paramAppInfo != null)
            {
              paramarcs = paramAppInfo.optString("_red_ext_bid");
              paramAppInfo = paramAppInfo.optString("_red_ext_pid");
              if (!TextUtils.isEmpty(paramarcs)) {
                localStringBuffer.append("&bid=").append(paramarcs);
              }
              if (!TextUtils.isEmpty(paramAppInfo)) {
                localStringBuffer.append("&pid=").append(paramAppInfo);
              }
            }
          }
        }
      }
      catch (Exception paramarcs)
      {
        for (;;)
        {
          QLog.i("Leba", 1, "handerSpecialWhenJumpScheme", paramarcs);
        }
      }
      if (localStringBuffer.length() > 0) {
        parambgmp.e(localStringBuffer.toString());
      }
      return parambgmp;
    }
  }
  
  public void b(View paramView, arcs paramarcs)
  {
    if ((paramarcs == null) || (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    a(paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, new aemn(this, paramView, paramarcs));
  }
  
  public void b(arcs paramarcs)
  {
    if (paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) {
      bctj.a(a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
    }
    if (paramarcs.jdField_a_of_type_Long == 1047L) {
      aysz.a().jdField_a_of_type_Int = 4;
    }
    a(new Leba.44(this));
    if (!paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist")) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      y();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_Bkfv);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayev);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ayet);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayes);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anmu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aooo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anry);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aniz, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Axcd);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asgf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver);
      bdch.a(this.jdField_a_of_type_Bdci);
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
    return this.jdField_b_of_type_Boolean;
  }
  
  public bgmp c(arcs paramarcs, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bgmp parambgmp)
  {
    Object localObject = (njg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    paramAppInfo = ((njg)localObject).a();
    paramarcs = paramAppInfo;
    if (paramAppInfo == null)
    {
      paramarcs = paramAppInfo;
      if (((wsm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "check invisible red point for msgtab");
        }
        paramarcs = ((njg)localObject).a(52);
        if (paramarcs != null) {
          break label223;
        }
        paramarcs = ((njg)localObject).a(35);
      }
    }
    label223:
    for (;;)
    {
      paramAppInfo = parambgmp;
      if (paramarcs != null)
      {
        paramAppInfo = parambgmp;
        if (paramarcs.uint32_appid.get() == 37) {
          localObject = null;
        }
      }
      try
      {
        paramAppInfo = new JSONObject(paramarcs.str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
        localObject = paramAppInfo;
      }
      catch (Exception paramAppInfo)
      {
        for (;;)
        {
          yqp.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { paramAppInfo.getMessage() });
          continue;
          paramarcs = String.valueOf(paramarcs.uint32_appid.get());
        }
      }
      paramAppInfo = parambgmp;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppInfo = bgng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject);
      }
      if (paramarcs == null)
      {
        paramarcs = "";
        paramAppInfo.a("redid", paramarcs);
        paramAppInfo.a("lebaVersion", "old");
        return paramAppInfo;
      }
    }
  }
  
  public void c()
  {
    super.c();
    x();
    if (this.jdField_a_of_type_Aenj != null) {
      this.jdField_a_of_type_Aenj.d();
    }
    if (this.jdField_b_of_type_Aenj != null) {
      this.jdField_b_of_type_Aenj.d();
    }
  }
  
  void c(View paramView, arcs paramarcs)
  {
    if (paramarcs == null) {
      return;
    }
    paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = anov.jdField_a_of_type_JavaLangString;
    String str = bgsg.c(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {
      paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = str.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("enterXQBL", 2, "跳转url = " + paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
    }
    b(paramView, paramarcs);
    O();
    bcst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
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
      bool2 = this.i;
      if (this.i)
      {
        this.i = false;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.postDelayed(new Leba.19(this), 1000L);
        return bool2;
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
    return bool2;
  }
  
  public void e()
  {
    super.e();
    w();
    P();
    ((ViewStub)a(2131377975)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131364839)).setOnFirstDrawListener(this);
    this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
    QzoneConfig.getInstance().addListener(this);
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onResume" + ajvi.jdField_a_of_type_Int);
    }
    AbstractGifImage.resumeAll();
    pmy.a().c();
    if (this.jdField_g_of_type_Boolean)
    {
      ThreadRegulator.a().b(4);
      this.jdField_g_of_type_Boolean = false;
    }
    aezt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Aenj != null) {
      this.jdField_a_of_type_Aenj.c();
    }
    if (this.jdField_b_of_type_Aenj != null) {
      this.jdField_b_of_type_Aenj.c();
    }
    ThreadManager.post(new Leba.4(this), 5, null, false);
    ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    if ((!this.jdField_b_of_type_Boolean) || ((ajvi.jdField_a_of_type_Int & 0x4) != 0)) {
      this.jdField_a_of_type_Bkfv.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.c(true);
      this.jdField_a_of_type_Bkfv.postDelayed(new Leba.5(this), 100L);
      ThreadManagerV2.excute(new Leba.6(this, (axby)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
      N();
      Object localObject;
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_h_of_type_AndroidWidgetTextView.setFocusable(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(2131690973));
        localObject = a(2131693458);
        this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131693458));
      }
      if (this.jdField_a_of_type_Ajvd != null) {
        this.jdField_a_of_type_Ajvd.a();
      }
      if (this.jdField_a_of_type_Avri != null) {
        this.jdField_a_of_type_Avri.b(true);
      }
      ApngImage.playByTag(4);
      if ((paramBoolean) && (!this.jdField_f_of_type_Boolean) && (a() != null))
      {
        this.jdField_f_of_type_Boolean = true;
        ThreadManagerV2.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
      }
      return;
      if (ajvi.jdField_a_of_type_Int > 0)
      {
        localObject = new ArrayList();
        anoy.a((List)localObject, ajvi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
          if (this.jdField_a_of_type_Ajvd != null)
          {
            this.jdField_a_of_type_Ajvd.b();
            I();
          }
        }
        ajvi.jdField_a_of_type_Int = 0;
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
    this.jdField_a_of_type_Aval.d();
    this.jdField_b_of_type_Aval.d();
    axdl.c(0);
    this.jdField_a_of_type_Bkfv.removeMessages(1134010);
    if (this.jdField_a_of_type_Aenj != null) {
      this.jdField_a_of_type_Aenj.b();
    }
    if (this.jdField_b_of_type_Aenj != null) {
      this.jdField_b_of_type_Aenj.b();
    }
    if (this.jdField_a_of_type_Ajvd != null) {
      this.jdField_a_of_type_Ajvd.a(b(), e(), c());
    }
    if (this.jdField_a_of_type_Avri != null) {
      this.jdField_a_of_type_Avri.c();
    }
    this.jdField_a_of_type_Bkfv.postDelayed(new Leba.3(this), 500L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onPause");
    }
    this.j = true;
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
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onSwitchOutofLeba");
    }
  }
  
  protected void j()
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (!bbum.a()) {
        break label26;
      }
    }
    label26:
    for (int m = 0;; m = 8)
    {
      localRelativeLayout.setVisibility(m);
      return;
    }
  }
  
  public void k()
  {
    x();
    if (this.jdField_a_of_type_Aenj != null) {
      this.jdField_a_of_type_Aenj.d();
    }
    if (this.jdField_b_of_type_Aenj != null) {
      this.jdField_b_of_type_Aenj.d();
    }
    if (this.jdField_a_of_type_Avri != null) {
      this.jdField_a_of_type_Avri.d();
    }
    super.k();
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.post(new Leba.10(this), 10, null, false);
    WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.a(202);
    }
  }
  
  protected void m()
  {
    Object localObject = (baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    int n;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((baif)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        n = 0;
        int m = n;
        if (n == -1)
        {
          localAppInfo = ((baif)localObject).a("886.100171");
          m = n;
          if (localAppInfo != null)
          {
            m = n;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              m = n;
              if (localAppInfo.type.get() != -1) {
                m = 1;
              }
            }
          }
        }
        n = m;
        if (m == -1)
        {
          localObject = ((baif)localObject).a("886.100172");
          n = m;
          if (localObject != null)
          {
            n = m;
            if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)
            {
              n = m;
              if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != -1) {
                n = 2;
              }
            }
          }
        }
        if (n != -1) {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, n + "", "", "", "");
        }
        if (((njg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).a()) {
          axzx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "entry", "official_push_exp");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "ReportTroopAndActivityStatics, redDotFrom=" + n);
      }
      return;
      n = -1;
      break;
      n = -1;
    }
  }
  
  void n()
  {
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, 4, 2130838759, "-leba-");
    if (ThemeUtil.isNowThemeIsAnimate()) {
      this.jdField_e_of_type_Boolean = true;
    }
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
      case 2131368961: 
      case 2131368979: 
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
        H();
        break;
      case 2131374344: 
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_enable_splash", true);
        ((Intent)localObject).putExtra("key_jump_from", "3");
        if (((!this.k) || (this.jdField_e_of_type_Int <= 0)) && (this.jdField_d_of_type_Int <= 0)) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject).putExtra("key_enable_page_memory_cache", bool);
          uxo.a(a(), (Intent)localObject);
          R();
          G();
          a(1);
          break;
        }
      case 2131375355: 
        if (QLog.isColorLevel()) {
          QLog.d("HardCoder", 2, "launch qzone");
        }
        jdField_a_of_type_Int = addy.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootQzone");
        localObject = (arcs)ajvi.a().jdField_a_of_type_JavaUtilHashMap.get("qzone_feedlist");
        QLog.d("Q.lebatab.leba", 1, "user clicked qzone feed entry.");
        ThreadManager.postImmediately(new Leba.33(this, (arcs)localObject), null, true);
        Q();
        MiniSdkLauncher.preLaunchMiniAppCheckinFromLeba();
      }
    }
  }
  
  public void onConfigChange()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      QLog.d("Leba", 1, "onConfigChange");
      this.jdField_c_of_type_Boolean = false;
      a(new Leba.41(this));
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    b(false);
    if (!this.jdField_b_of_type_Boolean) {
      e(true);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      return;
      if (this.jdField_e_of_type_Boolean)
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
    } while (this.jdField_a_of_type_Ajvd == null);
    this.jdField_a_of_type_Ajvd.a(paramAbsListView, paramInt);
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onPostThemeChanged");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(null);
    }
    n();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-1);
      bcnj.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Bkfv.sendEmptyMessageDelayed(11340002, 0L);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        if (!bcnj.a()) {
          break label243;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ajvd != null) {
        this.jdField_a_of_type_Ajvd.c();
      }
      if (this.jdField_a_of_type_Aenj != null) {
        this.jdField_a_of_type_Aenj.e();
      }
      if (this.jdField_b_of_type_Aenj != null) {
        this.jdField_b_of_type_Aenj.e();
      }
      if (this.jdField_a_of_type_Avri != null) {
        this.jdField_a_of_type_Avri.f();
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        TextHook.updateFont(this.jdField_b_of_type_AndroidViewView);
      }
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850087);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166983));
      break;
      label243:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void q()
  {
    QLog.d("Leba", 1, "onLebaTabChange");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      awnb localawnb = (awnb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      bccx.jdField_a_of_type_Boolean = true;
      if (localawnb != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localawnb.a(3);
      }
      viy.a().a(3, null, null);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.e();
      }
    }
    if (!d()) {
      D();
    }
    a(2);
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)) {}
    odu localodu;
    do
    {
      return;
      localodu = (odu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localodu == null);
    localodu.a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */