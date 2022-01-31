package com.tencent.mobileqq.activity;

import abws;
import adfs;
import adft;
import adfu;
import adfv;
import adfw;
import adfx;
import adfy;
import adfz;
import adga;
import adgb;
import adgc;
import adgd;
import adge;
import adgf;
import adgg;
import adgh;
import adgi;
import adgk;
import adgm;
import adgp;
import adgt;
import adtj;
import aieq;
import aieu;
import alpq;
import alsn;
import altm;
import alud;
import alvp;
import alvr;
import alzr;
import amph;
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
import aoiq;
import aoiu;
import aoiy;
import aozs;
import aqbl;
import astc;
import atkq;
import atkr;
import atkv;
import atkw;
import atky;
import atli;
import atlk;
import atwq;
import aufx;
import auul;
import auuo;
import auuq;
import auwc;
import auwq;
import auwz;
import avsm;
import avsn;
import avva;
import avvb;
import avvd;
import awfa;
import axlx;
import ayvj;
import azbi;
import azbw;
import azmk;
import azpt;
import azqs;
import azqx;
import azri;
import azrq;
import azte;
import babd;
import babe;
import bczz;
import bdgz;
import bdhk;
import bdib;
import bdne;
import bdtg;
import bdug;
import bems;
import bflq;
import bhsl;
import bhsr;
import bhsz;
import bhtv;
import bibv;
import bilp;
import bjkd;
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
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
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
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
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
import nag;
import nan;
import nga;
import nup;
import org.json.JSONException;
import org.json.JSONObject;
import oxp;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;
import tqs;
import tzv;
import uza;
import wxe;
import wxj;

public class Leba
  extends alsn
  implements adgp, aieu, View.OnClickListener, ViewStub.OnInflateListener, atky, bhtv, bilp
{
  public static int a;
  static long jdField_b_of_type_Long;
  private static List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_d_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_e_of_type_JavaUtilList = new ArrayList();
  protected final long a;
  private adgt jdField_a_of_type_Adgt;
  private alpq jdField_a_of_type_Alpq = new adgh(this);
  altm jdField_a_of_type_Altm = new adgf(this);
  private alzr jdField_a_of_type_Alzr = new adge(this);
  private amph jdField_a_of_type_Amph = new adgd(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new adft(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqbl jdField_a_of_type_Aqbl = new adgi(this);
  private astc jdField_a_of_type_Astc = new astc("qzone_leba", "com.tencent.mobileqq:qzone");
  private atkr jdField_a_of_type_Atkr;
  private atkv jdField_a_of_type_Atkv;
  auuq jdField_a_of_type_Auuq = new adgg(this);
  private avva jdField_a_of_type_Avva = new adgc(this);
  private avvb jdField_a_of_type_Avvb = new adgb(this);
  private avvd jdField_a_of_type_Avvd = new adga(this);
  babe jdField_a_of_type_Babe = new adgk(this);
  public bhsl a;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new adfs(this);
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
  private adgt jdField_b_of_type_Adgt;
  private View jdField_b_of_type_AndroidViewView;
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private astc jdField_b_of_type_Astc = new astc("web_leba", "com.tencent.mobileqq:tool");
  private List<aozs> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageSwitcher jdField_c_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
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
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = atwq.a();
    this.jdField_a_of_type_JavaLangString = ("mobileMP" + System.currentTimeMillis());
    this.jdField_a_of_type_Long = 30000L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bhsl = new bhsl(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private void D()
  {
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131373640);
    if ((!QzoneConfig.isQQCircleShowLebaEntrance()) || (azmk.a())) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131369394));
      if ((this.jdField_d_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.jdField_d_of_type_AndroidWidgetImageView).setMaskShape(bibv.jdField_c_of_type_Int);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130844924);
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130839217);
      ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131373646)).setText(2131720578);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131373648));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131373647));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131373649));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_d_of_type_AndroidViewView.findViewById(2131373642));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new adfx(this));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131373644));
      this.jdField_d_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_d_of_type_AndroidViewView.findViewById(2131373643));
      this.jdField_d_of_type_AndroidWidgetImageSwitcher.setFactory(new adfy(this));
      this.jdField_b_of_type_Adgt = new adgt(this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_d_of_type_AndroidWidgetImageSwitcher, this.jdField_f_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bhsl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
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
    Object localObject3 = (axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    Object localObject2 = ((axlx)localObject3).a(String.valueOf(100510));
    ((avsm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160)).a(100510);
    aieq.jdField_a_of_type_Int |= 0x1;
    Object localObject1 = ((axlx)localObject3).a("100510.100517");
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
      ((axlx)localObject3).b("100510.100517");
      localObject3 = (nag)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43);
      ((nag)localObject3).a(60);
      ((nag)localObject3).a(59);
      localObject3 = (nan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
      if (((nan)localObject3).a())
      {
        avsn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "home", "official_push_click");
        if (this.jdField_c_of_type_Int != 0) {
          ThreadManagerV2.excute(new Leba.23(this, (auul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
        }
      }
      ((nan)localObject3).a(false);
      int n;
      boolean bool;
      if (this.jdField_a_of_type_Atkv == null)
      {
        n = -1;
        this.jdField_a_of_type_Bhsl.post(new Leba.24(this));
        ThreadManagerV2.excute(new Leba.25(this, (auul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
        if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) || (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 1)) {
          break label1073;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
        azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          auwz.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        auwc.b(0);
        if (!auwq.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
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
          new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_clk_red").a();
        }
        for (;;)
        {
          auuo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, n);
          if (bool) {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
          }
          oxp.a().a("FuJin", bool);
          return;
          n = this.jdField_a_of_type_Atkv.a();
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
            localObject1 = ((nan)localObject3).a(60);
            if ((localObject1 != null) && (((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get() == 1822701914L)) {
              new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_clk_red").a();
            } else {
              new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_clk_red").a();
            }
          }
          else if (n == 61)
          {
            new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_clk_red").a();
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
      aufx localaufx = (aufx)a().app.getManager(10);
      if (localaufx != null)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localaufx.a(3);
        }
        localaufx.a(false);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void G()
  {
    int m = a();
    if (m != 0) {
      tzv.a("", 1, 2L, m);
    }
  }
  
  private void H()
  {
    aieq.a().jdField_a_of_type_Boolean = true;
    ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("100600");
    a(new Intent(a(), LebaListMgrActivity.class));
  }
  
  private void I()
  {
    J();
    K();
    this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1134006, 200L);
    M();
    if ((this.jdField_a_of_type_Atkv != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Atkv.b();
    }
  }
  
  private void J()
  {
    ThreadManager.post(new Leba.36(this), 5, null, false);
  }
  
  private void K()
  {
    if ((!QzoneConfig.isQQCircleShowLebaEntrance()) || (azmk.a()) || (this.jdField_c_of_type_Boolean))
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
    ThreadManager.post(new Leba.37(this), 5, null, false);
  }
  
  private void L()
  {
    int m = a();
    if ((m != 0) && (this.j))
    {
      tzv.a("", 1, 1L, m);
      this.j = false;
    }
  }
  
  private void M()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("100600");
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).d(10).a().a(localAppInfo);
    a(localAppInfo);
  }
  
  private void N()
  {
    Object localObject = (nan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((nan)localObject).a(1);
      if (localRedDotInfo != null) {
        nag.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
      }
      localObject = ((nan)localObject).a(6);
      if (localObject != null) {
        nag.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject);
      }
    }
  }
  
  private void O()
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
  
  private void P()
  {
    atli localatli = new atli();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localatli.jdField_a_of_type_Boolean = bool;
      localatli.jdField_a_of_type_Long = 10000L;
      localatli.jdField_a_of_type_Int = 0;
      localatli.jdField_b_of_type_Int = b();
      localatli.jdField_d_of_type_Int = 2;
      if (this.jdField_a_of_type_Atkv != null) {
        localatli.jdField_d_of_type_Int = atlk.a(this.jdField_a_of_type_Atkv.b());
      }
      a(localatli);
      return;
    }
  }
  
  private void Q()
  {
    atli localatli = new atli();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localatli.jdField_a_of_type_Boolean = bool;
      localatli.jdField_a_of_type_Long = 10004L;
      localatli.jdField_a_of_type_Int = 0;
      localatli.jdField_b_of_type_Int = c();
      localatli.jdField_d_of_type_Int = 0;
      a(localatli);
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
  
  private aozs a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        aozs localaozs = (aozs)localIterator.next();
        if ((localaozs != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))) {
          return localaozs;
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_d_of_type_AndroidViewView != null) && ((this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) || (QzoneConfig.isQQCircleShowLebaEntrance())))
    {
      aieq.jdField_a_of_type_Int |= 0x2;
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
      QLog.d("Leba", 1, "showQQCircleRedDot: " + paramInt + ", " + paramBoolean + ", " + m);
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
      a(new Leba.38(this, paramInt, paramBoolean, m, paramList));
      return;
    }
  }
  
  private void a(atli paramatli)
  {
    if (paramatli == null)
    {
      QLog.i("Q.lebatab.leba", 1, "reportPluginClick  reportInfo == null ");
      return;
    }
    QLog.i("Q.lebatab.leba", 1, String.format("reportPluginClick id = %d pos = %d type = %d mode = %b hasAssistsText = %d", new Object[] { Long.valueOf(paramatli.jdField_a_of_type_Long), Integer.valueOf(paramatli.jdField_a_of_type_Int), Integer.valueOf(paramatli.jdField_b_of_type_Int), Boolean.valueOf(paramatli.jdField_a_of_type_Boolean), Integer.valueOf(paramatli.jdField_c_of_type_Int) }));
    if (paramatli.jdField_a_of_type_Boolean)
    {
      azte localazte = atlk.a("plugin_clk");
      localazte.jdField_a_of_type_JavaLangString = String.valueOf(paramatli.jdField_a_of_type_Long);
      localazte.c = String.valueOf(paramatli.jdField_a_of_type_Int);
      localazte.d = String.valueOf(paramatli.jdField_b_of_type_Int);
      localazte.e = String.valueOf(paramatli.jdField_c_of_type_Int);
      localazte.f = String.valueOf(paramatli.jdField_d_of_type_Int);
      localazte.g = ThemeUtil.getCurrentThemeId();
      azpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazte);
      return;
    }
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(paramatli.jdField_a_of_type_Long), String.valueOf(paramatli.jdField_a_of_type_Int), String.valueOf(paramatli.jdField_b_of_type_Int), "");
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
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
    Object localObject2 = bdtg.a("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((aozs)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((aozs)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((bdhk)localObject3).b("url");
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
    t();
    int m = atlk.a(paramBoolean, paramRedTypeInfo);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(m), "");
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
      r();
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
  
  private boolean d()
  {
    return (this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  private boolean f()
  {
    return (this.jdField_a_of_type_Atkv != null) && (this.jdField_a_of_type_Atkv.b() == 1);
  }
  
  private void t()
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
    u();
  }
  
  private void u()
  {
    ThreadManager.executeOnSubThread(new Leba.8(this));
  }
  
  private void v()
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
    if ((localObject1 != null) && (((aozs)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {}
    for (long l1 = ((aozs)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;; l1 = 489L)
    {
      localObject1 = (axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      Object localObject2 = ((axlx)localObject1).a("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((axlx)localObject1).a(String.valueOf(l1));
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
        ((axlx)localObject1).b(String.valueOf("200010.200011"));
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
  
  private void w()
  {
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_Boolean = true;
      QLog.d("Leba", 1, "hideQQCircleAfterAccountChanged");
    }
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131378030));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377957));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131375863));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369338));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)a(2131368670));
    this.jdField_h_of_type_AndroidWidgetTextView.setText(2131720587);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131368638));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (azmk.a()) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_b_of_type_AndroidWidgetImageView).a(53).d(10).a();
    M();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      azmk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849536);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166900));
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Avvd);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Avvb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Avva);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amph);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alzr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alpq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Auuq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqbl);
      babd.b(this.jdField_a_of_type_Babe);
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131369340));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369331));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(a().getDrawable(2130849646));
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
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561014, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
        this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131374634);
        localObject = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369394);
        if ((localObject instanceof ThemeImageView)) {
          ((ThemeImageView)localObject).setMaskShape(bibv.jdField_c_of_type_Int);
        }
        ((ImageView)localObject).setImageResource(2130844923);
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839217);
        ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369395)).setText(2131720579);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374636));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374680));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374840));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375175));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131374637));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new adfu(this));
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374649));
        this.jdField_c_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131374638));
        this.jdField_c_of_type_AndroidWidgetImageSwitcher.setFactory(new adfv(this));
        D();
        this.jdField_a_of_type_Adgt = new adgt(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_c_of_type_AndroidWidgetImageSwitcher, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bhsl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376034));
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369330));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131365851));
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        bczz.a(this.jdField_a_of_type_AndroidWidgetEditText, a(2131691212));
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131378988));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363522));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_h_of_type_Boolean = BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("has_search_bar", false);
        j();
        this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new adfw(this));
        if (AppSetting.jdField_c_of_type_Boolean) {
          bczz.b(this.jdField_b_of_type_AndroidViewView);
        }
        alud.a(2131720579);
        bczz.b(this.jdField_c_of_type_AndroidViewView, Button.class.getName());
      }
      if (this.jdField_a_of_type_Atkv != null)
      {
        localObject = new atkw();
        ((atkw)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ((atkw)localObject).jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
        ((atkw)localObject).jdField_a_of_type_AndroidContentContext = a();
        ((atkw)localObject).jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
        ((atkw)localObject).jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
        ((atkw)localObject).jdField_a_of_type_Atky = this;
        this.jdField_a_of_type_Atkv.a((atkw)localObject);
      }
      if (this.jdField_a_of_type_Atkr == null)
      {
        this.jdField_a_of_type_Atkr = new atkr(a());
        this.jdField_a_of_type_Atkr.a(this.jdField_a_of_type_AndroidViewView);
        int m = a().getTitleBarHeight();
        int n = (int)bdgz.a(a(), 5.0F);
        this.jdField_a_of_type_Atkr.b();
        this.jdField_a_of_type_Atkr.a(m - n);
      }
      o();
    }
  }
  
  public void K_()
  {
    super.K_();
    y();
    if (this.jdField_a_of_type_Adgt != null) {
      this.jdField_a_of_type_Adgt.d();
    }
    if (this.jdField_b_of_type_Adgt != null) {
      this.jdField_b_of_type_Adgt.d();
    }
  }
  
  protected Intent a(Class<?> paramClass)
  {
    return new Intent(a(), paramClass);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559229, null);
    this.jdField_a_of_type_Atkv = new atkv();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public String a()
  {
    return alud.a(2131706393);
  }
  
  public void a()
  {
    super.a();
    j();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onAccountChanged");
    }
    if (this.jdField_a_of_type_Adgt != null) {
      this.jdField_a_of_type_Adgt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_b_of_type_Adgt != null) {
      this.jdField_b_of_type_Adgt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    aieq.a().a();
    I();
    if (this.jdField_a_of_type_Atkr != null) {
      this.jdField_a_of_type_Atkr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  
  public void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      nup localnup = (nup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      String str1 = String.valueOf(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = bhsz.a(str2, "code", paramMessage.auth_code.get());
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
          if (localnup != null) {
            localnup.a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localnup != null) {
            localnup.a(134246777, null, "not_jump", str1, "", 0L, false);
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
          if (localnup != null) {
            localnup.a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
      }
    }
  }
  
  public void a(View paramView, aozs paramaozs)
  {
    if (c()) {
      ThreadManager.post(new Leba.18(this, paramView, paramaozs), 8, null, true);
    }
  }
  
  public void a(View paramView, aozs paramaozs, atli paramatli)
  {
    if ((paramaozs == null) || (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "onPluginClick item == null || item.info == null");
      return;
    }
    for (;;)
    {
      try
      {
        QLog.i("Q.lebatab.leba", 1, "onPluginClick item = " + paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.toString());
        a(paramatli);
        paramatli = (axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if ((paramaozs != null) && (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nga.jdField_a_of_type_Int))
        {
          wxj.a("dynamic", "clk_story", 0, ((nan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).c(), new String[0]);
          a(paramView, paramaozs);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.w("Q.lebatab.leba", 1, "onPluginClick", paramView);
        return;
      }
      if ((paramaozs != null) && (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7719L == paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        E();
        paramatli.a(100510, 31);
        return;
      }
      if ((paramaozs != null) && (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (826L == paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        c(paramView, paramaozs);
        return;
      }
      if ((paramaozs != null) && (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7720L == paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        ExtendFriendPublicFragmentActivity.a(a(), 2);
        if ((paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId <= 0L)) {
          break;
        }
        paramatli.a((int)paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, 31);
        return;
      }
      if ((paramaozs != null) && (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7759L == paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        aoiq localaoiq = ((aoiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
        String str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramatli = str;
        if (localaoiq != null)
        {
          paramatli = str;
          if (!TextUtils.isEmpty(localaoiq.l)) {
            paramatli = localaoiq.l;
          }
        }
        paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = paramatli;
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean, aozs paramaozs)
  {
    if ((paramaozs == null) || (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    Object localObject1 = paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;
    if ("com.cmshow.game.android".equals(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_tab_game", 0, 0, new String[0]);
    }
    String str1 = paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName;
    int m = paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sResSubType;
    boolean bool3 = false;
    boolean bool1 = false;
    if ((paramView != null) && ((paramView instanceof RedTouch))) {}
    for (boolean bool2 = ((RedTouch)paramView).a();; bool2 = false)
    {
      Object localObject2;
      Object localObject4;
      int n;
      label410:
      if (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))
      {
        paramView = bdtg.a("vipGameCenter");
        if (TextUtils.isEmpty(paramView))
        {
          paramView = paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;
          QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use plugin info url=" + paramView);
          if (!bool2) {
            break label3423;
          }
          localObject2 = "-1";
          localObject4 = ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId)).missions.get();
          localObject1 = localObject2;
          if (localObject4 == null) {
            break label379;
          }
          localObject1 = localObject2;
          if (((List)localObject4).size() <= 0) {
            break label379;
          }
          localObject1 = "-1";
          n = 0;
          label252:
          if (n >= ((List)localObject4).size()) {
            break label379;
          }
          if (n != 0) {
            break label338;
          }
        }
        label338:
        for (localObject1 = (String)((List)localObject4).get(n);; localObject1 = (String)localObject1 + "_" + (String)((List)localObject4).get(n))
        {
          n += 1;
          break label252;
          if (paramView.startsWith("http")) {
            m = 0;
          }
          for (;;)
          {
            QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use IndividuationUrl url=" + paramView);
            break;
          }
        }
        label379:
        if (m == 0)
        {
          paramView = paramView + "&missions=" + (String)localObject1;
          QLog.i("Q.lebatab.leba", 1, "[dealGameCenterUrl] add redPointId :" + paramView);
        }
      }
      for (;;)
      {
        if (paramBoolean) {
          if (paramaozs != null)
          {
            if (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 0L) {
              break label3414;
            }
            if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
              break label1068;
            }
            bool1 = true;
          }
        }
        label909:
        label1068:
        label3372:
        for (;;)
        {
          label477:
          oxp.a().b((int)paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, bool1);
          label493:
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str1 + ",url=" + paramView + ",type=" + m);
          }
          axlx localaxlx = (axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          BusinessInfoCheckUpdate.AppInfo localAppInfo = localaxlx.a(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "");
          if ((paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId > 0L)) {
            if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
            {
              paramView = bjkd.a(paramView, localAppInfo);
              if (localAppInfo.type.get() == 0) {
                bool1 = true;
              }
              bool2 = bool1;
              if (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
                bool2 = bool1 | true;
              }
              new ArrayList();
              if ((localAppInfo.red_display_info == null) || (localAppInfo.red_display_info.red_type_info == null)) {
                break label3408;
              }
              localObject1 = localAppInfo.red_display_info.red_type_info.get();
              if ((localObject1 == null) || (((List)localObject1).size() < 2)) {
                break label3408;
              }
            }
          }
          label817:
          label2486:
          label3019:
          label3408:
          for (n = ((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(1)).red_type.get();; n = 0)
          {
            int i1 = localAppInfo.num.get();
            localObject1 = "status=" + n + "&number=" + i1 + "&path=" + localAppInfo.path.get();
            bool1 = bool2;
            localObject2 = (azbi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
            if (localObject2 != null) {
              if (((azbi)localObject2).a(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "") != -1)
              {
                bool2 = true;
                label874:
                if (!paramBoolean) {
                  break label1198;
                }
                localaxlx.b(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "");
                paramBoolean = bool2;
                if (bool2) {
                  a(new Leba.21(this));
                }
              }
            }
            for (paramBoolean = bool2;; paramBoolean = false)
            {
              int i2 = i1;
              bool2 = bool1;
              localObject2 = paramView;
              bool1 = paramBoolean;
              paramBoolean = bool2;
              paramView = (View)localObject1;
              i1 = n;
              n = i2;
              localObject1 = localObject2;
              for (;;)
              {
                if ((localObject1 == null) || ("".equals(localObject1)))
                {
                  a(paramaozs, localAppInfo, localaxlx);
                  return;
                  if (m != 2) {
                    break label3420;
                  }
                  localObject2 = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramView).b("url");
                  paramView = paramView.replace((CharSequence)localObject2, (String)localObject2 + URLEncoder.encode(new StringBuilder().append("&missions=").append((String)localObject1).toString()));
                  break label410;
                  bool1 = false;
                  break label477;
                  if (paramaozs == null) {
                    break label493;
                  }
                  oxp.a().b((int)paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, bool2);
                  bool1 = bool3;
                  if ("com.tx.xingqubuluo.android".equals(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
                    bool1 = bool2;
                  }
                  if (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 7966L) {
                    break label493;
                  }
                  bool1 = bool2;
                  break label493;
                  localObject1 = "status=" + -1 + "&number=0" + "&path=" + paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
                  i1 = 0;
                  n = 0;
                  break label817;
                  bool2 = false;
                  break label874;
                  localaxlx.a((int)paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, 31);
                  break label909;
                  if ((paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (!paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist"))) {
                    break label3379;
                  }
                  localObject1 = (azbw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
                  if ((localObject1 == null) || ((((azbw)localObject1).a(2) <= 0) && (((azbw)localObject1).a(1) <= 0))) {
                    break label3379;
                  }
                  i1 = 0;
                  localObject2 = null;
                  paramBoolean = bool1;
                  bool1 = true;
                  n = 0;
                  localObject1 = paramView;
                  paramView = (View)localObject2;
                  continue;
                }
                String str2 = (String)atkq.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
                if (m == 0) {
                  if (!((String)localObject1).contains("plg_uin=1")) {
                    break label3372;
                  }
                }
                for (localObject2 = (String)localObject1 + "&mqquin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; localObject3 = localObject1)
                {
                  localObject1 = localObject2;
                  if (((String)localObject2).contains("plg_vkey=1")) {
                    localObject1 = (String)localObject2 + "&mqqvkey=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
                  }
                  localObject4 = a(QQBrowserActivity.class);
                  if (((String)localObject1).contains("plg_nld=1")) {
                    ((Intent)localObject4).putExtra("reportNld", true);
                  }
                  localObject2 = localObject1;
                  if (!TextUtils.isEmpty(paramView))
                  {
                    ((Intent)localObject4).putExtra("redTouch", paramView);
                    localObject2 = localObject1;
                    if (((String)localObject1).contains("red_touch=1")) {
                      localObject2 = (String)localObject1 + "&" + paramView;
                    }
                  }
                  this.jdField_b_of_type_Astc.b();
                  ((Intent)localObject4).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                  ((Intent)localObject4).putExtra("plugin_start_time", System.nanoTime());
                  ((Intent)localObject4).putExtra("click_start_time", System.currentTimeMillis());
                  ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
                  ((Intent)localObject4).putExtra("is_from_leba", true);
                  ((Intent)localObject4).putExtra("leba_resid", paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
                  ((Intent)localObject4).putExtra("has_red_dot", paramBoolean);
                  ((Intent)localObject4).putExtra("url", (String)localObject2);
                  if (!TextUtils.isEmpty(str2)) {
                    ((Intent)localObject4).putExtra("big_brother_source_key", str2);
                  }
                  if ((paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 3053L) && (((String)localObject2).indexOf("fetchCode=1") > -1))
                  {
                    long l = NetConnInfoCenter.getServerTime();
                    if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
                      }
                      ((Intent)localObject4).putExtra("url", bhsz.a((String)localObject2, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
                      a((Intent)localObject4);
                      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
                      a(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
                      paramView = (nup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
                      if (paramView == null) {
                        break;
                      }
                      paramView.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
                      return;
                    }
                    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
                    this.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject4);
                    a(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
                    this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1134007, 1000L);
                    return;
                  }
                  if (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 5647L)
                  {
                    if (!((String)localObject2).contains("?"))
                    {
                      paramView = (String)localObject2 + "?hasRedDot=" + paramBoolean;
                      if ((!paramBoolean) || (localAppInfo == null)) {
                        break label3369;
                      }
                      localObject1 = new StringBuilder();
                      localObject2 = localAppInfo.missions.get();
                      if (((List)localObject2).size() <= 0) {
                        break label2063;
                      }
                      m = 0;
                      if (m >= ((List)localObject2).size()) {
                        break label2063;
                      }
                      if (m != ((List)localObject2).size() - 1) {
                        break label2036;
                      }
                      ((StringBuilder)localObject1).append((String)((List)localObject2).get(m));
                    }
                    for (;;)
                    {
                      m += 1;
                      break label1954;
                      paramView = (String)localObject2 + "&hasRedDot=" + paramBoolean;
                      break;
                      label2036:
                      ((StringBuilder)localObject1).append((String)((List)localObject2).get(m)).append("_");
                    }
                    paramView = paramView + "&missions=" + ((StringBuilder)localObject1).toString();
                  }
                  for (;;)
                  {
                    ((Intent)localObject4).putExtra("url", paramView);
                    if ("com.cmshow.game.android".equals(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))
                    {
                      ((Intent)localObject4).putExtra("fragment_class", CmGameFragment.class.getCanonicalName());
                      ((Intent)localObject4).putExtra("hide_operation_bar", true);
                      ((Intent)localObject4).putExtra("hide_more_button", true);
                      ((Intent)localObject4).putExtra("portraitOnly", true);
                    }
                    a((Intent)localObject4);
                    do
                    {
                      a(paramaozs, localAppInfo, localaxlx);
                      if (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) {
                        azri.a(a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
                      }
                      if (paramaozs.jdField_a_of_type_Long == 1047L) {
                        awfa.a().jdField_a_of_type_Int = 4;
                      }
                      a(new Leba.22(this));
                      if (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist")) {
                        break;
                      }
                      this.jdField_a_of_type_Boolean = true;
                      return;
                    } while (m != 2);
                    localObject4 = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
                    if (localObject4 != null)
                    {
                      if (!paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
                        break label2686;
                      }
                      ((bdhk)localObject4).d("platformId=qq_m");
                      localObject2 = localObject4;
                    }
                    label2686:
                    do
                    {
                      for (;;)
                      {
                        ((bdhk)localObject2).a("from_leba", "fromleba");
                        ((bdhk)localObject2).a("leba_resid", String.valueOf(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
                        ((bdhk)localObject2).a("config_res_plugin_item_name", str1);
                        ((bdhk)localObject2).a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
                        ((bdhk)localObject2).a(bool1);
                        ((bdhk)localObject2).b(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
                        ((bdhk)localObject2).e(paramView);
                        ((bdhk)localObject2).b(paramBoolean);
                        ((bdhk)localObject2).a(localAppInfo);
                        if (!TextUtils.isEmpty(str2)) {
                          ((bdhk)localObject2).a("download_sourceid", str2);
                        }
                        if ((paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 8059L) || (!MiniAppLauncher.isMiniAppUrl((String)localObject1))) {
                          break label3354;
                        }
                        MiniAppLauncher.startMiniApp(a(), (String)localObject1, 2050, null);
                        bhsr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaozs, i1, n);
                        if (this.jdField_a_of_type_JavaUtilSet.contains(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
                          this.jdField_b_of_type_Astc.b();
                        }
                        if (!paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist")) {
                          break;
                        }
                        azrq.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        azrq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        this.jdField_a_of_type_Astc.b();
                        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
                        paramView = (azbw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
                        if (paramView != null)
                        {
                          if (QLog.isDevelopLevel()) {
                            QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
                          }
                          paramView.a(true);
                        }
                        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
                        break;
                        if (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.xingqubuluo.android"))
                        {
                          localObject2 = (nan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
                          localObject5 = new StringBuffer();
                          m = ((nan)localObject2).d();
                          if (m > 0) {
                            ((StringBuffer)localObject5).append("redid=" + m);
                          }
                          if (QLog.isDevelopLevel()) {
                            QLog.d("xingqubuluo", 4, "***redid=" + m);
                          }
                          m = ((nan)localObject2).a();
                          if (m > 0) {
                            if (((StringBuffer)localObject5).length() != 0) {
                              break label3019;
                            }
                          }
                          for (localObject2 = "";; localObject2 = "&rpnumber=" + m)
                          {
                            ((StringBuffer)localObject5).append((String)localObject2);
                            if (QLog.isDevelopLevel()) {
                              QLog.d("xingqubuluo", 4, "***rpnumber=" + m);
                            }
                            try
                            {
                              localObject2 = new JSONObject(localAppInfo.buffer.get());
                              if (localObject2 != null)
                              {
                                localObject2 = ((JSONObject)localObject2).optJSONObject("param");
                                if (localObject2 != null)
                                {
                                  localObject6 = ((JSONObject)localObject2).optJSONObject((String)localAppInfo.missions.get(0));
                                  if (localObject6 != null)
                                  {
                                    localObject2 = ((JSONObject)localObject6).optString("_red_ext_bid");
                                    localObject6 = ((JSONObject)localObject6).optString("_red_ext_pid");
                                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                                      ((StringBuffer)localObject5).append("&bid=").append((String)localObject2);
                                    }
                                    if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                                      ((StringBuffer)localObject5).append("&pid=").append((String)localObject6);
                                    }
                                  }
                                }
                              }
                            }
                            catch (JSONException localJSONException)
                            {
                              for (;;)
                              {
                                localJSONException.printStackTrace();
                              }
                            }
                            localObject2 = localObject4;
                            if (((StringBuffer)localObject5).length() <= 0) {
                              break;
                            }
                            ((bdhk)localObject4).d(((StringBuffer)localObject5).toString());
                            localObject2 = localObject4;
                            break;
                          }
                        }
                        if (!paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.read.android")) {
                          break label3089;
                        }
                        ((bdhk)localObject4).a("ChannelID", "100020");
                        localObject3 = localObject4;
                      }
                      localObject3 = localObject4;
                    } while (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != nga.jdField_a_of_type_Int);
                    Object localObject6 = (nan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
                    Object localObject5 = ((nan)localObject6).a();
                    localObject3 = localObject5;
                    if (localObject5 == null)
                    {
                      localObject3 = localObject5;
                      if (((uza)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.lebatab.leba", 2, "check invisible red point for msgtab");
                        }
                        localObject3 = ((nan)localObject6).a(52);
                        if (localObject3 != null) {
                          break label3366;
                        }
                        localObject3 = ((nan)localObject6).a(35);
                      }
                    }
                    for (;;)
                    {
                      if ((localObject3 != null) && (((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get() == 37))
                      {
                        localObject5 = null;
                        try
                        {
                          localObject6 = new JSONObject(((oidb_0x791.RedDotInfo)localObject3).str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
                          localObject5 = localObject6;
                        }
                        catch (Exception localException)
                        {
                          for (;;)
                          {
                            wxe.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
                            continue;
                            localObject3 = String.valueOf(((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get());
                          }
                        }
                        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                          localObject4 = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject5);
                        }
                      }
                      for (;;)
                      {
                        if (localObject3 == null)
                        {
                          localObject3 = "";
                          ((bdhk)localObject4).a("redid", (String)localObject3);
                          ((bdhk)localObject4).a("lebaVersion", "old");
                          localObject3 = localObject4;
                          break;
                        }
                        a((bdhk)localObject3);
                        break label2486;
                      }
                    }
                  }
                }
                i1 = 0;
                Object localObject3 = null;
                paramBoolean = bool1;
                bool1 = false;
                n = 0;
                localObject1 = paramView;
                paramView = (View)localObject3;
              }
            }
          }
          label1198:
          label3379:
          label3414:
          bool1 = false;
        }
        label1954:
        label3366:
        label3369:
        label3420:
        break label410;
        label2063:
        label3089:
        label3354:
        label3423:
        continue;
        paramView = (View)localObject1;
      }
    }
  }
  
  protected void a(aozs paramaozs, BusinessInfoCheckUpdate.AppInfo paramAppInfo, axlx paramaxlx)
  {
    if ((paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId > 0L))
    {
      paramaxlx = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      String str = String.valueOf(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
      if ((paramAppInfo != null) && (paramaxlx != null) && (paramaxlx.a(str))) {
        ThreadManager.getFileThreadHandler().post(new Leba.26(this, str, paramAppInfo));
      }
      if (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals(bems.jdField_a_of_type_JavaLangString)) {
        ThreadManager.post(new Leba.27(this), 5, null, false);
      }
      if (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 7759L) {
        aoiy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  protected void a(bdhk parambdhk)
  {
    if (parambdhk != null) {
      parambdhk.c();
    }
  }
  
  void a(String paramString)
  {
    ((bdug)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).c(paramString);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, adgm paramadgm)
  {
    if (paramadgm == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramadgm.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.lebatab.leba", 1, paramString, new Object[0]);
      paramadgm.a();
      return;
    }
    String str1;
    int m;
    if (paramString.equals(a().getString(2131693862)))
    {
      str1 = a().getString(2131693859);
      paramString = a().getString(2131693864);
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
          str2 = bflq.a("check_app_exemption__" + str2 + "_" + paramString);
          boolean bool = localSharedPreferences.getBoolean(str2, false);
          QLog.i("Q.lebatab.leba", 1, "checkEnterApp..checkKey:" + str2 + ",hasCheck:" + bool + "，checkName：" + paramString);
          if (!bool)
          {
            a(new Leba.42(this, str1, localSharedPreferences, str2, paramadgm));
            return;
            if (paramString.equals(a().getString(2131693861)))
            {
              str1 = a().getString(2131693858);
              paramString = a().getString(2131693863);
              m = 1;
              continue;
            }
            if (!paramString.equals(a().getString(2131693860))) {
              break label320;
            }
            str1 = a().getString(2131693857);
            m = 1;
            continue;
          }
        }
      }
      paramadgm.a();
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
    oxp.a().a(3, paramBoolean);
    this.jdField_a_of_type_Bhsl.postDelayed(new Leba.9(this, paramBoolean, paramRedTypeInfo), 150L);
    LpReportInfo_pf00064.allReport(637, 31, 1);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onSwitchOutofLeba");
    }
  }
  
  public void b(View paramView, aozs paramaozs)
  {
    if ((paramaozs == null) || (paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    a(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, new adfz(this, paramView, paramaozs));
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      z();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_Bhsl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Avvd);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Avvb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Avva);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amph);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alzr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alpq, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Auuq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqbl);
      babd.a(this.jdField_a_of_type_Babe);
      if (paramBoolean) {
        w();
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
  
  public void c()
  {
    this.jdField_a_of_type_Bhsl.post(new Leba.2(this));
  }
  
  void c(View paramView, aozs paramaozs)
  {
    if (paramaozs == null) {
      return;
    }
    paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = alvp.jdField_a_of_type_JavaLangString;
    String str = bdne.c(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {
      paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = str.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("enterXQBL", 2, "跳转url = " + paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
    }
    b(paramView, paramaozs);
    N();
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
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
    x();
    O();
    ((ViewStub)a(2131377168)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131364622)).setOnFirstDrawListener(this);
    this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
    QzoneConfig.getInstance().addListener(this);
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onResume" + aieq.jdField_a_of_type_Int);
    }
    AbstractGifImage.resumeAll();
    oxp.a().c();
    if (this.jdField_g_of_type_Boolean)
    {
      ThreadRegulator.a().b(4);
      this.jdField_g_of_type_Boolean = false;
    }
    adtj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Adgt != null) {
      this.jdField_a_of_type_Adgt.c();
    }
    if (this.jdField_b_of_type_Adgt != null) {
      this.jdField_b_of_type_Adgt.c();
    }
    ThreadManager.post(new Leba.4(this), 5, null, false);
    ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    if ((!this.jdField_b_of_type_Boolean) || ((aieq.jdField_a_of_type_Int & 0x4) != 0)) {
      this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.c(true);
      this.jdField_a_of_type_Bhsl.postDelayed(new Leba.5(this), 100L);
      ThreadManagerV2.excute(new Leba.6(this, (auul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
      M();
      Object localObject;
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_h_of_type_AndroidWidgetTextView.setFocusable(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(2131691170));
        localObject = a(2131694189);
        this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131694189));
      }
      if (this.jdField_a_of_type_Atkv != null) {
        this.jdField_a_of_type_Atkv.a();
      }
      if (this.jdField_a_of_type_Atkr != null) {
        this.jdField_a_of_type_Atkr.b(true);
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
      if (aieq.jdField_a_of_type_Int > 0)
      {
        localObject = new ArrayList();
        alvr.a((List)localObject, aieq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
          if (this.jdField_a_of_type_Atkv != null)
          {
            this.jdField_a_of_type_Atkv.b();
            I();
          }
        }
        aieq.jdField_a_of_type_Int = 0;
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
    this.jdField_a_of_type_Astc.d();
    this.jdField_b_of_type_Astc.d();
    auwc.c(0);
    this.jdField_a_of_type_Bhsl.removeMessages(1134010);
    if (this.jdField_a_of_type_Adgt != null) {
      this.jdField_a_of_type_Adgt.b();
    }
    if (this.jdField_b_of_type_Adgt != null) {
      this.jdField_b_of_type_Adgt.b();
    }
    if (this.jdField_a_of_type_Atkv != null) {
      this.jdField_a_of_type_Atkv.a(b(), d(), c());
    }
    if (this.jdField_a_of_type_Atkr != null) {
      this.jdField_a_of_type_Atkr.c();
    }
    this.jdField_a_of_type_Bhsl.postDelayed(new Leba.3(this), 500L);
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
  
  protected void j()
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (!ayvj.a()) {
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
    y();
    if (this.jdField_a_of_type_Adgt != null) {
      this.jdField_a_of_type_Adgt.d();
    }
    if (this.jdField_b_of_type_Adgt != null) {
      this.jdField_b_of_type_Adgt.d();
    }
    if (this.jdField_a_of_type_Atkr != null) {
      this.jdField_a_of_type_Atkr.d();
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
  
  public void m()
  {
    super.m();
  }
  
  protected void n()
  {
    Object localObject = (axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    int n;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((axlx)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        n = 0;
        int m = n;
        if (n == -1)
        {
          localAppInfo = ((axlx)localObject).a("886.100171");
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
          localObject = ((axlx)localObject).a("886.100172");
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
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, n + "", "", "", "");
        }
        if (((nan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).a()) {
          avsn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "entry", "official_push_exp");
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
  
  void o()
  {
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, 4, 2130838593, "-leba-");
    if (ThemeUtil.isNowThemeIsAnimate()) {
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  public void onClick(View paramView)
  {
    if (!c()) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368638: 
    case 2131368655: 
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
      H();
      return;
    case 2131373640: 
      paramView = new Intent();
      paramView.putExtra("key_enable_splash", true);
      paramView.putExtra("key_jump_from", "3");
      tqs.a(a(), paramView);
      Q();
      G();
      a(1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HardCoder", 2, "launch qzone");
    }
    jdField_a_of_type_Int = abws.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootQzone");
    paramView = (aozs)aieq.a().jdField_a_of_type_JavaUtilHashMap.get("qzone_feedlist");
    QLog.d("Q.lebatab.leba", 1, "user clicked qzone feed entry.");
    ThreadManager.postImmediately(new Leba.34(this, paramView), null, true);
    P();
    bczz.a(this.jdField_c_of_type_AndroidViewView, alud.a(2131720579));
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
    } while (this.jdField_a_of_type_Atkv == null);
    this.jdField_a_of_type_Atkv.a(paramAbsListView, paramInt);
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onPostThemeChanged");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(null);
    }
    o();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-1);
      azmk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(11340002, 0L);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        if (!azmk.a()) {
          break label243;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Atkv != null) {
        this.jdField_a_of_type_Atkv.c();
      }
      if (this.jdField_a_of_type_Adgt != null) {
        this.jdField_a_of_type_Adgt.e();
      }
      if (this.jdField_b_of_type_Adgt != null) {
        this.jdField_b_of_type_Adgt.e();
      }
      if (this.jdField_a_of_type_Atkr != null) {
        this.jdField_a_of_type_Atkr.f();
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        TextHook.updateFont(this.jdField_b_of_type_AndroidViewView);
      }
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849536);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166900));
      break;
      label243:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void r()
  {
    QLog.d("Leba", 1, "onLebaTabChange");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      aufx localaufx = (aufx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      azby.jdField_a_of_type_Boolean = true;
      if (localaufx != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localaufx.a(3);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
      }
    }
    if (!e()) {
      C();
    }
    a(2);
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)) {}
    nup localnup;
    do
    {
      return;
      localnup = (nup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localnup == null);
    localnup.a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */