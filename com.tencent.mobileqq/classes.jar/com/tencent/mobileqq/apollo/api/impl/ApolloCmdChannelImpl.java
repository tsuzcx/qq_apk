package com.tencent.mobileqq.apollo.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloRenderRunner;
import com.tencent.mobileqq.apollo.aioChannel.GeneralEventHandler;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.mobileqq.apollo.game.rankList.CmGameUserInfo;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.audio.ApolloGameMusicPlayer;
import com.tencent.mobileqq.apollo.process.audio.ICmGameAudioPlayer;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler;
import com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate;
import com.tencent.mobileqq.apollo.process.ui.NativeUIManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class ApolloCmdChannelImpl
  extends ApolloCmdChannel
  implements IApolloCmdChannel
{
  private static final String TAG = "cmshow_scripted_cmgame_process.ApolloDataChannel";
  private WeakReference<Activity> mActivityRef;
  private WeakReference<QQAppInterface> mAppInterfaceRef;
  private HashMap<Long, Boolean> mCallJsRuntimeMap = new HashMap();
  private ICmGameAudioPlayer mPlayer;
  private ApolloRenderRunner mRenderRunners = new ApolloRenderRunner();
  private WeakReferenceHandler mRequestHandlerThread;
  private List<IRequestHandler> mRequestHandlers = new ArrayList();
  private volatile boolean mSetNativeObj;
  
  public ApolloCmdChannelImpl()
  {
    init();
  }
  
  private void createRightPlayer(int paramInt)
  {
    if (CmGameUtil.a())
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(getGameId());
      if (localCmGameLauncher != null) {
        localCmGameLauncher.b(paramInt);
      }
    }
  }
  
  private int getGameId()
  {
    if (CmGameUtil.a())
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(Thread.currentThread().getId());
      if (localCmGameLauncher == null) {
        return -1;
      }
      return localCmGameLauncher.a();
    }
    return -10000;
  }
  
  private ICmGameAudioPlayer getRightPlayer()
  {
    if (CmGameUtil.a())
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(getGameId());
      if (localCmGameLauncher != null) {
        return localCmGameLauncher.a();
      }
    }
    else
    {
      return this.mPlayer;
    }
    return null;
  }
  
  private void init()
  {
    makesureHasInitObj();
    this.mRequestHandlerThread = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
    synchronized (this.mRequestHandlers)
    {
      Collections.sort(this.mRequestHandlers, new ApolloCmdChannelImpl.2(this));
      return;
    }
  }
  
  private boolean isGameHandlerClosed()
  {
    for (;;)
    {
      synchronized (this.mRequestHandlers)
      {
        Iterator localIterator = this.mRequestHandlers.iterator();
        if (localIterator.hasNext())
        {
          if (!((IRequestHandler)localIterator.next() instanceof CmGameSubProcessHandler)) {
            continue;
          }
          bool = false;
          return bool;
        }
      }
      boolean bool = true;
    }
  }
  
  public void addCmdHandler(IRequestHandler paramIRequestHandler)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(paramIRequestHandler);
      this.mRequestHandlers.add(paramIRequestHandler);
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "addCmdHandler class:" + paramIRequestHandler.getClass().getName() + ", size: " + this.mRequestHandlers.size());
      }
      return;
    }
  }
  
  public void addRenderRunner(IRenderRunner paramIRenderRunner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "addRenderRunner,renderRunner:" + paramIRenderRunner);
    }
    this.mRenderRunners.a(paramIRenderRunner);
  }
  
  public void callbackDirect(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "[callbackEngine], luaState:" + paramLong + ",errCode:" + paramInt + ",cmd:" + paramString1 + ",reqData:" + paramString2);
    }
    if (-1L == paramLong)
    {
      QLog.i("cmshow_scripted_cmgame_process.ApolloDataChannel", 1, "callbackEngine, errInfo->lState is destroyed.");
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = "{}";
    }
    for (;;)
    {
      callbackEngineWrapper(paramBoolean, paramLong, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public void callbackEngine(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    super.callbackEngine(paramLong, paramInt, paramString1, paramString2);
  }
  
  public void callbackEngineWrapper(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (paramLong == -1L) {}
    label166:
    label339:
    do
    {
      Boolean localBoolean;
      do
      {
        return;
        if (!ApolloEngine.a()) {
          break label339;
        }
        localBoolean = (Boolean)this.mCallJsRuntimeMap.get(Long.valueOf(paramLong));
        try
        {
          localCmGameLauncher = CmGameUtil.b(paramLong);
          if ((localCmGameLauncher == null) || (!localCmGameLauncher.b())) {
            break label258;
          }
          if (localBoolean == null) {
            break label166;
          }
          if (localBoolean.booleanValue())
          {
            if (QLog.isColorLevel()) {
              QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper isCallFromJs callbackEngine,lState:" + paramLong);
            }
            callbackEngine(paramLong, paramInt, paramString1, paramString2);
            return;
          }
        }
        catch (OutOfMemoryError paramString1)
        {
          QLog.e("cmshow_scripted_cmgame_process.ApolloDataChannel", 1, paramString1, new Object[0]);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper isCallFromJs callbackEngineOld,lState:" + paramLong);
        }
        callbackEngineOld(paramLong, paramInt, paramString1, paramString2);
        return;
        if (paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper callbackEngine, jsRuntime lState:" + paramLong);
          }
          callbackEngine(paramLong, paramInt, paramString1, paramString2);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper callbackEngineOld, jsRuntime lState:" + paramLong);
        }
        callbackEngineOld(paramLong, paramInt, paramString1, paramString2);
        return;
        CmGameLauncher localCmGameLauncher = CmGameUtil.a((int)paramLong);
        if (localCmGameLauncher == null) {
          break;
        }
        if (!localCmGameLauncher.b())
        {
          localCmGameLauncher.a(paramInt, paramString1, paramString2);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "not h5 game");
      return;
      if ((paramBoolean) || (localBoolean.booleanValue())) {
        callbackEngine(paramLong, paramInt, paramString1, paramString2);
      }
      QLog.e("cmshow_scripted_cmgame_process.ApolloDataChannel", 1, "can not find h5 launcher");
      return;
    } while (!QLog.isColorLevel());
    label258:
    QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "callbackEngineWarpper ApolloEngine.isEngineReady() false");
  }
  
  public void callbackFromRequest(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "[callbackFromRequest], luaState:" + paramLong + ",errCode:" + paramInt + ",cmd:" + paramString1 + ",reqData:" + paramString2);
    }
    this.mRenderRunners.a(this, paramLong, paramInt, paramString1, paramString2);
  }
  
  public void callbackGetHead(Bitmap paramBitmap, String paramString, int paramInt, long paramLong)
  {
    IRenderRunner localIRenderRunner = this.mRenderRunners.a(paramLong);
    if (localIRenderRunner != null)
    {
      if (ApolloEngine.a()) {
        break label38;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "callbackGetHead ApolloEngine.isEngineReady() false");
      }
    }
    return;
    label38:
    localIRenderRunner.runRenderTask(new ApolloCmdChannelImpl.4(this, paramBitmap, paramString, paramInt, paramLong));
  }
  
  public void callbackGetNick(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    IRenderRunner localIRenderRunner = this.mRenderRunners.a(paramLong);
    if (localIRenderRunner != null)
    {
      if (ApolloEngine.a()) {
        break label38;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "callbackGetNick ApolloEngine.isEngineReady() false");
      }
    }
    return;
    label38:
    localIRenderRunner.runRenderTask(new ApolloCmdChannelImpl.3(this, paramString1, paramString2, paramInt, paramLong));
  }
  
  public void checkSetNative()
  {
    if (!this.mSetNativeObj)
    {
      nativeSetDataChannelObj(this);
      this.mSetNativeObj = true;
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "checkSetNative nativeSetDataChannelObj");
      }
    }
  }
  
  public void destroyMusic()
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.c();
    }
  }
  
  public void exeJsOnEngine(IRenderRunner paramIRenderRunner, String paramString)
  {
    this.mRenderRunners.a(paramIRenderRunner, paramString);
  }
  
  public void getAccountInfo(long paramLong, String paramString, int paramInt)
  {
    if (CmGameUtil.a()) {
      CmGameOpenIdFinder.a(paramLong, paramInt, paramString);
    }
  }
  
  public int getDeviceHeight()
  {
    return (int)DeviceInfoUtil.l();
  }
  
  public int getDeviceWidth()
  {
    return (int)DeviceInfoUtil.k();
  }
  
  public int getDispalyDpi()
  {
    return DeviceInfoUtil.e();
  }
  
  public int getMusicCurPos(int paramInt)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      return this.mPlayer.a(paramInt);
    }
    return -1;
  }
  
  public int getMusicDuration(int paramInt)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      return this.mPlayer.b(paramInt);
    }
    return -1;
  }
  
  public int getMusicSwitch()
  {
    this.mPlayer = getRightPlayer();
    AppInterface localAppInterface = CmGameUtil.a();
    if ((this.mPlayer != null) && (localAppInterface != null)) {
      return this.mPlayer.a(localAppInterface);
    }
    return 1;
  }
  
  public String getNickname(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = paramString2;
    if (this.mAppInterfaceRef != null)
    {
      localObject = paramString2;
      if (this.mAppInterfaceRef.get() != null)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          break label36;
        }
        localObject = paramString2;
      }
    }
    return localObject;
    label36:
    if (paramInt == 4) {
      paramString1 = ContactUtils.d((QQAppInterface)this.mAppInterfaceRef.get(), paramString1, paramString2);
    }
    for (;;)
    {
      localObject = paramString1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "[getNickname], nickName:" + paramString1);
      return paramString1;
      if (paramInt == 5)
      {
        paramString1 = ContactUtils.d((QQAppInterface)this.mAppInterfaceRef.get(), paramString2, false);
      }
      else
      {
        paramString1 = paramString2;
        if (paramInt == 1)
        {
          localObject = (QQAppInterface)this.mAppInterfaceRef.get();
          paramString1 = paramString2;
          if (localObject != null)
          {
            localObject = ((FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString2);
            paramString1 = paramString2;
            if (localObject != null) {
              paramString1 = ((Friends)localObject).getFriendNick();
            }
          }
        }
      }
    }
  }
  
  public void getOpenApiHead(long paramLong, String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.mRequestHandlers.size())
      {
        if ((this.mRequestHandlers.get(i) instanceof CmGameSubProcessHandler)) {
          ((CmGameSubProcessHandler)this.mRequestHandlers.get(i)).a(paramLong, paramString, new ApolloCmdChannelImpl.7(this, paramLong, paramString));
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void getOpenApiNick(long paramLong, String paramString)
  {
    int i = 0;
    while (i < this.mRequestHandlers.size())
    {
      if ((this.mRequestHandlers.get(i) instanceof CmGameSubProcessHandler)) {
        ((CmGameSubProcessHandler)this.mRequestHandlers.get(i)).a(paramLong, paramString, new ApolloCmdChannelImpl.8(this, paramLong, paramString));
      }
      i += 1;
    }
  }
  
  public void handleWebEvent(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, new Object[] { "[handleWebEvent] data=", paramString });
    }
    if (!ApolloEngine.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "handleWebEvent ApolloEngine.isEngineReady() false");
      }
      return;
    }
    if (paramInt != 0) {}
    for (IRenderRunner localIRenderRunner = this.mRenderRunners.a(paramInt);; localIRenderRunner = this.mRenderRunners.a())
    {
      if (localIRenderRunner != null) {
        break label92;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "[handleWebEvent], not find renderRunner");
      return;
    }
    label92:
    localIRenderRunner.runRenderTask(new ApolloCmdChannelImpl.5(this, localIRenderRunner, paramString));
  }
  
  /* Error */
  public void makesureHasInitObj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 261	com/tencent/mobileqq/apollo/ApolloEngine:a	()Z
    //   5: ifeq +38 -> 43
    //   8: aload_0
    //   9: getfield 339	com/tencent/mobileqq/apollo/api/impl/ApolloCmdChannelImpl:mSetNativeObj	Z
    //   12: ifne +28 -> 40
    //   15: aload_0
    //   16: aload_0
    //   17: invokevirtual 343	com/tencent/mobileqq/apollo/api/impl/ApolloCmdChannelImpl:nativeSetDataChannelObj	(Lcom/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel;)V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 339	com/tencent/mobileqq/apollo/api/impl/ApolloCmdChannelImpl:mSetNativeObj	Z
    //   25: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +12 -> 40
    //   31: ldc 10
    //   33: iconst_2
    //   34: ldc_w 475
    //   37: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq -6 -> 40
    //   49: ldc 10
    //   51: iconst_2
    //   52: ldc_w 477
    //   55: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: goto -18 -> 40
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ApolloCmdChannelImpl
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	61	finally
    //   43	58	61	finally
  }
  
  public void nativeOpenApiGetHeadCallBack(long paramLong, @Nullable String paramString, int paramInt1, int paramInt2, int paramInt3, @Nullable byte[] paramArrayOfByte)
  {
    super.nativeOpenApiGetHeadCallBack(paramLong, paramString, paramInt1, paramInt2, paramInt3, paramArrayOfByte);
  }
  
  public void nativeOpenApiGetNickCallBack(long paramLong, @Nullable String paramString1, int paramInt, @Nullable String paramString2)
  {
    super.nativeOpenApiGetNickCallBack(paramLong, paramString1, paramInt, paramString2);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (this.mAppInterfaceRef = new WeakReference((QQAppInterface)paramAppRuntime);; this.mAppInterfaceRef = new WeakReference(null))
    {
      this.mPlayer = new ApolloGameMusicPlayer((AppInterface)this.mAppInterfaceRef.get(), -10000);
      return;
    }
  }
  
  public void onDestroy()
  {
    this.mRenderRunners.a();
    synchronized (this.mRequestHandlers)
    {
      Iterator localIterator = this.mRequestHandlers.iterator();
      if (localIterator.hasNext()) {
        ((IRequestHandler)localIterator.next()).a();
      }
    }
    this.mRequestHandlers.clear();
    this.mRequestHandlerThread.removeCallbacksAndMessages(null);
    if (this.mPlayer != null) {
      this.mPlayer.c();
    }
  }
  
  public void openWebview(String paramString)
  {
    if (this.mActivityRef != null) {}
    for (Object localObject1 = (Activity)this.mActivityRef.get();; localObject1 = BaseActivity.sTopActivity)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (SplashActivity.sWeakInstance != null) {
          localObject2 = (Activity)SplashActivity.sWeakInstance.get();
        }
      }
      if (localObject2 != null)
      {
        localObject1 = new Intent((Context)localObject2, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("game_busid", "Android.H5");
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.openQQBrowserActivity((Context)localObject2, paramString, -1L, (Intent)localObject1, true, 100);
        QLog.i("cmshow_scripted_cmgame_process.ApolloDataChannel", 1, "openWebview activity=" + localObject2 + ", url: " + paramString);
      }
      return;
    }
  }
  
  public void operateNativeUI(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = CmGameUtil.b(paramLong);
    if (localObject != null)
    {
      localObject = ((CmGameLauncher)localObject).a();
      if (localObject == null) {}
    }
    try
    {
      paramString3 = new JSONObject(paramString3);
      paramString3.put("action", paramString4);
      ((NativeUIManager)localObject).a(paramString1, paramString2, paramString4, paramString3.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmshow_scripted_cmgame_process.ApolloDataChannel", 1, paramString1, new Object[0]);
    }
  }
  
  public void pauseMusic(int paramInt, String paramString)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.a(paramInt, paramString);
    }
  }
  
  public void playMusic(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "[playMusic], type:" + paramInt1 + ",count:" + paramInt2 + ",musicPath:" + paramString);
    }
    playMusic(paramLong, paramInt1, paramInt2, paramString, -1.0F, 0, 0);
  }
  
  public void playMusic(long paramLong, int paramInt1, int paramInt2, String paramString, float paramFloat, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, new Object[] { "[playMusic], type:", Integer.valueOf(paramInt1), ",count:", Integer.valueOf(paramInt2), ",musicPath:", "volumn:", Float.valueOf(paramFloat), ",seekTo:", Integer.valueOf(paramInt3), ",audioType:", Integer.valueOf(paramInt4) });
    }
    IRenderRunner localIRenderRunner = this.mRenderRunners.b(Thread.currentThread().getId());
    if (localIRenderRunner == null) {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "[playMusic], not find renderRunner");
      }
    }
    label232:
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "[playMusic], musicPath is null");
      return;
      if (paramString.startsWith("actionMusic:")) {
        paramString = paramString.substring(paramString.indexOf(":") + 1);
      }
      for (;;)
      {
        if (!(localIRenderRunner instanceof View)) {
          break label232;
        }
        View localView = (View)localIRenderRunner;
        if ((localView == null) || (localView.isShown())) {
          break label232;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "DO NOT play music, cause the view is not visible.");
        return;
      }
      createRightPlayer(paramInt4);
      this.mPlayer = getRightPlayer();
    } while (this.mPlayer == null);
    ThreadManager.post(new ApolloCmdChannelImpl.PlayMusicTask(getGameId(), this, localIRenderRunner, this.mPlayer, paramLong, paramInt1, paramInt2, paramString, paramFloat, paramInt3), 5, null, true);
  }
  
  public void playMusicInner(IRenderRunner paramIRenderRunner, int paramInt, long paramLong)
  {
    if ((paramIRenderRunner != null) && (paramInt != 0) && (paramLong != 0L))
    {
      if (ApolloEngine.a()) {
        break label36;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "playMusicInner ApolloEngine.isEngineReady() false");
      }
    }
    return;
    label36:
    paramIRenderRunner.runRenderTask(new ApolloCmdChannelImpl.6(this, paramLong, paramInt));
  }
  
  public void removeCmdHandler(IRequestHandler paramIRequestHandler)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(paramIRequestHandler);
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "removeCmdHandler class:" + paramIRequestHandler.getClass().getName() + ", size: " + this.mRequestHandlers.size());
      }
      return;
    }
  }
  
  public void removeRenderRunner(IRenderRunner paramIRenderRunner)
  {
    this.mRenderRunners.b(paramIRenderRunner);
  }
  
  public String requestData(long paramLong, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "{}";
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, this + "[requestData], luaState:" + paramLong + ",cmd:" + paramString1 + ",async:" + paramBoolean1 + ",isCallFromJsRuntime:" + paramBoolean2);
    }
    if (isGameHandlerClosed()) {
      CmGameUtil.a(paramString1, paramString2);
    }
    if (CmGameToolCmdChannel.a(paramLong, paramBoolean1, paramString1, paramString2))
    {
      QLog.i("cmshow_scripted_cmgame_process.ApolloDataChannel", 1, "fetch uin by openId first.");
      return "{}";
    }
    paramString2 = CmGameOpenIdFinder.a(paramLong, paramString1, paramString2);
    if (1 == CmGameToolCmdChannel.a(paramLong, paramString1, paramString2, paramBoolean1)) {
      return "{}";
    }
    this.mCallJsRuntimeMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean2));
    ??? = paramString1.trim();
    Object localObject2 = new ApolloCmdChannelImpl.RequestRunable(this, paramLong, (String)???, paramString2);
    if (("cs.close_room.local".equals(???)) || ("cs.make_room_min.local".equals(???)) || ("cs.share_game_result.local".equals(???)) || ("cs.invite_friends.local".equals(paramString1)) || ("cs.send_b2c_redpacket.local".equals(paramString1)) || ("cs.qta_notify_test_result.local".equals(paramString1)) || ("cs.share_pic.local".equals(paramString1))) {
      ThreadManager.post((Runnable)localObject2, 5, null, true);
    }
    for (;;)
    {
      return "{}";
      if (paramBoolean1) {
        this.mRequestHandlerThread.post((Runnable)localObject2);
      } else {
        synchronized (this.mRequestHandlers)
        {
          localObject2 = this.mRequestHandlers.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            HandleResult localHandleResult = ((IRequestHandler)((Iterator)localObject2).next()).a(paramLong, paramString1, paramString2);
            if (localHandleResult != null)
            {
              if (localHandleResult.jdField_a_of_type_Boolean) {
                ((Iterator)localObject2).remove();
              }
              paramString1 = localHandleResult.jdField_a_of_type_JavaLangString;
              return paramString1;
            }
          }
        }
      }
    }
  }
  
  public void resumeMusic(int paramInt, String paramString)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.b(paramInt, paramString);
    }
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.a(paramInt1, paramInt2);
    }
  }
  
  public void setActivityContext(Activity paramActivity)
  {
    if ((this.mSetNativeObj) && ((this.mActivityRef == null) || (this.mActivityRef.get() != paramActivity)))
    {
      this.mActivityRef = new WeakReference(paramActivity);
      synchronized (this.mRequestHandlers)
      {
        Iterator localIterator = this.mRequestHandlers.iterator();
        while (localIterator.hasNext())
        {
          IRequestHandler localIRequestHandler = (IRequestHandler)localIterator.next();
          if (localIRequestHandler.a(paramActivity))
          {
            localIRequestHandler.a();
            localIterator.remove();
            QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 1, "setActivityContext handler.checkReCreateOnActivityChanged:" + localIRequestHandler.getClass());
          }
        }
      }
      this.mRequestHandlers.add(new GeneralEventHandler(paramActivity, (QQAppInterface)this.mAppInterfaceRef.get()));
      Collections.sort(this.mRequestHandlers, new ApolloCmdChannelImpl.1(this));
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 1, "setActivityContext activity: " + paramActivity);
    }
  }
  
  public void setMusicSwitch(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "[setMusicSwitch], switch:" + paramInt);
    }
    this.mPlayer = getRightPlayer();
    AppInterface localAppInterface = CmGameUtil.a();
    if ((this.mPlayer != null) && (localAppInterface != null)) {
      this.mPlayer.a(paramInt, localAppInterface);
    }
  }
  
  public void setScreenMode(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.i("cmshow_scripted_cmgame_process.ApolloDataChannel", 1, "[setScreenMode] " + paramInt1 + ",oldWidth:" + paramInt2 + ",oldHeight:" + paramInt3);
    Object localObject1 = ApolloRender.getCurrentRender();
    Object localObject2 = this.mRenderRunners.b(Thread.currentThread().getId());
    if (localObject2 == null) {}
    Object localObject3;
    do
    {
      do
      {
        return;
        localObject3 = CmGameUtil.b(((IRenderRunner)localObject2).getRuntimeState());
      } while ((localObject3 == null) || (localObject1 == null));
      localObject2 = ((CmGameLauncher)localObject3).a();
      localObject3 = ((CmGameLauncher)localObject3).a();
    } while ((localObject3 == null) || (localObject2 == null));
    int i = ((CmGameInitParams)localObject3).mViewMode + 1;
    QLog.i("cmshow_scripted_cmgame_process.ApolloDataChannel", 1, "oldMode:" + i);
    if (((i == 1) && ((paramInt1 == 2) || (paramInt1 == 3))) || (((i == 2) || (i == 3)) && (paramInt1 == 1)))
    {
      localObject1 = ((ApolloRender)localObject1).getSavaWrapper();
      if (localObject1 != null) {
        ((ApolloEngine)localObject1).a(paramInt3 / DeviceInfoUtil.a, paramInt2 / DeviceInfoUtil.a);
      }
    }
    ((CmGameScreenRotate)localObject2).a(CmGameScreenRotate.a(paramInt1));
  }
  
  public void stopMusic(int paramInt, String paramString)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.c(paramInt, paramString);
    }
  }
  
  public void updateUserInfo(CmGameUserInfo paramCmGameUserInfo)
  {
    int i = 0;
    while (i < this.mRequestHandlers.size())
    {
      if ((this.mRequestHandlers.get(i) instanceof CmGameSubProcessHandler)) {
        ((CmGameSubProcessHandler)this.mRequestHandlers.get(i)).a(paramCmGameUserInfo);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloCmdChannelImpl
 * JD-Core Version:    0.7.0.1
 */