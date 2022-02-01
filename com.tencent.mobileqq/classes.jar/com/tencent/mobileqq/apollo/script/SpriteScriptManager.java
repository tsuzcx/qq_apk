package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.api.IApolloResponseManager;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.impl.ApolloMessageServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloMessageServiceImpl.Companion.MessageType;
import com.tencent.mobileqq.apollo.api.impl.listener.IApolloStatusOrDressChangeListener;
import com.tencent.mobileqq.apollo.api.impl.listener.ITraceSpanMessage;
import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.api.uitls.IApolloActionHelper;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.trace.TraceMappingIml;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.task.ApolloBubbleLogic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class SpriteScriptManager
  implements ISpriteScriptManager
{
  public static final String TAG = "cmshow_scripted_SpriteScriptManager";
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
      TraceReportUtil.a(SpriteUtil.b(this.mSpriteContext.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void doOnPause(int paramInt, String paramString)
  {
    if (!SpriteUtil.b(getApp(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = SpriteUtil.a(getApp());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.mSpriteBackgroundManager == null);
    this.mSpriteBackgroundManager.c();
  }
  
  public void doOnResume(int paramInt, String paramString)
  {
    if (!SpriteUtil.b(getApp(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = SpriteUtil.a(getApp());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.mSpriteBackgroundManager == null);
    this.mSpriteBackgroundManager.d();
  }
  
  public QQAppInterface getApp()
  {
    if (this.mAppRef == null) {
      return null;
    }
    return (QQAppInterface)this.mAppRef.get();
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
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      throw new RuntimeException("can not create SpriteScriptManager without a QQAppInterface");
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    this.mSpriteContext = new SpriteContext(paramAppRuntime);
    this.mAppRef = new WeakReference(paramAppRuntime);
    this.mUIHandler = new SpriteUIHandler(this.mSpriteContext);
    this.mTaskHandler = new SpriteTaskHandler(this.mSpriteContext, this.mUIHandler);
    this.mScriptCreator = new SpriteScriptCreator(this.mSpriteContext, this.mTaskHandler);
    this.mResBuilder = new SpriteRscBuilder(this.mSpriteContext);
    this.mTaskBridge = new SpriteBridge(this.mSpriteContext, this.mTaskHandler, this.mResBuilder, this.mScriptCreator);
    this.mSpriteContext.a(this.mResBuilder);
    paramAppRuntime = (ApolloMessageServiceImpl)paramAppRuntime.getRuntimeService(IApolloMessageService.class, "all");
    paramAppRuntime.addListener(ApolloMessageServiceImpl.Companion.MessageType.STATE_OR_DRESS_CHANGE, this.statusOrDressChangeListener);
    paramAppRuntime.addListener(ApolloMessageServiceImpl.Companion.MessageType.TRACE_SPAN_MESSAGE, this.traceSpanMessage);
  }
  
  public void onDestroy()
  {
    if (this.mResBuilder != null) {
      this.mResBuilder.a();
    }
    Object localObject = this.mSpriteContext.a();
    if (localObject != null)
    {
      localObject = ((IApolloRenderView)localObject).getRenderImpl();
      if (localObject != null) {
        ((ApolloRenderInterfaceImpl)localObject).c();
      }
    }
    if (this.mBubbleLogic != null)
    {
      this.mBubbleLogic.a();
      this.mBubbleLogic = null;
    }
    if (this.mSpriteActionMessage != null)
    {
      this.mSpriteActionMessage.a();
      this.mSpriteActionMessage = null;
    }
    if (this.mSpriteBackgroundManager != null)
    {
      this.mSpriteBackgroundManager.f();
      this.mSpriteBackgroundManager = null;
    }
    this.mTaskHandler.a();
    this.mScriptCreator.b();
    this.mTaskBridge.b();
    this.mSpriteContext.c();
    this.mIsInit = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = getApp();
    if (localObject == null) {}
    do
    {
      return;
      ApolloMessageServiceImpl localApolloMessageServiceImpl = (ApolloMessageServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloMessageService.class, "all");
      localApolloMessageServiceImpl.removeListener(ApolloMessageServiceImpl.Companion.MessageType.STATE_OR_DRESS_CHANGE, this.statusOrDressChangeListener);
      localApolloMessageServiceImpl.removeListener(ApolloMessageServiceImpl.Companion.MessageType.TRACE_SPAN_MESSAGE, this.traceSpanMessage);
    } while (this.mSpriteContext.jdField_a_of_type_AndroidContentSharedPreferences == null);
    this.mSpriteContext.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
  
  public void onSurfaceReady(String paramString, int paramInt)
  {
    onSurfaceReady(paramString, paramInt, false);
  }
  
  public void onSurfaceReady(String paramString, int paramInt, boolean paramBoolean)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.mSpriteContext == null) || (this.mTaskBridge == null) || (this.mScriptCreator == null)) {
      return;
    }
    this.mSpriteContext.g(true);
    int i = SpriteUtil.b(this.mSpriteContext.e);
    this.mSpriteContext.a(i);
    if (!this.mSpriteContext.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.mSpriteContext.a(paramInt, 0);
    this.mSpriteContext.jdField_a_of_type_JavaLangString = paramString;
    this.mSpriteContext.a();
    this.mSpriteContext.b();
    if ((!paramBoolean) && (!SpriteUtil.b(getApp(), paramInt, paramString)))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    TraceReportUtil.a(i, 200);
    this.mTaskBridge.a(this.mBubbleLogic);
    this.mScriptCreator.a();
    TraceReportUtil.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.mSpriteContext.f(true);
    Object localObject1;
    if (!this.mTaskHandler.a(null))
    {
      TraceReportUtil.a(i, 300);
      this.mTaskBridge.a(this.mSpriteContext);
      TraceReportUtil.a(i, 300, 0, new Object[] { "initSprite done" });
      TraceReportUtil.a(i, 1, 0, new Object[] { "terminal all done" });
      TraceReportUtil.a(i, null, new int[] { TraceMappingIml.a(i, false, this.mSpriteContext.b, paramInt, true) });
      this.mIsInit = true;
      if ((this.mAppRef == null) || (!CmShowAioMatcher.a(paramInt, 1))) {
        break label706;
      }
      i = ((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(((QQAppInterface)this.mAppRef.get()).getCurrentUin(), (QQAppInterface)this.mAppRef.get());
      localObject1 = String.valueOf(((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(paramString, (QQAppInterface)this.mAppRef.get()));
    }
    for (Object localObject2 = String.valueOf(i);; localObject2 = "")
    {
      QQAppInterface localQQAppInterface = getApp();
      if (this.mSpriteContext.d == 1)
      {
        i = 1;
        label455:
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportUserResult(this.mSpriteContext.b), new String[] { Integer.toString(((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramInt)), localObject2, localObject1, paramString });
        localObject2 = new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a((QQAppInterface)this.mAppRef.get())).b(ApolloDtReportUtil.a(paramInt)).f(((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(((QQAppInterface)this.mAppRef.get()).getCurrentUin(), (QQAppInterface)this.mAppRef.get()));
        if (paramInt != 0) {
          break label700;
        }
      }
      label700:
      for (localObject1 = Integer.valueOf(((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(paramString, (QQAppInterface)this.mAppRef.get()));; localObject1 = null)
      {
        ApolloDtReportUtil.a("aio", "sprite", "expose", ((ApolloDtReportUtil.DtReportParamsBuilder)localObject2).a((Integer)localObject1).b(paramString).a());
        return;
        TraceReportUtil.a(i, null, new int[] { TraceMappingIml.a(i, true, this.mSpriteContext.b, paramInt, true) });
        break;
        i = 0;
        break label455;
      }
      label706:
      localObject1 = "";
    }
  }
  
  public void preloadSpriteData()
  {
    if (this.mTaskBridge != null) {
      this.mTaskBridge.a();
    }
  }
  
  public void setBackgroundManager(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.mSpriteBackgroundManager = new SpriteBackgroundManager(this.mSpriteContext, paramApolloTextureView);
  }
  
  public void setPie(BaseChatPie paramBaseChatPie)
  {
    this.mSpriteContext.a(paramBaseChatPie);
    paramBaseChatPie = getApp();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (IApolloResponseManager)paramBaseChatPie.getRuntimeService(IApolloResponseManager.class, "all");
      getTaskHandler().a(paramBaseChatPie);
    }
    if (this.mBubbleLogic == null) {
      this.mBubbleLogic = new ApolloBubbleLogic(this.mSpriteContext);
    }
    if (this.mSpriteActionMessage == null) {
      this.mSpriteActionMessage = new SpriteActionMessage(this.mSpriteContext);
    }
  }
  
  public void setRenderView(IApolloRenderView paramIApolloRenderView)
  {
    if (paramIApolloRenderView == null) {
      return;
    }
    this.mSpriteContext.a(paramIApolloRenderView);
    ApolloUtilImpl.getCmdChannel().addRenderRunner(paramIApolloRenderView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteScriptManager
 * JD-Core Version:    0.7.0.1
 */