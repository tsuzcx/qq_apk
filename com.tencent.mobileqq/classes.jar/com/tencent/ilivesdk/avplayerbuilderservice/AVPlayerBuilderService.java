package com.tencent.ilivesdk.avplayerbuilderservice;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.avmediaservice_interface.AVMediaServiceInterface;
import com.tencent.ilivesdk.avmediaservice_interface.AvInitCallBack;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface.VideoFormat;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerServiceBuilderAdapter;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerType;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceInterface;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerParams;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.ilivesdk.opensdkplayerservice.OpenSdkPlayerService;

public class AVPlayerBuilderService
  implements AVPlayerBuilderServiceInterface
{
  private static final String TAG = "AVPlayerBuilderService";
  private static boolean sIsOpenSdkInit = false;
  Context context;
  AVPlayerServiceInterface currentPlayerService;
  private boolean isInit = false;
  private boolean isLogin = false;
  private boolean isWaitingLogin = false;
  AVPlayerServiceBuilderAdapter mBuilderAdapter;
  private FrameLayout mContainer;
  AVPlayerServiceAdapter mPlayerAdapter;
  AVPlayerPreloadAdapter mPlayerPreloadAdapter;
  private AvInitCallBack openSdkInitCallBack = new AVPlayerBuilderService.1(this);
  AVPlayerServiceInterface openSdkPlayerService;
  AVPlayerServiceInterface thumbPlayerService;
  
  private AVPlayerServiceInterface createOpenSdkPlayer(PlayerParams paramPlayerParams)
  {
    this.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "create open sdk player", new Object[0]);
    if (this.openSdkPlayerService != null)
    {
      this.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "use old open sdk player", new Object[0]);
      return this.openSdkPlayerService;
    }
    this.openSdkPlayerService = new OpenSdkPlayerService();
    this.openSdkPlayerService.setPlayerAdapter(this.mPlayerAdapter);
    this.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "new open sdk player", new Object[0]);
    if (sIsOpenSdkInit)
    {
      this.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "open sdk has init!", new Object[0]);
      this.openSdkPlayerService.init(this.context, this.mContainer);
    }
    for (;;)
    {
      this.openSdkPlayerService.setParams(paramPlayerParams);
      return this.openSdkPlayerService;
      this.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "open sdk has not init!", new Object[0]);
      if (this.isLogin)
      {
        this.mPlayerAdapter.getAVMediaService().avInit(this.openSdkInitCallBack);
      }
      else
      {
        this.isWaitingLogin = true;
        this.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "open sdk has not init, waiting login", new Object[0]);
      }
    }
  }
  
  private AVPlayerServiceInterface createTPPlayer(PlayerParams paramPlayerParams)
  {
    this.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "create tp player", new Object[0]);
    if ((this.thumbPlayerService == null) && (this.context != null))
    {
      this.thumbPlayerService = this.mBuilderAdapter.getNormalPlayer();
      this.thumbPlayerService.setPlayerAdapter(this.mPlayerAdapter);
      this.thumbPlayerService.setPlayerPreloadAdapter(this.mPlayerPreloadAdapter);
      this.thumbPlayerService.init(this.context, this.mContainer);
      this.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "new tp player", new Object[0]);
    }
    for (;;)
    {
      return this.thumbPlayerService;
      this.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "use old tp player", new Object[0]);
    }
  }
  
  private AVPlayerType getPlayType(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getScheme();
      if (TextUtils.isEmpty(paramString)) {
        return AVPlayerType.UNKNOWN_PLAYER;
      }
      if ("opensdk".equalsIgnoreCase(paramString)) {
        return AVPlayerType.OPEN_SDK_PLAYER;
      }
      paramString = AVPlayerType.THUMB_PLAYER;
      return paramString;
    }
    catch (Exception paramString)
    {
      this.mPlayerAdapter.getLogger().printException(paramString);
    }
    return AVPlayerType.UNKNOWN_PLAYER;
  }
  
  private AVPlayerServiceInterface lazyCreatePlayer(PlayerParams paramPlayerParams)
  {
    if (TextUtils.isEmpty(paramPlayerParams.url)) {
      this.mPlayerAdapter.getLogger().e("AVPlayerBuilderService", "play url is null.", new Object[0]);
    }
    AVPlayerType localAVPlayerType;
    do
    {
      return null;
      localAVPlayerType = getPlayType(paramPlayerParams.url);
      if (AVPlayerType.OPEN_SDK_PLAYER == localAVPlayerType) {
        return createOpenSdkPlayer(paramPlayerParams);
      }
      if (AVPlayerType.THUMB_PLAYER == localAVPlayerType) {
        return createTPPlayer(paramPlayerParams);
      }
    } while (AVPlayerType.UNKNOWN_PLAYER != localAVPlayerType);
    this.mPlayerAdapter.getLogger().e("AVPlayerBuilderService", "unknown format url:" + paramPlayerParams.url, new Object[0]);
    return null;
  }
  
  public void clearEventOutput()
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.clearEventOutput();
    }
  }
  
  public long getCurrentPositionMs()
  {
    if (this.currentPlayerService != null) {
      return this.currentPlayerService.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public Rect getDisplayViewRect()
  {
    if (this.currentPlayerService != null) {
      return this.currentPlayerService.getDisplayViewRect();
    }
    return new Rect();
  }
  
  public String[] getSupportFormat()
  {
    return new String[] { AVPlayerBuilderServiceInterface.VideoFormat.FLV.value, AVPlayerBuilderServiceInterface.VideoFormat.RTMP.value, AVPlayerBuilderServiceInterface.VideoFormat.OPENSDK.value };
  }
  
  public long getVideoDurationMs()
  {
    if (this.currentPlayerService != null) {
      return this.currentPlayerService.getVideoDurationMs();
    }
    return 0L;
  }
  
  public int getVideoHeight()
  {
    if (this.currentPlayerService != null) {
      return this.currentPlayerService.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    if (this.currentPlayerService != null) {
      return this.currentPlayerService.getVideoWidth();
    }
    return 0;
  }
  
  public void init(Context paramContext, FrameLayout paramFrameLayout)
  {
    this.context = paramContext;
    this.mContainer = paramFrameLayout;
    this.isInit = true;
  }
  
  public boolean isPaused()
  {
    if (this.currentPlayerService != null) {
      return this.currentPlayerService.isPaused();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    if (this.currentPlayerService != null) {
      return this.currentPlayerService.isPlaying();
    }
    return false;
  }
  
  public boolean isSupportFormat(AVPlayerBuilderServiceInterface.VideoFormat paramVideoFormat)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = AVPlayerBuilderServiceInterface.VideoFormat.FLV.value;
    arrayOfString[1] = AVPlayerBuilderServiceInterface.VideoFormat.RTMP.value;
    arrayOfString[2] = AVPlayerBuilderServiceInterface.VideoFormat.OPENSDK.value;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(paramVideoFormat.value)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isUseLocalServerPreload()
  {
    if (this.currentPlayerService != null) {
      return this.currentPlayerService.isUseLocalServerPreload();
    }
    return false;
  }
  
  public void mutePlay(boolean paramBoolean)
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.mutePlay(paramBoolean);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.onCreate(paramContext);
    }
  }
  
  public void onDestroy()
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.onDestroy();
    }
  }
  
  public void onLoginEvent(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
    case 1: 
      do
      {
        return;
        this.isLogin = true;
      } while (!this.isWaitingLogin);
      this.isWaitingLogin = false;
      this.mPlayerAdapter.getAVMediaService().avInit(this.openSdkInitCallBack);
      return;
    case 2: 
      this.isLogin = false;
      return;
    case 3: 
      sIsOpenSdkInit = true;
      return;
    }
    sIsOpenSdkInit = false;
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onScreenOrientationChange(boolean paramBoolean)
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.onScreenOrientationChange(paramBoolean);
    }
  }
  
  public void pausePlay()
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.pausePlay();
    }
  }
  
  public void preload()
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.preload();
    }
  }
  
  public void preparePlay()
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.preparePlay();
    }
  }
  
  public void readyPlay(@NonNull FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    this.currentPlayerService.readyPlay(paramFrameLayout, paramBoolean);
  }
  
  public void reportPreloadData(boolean paramBoolean)
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.reportPreloadData(paramBoolean);
    }
  }
  
  public void resetPlayer()
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.resetPlayer();
    }
  }
  
  public void resumePlay()
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.resumePlay();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.seekTo(paramInt);
    }
  }
  
  public void setBuilderAdapter(AVPlayerServiceBuilderAdapter paramAVPlayerServiceBuilderAdapter)
  {
    this.mBuilderAdapter = paramAVPlayerServiceBuilderAdapter;
  }
  
  public void setParams(PlayerParams paramPlayerParams)
  {
    this.currentPlayerService = lazyCreatePlayer(paramPlayerParams);
    if (this.currentPlayerService == null)
    {
      this.mPlayerAdapter.getLogger().e("AVPlayerBuilderService", "lazyCreatePlayer failed!", new Object[0]);
      return;
    }
    this.currentPlayerService.setParams(paramPlayerParams);
  }
  
  public void setPlayerAdapter(AVPlayerServiceAdapter paramAVPlayerServiceAdapter)
  {
    this.mPlayerAdapter = paramAVPlayerServiceAdapter;
  }
  
  public void setPlayerPreloadAdapter(AVPlayerPreloadAdapter paramAVPlayerPreloadAdapter)
  {
    this.mPlayerPreloadAdapter = paramAVPlayerPreloadAdapter;
  }
  
  public void setPlayerStatusListener(PlayerStatusListener paramPlayerStatusListener)
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.setPlayerStatusListener(paramPlayerStatusListener);
    }
  }
  
  public void setPlayerSurface()
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.setPlayerSurface();
    }
  }
  
  public void startPlay()
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.startPlay();
    }
  }
  
  public void stopPlay()
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.stopPlay();
    }
  }
  
  public void switchResolution(PlayerParams paramPlayerParams, PlayerStatusListener paramPlayerStatusListener)
  {
    if (this.currentPlayerService != null) {
      this.currentPlayerService.switchResolution(paramPlayerParams, paramPlayerStatusListener);
    }
  }
  
  public void uninit()
  {
    if (this.isInit)
    {
      if (this.openSdkPlayerService != null)
      {
        this.openSdkPlayerService.stopPlay();
        this.openSdkPlayerService.uninit();
      }
      if (this.thumbPlayerService != null) {
        this.thumbPlayerService.uninit();
      }
      this.context = null;
      this.currentPlayerService = null;
      this.openSdkPlayerService = null;
      this.thumbPlayerService = null;
      this.isLogin = false;
      this.isWaitingLogin = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerbuilderservice.AVPlayerBuilderService
 * JD-Core Version:    0.7.0.1
 */