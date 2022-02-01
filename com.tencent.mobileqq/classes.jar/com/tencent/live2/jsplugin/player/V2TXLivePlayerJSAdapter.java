package com.tencent.live2.jsplugin.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.h;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayerStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.impl.V2TXLivePlayerImpl;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.b;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class V2TXLivePlayerJSAdapter
  extends a
{
  private static final String TAG = "V2TXLivePlayerJSAdapter";
  private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private V2TXLivePlayerJSConfig mConfig;
  private boolean mIsInit;
  private boolean mNeedCompressSnapshot;
  private ITXLivePlayListener mPlayListener;
  private V2TXLiveDef.V2TXLiveMode mPlayMode;
  private V2TXLivePlayer mPlayer;
  private TXLivePlayer.ITXSnapshotListener mSnapshotListener;
  private int mTRTCNetworkQuality;
  private Handler mThreadHandler;
  
  static
  {
    h.f();
  }
  
  public V2TXLivePlayerJSAdapter(Context paramContext)
  {
    this.mPlayer = new V2TXLivePlayerImpl(paramContext);
    this.mPlayer.setObserver(this);
    this.mTRTCNetworkQuality = 2;
    this.mThreadHandler = new Handler(Looper.getMainLooper());
    this.mConfig = new V2TXLivePlayerJSConfig();
  }
  
  private void apiOnlineError(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("V2TXLivePlayerJSAdapter(");
      paramString.append(hashCode());
      paramString.append(")");
      Monitor.a(1, paramString.toString(), str, 0);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("V2TXLivePlayerJSAdapter(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.e("V2TXLivePlayerJSAdapter", paramString.toString());
  }
  
  private void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("V2TXLivePlayerJSAdapter(");
      paramString.append(hashCode());
      paramString.append(")");
      Monitor.a(1, paramString.toString(), str, 0);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("V2TXLivePlayerJSAdapter(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.i("V2TXLivePlayerJSAdapter", paramString.toString());
  }
  
  private void callbackSDKVersion()
  {
    ITXLivePlayListener localITXLivePlayListener = this.mPlayListener;
    if (localITXLivePlayListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      localITXLivePlayListener.onPlayEvent(-9999999, localBundle);
    }
  }
  
  private V2TXJSAdapterError initLivePlayerInner(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      apiOnlineError("init player inner fail. invalid bundle params.", false);
      return new V2TXJSAdapterError(-1, "invalid params");
    }
    if (this.mIsInit)
    {
      apiOnlineError("invalid operation. already init.", false);
      return new V2TXJSAdapterError(-1, "invalid operation. already init.");
    }
    if (paramTXCloudVideoView != null) {
      this.mPlayer.setRenderView(paramTXCloudVideoView);
    }
    apiOnlineLog("init player.", false);
    this.mIsInit = true;
    this.mConfig.updateFromBundle(paramBundle);
    setFullParams(this.mConfig);
    return new V2TXJSAdapterError();
  }
  
  private boolean isRTCProtocol()
  {
    return this.mPlayMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
  }
  
  private void runOnLivePlayerThread(Runnable paramRunnable)
  {
    Handler localHandler = this.mThreadHandler;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  private void setDiffParams(V2TXLivePlayerJSConfig paramV2TXLivePlayerJSConfig1, V2TXLivePlayerJSConfig paramV2TXLivePlayerJSConfig2)
  {
    String str = paramV2TXLivePlayerJSConfig2.diffConfig(paramV2TXLivePlayerJSConfig1);
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set diff config:");
      localStringBuilder.append(str);
      apiOnlineLog(localStringBuilder.toString(), true);
    }
    if (paramV2TXLivePlayerJSConfig1.isMuteVideo != paramV2TXLivePlayerJSConfig2.isMuteVideo) {
      if (paramV2TXLivePlayerJSConfig2.isMuteVideo) {
        this.mPlayer.pauseVideo();
      } else {
        this.mPlayer.resumeVideo();
      }
    }
    if (paramV2TXLivePlayerJSConfig1.isMuteAudio != paramV2TXLivePlayerJSConfig2.isMuteAudio) {
      if (paramV2TXLivePlayerJSConfig2.isMuteAudio) {
        this.mPlayer.pauseAudio();
      } else {
        this.mPlayer.resumeAudio();
      }
    }
    if (paramV2TXLivePlayerJSConfig1.enableRecvSEIMessage != paramV2TXLivePlayerJSConfig2.enableRecvSEIMessage) {
      this.mPlayer.setProperty("enableRecvSEIMessage", Boolean.valueOf(paramV2TXLivePlayerJSConfig2.enableRecvSEIMessage));
    }
    if (paramV2TXLivePlayerJSConfig1.enableDebugView != paramV2TXLivePlayerJSConfig2.enableDebugView) {
      this.mPlayer.showDebugView(paramV2TXLivePlayerJSConfig2.enableDebugView);
    }
    if ((paramV2TXLivePlayerJSConfig1.minCache != paramV2TXLivePlayerJSConfig2.minCache) || (paramV2TXLivePlayerJSConfig1.maxCache != paramV2TXLivePlayerJSConfig2.maxCache)) {
      this.mPlayer.setCacheParams(Math.min(paramV2TXLivePlayerJSConfig2.minCache, paramV2TXLivePlayerJSConfig2.maxCache), Math.max(paramV2TXLivePlayerJSConfig2.minCache, paramV2TXLivePlayerJSConfig2.maxCache));
    }
    if (paramV2TXLivePlayerJSConfig1.volumeNotifyIntervals != paramV2TXLivePlayerJSConfig2.volumeNotifyIntervals) {
      this.mPlayer.enableVolumeEvaluation(paramV2TXLivePlayerJSConfig2.volumeNotifyIntervals);
    }
    if (paramV2TXLivePlayerJSConfig1.fillMode != paramV2TXLivePlayerJSConfig2.fillMode) {
      this.mPlayer.setRenderFillMode(paramV2TXLivePlayerJSConfig2.fillMode);
    }
    if (paramV2TXLivePlayerJSConfig1.renderRotation != paramV2TXLivePlayerJSConfig2.renderRotation) {
      this.mPlayer.setRenderRotation(paramV2TXLivePlayerJSConfig2.renderRotation);
    }
    if (paramV2TXLivePlayerJSConfig1.audioRoute != paramV2TXLivePlayerJSConfig2.audioRoute) {
      TXCAudioEngine.setAudioRoute(paramV2TXLivePlayerJSConfig2.audioRoute);
    }
    if ((paramV2TXLivePlayerJSConfig2.url != null) && (!paramV2TXLivePlayerJSConfig2.url.equals(paramV2TXLivePlayerJSConfig1.url)))
    {
      if (this.mPlayer.isPlaying() == 1)
      {
        apiOnlineLog("stop play when update url.", false);
        this.mPlayer.stopPlay();
      }
      if ((paramV2TXLivePlayerJSConfig2.isCanAutoPlay) && (paramV2TXLivePlayerJSConfig2.isAutoPlay))
      {
        apiOnlineLog("auto start play when update url.", false);
        startPlayInner(paramV2TXLivePlayerJSConfig2.url, paramV2TXLivePlayerJSConfig2.mode);
      }
    }
    if (paramV2TXLivePlayerJSConfig1.mode != paramV2TXLivePlayerJSConfig2.mode)
    {
      if (this.mPlayer.isPlaying() == 1)
      {
        apiOnlineLog("stop play when update mode.", false);
        this.mPlayer.stopPlay();
      }
      if ((paramV2TXLivePlayerJSConfig2.isCanAutoPlay) && (paramV2TXLivePlayerJSConfig2.isAutoPlay))
      {
        apiOnlineLog("auto start play when update mode.", false);
        startPlayInner(paramV2TXLivePlayerJSConfig2.url, paramV2TXLivePlayerJSConfig2.mode);
      }
    }
    if ((paramV2TXLivePlayerJSConfig1.isAutoPlay != paramV2TXLivePlayerJSConfig2.isAutoPlay) && (paramV2TXLivePlayerJSConfig2.isAutoPlay) && (paramV2TXLivePlayerJSConfig2.isCanAutoPlay) && (!TextUtils.isEmpty(paramV2TXLivePlayerJSConfig2.url)) && (this.mPlayer.isPlaying() != 1))
    {
      apiOnlineLog("start play when update auto play.", false);
      startPlayInner(paramV2TXLivePlayerJSConfig2.url, paramV2TXLivePlayerJSConfig2.mode);
    }
  }
  
  private void setFullParams(V2TXLivePlayerJSConfig paramV2TXLivePlayerJSConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set full config:");
    localStringBuilder.append(paramV2TXLivePlayerJSConfig);
    apiOnlineLog(localStringBuilder.toString(), true);
    if (paramV2TXLivePlayerJSConfig.isMuteVideo) {
      this.mPlayer.pauseVideo();
    } else {
      this.mPlayer.resumeVideo();
    }
    if (paramV2TXLivePlayerJSConfig.isMuteAudio) {
      this.mPlayer.pauseAudio();
    } else {
      this.mPlayer.resumeAudio();
    }
    this.mPlayer.setProperty("enableRecvSEIMessage", Boolean.valueOf(paramV2TXLivePlayerJSConfig.enableRecvSEIMessage));
    this.mPlayer.showDebugView(paramV2TXLivePlayerJSConfig.enableDebugView);
    this.mPlayer.setCacheParams(Math.min(paramV2TXLivePlayerJSConfig.minCache, paramV2TXLivePlayerJSConfig.maxCache), Math.max(paramV2TXLivePlayerJSConfig.minCache, paramV2TXLivePlayerJSConfig.maxCache));
    this.mPlayer.enableVolumeEvaluation(paramV2TXLivePlayerJSConfig.volumeNotifyIntervals);
    TXCAudioEngine.setAudioRoute(paramV2TXLivePlayerJSConfig.audioRoute);
    this.mPlayer.setRenderFillMode(paramV2TXLivePlayerJSConfig.fillMode);
    this.mPlayer.setRenderRotation(paramV2TXLivePlayerJSConfig.renderRotation);
    if ((this.mConfig.isCanAutoPlay) && (this.mConfig.isAutoPlay) && (!TextUtils.isEmpty(this.mConfig.url)))
    {
      if (this.mPlayer.isPlaying() == 1)
      {
        this.mPlayer.stopPlay();
        apiOnlineError("stop play when set full params.", false);
      }
      startPlayInner(this.mConfig.url, this.mConfig.mode);
    }
  }
  
  private void startPlayInner(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      apiOnlineError("start play fail. url is empty.", false);
      return;
    }
    if (paramInt == 1)
    {
      if (((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (paramString.contains(".flv"))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
    else {
      paramInt = 5;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start play.[url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("][type:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    apiOnlineLog(localStringBuilder.toString(), false);
    this.mPlayMode = b.a(paramString);
    this.mPlayer.setProperty("setPlayURLType", Integer.valueOf(paramInt));
    this.mPlayer.setProperty("setFrameWorkType", Integer.valueOf(3));
    this.mPlayer.startPlay(paramString);
  }
  
  public V2TXJSAdapterError initLivePlayer(Bundle paramBundle)
  {
    callbackSDKVersion();
    return initLivePlayerInner(null, paramBundle);
  }
  
  public V2TXJSAdapterError initLivePlayer(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    if (paramTXCloudVideoView == null) {
      return new V2TXJSAdapterError(-1, "invalid params");
    }
    return initLivePlayerInner(paramTXCloudVideoView, paramBundle);
  }
  
  public boolean isMuted()
  {
    return this.mConfig.isMuteAudio;
  }
  
  public boolean isPlaying()
  {
    return this.mPlayer.isPlaying() == 1;
  }
  
  public void onAudioPlayStatusUpdate(V2TXLivePlayer paramV2TXLivePlayer, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason, Bundle paramBundle)
  {
    paramV2TXLivePlayer = new StringBuilder();
    paramV2TXLivePlayer.append("onAudioPlayStatusUpdate: [status:");
    paramV2TXLivePlayer.append(paramV2TXLivePlayStatus);
    paramV2TXLivePlayer.append("][reason:");
    paramV2TXLivePlayer.append(paramV2TXLiveStatusChangeReason);
    paramV2TXLivePlayer.append("]");
    apiOnlineLog(paramV2TXLivePlayer.toString(), false);
    if (!isRTCProtocol())
    {
      apiOnlineLog("onAudioPlayStatusUpdate: isn't rtc protocol,ignore.", false);
      return;
    }
    paramV2TXLivePlayer = this.mPlayListener;
    if (paramV2TXLivePlayer == null) {
      return;
    }
    if (V2TXLivePlayerJSAdapter.2.$SwitchMap$com$tencent$live2$V2TXLiveDef$V2TXLivePlayStatus[paramV2TXLivePlayStatus.ordinal()] != 1) {
      return;
    }
    paramV2TXLivePlayer.onPlayEvent(2001, paramBundle);
  }
  
  public void onError(V2TXLivePlayer paramV2TXLivePlayer, int paramInt, String paramString, Bundle paramBundle)
  {
    paramV2TXLivePlayer = new StringBuilder();
    paramV2TXLivePlayer.append("onError: [code:");
    paramV2TXLivePlayer.append(paramInt);
    paramV2TXLivePlayer.append("][msg:");
    paramV2TXLivePlayer.append(paramString);
    paramV2TXLivePlayer.append("][info:");
    paramV2TXLivePlayer.append(paramBundle);
    paramV2TXLivePlayer.append("]");
    apiOnlineLog(paramV2TXLivePlayer.toString(), false);
    if (!isRTCProtocol())
    {
      apiOnlineLog("onError: isn't rtc protocol, ignore.", false);
      return;
    }
    paramV2TXLivePlayer = this.mPlayListener;
    if (paramV2TXLivePlayer == null) {
      return;
    }
    if ((paramInt != -7) && (paramInt != -6) && (paramInt != -3) && (paramInt != -1)) {
      return;
    }
    paramV2TXLivePlayer.onPlayEvent(-2301, paramBundle);
  }
  
  public void onNetworkQuality(int paramInt)
  {
    this.mTRTCNetworkQuality = paramInt;
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 2006) || (paramInt == -2301)) {
      runOnLivePlayerThread(new V2TXLivePlayerJSAdapter.1(this));
    }
    if (paramInt == 2012) {
      if ((this.mConfig.enableRecvSEIMessage) && (paramBundle != null))
      {
        Object localObject1 = paramBundle.getByteArray("EVT_GET_MSG");
        if ((localObject1 != null) && (localObject1.length > 0)) {
          try
          {
            localObject1 = new String((byte[])localObject1, "UTF-8");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        } else {
          localObject2 = "";
        }
        paramBundle.putString("EVT_MSG", (String)localObject2);
      }
      else
      {
        return;
      }
    }
    Object localObject2 = this.mPlayListener;
    if (localObject2 != null) {
      ((ITXLivePlayListener)localObject2).onPlayEvent(paramInt, paramBundle);
    }
  }
  
  public void onPlayNetStatus(Bundle paramBundle)
  {
    ITXLivePlayListener localITXLivePlayListener = this.mPlayListener;
    if (localITXLivePlayListener != null) {
      localITXLivePlayListener.onNetStatus(paramBundle);
    }
  }
  
  public void onPlayoutVolumeUpdate(V2TXLivePlayer paramV2TXLivePlayer, int paramInt)
  {
    paramV2TXLivePlayer = this.mAudioVolumeListener;
    if (paramV2TXLivePlayer != null) {
      paramV2TXLivePlayer.onAudioVolumeEvaluationNotify(paramInt);
    }
  }
  
  public void onRecvSEIMessage(String paramString)
  {
    ITXLivePlayListener localITXLivePlayListener = this.mPlayListener;
    if (localITXLivePlayListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", paramString);
      localITXLivePlayListener.onPlayEvent(2012, localBundle);
    }
  }
  
  public void onSnapshotComplete(V2TXLivePlayer paramV2TXLivePlayer, Bitmap paramBitmap)
  {
    paramV2TXLivePlayer = this.mSnapshotListener;
    if (paramV2TXLivePlayer == null) {
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
        paramV2TXLivePlayer.onSnapshot(paramBitmap);
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          paramBitmap.recycle();
        }
      }
      else
      {
        paramV2TXLivePlayer.onSnapshot(paramBitmap);
      }
    }
    else {
      paramV2TXLivePlayer.onSnapshot(paramBitmap);
    }
  }
  
  public void onStatisticsUpdate(V2TXLivePlayer paramV2TXLivePlayer, V2TXLiveDef.V2TXLivePlayerStatistics paramV2TXLivePlayerStatistics)
  {
    String str1 = String.format("%d%%|%d%%", new Object[] { Integer.valueOf(paramV2TXLivePlayerStatistics.appCpu), Integer.valueOf(paramV2TXLivePlayerStatistics.systemCpu) });
    String str2 = TXCStatus.b("18446744073709551615", 10001);
    paramV2TXLivePlayer = new Bundle();
    paramV2TXLivePlayer.putString("CPU_USAGE", str1);
    paramV2TXLivePlayer.putInt("VIDEO_WIDTH", paramV2TXLivePlayerStatistics.width);
    paramV2TXLivePlayer.putInt("VIDEO_HEIGHT", paramV2TXLivePlayerStatistics.height);
    paramV2TXLivePlayer.putInt("VIDEO_FPS", paramV2TXLivePlayerStatistics.fps);
    paramV2TXLivePlayer.putInt("NET_SPEED", paramV2TXLivePlayerStatistics.audioBitrate + paramV2TXLivePlayerStatistics.videoBitrate);
    paramV2TXLivePlayer.putInt("VIDEO_BITRATE", paramV2TXLivePlayerStatistics.videoBitrate);
    paramV2TXLivePlayer.putInt("AUDIO_BITRATE", paramV2TXLivePlayerStatistics.audioBitrate);
    paramV2TXLivePlayer.putString("SERVER_IP", str2);
    paramV2TXLivePlayer.putInt("NET_QUALITY_LEVEL", this.mTRTCNetworkQuality);
    paramV2TXLivePlayer.putInt("AUDIO_CACHE", 0);
    paramV2TXLivePlayer.putInt("VIDEO_CACHE", 0);
    paramV2TXLivePlayer.putInt("V_SUM_CACHE_SIZE", 0);
    paramV2TXLivePlayer.putInt("V_DEC_CACHE_SIZE", 0);
    paramV2TXLivePlayer.putString("AUDIO_PLAY_INFO", "");
    paramV2TXLivePlayerStatistics = this.mPlayListener;
    if (paramV2TXLivePlayerStatistics != null) {
      paramV2TXLivePlayerStatistics.onNetStatus(paramV2TXLivePlayer);
    }
  }
  
  public void onVideoPlayStatusUpdate(V2TXLivePlayer paramV2TXLivePlayer, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason, Bundle paramBundle)
  {
    paramV2TXLivePlayer = new StringBuilder();
    paramV2TXLivePlayer.append("onVideoPlayStatusUpdate: [status:");
    paramV2TXLivePlayer.append(paramV2TXLivePlayStatus);
    paramV2TXLivePlayer.append("][reason:");
    paramV2TXLivePlayer.append(paramV2TXLiveStatusChangeReason);
    paramV2TXLivePlayer.append("]");
    apiOnlineLog(paramV2TXLivePlayer.toString(), false);
    if (!isRTCProtocol())
    {
      apiOnlineLog("onVideoPlayStatusUpdate: isn't rtc protocol,ignore.", false);
      return;
    }
    paramV2TXLivePlayer = this.mPlayListener;
    if (paramV2TXLivePlayer == null) {
      return;
    }
    int i = V2TXLivePlayerJSAdapter.2.$SwitchMap$com$tencent$live2$V2TXLiveDef$V2TXLivePlayStatus[paramV2TXLivePlayStatus.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      paramV2TXLivePlayer.onPlayEvent(2007, paramBundle);
      return;
    }
    paramV2TXLivePlayer.onPlayEvent(2003, paramBundle);
    paramV2TXLivePlayer.onPlayEvent(2004, paramBundle);
  }
  
  public void onWarning(V2TXLivePlayer paramV2TXLivePlayer, int paramInt, String paramString, Bundle paramBundle)
  {
    if (!isRTCProtocol()) {
      return;
    }
    paramV2TXLivePlayer = this.mPlayListener;
    if (paramV2TXLivePlayer == null) {
      return;
    }
    if (paramInt == 2105) {
      paramV2TXLivePlayer.onPlayEvent(2105, paramBundle);
    }
  }
  
  public V2TXJSAdapterError operateLivePlayer(String paramString, JSONObject paramJSONObject)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      apiOnlineError("operate live player fail. operate name is empty.", false);
      return new V2TXJSAdapterError(-1, "invalid params");
    }
    if (!this.mIsInit)
    {
      if ((paramString.equals("start")) || (paramString.equals("stop")) || (paramString.equals("resume")) || (paramString.equals("pause")) || (paramString.equals("mute"))) {
        bool1 = true;
      }
      apiOnlineError("operate live player fail. player isn't init.", bool1);
      return new V2TXJSAdapterError(-3, "uninited livePlayer");
    }
    String str;
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("operate live player.[name:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("][param:");
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    apiOnlineLog(localStringBuilder.toString(), true);
    if ((!paramString.equalsIgnoreCase("play")) && (!paramString.equalsIgnoreCase("resume")))
    {
      if ((!paramString.equalsIgnoreCase("stop")) && (!paramString.equalsIgnoreCase("pause")))
      {
        if (paramString.equalsIgnoreCase("mute"))
        {
          paramString = this.mConfig;
          paramString.isMuteAudio ^= true;
          if (this.mConfig.isMuteAudio) {
            this.mPlayer.pauseAudio();
          } else {
            this.mPlayer.resumeAudio();
          }
        }
        else if (paramString.equalsIgnoreCase("snapshot"))
        {
          bool1 = bool2;
          if (paramJSONObject != null)
          {
            paramString = paramJSONObject.optString("quality");
            bool1 = bool2;
            if (paramString != null)
            {
              bool1 = bool2;
              if (paramString.equalsIgnoreCase("compressed")) {
                bool1 = true;
              }
            }
          }
          takePhoto(bool1, this.mSnapshotListener);
        }
        else
        {
          return new V2TXJSAdapterError(-4, "invalid operate command");
        }
      }
      else {
        this.mPlayer.stopPlay();
      }
    }
    else {
      startPlayInner(this.mConfig.url, this.mConfig.mode);
    }
    return new V2TXJSAdapterError();
  }
  
  public void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.mPlayListener = paramITXLivePlayListener;
  }
  
  public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.mSnapshotListener = paramITXSnapshotListener;
  }
  
  public V2TXJSAdapterError setSurface(Surface paramSurface)
  {
    this.mPlayer.setProperty("setSurface", paramSurface);
    return new V2TXJSAdapterError();
  }
  
  public V2TXJSAdapterError setSurfaceSize(int paramInt1, int paramInt2)
  {
    this.mPlayer.setProperty("setSurfaceSize", new a.a(paramInt1, paramInt2));
    return new V2TXJSAdapterError();
  }
  
  public void setThreadHandler(Handler paramHandler)
  {
    this.mThreadHandler = paramHandler;
  }
  
  public void takePhoto(boolean paramBoolean, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.mNeedCompressSnapshot = paramBoolean;
    this.mSnapshotListener = paramITXSnapshotListener;
    this.mPlayer.snapshot();
  }
  
  public V2TXJSAdapterError uninitLivePlayer()
  {
    if (!this.mIsInit)
    {
      apiOnlineError("un init player fail. player isn't init.", false);
      return new V2TXJSAdapterError(-3, "uninited livePlayer");
    }
    apiOnlineLog("un init player.", false);
    this.mIsInit = false;
    this.mPlayer.stopPlay();
    return new V2TXJSAdapterError();
  }
  
  public V2TXJSAdapterError updateLivePlayer(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      apiOnlineError("update player fail. invalid params.", false);
      return new V2TXJSAdapterError(-1, "invalid params.");
    }
    if (!this.mIsInit)
    {
      apiOnlineError("update player fail. player isn't init.", false);
      return new V2TXJSAdapterError(-3, "uninited livePlayer.");
    }
    V2TXLivePlayerJSConfig localV2TXLivePlayerJSConfig = new V2TXLivePlayerJSConfig(this.mConfig);
    localV2TXLivePlayerJSConfig.updateFromBundle(paramBundle);
    setDiffParams(this.mConfig, localV2TXLivePlayerJSConfig);
    this.mConfig = localV2TXLivePlayerJSConfig;
    return new V2TXJSAdapterError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.jsplugin.player.V2TXLivePlayerJSAdapter
 * JD-Core Version:    0.7.0.1
 */