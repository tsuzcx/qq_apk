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
import com.tencent.crossengine.CEApplication.Builder;
import com.tencent.crossengine.CESurfaceView;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
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
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 0.827F, 0.843F, 0.8475F };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "blush", "eyeshadow", "eyeline", "freckle", "lipstick", "tatoo", "wing", "eyeglasses", "headDress" };
  private int jdField_a_of_type_Int;
  private volatile long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private CmShowAssetsData jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData;
  private CEApplication jdField_a_of_type_ComTencentCrossengineCEApplication;
  private CESurfaceView jdField_a_of_type_ComTencentCrossengineCESurfaceView;
  private CmShowCrossEngineLoader.CEInitListener jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowCrossEngineLoader$CEInitListener = new CmShowMakeupFragment.2(this);
  private CmShowEALoader.InitListener jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitListener = new CmShowMakeupFragment.1(this);
  private CmShowEALoader jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader;
  private IApolloResManager.ApolloDressInfoListener jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloDressInfoListener;
  private CmShowAESurfaceView jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView;
  private CEScriptService jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEScriptService;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile long jdField_b_of_type_Long = 0L;
  private CmShowAssetsData jdField_b_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private volatile boolean c = false;
  private volatile boolean d = true;
  
  @NotNull
  private IApolloResManager.ApolloDressInfoListener a(@NotNull CmShowDataWrapper paramCmShowDataWrapper)
  {
    return new CmShowMakeupFragment.DressInfoListener(this, this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData, paramCmShowDataWrapper, null);
  }
  
  private void a(CmShowAssetsData paramCmShowAssetsData)
  {
    if (paramCmShowAssetsData == null)
    {
      QLog.d("[cmshow]CmShowMakeupFragment", 0, "[cmShowSetKapuModel] assetsData is null, return!");
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData = paramCmShowAssetsData;
    if (CmShowWnsUtils.w()) {
      if ((this.jdField_a_of_type_ComTencentCrossengineCESurfaceView != null) && (this.jdField_a_of_type_ComTencentCrossengineCEApplication != null))
      {
        localObject1 = paramCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = ((String)((Map.Entry)localObject3).getValue()).replace(ApolloConstant.j, "");
          if (!TextUtils.equals((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2), (CharSequence)localObject3))
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localObject3);
            localObject2 = String.format("ce.Level.CMShow.putOn('', '%s');", new Object[] { localObject3 });
            this.jdField_a_of_type_ComTencentCrossengineCEApplication.evaluateJs((String)localObject2);
          }
        }
        localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          if ((!paramCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)))
          {
            this.jdField_a_of_type_JavaUtilHashMap.remove(localObject2);
            localObject2 = String.format("ce.Level.CMShow.takeOff('%s')", new Object[] { localObject2 });
            this.jdField_a_of_type_ComTencentCrossengineCEApplication.evaluateJs((String)localObject2);
          }
          i += 1;
        }
        if (TextUtils.isEmpty(paramCmShowAssetsData.jdField_b_of_type_JavaLangString)) {
          break label468;
        }
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = new JSONObject(paramCmShowAssetsData.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject2).remove("callback");
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label305:
      break label305;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[CrossEngine] doSetCmShowAssetsData error json format. json=");
    ((StringBuilder)localObject2).append(paramCmShowAssetsData.jdField_b_of_type_JavaLangString);
    QLog.e("[cmshow]CmShowMakeupFragment", 1, ((StringBuilder)localObject2).toString());
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, (CharSequence)localObject1))
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject1);
      paramCmShowAssetsData = String.format("ce.Level.CMShow.setFaceJson('%s');", new Object[] { paramCmShowAssetsData.jdField_b_of_type_JavaLangString });
      this.jdField_a_of_type_ComTencentCrossengineCEApplication.evaluateJs(paramCmShowAssetsData);
      return;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[CrossEngine] doSetCmShowAssetsData ");
      if (this.jdField_a_of_type_ComTencentCrossengineCEApplication == null) {
        paramCmShowAssetsData = "mCEApplication == null";
      } else {
        paramCmShowAssetsData = "mCEApplication != null";
      }
      ((StringBuilder)localObject1).append(paramCmShowAssetsData);
      if (this.jdField_a_of_type_ComTencentCrossengineCESurfaceView == null) {
        paramCmShowAssetsData = "mCESurfaceView == null";
      } else {
        paramCmShowAssetsData = "mCESurfaceView != null";
      }
      ((StringBuilder)localObject1).append(paramCmShowAssetsData);
      QLog.e("[cmshow]CmShowMakeupFragment", 1, ((StringBuilder)localObject1).toString());
    }
    label468:
    return;
    if (!this.c)
    {
      QLog.d("[cmshow]CmShowMakeupFragment", 0, "[cmShowSetKapuModel] not init AEKitView, return!");
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView;
    if (localObject1 != null) {
      ((CmShowAESurfaceView)localObject1).a(paramCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap, paramCmShowAssetsData.jdField_b_of_type_JavaLangString, new CmShowMakeupFragment.5(this));
    } else {
      QLog.e("[cmshow]CmShowMakeupFragment", 0, "[cmShowSetKapuModel] AEKitView is null, return!");
    }
    paramCmShowAssetsData = paramCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
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
    this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloDressInfoListener = a(paramCmShowDataWrapper);
    ApolloIPCModule.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloDressInfoListener);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentCrossengineCEApplication != null) {
      return;
    }
    TraceReportUtil.a(126, 8);
    if (getActivity() == null)
    {
      QLog.e("[cmshow]CmShowMakeupFragment", 1, "[initCrossEngine] activity is null");
      return;
    }
    CmShowMakeupFragment.3 local3 = new CmShowMakeupFragment.3(this);
    String str = ApolloConstant.j;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[CrossEngine] assets path=");
      localStringBuilder.append(str);
      QLog.d("[cmshow]CmShowMakeupFragment", 3, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentCrossengineCEApplication = CEApplication.Builder.createBuilder().withContext(getActivity()).setStartUpWorld("Contents/World/EmptyScene.nda").setAssetsPath(str).setLifeCycle(local3).setLogger(new CELogger()).setFontPixelsFactory(new CEFontPixelsFactory()).build();
    this.jdField_a_of_type_ComTencentCrossengineCESurfaceView = this.jdField_a_of_type_ComTencentCrossengineCEApplication.createSurfaceView(getActivity());
    this.jdField_a_of_type_ComTencentCrossengineCESurfaceView.setGestureDetector(new GestureDetector(getActivity(), new CmShowMakeupFragment.CEGestureListener(this)));
    if (getUIStyleHandler() == null) {
      QLog.w("[cmshow]CmShowMakeupFragment", 1, "[CrossEngine] getUIStyleHandler()==null");
    } else if (getUIStyleHandler().c == null) {
      QLog.w("[cmshow]CmShowMakeupFragment", 1, "[CrossEngine] getUIStyleHandler().webviewWrapper == null");
    }
    this.jdField_a_of_type_Boolean = false;
    if ((getUIStyleHandler() != null) && (getUIStyleHandler().c != null)) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEScriptService = new CEScriptService(new CEEngineContext(getContext(), this.jdField_a_of_type_ComTencentCrossengineCEApplication, Scene.MAKEUP_PAGE));
    this.jdField_a_of_type_ComTencentCrossengineCEApplication.setCEJSEventListener(new CmShowMakeupFragment.4(this));
    this.jdField_a_of_type_ComTencentCrossengineCEApplication.startGame();
    TraceReportUtil.a(126, 8, 0, new Object[0]);
  }
  
  private void d()
  {
    QLog.i("[cmshow]CmShowMakeupFragment", 1, "[CrossEngine] add CESurfaceView");
    this.jdField_a_of_type_Int = (ViewUtils.b() / 2);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, this.jdField_a_of_type_Int);
    getUIStyleHandler().c.addView(this.jdField_a_of_type_ComTencentCrossengineCESurfaceView, 0, localLayoutParams);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public CmShowAssetsData a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData;
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
            paramCmShowAssetsData1.jdField_b_of_type_JavaLangString = paramCmShowAssetsData2.jdField_b_of_type_JavaLangString;
            paramCmShowAssetsData1.jdField_a_of_type_JavaUtilHashMap = paramCmShowAssetsData2.jdField_a_of_type_JavaUtilHashMap;
          }
        }
        else {
          paramCmShowAssetsData1.jdField_a_of_type_JavaUtilHashMap = paramCmShowAssetsData2.jdField_a_of_type_JavaUtilHashMap;
        }
      }
      else
      {
        String str2 = paramCmShowAssetsData1.jdField_b_of_type_JavaLangString;
        String str1 = paramCmShowAssetsData2.jdField_b_of_type_JavaLangString;
        if (!TextUtils.isEmpty(str1)) {
          if (TextUtils.isEmpty(str2)) {
            paramCmShowAssetsData1.jdField_b_of_type_JavaLangString = paramCmShowAssetsData2.jdField_b_of_type_JavaLangString;
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
              paramCmShowAssetsData1.jdField_b_of_type_JavaLangString = str2;
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
      paramCmShowAssetsData1.jdField_b_of_type_JavaLangString = paramCmShowAssetsData2.jdField_b_of_type_JavaLangString;
    }
    if (paramCmShowAssetsData1.jdField_a_of_type_JavaUtilHashMap != null) {
      paramCmShowAssetsData1.jdField_a_of_type_JavaUtilHashMap.put("role", paramCmShowAssetsData1.jdField_a_of_type_JavaLangString);
    }
    return paramCmShowAssetsData1;
  }
  
  protected void a()
  {
    try
    {
      if (this.c)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setMaterialPath(this.jdField_b_of_type_JavaLangString);
        }
        return;
      }
      TraceReportUtil.a(126, 3);
      if (getActivity() == null)
      {
        QLog.d("[cmshow]CmShowMakeupFragment", 1, "[initAEKitView] activity is null  ");
        return;
      }
      if ((getUIStyleHandler() != null) && (getUIStyleHandler().c != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView = new CmShowAESurfaceView(getActivity());
        Object localObject1 = new ViewGroup.LayoutParams(-1, -1);
        getUIStyleHandler().c.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView, 0, (ViewGroup.LayoutParams)localObject1);
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          getUIStyleHandler().c.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
        }
        com.tencent.aekit.openrender.AEDebugConfig.ENABLE_GENDER_DETECT = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setFrameInterval(33);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setBackgroundColor(jdField_a_of_type_ArrayOfFloat[0], jdField_a_of_type_ArrayOfFloat[1], jdField_a_of_type_ArrayOfFloat[2]);
        if (this.jdField_b_of_type_JavaLangString != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setMaterialPath(this.jdField_b_of_type_JavaLangString);
        }
        localObject1 = new Rect(0, 0, this.webView.getMeasuredWidth(), this.webView.getMeasuredHeight() / 2);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[initAEKitView] setTouchableRect  ");
          localStringBuilder.append(localObject1);
          QLog.d("[cmshow]CmShowMakeupFragment", 1, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setTouchableRect((Rect)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[initAEKitView] mMaterialPath  ");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        QLog.d("[cmshow]CmShowMakeupFragment", 1, ((StringBuilder)localObject1).toString());
        this.c = true;
        ApolloQualityReportUtil.a("dressup_ini_aekit_view", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
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
    if (CmShowWnsUtils.w())
    {
      if (this.jdField_a_of_type_ComTencentCrossengineCEApplication != null)
      {
        localObject = String.format("ce.Level.CMShow.switchCameraType(%d);", new Object[] { Integer.valueOf(paramInt) });
        this.jdField_a_of_type_ComTencentCrossengineCEApplication.evaluateJs((String)localObject);
      }
      return;
    }
    CmShowAESurfaceView localCmShowAESurfaceView = this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView;
    if (localCmShowAESurfaceView != null)
    {
      localCmShowAESurfaceView.a((CameraController.CameraViewType)localObject);
      return;
    }
    QLog.e("[cmshow]CmShowMakeupFragment", 0, "[setCameraViewType] mAESurfaceView is null, set viewType failed!");
  }
  
  public void a(CmShowAssetsData paramCmShowAssetsData, int paramInt)
  {
    this.jdField_b_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData = paramCmShowAssetsData;
    this.jdField_b_of_type_Int = paramInt;
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
      CmShowAssetsData localCmShowAssetsData = a(this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData, this.jdField_b_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData, this.jdField_b_of_type_Int);
      if ((localCmShowAssetsData != null) && (localCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap != null) && ((localCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap.get("role") != null) || (CmShowWnsUtils.w()))) {
        a(localCmShowAssetsData);
      }
      return;
    }
    finally {}
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
      ApolloJsPluginImpl localApolloJsPluginImpl = (ApolloJsPluginImpl)this.webView.getPluginEngine().a("apollo");
      if (localApolloJsPluginImpl != null) {
        localApolloJsPluginImpl.callbackCmShowFaceCameraResult(0, new Gson().toJson(paramIntent.dressidMaps), paramIntent.cmJsonString);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_client CmShowMakeupFragment start create! HashCode=");
    localStringBuilder.append(hashCode());
    QLog.i("[cmshow]CmShowMakeupFragment", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ApolloQualityReportUtil.a("dressup_page_expose", String.valueOf(this.jdField_a_of_type_Long));
    this.jdField_b_of_type_Boolean = CmShowWnsUtils.w();
    TraceReportUtil.a(126);
    int i;
    if (this.jdField_b_of_type_Boolean) {
      i = 6;
    } else {
      i = 2;
    }
    TraceReportUtil.a(126, i);
    if (this.jdField_b_of_type_Boolean) {
      i = 7;
    } else {
      i = 5;
    }
    TraceReportUtil.a(126, i);
    if (this.jdField_b_of_type_Boolean) {
      i = 9;
    } else {
      i = 4;
    }
    TraceReportUtil.a(126, i);
    boolean bool = super.doOnCreate(paramBundle);
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(getActivity().getApplicationContext());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      paramBundle = new CmShowCrossEngineLoader(getUin());
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowCrossEngineLoader$CEInitListener);
      paramBundle.a(getActivity().getBaseContext());
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_JavaLangString = null;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader = new CmShowEALoader(getUin());
      this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitListener);
      this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader.a(getActivity().getBaseContext());
    }
    paramBundle = new StringBuilder();
    paramBundle.append("apollo_client CmShowMakeupFragment end create! use:");
    paramBundle.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
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
    this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloDressInfoListener = null;
    CEApplication localCEApplication = this.jdField_a_of_type_ComTencentCrossengineCEApplication;
    if (localCEApplication != null)
    {
      localCEApplication.exit();
      this.jdField_a_of_type_ComTencentCrossengineCEApplication.destroy();
      this.jdField_a_of_type_ComTencentCrossengineCEApplication = null;
    }
    TraceReportUtil.b(126);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    ApolloQualityReportUtil.a("dressup_web_page_low_memory");
    int i;
    if (this.jdField_b_of_type_Boolean) {
      i = 1003;
    } else {
      i = 1001;
    }
    TraceReportUtil.a(126, null, new int[] { i });
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView != null) && (getActivity().isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.onPause();
    }
    if ((this.jdField_a_of_type_ComTencentCrossengineCEApplication != null) && (getActivity().isFinishing())) {
      this.jdField_a_of_type_ComTencentCrossengineCEApplication.pause();
    }
    super.onPause();
    if (this.jdField_a_of_type_Long != 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
      ApolloDtReportUtil.a("dressup_3d_page", "home_page", "stay", localHashMap);
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ApolloDtReportUtil.a("dressup_3d_page", "home_page", "expose", null);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    CEApplication localCEApplication = this.jdField_a_of_type_ComTencentCrossengineCEApplication;
    if (localCEApplication != null) {
      localCEApplication.resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment
 * JD-Core Version:    0.7.0.1
 */