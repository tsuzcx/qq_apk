package com.tencent.mobileqq.armap;

import aarv;
import aarz;
import aasa;
import aasb;
import aasc;
import aasf;
import aasg;
import aash;
import aasi;
import aasl;
import aasm;
import aasn;
import aasq;
import aasr;
import aasx;
import aasy;
import aasz;
import aata;
import aatb;
import aatc;
import aatd;
import aatf;
import aatg;
import aath;
import aati;
import aatj;
import aatk;
import aatm;
import aatp;
import aatq;
import aatr;
import aats;
import aatt;
import aatu;
import aatv;
import aatw;
import aaty;
import aatz;
import aaua;
import aaub;
import aauc;
import aaud;
import aaue;
import aaug;
import aauh;
import aauk;
import aaul;
import aaum;
import aaun;
import aauo;
import aauq;
import aaur;
import aaus;
import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nineoldandroids.animation.ValueAnimator;
import com.qq.im.poi.LbsCaiShenActivity;
import com.qq.im.poi.LbsPackConfig;
import com.qq.im.poi.LbsPackInfo;
import com.qq.im.poi.LbsPackListActivity;
import com.qq.im.poi.LbsPackManager;
import com.qq.im.poi.LbsPackMapInfo;
import com.qq.im.poi.LbsPackNameUtil;
import com.qq.im.poi.LbsPackObserver;
import com.qq.im.poi.LbsPackPoiInfo;
import com.qq.im.poi.LbsPackSendActivity;
import com.qq.im.poi.LbsPackShareOption;
import com.qq.im.poi.LbsStrangerPoiDialog;
import com.qq.im.poi.PoiInfo;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfig.WealthGodConfig;
import com.tencent.mobileqq.armap.config.BaseCheckHandler;
import com.tencent.mobileqq.armap.config.ConfigCheckHander;
import com.tencent.mobileqq.armap.config.OpenBoxCheckHander;
import com.tencent.mobileqq.armap.config.OpenBoxCheckHander.OnResCheckResultListener;
import com.tencent.mobileqq.armap.config.POICheckHander;
import com.tencent.mobileqq.armap.config.POICheckHander.Listener;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler.OnResCheckResultListener;
import com.tencent.mobileqq.armap.ipc.ArMapIPC;
import com.tencent.mobileqq.armap.ipc.IPCConstants;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;
import com.tencent.mobileqq.armap.map.ARMapEngine;
import com.tencent.mobileqq.armap.map.ARMapPOIStarDialog;
import com.tencent.mobileqq.armap.map.LbsPackShareDialog;
import com.tencent.mobileqq.armap.map.MapEngineCallback;
import com.tencent.mobileqq.armap.test.MapBorderUtils;
import com.tencent.mobileqq.armap.test.MapTestHelper;
import com.tencent.mobileqq.armap.test.joystick.Joystick;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.armap.utils.SystemUtil;
import com.tencent.mobileqq.armap.wealthgod.ARMapDPC;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity.LoadingTimeStamp;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashBgView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashEntryView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView.ARMapSplashListener;
import com.tencent.mobileqq.armap.wealthgod.SplashBitmapUtils;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ARMapActivity
  extends ARMapBaseActivity
  implements View.OnClickListener, ARMapSplashView.ARMapSplashListener
{
  public static int a;
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  public double a;
  public float a;
  public long a;
  public ProgressDialog a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aata(this);
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
  LbsPackObserver jdField_a_of_type_ComQqImPoiLbsPackObserver = new aarv(this);
  private LbsStrangerPoiDialog jdField_a_of_type_ComQqImPoiLbsStrangerPoiDialog;
  PoiInfo jdField_a_of_type_ComQqImPoiPoiInfo;
  public SosoInterface.OnLocationListener a;
  public ARGLSurfaceView a;
  public ARMapActivity.LocationMonitor a;
  public ARMapTracer a;
  ArMapObserver jdField_a_of_type_ComTencentMobileqqArmapArMapObserver = new aasn(this);
  NetChangedListener jdField_a_of_type_ComTencentMobileqqArmapNetChangedListener = new aasb(this);
  NonMainAppHeadLoader.FaceObserver jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver = new aauo(this);
  public RedPackRainCloudView a;
  private OpenBoxCheckHander.OnResCheckResultListener jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander$OnResCheckResultListener = new aasf(this);
  public OpenBoxCheckHander a;
  private POICheckHander.Listener jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander$Listener = new aasc(this);
  POICheckHander jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander;
  private ShopScanCheckHandler.OnResCheckResultListener jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$OnResCheckResultListener;
  private ShopScanCheckHandler jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler;
  private ARGridMapViewDialog jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog;
  public ARMapEngine a;
  private ARMapPOIStarDialog jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog;
  public MapTestHelper a;
  private ARMapLoadingActivity.LoadingTimeStamp jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp;
  private ARMapSplashEntryView jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashEntryView;
  private ARMapSplashView jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView;
  private WealthGodInfo jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public MapView a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private Runnable jdField_a_of_type_JavaLangRunnable = new aatd(this);
  public String a;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "M032", "M040" };
  public double b;
  private float jdField_b_of_type_Float = 0.0F;
  public int b;
  public long b;
  private Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new aatb(this);
  public Handler b;
  View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  public String b;
  public boolean b;
  private float jdField_c_of_type_Float = 0.0F;
  public int c;
  public long c;
  View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  public ImageView c;
  public String c;
  boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = 0.0F;
  int jdField_d_of_type_Int;
  long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private Button jdField_d_of_type_AndroidWidgetButton;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  public long e;
  private View e;
  public String e;
  public boolean e;
  public int f;
  long f;
  public String f;
  public boolean f;
  public int g;
  private long g;
  public String g;
  public boolean g;
  public int h;
  private long h;
  public String h;
  public boolean h;
  private int jdField_i_of_type_Int = 1;
  private long jdField_i_of_type_Long;
  public String i;
  boolean jdField_i_of_type_Boolean = false;
  private int j;
  public String j;
  public boolean j;
  private int jdField_k_of_type_Int = 0;
  private String jdField_k_of_type_JavaLangString;
  public boolean k;
  private final String jdField_l_of_type_JavaLangString = "/supercell_icon_nor0.png";
  boolean jdField_l_of_type_Boolean;
  private final String m;
  public boolean m;
  private final String jdField_n_of_type_JavaLangString = "/starcard_nor0.png";
  private boolean jdField_n_of_type_Boolean;
  private final String jdField_o_of_type_JavaLangString = "/starcard_pre0.png";
  private boolean jdField_o_of_type_Boolean;
  private final String jdField_p_of_type_JavaLangString = "/supercell_icon_nor.png";
  private boolean jdField_p_of_type_Boolean;
  private final String jdField_q_of_type_JavaLangString = "/supercell_icon_pre.png";
  private boolean jdField_q_of_type_Boolean;
  private final String jdField_r_of_type_JavaLangString = "/starcard_nor.png";
  private boolean jdField_r_of_type_Boolean;
  private final String jdField_s_of_type_JavaLangString = "/starcard_pre.png";
  private boolean jdField_s_of_type_Boolean;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  static
  {
    jdField_a_of_type_Int = 100;
  }
  
  public ARMapActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Long = 5000L;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_e_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new aatk(this, 3, true, true, 0L, false, true, "ARMapActivity");
    this.jdField_m_of_type_JavaLangString = "/supercell_icon_pre0.png";
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.b();
    }
  }
  
  private void B()
  {
    if (this.B) {
      return;
    }
    findViewById(2131369587).setOnClickListener(this);
    this.B = true;
    ((Joystick)findViewById(2131369588)).setJoystickListener(new aatm(this));
  }
  
  private void C()
  {
    if (this.A)
    {
      float f1 = this.jdField_c_of_type_Float - this.jdField_b_of_type_Float;
      double d1 = Math.sin(f1 * 3.141592653589793D / 180.0D);
      double d2 = this.jdField_d_of_type_Float;
      a(Math.cos(f1 * 3.141592653589793D / 180.0D) * this.jdField_d_of_type_Float * 0.0003D, d1 * d2 * 0.0001D);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aatp(this), 100L);
    }
  }
  
  private void D()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new aatt(this), 5000L);
  }
  
  private void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "initViews");
    }
    try
    {
      Object localObject = (ARMapManager)this.app.getManager(209);
      LbsPackManager localLbsPackManager = (LbsPackManager)this.app.getManager(214);
      ((ARMapManager)localObject).a();
      localLbsPackManager.b();
      localObject = ((ARMapManager)localObject).a(true);
      if (localObject != null) {
        BaseCheckHandler.jdField_e_of_type_JavaLangString = ((ARMapConfig)localObject).pccBid;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, String.format("preInit BaseCheckHandler.preCoverDir=%s", new Object[] { BaseCheckHandler.jdField_e_of_type_JavaLangString }));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ARMapActivity", 1, "preInit load config fail!");
      }
    }
    SplashBitmapUtils.a(this.app);
  }
  
  private void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "initViews");
    }
    Object localObject = getIntent();
    boolean bool;
    ARMapConfig localARMapConfig;
    if (localObject != null)
    {
      this.C = ((Intent)localObject).getBooleanExtra("extra_need_completed_response", false);
      ((Intent)localObject).setExtrasClassLoader(WealthGodInfo.class.getClassLoader());
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo = ((WealthGodInfo)((Intent)localObject).getParcelableExtra("extra_wealth_god_info"));
      bool = ((Intent)localObject).getBooleanExtra("extra_in_special_area", false);
      this.jdField_a_of_type_Double = ((Intent)localObject).getDoubleExtra("extra_location_longitude", 0.0D);
      this.jdField_b_of_type_Double = ((Intent)localObject).getDoubleExtra("extra_location_latitude", 0.0D);
      this.jdField_e_of_type_Long = ((Intent)localObject).getLongExtra("extra_location_adcode", -1L);
      this.jdField_j_of_type_Int = ((Intent)localObject).getIntExtra("extra_cur_progress", 0);
      ((Intent)localObject).setExtrasClassLoader(ARMapLoadingActivity.LoadingTimeStamp.class.getClassLoader());
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp = ((ARMapLoadingActivity.LoadingTimeStamp)((Intent)localObject).getParcelableExtra("extra_time_stamp"));
      localARMapConfig = ((ARMapManager)this.app.getManager(209)).a(true);
      if (localARMapConfig != null)
      {
        this.jdField_d_of_type_Int = localARMapConfig.mapLocateFreq;
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extra_lbs_location");
        this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extra_lbs_nick");
        String str = ((Intent)localObject).getStringExtra("extra_lbs_pid");
        this.jdField_i_of_type_JavaLangString = str;
        this.jdField_j_of_type_JavaLangString = str;
        this.jdField_g_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extra_lbs_status");
        this.jdField_h_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extra_lbs_uin");
        this.jdField_e_of_type_Int = ((Intent)localObject).getIntExtra("entrance_type", 0);
        this.jdField_f_of_type_Int = ((Intent)localObject).getIntExtra("entrance_from", 0);
        if (QLog.isColorLevel()) {
          QLog.d("ARMapActivity", 2, "armaploading jump from url mSplashView=" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369573));
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView = ((ARMapSplashView)findViewById(2131369575));
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null) {
        if (this.jdField_e_of_type_Int == 1)
        {
          this.jdField_k_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setLocationText(this.jdField_e_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setNickName(LbsPackNameUtil.a(this.jdField_f_of_type_JavaLangString));
          this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setRedPackDetail(LbsPackNameUtil.a(this.jdField_f_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString));
          this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setWebKey(this.jdField_e_of_type_Int);
          this.app.a.a(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
          localObject = this.app.a.a(this.jdField_h_of_type_JavaLangString, true, null);
          if (localObject == null) {
            break label647;
          }
          this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a((Bitmap)localObject);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setSplashMode(0);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setLoadStatus(1);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setSplashListener(this);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setARMapConfig(localARMapConfig);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setWealthGodInfo(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo, bool);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setProgressMax(100);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setProgress(this.jdField_j_of_type_Int);
        this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a();
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131369577));
        if (this.jdField_b_of_type_AndroidWidgetButton != null) {
          this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369576));
        if (this.mSystemBarComp != null)
        {
          this.mSystemBarComp.setStatusColor(0);
          this.mSystemBarComp.setStatusDrawable(null);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
          {
            int i1 = ImmersiveUtils.a(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, i1, 0, 0);
          }
        }
        getWindow().addFlags(128);
        return;
        this.jdField_d_of_type_Int = -1;
        break;
        label647:
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setCompanyToDefaultIcon();
      }
      bool = false;
      localARMapConfig = null;
    }
  }
  
  private void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "loadARMapViewStub");
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131369574));
    this.jdField_a_of_type_AndroidViewViewStub.inflate();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369579);
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.mSystemBarComp != null))
    {
      int i1 = ImmersiveUtils.a(this);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, i1, 0, 0);
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369592));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369593));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131369594);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369595));
    Object localObject = (LbsPackManager)this.app.getManager(214);
    d(((LbsPackManager)localObject).jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "getLbsPackEntrance " + ((LbsPackManager)localObject).jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView = ((RedPackRainCloudView)findViewById(2131369584));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.setPadding(0, AIOUtils.a(10.0F, getResources()), 0, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.setOnCloudClickListener(this);
    this.jdField_b_of_type_AndroidOsHandler.post(new aatv(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369589));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369590));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369585));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    MapEngineCallback.testServerTime = 1480564800;
    this.app.getApp().getSharedPreferences("envSwitch", 4);
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = (TextView)findViewById(2131369586);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setOnClickListener(new aatw(this));
    }
    this.jdField_a_of_type_JavaLangString = DeviceInfoUtil.a();
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      D();
    }
  }
  
  private void H()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "checkAndLoadTopRightEnter");
    }
    if (this.jdField_c_of_type_AndroidWidgetButton == null)
    {
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131369581));
      this.jdField_d_of_type_AndroidViewView = findViewById(2131369582);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131369580);
    }
    long l2 = 0L;
    long l3 = MessageCache.a() * 1000L;
    int i4 = 0;
    int i1 = 0;
    int i3 = i1;
    int i2 = i4;
    long l1 = l2;
    ARMapManager localARMapManager;
    ARMapConfig localARMapConfig;
    long l4;
    if (this.jdField_c_of_type_AndroidWidgetButton != null)
    {
      i3 = i1;
      i2 = i4;
      l1 = l2;
      if (this.app != null)
      {
        localARMapManager = (ARMapManager)this.app.getManager(209);
        i3 = i1;
        i2 = i4;
        l1 = l2;
        if (localARMapManager != null)
        {
          boolean bool = localARMapManager.a();
          localARMapConfig = localARMapManager.a(false);
          if ((!bool) || (localARMapConfig == null)) {
            break label540;
          }
          l2 = localARMapConfig.mapTopRightEndTime - l3;
          l4 = localARMapManager.a();
          if ((l4 <= 0L) || (l4 >= l3)) {
            break label501;
          }
          l1 = 86400000L - l3 % 86400000L;
          if (l2 <= l1) {
            break label813;
          }
        }
      }
    }
    for (;;)
    {
      i1 = 1;
      i2 = 1;
      i3 = i1;
      label219:
      if (this.jdField_d_of_type_AndroidWidgetButton == null) {
        this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131369583));
      }
      if ((this.jdField_d_of_type_AndroidWidgetButton != null) && (this.app != null))
      {
        localARMapManager = (ARMapManager)this.app.getManager(209);
        if (localARMapManager != null)
        {
          localARMapConfig = localARMapManager.a(false);
          if ((localARMapConfig != null) && (localARMapManager.b())) {
            if (l1 > 0L)
            {
              l1 = Math.min(l1, localARMapConfig.starEntranceEndTime - l3);
              i1 = 1;
            }
          }
        }
      }
      for (;;)
      {
        label319:
        if (this.app != null)
        {
          localARMapManager = (ARMapManager)this.app.getManager(209);
          if (localARMapManager != null) {
            if (this.jdField_d_of_type_AndroidWidgetButton != null)
            {
              if ((i2 == 0) || (i1 == 0)) {
                break label656;
              }
              this.jdField_e_of_type_AndroidViewView.setVisibility(0);
              this.jdField_c_of_type_AndroidWidgetButton.setBackgroundDrawable(localARMapManager.a(this, "/supercell_icon_nor0.png", "/supercell_icon_pre0.png"));
              this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
              if (i3 == 0) {
                break label644;
              }
              this.jdField_d_of_type_AndroidViewView.setVisibility(0);
              this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
              this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(localARMapManager.a(this, "/starcard_nor0.png", "/starcard_pre0.png"));
              this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
            }
          }
        }
        for (;;)
        {
          label406:
          if ((l1 > 0L) && (l1 < 43200000L))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ARMapActivity", 2, "checkAndLoadTopRightEnter delay:" + l1);
            }
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, l1);
          }
          return;
          label501:
          l1 = l2;
          if (l4 > l3)
          {
            l1 = l2;
            if (l2 > l4 - l3) {
              l1 = l4 - l3;
            }
          }
          i1 = 0;
          break;
          label540:
          i3 = i1;
          i2 = i4;
          l1 = l2;
          if (localARMapConfig == null) {
            break label219;
          }
          l1 = localARMapConfig.mapTopRightBeginTime - l3;
          i2 = 0;
          i3 = i1;
          break label219;
          l1 = localARMapConfig.starEntranceEndTime - l3;
          i1 = 1;
          break label319;
          if (localARMapConfig == null) {
            break label808;
          }
          if (localARMapConfig.starEntranceStartTime <= l3) {
            break label803;
          }
          if (l1 > 0L)
          {
            l1 = Math.min(l1, localARMapConfig.starEntranceStartTime - l3);
            i1 = 0;
            break label319;
          }
          l1 = localARMapConfig.starEntranceStartTime - l3;
          i1 = 0;
          break label319;
          label644:
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          break label406;
          label656:
          if ((i2 != 0) || (i1 != 0))
          {
            if (i2 != 0)
            {
              this.jdField_e_of_type_AndroidViewView.setVisibility(0);
              this.jdField_c_of_type_AndroidWidgetButton.setBackgroundDrawable(localARMapManager.a(this, "/supercell_icon_nor.png", "/supercell_icon_pre.png"));
              this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
              if (i3 != 0) {
                this.jdField_d_of_type_AndroidViewView.setVisibility(0);
              }
              for (;;)
              {
                this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
                break;
                this.jdField_d_of_type_AndroidViewView.setVisibility(8);
              }
            }
            this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
            this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(localARMapManager.a(this, "/starcard_nor.png", "/starcard_pre.png"));
            this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          }
          else
          {
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
          }
        }
        label803:
        i1 = 0;
        continue;
        label808:
        i1 = 0;
      }
      label813:
      l1 = l2;
    }
  }
  
  private void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "topRightEnterClick");
    }
    Object localObject = (ARMapManager)this.app.getManager(209);
    if (localObject != null)
    {
      if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0))
      {
        ((ARMapManager)localObject).b();
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
      localObject = ((ARMapManager)localObject).a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("uin", this.app.getCurrentAccountUin());
        localIntent.putExtra("portraitOnly", true);
        startActivity(localIntent);
        ReportController.b(null, "dc01440", "", "", "0X80079C6", "0X80079C6", 0, 0, "", "", String.valueOf(this.jdField_e_of_type_Long), "");
      }
    }
  }
  
  private void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "topRightStarEnterClick");
    }
    Object localObject = (ARMapManager)this.app.getManager(209);
    if (localObject != null)
    {
      localObject = ((ARMapManager)localObject).b();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        startActivity(localIntent);
        ReportController.b(null, "dc01440", "", "", "0X8007A04", "0X8007A04", 0, 0, "", "", String.valueOf(this.jdField_e_of_type_Long), "");
      }
    }
  }
  
  private void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "sendStartCompletedResponse");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.armap.ACTION_START_ARMAP_COMPLETED");
    sendBroadcast(localIntent);
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashEntryView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashEntryView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashEntryView.a(new aauc(this));
    }
    t();
  }
  
  private void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "endProgressAnim");
    }
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_j_of_type_Int, 100 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(1000L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new aaud(this));
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(new aaue(this));
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
    }
  }
  
  private void N()
  {
    this.jdField_i_of_type_Long = System.currentTimeMillis();
  }
  
  private void O()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashEntryView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashEntryView = new ARMapSplashEntryView(this, null);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashEntryView, -1, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashEntryView.setVisibility(8);
    }
    M();
  }
  
  private void P()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, String.format("startLocation mHasEnteredMap=%s", new Object[] { Boolean.valueOf(this.D) }));
    }
    if ((this.D) && (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null))
    {
      SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      if (this.y)
      {
        this.jdField_q_of_type_Boolean = false;
        this.y = false;
        r();
      }
    }
  }
  
  private void Q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, String.format("stopLocation mHasEnteredMap=%s", new Object[] { Boolean.valueOf(this.D) }));
    }
    if ((this.D) && (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null))
    {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      if ((this.jdField_q_of_type_Boolean) || (this.jdField_b_of_type_AndroidOsHandler.hasMessages(100)))
      {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
        this.y = true;
        this.jdField_q_of_type_Boolean = false;
      }
    }
  }
  
  private void R()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, String.format("startSensor mHasEnteredMap=%s", new Object[] { Boolean.valueOf(this.D) }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) && (!this.jdField_n_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.resumeSensor(2);
    }
  }
  
  private void S()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, String.format("stopSensor mHasEnteredMap=%s", new Object[] { Boolean.valueOf(this.D) }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) && (!this.jdField_n_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.stopSensor();
    }
  }
  
  private void T()
  {
    Object localObject = ArMapUtil.a(this.app);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapActivity", 2, String.format("saveLastLocation mCurrentLongitude=%s mCurrentLatitude=%s", new Object[] { Double.valueOf(this.jdField_a_of_type_Double), Double.valueOf(this.jdField_b_of_type_Double) }));
        }
        ((SharedPreferences.Editor)localObject).putString("armap_last_lon", Double.toString(this.jdField_a_of_type_Double));
        ((SharedPreferences.Editor)localObject).putString("armap_last_lat", Double.toString(this.jdField_b_of_type_Double));
        ((SharedPreferences.Editor)localObject).putString("armap_last_adcode", Double.toString(this.jdField_e_of_type_Long));
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  private void U()
  {
    Object localObject2;
    Object localObject1;
    String str;
    if ((this.jdField_a_of_type_Double == 0.0D) && (this.jdField_b_of_type_Double == 0.0D))
    {
      localObject2 = ArMapUtil.a(this.app);
      if (localObject2 != null)
      {
        localObject1 = ((SharedPreferences)localObject2).getString("armap_last_lon", "");
        str = ((SharedPreferences)localObject2).getString("armap_last_lat", "");
        localObject2 = ((SharedPreferences)localObject2).getString("armap_last_adcode", "0");
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str))) {}
      }
    }
    try
    {
      this.jdField_a_of_type_Double = Double.valueOf((String)localObject1).doubleValue();
      this.jdField_b_of_type_Double = Double.valueOf(str).doubleValue();
      if (this.jdField_e_of_type_Long == -1L) {
        this.jdField_e_of_type_Long = Long.valueOf((String)localObject2).longValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, String.format("restoreLastLocation mCurrentLongitude=%s mCurrentLatitude=%s", new Object[] { Double.valueOf(this.jdField_a_of_type_Double), Double.valueOf(this.jdField_b_of_type_Double) }));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine;
        ARMapEngine.setDefaultLocation(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Double = 0.0D;
        this.jdField_b_of_type_Double = 0.0D;
      }
    }
  }
  
  private void V()
  {
    if ((this.jdField_e_of_type_Long > 0L) && (this.jdField_a_of_type_Double > 0.0D) && (this.jdField_b_of_type_Double > 0.0D) && (this.jdField_m_of_type_Boolean))
    {
      WealthGodInfo localWealthGodInfo = a();
      if (localWealthGodInfo != null) {
        localWealthGodInfo.jdField_a_of_type_Boolean = this.jdField_r_of_type_Boolean;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, String.format("ACTION_SYNC_ARMAP_INFO adCode=%s longitude=%s latitude=%s wealthGodInfo=%s", new Object[] { Long.valueOf(this.jdField_e_of_type_Long), Double.valueOf(this.jdField_a_of_type_Double), Double.valueOf(this.jdField_b_of_type_Double), localWealthGodInfo }));
      }
      Bundle localBundle = new Bundle();
      localBundle.putLong(IPCConstants.jdField_i_of_type_JavaLangString, this.jdField_e_of_type_Long);
      localBundle.putDouble(IPCConstants.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Double);
      localBundle.putDouble(IPCConstants.jdField_k_of_type_JavaLangString, this.jdField_b_of_type_Double);
      localBundle.putParcelable(IPCConstants.jdField_l_of_type_JavaLangString, localWealthGodInfo);
      localBundle.setClassLoader(WealthGodInfo.class.getClassLoader());
      ArMapIPC.a().a(IPCConstants.jdField_g_of_type_JavaLangString, localBundle);
    }
  }
  
  private void W()
  {
    String str = "";
    long l1;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Long;
      str = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString;
      i1 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Int;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, String.format("reportLoadSuccess mUIState=%s adCode=%s companyName=%s", new Object[] { Integer.valueOf(this.jdField_k_of_type_Int), Long.valueOf(l1), str }));
      }
      if (this.jdField_k_of_type_Int == 4) {
        if (i1 == 0) {
          ReportController.b(null, "dc01440", "", "", "0X800794D", "0X800794D", 0, 0, "5", "", String.valueOf(l1), str);
        }
      }
      do
      {
        return;
        ReportController.b(null, "dc01440", "", "", "0X800794D", "0X800794D", 0, 0, "4", "", String.valueOf(l1), str);
        return;
        if (this.jdField_k_of_type_Int == 5)
        {
          ReportController.b(null, "dc01440", "", "", "0X80079C5", "0X80079C5", 0, 0, "5", "", String.valueOf(l1), str);
          return;
        }
        if (this.jdField_k_of_type_Int == 6)
        {
          ReportController.b(null, "dc01440", "", "", "0X800794E", "0X800794E", 0, 0, "1", "", String.valueOf(l1), str);
          return;
        }
      } while (this.jdField_k_of_type_Int != 7);
      ReportController.b(null, "dc01440", "", "", "0X800794B", "0X800794B", 0, 0, "1", "", String.valueOf(l1), str);
      return;
      i1 = 0;
      l1 = 0L;
    }
  }
  
  private void X()
  {
    String str = "";
    long l1;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Long;
      str = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString;
      i1 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Int;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, String.format("reportRefreshSuccess mUIState=%s adCode=%s companyName=%s", new Object[] { Integer.valueOf(this.jdField_k_of_type_Int), Long.valueOf(l1), str }));
      }
      if (this.jdField_k_of_type_Int == 4) {
        if (i1 == 0) {
          ReportController.b(null, "dc01440", "", "", "0X800794D", "0X800794D", 0, 0, "7", "", String.valueOf(l1), str);
        }
      }
      do
      {
        return;
        ReportController.b(null, "dc01440", "", "", "0X800794D", "0X800794D", 0, 0, "6", "", String.valueOf(l1), str);
        return;
        if (this.jdField_k_of_type_Int == 5)
        {
          ReportController.b(null, "dc01440", "", "", "0X80079C5", "0X80079C5", 0, 0, "7", "", String.valueOf(l1), str);
          return;
        }
        if (this.jdField_k_of_type_Int == 6)
        {
          ReportController.b(null, "dc01440", "", "", "0X800794E", "0X800794E", 0, 0, "6", "", String.valueOf(l1), str);
          return;
        }
      } while (this.jdField_k_of_type_Int != 7);
      ReportController.b(null, "dc01440", "", "", "0X800794B", "0X800794B", 0, 0, "6", "", String.valueOf(l1), str);
      return;
      i1 = 0;
      l1 = 0L;
    }
  }
  
  private void Y()
  {
    String str = "";
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Long;
      str = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, String.format("reportLoadCancel mUIState=%s adCode=%s companyName=%s", new Object[] { Integer.valueOf(this.jdField_k_of_type_Int), Long.valueOf(l1), str }));
      }
      if (this.jdField_k_of_type_Int == 4) {
        ReportController.b(null, "dc01440", "", "", "0X800794D", "0X800794D", 0, 0, "3", "", String.valueOf(l1), str);
      }
      do
      {
        return;
        if (this.jdField_k_of_type_Int == 5)
        {
          ReportController.b(null, "dc01440", "", "", "0X80079C5", "0X80079C5", 0, 0, "3", "", String.valueOf(l1), str);
          return;
        }
        if (this.jdField_k_of_type_Int == 6)
        {
          ReportController.b(null, "dc01440", "", "", "0X800794E", "0X800794E", 0, 0, "3", "", String.valueOf(l1), str);
          return;
        }
      } while (this.jdField_k_of_type_Int != 7);
      ReportController.b(null, "dc01440", "", "", "0X800794B", "0X800794B", 0, 0, "3", "", String.valueOf(l1), str);
      return;
      l1 = 0L;
    }
  }
  
  private void Z()
  {
    String str;
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null)
    {
      str = "";
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo == null) {
        break label168;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Long;
      str = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a() == 6) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapActivity", 2, String.format("reportEntryBtnClick active=%s adCode=%s companyName=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), str }));
        }
        if (!bool) {
          break;
        }
        ReportController.b(null, "dc01440", "", "", "0X80079C3", "0X80079C3", 0, 0, "", "", String.valueOf(l1), str);
        return;
      }
      ReportController.b(null, "dc01440", "", "", "0X80079C4", "0X80079C4", 0, 0, "", "", String.valueOf(l1), str);
      return;
      label168:
      l1 = 0L;
    }
  }
  
  private MapView a()
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView == null)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView = new MapView(this, true);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getUiSettings().setLogoPosition(0);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getUiSettings().setScaleControlsEnabled(false);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getUiSettings().setScrollGesturesEnabled(false);
      TencentMap localTencentMap = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getMap();
      localTencentMap.setMinZoomLevel(15);
      localTencentMap.setMaxZoomLevel(17);
      localTencentMap.setOnMapCameraChangeListener(new aasx(this));
      localTencentMap.setOnMapLoadedListener(new aasy(this));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.setEnabled(true);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.setClickable(true);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.onCreate(null);
    }
    return this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView;
  }
  
  private String a(WealthGodInfo paramWealthGodInfo, boolean paramBoolean)
  {
    if ((paramWealthGodInfo != null) && (!TextUtils.isEmpty(paramWealthGodInfo.jdField_b_of_type_JavaLangString)) && (paramWealthGodInfo.jdField_b_of_type_JavaLangString.length() <= 3)) {
      return paramWealthGodInfo.jdField_b_of_type_JavaLangString;
    }
    return "本区域";
  }
  
  private void a(int paramInt, String paramString)
  {
    if ((this.u) || (!this.t)) {
      return;
    }
    this.u = true;
    String str1 = "" + paramInt;
    String str2 = "" + paramString;
    if (this.jdField_f_of_type_Int == 0) {}
    for (paramString = "1";; paramString = "5")
    {
      ReportController.b(null, "dc01440", "", "", "0X8007839", "0X8007839", 0, 0, str1, "", str2, paramString);
      return;
    }
  }
  
  private void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, String.format("loadMapView configList=%s", new Object[] { paramList }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.o = System.currentTimeMillis();
    }
    G();
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView = ((ARGLSurfaceView)findViewById(2131369578));
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.setLowFPSRate(true, 200L, false);
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.getHolder().setFormat(-3);
    this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine = new ARMapEngine(this, this.app, this.jdField_a_of_type_AndroidOsHandler, paramList);
    U();
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.setSurfaceStateListener(this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine);
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.init(this, ARResUtil.a(), 0);
    this.jdField_n_of_type_Boolean = SplashBitmapUtils.a().jdField_c_of_type_Boolean;
    if (!this.jdField_n_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.initSensor(null, 1);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver, true);
    this.app.registObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqArmapNetChangedListener);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARMapActivity", 2, "onOpenRedPacketHandle openSuccess:" + paramBoolean2 + " refreshPOI:" + paramBoolean1 + " hasOpen:" + paramBoolean3);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null) && (paramBoolean2))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_b_of_type_Long < this.jdField_c_of_type_Long)
      {
        WealthGodInfo localWealthGodInfo = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo;
        localWealthGodInfo.jdField_b_of_type_Long -= 1L;
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_b_of_type_Long > 0L) || (this.jdField_r_of_type_Boolean)) {
        break label200;
      }
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
      }
      this.jdField_s_of_type_Boolean = true;
      this.jdField_q_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.setVisibility(8);
        this.w = false;
        A();
      }
    }
    label200:
    while ((!paramBoolean2) || (this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView == null) || (this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.getVisibility() != 0) || (this.jdField_i_of_type_Int != 4))
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_b_of_type_Long = (this.jdField_c_of_type_Long - 1L);
      break;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo);
  }
  
  private boolean a(long paramLong)
  {
    return (paramLong >= 0L) && (paramLong <= 60000L);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "checkAndHandleCurfew  mIsInCurfew:" + this.H + " firtCheck:" + paramBoolean + " isFinishing: " + isFinishing());
    }
    if (isFinishing()) {
      return false;
    }
    Object localObject1 = (ARMapManager)this.app.getManager(209);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((ARMapManager)localObject1).a(false);
      if (localObject1 != null)
      {
        localObject2 = ArMapUtil.a((ARMapConfig)localObject1);
        if (((ArMapUtil.CurfewResInfo)localObject2).jdField_a_of_type_Long > 0L) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, ((ArMapUtil.CurfewResInfo)localObject2).jdField_a_of_type_Long + 100L);
        }
        paramBoolean = ((ArMapUtil.CurfewResInfo)localObject2).jdField_a_of_type_Boolean;
        if ((((ARMapConfig)localObject1).wealthGodConfig != null) && (!TextUtils.isEmpty(((ARMapConfig)localObject1).wealthGodConfig.curfewWarning)))
        {
          localObject1 = ((ARMapConfig)localObject1).wealthGodConfig.curfewWarning;
          if (QLog.isColorLevel()) {
            QLog.d("ARMapActivity", 2, "checkAndHandleCurfew timeHtmlStr:" + (String)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.H != paramBoolean)
      {
        if ((this.H) || (!paramBoolean)) {
          break label465;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle("早点休息");
          localObject2 = new TextView(this);
          ((TextView)localObject2).setGravity(17);
          ((TextView)localObject2).setText(Html.fromHtml((String)localObject1));
          ((TextView)localObject2).setMaxLines(2);
          ((TextView)localObject2).setLineSpacing(AIOUtils.a(5.0F, getResources()), 1.0F);
          ((TextView)localObject2).setTextColor(getResources().getColor(2131492879));
          ((TextView)localObject2).setTextSize(2, 16.0F);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.addView((View)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131432400, new aaua(this));
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new aaub(this));
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          ReportController.b(null, "dc01440", "", "", "0X80079C9", "0X80079C9", 0, 0, "", "", "" + this.jdField_e_of_type_Long, "");
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapActivity", 2, "checkAndHandleCurfew inCurfew:" + paramBoolean);
        }
        this.H = paramBoolean;
        if (paramBoolean) {
          break;
        }
        return true;
        label465:
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
        {
          this.H = false;
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
        }
        this.t = true;
      }
      return false;
      localObject1 = "<![CDATA[<font color=#165777>活动将于明早07：00开放，</font><br><font color=#165777>明天再来参加吧！</font>]]>";
      continue;
      localObject1 = "<![CDATA[<font color=#165777>活动将于明早07：00开放，</font><br><font color=#165777>明天再来参加吧！</font>]]>";
      paramBoolean = false;
    }
  }
  
  private void aa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, String.format("reportLoadTime mUIState=%s mIsMapLoadFinished=%s mLoadCompleted=%s", new Object[] { Integer.valueOf(this.jdField_k_of_type_Int), Boolean.valueOf(this.jdField_f_of_type_Boolean), Boolean.valueOf(this.F) }));
    }
    long l1;
    long l2;
    label127:
    long l3;
    label162:
    long l4;
    label197:
    long l5;
    label232:
    long l6;
    label267:
    long l7;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_b_of_type_Long <= this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_a_of_type_Long) {
        break label453;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_b_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_d_of_type_Long <= this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_c_of_type_Long) {
        break label458;
      }
      l2 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_d_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_c_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_f_of_type_Long <= this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_e_of_type_Long) {
        break label463;
      }
      l3 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_f_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_e_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_h_of_type_Long <= this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_g_of_type_Long) {
        break label469;
      }
      l4 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_h_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_g_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.j <= this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_i_of_type_Long) {
        break label475;
      }
      l5 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.j - this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_i_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.l <= this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.k) {
        break label481;
      }
      l6 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.l - this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.k;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.n <= this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.m) {
        break label487;
      }
      l7 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.n - this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.m;
      label302:
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.p <= this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.o) {
        break label493;
      }
    }
    label453:
    label458:
    label463:
    label469:
    label475:
    label481:
    label487:
    label493:
    for (long l8 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.p - this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.o;; l8 = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, String.format("reportLoadTime loadingTime=%sms locationTime=%sms requestInfoTime=%sms resCheckTime=%sms soCheckTime=%sms startThreadTime=%sms launchARMapTime=%sms loadMapTime=%sms", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8) }));
      }
      ThreadManager.post(new aaug(this, l1, l2, l3, l4, l5, l6, l7, l8), 5, null, false);
      return;
      l1 = 0L;
      break;
      l2 = 0L;
      break label127;
      l3 = 0L;
      break label162;
      l4 = 0L;
      break label197;
      l5 = 0L;
      break label232;
      l6 = 0L;
      break label267;
      l7 = 0L;
      break label302;
    }
  }
  
  private void ab()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ARMapActivity", 2, "Novice guide pic has not been downloaded!    because mMapEngin is null");
      }
      v();
    }
    Object localObject;
    do
    {
      return;
      localObject = Drawable.createFromPath(this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine.mMapEngineCallback.getConfigCommonImgPath("armap_guide.png"));
      if (localObject == null) {
        break;
      }
      this.jdField_c_of_type_AndroidViewView = getLayoutInflater().inflate(2130970202, null);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131369600));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.bringToFront();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369598)).setBackgroundDrawable((Drawable)localObject);
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131369597);
    } while (c());
    int i1 = AIOUtils.a(400.0F, getResources());
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, (i1 + (getResources().getDisplayMetrics().heightPixels - i1) / 2) * -1, 0, 0.0F);
    localTranslateAnimation.setDuration(500L);
    ((View)localObject).startAnimation(localTranslateAnimation);
    return;
    if (QLog.isColorLevel()) {
      QLog.e("ARMapActivity", 2, "Novice guide pic has not been downloaded!");
    }
    v();
  }
  
  private void ac()
  {
    int i1;
    if (this.jdField_g_of_type_Int > 0)
    {
      i1 = this.jdField_g_of_type_Int;
      if ((i1 >= 2) && (i1 <= 100) && (i1 * 1000 != SosoInterface.jdField_a_of_type_Int)) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      i1 = this.jdField_h_of_type_Int;
      break;
      QLog.i("ARMapActivity", 1, "changeContinueLocationInterval. interval is: " + this.jdField_h_of_type_Int * 1000 + " lbsinterval:" + this.jdField_g_of_type_Int * 1000 + " current interval is: " + SosoInterface.jdField_a_of_type_Int + " isResume: " + isResume() + " hasEnteredMap: " + this.D);
    } while ((!this.D) || (this.jdField_a_of_type_Boolean));
    runOnUiThread(new aaun(this, i1));
  }
  
  private void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, String.format("sendStartCompletedResponseDelay delay=%s", new Object[] { Long.valueOf(paramLong) }));
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aatz(this), paramLong);
    }
  }
  
  private void b(WealthGodInfo paramWealthGodInfo)
  {
    if ((paramWealthGodInfo == null) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new aatc(this, paramWealthGodInfo));
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog.isShowing())) {}
    while (((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) || ((this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.isShowing())) || ((this.jdField_a_of_type_ComQqImPoiLbsStrangerPoiDialog != null) && (this.jdField_a_of_type_ComQqImPoiLbsStrangerPoiDialog.isShowing()))) {
      return true;
    }
    return false;
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int i2;
    int i1;
    if (str != null)
    {
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      i2 = arrayOfString.length;
      i1 = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < i2)
      {
        if (TextUtils.equals(str, arrayOfString[i1])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "checkAndStartQueryRedPacket() mAdcode:" + this.jdField_e_of_type_Long + "  mReqRedPacketCountRunning:" + this.jdField_q_of_type_Boolean + "  mHasGetPoiList:" + this.jdField_p_of_type_Boolean + "  mReqRedPacketCountStoped:" + this.jdField_s_of_type_Boolean);
    }
    if ((this.jdField_e_of_type_Long > 0L) && (!this.jdField_q_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) && (this.jdField_p_of_type_Boolean) && (!this.jdField_s_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, "checkAndStartQueryRedPacket() enter delay query");
      }
      this.jdField_q_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 200L);
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, String.format("loadMapView mHasLoadMap=%s", new Object[] { Boolean.valueOf(this.E) }));
    }
    List localList = ConfigCheckHander.a(((ARMapManager)this.app.getManager(209)).a(true));
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, localList).sendToTarget();
    this.E = true;
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      double d1 = getIntent().getDoubleExtra("default_lon", 0.0D);
      double d2 = getIntent().getDoubleExtra("default_lat", 0.0D);
      long l1 = getIntent().getLongExtra("adcode", 0L);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, "jump location ,lon = " + d1 + ",lat = " + d2 + "  adcode = " + l1);
      }
      this.jdField_b_of_type_Double = d2;
      this.jdField_a_of_type_Double = d1;
      this.jdField_e_of_type_Long = l1;
      if ((this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine.mGameplayHandler != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aasg(this));
      }
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131438773);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131438774);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131438775);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131432998);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new aasm(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new aasq(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_o_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "alreadyDisplayMap");
    }
    if (a(true))
    {
      a();
      this.t = true;
    }
    a(true);
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null) {
      ReportController.b(null, "dc01440", "", "", "0X8007847", "0X8007847", 0, 0, "", "", "" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Long, "" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString);
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null) {
      ReportController.b(null, "dc01440", "", "", "0X8007848", "0X8007848", 0, 0, "", "", "" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Long, "" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString);
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ARMapActivity", 2, localException, new Object[] { "hide progress" });
    }
  }
  
  private void z()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("checkAndStartCloudAnim needTopCloudAnim:").append(this.w).append(" canTopCloudAnim:").append(this.x).append("  mIsResume:").append(this.mIsResume).append(" isPlaying:");
      if ((this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView == null) || (!this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.jdField_a_of_type_Boolean)) {
        break label138;
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ARMapActivity", 2, bool);
      if ((this.w) && (this.x) && (this.mIsResume) && (this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView != null) && (!this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.a();
      }
      return;
    }
  }
  
  public int a(String paramString)
  {
    ARMapDPC localARMapDPC = SplashBitmapUtils.a();
    int i1 = 0;
    if ("MaxPOIReachableCount".equals(paramString)) {
      if (localARMapDPC == null) {
        i1 = 100;
      }
    }
    while (!"MaxPOIExposionCacheCount".equals(paramString))
    {
      return i1;
      return localARMapDPC.jdField_c_of_type_Int;
    }
    if (localARMapDPC == null) {
      return 1500;
    }
    return localARMapDPC.jdField_d_of_type_Int;
  }
  
  public WealthGodInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo;
  }
  
  void a()
  {
    if (isFinishing()) {}
    boolean bool2;
    do
    {
      return;
      boolean bool1 = ArMapUtil.a(this);
      bool2 = ArMapUtil.b(this);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, "checkWifiGPSSwitcher ,isWifiOn = " + bool1 + ",isGPSOn = " + bool2);
      }
      if ((!bool1) && (!bool2))
      {
        e();
        return;
      }
      if (!bool1) {
        c();
      }
    } while (bool2);
    d();
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    this.jdField_a_of_type_Double += paramDouble1;
    this.jdField_b_of_type_Double += paramDouble2;
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aatq(this));
  }
  
  public void a(double paramDouble1, double paramDouble2, float paramFloat, String paramString)
  {
    boolean bool = ArMapUtil.b(this);
    int i1 = NetworkUtil.a(BaseApplication.getContext());
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "reportWrongLocation  dlongitude = " + paramDouble1 + ",dlatitude = " + paramDouble2 + ",accuracy = " + paramFloat + ",gpsON = " + bool + ",nettype = " + i1 + ",mIMEI = " + this.jdField_a_of_type_JavaLangString + ",source = " + paramString);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_nettype", com.tencent.mobileqq.app.AppConstants.c[i1]);
    localHashMap.put("param_dlongitude", String.valueOf(paramDouble1));
    localHashMap.put("param_dlatitude", String.valueOf(paramDouble2));
    localHashMap.put("param_accuracy", String.valueOf(paramFloat));
    if (bool) {}
    for (bool = true;; bool = false)
    {
      localHashMap.put("param_gps_status", String.valueOf(bool));
      localHashMap.put("param_report_time", String.valueOf(l1));
      localHashMap.put("param_device_id", this.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_source", paramString);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actArmapBadLocation", false, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (SystemClock.elapsedRealtime() - this.jdField_f_of_type_Long < 300000L) {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, "showExceptionalLocationToast interval less than 60s");
      }
    }
    do
    {
      return;
      QQToast.a(this, "定位信号暂时异常，稍后再来试试吧。", 1).a();
      this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
      ReportController.b(null, "dc01440", "", "", "0X8007856", "0X8007856", 0, 0, "", "", "" + this.jdField_e_of_type_Long, "");
    } while (!QLog.isColorLevel());
    QLog.d("ARMapActivity", 2, "showExceptionalLocationToast sosoErrorCode=" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, int paramInt5, String paramString1, String paramString2, double paramDouble1, double paramDouble2, String paramString3, Object paramObject)
  {
    if ((System.currentTimeMillis() - this.jdField_h_of_type_Long < 500L) || (b()))
    {
      QLog.d("ARMapActivity", 1, "poi click too quick");
      return;
    }
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    paramString1 = new aasr(this, paramInt3, paramInt4, paramLong1, paramLong2, paramInt5, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramDouble2, paramDouble1, paramObject);
    this.jdField_a_of_type_AndroidOsHandler.postAtFrontOfQueue(paramString1);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, String.format("onCountBackwardsUpdate curCount=%s", new Object[] { Long.valueOf(paramLong) }));
    }
    if ((!this.E) && (paramLong <= 3L)) {
      s();
    }
    if ((paramLong == 0L) && (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null))
    {
      this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a();
      X();
    }
  }
  
  public void a(WealthGodInfo paramWealthGodInfo)
  {
    if (paramWealthGodInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ARMapActivity", 2, "updateLeftTime nextWealthGodInfo = " + paramWealthGodInfo);
    }
    runOnUiThread(new aatf(this, paramWealthGodInfo));
  }
  
  public void a(String paramString1, int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("ARMapActivity", 2, "handlePoiClicked configs: " + paramString1);
      QLog.i("ARMapActivity", 2, "handlePoiClicked taskType: " + paramInt1 + ", taskId: " + paramLong1 + ", poiId: " + paramLong2 + ", distance: " + paramInt2 + ", businessName: " + paramString2 + ", possible: " + paramBoolean + ", resPath: " + paramString3);
    }
    if (!NetworkUtil.d(this)) {
      QQToast.a(getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(getTitleBarHeight());
    }
    String str2;
    String str1;
    Object localObject1;
    int i2;
    int i1;
    label617:
    do
    {
      do
      {
        return;
        localObject3 = "";
        String str3 = "";
        String str4 = "";
        str2 = str4;
        str1 = str3;
        localObject1 = localObject3;
        try
        {
          String str5 = new JSONObject(paramString1).getString("farPoi");
          str2 = str4;
          str1 = str3;
          localObject1 = localObject3;
          if (TextUtils.isEmpty(str5))
          {
            str2 = str4;
            str1 = str3;
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              str2 = str4;
              str1 = str3;
              localObject1 = localObject3;
              QLog.i("ARMapActivity", 2, "handlePoiClicked poi logo url is empty!");
            }
          }
          localObject2 = null;
          paramString1 = null;
          str2 = str4;
          str1 = str3;
          localObject1 = localObject3;
          String[] arrayOfString = str5.split("\\?md5=");
          str2 = str4;
          str1 = str3;
          localObject1 = localObject3;
          if (arrayOfString.length > 1)
          {
            localObject2 = arrayOfString[0];
            paramString1 = arrayOfString[1];
          }
          str2 = str4;
          str1 = str3;
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            str2 = str4;
            str1 = str3;
            localObject1 = localObject3;
            QLog.i("ARMapActivity", 2, "handlePoiClicked logoUrl: " + str5 + ", url: " + (String)localObject2 + ", md5: " + paramString1);
          }
          str2 = str4;
          str1 = str3;
          localObject1 = localObject3;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            str2 = str4;
            str1 = str3;
            localObject1 = localObject3;
            if (!TextUtils.isEmpty(paramString1)) {}
          }
          else
          {
            str2 = str4;
            str1 = str3;
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              str2 = str4;
              str1 = str3;
              localObject1 = localObject3;
              QLog.d("ARMapActivity", 2, "handlePoiClicked url or md5 is empty");
            }
          }
          str2 = str4;
          str1 = str3;
          localObject1 = localObject3;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander.a((String)localObject2, paramString1, paramInt1);
          str2 = str4;
          str1 = str3;
          localObject1 = localObject3;
          str3 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander.a((String)localObject2, paramString1);
          str2 = str4;
          str1 = str3;
          localObject1 = localObject3;
          str4 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander.b((String)localObject2, paramString1);
          str2 = str4;
          str1 = str3;
          localObject1 = localObject3;
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander.c((String)localObject2, paramString1);
          localObject1 = paramString1;
          str1 = str4;
          str2 = str3;
          localObject2 = localObject3;
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("ARMapActivity", 2, "handlePoiClicked", paramString1);
            }
            localObject3 = "";
            paramString1 = str1;
            Object localObject2 = localObject1;
            localObject1 = localObject3;
            str1 = str2;
            str2 = paramString1;
            continue;
            if (paramInt1 == 5)
            {
              paramString1 = new Intent(this, SupercellActivity.class);
              i2 = 103;
            }
            else
            {
              if (paramInt1 != 4) {
                break;
              }
              paramString1 = new Intent(this, OpenBoxActivity.class);
              i2 = 101;
            }
          }
        }
        paramString1 = null;
        i2 = -1;
        i1 = 0;
        if ((paramInt1 != 4) && (paramInt1 != 6) && (paramInt1 != 7)) {
          break label840;
        }
        paramString1 = new Intent(this, CaiShenActivity.class);
        i2 = 102;
        if (paramString1 == null) {
          break label1219;
        }
        paramString1.putExtra("task_type", paramInt1);
        paramString1.putExtra("task_id", paramLong1);
        paramString1.putExtra("poi_id", paramLong2);
        paramString1.putExtra("distance", paramInt2);
        paramString1.putExtra("business_name", paramString2);
        paramString1.putExtra("possible", paramBoolean);
        paramString1.putExtra("resPath", paramString3);
        paramString1.putExtra("logoPath", (String)localObject2);
        paramString1.putExtra("textIconPath", str2);
        paramString1.putExtra("bannerPath", str1);
        paramString1.putExtra("wishing", (String)localObject1);
        paramString1.putExtra("adcode", this.jdField_e_of_type_Long);
        paramString1.putExtra("pid", this.jdField_j_of_type_JavaLangString);
        paramString1.putExtra("business_url", paramString4);
        startActivityForResult(paramString1, i2);
      } while ((i2 != 1001) || (i1 <= 1));
      overridePendingTransition(2131034363, 0);
      return;
    } while ((paramInt1 != 12) || (a()));
    label840:
    Object localObject3 = ((LbsPackManager)getAppRuntime().getManager(214)).a();
    if (localObject3 != null)
    {
      localObject3 = (LbsPackPoiInfo)((LbsPackMapInfo)localObject3).a.get(Long.valueOf(paramLong2));
      if (localObject3 != null)
      {
        i1 = ((LbsPackPoiInfo)localObject3).a.size();
        if (i1 == 1)
        {
          localObject3 = (LbsPackInfo)((LbsPackPoiInfo)localObject3).a.get(0);
          if (String.valueOf(((LbsPackInfo)localObject3).jdField_a_of_type_Long).equals(this.app.getCurrentAccountUin()))
          {
            this.jdField_i_of_type_Boolean = true;
            paramString1 = new Intent(this, LbsPackListActivity.class);
            label1015:
            i2 = 1001;
            ReportController.b(null, "dc01440", "", "", "0X8007A50", "0X8007A50", 0, 0, String.valueOf(paramLong1), String.valueOf(paramLong2), "1", "");
          }
        }
      }
    }
    for (;;)
    {
      break label617;
      if (((LbsPackInfo)localObject3).jdField_a_of_type_Int != 0)
      {
        ((LbsPackManager)this.app.getManager(214)).a(this, 1001, (LbsPackInfo)localObject3, 0);
        return;
      }
      paramString1 = new Intent(this, LbsCaiShenActivity.class);
      paramString1.putExtra("pid", ((LbsPackInfo)localObject3).jdField_b_of_type_JavaLangString);
      paramString1.putExtra("k_pack_info", (Parcelable)localObject3);
      break label1015;
      if (i1 > 1)
      {
        this.jdField_i_of_type_Boolean = true;
        paramString1 = new Intent(this, LbsPackListActivity.class);
        i2 = 1001;
        ReportController.b(null, "dc01440", "", "", "0X8007A50", "0X8007A50", 0, 0, String.valueOf(paramLong1), String.valueOf(paramLong2), String.valueOf(i1), "");
        continue;
        if (QLog.isColorLevel()) {
          QLog.e("ARMapActivity", 2, "handlePoiClicked type = 12, lbsPackPoiInfo = null");
        }
        i1 = 0;
        continue;
        label1219:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ARMapActivity", 2, "error no intent");
        return;
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander.a(paramString, paramLong);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "playBGM launch:" + paramBoolean + " hasLaunchBGM:" + this.v + "  mIsResume:" + this.mIsResume);
    }
    if (paramBoolean) {
      this.v = true;
    }
    ARMapManager localARMapManager;
    do
    {
      while (!this.mIsResume)
      {
        return;
        if (!this.v) {
          return;
        }
      }
      localARMapManager = (ARMapManager)this.app.getManager(209);
    } while (localARMapManager == null);
    ARMapManager.a(this, true);
    localARMapManager.c();
  }
  
  public void a(boolean paramBoolean, float paramFloat, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "showPOIGuide show=" + paramBoolean + ",dir =" + paramString);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.post(new aasz(this, paramBoolean, paramString, paramInt));
  }
  
  boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_d_of_type_Long;
    this.jdField_d_of_type_Long = l1;
    return l1 - l2 <= 500L;
  }
  
  public void b()
  {
    if (this.jdField_l_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, "showGPSOverSpeedDialog has Showed before");
      }
    }
    while (isFinishing()) {
      return;
    }
    DialogUtil.a(this, 230, "安全提示", "在开车吗？安全第一，请勿边驾驶边参加活动哦。", "", "我知道了", new aaty(this), null).show();
    ReportController.b(null, "dc01440", "", "", "0X80079E1", "0X80079E1", 0, 0, "", "", "" + this.jdField_e_of_type_Long, "");
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "showGPSOverSpeedDialog");
    }
    this.jdField_l_of_type_Boolean = true;
  }
  
  public void b(double paramDouble1, double paramDouble2)
  {
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aats(this));
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt) {
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander.b(paramString, paramLong);
  }
  
  public void b(boolean paramBoolean)
  {
    this.z = paramBoolean;
    if (paramBoolean)
    {
      B();
      findViewById(2131369588).setVisibility(0);
      findViewById(2131369587).setVisibility(0);
      return;
    }
    findViewById(2131369588).setVisibility(8);
    findViewById(2131369587).setVisibility(8);
  }
  
  void c()
  {
    if (isFinishing()) {}
    do
    {
      return;
      DialogUtil.a(this, 230, null, "打开Wi-Fi，抢奖励会更准哦！现在开启？", "取消", "去开启", new aaum(this), new aauq(this)).show();
      ReportController.b(null, "dc01440", "", "", "0X8007855", "0X8007855", 0, 0, "1", "", "" + this.jdField_e_of_type_Long, "");
    } while (!QLog.isColorLevel());
    QLog.d("ARMapActivity", 2, "showOpenWifiDialog");
  }
  
  public void c(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
    X();
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null)
    {
      if (this.jdField_k_of_type_Int == 5) {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.c();
      }
      if ((this.jdField_k_of_type_Int == 3) || (this.jdField_k_of_type_Int == 2) || ((this.jdField_k_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Int == 0))) {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.b();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a();
  }
  
  void d()
  {
    if (isFinishing()) {}
    do
    {
      return;
      DialogUtil.a(this, 230, null, "打开GPS定位服务，抢奖励会更准哦！现在开启？", "取消", "去开启", new aaur(this), new aaus(this)).show();
      ReportController.b(null, "dc01440", "", "", "0X8007855", "0X8007855", 0, 0, "2", "", "" + this.jdField_e_of_type_Long, "");
    } while (!QLog.isColorLevel());
    QLog.d("ARMapActivity", 2, "showOpenGPSDialog");
  }
  
  public void d(int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      View localView = this.jdField_b_of_type_AndroidViewView;
      if (paramInt != 1) {}
      for (;;)
      {
        localView.setEnabled(bool);
        return;
        bool = false;
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "doOnActivityResult requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    }
    long l1;
    long l2;
    int i1;
    boolean bool6;
    if (((paramInt1 == 101) || (paramInt1 == 102) || (paramInt1 == 103) || (paramInt1 == 104) || (paramInt1 == 106)) && (paramInt2 == -1) && (paramIntent != null))
    {
      boolean bool1 = paramIntent.getBooleanExtra("flag_refresh_poi", false);
      boolean bool2 = paramIntent.getBooleanExtra("flag_open_failed", false);
      boolean bool3 = paramIntent.getBooleanExtra("flag_open_success", false);
      boolean bool4 = paramIntent.getBooleanExtra("flag_has_open", false);
      boolean bool5 = paramIntent.getBooleanExtra("flag_server_resp_success", false);
      l1 = paramIntent.getLongExtra("poi_id", 0L);
      l2 = paramIntent.getLongExtra("task_id", 0L);
      i1 = paramIntent.getIntExtra("task_type", -1);
      bool6 = paramIntent.getBooleanExtra("open_status", false);
      if (QLog.isColorLevel()) {
        QLog.i("ARMapActivity", 2, "doOnActivityResult openSuc:" + bool3 + " hasOpen:" + bool4 + " hasReceived:" + bool6 + "poiId:" + l1 + " taskId:" + l2 + " serverRespSuc:" + bool5 + "  taskType:" + i1 + " mMapView:" + this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView);
      }
      if ((l1 != 0L) && (l2 != 0L))
      {
        if (((!bool2) || (i1 != 7)) && ((!bool3) || (i1 != 7)) && ((!bool5) || ((i1 != 4) && (i1 != 5) && (i1 != 11)))) {
          break label444;
        }
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label449;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ARMapActivity", 2, "remove poi tasks");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) {
          this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aatg(this, l1));
        }
      }
      label397:
      if ((paramInt1 == 102) && (i1 == POITaskInfo.jdField_g_of_type_Int)) {
        a(bool1, bool3, bool4);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aati(this));
      }
    }
    for (;;)
    {
      return;
      label444:
      paramInt2 = 0;
      break;
      label449:
      if ((i1 != 6) || (!bool6)) {
        break label397;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ARMapActivity", 2, "update poi task status");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView == null) {
        break label397;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aath(this, l1, l2));
      break label397;
      if (paramInt1 == 105)
      {
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          this.jdField_a_of_type_ComQqImPoiPoiInfo = ((PoiInfo)paramIntent.getParcelableExtra("send_hb_poi"));
          paramIntent = paramIntent.getStringExtra("pid");
          ((LbsPackManager)getAppRuntime().getManager(214)).a(paramIntent);
          this.jdField_i_of_type_JavaLangString = paramIntent;
          this.jdField_j_of_type_JavaLangString = paramIntent;
          if ((!TextUtils.isEmpty(paramIntent)) && (this.jdField_a_of_type_ComQqImPoiPoiInfo != null))
          {
            paramIntent = new LbsPackShareDialog(this, this, this.jdField_a_of_type_ComQqImPoiPoiInfo, paramIntent);
            paramIntent.setOnDismissListener(new aatj(this));
            paramIntent.b();
          }
        }
      }
      else if (((paramInt1 == 1000) || (paramInt1 == 1001)) && (paramInt2 == -1))
      {
        if (paramInt1 == 1000) {}
        for (paramInt1 = 2; this.jdField_a_of_type_ComQqImPoiPoiInfo != null; paramInt1 = 3)
        {
          LbsPackShareOption.a(paramInt1, this.jdField_a_of_type_ComQqImPoiPoiInfo.jdField_a_of_type_Long);
          return;
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("from_jump", false)) {
      this.jdField_a_of_type_Boolean = true;
    }
    E();
    getWindow().setFormat(-3);
    setContentView(2130970200);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this.jdField_b_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_AndroidOsHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    F();
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity$LocationMonitor = new ARMapActivity.LocationMonitor(this);
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander = new POICheckHander(this.app);
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander.a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander$Listener);
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander = new OpenBoxCheckHander(this.app);
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander.a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander$OnResCheckResultListener);
    N();
    ((LbsPackManager)getAppRuntime().getManager(214)).a(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.onDestroy();
      S();
      this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.setTraceCallback(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setSplashListener(null);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.f();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapTracer != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapTracer.endTrace();
    }
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView != null) {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.onDestroy();
    }
    super.doOnDestroy();
    T();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqArmapNetChangedListener);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.app.a.b(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
    if (!this.u) {
      a(1, "" + this.jdField_e_of_type_Long);
    }
    if (this.G) {
      Y();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "doOnPause called ");
    }
    h();
    y();
    if (!this.jdField_i_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        SosoInterface.jdField_a_of_type_Int = 2000;
        Q();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null)
      {
        S();
        this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.onPause();
      }
      this.jdField_b_of_type_Boolean = false;
    }
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView != null) && (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getParent() != null)) {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.onPause();
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.b(false);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a.b();
      }
      A();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ARMapActivity", 1, "doOnPause stop anim fail!");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "doOnResume called ");
    }
    this.jdField_i_of_type_Boolean = false;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Int > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapActivity", 2, "doOnResume mMapLocateFreq=" + this.jdField_d_of_type_Int);
        }
        SosoInterface.jdField_a_of_type_Int = this.jdField_d_of_type_Int * 1000;
      }
      P();
    }
    if (this.C)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.n = System.currentTimeMillis();
      }
      if (!sIsLoadSoSuc) {
        break label281;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null) && (this.jdField_k_of_type_Int == 5)) {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.c();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView == null) || (this.jdField_k_of_type_Int != 5) || (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a() <= 3L)) {
        break label270;
      }
      O();
    }
    for (;;)
    {
      b(1000L);
      this.C = false;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.onResume();
        R();
        a(false);
      }
      if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView != null) && (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getParent() != null)) {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.onResume();
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.b(this.app);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a.a();
        z();
        return;
        label270:
        s();
        O();
        continue;
        label281:
        if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setLoadStatus(3);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("ARMapActivity", 1, "doOnResume start anim fail!");
        }
      }
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "doOnStart called ");
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "doOnStop called ");
    }
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView != null) {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.onStop();
    }
  }
  
  void e()
  {
    if (isFinishing()) {}
    do
    {
      return;
      DialogUtil.a(this, 230, null, "打开Wi-Fi和GPS定位服务，抢奖励会更准哦！现在开启？", "取消", "去开启", new aarz(this), new aasa(this)).show();
      ReportController.b(null, "dc01440", "", "", "0X8007855", "0X8007855", 0, 0, "3", "", "" + this.jdField_e_of_type_Long, "");
    } while (!QLog.isColorLevel());
    QLog.d("ARMapActivity", 2, "showOpenWifiGPSDialog");
  }
  
  public void f()
  {
    this.jdField_i_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "clickLbsPackEntry");
    }
    Object localObject = ((LbsPackManager)this.app.getManager(214)).a;
    if (localObject != null) {}
    for (localObject = ((LbsPackConfig)localObject).getGreeting(NetConnInfoCenter.getServerTimeMillis());; localObject = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        LbsPackSendActivity.a(this, 105);
      }
      QQCustomDialog localQQCustomDialog;
      do
      {
        return;
        localQQCustomDialog = DialogUtil.a(this, 0);
        localQQCustomDialog.setMessage((CharSequence)localObject).setCancelable(true);
        localQQCustomDialog.setNegativeButton(2131432998, null);
        localQQCustomDialog.setPositiveButton(2131438000, new aasl(this, localQQCustomDialog));
      } while (isFinishing());
      localQQCustomDialog.show();
      return;
    }
  }
  
  public void g()
  {
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this, getString(2131433196), 1).a();
      return;
    }
    Object localObject2 = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new JSONObject();
    LbsPackManager localLbsPackManager = (LbsPackManager)this.app.getManager(214);
    try
    {
      localJSONObject.put("tab_index", 1);
      ((JSONObject)localObject2).put("detailinfo", localJSONObject);
      ((JSONObject)localObject1).put("extra_data", localObject2);
      ((JSONObject)localObject1).put("come_from", 2);
      ((JSONObject)localObject1).put("viewTag", "redgiftRecord");
      ((JSONObject)localObject1).put("userId", this.app.getCurrentAccountUin());
      ((JSONObject)localObject1).put("skey", localLbsPackManager.b());
      ((JSONObject)localObject1).put("key_type", 2);
      ReportController.b(null, "dc01440", "", "", "0X8007A55", "0X8007A55", 0, 0, "", "", "", "");
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("json", ((JSONObject)localObject1).toString());
      ((Bundle)localObject2).putString("callbackSn", "0");
      localObject1 = new Intent(this, PayBridgeActivity.class);
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).putExtra("pay_requestcode", 5);
      startActivity((Intent)localObject1);
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
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "stopBGM");
    }
    ARMapManager localARMapManager = (ARMapManager)this.app.getManager(209);
    if (localARMapManager != null)
    {
      localARMapManager.d();
      ARMapManager.a(this, false);
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "onMapLoadFinished");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.p = System.currentTimeMillis();
    }
    this.jdField_f_of_type_Boolean = true;
    if (this.F) {
      aa();
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  @TargetApi(11)
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARMapActivity", 2, "clickRedpacketCloud");
    }
    Object localObject1 = (ARMapManager)this.app.getManager(209);
    long l1;
    Object localObject2;
    Uri.Builder localBuilder;
    int i1;
    if (localObject1 != null)
    {
      localObject1 = ((ARMapManager)localObject1).a(false);
      if ((localObject1 != null) && (((ARMapConfig)localObject1).wealthGodConfig != null) && (!TextUtils.isEmpty(((ARMapConfig)localObject1).wealthGodConfig.topBarCloudUrl)))
      {
        l1 = NetConnInfoCenter.getServerTimeMillis();
        localObject2 = Uri.parse(((ARMapConfig)localObject1).wealthGodConfig.topBarCloudUrl);
        Object localObject3 = ((Uri)localObject2).getQueryParameterNames();
        localBuilder = ((Uri)localObject2).buildUpon().clearQuery();
        localObject3 = ((Set)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          if ((!str.equals("adcode")) && (!str.equals("timestamp")) && (!str.equals("state"))) {
            localBuilder.appendQueryParameter(str, ((Uri)localObject2).getQueryParameter(str));
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo == null) {
          break label466;
        }
        if (l1 >= this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_Long) {
          break label427;
        }
        i1 = 0;
      }
    }
    for (;;)
    {
      localBuilder.appendQueryParameter("adcode", String.valueOf(this.jdField_e_of_type_Long));
      localBuilder.appendQueryParameter("timestamp", String.valueOf(l1));
      localBuilder.appendQueryParameter("state", String.valueOf(i1));
      localObject2 = localBuilder.build().toString();
      if (QLog.isColorLevel()) {
        QLog.i("ARMapActivity", 2, "clickRedpacketCloud enter mapRedpacketCloudUrl:" + ((ARMapConfig)localObject1).wealthGodConfig.topBarCloudUrl + "   newUrl:" + (String)localObject2);
      }
      localObject1 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("portraitOnly", true);
      ((Intent)localObject1).putExtra("finish_animation_up_down", true);
      startActivity((Intent)localObject1);
      overridePendingTransition(2131034134, 2131034131);
      ReportController.b(null, "dc01440", "", "", "0X80079C7", "0X80079C7", 0, 0, String.valueOf(this.jdField_i_of_type_Int), "", String.valueOf(this.jdField_e_of_type_Long), "");
      return;
      label427:
      if (l1 < this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_Long)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_b_of_type_Long <= 0L) {
          i1 = 3;
        }
      }
      else
      {
        i1 = 2;
        continue;
      }
      i1 = 1;
      continue;
      label466:
      i1 = 0;
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARMapActivity", 2, "queryLeftRedPacketCount mAdcode:" + this.jdField_e_of_type_Long + "  mQueryLeftRedPacketPaused:" + this.y);
    }
    if ((this.jdField_e_of_type_Long > 0L) && (!this.y)) {
      ((ArMapHandler)this.app.a(2)).a(this.jdField_e_of_type_Long, false, 2, null);
    }
    do
    {
      return;
      this.jdField_q_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    QLog.i("ARMapActivity", 2, "queryLeftRedPacketCount no run ");
  }
  
  @TargetApi(11)
  public void l()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this, 3);
    localBuilder.setTitle("选择一个城市");
    localBuilder.setItems(MapBorderUtils.jdField_a_of_type_ArrayOfJavaLangString, new aatr(this));
    localBuilder.show();
  }
  
  public void m()
  {
    String str = SystemUtil.a(this, "com.tencent.mobileqq:tool");
    str = "lon:" + this.jdField_a_of_type_Double + ",lat:" + this.jdField_b_of_type_Double + str;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.post(new aatu(this, str));
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "onEntryClick");
    }
    ArMapIPC.a().a(IPCConstants.jdField_h_of_type_JavaLangString, null);
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.b(true);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.e();
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a.b();
      L();
      Z();
    }
    H();
  }
  
  public void o()
  {
    ThreadManager.post(new aauh(this), 5, null, true);
  }
  
  protected boolean onBackEvent()
  {
    if (System.currentTimeMillis() - this.jdField_i_of_type_Long <= 1000L) {
      return true;
    }
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      v();
      return true;
    }
    V();
    if (!this.F) {
      this.G = true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369592: 
    case 2131369585: 
    case 2131369577: 
    case 2131369581: 
    case 2131369583: 
    case 2131369600: 
    case 2131369657: 
    case 2131369587: 
    case 2131369594: 
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (this.jdField_b_of_type_Int == 2) {
                b(0);
              }
              while ((this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.getEngineHandler() != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine != null))
              {
                this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aash(this));
                return;
                b(2);
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("ARMapActivity", 2, "tv_poiguide clicked");
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView == null);
          this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aasi(this));
          return;
        } while (System.currentTimeMillis() - this.jdField_i_of_type_Long <= 1000L);
        if (!this.F) {
          this.G = true;
        }
        V();
        finish();
        return;
        I();
        return;
        J();
        return;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        v();
        return;
        j();
        return;
        l();
        return;
      } while (a());
      f();
      return;
    }
    u();
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander.a();
    }
  }
  
  public void q()
  {
    Object localObject = new SpannableString(getString(2131438747));
    StatableSpanTextView.StatableForegroundColorSpan localStatableForegroundColorSpan = new StatableSpanTextView.StatableForegroundColorSpan(getResources().getColor(2131493061), getResources().getColor(2131493062));
    int i1 = ((SpannableString)localObject).length();
    ((SpannableString)localObject).setSpan(localStatableForegroundColorSpan, i1 - 7, i1 - 1, 33);
    localObject = DialogUtil.a(this, "安全提示", (CharSequence)localObject, 0, 2131435179, null, null, new aauk(this));
    ((Dialog)localObject).setOnDismissListener(new aaul(this));
    if (!isFinishing()) {}
    try
    {
      ((Dialog)localObject).show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapActivity
 * JD-Core Version:    0.7.0.1
 */