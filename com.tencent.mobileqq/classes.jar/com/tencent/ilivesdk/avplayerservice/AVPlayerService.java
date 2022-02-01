package com.tencent.ilivesdk.avplayerservice;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.av.report.AVReportManager;
import com.tencent.ilivesdk.avplayerservice.network.AVPlayerNetworkReceiver;
import com.tencent.ilivesdk.avplayerservice.push.AVPlayerPushMgr;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceInterface;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;

public abstract class AVPlayerService
  implements AVPlayerServiceInterface
{
  public static final int PLAYER_ERROR_CODE_NETWORK = 200;
  public static final int PLAYER_ERROR_CODE_NONE = 100;
  public static final int PLAYER_ERROR_CODE_OTHER = 400;
  public static final int PLAYER_ERROR_CODE_PARSER = 300;
  protected AVPlayerServiceAdapter adapter;
  protected Context appContext;
  protected AVPlayerNetworkReceiver avPlayerNetworkReceiver;
  protected AVPlayerPushMgr avPlayerPushMgr;
  protected AVPlayerPreloadAdapter mPreloadAdapter;
  protected PlayerStatusListener mStatusListener;
  
  public void init(Context paramContext, FrameLayout paramFrameLayout)
  {
    this.avPlayerPushMgr = new AVPlayerPushMgr(this.adapter);
    this.avPlayerPushMgr.init();
    this.appContext = paramContext.getApplicationContext();
    AVReportManager.init(paramContext.getApplicationContext(), new SimpleHttpInterfaceTransfer(this.adapter.getHttp()));
  }
  
  public boolean isUseLocalServerPreload()
  {
    return false;
  }
  
  public void mutePlay(boolean paramBoolean) {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void preload() {}
  
  public void reportPreloadData(boolean paramBoolean) {}
  
  public void setPlayerAdapter(AVPlayerServiceAdapter paramAVPlayerServiceAdapter)
  {
    this.adapter = paramAVPlayerServiceAdapter;
  }
  
  public void setPlayerPreloadAdapter(AVPlayerPreloadAdapter paramAVPlayerPreloadAdapter)
  {
    this.mPreloadAdapter = paramAVPlayerPreloadAdapter;
  }
  
  public void setPlayerStatusListener(PlayerStatusListener paramPlayerStatusListener)
  {
    this.mStatusListener = paramPlayerStatusListener;
    this.avPlayerPushMgr.addPlayerStatusListener(paramPlayerStatusListener);
  }
  
  public void uninit()
  {
    this.avPlayerPushMgr.unInit();
    this.appContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.AVPlayerService
 * JD-Core Version:    0.7.0.1
 */