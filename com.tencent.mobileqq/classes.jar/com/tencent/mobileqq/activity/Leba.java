package com.tencent.mobileqq.activity;

import acjp;
import adol;
import adom;
import adon;
import adoo;
import adop;
import adoq;
import ador;
import ados;
import adot;
import adou;
import adov;
import adow;
import adox;
import adoy;
import adoz;
import adpa;
import adpb;
import adpc;
import adpe;
import adpg;
import adph;
import adpk;
import adpo;
import aebs;
import ajef;
import ajeg;
import ajek;
import ajeq;
import ajer;
import ajes;
import ajet;
import amrz;
import amsu;
import amtj;
import amux;
import amvb;
import amyh;
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
import anwh;
import aprw;
import apsa;
import apse;
import aqmf;
import arht;
import atzd;
import aufo;
import auxc;
import auxd;
import auxh;
import auxr;
import auxt;
import avjy;
import avta;
import awhw;
import awhz;
import awib;
import awjm;
import awka;
import awkj;
import axfy;
import axfz;
import axkt;
import axku;
import axkw;
import axys;
import azvi;
import bbgh;
import bboi;
import bbox;
import bbyp;
import bcdg;
import bcef;
import bcek;
import bcew;
import bcfp;
import bcoo;
import bcoq;
import bfpm;
import bfvh;
import bfvp;
import bfwg;
import bfyz;
import bgev;
import bhat;
import bhzn;
import bjmp;
import bjmv;
import bjnd;
import bjpg;
import bjuk;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
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
import nmj;
import nmq;
import nru;
import ogr;
import org.json.JSONObject;
import ple;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;
import vgn;
import vxx;
import xvv;
import xwa;

public class Leba
  extends amrz
  implements adpk, ajet, View.OnClickListener, ViewStub.OnInflateListener, auxh, AbsListView.OnScrollListener, QzoneConfig.QzoneConfigChangeListener
{
  public static int a;
  static long jdField_b_of_type_Long;
  private static List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_d_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_e_of_type_JavaUtilList = new ArrayList();
  protected final long a;
  private adpo jdField_a_of_type_Adpo;
  private ajef jdField_a_of_type_Ajef;
  amsu jdField_a_of_type_Amsu = new adoy(this);
  private amyh jdField_a_of_type_Amyh = new adox(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new adom(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anwh jdField_a_of_type_Anwh = new adow(this);
  private arht jdField_a_of_type_Arht = new adpb(this);
  private aufo jdField_a_of_type_Aufo = new aufo("qzone_leba", "com.tencent.mobileqq:qzone");
  private auxd jdField_a_of_type_Auxd;
  awib jdField_a_of_type_Awib = new adoz(this);
  private axkt jdField_a_of_type_Axkt = new adov(this);
  private axku jdField_a_of_type_Axku = new adou(this);
  private axkw jdField_a_of_type_Axkw = new adot(this);
  bcoq jdField_a_of_type_Bcoq = new adpe(this);
  public bjmp a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new adpa(this);
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new adol(this);
  FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  protected TimerTaskManager a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private QCircleObserver jdField_a_of_type_CooperationQqcircleChatQCircleObserver = new adpc(this);
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
  private adpo jdField_b_of_type_Adpo;
  private View jdField_b_of_type_AndroidViewView;
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private aufo jdField_b_of_type_Aufo = new aufo("web_leba", "com.tencent.mobileqq:tool");
  private String jdField_b_of_type_JavaLangString;
  private List<aqmf> jdField_b_of_type_JavaUtilList;
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
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = avjy.a();
    this.jdField_a_of_type_JavaLangString = ("mobileMP" + System.currentTimeMillis());
    this.jdField_a_of_type_Long = 30000L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bjmp = new bjmp(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private void D()
  {
    this.jdField_e_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131374248);
    if ((!d()) || (bbyp.a())) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131369879));
      if ((this.jdField_d_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.jdField_d_of_type_AndroidWidgetImageView).setMaskShape(bjuk.jdField_c_of_type_Int);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845217);
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130839437);
      ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374253)).setText(2131718768);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374255));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374256));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374254));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374257));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_e_of_type_AndroidViewView.findViewById(2131374250));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new adoq(this));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131374252));
      this.jdField_d_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_e_of_type_AndroidViewView.findViewById(2131374251));
      this.jdField_d_of_type_AndroidWidgetImageSwitcher.setFactory(new ador(this));
      this.jdField_b_of_type_Adpo = new adpo(this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_d_of_type_AndroidWidgetImageSwitcher, this.jdField_f_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bjmp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
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
    Object localObject3 = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    Object localObject2 = ((azvi)localObject3).a(String.valueOf(100510));
    ((axfy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160)).a(100510);
    ajek.jdField_a_of_type_Int |= 0x1;
    Object localObject1 = ((azvi)localObject3).a("100510.100517");
    if (((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.has()) {}
    Object localObject4;
    int n;
    for (localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "god buffer: " + (String)localObject1);
      }
      if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.has()) || (!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.has())) {
        break label1141;
      }
      localObject4 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.get();
      if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
        break label1141;
      }
      localObject4 = ((List)localObject4).iterator();
      for (n = 2; ((Iterator)localObject4).hasNext(); n = 1) {
        if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject4).next()).red_type.get() != 3) {
          break label1138;
        }
      }
    }
    for (;;)
    {
      ((azvi)localObject3).b("100510.100517");
      localObject3 = (nmj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(43);
      ((nmj)localObject3).a(60);
      ((nmj)localObject3).a(59);
      localObject3 = (nmq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
      NearbyReportRunnable localNearbyReportRunnable;
      if (((nmq)localObject3).a())
      {
        axfz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "home", "official_push_click");
        if (this.jdField_f_of_type_Int != 0)
        {
          localObject4 = (awhw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106);
          localNearbyReportRunnable = new NearbyReportRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
          localNearbyReportRunnable.a((awhw)localObject4);
          localNearbyReportRunnable.a(new String[] { String.valueOf(this.jdField_f_of_type_Int), "" });
          ThreadManagerV2.excute(localNearbyReportRunnable, 16, null, false);
        }
      }
      ((nmq)localObject3).a(false);
      int i1;
      boolean bool;
      if (this.jdField_a_of_type_Ajef == null)
      {
        i1 = -1;
        this.jdField_a_of_type_Bjmp.post(new Leba.22(this));
        localObject4 = (awhw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106);
        localNearbyReportRunnable = new NearbyReportRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        localNearbyReportRunnable.a((awhw)localObject4);
        ThreadManagerV2.excute(localNearbyReportRunnable, 16, null, false);
        if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) || (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 1)) {
          break label1132;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
        bcef.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          awkj.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        awjm.b(0);
        if (!awka.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
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
          label770:
          if (i1 != 59) {
            break label968;
          }
          new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_clk_red").a();
        }
        for (;;)
        {
          awhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1);
          if (bool) {
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
          }
          ple.a().a("FuJin", bool);
          return;
          i1 = this.jdField_a_of_type_Ajef.a();
          break;
          localObject2 = new Intent(a(), NearbyGuideActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", n);
          a().startActivity((Intent)localObject2);
          break label770;
          label968:
          if (i1 == 60)
          {
            localObject1 = ((nmq)localObject3).a(60);
            if ((localObject1 != null) && (((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get() == 1822701914L)) {
              new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_clk_red").a();
            } else {
              new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_clk_red").a();
            }
          }
          else if (i1 == 61)
          {
            new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_clk_red").a();
          }
        }
        label1132:
        bool = false;
      }
      label1138:
      break;
      label1141:
      n = 2;
    }
  }
  
  private void F()
  {
    if ((a() != null) && (a().app != null))
    {
      avta localavta = (avta)a().app.getManager(10);
      if (localavta != null)
      {
        if (this.jdField_f_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localavta.a(3);
        }
        localavta.a(false);
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
    ajek.a().jdField_a_of_type_Boolean = true;
    amvb.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void I()
  {
    J();
    K();
    this.jdField_a_of_type_Bjmp.sendEmptyMessageDelayed(1134006, 200L);
    N();
    if ((this.jdField_a_of_type_Ajef != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Ajef.b();
    }
  }
  
  private void J()
  {
    ThreadManager.post(new Leba.33(this), 5, null, false);
  }
  
  private void K()
  {
    if ((!d()) || (bbyp.a()))
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
    if (bbyp.a()) {}
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        QLog.i("Leba", 1, "updateIconEntryRedTouch app == null");
        return;
      }
      localAppInfo = ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("150000");
    } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).a().a(localAppInfo);
    a(localAppInfo);
  }
  
  private void O()
  {
    Object localObject = (nmq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((nmq)localObject).a(1);
      if (localRedDotInfo != null) {
        nmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
      }
      localObject = ((nmq)localObject).a(6);
      if (localObject != null) {
        nmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject);
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
    auxr localauxr = new auxr();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localauxr.jdField_a_of_type_Boolean = bool;
      localauxr.jdField_a_of_type_Long = 10000L;
      localauxr.jdField_a_of_type_Int = 0;
      localauxr.jdField_b_of_type_Int = b();
      localauxr.jdField_d_of_type_Int = 2;
      if (this.jdField_a_of_type_Ajef != null) {
        localauxr.jdField_d_of_type_Int = auxt.a(this.jdField_a_of_type_Ajef.b());
      }
      a(localauxr);
      return;
    }
  }
  
  private void R()
  {
    auxr localauxr = new auxr();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localauxr.jdField_a_of_type_Boolean = bool;
      localauxr.jdField_a_of_type_Long = 10004L;
      localauxr.jdField_a_of_type_Int = 0;
      localauxr.jdField_b_of_type_Int = c();
      localauxr.jdField_d_of_type_Int = 0;
      a(localauxr);
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
  
  private aqmf a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        aqmf localaqmf = (aqmf)localIterator.next();
        if ((localaqmf != null) && (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName != null) && (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName != null) && (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))) {
          return localaqmf;
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && ((this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) || (d())))
    {
      ajek.jdField_a_of_type_Int |= 0x2;
      if (QLog.isColorLevel()) {
        QLog.d("Leba", 2, "updateRefreshFlagForQQCircle " + paramInt);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, List<String> paramList, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    b(new Leba.35(this, paramInt, paramBoolean1, paramBoolean2, paramBoolean4, paramString, paramBoolean3, paramList));
  }
  
  private void a(auxr paramauxr)
  {
    if (paramauxr == null)
    {
      QLog.i("Q.lebatab.leba", 1, "reportPluginClick  reportInfo == null ");
      return;
    }
    QLog.i("Q.lebatab.leba", 1, String.format("reportPluginClick id = %d pos = %d type = %d mode = %b hasAssistsText = %d", new Object[] { Long.valueOf(paramauxr.jdField_a_of_type_Long), Integer.valueOf(paramauxr.jdField_a_of_type_Int), Integer.valueOf(paramauxr.jdField_b_of_type_Int), Boolean.valueOf(paramauxr.jdField_a_of_type_Boolean), Integer.valueOf(paramauxr.jdField_c_of_type_Int) }));
    if (paramauxr.jdField_a_of_type_Boolean)
    {
      bcfp localbcfp = auxt.a("plugin_clk");
      localbcfp.jdField_a_of_type_JavaLangString = String.valueOf(paramauxr.jdField_a_of_type_Long);
      localbcfp.jdField_c_of_type_JavaLangString = String.valueOf(paramauxr.jdField_a_of_type_Int);
      localbcfp.d = String.valueOf(paramauxr.jdField_b_of_type_Int);
      localbcfp.e = String.valueOf(paramauxr.jdField_c_of_type_Int);
      localbcfp.f = String.valueOf(paramauxr.jdField_d_of_type_Int);
      localbcfp.g = ThemeUtil.getCurrentThemeId();
      bcdg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbcfp);
      return;
    }
    bcef.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(paramauxr.jdField_a_of_type_Long), String.valueOf(paramauxr.jdField_a_of_type_Int), String.valueOf(paramauxr.jdField_b_of_type_Int), "");
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
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
    Object localObject2 = bgev.a("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((aqmf)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((aqmf)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((bfvp)localObject3).b("url");
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
    bjpg.a(this.jdField_b_of_type_AndroidWidgetTextView, 8, 0, 0);
    paramString = this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    if ((paramString instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)paramString).bottomMargin = a().getDimensionPixelSize(2131297113);
    }
  }
  
  private void b(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mLebaHelper == null)) {
      return;
    }
    WebProcessManager.c(true);
    s();
    int n = auxt.a(paramBoolean, paramRedTypeInfo);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(n), "");
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
      paramRedTypeInfo = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
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
    return (this.jdField_a_of_type_Ajef != null) && (this.jdField_a_of_type_Ajef.b() == 1);
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
    if ((localObject1 != null) && (((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {}
    for (long l1 = ((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;; l1 = 489L)
    {
      localObject1 = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      Object localObject2 = ((azvi)localObject1).a("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((azvi)localObject1).a(String.valueOf(l1));
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
        ((azvi)localObject1).b(String.valueOf("200010.200011"));
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
        n += 1;
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
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      QLog.d("Leba", 1, "hideQQCircleAfterAccountChanged");
    }
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131378806));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378727));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131376501));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369814));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)a(2131369115));
    this.jdField_i_of_type_AndroidWidgetTextView.setText(2131718774);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369082));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    o();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_b_of_type_AndroidWidgetImageView).a(53).a();
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
      bbyp.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850016);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167009));
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Axkw);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axku);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Axkt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeLebaListener(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amsu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anwh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amyh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Awib);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Arht);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
      bcoo.b(this.jdField_a_of_type_Bcoq);
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131369816));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369806));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(a().getDrawable(2130850155));
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
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561137, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
        this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131375260);
        localObject = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131369879);
        if ((localObject instanceof ThemeImageView)) {
          ((ThemeImageView)localObject).setMaskShape(bjuk.jdField_c_of_type_Int);
        }
        ((ImageView)localObject).setImageResource(2130845214);
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130839437);
        ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131369880)).setText(2131718769);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375262));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375313));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375474));
        this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375814));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_c_of_type_AndroidViewView.findViewById(2131375263));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new adon(this));
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375275));
        this.jdField_c_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_c_of_type_AndroidViewView.findViewById(2131375264));
        this.jdField_c_of_type_AndroidWidgetImageSwitcher.setFactory(new adoo(this));
        D();
        this.jdField_a_of_type_Adpo = new adpo(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_c_of_type_AndroidWidgetImageSwitcher, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bjmp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376679));
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369805));
        this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131369808);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131366179));
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        bfpm.a(this.jdField_a_of_type_AndroidWidgetEditText, a(2131691056));
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131379819));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363774));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.l = BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("has_search_bar", false);
        d();
        this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new adop(this));
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          bfpm.b(this.jdField_c_of_type_AndroidViewView);
          bfpm.a(this.jdField_d_of_type_AndroidViewView, amtj.a(2131718769), Button.class.getName());
        }
      }
      if (this.jdField_a_of_type_Ajef != null)
      {
        localObject = new ajeg();
        ((ajeg)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ((ajeg)localObject).jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
        ((ajeg)localObject).jdField_a_of_type_AndroidContentContext = a();
        ((ajeg)localObject).jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
        ((ajeg)localObject).jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView;
        ((ajeg)localObject).jdField_a_of_type_Auxh = this;
        this.jdField_a_of_type_Ajef.a((ajeg)localObject);
      }
      if (this.jdField_a_of_type_Auxd == null)
      {
        this.jdField_a_of_type_Auxd = new auxd(a());
        this.jdField_a_of_type_Auxd.a(this.jdField_a_of_type_AndroidViewView);
        int n = a().getTitleBarHeight();
        int i1 = (int)bfvh.a(a(), 5.0F);
        this.jdField_a_of_type_Auxd.b();
        this.jdField_a_of_type_Auxd.a(n - i1);
      }
      m();
    }
  }
  
  public void X_()
  {
    o();
    d();
  }
  
  public adph a(aqmf paramaqmf, String paramString, short paramShort, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ("com.cmshow.game.android".equals(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_tab_game", 0, 0);
    }
    Object localObject;
    short s;
    String str;
    if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))
    {
      paramString = a("vipGameCenter");
      List localList;
      int n;
      if (TextUtils.isEmpty(paramString))
      {
        paramString = paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;
        QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use plugin info url=" + paramString);
        localObject = paramString;
        s = paramShort;
        if (!paramBoolean1) {
          break label367;
        }
        str = "-1";
        localList = ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId)).missions.get();
        localObject = str;
        if (localList == null) {
          break label304;
        }
        localObject = str;
        if (localList.size() <= 0) {
          break label304;
        }
        localObject = "-1";
        n = 0;
        label181:
        if (n >= localList.size()) {
          break label304;
        }
        if (n != 0) {
          break label263;
        }
      }
      label263:
      for (localObject = (String)localList.get(n);; localObject = (String)localObject + "_" + (String)localList.get(n))
      {
        n += 1;
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
        if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 0L) {
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
        ple.a().b((int)paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean3);
        for (;;)
        {
          paramString = new adph();
          paramString.jdField_a_of_type_JavaLangString = ((String)localObject);
          paramString.jdField_a_of_type_Short = s;
          paramString.jdField_b_of_type_Boolean = paramBoolean3;
          paramString.jdField_c_of_type_Boolean = paramBoolean1;
          paramString.jdField_d_of_type_Boolean = paramBoolean2;
          paramString.jdField_a_of_type_Aqmf = paramaqmf;
          return paramString;
          if (paramShort != 2) {
            break label611;
          }
          str = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramString).b("url");
          paramString = paramString.replace(str, str + URLEncoder.encode(new StringBuilder().append("&missions=").append((String)localObject).toString()));
          break;
          paramBoolean3 = false;
          break label404;
          ple.a().b((int)paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean1);
          if ("com.tx.xingqubuluo.android".equals(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
            paramBoolean3 = paramBoolean1;
          }
          if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 7966L) {
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559315, null);
    this.jdField_a_of_type_Ajef = new ajef();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public bfvp a(aqmf paramaqmf, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bfvp parambfvp)
  {
    if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
      parambfvp.e("platformId=qq_m");
    }
    do
    {
      return parambfvp;
      if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.xingqubuluo.android")) {
        return b(paramaqmf, paramAppInfo, parambfvp);
      }
      if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.read.android"))
      {
        parambfvp.a("ChannelID", "100020");
        return parambfvp;
      }
    } while (!a(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
    return c(paramaqmf, paramAppInfo, parambfvp);
  }
  
  public bfvp a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    return bfwg.a(paramQQAppInterface, paramContext, paramString);
  }
  
  public String a()
  {
    return amtj.a(2131705141);
  }
  
  public String a(String paramString)
  {
    return bgev.a(paramString);
  }
  
  public void a()
  {
    super.a();
    X_();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onAccountChanged");
    }
    if (this.jdField_a_of_type_Adpo != null) {
      this.jdField_a_of_type_Adpo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_b_of_type_Adpo != null) {
      this.jdField_b_of_type_Adpo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    L();
    ajek.a().a();
    I();
    if (this.jdField_a_of_type_Auxd != null) {
      this.jdField_a_of_type_Auxd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    QCircleEeveeMananger.getInstance().onSend(4, null, null);
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
  
  public void a(adph paramadph)
  {
    String str1 = paramadph.jdField_a_of_type_JavaLangString;
    Object localObject2 = paramadph.jdField_b_of_type_JavaLangString;
    int n = paramadph.jdField_a_of_type_Short;
    boolean bool1 = paramadph.jdField_a_of_type_Boolean;
    boolean bool2 = paramadph.jdField_b_of_type_Boolean;
    String str2 = paramadph.jdField_c_of_type_JavaLangString;
    boolean bool3 = paramadph.jdField_c_of_type_Boolean;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramadph.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
    int i1 = paramadph.jdField_a_of_type_Int;
    int i2 = paramadph.jdField_b_of_type_Int;
    Object localObject1 = paramadph.jdField_a_of_type_AndroidViewView;
    boolean bool4 = paramadph.jdField_d_of_type_Boolean;
    localObject1 = paramadph.jdField_a_of_type_Aqmf;
    azvi localazvi = paramadph.jdField_a_of_type_Azvi;
    if ((str1 == null) || ("".equals(str1))) {
      a((aqmf)localObject1, localAppInfo, localazvi);
    }
    String str3;
    do
    {
      return;
      str3 = (String)auxc.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      if (n != 0) {
        break;
      }
      paramadph = new ajer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).a(str1);
      paramadph = new ajes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getvKeyHexStr()).a(paramadph);
      str1 = new ajeq(bool3, localAppInfo).a(paramadph);
      localObject2 = a(QQBrowserActivity.class);
      if (str1.contains("plg_nld=1")) {
        ((Intent)localObject2).putExtra("reportNld", true);
      }
      paramadph = str1;
      if (!TextUtils.isEmpty(str2))
      {
        ((Intent)localObject2).putExtra("redTouch", str2);
        paramadph = str1;
        if (str1.contains("red_touch=1")) {
          paramadph = str1 + "&" + str2;
        }
      }
      this.jdField_b_of_type_Aufo.b();
      ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject2).putExtra("plugin_start_time", System.nanoTime());
      ((Intent)localObject2).putExtra("click_start_time", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("is_from_leba", true);
      ((Intent)localObject2).putExtra("leba_resid", ((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
      ((Intent)localObject2).putExtra("has_red_dot", bool2);
      ((Intent)localObject2).putExtra("url", paramadph);
      if (!TextUtils.isEmpty(str3)) {
        ((Intent)localObject2).putExtra("big_brother_source_key", str3);
      }
    } while (!a((aqmf)localObject1, paramadph, (Intent)localObject2, bool3, bool2, localAppInfo));
    a((Intent)localObject2);
    while (n != 2)
    {
      a((aqmf)localObject1, localAppInfo, localazvi);
      b((aqmf)localObject1);
      return;
    }
    paramadph = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), str1);
    if (paramadph != null)
    {
      paramadph = a((aqmf)localObject1, localAppInfo, paramadph);
      paramadph.a("from_leba", "fromleba");
      paramadph.a("leba_resid", String.valueOf(((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      paramadph.a("config_res_plugin_item_name", (String)localObject2);
      paramadph.a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
      paramadph.a(bool1);
      paramadph.c(((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
      paramadph.f(str2);
      paramadph.b(bool2);
      paramadph.a(localAppInfo);
      if (!TextUtils.isEmpty(str3)) {
        paramadph.a("download_sourceid", str3);
      }
      if ((((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 8059L) || (!MiniAppLauncher.isMiniAppUrl(str1))) {
        break label678;
      }
      MiniAppLauncher.startMiniApp(a(), str1, 2050, null);
    }
    for (;;)
    {
      bjmv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aqmf)localObject1, i1, i2);
      if (this.jdField_a_of_type_JavaUtilSet.contains(((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
        this.jdField_b_of_type_Aufo.b();
      }
      a((aqmf)localObject1);
      break;
      label678:
      a(paramadph);
    }
  }
  
  public void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      ogr localogr = (ogr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(88);
      String str1 = String.valueOf(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = bjnd.a(str2, "code", paramMessage.auth_code.get());
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
          if (localogr != null) {
            localogr.a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localogr != null) {
            localogr.a(134246777, null, "not_jump", str1, "", 0L, false);
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
          if (localogr != null) {
            localogr.a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
      }
    }
  }
  
  public void a(View paramView, aqmf paramaqmf)
  {
    if (c()) {
      ThreadManager.post(new Leba.18(this, paramView, paramaqmf), 8, null, true);
    }
  }
  
  public void a(View paramView, aqmf paramaqmf, auxr paramauxr)
  {
    if ((paramaqmf == null) || (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "onPluginClick item == null || item.info == null");
      return;
    }
    for (;;)
    {
      try
      {
        QLog.i("Q.lebatab.leba", 1, "onPluginClick item = " + paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.toString());
        a(paramauxr);
        paramauxr = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if ((paramaqmf != null) && (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nru.jdField_a_of_type_Int))
        {
          xwa.a("dynamic", "clk_story", 0, ((nmq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).c(), new String[0]);
          a(paramView, paramaqmf);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.w("Q.lebatab.leba", 1, "onPluginClick", paramView);
        return;
      }
      if ((paramaqmf != null) && (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7719L == paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        E();
        paramauxr.a(100510, 31);
        return;
      }
      if ((paramaqmf != null) && (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (826L == paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        c(paramView, paramaqmf);
        return;
      }
      if ((paramaqmf != null) && (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7720L == paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        ExtendFriendPublicFragmentActivity.a(a(), 2);
        if ((paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId <= 0L)) {
          break;
        }
        paramauxr.a((int)paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, 31);
        return;
      }
      if ((paramaqmf != null) && (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7759L == paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        aprw localaprw = ((apsa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
        String str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramauxr = str;
        if (localaprw != null)
        {
          paramauxr = str;
          if (!TextUtils.isEmpty(localaprw.l)) {
            paramauxr = localaprw.l;
          }
        }
        paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = paramauxr;
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean, aqmf paramaqmf)
  {
    if ((paramaqmf == null) || (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    String str1 = paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;
    String str2 = paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName;
    short s = paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sResSubType;
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
    paramaqmf = a(paramaqmf, str1, s, bool1, paramBoolean, false);
    aqmf localaqmf = paramaqmf.jdField_a_of_type_Aqmf;
    str1 = paramaqmf.jdField_a_of_type_JavaLangString;
    s = paramaqmf.jdField_a_of_type_Short;
    bool3 = paramaqmf.jdField_c_of_type_Boolean;
    boolean bool4 = paramaqmf.jdField_d_of_type_Boolean;
    paramBoolean = paramaqmf.jdField_b_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str2 + ",url=" + str1 + ",type=" + s);
    }
    azvi localazvi = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localazvi.a(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "");
    int i2 = 0;
    int i1 = 0;
    int i3 = 0;
    int n = 0;
    if (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId > 0L) {
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
      {
        str1 = MobileReportManager.getStringWithRedAppinfo(str1, localAppInfo);
        if (localAppInfo.type.get() == 0) {
          paramBoolean = true;
        }
        if (!localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
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
        paramaqmf = localAppInfo.red_display_info.red_type_info.get();
        if ((paramaqmf == null) || (paramaqmf.size() < 2)) {}
      }
      for (n = ((BusinessInfoCheckUpdate.RedTypeInfo)paramaqmf.get(1)).red_type.get();; n = 0)
      {
        i2 = localAppInfo.num.get();
        paramaqmf = "status=" + n + "&number=" + i2 + "&path=" + localAppInfo.path.get();
        i1 = n;
        n = i2;
        Object localObject = (bboi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
        if (localObject != null) {
          if (((bboi)localObject).a(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "") != -1)
          {
            bool1 = true;
            if (!bool4) {
              break label749;
            }
            localazvi.b(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "");
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
            localObject = new adph();
            ((adph)localObject).jdField_a_of_type_JavaLangString = str1;
            ((adph)localObject).jdField_b_of_type_JavaLangString = str2;
            ((adph)localObject).jdField_a_of_type_Short = s;
            ((adph)localObject).jdField_a_of_type_Boolean = paramBoolean;
            ((adph)localObject).jdField_b_of_type_Boolean = bool1;
            ((adph)localObject).jdField_c_of_type_JavaLangString = paramaqmf;
            ((adph)localObject).jdField_c_of_type_Boolean = bool3;
            ((adph)localObject).jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localAppInfo;
            ((adph)localObject).jdField_a_of_type_Int = i1;
            ((adph)localObject).jdField_b_of_type_Int = n;
            ((adph)localObject).jdField_a_of_type_AndroidViewView = paramView;
            ((adph)localObject).jdField_d_of_type_Boolean = bool4;
            ((adph)localObject).jdField_a_of_type_Aqmf = localaqmf;
            ((adph)localObject).jdField_a_of_type_Azvi = localazvi;
            a((adph)localObject);
            return;
            paramaqmf = "status=" + -1 + "&number=0" + "&path=" + localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
            break;
            bool1 = false;
            break label517;
            label749:
            localazvi.a((int)localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, 31);
            break label554;
            if (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
            {
              bool2 = a(false);
              paramaqmf = null;
              bool1 = paramBoolean;
              n = i3;
              i1 = i2;
              paramBoolean = bool2;
            }
            else
            {
              paramaqmf = null;
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
  
  public void a(aqmf paramaqmf)
  {
    if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
    {
      bcew.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bcew.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_Aufo.b();
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
      paramaqmf = (bbox)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (paramaqmf != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
        }
        paramaqmf.a(true);
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
    }
  }
  
  protected void a(aqmf paramaqmf, BusinessInfoCheckUpdate.AppInfo paramAppInfo, azvi paramazvi)
  {
    if ((paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId > 0L))
    {
      paramazvi = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      String str = String.valueOf(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
      if ((paramAppInfo != null) && (paramazvi != null) && (paramazvi.a(str))) {
        ThreadManager.getFileThreadHandler().post(new Leba.23(this, str, paramAppInfo));
      }
      if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals(bhat.jdField_a_of_type_JavaLangString)) {
        ThreadManager.post(new Leba.24(this), 5, null, false);
      }
      if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 7759L) {
        apse.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  protected void a(bfvp parambfvp)
  {
    if (parambfvp != null) {
      parambfvp.a();
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    VipUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, new String[0]);
  }
  
  void a(String paramString)
  {
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(71)).c(paramString);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, adpg paramadpg)
  {
    if (paramadpg == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramadpg.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.lebatab.leba", 1, paramString, new Object[0]);
      paramadpg.a();
      return;
    }
    String str1;
    int n;
    if (paramString.equals(a().getString(2131693296)))
    {
      str1 = a().getString(2131693293);
      paramString = a().getString(2131693298);
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
          str2 = bhzn.a("check_app_exemption__" + str2 + "_" + paramString);
          boolean bool = localSharedPreferences.getBoolean(str2, false);
          QLog.i("Q.lebatab.leba", 1, "checkEnterApp..checkKey:" + str2 + ",hasCheck:" + bool + "，checkName：" + paramString);
          if (!bool)
          {
            b(new Leba.40(this, str1, localSharedPreferences, str2, paramadpg));
            return;
            if (paramString.equals(a().getString(2131693295)))
            {
              str1 = a().getString(2131693292);
              paramString = a().getString(2131693297);
              n = 1;
              continue;
            }
            if (!paramString.equals(a().getString(2131693294))) {
              break label320;
            }
            str1 = a().getString(2131693291);
            n = 1;
            continue;
          }
        }
      }
      paramadpg.a();
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
    ple.a().a(3, paramBoolean);
    this.jdField_a_of_type_Bjmp.postDelayed(new Leba.9(this, paramBoolean, paramRedTypeInfo), 150L);
    LpReportInfo_pf00064.allReport(637, 31, 1);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == nru.jdField_a_of_type_Int;
  }
  
  public boolean a(aqmf paramaqmf, String paramString, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int n = 0;
    if ((paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 3053L) && (paramString.indexOf("fetchCode=1") > -1))
    {
      long l1 = NetConnInfoCenter.getServerTime();
      if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
        }
        paramIntent.putExtra("url", bjnd.a(paramString, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
        a(paramIntent);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        a(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
        paramaqmf = (ogr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(88);
        if (paramaqmf != null) {
          paramaqmf.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
        }
        return false;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      a(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
      this.jdField_a_of_type_Bjmp.sendEmptyMessageDelayed(1134007, 1000L);
      return false;
    }
    if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 5647L)
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
        if (n >= paramAppInfo.size()) {
          break label424;
        }
        if (n != paramAppInfo.size() - 1) {
          break label397;
        }
        localStringBuilder.append((String)paramAppInfo.get(n));
      }
      for (;;)
      {
        n += 1;
        break label315;
        paramString = paramString + "&hasRedDot=" + paramBoolean2;
        break;
        label397:
        localStringBuilder.append((String)paramAppInfo.get(n)).append("_");
      }
      label424:
      paramString = paramString + "&missions=" + localStringBuilder.toString();
    }
    label521:
    for (;;)
    {
      paramIntent.putExtra("url", paramString);
      if ("com.cmshow.game.android".equals(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))
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
    bbox localbbox = (bbox)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    boolean bool = paramBoolean;
    if (localbbox != null) {
      if (localbbox.a(2) <= 0)
      {
        bool = paramBoolean;
        if (localbbox.a(1) <= 0) {}
      }
      else
      {
        bool = true;
      }
    }
    return bool;
  }
  
  public void ac_()
  {
    this.jdField_a_of_type_Bjmp.post(new Leba.2(this));
  }
  
  public bfvp b(aqmf paramaqmf, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bfvp parambfvp)
  {
    paramaqmf = (nmq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramaqmf.d();
    if (n > 0) {
      localStringBuffer.append("redid=" + n);
    }
    int i1 = paramaqmf.a();
    if (i1 > 0) {
      if (localStringBuffer.length() != 0) {
        break label255;
      }
    }
    label255:
    for (paramaqmf = "";; paramaqmf = "&rpnumber=" + i1)
    {
      localStringBuffer.append(paramaqmf);
      QLog.i("Leba", 1, "xqbl redid=" + n + ",rpnumber=" + i1);
      try
      {
        paramaqmf = new JSONObject(paramAppInfo.buffer.get());
        if (paramaqmf != null)
        {
          paramaqmf = paramaqmf.optJSONObject("param");
          if (paramaqmf != null)
          {
            paramAppInfo = paramaqmf.optJSONObject((String)paramAppInfo.missions.get(0));
            if (paramAppInfo != null)
            {
              paramaqmf = paramAppInfo.optString("_red_ext_bid");
              paramAppInfo = paramAppInfo.optString("_red_ext_pid");
              if (!TextUtils.isEmpty(paramaqmf)) {
                localStringBuffer.append("&bid=").append(paramaqmf);
              }
              if (!TextUtils.isEmpty(paramAppInfo)) {
                localStringBuffer.append("&pid=").append(paramAppInfo);
              }
            }
          }
        }
      }
      catch (Exception paramaqmf)
      {
        for (;;)
        {
          QLog.i("Leba", 1, "handerSpecialWhenJumpScheme", paramaqmf);
        }
      }
      if (localStringBuffer.length() > 0) {
        parambfvp.e(localStringBuffer.toString());
      }
      return parambfvp;
    }
  }
  
  public void b(View paramView, aqmf paramaqmf)
  {
    if ((paramaqmf == null) || (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    a(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, new ados(this, paramView, paramaqmf));
  }
  
  public void b(aqmf paramaqmf)
  {
    if (paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) {
      StatisticCollector.getInstance(a()).reportActionCount(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
    }
    if (paramaqmf.jdField_a_of_type_Long == 1047L) {
      axys.a().jdField_a_of_type_Int = 4;
    }
    b(new Leba.42(this));
    if (!paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist")) {
      this.jdField_f_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      z();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.initLebaHelper();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_Bjmp);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addLebaListener(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Axkw);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axku);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Axkt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amsu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anwh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amyh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Awib);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Arht);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
      bcoo.a(this.jdField_a_of_type_Bcoq);
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
  
  public bfvp c(aqmf paramaqmf, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bfvp parambfvp)
  {
    Object localObject = (nmq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    paramAppInfo = ((nmq)localObject).a();
    paramaqmf = paramAppInfo;
    if (paramAppInfo == null)
    {
      paramaqmf = paramAppInfo;
      if (((vxx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "check invisible red point for msgtab");
        }
        paramaqmf = ((nmq)localObject).a(52);
        if (paramaqmf != null) {
          break label223;
        }
        paramaqmf = ((nmq)localObject).a(35);
      }
    }
    label223:
    for (;;)
    {
      paramAppInfo = parambfvp;
      if (paramaqmf != null)
      {
        paramAppInfo = parambfvp;
        if (paramaqmf.uint32_appid.get() == 37) {
          localObject = null;
        }
      }
      try
      {
        paramAppInfo = new JSONObject(paramaqmf.str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
        localObject = paramAppInfo;
      }
      catch (Exception paramAppInfo)
      {
        for (;;)
        {
          xvv.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { paramAppInfo.getMessage() });
          continue;
          paramaqmf = String.valueOf(paramaqmf.uint32_appid.get());
        }
      }
      paramAppInfo = parambfvp;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppInfo = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject);
      }
      if (paramaqmf == null)
      {
        paramaqmf = "";
        paramAppInfo.a("redid", paramaqmf);
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
  
  void c(View paramView, aqmf paramaqmf)
  {
    if (paramaqmf == null) {
      return;
    }
    paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = amux.jdField_a_of_type_JavaLangString;
    String str = bfyz.c(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {
      paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = str.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("enterXQBL", 2, "跳转url = " + paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
    }
    b(paramView, paramaqmf);
    O();
    bcef.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
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
      boolean bool = bbgh.a();
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
      if ((bcoo.a()) && (this.jdField_a_of_type_Ajef != null)) {}
      try
      {
        this.jdField_a_of_type_Ajef.d();
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
    ((ViewStub)a(2131377901)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131364913)).setOnFirstDrawListener(this);
    this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
    QzoneConfig.getInstance().addListener(this);
    atzd.d();
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onResume" + ajek.jdField_a_of_type_Int);
    }
    AbstractGifImage.resumeAll();
    ple.a().c();
    if (this.k)
    {
      ThreadRegulator.a().b(4);
      this.k = false;
    }
    aebs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Adpo != null) {
      this.jdField_a_of_type_Adpo.c();
    }
    if (this.jdField_b_of_type_Adpo != null) {
      this.jdField_b_of_type_Adpo.c();
    }
    ThreadManager.post(new Leba.4(this), 5, null, false);
    ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    if ((!this.jdField_g_of_type_Boolean) || ((ajek.jdField_a_of_type_Int & 0x4) != 0)) {
      this.jdField_a_of_type_Bjmp.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.c(true);
      this.jdField_a_of_type_Bjmp.postDelayed(new Leba.5(this), 100L);
      ThreadManagerV2.excute(new Leba.6(this, (awhw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
      N();
      X_();
      Object localObject;
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setFocusable(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(2131691013));
        localObject = a(2131693565);
        this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131693565));
      }
      if (this.jdField_a_of_type_Ajef != null) {
        this.jdField_a_of_type_Ajef.a();
      }
      if (this.jdField_a_of_type_Auxd != null) {
        this.jdField_a_of_type_Auxd.b(true);
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
      if (ajek.jdField_a_of_type_Int > 0)
      {
        localObject = new ArrayList();
        amvb.a((List)localObject, ajek.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
          if (this.jdField_a_of_type_Ajef != null)
          {
            this.jdField_a_of_type_Ajef.b();
            I();
          }
        }
        ajek.jdField_a_of_type_Int = 0;
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
    this.jdField_a_of_type_Aufo.d();
    this.jdField_b_of_type_Aufo.d();
    awjm.c(0);
    this.jdField_a_of_type_Bjmp.removeMessages(1134010);
    if (this.jdField_a_of_type_Adpo != null) {
      this.jdField_a_of_type_Adpo.b();
    }
    if (this.jdField_b_of_type_Adpo != null) {
      this.jdField_b_of_type_Adpo.b();
    }
    if (this.jdField_a_of_type_Ajef != null) {
      this.jdField_a_of_type_Ajef.a(b(), f(), c());
    }
    if (this.jdField_a_of_type_Auxd != null) {
      this.jdField_a_of_type_Auxd.c();
    }
    this.jdField_a_of_type_Bjmp.postDelayed(new Leba.3(this), 500L);
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
    if (this.jdField_a_of_type_Adpo != null) {
      this.jdField_a_of_type_Adpo.d();
    }
    if (this.jdField_b_of_type_Adpo != null) {
      this.jdField_b_of_type_Adpo.d();
    }
    if (this.jdField_a_of_type_Auxd != null) {
      this.jdField_a_of_type_Auxd.d();
    }
    super.i();
  }
  
  public void j()
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
  
  public void k()
  {
    super.k();
    x();
    if (this.jdField_a_of_type_Adpo != null) {
      this.jdField_a_of_type_Adpo.d();
    }
    if (this.jdField_b_of_type_Adpo != null) {
      this.jdField_b_of_type_Adpo.d();
    }
  }
  
  protected void l()
  {
    Object localObject = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    int i1;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((azvi)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        i1 = 0;
        int n = i1;
        if (i1 == -1)
        {
          localAppInfo = ((azvi)localObject).a("886.100171");
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
          localObject = ((azvi)localObject).a("886.100172");
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
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, i1 + "", "", "", "");
        }
        if (((nmq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).a()) {
          axfz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "entry", "official_push_exp");
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
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, 4, 2130838892, "-leba-");
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
      bbyp.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Bjmp.sendEmptyMessageDelayed(11340002, 0L);
      X_();
      if (this.jdField_a_of_type_Ajef != null) {
        this.jdField_a_of_type_Ajef.c();
      }
      if (this.jdField_a_of_type_Adpo != null) {
        this.jdField_a_of_type_Adpo.e();
      }
      if (this.jdField_b_of_type_Adpo != null) {
        this.jdField_b_of_type_Adpo.e();
      }
      if (this.jdField_a_of_type_Auxd != null) {
        this.jdField_a_of_type_Auxd.f();
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        TextHook.updateFont(this.jdField_c_of_type_AndroidViewView);
      }
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850016);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167009));
    }
  }
  
  public void o()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      boolean bool1 = bbyp.a();
      boolean bool2 = bcoo.a();
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
      case 2131369082: 
      case 2131369099: 
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
        H();
        break;
      case 2131374248: 
        HashMap localHashMap = new HashMap();
        localHashMap.put("key_enable_splash", "1");
        localHashMap.put("key_jump_from", "3");
        if (this.jdField_b_of_type_Boolean) {}
        for (localObject = "1";; localObject = "0")
        {
          localHashMap.put("key_show_active_red_dot", localObject);
          localHashMap.put("key_unread_red_num", this.jdField_c_of_type_Int + "");
          if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
            localHashMap.put("key_red_dot_trans_info", new String(this.jdField_a_of_type_ArrayOfByte));
          }
          if (this.jdField_b_of_type_Int > 0) {
            localHashMap.put("key_assign_show_tab_type", this.jdField_b_of_type_Int + "");
          }
          vgn.a(a(), "openfolder", localHashMap);
          R();
          G();
          a(1);
          break;
        }
      case 2131375260: 
        if (QLog.isColorLevel()) {
          QLog.d("HardCoder", 2, "launch qzone");
        }
        jdField_a_of_type_Int = acjp.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootQzone");
        localObject = (aqmf)ajek.a().jdField_a_of_type_JavaUtilHashMap.get("qzone_feedlist");
        QLog.d("Q.lebatab.leba", 1, "user clicked qzone feed entry.");
        ThreadManager.postImmediately(new Leba.31(this, (aqmf)localObject), null, true);
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
    } while (this.jdField_a_of_type_Ajef == null);
    this.jdField_a_of_type_Ajef.a(paramAbsListView, paramInt);
  }
  
  public void q()
  {
    QLog.d("Leba", 1, "onLebaTabChange");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      avta localavta = (avta)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      bboz.jdField_a_of_type_Boolean = true;
      if (localavta != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localavta.a(3);
      }
      QCircleEeveeMananger.getInstance().onSend(3, null, null);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mLebaHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mLebaHelper.b();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mLebaHelper.e();
      }
    }
    if (!e()) {
      C();
    }
    a(2);
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)) {}
    ogr localogr;
    do
    {
      return;
      localogr = (ogr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(88);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localogr == null);
    localogr.a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
  
  public void y()
  {
    super.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */