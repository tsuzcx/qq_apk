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
  IApolloStatusOrDressChangeListener a = new SpriteDrawerInfoManager.1(this);
  ITraceSpanMessage b = new SpriteDrawerInfoManager.2(this);
  private WeakReference<QQAppInterface> c;
  private SpriteContext d;
  private SpriteScriptCreator e;
  private SpriteDrawerInfoTaskHandler f;
  private SpriteRscBuilder g;
  private SpriteDrawerInfoBridge h;
  private SpriteActionScript i;
  private boolean j = false;
  
  public SpriteDrawerInfoManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.d = new SpriteContext(paramQQAppInterface);
    this.c = new WeakReference(paramQQAppInterface);
    this.f = new SpriteDrawerInfoTaskHandler(this.d);
    this.e = new SpriteScriptCreator(this.d, this.f);
    this.g = new SpriteRscBuilder(this.d);
    this.h = new SpriteDrawerInfoBridge(this.d, this.f, this.g, this.e);
    this.d.a(this.g);
    paramQQAppInterface = (ApolloMessageServiceImpl)paramQQAppInterface.getRuntimeService(IApolloMessageService.class, "all");
    paramQQAppInterface.addListener(ApolloMessageServiceImpl.Companion.MessageType.STATE_OR_DRESS_CHANGE, this.a);
    paramQQAppInterface.addListener(ApolloMessageServiceImpl.Companion.MessageType.TRACE_SPAN_MESSAGE, this.b);
  }
  
  private void a(int paramInt, ArrayList<String> paramArrayList)
  {
    SpriteActionScript localSpriteActionScript = e();
    if ((localSpriteActionScript != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.d.c)) {
          localSpriteActionScript.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  private void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.j) {
      TraceReportUtil.a(TraceReportUtil.c(this.d.i), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public QQAppInterface a()
  {
    WeakReference localWeakReference = this.c;
    if (localWeakReference == null) {
      return null;
    }
    return (QQAppInterface)localWeakReference.get();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ApolloRoleInfo localApolloRoleInfo = new ApolloRoleInfo(paramFloat1, paramFloat2, paramFloat3);
    this.d.a(localApolloRoleInfo);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onSurfaceReady], spriteFrom:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("[cmshow][scripted]SpriteDrawerInfoManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.d;
    if ((localObject != null) && (this.h != null))
    {
      if (this.e == null) {
        return;
      }
      ((SpriteContext)localObject).g(true);
      int k = TraceReportUtil.c(this.d.i);
      this.d.b(k);
      TraceReportUtil.a(k, 100, 0, new Object[] { "onSurfaceReady" });
      this.d.a(-2, paramInt);
      TraceReportUtil.a(k, 200);
      this.e.a();
      TraceReportUtil.a(k, 200, 0, new Object[] { "loadBasicScript done" });
      this.d.f(true);
      TraceReportUtil.a(k, 300);
      this.h.a(this.d);
      TraceReportUtil.a(k, 300, 0, new Object[] { "initSprite done" });
      TraceReportUtil.a(k, 1, 0, new Object[] { "terminal all done" });
      this.j = true;
      this.i = ((SpriteActionScript)this.e.b(0));
      if (this.d.u() != null) {
        this.d.u().c();
      }
    }
  }
  
  public void a(ISpriteDrawerInfoCallback paramISpriteDrawerInfoCallback)
  {
    if (paramISpriteDrawerInfoCallback != null) {
      this.d.a(paramISpriteDrawerInfoCallback);
    }
  }
  
  public void a(ICMShowEngine paramICMShowEngine)
  {
    if (paramICMShowEngine == null) {
      return;
    }
    this.d.a(paramICMShowEngine);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.d.c(paramString);
    int k = 0;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      k = ((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramString);
    }
    this.d.d = k;
  }
  
  public void b()
  {
    SpriteDrawerInfoBridge localSpriteDrawerInfoBridge = this.h;
    if (localSpriteDrawerInfoBridge != null) {
      localSpriteDrawerInfoBridge.c();
    }
  }
  
  public void b(int paramInt)
  {
    SpriteContext localSpriteContext = this.d;
    if (localSpriteContext != null) {
      localSpriteContext.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!SpriteUtil.j(a())) {
      return;
    }
    SpriteActionScript localSpriteActionScript = this.i;
    if (localSpriteActionScript != null) {
      localSpriteActionScript.c(1);
    }
    this.d.a(-1);
  }
  
  public void d()
  {
    if (!SpriteUtil.j(a())) {
      return;
    }
    SpriteActionScript localSpriteActionScript = this.i;
    if (localSpriteActionScript != null) {
      localSpriteActionScript.c(2);
    }
  }
  
  public SpriteActionScript e()
  {
    return this.i;
  }
  
  public SpriteContext f()
  {
    return this.d;
  }
  
  public SpriteDrawerInfoBridge g()
  {
    return this.h;
  }
  
  public void h()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((SpriteRscBuilder)localObject).a();
    }
    TraceReportUtil.a(this.d.w(), true);
    this.f.e();
    this.e.b();
    this.d.y();
    this.h.b();
    localObject = a();
    if (localObject != null)
    {
      localObject = (ApolloMessageServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloMessageService.class, "all");
      ((ApolloMessageServiceImpl)localObject).removeListener(ApolloMessageServiceImpl.Companion.MessageType.STATE_OR_DRESS_CHANGE, this.a);
      ((ApolloMessageServiceImpl)localObject).removeListener(ApolloMessageServiceImpl.Companion.MessageType.TRACE_SPAN_MESSAGE, this.b);
    }
    this.j = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager
 * JD-Core Version:    0.7.0.1
 */