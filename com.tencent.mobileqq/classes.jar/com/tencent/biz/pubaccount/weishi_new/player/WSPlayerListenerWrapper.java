package com.tencent.biz.pubaccount.weishi_new.player;

import android.graphics.Bitmap;
import android.view.SurfaceHolder;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnPreAdListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;

public class WSPlayerListenerWrapper
  implements TVK_IMediaPlayer.OnCaptureImageListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnPreAdListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, IVideoViewBase.IVideoViewCallBack
{
  public void OnDownloadCallback(String paramString) {}
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    WSLog.e("WS_VIDEO_LISTENER", "[WSPlayerListenerWrapper.java][onCaptureImageFailed] id:" + paramInt1 + ", errCode:" + paramInt2);
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    WSLog.e("WS_VIDEO_LISTENER", "[WSPlayerListenerWrapper.java][onCaptureImageSucceed] id:" + paramInt1 + ", width:" + paramInt2 + ", height:" + paramInt3);
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    WSLog.e("WS_VIDEO_LISTENER", "[WSPlayerListenerWrapper.java][onCompletion]");
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    WSLog.e("WS_VIDEO_LISTENER", "[WSPlayerListenerWrapper.java][onError] model:" + paramInt1 + ", what:" + paramInt2 + ", position:" + paramInt3 + ", detailInfo:" + paramString);
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    WSLog.e("WS_VIDEO_LISTENER", "[WSPlayerListenerWrapper.java][onInfo] what:" + paramInt + ", extra:" + paramObject);
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    WSLog.e("WS_VIDEO_LISTENER", "[WSPlayerListenerWrapper.java][onNetVideoInfo] player:" + paramTVK_IMediaPlayer + ", videoInfo:" + paramTVK_NetVideoInfo);
  }
  
  public void onPreAdPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong) {}
  
  public void onPreAdPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    WSLog.e("WS_VIDEO_LISTENER", "[WSPlayerListenerWrapper.java][onSeekComplete] mediaPlayer:" + paramTVK_IMediaPlayer);
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    WSLog.e("WS_VIDEO_LISTENER", "[WSPlayerListenerWrapper.java][onVideoPrepared] mediaPlayer:" + paramTVK_IMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerListenerWrapper
 * JD-Core Version:    0.7.0.1
 */