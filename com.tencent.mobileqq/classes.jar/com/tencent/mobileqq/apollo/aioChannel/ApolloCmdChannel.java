package com.tencent.mobileqq.apollo.aioChannel;

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
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler;
import com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate;
import com.tencent.mobileqq.apollo.utils.ApolloGameMusicPlayer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
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
import yoo;
import yop;
import yoq;
import yor;
import yos;
import yot;
import you;
import yov;

public class ApolloCmdChannel
{
  private static final String TAG = "cmgame_process.ApolloDataChannel";
  private static ApolloCmdChannel sDataChannel;
  private AppInterface _mApp;
  private WeakReference mActivityRef;
  private WeakReference mAppRef;
  private HashMap mCallJsRuntimeMap;
  private ApolloGameMusicPlayer mPlayer;
  private ApolloRenderRunner mRenderRunners;
  private WeakReferenceHandler mRequestHandlerThread;
  private List mRequestHandlers;
  private volatile boolean mSetNativeObj;
  
  public ApolloCmdChannel(AppInterface paramAppInterface)
  {
    this._mApp = paramAppInterface;
    this.mCallJsRuntimeMap = new HashMap();
    this.mRenderRunners = new ApolloRenderRunner();
    this.mRequestHandlers = new ArrayList();
    this.mPlayer = new ApolloGameMusicPlayer(CmGameUtil.a());
    init();
  }
  
  private ApolloCmdChannel(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.mRequestHandlers = new ArrayList();
    this.mRenderRunners = new ApolloRenderRunner();
    this.mPlayer = new ApolloGameMusicPlayer(paramQQAppInterface);
    this.mCallJsRuntimeMap = new HashMap();
    init();
  }
  
  private native void callbackEngineOld(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public static void checkNeedDestroy()
  {
    if (sDataChannel != null)
    {
      sDataChannel.onDestroy();
      sDataChannel = null;
    }
  }
  
  public static ApolloCmdChannel getChannel(QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      try
      {
        if (sDataChannel == null)
        {
          sDataChannel = new ApolloCmdChannel(paramQQAppInterface);
          paramQQAppInterface = sDataChannel;
          return paramQQAppInterface;
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)sDataChannel.mAppRef.get();
        if (localQQAppInterface == null)
        {
          sDataChannel.onDestroy();
          sDataChannel = new ApolloCmdChannel(paramQQAppInterface);
          QLog.d("cmgame_process.ApolloDataChannel", 1, "oldApp == null create new cmdChannel App:" + paramQQAppInterface);
          continue;
        }
        if (localQQAppInterface == paramQQAppInterface) {
          continue;
        }
      }
      finally {}
      sDataChannel.onDestroy();
      sDataChannel = new ApolloCmdChannel(paramQQAppInterface);
      QLog.d("cmgame_process.ApolloDataChannel", 1, "oldApp != app create new cmdChannel App:" + paramQQAppInterface);
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
  
  private void init()
  {
    makesureHasInitObj();
    this.mRequestHandlerThread = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.add(new GeneralMsgHandler());
      Collections.sort(this.mRequestHandlers, new yop(this));
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
          if (!((ApolloCmdChannel.IRequestHandler)localIterator.next() instanceof CmGameSubProcessHandler)) {
            continue;
          }
          bool = false;
          return bool;
        }
      }
      boolean bool = true;
    }
  }
  
  private native void nativeGetHeadCallback(Bitmap paramBitmap, String paramString, int paramInt, long paramLong);
  
  private native void nativeGetNickCallback(String paramString1, String paramString2, int paramInt, long paramLong);
  
  private native void nativeSetAudioHash(long paramLong, int paramInt);
  
  private native void nativeSetDataChannelObj(ApolloCmdChannel paramApolloCmdChannel);
  
  public static void onAccountChanged()
  {
    if (sDataChannel != null)
    {
      sDataChannel.onDestroy();
      sDataChannel = null;
    }
  }
  
  private void playMusicInner(IRenderRunner paramIRenderRunner, int paramInt, long paramLong)
  {
    if ((paramIRenderRunner != null) && (paramInt != 0) && (paramLong != 0L))
    {
      if (ApolloEngine.a()) {
        break label35;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "playMusicInner ApolloEngine.isEngineReady() false");
      }
    }
    return;
    label35:
    paramIRenderRunner.runRenderTask(new yot(this, paramLong, paramInt));
  }
  
  public void addCmdHandler(ApolloCmdChannel.IRequestHandler paramIRequestHandler)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(paramIRequestHandler);
      this.mRequestHandlers.add(paramIRequestHandler);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "addCmdHandler class:" + paramIRequestHandler.getClass().getName() + ", size: " + this.mRequestHandlers.size());
      }
      return;
    }
  }
  
  public void addRenderRunner(IRenderRunner paramIRenderRunner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "addRenderRunner,renderRunner:" + paramIRenderRunner);
    }
    this.mRenderRunners.a(paramIRenderRunner);
  }
  
  public void callbackDirect(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[callbackEngine], luaState:" + paramLong + ",errCode:" + paramInt + ",cmd:" + paramString1 + ",reqData:" + paramString2);
    }
    if (-1L == paramLong)
    {
      QLog.i("cmgame_process.ApolloDataChannel", 1, "callbackEngine, errInfo->lState is destroyed.");
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
  
  public native void callbackEngine(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public void callbackEngineWrapper(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (paramLong == -1L) {}
    do
    {
      return;
      if (ApolloEngine.a())
      {
        Boolean localBoolean = (Boolean)this.mCallJsRuntimeMap.get(Long.valueOf(paramLong));
        if (localBoolean != null)
        {
          try
          {
            if (localBoolean.booleanValue())
            {
              if (QLog.isColorLevel()) {
                QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper isCallFromJs callbackEngine,lState:" + paramLong);
              }
              callbackEngine(paramLong, paramInt, paramString1, paramString2);
              return;
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            QLog.e("cmgame_process.ApolloDataChannel", 1, paramString1, new Object[0]);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper isCallFromJs callbackEngineOld,lState:" + paramLong);
          }
          callbackEngineOld(paramLong, paramInt, paramString1, paramString2);
          return;
        }
        if (paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper callbackEngine, jsRuntime lState:" + paramLong);
          }
          callbackEngine(paramLong, paramInt, paramString1, paramString2);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper callbackEngineOld, jsRuntime lState:" + paramLong);
        }
        callbackEngineOld(paramLong, paramInt, paramString1, paramString2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackEngineWarpper ApolloEngine.isEngineReady() false");
  }
  
  public void callbackFromRequest(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[callbackFromRequest], luaState:" + paramLong + ",errCode:" + paramInt + ",cmd:" + paramString1 + ",reqData:" + paramString2);
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
        QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackGetHead ApolloEngine.isEngineReady() false");
      }
    }
    return;
    label38:
    localIRenderRunner.runRenderTask(new yor(this, paramBitmap, paramString, paramInt, paramLong));
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
        QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackGetNick ApolloEngine.isEngineReady() false");
      }
    }
    return;
    label38:
    localIRenderRunner.runRenderTask(new yoq(this, paramString1, paramString2, paramInt, paramLong));
  }
  
  public void checkSetNative()
  {
    if (!this.mSetNativeObj)
    {
      nativeSetDataChannelObj(this);
      this.mSetNativeObj = true;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "checkSetNative nativeSetDataChannelObj");
      }
    }
  }
  
  public void destroyMusic(int paramInt)
  {
    if (this.mPlayer != null) {
      this.mPlayer.c(paramInt);
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
    return (int)DeviceInfoUtil.m();
  }
  
  public int getDeviceWidth()
  {
    return (int)DeviceInfoUtil.l();
  }
  
  public int getDispalyDpi()
  {
    return DeviceInfoUtil.d();
  }
  
  public int getMusicSwitch()
  {
    AppInterface localAppInterface = CmGameUtil.a();
    if ((this.mPlayer != null) && (localAppInterface != null)) {
      return this.mPlayer.a(localAppInterface, getGameId());
    }
    return 1;
  }
  
  public String getNickname(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = paramString2;
    if (this.mAppRef != null)
    {
      localObject = paramString2;
      if (this.mAppRef.get() != null)
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
      paramString1 = ContactUtils.e((QQAppInterface)this.mAppRef.get(), paramString1, paramString2);
    }
    for (;;)
    {
      localObject = paramString1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[getNickname], nickName:" + paramString1);
      return paramString1;
      if (paramInt == 5)
      {
        paramString1 = ContactUtils.c((QQAppInterface)this.mAppRef.get(), paramString2, false);
      }
      else
      {
        paramString1 = paramString2;
        if (paramInt == 1)
        {
          localObject = (QQAppInterface)this.mAppRef.get();
          paramString1 = paramString2;
          if (localObject != null)
          {
            localObject = ((FriendsManager)((QQAppInterface)localObject).getManager(50)).a(paramString2);
            paramString1 = paramString2;
            if (localObject != null) {
              paramString1 = ((Friends)localObject).getFriendNick();
            }
          }
        }
      }
    }
  }
  
  public void handleWebEvent(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, new Object[] { "[handleWebEvent] data=", paramString });
    }
    if (!ApolloEngine.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "handleWebEvent ApolloEngine.isEngineReady() false");
      }
    }
    IRenderRunner localIRenderRunner;
    do
    {
      return;
      localIRenderRunner = this.mRenderRunners.a();
      if (localIRenderRunner != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.ApolloDataChannel", 2, "[handleWebEvent], not find renderRunner");
    return;
    localIRenderRunner.runRenderTask(new yos(this, localIRenderRunner, paramString));
  }
  
  /* Error */
  public void makesureHasInitObj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 221	com/tencent/mobileqq/apollo/ApolloEngine:a	()Z
    //   5: ifeq +38 -> 43
    //   8: aload_0
    //   9: getfield 358	com/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel:mSetNativeObj	Z
    //   12: ifne +28 -> 40
    //   15: aload_0
    //   16: aload_0
    //   17: invokespecial 360	com/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel:nativeSetDataChannelObj	(Lcom/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel;)V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 358	com/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel:mSetNativeObj	Z
    //   25: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +12 -> 40
    //   31: ldc 8
    //   33: iconst_2
    //   34: ldc_w 444
    //   37: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq -6 -> 40
    //   49: ldc 8
    //   51: iconst_2
    //   52: ldc_w 446
    //   55: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: goto -18 -> 40
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ApolloCmdChannel
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	61	finally
    //   43	58	61	finally
  }
  
  public void onDestroy()
  {
    this.mRenderRunners.a();
    synchronized (this.mRequestHandlers)
    {
      Iterator localIterator = this.mRequestHandlers.iterator();
      if (localIterator.hasNext()) {
        ((ApolloCmdChannel.IRequestHandler)localIterator.next()).a();
      }
    }
    this.mRequestHandlers.clear();
    this.mRequestHandlerThread.removeCallbacksAndMessages(null);
    this.mPlayer.c(getGameId());
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
        if (SplashActivity.a != null) {
          localObject2 = (Activity)SplashActivity.a.get();
        }
      }
      if (localObject2 != null)
      {
        VasWebviewUtil.openQQBrowserActivity((Context)localObject2, paramString, -1L, new Intent((Context)localObject2, QQBrowserActivity.class), true, 100);
        QLog.i("cmgame_process.ApolloDataChannel", 1, "openWebview activity=" + localObject2 + ", url: " + paramString);
      }
      return;
    }
  }
  
  public void pauseGameMusic(int paramInt)
  {
    if (this.mPlayer != null) {
      this.mPlayer.a(paramInt);
    }
  }
  
  public void pauseMusic(int paramInt, String paramString)
  {
    if (this.mPlayer != null) {
      this.mPlayer.a(getGameId(), paramInt, paramString);
    }
  }
  
  public void playMusic(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[playMusic], type:" + paramInt1 + ",count:" + paramInt2 + ",musicPath:" + paramString);
    }
    IRenderRunner localIRenderRunner = this.mRenderRunners.b(Thread.currentThread().getId());
    if (localIRenderRunner == null) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "[playMusic], not find renderRunner");
      }
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloDataChannel", 2, "[playMusic], musicPath is null");
        }
      }
      else
      {
        if (paramString.startsWith("actionMusic:")) {}
        for (String str = paramString.substring(paramString.indexOf(":") + 1);; str = paramString)
        {
          if (!(localIRenderRunner instanceof View)) {
            break label193;
          }
          paramString = (View)localIRenderRunner;
          if ((paramString == null) || (paramString.isShown())) {
            break label193;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("cmgame_process.ApolloDataChannel", 2, "DO NOT play music, cause the view is not visible.");
          return;
        }
        label193:
        paramString = null;
        if (this.mAppRef != null) {
          paramString = (AppInterface)this.mAppRef.get();
        }
        if (CmGameUtil.a()) {
          paramString = CmGameUtil.a();
        }
        while ((this.mPlayer != null) && (paramString != null))
        {
          ThreadManager.post(new you(getGameId(), paramString, localIRenderRunner, this.mPlayer, paramLong, paramInt1, paramInt2, str), 5, null, true);
          return;
        }
      }
    }
  }
  
  public void removeCmdHandler(ApolloCmdChannel.IRequestHandler paramIRequestHandler)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(paramIRequestHandler);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "removeCmdHandler class:" + paramIRequestHandler.getClass().getName() + ", size: " + this.mRequestHandlers.size());
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
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[requestData], luaState:" + paramLong + ",cmd:" + paramString1 + ",reqData:" + paramString2 + ",async:" + paramBoolean1 + ",isCallFromJsRuntime:" + paramBoolean2);
    }
    if (isGameHandlerClosed()) {
      CmGameUtil.a(paramString1, paramString2);
    }
    if (CmGameToolCmdChannel.a(paramLong, paramBoolean1, paramString1, paramString2))
    {
      QLog.i("cmgame_process.ApolloDataChannel", 1, "fetch uin by openId first.");
      return "{}";
    }
    paramString2 = CmGameOpenIdFinder.a(paramLong, paramString1, paramString2);
    if (1 == CmGameToolCmdChannel.a(paramLong, paramString1, paramString2, paramBoolean1)) {
      return "{}";
    }
    this.mCallJsRuntimeMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean2));
    ??? = paramString1.trim();
    Object localObject2 = new yov(this, paramLong, (String)???, paramString2);
    if (("cs.close_room.local".equals(???)) || ("cs.make_room_min.local".equals(???)) || ("cs.share_game_result.local".equals(???)) || ("cs.invite_friends.local".equals(paramString1)) || ("cs.first_frame_drawn.local".equals(paramString1)) || ("cs.share_pic.local".equals(paramString1))) {
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
            HandleResult localHandleResult = ((ApolloCmdChannel.IRequestHandler)((Iterator)localObject2).next()).a(paramLong, paramString1, paramString2);
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
  
  public void resumeGameMusic(int paramInt)
  {
    if (this.mPlayer != null) {
      this.mPlayer.b(paramInt);
    }
  }
  
  public void resumeMusic(int paramInt, String paramString)
  {
    if (this.mPlayer != null) {
      this.mPlayer.b(getGameId(), paramInt, paramString);
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
          ApolloCmdChannel.IRequestHandler localIRequestHandler = (ApolloCmdChannel.IRequestHandler)localIterator.next();
          if (localIRequestHandler.a(paramActivity))
          {
            localIRequestHandler.a();
            localIterator.remove();
            QLog.d("cmgame_process.ApolloDataChannel", 1, "setActivityContext handler.checkReCreateOnActivityChanged:" + localIRequestHandler.getClass());
          }
        }
      }
      this.mRequestHandlers.add(new GeneralEventHandler(paramActivity, (QQAppInterface)this.mAppRef.get()));
      Collections.sort(this.mRequestHandlers, new yoo(this));
      QLog.d("cmgame_process.ApolloDataChannel", 1, "setActivityContext activity: " + paramActivity);
    }
  }
  
  public void setMusicSwitch(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[setMusicSwitch], switch:" + paramInt);
    }
    AppInterface localAppInterface = CmGameUtil.a();
    int i = getGameId();
    if ((this.mPlayer != null) && (localAppInterface != null) && (-1 != i)) {
      this.mPlayer.a(paramInt, localAppInterface, i);
    }
  }
  
  public void setScreenMode(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.i("cmgame_process.ApolloDataChannel", 1, "[setScreenMode] " + paramInt1 + ",oldWidth:" + paramInt2 + ",oldHeight:" + paramInt3);
    Object localObject1 = ApolloRender.getRenderByThreadId();
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
    QLog.i("cmgame_process.ApolloDataChannel", 1, "oldMode:" + i);
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
    if (this.mPlayer != null) {
      this.mPlayer.c(getGameId(), paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel
 * JD-Core Version:    0.7.0.1
 */