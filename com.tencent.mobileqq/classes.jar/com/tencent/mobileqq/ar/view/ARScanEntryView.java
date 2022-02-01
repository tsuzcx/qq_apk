package com.tencent.mobileqq.ar.view;

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
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.ARTransparentWebviewPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARGlobalRemoteManager;
import com.tencent.mobileqq.ar.ARLBSPOIDialog;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderTrackInfo;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.DrawView2.FaceData;
import com.tencent.mobileqq.ar.FaceUIController;
import com.tencent.mobileqq.ar.ObjectSurfaceView;
import com.tencent.mobileqq.ar.ScanningSurfaceView;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult.POIInfo;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalRecogResultBase;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.MIGObjectSearchResult;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.ar.model.CameraProxy.CameraOperationStatusCallBack;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate.ARBaseResDownLoadCallBack;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack;
import com.tencent.mobileqq.ar.model.UniformGLRenderManager;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.ButtonClickListener;
import com.tencent.mobileqq.olympic.activity.PromotionGuide;
import com.tencent.mobileqq.olympic.activity.PromotionGuide.OnPromotionStatusListener;
import com.tencent.mobileqq.olympic.activity.PromotionRes;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class ARScanEntryView
  extends ScanEntryProviderView
  implements Handler.Callback, View.OnClickListener, AREngineCallback, CameraProxy.CameraOperationStatusCallBack, PromotionGuide.OnPromotionStatusListener
{
  private boolean A = false;
  private boolean B = false;
  private boolean C = true;
  private boolean D = false;
  private boolean E = false;
  private boolean F = false;
  private boolean G = false;
  private boolean H;
  private boolean I = false;
  private boolean J = false;
  private boolean K = false;
  private boolean L;
  private boolean M = false;
  public int a;
  long jdField_a_of_type_Long = -1L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new ARScanEntryView.1(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ARScanEntryView.2(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public FrameLayout a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private ARLBSPOIDialog jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog = null;
  ARTransferDoorLogicManager jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
  private ARVideoRecordViewProxy jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy;
  private ARTarget jdField_a_of_type_ComTencentMobileqqArARTarget = null;
  FaceUIController jdField_a_of_type_ComTencentMobileqqArFaceUIController;
  public ObjectSurfaceView a;
  public ScanningSurfaceView a;
  private volatile ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  private QQARSession jdField_a_of_type_ComTencentMobileqqArModelQQARSession;
  private ScanEntryResourceDelegate.ARBaseResDownLoadCallBack jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$ARBaseResDownLoadCallBack = new ARScanEntryView.3(this);
  private ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate$AsyncFaceResDownloadCallBack = new ARScanEntryView.4(this);
  private ArMapObserver jdField_a_of_type_ComTencentMobileqqArmapArMapObserver = new ARScanEntryView.5(this);
  public ScanSuccessView a;
  private ARTipsManager jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager;
  private PromotionGuide jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide = null;
  private ScanIconAnimateView jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private MapView jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView = null;
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
  public String b;
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = -1L;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public TextView c;
  public String c;
  boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = false;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  boolean jdField_g_of_type_Boolean = false;
  volatile boolean h = false;
  volatile boolean i = false;
  boolean j;
  private boolean n;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private volatile boolean z = true;
  
  public ARScanEntryView(Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    super(paramContext, paramScanEntryContainerViewListener);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("checkArDependenceReady time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.jdField_c_of_type_Long) }));
    }
    boolean bool1 = ARDeviceController.a().a();
    boolean bool2 = ARDeviceController.a().b();
    QLog.i("AREngine_ARScanEntryView", 1, "checkArDependenceReady. isAREnable = " + bool1 + ", isSupportAr = " + bool2 + ", mIsArSoReady = " + false + ", mIsVideoPluginReady = " + false);
    ScanEntryResourceDelegate localScanEntryResourceDelegate = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    if ((bool1) && (bool2) && (localScanEntryResourceDelegate.a(2)) && (localScanEntryResourceDelegate.a(8)) && (!this.s))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession != null) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.c()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.d()) {
          q();
        }
        if ((this.m) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.d()) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.c()) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.b() == 1)) {
          this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.g();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a() != null) {
        if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().isEnableVideoRecord != 1L) {
          break label337;
        }
      }
    }
    label337:
    for (bool1 = true;; bool1 = false)
    {
      ARVideoRecordUIControllerImpl.a().a(bool1);
      QLog.d("AREngine_ARScanEntryView", 1, String.format("checkARVideoRecordEnable enable=%s", new Object[] { Boolean.valueOf(bool1) }));
      if ((!this.I) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(321)))
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
      this.jdField_b_of_type_JavaLangRunnable = new ARScanEntryView.38(this);
      QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck");
    }
    this.L = false;
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
      QLog.d("AREngine_ARScanEntryView", 2, String.format("addTimeoutCheck mArEnabled=%s mHasCallRemoveTimeoutCheck=%s", new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.M) }));
    }
    if (this.M) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new ARScanEntryView.39(this);
    }
    long l1 = l2;
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a() != null)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().mARNoResultCheckTime;
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
    this.M = true;
    this.v = false;
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
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession);
    }
    PromotionRes localPromotionRes = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    if (localPromotionRes != null) {
      localPromotionRes.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.A = true;
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
    if ((!this.t) || (this.L)) {}
    while (!this.v) {
      return;
    }
    b("updateDownloadProgress");
  }
  
  private void I()
  {
    QLog.i("AREngine_ARScanEntryView", 1, "checkReadyToStartARSession = " + this.m);
    if ((this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession != null) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.d()) && (this.m)) {
      this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.a();
    }
  }
  
  private void J() {}
  
  private void K()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "checkIfNeedAutoFocus isCameraPrviewing=" + CameraProxy.a().b() + ";mIsResumed=" + this.m);
    if ((CameraProxy.a().b()) && (this.m)) {
      CameraProxy.a().a(UniformGLRenderManagerImpl.jdField_a_of_type_Int, UniformGLRenderManagerImpl.jdField_b_of_type_Int);
    }
  }
  
  private void L()
  {
    QLog.i("AREngine_ARScanEntryView", 1, "stopAutoFoucus ");
    CameraProxy.a().a();
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
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView = new MapView(this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings() != null)
      {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings().setLogoPosition(0);
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings().setScaleViewEnabled(false);
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings().setScrollGesturesEnabled(false);
      }
      TencentMap localTencentMap = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap();
      localTencentMap.setOnCameraChangeListener(new ARScanEntryView.36(this));
      localTencentMap.setOnMapLoadedCallback(new ARScanEntryView.37(this));
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
  
  private void a(ARCloudLBSLocationCheckResult.POIInfo paramPOIInfo, ArLBSActivity paramArLBSActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog = new ARLBSPOIDialog((Activity)this.jdField_a_of_type_AndroidContentContext, a(), this);
      this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog.setOnDismissListener(new ARScanEntryView.35(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog.a();
    this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog.a(paramPOIInfo, paramArLBSActivity);
  }
  
  private String b(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append("&_wv=");
    paramString.append(17367040);
    return paramString.toString();
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
          this.jdField_f_of_type_JavaLangString = localARScanAR.j;
          this.jdField_e_of_type_JavaLangString = localARScanAR.jdField_f_of_type_JavaLangString;
        }
      }
    }
    if (!this.E)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(325);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(325);
    }
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
    if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("NoLimitParams", true)) {
      a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo, this.jdField_a_of_type_AndroidOsBundle.getLong("recognitionMask", 0L));
    }
    paramARCommonConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    ThreadManager.postImmediately(new ARScanEntryView.8(this, this.jdField_b_of_type_Long, paramARCommonConfigInfo), null, false);
  }
  
  private void b(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity)
  {
    if (paramArLBSActivity == null) {
      new ArLBSActivity();
    }
    do
    {
      return;
      if (paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int == 0)
      {
        if (paramARCloudLBSLocationCheckResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult$POIInfo == null)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramArLBSActivity.jdField_f_of_type_JavaLangString, 1).a();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.h();
        g(false);
        a(paramARCloudLBSLocationCheckResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult$POIInfo, paramArLBSActivity);
        return;
      }
      if (paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.g();
        g(false);
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, paramArLBSActivity.g, paramArLBSActivity.h, HardCodeUtil.a(2131700826), HardCodeUtil.a(2131700818), new ARScanEntryView.32(this), new ARScanEntryView.33(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new ARScanEntryView.34(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    } while (paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int != -1);
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
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a() != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().b();
    }
    return true;
  }
  
  /* Error */
  private boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 412	com/tencent/mobileqq/ar/view/ARScanEntryView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4: invokestatic 802	com/tencent/mobileqq/armap/ArMapUtil:a	(Lmqq/app/AppRuntime;)Landroid/content/SharedPreferences;
    //   7: astore 4
    //   9: aload 4
    //   11: ldc_w 804
    //   14: iconst_0
    //   15: invokeinterface 807 3 0
    //   20: istore_1
    //   21: aload_0
    //   22: invokespecial 809	com/tencent/mobileqq/ar/view/ARScanEntryView:g	()Z
    //   25: ifne +51 -> 76
    //   28: aload_0
    //   29: getfield 412	com/tencent/mobileqq/ar/view/ARScanEntryView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   32: getstatic 812	com/tencent/mobileqq/armap/ArMapConstant:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   35: invokevirtual 818	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   38: checkcast 820	com/tencent/mobileqq/armap/ArMapHandler
    //   41: astore 5
    //   43: aload 4
    //   45: ldc_w 822
    //   48: lconst_0
    //   49: invokeinterface 823 4 0
    //   54: lstore_2
    //   55: aload 5
    //   57: ifnull +19 -> 76
    //   60: aload 5
    //   62: aload_0
    //   63: getfield 412	com/tencent/mobileqq/ar/view/ARScanEntryView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   66: invokevirtual 826	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   69: invokestatic 830	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: lload_2
    //   73: invokevirtual 833	com/tencent/mobileqq/armap/ArMapHandler:a	(JJ)V
    //   76: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +29 -> 108
    //   82: ldc 228
    //   84: iconst_2
    //   85: new 264	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 835
    //   95: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: iload_1
    //   99: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: iload_1
    //   109: ireturn
    //   110: astore 4
    //   112: aload 4
    //   114: invokevirtual 838	java/lang/Exception:printStackTrace	()V
    //   117: ldc 228
    //   119: iconst_1
    //   120: ldc_w 840
    //   123: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: iload_1
    //   127: ireturn
    //   128: astore 4
    //   130: goto -54 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	ARScanEntryView
    //   20	107	1	bool	boolean
    //   54	19	2	l	long
    //   7	37	4	localSharedPreferences	SharedPreferences
    //   110	3	4	localException	Exception
    //   128	1	4	localNumberFormatException	java.lang.NumberFormatException
    //   41	20	5	localArMapHandler	com.tencent.mobileqq.armap.ArMapHandler
    // Exception table:
    //   from	to	target	type
    //   28	43	110	java/lang/Exception
    //   60	76	128	java/lang/NumberFormatException
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("setHaveEdge flag=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.K == paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "edge show equal so refuse");
      }
      return;
    }
    this.K = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().a(paramBoolean, 0.0F, 1.0F);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, String.format("setHaveEdge do real call flag=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.10(this, paramBoolean));
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.b(paramBoolean);
    f(paramBoolean);
  }
  
  private boolean g()
  {
    boolean bool2 = false;
    String str1 = ArMapUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).getString("key_click_reddot_date", null);
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
      this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.11(this));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.12(this));
  }
  
  private void i(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget == null) || (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) {
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
      }
      if (this.J)
      {
        this.J = false;
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.bottomMargin = AIOUtils.a(170.0F, getResources());
        localLayoutParams.addRule(13, 0);
      }
    } while (!paramBoolean);
    AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069D2", "0X80069D2", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "", "");
  }
  
  private void n()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377356));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131379451));
    UniformUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379452));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379454));
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("Title");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131700820));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362956));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131381861));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365355));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131700822));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView = ((ScanIconAnimateView)findViewById(2131365358));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.setPopUpListener(new ARScanEntryView.7(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366996));
    localObject = (ViewStub)findViewById(2131362953);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy = new ARVideoRecordViewProxy(findViewById(2131362979));
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362949));
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager = new ARTransferDoorLogicManager();
      localObject = (ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext;
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (ScanTorchActivity)localObject, this.jdField_c_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView = this;
    }
    if (this.E) {
      G();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("initView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
  
  private void o()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    ARVideoRecordUIControllerImpl.a().a(localActivity);
    ARVideoRecordUIControllerImpl.a().a(localActivity);
    ARVideoRecordUIControllerImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy);
  }
  
  private void p()
  {
    if (!QQARSession.b())
    {
      QLog.d("AREngine_ARScanEntryView", 1, "ARScanEntryView onCreate error happen");
      return;
    }
    QQARSession localQQARSession = QQARSession.a();
    this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession = localQQARSession;
    this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession = localQQARSession;
    this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  private void q()
  {
    if (this.s) {
      return;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    ARScanStarFaceConfigInfo localARScanStarFaceConfigInfo = ARGlobalRemoteManager.a(localActivity).a();
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession != null) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.c()))
        {
          long l = System.currentTimeMillis();
          k = this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.a(false, this.C, this.E, false, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo, null, localARScanStarFaceConfigInfo, this, localActivity, this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager, this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a());
          ARReport.a().a(System.currentTimeMillis() - l, k);
          if ((k != 0) || (!this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.d())) {
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
      this.s = true;
      return;
      QLog.e("AREngine_ARScanEntryView", 1, String.format("initAr fail. result=%s", new Object[] { Integer.valueOf(k) }));
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide.a(null);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide = null;
    }
  }
  
  private void s()
  {
    if (this.I) {}
    long l;
    do
    {
      return;
      this.I = true;
      l = System.currentTimeMillis();
      ViewStub localViewStub = (ViewStub)findViewById(2131362946);
      if (localViewStub != null)
      {
        localViewStub.inflate();
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView = ((ScanningSurfaceView)super.findViewById(2131377489));
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqArFaceUIController = new FaceUIController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager);
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.jdField_a_of_type_ComTencentMobileqqArFaceUIController = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController;
        this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView = ((ObjectSurfaceView)super.findViewById(2131372465));
        this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqArFaceUIController = new FaceUIController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager);
        this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.jdField_a_of_type_ComTencentMobileqqArFaceUIController = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController;
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131381981));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379187));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379188));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379189));
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131379737));
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).getWebView(null);
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
      ARReport.a().a(System.currentTimeMillis() - l);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, String.format("lazyInitWebView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
    }
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("showViewFinder mHasViewFinderShow=%s isPause=%s", new Object[] { Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.l) }));
    }
    if ((this.jdField_c_of_type_Boolean) || (this.l)) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      while (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        int k = AIOUtils.a(15.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2131167305);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(k, k, k, 0);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.bottomMargin = AIOUtils.a(170.0F, getResources());
        if (this.J)
        {
          this.J = false;
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845934);
    int k = AIOUtils.a(15.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.a(170.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(k, k, k, AIOUtils.a(7.0F, getResources()));
    if (this.J)
    {
      this.J = false;
      localLayoutParams.addRule(13, 0);
    }
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "showTouchView");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a != null)) {
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
      b_(HardCodeUtil.a(2131700821));
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299166);
  }
  
  public PromotionConfigInfo.PromotionItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().a();
  }
  
  public PromotionGuide a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "getPromotionGuide create = " + paramBoolean);
    }
    if (!this.m) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide == null) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide = new PromotionGuide((Activity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide.a(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide;
  }
  
  public String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("https")) || (paramString.startsWith("http"))) {
      return paramString;
    }
    return "https://" + paramString;
  }
  
  public void a()
  {
    QLog.d("AREngine_ARScanEntryView", 2, "ARTransferDoorLogicManager onRenderManagerStarted");
    if ((this.m) && (this.F) && (this.D))
    {
      QLog.d("AREngine_ARScanEntryView", 2, "start for next Time");
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.e();
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(null);
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
      if (localScanTorchActivity.jdField_b_of_type_Long < 0L) {
        localScanTorchActivity.jdField_b_of_type_Long = System.currentTimeMillis();
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
  
  public void a(int paramInt1, ARTarget paramARTarget, int paramInt2)
  {
    if ((paramARTarget == null) || (paramARTarget.a == null))
    {
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, arTarget == null || arTarget.arResourceInfo == null");
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, remainCount " + paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, new Object[] { "onARAnimationStateChanged, mLastArAnimState=", Integer.valueOf(this.jdField_a_of_type_Int), ", newState=", paramInt1 + ", target=" + paramARTarget });
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
        this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramARTarget;
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.22(this, paramARTarget));
        for (paramInt2 = 100;; paramInt2 = 100)
        {
          try
          {
            switch (paramARTarget.a.jdField_d_of_type_Int)
            {
            case 0: 
              ReportController.b(null, "CliOper", "", "", "0X80081DF", "0X80081DF", 0, 0, paramARTarget.a.jdField_b_of_type_JavaLangString, String.valueOf(paramInt2), String.valueOf(k), "");
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              QLog.d("AREngine_ARScanEntryView", 1, "0X80081DF ReportController  error " + localException1.getMessage());
            }
            AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069CC", "0X80069CC", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.a.jdField_b_of_type_JavaLangString, "2");
          }
          if ((paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (!paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean)) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.23(this, paramARTarget));
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
          return;
          if (paramARTarget.a.j())
          {
            paramInt2 = 3;
            break label1349;
          }
          if (!paramARTarget.a.d()) {
            break label1349;
          }
          paramInt2 = 0;
          break label1349;
          if (paramARTarget.a.j())
          {
            paramInt2 = 1;
            break label1355;
          }
          if (!paramARTarget.a.i()) {
            break label1355;
          }
          paramInt2 = 5;
          break label1355;
          if (paramARTarget.a.d())
          {
            paramInt2 = 2;
            break label1361;
          }
          bool = paramARTarget.a.j();
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
      this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramARTarget;
      if (!paramARTarget.a.d()) {
        AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8008144", "0X8008144", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.a.jdField_b_of_type_JavaLangString, "2");
      }
      if ((paramARTarget.a.jdField_d_of_type_Int != 0) && (paramARTarget.a.jdField_d_of_type_Int != 5))
      {
        m = ARVideoUtil.a(paramARTarget);
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
            switch (paramARTarget.a.jdField_d_of_type_Int)
            {
            case 0: 
              label700:
              ReportController.b(null, "CliOper", "", "", "0X80081E1", "0X80081E1", 0, 0, paramARTarget.a.jdField_b_of_type_JavaLangString, String.valueOf(k), String.valueOf(m), "");
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
          if ((paramARTarget.a.jdField_a_of_type_Int != 0) && ((paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (TextUtils.isEmpty(paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))) {
            break label999;
          }
          bool = true;
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.24(this, paramARTarget, paramInt2, bool));
          AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069CF", "0X80069CF", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.a.jdField_b_of_type_JavaLangString, "");
          break;
          if (paramARTarget.a.j())
          {
            k = 3;
            break label1377;
          }
          if (!paramARTarget.a.d()) {
            break label1377;
          }
          k = 0;
          break label1377;
          if (paramARTarget.a.j())
          {
            k = 1;
            break label1383;
          }
          if (!paramARTarget.a.i()) {
            break label1383;
          }
          k = 5;
          break label1383;
          if (paramARTarget.a.d())
          {
            k = 2;
            break label1389;
          }
          bool = paramARTarget.a.j();
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
        switch (paramARTarget.a.jdField_d_of_type_Int)
        {
        case 0: 
          ReportController.b(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramARTarget.a.jdField_b_of_type_JavaLangString, String.valueOf(paramInt2), String.valueOf(k), "");
        }
      }
      catch (Exception localException3)
      {
        QLog.d("AREngine_ARScanEntryView", 1, "0X80081E1 ReportController  error " + localException3.getMessage());
        continue;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
      this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.25(this));
      AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069D0", "0X80069D0", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.a.jdField_b_of_type_JavaLangString, "");
      break;
      if (paramARTarget.a.j())
      {
        paramInt2 = 3;
      }
      else if (paramARTarget.a.d())
      {
        paramInt2 = 0;
        break label1404;
        if (paramARTarget.a.j())
        {
          paramInt2 = 1;
          break label1410;
        }
        if (!paramARTarget.a.i()) {
          break label1410;
        }
        paramInt2 = 5;
        break label1410;
        if (paramARTarget.a.d())
        {
          paramInt2 = 2;
          break label1416;
        }
        bool = paramARTarget.a.j();
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
        this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.26(this));
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
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.28(this, paramString));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
  }
  
  public void a(long paramLong, int paramInt, ARRenderTrackInfo paramARRenderTrackInfo, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    E();
    if ((paramLong == 128L) && ((paramARLocalRecogResultBase instanceof ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)))
    {
      paramARLocalRecogResultBase = (ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)paramARLocalRecogResultBase;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 1, " externalRenderResult info is isValidData=" + paramARLocalRecogResultBase.jdField_a_of_type_Boolean + "isNeedShowViewFinder " + paramARLocalRecogResultBase.jdField_b_of_type_Boolean);
      }
      if (!paramARLocalRecogResultBase.jdField_a_of_type_Boolean)
      {
        this.z = false;
        h(paramARLocalRecogResultBase.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.13(this));
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
              if (paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult == null) {
                break;
              }
              paramARRenderTrackInfo = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_AndroidGraphicsRectF.toString();
              QLog.d("AREngine_MIGObjectClassifyResult", 1, paramARRenderTrackInfo);
            }
            h(false);
          } while (paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult == null);
          Object localObject = new DrawView2.FaceData();
          ((DrawView2.FaceData)localObject).jdField_a_of_type_Float = 99.0F;
          ((DrawView2.FaceData)localObject).jdField_c_of_type_JavaLangString = (HardCodeUtil.a(2131700819) + (int)(paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_Double * 100.0D) + "%");
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_MIGObjectClassifyResult", 1, " scantorch activitity result ok " + paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_Double);
          }
          ((DrawView2.FaceData)localObject).jdField_a_of_type_Int = 10;
          ((DrawView2.FaceData)localObject).jdField_a_of_type_AndroidGraphicsRectF = DrawView2.FaceData.a(paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_AndroidGraphicsRectF);
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_MIGObjectClassifyResult", 1, "MIG mapMigObjectRect2Screen(协议转化后的数据) object RectF " + ((DrawView2.FaceData)localObject).jdField_a_of_type_AndroidGraphicsRectF);
          }
          ((DrawView2.FaceData)localObject).jdField_a_of_type_ArrayOfFloat = null;
          ((DrawView2.FaceData)localObject).h = null;
          ((DrawView2.FaceData)localObject).jdField_c_of_type_Boolean = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_b_of_type_Boolean;
          ((DrawView2.FaceData)localObject).jdField_d_of_type_Boolean = false;
          ((DrawView2.FaceData)localObject).jdField_a_of_type_Boolean = true;
          ((DrawView2.FaceData)localObject).jdField_b_of_type_Boolean = true;
          ((DrawView2.FaceData)localObject).jdField_e_of_type_Boolean = false;
          ((DrawView2.FaceData)localObject).jdField_a_of_type_JavaLangString = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_JavaLangString;
          if (TextUtils.isEmpty(paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_b_of_type_JavaLangString))
          {
            paramARRenderTrackInfo = " ";
            ((DrawView2.FaceData)localObject).jdField_d_of_type_JavaLangString = paramARRenderTrackInfo;
            if (!TextUtils.isEmpty(paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_c_of_type_JavaLangString)) {
              break label634;
            }
            paramARRenderTrackInfo = " ";
            ((DrawView2.FaceData)localObject).jdField_e_of_type_JavaLangString = paramARRenderTrackInfo;
            ((DrawView2.FaceData)localObject).jdField_b_of_type_JavaLangString = null;
            ((DrawView2.FaceData)localObject).jdField_f_of_type_JavaLangString = null;
            ((DrawView2.FaceData)localObject).g = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_d_of_type_JavaLangString;
            if (QLog.isColorLevel())
            {
              QLog.d("AREngine_ARScanEntryView", 1, " label name is " + ((DrawView2.FaceData)localObject).jdField_a_of_type_JavaLangString + "isAutoJump " + ((DrawView2.FaceData)localObject).jdField_c_of_type_Boolean);
              if (TextUtils.isEmpty(paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_c_of_type_JavaLangString)) {
                QLog.d("AREngine_ARScanEntryView", 1, " profileContent    null  ");
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView == null) {
              break label647;
            }
            this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.14(this));
          }
          for (;;)
          {
            paramARRenderTrackInfo = new ArrayList();
            paramARRenderTrackInfo.add(localObject);
            this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.setFaceData(paramARRenderTrackInfo);
            return;
            paramARRenderTrackInfo = "error happen";
            break;
            paramARRenderTrackInfo = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_b_of_type_JavaLangString;
            break label432;
            paramARRenderTrackInfo = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_c_of_type_JavaLangString;
            break label458;
            QLog.d("AREngine_ARScanEntryView", 1, " scanningSurfaceView not ready ");
          }
          if (paramLong != 4L) {
            break;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqArFaceUIController != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null))
          {
            int k = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
            if ((k != 3) && (k != 2) && (k != 0)) {
              j();
            }
          }
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARScanEntryView", 2, "onARTrackComplete, recogType = " + paramLong + ",trackMode = " + paramInt + ",trackResult = " + paramARRenderTrackInfo + ",localRecogResult = " + paramARLocalRecogResultBase + ",isPause = " + this.i);
          }
        } while ((this.i) || (paramLong != 4L) || (!(paramARLocalRecogResultBase instanceof ARLocalFaceRecogResult)));
        paramARRenderTrackInfo = (ARLocalFaceRecogResult)paramARLocalRecogResultBase;
      } while (paramARRenderTrackInfo == null);
      paramARLocalRecogResultBase = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if ((paramARRenderTrackInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramARRenderTrackInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
      for (;;)
      {
        if (!paramARRenderTrackInfo.jdField_a_of_type_Boolean) {
          break label994;
        }
        this.h = false;
        if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.c();
          this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.a();
          this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.16(this));
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.17(this));
        return;
        j();
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqArFaceUIController != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!paramARLocalRecogResultBase.isFinishing())) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.15(this));
        }
      }
      if (!this.h)
      {
        this.h = true;
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.18(this));
      }
      if (this.jdField_a_of_type_Long < 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView == null);
    label647:
    label994:
    if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.19(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.setFaceData(paramARRenderTrackInfo.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(long paramLong, ARTarget paramARTarget)
  {
    E();
    j();
    if ((paramARTarget == null) || (paramARTarget.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 1, "onARRecogComplete empty value");
      }
    }
    for (;;)
    {
      return;
      if (!this.H) {}
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.a();
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
      this.H = true;
      if (!paramARTarget.a.f()) {
        if ((paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.9(this, paramARTarget));
          if (!this.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(306);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageAtTime(313, 100L);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
          }
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 1, "onARRecogComplete start jump :" + paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
          }
        }
        else if ((paramARTarget.a.jdField_d_of_type_Int == 6) && (paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (!paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
        {
          ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, paramARTarget.a.jdField_b_of_type_JavaLangString, "1", "0", "");
          paramARTarget = paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
          localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
          if (a(paramARTarget))
          {
            localIntent = new Intent("android.intent.action.VIEW");
            localIntent.setData(Uri.parse(paramARTarget));
            localIntent.addFlags(268435456);
            localIntent.addCategory("android.intent.category.DEFAULT");
            localIntent.setPackage(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getPackageName());
            this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          }
          while ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
          {
            ((Activity)localObject).overridePendingTransition(2130771999, 0);
            return;
            localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
            localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
            localIntent.putExtra("url", paramARTarget);
            localIntent.putExtra("finish_animation_up_down", true);
            ((Activity)localObject).startActivity(localIntent);
          }
        }
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, ARTarget paramARTarget)
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
        switch (paramARTarget.a.jdField_d_of_type_Int)
        {
        case 0: 
          ReportController.b(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramARTarget.a.jdField_b_of_type_JavaLangString, String.valueOf(k), String.valueOf(m), "");
        }
      }
      catch (Exception localException)
      {
        QLog.d("AREngine_ARScanEntryView", 1, "0X80081E0 ReportController  error " + localException.getMessage());
        continue;
        g(true);
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.20(this));
        return;
      }
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsValue(Integer.valueOf(0))) || (!paramARTarget.a.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "onARStateChanged, AR_RECOG_STATE_LOST in");
        }
        if (this.p != true) {}
      }
      else
      {
        return;
        if (paramARTarget.a.j())
        {
          k = 3;
          break label433;
        }
        if (!paramARTarget.a.d()) {
          break label433;
        }
        k = 0;
        break label433;
        if (paramARTarget.a.j())
        {
          k = 1;
          break label439;
        }
        if (!paramARTarget.a.i()) {
          break label439;
        }
        k = 5;
        break label439;
        if (paramARTarget.a.d())
        {
          k = 2;
          break label445;
        }
        paramBoolean = paramARTarget.a.j();
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
      if ((paramARTarget.a.jdField_a_of_type_Int == 1) && (paramARTarget.a.e == 0)) {}
      for (k = 1; (k == 0) || (paramARTarget.a.d()); k = 0)
      {
        g(false);
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.21(this));
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
  
  public void a(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("downloadItems", 14L);
    this.E = this.jdField_a_of_type_AndroidOsBundle.getBoolean("arTransferPromotion", false);
    this.C = this.jdField_a_of_type_AndroidOsBundle.getBoolean("enableARCloud", true);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      paramBundle = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561098, this, false);
      addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
      n();
      o();
      this.jdField_b_of_type_AndroidViewView = paramBundle;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager = new ARTipsManager(this.jdField_a_of_type_AndroidContentContext, (RelativeLayout)this.jdField_b_of_type_AndroidViewView, new ARScanEntryView.6(this));
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
    p();
    CameraProxy.a().a(this);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
    this.A = false;
    this.k = true;
  }
  
  public void a(PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "loadTransferDoorGuide ");
    }
    PromotionGuide localPromotionGuide = a(true);
    if (localPromotionGuide == null) {
      return;
    }
    localPromotionGuide.a(paramPromotionItem);
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
  
  public void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity)
  {
    QLog.d("AREngine_ARScanEntryView", 2, "onLBSLocationComplete. retCode = " + paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int + ", LBSActivity = " + paramArLBSActivity);
    ThreadManager.getUIHandler().post(new ARScanEntryView.31(this, paramARCloudLBSLocationCheckResult, paramArLBSActivity));
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.27(this, paramARRenderMangerInnerCallback, paramArVideoResourceInfo));
  }
  
  public void a(String paramString, PromotionConfigInfo.PromotionItem paramPromotionItem, boolean paramBoolean)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "tryToEnterTransferMode[" + paramString + "], mIsTransferDoorMode[" + this.F + "], ready[" + paramBoolean + "]");
    this.F = true;
    this.E = true;
    if (paramPromotionItem != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramPromotionItem.jdField_b_of_type_JavaLangString);
    }
    G();
    if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((QQARSession)this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.jdField_a_of_type_JavaLangRefWeakReference.get()).s();
    }
    if ((!paramBoolean) || (paramPromotionItem == null)) {
      return;
    }
    this.G = true;
    d(false);
    b(1);
    paramString = paramPromotionItem.a();
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(2);
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.c();
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.e();
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(paramString);
    E();
    j();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)
    {
      QLog.w("AREngine_ARScanEntryView", 1, "showTipsWithProgress, from[" + paramString1 + "], tips[" + paramString2 + "], progress[" + paramInt + "], isVisible[" + this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a() + "]");
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a(paramString2, paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, ARTipsManager.ButtonClickListener paramButtonClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "showErrorTips, str[" + paramString1 + "], isVisible[" + this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a() + "]", new Throwable("打印调用栈"));
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a(paramString1, paramString2, paramButtonClickListener);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.G) || (this.w)) && (!this.n))
    {
      QLog.w("AREngine_ARScanEntryView", 1, "showLoadProgress, 已经在穿越门里面了, from[" + paramString + "]");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    int i2 = (this.jdField_d_of_type_Int + this.jdField_c_of_type_Int) / 2;
    QLog.d("AREngine_ARScanEntryView", 1, "showLoadProgress mCurrentAsyncProgress:=" + this.jdField_d_of_type_Int + ",mCurrentSyncProgress:=" + this.jdField_c_of_type_Int);
    int k;
    label142:
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy.a()))
    {
      k = 1;
      PromotionRes localPromotionRes = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
      if ((localPromotionRes == null) || (!this.E)) {
        break label274;
      }
      paramBoolean = localPromotionRes.c();
      m = localPromotionRes.a();
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
        if (this.y) {
          break;
        }
        this.y = true;
        ReportController.b(null, "dc00898", "", "", "0X80085B6", "0X80085B6", 0, 0, "", "", "", "");
        return;
        k = 0;
        break label142;
        a(paramString, HardCodeUtil.a(2131700827), i1);
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
      this.h = false;
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.c();
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.a();
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.29(this));
      this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.30(this));
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (StringUtil.a(paramString)) {}
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
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide.a(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return (this.D) && (this.m) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.b() == 2);
  }
  
  public void b_(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)
    {
      QLog.w("AREngine_ARScanEntryView", 1, "showErrorTips, str[" + paramString + "], isVisible[" + this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a() + "]", new Throwable("打印调用栈"));
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a(paramString);
    }
  }
  
  public void c()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onResume ");
    super.c();
    K();
    if ((!this.E) && (!this.F)) {
      g(true);
    }
    this.i = false;
    if (!this.jdField_c_of_type_Boolean) {
      u();
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
    }
    if (this.q) {
      g(true);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.p == true)
    {
      g(true);
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
      }
    }
    this.p = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqArFaceUIController != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArFaceUIController != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.b();
    }
    ARVideoRecordUIControllerImpl.a().a();
  }
  
  public void c(boolean paramBoolean)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "doAfterProviderViewClose isPromotionPage =  " + d() + "mHasReachEntryReady:" + this.A);
    if ((d()) || (paramBoolean) || (!this.A)) {
      e();
    }
  }
  
  public void d()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onPause ");
    g(false);
    L();
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.g();
    }
    ARVideoRecordUIControllerImpl.a().e();
    this.i = true;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onPause();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
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
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide.a(paramBoolean);
  }
  
  public void e()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onDestroy ");
    if (this.B) {
      AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().f();
    if ((this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession != null) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.i();
      this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.j();
    }
    this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession = null;
    QQARSession.k();
    CameraProxy.a().b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.h();
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager = null;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    ARVideoRecordUIControllerImpl.a().f();
    removeAllViews();
    this.jdField_b_of_type_AndroidViewView = null;
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof ScanTorchActivity))) {
      ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).g();
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
    this.t = false;
    this.u = false;
    this.v = false;
    this.L = false;
    r();
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = null;
    this.s = false;
    this.k = false;
    this.n = false;
    this.I = false;
    super.e();
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append("updateDownloadStatus, from[");
    if (!paramBoolean)
    {
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append("]!mAfterDependenceTimeout=");
      if (this.t) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AREngine_ARScanEntryView", 1, bool + ";mIsDownloadTimeout=" + this.L);
      if (((this.t) || (paramBoolean)) && (!this.L)) {
        break label101;
      }
      return;
      bool = false;
      break;
    }
    label101:
    localObject = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    PromotionRes localPromotionRes = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    if ((this.E) && (localPromotionRes != null)) {}
    for (bool = localPromotionRes.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);; bool = true)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "updateDownloadStatus 2222, " + ((ScanEntryResourceDelegate)localObject).a() + ";" + bool);
      if ((((ScanEntryResourceDelegate)localObject).a()) && (bool))
      {
        if ((!this.u) && (!this.v) && (!paramBoolean)) {
          break;
        }
        j();
        this.u = false;
        this.v = false;
        C();
        return;
      }
      int k;
      if (this.E) {
        if ((localPromotionRes != null) && (!localPromotionRes.a()) && (!((ScanEntryResourceDelegate)localObject).b())) {
          k = 1;
        }
      }
      for (;;)
      {
        QLog.d("AREngine_ARScanEntryView", 1, "updateDownloadStatus 333, " + ((ScanEntryResourceDelegate)localObject).b());
        if (k == 0) {
          break label406;
        }
        a("AR组件加载失败", HardCodeUtil.a(2131700825), new ARScanEntryView.40(this, (ScanEntryResourceDelegate)localObject, localPromotionRes));
        this.w = true;
        this.u = true;
        C();
        if (this.x) {
          break;
        }
        this.x = true;
        ReportController.b(null, "dc00898", "", "", "0X80085B5", "0X80085B5", 0, 0, "", "", "", "");
        return;
        k = 0;
        continue;
        if (!((ScanEntryResourceDelegate)localObject).b()) {
          k = 1;
        } else {
          k = 0;
        }
      }
      label406:
      b("updateDownloadStatus");
      this.v = true;
      return;
    }
  }
  
  public void f()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onProviderViewShow. mQQARSession mCurrentStatus:=" + this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.b());
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    super.f();
    K();
    D();
    if (!this.E)
    {
      J();
      g(true);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
      if (f())
      {
        this.B = true;
        Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.b();
      }
      ARVideoRecordUIControllerImpl.a().a();
      return;
      g(false);
    }
  }
  
  public void g()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onProviderViewClose. mQQARSession mCurrentStatus:=" + this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.b());
    super.g();
    L();
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().f();
    g(false);
    E();
    j();
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.d();
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.b();
    Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.g();
    }
    ARVideoRecordUIControllerImpl.a().e();
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.b(true);
    this.M = false;
  }
  
  public void h()
  {
    this.j = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(312);
    QLog.d("AREngine_ARScanEntryView", 1, "scanTorch notifyRenderReady " + this.jdField_e_of_type_Boolean);
    if (this.jdField_e_of_type_Boolean)
    {
      i();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(313);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession != null) {
      this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.r();
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
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ScreenUtil.SCREEN_WIDTH);
                  this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, paramMessage);
                  this.jdField_a_of_type_AndroidOsHandler.removeMessages(352);
                } while (!e());
                g(false);
                this.r = true;
                return true;
              } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null);
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView);
              this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = null;
              if ((this.r) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
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
        } while ((!this.r) || (paramMessage.isFinishing()));
        g(true);
        return true;
        A();
        return true;
        s();
        return true;
        QLog.d("AREngine_ARScanEntryView", 1, "start AR ready");
        i(false);
        this.D = true;
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
      if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_d_of_type_AndroidWidgetTextView != null)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString.replace("\\n", "\n"));
      }
    } while ((this.E) || (this.F) || (this.jdField_d_of_type_AndroidWidgetTextView == null));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    return true;
  }
  
  public void i()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "scanTorch notifyRenderReady isNotifyRecivied " + this.j);
    if (Build.VERSION.SDK_INT >= 16)
    {
      a();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      ARVideoRecordUIControllerImpl.a().b(6);
    }
    for (;;)
    {
      if (this.j)
      {
        ARTransparentWebviewPlugin.b();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      }
      return;
      HashMap localHashMap = new HashMap();
      localHashMap.put("ar_model", Build.MODEL);
      localHashMap.put("ar_type", "3");
      localHashMap.put("ar_reason", "1");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidARException", true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)
    {
      Throwable localThrowable = null;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a()) {
        localThrowable = new Throwable("打印调用栈");
      }
      QLog.w("AREngine_ARScanEntryView", 1, "hideTips", localThrowable);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
    }
  }
  
  public boolean j_()
  {
    return this.m;
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
    Object localObject2 = (ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((ScanTorchActivity)localObject2).a(false);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARScanEntryView", 2, "onClick R.id.touch_view");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) {
          break label518;
        }
        ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString, "0", "1", "");
        if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.c()) {
          ReportController.b(null, "CliOper", "", "", "0X80098D1", "0X80098D1", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString, "1", "0", "");
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
        ((ScanTorchActivity)localObject2).setResult(11);
        ARVideoRecordUIControllerImpl.a().b(3);
        if (!a((String)localObject1)) {
          break label470;
        }
        localObject2 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
        ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        label321:
        this.q = true;
      }
      label470:
      Object localObject3;
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (!this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.d())) {
          AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString, "2");
        }
        y();
        if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString))) {
          break;
        }
        AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069D1", "0X80069D1", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString, "");
        break;
        localObject3 = new Intent((Context)localObject2, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_sacan");
        ((Intent)localObject3).putExtra("url", a((String)localObject1));
        ((ScanTorchActivity)localObject2).startActivity((Intent)localObject3);
        break label321;
        label518:
        ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString, "0", "0", "");
        this.p = true;
        g(false);
        v();
        w();
        if (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.a(1L);
          this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.n();
        }
        i();
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "find button clicked what2scanUrl = " + this.jdField_f_of_type_JavaLangString);
      }
      AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8008615", "0X8008615", 0, 0, "", "", "", "");
      Object localObject1 = ArMapUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.b();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "isPendulumRunning runiing");
        }
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      if (((SharedPreferences)localObject1).getBoolean("key_show_reddot", false))
      {
        localObject3 = a(NetConnInfoCenter.getServerTimeMillis());
        ((SharedPreferences)localObject1).edit().putString("key_click_reddot_date", (String)localObject3).commit();
        ((SharedPreferences)localObject1).edit().putBoolean("key_show_reddot", false).commit();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "isPendulumRunning KEY_SHOW_REDDOT true");
        }
      }
      try
      {
        localObject1 = this.jdField_f_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
          localObject1 = "https://ti.qq.com/arinfo/index.html?_nav_alpha=true";
        }
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "find button clicked jumpurl  = " + (String)localObject1);
        }
        localObject3 = new Intent((Context)localObject2, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_sacan");
        ((Intent)localObject3).putExtra("url", (String)localObject1);
        ((Intent)localObject3).putExtra("finish_animation_up_down", false);
        ((ScanTorchActivity)localObject2).startActivity((Intent)localObject3);
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARScanEntryView", 1, "find button clicked start QQBrowserActivity catch an Exception.", localException);
      }
    }
  }
  
  public void setRectAreas(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    paramRect = (ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    paramRect.setMargins(paramRect.leftMargin, this.jdField_a_of_type_AndroidGraphicsRect.bottom + AIOUtils.a(30.0F, getResources()), paramRect.rightMargin, paramRect.bottomMargin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView
 * JD-Core Version:    0.7.0.1
 */