package com.tencent.mobileqq.apollo.makeup;

import amlo;
import amod;
import amtl;
import amup;
import amuy;
import amvb;
import amvc;
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
import anis;
import ankl;
import anlx;
import ashz;
import com.google.gson.Gson;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.CmShowAESurfaceView;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.filament.CMShowUserLoader;
import com.tencent.ttpic.filament.CameraViewType;
import com.tencent.ttpic.filament.CmShowAssetsData;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class CmShowMakeupHybirdFragment
  extends WebViewFragment
  implements amtl
{
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 0.827F, 0.843F, 0.8475F };
  private int jdField_a_of_type_Int;
  private volatile long jdField_a_of_type_Long;
  private amod jdField_a_of_type_Amod;
  private amup jdField_a_of_type_Amup;
  private amuy jdField_a_of_type_Amuy = new amvb(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private CmShowAESurfaceView jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView;
  private CMShowUserLoader jdField_a_of_type_ComTencentTtpicFilamentCMShowUserLoader;
  private CmShowAssetsData jdField_a_of_type_ComTencentTtpicFilamentCmShowAssetsData;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile long jdField_b_of_type_Long;
  private CmShowAssetsData jdField_b_of_type_ComTencentTtpicFilamentCmShowAssetsData;
  private volatile boolean jdField_b_of_type_Boolean = true;
  
  @NotNull
  private amod a(@NotNull AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper)
  {
    return new amvc(this, paramCmShowDataWrapper);
  }
  
  private void a(CmShowAssetsData paramCmShowAssetsData)
  {
    if (paramCmShowAssetsData == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentTtpicFilamentCmShowAssetsData = paramCmShowAssetsData;
    } while (!this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentTtpicFilamentCMShowUserLoader == null) {
      this.jdField_a_of_type_ComTencentTtpicFilamentCMShowUserLoader = new CMShowUserLoader();
    }
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicFilamentCMShowUserLoader.setCmShowAssetsData(paramCmShowAssetsData, new CmShowMakeupHybirdFragment.2(this));
      localObject = new ArrayList();
      ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentTtpicFilamentCMShowUserLoader);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setParam("setFilamentUserLoader", localObject);
      }
    }
    for (;;)
    {
      paramCmShowAssetsData = paramCmShowAssetsData.dressResMap.entrySet().iterator();
      while (paramCmShowAssetsData.hasNext())
      {
        localObject = (Map.Entry)paramCmShowAssetsData.next();
        QLog.d("CmShowMakeupHybirdFragment", 1, "[doSetCmShowAssetsData] part : " + ((Map.Entry)localObject).getKey() + " dressid : " + ((Map.Entry)localObject).getValue());
      }
      break;
      this.jdField_a_of_type_ComTencentTtpicFilamentCMShowUserLoader.setCmShowAssetsData(paramCmShowAssetsData);
    }
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
    this.jdField_a_of_type_Amod = a(paramCmShowDataWrapper);
    amlo.a(localArrayList, this.jdField_a_of_type_Amod);
  }
  
  public CmShowAssetsData a()
  {
    return this.jdField_a_of_type_ComTencentTtpicFilamentCmShowAssetsData;
  }
  
  protected CmShowAssetsData a(CmShowAssetsData paramCmShowAssetsData1, CmShowAssetsData paramCmShowAssetsData2, int paramInt)
  {
    if (paramCmShowAssetsData2 == null) {}
    String str2;
    String str1;
    do
    {
      return paramCmShowAssetsData1;
      if (paramCmShowAssetsData1 == null) {
        return paramCmShowAssetsData2;
      }
      switch (paramInt)
      {
      default: 
        return paramCmShowAssetsData1;
      case 0: 
        paramCmShowAssetsData1.faceDataJsonStr = paramCmShowAssetsData2.faceDataJsonStr;
        return paramCmShowAssetsData1;
      case 1: 
        str2 = paramCmShowAssetsData1.faceDataJsonStr;
        str1 = paramCmShowAssetsData2.faceDataJsonStr;
      }
    } while (TextUtils.isEmpty(str1));
    if (TextUtils.isEmpty(str2))
    {
      paramCmShowAssetsData1.faceDataJsonStr = paramCmShowAssetsData2.faceDataJsonStr;
      return paramCmShowAssetsData1;
    }
    try
    {
      paramCmShowAssetsData2 = new JSONObject(str2);
      ApolloUtil.a(paramCmShowAssetsData2, new JSONObject(str1));
      str2 = paramCmShowAssetsData2.toString();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[mergeCmShowAssetsData] TYPE_FACE_INCREMENT  faceDataFullJson: ").append(paramCmShowAssetsData2).append("faceDataPartJsonStr: ").append(str1).append("resultJsonStr: ").append(str2);
        QLog.d("CmShowMakeupHybirdFragment", 1, new Object[] { localStringBuilder });
      }
      paramCmShowAssetsData1.faceDataJsonStr = str2;
      return paramCmShowAssetsData1;
    }
    catch (Exception paramCmShowAssetsData2)
    {
      QLog.e("CmShowMakeupHybirdFragment", 1, "[mergeCmShowAssetsData] TYPE_FACE_INCREMENT error! ", paramCmShowAssetsData2);
      return paramCmShowAssetsData1;
    }
    paramCmShowAssetsData1.dressResMap = paramCmShowAssetsData2.dressResMap;
    return paramCmShowAssetsData1;
    paramCmShowAssetsData1.faceDataJsonStr = paramCmShowAssetsData2.faceDataJsonStr;
    paramCmShowAssetsData1.dressResMap = paramCmShowAssetsData2.dressResMap;
    return paramCmShowAssetsData1;
  }
  
  protected void a()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        anis.a(126, 3);
        if (getActivity() == null)
        {
          QLog.d("CmShowMakeupHybirdFragment", 1, "[initAEKitView] activity is null  ");
          continue;
        }
        if (this.mUIStyleHandler == null) {
          break label60;
        }
      }
      finally {}
      if (this.mUIStyleHandler.webviewWrapper == null)
      {
        label60:
        QLog.e("CmShowMakeupHybirdFragment", 1, "[inflateAEKitView] error: mUIStyleHandler.webviewWrapper is null! ");
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView = new CmShowAESurfaceView(getActivity());
        Object localObject2 = new ViewGroup.LayoutParams(-1, -1);
        this.mUIStyleHandler.webviewWrapper.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView, 0, (ViewGroup.LayoutParams)localObject2);
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.mUIStyleHandler.webviewWrapper.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
        }
        com.tencent.aekit.openrender.AEDebugConfig.ENABLE_GENDER_DETECT = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setFrameInterval(33);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setMaterialPath(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setBackgroundColor(jdField_a_of_type_ArrayOfFloat[0], jdField_a_of_type_ArrayOfFloat[1], jdField_a_of_type_ArrayOfFloat[2]);
        localObject2 = new Rect(0, 0, this.webView.getMeasuredWidth(), this.webView.getMeasuredHeight() / 2);
        if (QLog.isColorLevel()) {
          QLog.d("CmShowMakeupHybirdFragment", 1, "[initAEKitView] setTouchableRect  " + localObject2);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setTouchableRect((Rect)localObject2);
        QLog.d("CmShowMakeupHybirdFragment", 1, "[initAEKitView] mMaterialPath  " + this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Boolean = true;
        anlx.a("dressup_ini_aekit_view", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
        anis.a(126, 3, 0, new Object[0]);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (CameraViewType localCameraViewType = CameraViewType.Body;; localCameraViewType = CameraViewType.Head)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.setParam("switchCameraViewType", localCameraViewType);
      }
      do
      {
        return;
      } while (paramInt != 1);
    }
  }
  
  public void a(CmShowAssetsData paramCmShowAssetsData, int paramInt)
  {
    this.jdField_b_of_type_ComTencentTtpicFilamentCmShowAssetsData = paramCmShowAssetsData;
    this.jdField_a_of_type_Int = paramInt;
    b();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 369	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:isDestroyed	Z
    //   6: ifeq +15 -> 21
    //   9: ldc 138
    //   11: iconst_1
    //   12: ldc_w 371
    //   15: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 70	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:jdField_a_of_type_ComTencentTtpicFilamentCmShowAssetsData	Lcom/tencent/ttpic/filament/CmShowAssetsData;
    //   27: aload_0
    //   28: getfield 362	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:jdField_b_of_type_ComTencentTtpicFilamentCmShowAssetsData	Lcom/tencent/ttpic/filament/CmShowAssetsData;
    //   31: aload_0
    //   32: getfield 364	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:jdField_a_of_type_Int	I
    //   35: invokevirtual 373	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:a	(Lcom/tencent/ttpic/filament/CmShowAssetsData;Lcom/tencent/ttpic/filament/CmShowAssetsData;I)Lcom/tencent/ttpic/filament/CmShowAssetsData;
    //   38: invokespecial 375	com/tencent/mobileqq/apollo/makeup/CmShowMakeupHybirdFragment:a	(Lcom/tencent/ttpic/filament/CmShowAssetsData;)V
    //   41: goto -23 -> 18
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	CmShowMakeupHybirdFragment
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	44	finally
    //   21	41	44	finally
  }
  
  public int doCreateLoopStep_InitTitleBar(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitTitleBar(paramBundle);
    if (getActivity() != null) {
      ImmersiveUtils.a(getActivity().getWindow(), true);
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
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.webviewWrapper != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839470);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      paramBundle = new ViewGroup.LayoutParams(-1, ViewUtils.getScreenHeight() / 2);
      this.mUIStyleHandler.webviewWrapper.addView(this.jdField_a_of_type_AndroidWidgetImageView, 0, paramBundle);
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
    ApolloJsPlugin localApolloJsPlugin;
    do
    {
      return;
      a(paramIntent);
      localApolloJsPlugin = (ApolloJsPlugin)this.webView.getPluginEngine().a("apollo");
    } while (localApolloJsPlugin == null);
    localApolloJsPlugin.callbackCmShowFaceCameraResult(0, new Gson().toJson(paramIntent.dressidMaps), paramIntent.cmJsonString);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShowMakeupHybirdFragment", 2, "apollo_client CmShowMakeupHybirdFragment start create!");
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    anlx.a("dressup_page_expose", String.valueOf(this.jdField_a_of_type_Long));
    anis.a(126);
    anis.a(126, 2);
    anis.a(126, 5);
    anis.a(126, 4);
    boolean bool = super.doOnCreate(paramBundle);
    if (!ashz.a().a()) {
      ashz.a().a().doBindService(getActivity().getApplicationContext());
    }
    this.jdField_a_of_type_Amup = new amup(this.uin);
    this.jdField_a_of_type_Amup.a(this.jdField_a_of_type_Amuy);
    this.jdField_a_of_type_Amup.a(getActivity());
    QLog.d("CmShowMakeupHybirdFragment", 1, "apollo_client CmShowMakeupHybirdFragment end create! use:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView = null;
    this.jdField_a_of_type_Amod = null;
    anis.b(126);
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    super.onDetectedBlankScreen(paramString, paramInt);
    anlx.a("dressup_web_page_bland_screenr", String.valueOf(paramInt));
    anis.a(126, null, new int[] { 1002 });
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    anlx.a("dressup_web_page_low_memory");
    anis.a(126, null, new int[] { 1001 });
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    anlx.a("dressup_web_page_finish", String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long));
    this.jdField_b_of_type_Long = 0L;
    anis.a(126, 1, 0, new Object[0]);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    anlx.a("dressup_web_page_start", String.valueOf(this.jdField_b_of_type_Long));
    anis.a(126, 1);
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView != null) && (getActivity().isFinishing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.onPause();
      if (this.jdField_a_of_type_ComTencentTtpicFilamentCMShowUserLoader != null) {
        this.jdField_a_of_type_ComTencentTtpicFilamentCMShowUserLoader.destroy();
      }
    }
    super.onPause();
    if (this.jdField_a_of_type_Long != 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
      ankl.a("dressup_3d_page", "home_page", "stay", localHashMap);
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    anlx.a("dressup_web_page_error", String.valueOf(paramInt), paramString1);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslError);
    anlx.a("dressup_web_page_ssl_error", String.valueOf(paramSslError.getPrimaryError()));
  }
  
  public void onResume()
  {
    super.onResume();
    ankl.a("dressup_3d_page", "home_page", "expose", null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupHybirdFragment
 * JD-Core Version:    0.7.0.1
 */