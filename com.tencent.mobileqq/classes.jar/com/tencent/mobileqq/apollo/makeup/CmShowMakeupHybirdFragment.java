package com.tencent.mobileqq.apollo.makeup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.google.gson.Gson;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.apollo.ApolloClientQIPCModule;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl;
import com.tencent.mobileqq.apollo.api.web.impl.IApolloJsCallBack;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.view.CmShowAESurfaceView;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper;
import dov.com.qq.im.ae.sink.CmShowAssetsData;
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

public class CmShowMakeupHybirdFragment
  extends WebViewFragment
  implements IApolloJsCallBack
{
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 0.827F, 0.843F, 0.8475F };
  private int jdField_a_of_type_Int;
  private volatile long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private IApolloResManager.ApolloDressInfoListener jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResManager$ApolloDressInfoListener;
  private CmShowEALoader.InitListener jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitListener = new CmShowMakeupHybirdFragment.1(this);
  private CmShowEALoader jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader;
  private CmShowAESurfaceView jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView;
  private CmShowAssetsData jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile long jdField_b_of_type_Long = 0L;
  private CmShowAssetsData jdField_b_of_type_DovComQqImAeSinkCmShowAssetsData;
  private volatile boolean jdField_b_of_type_Boolean = true;
  
  @NotNull
  private IApolloResManager.ApolloDressInfoListener a(@NotNull AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper)
  {
    return new CmShowMakeupHybirdFragment.DressInfoListener(this, this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData, paramCmShowDataWrapper, null);
  }
  
  private void a(@NotNull AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper)
  {
    if (paramCmShowDataWrapper.dressidMaps == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramCmShowDataWrapper.dressidMaps.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Integer)localIterator.next());
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResManager$ApolloDressInfoListener = a(paramCmShowDataWrapper);
    ApolloClientQIPCModule.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResManager$ApolloDressInfoListener);
  }
  
  private void a(CmShowAssetsData paramCmShowAssetsData)
  {
    if (paramCmShowAssetsData == null)
    {
      QLog.d("CmShowMakeupHybirdFragment", 0, "[cmShowSetKapuModel] assetsData is null, return!");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData = paramCmShowAssetsData;
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("CmShowMakeupHybirdFragment", 0, "[cmShowSetKapuModel] not init AEKitView, return!");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.a(paramCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap, paramCmShowAssetsData.b, new CmShowMakeupHybirdFragment.2(this));
    }
    for (;;)
    {
      paramCmShowAssetsData = paramCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (paramCmShowAssetsData.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCmShowAssetsData.next();
        QLog.d("CmShowMakeupHybirdFragment", 1, "[doSetCmShowAssetsData] part : " + localEntry.getKey() + " dressid : " + localEntry.getValue());
      }
      break;
      QLog.e("CmShowMakeupHybirdFragment", 0, "[cmShowSetKapuModel] AEKitView is null, return!");
    }
  }
  
  public CmShowAssetsData a()
  {
    return this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData;
  }
  
  protected CmShowAssetsData a(CmShowAssetsData paramCmShowAssetsData1, CmShowAssetsData paramCmShowAssetsData2, int paramInt)
  {
    if (paramCmShowAssetsData2 == null) {}
    for (;;)
    {
      return paramCmShowAssetsData1;
      if (paramCmShowAssetsData1 == null) {
        return paramCmShowAssetsData2;
      }
      switch (paramInt)
      {
      }
      while (paramCmShowAssetsData1.jdField_a_of_type_JavaUtilHashMap != null)
      {
        paramCmShowAssetsData1.jdField_a_of_type_JavaUtilHashMap.put("role", paramCmShowAssetsData1.jdField_a_of_type_JavaLangString);
        return paramCmShowAssetsData1;
        paramCmShowAssetsData1.b = paramCmShowAssetsData2.b;
        continue;
        String str2 = paramCmShowAssetsData1.b;
        String str1 = paramCmShowAssetsData2.b;
        if (!TextUtils.isEmpty(str1)) {
          if (TextUtils.isEmpty(str2))
          {
            paramCmShowAssetsData1.b = paramCmShowAssetsData2.b;
          }
          else
          {
            try
            {
              paramCmShowAssetsData2 = new JSONObject(str2);
              ApolloUtilImpl.mergeJSON(paramCmShowAssetsData2, new JSONObject(str1));
              str2 = paramCmShowAssetsData2.toString();
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[mergeCmShowAssetsData] TYPE_FACE_INCREMENT  faceDataFullJson: ").append(paramCmShowAssetsData2).append("faceDataPartJsonStr: ").append(str1).append("resultJsonStr: ").append(str2);
                QLog.d("CmShowMakeupHybirdFragment", 1, localStringBuilder.toString());
              }
              paramCmShowAssetsData1.b = str2;
            }
            catch (Exception paramCmShowAssetsData2)
            {
              QLog.e("CmShowMakeupHybirdFragment", 1, "[mergeCmShowAssetsData] TYPE_FACE_INCREMENT error! ", paramCmShowAssetsData2);
            }
            continue;
            paramCmShowAssetsData1.jdField_a_of_type_JavaUtilHashMap = paramCmShowAssetsData2.jdField_a_of_type_JavaUtilHashMap;
            continue;
            paramCmShowAssetsData1.b = paramCmShowAssetsData2.b;
            paramCmShowAssetsData1.jdField_a_of_type_JavaUtilHashMap = paramCmShowAssetsData2.jdField_a_of_type_JavaUtilHashMap;
          }
        }
      }
    }
  }
  
  protected void a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setMaterialPath(this.jdField_a_of_type_JavaLangString);
          }
          return;
        }
        TraceReportUtil.a(126, 3);
        if (getActivity() == null)
        {
          QLog.d("CmShowMakeupHybirdFragment", 1, "[initAEKitView] activity is null  ");
          continue;
        }
        if (this.mUIStyleHandler == null) {
          break label76;
        }
      }
      finally {}
      if (this.mUIStyleHandler.c == null)
      {
        label76:
        QLog.e("CmShowMakeupHybirdFragment", 1, "[inflateAEKitView] error: mUIStyleHandler.webviewWrapper is null! ");
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView = new CmShowAESurfaceView(getActivity());
        Object localObject2 = new ViewGroup.LayoutParams(-1, -1);
        this.mUIStyleHandler.c.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView, 0, (ViewGroup.LayoutParams)localObject2);
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.mUIStyleHandler.c.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
        }
        com.tencent.aekit.openrender.AEDebugConfig.ENABLE_GENDER_DETECT = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setFrameInterval(33);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setBackgroundColor(jdField_a_of_type_ArrayOfFloat[0], jdField_a_of_type_ArrayOfFloat[1], jdField_a_of_type_ArrayOfFloat[2]);
        if (this.jdField_a_of_type_JavaLangString != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setMaterialPath(this.jdField_a_of_type_JavaLangString);
        }
        localObject2 = new Rect(0, 0, this.webView.getMeasuredWidth(), this.webView.getMeasuredHeight() / 2);
        if (QLog.isColorLevel()) {
          QLog.d("CmShowMakeupHybirdFragment", 1, "[initAEKitView] setTouchableRect  " + localObject2);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setTouchableRect((Rect)localObject2);
        QLog.d("CmShowMakeupHybirdFragment", 1, "[initAEKitView] mMaterialPath  " + this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Boolean = true;
        ApolloQualityReportUtil.a("dressup_ini_aekit_view", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
        TraceReportUtil.a(126, 3, 0, new Object[0]);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (CameraController.CameraViewType localCameraViewType = CameraController.CameraViewType.BODY; this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView != null; localCameraViewType = CameraController.CameraViewType.HEAD)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.a(localCameraViewType);
      do
      {
        return;
      } while (paramInt != 1);
    }
    QLog.e("CmShowMakeupHybirdFragment", 0, "[setCameraViewType] mAESurfaceView is null, set viewType failed!");
  }
  
  public void a(CmShowAssetsData paramCmShowAssetsData, int paramInt)
  {
    this.jdField_b_of_type_DovComQqImAeSinkCmShowAssetsData = paramCmShowAssetsData;
    this.jdField_a_of_type_Int = paramInt;
    QLog.d("CmShowMakeupHybirdFragment", 0, "[setCmShowAssetsPartData]:");
    b();
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 126
    //   4: iconst_0
    //   5: ldc_w 371
    //   8: invokestatic 134	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11: aload_0
    //   12: getfield 374	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:isDestroyed	Z
    //   15: ifeq +15 -> 30
    //   18: ldc 126
    //   20: iconst_1
    //   21: ldc_w 376
    //   24: invokestatic 193	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 67	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData	Ldov/com/qq/im/ae/sink/CmShowAssetsData;
    //   35: aload_0
    //   36: getfield 363	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:jdField_b_of_type_DovComQqImAeSinkCmShowAssetsData	Ldov/com/qq/im/ae/sink/CmShowAssetsData;
    //   39: aload_0
    //   40: getfield 365	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:jdField_a_of_type_Int	I
    //   43: invokevirtual 378	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:a	(Ldov/com/qq/im/ae/sink/CmShowAssetsData;Ldov/com/qq/im/ae/sink/CmShowAssetsData;I)Ldov/com/qq/im/ae/sink/CmShowAssetsData;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull -21 -> 27
    //   51: aload_1
    //   52: getfield 143	dov/com/qq/im/ae/sink/CmShowAssetsData:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   55: ifnull -28 -> 27
    //   58: aload_1
    //   59: getfield 143	dov/com/qq/im/ae/sink/CmShowAssetsData:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   62: ldc 201
    //   64: invokevirtual 382	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: ifnull -40 -> 27
    //   70: aload_0
    //   71: aload_1
    //   72: invokespecial 384	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:a	(Ldov/com/qq/im/ae/sink/CmShowAssetsData;)V
    //   75: goto -48 -> 27
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	CmShowMakeupHybirdFragment
    //   46	26	1	localCmShowAssetsData	CmShowAssetsData
    //   78	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	78	finally
    //   30	47	78	finally
    //   51	75	78	finally
  }
  
  public int doCreateLoopStep_InitTitleBar(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitTitleBar(paramBundle);
    if (getActivity() != null) {
      ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
    }
    return i;
  }
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitUIContent(paramBundle);
    if (this.webView != null)
    {
      this.webView.setBackgroundColor(0);
      paramBundle = this.webView.getBackground();
      if (paramBundle != null) {
        paramBundle.setAlpha(0);
      }
      if (this.webView.getChildCount() > 0)
      {
        paramBundle = this.webView.getChildAt(0);
        paramBundle.setBackgroundResource(0);
        paramBundle = paramBundle.getBackground();
        if (paramBundle != null) {
          paramBundle.setAlpha(0);
        }
      }
    }
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.c != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839549);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      paramBundle = new ViewGroup.LayoutParams(-1, ViewUtils.b() / 2);
      this.mUIStyleHandler.c.addView(this.jdField_a_of_type_AndroidWidgetImageView, 0, paramBundle);
    }
    return i;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramInt2 == -1))
    {
      paramIntent = (AECMShowRequestController.CmShowDataWrapper)paramIntent.getSerializableExtra("cms_face_data");
      if (paramIntent != null) {
        break label34;
      }
    }
    label34:
    ApolloJsPluginImpl localApolloJsPluginImpl;
    do
    {
      return;
      a(paramIntent);
      localApolloJsPluginImpl = (ApolloJsPluginImpl)this.webView.getPluginEngine().a("apollo");
    } while (localApolloJsPluginImpl == null);
    localApolloJsPluginImpl.callbackCmShowFaceCameraResult(0, new Gson().toJson(paramIntent.dressidMaps), paramIntent.cmJsonString);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShowMakeupHybirdFragment", 0, "apollo_client CmShowMakeupHybirdFragment start create!");
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ApolloQualityReportUtil.a("dressup_page_expose", String.valueOf(this.jdField_a_of_type_Long));
    TraceReportUtil.a(126);
    TraceReportUtil.a(126, 2);
    TraceReportUtil.a(126, 5);
    TraceReportUtil.a(126, 4);
    boolean bool = super.doOnCreate(paramBundle);
    if (!WebIPCOperator.a().a()) {
      WebIPCOperator.a().a().doBindService(getActivity().getApplicationContext());
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader = new CmShowEALoader(this.uin);
    this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitListener);
    this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader.a(getActivity().getBaseContext());
    QLog.d("CmShowMakeupHybirdFragment", 1, "apollo_client CmShowMakeupHybirdFragment end create! use:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResManager$ApolloDressInfoListener = null;
    TraceReportUtil.b(126);
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    super.onDetectedBlankScreen(paramString, paramInt);
    ApolloQualityReportUtil.a("dressup_web_page_bland_screenr", String.valueOf(paramInt));
    TraceReportUtil.a(126, null, new int[] { 1002 });
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    ApolloQualityReportUtil.a("dressup_web_page_low_memory");
    TraceReportUtil.a(126, null, new int[] { 1001 });
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    ApolloQualityReportUtil.a("dressup_web_page_finish", String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long));
    this.jdField_b_of_type_Long = 0L;
    TraceReportUtil.a(126, 1, 0, new Object[0]);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ApolloQualityReportUtil.a("dressup_web_page_start", String.valueOf(this.jdField_b_of_type_Long));
    TraceReportUtil.a(126, 1);
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView != null) && (getActivity().isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.onPause();
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
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    ApolloQualityReportUtil.a("dressup_web_page_error", String.valueOf(paramInt), paramString1);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslError);
    ApolloQualityReportUtil.a("dressup_web_page_ssl_error", String.valueOf(paramSslError.getPrimaryError()));
  }
  
  public void onResume()
  {
    super.onResume();
    ApolloDtReportUtil.a("dressup_3d_page", "home_page", "expose", null);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    super.onTouch(paramView, paramMotionEvent);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupHybirdFragment
 * JD-Core Version:    0.7.0.1
 */