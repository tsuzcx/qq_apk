package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.ApolloResponseManager;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloMessageServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloMessageServiceImpl.Companion.MessageType;
import com.tencent.mobileqq.apollo.listener.IApolloStatusOrDressChangeListener;
import com.tencent.mobileqq.apollo.listener.ITraceSpanMessage;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.task.ApolloBubbleLogic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class SpriteScriptManager
  implements ISpriteScriptManager
{
  public static final String TAG = "[cmshow][scripted]SpriteScriptManager";
  private WeakReference<QQAppInterface> mAppRef;
  private ApolloBubbleLogic mBubbleLogic;
  private boolean mIsInit = false;
  private SpriteRscBuilder mResBuilder;
  private SpriteScriptCreator mScriptCreator;
  private SpriteActionMessage mSpriteActionMessage;
  private SpriteBackgroundManager mSpriteBackgroundManager;
  private SpriteContext mSpriteContext;
  private SpriteBridge mTaskBridge;
  private SpriteTaskHandler mTaskHandler;
  private SpriteUIHandler mUIHandler;
  IApolloStatusOrDressChangeListener statusOrDressChangeListener = new SpriteScriptManager.1(this);
  ITraceSpanMessage traceSpanMessage = new SpriteScriptManager.2(this);
  
  private void notifyStatusOrDressChanged(int paramInt, ArrayList<String> paramArrayList)
  {
    SpriteActionScript localSpriteActionScript = SpriteUtil.a(getApp());
    if (localSpriteActionScript != null) {
      localSpriteActionScript.a(paramInt, paramArrayList);
    }
  }
  
  private void reportTraceSpanMsg(int paramInt, Object... paramVarArgs)
  {
    if (!this.mIsInit) {
      TraceReportUtil.a(TraceReportUtil.a(this.mSpriteContext.d), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void doOnPause(int paramInt, String paramString)
  {
    if (!SpriteUtil.b(getApp(), paramInt, paramString)) {
      return;
    }
    paramString = SpriteUtil.a(getApp());
    if (paramString != null) {
      paramString.c(1);
    }
    paramString = this.mSpriteBackgroundManager;
    if (paramString != null) {
      paramString.c();
    }
  }
  
  public void doOnResume(int paramInt, String paramString)
  {
    if (!SpriteUtil.b(getApp(), paramInt, paramString)) {
      return;
    }
    paramString = SpriteUtil.a(getApp());
    if (paramString != null) {
      paramString.c(2);
    }
    paramString = this.mSpriteBackgroundManager;
    if (paramString != null) {
      paramString.d();
    }
  }
  
  public QQAppInterface getApp()
  {
    WeakReference localWeakReference = this.mAppRef;
    if (localWeakReference == null) {
      return null;
    }
    return (QQAppInterface)localWeakReference.get();
  }
  
  public ApolloBubbleLogic getBubbleLogic()
  {
    return this.mBubbleLogic;
  }
  
  public SpriteRscBuilder getRscBuilder()
  {
    return this.mResBuilder;
  }
  
  public SpriteActionMessage getSpriteActionMessage()
  {
    return this.mSpriteActionMessage;
  }
  
  public SpriteBackgroundManager getSpriteBackgroundManager()
  {
    return this.mSpriteBackgroundManager;
  }
  
  public ISpriteBridge getSpriteBridge()
  {
    return this.mTaskBridge;
  }
  
  public ISpriteContext getSpriteContext()
  {
    return this.mSpriteContext;
  }
  
  public SpriteScriptCreator getSpriteCreator()
  {
    return this.mScriptCreator;
  }
  
  public ISpriteTaskHandler getTaskHandler()
  {
    return this.mTaskHandler;
  }
  
  public ISpriteUIHandler getUIHandler()
  {
    return this.mUIHandler;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      QLog.i("[cmshow][scripted]SpriteScriptManager", 1, "SpriteScriptManager onCreate");
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      this.mSpriteContext = new SpriteContext(paramAppRuntime);
      this.mAppRef = new WeakReference(paramAppRuntime);
      this.mUIHandler = new SpriteUIHandler(this.mSpriteContext);
      this.mTaskHandler = new SpriteTaskHandler(this.mSpriteContext, this.mUIHandler);
      this.mScriptCreator = new SpriteScriptCreator(this.mSpriteContext, this.mTaskHandler);
      this.mResBuilder = new SpriteRscBuilder(this.mSpriteContext);
      this.mTaskBridge = new SpriteBridge(this.mSpriteContext, this.mTaskHandler, this.mResBuilder, this.mScriptCreator);
      this.mSpriteContext.a(this.mResBuilder);
      return;
    }
    throw new RuntimeException("can not create SpriteScriptManager without a QQAppInterface");
  }
  
  public void onDestroy()
  {
    QLog.i("[cmshow][scripted]SpriteScriptManager", 1, "onDestroy");
    reset();
  }
  
  public void onSurfaceReady(String paramString, int paramInt)
  {
    onSurfaceReady(paramString, paramInt, false);
  }
  
  public void onSurfaceReady(String paramString, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void preloadSpriteData()
  {
    SpriteBridge localSpriteBridge = this.mTaskBridge;
    if (localSpriteBridge != null) {
      localSpriteBridge.a();
    }
  }
  
  public void reset()
  {
    QLog.i("[cmshow][scripted]SpriteScriptManager", 1, "reset");
    Object localObject = this.mResBuilder;
    if (localObject != null) {
      ((SpriteRscBuilder)localObject).a();
    }
    localObject = this.mBubbleLogic;
    if (localObject != null)
    {
      ((ApolloBubbleLogic)localObject).a();
      this.mBubbleLogic = null;
    }
    localObject = this.mSpriteActionMessage;
    if (localObject != null)
    {
      ((SpriteActionMessage)localObject).a();
      this.mSpriteActionMessage = null;
    }
    localObject = this.mSpriteBackgroundManager;
    if (localObject != null)
    {
      ((SpriteBackgroundManager)localObject).f();
      this.mSpriteBackgroundManager = null;
    }
    this.mTaskHandler.a();
    this.mScriptCreator.b();
    this.mTaskBridge.b();
    this.mSpriteContext.c();
    this.mIsInit = false;
    localObject = getApp();
    if (localObject == null) {
      return;
    }
    localObject = (ApolloMessageServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloMessageService.class, "all");
    ((ApolloMessageServiceImpl)localObject).removeListener(ApolloMessageServiceImpl.Companion.MessageType.STATE_OR_DRESS_CHANGE, this.statusOrDressChangeListener);
    ((ApolloMessageServiceImpl)localObject).removeListener(ApolloMessageServiceImpl.Companion.MessageType.TRACE_SPAN_MESSAGE, this.traceSpanMessage);
  }
  
  public void setBackgroundManager(ICMShowEngine paramICMShowEngine)
  {
    if (paramICMShowEngine == null) {
      return;
    }
    this.mSpriteBackgroundManager = new SpriteBackgroundManager(this.mSpriteContext, paramICMShowEngine);
  }
  
  public void setPie(BaseChatPie paramBaseChatPie)
  {
    this.mSpriteContext.a(paramBaseChatPie);
    paramBaseChatPie = getApp();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (ApolloResponseManager)paramBaseChatPie.getManager(QQManagerFactory.APOLLO_RESPONSE_MANAGER);
      getTaskHandler().a(paramBaseChatPie);
    }
    if (this.mBubbleLogic == null) {
      this.mBubbleLogic = new ApolloBubbleLogic(this.mSpriteContext);
    }
    if (this.mSpriteActionMessage == null) {
      this.mSpriteActionMessage = new SpriteActionMessage(this.mSpriteContext);
    }
  }
  
  public void updateSessionInfo(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.mSpriteContext.a(paramSessionInfo.jdField_a_of_type_Int, 0);
      this.mSpriteContext.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteScriptManager
 * JD-Core Version:    0.7.0.1
 */