package com.tencent.mobileqq.apollo.makeup;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.tencent.TMG.utils.QLog;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.CEApplicationBuilder;
import com.tencent.crossengine.CERenderView;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.ipc.business.ICMResManager;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.view.CmShowAESurfaceView;
import com.tencent.mobileqq.apollo.web.IApolloJsCallBack;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl;
import com.tencent.mobileqq.cmshow.crossengine.CEEngineContext;
import com.tencent.mobileqq.cmshow.crossengine.CEScriptService;
import com.tencent.mobileqq.cmshow.crossengine.util.CEFontPixelsFactory;
import com.tencent.mobileqq.cmshow.crossengine.util.CELogger;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.light.CameraController.CameraViewType;

public class CmShowMakeupFragment
  extends WebViewFragment
  implements IApolloJsCallBack
{
  private static final float[] u = { 0.827F, 0.843F, 0.8475F };
  private static final String[] w = { "blush", "eyeshadow", "eyeline", "freckle", "lipstick", "tatoo", "wing", "eyeglasses", "headDress" };
  private CEApplication a;
  private CERenderView b;
  private int c;
  private volatile boolean d;
  private boolean e;
  private CEScriptService f;
  private HashMap<String, String> g;
  private String h;
  private CmShowAESurfaceView i;
  private ImageView j;
  private String k;
  private CmShowAssetsData l;
  private CmShowAssetsData m;
  private int n;
  private volatile boolean o = false;
  private Handler p = new Handler(Looper.getMainLooper());
  private CmShowEALoader q;
  private volatile long r = 0L;
  private volatile long s = 0L;
  private volatile boolean t = true;
  private IApolloResManager.ApolloDressInfoListener v;
  private CmShowEALoader.InitListener x = new CmShowMakeupFragment.1(this);
  private CmShowCrossEngineLoader.CEInitListener y = new CmShowMakeupFragment.2(this);
  
  private void a(CmShowAssetsData paramCmShowAssetsData)
  {
    if (paramCmShowAssetsData == null)
    {
      QLog.d("[cmshow]CmShowMakeupFragment", 0, "[cmShowSetKapuModel] assetsData is null, return!");
      return;
    }
    this.l = paramCmShowAssetsData;
    if (CMShowPlatform.a.b(Scene.MAKE_UP_3D)) {
      if ((this.b != null) && (this.a != null))
      {
        localObject1 = paramCmShowAssetsData.b.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          if (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject3).getValue()))
          {
            localObject3 = ((String)((Map.Entry)localObject3).getValue()).replace(ApolloConstant.k, "");
            if (!TextUtils.equals((CharSequence)this.g.get(localObject2), (CharSequence)localObject3))
            {
              this.g.put(localObject2, localObject3);
              localObject2 = String.format("ce.Level.CMShow.putOn('', '%s');", new Object[] { localObject3 });
              this.a.evaluateJs((String)localObject2);
            }
          }
        }
        localObject1 = w;
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          localObject2 = localObject1[i1];
          if ((!paramCmShowAssetsData.b.containsKey(localObject2)) && (this.g.containsKey(localObject2)))
          {
            this.g.remove(localObject2);
            localObject2 = String.format("ce.Level.CMShow.takeOff('%s')", new Object[] { localObject2 });
            this.a.evaluateJs((String)localObject2);
          }
          i1 += 1;
        }
        if (TextUtils.isEmpty(paramCmShowAssetsData.c)) {
          break label493;
        }
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = new JSONObject(paramCmShowAssetsData.c);
      ((JSONObject)localObject2).remove("callback");
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label330:
      break label330;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[CrossEngine] doSetCmShowAssetsData error json format. json=");
    ((StringBuilder)localObject2).append(paramCmShowAssetsData.c);
    QLog.e("[cmshow]CmShowMakeupFragment", 1, ((StringBuilder)localObject2).toString());
    if (!TextUtils.equals(this.h, (CharSequence)localObject1))
    {
      this.h = ((String)localObject1);
      paramCmShowAssetsData = String.format("ce.Level.CMShow.setFaceJson('%s');", new Object[] { paramCmShowAssetsData.c });
      this.a.evaluateJs(paramCmShowAssetsData);
      return;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[CrossEngine] doSetCmShowAssetsData ");
      if (this.a == null) {
        paramCmShowAssetsData = "mCEApplication == null";
      } else {
        paramCmShowAssetsData = "mCEApplication != null";
      }
      ((StringBuilder)localObject1).append(paramCmShowAssetsData);
      if (this.b == null) {
        paramCmShowAssetsData = "mCESurfaceView == null";
      } else {
        paramCmShowAssetsData = "mCESurfaceView != null";
      }
      ((StringBuilder)localObject1).append(paramCmShowAssetsData);
      QLog.e("[cmshow]CmShowMakeupFragment", 1, ((StringBuilder)localObject1).toString());
    }
    label493:
    return;
    if (!this.o)
    {
      QLog.d("[cmshow]CmShowMakeupFragment", 0, "[cmShowSetKapuModel] not init AEKitView, return!");
      return;
    }
    Object localObject1 = this.i;
    if (localObject1 != null) {
      ((CmShowAESurfaceView)localObject1).a(paramCmShowAssetsData.b, paramCmShowAssetsData.c, new CmShowMakeupFragment.5(this));
    } else {
      QLog.e("[cmshow]CmShowMakeupFragment", 0, "[cmShowSetKapuModel] AEKitView is null, return!");
    }
    paramCmShowAssetsData = paramCmShowAssetsData.b.entrySet().iterator();
    while (paramCmShowAssetsData.hasNext())
    {
      localObject1 = (Map.Entry)paramCmShowAssetsData.next();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[doSetCmShowAssetsData] part : ");
      ((StringBuilder)localObject2).append(((Map.Entry)localObject1).getKey());
      ((StringBuilder)localObject2).append(" dressid : ");
      ((StringBuilder)localObject2).append(((Map.Entry)localObject1).getValue());
      QLog.d("[cmshow]CmShowMakeupFragment", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void a(@NotNull CmShowDataWrapper paramCmShowDataWrapper)
  {
    if (paramCmShowDataWrapper.dressidMaps == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramCmShowDataWrapper.dressidMaps.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Integer)localIterator.next());
    }
    this.v = b(paramCmShowDataWrapper);
    ((ICMResManager)ApolloIPCModule.a(ICMResManager.class)).a(localArrayList, 1, this.v);
  }
  
  @NotNull
  private IApolloResManager.ApolloDressInfoListener b(@NotNull CmShowDataWrapper paramCmShowDataWrapper)
  {
    return new CmShowMakeupFragment.DressInfoListener(this, this.l, paramCmShowDataWrapper, null);
  }
  
  private void d()
  {
    if (this.a != null) {
      return;
    }
    TraceReportUtil.a(126, 8);
    if (getActivity() == null)
    {
      QLog.e("[cmshow]CmShowMakeupFragment", 1, "[initCrossEngine] activity is null");
      return;
    }
    CmShowMakeupFragment.3 local3 = new CmShowMakeupFragment.3(this);
    String str = ApolloConstant.k;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[CrossEngine] assets path=");
      localStringBuilder.append(str);
      QLog.d("[cmshow]CmShowMakeupFragment", 3, localStringBuilder.toString());
    }
    this.a = CEApplicationBuilder.createBuilder().withContext(getActivity()).setStartUpWorld("Contents/World/EmptyScene.nda").setAssetsPath(str).setLifeCycle(local3).setLogger(new CELogger()).setFontPixelsFactory(new CEFontPixelsFactory()).build();
    this.b = this.a.createRenderView(getActivity());
    this.b.setGestureDetector(new GestureDetector(getActivity(), new CmShowMakeupFragment.CEGestureListener(this)));
    if (getUIStyleHandler() == null) {
      QLog.w("[cmshow]CmShowMakeupFragment", 1, "[CrossEngine] getUIStyleHandler()==null");
    } else if (getUIStyleHandler().u == null) {
      QLog.w("[cmshow]CmShowMakeupFragment", 1, "[CrossEngine] getUIStyleHandler().webviewWrapper == null");
    }
    this.d = false;
    if ((getUIStyleHandler() != null) && (getUIStyleHandler().u != null)) {
      e();
    }
    this.f = new CEScriptService(new CEEngineContext(getContext(), this.a, Scene.MAKE_UP_3D));
    this.a.setCEJSEventListener(new CmShowMakeupFragment.4(this));
    this.a.setEnableGPUSkinning(false);
    try
    {
      this.a.startGame();
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]CmShowMakeupFragment", 1, "[CrossEngine] initCrossEngine error", localException);
    }
    TraceReportUtil.a(126, 8, 0, new Object[0]);
  }
  
  private void e()
  {
    QLog.i("[cmshow]CmShowMakeupFragment", 1, "[CrossEngine] add CESurfaceView");
    this.c = (ViewUtils.getScreenHeight() / 2);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, this.c);
    getUIStyleHandler().u.addView(this.b, 0, localLayoutParams);
    this.d = true;
  }
  
  protected CmShowAssetsData a(CmShowAssetsData paramCmShowAssetsData1, CmShowAssetsData paramCmShowAssetsData2, int paramInt)
  {
    if (paramCmShowAssetsData2 == null) {
      return paramCmShowAssetsData1;
    }
    if (paramCmShowAssetsData1 == null) {
      return paramCmShowAssetsData2;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            paramCmShowAssetsData1.c = paramCmShowAssetsData2.c;
            paramCmShowAssetsData1.b = paramCmShowAssetsData2.b;
          }
        }
        else {
          paramCmShowAssetsData1.b = paramCmShowAssetsData2.b;
        }
      }
      else
      {
        String str2 = paramCmShowAssetsData1.c;
        String str1 = paramCmShowAssetsData2.c;
        if (!TextUtils.isEmpty(str1)) {
          if (TextUtils.isEmpty(str2)) {
            paramCmShowAssetsData1.c = paramCmShowAssetsData2.c;
          } else {
            try
            {
              paramCmShowAssetsData2 = new JSONObject(str2);
              ApolloUtilImpl.mergeJSON(paramCmShowAssetsData2, new JSONObject(str1));
              str2 = paramCmShowAssetsData2.toString();
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[mergeCmShowAssetsData] TYPE_FACE_INCREMENT  faceDataFullJson: ");
                localStringBuilder.append(paramCmShowAssetsData2);
                localStringBuilder.append("faceDataPartJsonStr: ");
                localStringBuilder.append(str1);
                localStringBuilder.append("resultJsonStr: ");
                localStringBuilder.append(str2);
                QLog.d("[cmshow]CmShowMakeupFragment", 1, localStringBuilder.toString());
              }
              paramCmShowAssetsData1.c = str2;
            }
            catch (Exception paramCmShowAssetsData2)
            {
              QLog.e("[cmshow]CmShowMakeupFragment", 1, "[mergeCmShowAssetsData] TYPE_FACE_INCREMENT error! ", paramCmShowAssetsData2);
            }
          }
        }
      }
    }
    else {
      paramCmShowAssetsData1.c = paramCmShowAssetsData2.c;
    }
    if (paramCmShowAssetsData1.b != null) {
      paramCmShowAssetsData1.b.put("role", paramCmShowAssetsData1.a);
    }
    return paramCmShowAssetsData1;
  }
  
  protected void a()
  {
    try
    {
      if (this.o)
      {
        if (this.i != null) {
          this.i.setMaterialPath(this.k);
        }
        return;
      }
      TraceReportUtil.a(126, 3);
      if (getActivity() == null)
      {
        QLog.d("[cmshow]CmShowMakeupFragment", 1, "[initAEKitView] activity is null  ");
        return;
      }
      if ((getUIStyleHandler() != null) && (getUIStyleHandler().u != null))
      {
        this.i = new CmShowAESurfaceView(getActivity());
        Object localObject1 = new ViewGroup.LayoutParams(-1, -1);
        getUIStyleHandler().u.addView(this.i, 0, (ViewGroup.LayoutParams)localObject1);
        if (this.j != null) {
          getUIStyleHandler().u.removeView(this.j);
        }
        com.tencent.aekit.openrender.AEDebugConfig.ENABLE_GENDER_DETECT = false;
        this.i.setFrameInterval(33);
        this.i.setBackgroundColor(u[0], u[1], u[2]);
        if (this.k != null) {
          this.i.setMaterialPath(this.k);
        }
        localObject1 = new Rect(0, 0, this.webView.getMeasuredWidth(), this.webView.getMeasuredHeight() / 2);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[initAEKitView] setTouchableRect  ");
          localStringBuilder.append(localObject1);
          QLog.d("[cmshow]CmShowMakeupFragment", 1, localStringBuilder.toString());
        }
        this.i.setTouchableRect((Rect)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[initAEKitView] mMaterialPath  ");
        ((StringBuilder)localObject1).append(this.k);
        QLog.d("[cmshow]CmShowMakeupFragment", 1, ((StringBuilder)localObject1).toString());
        this.o = true;
        ApolloQualityReportUtil.a("dressup_ini_aekit_view", String.valueOf(System.currentTimeMillis() - this.r));
        TraceReportUtil.a(126, 3, 0, new Object[0]);
        return;
      }
      QLog.e("[cmshow]CmShowMakeupFragment", 1, "[inflateAEKitView] error: mUIStyleHandler.webviewWrapper is null! ");
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = CameraController.CameraViewType.BODY;
    }
    else
    {
      if (paramInt != 1) {
        return;
      }
      localObject = CameraController.CameraViewType.HEAD;
    }
    if (CMShowPlatform.a.b(Scene.MAKE_UP_3D))
    {
      if (this.a != null)
      {
        localObject = String.format("ce.Level.CMShow.switchCameraType(%d);", new Object[] { Integer.valueOf(paramInt) });
        this.a.evaluateJs((String)localObject);
      }
      return;
    }
    CmShowAESurfaceView localCmShowAESurfaceView = this.i;
    if (localCmShowAESurfaceView != null)
    {
      localCmShowAESurfaceView.a((CameraController.CameraViewType)localObject);
      return;
    }
    QLog.e("[cmshow]CmShowMakeupFragment", 0, "[setCameraViewType] mAESurfaceView is null, set viewType failed!");
  }
  
  public void a(CmShowAssetsData paramCmShowAssetsData, int paramInt)
  {
    this.m = paramCmShowAssetsData;
    this.n = paramInt;
    QLog.d("[cmshow]CmShowMakeupFragment", 0, "[setCmShowAssetsPartData]:");
    b();
  }
  
  protected void b()
  {
    try
    {
      QLog.d("[cmshow]CmShowMakeupFragment", 0, "[CrossEngine][cmShowSetKapuModel][updateAssetsData2Render]:尝试更新资源");
      if (this.isDestroyed)
      {
        QLog.e("[cmshow]CmShowMakeupFragment", 1, "[updateAssetsData2Render] return! Fragment is destroyed!");
        return;
      }
      CmShowAssetsData localCmShowAssetsData = a(this.l, this.m, this.n);
      if ((localCmShowAssetsData != null) && (localCmShowAssetsData.b != null) && ((localCmShowAssetsData.b.get("role") != null) || (CMShowPlatform.a.b(Scene.MAKE_UP_3D)))) {
        a(localCmShowAssetsData);
      }
      return;
    }
    finally {}
  }
  
  public CmShowAssetsData c()
  {
    return this.l;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramInt2 == -1))
    {
      paramIntent = (CmShowDataWrapper)paramIntent.getSerializableExtra("cms_face_data");
      if (paramIntent == null) {
        return;
      }
      a(paramIntent);
      ApolloJsPluginImpl localApolloJsPluginImpl = (ApolloJsPluginImpl)this.webView.getPluginEngine().b("apollo");
      if (localApolloJsPluginImpl != null) {
        localApolloJsPluginImpl.notifyCmShowFaceCameraResult(0, new Gson().toJson(paramIntent.dressidMaps), paramIntent.cmJsonString);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_client CmShowMakeupFragment start create! HashCode=");
    localStringBuilder.append(hashCode());
    QLog.i("[cmshow]CmShowMakeupFragment", 1, localStringBuilder.toString());
    this.r = System.currentTimeMillis();
    ApolloQualityReportUtil.a("dressup_page_expose", String.valueOf(this.r));
    this.e = CMShowPlatform.a.b(Scene.MAKE_UP_3D);
    TraceReportUtil.a(126);
    int i1;
    if (this.e) {
      i1 = 6;
    } else {
      i1 = 2;
    }
    TraceReportUtil.a(126, i1);
    if (this.e) {
      i1 = 7;
    } else {
      i1 = 5;
    }
    TraceReportUtil.a(126, i1);
    if (this.e) {
      i1 = 9;
    } else {
      i1 = 4;
    }
    TraceReportUtil.a(126, i1);
    boolean bool = super.doOnCreate(paramBundle);
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(getActivity().getApplicationContext());
    }
    if (this.e)
    {
      paramBundle = new CmShowCrossEngineLoader(getUin());
      paramBundle.a(this.y);
      paramBundle.a(getActivity().getBaseContext());
      this.g = new HashMap();
      this.h = null;
    }
    else
    {
      this.q = new CmShowEALoader(getUin());
      this.q.a(this.x);
      this.q.a(getActivity().getBaseContext());
    }
    paramBundle = new StringBuilder();
    paramBundle.append("apollo_client CmShowMakeupFragment end create! use:");
    paramBundle.append(System.currentTimeMillis() - this.r);
    QLog.d("[cmshow]CmShowMakeupFragment", 1, paramBundle.toString());
    return bool;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new CmShowMakeupFragment.6(this, this.webViewSurface);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.i = null;
    this.v = null;
    CEApplication localCEApplication = this.a;
    if (localCEApplication != null)
    {
      localCEApplication.exit();
      this.a.destroy();
      this.a = null;
    }
    TraceReportUtil.b(126);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    ApolloQualityReportUtil.a("dressup_web_page_low_memory");
    int i1;
    if (this.e) {
      i1 = 1003;
    } else {
      i1 = 1001;
    }
    TraceReportUtil.a(126, null, new int[] { i1 });
  }
  
  public void onPause()
  {
    if ((this.i != null) && (getActivity().isFinishing())) {
      this.i.onPause();
    }
    if ((this.a != null) && (getActivity().isFinishing())) {
      this.a.pause();
    }
    super.onPause();
    if (this.r != 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", String.valueOf(System.currentTimeMillis() - this.r));
      ApolloDtReportUtil.a("dressup_3d_page", "home_page", "stay", localHashMap);
      this.r = 0L;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ApolloDtReportUtil.a("dressup_3d_page", "home_page", "expose", null);
    if (this.r == 0L) {
      this.r = System.currentTimeMillis();
    }
    CEApplication localCEApplication = this.a;
    if (localCEApplication != null) {
      localCEApplication.resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment
 * JD-Core Version:    0.7.0.1
 */