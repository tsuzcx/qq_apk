package com.tencent.mobileqq.apollo.sdk;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.sdk.IRenderViewListener;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class CmShowScriptManager
{
  private final int jdField_a_of_type_Int;
  private CmShowSpriteActionScript jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteActionScript;
  private CmShowSpriteContext jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext;
  private CmShowSpriteDrawerInfoBridge jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge;
  private CmShowSpriteDrawerInfoTaskHandler jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoTaskHandler;
  private CmShowSpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteRscBuilder;
  private CmShowSpriteScriptCreator jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteScriptCreator;
  private boolean jdField_a_of_type_Boolean = false;
  
  public CmShowScriptManager(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteScriptManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext = new CmShowSpriteContext();
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoTaskHandler = new CmShowSpriteDrawerInfoTaskHandler(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteScriptCreator = new CmShowSpriteScriptCreator(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoTaskHandler, this);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteRscBuilder = new CmShowSpriteRscBuilder(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge = new CmShowSpriteDrawerInfoBridge(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoTaskHandler, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteRscBuilder, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteScriptCreator);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteRscBuilder);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public CmShowSpriteActionScript a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteActionScript;
  }
  
  public CmShowSpriteContext a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext;
  }
  
  public CmShowSpriteRscBuilder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteRscBuilder;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteActionScript != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteActionScript.a(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(-1);
  }
  
  public void a(int paramInt)
  {
    QLog.i("CmShow_SpriteScriptManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteScriptCreator == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(0, 0);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.b(true);
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteScriptCreator.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteActionScript = ((CmShowSpriteActionScript)this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteScriptCreator.a(100));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a(paramInt1, paramInt2);
  }
  
  public void a(IApolloRenderView paramIApolloRenderView)
  {
    if (paramIApolloRenderView == null) {}
    IApolloCmdChannel localIApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(paramIApolloRenderView);
      localIApolloCmdChannel = ApolloUtilImpl.getCmdChannel();
    } while (localIApolloCmdChannel == null);
    localIApolloCmdChannel.addRenderRunner(paramIApolloRenderView);
  }
  
  public void a(IRenderViewListener paramIRenderViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoTaskHandler.a(paramIRenderViewListener);
  }
  
  public void a(PlayActionConfig paramPlayActionConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext, paramPlayActionConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext, paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoTaskHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext, paramInt, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoTaskHandler.a, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a(paramString, paramBoolean);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a(paramList, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteActionScript != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteActionScript.a(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteRscBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteRscBuilder.a();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a();
    if (localObject != null)
    {
      localObject = ((IApolloRenderView)localObject).getRenderImpl();
      if (localObject != null) {
        ((ApolloRenderInterfaceImpl)localObject).c();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoTaskHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteScriptCreator.b();
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.c();
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.a();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowScriptManager
 * JD-Core Version:    0.7.0.1
 */