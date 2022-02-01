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
    paramTVK_IMediaPlayer = new StringBuilder();
    paramTVK_IMediaPlayer.append("[WSPlayerListenerWrapper.java][onCaptureImageFailed] id:");
    paramTVK_IMediaPlayer.append(paramInt1);
    paramTVK_IMediaPlayer.append(", errCode:");
    paramTVK_IMediaPlayer.append(paramInt2);
    WSLog.e("WS_VIDEO_LISTENER", paramTVK_IMediaPlayer.toString());
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    paramTVK_IMediaPlayer = new StringBuilder();
    paramTVK_IMediaPlayer.append("[WSPlayerListenerWrapper.java][onCaptureImageSucceed] id:");
    paramTVK_IMediaPlayer.append(paramInt1);
    paramTVK_IMediaPlayer.append(", width:");
    paramTVK_IMediaPlayer.append(paramInt2);
    paramTVK_IMediaPlayer.append(", height:");
    paramTVK_IMediaPlayer.append(paramInt3);
    WSLog.e("WS_VIDEO_LISTENER", paramTVK_IMediaPlayer.toString());
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    WSLog.e("WS_VIDEO_LISTENER", "[WSPlayerListenerWrapper.java][onCompletion]");
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramTVK_IMediaPlayer = new StringBuilder();
    paramTVK_IMediaPlayer.append("[WSPlayerListenerWrapper.java][onError] model:");
    paramTVK_IMediaPlayer.append(paramInt1);
    paramTVK_IMediaPlayer.append(", what:");
    paramTVK_IMediaPlayer.append(paramInt2);
    paramTVK_IMediaPlayer.append(", position:");
    paramTVK_IMediaPlayer.append(paramInt3);
    paramTVK_IMediaPlayer.append(", detailInfo:");
    paramTVK_IMediaPlayer.append(paramString);
    WSLog.e("WS_VIDEO_LISTENER", paramTVK_IMediaPlayer.toString());
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    paramTVK_IMediaPlayer = new StringBuilder();
    paramTVK_IMediaPlayer.append("[WSPlayerListenerWrapper.java][onInfo] what:");
    paramTVK_IMediaPlayer.append(paramInt);
    paramTVK_IMediaPlayer.append(", extra:");
    paramTVK_IMediaPlayer.append(paramObject);
    WSLog.e("WS_VIDEO_LISTENER", paramTVK_IMediaPlayer.toString());
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerListenerWrapper.java][onNetVideoInfo] player:");
    localStringBuilder.append(paramTVK_IMediaPlayer);
    localStringBuilder.append(", videoInfo:");
    localStringBuilder.append(paramTVK_NetVideoInfo);
    WSLog.e("WS_VIDEO_LISTENER", localStringBuilder.toString());
  }
  
  public void onPreAdPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong) {}
  
  public void onPreAdPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerListenerWrapper.java][onSeekComplete] mediaPlayer:");
    localStringBuilder.append(paramTVK_IMediaPlayer);
    WSLog.e("WS_VIDEO_LISTENER", localStringBuilder.toString());
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerListenerWrapper.java][onVideoPrepared] mediaPlayer:");
    localStringBuilder.append(paramTVK_IMediaPlayer);
    WSLog.e("WS_VIDEO_LISTENER", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerListenerWrapper
 * JD-Core Version:    0.7.0.1
 */