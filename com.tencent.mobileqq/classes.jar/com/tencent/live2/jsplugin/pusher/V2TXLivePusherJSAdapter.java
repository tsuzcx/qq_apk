package com.tencent.live2.jsplugin.pusher;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.AudioMusicParam;
import com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePusherStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTexture;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.impl.V2TXLivePusherImpl;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.c;
import com.tencent.live2.impl.a.d;
import com.tencent.live2.impl.a.e;
import com.tencent.live2.impl.a.f;
import com.tencent.live2.impl.a.g;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.live2.jsplugin.player.V2TXLivePlayerJSConfig;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class V2TXLivePusherJSAdapter
  extends com.tencent.live2.impl.a.b
  implements TXAudioEffectManager.TXMusicPlayObserver
{
  private static final int BGM_ID = 1234567;
  private static final String TAG = "V2TXLivePusherJSAdapter";
  private TXLivePusher.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private TXLivePusher.OnBGMNotify mBGMNotifyListener;
  private V2TXLivePusherJSConfig mConfig;
  private Context mContext;
  private boolean mIsBGMPlaying;
  private boolean mIsBGMPlayingWhenPausePusher;
  private boolean mIsInit;
  private boolean mIsOpenFlashLight;
  private boolean mIsStartCamera;
  private boolean mIsStartMicrophone;
  private int mLastAngle = 0;
  private ITXLivePushListener mLivePushListener;
  private final List<String> mMainStreamUserIdList;
  private Handler mMainThreadHandler;
  private boolean mNeedCompressSnapshot;
  private V2TXLivePusher mPusher;
  private V2TXLiveDef.V2TXLiveMode mPusherMode;
  private a.d mRTCProtocolType;
  private TXLivePusher.ITXSnapshotListener mSnapshotListener;
  private final List<String> mSubStreamUserIdList;
  private Surface mSurface;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private int mTRTCNetworkQuality;
  private Handler mThreadHandler;
  private TXLivePusher.VideoCustomProcessListener mVideoCustomProcessListener;
  private TXCloudVideoView mVideoView;
  
  static
  {
    h.f();
  }
  
  public V2TXLivePusherJSAdapter(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mThreadHandler = new Handler(Looper.getMainLooper());
    this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    this.mConfig = new V2TXLivePusherJSConfig();
    this.mMainStreamUserIdList = new ArrayList();
    this.mSubStreamUserIdList = new ArrayList();
    this.mTRTCNetworkQuality = 2;
  }
  
  private int adjustHomeOrientation(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    if (paramInt == 1) {
      if (paramBoolean) {
        return 0;
      }
    }
    for (;;)
    {
      return 3;
      if (paramInt == 3) {
        if (!paramBoolean) {}
      }
      do
      {
        return 2;
        for (;;)
        {
          return 1;
          if (paramInt != 0) {
            break;
          }
          paramInt = i;
          if (!paramBoolean) {
            return paramInt;
          }
        }
        if (paramInt != 2) {
          break;
        }
      } while (!paramBoolean);
    }
    paramInt = -2147483648;
    return paramInt;
  }
  
  private void apiOnlineError(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("V2TXLivePusherJSAdapter(");
      paramString.append(hashCode());
      paramString.append(")");
      Monitor.a(1, paramString.toString(), str, 0);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("V2TXLivePusherJSAdapter(");
    paramString.append(hashCode());
    paramString.append(")");
    paramString.append(str);
    TXCLog.e("V2TXLivePusherJSAdapter", paramString.toString());
  }
  
  private void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("V2TXLivePusherJSAdapter(");
      paramString.append(hashCode());
      paramString.append(")");
      Monitor.a(1, paramString.toString(), str, 0);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("V2TXLivePusherJSAdapter(");
    paramString.append(hashCode());
    paramString.append(")");
    paramString.append(str);
    TXCLog.i("V2TXLivePusherJSAdapter", paramString.toString());
  }
  
  private void callbackSDKVersion()
  {
    if (this.mLivePushListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      this.mLivePushListener.onPushEvent(-9999999, localBundle);
    }
  }
  
  private void createPusherInstance(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mPusherMode = com.tencent.live2.impl.b.a(paramString);
    this.mPusher = new V2TXLivePusherImpl(this.mContext, this.mPusherMode);
    this.mPusher.setObserver(this);
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    boolean bool;
    if (this.mVideoCustomProcessListener != null) {
      bool = true;
    } else {
      bool = false;
    }
    localV2TXLivePusher.enableCustomVideoProcess(bool, V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D, V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture);
    if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      if (paramString.startsWith("trtc://"))
      {
        this.mRTCProtocolType = a.d.b;
        return;
      }
      if (paramString.startsWith("room://"))
      {
        this.mRTCProtocolType = a.d.a;
        return;
      }
      this.mRTCProtocolType = null;
    }
  }
  
  private String generateURL(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("room://cloud.tencent.com/rtc?userid=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&streamtype=");
    if (paramInt == 2) {
      paramString = "aux";
    } else {
      paramString = "main";
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private JSONObject getAudioAvailableJSONObject(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userid", paramString1);
      localJSONObject.put("playurl", paramString2);
      localJSONObject.put("hasaudio", paramBoolean);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      label42:
      break label42;
    }
    return null;
  }
  
  private JSONObject getUserJSONObject(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userid", paramString);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      label19:
      break label19;
    }
    return null;
  }
  
  private JSONObject getVideoAvailableJSONObject(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("userid", paramString1);
      localJSONObject.put("playurl", paramString2);
      if (paramInt != 2) {
        break label71;
      }
      paramString1 = "aux";
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        continue;
        label71:
        paramString1 = "main";
      }
    }
    localJSONObject.put("streamtype", paramString1);
    localJSONObject.put("hasvideo", paramBoolean);
    return localJSONObject;
    return null;
  }
  
  private V2TXJSAdapterError initLivePusherInner(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      apiOnlineError("init pusher inner fail. invalid bundle params.", false);
      return new V2TXJSAdapterError(-1, "invalid params");
    }
    if (this.mIsInit)
    {
      apiOnlineError("invalid operation. already init.", false);
      return new V2TXJSAdapterError(-1, "invalid operation. already init.");
    }
    this.mIsInit = true;
    apiOnlineLog("init pusher.", true);
    this.mVideoView = paramTXCloudVideoView;
    this.mConfig.updateFromBundle(paramBundle);
    if (TextUtils.isEmpty(this.mConfig.url))
    {
      apiOnlineError("create pusher fail. not find url.", false);
      return new V2TXJSAdapterError();
    }
    createPusherInstance(this.mConfig.url);
    setFullParam(this.mConfig);
    if (this.mConfig.isAutoPush) {
      startPushInner(this.mConfig.url);
    }
    return new V2TXJSAdapterError();
  }
  
  private boolean isRTCProtocolType()
  {
    return this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
  }
  
  private boolean isRTCRoomProtocolType()
  {
    return (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC) && (this.mRTCProtocolType == a.d.a);
  }
  
  /* Error */
  private void notifyFullUserList()
  {
    // Byte code:
    //   0: new 292	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 293	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: new 361	org/json/JSONArray
    //   11: dup
    //   12: invokespecial 362	org/json/JSONArray:<init>	()V
    //   15: astore_2
    //   16: aload_1
    //   17: ldc_w 364
    //   20: aload_2
    //   21: invokevirtual 299	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   24: pop
    //   25: aload_0
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 104	com/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter:mMainStreamUserIdList	Ljava/util/List;
    //   31: invokeinterface 370 1 0
    //   36: astore_3
    //   37: aload_3
    //   38: invokeinterface 375 1 0
    //   43: ifeq +60 -> 103
    //   46: aload_3
    //   47: invokeinterface 379 1 0
    //   52: checkcast 261	java/lang/String
    //   55: astore 4
    //   57: new 292	org/json/JSONObject
    //   60: dup
    //   61: invokespecial 293	org/json/JSONObject:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: ldc_w 295
    //   71: aload 4
    //   73: invokevirtual 299	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload 5
    //   79: ldc_w 301
    //   82: aload_0
    //   83: aload 4
    //   85: iconst_0
    //   86: invokespecial 381	com/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter:generateURL	(Ljava/lang/String;I)Ljava/lang/String;
    //   89: invokevirtual 299	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   92: pop
    //   93: aload_2
    //   94: aload 5
    //   96: invokevirtual 384	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   99: pop
    //   100: goto -63 -> 37
    //   103: aload_0
    //   104: monitorexit
    //   105: new 361	org/json/JSONArray
    //   108: dup
    //   109: invokespecial 362	org/json/JSONArray:<init>	()V
    //   112: astore_2
    //   113: aload_1
    //   114: ldc_w 386
    //   117: aload_2
    //   118: invokevirtual 299	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   121: pop
    //   122: aload_0
    //   123: monitorenter
    //   124: aload_0
    //   125: getfield 106	com/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter:mSubStreamUserIdList	Ljava/util/List;
    //   128: invokeinterface 370 1 0
    //   133: astore_3
    //   134: aload_3
    //   135: invokeinterface 375 1 0
    //   140: ifeq +60 -> 200
    //   143: aload_3
    //   144: invokeinterface 379 1 0
    //   149: checkcast 261	java/lang/String
    //   152: astore 4
    //   154: new 292	org/json/JSONObject
    //   157: dup
    //   158: invokespecial 293	org/json/JSONObject:<init>	()V
    //   161: astore 5
    //   163: aload 5
    //   165: ldc_w 295
    //   168: aload 4
    //   170: invokevirtual 299	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: aload 5
    //   176: ldc_w 301
    //   179: aload_0
    //   180: aload 4
    //   182: iconst_2
    //   183: invokespecial 381	com/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter:generateURL	(Ljava/lang/String;I)Ljava/lang/String;
    //   186: invokevirtual 299	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   189: pop
    //   190: aload_2
    //   191: aload 5
    //   193: invokevirtual 384	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   196: pop
    //   197: goto -63 -> 134
    //   200: aload_0
    //   201: monitorexit
    //   202: aload_0
    //   203: sipush 1020
    //   206: aload_1
    //   207: iconst_0
    //   208: invokespecial 390	com/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter:sendEventNotify	(ILorg/json/JSONObject;Z)V
    //   211: return
    //   212: astore_1
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_1
    //   216: athrow
    //   217: astore_1
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: ldc 13
    //   225: ldc_w 392
    //   228: aload_1
    //   229: invokestatic 395	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	V2TXLivePusherJSAdapter
    //   7	200	1	localJSONObject1	JSONObject
    //   212	4	1	localObject1	Object
    //   217	4	1	localObject2	Object
    //   222	7	1	localException	Exception
    //   15	176	2	localJSONArray	JSONArray
    //   36	108	3	localIterator	java.util.Iterator
    //   55	126	4	str	String
    //   64	128	5	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   124	134	212	finally
    //   134	197	212	finally
    //   200	202	212	finally
    //   213	215	212	finally
    //   27	37	217	finally
    //   37	100	217	finally
    //   103	105	217	finally
    //   218	220	217	finally
    //   0	27	222	java/lang/Exception
    //   105	124	222	java/lang/Exception
    //   202	211	222	java/lang/Exception
    //   215	217	222	java/lang/Exception
    //   220	222	222	java/lang/Exception
  }
  
  private void runOnLivePusherThread(Runnable paramRunnable)
  {
    Handler localHandler = this.mThreadHandler;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  private void sendEventNotify(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendEventNotify [eventId:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("][message:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    apiOnlineLog(((StringBuilder)localObject).toString(), false);
    localObject = this.mLivePushListener;
    if (localObject != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", paramString);
      ((ITXLivePushListener)localObject).onPushEvent(paramInt, localBundle);
    }
  }
  
  private void sendEventNotify(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInt);
    Object localObject2 = "";
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (paramInt != 1020) {
      switch (paramInt)
      {
      default: 
        break;
      case 1034: 
        localObject1 = "AudioStateUpdate";
        break;
      case 1033: 
        localObject1 = "VideoStateUpdate";
        break;
      case 1032: 
        localObject1 = "UserExit";
        break;
      case 1031: 
        localObject1 = "UserEnter";
        break;
      }
    } else {
      localObject1 = "UserList";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendEventNotify [eventName:");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("][params:");
    localObject1 = localObject2;
    if (paramJSONObject != null) {
      localObject1 = paramJSONObject.toString();
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("]");
    apiOnlineLog(localStringBuilder.toString(), false);
    if (paramJSONObject == null) {
      return;
    }
    if (paramBoolean) {}
    try
    {
      localObject1 = new JSONArray();
      ((JSONArray)localObject1).put(paramJSONObject);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("userlist", localObject1);
      paramJSONObject = paramJSONObject.toString();
      break label244;
      paramJSONObject = paramJSONObject.toString();
      label244:
      localObject1 = this.mLivePushListener;
      if (localObject1 != null)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("EVT_MSG", paramJSONObject);
        ((ITXLivePushListener)localObject1).onPushEvent(paramInt, (Bundle)localObject2);
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  private void setDiffParam(V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig1, V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig2)
  {
    Object localObject = paramV2TXLivePusherJSConfig2.diffConfig(paramV2TXLivePusherJSConfig1);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set diff config. diff:");
      localStringBuilder.append((String)localObject);
      apiOnlineLog(localStringBuilder.toString(), true);
    }
    if (paramV2TXLivePusherJSConfig1.enableDebugView != paramV2TXLivePusherJSConfig2.enableDebugView) {
      this.mPusher.showDebugView(paramV2TXLivePusherJSConfig2.enableDebugView);
    }
    if (paramV2TXLivePusherJSConfig1.isFrontCamera != paramV2TXLivePusherJSConfig2.isFrontCamera) {
      this.mPusher.getDeviceManager().switchCamera(paramV2TXLivePusherJSConfig2.isFrontCamera);
    }
    if (paramV2TXLivePusherJSConfig1.enableAutoFocus != paramV2TXLivePusherJSConfig2.enableAutoFocus) {
      this.mPusher.getDeviceManager().enableCameraAutoFocus(paramV2TXLivePusherJSConfig2.enableAutoFocus);
    }
    if (paramV2TXLivePusherJSConfig1.enableZoom != paramV2TXLivePusherJSConfig2.enableZoom) {
      this.mPusher.setProperty("enableCameraZoom", Boolean.valueOf(paramV2TXLivePusherJSConfig2.enableZoom));
    }
    if (paramV2TXLivePusherJSConfig1.enableRemoteMirror != paramV2TXLivePusherJSConfig2.enableRemoteMirror) {
      this.mPusher.setEncoderMirror(paramV2TXLivePusherJSConfig2.enableRemoteMirror);
    }
    if (paramV2TXLivePusherJSConfig1.mirrorType != paramV2TXLivePusherJSConfig2.mirrorType) {
      this.mPusher.setRenderMirror(paramV2TXLivePusherJSConfig2.mirrorType);
    }
    if ((paramV2TXLivePusherJSConfig1.isVerticalOrientation != paramV2TXLivePusherJSConfig2.isVerticalOrientation) && (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP)) {
      if (paramV2TXLivePusherJSConfig2.isVerticalOrientation) {
        this.mPusher.setRenderRotation(V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0);
      } else {
        this.mPusher.setRenderRotation(V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90);
      }
    }
    if ((paramV2TXLivePusherJSConfig1.isVerticalOrientation != paramV2TXLivePusherJSConfig2.isVerticalOrientation) || (paramV2TXLivePusherJSConfig1.aspect != paramV2TXLivePusherJSConfig2.aspect) || (paramV2TXLivePusherJSConfig1.width != paramV2TXLivePusherJSConfig2.width) || (paramV2TXLivePusherJSConfig1.height != paramV2TXLivePusherJSConfig2.height) || (paramV2TXLivePusherJSConfig1.mode != paramV2TXLivePusherJSConfig2.mode) || (paramV2TXLivePusherJSConfig1.minBitrate != paramV2TXLivePusherJSConfig2.minBitrate) || (paramV2TXLivePusherJSConfig1.maxBitrate != paramV2TXLivePusherJSConfig2.maxBitrate)) {
      setVideoEncParam(paramV2TXLivePusherJSConfig2);
    }
    if (paramV2TXLivePusherJSConfig1.enableCamera != paramV2TXLivePusherJSConfig2.enableCamera)
    {
      this.mPusher.setProperty("setPureAudioPushMode", Boolean.valueOf(paramV2TXLivePusherJSConfig2.enableCamera ^ true));
      if (paramV2TXLivePusherJSConfig2.enableCamera) {
        startCameraInner();
      } else {
        stopCameraInner();
      }
    }
    else if ((paramV2TXLivePusherJSConfig2.enableCamera) && (!this.mIsStartCamera))
    {
      startCameraInner();
    }
    if (paramV2TXLivePusherJSConfig1.isMuteAudio != paramV2TXLivePusherJSConfig2.isMuteAudio) {
      this.mPusher.setProperty("muteAudio", Boolean.valueOf(paramV2TXLivePusherJSConfig2.isMuteAudio));
    }
    if (paramV2TXLivePusherJSConfig1.enableAGC != paramV2TXLivePusherJSConfig2.enableAGC) {
      this.mPusher.setProperty("enableAudioAGC", Boolean.valueOf(paramV2TXLivePusherJSConfig2.enableAGC));
    }
    if (paramV2TXLivePusherJSConfig1.enableANS != paramV2TXLivePusherJSConfig2.enableANS) {
      this.mPusher.setProperty("enableAudioANS", Boolean.valueOf(paramV2TXLivePusherJSConfig2.enableANS));
    }
    if (paramV2TXLivePusherJSConfig1.enableEarMonitor != paramV2TXLivePusherJSConfig2.enableEarMonitor) {
      this.mPusher.getAudioEffectManager().enableVoiceEarMonitor(paramV2TXLivePusherJSConfig2.enableEarMonitor);
    }
    if (paramV2TXLivePusherJSConfig1.volumeNotifyIntervals != paramV2TXLivePusherJSConfig2.volumeNotifyIntervals) {
      this.mPusher.enableVolumeEvaluation(paramV2TXLivePusherJSConfig2.volumeNotifyIntervals);
    }
    if (paramV2TXLivePusherJSConfig1.volumeType != paramV2TXLivePusherJSConfig2.volumeType) {
      this.mPusher.getDeviceManager().setSystemVolumeType(paramV2TXLivePusherJSConfig2.volumeType);
    }
    if (paramV2TXLivePusherJSConfig1.reverbType != paramV2TXLivePusherJSConfig2.reverbType) {
      this.mPusher.getAudioEffectManager().setVoiceReverbType(paramV2TXLivePusherJSConfig2.reverbType);
    }
    if (paramV2TXLivePusherJSConfig1.audioQuality != paramV2TXLivePusherJSConfig2.audioQuality) {
      this.mPusher.setAudioQuality(paramV2TXLivePusherJSConfig1.audioQuality);
    }
    if (paramV2TXLivePusherJSConfig1.enableMicrophone != paramV2TXLivePusherJSConfig2.enableMicrophone)
    {
      if (paramV2TXLivePusherJSConfig2.enableMicrophone) {
        startMicrophoneInner();
      } else {
        stopMicrophoneInner();
      }
    }
    else if ((paramV2TXLivePusherJSConfig2.enableMicrophone) && (!this.mIsStartMicrophone)) {
      startMicrophoneInner();
    }
    if (paramV2TXLivePusherJSConfig1.beautyStyle != paramV2TXLivePusherJSConfig2.beautyStyle) {
      this.mPusher.getBeautyManager().setBeautyStyle(paramV2TXLivePusherJSConfig1.beautyStyle);
    }
    if (paramV2TXLivePusherJSConfig1.beautyLevel != paramV2TXLivePusherJSConfig2.beautyLevel) {
      this.mPusher.getBeautyManager().setBeautyLevel(paramV2TXLivePusherJSConfig2.beautyLevel);
    }
    if (paramV2TXLivePusherJSConfig1.whitenessLevel != paramV2TXLivePusherJSConfig2.whitenessLevel) {
      this.mPusher.getBeautyManager().setWhitenessLevel(paramV2TXLivePusherJSConfig2.whitenessLevel);
    }
    if ((paramV2TXLivePusherJSConfig2.filterImagePath != null) && (!paramV2TXLivePusherJSConfig2.filterImagePath.equals(paramV2TXLivePusherJSConfig1.filterImagePath))) {
      if (TextUtils.isEmpty(paramV2TXLivePusherJSConfig2.filterImagePath))
      {
        this.mPusher.getBeautyManager().setFilter(null);
      }
      else
      {
        localObject = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig2.filterImagePath);
        this.mPusher.getBeautyManager().setFilter((Bitmap)localObject);
      }
    }
    if (((paramV2TXLivePusherJSConfig2.watermarkImagePath != null) && (!paramV2TXLivePusherJSConfig2.watermarkImagePath.equals(paramV2TXLivePusherJSConfig1.watermarkImagePath))) || (paramV2TXLivePusherJSConfig1.watermarkWidth != paramV2TXLivePusherJSConfig2.watermarkWidth) || (paramV2TXLivePusherJSConfig1.watermarkLeft != paramV2TXLivePusherJSConfig2.watermarkLeft) || (paramV2TXLivePusherJSConfig1.watermarkTop != paramV2TXLivePusherJSConfig2.watermarkTop)) {
      if (TextUtils.isEmpty(paramV2TXLivePusherJSConfig2.watermarkImagePath))
      {
        this.mPusher.setWatermark(null, 0.0F, 0.0F, 0.0F);
      }
      else
      {
        localObject = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig2.watermarkImagePath);
        this.mPusher.setWatermark((Bitmap)localObject, paramV2TXLivePusherJSConfig2.watermarkLeft, paramV2TXLivePusherJSConfig2.watermarkTop, paramV2TXLivePusherJSConfig2.watermarkWidth);
      }
    }
    if ((paramV2TXLivePusherJSConfig2.backgroundImagePath != null) && (!paramV2TXLivePusherJSConfig2.backgroundImagePath.equals(paramV2TXLivePusherJSConfig1.backgroundImagePath))) {
      if (TextUtils.isEmpty(paramV2TXLivePusherJSConfig2.backgroundImagePath))
      {
        this.mPusher.setProperty("setPauseParam", null);
      }
      else
      {
        localObject = new a.c();
        ((a.c)localObject).a = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig2.backgroundImagePath);
        boolean bool;
        if (paramV2TXLivePusherJSConfig2.mode != 6) {
          bool = true;
        } else {
          bool = false;
        }
        ((a.c)localObject).d = bool;
        ((a.c)localObject).c = true;
        ((a.c)localObject).e = -1;
        this.mPusher.setProperty("setPauseParam", localObject);
      }
    }
    if ((paramV2TXLivePusherJSConfig1.isAutoPush != paramV2TXLivePusherJSConfig2.isAutoPush) && (paramV2TXLivePusherJSConfig2.isAutoPush) && (!TextUtils.isEmpty(paramV2TXLivePusherJSConfig2.url)) && (this.mPusher.isPushing() != 1))
    {
      apiOnlineLog("stat push when update auto push.", false);
      startPushInner(paramV2TXLivePusherJSConfig2.url);
    }
  }
  
  private void setFullParam(V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("set full config:");
    ((StringBuilder)localObject1).append(paramV2TXLivePusherJSConfig);
    apiOnlineLog(((StringBuilder)localObject1).toString(), true);
    this.mPusher.showDebugView(paramV2TXLivePusherJSConfig.enableDebugView);
    this.mPusher.getDeviceManager().enableCameraAutoFocus(paramV2TXLivePusherJSConfig.enableAutoFocus);
    this.mPusher.setProperty("enableCameraZoom", Boolean.valueOf(paramV2TXLivePusherJSConfig.enableZoom));
    this.mPusher.setEncoderMirror(paramV2TXLivePusherJSConfig.enableRemoteMirror);
    this.mPusher.setRenderMirror(paramV2TXLivePusherJSConfig.mirrorType);
    if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP) {
      if (paramV2TXLivePusherJSConfig.isVerticalOrientation) {
        this.mPusher.setRenderRotation(V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0);
      } else {
        this.mPusher.setRenderRotation(V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90);
      }
    }
    setVideoEncParam(paramV2TXLivePusherJSConfig);
    localObject1 = this.mVideoView;
    if (localObject1 != null) {
      this.mPusher.setRenderView((TXCloudVideoView)localObject1);
    }
    localObject1 = this.mSurface;
    if (localObject1 != null)
    {
      this.mPusher.setProperty("setSurface", localObject1);
      this.mPusher.setProperty("setSurfaceSize", new a.a(this.mSurfaceWidth, this.mSurfaceHeight));
    }
    this.mPusher.setProperty("setPureAudioPushMode", Boolean.valueOf(paramV2TXLivePusherJSConfig.enableCamera ^ true));
    if (paramV2TXLivePusherJSConfig.enableCamera) {
      startCameraInner();
    } else {
      stopCameraInner();
    }
    this.mPusher.setProperty("muteAudio", Boolean.valueOf(paramV2TXLivePusherJSConfig.isMuteAudio));
    this.mPusher.setProperty("enableAudioAGC", Boolean.valueOf(paramV2TXLivePusherJSConfig.enableAGC));
    this.mPusher.setProperty("enableAudioANS", Boolean.valueOf(paramV2TXLivePusherJSConfig.enableANS));
    this.mPusher.getAudioEffectManager().enableVoiceEarMonitor(paramV2TXLivePusherJSConfig.enableEarMonitor);
    this.mPusher.enableVolumeEvaluation(paramV2TXLivePusherJSConfig.volumeNotifyIntervals);
    this.mPusher.getDeviceManager().setSystemVolumeType(paramV2TXLivePusherJSConfig.volumeType);
    this.mPusher.getAudioEffectManager().setVoiceReverbType(paramV2TXLivePusherJSConfig.reverbType);
    this.mPusher.setAudioQuality(paramV2TXLivePusherJSConfig.audioQuality);
    if (paramV2TXLivePusherJSConfig.enableMicrophone) {
      startMicrophoneInner();
    } else {
      stopMicrophoneInner();
    }
    this.mPusher.getBeautyManager().setBeautyStyle(paramV2TXLivePusherJSConfig.beautyStyle);
    this.mPusher.getBeautyManager().setBeautyLevel(paramV2TXLivePusherJSConfig.beautyLevel);
    this.mPusher.getBeautyManager().setWhitenessLevel(paramV2TXLivePusherJSConfig.whitenessLevel);
    boolean bool = TextUtils.isEmpty(paramV2TXLivePusherJSConfig.filterImagePath);
    localObject1 = null;
    if (bool)
    {
      this.mPusher.getBeautyManager().setFilter(null);
    }
    else
    {
      localObject2 = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig.filterImagePath);
      this.mPusher.getBeautyManager().setFilter((Bitmap)localObject2);
    }
    if (TextUtils.isEmpty(paramV2TXLivePusherJSConfig.watermarkImagePath))
    {
      this.mPusher.setWatermark(null, 0.0F, 0.0F, 0.0F);
    }
    else
    {
      localObject2 = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig.watermarkImagePath);
      this.mPusher.setWatermark((Bitmap)localObject2, paramV2TXLivePusherJSConfig.watermarkLeft, paramV2TXLivePusherJSConfig.watermarkTop, paramV2TXLivePusherJSConfig.watermarkWidth);
    }
    Object localObject2 = new a.c();
    if (!TextUtils.isEmpty(paramV2TXLivePusherJSConfig.backgroundImagePath)) {
      localObject1 = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig.backgroundImagePath);
    }
    ((a.c)localObject2).a = ((Bitmap)localObject1);
    if (paramV2TXLivePusherJSConfig.mode != 6) {
      bool = true;
    } else {
      bool = false;
    }
    ((a.c)localObject2).d = bool;
    ((a.c)localObject2).c = true;
    ((a.c)localObject2).e = -1;
    this.mPusher.setProperty("setPauseParam", localObject2);
  }
  
  private void setVideoEncParam(V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig)
  {
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    int i1 = 0;
    int i3 = 0;
    int i4 = 0;
    int i2 = 0;
    if (localV2TXLivePusher == null)
    {
      apiOnlineError("set video encoder fail. pusher is null.", false);
      return;
    }
    int i5 = adjustHomeOrientation(this.mLastAngle, paramV2TXLivePusherJSConfig.isVerticalOrientation);
    int i;
    int j;
    if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      if ((i5 != 0) && (i5 != 2))
      {
        i = Math.min(paramV2TXLivePusherJSConfig.width, paramV2TXLivePusherJSConfig.height);
        j = Math.max(paramV2TXLivePusherJSConfig.width, paramV2TXLivePusherJSConfig.height);
      }
      else
      {
        i = Math.max(paramV2TXLivePusherJSConfig.width, paramV2TXLivePusherJSConfig.height);
        j = Math.min(paramV2TXLivePusherJSConfig.width, paramV2TXLivePusherJSConfig.height);
      }
      a.g localg = new a.g();
      localg.a = i;
      localg.b = j;
      localg.d = Math.max(paramV2TXLivePusherJSConfig.minBitrate, paramV2TXLivePusherJSConfig.maxBitrate);
      localg.c = 15;
      localV2TXLivePusher.setProperty("setCustomVideoEncParam", localg);
      return;
    }
    if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP)
    {
      i = paramV2TXLivePusherJSConfig.mode;
      int n = 1;
      localV2TXLivePusher.setProperty("setVideoQuality", new a.f(i, true, false));
      if ((paramV2TXLivePusherJSConfig.mode != 4) && (paramV2TXLivePusherJSConfig.mode != 5))
      {
        int m;
        if ((paramV2TXLivePusherJSConfig.minBitrate > 0) && (paramV2TXLivePusherJSConfig.maxBitrate > 0)) {
          m = 1;
        } else {
          m = 0;
        }
        j = Math.min(paramV2TXLivePusherJSConfig.minBitrate, paramV2TXLivePusherJSConfig.maxBitrate);
        int k = Math.max(paramV2TXLivePusherJSConfig.minBitrate, paramV2TXLivePusherJSConfig.maxBitrate);
        if (j != k) {
          i = 0;
        } else {
          i = -1;
        }
        int i6 = paramV2TXLivePusherJSConfig.mode;
        if (i6 != 1) {
          if (i6 != 2) {
            if (i6 != 3) {
              if (i6 != 6) {
                if (i6 == 7) {}
              }
            }
          }
        }
        for (;;)
        {
          i1 = i;
          m = 0;
          n = 5;
          i = j;
          j = k;
          k = i1;
          break;
          if (m == 0)
          {
            j = 3000;
            k = 3500;
            i = i2;
          }
          n = i;
          i = j;
          j = k;
          m = 30;
          k = n;
          break label519;
          if (m == 0)
          {
            j = 190;
            k = 810;
          }
          if (paramV2TXLivePusherJSConfig.aspect == 1)
          {
            i = 13;
          }
          else
          {
            i = paramV2TXLivePusherJSConfig.aspect;
            i = i1;
          }
          m = i;
          i = j;
          j = k;
          n = 1;
          k = 5;
          break;
          if (m == 0)
          {
            j = 1000;
            k = 1800;
            i = i3;
          }
          n = i;
          i = j;
          j = k;
          m = 2;
          k = n;
          break label519;
          if (m == 0)
          {
            j = 800;
            k = 1500;
            i = i4;
          }
          m = i;
          i = j;
          j = k;
          k = m;
          m = n;
          label519:
          n = 5;
          break;
          if (m == 0)
          {
            j = 500;
            k = 900;
            i = 0;
          }
        }
        localV2TXLivePusher.setProperty("setCustomVideoEncParam", new a.e(m, 15, n, i, j, i5, k));
        return;
      }
      apiOnlineLog("ignore set main publisher or sub publisher gop and bitrate", false);
    }
  }
  
  private void startCameraInner()
  {
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher == null)
    {
      apiOnlineError("start camera fail. pusher is null.", false);
      return;
    }
    if (this.mIsStartCamera)
    {
      apiOnlineLog("already start camera.", false);
      return;
    }
    this.mIsStartCamera = true;
    localV2TXLivePusher.startCamera(this.mConfig.isFrontCamera);
  }
  
  private void startMicrophoneInner()
  {
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher == null)
    {
      apiOnlineError("start microphone fail. pusher is null.", false);
      return;
    }
    if (this.mIsStartMicrophone)
    {
      apiOnlineLog("already start microphone.", false);
      return;
    }
    this.mIsStartMicrophone = true;
    localV2TXLivePusher.startMicrophone();
    TXCAudioEngine.setAudioRoute(V2TXLivePlayerJSConfig.sAudioRoute);
  }
  
  private void startPushInner(String paramString)
  {
    if (this.mPusher == null)
    {
      apiOnlineError("start push fail. pusher is null.", false);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      apiOnlineError("start push inner fail.url is empty.", false);
      return;
    }
    apiOnlineLog("startPushInner", false);
    if ((this.mConfig.enableMicrophone) && (!this.mIsStartMicrophone)) {
      startMicrophoneInner();
    }
    if ((this.mConfig.enableCamera) && (!this.mIsStartCamera)) {
      startCameraInner();
    }
    this.mPusher.setProperty("setFrameWorkType", Integer.valueOf(3));
    this.mPusher.startPush(paramString);
  }
  
  private void stopCameraInner()
  {
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher == null)
    {
      apiOnlineError("stop camera fail. pusher is null.", false);
      return;
    }
    if (!this.mIsStartCamera)
    {
      apiOnlineLog("already stop camera.", false);
      return;
    }
    this.mIsStartCamera = false;
    localV2TXLivePusher.stopCamera();
  }
  
  private void stopMicrophoneInner()
  {
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher == null)
    {
      apiOnlineError("stop microphone fail. pusher is null.", false);
      return;
    }
    if (!this.mIsStartMicrophone)
    {
      apiOnlineLog("already stop microphone.", false);
      return;
    }
    this.mIsStartMicrophone = false;
    localV2TXLivePusher.stopMicrophone();
  }
  
  private void stopPushInner()
  {
    apiOnlineLog("stopPushInner", false);
    this.mIsBGMPlaying = false;
    this.mIsBGMPlayingWhenPausePusher = false;
    this.mIsOpenFlashLight = false;
    this.mIsStartMicrophone = false;
    this.mIsStartCamera = false;
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher != null)
    {
      localV2TXLivePusher.getAudioEffectManager().stopPlayMusic(1234567);
      this.mPusher.getAudioEffectManager().setMusicObserver(1234567, null);
      this.mPusher.stopPush();
    }
  }
  
  public int getMaxZoom()
  {
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher == null) {
      return 0;
    }
    return (int)localV2TXLivePusher.getDeviceManager().getCameraZoomMaxRatio();
  }
  
  public V2TXJSAdapterError initLivePusher(Bundle paramBundle)
  {
    callbackSDKVersion();
    return initLivePusherInner(null, paramBundle);
  }
  
  public V2TXJSAdapterError initLivePusher(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    if (paramTXCloudVideoView == null) {
      return new V2TXJSAdapterError(-1, "invalid params");
    }
    return initLivePusherInner(paramTXCloudVideoView, paramBundle);
  }
  
  public boolean isPushing()
  {
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    boolean bool = false;
    if (localV2TXLivePusher == null) {
      return false;
    }
    if (localV2TXLivePusher.isPushing() == 1) {
      bool = true;
    }
    return bool;
  }
  
  public void notifyOrientationChanged(int paramInt)
  {
    this.mMainThreadHandler.post(new V2TXLivePusherJSAdapter.1(this, paramInt));
  }
  
  public void onCaptureFirstAudioFrame()
  {
    if (!isRTCProtocolType())
    {
      apiOnlineLog("onCaptureFirstAudioFrame: isn't rtc protocol,ignore", false);
      return;
    }
    ITXLivePushListener localITXLivePushListener = this.mLivePushListener;
    if (localITXLivePushListener == null) {
      return;
    }
    localITXLivePushListener.onPushEvent(2027, new Bundle());
  }
  
  public void onCaptureFirstVideoFrame()
  {
    if (!isRTCProtocolType())
    {
      apiOnlineLog("onCaptureFirstVideoFrame: isn't rtc protocol,ignore", false);
      return;
    }
    ITXLivePushListener localITXLivePushListener = this.mLivePushListener;
    if (localITXLivePushListener == null) {
      return;
    }
    localITXLivePushListener.onPushEvent(1003, new Bundle());
    localITXLivePushListener.onPushEvent(1007, new Bundle());
    localITXLivePushListener.onPushEvent(1008, new Bundle());
  }
  
  public void onComplete(int paramInt1, int paramInt2)
  {
    Object localObject = this.mConfig;
    if ((1234567 == paramInt1) && (((V2TXLivePusherJSConfig)localObject).enableBGMEventCallback))
    {
      localObject = this.mBGMNotifyListener;
      if (localObject != null) {
        ((TXLivePusher.OnBGMNotify)localObject).onBGMComplete(paramInt2);
      }
    }
  }
  
  public void onEnterRoom(long paramLong)
  {
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onEnterRoom: isn't room protocol,ignore", false);
      return;
    }
    this.mMainStreamUserIdList.clear();
    this.mSubStreamUserIdList.clear();
    if (paramLong > 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoom success, time cost[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      sendEventNotify(1018, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom failed, error code[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    sendEventNotify(1022, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom failed, error code[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    sendEventNotify(-3301, localStringBuilder.toString());
    if (paramLong == -100018L) {
      sendEventNotify(-100018, "onEnterRoom failed, user sign invalid.");
    }
  }
  
  public void onExitRoom(int paramInt)
  {
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onExitRoom: isn't room protocol,ignore", false);
      return;
    }
    this.mMainStreamUserIdList.clear();
    this.mSubStreamUserIdList.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    sendEventNotify(1019, localStringBuilder.toString());
  }
  
  public void onGLContextCreated()
  {
    super.onGLContextCreated();
  }
  
  public void onGLContextDestroyed()
  {
    TXLivePusher.VideoCustomProcessListener localVideoCustomProcessListener = this.mVideoCustomProcessListener;
    if (localVideoCustomProcessListener != null) {
      localVideoCustomProcessListener.onTextureDestoryed();
    }
  }
  
  public void onMicrophoneVolumeUpdate(int paramInt)
  {
    TXLivePusher.ITXAudioVolumeEvaluationListener localITXAudioVolumeEvaluationListener = this.mAudioVolumeListener;
    if (localITXAudioVolumeEvaluationListener != null) {
      localITXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(paramInt);
    }
  }
  
  public void onNetworkQuality(int paramInt)
  {
    this.mTRTCNetworkQuality = paramInt;
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = this.mConfig;
    if ((1234567 == paramInt) && (((V2TXLivePusherJSConfig)localObject).enableBGMEventCallback))
    {
      localObject = this.mBGMNotifyListener;
      if (localObject != null) {
        ((TXLivePusher.OnBGMNotify)localObject).onBGMProgress(paramLong1, paramLong2);
      }
    }
  }
  
  public int onProcessVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame1, V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame2)
  {
    TXLivePusher.VideoCustomProcessListener localVideoCustomProcessListener = this.mVideoCustomProcessListener;
    if (localVideoCustomProcessListener != null)
    {
      int i = localVideoCustomProcessListener.onTextureCustomProcess(paramV2TXLiveVideoFrame1.texture.textureId, paramV2TXLiveVideoFrame1.width, paramV2TXLiveVideoFrame1.height);
      paramV2TXLiveVideoFrame2.texture.textureId = i;
    }
    return 0;
  }
  
  public void onPushEvent(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == -1307) || (paramInt == -1313))
    {
      apiOnlineError("recv disconnect or invalid address event, stop push.", false);
      runOnLivePusherThread(new V2TXLivePusherJSAdapter.2(this));
    }
    ITXLivePushListener localITXLivePushListener = this.mLivePushListener;
    if (localITXLivePushListener != null) {
      localITXLivePushListener.onPushEvent(paramInt, paramBundle);
    }
  }
  
  public void onPushNetStatus(Bundle paramBundle)
  {
    ITXLivePushListener localITXLivePushListener = this.mLivePushListener;
    if (localITXLivePushListener != null) {
      localITXLivePushListener.onNetStatus(paramBundle);
    }
  }
  
  public void onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus paramV2TXLivePushStatus, String paramString, Bundle paramBundle)
  {
    paramString = new StringBuilder();
    paramString.append("onPushStatusUpdate: [status:");
    paramString.append(paramV2TXLivePushStatus);
    paramString.append("]");
    apiOnlineLog(paramString.toString(), false);
    if (!isRTCProtocolType())
    {
      apiOnlineLog("onPushStatusUpdate: isn't rtc protocol,ignore", false);
      return;
    }
    paramString = this.mLivePushListener;
    if (paramString == null) {
      return;
    }
    int i = V2TXLivePusherJSAdapter.3.$SwitchMap$com$tencent$live2$V2TXLiveDef$V2TXLivePushStatus[paramV2TXLivePushStatus.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramString.onPushEvent(1001, paramBundle);
        paramString.onPushEvent(1002, paramBundle);
        return;
      }
      paramString.onPushEvent(1102, paramBundle);
      return;
    }
    paramString.onPushEvent(-1307, paramBundle);
  }
  
  public void onRemoteUserEnter(String paramString)
  {
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onRemoteUserEnter: isn't room protocol,ignore", false);
      return;
    }
    sendEventNotify(1031, getUserJSONObject(paramString), true);
  }
  
  public void onRemoteUserExit(String paramString, int paramInt)
  {
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onRemoteUserExit: isn't room protocol,ignore", false);
      return;
    }
    sendEventNotify(1032, getUserJSONObject(paramString), true);
  }
  
  public void onSnapshotComplete(Bitmap paramBitmap)
  {
    TXLivePusher.ITXSnapshotListener localITXSnapshotListener = this.mSnapshotListener;
    if (localITXSnapshotListener == null) {
      return;
    }
    if (paramBitmap != null)
    {
      if (this.mNeedCompressSnapshot)
      {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(0.5F, 0.5F);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, false);
        localITXSnapshotListener.onSnapshot(paramBitmap);
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          paramBitmap.recycle();
        }
      }
      else
      {
        localITXSnapshotListener.onSnapshot(paramBitmap);
      }
    }
    else {
      localITXSnapshotListener.onSnapshot(paramBitmap);
    }
  }
  
  public void onStart(int paramInt1, int paramInt2)
  {
    Object localObject = this.mConfig;
    if ((1234567 == paramInt1) && (((V2TXLivePusherJSConfig)localObject).enableBGMEventCallback))
    {
      localObject = this.mBGMNotifyListener;
      if (localObject != null) {
        ((TXLivePusher.OnBGMNotify)localObject).onBGMStart();
      }
    }
  }
  
  public void onStatisticsUpdate(V2TXLiveDef.V2TXLivePusherStatistics paramV2TXLivePusherStatistics)
  {
    Object localObject = String.format("%d%%|%d%%", new Object[] { Integer.valueOf(paramV2TXLivePusherStatistics.appCpu), Integer.valueOf(paramV2TXLivePusherStatistics.systemCpu) });
    String str = TXCStatus.b("18446744073709551615", 10001);
    int i = paramV2TXLivePusherStatistics.width;
    int j = paramV2TXLivePusherStatistics.height;
    int k = paramV2TXLivePusherStatistics.fps;
    int m = paramV2TXLivePusherStatistics.videoBitrate;
    int n = paramV2TXLivePusherStatistics.audioBitrate;
    paramV2TXLivePusherStatistics = new Bundle();
    paramV2TXLivePusherStatistics.putString("CPU_USAGE", (String)localObject);
    paramV2TXLivePusherStatistics.putInt("VIDEO_WIDTH", i);
    paramV2TXLivePusherStatistics.putInt("VIDEO_HEIGHT", j);
    paramV2TXLivePusherStatistics.putInt("VIDEO_FPS", k);
    paramV2TXLivePusherStatistics.putInt("NET_SPEED", n + m);
    paramV2TXLivePusherStatistics.putInt("VIDEO_BITRATE", m);
    paramV2TXLivePusherStatistics.putInt("AUDIO_BITRATE", n);
    paramV2TXLivePusherStatistics.putString("SERVER_IP", str);
    paramV2TXLivePusherStatistics.putInt("NET_QUALITY_LEVEL", this.mTRTCNetworkQuality);
    paramV2TXLivePusherStatistics.putInt("VIDEO_GOP", 1);
    paramV2TXLivePusherStatistics.putString("AUDIO_PLAY_INFO", "");
    localObject = this.mLivePushListener;
    if (localObject != null) {
      ((ITXLivePushListener)localObject).onNetStatus(paramV2TXLivePusherStatistics);
    }
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onUserAudioAvailable: isn't room protocol,ignore", false);
      return;
    }
    sendEventNotify(1034, getAudioAvailableJSONObject(paramString, generateURL(paramString, 0), paramBoolean), true);
  }
  
  public void onUserVideoAvailable(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onUserVideoAvailable: isn't room protocol,ignore", false);
      return;
    }
    sendEventNotify(1033, getVideoAvailableJSONObject(paramString, generateURL(paramString, paramInt), paramInt, paramBoolean), true);
    List localList;
    if (paramInt == 2) {
      localList = this.mSubStreamUserIdList;
    } else {
      localList = this.mMainStreamUserIdList;
    }
    if (paramBoolean) {
      localList.add(paramString);
    } else {
      localList.remove(paramString);
    }
    notifyFullUserList();
  }
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!isRTCProtocolType())
    {
      apiOnlineLog("onWarning: isn't rtc protocol,ignore", false);
      return;
    }
    paramString = this.mLivePushListener;
    if (paramString == null) {
      return;
    }
    int j = -1301;
    if (paramInt != -1319) {
      if (paramInt != -1314)
      {
        if (paramInt != -1317)
        {
          i = j;
          if (paramInt == -1316) {
            break label108;
          }
          if (paramInt != -1302)
          {
            i = j;
            if (paramInt == -1301) {
              break label108;
            }
            i = -1;
            break label108;
          }
        }
        else
        {
          i = -1317;
          break label108;
        }
      }
      else
      {
        i = -1314;
        break label108;
      }
    }
    int i = -1302;
    label108:
    if (i != -1) {
      paramString.onPushEvent(i, paramBundle);
    }
  }
  
  public V2TXJSAdapterError operateLivePusher(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new V2TXJSAdapterError(-1, "invalid params");
    }
    boolean bool1 = this.mIsInit;
    boolean bool2 = false;
    int i = 0;
    if ((bool1) && (this.mPusher != null))
    {
      Object localObject;
      if (paramString.equalsIgnoreCase("start"))
      {
        if ((this.mPusher.isPushing() != 1) && (!TextUtils.isEmpty(this.mConfig.url)))
        {
          startPushInner(this.mConfig.url);
          paramString = new StringBuilder();
          paramString.append("start push. url:");
          paramString.append(TextUtils.isEmpty(this.mConfig.url) ^ true);
          apiOnlineLog(paramString.toString(), true);
        }
        else
        {
          return new V2TXJSAdapterError(-2, "fail");
        }
      }
      else if (paramString.equalsIgnoreCase("stop"))
      {
        stopPushInner();
        apiOnlineLog("stop push.", true);
      }
      else
      {
        bool1 = paramString.equalsIgnoreCase("pause");
        localObject = null;
        if (bool1)
        {
          this.mPusher.setProperty("pausePusher", Boolean.valueOf(true));
          this.mIsBGMPlayingWhenPausePusher = this.mIsBGMPlaying;
          if (this.mIsBGMPlayingWhenPausePusher) {
            operateLivePusher("pauseBGM", null);
          }
          apiOnlineLog("pause push.", true);
        }
        else if (paramString.equalsIgnoreCase("resume"))
        {
          this.mPusher.setProperty("pausePusher", Boolean.valueOf(false));
          if (this.mIsBGMPlayingWhenPausePusher) {
            operateLivePusher("resumeBGM", null);
          }
          apiOnlineLog("resume push.", true);
        }
        else if (paramString.equalsIgnoreCase("startPreview"))
        {
          if (this.mPusher.isPushing() == 1)
          {
            apiOnlineLog("do not support startPreview when pushing", false);
            return new V2TXJSAdapterError(-2, "fail");
          }
          startCameraInner();
          apiOnlineLog("start camera.", true);
        }
        else if (paramString.equalsIgnoreCase("stopPreview"))
        {
          if (this.mPusher.isPushing() == 1)
          {
            apiOnlineLog("do not support stopPreview when pushing", false);
            return new V2TXJSAdapterError(-2, "fail");
          }
          stopCameraInner();
          apiOnlineLog("stop camera.", true);
        }
        else if (paramString.equalsIgnoreCase("switchCamera"))
        {
          paramString = this.mConfig;
          paramString.isFrontCamera ^= true;
          this.mPusher.getDeviceManager().switchCamera(this.mConfig.isFrontCamera);
        }
        else if (paramString.equalsIgnoreCase("snapshot"))
        {
          this.mNeedCompressSnapshot = false;
          if (paramJSONObject != null)
          {
            paramString = paramJSONObject.optString("quality");
            if ((paramString != null) && (paramString.equalsIgnoreCase("compressed"))) {
              this.mNeedCompressSnapshot = true;
            }
          }
          this.mPusher.snapshot();
        }
        else
        {
          if (paramString.equalsIgnoreCase("toggleTorch"))
          {
            bool1 = this.mIsOpenFlashLight ^ true;
            bool2 = this.mPusher.getDeviceManager().enableCameraTorch(bool1);
            if (!bool2) {
              bool1 = this.mIsOpenFlashLight;
            }
            this.mIsOpenFlashLight = bool1;
            if (!bool2) {
              i = -2;
            }
            if (bool2) {
              paramString = "Success";
            } else {
              paramString = "Failed";
            }
            return new V2TXJSAdapterError(i, paramString);
          }
          if (paramString.equalsIgnoreCase("playBGM"))
          {
            if (paramJSONObject != null) {
              paramString = paramJSONObject.optString("BGMFilePath", "");
            } else {
              paramString = "";
            }
            if (TextUtils.isEmpty(paramString)) {
              return new V2TXJSAdapterError(-2, "fail");
            }
            this.mIsBGMPlaying = true;
            paramString = new TXAudioEffectManager.AudioMusicParam(1234567, paramString);
            paramString.publish = true;
            this.mPusher.getAudioEffectManager().setMusicObserver(1234567, this);
            this.mPusher.getAudioEffectManager().startPlayMusic(paramString);
          }
          else if (paramString.equalsIgnoreCase("stopBGM"))
          {
            this.mIsBGMPlaying = false;
            this.mPusher.getAudioEffectManager().setMusicObserver(1234567, null);
            this.mPusher.getAudioEffectManager().stopPlayMusic(1234567);
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.mIsBGMPlaying = false;
            this.mPusher.getAudioEffectManager().pausePlayMusic(1234567);
          }
          else if (paramString.equalsIgnoreCase("resumeBGM"))
          {
            this.mIsBGMPlaying = true;
            this.mPusher.getAudioEffectManager().resumePlayMusic(1234567);
          }
          else
          {
            bool1 = paramString.equalsIgnoreCase("setBGMVolume");
            double d = 1.0D;
            if (bool1)
            {
              if (paramJSONObject != null) {
                d = paramJSONObject.optDouble("volume", 1.0D);
              }
              paramString = this.mPusher.getAudioEffectManager();
              i = (int)(d * 100.0D);
              paramString.setMusicPlayoutVolume(1234567, i);
              this.mPusher.getAudioEffectManager().setMusicPublishVolume(1234567, i);
            }
            else
            {
              if (!paramString.equalsIgnoreCase("setMICVolume")) {
                break label945;
              }
              if (paramJSONObject != null) {
                d = paramJSONObject.optDouble("volume", 1.0D);
              }
              this.mPusher.getAudioEffectManager().setVoiceCaptureVolume((int)(d * 100.0D));
            }
          }
        }
      }
      return new V2TXJSAdapterError();
      label945:
      if (paramString.equalsIgnoreCase("sendMessage"))
      {
        paramString = localObject;
        if (paramJSONObject != null) {
          paramString = paramJSONObject.optString("msg");
        }
        if (TextUtils.isEmpty(paramString)) {
          return new V2TXJSAdapterError(-2, "fail");
        }
        this.mPusher.setProperty("sendSEIMessage", paramString.getBytes());
        return new V2TXJSAdapterError(0, "Success");
      }
      return new V2TXJSAdapterError(-4, "invalid operate command");
    }
    if ((!paramString.equals("start")) && (!paramString.equals("stop")) && (!paramString.equals("resume")) && (!paramString.equals("pause")) && (!paramString.equals("startPreview")) && (!paramString.equals("stopPreview"))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("operate live pusher fail. init pusher first.[operateName:");
    paramJSONObject.append(paramString);
    paramJSONObject.append("][isInit:");
    paramJSONObject.append(this.mIsInit);
    paramJSONObject.append("][hasPusher:");
    if (this.mPusher != null) {
      bool2 = true;
    }
    paramJSONObject.append(bool2);
    paramJSONObject.append("]");
    apiOnlineError(paramJSONObject.toString(), bool1);
    return new V2TXJSAdapterError(-3, "uninited livePusher");
  }
  
  public void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.mBGMNotifyListener = paramOnBGMNotify;
  }
  
  public V2TXJSAdapterError setFocusPosition(float paramFloat1, float paramFloat2)
  {
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher == null) {
      return new V2TXJSAdapterError(-3, "uninited livePusher");
    }
    localV2TXLivePusher.getDeviceManager().setCameraFocusPosition((int)paramFloat1, (int)paramFloat2);
    return new V2TXJSAdapterError();
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.mLivePushListener = paramITXLivePushListener;
  }
  
  public void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.mSnapshotListener = paramITXSnapshotListener;
  }
  
  public V2TXJSAdapterError setSurface(Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set surface:");
    if (paramSurface != null) {
      localObject = Integer.valueOf(paramSurface.hashCode());
    } else {
      localObject = "0";
    }
    localStringBuilder.append(localObject);
    apiOnlineLog(localStringBuilder.toString(), false);
    this.mSurface = paramSurface;
    Object localObject = this.mPusher;
    if (localObject != null) {
      ((V2TXLivePusher)localObject).setProperty("setSurface", paramSurface);
    }
    return new V2TXJSAdapterError();
  }
  
  public V2TXJSAdapterError setSurfaceSize(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("set surface size: [width:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("][height:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("]");
    apiOnlineLog(((StringBuilder)localObject).toString(), false);
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    localObject = this.mPusher;
    if (localObject != null) {
      ((V2TXLivePusher)localObject).setProperty("setSurfaceSize", new a.a(paramInt1, paramInt2));
    }
    return new V2TXJSAdapterError();
  }
  
  public void setThreadHandler(Handler paramHandler)
  {
    this.mThreadHandler = paramHandler;
  }
  
  public void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
  {
    this.mVideoCustomProcessListener = paramVideoCustomProcessListener;
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher != null)
    {
      boolean bool;
      if (paramVideoCustomProcessListener != null) {
        bool = true;
      } else {
        bool = false;
      }
      localV2TXLivePusher.enableCustomVideoProcess(bool, V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D, V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture);
    }
  }
  
  public V2TXJSAdapterError setZoom(int paramInt)
  {
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher == null) {
      return new V2TXJSAdapterError(-3, "uninited livePusher");
    }
    localV2TXLivePusher.getDeviceManager().setCameraZoomRatio(paramInt);
    return new V2TXJSAdapterError();
  }
  
  public void takePhoto(boolean paramBoolean, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher != null)
    {
      this.mNeedCompressSnapshot = paramBoolean;
      this.mSnapshotListener = paramITXSnapshotListener;
      localV2TXLivePusher.snapshot();
    }
  }
  
  public V2TXJSAdapterError unInitLivePusher()
  {
    if (!this.mIsInit) {
      return new V2TXJSAdapterError(-3, "uninited livePusher");
    }
    apiOnlineLog("un init pusher.", true);
    stopPushInner();
    this.mIsInit = false;
    return new V2TXJSAdapterError();
  }
  
  public V2TXJSAdapterError updateLivePusher(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new V2TXJSAdapterError(-1, "invalid params");
    }
    if (!this.mIsInit) {
      return new V2TXJSAdapterError(-3, "uninited livePusher");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("update pusher params:");
    ((StringBuilder)localObject).append(paramBundle.toString());
    apiOnlineLog(((StringBuilder)localObject).toString(), false);
    localObject = new V2TXLivePusherJSConfig(this.mConfig);
    ((V2TXLivePusherJSConfig)localObject).updateFromBundle(paramBundle);
    if ((!TextUtils.isEmpty(((V2TXLivePusherJSConfig)localObject).url)) && (!((V2TXLivePusherJSConfig)localObject).url.equals(this.mConfig.url)))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("update url to:");
      paramBundle.append(((V2TXLivePusherJSConfig)localObject).url);
      apiOnlineLog(paramBundle.toString(), false);
      paramBundle = this.mPusher;
      if ((paramBundle != null) && (paramBundle.isPushing() == 1))
      {
        apiOnlineLog("stop push when update url.", false);
        this.mPusher.stopPush();
      }
      createPusherInstance(((V2TXLivePusherJSConfig)localObject).url);
      setFullParam((V2TXLivePusherJSConfig)localObject);
      this.mConfig = ((V2TXLivePusherJSConfig)localObject);
      if (((V2TXLivePusherJSConfig)localObject).isAutoPush)
      {
        apiOnlineLog("auto push", true);
        startPushInner(((V2TXLivePusherJSConfig)localObject).url);
      }
    }
    else
    {
      if (this.mPusher != null) {
        setDiffParam(this.mConfig, (V2TXLivePusherJSConfig)localObject);
      } else {
        apiOnlineError("pusher no init yet.ignore set diff param", false);
      }
      this.mConfig = ((V2TXLivePusherJSConfig)localObject);
    }
    return new V2TXJSAdapterError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter
 * JD-Core Version:    0.7.0.1
 */