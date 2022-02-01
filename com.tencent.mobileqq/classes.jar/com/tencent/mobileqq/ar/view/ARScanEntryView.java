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
  int A;
  boolean B;
  private ARTipsManager K;
  private boolean L;
  private Runnable M;
  private Handler N;
  private MqqHandler O;
  private FrameLayout P;
  private TouchWebView Q;
  private ViewGroup R;
  private TextView S;
  private TextView T;
  private TextView U;
  private QQARSession V;
  private ARTarget W = null;
  private boolean Z = false;
  public RelativeLayout a;
  private boolean aA = false;
  private RelativeLayout aB;
  private boolean aC = false;
  private boolean aD = false;
  private boolean aE = false;
  private PromotionGuide aF = null;
  private boolean aG;
  private MessageQueue.IdleHandler aH = new ARScanEntryView.1(this);
  private View.OnTouchListener aI = new ARScanEntryView.2(this);
  private Rect aJ;
  private long aK = -1L;
  private boolean aL = false;
  private boolean aM = false;
  private boolean aN = false;
  private QQCustomDialog aO = null;
  private ARLBSPOIDialog aP = null;
  private MapView aQ = null;
  private Runnable aR;
  private boolean aS;
  private ScanEntryResourceDelegate.ARBaseResDownLoadCallBack aT = new ARScanEntryView.3(this);
  private boolean aU = false;
  private ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack aV = new ARScanEntryView.4(this);
  private ArMapObserver aW = new ARScanEntryView.5(this);
  private SimpleDateFormat aX;
  private boolean aa = false;
  private boolean ab = false;
  private boolean ac = false;
  private String ad;
  private String ae;
  private volatile ARCommonConfigInfo af;
  private boolean ag = false;
  private Bundle ah;
  private long ai;
  private boolean aj = false;
  private boolean ak = false;
  private boolean al = false;
  private boolean am = false;
  private int an = 0;
  private int ao = 0;
  private boolean ap = false;
  private boolean aq = false;
  private volatile boolean ar = true;
  private HashMap<String, Integer> as = new HashMap();
  private ARVideoRecordViewProxy at;
  private boolean au = false;
  private RelativeLayout av;
  private ScanIconAnimateView aw;
  private ImageView ax;
  private boolean ay = false;
  private boolean az = true;
  public TextView b;
  public TextView c;
  public TextView d;
  public FrameLayout e;
  public LinearLayout f;
  public ScanSuccessView g;
  public ObjectSurfaceView h;
  public String i = null;
  public String j = null;
  public String k = null;
  public String l = null;
  public int m = -1;
  public boolean n = false;
  public boolean o = false;
  TextView p;
  FaceUIController q;
  boolean r = true;
  boolean s = false;
  boolean t = false;
  boolean u = false;
  boolean v = false;
  volatile boolean w = false;
  volatile boolean x = false;
  long y = -1L;
  ARTransferDoorLogicManager z;
  
  public ARScanEntryView(Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    super(paramContext, paramScanEntryContainerViewListener);
  }
  
  private void A()
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      return;
    }
    localTextView.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.l = null;
    this.f.setVisibility(8);
  }
  
  private void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "showTouchView");
    }
    this.f.setVisibility(8);
    this.e.setVisibility(0);
    ARTarget localARTarget = this.W;
    if ((localARTarget != null) && (localARTarget.a != null)) {
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "mArTarget == null || mArTarget.arResourceInfo == null");
  }
  
  private void C()
  {
    FrameLayout localFrameLayout = this.e;
    if (localFrameLayout == null) {
      return;
    }
    localFrameLayout.setVisibility(8);
  }
  
  private boolean D()
  {
    if (this.H.getRenderEngine() != null) {
      return this.H.getRenderEngine().h();
    }
    return true;
  }
  
  private void E()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "handleARStartFail");
    this.L = true;
    if (this.M == null) {
      c(HardCodeUtil.a(2131898988));
    }
  }
  
  private void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("checkArDependenceReady time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.aK) }));
    }
    boolean bool1 = ARDeviceController.a().b();
    boolean bool2 = ARDeviceController.a().c();
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
    localObject = this.H.getUniformResManger();
    Activity localActivity = (Activity)this.E;
    if ((bool1) && (bool2) && (((ScanEntryResourceDelegate)localObject).c(2)) && (((ScanEntryResourceDelegate)localObject).c(8)) && (!this.ag))
    {
      localObject = this.V;
      if ((localObject != null) && (((QQARSession)localObject).u()))
      {
        if (!this.V.v()) {
          u();
        }
        if ((this.J) && (this.V.v()) && (this.V.u()) && (this.V.l() == 1)) {
          this.V.k();
        }
      }
      if (this.H.getARCommonConfig() != null)
      {
        if (this.H.getARCommonConfig().isEnableVideoRecord == 1L) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ARVideoRecordUIControllerImpl.a().a(bool1);
        QLog.d("AREngine_ARScanEntryView", 1, String.format("checkARVideoRecordEnable enable=%s", new Object[] { Boolean.valueOf(bool1) }));
      }
      if ((!this.aL) && (!this.N.hasMessages(321)))
      {
        this.N.sendEmptyMessageDelayed(321, 100L);
        QLog.d("AREngine_ARScanEntryView", 1, "checkArDependenceReady do delay initARView");
      }
    }
  }
  
  private void G()
  {
    if (this.aR == null)
    {
      this.aR = new ARScanEntryView.35(this);
      QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck");
    }
    this.aS = false;
    this.N.removeCallbacks(this.aR);
    this.N.postDelayed(this.aR, 10000L);
  }
  
  private void H()
  {
    QLog.d("AREngine_ARScanEntryView", 2, "stopDownloadTimeoutCheck");
    Runnable localRunnable = this.aR;
    if (localRunnable != null)
    {
      this.N.removeCallbacks(localRunnable);
      this.aR = null;
    }
  }
  
  private void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("addTimeoutCheck mArEnabled=%s mHasCallRemoveTimeoutCheck=%s", new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.aU) }));
    }
    if (this.aU) {
      return;
    }
    if (this.N != null)
    {
      if (this.M == null) {
        this.M = new ARScanEntryView.36(this);
      }
      ARCommonConfigInfo localARCommonConfigInfo = this.H.getARCommonConfig();
      long l2 = 8000L;
      long l1 = l2;
      if (localARCommonConfigInfo != null)
      {
        l1 = this.H.getARCommonConfig().mARNoResultCheckTime;
        if (l1 <= 0L) {
          l1 = l2;
        }
      }
      this.N.postDelayed(this.M, l1);
    }
  }
  
  private void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "removeTimeoutCheck");
    }
    this.aU = true;
    this.al = false;
    if ((this.N != null) && (this.M != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "do removeTimeoutCheck");
      }
      this.N.removeCallbacks(this.M);
      this.M = null;
    }
  }
  
  private void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "doAfterAREngineReady = ");
    }
    Object localObject = this.z;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).a(this.V);
    }
    localObject = this.H.getPromotionManager();
    if (localObject != null) {
      ((PromotionRes)localObject).f(this.C);
    }
    this.au = true;
  }
  
  private void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "doHideNonPromotionUI = ");
    }
    this.av.setVisibility(8);
    this.p.setVisibility(8);
  }
  
  private void M()
  {
    if (this.aj)
    {
      if (this.aS) {
        return;
      }
      if (this.al) {
        d("updateDownloadProgress");
      }
    }
  }
  
  private void N()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkReadyToStartARSession = ");
    ((StringBuilder)localObject).append(this.J);
    QLog.i("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    localObject = this.V;
    if ((localObject != null) && (((QQARSession)localObject).v()) && (this.J)) {
      this.V.j();
    }
  }
  
  private void O() {}
  
  private void P()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIfNeedAutoFocus isCameraPrviewing=");
    localStringBuilder.append(CameraProxy.a().g());
    localStringBuilder.append(";mIsResumed=");
    localStringBuilder.append(this.J);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    if ((CameraProxy.a().g()) && (this.J)) {
      CameraProxy.a().a(UniformGLRenderManagerImpl.b, UniformGLRenderManagerImpl.c);
    }
  }
  
  private void Q()
  {
    QLog.i("AREngine_ARScanEntryView", 1, "stopAutoFoucus ");
    CameraProxy.a().b();
  }
  
  private boolean R()
  {
    SharedPreferences localSharedPreferences = ArMapUtil.a(this.C);
    boolean bool = localSharedPreferences.getBoolean("key_show_reddot", false);
    if (!S()) {
      try
      {
        localArMapHandler = (ArMapHandler)this.C.getBusinessHandler(ArMapConstant.a);
        l1 = localSharedPreferences.getLong("key_ar_act_id", 0L);
        if (localArMapHandler == null) {}
      }
      catch (Exception localException)
      {
        ArMapHandler localArMapHandler;
        long l1;
        label79:
        localException.printStackTrace();
        QLog.d("AREngine_ARScanEntryView", 1, "shouldShowActRedDot  getBusinessHandler fail ");
        return bool;
      }
    }
    try
    {
      localArMapHandler.a(Long.parseLong(this.C.getCurrentAccountUin()), l1);
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
  
  private boolean S()
  {
    String str1 = ArMapUtil.a(this.C).getString("key_click_reddot_date", null);
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
  
  private String a(long paramLong)
  {
    if (this.aX == null)
    {
      this.aX = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
      this.aX.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      String str = this.aX.format(Long.valueOf(paramLong));
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
      int i1 = 0;
      if (paramLong != 0L)
      {
        Object localObject = paramARCommonConfigInfo.recognitions.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ARRecognition localARRecognition = (ARRecognition)((Iterator)localObject).next();
          int i2 = i1;
          if (localARRecognition.a == 12L) {
            i2 = 1;
          }
          i1 = i2;
          if ((1 << (int)localARRecognition.a & paramLong) != 0L)
          {
            localArrayList.add(localARRecognition);
            i1 = i2;
          }
        }
        if ((i1 == 0) && ((paramLong & 0x1000) != 0L))
        {
          localObject = new ARRecognition();
          ((ARRecognition)localObject).a = 12L;
          ((ARRecognition)localObject).b = 1;
          ((ARRecognition)localObject).c = 1;
          ((ARRecognition)localObject).d = 4;
          ((ARRecognition)localObject).f = 1;
        }
        paramARCommonConfigInfo.recognitions = localArrayList;
      }
    }
  }
  
  private void a(ARCloudLBSLocationCheckResult.POIInfo paramPOIInfo, ArLBSActivity paramArLBSActivity)
  {
    if (this.aP == null)
    {
      this.aP = new ARLBSPOIDialog((Activity)this.E, getDailogMapView(), this);
      this.aP.setOnDismissListener(new ARScanEntryView.32(this));
    }
    this.aP.a();
    this.aP.a(paramPOIInfo, paramArLBSActivity);
  }
  
  private void b(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "doWhenGetARConfig ");
    if (this.af != null) {
      return;
    }
    if ((paramARCommonConfigInfo != null) && (paramARCommonConfigInfo.arControllers != null))
    {
      Iterator localIterator = paramARCommonConfigInfo.arControllers.iterator();
      while (localIterator.hasNext())
      {
        ARScanAR localARScanAR = (ARScanAR)localIterator.next();
        if ((localARScanAR != null) && (localARScanAR.a == 1))
        {
          this.ae = localARScanAR.q;
          this.ad = localARScanAR.m;
        }
      }
    }
    if (!this.aC)
    {
      this.N.removeMessages(325);
      this.N.sendEmptyMessage(325);
    }
    this.af = paramARCommonConfigInfo;
    if (!this.ah.getBoolean("NoLimitParams", true)) {
      a(this.af, this.ah.getLong("recognitionMask", 0L));
    }
    paramARCommonConfigInfo = this.H.getUniformResManger();
    ThreadManager.postImmediately(new ARScanEntryView.8(this, this.ai, paramARCommonConfigInfo), null, false);
  }
  
  private void b(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity)
  {
    if (paramArLBSActivity == null)
    {
      new ArLBSActivity();
      return;
    }
    if (paramARCloudLBSLocationCheckResult.a == 0)
    {
      if (paramARCloudLBSLocationCheckResult.c == null)
      {
        QQToast.makeText(this.E, paramArLBSActivity.f, 1).show();
        return;
      }
      this.V.m();
      setHaveEdge(false);
      a(paramARCloudLBSLocationCheckResult.c, paramArLBSActivity);
      return;
    }
    if (paramARCloudLBSLocationCheckResult.a == 2)
    {
      this.V.k();
      setHaveEdge(false);
      if (this.aO == null) {
        this.aO = DialogUtil.a(this.E, 230, paramArLBSActivity.g, paramArLBSActivity.h, HardCodeUtil.a(2131899883), HardCodeUtil.a(2131898986), new ARScanEntryView.29(this), new ARScanEntryView.30(this));
      }
      this.aO.setOnDismissListener(new ARScanEntryView.31(this));
      this.aO.show();
      return;
    }
    int i1 = paramARCloudLBSLocationCheckResult.a;
  }
  
  private String e(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append("&_wv=");
    paramString.append(17367040);
    return paramString.toString();
  }
  
  private void f(String paramString)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "scanTorch preLaunchToQQBrowseActivity ");
    paramString = e(paramString);
    getLazyWebView();
    TouchWebView localTouchWebView = this.Q;
    if (localTouchWebView != null)
    {
      localTouchWebView.onResume();
      this.Q.loadUrl(paramString);
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.N.post(new ARScanEntryView.11(this));
      return;
    }
    this.N.post(new ARScanEntryView.12(this));
  }
  
  private MapView getDailogMapView()
  {
    if (this.aQ == null)
    {
      this.o = false;
      this.aQ = new MapView(this.E);
      if (this.aQ.getMap().getUiSettings() != null)
      {
        this.aQ.getMap().getUiSettings().setLogoPosition(0);
        this.aQ.getMap().getUiSettings().setScaleViewEnabled(false);
        this.aQ.getMap().getUiSettings().setScrollGesturesEnabled(false);
      }
      TencentMap localTencentMap = this.aQ.getMap();
      localTencentMap.setOnCameraChangeListener(new ARScanEntryView.33(this));
      localTencentMap.setOnMapLoadedCallback(new ARScanEntryView.34(this));
      this.aQ.setEnabled(true);
      this.aQ.setClickable(true);
    }
    return this.aQ;
  }
  
  private TouchWebView getLazyWebView()
  {
    if (this.Q == null) {
      x();
    }
    return this.Q;
  }
  
  private void h(boolean paramBoolean)
  {
    Object localObject = this.W;
    if (localObject != null)
    {
      if (((ARTarget)localObject).a == null) {
        return;
      }
      if (this.W.a.m != null) {
        this.l = this.W.a.m.c;
      }
      if (this.aM)
      {
        this.aM = false;
        localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(170.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      }
      if (paramBoolean) {
        AppIntefaceReportWrap.a(this.C, "CliOper", "", "", "0X80069D2", "0X80069D2", 0, 0, "1", this.C.getCurrentAccountUin(), "", "");
      }
    }
  }
  
  private void q()
  {
    long l1 = System.currentTimeMillis();
    this.a = ((RelativeLayout)findViewById(2131445137));
    this.R = ((ViewGroup)findViewById(2131447484));
    UniformUtils.a(this.E, this.R);
    this.T = ((TextView)findViewById(2131447486));
    this.S = ((TextView)findViewById(2131447488));
    Object localObject = this.ah.getString("Title");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.S.setText((CharSequence)localObject);
    }
    this.T.setOnClickListener(this);
    this.T.setContentDescription(HardCodeUtil.a(2131901576));
    this.p = ((TextView)findViewById(2131428703));
    this.P = ((FrameLayout)findViewById(2131450086));
    this.av = ((RelativeLayout)findViewById(2131431387));
    this.av.setOnTouchListener(this.aI);
    this.av.setOnClickListener(this);
    this.av.setContentDescription(HardCodeUtil.a(2131898989));
    this.aw = ((ScanIconAnimateView)findViewById(2131431390));
    this.aw.setPopUpListener(new ARScanEntryView.7(this));
    this.ax = ((ImageView)findViewById(2131433176));
    localObject = (ViewStub)findViewById(2131428700);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      this.at = new ARVideoRecordViewProxy(findViewById(2131428726));
    }
    this.aB = ((RelativeLayout)findViewById(2131428696));
    if (this.z == null)
    {
      this.z = new ARTransferDoorLogicManager();
      localObject = (ScanTorchActivity)this.E;
      this.z.a(this.C, (ScanTorchActivity)localObject, this.aB);
      this.z.i = this;
    }
    if (this.aC) {
      L();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("initView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
    }
  }
  
  private void r()
  {
    Activity localActivity = (Activity)this.E;
    ARVideoRecordUIControllerImpl.a().a(localActivity);
    ARVideoRecordUIControllerImpl.a().a(localActivity);
    ARVideoRecordUIControllerImpl.a().a(this.at);
  }
  
  private void s()
  {
    if (!QQARSession.s())
    {
      QLog.d("AREngine_ARScanEntryView", 1, "ARScanEntryView onCreate error happen");
      return;
    }
    QQARSession localQQARSession = QQARSession.p();
    this.V = localQQARSession;
    this.G = localQQARSession;
    this.V.a(this.E, this.C);
  }
  
  private void setHaveEdge(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("setHaveEdge flag=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.aN == paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "edge show equal so refuse");
      }
      return;
    }
    this.aN = paramBoolean;
    if (this.H.getRenderEngine() != null)
    {
      this.H.getRenderEngine().a(paramBoolean, 0.0F, 1.0F);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, String.format("setHaveEdge do real call flag=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
    }
    this.N.post(new ARScanEntryView.10(this, paramBoolean));
    this.H.b(paramBoolean);
    setAllowShowEntry(paramBoolean);
  }
  
  private boolean t()
  {
    return this.ah.getBoolean("NoLimitParams", true) ^ true;
  }
  
  private void u()
  {
    if (this.ag) {
      return;
    }
    Activity localActivity = (Activity)this.E;
    try
    {
      if ((this.V != null) && (this.V.u()))
      {
        long l1 = System.currentTimeMillis();
        int i1 = this.V.a(false, this.az, this.aC, false, this.af, null, null, this, localActivity, this.z, this.H.getRenderEngine());
        ARReport.a().a(System.currentTimeMillis() - l1, i1);
        if ((i1 == 0) && (this.V.v())) {
          N();
        } else {
          QLog.e("AREngine_ARScanEntryView", 1, String.format("initAr fail. result=%s", new Object[] { Integer.valueOf(i1) }));
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("AREngine_ARScanEntryView", 1, "initAr fail.", localException);
    }
    this.ag = true;
  }
  
  private void v()
  {
    PromotionGuide localPromotionGuide = this.aF;
    if (localPromotionGuide != null)
    {
      localPromotionGuide.a(null);
      this.aF = null;
    }
  }
  
  private void w()
  {
    if (this.aL) {
      return;
    }
    this.aL = true;
    long l1 = System.currentTimeMillis();
    ViewStub localViewStub = (ViewStub)findViewById(2131428693);
    if (localViewStub != null)
    {
      localViewStub.inflate();
      this.h = ((ObjectSurfaceView)super.findViewById(2131439510));
      this.h.setVisibility(8);
      this.q = new FaceUIController(this.E, this.K);
      this.h.a = this.q;
      this.f = ((LinearLayout)super.findViewById(2131450234));
      this.b = ((TextView)super.findViewById(2131447174));
      this.c = ((TextView)super.findViewById(2131447175));
      this.d = ((TextView)super.findViewById(2131447176));
      this.d.setOnClickListener(this);
      this.e = ((FrameLayout)super.findViewById(2131447802));
      this.e.setClickable(true);
      this.e.setOnClickListener(this);
      A();
      C();
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        int i1 = ImmersiveUtils.getStatusBarHeight(this.E);
        this.e.setPadding(0, i1, 0, 0);
      }
      y();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("lazyInitARView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
    }
  }
  
  private void x()
  {
    if (this.Q == null)
    {
      long l1 = System.currentTimeMillis();
      this.Q = ((ScanTorchActivity)this.E).getWebView(null);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.Q.setVisibility(4);
      this.Q.setOnScrollChangedListener(null);
      this.Q.setBackgroundColor(0);
      this.Q.setBackgroundResource(0);
      Drawable localDrawable = this.Q.getBackground();
      if (localDrawable != null) {
        localDrawable.setAlpha(0);
      }
      this.P.setVisibility(0);
      this.P.addView(this.Q, localLayoutParams);
      ARReport.a().a(System.currentTimeMillis() - l1);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, String.format("lazyInitWebView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
      }
    }
  }
  
  private void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("showViewFinder mHasViewFinderShow=%s isPause=%s", new Object[] { Boolean.valueOf(this.r), Boolean.valueOf(this.I) }));
    }
    if (!this.r)
    {
      if (this.I) {
        return;
      }
      this.r = true;
      Object localObject = this.U;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      } else if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      if (this.f != null)
      {
        int i1 = AIOUtils.b(15.0F, getResources());
        this.f.setBackgroundResource(2131168376);
        this.f.setPadding(i1, i1, i1, 0);
        localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(170.0F, getResources());
        if (this.aM)
        {
          this.aM = false;
          ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
        }
        this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
        A();
      }
    }
  }
  
  private void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "hideViewFinder");
    }
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    ((LinearLayout)localObject).setBackgroundResource(2130847277);
    int i1 = AIOUtils.b(15.0F, getResources());
    localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(170.0F, getResources());
    this.f.setPadding(i1, i1, i1, AIOUtils.b(7.0F, getResources()));
    if (this.aM)
    {
      this.aM = false;
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
    }
    localObject = this.U;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.r = false;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.N;
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
    localObject = (ScanTorchActivity)this.E;
    if (((ScanTorchActivity)localObject).mTimeArReady < 0L) {
      ((ScanTorchActivity)localObject).mTimeArReady = System.currentTimeMillis();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onArReady success + time is ");
      localStringBuilder.append(System.currentTimeMillis() - this.aK);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onArReady success-visiable + time is ");
      localStringBuilder.append(System.currentTimeMillis() - ((ScanTorchActivity)localObject).getTimeActivityVisible());
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    }
    this.N.sendEmptyMessage(295);
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
        this.A = paramInt2;
        this.N.sendEmptyMessage(311);
        return;
      }
      this.N.sendEmptyMessage(307);
      return;
    }
    setHaveEdge(false);
    J();
    l();
    this.N.sendEmptyMessage(306);
  }
  
  public void a(int paramInt1, ARTarget paramARTarget, int paramInt2)
  {
    boolean bool2 = true;
    int i2;
    int i1;
    int i3;
    StringBuilder localStringBuilder3;
    if ((paramARTarget != null) && (paramARTarget.a != null))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onARAnimationStateChanged, remainCount ");
      localStringBuilder1.append(paramInt2);
      QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder1.toString());
      boolean bool1 = QLog.isColorLevel();
      i2 = 2;
      if (bool1)
      {
        i1 = this.m;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(paramInt1);
        localStringBuilder1.append(", target=");
        localStringBuilder1.append(paramARTarget);
        QLog.d("AREngine_ARScanEntryView", 2, new Object[] { "onARAnimationStateChanged, mLastArAnimState=", Integer.valueOf(i1), ", newState=", localStringBuilder1.toString() });
      }
      i1 = 100;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 == 3)
            {
              this.n = false;
              this.W = null;
              this.N.post(new ARScanEntryView.24(this));
            }
          }
          else
          {
            try
            {
              paramInt2 = paramARTarget.a.e;
              if (paramInt2 != 0)
              {
                if (paramInt2 != 2)
                {
                  if (paramInt2 != 3)
                  {
                    if (paramInt2 == 4) {
                      break label1389;
                    }
                    i3 = i2;
                    paramInt2 = i1;
                  }
                  else
                  {
                    if (paramARTarget.a.d())
                    {
                      paramInt2 = 2;
                      break label1401;
                    }
                    if (!paramARTarget.a.j()) {
                      break label1398;
                    }
                    paramInt2 = 4;
                    break label1401;
                  }
                }
                else
                {
                  if (paramARTarget.a.j())
                  {
                    paramInt2 = 1;
                    break label1401;
                  }
                  paramInt2 = i1;
                  if (!paramARTarget.a.i()) {
                    break label1401;
                  }
                  paramInt2 = 5;
                  break label1401;
                }
              }
              else if (paramARTarget.a.j())
              {
                paramInt2 = 3;
                i3 = i2;
              }
              else
              {
                i3 = i2;
                paramInt2 = i1;
                if (paramARTarget.a.d())
                {
                  paramInt2 = 0;
                  i3 = i2;
                }
              }
              ReportController.b(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramARTarget.a.f, String.valueOf(paramInt2), String.valueOf(i3), "");
            }
            catch (Exception localException1)
            {
              localStringBuilder3 = new StringBuilder();
              localStringBuilder3.append("0X80081E1 ReportController  error ");
              localStringBuilder3.append(localException1.getMessage());
              QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder3.toString());
            }
            this.n = false;
            this.W = null;
            this.N.post(new ARScanEntryView.23(this));
            AppIntefaceReportWrap.a(this.C, "CliOper", "", "", "0X80069D0", "0X80069D0", 0, 0, "1", this.C.getCurrentAccountUin(), paramARTarget.a.f, "");
          }
        }
        else
        {
          this.W = paramARTarget;
          if (!paramARTarget.a.d()) {
            AppIntefaceReportWrap.a(this.C, "CliOper", "", "", "0X8008144", "0X8008144", 0, 0, "1", this.C.getCurrentAccountUin(), paramARTarget.a.f, "2");
          }
          if ((paramARTarget.a.e != 0) && (paramARTarget.a.e != 5))
          {
            int i4 = ARVideoUtil.a(paramARTarget);
            i3 = i4;
            if (i4 == 0) {
              i3 = 2147483647;
            }
          }
          else
          {
            i3 = 1;
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("AREngineCallback.AR_ANIMATION_STATE_END, remainCount is ");
            localStringBuilder2.append(i3);
            localStringBuilder2.append(",remainCount");
            localStringBuilder2.append(paramInt2);
            QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder2.toString());
          }
          if (paramInt2 == 0) {
            try
            {
              i3 = paramARTarget.a.e;
              if (i3 != 0)
              {
                if (i3 != 2)
                {
                  if (i3 != 3)
                  {
                    if (i3 == 4) {
                      break label1407;
                    }
                    i3 = i2;
                  }
                  else
                  {
                    if (paramARTarget.a.d())
                    {
                      i1 = 2;
                      break label1417;
                    }
                    if (!paramARTarget.a.j()) {
                      break label1413;
                    }
                    i1 = 4;
                    break label1417;
                  }
                }
                else
                {
                  if (paramARTarget.a.j())
                  {
                    i1 = 1;
                    break label1417;
                  }
                  if (!paramARTarget.a.i()) {
                    break label1417;
                  }
                  i1 = 5;
                  break label1417;
                }
              }
              else if (paramARTarget.a.j())
              {
                i1 = 3;
                i3 = i2;
              }
              else
              {
                i3 = i2;
                if (paramARTarget.a.d())
                {
                  i1 = 0;
                  i3 = i2;
                }
              }
              label814:
              ReportController.b(null, "CliOper", "", "", "0X80081E1", "0X80081E1", 0, 0, paramARTarget.a.f, String.valueOf(i1), String.valueOf(i3), "");
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
          if (paramARTarget.a.a != 0) {
            if ((paramARTarget.a.m != null) && (!TextUtils.isEmpty(paramARTarget.a.m.c))) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          this.N.post(new ARScanEntryView.22(this, paramARTarget, paramInt2, bool1));
          AppIntefaceReportWrap.a(this.C, "CliOper", "", "", "0X80069CF", "0X80069CF", 0, 0, "1", this.C.getCurrentAccountUin(), paramARTarget.a.f, "");
        }
      }
      else
      {
        this.n = true;
        this.W = paramARTarget;
        this.N.post(new ARScanEntryView.20(this, paramARTarget));
      }
    }
    for (;;)
    {
      try
      {
        paramInt2 = paramARTarget.a.e;
        if (paramInt2 != 0)
        {
          if (paramInt2 != 2)
          {
            if (paramInt2 != 3)
            {
              if (paramInt2 == 4) {
                break label1423;
              }
              i3 = i2;
              paramInt2 = i1;
            }
            else
            {
              if (paramARTarget.a.d())
              {
                paramInt2 = 2;
                break label1435;
              }
              if (!paramARTarget.a.j()) {
                break label1432;
              }
              paramInt2 = 4;
              break label1435;
            }
          }
          else
          {
            if (paramARTarget.a.j())
            {
              paramInt2 = 1;
              break label1435;
            }
            paramInt2 = i1;
            if (!paramARTarget.a.i()) {
              break label1435;
            }
            paramInt2 = 5;
            break label1435;
          }
        }
        else if (paramARTarget.a.j())
        {
          paramInt2 = 3;
          i3 = i2;
        }
        else
        {
          i3 = i2;
          paramInt2 = i1;
          if (paramARTarget.a.d())
          {
            paramInt2 = 0;
            i3 = i2;
          }
        }
        ReportController.b(null, "CliOper", "", "", "0X80081DF", "0X80081DF", 0, 0, paramARTarget.a.f, String.valueOf(paramInt2), String.valueOf(i3), "");
      }
      catch (Exception localException3)
      {
        localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("0X80081DF ReportController  error ");
        localStringBuilder3.append(localException3.getMessage());
        QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder3.toString());
      }
      if ((paramARTarget.a.m != null) && (paramARTarget.a.m.b))
      {
        this.N.post(new ARScanEntryView.21(this, paramARTarget));
        this.N.sendEmptyMessageDelayed(312, 100000L);
        return;
      }
      AppIntefaceReportWrap.a(this.C, "CliOper", "", "", "0X80069CC", "0X80069CC", 0, 0, "1", this.C.getCurrentAccountUin(), paramARTarget.a.f, "2");
      this.m = paramInt1;
      return;
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, arTarget == null || arTarget.arResourceInfo == null");
      return;
      label1389:
      i3 = 0;
      paramInt2 = i1;
      break;
      label1398:
      paramInt2 = 6;
      label1401:
      i3 = 1;
      break;
      label1407:
      i3 = 0;
      break label814;
      label1413:
      i1 = 6;
      label1417:
      i3 = 1;
      break label814;
      label1423:
      i3 = 0;
      paramInt2 = i1;
      continue;
      label1432:
      paramInt2 = 6;
      label1435:
      i3 = 1;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("AREngine_ARScanEntryView", 2, "onStartLoadUrl");
    this.s = true;
    this.N.post(new ARScanEntryView.26(this, paramString));
    this.N.sendEmptyMessageDelayed(312, 100000L);
  }
  
  public void a(long paramLong, int paramInt, ARRenderTrackInfo paramARRenderTrackInfo, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    J();
    Object localObject;
    if ((paramLong == 128L) && ((paramARLocalRecogResultBase instanceof ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)))
    {
      localObject = (ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)paramARLocalRecogResultBase;
      if (QLog.isColorLevel())
      {
        paramARRenderTrackInfo = new StringBuilder();
        paramARRenderTrackInfo.append(" externalRenderResult info is isValidData=");
        paramARRenderTrackInfo.append(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).b);
        paramARRenderTrackInfo.append("isNeedShowViewFinder ");
        paramARRenderTrackInfo.append(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).c);
        QLog.d("AREngine_ARScanEntryView", 1, paramARRenderTrackInfo.toString());
      }
      if (!((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).b)
      {
        this.ar = false;
        g(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).c);
        this.N.post(new ARScanEntryView.13(this));
        return;
      }
      if (QLog.isColorLevel())
      {
        paramARLocalRecogResultBase = new StringBuilder();
        paramARLocalRecogResultBase.append("MIG object RectF(协议原始的数据) ");
        if (((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e != null) {
          paramARRenderTrackInfo = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.b.toString();
        } else {
          paramARRenderTrackInfo = "error happen";
        }
        paramARLocalRecogResultBase.append(paramARRenderTrackInfo);
        QLog.d("AREngine_MIGObjectClassifyResult", 1, paramARLocalRecogResultBase.toString());
      }
      g(false);
      if (((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e == null) {
        return;
      }
      DrawView2.FaceData localFaceData = new DrawView2.FaceData();
      localFaceData.o = 99.0F;
      paramARRenderTrackInfo = new StringBuilder();
      paramARRenderTrackInfo.append(HardCodeUtil.a(2131898987));
      paramARRenderTrackInfo.append((int)(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.d * 100.0D));
      paramARRenderTrackInfo.append("%");
      localFaceData.g = paramARRenderTrackInfo.toString();
      if (QLog.isColorLevel())
      {
        paramARRenderTrackInfo = new StringBuilder();
        paramARRenderTrackInfo.append(" scantorch activitity result ok ");
        paramARRenderTrackInfo.append(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.d);
        QLog.d("AREngine_MIGObjectClassifyResult", 1, paramARRenderTrackInfo.toString());
      }
      localFaceData.f = 10;
      localFaceData.c = DrawView2.FaceData.a(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.b);
      if (QLog.isColorLevel())
      {
        paramARRenderTrackInfo = new StringBuilder();
        paramARRenderTrackInfo.append("MIG mapMigObjectRect2Screen(协议转化后的数据) object RectF ");
        paramARRenderTrackInfo.append(localFaceData.c);
        QLog.d("AREngine_MIGObjectClassifyResult", 1, paramARRenderTrackInfo.toString());
      }
      localFaceData.a = null;
      localFaceData.p = null;
      localFaceData.n = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.i;
      localFaceData.q = false;
      localFaceData.h = true;
      localFaceData.m = true;
      localFaceData.r = false;
      localFaceData.d = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.c;
      boolean bool = TextUtils.isEmpty(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.e);
      paramARLocalRecogResultBase = " ";
      if (bool) {
        paramARRenderTrackInfo = " ";
      } else {
        paramARRenderTrackInfo = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.e;
      }
      localFaceData.i = paramARRenderTrackInfo;
      if (TextUtils.isEmpty(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.f)) {
        paramARRenderTrackInfo = paramARLocalRecogResultBase;
      } else {
        paramARRenderTrackInfo = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.f;
      }
      localFaceData.j = paramARRenderTrackInfo;
      localFaceData.e = null;
      localFaceData.k = null;
      localFaceData.l = ((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.g;
      if (QLog.isColorLevel())
      {
        paramARRenderTrackInfo = new StringBuilder();
        paramARRenderTrackInfo.append(" label name is ");
        paramARRenderTrackInfo.append(localFaceData.d);
        paramARRenderTrackInfo.append("isAutoJump ");
        paramARRenderTrackInfo.append(localFaceData.n);
        QLog.d("AREngine_ARScanEntryView", 1, paramARRenderTrackInfo.toString());
        if (TextUtils.isEmpty(((ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)localObject).e.f)) {
          QLog.d("AREngine_ARScanEntryView", 1, " profileContent    null  ");
        }
      }
      paramARRenderTrackInfo = this.h;
      if (paramARRenderTrackInfo == null)
      {
        QLog.d("AREngine_ARScanEntryView", 1, " mObjectSurfaceView not ready ");
        return;
      }
      paramARRenderTrackInfo.post(new ARScanEntryView.14(this));
      paramARRenderTrackInfo = new ArrayList();
      paramARRenderTrackInfo.add(localFaceData);
      this.h.setFaceData(paramARRenderTrackInfo);
      return;
    }
    if (paramLong == 4L)
    {
      localObject = this.q;
      if ((localObject != null) && (((FaceUIController)localObject).a != null))
      {
        int i1 = this.q.a.b();
        if ((i1 != 3) && (i1 != 2) && (i1 != 0)) {
          l();
        }
      }
    }
    else
    {
      l();
    }
    if ((QLog.isColorLevel()) && (ARLocalFaceRecog.a))
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
      ((StringBuilder)localObject).append(this.x);
      QLog.d("AREngine_ARScanEntryView", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.x) && (paramLong == 4L) && ((paramARLocalRecogResultBase instanceof ARLocalFaceRecogResult)))
    {
      paramARRenderTrackInfo = (ARLocalFaceRecogResult)paramARLocalRecogResultBase;
      if (paramARRenderTrackInfo == null) {
        return;
      }
      paramARLocalRecogResultBase = (Activity)this.E;
      if ((paramARRenderTrackInfo.c == null) || (paramARRenderTrackInfo.c.size() <= 0))
      {
        localObject = this.q;
        if ((localObject != null) && (((FaceUIController)localObject).b != null) && (this.q.b.isShowing()) && (!paramARLocalRecogResultBase.isFinishing())) {
          this.N.post(new ARScanEntryView.15(this));
        }
      }
      if (paramARRenderTrackInfo.b)
      {
        this.w = false;
        this.N.post(new ARScanEntryView.16(this));
        return;
      }
      if (!this.w)
      {
        this.w = true;
        this.N.post(new ARScanEntryView.17(this));
      }
      if (this.y < 0L) {
        this.y = System.currentTimeMillis();
      }
    }
  }
  
  public void a(long paramLong, ARTarget paramARTarget)
  {
    J();
    l();
    if ((paramARTarget == null) || (paramARTarget.a == null) || (!this.aG)) {}
    try
    {
      localObject = this.V.F();
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
    this.aG = true;
    if (paramARTarget.a.f()) {
      return;
    }
    if ((paramARTarget.a.m != null) && (paramARTarget.a.m.b) && (paramARTarget.a.m.a) && (!TextUtils.isEmpty(paramARTarget.a.m.c)))
    {
      this.N.post(new ARScanEntryView.9(this, paramARTarget));
      if (!this.s)
      {
        this.N.sendEmptyMessage(306);
        this.N.sendEmptyMessageAtTime(313, 100L);
        this.N.sendEmptyMessageDelayed(312, 100000L);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onARRecogComplete start jump :");
        ((StringBuilder)localObject).append(paramARTarget.a.m.c);
        QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if ((paramARTarget.a.e == 6) && (paramARTarget.a.m != null) && (!paramARTarget.a.m.b) && (paramARTarget.a.m.a) && (!TextUtils.isEmpty(paramARTarget.a.m.c)))
    {
      ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, paramARTarget.a.f, "1", "0", "");
      paramARTarget = paramARTarget.a.m.c;
      localObject = (Activity)this.E;
      if (a(paramARTarget))
      {
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramARTarget));
        localIntent.addFlags(268435456);
        localIntent.addCategory("android.intent.category.DEFAULT");
        localIntent.setPackage(this.C.getApp().getPackageName());
        this.E.startActivity(localIntent);
      }
      else
      {
        localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
        localIntent.putExtra("url", paramARTarget);
        localIntent.putExtra("finish_animation_up_down", true);
        ((Activity)localObject).startActivity(localIntent);
      }
      if ((this.E instanceof Activity)) {
        ((Activity)localObject).overridePendingTransition(2130772014, 0);
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
    int i1 = 1;
    if (!paramBoolean) {
      i1 = 100;
    }
    for (;;)
    {
      try
      {
        i2 = paramARTarget.a.e;
        if (i2 != 0)
        {
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if (i2 == 4) {
                break label425;
              }
            }
            else
            {
              if (paramARTarget.a.d())
              {
                i1 = 2;
                break label435;
              }
              if (!paramARTarget.a.j()) {
                break label431;
              }
              i1 = 4;
              break label435;
            }
          }
          else
          {
            if (paramARTarget.a.j())
            {
              i1 = 1;
              break label435;
            }
            if (!paramARTarget.a.i()) {
              break label435;
            }
            i1 = 5;
            break label435;
          }
        }
        else if (paramARTarget.a.j()) {
          i1 = 3;
        } else if (paramARTarget.a.d()) {
          i1 = 0;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("0X80081E0 ReportController  error ");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder2.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramARTarget.a.f, String.valueOf(i1), String.valueOf(i2), "");
      if ((!this.as.containsValue(Integer.valueOf(0))) || (!paramARTarget.a.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "onARStateChanged, AR_RECOG_STATE_LOST in");
        }
        if (this.aa == true) {
          return;
        }
        setHaveEdge(true);
        this.N.post(new ARScanEntryView.18(this));
        return;
        if ((paramARTarget.a.a != 1) || (paramARTarget.a.g != 0)) {
          i1 = 0;
        }
        if ((i1 == 0) || (paramARTarget.a.d()))
        {
          setHaveEdge(false);
          this.N.post(new ARScanEntryView.19(this));
        }
      }
      return;
      int i2 = 2;
      continue;
      label425:
      i2 = 0;
      continue;
      label431:
      i1 = 6;
      label435:
      i2 = 1;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    this.N = new Handler(this);
    this.ah = paramBundle;
    this.ai = this.ah.getLong("downloadItems", 14L);
    this.aC = this.ah.getBoolean("arTransferPromotion", false);
    this.az = this.ah.getBoolean("enableARCloud", true);
    if (this.F == null)
    {
      paramBundle = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131627301, this, false);
      addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
      q();
      r();
      this.F = paramBundle;
    }
    this.K = new ARTipsManager(this.E, (RelativeLayout)this.F, new ARScanEntryView.6(this));
    this.O = ThreadManager.getSubThreadHandler();
    s();
    CameraProxy.a().a(this);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
    }
    this.au = false;
    this.D = true;
  }
  
  public void a(PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "loadTransferDoorGuide ");
    }
    PromotionGuide localPromotionGuide = d(true);
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
    localStringBuilder.append(paramARCloudLBSLocationCheckResult.a);
    localStringBuilder.append(", LBSActivity = ");
    localStringBuilder.append(paramArLBSActivity);
    QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new ARScanEntryView.28(this, paramARCloudLBSLocationCheckResult, paramArLBSActivity));
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    this.N.post(new ARScanEntryView.25(this, paramARRenderMangerInnerCallback, paramArVideoResourceInfo));
  }
  
  public void a(String paramString, PromotionConfigInfo.PromotionItem paramPromotionItem, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryToEnterTransferMode[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mIsTransferDoorMode[");
    localStringBuilder.append(this.aD);
    localStringBuilder.append("], ready[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    this.aD = true;
    this.aC = true;
    if (paramPromotionItem != null) {
      this.S.setText(paramPromotionItem.f);
    }
    L();
    if ((this.z.j != null) && (this.z.j.get() != null)) {
      ((QQARSession)this.z.j.get()).G();
    }
    if (paramBoolean)
    {
      if (paramPromotionItem == null) {
        return;
      }
      this.aE = true;
      e(false);
      b(1);
      paramString = paramPromotionItem.a();
      this.z.a(2);
      this.z.d();
      this.z.g();
      this.z.a(paramString);
      J();
      l();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.K != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTipsWithProgress, from[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], tips[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], progress[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], isVisible[");
      localStringBuilder.append(this.K.c());
      localStringBuilder.append("]");
      QLog.w("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
      this.K.a(paramString2, paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, ARTipsManager.ButtonClickListener paramButtonClickListener)
  {
    if (this.K != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showErrorTips, str[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], isVisible[");
      localStringBuilder.append(this.K.c());
      localStringBuilder.append("]");
      QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      this.K.a(paramString1, paramString2, paramButtonClickListener);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.aE) || (this.am)) && (!this.L))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showLoadProgress, 已经在穿越门里面了, from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.w("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.H.getUniformResManger();
    int i4 = (this.ao + this.an) / 2;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showLoadProgress mCurrentAsyncProgress:=");
    ((StringBuilder)localObject).append(this.ao);
    ((StringBuilder)localObject).append(",mCurrentSyncProgress:=");
    ((StringBuilder)localObject).append(this.an);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    localObject = this.at;
    paramBoolean = false;
    int i1;
    if ((localObject != null) && (((ARVideoRecordViewProxy)localObject).d())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject = this.H.getPromotionManager();
    int i2;
    if ((localObject != null) && (this.aC))
    {
      paramBoolean = ((PromotionRes)localObject).f();
      i2 = ((PromotionRes)localObject).b();
    }
    else
    {
      i2 = 0;
    }
    int i3 = i4;
    if (paramBoolean) {
      i3 = (i4 + i2) / 2;
    }
    if (i1 != 0) {
      l();
    } else {
      a(paramString, HardCodeUtil.a(2131898993), i3);
    }
    G();
    if (!this.aq)
    {
      this.aq = true;
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
      this.w = false;
      this.N.post(new ARScanEntryView.27(this));
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = StringUtil.isEmpty(paramString);
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
  
  public String b(String paramString)
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
  
  public void b()
  {
    QLog.i("AREngine_ARScanEntryView", 1, "onStartPreviewSuccess");
    N();
    O();
    P();
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
    if (d(false) == null) {
      return;
    }
    this.aF.a(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void bZ_()
  {
    QLog.d("AREngine_ARScanEntryView", 2, "ARTransferDoorLogicManager onRenderManagerStarted");
    if ((this.J) && (this.aD) && (this.aA))
    {
      QLog.d("AREngine_ARScanEntryView", 2, "start for next Time");
      this.z.g();
      this.z.a(null);
    }
  }
  
  public void c()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onResume ");
    super.c();
    P();
    if ((!this.aC) && (!this.aD)) {
      setHaveEdge(true);
    }
    this.x = false;
    if (!this.r) {
      y();
    }
    Object localObject = this.Q;
    if (localObject != null) {
      ((TouchWebView)localObject).onResume();
    }
    if (this.ab) {
      setHaveEdge(true);
    }
    localObject = this.as;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    if (this.aa == true)
    {
      setHaveEdge(true);
      localObject = this.Q;
      if (localObject != null) {
        ((TouchWebView)localObject).setVisibility(4);
      }
    }
    this.aa = false;
    this.s = false;
    this.t = false;
    localObject = this.q;
    if ((localObject != null) && (((FaceUIController)localObject).b != null) && (this.q.b.isShowing())) {
      this.q.b.dismiss();
    }
    localObject = this.q;
    if ((localObject != null) && (((FaceUIController)localObject).a != null)) {
      this.q.a.a();
    }
    localObject = this.z;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).c();
    }
    ARVideoRecordUIControllerImpl.a().b();
  }
  
  public void c(String paramString)
  {
    if (this.K != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showErrorTips, str[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isVisible[");
      localStringBuilder.append(this.K.c());
      localStringBuilder.append("]");
      QLog.w("AREngine_ARScanEntryView", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      this.K.a(paramString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doAfterProviderViewClose isPromotionPage =  ");
    localStringBuilder.append(t());
    localStringBuilder.append("mHasReachEntryReady:");
    localStringBuilder.append(this.au);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    if ((t()) || (paramBoolean) || (!this.au)) {
      e();
    }
  }
  
  public PromotionGuide d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPromotionGuide create = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    }
    if (!this.J) {
      return null;
    }
    if ((this.aF == null) && (paramBoolean))
    {
      this.aF = new PromotionGuide((Activity)this.E);
      this.aF.a(this);
    }
    return this.aF;
  }
  
  public void d()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onPause ");
    setHaveEdge(false);
    Q();
    Object localObject = this.z;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).k();
    }
    ARVideoRecordUIControllerImpl.a().i();
    this.x = true;
    localObject = this.Q;
    if (localObject != null) {
      ((TouchWebView)localObject).onPause();
    }
    localObject = this.N;
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessage(307);
    }
    localObject = this.aP;
    if (localObject != null) {
      ((ARLBSPOIDialog)localObject).dismiss();
    }
    localObject = this.aO;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    super.d();
  }
  
  public void d(String paramString)
  {
    a(paramString, false);
  }
  
  public void e()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onDestroy ");
    if (this.ay) {
      AppIntefaceReportWrap.a(this.C, "dc00898", "", this.C.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
    }
    this.H.getUniformResManger().f();
    Object localObject = this.V;
    if ((localObject != null) && (((QQARSession)localObject).u()))
    {
      this.V.n();
      this.V.o();
    }
    this.V = null;
    QQARSession.r();
    CameraProxy.a().b(this);
    localObject = this.z;
    if (localObject != null)
    {
      ((ARTransferDoorLogicManager)localObject).l();
      this.z = null;
    }
    this.C.removeObserver(this.aW);
    ARVideoRecordUIControllerImpl.a().j();
    removeAllViews();
    this.F = null;
    if ((this.E != null) && ((this.E instanceof ScanTorchActivity))) {
      ((ScanTorchActivity)this.E).doReport();
    }
    localObject = this.aw;
    if (localObject != null)
    {
      ((ScanIconAnimateView)localObject).e();
      this.aw.b();
      this.aw = null;
    }
    localObject = this.N;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.N = null;
    }
    this.aj = false;
    this.ak = false;
    this.al = false;
    this.aS = false;
    v();
    this.af = null;
    this.ag = false;
    this.D = false;
    this.L = false;
    this.aL = false;
    super.e();
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTransferDoorGuideImage show = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    }
    if (d(true) == null) {
      return;
    }
    this.aF.a(paramBoolean);
  }
  
  public void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onProviderViewShow. mQQARSession mCurrentStatus:=");
    ((StringBuilder)localObject).append(this.V.l());
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    this.aK = System.currentTimeMillis();
    super.f();
    P();
    I();
    if (!this.aC)
    {
      O();
      setHaveEdge(true);
      this.C.addObserver(this.aW);
      if (R())
      {
        this.ay = true;
        Looper.myQueue().addIdleHandler(this.aH);
      }
    }
    else
    {
      setHaveEdge(false);
    }
    localObject = this.z;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).c();
    }
    ARVideoRecordUIControllerImpl.a().b();
  }
  
  public void f(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateDownloadStatus, from[");
    ((StringBuilder)localObject).append(paramBoolean ^ true);
    ((StringBuilder)localObject).append("]!mAfterDependenceTimeout=");
    ((StringBuilder)localObject).append(this.aj ^ true);
    ((StringBuilder)localObject).append(";mIsDownloadTimeout=");
    ((StringBuilder)localObject).append(this.aS);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    if (((!this.aj) && (!paramBoolean)) || (this.aS)) {
      return;
    }
    localObject = this.H.getUniformResManger();
    PromotionRes localPromotionRes = this.H.getPromotionManager();
    boolean bool1;
    if ((this.aC) && (localPromotionRes != null)) {
      bool1 = localPromotionRes.e(this.C);
    } else {
      bool1 = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateDownloadStatus 2222, ");
    localStringBuilder.append(((ScanEntryResourceDelegate)localObject).j());
    localStringBuilder.append(";");
    localStringBuilder.append(bool1);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    boolean bool2 = ((ScanEntryResourceDelegate)localObject).j();
    int i2 = 0;
    if ((bool2) && (bool1))
    {
      if ((this.ak) || (this.al) || (paramBoolean))
      {
        l();
        this.ak = false;
        this.al = false;
        H();
      }
    }
    else
    {
      if (this.aC)
      {
        i1 = i2;
        if (localPromotionRes == null) {
          break label312;
        }
        i1 = i2;
        if (localPromotionRes.d()) {
          break label312;
        }
        i1 = i2;
        if (((ScanEntryResourceDelegate)localObject).k()) {
          break label312;
        }
      }
      else
      {
        i1 = i2;
        if (((ScanEntryResourceDelegate)localObject).k()) {
          break label312;
        }
      }
      int i1 = 1;
      label312:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDownloadStatus 333, ");
      localStringBuilder.append(((ScanEntryResourceDelegate)localObject).k());
      QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
      if (i1 != 0)
      {
        a("AR组件加载失败", HardCodeUtil.a(2131898992), new ARScanEntryView.37(this, (ScanEntryResourceDelegate)localObject, localPromotionRes));
        this.am = true;
        this.ak = true;
        H();
        if (!this.ap)
        {
          this.ap = true;
          ReportController.b(null, "dc00898", "", "", "0X80085B5", "0X80085B5", 0, 0, "", "", "", "");
        }
      }
      else
      {
        d("updateDownloadStatus");
        this.al = true;
      }
    }
  }
  
  public void g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onProviderViewClose. mQQARSession mCurrentStatus:=");
    ((StringBuilder)localObject).append(this.V.l());
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    super.g();
    Q();
    this.H.getUniformResManger().f();
    setHaveEdge(false);
    J();
    l();
    this.aw.e();
    this.aw.b();
    Looper.myQueue().removeIdleHandler(this.aH);
    this.C.removeObserver(this.aW);
    localObject = this.z;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).k();
    }
    ARVideoRecordUIControllerImpl.a().i();
    this.H.b(true);
    this.aU = false;
  }
  
  public PromotionConfigInfo.PromotionItem getCurrentPromotionItem()
  {
    return this.H.getPromotionManager().a();
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  public void h()
  {
    this.B = true;
    this.N.removeMessages(312);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scanTorch notifyRenderReady ");
    ((StringBuilder)localObject).append(this.t);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    if (this.t)
    {
      i();
      this.N.sendEmptyMessage(307);
      this.N.removeMessages(313);
    }
    localObject = this.V;
    if (localObject != null) {
      ((QQARSession)localObject).E();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 295)
    {
      if (i1 != 296)
      {
        if (i1 != 321)
        {
          if (i1 != 352)
          {
            if (i1 != 324)
            {
              if (i1 != 325)
              {
                switch (i1)
                {
                default: 
                  return true;
                case 313: 
                  this.N.sendEmptyMessageDelayed(313, 50L);
                  this.A += 1;
                  paramMessage = this.g;
                  if (paramMessage == null) {
                    break;
                  }
                  paramMessage.setTotalProgress(this.A);
                  return true;
                case 312: 
                  paramMessage = this.Q;
                  if (paramMessage == null) {
                    break;
                  }
                  paramMessage.onPause();
                  return true;
                case 311: 
                  paramMessage = this.g;
                  if (paramMessage == null) {
                    break;
                  }
                  paramMessage.setTotalProgress(this.A);
                  return true;
                case 310: 
                  E();
                  return true;
                case 309: 
                  E();
                  return true;
                case 308: 
                  E();
                  return true;
                case 307: 
                  paramMessage = this.g;
                  if (paramMessage == null) {
                    break;
                  }
                  this.a.removeView(paramMessage);
                  this.g = null;
                  if (this.ac)
                  {
                    paramMessage = this.N;
                    if (paramMessage != null) {
                      paramMessage.sendEmptyMessageDelayed(352, 2500L);
                    }
                  }
                  QLog.d("AREngine_ARScanEntryView", 1, "MSG_HIDE_SCAN_SUCCESS_PROGRESS,juhua has call finished ");
                  return true;
                case 306: 
                  if (this.g != null) {
                    break;
                  }
                  paramMessage = new RelativeLayout.LayoutParams(-1, -1);
                  this.g = new ScanSuccessView(this.E);
                  this.g.setBackgroundColor(2130706432);
                  this.g.setScale(ScreenUtil.SCREEN_WIDTH);
                  this.a.addView(this.g, paramMessage);
                  this.N.removeMessages(352);
                  if (!D()) {
                    break;
                  }
                  setHaveEdge(false);
                  this.ac = true;
                  return true;
                }
              }
              else
              {
                if (!TextUtils.isEmpty(this.ad))
                {
                  paramMessage = this.p;
                  if (paramMessage != null) {
                    paramMessage.setText(this.ad.replace("\\n", "\n"));
                  }
                }
                if ((!this.aC) && (!this.aD))
                {
                  paramMessage = this.p;
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
              F();
              return true;
            }
          }
          else
          {
            paramMessage = (Activity)this.E;
            if ((this.ac) && (!paramMessage.isFinishing()))
            {
              setHaveEdge(true);
              return true;
            }
          }
        }
        else
        {
          w();
          return true;
        }
      }
      else
      {
        E();
        return true;
      }
    }
    else
    {
      QLog.d("AREngine_ARScanEntryView", 1, "start AR ready");
      h(false);
      this.aA = true;
      K();
    }
    return true;
  }
  
  public void i()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scanTorch notifyRenderReady isNotifyRecivied ");
    ((StringBuilder)localObject).append(this.B);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    if (Build.VERSION.SDK_INT >= 16)
    {
      getLazyWebView();
      this.Q.setVisibility(0);
      this.S.setVisibility(8);
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
    if (this.B)
    {
      ARTransparentWebviewPlugin.b();
      this.N.sendEmptyMessage(307);
    }
  }
  
  public boolean j()
  {
    return this.J;
  }
  
  public boolean k()
  {
    return (this.aA) && (this.J) && (this.V.l() == 2);
  }
  
  public void l()
  {
    ARTipsManager localARTipsManager = this.K;
    if (localARTipsManager != null)
    {
      Throwable localThrowable = null;
      if (localARTipsManager.c()) {
        localThrowable = new Throwable("打印调用栈");
      }
      QLog.w("AREngine_ARScanEntryView", 1, "hideTips", localThrowable);
      this.K.a();
    }
  }
  
  public void m()
  {
    f(false);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.d("AREngine_ARScanEntryView", 1, "onAttachedToWindow ");
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (ScanTorchActivity)this.E;
    int i1 = paramView.getId();
    Object localObject1;
    Object localObject3;
    if (i1 != 2131431387)
    {
      if (i1 != 2131447486)
      {
        if (i1 == 2131447802)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AREngine_ARScanEntryView", 2, "onClick R.id.touch_view");
          }
          localObject1 = this.W;
          if ((localObject1 != null) && (((ARTarget)localObject1).a.m != null) && (!TextUtils.isEmpty(this.W.a.m.c)))
          {
            if (!this.W.a.m.b)
            {
              ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.W.a.f, "0", "1", "");
              if (this.W.a.c()) {
                ReportController.b(null, "CliOper", "", "", "0X80098D1", "0X80098D1", 0, 0, this.W.a.f, "1", "0", "");
              }
              localObject1 = this.W.a.m.c;
              ((ScanTorchActivity)localObject2).setResult(11);
              ARVideoRecordUIControllerImpl.a().b(3);
              if (a((String)localObject1))
              {
                localObject2 = new Intent("android.intent.action.VIEW");
                ((Intent)localObject2).setData(Uri.parse((String)localObject1));
                ((Intent)localObject2).addFlags(268435456);
                ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
                ((Intent)localObject2).setPackage(this.C.getApp().getPackageName());
                this.E.startActivity((Intent)localObject2);
              }
              else
              {
                localObject3 = new Intent((Context)localObject2, QQBrowserActivity.class);
                ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_sacan");
                ((Intent)localObject3).putExtra("url", b((String)localObject1));
                ((ScanTorchActivity)localObject2).startActivity((Intent)localObject3);
              }
              this.ab = true;
            }
            else
            {
              ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.W.a.f, "0", "0", "");
              this.aa = true;
              setHaveEdge(false);
              z();
              A();
              localObject1 = this.V;
              if (localObject1 != null)
              {
                ((QQARSession)localObject1).a(1L);
                this.V.y();
              }
              i();
            }
            localObject1 = this.W;
            if ((localObject1 != null) && (!((ARTarget)localObject1).a.d())) {
              AppIntefaceReportWrap.a(this.C, "CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.C.getCurrentAccountUin(), this.W.a.f, "2");
            }
            C();
          }
          localObject1 = this.W;
          if ((localObject1 != null) && (!TextUtils.isEmpty(((ARTarget)localObject1).a.f))) {
            AppIntefaceReportWrap.a(this.C, "CliOper", "", "", "0X80069D1", "0X80069D1", 0, 0, "1", this.C.getCurrentAccountUin(), this.W.a.f, "");
          }
        }
      }
      else {
        ((ScanTorchActivity)localObject2).doOnBackPressed(false);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("find button clicked what2scanUrl = ");
        ((StringBuilder)localObject1).append(this.ae);
        QLog.d("AREngine_ARScanEntryView", 2, ((StringBuilder)localObject1).toString());
      }
      AppIntefaceReportWrap.a(this.C, "dc00898", "", this.C.getCurrentAccountUin(), "0X8008615", "0X8008615", 0, 0, "", "", "", "");
      localObject1 = ArMapUtil.a(this.C);
      if (this.aw.c())
      {
        this.aw.b();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "isPendulumRunning runiing");
        }
      }
      this.ax.setVisibility(4);
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
        localObject1 = this.ae;
        if (TextUtils.isEmpty(this.ae)) {
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
    this.aJ = new Rect(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    paramRect = (ViewGroup.MarginLayoutParams)this.p.getLayoutParams();
    paramRect.setMargins(paramRect.leftMargin, this.aJ.bottom + AIOUtils.b(30.0F, getResources()), paramRect.rightMargin, paramRect.bottomMargin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView
 * JD-Core Version:    0.7.0.1
 */