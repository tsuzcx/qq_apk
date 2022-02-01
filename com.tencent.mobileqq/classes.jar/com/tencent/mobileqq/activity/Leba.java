package com.tencent.mobileqq.activity;

import admw;
import aevj;
import aevk;
import aevl;
import aevm;
import aevn;
import aevo;
import aevp;
import aevq;
import aevr;
import aevs;
import aevt;
import aevu;
import aevv;
import aevw;
import aevx;
import aevy;
import aevz;
import aewa;
import aewc;
import aewe;
import aewf;
import aewi;
import aewm;
import afja;
import akgm;
import akgn;
import akgr;
import akgv;
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
import anuw;
import anxr;
import anyu;
import anzj;
import aoaw;
import aoaz;
import aoeg;
import apce;
import aqyl;
import aqyp;
import aqyt;
import arsh;
import asvt;
import avsm;
import awjy;
import awjz;
import awkd;
import awkn;
import awkp;
import awwr;
import axft;
import axup;
import axus;
import axuu;
import axwe;
import axws;
import axxb;
import aysq;
import aysr;
import ayxl;
import ayxm;
import ayxo;
import azlk;
import bbav;
import bcnf;
import bcuy;
import bcvn;
import bdgb;
import bdkm;
import bdll;
import bdlq;
import bdmc;
import bdml;
import bdne;
import bduy;
import bduz;
import bhga;
import bhmg;
import bhmr;
import bhni;
import bhsi;
import bhyk;
import biur;
import bjty;
import blha;
import blhf;
import blhn;
import blih;
import blqj;
import bmaf;
import bmzn;
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
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
import nku;
import nlb;
import nql;
import ofe;
import org.json.JSONObject;
import pfs;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;
import uyx;
import vlc;
import vtq;
import wwh;
import yuk;
import yup;

public class Leba
  extends anxr
  implements aewi, akgv, View.OnClickListener, ViewStub.OnInflateListener, awkd, blih, bmaf
{
  public static int a;
  static long jdField_b_of_type_Long;
  private static List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_d_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_e_of_type_JavaUtilList = new ArrayList();
  protected final long a;
  private aewm jdField_a_of_type_Aewm;
  private akgm jdField_a_of_type_Akgm;
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aevk(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anuw jdField_a_of_type_Anuw = new aevy(this);
  anyu jdField_a_of_type_Anyu = new aevw(this);
  private aoeg jdField_a_of_type_Aoeg = new aevv(this);
  private apce jdField_a_of_type_Apce = new aevu(this);
  private asvt jdField_a_of_type_Asvt = new aevz(this);
  private avsm jdField_a_of_type_Avsm = new avsm("qzone_leba", "com.tencent.mobileqq:qzone");
  private awjz jdField_a_of_type_Awjz;
  axuu jdField_a_of_type_Axuu = new aevx(this);
  private ayxl jdField_a_of_type_Ayxl = new aevt(this);
  private ayxm jdField_a_of_type_Ayxm = new aevs(this);
  private ayxo jdField_a_of_type_Ayxo = new aevr(this);
  bduz jdField_a_of_type_Bduz = new aewc(this);
  public blha a;
  private QCircleObserver jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver = new aewa(this);
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new aevj(this);
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
  private volatile boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = -1;
  private aewm jdField_b_of_type_Aewm;
  private View jdField_b_of_type_AndroidViewView;
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private avsm jdField_b_of_type_Avsm = new avsm("web_leba", "com.tencent.mobileqq:tool");
  private String jdField_b_of_type_JavaLangString;
  private List<arsh> jdField_b_of_type_JavaUtilList;
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
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean = true;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private boolean jdField_h_of_type_Boolean;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  private boolean k;
  private boolean l = true;
  
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
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = awwr.a();
    this.jdField_a_of_type_JavaLangString = ("mobileMP" + System.currentTimeMillis());
    this.jdField_a_of_type_Long = 30000L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Blha = new blha(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131369827));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369817));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(a().getDrawable(2130850234));
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
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561262, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
        this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131375492);
        localObject = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369885);
        if ((localObject instanceof ThemeImageView)) {
          ((ThemeImageView)localObject).setMaskShape(blqj.jdField_c_of_type_Int);
        }
        ((ImageView)localObject).setImageResource(2130845335);
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839402);
        ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369886)).setText(2131718521);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375494));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375545));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375706));
        this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376046));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131375495));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new aevl(this));
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375507));
        this.jdField_c_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131375496));
        this.jdField_c_of_type_AndroidWidgetImageSwitcher.setFactory(new aevm(this));
        D();
        this.jdField_a_of_type_Aewm = new aewm(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_c_of_type_AndroidWidgetImageSwitcher, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Blha, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376925));
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369816));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131366151));
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        bhga.a(this.jdField_a_of_type_AndroidWidgetEditText, a(2131691016));
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380067));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363745));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.k = BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("has_search_bar", false);
        k();
        this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new aevn(this));
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          bhga.b(this.jdField_b_of_type_AndroidViewView);
          bhga.a(this.jdField_c_of_type_AndroidViewView, anzj.a(2131718521), Button.class.getName());
        }
      }
      if (this.jdField_a_of_type_Akgm != null)
      {
        localObject = new akgn();
        ((akgn)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ((akgn)localObject).jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
        ((akgn)localObject).jdField_a_of_type_AndroidContentContext = a();
        ((akgn)localObject).jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
        ((akgn)localObject).jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
        ((akgn)localObject).jdField_a_of_type_Awkd = this;
        this.jdField_a_of_type_Akgm.a((akgn)localObject);
      }
      if (this.jdField_a_of_type_Awjz == null)
      {
        this.jdField_a_of_type_Awjz = new awjz(a());
        this.jdField_a_of_type_Awjz.a(this.jdField_a_of_type_AndroidViewView);
        int m = a().getTitleBarHeight();
        int n = (int)bhmg.a(a(), 5.0F);
        this.jdField_a_of_type_Awjz.b();
        this.jdField_a_of_type_Awjz.a(m - n);
      }
      n();
    }
  }
  
  private void D()
  {
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131374480);
    if ((!d()) || (bdgb.a())) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131369885));
      if ((this.jdField_d_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.jdField_d_of_type_AndroidWidgetImageView).setMaskShape(blqj.jdField_c_of_type_Int);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845338);
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130839402);
      ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374485)).setText(2131718520);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374487));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374488));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374486));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374489));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_d_of_type_AndroidViewView.findViewById(2131374482));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new aevo(this));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374484));
      this.jdField_d_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_d_of_type_AndroidViewView.findViewById(2131374483));
      this.jdField_d_of_type_AndroidWidgetImageSwitcher.setFactory(new aevp(this));
      this.jdField_b_of_type_Aewm = new aewm(this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_d_of_type_AndroidWidgetImageSwitcher, this.jdField_f_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Blha, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    Object localObject3 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    Object localObject2 = ((bbav)localObject3).a(String.valueOf(100510));
    ((aysq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160)).a(100510);
    akgr.jdField_a_of_type_Int |= 0x1;
    Object localObject1 = ((bbav)localObject3).a("100510.100517");
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
      ((bbav)localObject3).b("100510.100517");
      localObject3 = (nku)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43);
      ((nku)localObject3).a(60);
      ((nku)localObject3).a(59);
      localObject3 = (nlb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
      if (((nlb)localObject3).a())
      {
        aysr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "home", "official_push_click");
        if (this.jdField_f_of_type_Int != 0) {
          ThreadManagerV2.excute(new Leba.22(this, (axup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
        }
      }
      ((nlb)localObject3).a(false);
      int n;
      boolean bool;
      if (this.jdField_a_of_type_Akgm == null)
      {
        n = -1;
        this.jdField_a_of_type_Blha.post(new Leba.23(this));
        ThreadManagerV2.excute(new Leba.24(this, (axup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
        if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) || (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 1)) {
          break label1073;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
        bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          axxb.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        axwe.b(0);
        if (!axws.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
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
          new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_clk_red").a();
        }
        for (;;)
        {
          axus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, n);
          if (bool) {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
          }
          pfs.a().a("FuJin", bool);
          return;
          n = this.jdField_a_of_type_Akgm.a();
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
            localObject1 = ((nlb)localObject3).a(60);
            if ((localObject1 != null) && (((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get() == 1822701914L)) {
              new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_clk_red").a();
            } else {
              new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_clk_red").a();
            }
          }
          else if (n == 61)
          {
            new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_clk_red").a();
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
      axft localaxft = (axft)a().app.getManager(10);
      if (localaxft != null)
      {
        if (this.jdField_e_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localaxft.a(3);
        }
        localaxft.a(false);
      }
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void G()
  {
    int m = a();
    if (m != 0) {
      vtq.a("", 1, 2, m, "1", "", this.jdField_b_of_type_JavaLangString, null, "", "", null, -1, -1);
    }
  }
  
  private void H()
  {
    akgr.a().jdField_a_of_type_Boolean = true;
    ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("150000");
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
    this.jdField_a_of_type_Blha.sendEmptyMessageDelayed(1134006, 200L);
    N();
    if ((this.jdField_a_of_type_Akgm != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Akgm.b();
    }
  }
  
  private void J()
  {
    ThreadManager.post(new Leba.35(this), 5, null, false);
  }
  
  private void K()
  {
    if ((!d()) || (bdgb.a()))
    {
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
      QLog.e("QCircleEeveeRedPoint_Leba", 1, "updateQQCircleRedFlag hide");
      return;
    }
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    QLog.e("QCircleEeveeRedPoint_Leba", 1, "updateQQCircleRedFlag show");
    ThreadManager.post(new Leba.36(this), 5, null, false);
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
    int m = a();
    if ((m != 0) && (this.jdField_a_of_type_Boolean))
    {
      vtq.a("", 1, 1, m, "1", "", this.jdField_b_of_type_JavaLangString, null, "", "", null, -1, -1);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void N()
  {
    if (bdgb.a()) {}
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        QLog.i("Leba", 1, "updateIconEntryRedTouch app == null");
        return;
      }
      localAppInfo = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("150000");
    } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).a().a(localAppInfo);
    a(localAppInfo);
  }
  
  private void O()
  {
    Object localObject = (nlb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((nlb)localObject).a(1);
      if (localRedDotInfo != null) {
        nku.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
      }
      localObject = ((nlb)localObject).a(6);
      if (localObject != null) {
        nku.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject);
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
    awkn localawkn = new awkn();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localawkn.jdField_a_of_type_Boolean = bool;
      localawkn.jdField_a_of_type_Long = 10000L;
      localawkn.jdField_a_of_type_Int = 0;
      localawkn.jdField_b_of_type_Int = b();
      localawkn.jdField_d_of_type_Int = 2;
      if (this.jdField_a_of_type_Akgm != null) {
        localawkn.jdField_d_of_type_Int = awkp.a(this.jdField_a_of_type_Akgm.b());
      }
      a(localawkn);
      return;
    }
  }
  
  private void R()
  {
    awkn localawkn = new awkn();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localawkn.jdField_a_of_type_Boolean = bool;
      localawkn.jdField_a_of_type_Long = 10004L;
      localawkn.jdField_a_of_type_Int = 0;
      localawkn.jdField_b_of_type_Int = c();
      localawkn.jdField_d_of_type_Int = 0;
      a(localawkn);
      return;
    }
  }
  
  private int a()
  {
    int m = 0;
    if ((this.jdField_c_of_type_Int > 0) && (this.jdField_b_of_type_Boolean)) {
      m = 3;
    }
    do
    {
      return m;
      if (this.jdField_b_of_type_Boolean) {
        return 1;
      }
      if (this.jdField_c_of_type_Int > 0) {
        return 2;
      }
    } while (!this.jdField_d_of_type_Boolean);
    return 5;
  }
  
  private arsh a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        arsh localarsh = (arsh)localIterator.next();
        if ((localarsh != null) && (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName != null) && (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName != null) && (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))) {
          return localarsh;
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_d_of_type_AndroidViewView != null) && ((this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) || (d())))
    {
      akgr.jdField_a_of_type_Int |= 0x2;
      if (QLog.isColorLevel()) {
        QLog.d("Leba", 2, "updateRefreshFlagForQQCircle " + paramInt);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, List<String> paramList, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    a(new Leba.37(this, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramString, paramList));
  }
  
  private void a(awkn paramawkn)
  {
    if (paramawkn == null)
    {
      QLog.i("Q.lebatab.leba", 1, "reportPluginClick  reportInfo == null ");
      return;
    }
    QLog.i("Q.lebatab.leba", 1, String.format("reportPluginClick id = %d pos = %d type = %d mode = %b hasAssistsText = %d", new Object[] { Long.valueOf(paramawkn.jdField_a_of_type_Long), Integer.valueOf(paramawkn.jdField_a_of_type_Int), Integer.valueOf(paramawkn.jdField_b_of_type_Int), Boolean.valueOf(paramawkn.jdField_a_of_type_Boolean), Integer.valueOf(paramawkn.jdField_c_of_type_Int) }));
    if (paramawkn.jdField_a_of_type_Boolean)
    {
      bdne localbdne = awkp.a("plugin_clk");
      localbdne.jdField_a_of_type_JavaLangString = String.valueOf(paramawkn.jdField_a_of_type_Long);
      localbdne.jdField_c_of_type_JavaLangString = String.valueOf(paramawkn.jdField_a_of_type_Int);
      localbdne.d = String.valueOf(paramawkn.jdField_b_of_type_Int);
      localbdne.e = String.valueOf(paramawkn.jdField_c_of_type_Int);
      localbdne.f = String.valueOf(paramawkn.jdField_d_of_type_Int);
      localbdne.g = ThemeUtil.getCurrentThemeId();
      bdkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbdne);
      return;
    }
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(paramawkn.jdField_a_of_type_Long), String.valueOf(paramawkn.jdField_a_of_type_Int), String.valueOf(paramawkn.jdField_b_of_type_Int), "");
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private int b()
  {
    int n = 0;
    int m;
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      m = 7;
    }
    do
    {
      do
      {
        return m;
        if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          return 4;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          return 5;
        }
        m = n;
      } while (this.jdField_f_of_type_AndroidWidgetTextView == null);
      m = n;
    } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
    return 6;
  }
  
  private String b()
  {
    Object localObject2 = bhyk.a("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((arsh)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((arsh)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((bhmr)localObject3).b("url");
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
    int m = awkp.a(paramBoolean, paramRedTypeInfo);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(m), "");
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
    for (long l1 = localLebaPluginInfo.uiResId;; l1 = 0L)
    {
      ThreadManager.postImmediately(new Leba.7(this, l1), null, false);
      q();
      return;
    }
  }
  
  private int c()
  {
    int n = 0;
    int m;
    boolean bool1;
    boolean bool2;
    if (this.jdField_c_of_type_Int > 0)
    {
      m = 1;
      bool1 = this.jdField_b_of_type_Boolean;
      bool2 = this.jdField_c_of_type_Boolean;
      if (m == 0) {
        break label42;
      }
      if (!bool1) {
        break label40;
      }
      m = 7;
    }
    label40:
    label42:
    do
    {
      return m;
      m = 0;
      break;
      return 4;
      if (bool1) {
        return 5;
      }
      m = n;
    } while (!bool2);
    return 8;
  }
  
  public static boolean d()
  {
    return (QzoneConfig.isQQCircleShowLebaEntrance()) && (QzoneConfig.isQQCircleShowLebaBySwitchButton());
  }
  
  private boolean f()
  {
    return (this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_Akgm != null) && (this.jdField_a_of_type_Akgm.b() == 1);
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
    if ((localObject1 != null) && (((arsh)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {}
    for (long l1 = ((arsh)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;; l1 = 489L)
    {
      localObject1 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      Object localObject2 = ((bbav)localObject1).a("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbav)localObject1).a(String.valueOf(l1));
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
        ((bbav)localObject1).b(String.valueOf("200010.200011"));
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
      QLog.d("Leba", 1, "hideQQCircleAfterAccountChanged");
    }
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131379037));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378956));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131376731));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369825));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)a(2131369088));
    this.jdField_i_of_type_AndroidWidgetTextView.setText(2131718526);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369056));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (bdgb.a()) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
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
      bdgb.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850099);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166987));
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayxo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayxm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayxl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Apce);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoeg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Axuu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asvt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver);
      bduy.b(this.jdField_a_of_type_Bduz);
    }
  }
  
  public aewf a(arsh paramarsh, String paramString, short paramShort, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ("com.cmshow.game.android".equals(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_tab_game", 0, 0);
    }
    Object localObject;
    short s;
    String str;
    if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))
    {
      paramString = a("vipGameCenter");
      List localList;
      int m;
      if (TextUtils.isEmpty(paramString))
      {
        paramString = paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;
        QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use plugin info url=" + paramString);
        localObject = paramString;
        s = paramShort;
        if (!paramBoolean1) {
          break label367;
        }
        str = "-1";
        localList = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId)).missions.get();
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
        if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 0L) {
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
        pfs.a().b((int)paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean3);
        for (;;)
        {
          paramString = new aewf();
          paramString.jdField_a_of_type_JavaLangString = ((String)localObject);
          paramString.jdField_a_of_type_Short = s;
          paramString.jdField_b_of_type_Boolean = paramBoolean3;
          paramString.jdField_c_of_type_Boolean = paramBoolean1;
          paramString.jdField_d_of_type_Boolean = paramBoolean2;
          paramString.jdField_a_of_type_Arsh = paramarsh;
          return paramString;
          if (paramShort != 2) {
            break label611;
          }
          str = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramString).b("url");
          paramString = paramString.replace(str, str + URLEncoder.encode(new StringBuilder().append("&missions=").append((String)localObject).toString()));
          break;
          paramBoolean3 = false;
          break label404;
          pfs.a().b((int)paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean1);
          if ("com.tx.xingqubuluo.android".equals(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
            paramBoolean3 = paramBoolean1;
          }
          if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 7966L) {
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
    this.jdField_a_of_type_Akgm = new akgm();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public bhmr a(arsh paramarsh, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bhmr parambhmr)
  {
    if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
      parambhmr.e("platformId=qq_m");
    }
    do
    {
      return parambhmr;
      if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.xingqubuluo.android")) {
        return b(paramarsh, paramAppInfo, parambhmr);
      }
      if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.read.android"))
      {
        parambhmr.a("ChannelID", "100020");
        return parambhmr;
      }
    } while (!a(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
    return c(paramarsh, paramAppInfo, parambhmr);
  }
  
  public bhmr a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    return bhni.a(paramQQAppInterface, paramContext, paramString);
  }
  
  public String a()
  {
    return anzj.a(2131704911);
  }
  
  public String a(String paramString)
  {
    return bhyk.a(paramString);
  }
  
  public void a()
  {
    super.a();
    k();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onAccountChanged");
    }
    if (this.jdField_a_of_type_Aewm != null) {
      this.jdField_a_of_type_Aewm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_b_of_type_Aewm != null) {
      this.jdField_b_of_type_Aewm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    L();
    akgr.a().a();
    I();
    if (this.jdField_a_of_type_Awjz != null) {
      this.jdField_a_of_type_Awjz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    vlc.a().a(4, null, null);
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
  
  public void a(aewf paramaewf)
  {
    Object localObject2 = paramaewf.jdField_a_of_type_JavaLangString;
    Object localObject1 = paramaewf.jdField_b_of_type_JavaLangString;
    int m = paramaewf.jdField_a_of_type_Short;
    boolean bool1 = paramaewf.jdField_a_of_type_Boolean;
    boolean bool2 = paramaewf.jdField_b_of_type_Boolean;
    String str1 = paramaewf.jdField_c_of_type_JavaLangString;
    boolean bool3 = paramaewf.jdField_c_of_type_Boolean;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramaewf.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
    int n = paramaewf.jdField_a_of_type_Int;
    int i1 = paramaewf.jdField_b_of_type_Int;
    Object localObject3 = paramaewf.jdField_a_of_type_AndroidViewView;
    boolean bool4 = paramaewf.jdField_d_of_type_Boolean;
    localObject3 = paramaewf.jdField_a_of_type_Arsh;
    bbav localbbav = paramaewf.jdField_a_of_type_Bbav;
    if ((localObject2 == null) || ("".equals(localObject2))) {
      a((arsh)localObject3, localAppInfo, localbbav);
    }
    String str2;
    do
    {
      return;
      str2 = (String)awjy.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((arsh)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      if (m != 0) {
        break;
      }
      localObject1 = localObject2;
      if (((String)localObject2).contains("plg_uin=1")) {
        localObject1 = (String)localObject2 + "&mqquin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      paramaewf = (aewf)localObject1;
      if (((String)localObject1).contains("plg_vkey=1")) {
        paramaewf = (String)localObject1 + "&mqqvkey=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
      }
      localObject2 = a(QQBrowserActivity.class);
      if (paramaewf.contains("plg_nld=1")) {
        ((Intent)localObject2).putExtra("reportNld", true);
      }
      localObject1 = paramaewf;
      if (!TextUtils.isEmpty(str1))
      {
        ((Intent)localObject2).putExtra("redTouch", str1);
        localObject1 = paramaewf;
        if (paramaewf.contains("red_touch=1")) {
          localObject1 = paramaewf + "&" + str1;
        }
      }
      this.jdField_b_of_type_Avsm.b();
      ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject2).putExtra("plugin_start_time", System.nanoTime());
      ((Intent)localObject2).putExtra("click_start_time", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("is_from_leba", true);
      ((Intent)localObject2).putExtra("leba_resid", ((arsh)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
      ((Intent)localObject2).putExtra("has_red_dot", bool2);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      if (!TextUtils.isEmpty(str2)) {
        ((Intent)localObject2).putExtra("big_brother_source_key", str2);
      }
    } while (!a((arsh)localObject3, (String)localObject1, (Intent)localObject2, bool3, bool2, localAppInfo));
    a((Intent)localObject2);
    while (m != 2)
    {
      a((arsh)localObject3, localAppInfo, localbbav);
      b((arsh)localObject3);
      return;
    }
    paramaewf = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject2);
    if (paramaewf != null)
    {
      paramaewf = a((arsh)localObject3, localAppInfo, paramaewf);
      paramaewf.a("from_leba", "fromleba");
      paramaewf.a("leba_resid", String.valueOf(((arsh)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      paramaewf.a("config_res_plugin_item_name", (String)localObject1);
      paramaewf.a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
      paramaewf.a(bool1);
      paramaewf.c(((arsh)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
      paramaewf.f(str1);
      paramaewf.b(bool2);
      paramaewf.a(localAppInfo);
      if (!TextUtils.isEmpty(str2)) {
        paramaewf.a("download_sourceid", str2);
      }
      if ((((arsh)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 8059L) || (!MiniAppLauncher.isMiniAppUrl((String)localObject2))) {
        break label716;
      }
      MiniAppLauncher.startMiniApp(a(), (String)localObject2, 2050, null);
    }
    for (;;)
    {
      blhf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (arsh)localObject3, n, i1);
      if (this.jdField_a_of_type_JavaUtilSet.contains(((arsh)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName)) {
        this.jdField_b_of_type_Avsm.b();
      }
      a((arsh)localObject3);
      break;
      label716:
      a(paramaewf);
    }
  }
  
  public void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      ofe localofe = (ofe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      String str1 = String.valueOf(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = blhn.a(str2, "code", paramMessage.auth_code.get());
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
          if (localofe != null) {
            localofe.a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localofe != null) {
            localofe.a(134246777, null, "not_jump", str1, "", 0L, false);
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
          if (localofe != null) {
            localofe.a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
      }
    }
  }
  
  public void a(View paramView, arsh paramarsh)
  {
    if (c()) {
      ThreadManager.post(new Leba.18(this, paramView, paramarsh), 8, null, true);
    }
  }
  
  public void a(View paramView, arsh paramarsh, awkn paramawkn)
  {
    if ((paramarsh == null) || (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "onPluginClick item == null || item.info == null");
      return;
    }
    for (;;)
    {
      try
      {
        QLog.i("Q.lebatab.leba", 1, "onPluginClick item = " + paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.toString());
        a(paramawkn);
        paramawkn = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if ((paramarsh != null) && (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == nql.jdField_a_of_type_Int))
        {
          yup.a("dynamic", "clk_story", 0, ((nlb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).c(), new String[0]);
          a(paramView, paramarsh);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.w("Q.lebatab.leba", 1, "onPluginClick", paramView);
        return;
      }
      if ((paramarsh != null) && (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7719L == paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        E();
        paramawkn.a(100510, 31);
        return;
      }
      if ((paramarsh != null) && (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (826L == paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        c(paramView, paramarsh);
        return;
      }
      if ((paramarsh != null) && (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7720L == paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        ExtendFriendPublicFragmentActivity.a(a(), 2);
        if ((paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId <= 0L)) {
          break;
        }
        paramawkn.a((int)paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, 31);
        return;
      }
      if ((paramarsh != null) && (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (7759L == paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        aqyl localaqyl = ((aqyp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
        String str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramawkn = str;
        if (localaqyl != null)
        {
          paramawkn = str;
          if (!TextUtils.isEmpty(localaqyl.l)) {
            paramawkn = localaqyl.l;
          }
        }
        paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = paramawkn;
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean, arsh paramarsh)
  {
    if ((paramarsh == null) || (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    String str1 = paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl;
    String str2 = paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName;
    short s = paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sResSubType;
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
    paramarsh = a(paramarsh, str1, s, bool1, paramBoolean, false);
    arsh localarsh = paramarsh.jdField_a_of_type_Arsh;
    str1 = paramarsh.jdField_a_of_type_JavaLangString;
    s = paramarsh.jdField_a_of_type_Short;
    bool3 = paramarsh.jdField_c_of_type_Boolean;
    boolean bool4 = paramarsh.jdField_d_of_type_Boolean;
    paramBoolean = paramarsh.jdField_b_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str2 + ",url=" + str1 + ",type=" + s);
    }
    bbav localbbav = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbav.a(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "");
    int i1 = 0;
    int n = 0;
    int i2 = 0;
    int m = 0;
    if (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId > 0L) {
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
      {
        str1 = bmzn.a(str1, localAppInfo);
        if (localAppInfo.type.get() == 0) {
          paramBoolean = true;
        }
        if (!localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
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
        paramarsh = localAppInfo.red_display_info.red_type_info.get();
        if ((paramarsh == null) || (paramarsh.size() < 2)) {}
      }
      for (m = ((BusinessInfoCheckUpdate.RedTypeInfo)paramarsh.get(1)).red_type.get();; m = 0)
      {
        i1 = localAppInfo.num.get();
        paramarsh = "status=" + m + "&number=" + i1 + "&path=" + localAppInfo.path.get();
        n = m;
        m = i1;
        Object localObject = (bcuy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
        if (localObject != null) {
          if (((bcuy)localObject).a(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "") != -1)
          {
            bool1 = true;
            if (!bool4) {
              break label749;
            }
            localbbav.b(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId + "");
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
            localObject = new aewf();
            ((aewf)localObject).jdField_a_of_type_JavaLangString = str1;
            ((aewf)localObject).jdField_b_of_type_JavaLangString = str2;
            ((aewf)localObject).jdField_a_of_type_Short = s;
            ((aewf)localObject).jdField_a_of_type_Boolean = paramBoolean;
            ((aewf)localObject).jdField_b_of_type_Boolean = bool1;
            ((aewf)localObject).jdField_c_of_type_JavaLangString = paramarsh;
            ((aewf)localObject).jdField_c_of_type_Boolean = bool3;
            ((aewf)localObject).jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localAppInfo;
            ((aewf)localObject).jdField_a_of_type_Int = n;
            ((aewf)localObject).jdField_b_of_type_Int = m;
            ((aewf)localObject).jdField_a_of_type_AndroidViewView = paramView;
            ((aewf)localObject).jdField_d_of_type_Boolean = bool4;
            ((aewf)localObject).jdField_a_of_type_Arsh = localarsh;
            ((aewf)localObject).jdField_a_of_type_Bbav = localbbav;
            a((aewf)localObject);
            return;
            paramarsh = "status=" + -1 + "&number=0" + "&path=" + localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
            break;
            bool1 = false;
            break label517;
            label749:
            localbbav.a((int)localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, 31);
            break label554;
            if (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
            {
              bool2 = a(false);
              paramarsh = null;
              bool1 = paramBoolean;
              m = i2;
              n = i1;
              paramBoolean = bool2;
            }
            else
            {
              paramarsh = null;
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
  
  public void a(arsh paramarsh)
  {
    if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
    {
      bdml.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bdml.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_Avsm.b();
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
      paramarsh = (bcvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (paramarsh != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
        }
        paramarsh.a(true);
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
    }
  }
  
  protected void a(arsh paramarsh, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bbav parambbav)
  {
    if ((paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId > 0L))
    {
      parambbav = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      String str = String.valueOf(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
      if ((paramAppInfo != null) && (parambbav != null) && (parambbav.a(str))) {
        ThreadManager.getFileThreadHandler().post(new Leba.25(this, str, paramAppInfo));
      }
      if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals(biur.jdField_a_of_type_JavaLangString)) {
        ThreadManager.post(new Leba.26(this), 5, null, false);
      }
      if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 7759L) {
        aqyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  protected void a(bhmr parambhmr)
  {
    if (parambhmr != null) {
      parambhmr.a();
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
  
  public void a(String paramString, aewe paramaewe)
  {
    if (paramaewe == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramaewe.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.lebatab.leba", 1, paramString, new Object[0]);
      paramaewe.a();
      return;
    }
    String str1;
    int m;
    if (paramString.equals(a().getString(2131693207)))
    {
      str1 = a().getString(2131693204);
      paramString = a().getString(2131693209);
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
          str2 = bjty.a("check_app_exemption__" + str2 + "_" + paramString);
          boolean bool = localSharedPreferences.getBoolean(str2, false);
          QLog.i("Q.lebatab.leba", 1, "checkEnterApp..checkKey:" + str2 + ",hasCheck:" + bool + "，checkName：" + paramString);
          if (!bool)
          {
            a(new Leba.42(this, str1, localSharedPreferences, str2, paramaewe));
            return;
            if (paramString.equals(a().getString(2131693206)))
            {
              str1 = a().getString(2131693203);
              paramString = a().getString(2131693208);
              m = 1;
              continue;
            }
            if (!paramString.equals(a().getString(2131693205))) {
              break label320;
            }
            str1 = a().getString(2131693202);
            m = 1;
            continue;
          }
        }
      }
      paramaewe.a();
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
    pfs.a().a(3, paramBoolean);
    this.jdField_a_of_type_Blha.postDelayed(new Leba.9(this, paramBoolean, paramRedTypeInfo), 150L);
    LpReportInfo_pf00064.allReport(637, 31, 1);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == nql.jdField_a_of_type_Int;
  }
  
  public boolean a(arsh paramarsh, String paramString, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int m = 0;
    if ((paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 3053L) && (paramString.indexOf("fetchCode=1") > -1))
    {
      long l1 = NetConnInfoCenter.getServerTime();
      if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
        }
        paramIntent.putExtra("url", blhn.a(paramString, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
        a(paramIntent);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        a(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
        paramarsh = (ofe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
        if (paramarsh != null) {
          paramarsh.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
        }
        return false;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      a(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
      this.jdField_a_of_type_Blha.sendEmptyMessageDelayed(1134007, 1000L);
      return false;
    }
    if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 5647L)
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
      if ("com.cmshow.game.android".equals(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))
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
    bcvn localbcvn = (bcvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    boolean bool = paramBoolean;
    if (localbcvn != null) {
      if (localbcvn.a(2) <= 0)
      {
        bool = paramBoolean;
        if (localbcvn.a(1) <= 0) {}
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
    this.jdField_a_of_type_Blha.post(new Leba.2(this));
  }
  
  public bhmr b(arsh paramarsh, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bhmr parambhmr)
  {
    paramarsh = (nlb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramarsh.d();
    if (m > 0) {
      localStringBuffer.append("redid=" + m);
    }
    int n = paramarsh.a();
    if (n > 0) {
      if (localStringBuffer.length() != 0) {
        break label255;
      }
    }
    label255:
    for (paramarsh = "";; paramarsh = "&rpnumber=" + n)
    {
      localStringBuffer.append(paramarsh);
      QLog.i("Leba", 1, "xqbl redid=" + m + ",rpnumber=" + n);
      try
      {
        paramarsh = new JSONObject(paramAppInfo.buffer.get());
        if (paramarsh != null)
        {
          paramarsh = paramarsh.optJSONObject("param");
          if (paramarsh != null)
          {
            paramAppInfo = paramarsh.optJSONObject((String)paramAppInfo.missions.get(0));
            if (paramAppInfo != null)
            {
              paramarsh = paramAppInfo.optString("_red_ext_bid");
              paramAppInfo = paramAppInfo.optString("_red_ext_pid");
              if (!TextUtils.isEmpty(paramarsh)) {
                localStringBuffer.append("&bid=").append(paramarsh);
              }
              if (!TextUtils.isEmpty(paramAppInfo)) {
                localStringBuffer.append("&pid=").append(paramAppInfo);
              }
            }
          }
        }
      }
      catch (Exception paramarsh)
      {
        for (;;)
        {
          QLog.i("Leba", 1, "handerSpecialWhenJumpScheme", paramarsh);
        }
      }
      if (localStringBuffer.length() > 0) {
        parambhmr.e(localStringBuffer.toString());
      }
      return parambhmr;
    }
  }
  
  public void b(View paramView, arsh paramarsh)
  {
    if ((paramarsh == null) || (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    a(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, new aevq(this, paramView, paramarsh));
  }
  
  public void b(arsh paramarsh)
  {
    if (paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) {
      bdmc.a(a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
    }
    if (paramarsh.jdField_a_of_type_Long == 1047L) {
      azlk.a().jdField_a_of_type_Int = 4;
    }
    a(new Leba.44(this));
    if (!paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName.equals("qzone_feedlist")) {
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      C();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_Blha);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayxo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ayxm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayxl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Apce);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoeg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Axuu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asvt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver);
      bduy.a(this.jdField_a_of_type_Bduz);
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
    return this.jdField_f_of_type_Boolean;
  }
  
  public bhmr c(arsh paramarsh, BusinessInfoCheckUpdate.AppInfo paramAppInfo, bhmr parambhmr)
  {
    Object localObject = (nlb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    paramAppInfo = ((nlb)localObject).a();
    paramarsh = paramAppInfo;
    if (paramAppInfo == null)
    {
      paramarsh = paramAppInfo;
      if (((wwh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "check invisible red point for msgtab");
        }
        paramarsh = ((nlb)localObject).a(52);
        if (paramarsh != null) {
          break label223;
        }
        paramarsh = ((nlb)localObject).a(35);
      }
    }
    label223:
    for (;;)
    {
      paramAppInfo = parambhmr;
      if (paramarsh != null)
      {
        paramAppInfo = parambhmr;
        if (paramarsh.uint32_appid.get() == 37) {
          localObject = null;
        }
      }
      try
      {
        paramAppInfo = new JSONObject(paramarsh.str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
        localObject = paramAppInfo;
      }
      catch (Exception paramAppInfo)
      {
        for (;;)
        {
          yuk.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { paramAppInfo.getMessage() });
          continue;
          paramarsh = String.valueOf(paramarsh.uint32_appid.get());
        }
      }
      paramAppInfo = parambhmr;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppInfo = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject);
      }
      if (paramarsh == null)
      {
        paramarsh = "";
        paramAppInfo.a("redid", paramarsh);
        paramAppInfo.a("lebaVersion", "old");
        return paramAppInfo;
      }
    }
  }
  
  public void c()
  {
    super.c();
    x();
    if (this.jdField_a_of_type_Aewm != null) {
      this.jdField_a_of_type_Aewm.d();
    }
    if (this.jdField_b_of_type_Aewm != null) {
      this.jdField_b_of_type_Aewm.d();
    }
  }
  
  void c(View paramView, arsh paramarsh)
  {
    if (paramarsh == null) {
      return;
    }
    paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = aoaw.jdField_a_of_type_JavaLangString;
    String str = bhsi.c(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {
      paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl = str.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("enterXQBL", 2, "跳转url = " + paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGotoUrl);
    }
    b(paramView, paramarsh);
    O();
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
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
      bool2 = this.l;
      if (this.l)
      {
        this.l = false;
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
    ((ViewStub)a(2131378130)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131364886)).setOnFirstDrawListener(this);
    this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
    QzoneConfig.getInstance().addListener(this);
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onResume" + akgr.jdField_a_of_type_Int);
    }
    AbstractGifImage.resumeAll();
    pfs.a().c();
    if (this.j)
    {
      ThreadRegulator.a().b(4);
      this.j = false;
    }
    afja.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Aewm != null) {
      this.jdField_a_of_type_Aewm.c();
    }
    if (this.jdField_b_of_type_Aewm != null) {
      this.jdField_b_of_type_Aewm.c();
    }
    ThreadManager.post(new Leba.4(this), 5, null, false);
    ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    if ((!this.jdField_f_of_type_Boolean) || ((akgr.jdField_a_of_type_Int & 0x4) != 0)) {
      this.jdField_a_of_type_Blha.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.c(true);
      this.jdField_a_of_type_Blha.postDelayed(new Leba.5(this), 100L);
      ThreadManagerV2.excute(new Leba.6(this, (axup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
      N();
      Object localObject;
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setFocusable(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(2131690973));
        localObject = a(2131693470);
        this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131693470));
      }
      if (this.jdField_a_of_type_Akgm != null) {
        this.jdField_a_of_type_Akgm.a();
      }
      if (this.jdField_a_of_type_Awjz != null) {
        this.jdField_a_of_type_Awjz.b(true);
      }
      ApngImage.playByTag(4);
      if ((paramBoolean) && (!this.jdField_i_of_type_Boolean) && (a() != null))
      {
        this.jdField_i_of_type_Boolean = true;
        ThreadManagerV2.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
      }
      return;
      if (akgr.jdField_a_of_type_Int > 0)
      {
        localObject = new ArrayList();
        aoaz.a((List)localObject, akgr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
          if (this.jdField_a_of_type_Akgm != null)
          {
            this.jdField_a_of_type_Akgm.b();
            I();
          }
        }
        akgr.jdField_a_of_type_Int = 0;
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
    this.jdField_a_of_type_Avsm.d();
    this.jdField_b_of_type_Avsm.d();
    axwe.c(0);
    this.jdField_a_of_type_Blha.removeMessages(1134010);
    if (this.jdField_a_of_type_Aewm != null) {
      this.jdField_a_of_type_Aewm.b();
    }
    if (this.jdField_b_of_type_Aewm != null) {
      this.jdField_b_of_type_Aewm.b();
    }
    if (this.jdField_a_of_type_Akgm != null) {
      this.jdField_a_of_type_Akgm.a(b(), f(), c());
    }
    if (this.jdField_a_of_type_Awjz != null) {
      this.jdField_a_of_type_Awjz.c();
    }
    this.jdField_a_of_type_Blha.postDelayed(new Leba.3(this), 500L);
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
    if (this.jdField_a_of_type_Aewm != null) {
      this.jdField_a_of_type_Aewm.d();
    }
    if (this.jdField_b_of_type_Aewm != null) {
      this.jdField_b_of_type_Aewm.d();
    }
    if (this.jdField_a_of_type_Awjz != null) {
      this.jdField_a_of_type_Awjz.d();
    }
    super.i();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onSwitchOutofLeba");
    }
  }
  
  protected void k()
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (!bcnf.a()) {
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
    Object localObject = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    int n;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbav)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        n = 0;
        int m = n;
        if (n == -1)
        {
          localAppInfo = ((bbav)localObject).a("886.100171");
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
          localObject = ((bbav)localObject).a("886.100172");
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
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, n + "", "", "", "");
        }
        if (((nlb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).a()) {
          aysr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "entry", "official_push_exp");
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
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, 4, 2130838779, "-leba-");
    if (ThemeUtil.isNowThemeIsAnimate()) {
      this.jdField_h_of_type_Boolean = true;
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
      case 2131369056: 
      case 2131369073: 
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
        H();
        break;
      case 2131374480: 
        localObject = new QCircleFolderBean();
        ((QCircleFolderBean)localObject).setEnableSplash(true);
        ((QCircleFolderBean)localObject).setLaunchFrom("3");
        ((QCircleFolderBean)localObject).setHasRedDot(this.jdField_b_of_type_Boolean);
        ((QCircleFolderBean)localObject).setUnreadRedNum(this.jdField_c_of_type_Int);
        ((QCircleFolderBean)localObject).setRedDotTransInfo(this.jdField_a_of_type_ArrayOfByte);
        if (this.jdField_b_of_type_Int > 0) {
          ((QCircleFolderBean)localObject).setAssignShowTabType(this.jdField_b_of_type_Int);
        }
        uyx.a(a(), (QCircleFolderBean)localObject);
        R();
        G();
        a(1);
        break;
      case 2131375492: 
        if (QLog.isColorLevel()) {
          QLog.d("HardCoder", 2, "launch qzone");
        }
        jdField_a_of_type_Int = admw.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootQzone");
        localObject = (arsh)akgr.a().jdField_a_of_type_JavaUtilHashMap.get("qzone_feedlist");
        QLog.d("Q.lebatab.leba", 1, "user clicked qzone feed entry.");
        ThreadManager.postImmediately(new Leba.33(this, (arsh)localObject), null, true);
        Q();
        MiniSdkLauncher.preLaunchMiniAppCheckinFromLeba();
      }
    }
  }
  
  public void onConfigChange()
  {
    QLog.d("Leba", 1, "onConfigChange");
    a(new Leba.41(this));
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    b(false);
    if (!this.jdField_f_of_type_Boolean) {
      e(true);
    }
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      return;
      if (this.jdField_h_of_type_Boolean)
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
    } while (this.jdField_a_of_type_Akgm == null);
    this.jdField_a_of_type_Akgm.a(paramAbsListView, paramInt);
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
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-1);
      bdgb.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Blha.sendEmptyMessageDelayed(11340002, 0L);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        if (!bdgb.a()) {
          break label243;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Akgm != null) {
        this.jdField_a_of_type_Akgm.c();
      }
      if (this.jdField_a_of_type_Aewm != null) {
        this.jdField_a_of_type_Aewm.e();
      }
      if (this.jdField_b_of_type_Aewm != null) {
        this.jdField_b_of_type_Aewm.e();
      }
      if (this.jdField_a_of_type_Awjz != null) {
        this.jdField_a_of_type_Awjz.f();
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        TextHook.updateFont(this.jdField_b_of_type_AndroidViewView);
      }
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850099);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166987));
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
      axft localaxft = (axft)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      bcvp.jdField_a_of_type_Boolean = true;
      if (localaxft != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localaxft.a(3);
      }
      vlc.a().a(3, null, null);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.e();
      }
    }
    if (!e()) {
      B();
    }
    a(2);
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)) {}
    ofe localofe;
    do
    {
      return;
      localofe = (ofe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localofe == null);
    localofe.a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
  
  public void y()
  {
    super.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */