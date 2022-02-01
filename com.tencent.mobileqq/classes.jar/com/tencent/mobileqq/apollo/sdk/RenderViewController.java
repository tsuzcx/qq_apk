package com.tencent.mobileqq.apollo.sdk;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.sdk.IRenderViewListener;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class RenderViewController
{
  public static int a;
  private ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  private CmShowScriptManager jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager;
  private CmShowViewListener jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowViewListener;
  private final int b;
  private int c;
  
  public RenderViewController(CmShowRenderView paramCmShowRenderView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = paramCmShowRenderView;
    this.b = paramInt;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onResume");
    }
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramInt1, paramInt2);
    }
  }
  
  public void a(IRenderViewListener paramIRenderViewListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowViewListener.a(paramIRenderViewListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramIRenderViewListener);
    }
  }
  
  public void a(PlayActionConfig paramPlayActionConfig)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramPlayActionConfig);
    }
  }
  
  @TargetApi(14)
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "initApolloSurfaceView");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager = new CmShowScriptManager(paramString, this.b);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowViewListener = new CmShowViewListener(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager, 0);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowViewListener);
    paramString = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
    if (paramString != null) {}
    for (boolean bool = ((ApolloManagerServiceImpl)paramString.getRuntimeService(IApolloManagerService.class, "all")).isDisableCreateRenderThread();; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDumplicateCreateRenderThread(bool);
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      int i = SpriteUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setInitHeight(i);
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramString, paramInt);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramString1, paramString2, paramFloat, paramInt, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramString1, paramString2, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramString, paramBoolean);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramList, paramBoolean);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onPause");
    }
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a();
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a(paramString);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onDestroy ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      ApolloRender localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender();
      if (localApolloRender != null) {
        localApolloRender.queueDestroy();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.c();
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager = null;
    }
    if (!a())
    {
      QLog.e("CmShow_RenderViewController", 1, new Object[] { "[onDestory] isViewAvailable:", Boolean.valueOf(a()) });
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
    }
    this.c = 0;
    CmShowDataHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.RenderViewController
 * JD-Core Version:    0.7.0.1
 */