package com.tencent.mobileqq.apollo.script.drawerinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.api.impl.ApolloMessageServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloMessageServiceImpl.Companion.MessageType;
import com.tencent.mobileqq.apollo.listener.IApolloStatusOrDressChangeListener;
import com.tencent.mobileqq.apollo.listener.ITraceSpanMessage;
import com.tencent.mobileqq.apollo.model.ApolloRoleInfo;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteScriptCreator;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class SpriteDrawerInfoManager
{
  IApolloStatusOrDressChangeListener jdField_a_of_type_ComTencentMobileqqApolloListenerIApolloStatusOrDressChangeListener = new SpriteDrawerInfoManager.1(this);
  ITraceSpanMessage jdField_a_of_type_ComTencentMobileqqApolloListenerITraceSpanMessage = new SpriteDrawerInfoManager.2(this);
  private SpriteActionScript jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private SpriteScriptCreator jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator;
  private SpriteDrawerInfoBridge jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoBridge;
  private SpriteDrawerInfoTaskHandler jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoTaskHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  public SpriteDrawerInfoManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = new SpriteContext(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoTaskHandler = new SpriteDrawerInfoTaskHandler(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator = new SpriteScriptCreator(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoTaskHandler);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = new SpriteRscBuilder(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoBridge = new SpriteDrawerInfoBridge(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoTaskHandler, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder);
    paramQQAppInterface = (ApolloMessageServiceImpl)paramQQAppInterface.getRuntimeService(IApolloMessageService.class, "all");
    paramQQAppInterface.addListener(ApolloMessageServiceImpl.Companion.MessageType.STATE_OR_DRESS_CHANGE, this.jdField_a_of_type_ComTencentMobileqqApolloListenerIApolloStatusOrDressChangeListener);
    paramQQAppInterface.addListener(ApolloMessageServiceImpl.Companion.MessageType.TRACE_SPAN_MESSAGE, this.jdField_a_of_type_ComTencentMobileqqApolloListenerITraceSpanMessage);
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
      TraceReportUtil.a(TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d), 1, paramInt, 0L, paramVarArgs);
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
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoBridge;
  }
  
  public QQAppInterface a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    return (QQAppInterface)localWeakReference.get();
  }
  
  public void a()
  {
    SpriteDrawerInfoBridge localSpriteDrawerInfoBridge = this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoBridge;
    if (localSpriteDrawerInfoBridge != null) {
      localSpriteDrawerInfoBridge.b();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ApolloRoleInfo localApolloRoleInfo = new ApolloRoleInfo(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(localApolloRoleInfo);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onSurfaceReady], spriteFrom:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("[cmshow][scripted]SpriteDrawerInfoManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoBridge != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator == null) {
        return;
      }
      ((SpriteContext)localObject).g(true);
      int i = TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d);
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b(i);
      TraceReportUtil.a(i, 100, 0, new Object[] { "onSurfaceReady" });
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(-2, paramInt);
      TraceReportUtil.a(i, 200);
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a();
      TraceReportUtil.a(i, 200, 0, new Object[] { "loadBasicScript done" });
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.f(true);
      TraceReportUtil.a(i, 300);
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
      TraceReportUtil.a(i, 300, 0, new Object[] { "initSprite done" });
      TraceReportUtil.a(i, 1, 0, new Object[] { "terminal all done" });
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript = ((SpriteActionScript)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.b(0));
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().c();
      }
    }
  }
  
  public void a(ISpriteDrawerInfoCallback paramISpriteDrawerInfoCallback)
  {
    if (paramISpriteDrawerInfoCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramISpriteDrawerInfoCallback);
    }
  }
  
  public void a(ICMShowEngine paramICMShowEngine)
  {
    if (paramICMShowEngine == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramICMShowEngine);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b(paramString);
    int i = 0;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      i = ((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_Int = i;
  }
  
  public void b()
  {
    if (!SpriteUtil.d(a())) {
      return;
    }
    SpriteActionScript localSpriteActionScript = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript;
    if (localSpriteActionScript != null) {
      localSpriteActionScript.c(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(-1);
  }
  
  public void b(int paramInt)
  {
    SpriteContext localSpriteContext = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if (localSpriteContext != null) {
      localSpriteContext.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!SpriteUtil.d(a())) {
      return;
    }
    SpriteActionScript localSpriteActionScript = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript;
    if (localSpriteActionScript != null) {
      localSpriteActionScript.c(2);
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
    if (localObject != null) {
      ((SpriteRscBuilder)localObject).a();
    }
    TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c(), true);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoTaskHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.b();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoBridge.a();
    localObject = a();
    if (localObject != null)
    {
      localObject = (ApolloMessageServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloMessageService.class, "all");
      ((ApolloMessageServiceImpl)localObject).removeListener(ApolloMessageServiceImpl.Companion.MessageType.STATE_OR_DRESS_CHANGE, this.jdField_a_of_type_ComTencentMobileqqApolloListenerIApolloStatusOrDressChangeListener);
      ((ApolloMessageServiceImpl)localObject).removeListener(ApolloMessageServiceImpl.Companion.MessageType.TRACE_SPAN_MESSAGE, this.jdField_a_of_type_ComTencentMobileqqApolloListenerITraceSpanMessage);
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager
 * JD-Core Version:    0.7.0.1
 */