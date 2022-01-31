package com.tencent.mobileqq.ar.view;

import aciy;
import ajjy;
import akiq;
import akiw;
import akja;
import akjt;
import akkc;
import akkz;
import akle;
import aklt;
import aklw;
import akmy;
import akmz;
import aknz;
import akoe;
import akrk;
import akrl;
import akso;
import akss;
import aksw;
import akti;
import aktk;
import akto;
import akue;
import akwj;
import akwk;
import akwn;
import akwq;
import akwr;
import akws;
import akwu;
import akwv;
import akxi;
import akxj;
import akxk;
import akxm;
import akxn;
import akxo;
import akxp;
import akxq;
import akxr;
import akxs;
import akxt;
import akxu;
import akxv;
import akxw;
import akxx;
import akyn;
import alif;
import alig;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import athi;
import athu;
import atig;
import atij;
import atik;
import awmc;
import awqx;
import awrn;
import babr;
import bafb;
import baip;
import bbmy;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ar.ObjectSurfaceView;
import com.tencent.mobileqq.ar.ScanningSurfaceView;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import mqq.os.MqqHandler;
import xaw;

public class ARScanEntryView
  extends ScanEntryProviderView
  implements akso, akwk, Handler.Callback, View.OnClickListener, atij
{
  private boolean A;
  private boolean B = true;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I;
  private boolean J;
  private boolean K;
  private boolean L;
  public int a;
  long jdField_a_of_type_Long = -1L;
  private akja jdField_a_of_type_Akja;
  akjt jdField_a_of_type_Akjt;
  private akle jdField_a_of_type_Akle;
  private akmy jdField_a_of_type_Akmy;
  akoe jdField_a_of_type_Akoe;
  private akwn jdField_a_of_type_Akwn;
  private akwr jdField_a_of_type_Akwr = new akxw(this);
  private akws jdField_a_of_type_Akws = new akxx(this);
  private alif jdField_a_of_type_Alif = new akxv(this);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new akxj(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new akxk(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public FrameLayout a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  private athi jdField_a_of_type_Athi;
  private atig jdField_a_of_type_Atig;
  private bafb jdField_a_of_type_Bafb;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  public ObjectSurfaceView a;
  public ScanningSurfaceView a;
  private volatile ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  public ScanSuccessView a;
  private ScanIconAnimateView jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView;
  private MapView jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public String a;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public TextView c;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean = false;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  boolean jdField_f_of_type_Boolean = false;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  volatile boolean jdField_g_of_type_Boolean = false;
  volatile boolean h = false;
  boolean i;
  public boolean j;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private volatile boolean y = true;
  private boolean z;
  
  public ARScanEntryView(Context paramContext, akyn paramakyn)
  {
    super(paramContext, paramakyn);
    this.jdField_a_of_type_Int = -1;
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("checkArDependenceReady time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.jdField_c_of_type_Long) }));
    }
    boolean bool1 = akiq.a().a();
    boolean bool2 = akiq.a().b();
    QLog.i("AREngine_ARScanEntryView", 1, "checkArDependenceReady. isAREnable = " + bool1 + ", isSupportAr = " + bool2 + ", mIsArSoReady = " + false + ", mIsVideoPluginReady = " + false);
    akwq localakwq = this.jdField_a_of_type_Akyn.a();
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    if ((bool1) && (bool2) && (localakwq.a(2)) && (localakwq.a(8)) && (!this.r))
    {
      if ((this.jdField_a_of_type_Akwn != null) && (this.jdField_a_of_type_Akwn.b()))
      {
        if (!this.jdField_a_of_type_Akwn.c()) {
          q();
        }
        if ((this.m) && (this.jdField_a_of_type_Akwn.c()) && (this.jdField_a_of_type_Akwn.b()) && (this.jdField_a_of_type_Akwn.b() == 1)) {
          this.jdField_a_of_type_Akwn.g();
        }
      }
      if (this.jdField_a_of_type_Akyn.a() != null) {
        if (this.jdField_a_of_type_Akyn.a().isEnableVideoRecord != 1L) {
          break label333;
        }
      }
    }
    label333:
    for (bool1 = true;; bool1 = false)
    {
      akkz.a().a(bool1);
      QLog.d("AREngine_ARScanEntryView", 1, String.format("checkARVideoRecordEnable enable=%s", new Object[] { Boolean.valueOf(bool1) }));
      if ((!this.H) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(321)))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(321, 100L);
        QLog.d("AREngine_ARScanEntryView", 1, "checkArDependenceReady do delay initARView");
      }
      return;
    }
  }
  
  private void B()
  {
    if (this.jdField_b_of_type_JavaLangRunnable == null)
    {
      this.jdField_b_of_type_JavaLangRunnable = new ARScanEntryView.37(this);
      QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck");
    }
    this.K = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 10000L);
  }
  
  private void C()
  {
    QLog.d("AREngine_ARScanEntryView", 2, "stopDownloadTimeoutCheck");
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
  }
  
  private void D()
  {
    long l2 = 8000L;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("addTimeoutCheck mArEnabled=%s mHasCallRemoveTimeoutCheck=%s", new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.L) }));
    }
    if (this.L) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new ARScanEntryView.38(this);
    }
    long l1 = l2;
    if (this.jdField_a_of_type_Akyn.a() != null)
    {
      l1 = this.jdField_a_of_type_Akyn.a().mARNoResultCheckTime;
      if (l1 > 0L) {
        break label126;
      }
      l1 = l2;
    }
    label126:
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l1);
      return;
    }
  }
  
  private void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "removeTimeoutCheck");
    }
    this.L = true;
    this.u = false;
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "do removeTimeoutCheck");
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  private void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "doAfterAREngineReady = ");
    }
    if (this.jdField_a_of_type_Akjt != null) {
      this.jdField_a_of_type_Akjt.a(this.jdField_a_of_type_Akwn);
    }
    atik localatik = this.jdField_a_of_type_Akyn.a();
    if (localatik != null) {
      localatik.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.z = true;
  }
  
  private void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "doHideNonPromotionUI = ");
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void H()
  {
    if ((!this.s) || (this.K)) {}
    while (!this.u) {
      return;
    }
    b("updateDownloadProgress");
  }
  
  private void I()
  {
    QLog.i("AREngine_ARScanEntryView", 1, "checkReadyToStartARSession = " + this.m);
    if ((this.jdField_a_of_type_Akwn != null) && (this.jdField_a_of_type_Akwn.c()) && (this.m)) {
      this.jdField_a_of_type_Akwn.a();
    }
  }
  
  private void J() {}
  
  private void K()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "checkIfNeedAutoFocus isCameraPrviewing=" + akwj.a().b() + ";mIsResumed=" + this.m);
    if ((akwj.a().b()) && (this.m)) {
      akwj.a().a(akwv.jdField_a_of_type_Int, akwv.jdField_b_of_type_Int);
    }
  }
  
  private void L()
  {
    QLog.i("AREngine_ARScanEntryView", 1, "stopAutoFoucus ");
    akwj.a().a();
  }
  
  private TouchWebView a()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      t();
    }
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  private MapView a()
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView == null)
    {
      this.j = false;
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView = new MapView(this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings() != null)
      {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings().setLogoPosition(0);
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings().setScaleViewEnabled(false);
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings().setScrollGesturesEnabled(false);
      }
      TencentMap localTencentMap = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap();
      localTencentMap.setOnCameraChangeListener(new akxr(this));
      localTencentMap.setOnMapLoadedCallback(new akxs(this));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.setEnabled(true);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.setClickable(true);
    }
    return this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView;
  }
  
  private String a(long paramLong)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
      this.jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      String str = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AREngine_ARScanEntryView", 2, "getCurrentDateString exception", localException);
    }
    return localObject;
    return null;
  }
  
  private void a(akrl paramakrl, ArLBSActivity paramArLBSActivity)
  {
    if (this.jdField_a_of_type_Akja == null)
    {
      this.jdField_a_of_type_Akja = new akja((Activity)this.jdField_a_of_type_AndroidContentContext, a(), this);
      this.jdField_a_of_type_Akja.setOnDismissListener(new akxq(this));
    }
    this.jdField_a_of_type_Akja.a();
    this.jdField_a_of_type_Akja.a(paramakrl, paramArLBSActivity);
  }
  
  private void a(ARCommonConfigInfo paramARCommonConfigInfo, long paramLong)
  {
    if ((paramARCommonConfigInfo.recognitions != null) && (paramARCommonConfigInfo.recognitions.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      if (paramLong != 0L)
      {
        Object localObject = paramARCommonConfigInfo.recognitions.iterator();
        int k = 0;
        while (((Iterator)localObject).hasNext())
        {
          ARRecognition localARRecognition = (ARRecognition)((Iterator)localObject).next();
          int m = k;
          if (localARRecognition.jdField_a_of_type_Long == 12L) {
            m = 1;
          }
          k = m;
          if ((1 << (int)localARRecognition.jdField_a_of_type_Long & paramLong) != 0L)
          {
            localArrayList.add(localARRecognition);
            k = m;
          }
        }
        if ((k == 0) && ((0x1000 & paramLong) != 0L))
        {
          localObject = new ARRecognition();
          ((ARRecognition)localObject).jdField_a_of_type_Long = 12L;
          ((ARRecognition)localObject).jdField_a_of_type_Int = 1;
          ((ARRecognition)localObject).jdField_b_of_type_Int = 1;
          ((ARRecognition)localObject).jdField_c_of_type_Int = 4;
          ((ARRecognition)localObject).jdField_d_of_type_Int = 1;
        }
        paramARCommonConfigInfo.recognitions = localArrayList;
      }
    }
  }
  
  private String b(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append("&_wv=");
    paramString.append(Integer.toString(17367040));
    return paramString.toString();
  }
  
  private void b(akrk paramakrk, ArLBSActivity paramArLBSActivity)
  {
    if (paramArLBSActivity == null) {
      new ArLBSActivity();
    }
    do
    {
      return;
      if (paramakrk.jdField_a_of_type_Int == 0)
      {
        if (paramakrk.jdField_a_of_type_Akrl == null)
        {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, paramArLBSActivity.f, 1).a();
          return;
        }
        this.jdField_a_of_type_Akwn.h();
        g(false);
        a(paramakrk.jdField_a_of_type_Akrl, paramArLBSActivity);
        return;
      }
      if (paramakrk.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Akwn.g();
        g(false);
        if (this.jdField_a_of_type_Bafb == null) {
          this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidContentContext, 230, paramArLBSActivity.g, paramArLBSActivity.h, ajjy.a(2131634954), ajjy.a(2131634946), new akxn(this), new akxo(this));
        }
        this.jdField_a_of_type_Bafb.setOnDismissListener(new akxp(this));
        this.jdField_a_of_type_Bafb.show();
        return;
      }
    } while (paramakrk.jdField_a_of_type_Int != -1);
  }
  
  private void b(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "doWhenGetARConfig ");
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
      return;
    }
    if ((paramARCommonConfigInfo != null) && (paramARCommonConfigInfo.arControllers != null))
    {
      Iterator localIterator = paramARCommonConfigInfo.arControllers.iterator();
      while (localIterator.hasNext())
      {
        ARScanAR localARScanAR = (ARScanAR)localIterator.next();
        if ((localARScanAR != null) && (localARScanAR.jdField_a_of_type_Int == 1))
        {
          this.jdField_c_of_type_JavaLangString = localARScanAR.j;
          this.jdField_b_of_type_JavaLangString = localARScanAR.f;
        }
      }
    }
    if (!this.D)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(325);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(325);
    }
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
    if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("NoLimitParams", true)) {
      a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo, this.jdField_a_of_type_AndroidOsBundle.getLong("recognitionMask", 0L));
    }
    paramARCommonConfigInfo = this.jdField_a_of_type_Akyn.a();
    ThreadManager.postImmediately(new ARScanEntryView.7(this, this.jdField_b_of_type_Long, paramARCommonConfigInfo), null, false);
  }
  
  private void c(String paramString)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "scanTorch preLaunchToQQBrowseActivity ");
    paramString = b(paramString);
    a();
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramString);
    }
  }
  
  private boolean d()
  {
    return !this.jdField_a_of_type_AndroidOsBundle.getBoolean("NoLimitParams", true);
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_Akyn.a() != null) {
      return this.jdField_a_of_type_Akyn.a().b();
    }
    return true;
  }
  
  /* Error */
  private boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 350	com/tencent/mobileqq/ar/view/ARScanEntryView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4: invokestatic 772	alig:a	(Lmqq/app/AppRuntime;)Landroid/content/SharedPreferences;
    //   7: astore 4
    //   9: aload 4
    //   11: ldc_w 774
    //   14: iconst_0
    //   15: invokeinterface 777 3 0
    //   20: istore_1
    //   21: aload_0
    //   22: invokespecial 779	com/tencent/mobileqq/ar/view/ARScanEntryView:g	()Z
    //   25: ifne +49 -> 74
    //   28: aload_0
    //   29: getfield 350	com/tencent/mobileqq/ar/view/ARScanEntryView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   32: iconst_2
    //   33: invokevirtual 785	com/tencent/common/app/AppInterface:getBusinessHandler	(I)Ljava/lang/Object;
    //   36: checkcast 787	alie
    //   39: astore 5
    //   41: aload 4
    //   43: ldc_w 789
    //   46: lconst_0
    //   47: invokeinterface 790 4 0
    //   52: lstore_2
    //   53: aload 5
    //   55: ifnull +19 -> 74
    //   58: aload 5
    //   60: aload_0
    //   61: getfield 350	com/tencent/mobileqq/ar/view/ARScanEntryView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   64: invokevirtual 793	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   67: invokestatic 797	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   70: lload_2
    //   71: invokevirtual 800	alie:a	(JJ)V
    //   74: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +29 -> 106
    //   80: ldc 159
    //   82: iconst_2
    //   83: new 195	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 802
    //   93: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload_1
    //   97: invokevirtual 205	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   100: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: iload_1
    //   107: ireturn
    //   108: astore 4
    //   110: aload 4
    //   112: invokevirtual 805	java/lang/Exception:printStackTrace	()V
    //   115: ldc 159
    //   117: iconst_1
    //   118: ldc_w 807
    //   121: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: iload_1
    //   125: ireturn
    //   126: astore 4
    //   128: goto -54 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ARScanEntryView
    //   20	105	1	bool	boolean
    //   52	19	2	l	long
    //   7	35	4	localSharedPreferences	SharedPreferences
    //   108	3	4	localException	Exception
    //   126	1	4	localNumberFormatException	java.lang.NumberFormatException
    //   39	20	5	localalie	alie
    // Exception table:
    //   from	to	target	type
    //   28	41	108	java/lang/Exception
    //   58	74	126	java/lang/NumberFormatException
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("setHaveEdge flag=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.J == paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "edge show equal so refuse");
      }
      return;
    }
    this.J = paramBoolean;
    if (this.jdField_a_of_type_Akyn.a() != null)
    {
      this.jdField_a_of_type_Akyn.a().a(paramBoolean, 0.0F, 1.0F);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, String.format("setHaveEdge do real call flag=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.9(this, paramBoolean));
    this.jdField_a_of_type_Akyn.b(paramBoolean);
    f(paramBoolean);
  }
  
  private boolean g()
  {
    boolean bool2 = false;
    String str1 = alig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).getString("key_click_reddot_date", null);
    String str2 = a(NetConnInfoCenter.getServerTimeMillis());
    boolean bool1 = bool2;
    if (str1 != null)
    {
      bool1 = bool2;
      if (str1.equals(str2)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "hasClickedRedDotToday  result = " + bool1 + ",curDate = " + str2 + ",clickDate = " + str1);
    }
    return bool1;
  }
  
  private void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.10(this));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.11(this));
  }
  
  private void i(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Akmy == null) || (this.jdField_a_of_type_Akmy.a == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Akmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Akmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
      }
      if (this.I)
      {
        this.I = false;
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.bottomMargin = aciy.a(170.0F, getResources());
        localLayoutParams.addRule(13, 0);
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069D2", "0X80069D2", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "", "");
  }
  
  private void n()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309736));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131311553));
    akxi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311554));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311556));
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("Title");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131634948));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297188));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131313560));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299184));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajjy.a(2131634950));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView = ((ScanIconAnimateView)findViewById(2131299187));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.setPopUpListener(new akxu(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300672));
    localObject = (ViewStub)findViewById(2131297185);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      this.jdField_a_of_type_Akle = new akle(findViewById(2131297211));
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297181));
    if (this.jdField_a_of_type_Akjt == null)
    {
      this.jdField_a_of_type_Akjt = new akjt();
      localObject = (ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext;
      this.jdField_a_of_type_Akjt.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (ScanTorchActivity)localObject, this.jdField_c_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_Akjt.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView = this;
    }
    if (this.D) {
      G();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("initView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
  
  private void o()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    akkz.a().a(localActivity);
    akkz.a().a(localActivity);
    akkz.a().a(this.jdField_a_of_type_Akle);
  }
  
  private void p()
  {
    if (!akwn.f())
    {
      QLog.d("AREngine_ARScanEntryView", 1, "ARScanEntryView onCreate error happen");
      return;
    }
    akwn localakwn = akwn.a();
    this.jdField_a_of_type_Akwn = localakwn;
    this.jdField_a_of_type_Akwb = localakwn;
    this.jdField_a_of_type_Akwn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  private void q()
  {
    if (this.r) {
      return;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    ARScanStarFaceConfigInfo localARScanStarFaceConfigInfo = akiw.a(localActivity).a();
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Akwn != null) && (this.jdField_a_of_type_Akwn.b()))
        {
          long l = System.currentTimeMillis();
          k = this.jdField_a_of_type_Akwn.a(false, this.B, this.D, false, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo, null, localARScanStarFaceConfigInfo, this, localActivity, this.jdField_a_of_type_Akjt, this.jdField_a_of_type_Akyn.a());
          akue.a().a(System.currentTimeMillis() - l, k);
          if ((k != 0) || (!this.jdField_a_of_type_Akwn.c())) {
            continue;
          }
          I();
        }
      }
      catch (Exception localException)
      {
        int k;
        QLog.e("AREngine_ARScanEntryView", 1, "initAr fail.", localException);
        continue;
      }
      this.r = true;
      return;
      QLog.e("AREngine_ARScanEntryView", 1, String.format("initAr fail. result=%s", new Object[] { Integer.valueOf(k) }));
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Atig != null)
    {
      this.jdField_a_of_type_Atig.a(null);
      this.jdField_a_of_type_Atig = null;
    }
  }
  
  private void s()
  {
    if (this.H) {}
    long l;
    do
    {
      return;
      this.H = true;
      l = System.currentTimeMillis();
      ViewStub localViewStub = (ViewStub)findViewById(2131297178);
      if (localViewStub != null)
      {
        localViewStub.inflate();
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView = ((ScanningSurfaceView)super.findViewById(2131309850));
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.setVisibility(8);
        this.jdField_a_of_type_Akoe = new akoe(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Athi);
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.jdField_a_of_type_Akoe = this.jdField_a_of_type_Akoe;
        this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView = ((ObjectSurfaceView)super.findViewById(2131305322));
        this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.setVisibility(8);
        this.jdField_a_of_type_Akoe = new akoe(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Athi);
        this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.jdField_a_of_type_Akoe = this.jdField_a_of_type_Akoe;
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131313665));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131311311));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131311312));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131311313));
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131311819));
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setClickable(true);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
        w();
        y();
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          int k = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(0, k, 0, 0);
        }
        u();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AREngine_ARScanEntryView", 2, String.format("lazyInitARView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).b(null);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(null);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundResource(0);
      Drawable localDrawable = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getBackground();
      if (localDrawable != null) {
        localDrawable.setAlpha(0);
      }
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView, localLayoutParams);
      akue.a().a(System.currentTimeMillis() - l);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, String.format("lazyInitWebView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
    }
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("showViewFinder mHasViewFinderShow=%s isPause=%s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(this.l) }));
    }
    if ((this.jdField_b_of_type_Boolean) || (this.l)) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      while (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        int k = aciy.a(15.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2131101491);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(k, k, k, 0);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.bottomMargin = aciy.a(170.0F, getResources());
        if (this.I)
        {
          this.I = false;
          localLayoutParams.addRule(13, 0);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        w();
        return;
        if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "hideViewFinder");
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130844724);
    int k = aciy.a(15.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = aciy.a(170.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(k, k, k, aciy.a(7.0F, getResources()));
    if (this.I)
    {
      this.I = false;
      localLayoutParams.addRule(13, 0);
    }
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "showTouchView");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if ((this.jdField_a_of_type_Akmy != null) && (this.jdField_a_of_type_Akmy.a != null)) {
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "mArTarget == null || mArTarget.arResourceInfo == null");
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void z()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "handleARStartFail");
    this.n = true;
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      d_(ajjy.a(2131634949));
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131167766);
  }
  
  public akkc a()
  {
    return this.jdField_a_of_type_Akyn.a().a();
  }
  
  public atig a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "getPromotionGuide create = " + paramBoolean);
    }
    if (!this.m) {
      return null;
    }
    if ((this.jdField_a_of_type_Atig == null) && (paramBoolean))
    {
      this.jdField_a_of_type_Atig = new atig((Activity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Atig.a(this);
    }
    return this.jdField_a_of_type_Atig;
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.startsWith("http")) {
        str = "http://" + paramString;
      }
    }
    return str;
  }
  
  public void a()
  {
    QLog.d("AREngine_ARScanEntryView", 2, "ARTransferDoorLogicManager onRenderManagerStarted");
    if ((this.m) && (this.E) && (this.C))
    {
      QLog.d("AREngine_ARScanEntryView", 2, "start for next Time");
      this.jdField_a_of_type_Akjt.e();
      this.jdField_a_of_type_Akjt.a(null);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 1, "onARStartComplete mUIhandler null retCode " + paramInt);
      }
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ScanTorchActivity localScanTorchActivity = (ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext;
      if (localScanTorchActivity.f < 0L) {
        localScanTorchActivity.f = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "onArReady success + time is " + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "onArReady success-visiable + time is " + (System.currentTimeMillis() - localScanTorchActivity.a()));
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(295);
      return;
    case 7: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(309);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(310);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      return;
    case 0: 
      g(false);
      E();
      j();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(306);
      return;
    }
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(311);
  }
  
  public void a(int paramInt1, akmy paramakmy, int paramInt2)
  {
    if ((paramakmy == null) || (paramakmy.a == null))
    {
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, arTarget == null || arTarget.arResourceInfo == null");
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, remainCount " + paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, new Object[] { "onARAnimationStateChanged, mLastArAnimState=", Integer.valueOf(this.jdField_a_of_type_Int), ", newState=", paramInt1 + ", target=" + paramakmy });
    }
    label220:
    int k;
    boolean bool;
    int m;
    switch (paramInt1)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Int = paramInt1;
        return;
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Akmy = paramakmy;
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.21(this, paramakmy));
        for (paramInt2 = 100;; paramInt2 = 100)
        {
          try
          {
            switch (paramakmy.a.jdField_d_of_type_Int)
            {
            case 0: 
              awqx.b(null, "CliOper", "", "", "0X80081DF", "0X80081DF", 0, 0, paramakmy.a.jdField_b_of_type_JavaLangString, String.valueOf(paramInt2), String.valueOf(k), "");
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              QLog.d("AREngine_ARScanEntryView", 1, "0X80081DF ReportController  error " + localException1.getMessage());
            }
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069CC", "0X80069CC", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramakmy.a.jdField_b_of_type_JavaLangString, "2");
          }
          if ((paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (!paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean)) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.22(this, paramakmy));
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
          return;
          if (paramakmy.a.j())
          {
            paramInt2 = 3;
            break label1349;
          }
          if (!paramakmy.a.d()) {
            break label1349;
          }
          paramInt2 = 0;
          break label1349;
          if (paramakmy.a.j())
          {
            paramInt2 = 1;
            break label1355;
          }
          if (!paramakmy.a.i()) {
            break label1355;
          }
          paramInt2 = 5;
          break label1355;
          if (paramakmy.a.d())
          {
            paramInt2 = 2;
            break label1361;
          }
          bool = paramakmy.a.j();
          if (bool)
          {
            paramInt2 = 4;
            break label1361;
          }
          paramInt2 = 6;
          break label1361;
          k = 0;
        }
      }
    case 1: 
      this.jdField_a_of_type_Akmy = paramakmy;
      if (!paramakmy.a.d()) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X8008144", "0X8008144", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramakmy.a.jdField_b_of_type_JavaLangString, "2");
      }
      if ((paramakmy.a.jdField_d_of_type_Int != 0) && (paramakmy.a.jdField_d_of_type_Int != 5))
      {
        m = akmz.a(paramakmy);
        k = m;
        if (m == 0) {
          k = 2147483647;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "AREngineCallback.AR_ANIMATION_STATE_END, remainCount is " + k + ",remainCount" + paramInt2);
        }
        if (paramInt2 == 0) {}
        for (k = 100;; k = 100)
        {
          try
          {
            switch (paramakmy.a.jdField_d_of_type_Int)
            {
            case 0: 
              label700:
              awqx.b(null, "CliOper", "", "", "0X80081E1", "0X80081E1", 0, 0, paramakmy.a.jdField_b_of_type_JavaLangString, String.valueOf(k), String.valueOf(m), "");
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              QLog.d("AREngine_ARScanEntryView", 1, "0X80081E1 ReportController  error " + localException2.getMessage());
              continue;
              bool = false;
            }
          }
          if ((paramakmy.a.jdField_a_of_type_Int != 0) && ((paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (TextUtils.isEmpty(paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))) {
            break label999;
          }
          bool = true;
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.23(this, paramakmy, paramInt2, bool));
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069CF", "0X80069CF", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramakmy.a.jdField_b_of_type_JavaLangString, "");
          break;
          if (paramakmy.a.j())
          {
            k = 3;
            break label1377;
          }
          if (!paramakmy.a.d()) {
            break label1377;
          }
          k = 0;
          break label1377;
          if (paramakmy.a.j())
          {
            k = 1;
            break label1383;
          }
          if (!paramakmy.a.i()) {
            break label1383;
          }
          k = 5;
          break label1383;
          if (paramakmy.a.d())
          {
            k = 2;
            break label1389;
          }
          bool = paramakmy.a.j();
          if (bool)
          {
            k = 4;
            break label1389;
          }
          k = 6;
          break label1389;
          m = 0;
        }
      }
      break;
    case 2: 
      label606:
      label999:
      paramInt2 = 100;
    }
    for (;;)
    {
      try
      {
        switch (paramakmy.a.jdField_d_of_type_Int)
        {
        case 0: 
          awqx.b(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramakmy.a.jdField_b_of_type_JavaLangString, String.valueOf(paramInt2), String.valueOf(k), "");
        }
      }
      catch (Exception localException3)
      {
        QLog.d("AREngine_ARScanEntryView", 1, "0X80081E1 ReportController  error " + localException3.getMessage());
        continue;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Akmy = null;
      this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.24(this));
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069D0", "0X80069D0", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramakmy.a.jdField_b_of_type_JavaLangString, "");
      break;
      if (paramakmy.a.j())
      {
        paramInt2 = 3;
      }
      else if (paramakmy.a.d())
      {
        paramInt2 = 0;
        break label1404;
        if (paramakmy.a.j())
        {
          paramInt2 = 1;
          break label1410;
        }
        if (!paramakmy.a.i()) {
          break label1410;
        }
        paramInt2 = 5;
        break label1410;
        if (paramakmy.a.d())
        {
          paramInt2 = 2;
          break label1416;
        }
        bool = paramakmy.a.j();
        if (bool)
        {
          paramInt2 = 4;
          break label1416;
        }
        paramInt2 = 6;
        break label1416;
        k = 0;
        paramInt2 = 100;
        continue;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Akmy = null;
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.25(this));
        break;
        k = 1;
        break label606;
        k = 2;
        paramInt2 = 100;
        break label220;
        label1349:
        k = 2;
        break label220;
        label1355:
        k = 1;
        break label220;
        label1361:
        k = 1;
        break label220;
        m = 2;
        k = 100;
        break label700;
        label1377:
        m = 2;
        break label700;
        label1383:
        m = 1;
        break label700;
        label1389:
        m = 1;
        break label700;
        k = 2;
        paramInt2 = 100;
        continue;
      }
      label1404:
      k = 2;
      continue;
      label1410:
      k = 1;
      continue;
      label1416:
      k = 1;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("AREngine_ARScanEntryView", 2, "onStartLoadUrl");
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.27(this, paramString));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
  }
  
  public void a(long paramLong, int paramInt, aklw paramaklw, akti paramakti)
  {
    E();
    if ((paramLong == 128L) && ((paramakti instanceof aktk)))
    {
      paramakti = (aktk)paramakti;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 1, " externalRenderResult info is isValidData=" + paramakti.jdField_a_of_type_Boolean + "isNeedShowViewFinder " + paramakti.jdField_b_of_type_Boolean);
      }
      if (!paramakti.jdField_a_of_type_Boolean)
      {
        this.y = false;
        h(paramakti.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.12(this));
      }
    }
    label432:
    label458:
    label634:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("MIG object RectF(协议原始的数据) ");
              if (paramakti.jdField_a_of_type_Akto == null) {
                break;
              }
              paramaklw = paramakti.jdField_a_of_type_Akto.jdField_a_of_type_AndroidGraphicsRectF.toString();
              QLog.d("AREngine_MIGObjectClassifyResult", 1, paramaklw);
            }
            h(false);
          } while (paramakti.jdField_a_of_type_Akto == null);
          Object localObject = new aknz();
          ((aknz)localObject).jdField_a_of_type_Float = 99.0F;
          ((aknz)localObject).jdField_c_of_type_JavaLangString = (ajjy.a(2131634947) + (int)(paramakti.jdField_a_of_type_Akto.jdField_a_of_type_Double * 100.0D) + "%");
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_MIGObjectClassifyResult", 1, " scantorch activitity result ok " + paramakti.jdField_a_of_type_Akto.jdField_a_of_type_Double);
          }
          ((aknz)localObject).jdField_a_of_type_Int = 10;
          ((aknz)localObject).jdField_a_of_type_AndroidGraphicsRectF = aknz.a(paramakti.jdField_a_of_type_Akto.jdField_a_of_type_AndroidGraphicsRectF);
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_MIGObjectClassifyResult", 1, "MIG mapMigObjectRect2Screen(协议转化后的数据) object RectF " + ((aknz)localObject).jdField_a_of_type_AndroidGraphicsRectF);
          }
          ((aknz)localObject).jdField_a_of_type_ArrayOfFloat = null;
          ((aknz)localObject).h = null;
          ((aknz)localObject).jdField_c_of_type_Boolean = paramakti.jdField_a_of_type_Akto.jdField_b_of_type_Boolean;
          ((aknz)localObject).jdField_d_of_type_Boolean = false;
          ((aknz)localObject).jdField_a_of_type_Boolean = true;
          ((aknz)localObject).jdField_b_of_type_Boolean = true;
          ((aknz)localObject).jdField_e_of_type_Boolean = false;
          ((aknz)localObject).jdField_a_of_type_JavaLangString = paramakti.jdField_a_of_type_Akto.jdField_a_of_type_JavaLangString;
          if (TextUtils.isEmpty(paramakti.jdField_a_of_type_Akto.jdField_b_of_type_JavaLangString))
          {
            paramaklw = " ";
            ((aknz)localObject).jdField_d_of_type_JavaLangString = paramaklw;
            if (!TextUtils.isEmpty(paramakti.jdField_a_of_type_Akto.jdField_c_of_type_JavaLangString)) {
              break label634;
            }
            paramaklw = " ";
            ((aknz)localObject).jdField_e_of_type_JavaLangString = paramaklw;
            ((aknz)localObject).jdField_b_of_type_JavaLangString = null;
            ((aknz)localObject).f = null;
            ((aknz)localObject).g = paramakti.jdField_a_of_type_Akto.jdField_d_of_type_JavaLangString;
            if (QLog.isColorLevel())
            {
              QLog.d("AREngine_ARScanEntryView", 1, " label name is " + ((aknz)localObject).jdField_a_of_type_JavaLangString + "isAutoJump " + ((aknz)localObject).jdField_c_of_type_Boolean);
              if (TextUtils.isEmpty(paramakti.jdField_a_of_type_Akto.jdField_c_of_type_JavaLangString)) {
                QLog.d("AREngine_ARScanEntryView", 1, " profileContent    null  ");
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView == null) {
              break label647;
            }
            this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.13(this));
          }
          for (;;)
          {
            paramaklw = new ArrayList();
            paramaklw.add(localObject);
            this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.setFaceData(paramaklw);
            return;
            paramaklw = "error happen";
            break;
            paramaklw = paramakti.jdField_a_of_type_Akto.jdField_b_of_type_JavaLangString;
            break label432;
            paramaklw = paramakti.jdField_a_of_type_Akto.jdField_c_of_type_JavaLangString;
            break label458;
            QLog.d("AREngine_ARScanEntryView", 1, " scanningSurfaceView not ready ");
          }
          if (paramLong != 4L) {
            break;
          }
          if ((this.jdField_a_of_type_Akoe != null) && (this.jdField_a_of_type_Akoe.jdField_a_of_type_Athi != null))
          {
            int k = this.jdField_a_of_type_Akoe.jdField_a_of_type_Athi.a();
            if ((k != 3) && (k != 2) && (k != 0)) {
              j();
            }
          }
          if ((QLog.isColorLevel()) && (akss.jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARScanEntryView", 2, "onARTrackComplete, recogType = " + paramLong + ",trackMode = " + paramInt + ",trackResult = " + paramaklw + ",localRecogResult = " + paramakti + ",isPause = " + this.h);
          }
        } while ((this.h) || (paramLong != 4L) || (!(paramakti instanceof aksw)));
        paramaklw = (aksw)paramakti;
      } while (paramaklw == null);
      paramakti = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if ((paramaklw.jdField_a_of_type_JavaUtilArrayList != null) && (paramaklw.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
      for (;;)
      {
        if (!paramaklw.jdField_a_of_type_Boolean) {
          break label994;
        }
        this.jdField_g_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.c();
          this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.a();
          this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.15(this));
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.16(this));
        return;
        j();
        break;
        if ((this.jdField_a_of_type_Akoe != null) && (this.jdField_a_of_type_Akoe.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Akoe.jdField_a_of_type_Bafb.isShowing()) && (!paramakti.isFinishing())) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.14(this));
        }
      }
      if (!this.jdField_g_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.17(this));
      }
      if (this.jdField_a_of_type_Long < 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView == null);
    label647:
    label994:
    if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.18(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.setFaceData(paramaklw.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(long paramLong, akmy paramakmy)
  {
    E();
    j();
    if ((paramakmy == null) || (paramakmy.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 1, "onARRecogComplete empty value");
      }
    }
    for (;;)
    {
      return;
      if (!this.G) {}
      try
      {
        localObject = this.jdField_a_of_type_Akwn.a();
        if (localObject != null)
        {
          ((ArrayList)localObject).size();
          ((ArrayList)localObject).toString();
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        label68:
        Intent localIntent;
        break label68;
      }
      this.G = true;
      if (!paramakmy.a.f()) {
        if ((paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.8(this, paramakmy));
          if (!this.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(306);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageAtTime(313, 100L);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
          }
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 1, "onARRecogComplete start jump :" + paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
          }
        }
        else if ((paramakmy.a.jdField_d_of_type_Int == 6) && (paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (!paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
        {
          awqx.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, paramakmy.a.jdField_b_of_type_JavaLangString, "1", "0", "");
          paramakmy = paramakmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
          localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
          if (a(paramakmy))
          {
            localIntent = new Intent("android.intent.action.VIEW");
            localIntent.setData(Uri.parse(paramakmy));
            localIntent.addFlags(268435456);
            localIntent.addCategory("android.intent.category.DEFAULT");
            localIntent.setPackage(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getPackageName());
            this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          }
          while ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
          {
            ((Activity)localObject).overridePendingTransition(2130771997, 0);
            return;
            localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
            localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
            localIntent.putExtra("url", paramakmy);
            localIntent.putExtra("finish_animation_up_down", true);
            ((Activity)localObject).startActivity(localIntent);
          }
        }
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, akmy paramakmy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "onAREnableModelRender, isEnable = " + paramBoolean);
    }
    int k;
    if (!paramBoolean) {
      k = 100;
    }
    for (;;)
    {
      try
      {
        switch (paramakmy.a.jdField_d_of_type_Int)
        {
        case 0: 
          awqx.b(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramakmy.a.jdField_b_of_type_JavaLangString, String.valueOf(k), String.valueOf(m), "");
        }
      }
      catch (Exception localException)
      {
        QLog.d("AREngine_ARScanEntryView", 1, "0X80081E0 ReportController  error " + localException.getMessage());
        continue;
        g(true);
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.19(this));
        return;
      }
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsValue(Integer.valueOf(0))) || (!paramakmy.a.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "onARStateChanged, AR_RECOG_STATE_LOST in");
        }
        if (this.o != true) {}
      }
      else
      {
        return;
        if (paramakmy.a.j())
        {
          k = 3;
          break label433;
        }
        if (!paramakmy.a.d()) {
          break label433;
        }
        k = 0;
        break label433;
        if (paramakmy.a.j())
        {
          k = 1;
          break label439;
        }
        if (!paramakmy.a.i()) {
          break label439;
        }
        k = 5;
        break label439;
        if (paramakmy.a.d())
        {
          k = 2;
          break label445;
        }
        paramBoolean = paramakmy.a.j();
        if (paramBoolean)
        {
          k = 4;
          break label445;
        }
        k = 6;
        break label445;
        m = 0;
        k = 100;
        continue;
      }
      if ((paramakmy.a.jdField_a_of_type_Int == 1) && (paramakmy.a.e == 0)) {}
      for (k = 1; (k == 0) || (paramakmy.a.d()); k = 0)
      {
        g(false);
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.20(this));
        return;
      }
      continue;
      int m = 2;
      k = 100;
      continue;
      label433:
      m = 2;
      continue;
      label439:
      m = 1;
      continue;
      label445:
      m = 1;
    }
  }
  
  public void a(akkc paramakkc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "loadTransferDoorGuide ");
    }
    atig localatig = a(true);
    if (localatig == null) {
      return;
    }
    localatig.a(paramakkc);
  }
  
  public void a(akrk paramakrk, ArLBSActivity paramArLBSActivity)
  {
    QLog.d("AREngine_ARScanEntryView", 2, "onLBSLocationComplete. retCode = " + paramakrk.jdField_a_of_type_Int + ", LBSActivity = " + paramArLBSActivity);
    ThreadManager.getUIHandler().post(new ARScanEntryView.30(this, paramakrk, paramArLBSActivity));
  }
  
  public void a(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("downloadItems", 14L);
    this.D = this.jdField_a_of_type_AndroidOsBundle.getBoolean("arTransferPromotion", false);
    this.B = this.jdField_a_of_type_AndroidOsBundle.getBoolean("enableARCloud", true);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      paramBundle = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131495068, this, false);
      addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
      n();
      o();
      this.jdField_b_of_type_AndroidViewView = paramBundle;
    }
    this.jdField_a_of_type_Athi = new athi(this.jdField_a_of_type_AndroidContentContext, (RelativeLayout)this.jdField_b_of_type_AndroidViewView, new akxm(this));
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
    p();
    akwj.a().a(this);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
    this.z = false;
    this.k = true;
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    b(paramARCommonConfigInfo);
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo1, ArCloudConfigInfo paramArCloudConfigInfo2, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "onCommonCallbackFromUI, config=" + paramArCloudConfigInfo1 + ", action=" + paramInt1 + ", result=" + paramInt2 + ", data=" + paramObject);
    }
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, aklt paramaklt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.26(this, paramaklt, paramArVideoResourceInfo));
  }
  
  public void a(String paramString, akkc paramakkc, boolean paramBoolean)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "tryToEnterTransferMode[" + paramString + "], mIsTransferDoorMode[" + this.E + "], ready[" + paramBoolean + "]");
    this.E = true;
    this.D = true;
    if (paramakkc != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramakkc.jdField_b_of_type_JavaLangString);
    }
    G();
    if ((this.jdField_a_of_type_Akjt.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Akjt.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((akwn)this.jdField_a_of_type_Akjt.jdField_a_of_type_JavaLangRefWeakReference.get()).q();
    }
    if ((!paramBoolean) || (paramakkc == null)) {
      return;
    }
    this.F = true;
    d(false);
    b(1);
    awqx.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 0, 0, "1", "", "", "");
    paramString = paramakkc.a();
    this.jdField_a_of_type_Akjt.a(2);
    this.jdField_a_of_type_Akjt.c();
    this.jdField_a_of_type_Akjt.e();
    this.jdField_a_of_type_Akjt.a(paramString);
    E();
    j();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_Athi != null)
    {
      QLog.w("AREngine_ARScanEntryView", 1, "showTipsWithProgress, from[" + paramString1 + "], tips[" + paramString2 + "], progress[" + paramInt + "], isVisible[" + this.jdField_a_of_type_Athi.a() + "]");
      this.jdField_a_of_type_Athi.a(paramString2, paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, athu paramathu)
  {
    if (this.jdField_a_of_type_Athi != null)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "showErrorTips, str[" + paramString1 + "], isVisible[" + this.jdField_a_of_type_Athi.a() + "]", new Throwable("打印调用栈"));
      this.jdField_a_of_type_Athi.a(paramString1, paramString2, paramathu);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.F) || (this.v)) && (!this.n))
    {
      QLog.w("AREngine_ARScanEntryView", 1, "showLoadProgress, 已经在穿越门里面了, from[" + paramString + "]");
      return;
    }
    this.jdField_a_of_type_Akyn.a();
    int i2 = (this.jdField_d_of_type_Int + this.jdField_c_of_type_Int) / 2;
    QLog.d("AREngine_ARScanEntryView", 1, "showLoadProgress mCurrentAsyncProgress:=" + this.jdField_d_of_type_Int + ",mCurrentSyncProgress:=" + this.jdField_c_of_type_Int);
    int k;
    label142:
    int m;
    if ((this.jdField_a_of_type_Akle != null) && (this.jdField_a_of_type_Akle.a()))
    {
      k = 1;
      atik localatik = this.jdField_a_of_type_Akyn.a();
      if ((localatik == null) || (!this.D)) {
        break label274;
      }
      paramBoolean = localatik.c();
      m = localatik.a();
    }
    for (;;)
    {
      int i1 = i2;
      if (paramBoolean) {
        i1 = (i2 + m) / 2;
      }
      if (k != 0) {
        j();
      }
      for (;;)
      {
        B();
        if (this.x) {
          break;
        }
        this.x = true;
        awqx.b(null, "dc00898", "", "", "0X80085B6", "0X80085B6", 0, 0, "", "", "", "");
        return;
        k = 0;
        break label142;
        a(paramString, ajjy.a(2131634955), i1);
      }
      label274:
      m = 0;
      paramBoolean = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "onEnginePause resetFaceUI = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.c();
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.a();
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.28(this));
      this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.29(this));
    }
  }
  
  public boolean a()
  {
    return this.m;
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (baip.a(paramString)) {}
    do
    {
      return bool2;
      String str = paramString.toLowerCase();
      if ((str.startsWith("mqqapi://miniapp/open")) || (str.startsWith("mqqapi://microapp/open"))) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("AREngine_ARScanEntryView", 2, "checkUrlIsMiniAppJumpSchema, retValue is " + bool1 + ",strUrl" + paramString);
    return bool1;
  }
  
  public void b()
  {
    QLog.i("AREngine_ARScanEntryView", 1, "onStartPreviewSuccess");
    I();
    J();
    K();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "showTransferDoorGuideText textIndex = " + paramInt);
    }
    if (a(false) == null) {
      return;
    }
    this.jdField_a_of_type_Atig.a(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return (this.C) && (this.m) && (this.jdField_a_of_type_Akwn.b() == 2);
  }
  
  public void c()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onResume ");
    super.c();
    K();
    if ((!this.D) && (!this.E)) {
      g(true);
    }
    this.h = false;
    if (!this.jdField_b_of_type_Boolean) {
      u();
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
    }
    if (this.p) {
      g(true);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.o == true)
    {
      g(true);
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
      }
    }
    this.o = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Akoe != null) && (this.jdField_a_of_type_Akoe.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Akoe.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Akoe.jdField_a_of_type_Bafb.dismiss();
    }
    if ((this.jdField_a_of_type_Akoe != null) && (this.jdField_a_of_type_Akoe.jdField_a_of_type_Athi != null)) {
      this.jdField_a_of_type_Akoe.jdField_a_of_type_Athi.a();
    }
    if (this.jdField_a_of_type_Akjt != null) {
      this.jdField_a_of_type_Akjt.b();
    }
    akkz.a().a();
  }
  
  public void c(boolean paramBoolean)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "doAfterProviderViewClose isPromotionPage =  " + d() + "mHasReachEntryReady:" + this.z);
    if ((d()) || (paramBoolean) || (!this.z)) {
      e();
    }
  }
  
  public void d()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onPause ");
    g(false);
    L();
    if (this.jdField_a_of_type_Akjt != null) {
      this.jdField_a_of_type_Akjt.g();
    }
    akkz.a().e();
    this.h = true;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onPause();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
    }
    if (this.jdField_a_of_type_Akja != null) {
      this.jdField_a_of_type_Akja.dismiss();
    }
    if (this.jdField_a_of_type_Bafb != null) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    super.d();
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "showTransferDoorGuideImage show = " + paramBoolean);
    }
    if (a(true) == null) {
      return;
    }
    this.jdField_a_of_type_Atig.a(paramBoolean);
  }
  
  public void d_(String paramString)
  {
    if (this.jdField_a_of_type_Athi != null)
    {
      QLog.w("AREngine_ARScanEntryView", 1, "showErrorTips, str[" + paramString + "], isVisible[" + this.jdField_a_of_type_Athi.a() + "]", new Throwable("打印调用栈"));
      this.jdField_a_of_type_Athi.a(paramString);
    }
  }
  
  public void e()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onDestroy ");
    if (this.A) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("dc00898", "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Akyn.a().f();
    if ((this.jdField_a_of_type_Akwn != null) && (this.jdField_a_of_type_Akwn.b()))
    {
      this.jdField_a_of_type_Akwn.i();
      this.jdField_a_of_type_Akwn.j();
    }
    this.jdField_a_of_type_Akwn = null;
    akwn.r();
    akwj.a().b(this);
    if (this.jdField_a_of_type_Akjt != null)
    {
      this.jdField_a_of_type_Akjt.h();
      this.jdField_a_of_type_Akjt = null;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Alif);
    akkz.a().f();
    removeAllViews();
    this.jdField_b_of_type_AndroidViewView = null;
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof ScanTorchActivity))) {
      ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).h();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.d();
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.b();
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.s = false;
    this.t = false;
    this.u = false;
    this.K = false;
    r();
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = null;
    this.r = false;
    this.k = false;
    this.n = false;
    this.H = false;
    super.e();
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append("updateDownloadStatus, from[");
    if (!paramBoolean)
    {
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append("]!mAfterDependenceTimeout=");
      if (this.s) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AREngine_ARScanEntryView", 1, bool + ";mIsDownloadTimeout=" + this.K);
      if (((this.s) || (paramBoolean)) && (!this.K)) {
        break label101;
      }
      return;
      bool = false;
      break;
    }
    label101:
    localObject = this.jdField_a_of_type_Akyn.a();
    atik localatik = this.jdField_a_of_type_Akyn.a();
    if ((this.D) && (localatik != null)) {}
    for (bool = localatik.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);; bool = true)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "updateDownloadStatus 2222, " + ((akwq)localObject).a() + ";" + bool);
      if ((((akwq)localObject).a()) && (bool))
      {
        if ((!this.t) && (!this.u) && (!paramBoolean)) {
          break;
        }
        j();
        this.t = false;
        this.u = false;
        C();
        return;
      }
      int k;
      if (this.D) {
        if ((localatik != null) && (!localatik.a()) && (!((akwq)localObject).b())) {
          k = 1;
        }
      }
      for (;;)
      {
        QLog.d("AREngine_ARScanEntryView", 1, "updateDownloadStatus 333, " + ((akwq)localObject).b());
        if (k == 0) {
          break label406;
        }
        a("AR组件加载失败", ajjy.a(2131634953), new akxt(this, (akwq)localObject, localatik));
        this.v = true;
        this.t = true;
        C();
        if (this.w) {
          break;
        }
        this.w = true;
        awqx.b(null, "dc00898", "", "", "0X80085B5", "0X80085B5", 0, 0, "", "", "", "");
        return;
        k = 0;
        continue;
        if (!((akwq)localObject).b()) {
          k = 1;
        } else {
          k = 0;
        }
      }
      label406:
      b("updateDownloadStatus");
      this.u = true;
      return;
    }
  }
  
  public void f()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onProviderViewShow. mQQARSession mCurrentStatus:=" + this.jdField_a_of_type_Akwn.b());
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    super.f();
    K();
    D();
    if (!this.D)
    {
      J();
      g(true);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Alif);
      if (f())
      {
        this.A = true;
        Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Akjt != null) {
        this.jdField_a_of_type_Akjt.b();
      }
      akkz.a().a();
      return;
      g(false);
    }
  }
  
  public void g()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onProviderViewClose. mQQARSession mCurrentStatus:=" + this.jdField_a_of_type_Akwn.b());
    super.g();
    L();
    this.jdField_a_of_type_Akyn.a().f();
    g(false);
    E();
    j();
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.d();
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.b();
    Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Alif);
    if (this.jdField_a_of_type_Akjt != null) {
      this.jdField_a_of_type_Akjt.g();
    }
    akkz.a().e();
    this.jdField_a_of_type_Akyn.b(true);
    this.L = false;
  }
  
  public void h()
  {
    this.i = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(312);
    QLog.d("AREngine_ARScanEntryView", 1, "scanTorch notifyRenderReady " + this.jdField_d_of_type_Boolean);
    if (this.jdField_d_of_type_Boolean)
    {
      i();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(313);
    }
    if (this.jdField_a_of_type_Akwn != null) {
      this.jdField_a_of_type_Akwn.p();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
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
                    return true;
                  } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView != null);
                  paramMessage = new RelativeLayout.LayoutParams(-1, -1);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this.jdField_a_of_type_AndroidContentContext);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(awmc.jdField_a_of_type_Int);
                  this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, paramMessage);
                  this.jdField_a_of_type_AndroidOsHandler.removeMessages(352);
                } while (!e());
                g(false);
                this.q = true;
                return true;
              } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null);
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView);
              this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = null;
              if ((this.q) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(352, 2500L);
              }
              QLog.d("AREngine_ARScanEntryView", 1, "MSG_HIDE_SCAN_SUCCESS_PROGRESS,juhua has call finished ");
              return true;
            } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null);
            this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setTotalProgress(this.jdField_b_of_type_Int);
            return true;
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(313, 50L);
            this.jdField_b_of_type_Int += 1;
          } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null);
          this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setTotalProgress(this.jdField_b_of_type_Int);
          return true;
          paramMessage = (Activity)this.jdField_a_of_type_AndroidContentContext;
        } while ((!this.q) || (paramMessage.isFinishing()));
        g(true);
        return true;
        A();
        return true;
        s();
        return true;
        QLog.d("AREngine_ARScanEntryView", 1, "start AR ready");
        i(false);
        this.C = true;
        F();
        return true;
        z();
        return true;
        z();
        return true;
        z();
        return true;
        z();
        return true;
      } while (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onPause();
      return true;
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_d_of_type_AndroidWidgetTextView != null)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString.replace("\\n", "\n"));
      }
    } while ((this.D) || (this.E) || (this.jdField_d_of_type_AndroidWidgetTextView == null));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    return true;
  }
  
  public void i()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "scanTorch notifyRenderReady isNotifyRecivied " + this.i);
    if (Build.VERSION.SDK_INT >= 16)
    {
      a();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      akkz.a().b(6);
    }
    for (;;)
    {
      if (this.i)
      {
        xaw.b();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      }
      return;
      HashMap localHashMap = new HashMap();
      localHashMap.put("ar_model", Build.MODEL);
      localHashMap.put("ar_type", "3");
      localHashMap.put("ar_reason", "1");
      awrn.a(BaseApplication.getContext()).a("", "AndroidARException", true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Athi != null)
    {
      Throwable localThrowable = null;
      if (this.jdField_a_of_type_Athi.a()) {
        localThrowable = new Throwable("打印调用栈");
      }
      QLog.w("AREngine_ARScanEntryView", 1, "hideTips", localThrowable);
      this.jdField_a_of_type_Athi.a();
    }
  }
  
  public void k()
  {
    e(false);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.d("AREngine_ARScanEntryView", 1, "onAttachedToWindow ");
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext;
    label312:
    label459:
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131311554: 
      ((ScanTorchActivity)localObject1).a(false);
      return;
    case 2131311819: 
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARScanEntryView", 2, "onClick R.id.touch_view");
      }
      if ((this.jdField_a_of_type_Akmy != null) && (this.jdField_a_of_type_Akmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Akmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
      {
        if (this.jdField_a_of_type_Akmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) {
          break label503;
        }
        awqx.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_Akmy.a.jdField_b_of_type_JavaLangString, "0", "1", "");
        if (this.jdField_a_of_type_Akmy.a.c()) {
          awqx.b(null, "CliOper", "", "", "0X80098D0", "0X80098D0", 0, 0, this.jdField_a_of_type_Akmy.a.jdField_b_of_type_JavaLangString, "1", "0", "");
        }
        paramView = this.jdField_a_of_type_Akmy.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
        ((ScanTorchActivity)localObject1).setResult(11);
        akkz.a().b(3);
        if (!a(paramView)) {
          break label459;
        }
        localObject1 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject1).setData(Uri.parse(paramView));
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).addCategory("android.intent.category.DEFAULT");
        ((Intent)localObject1).setPackage(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        this.p = true;
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Akmy != null) && (!this.jdField_a_of_type_Akmy.a.d())) {
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Akmy.a.jdField_b_of_type_JavaLangString, "2");
        }
        y();
        if ((this.jdField_a_of_type_Akmy == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Akmy.a.jdField_b_of_type_JavaLangString))) {
          break;
        }
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069D1", "0X80069D1", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Akmy.a.jdField_b_of_type_JavaLangString, "");
        return;
        localObject2 = new Intent((Context)localObject1, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_sacan");
        ((Intent)localObject2).putExtra("url", a(paramView));
        ((ScanTorchActivity)localObject1).startActivity((Intent)localObject2);
        break label312;
        label503:
        awqx.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_Akmy.a.jdField_b_of_type_JavaLangString, "0", "0", "");
        this.o = true;
        g(false);
        v();
        w();
        if (this.jdField_a_of_type_Akwn != null)
        {
          this.jdField_a_of_type_Akwn.a(1L);
          this.jdField_a_of_type_Akwn.l();
        }
        i();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "find button clicked what2scanUrl = " + this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("dc00898", "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8008615", "0X8008615", 0, 0, "", "", "", "");
    paramView = alig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.b();
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "isPendulumRunning runiing");
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    if (paramView.getBoolean("key_show_reddot", false))
    {
      localObject2 = a(NetConnInfoCenter.getServerTimeMillis());
      paramView.edit().putString("key_click_reddot_date", (String)localObject2).commit();
      paramView.edit().putBoolean("key_show_reddot", false).commit();
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "isPendulumRunning KEY_SHOW_REDDOT true");
      }
    }
    try
    {
      paramView = this.jdField_c_of_type_JavaLangString;
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        paramView = "https://ti.qq.com/arinfo/index.html?_nav_alpha=true";
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "find button clicked jumpurl  = " + paramView);
      }
      localObject2 = new Intent((Context)localObject1, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_sacan");
      ((Intent)localObject2).putExtra("url", paramView);
      ((Intent)localObject2).putExtra("finish_animation_up_down", false);
      ((ScanTorchActivity)localObject1).startActivity((Intent)localObject2);
      return;
    }
    catch (Exception paramView)
    {
      QLog.e("AREngine_ARScanEntryView", 1, "find button clicked start QQBrowserActivity catch an Exception.", paramView);
    }
  }
  
  public void setRectAreas(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    paramRect = (ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    paramRect.setMargins(paramRect.leftMargin, this.jdField_a_of_type_AndroidGraphicsRect.bottom + aciy.a(30.0F, getResources()), paramRect.rightMargin, paramRect.bottomMargin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView
 * JD-Core Version:    0.7.0.1
 */