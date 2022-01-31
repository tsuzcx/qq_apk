package com.tencent.mobileqq.apollo.script.drawerInfo;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.data.ApolloRoleInfo;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteScriptCreator;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SpriteDrawerInfoManager
{
  private SpriteActionScript jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private SpriteScriptCreator jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator;
  private SpriteDrawerInfoBridge jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge;
  private SpriteDrawerInfoTaskHandler jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoTaskHandler;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public SpriteDrawerInfoManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = new SpriteContext(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoTaskHandler = new SpriteDrawerInfoTaskHandler(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator = new SpriteScriptCreator(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoTaskHandler);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = new SpriteRscBuilder(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge = new SpriteDrawerInfoBridge(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoTaskHandler, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder);
    paramQQAppInterface = SpriteUtil.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public SpriteActionScript a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript;
  }
  
  public SpriteContext a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  }
  
  public SpriteDrawerInfoBridge a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (!SpriteUtil.d(a())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript.c(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(-1);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ApolloRoleInfo localApolloRoleInfo = new ApolloRoleInfo(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(localApolloRoleInfo);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(-2, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b(true);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript = ((SpriteActionScript)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(0));
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    SpriteActionScript localSpriteActionScript = a();
    if (localSpriteActionScript != null) {
      localSpriteActionScript.a(paramInt, paramArrayList);
    }
  }
  
  public void a(IApolloRenderView paramIApolloRenderView)
  {
    if (paramIApolloRenderView == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramIApolloRenderView);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramIApolloRenderView);
  }
  
  public void a(ISpriteDrawerInfoCallback paramISpriteDrawerInfoCallback)
  {
    if (paramISpriteDrawerInfoCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramISpriteDrawerInfoCallback);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramString);
  }
  
  public void b()
  {
    if (!SpriteUtil.d(a())) {}
    while (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript.c(2);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (localObject != null)
    {
      localObject = ((IApolloRenderView)localObject).getRenderImpl();
      if (localObject != null) {
        ((ApolloRenderInterfaceImpl)localObject).c();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoTaskHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.b();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager
 * JD-Core Version:    0.7.0.1
 */