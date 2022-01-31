package com.tencent.mobileqq.apollo.aioChannel;

import aiiu;
import aiiv;
import aiiw;
import aiix;
import aiiy;
import aijb;
import aijd;
import aije;
import aijf;
import ailx;
import aing;
import ainm;
import aioa;
import aios;
import aioy;
import aipj;
import aipx;
import aiqb;
import airc;
import ajjj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import babh;
import babp;
import befq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ApolloCmdChannel
{
  private static final String TAG = "cmgame_process.ApolloDataChannel";
  private static ApolloCmdChannel sDataChannel;
  private AppInterface _mApp;
  private WeakReference<Activity> mActivityRef;
  private WeakReference<QQAppInterface> mAppRef;
  private HashMap<Long, Boolean> mCallJsRuntimeMap;
  private aioa mPlayer;
  private aijb mRenderRunners;
  private befq mRequestHandlerThread;
  private List<aiiy> mRequestHandlers;
  private volatile boolean mSetNativeObj;
  
  public ApolloCmdChannel(AppInterface paramAppInterface)
  {
    this._mApp = paramAppInterface;
    this.mCallJsRuntimeMap = new HashMap();
    this.mRenderRunners = new aijb();
    this.mRequestHandlers = new ArrayList();
    init();
  }
  
  private ApolloCmdChannel(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.mRequestHandlers = new ArrayList();
    this.mRenderRunners = new aijb();
    this.mPlayer = new ainm(paramQQAppInterface, -10000);
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
  
  private void createRightPlayer(int paramInt)
  {
    if (aing.a())
    {
      aipj localaipj = aing.a(getGameId());
      if (localaipj != null) {
        localaipj.b(paramInt);
      }
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
    if (aing.a())
    {
      aipj localaipj = aing.a(Thread.currentThread().getId());
      if (localaipj == null) {
        return -1;
      }
      return localaipj.a();
    }
    return -10000;
  }
  
  private aioa getRightPlayer()
  {
    if (aing.a())
    {
      aipj localaipj = aing.a(getGameId());
      if (localaipj != null) {
        return localaipj.a();
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
    this.mRequestHandlerThread = new befq(ThreadManager.getSubThreadLooper(), null);
    synchronized (this.mRequestHandlers)
    {
      Collections.sort(this.mRequestHandlers, new aiiv(this));
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
          if (!((aiiy)localIterator.next() instanceof aios)) {
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
  
  public void addCmdHandler(aiiy paramaiiy)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(paramaiiy);
      this.mRequestHandlers.add(paramaiiy);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "addCmdHandler class:" + paramaiiy.getClass().getName() + ", size: " + this.mRequestHandlers.size());
      }
      return;
    }
  }
  
  public void addRenderRunner(aijf paramaijf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "addRenderRunner,renderRunner:" + paramaijf);
    }
    this.mRenderRunners.a(paramaijf);
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
  
  void callbackEngineWrapper(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
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
          localaipj = aing.b(paramLong);
          if ((localaipj == null) || (!localaipj.b())) {
            break label258;
          }
          if (localBoolean == null) {
            break label166;
          }
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
        aipj localaipj = aing.a((int)paramLong);
        if (localaipj == null) {
          break;
        }
        if (!localaipj.b())
        {
          localaipj.a(paramInt, paramString1, paramString2);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.ApolloDataChannel", 2, "not h5 game");
      return;
      if ((paramBoolean) || (localBoolean.booleanValue())) {
        callbackEngine(paramLong, paramInt, paramString1, paramString2);
      }
      QLog.e("cmgame_process.ApolloDataChannel", 1, "can not find h5 launcher");
      return;
    } while (!QLog.isColorLevel());
    label258:
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
    aijf localaijf = this.mRenderRunners.a(paramLong);
    if (localaijf != null)
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
    localaijf.runRenderTask(new ApolloCmdChannel.4(this, paramBitmap, paramString, paramInt, paramLong));
  }
  
  public void callbackGetNick(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    aijf localaijf = this.mRenderRunners.a(paramLong);
    if (localaijf != null)
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
    localaijf.runRenderTask(new ApolloCmdChannel.3(this, paramString1, paramString2, paramInt, paramLong));
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
  
  public void destroyMusic()
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.c();
    }
  }
  
  public void exeJsOnEngine(aijf paramaijf, String paramString)
  {
    this.mRenderRunners.a(paramaijf, paramString);
  }
  
  public void getAccountInfo(long paramLong, String paramString, int paramInt)
  {
    if (aing.a()) {
      aipx.a(paramLong, paramInt, paramString);
    }
  }
  
  public int getDeviceHeight()
  {
    return (int)babp.l();
  }
  
  public int getDeviceWidth()
  {
    return (int)babp.k();
  }
  
  public int getDispalyDpi()
  {
    return babp.d();
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
    AppInterface localAppInterface = aing.a();
    if ((this.mPlayer != null) && (localAppInterface != null)) {
      return this.mPlayer.a(localAppInterface);
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
      paramString1 = babh.e((QQAppInterface)this.mAppRef.get(), paramString1, paramString2);
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
        paramString1 = babh.c((QQAppInterface)this.mAppRef.get(), paramString2, false);
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
            localObject = ((ajjj)((QQAppInterface)localObject).getManager(51)).b(paramString2);
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
        if ((this.mRequestHandlers.get(i) instanceof aios)) {
          ((aios)this.mRequestHandlers.get(i)).a(paramLong, paramString, new aiiw(this, paramLong, paramString));
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
      if ((this.mRequestHandlers.get(i) instanceof aios)) {
        ((aios)this.mRequestHandlers.get(i)).a(paramLong, paramString, new aiix(this, paramLong, paramString));
      }
      i += 1;
    }
  }
  
  @Deprecated
  public void handleWebEvent(String paramString)
  {
    handleWebEvent(paramString, 0);
  }
  
  public void handleWebEvent(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, new Object[] { "[handleWebEvent] data=", paramString });
    }
    if (!ApolloEngine.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "handleWebEvent ApolloEngine.isEngineReady() false");
      }
      return;
    }
    if (paramInt != 0) {}
    for (aijf localaijf = this.mRenderRunners.a(paramInt);; localaijf = this.mRenderRunners.a())
    {
      if (localaijf != null) {
        break label92;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[handleWebEvent], not find renderRunner");
      return;
    }
    label92:
    localaijf.runRenderTask(new ApolloCmdChannel.5(this, localaijf, paramString));
  }
  
  /* Error */
  public void makesureHasInitObj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 297	com/tencent/mobileqq/apollo/ApolloEngine:a	()Z
    //   5: ifeq +38 -> 43
    //   8: aload_0
    //   9: getfield 374	com/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel:mSetNativeObj	Z
    //   12: ifne +28 -> 40
    //   15: aload_0
    //   16: aload_0
    //   17: invokespecial 376	com/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel:nativeSetDataChannelObj	(Lcom/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel;)V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 374	com/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel:mSetNativeObj	Z
    //   25: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +12 -> 40
    //   31: ldc 8
    //   33: iconst_2
    //   34: ldc_w 499
    //   37: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq -6 -> 40
    //   49: ldc 8
    //   51: iconst_2
    //   52: ldc_w 501
    //   55: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public native void nativeOpenApiGetHeadCallBack(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  public native void nativeOpenApiGetNickCallBack(long paramLong, String paramString1, int paramInt, String paramString2);
  
  public void onDestroy()
  {
    this.mRenderRunners.a();
    synchronized (this.mRequestHandlers)
    {
      Iterator localIterator = this.mRequestHandlers.iterator();
      if (localIterator.hasNext()) {
        ((aiiy)localIterator.next()).a();
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
        if (SplashActivity.a != null) {
          localObject2 = (Activity)SplashActivity.a.get();
        }
      }
      if (localObject2 != null)
      {
        localObject1 = new Intent((Context)localObject2, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("game_busid", "Android.H5");
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.openQQBrowserActivity((Context)localObject2, paramString, -1L, (Intent)localObject1, true, 100);
        QLog.i("cmgame_process.ApolloDataChannel", 1, "openWebview activity=" + localObject2 + ", url: " + paramString);
      }
      return;
    }
  }
  
  public void operateNativeUI(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = aing.b(paramLong);
    if (localObject != null)
    {
      localObject = ((aipj)localObject).a();
      if (localObject == null) {}
    }
    try
    {
      paramString3 = new JSONObject(paramString3);
      paramString3.put("action", paramString4);
      ((airc)localObject).a(paramString1, paramString2, paramString4, paramString3.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmgame_process.ApolloDataChannel", 1, paramString1, new Object[0]);
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
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[playMusic], type:" + paramInt1 + ",count:" + paramInt2 + ",musicPath:" + paramString);
    }
    playMusic(paramLong, paramInt1, paramInt2, paramString, -1.0F, 0, 0);
  }
  
  public void playMusic(long paramLong, int paramInt1, int paramInt2, String paramString, float paramFloat, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, new Object[] { "[playMusic], type:", Integer.valueOf(paramInt1), ",count:", Integer.valueOf(paramInt2), ",musicPath:", "volumn:", Float.valueOf(paramFloat), ",seekTo:", Integer.valueOf(paramInt3), ",audioType:", Integer.valueOf(paramInt4) });
    }
    aijf localaijf = this.mRenderRunners.b(Thread.currentThread().getId());
    if (localaijf == null) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "[playMusic], not find renderRunner");
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
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[playMusic], musicPath is null");
      return;
      if (paramString.startsWith("actionMusic:")) {
        paramString = paramString.substring(paramString.indexOf(":") + 1);
      }
      for (;;)
      {
        if (!(localaijf instanceof View)) {
          break label232;
        }
        View localView = (View)localaijf;
        if ((localView == null) || (localView.isShown())) {
          break label232;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cmgame_process.ApolloDataChannel", 2, "DO NOT play music, cause the view is not visible.");
        return;
      }
      createRightPlayer(paramInt4);
      this.mPlayer = getRightPlayer();
    } while (this.mPlayer == null);
    ThreadManager.post(new ApolloCmdChannel.PlayMusicTask(getGameId(), this, localaijf, this.mPlayer, paramLong, paramInt1, paramInt2, paramString, paramFloat, paramInt3), 5, null, true);
  }
  
  public void playMusicInner(aijf paramaijf, int paramInt, long paramLong)
  {
    if ((paramaijf != null) && (paramInt != 0) && (paramLong != 0L))
    {
      if (ApolloEngine.a()) {
        break label36;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "playMusicInner ApolloEngine.isEngineReady() false");
      }
    }
    return;
    label36:
    paramaijf.runRenderTask(new ApolloCmdChannel.6(this, paramLong, paramInt));
  }
  
  public void removeCmdHandler(aiiy paramaiiy)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(paramaiiy);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "removeCmdHandler class:" + paramaiiy.getClass().getName() + ", size: " + this.mRequestHandlers.size());
      }
      return;
    }
  }
  
  public void removeRenderRunner(aijf paramaijf)
  {
    this.mRenderRunners.b(paramaijf);
  }
  
  public String requestData(long paramLong, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "{}";
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[requestData], luaState:" + paramLong + ",cmd:" + paramString1 + ",async:" + paramBoolean1 + ",isCallFromJsRuntime:" + paramBoolean2);
    }
    if (isGameHandlerClosed()) {
      aing.a(paramString1, paramString2);
    }
    if (aioy.a(paramLong, paramBoolean1, paramString1, paramString2))
    {
      QLog.i("cmgame_process.ApolloDataChannel", 1, "fetch uin by openId first.");
      return "{}";
    }
    paramString2 = aipx.a(paramLong, paramString1, paramString2);
    if (1 == aioy.a(paramLong, paramString1, paramString2, paramBoolean1)) {
      return "{}";
    }
    this.mCallJsRuntimeMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean2));
    ??? = paramString1.trim();
    Object localObject2 = new ApolloCmdChannel.RequestRunable(this, paramLong, (String)???, paramString2);
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
            aije localaije = ((aiiy)((Iterator)localObject2).next()).a(paramLong, paramString1, paramString2);
            if (localaije != null)
            {
              if (localaije.jdField_a_of_type_Boolean) {
                ((Iterator)localObject2).remove();
              }
              paramString1 = localaije.jdField_a_of_type_JavaLangString;
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
          aiiy localaiiy = (aiiy)localIterator.next();
          if (localaiiy.a(paramActivity))
          {
            localaiiy.a();
            localIterator.remove();
            QLog.d("cmgame_process.ApolloDataChannel", 1, "setActivityContext handler.checkReCreateOnActivityChanged:" + localaiiy.getClass());
          }
        }
      }
      this.mRequestHandlers.add(new aijd(paramActivity, (QQAppInterface)this.mAppRef.get()));
      Collections.sort(this.mRequestHandlers, new aiiu(this));
      QLog.d("cmgame_process.ApolloDataChannel", 1, "setActivityContext activity: " + paramActivity);
    }
  }
  
  public void setMusicSwitch(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[setMusicSwitch], switch:" + paramInt);
    }
    this.mPlayer = getRightPlayer();
    AppInterface localAppInterface = aing.a();
    if ((this.mPlayer != null) && (localAppInterface != null)) {
      this.mPlayer.a(paramInt, localAppInterface);
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
        localObject3 = aing.b(((aijf)localObject2).getRuntimeState());
      } while ((localObject3 == null) || (localObject1 == null));
      localObject2 = ((aipj)localObject3).a();
      localObject3 = ((aipj)localObject3).a();
    } while ((localObject3 == null) || (localObject2 == null));
    int i = ((CmGameInitParams)localObject3).mViewMode + 1;
    QLog.i("cmgame_process.ApolloDataChannel", 1, "oldMode:" + i);
    if (((i == 1) && ((paramInt1 == 2) || (paramInt1 == 3))) || (((i == 2) || (i == 3)) && (paramInt1 == 1)))
    {
      localObject1 = ((ApolloRender)localObject1).getSavaWrapper();
      if (localObject1 != null) {
        ((ApolloEngine)localObject1).a(paramInt3 / babp.a, paramInt2 / babp.a);
      }
    }
    ((aiqb)localObject2).a(aiqb.a(paramInt1));
  }
  
  public void stopMusic(int paramInt, String paramString)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.c(paramInt, paramString);
    }
  }
  
  public void updateUserInfo(ailx paramailx)
  {
    int i = 0;
    while (i < this.mRequestHandlers.size())
    {
      if ((this.mRequestHandlers.get(i) instanceof aios)) {
        ((aios)this.mRequestHandlers.get(i)).a(paramailx);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel
 * JD-Core Version:    0.7.0.1
 */