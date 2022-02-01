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
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
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
import com.tencent.mobileqq.armap.ArMapConstant;
import com.tencent.mobileqq.armap.ArMapHandler;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkArDependenceReady. isAREnable = ");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", isSupportAr = ");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(", mIsArSoReady = ");
    ((StringBuilder)localObject).append(false);
    ((StringBuilder)localObject).append(", mIsVideoPluginReady = ");
    ((StringBuilder)localObject).append(false);
    QLog.i("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    if ((bool1) && (bool2) && (((ScanEntryResourceDelegate)localObject).a(2)) && (((ScanEntryResourceDelegate)localObject).a(8)) && (!this.s))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession;
      if ((localObject != null) && (((QQARSession)localObject).c()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.d()) {
          q();
        }
        if ((this.m) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.d()) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.c()) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.b() == 1)) {
          this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.g();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a() != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().isEnableVideoRecord == 1L) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ARVideoRecordUIControllerImpl.a().a(bool1);
        QLog.d("AREngine_ARScanEntryView", 1, String.format("checkARVideoRecordEnable enable=%s", new Object[] { Boolean.valueOf(bool1) }));
      }
      if ((!this.I) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(321)))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(321, 100L);
        QLog.d("AREngine_ARScanEntryView", 1, "checkArDependenceReady do delay initARView");
      }
    }
  }
  
  private void B()
  {
    if (this.jdField_b_of_type_JavaLangRunnable == null)
    {
      this.jdField_b_of_type_JavaLangRunnable = new ARScanEntryView.35(this);
      QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck");
    }
    this.L = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 10000L);
  }
  
  private void C()
  {
    QLog.d("AREngine_ARScanEntryView", 2, "stopDownloadTimeoutCheck");
    Runnable localRunnable = this.jdField_b_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
  }
  
  private void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("addTimeoutCheck mArEnabled=%s mHasCallRemoveTimeoutCheck=%s", new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.M) }));
    }
    if (this.M) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new ARScanEntryView.36(this);
      }
      ARCommonConfigInfo localARCommonConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
      long l2 = 8000L;
      long l1 = l2;
      if (localARCommonConfigInfo != null)
      {
        l1 = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().mARNoResultCheckTime;
        if (l1 <= 0L) {
          l1 = l2;
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l1);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    if (localObject != null) {
      ((PromotionRes)localObject).e(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
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
    if (this.t)
    {
      if (this.L) {
        return;
      }
      if (this.v) {
        b("updateDownloadProgress");
      }
    }
  }
  
  private void I()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkReadyToStartARSession = ");
    ((StringBuilder)localObject).append(this.m);
    QLog.i("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession;
    if ((localObject != null) && (((QQARSession)localObject).d()) && (this.m)) {
      this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.a();
    }
  }
  
  private void J() {}
  
  private void K()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIfNeedAutoFocus isCameraPrviewing=");
    localStringBuilder.append(CameraProxy.a().b());
    localStringBuilder.append(";mIsResumed=");
    localStringBuilder.append(this.m);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
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
      localTencentMap.setOnCameraChangeListener(new ARScanEntryView.33(this));
      localTencentMap.setOnMapLoadedCallback(new ARScanEntryView.34(this));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.setEnabled(true);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.setClickable(true);
    }
    return this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView;
  }
  
  private String a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
      this.jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      String str = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "getCurrentDateString exception", localException);
      }
    }
    return null;
  }
  
  private void a(ARCommonConfigInfo paramARCommonConfigInfo, long paramLong)
  {
    if ((paramARCommonConfigInfo.recognitions != null) && (paramARCommonConfigInfo.recognitions.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int k = 0;
      if (paramLong != 0L)
      {
        Object localObject = paramARCommonConfigInfo.recognitions.iterator();
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
        if ((k == 0) && ((paramLong & 0x1000) != 0L))
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
      this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog.setOnDismissListener(new ARScanEntryView.32(this));
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
    if (paramArLBSActivity == null)
    {
      new ArLBSActivity();
      return;
    }
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
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, paramArLBSActivity.g, paramArLBSActivity.h, HardCodeUtil.a(2131700970), HardCodeUtil.a(2131700962), new ARScanEntryView.29(this), new ARScanEntryView.30(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new ARScanEntryView.31(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    int k = paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int;
  }
  
  private void c(String paramString)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "scanTorch preLaunchToQQBrowseActivity ");
    paramString = b(paramString);
    a();
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localTouchWebView != null)
    {
      localTouchWebView.onResume();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramString);
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("NoLimitParams", true) ^ true;
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a() != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().b();
    }
    return true;
  }
  
  private boolean f()
  {
    SharedPreferences localSharedPreferences = ArMapUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    boolean bool = localSharedPreferences.getBoolean("key_show_reddot", false);
    if (!g()) {
      try
      {
        localArMapHandler = (ArMapHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(ArMapConstant.jdField_a_of_type_JavaLangString);
        l = localSharedPreferences.getLong("key_ar_act_id", 0L);
        if (localArMapHandler == null) {}
      }
      catch (Exception localException)
      {
        ArMapHandler localArMapHandler;
        long l;
        label79:
        localException.printStackTrace();
        QLog.d("AREngine_ARScanEntryView", 1, "shouldShowActRedDot  getBusinessHandler fail ");
        return bool;
      }
    }
    try
    {
      localArMapHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()), l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder;
      break label79;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldShowActRedDot  result = ");
      localStringBuilder.append(bool);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    }
    return bool;
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
    String str1 = ArMapUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).getString("key_click_reddot_date", null);
    String str2 = a(NetConnInfoCenter.getServerTimeMillis());
    boolean bool;
    if ((str1 != null) && (str1.equals(str2))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasClickedRedDotToday  result = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",curDate = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(",clickDate = ");
      localStringBuilder.append(str1);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    }
    return bool;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARTarget;
    if (localObject != null)
    {
      if (((ARTarget)localObject).a == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) {
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
      }
      if (this.J)
      {
        this.J = false;
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(170.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      }
      if (paramBoolean) {
        AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069D2", "0X80069D2", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "", "");
      }
    }
  }
  
  private void n()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376809));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131378803));
    UniformUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378804));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378806));
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("Title");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131700964));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362905));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131381073));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365221));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131700966));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView = ((ScanIconAnimateView)findViewById(2131365224));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.setPopUpListener(new ARScanEntryView.7(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366849));
    localObject = (ViewStub)findViewById(2131362902);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy = new ARVideoRecordViewProxy(findViewById(2131362928));
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362898));
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
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession != null) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.c()))
      {
        long l = System.currentTimeMillis();
        int k = this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.a(false, this.C, this.E, false, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo, null, null, this, localActivity, this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager, this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a());
        ARReport.a().a(System.currentTimeMillis() - l, k);
        if ((k == 0) && (this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.d())) {
          I();
        } else {
          QLog.e("AREngine_ARScanEntryView", 1, String.format("initAr fail. result=%s", new Object[] { Integer.valueOf(k) }));
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("AREngine_ARScanEntryView", 1, "initAr fail.", localException);
    }
    this.s = true;
  }
  
  private void r()
  {
    PromotionGuide localPromotionGuide = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide;
    if (localPromotionGuide != null)
    {
      localPromotionGuide.a(null);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide = null;
    }
  }
  
  private void s()
  {
    if (this.I) {
      return;
    }
    this.I = true;
    long l = System.currentTimeMillis();
    ViewStub localViewStub = (ViewStub)findViewById(2131362895);
    if (localViewStub != null)
    {
      localViewStub.inflate();
      this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView = ((ObjectSurfaceView)super.findViewById(2131372047));
      this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqArFaceUIController = new FaceUIController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager);
      this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.jdField_a_of_type_ComTencentMobileqqArFaceUIController = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131381185));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378550));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378551));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378552));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131379075));
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
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("lazyInitARView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
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
    if (!this.jdField_c_of_type_Boolean)
    {
      if (this.l) {
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      Object localObject = this.jdField_g_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      } else if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        int k = AIOUtils.b(15.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2131167333);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(k, k, k, 0);
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(170.0F, getResources());
        if (this.J)
        {
          this.J = false;
          ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        w();
      }
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "hideViewFinder");
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      return;
    }
    ((LinearLayout)localObject).setBackgroundResource(2130845807);
    int k = AIOUtils.b(15.0F, getResources());
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(170.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(k, k, k, AIOUtils.b(7.0F, getResources()));
    if (this.J)
    {
      this.J = false;
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
    }
    localObject = this.jdField_g_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void w()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    localTextView.setVisibility(8);
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
    ARTarget localARTarget = this.jdField_a_of_type_ComTencentMobileqqArARTarget;
    if ((localARTarget != null) && (localARTarget.a != null)) {
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "mArTarget == null || mArTarget.arResourceInfo == null");
  }
  
  private void y()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout == null) {
      return;
    }
    localFrameLayout.setVisibility(8);
  }
  
  private void z()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "handleARStartFail");
    this.n = true;
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      c_(HardCodeUtil.a(2131700965));
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  public PromotionConfigInfo.PromotionItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().a();
  }
  
  public PromotionGuide a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPromotionGuide create = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
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
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (!paramString.startsWith("https"))
      {
        if (paramString.startsWith("http")) {
          return paramString;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
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
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onARStartComplete mUIhandler null retCode ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 7)
      {
        if (paramInt != 8) {
          return;
        }
        ((Handler)localObject).sendEmptyMessage(310);
        return;
      }
      ((Handler)localObject).sendEmptyMessage(309);
      return;
    }
    localObject = (ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext;
    if (((ScanTorchActivity)localObject).jdField_b_of_type_Long < 0L) {
      ((ScanTorchActivity)localObject).jdField_b_of_type_Long = System.currentTimeMillis();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onArReady success + time is ");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onArReady success-visiable + time is ");
      localStringBuilder.append(System.currentTimeMillis() - ((ScanTorchActivity)localObject).a());
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(295);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return;
        }
        this.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(311);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      return;
    }
    g(false);
    E();
    j();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(306);
  }
  
  public void a(int paramInt1, ARTarget paramARTarget, int paramInt2)
  {
    boolean bool2 = true;
    int m;
    int k;
    int i1;
    StringBuilder localStringBuilder3;
    if ((paramARTarget != null) && (paramARTarget.a != null))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onARAnimationStateChanged, remainCount ");
      localStringBuilder1.append(paramInt2);
      QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder1.toString());
      boolean bool1 = QLog.isColorLevel();
      m = 2;
      if (bool1)
      {
        k = this.jdField_a_of_type_Int;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(paramInt1);
        localStringBuilder1.append(", target=");
        localStringBuilder1.append(paramARTarget);
        QLog.d("AREngine_ARScanEntryView", 2, new Object[] { "onARAnimationStateChanged, mLastArAnimState=", Integer.valueOf(k), ", newState=", localStringBuilder1.toString() });
      }
      k = 100;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 == 3)
            {
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
              this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.24(this));
            }
          }
          else
          {
            try
            {
              paramInt2 = paramARTarget.a.jdField_d_of_type_Int;
              if (paramInt2 != 0)
              {
                if (paramInt2 != 2)
                {
                  if (paramInt2 != 3)
                  {
                    if (paramInt2 == 4) {
                      break label1382;
                    }
                    i1 = m;
                    paramInt2 = k;
                  }
                  else
                  {
                    if (paramARTarget.a.d())
                    {
                      paramInt2 = 2;
                      break label1394;
                    }
                    if (!paramARTarget.a.j()) {
                      break label1391;
                    }
                    paramInt2 = 4;
                    break label1394;
                  }
                }
                else
                {
                  if (paramARTarget.a.j())
                  {
                    paramInt2 = 1;
                    break label1394;
                  }
                  paramInt2 = k;
                  if (!paramARTarget.a.i()) {
                    break label1394;
                  }
                  paramInt2 = 5;
                  break label1394;
                }
              }
              else if (paramARTarget.a.j())
              {
                paramInt2 = 3;
                i1 = m;
              }
              else
              {
                i1 = m;
                paramInt2 = k;
                if (paramARTarget.a.d())
                {
                  paramInt2 = 0;
                  i1 = m;
                }
              }
              ReportController.b(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramARTarget.a.jdField_b_of_type_JavaLangString, String.valueOf(paramInt2), String.valueOf(i1), "");
            }
            catch (Exception localException1)
            {
              localStringBuilder3 = new StringBuilder();
              localStringBuilder3.append("0X80081E1 ReportController  error ");
              localStringBuilder3.append(localException1.getMessage());
              QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder3.toString());
            }
            this.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
            this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.23(this));
            AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069D0", "0X80069D0", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.a.jdField_b_of_type_JavaLangString, "");
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramARTarget;
          if (!paramARTarget.a.d()) {
            AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8008144", "0X8008144", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.a.jdField_b_of_type_JavaLangString, "2");
          }
          if ((paramARTarget.a.jdField_d_of_type_Int != 0) && (paramARTarget.a.jdField_d_of_type_Int != 5))
          {
            int i2 = ARVideoUtil.a(paramARTarget);
            i1 = i2;
            if (i2 == 0) {
              i1 = 2147483647;
            }
          }
          else
          {
            i1 = 1;
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("AREngineCallback.AR_ANIMATION_STATE_END, remainCount is ");
            localStringBuilder2.append(i1);
            localStringBuilder2.append(",remainCount");
            localStringBuilder2.append(paramInt2);
            QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder2.toString());
          }
          if (paramInt2 == 0) {
            try
            {
              i1 = paramARTarget.a.jdField_d_of_type_Int;
              if (i1 != 0)
              {
                if (i1 != 2)
                {
                  if (i1 != 3)
                  {
                    if (i1 == 4) {
                      break label1400;
                    }
                    i1 = m;
                  }
                  else
                  {
                    if (paramARTarget.a.d())
                    {
                      k = 2;
                      break label1410;
                    }
                    if (!paramARTarget.a.j()) {
                      break label1406;
                    }
                    k = 4;
                    break label1410;
                  }
                }
                else
                {
                  if (paramARTarget.a.j())
                  {
                    k = 1;
                    break label1410;
                  }
                  if (!paramARTarget.a.i()) {
                    break label1410;
                  }
                  k = 5;
                  break label1410;
                }
              }
              else if (paramARTarget.a.j())
              {
                k = 3;
                i1 = m;
              }
              else
              {
                i1 = m;
                if (paramARTarget.a.d())
                {
                  k = 0;
                  i1 = m;
                }
              }
              label810:
              ReportController.b(null, "CliOper", "", "", "0X80081E1", "0X80081E1", 0, 0, paramARTarget.a.jdField_b_of_type_JavaLangString, String.valueOf(k), String.valueOf(i1), "");
            }
            catch (Exception localException2)
            {
              localStringBuilder3 = new StringBuilder();
              localStringBuilder3.append("0X80081E1 ReportController  error ");
              localStringBuilder3.append(localException2.getMessage());
              QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder3.toString());
            }
          }
          bool1 = bool2;
          if (paramARTarget.a.jdField_a_of_type_Int != 0) {
            if ((paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (!TextUtils.isEmpty(paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString))) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.22(this, paramARTarget, paramInt2, bool1));
          AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069CF", "0X80069CF", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.a.jdField_b_of_type_JavaLangString, "");
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramARTarget;
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.20(this, paramARTarget));
      }
    }
    for (;;)
    {
      try
      {
        paramInt2 = paramARTarget.a.jdField_d_of_type_Int;
        if (paramInt2 != 0)
        {
          if (paramInt2 != 2)
          {
            if (paramInt2 != 3)
            {
              if (paramInt2 == 4) {
                break label1416;
              }
              i1 = m;
              paramInt2 = k;
            }
            else
            {
              if (paramARTarget.a.d())
              {
                paramInt2 = 2;
                break label1428;
              }
              if (!paramARTarget.a.j()) {
                break label1425;
              }
              paramInt2 = 4;
              break label1428;
            }
          }
          else
          {
            if (paramARTarget.a.j())
            {
              paramInt2 = 1;
              break label1428;
            }
            paramInt2 = k;
            if (!paramARTarget.a.i()) {
              break label1428;
            }
            paramInt2 = 5;
            break label1428;
          }
        }
        else if (paramARTarget.a.j())
        {
          paramInt2 = 3;
          i1 = m;
        }
        else
        {
          i1 = m;
          paramInt2 = k;
          if (paramARTarget.a.d())
          {
            paramInt2 = 0;
            i1 = m;
          }
        }
        ReportController.b(null, "CliOper", "", "", "0X80081DF", "0X80081DF", 0, 0, paramARTarget.a.jdField_b_of_type_JavaLangString, String.valueOf(paramInt2), String.valueOf(i1), "");
      }
      catch (Exception localException3)
      {
        localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("0X80081DF ReportController  error ");
        localStringBuilder3.append(localException3.getMessage());
        QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder3.toString());
      }
      if ((paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.21(this, paramARTarget));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
        return;
      }
      AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069CC", "0X80069CC", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.a.jdField_b_of_type_JavaLangString, "2");
      this.jdField_a_of_type_Int = paramInt1;
      return;
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, arTarget == null || arTarget.arResourceInfo == null");
      return;
      label1382:
      i1 = 0;
      paramInt2 = k;
      break;
      label1391:
      paramInt2 = 6;
      label1394:
      i1 = 1;
      break;
      label1400:
      i1 = 0;
      break label810;
      label1406:
      k = 6;
      label1410:
      i1 = 1;
      break label810;
      label1416:
      i1 = 0;
      paramInt2 = k;
      continue;
      label1425:
      paramInt2 = 6;
      label1428:
      i1 = 1;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("AREngine_ARScanEntryView", 2, "onStartLoadUrl");
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.26(this, paramString));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
  }
  
  public void a(long paramLong, int paramInt, ARRenderTrackInfo paramARRenderTrackInfo, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    E();
    Object localObject;
    if ((paramLong == 128L) && ((paramARLocalRecogResultBase instanceof ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)))
    {
      localObject = (ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)paramARLocalRecogResultBase;
      if (QLog.isColorLevel())
      {
        paramARRenderTrackInfo = new StringBuilder();
        paramARRenderTrackInfo.append(" externalRenderResult info is isValidData=");
        paramARRenderTrackInfo.append(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_Boolean);
        paramARRenderTrackInfo.append("isNeedShowViewFinder ");
        paramARRenderTrackInfo.append(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_b_of_type_Boolean);
        QLog.d("AREngine_ARScanEntryView", 1, paramARRenderTrackInfo.toString());
      }
      if (!((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_Boolean)
      {
        this.z = false;
        h(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_b_of_type_Boolean);
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.13(this));
        return;
      }
      if (QLog.isColorLevel())
      {
        paramARLocalRecogResultBase = new StringBuilder();
        paramARLocalRecogResultBase.append("MIG object RectF(协议原始的数据) ");
        if (((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult != null) {
          paramARRenderTrackInfo = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_AndroidGraphicsRectF.toString();
        } else {
          paramARRenderTrackInfo = "error happen";
        }
        paramARLocalRecogResultBase.append(paramARRenderTrackInfo);
        QLog.d("AREngine_MIGObjectClassifyResult", 1, paramARLocalRecogResultBase.toString());
      }
      h(false);
      if (((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult == null) {
        return;
      }
      DrawView2.FaceData localFaceData = new DrawView2.FaceData();
      localFaceData.jdField_a_of_type_Float = 99.0F;
      paramARRenderTrackInfo = new StringBuilder();
      paramARRenderTrackInfo.append(HardCodeUtil.a(2131700963));
      paramARRenderTrackInfo.append((int)(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_Double * 100.0D));
      paramARRenderTrackInfo.append("%");
      localFaceData.jdField_c_of_type_JavaLangString = paramARRenderTrackInfo.toString();
      if (QLog.isColorLevel())
      {
        paramARRenderTrackInfo = new StringBuilder();
        paramARRenderTrackInfo.append(" scantorch activitity result ok ");
        paramARRenderTrackInfo.append(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_Double);
        QLog.d("AREngine_MIGObjectClassifyResult", 1, paramARRenderTrackInfo.toString());
      }
      localFaceData.jdField_a_of_type_Int = 10;
      localFaceData.jdField_a_of_type_AndroidGraphicsRectF = DrawView2.FaceData.a(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_AndroidGraphicsRectF);
      if (QLog.isColorLevel())
      {
        paramARRenderTrackInfo = new StringBuilder();
        paramARRenderTrackInfo.append("MIG mapMigObjectRect2Screen(协议转化后的数据) object RectF ");
        paramARRenderTrackInfo.append(localFaceData.jdField_a_of_type_AndroidGraphicsRectF);
        QLog.d("AREngine_MIGObjectClassifyResult", 1, paramARRenderTrackInfo.toString());
      }
      localFaceData.jdField_a_of_type_ArrayOfFloat = null;
      localFaceData.h = null;
      localFaceData.jdField_c_of_type_Boolean = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_b_of_type_Boolean;
      localFaceData.jdField_d_of_type_Boolean = false;
      localFaceData.jdField_a_of_type_Boolean = true;
      localFaceData.jdField_b_of_type_Boolean = true;
      localFaceData.jdField_e_of_type_Boolean = false;
      localFaceData.jdField_a_of_type_JavaLangString = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_JavaLangString;
      boolean bool = TextUtils.isEmpty(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_b_of_type_JavaLangString);
      paramARLocalRecogResultBase = " ";
      if (bool) {
        paramARRenderTrackInfo = " ";
      } else {
        paramARRenderTrackInfo = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_b_of_type_JavaLangString;
      }
      localFaceData.jdField_d_of_type_JavaLangString = paramARRenderTrackInfo;
      if (TextUtils.isEmpty(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_c_of_type_JavaLangString)) {
        paramARRenderTrackInfo = paramARLocalRecogResultBase;
      } else {
        paramARRenderTrackInfo = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_c_of_type_JavaLangString;
      }
      localFaceData.jdField_e_of_type_JavaLangString = paramARRenderTrackInfo;
      localFaceData.jdField_b_of_type_JavaLangString = null;
      localFaceData.jdField_f_of_type_JavaLangString = null;
      localFaceData.g = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_d_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        paramARRenderTrackInfo = new StringBuilder();
        paramARRenderTrackInfo.append(" label name is ");
        paramARRenderTrackInfo.append(localFaceData.jdField_a_of_type_JavaLangString);
        paramARRenderTrackInfo.append("isAutoJump ");
        paramARRenderTrackInfo.append(localFaceData.jdField_c_of_type_Boolean);
        QLog.d("AREngine_ARScanEntryView", 1, paramARRenderTrackInfo.toString());
        if (TextUtils.isEmpty(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_c_of_type_JavaLangString)) {
          QLog.d("AREngine_ARScanEntryView", 1, " profileContent    null  ");
        }
      }
      paramARRenderTrackInfo = this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView;
      if (paramARRenderTrackInfo == null)
      {
        QLog.d("AREngine_ARScanEntryView", 1, " mObjectSurfaceView not ready ");
        return;
      }
      paramARRenderTrackInfo.post(new ARScanEntryView.14(this));
      paramARRenderTrackInfo = new ArrayList();
      paramARRenderTrackInfo.add(localFaceData);
      this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.setFaceData(paramARRenderTrackInfo);
      return;
    }
    if (paramLong == 4L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController;
      if ((localObject != null) && (((FaceUIController)localObject).jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null))
      {
        int k = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
        if ((k != 3) && (k != 2) && (k != 0)) {
          j();
        }
      }
    }
    else
    {
      j();
    }
    if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onARTrackComplete, recogType = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",trackMode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",trackResult = ");
      ((StringBuilder)localObject).append(paramARRenderTrackInfo);
      ((StringBuilder)localObject).append(",localRecogResult = ");
      ((StringBuilder)localObject).append(paramARLocalRecogResultBase);
      ((StringBuilder)localObject).append(",isPause = ");
      ((StringBuilder)localObject).append(this.i);
      QLog.d("AREngine_ARScanEntryView", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.i) && (paramLong == 4L) && ((paramARLocalRecogResultBase instanceof ARLocalFaceRecogResult)))
    {
      paramARRenderTrackInfo = (ARLocalFaceRecogResult)paramARLocalRecogResultBase;
      if (paramARRenderTrackInfo == null) {
        return;
      }
      paramARLocalRecogResultBase = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if ((paramARRenderTrackInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramARRenderTrackInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController;
        if ((localObject != null) && (((FaceUIController)localObject).jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!paramARLocalRecogResultBase.isFinishing())) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.15(this));
        }
      }
      if (paramARRenderTrackInfo.jdField_a_of_type_Boolean)
      {
        this.h = false;
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.16(this));
        return;
      }
      if (!this.h)
      {
        this.h = true;
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.17(this));
      }
      if (this.jdField_a_of_type_Long < 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  public void a(long paramLong, ARTarget paramARTarget)
  {
    E();
    j();
    if ((paramARTarget == null) || (paramARTarget.a == null) || (!this.H)) {}
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
      label55:
      Intent localIntent;
      break label55;
    }
    this.H = true;
    if (paramARTarget.a.f()) {
      return;
    }
    if ((paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.9(this, paramARTarget));
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(306);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageAtTime(313, 100L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onARRecogComplete start jump :");
        ((StringBuilder)localObject).append(paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
        QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if ((paramARTarget.a.jdField_d_of_type_Int == 6) && (paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (!paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
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
      else
      {
        localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
        localIntent.putExtra("url", paramARTarget);
        localIntent.putExtra("finish_animation_up_down", true);
        ((Activity)localObject).startActivity(localIntent);
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ((Activity)localObject).overridePendingTransition(2130772011, 0);
      }
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 1, "onARRecogComplete empty value");
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, ARTarget paramARTarget)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onAREnableModelRender, isEnable = ");
      localStringBuilder1.append(paramBoolean);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder1.toString());
    }
    int k = 1;
    if (!paramBoolean) {
      k = 100;
    }
    for (;;)
    {
      try
      {
        m = paramARTarget.a.jdField_d_of_type_Int;
        if (m != 0)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m == 4) {
                break label422;
              }
            }
            else
            {
              if (paramARTarget.a.d())
              {
                k = 2;
                break label432;
              }
              if (!paramARTarget.a.j()) {
                break label428;
              }
              k = 4;
              break label432;
            }
          }
          else
          {
            if (paramARTarget.a.j())
            {
              k = 1;
              break label432;
            }
            if (!paramARTarget.a.i()) {
              break label432;
            }
            k = 5;
            break label432;
          }
        }
        else if (paramARTarget.a.j()) {
          k = 3;
        } else if (paramARTarget.a.d()) {
          k = 0;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("0X80081E0 ReportController  error ");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder2.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramARTarget.a.jdField_b_of_type_JavaLangString, String.valueOf(k), String.valueOf(m), "");
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsValue(Integer.valueOf(0))) || (!paramARTarget.a.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "onARStateChanged, AR_RECOG_STATE_LOST in");
        }
        if (this.p == true) {
          return;
        }
        g(true);
        this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.18(this));
        return;
        if ((paramARTarget.a.jdField_a_of_type_Int != 1) || (paramARTarget.a.e != 0)) {
          k = 0;
        }
        if ((k == 0) || (paramARTarget.a.d()))
        {
          g(false);
          this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.19(this));
        }
      }
      return;
      int m = 2;
      continue;
      label422:
      m = 0;
      continue;
      label428:
      k = 6;
      label432:
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
      paramBundle = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560960, this, false);
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
    if (QLog.isColorLevel())
    {
      paramArCloudConfigInfo2 = new StringBuilder();
      paramArCloudConfigInfo2.append("onCommonCallbackFromUI, config=");
      paramArCloudConfigInfo2.append(paramArCloudConfigInfo1);
      paramArCloudConfigInfo2.append(", action=");
      paramArCloudConfigInfo2.append(paramInt1);
      paramArCloudConfigInfo2.append(", result=");
      paramArCloudConfigInfo2.append(paramInt2);
      paramArCloudConfigInfo2.append(", data=");
      paramArCloudConfigInfo2.append(paramObject);
      QLog.d("AREngine_ARScanEntryView", 2, paramArCloudConfigInfo2.toString());
    }
  }
  
  public void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLBSLocationComplete. retCode = ");
    localStringBuilder.append(paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int);
    localStringBuilder.append(", LBSActivity = ");
    localStringBuilder.append(paramArLBSActivity);
    QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new ARScanEntryView.28(this, paramARCloudLBSLocationCheckResult, paramArLBSActivity));
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.25(this, paramARRenderMangerInnerCallback, paramArVideoResourceInfo));
  }
  
  public void a(String paramString, PromotionConfigInfo.PromotionItem paramPromotionItem, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryToEnterTransferMode[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mIsTransferDoorMode[");
    localStringBuilder.append(this.F);
    localStringBuilder.append("], ready[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    this.F = true;
    this.E = true;
    if (paramPromotionItem != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramPromotionItem.jdField_b_of_type_JavaLangString);
    }
    G();
    if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((QQARSession)this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.jdField_a_of_type_JavaLangRefWeakReference.get()).s();
    }
    if (paramBoolean)
    {
      if (paramPromotionItem == null) {
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
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTipsWithProgress, from[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], tips[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], progress[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], isVisible[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a());
      localStringBuilder.append("]");
      QLog.w("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a(paramString2, paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, ARTipsManager.ButtonClickListener paramButtonClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showErrorTips, str[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], isVisible[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a());
      localStringBuilder.append("]");
      QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a(paramString1, paramString2, paramButtonClickListener);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.G) || (this.w)) && (!this.n))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showLoadProgress, 已经在穿越门里面了, from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.w("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    int i2 = (this.jdField_d_of_type_Int + this.jdField_c_of_type_Int) / 2;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showLoadProgress mCurrentAsyncProgress:=");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject).append(",mCurrentSyncProgress:=");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy;
    paramBoolean = false;
    int k;
    if ((localObject != null) && (((ARVideoRecordViewProxy)localObject).a())) {
      k = 1;
    } else {
      k = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    int m;
    if ((localObject != null) && (this.E))
    {
      paramBoolean = ((PromotionRes)localObject).c();
      m = ((PromotionRes)localObject).a();
    }
    else
    {
      m = 0;
    }
    int i1 = i2;
    if (paramBoolean) {
      i1 = (i2 + m) / 2;
    }
    if (k != 0) {
      j();
    } else {
      a(paramString, HardCodeUtil.a(2131700971), i1);
    }
    B();
    if (!this.y)
    {
      this.y = true;
      ReportController.b(null, "dc00898", "", "", "0X80085B6", "0X80085B6", 0, 0, "", "", "", "");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnginePause resetFaceUI = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.h = false;
      this.jdField_a_of_type_AndroidOsHandler.post(new ARScanEntryView.27(this));
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = StringUtil.a(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Object localObject = paramString.toLowerCase();
    if ((((String)localObject).startsWith("mqqapi://miniapp/open")) || (((String)localObject).startsWith("mqqapi://microapp/open"))) {
      bool1 = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkUrlIsMiniAppJumpSchema, retValue is ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(",strUrl");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AREngine_ARScanEntryView", 2, ((StringBuilder)localObject).toString());
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTransferDoorGuideText textIndex = ");
      localStringBuilder.append(paramInt);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null) {
      ((TouchWebView)localObject).onResume();
    }
    if (this.q) {
      g(true);
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    if (this.p == true)
    {
      g(true);
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if (localObject != null) {
        ((TouchWebView)localObject).setVisibility(4);
      }
    }
    this.p = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController;
    if ((localObject != null) && (((FaceUIController)localObject).jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController;
    if ((localObject != null) && (((FaceUIController)localObject).jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).b();
    }
    ARVideoRecordUIControllerImpl.a().a();
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doAfterProviderViewClose isPromotionPage =  ");
    localStringBuilder.append(d());
    localStringBuilder.append("mHasReachEntryReady:");
    localStringBuilder.append(this.A);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    if ((d()) || (paramBoolean) || (!this.A)) {
      e();
    }
  }
  
  public void c_(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showErrorTips, str[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isVisible[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a());
      localStringBuilder.append("]");
      QLog.w("AREngine_ARScanEntryView", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a(paramString);
    }
  }
  
  public void d()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onPause ");
    g(false);
    L();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).g();
    }
    ARVideoRecordUIControllerImpl.a().e();
    this.i = true;
    localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null) {
      ((TouchWebView)localObject).onPause();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessage(307);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog;
    if (localObject != null) {
      ((ARLBSPOIDialog)localObject).dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    super.d();
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTransferDoorGuideImage show = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession;
    if ((localObject != null) && (((QQARSession)localObject).c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.i();
      this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.j();
    }
    this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession = null;
    QQARSession.k();
    CameraProxy.a().b(this);
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
    if (localObject != null)
    {
      ((ARTransferDoorLogicManager)localObject).h();
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager = null;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    ARVideoRecordUIControllerImpl.a().f();
    removeAllViews();
    this.jdField_b_of_type_AndroidViewView = null;
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof ScanTorchActivity))) {
      ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView;
    if (localObject != null)
    {
      ((ScanIconAnimateView)localObject).d();
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.b();
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateDownloadStatus, from[");
    ((StringBuilder)localObject).append(paramBoolean ^ true);
    ((StringBuilder)localObject).append("]!mAfterDependenceTimeout=");
    ((StringBuilder)localObject).append(this.t ^ true);
    ((StringBuilder)localObject).append(";mIsDownloadTimeout=");
    ((StringBuilder)localObject).append(this.L);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    if (((!this.t) && (!paramBoolean)) || (this.L)) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    PromotionRes localPromotionRes = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    boolean bool1;
    if ((this.E) && (localPromotionRes != null)) {
      bool1 = localPromotionRes.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    } else {
      bool1 = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateDownloadStatus 2222, ");
    localStringBuilder.append(((ScanEntryResourceDelegate)localObject).a());
    localStringBuilder.append(";");
    localStringBuilder.append(bool1);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    boolean bool2 = ((ScanEntryResourceDelegate)localObject).a();
    int m = 0;
    if ((bool2) && (bool1))
    {
      if ((this.u) || (this.v) || (paramBoolean))
      {
        j();
        this.u = false;
        this.v = false;
        C();
      }
    }
    else
    {
      if (this.E)
      {
        k = m;
        if (localPromotionRes == null) {
          break label310;
        }
        k = m;
        if (localPromotionRes.a()) {
          break label310;
        }
        k = m;
        if (((ScanEntryResourceDelegate)localObject).b()) {
          break label310;
        }
      }
      else
      {
        k = m;
        if (((ScanEntryResourceDelegate)localObject).b()) {
          break label310;
        }
      }
      int k = 1;
      label310:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDownloadStatus 333, ");
      localStringBuilder.append(((ScanEntryResourceDelegate)localObject).b());
      QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
      if (k != 0)
      {
        a("AR组件加载失败", HardCodeUtil.a(2131700969), new ARScanEntryView.37(this, (ScanEntryResourceDelegate)localObject, localPromotionRes));
        this.w = true;
        this.u = true;
        C();
        if (!this.x)
        {
          this.x = true;
          ReportController.b(null, "dc00898", "", "", "0X80085B5", "0X80085B5", 0, 0, "", "", "", "");
        }
      }
      else
      {
        b("updateDownloadStatus");
        this.v = true;
      }
    }
  }
  
  public void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onProviderViewShow. mQQARSession mCurrentStatus:=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.b());
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
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
    else
    {
      g(false);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).b();
    }
    ARVideoRecordUIControllerImpl.a().a();
  }
  
  public void g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onProviderViewClose. mQQARSession mCurrentStatus:=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.b());
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).g();
    }
    ARVideoRecordUIControllerImpl.a().e();
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.b(true);
    this.M = false;
  }
  
  public void h()
  {
    this.j = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(312);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scanTorch notifyRenderReady ");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_e_of_type_Boolean)
    {
      i();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(313);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession;
    if (localObject != null) {
      ((QQARSession)localObject).r();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    if (k != 295)
    {
      if (k != 296)
      {
        if (k != 321)
        {
          if (k != 352)
          {
            if (k != 324)
            {
              if (k != 325)
              {
                switch (k)
                {
                default: 
                  return true;
                case 313: 
                  this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(313, 50L);
                  this.jdField_b_of_type_Int += 1;
                  paramMessage = this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
                  if (paramMessage == null) {
                    break;
                  }
                  paramMessage.setTotalProgress(this.jdField_b_of_type_Int);
                  return true;
                case 312: 
                  paramMessage = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
                  if (paramMessage == null) {
                    break;
                  }
                  paramMessage.onPause();
                  return true;
                case 311: 
                  paramMessage = this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
                  if (paramMessage == null) {
                    break;
                  }
                  paramMessage.setTotalProgress(this.jdField_b_of_type_Int);
                  return true;
                case 310: 
                  z();
                  return true;
                case 309: 
                  z();
                  return true;
                case 308: 
                  z();
                  return true;
                case 307: 
                  paramMessage = this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
                  if (paramMessage == null) {
                    break;
                  }
                  this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(paramMessage);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = null;
                  if (this.r)
                  {
                    paramMessage = this.jdField_a_of_type_AndroidOsHandler;
                    if (paramMessage != null) {
                      paramMessage.sendEmptyMessageDelayed(352, 2500L);
                    }
                  }
                  QLog.d("AREngine_ARScanEntryView", 1, "MSG_HIDE_SCAN_SUCCESS_PROGRESS,juhua has call finished ");
                  return true;
                case 306: 
                  if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView != null) {
                    break;
                  }
                  paramMessage = new RelativeLayout.LayoutParams(-1, -1);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this.jdField_a_of_type_AndroidContentContext);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ScreenUtil.SCREEN_WIDTH);
                  this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, paramMessage);
                  this.jdField_a_of_type_AndroidOsHandler.removeMessages(352);
                  if (!e()) {
                    break;
                  }
                  g(false);
                  this.r = true;
                  return true;
                }
              }
              else
              {
                if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
                {
                  paramMessage = this.jdField_d_of_type_AndroidWidgetTextView;
                  if (paramMessage != null) {
                    paramMessage.setText(this.jdField_e_of_type_JavaLangString.replace("\\n", "\n"));
                  }
                }
                if ((!this.E) && (!this.F))
                {
                  paramMessage = this.jdField_d_of_type_AndroidWidgetTextView;
                  if (paramMessage != null)
                  {
                    paramMessage.setVisibility(0);
                    return true;
                  }
                }
              }
            }
            else
            {
              A();
              return true;
            }
          }
          else
          {
            paramMessage = (Activity)this.jdField_a_of_type_AndroidContentContext;
            if ((this.r) && (!paramMessage.isFinishing()))
            {
              g(true);
              return true;
            }
          }
        }
        else
        {
          s();
          return true;
        }
      }
      else
      {
        z();
        return true;
      }
    }
    else
    {
      QLog.d("AREngine_ARScanEntryView", 1, "start AR ready");
      i(false);
      this.D = true;
      F();
    }
    return true;
  }
  
  public void i()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scanTorch notifyRenderReady isNotifyRecivied ");
    ((StringBuilder)localObject).append(this.j);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    if (Build.VERSION.SDK_INT >= 16)
    {
      a();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      ARVideoRecordUIControllerImpl.a().b(6);
    }
    else
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("ar_model", Build.MODEL);
      ((HashMap)localObject).put("ar_type", "3");
      ((HashMap)localObject).put("ar_reason", "1");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidARException", true, 0L, 0L, (HashMap)localObject, "", true);
    }
    if (this.j)
    {
      ARTransparentWebviewPlugin.b();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
    }
  }
  
  public void j()
  {
    ARTipsManager localARTipsManager = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager;
    if (localARTipsManager != null)
    {
      Throwable localThrowable = null;
      if (localARTipsManager.a()) {
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
    int k = paramView.getId();
    Object localObject1;
    Object localObject3;
    if (k != 2131365221)
    {
      if (k != 2131378804)
      {
        if (k == 2131379075)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AREngine_ARScanEntryView", 2, "onClick R.id.touch_view");
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqArARTarget;
          if ((localObject1 != null) && (((ARTarget)localObject1).a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean)
            {
              ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString, "0", "1", "");
              if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.c()) {
                ReportController.b(null, "CliOper", "", "", "0X80098D1", "0X80098D1", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString, "1", "0", "");
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
              ((ScanTorchActivity)localObject2).setResult(11);
              ARVideoRecordUIControllerImpl.a().b(3);
              if (a((String)localObject1))
              {
                localObject2 = new Intent("android.intent.action.VIEW");
                ((Intent)localObject2).setData(Uri.parse((String)localObject1));
                ((Intent)localObject2).addFlags(268435456);
                ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
                ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getPackageName());
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
              }
              else
              {
                localObject3 = new Intent((Context)localObject2, QQBrowserActivity.class);
                ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_sacan");
                ((Intent)localObject3).putExtra("url", a((String)localObject1));
                ((ScanTorchActivity)localObject2).startActivity((Intent)localObject3);
              }
              this.q = true;
            }
            else
            {
              ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString, "0", "0", "");
              this.p = true;
              g(false);
              v();
              w();
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession;
              if (localObject1 != null)
              {
                ((QQARSession)localObject1).a(1L);
                this.jdField_a_of_type_ComTencentMobileqqArModelQQARSession.n();
              }
              i();
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqArARTarget;
            if ((localObject1 != null) && (!((ARTarget)localObject1).a.d())) {
              AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString, "2");
            }
            y();
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqArARTarget;
          if ((localObject1 != null) && (!TextUtils.isEmpty(((ARTarget)localObject1).a.jdField_b_of_type_JavaLangString))) {
            AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80069D1", "0X80069D1", 0, 0, "1", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_b_of_type_JavaLangString, "");
          }
        }
      }
      else {
        ((ScanTorchActivity)localObject2).a(false);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("find button clicked what2scanUrl = ");
        ((StringBuilder)localObject1).append(this.jdField_f_of_type_JavaLangString);
        QLog.d("AREngine_ARScanEntryView", 2, ((StringBuilder)localObject1).toString());
      }
      AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8008615", "0X8008615", 0, 0, "", "", "", "");
      localObject1 = ArMapUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
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
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("find button clicked jumpurl  = ");
          ((StringBuilder)localObject3).append((String)localObject1);
          QLog.d("AREngine_ARScanEntryView", 2, ((StringBuilder)localObject3).toString());
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
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setRectAreas(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    paramRect = (ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    paramRect.setMargins(paramRect.leftMargin, this.jdField_a_of_type_AndroidGraphicsRect.bottom + AIOUtils.b(30.0F, getResources()), paramRect.rightMargin, paramRect.bottomMargin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView
 * JD-Core Version:    0.7.0.1
 */