package com.tencent.mobileqq.apollo.script.drawerInfo;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.api.impl.ApolloMessageServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloMessageServiceImpl.Companion.MessageType;
import com.tencent.mobileqq.apollo.api.impl.listener.IApolloStatusOrDressChangeListener;
import com.tencent.mobileqq.apollo.api.impl.listener.ITraceSpanMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloRoleInfo;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteScriptCreator;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class SpriteDrawerInfoManager
{
  IApolloStatusOrDressChangeListener jdField_a_of_type_ComTencentMobileqqApolloApiImplListenerIApolloStatusOrDressChangeListener = new SpriteDrawerInfoManager.1(this);
  ITraceSpanMessage jdField_a_of_type_ComTencentMobileqqApolloApiImplListenerITraceSpanMessage = new SpriteDrawerInfoManager.2(this);
  private SpriteActionScript jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private SpriteScriptCreator jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator;
  private SpriteDrawerInfoBridge jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge;
  private SpriteDrawerInfoTaskHandler jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoTaskHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  
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
    paramQQAppInterface = (ApolloMessageServiceImpl)paramQQAppInterface.getRuntimeService(IApolloMessageService.class, "all");
    paramQQAppInterface.addListener(ApolloMessageServiceImpl.Companion.MessageType.STATE_OR_DRESS_CHANGE, this.jdField_a_of_type_ComTencentMobileqqApolloApiImplListenerIApolloStatusOrDressChangeListener);
    paramQQAppInterface.addListener(ApolloMessageServiceImpl.Companion.MessageType.TRACE_SPAN_MESSAGE, this.jdField_a_of_type_ComTencentMobileqqApolloApiImplListenerITraceSpanMessage);
  }
  
  private void a(int paramInt, ArrayList<String> paramArrayList)
  {
    SpriteActionScript localSpriteActionScript = a();
    if ((localSpriteActionScript != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString)) {
          localSpriteActionScript.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  private void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      TraceReportUtil.a(SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public ISpriteContext a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  }
  
  public SpriteActionScript a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript;
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ApolloRoleInfo localApolloRoleInfo = new ApolloRoleInfo(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(localApolloRoleInfo);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.g(true);
      int i = SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.e);
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(i);
      TraceReportUtil.a(i, 100, 0, new Object[] { "onSurfaceReady" });
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(-2, paramInt);
      TraceReportUtil.a(i, 200);
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a();
      TraceReportUtil.a(i, 200, 0, new Object[] { "loadBasicScript done" });
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.f(true);
      TraceReportUtil.a(i, 300);
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
      TraceReportUtil.a(i, 300, 0, new Object[] { "initSprite done" });
      TraceReportUtil.a(i, 1, 0, new Object[] { "terminal all done" });
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript = ((SpriteActionScript)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(0));
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().c();
  }
  
  public void a(IApolloRenderView paramIApolloRenderView)
  {
    if (paramIApolloRenderView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramIApolloRenderView);
    ApolloUtilImpl.getCmdChannel().addRenderRunner(paramIApolloRenderView);
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
    int i = 0;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      i = ((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(a(), paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_Int = i;
  }
  
  public void b()
  {
    if (!SpriteUtil.e(a())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript.c(1);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().setBubbleType(-1);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!SpriteUtil.e(a())) {}
    while (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript.c(2);
  }
  
  public void d()
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
    TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d(), true);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoTaskHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.b();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge.b();
    localObject = a();
    if (localObject != null)
    {
      localObject = (ApolloMessageServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloMessageService.class, "all");
      ((ApolloMessageServiceImpl)localObject).removeListener(ApolloMessageServiceImpl.Companion.MessageType.STATE_OR_DRESS_CHANGE, this.jdField_a_of_type_ComTencentMobileqqApolloApiImplListenerIApolloStatusOrDressChangeListener);
      ((ApolloMessageServiceImpl)localObject).removeListener(ApolloMessageServiceImpl.Companion.MessageType.TRACE_SPAN_MESSAGE, this.jdField_a_of_type_ComTencentMobileqqApolloApiImplListenerITraceSpanMessage);
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager
 * JD-Core Version:    0.7.0.1
 */