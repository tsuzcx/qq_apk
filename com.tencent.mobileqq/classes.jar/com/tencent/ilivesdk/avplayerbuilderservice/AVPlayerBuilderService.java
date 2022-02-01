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
    else
    {
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
    this.openSdkPlayerService.setParams(paramPlayerParams);
    return this.openSdkPlayerService;
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
    else
    {
      this.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "use old tp player", new Object[0]);
    }
    return this.thumbPlayerService;
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
    if (TextUtils.isEmpty(paramPlayerParams.url))
    {
      this.mPlayerAdapter.getLogger().e("AVPlayerBuilderService", "play url is null.", new Object[0]);
      return null;
    }
    Object localObject = getPlayType(paramPlayerParams.url);
    if (AVPlayerType.OPEN_SDK_PLAYER == localObject) {
      return createOpenSdkPlayer(paramPlayerParams);
    }
    if (AVPlayerType.THUMB_PLAYER == localObject) {
      return createTPPlayer(paramPlayerParams);
    }
    if (AVPlayerType.UNKNOWN_PLAYER == localObject)
    {
      localObject = this.mPlayerAdapter.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown format url:");
      localStringBuilder.append(paramPlayerParams.url);
      ((LogInterface)localObject).e("AVPlayerBuilderService", localStringBuilder.toString(), new Object[0]);
    }
    return null;
  }
  
  public void clearEventOutput()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.clearEventOutput();
    }
  }
  
  public long getCurrentPositionMs()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      return localAVPlayerServiceInterface.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public Rect getDisplayViewRect()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      return localAVPlayerServiceInterface.getDisplayViewRect();
    }
    return new Rect();
  }
  
  public String[] getSupportFormat()
  {
    return new String[] { AVPlayerBuilderServiceInterface.VideoFormat.FLV.value, AVPlayerBuilderServiceInterface.VideoFormat.RTMP.value, AVPlayerBuilderServiceInterface.VideoFormat.OPENSDK.value };
  }
  
  public long getVideoDurationMs()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      return localAVPlayerServiceInterface.getVideoDurationMs();
    }
    return 0L;
  }
  
  public int getVideoHeight()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      return localAVPlayerServiceInterface.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      return localAVPlayerServiceInterface.getVideoWidth();
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
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      return localAVPlayerServiceInterface.isPaused();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      return localAVPlayerServiceInterface.isPlaying();
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
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      return localAVPlayerServiceInterface.isUseLocalServerPreload();
    }
    return false;
  }
  
  public void mutePlay(boolean paramBoolean)
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.mutePlay(paramBoolean);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.onCreate(paramContext);
    }
  }
  
  public void onDestroy()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.onDestroy();
    }
  }
  
  public void onLoginEvent(int paramInt, String paramString)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          sIsOpenSdkInit = false;
          return;
        }
        sIsOpenSdkInit = true;
        return;
      }
      this.isLogin = false;
      return;
    }
    this.isLogin = true;
    if (this.isWaitingLogin)
    {
      this.isWaitingLogin = false;
      this.mPlayerAdapter.getAVMediaService().avInit(this.openSdkInitCallBack);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onScreenOrientationChange(boolean paramBoolean)
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.onScreenOrientationChange(paramBoolean);
    }
  }
  
  public void pausePlay()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.pausePlay();
    }
  }
  
  public void preload()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.preload();
    }
  }
  
  public void preparePlay()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.preparePlay();
    }
  }
  
  public void readyPlay(@NonNull FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    this.currentPlayerService.readyPlay(paramFrameLayout, paramBoolean);
  }
  
  public void reportPreloadData(boolean paramBoolean)
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.reportPreloadData(paramBoolean);
    }
  }
  
  public void resetPlayer()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.resetPlayer();
    }
  }
  
  public void resumePlay()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.resumePlay();
    }
  }
  
  public void seekTo(int paramInt)
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.seekTo(paramInt);
    }
  }
  
  public void setBuilderAdapter(AVPlayerServiceBuilderAdapter paramAVPlayerServiceBuilderAdapter)
  {
    this.mBuilderAdapter = paramAVPlayerServiceBuilderAdapter;
  }
  
  public void setParams(PlayerParams paramPlayerParams)
  {
    this.currentPlayerService = lazyCreatePlayer(paramPlayerParams);
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface == null)
    {
      this.mPlayerAdapter.getLogger().e("AVPlayerBuilderService", "lazyCreatePlayer failed!", new Object[0]);
      return;
    }
    localAVPlayerServiceInterface.setParams(paramPlayerParams);
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
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.setPlayerStatusListener(paramPlayerStatusListener);
    }
  }
  
  public void setPlayerSurface()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.setPlayerSurface();
    }
  }
  
  public void startPlay()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.startPlay();
    }
  }
  
  public void stopPlay()
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.stopPlay();
    }
  }
  
  public void switchResolution(PlayerParams paramPlayerParams, PlayerStatusListener paramPlayerStatusListener)
  {
    AVPlayerServiceInterface localAVPlayerServiceInterface = this.currentPlayerService;
    if (localAVPlayerServiceInterface != null) {
      localAVPlayerServiceInterface.switchResolution(paramPlayerParams, paramPlayerStatusListener);
    }
  }
  
  public void uninit()
  {
    if (this.isInit)
    {
      AVPlayerServiceInterface localAVPlayerServiceInterface = this.openSdkPlayerService;
      if (localAVPlayerServiceInterface != null)
      {
        localAVPlayerServiceInterface.stopPlay();
        this.openSdkPlayerService.uninit();
        this.openSdkPlayerService.onDestroy();
      }
      localAVPlayerServiceInterface = this.thumbPlayerService;
      if (localAVPlayerServiceInterface != null)
      {
        localAVPlayerServiceInterface.uninit();
        this.thumbPlayerService.onDestroy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerbuilderservice.AVPlayerBuilderService
 * JD-Core Version:    0.7.0.1
 */